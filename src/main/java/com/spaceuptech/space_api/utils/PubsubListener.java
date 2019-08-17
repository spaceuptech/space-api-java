package com.spaceuptech.space_api.utils;

public interface PubsubListener {
    void onReceive(String subject, Data data);

    void onError(String error);
}
