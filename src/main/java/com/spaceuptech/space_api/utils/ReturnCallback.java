package com.spaceuptech.space_api.utils;

@FunctionalInterface
public interface ReturnCallback {
    void send(String type, Object o);
}