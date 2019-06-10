package com.spaceuptech.space_api.utils;

import com.google.gson.Gson;
import com.google.protobuf.ByteString;

public class Message {
    private ByteString params;

    public Message(ByteString params) {
        this.params = params;
    }

    public <T> T getValue(Class<T> c) {
        Gson gson = new Gson();
        String json = this.params.toStringUtf8();
        return gson.fromJson(json, c);
    }
}
