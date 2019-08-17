package com.spaceuptech.space_api.utils;

public interface LiveDataListener {
    void onSnapshot(LiveData data, String type, Data changedData);

    void onError(String error);
}