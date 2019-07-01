package com.spaceuptech.space_api.utils;

import com.google.gson.*;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import com.spaceuptech.space_api.proto.*;
import com.spaceuptech.space_api.proto.Response;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

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

    public static void createFolder(SpaceCloudGrpc.SpaceCloudStub stub, String path, String name, Meta meta, Utils.ResponseListener listener) {
        CreateFolderRequest createFolderRequest = CreateFolderRequest.newBuilder()
                .setPath(path)
                .setName(name)
                .setMeta(meta)
                .build();
        stub.createFolder(createFolderRequest, makeStreamObserver(listener));
    }

    public static void deleteFile(SpaceCloudGrpc.SpaceCloudStub stub, String path, Meta meta, Utils.ResponseListener listener) {
        DeleteFileRequest deleteFileRequest = DeleteFileRequest.newBuilder()
                .setPath(path)
                .setMeta(meta)
                .build();
        stub.deleteFile(deleteFileRequest, makeStreamObserver(listener));
    }

    public static void listFiles(SpaceCloudGrpc.SpaceCloudStub stub, String path, Meta meta, Utils.ResponseListener listener) {
        ListFilesRequest listFilesRequest = ListFilesRequest.newBuilder()
                .setPath(path)
                .setMeta(meta)
                .build();
        stub.listFiles(listFilesRequest, makeStreamObserver(listener));
    }

    public static void uploadFile(SpaceCloudGrpc.SpaceCloudStub stub, String path, String name, Meta meta, InputStream stream, Utils.ResponseListener listener) {
        StreamObserver<Response> responseObserver = new StreamObserver<Response>() {
            @Override
            public void onNext(Response response) {
                listener.onResponse(response.getStatus(), new com.spaceuptech.space_api.utils.Response(response));
            }

            @Override
            public void onError(Throwable t) {
                listener.onError(new Exception(t));
            }

            @Override
            public void onCompleted() {
            }
        };
        StreamObserver<UploadFileRequest> requestObserver = stub.uploadFile(responseObserver);
        requestObserver.onNext(UploadFileRequest.newBuilder().setPath(path).setName(name).setMeta(meta).build());
        try {
            byte[] buffer = new byte[Constants.PAYLOAD_SIZE];
            while (stream.read(buffer) != -1) {
                requestObserver.onNext(UploadFileRequest.newBuilder().setPayload(ByteString.copyFrom(buffer)).build());
            }
            stream.close();
        } catch (RuntimeException | IOException e) {
            requestObserver.onError(e);
            listener.onError(e);
        }
        requestObserver.onCompleted();
    }

    public static void downloadFile(SpaceCloudGrpc.SpaceCloudStub stub, String path, Meta meta, OutputStream stream, Utils.ResponseListener listener){
        DownloadFileRequest downloadFileRequest = DownloadFileRequest.newBuilder()
                .setPath(path)
                .setMeta(meta)
                .build();
        final int[] status = {200};
        stub.downloadFile(downloadFileRequest, new StreamObserver<FilePayload>() {
            @Override
            public void onNext(FilePayload payload) {
                if(payload.getStatus()==200) {
                    try {
                        stream.write(payload.getPayload().toByteArray());
                    } catch (IOException e) {
                        listener.onError(e);
                    }
                } else {
                    status[0] = payload.getStatus();
                    listener.onError(new Exception(payload.getError()));
                }
            }

            @Override
            public void onError(Throwable t) {
                listener.onError(new Exception(t));
            }

            @Override
            public void onCompleted() {
                listener.onResponse(200, null);
            }
        });
    }
}