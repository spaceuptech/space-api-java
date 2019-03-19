package com.spaceuptech.api.core.utils;

public class SQLAuthResponse {
    public   String token;
    public SQLUser user;

    public SQLAuthResponse(String token, SQLUser user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public SQLUser getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "token: " + token + " sqlUser: " + user;
    }
}
