package com.spaceuptech.space_api.utils;

public interface ResponseListener {
    void onResponse(int statusCode, Response response);

    void onError(Exception e);
}
