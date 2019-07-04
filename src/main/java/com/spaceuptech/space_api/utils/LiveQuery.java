package com.spaceuptech.space_api.utils;

import com.google.gson.Gson;
import com.google.protobuf.ByteString;
import com.spaceuptech.space_api.proto.*;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class LiveQuery {
    private static final String STATE_READY = "READY";
    private static final String RETRY = "Retry connecting..."; // Unique string for internal use as a flag
    private static final String UNSUBSCRIBE = "SpaceCloud Unsubscribe..."; // Unique string for internal use as a flag

    private Config config;
    private String col, dbType, uuid;
    private HashMap<String, Object> find;
    private Gson gson;
    private LiveQueryOptions options = LiveQueryOptions.Builder().setChangesOnly(false);
    private final String[] msgs = new String[1];
    private AtomicReference<StreamObserver<RealTimeRequest>> sendStreamRef;
    private CountDownLatch finishedLatch;
    private ArrayList<Storage> store;
    private LiveDataListener liveDataListener;
    private StreamObserver<RealTimeResponse> receiveStream = new StreamObserver<RealTimeResponse>() {
        @Override
        public void onNext(RealTimeResponse response) {
            if (response.getId().equals(uuid)) {
                if (response.getAck()) {
                    LiveQuery.this.snapshotCallback(response.getFeedDataList());
                } else {
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

    public LiveQuery(Config config, String col, String dbType) {
        this.config = config;
        this.col = col;
        this.dbType = dbType;
        this.uuid = UUID.randomUUID().toString();
        this.find = new HashMap<>();
        this.gson = new Gson();
        this.store = new ArrayList<>();  // relating to the collection col
        this.sendStreamRef = new AtomicReference<>();
    }

    public LiveQuery where(Condition... conds) {
        if (conds.length == 1) this.find = Condition.generateFind(conds[0]);
        else this.find = Condition.generateFind(And.create(conds));
        return this;
    }

    private void unsubscribe() {
        msgs[0] = UNSUBSCRIBE;
        finishedLatch.countDown();
    }

    public LiveQuery options(LiveQueryOptions options) {
        this.options = options;
        return this;
    }

    public LiveQueryUnsubscribe subscribe(LiveDataListener listener) {
        liveDataListener = listener;
        new Runnable() {
            @Override
            public void run() {
                ManagedChannel channel = (ManagedChannel) config.stub.getChannel();
                ConnectivityState currentState = channel.getState(true);
                if (currentState.toString().equals(STATE_READY)) {
                    finishedLatch = new CountDownLatch(1);
                    StreamObserver<RealTimeRequest> sendStream = config.stub.realTime(receiveStream);
                    sendStreamRef.set(sendStream);
                    HashMap<String, Object> opts = new HashMap<>();
                    opts.put("skipInitial", options.getSkipInitial());
                    RealTimeRequest.Builder builder = RealTimeRequest.newBuilder()
                            .setDbType(dbType)
                            .setProject(config.projectId)
                            .setGroup(col)
                            .setId(uuid)
                            .setType(Constants.TYPE_REALTIME_SUBSCRIBE)
                            .setOptions(ByteString.copyFrom(gson.toJson(opts).getBytes()))
                            .setWhere(ByteString.copyFrom(gson.toJson(find).getBytes()));
                    if (config.token != null) builder.setToken(config.token);
                    sendStream.onNext(builder.build());
                    try {
                        finishedLatch.await();
                        if (msgs[0] != null) {
                            if (msgs[0].equals(RETRY)) {
                                channel.notifyWhenStateChanged(currentState, this);
                            } else {
                                if (!msgs[0].equals(UNSUBSCRIBE)) {
                                    liveDataListener.onError(msgs[0]);
                                }
                                RealTimeRequest.Builder builder1 = RealTimeRequest.newBuilder()
                                        .setDbType(dbType)
                                        .setProject(config.projectId)
                                        .setGroup(col)
                                        .setType(Constants.TYPE_REALTIME_UNSUBSCRIBE)
                                        .setId(uuid)
                                        .setOptions(ByteString.copyFrom(gson.toJson(opts).getBytes()))
                                        .setWhere(ByteString.copyFrom(gson.toJson(find).getBytes()));
                                if (config.token != null) builder1.setToken(config.token);
                                sendStream.onNext(builder.build());
                            }
                        } else {
                            // onCompleted of receive stream called
                        }
                        sendStream.onCompleted();
                    } catch (InterruptedException e) {
                        liveDataListener.onError(e.getMessage());
                    }
                } else {
                    channel.notifyWhenStateChanged(currentState, this);
                }
            }
        }.run();
        return LiveQuery.this::unsubscribe;
    }

    private void snapshotCallback(List<FeedData> feedDataList) {
        if (!feedDataList.isEmpty()) {
            if (options.getChangesOnly()) {
                for (FeedData feedData : feedDataList) {
                    if (!feedData.getType().equals(Constants.TYPE_DELETE)) {
                        this.liveDataListener.onSnapshot(new LiveData(new Storage(feedData.getDocId(), feedData.getTimeStamp(), feedData.getPayload(), false)), feedData.getType());
                    } else {
                        if (dbType.equals(Constants.MONGO)) {
                            String str = "{\"_id\":"+feedData.getDocId()+"}";
                            ByteString b = ByteString.copyFrom(str.getBytes(StandardCharsets.UTF_8));
                            this.liveDataListener.onSnapshot(new LiveData(new Storage(feedData.getDocId(), feedData.getTimeStamp(), b, false)), feedData.getType());
                        } else {
                            String str = "{\"id\": " + Integer.parseInt(feedData.getDocId()) + "}";
                            ByteString b = ByteString.copyFrom(str.getBytes(StandardCharsets.UTF_8));
                            this.liveDataListener.onSnapshot(new LiveData(new Storage(feedData.getDocId(), feedData.getTimeStamp(), b, false)), feedData.getType());
                        }
                    }
                }
            } else {
                for (FeedData feedData : feedDataList) {
                    updateStore:
                    switch (feedData.getType()) {
                        case Constants.TYPE_INITIAL:
                            store.add(new Storage(feedData.getDocId(), feedData.getTimeStamp(), feedData.getPayload(), false));
                        case Constants.TYPE_INSERT:
                        case Constants.TYPE_UPDATE:
                            for (Storage storage : store) {
                                if (storage.id.equals(feedData.getDocId())) {
                                    if (storage.time <= feedData.getTimeStamp()) {
                                        storage.time = feedData.getTimeStamp();
                                        storage.payload = feedData.getPayload();
                                        storage.isDeleted = false;
                                    }
                                    break updateStore;
                                }
                            }
                            store.add(new Storage(feedData.getDocId(), feedData.getTimeStamp(), feedData.getPayload(), false));
                            break;
                        case Constants.TYPE_DELETE:
                            for (Storage storage : store) {
                                if (storage.id.equals(feedData.getDocId()) && storage.time <= feedData.getTimeStamp()) {
                                    storage.time = feedData.getTimeStamp();
                                    storage.payload = null;
                                    storage.isDeleted = true;
                                }
                            }
                            break;
                    }
                }
                String changeType = feedDataList.get(0).getType();
                this.liveDataListener.onSnapshot(new LiveData(store), changeType);
            }
        }
    }

    static class Storage {
        String id;
        long time;
        ByteString payload;
        boolean isDeleted;

        Storage(String id, long time, ByteString payload, boolean isDeleted) {
            this.id = id;
            this.time = time;
            this.payload = payload;
            this.isDeleted = isDeleted;
        }
    }
}
