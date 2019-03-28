package com.spaceuptech.api.core.utils;

import com.google.protobuf.ByteString;
import com.spaceuptech.api.core.proto.*;
import com.spaceuptech.api.core.proto.Response;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class Transport {

    public static Meta makeMeta(String project, String collection, String dbType, String token) {
        return Meta.newBuilder()
                .setProject(project)
                .setCol(collection)
                .setDbType(dbType)
                .setToken(token).build();
    }

    private static GRPCResponse getGRPCResponse(Response response) {
        return new GRPCResponse(
                response.getStatus(),
                response.getError(),
                response.getResult()
        );
    }

    public static GRPCResponse create(String host, int port, Object doc, String operation, Meta meta) {

        final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        final SpaceCloudGrpc.SpaceCloudBlockingStub blockingStub = SpaceCloudGrpc.newBlockingStub(channel);

        CreateRequest createRequest = CreateRequest.newBuilder()
                .setDocument((ByteString) doc)
                .setOperation(operation)
                .setMeta(meta).build();

        GRPCResponse grpcResponse = null;
        try {
            Response response = blockingStub.create(createRequest);
            grpcResponse = getGRPCResponse(response);
        }
        finally {
            try {
                channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
            } finally {
                return grpcResponse;
            }
        }
    }

    public static GRPCResponse read(String host, int port, Object find, String operation, ReadOptions options, Meta meta) {

        final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        final SpaceCloudGrpc.SpaceCloudBlockingStub blockingStub = SpaceCloudGrpc.newBlockingStub(channel);

        ReadRequest readRequest = ReadRequest.newBuilder()
                .setFind((ByteString) find)
                .setOperation(operation)
                .setOptions(options)
                .setMeta(meta).build();

        GRPCResponse grpcResponse = null;
        try {
            Response response = blockingStub.read(readRequest);
            grpcResponse = getGRPCResponse(response);
        }
        finally {
            try {
                channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
            } finally {
                return grpcResponse;
            }
        }
    }

    public static GRPCResponse update(String host, int port, Object find, String operation, Object update, Meta meta) {

        final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        final SpaceCloudGrpc.SpaceCloudBlockingStub blockingStub = SpaceCloudGrpc.newBlockingStub(channel);

        UpdateRequest updateRequest = UpdateRequest.newBuilder()
                .setFind((ByteString) find)
                .setOperation(operation)
                .setUpdate((ByteString) update)
                .setMeta(meta).build();

        GRPCResponse grpcResponse = null;
        try {
            Response response = blockingStub.update(updateRequest);
            grpcResponse = getGRPCResponse(response);
        }
        finally {
            try {
                channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
            } finally {
                return grpcResponse;
            }
        }
    }

    public static GRPCResponse delete(String host, int port, Object find, String operation, Meta meta) {

        final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        final SpaceCloudGrpc.SpaceCloudBlockingStub blockingStub = SpaceCloudGrpc.newBlockingStub(channel);

        DeleteRequest deleteRequest = DeleteRequest.newBuilder()
                .setFind((ByteString) find)
                .setOperation(operation)
                .setMeta(meta).build();

        GRPCResponse grpcResponse = null;
        try {
            Response response = blockingStub.delete(deleteRequest);
            grpcResponse = getGRPCResponse(response);
        }
        finally {
            try {
                channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
            } finally {
                return grpcResponse;
            }
        }
    }
}