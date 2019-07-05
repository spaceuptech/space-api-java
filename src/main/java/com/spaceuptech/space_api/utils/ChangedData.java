package com.spaceuptech.space_api.utils;

import com.google.gson.Gson;
import com.google.protobuf.ByteString;

import java.util.ArrayList;
import java.util.List;

public class ChangedData {
    private ByteString data;

    ChangedData(ByteString data) {
        this.data = data;
    }

    ChangedData() {
        this.data = ByteString.copyFromUtf8("");
    }

    public <T> T getValue(Class<T> c) {
        Gson gson = new Gson();
        return gson.fromJson(data.toStringUtf8(), c);
    }
}
