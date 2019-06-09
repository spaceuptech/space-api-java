package com.spaceuptech.space_api.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.spaceuptech.space_api.proto.FunctionsPayload;
import io.grpc.stub.StreamObserver;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class Service {
    private Config config;
    private String serviceName;
    private final String uuid;
    private Map<String, ServiceFunction> METHODS;

    public Service(Config config, String serviceName) {
        this.config = config;
        this.serviceName = serviceName;
        this.uuid = UUID.randomUUID().toString();
    }

    public void registerFunction(String functionName, ServiceFunction serviceFunction) {
        METHODS.put(functionName, serviceFunction);
    }

    public void start() throws Throwable {
        final Throwable[] throwables = new Throwable[1];
        AtomicReference<StreamObserver<FunctionsPayload>> requestObserverRef = new AtomicReference<>();
        CountDownLatch finishedLatch = new CountDownLatch(1);
        StreamObserver<FunctionsPayload> streamObserver = config.stub.service(new StreamObserver<FunctionsPayload>() {
            @Override
            public void onNext(FunctionsPayload payload) {
                Gson gson = new Gson();
                if (payload.getType().equals(Constants.TYPE_SERVICE_REGISTER)) {
                    if (payload.getId().equals(uuid)) {
                        JsonObject params = new JsonParser().parse(payload.getParams().toStringUtf8()).getAsJsonObject();
                        if (params.get("ack").getAsBoolean()) {
                            // Service Registered
                        }
                    }
                } else if (payload.getType().equals(Constants.TYPE_SERVICE_REQUEST)) {
                    FunctionsPayload.Builder toSend = FunctionsPayload.newBuilder()
                            .setId(payload.getId())
                            .setType(Constants.TYPE_SERVICE_REQUEST)
                            .setService(serviceName);
                    if (METHODS.containsKey(payload.getFunction())) {
                        try {
                            String answer = METHODS.get(payload.getFunction()).run(payload.getParams().toString(), payload.getAuth().toString());
                            toSend.setParams(Utils.objectToByteString(answer));
                        } catch (Exception e) {
                            toSend.setError(e.getMessage());
                        }
                    } else {
                        toSend.setError("Function not Registered");
                    }
                    requestObserverRef.get().onNext(toSend.build());
                }
            }

            @Override
            public void onError(Throwable t) {
                throwables[0] = t;
                finishedLatch.countDown();
            }

            @Override
            public void onCompleted() {
                finishedLatch.countDown();
            }
        });
        requestObserverRef.set(streamObserver);
        streamObserver.onNext(FunctionsPayload.newBuilder()
                .setService(serviceName)
                .setType(Constants.TYPE_SERVICE_REGISTER)
                .setId(uuid)
                .setProject(config.projectId)
                .setToken(config.token)
                .build());
        finishedLatch.await();
        streamObserver.onCompleted();
        if (throwables[0] != null) {
            throw throwables[0];
        }
    }
}