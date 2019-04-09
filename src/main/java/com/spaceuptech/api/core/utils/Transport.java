package com.spaceuptech.api.core.utils;

import com.google.gson.*;
import com.google.protobuf.ByteString;
import com.spaceuptech.api.core.proto.*;
import com.spaceuptech.api.core.proto.Response;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class Transport {

    public static Meta makeMeta(String project, String collection, String dbType, String token) {

        Meta.Builder metaBuilder = Meta.newBuilder();

        if (project != null) metaBuilder.setProject(project);
        if (collection != null) metaBuilder.setCol(collection);
        if (dbType != null) metaBuilder.setDbType(dbType);
        if (token != null) metaBuilder.setToken(token);

        return metaBuilder.build();
    }

    private static StreamObserver<Response> makeStreamObserver(Utils.ResponseListener listener) {
        return new StreamObserver<Response>() {
            @Override
            public void onNext(Response value) {
                listener.onResponse(value.getStatus(), new com.spaceuptech.api.core.utils.Response(value));
            }

            @Override
            public void onError(Throwable t) {
                listener.onError(new Exception(t));
            }

            @Override
            public void onCompleted() {}
        };
    }

    public static void create(SpaceCloudGrpc.SpaceCloudStub stub, Object doc, String operation, Meta meta, Utils.ResponseListener listener) {

        Gson gson = new Gson();
        String jsonString = gson.toJson(doc);
        byte[] bytes = jsonString.getBytes();

        CreateRequest createRequest = CreateRequest.newBuilder()
                    .setDocument(ByteString.copyFrom(bytes))
                    .setOperation(operation)
                    .setMeta(meta).build();

        stub.create(createRequest, makeStreamObserver(listener));
    }

    public static void read(SpaceCloudGrpc.SpaceCloudStub stub, Object find, String operation, ReadOptions options, Meta meta, Utils.ResponseListener listener) {

        Gson gson = new Gson();
        String jsonString = gson.toJson(find);
        byte[] bytes = jsonString.getBytes();

        ReadRequest readRequest = ReadRequest.newBuilder()
                .setFind(ByteString.copyFrom(bytes))
                .setOperation(operation)
                .setOptions(options)
                .setMeta(meta).build();

        stub.read(readRequest, makeStreamObserver(listener));
    }

    public static void update(SpaceCloudGrpc.SpaceCloudStub stub, Object find, String operation, Object update, Meta meta, Utils.ResponseListener listener) {

        Gson gson = new Gson();
        String jsonString = gson.toJson(find);
        byte[] findBytes = jsonString.getBytes();
        jsonString = gson.toJson(update);
        byte[] updateBytes = jsonString.getBytes();

        UpdateRequest updateRequest = UpdateRequest.newBuilder()
                .setFind(ByteString.copyFrom(findBytes))
                .setOperation(operation)
                .setUpdate(ByteString.copyFrom(updateBytes))
                .setMeta(meta).build();

        stub.update(updateRequest, makeStreamObserver(listener));
    }

    public static void delete(SpaceCloudGrpc.SpaceCloudStub stub, Object find, String operation, Meta meta, Utils.ResponseListener listener) {

        Gson gson = new Gson();
        String jsonString = gson.toJson(find);
        byte[] bytes = jsonString.getBytes();

        DeleteRequest deleteRequest = DeleteRequest.newBuilder()
                .setFind(ByteString.copyFrom(bytes))
                .setOperation(operation)
                .setMeta(meta).build();

        stub.delete(deleteRequest, makeStreamObserver(listener));
    }

    public static void call(SpaceCloudGrpc.SpaceCloudStub stub, Object params, int timeout, String engine, String function, String token, Utils.ResponseListener listener) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(params);
        byte[] bytes = jsonString.getBytes();

        FaaSRequest faaSRequest = FaaSRequest.newBuilder()
                .setParams(ByteString.copyFrom(bytes))
                .setTimeout(timeout)
                .setEngine(engine)
                .setFunction(function)
                .setToken(token).build();

        stub.call(faaSRequest, makeStreamObserver(listener));
    }
}