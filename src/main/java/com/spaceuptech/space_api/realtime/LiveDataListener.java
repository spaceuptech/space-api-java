package com.spaceuptech.space_api.realtime;

import com.spaceuptech.space_api.utils.Data;

public interface LiveDataListener {
    void onSnapshot(LiveData data, String type, Data changedData);

    void onError(String error);
}
