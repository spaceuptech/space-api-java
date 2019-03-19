package com.spaceuptech.api.core.utils;

public class MongoAuthResponse {
    public   String token;
    public MongoUser user;

    public MongoAuthResponse(String token, MongoUser user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public MongoUser getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "token: " + token + " sqlUser: " + user;
    }
}
