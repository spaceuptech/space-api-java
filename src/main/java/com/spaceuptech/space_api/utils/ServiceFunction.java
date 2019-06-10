package com.spaceuptech.space_api.utils;

@FunctionalInterface
public interface ServiceFunction {
    void onInvocation(Message params, Message auth, ReturnCallback cb);
}