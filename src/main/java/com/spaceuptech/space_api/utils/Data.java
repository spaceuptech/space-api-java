package com.spaceuptech.space_api.utils;

import com.google.gson.Gson;
import com.google.protobuf.ByteString;

public class Data {
    private ByteString data;

    Data(ByteString data) {
        this.data = data;
    }

    Data() {
        this.data = ByteString.copyFromUtf8("");
    }

    public <T> T getValue(Class<T> c) {
        Gson gson = new Gson();
        return gson.fromJson(data.toStringUtf8(), c);
    }
}
