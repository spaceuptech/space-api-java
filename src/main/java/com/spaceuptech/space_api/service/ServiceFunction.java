package com.spaceuptech.space_api.service;

import com.spaceuptech.space_api.utils.Data;

@FunctionalInterface
public interface ServiceFunction {
    void onInvocation(Data params, Data auth, ReturnCallback cb);
}
