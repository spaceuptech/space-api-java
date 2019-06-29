package com.spaceuptech.space_api.utils;

import com.google.gson.*;
import com.google.protobuf.ByteString;
import com.spaceuptech.space_api.proto.*;
import com.spaceuptech.space_api.proto.Response;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.HashMap;

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
                listener.onResponse(value.getStatus(), new com.spaceuptech.space_api.utils.Response(value));
            }

            @Override
            public void onError(Throwable t) {
                listener.onError(new Exception(t));
            }

            @Override
            public void onCompleted() {
            }
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

    public static void update(SpaceCloudGrpc.SpaceCloudStub stub, Object find, String operation, HashMap<String, Object> update, Meta meta, Utils.ResponseListener listener) {

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

    public static void batch(SpaceCloudGrpc.SpaceCloudStub stub, ArrayList<AllRequest> requests, Meta meta, Utils.ResponseListener listener) {
        BatchRequest batchRequest = BatchRequest.newBuilder().setMeta(meta).addAllBatchrequest(requests).build();
        stub.batch(batchRequest, makeStreamObserver(listener));
    }

    public static void call(SpaceCloudGrpc.SpaceCloudStub stub, Object params, int timeout, String service, String function, String token, Utils.ResponseListener listener) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(params);
        byte[] bytes = jsonString.getBytes();

        FunctionsRequest.Builder builder = FunctionsRequest.newBuilder()
                .setParams(ByteString.copyFrom(bytes))
                .setTimeout(timeout)
                .setService(service)
                .setFunction(function);
        if (token != null) builder.setToken(token);
        stub.call(builder.build(), makeStreamObserver(listener));
    }

    public static void profile(SpaceCloudGrpc.SpaceCloudStub stub, String id, Meta meta, Utils.ResponseListener listener) {
        ProfileRequest profileRequest = ProfileRequest.newBuilder()
                .setId(id)
                .setMeta(meta).build();
        stub.profile(profileRequest, makeStreamObserver(listener));
    }

    public static void profiles(SpaceCloudGrpc.SpaceCloudStub stub, Meta meta, Utils.ResponseListener listener) {
        ProfilesRequest profilesRequest = ProfilesRequest.newBuilder()
                .setMeta(meta).build();
        stub.profiles(profilesRequest, makeStreamObserver(listener));
    }

    public static void signIn(SpaceCloudGrpc.SpaceCloudStub stub, String email, String password, Meta meta, Utils.ResponseListener listener) {
        SignInRequest signInRequest = SignInRequest.newBuilder()
                .setEmail(email)
                .setPassword(password)
                .setMeta(meta).build();
        stub.signIn(signInRequest, makeStreamObserver(listener));
    }

    public static void signUp(SpaceCloudGrpc.SpaceCloudStub stub, String email, String name, String password, String role, Meta meta, Utils.ResponseListener listener) {
        SignUpRequest.Builder builder = SignUpRequest.newBuilder()
                .setEmail(email)
                .setName(name)
                .setPassword(password)
                .setMeta(meta);
        if (!role.equals("")) {
            builder.setRole(role);
        }
        SignUpRequest signUpRequest = builder.build();
        stub.signUp(signUpRequest, makeStreamObserver(listener));
    }

    public static void editProfile(SpaceCloudGrpc.SpaceCloudStub stub, String id, String email, String name, String password, Meta meta, Utils.ResponseListener listener) {
        EditProfileRequest.Builder builder = EditProfileRequest.newBuilder()
                .setId(id)
                .setMeta(meta);
        if (email != null) {
            builder.setEmail(email);
        }
        if (name != null) {
            builder.setName(name);
        }
        if (password != null) {
            builder.setPassword(password);
        }
        EditProfileRequest editProfileRequest = builder.build();
        stub.editProfile(editProfileRequest, makeStreamObserver(listener));
    }
}