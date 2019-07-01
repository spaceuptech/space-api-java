package com.spaceuptech.space_api.utils;

import com.spaceuptech.space_api.proto.Meta;

import java.io.InputStream;
import java.io.OutputStream;

public class FileStore {
    private Config config;
    private Meta meta;
    public FileStore(Config config) {
        this.config = config;
        this.meta = Transport.makeMeta(config.projectId, null, null, config.token);
    }

    public void createFolder(String path, String name, Utils.ResponseListener listener) {
        Transport.createFolder(config.stub, path, name, meta, listener);
    }

    public void deleteFile(String path, Utils.ResponseListener listener) {
        Transport.deleteFile(config.stub, path, meta, listener);
    }

    public void listFiles(String path, Utils.ResponseListener listener) {
        Transport.listFiles(config.stub, path, meta, listener);
    }

    public void uploadFile(String path, String name, InputStream stream, Utils.ResponseListener listener) {
        Transport.uploadFile(config.stub, path, name, meta, stream, listener);
    }

    public void downloadFile(String path, OutputStream stream, Utils.ResponseListener listener) {
        Transport.downloadFile(config.stub, path, meta, stream, listener);
    }

}
