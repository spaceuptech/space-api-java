package com.spaceuptech.space_api.service;

@FunctionalInterface
public interface ReturnCallback {
    void send(String type, Object o);
}
