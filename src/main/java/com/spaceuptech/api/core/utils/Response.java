package com.spaceuptech.api.core.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Response {
    public JsonObject jsonObject;

    public Response(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public <T> T getValue(Class<T> c) {
        Gson gson = new Gson();
        JsonElement result = jsonObject.get("result");
        return  gson.fromJson(result, c);
    }

}
