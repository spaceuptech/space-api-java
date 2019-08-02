package com.spaceuptech.space_api.utils;

import com.google.gson.Gson;
import com.google.protobuf.ByteString;

import java.util.HashMap;

public class Utils {

    public interface ResponseListener {
        void onResponse(int statusCode, Response response);
        void onError(Exception e);
    }

    public static HashMap<String, Object> createMap(String k, Object v) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(k, v);
        return map;
    }

    public static ByteString objectToByteString(Object o) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(o);
        return ByteString.copyFrom(jsonString.getBytes());
    }
}
