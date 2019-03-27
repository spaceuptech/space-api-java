package com.spaceuptech.api.core.utils;

public class GRPCResponse {
    public int status;
    public String error;
    public Object result;

    public GRPCResponse(int status, String error, Object result) {
        this.error = error;
        this.result = result;
        this.status = status;
    }
}
