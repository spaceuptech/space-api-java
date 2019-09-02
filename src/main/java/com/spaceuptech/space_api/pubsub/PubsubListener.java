package com.spaceuptech.space_api.pubsub;

import com.spaceuptech.space_api.utils.Data;

public interface PubsubListener {
    void onReceive(String subject, Data data);

    void onError(String error);
}
