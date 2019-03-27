package com.spaceuptech.api.core.utils;

import com.google.protobuf.ByteString;
import com.spaceuptech.api.core.proto.CreateRequest;
import com.spaceuptech.api.core.proto.Meta;
import com.spaceuptech.api.core.proto.SpaceCloudGrpc;
import com.spaceuptech.api.core.proto.Response;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;

public class Transport {

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
            grpcResponse = new GRPCResponse(
                    response.getStatus(),
                    response.getError(),
                    response.getResult()
            );
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