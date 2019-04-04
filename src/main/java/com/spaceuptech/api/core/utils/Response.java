package com.spaceuptech.api.core.utils;

import com.google.gson.*;
import com.google.protobuf.ByteString;

public class Response {

    private com.spaceuptech.api.core.proto.Response res;
    private int status;

    public Response(com.spaceuptech.api.core.proto.Response res) {
        this.res = res;
        this.status = res.getStatus();
    }

    public <T> T getResult(Class<T> c) throws Exception {
        Gson gson = new Gson();
        if (this.status >= 200 && this.status < 300) {
            String json = this.res.getResult().toStringUtf8();
            return gson.fromJson(json, c);
        } else {
            throw new Exception("Errors generated");
        }
    }

    public String getError() {
        return res.getError();
    }
}
