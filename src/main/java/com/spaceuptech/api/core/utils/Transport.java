package com.spaceuptech.api.core.utils;

import com.google.protobuf.ByteString;
import com.spaceuptech.api.core.proto.*;
import com.spaceuptech.api.core.proto.Response;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
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

                System.out.println(value);

//                if (value.getStatus() == 200)
//                    listener.onResponse(value.getStatus(), new com.spaceuptech.api.core.utils.Response(new JsonParser().parse(value.getResult().toString()).getAsJsonObject()));
//                else
//                    listener.onResponse(value.getStatus(), new com.spaceuptech.api.core.utils.Response(new JsonParser().parse(value.getError()).getAsJsonObject()));

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

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(doc);
            out.flush();
            byte[] bytes = bos.toByteArray();

            CreateRequest createRequest = CreateRequest.newBuilder()
                    .setDocument(ByteString.copyFrom(bytes))
                    .setOperation(operation)
                    .setMeta(meta).build();

            stub.create(createRequest, makeStreamObserver(listener, channel));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
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