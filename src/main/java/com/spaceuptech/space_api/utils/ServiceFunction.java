package com.spaceuptech.space_api.utils;

@FunctionalInterface
public interface ServiceFunction {
    String run(String params, String auth);
}