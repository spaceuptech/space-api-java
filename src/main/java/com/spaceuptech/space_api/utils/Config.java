package com.spaceuptech.space_api.utils;

import com.spaceuptech.space_api.proto.SpaceCloudGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Config {
    public String token;
    public String projectId;
    public final SpaceCloudGrpc.SpaceCloudStub stub;

    public Config(String projectId, String host, int port) {
        this.projectId = projectId;
        final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        stub = SpaceCloudGrpc.newStub(channel);
    }
}

