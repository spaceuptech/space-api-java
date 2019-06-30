package com.spaceuptech.space_api.utils;

import com.google.gson.*;

public class Response {

    private com.spaceuptech.space_api.proto.Response res;
    private int status;

    public Response(com.spaceuptech.space_api.proto.Response res) {
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

    public <T> T[] getResults(Class<T[]> c) throws Exception {
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
