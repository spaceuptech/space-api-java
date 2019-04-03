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

    private static StreamObserver<Response> makeStreamObserver(Utils.ResponseListener listener, ManagedChannel channel) {
        return new StreamObserver<Response>() {
            @Override
            public void onNext(Response value) {

                Gson gson = new Gson();
                if (value.getStatus() == 200) {
                    String jsonString = gson.toJson(value.getResult().toStringUtf8());
                    listener.onResponse(value.getStatus(), new com.spaceuptech.api.core.utils.Response(gson.fromJson("{ \"result\": " + jsonString + " }", JsonObject.class)));
                }
                else {
                    String jsonString = gson.toJson(value.getError());
                    listener.onResponse(value.getStatus(), new com.spaceuptech.api.core.utils.Response(gson.fromJson("{ \"result\": " + jsonString + " }", JsonObject.class)));
                }

                try {
                    channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable t) {
                listener.onError(new Exception(t));
            }

            @Override
            public void onCompleted() {}
        };
    }

    public static void create(String host, int port, Object doc, String operation, Meta meta, Utils.ResponseListener listener) {

        final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        final SpaceCloudGrpc.SpaceCloudStub stub = SpaceCloudGrpc.newStub(channel);

        Gson gson = new Gson();
        String jsonString = gson.toJson(doc);
        byte[] bytes = jsonString.getBytes();

        CreateRequest createRequest = CreateRequest.newBuilder()
                    .setDocument(ByteString.copyFrom(bytes))
                    .setOperation(operation)
                    .setMeta(meta).build();

            stub.create(createRequest, makeStreamObserver(listener, channel));
    }

    public static void read(String host, int port, Object find, String operation, ReadOptions options, Meta meta, Utils.ResponseListener listener) {

        final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        final SpaceCloudGrpc.SpaceCloudStub stub = SpaceCloudGrpc.newStub(channel);

        Gson gson = new Gson();
        String jsonString = gson.toJson(find);
        byte[] bytes = jsonString.getBytes();

        ReadRequest readRequest = ReadRequest.newBuilder()
                .setFind(ByteString.copyFrom(bytes))
                .setOperation(operation)
                .setOptions(options)
                .setMeta(meta).build();

        stub.read(readRequest, makeStreamObserver(listener, channel));
    }

    public static void update(String host, int port, Object find, String operation, Object update, Meta meta, Utils.ResponseListener listener) {

        final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        final SpaceCloudGrpc.SpaceCloudStub stub = SpaceCloudGrpc.newStub(channel);

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

        stub.update(updateRequest, makeStreamObserver(listener, channel));
    }

    public static void delete(String host, int port, Object find, String operation, Meta meta, Utils.ResponseListener listener) {

        final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        final SpaceCloudGrpc.SpaceCloudStub stub = SpaceCloudGrpc.newStub(channel);

        Gson gson = new Gson();
        String jsonString = gson.toJson(find);
        byte[] bytes = jsonString.getBytes();

        DeleteRequest deleteRequest = DeleteRequest.newBuilder()
                .setFind(ByteString.copyFrom(bytes))
                .setOperation(operation)
                .setMeta(meta).build();

        stub.delete(deleteRequest, makeStreamObserver(listener, channel));
    }
}