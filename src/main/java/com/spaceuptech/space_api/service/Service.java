package com.spaceuptech.space_api.service;

import com.spaceuptech.space_api.proto.FunctionsPayload;
import com.spaceuptech.space_api.utils.Config;
import com.spaceuptech.space_api.utils.Constants;
import com.spaceuptech.space_api.utils.Data;

import static com.spaceuptech.space_api.utils.Utils.objectToByteString;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class Service {
    private Config config;
    private String serviceName;
    private final String uuid;
    private final String STATE_READY = "READY";
    private final String RETRY = "Retry connecting...";
    private Map<String, ServiceFunction> methods = new HashMap<>();

    private final Throwable[] throwables = new Throwable[1];
    private AtomicReference<StreamObserver<FunctionsPayload>> sendStreamRef = new AtomicReference<>();
    private CountDownLatch finishedLatch;
    private StreamObserver<FunctionsPayload> receiveStream = new StreamObserver<FunctionsPayload>() {
        @Override
        public void onNext(FunctionsPayload payload) {
            if (payload.getType().equals(Constants.TYPE_SERVICE_REGISTER)) {
                if (payload.getId().equals(uuid)) {
                    JsonObject params = new JsonParser().parse(payload.getParams().toStringUtf8()).getAsJsonObject();
                    if (params.get("ack").getAsBoolean()) {
                        System.out.println("Service Registered");
                    } else {
                        throwables[0] = new Throwable("Unable to register service");
                        finishedLatch.countDown();
                    }
                }
            } else if (payload.getType().equals(Constants.TYPE_SERVICE_REQUEST)) {
                if (methods.containsKey(payload.getFunction())) {
                    try {
                        methods.get(payload.getFunction()).onInvocation(new Data(payload.getParams()), new Data(payload.getAuth()), (type, answer) -> {
                            if (type.equals("response")) {
                                sendStreamRef.get().onNext(FunctionsPayload.newBuilder()
                                        .setId(payload.getId())
                                        .setType(Constants.TYPE_SERVICE_REQUEST)
                                        .setService(serviceName)
                                        .setParams(objectToByteString(answer))
                                        .build());
                            } else {
                                throwables[0] = new Throwable("type must be 'response'");
                                finishedLatch.countDown();
                            }
                        });
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        sendStreamRef.get().onNext(FunctionsPayload.newBuilder()
                                .setId(payload.getId())
                                .setType(Constants.TYPE_SERVICE_REQUEST)
                                .setService(serviceName)
                                .setError(e.getMessage())
                                .build());
                    }
                } else {
                    sendStreamRef.get().onNext(FunctionsPayload.newBuilder()
                            .setId(payload.getId())
                            .setType(Constants.TYPE_SERVICE_REQUEST)
                            .setService(serviceName)
                            .setError("Function not Registered")
                            .build());
                }
            }
        }

        @Override
        public void onError(Throwable t) {
            throwables[0] = new Throwable(RETRY);
            finishedLatch.countDown();
        }

        @Override
        public void onCompleted() {
            finishedLatch.countDown();
        }
    };

    public Service(Config config, String serviceName) {
        this.config = config;
        this.serviceName = serviceName;
        this.uuid = UUID.randomUUID().toString();
    }

    public void registerFunc(String functionName, ServiceFunction serviceFunction) {
        methods.put(functionName, serviceFunction);
    }

    public void start() throws Throwable {
        CountDownLatch closeLatch = new CountDownLatch(1);
        new Runnable() {
            @Override
            public void run() {
                ManagedChannel channel = (ManagedChannel) config.stub.getChannel();
                ConnectivityState currentState = channel.getState(true);
                if (currentState.toString().equals(STATE_READY)) {
                    finishedLatch = new CountDownLatch(1);
                    StreamObserver<FunctionsPayload> sendStream = config.stub.service(receiveStream);
                    sendStreamRef.set(sendStream);
                    FunctionsPayload.Builder builder = FunctionsPayload.newBuilder()
                            .setService(serviceName)
                            .setType(Constants.TYPE_SERVICE_REGISTER)
                            .setId(uuid)
                            .setProject(config.projectId);
                    if (config.token != null) builder.setToken(config.token);
                    sendStream.onNext(builder.build());
                    try {
                        finishedLatch.await();
                        sendStream.onCompleted();
                        if (throwables[0] != null) {
                            if (throwables[0].getMessage().equals(RETRY)) {
                                channel.notifyWhenStateChanged(currentState, this);
                            } else {
                                closeLatch.countDown();
                            }
                        } else {
                            closeLatch.countDown();
                        }
                    } catch (InterruptedException e) {
                        throwables[0] = new Throwable(e);
                        closeLatch.countDown();
                    }
                } else {
                    channel.notifyWhenStateChanged(currentState, this);
                }
            }
        }.run();
        closeLatch.await();
        if (throwables[0] != null) {
            throw throwables[0];
        }
    }
}