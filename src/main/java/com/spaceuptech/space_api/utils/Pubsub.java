package com.spaceuptech.space_api.utils;

import com.google.gson.Gson;
import com.google.protobuf.ByteString;
import com.spaceuptech.space_api.proto.*;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class Pubsub {
    private static final String STATE_READY = "READY";
    private static final String RETRY = "Retry connecting..."; // Unique string for internal use as a flag
    private static final String UNSUBSCRIBE = "SpaceCloud Unsubscribe..."; // Unique string for internal use as a flag

    private Config config;
    private String uuid;
    private final String[] msgs;
    private AtomicReference<StreamObserver<PubsubSubscribeRequest>> sendStreamRef;
    private CountDownLatch finishedLatch;
    private PubsubListener pubsubListener;

    private StreamObserver<PubsubMsgResponse> receiveStream = new StreamObserver<PubsubMsgResponse>() {
        @Override
        public void onNext(PubsubMsgResponse response) {
            if (response.getId().equals(uuid)) {
                if (response.getType().equals(Constants.TYPE_PUBSUB_SUBSCRIBE_FEED)) {
                    HashMap msg = (new Data(response.getMsg())).getValue(HashMap.class);
                    Gson gson = new Gson();
                    Data data = new Data(ByteString.copyFromUtf8(gson.toJson(msg.get("data"))));
                    pubsubListener.onReceive((String) msg.get("subject"), data);
                } else if (response.getStatus() != 200) {
                    pubsubListener.onError("Pubsub Error: OperationType=" + response.getType() + " Status=" + response.getStatus() + " " + response.getError());
                    msgs[0] = response.getError();
                    finishedLatch.countDown();
                }
            }
        }

        @Override
        public void onError(Throwable t) {
            msgs[0] = RETRY;
            finishedLatch.countDown();
        }

        @Override
        public void onCompleted() {
            finishedLatch.countDown();
        }
    };

    public Pubsub(Config config) {
        this.config = config;
        this.uuid = UUID.randomUUID().toString();
        this.msgs = new String[1];
        this.sendStreamRef = new AtomicReference<>();
    }

    private void unsubscribe() {
        msgs[0] = UNSUBSCRIBE;
        finishedLatch.countDown();
    }

    public PubsubSubscription subscribe(String subject, PubsubListener listener) {
        return queueSubscribe(subject, "", listener);
    }

    public PubsubSubscription queueSubscribe(String subject, String queue, PubsubListener listener) {
        pubsubListener = listener;
        new Runnable() {
            @Override
            public void run() {
                ManagedChannel channel = (ManagedChannel) config.stub.getChannel();
                ConnectivityState currentState = channel.getState(true);
                if (currentState.toString().equals(STATE_READY)) {
                    finishedLatch = new CountDownLatch(1);
                    StreamObserver<PubsubSubscribeRequest> sendStream = config.stub.pubsubSubscribe(receiveStream);
                    sendStreamRef.set(sendStream);
                    PubsubSubscribeRequest.Builder builder = PubsubSubscribeRequest.newBuilder()
                            .setSubject(subject)
                            .setQueue(queue)
                            .setType(Constants.TYPE_PUBSUB_SUBSCRIBE)
                            .setProject(config.projectId)
                            .setId(uuid);
                    if (config.token != null) builder.setToken(config.token);
                    sendStream.onNext(builder.build());
                    try {
                        finishedLatch.await();
                        if (msgs[0] != null) {
                            if (msgs[0].equals(RETRY)) {
                                channel.notifyWhenStateChanged(currentState, this);
                            } else {
                                if (!msgs[0].equals(UNSUBSCRIBE)) {
                                    pubsubListener.onError(msgs[0]);
                                }
                                PubsubSubscribeRequest.Builder builder1 = PubsubSubscribeRequest.newBuilder()
                                        .setSubject(subject)
                                        .setType(Constants.TYPE_PUBSUB_UNSUBSCRIBE)
                                        .setProject(config.projectId)
                                        .setId(uuid);
                                if (config.token != null) builder1.setToken(config.token);
                                sendStream.onNext(builder.build());
                            }
                        } else {
                            // onCompleted of receive stream called
                        }
                        sendStream.onCompleted();
                    } catch (InterruptedException e) {
                        pubsubListener.onError(e.getMessage());
                    }
                } else {
                    channel.notifyWhenStateChanged(currentState, this);
                }
            }
        }.run();
        return new PubsubSubscription(subject, this::unsubscribe);
    }

    public void publish(String subject, Object msg, Utils.ResponseListener listener) {
        Meta.Builder metaBuilder = Meta.newBuilder()
                .setProject(config.projectId);
        if (config.token != null)
            metaBuilder.setToken(config.token);
        Meta meta = metaBuilder.build();
        Transport.pubsubPublish(config.stub, subject, msg, meta, listener);
    }
}
