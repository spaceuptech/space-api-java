package com.spaceuptech.space_api.filestore;

import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.utils.Config;
import com.spaceuptech.space_api.utils.Transport;
import com.spaceuptech.space_api.utils.ResponseListener;

import java.io.InputStream;
import java.io.OutputStream;

public class FileStore {
    private Config config;
    private Meta meta;

    public FileStore(Config config) {
        this.config = config;
        this.meta = Transport.makeMeta(config.projectId, null, null, config.token);
    }

    public void createFolder(String path, String name, ResponseListener listener) {
        Transport.createFolder(config.stub, path, name, meta, listener);
    }

    public void deleteFile(String path, ResponseListener listener) {
        Transport.deleteFile(config.stub, path, meta, listener);
    }

    public void listFiles(String path, ResponseListener listener) {
        Transport.listFiles(config.stub, path, meta, listener);
    }

    public void uploadFile(String path, String name, InputStream stream, ResponseListener listener) {
        Transport.uploadFile(config.stub, path, name, meta, stream, listener);
    }

    public void downloadFile(String path, OutputStream stream, ResponseListener listener) {
        Transport.downloadFile(config.stub, path, meta, stream, listener);
    }
}
