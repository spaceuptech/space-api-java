package com.spaceuptech.api.core.utils;

import com.google.gson.JsonParser;
import com.google.protobuf.ByteString;
import com.spaceuptech.api.core.proto.*;
import com.spaceuptech.api.core.proto.Response;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class Transport {

    public static Meta makeMeta(String project, String collection, String dbType, String token) {
        return Meta.newBuilder()
                .setProject(project)
                .setCol(collection)
                .setDbType(dbType)
                .setToken(token).build();
    }

    private static StreamObserver<Response> makeStreamObserver(Utils.ResponseListener listener, ManagedChannel channel) {
        return new StreamObserver<Response>() {
            @Override
            public void onNext(Response value) {
                listener.onResponse(value.getStatus(), new com.spaceuptech.api.core.utils.Response(new JsonParser().parse(value.toString()).getAsJsonObject()));
            }

            @Override
            public void onError(Throwable t) {
                listener.onError(new Exception(t));
            }

            @Override
            public void onCompleted() {
                try {
                    channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
    }

    public static void create(String host, int port, Object doc, String operation, Meta meta, Utils.ResponseListener listener) {

        final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        final SpaceCloudGrpc.SpaceCloudStub stub = SpaceCloudGrpc.newStub(channel);

        CreateRequest createRequest = CreateRequest.newBuilder()
                .setDocument((ByteString) doc)
                .setOperation(operation)
                .setMeta(meta).build();

        stub.create(createRequest, makeStreamObserver(listener, channel));
    }

    public static void read(String host, int port, Object find, String operation, ReadOptions options, Meta meta, Utils.ResponseListener listener) {

        final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        final SpaceCloudGrpc.SpaceCloudStub stub = SpaceCloudGrpc.newStub(channel);

        ReadRequest readRequest = ReadRequest.newBuilder()
                .setFind((ByteString) find)
                .setOperation(operation)
                .setOptions(options)
                .setMeta(meta).build();

        stub.read(readRequest, makeStreamObserver(listener, channel));
    }

    public static void update(String host, int port, Object find, String operation, Object update, Meta meta, Utils.ResponseListener listener) {

        final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        final SpaceCloudGrpc.SpaceCloudStub stub = SpaceCloudGrpc.newStub(channel);

        UpdateRequest updateRequest = UpdateRequest.newBuilder()
                .setFind((ByteString) find)
                .setOperation(operation)
                .setUpdate((ByteString) update)
                .setMeta(meta).build();

        stub.update(updateRequest, makeStreamObserver(listener, channel));
    }

    public static void delete(String host, int port, Object find, String operation, Meta meta, Utils.ResponseListener listener) {

        final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        final SpaceCloudGrpc.SpaceCloudStub stub = SpaceCloudGrpc.newStub(channel);

        DeleteRequest deleteRequest = DeleteRequest.newBuilder()
                .setFind((ByteString) find)
                .setOperation(operation)
                .setMeta(meta).build();

        stub.delete(deleteRequest, makeStreamObserver(listener, channel));
    }
}