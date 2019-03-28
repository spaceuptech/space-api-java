package com.spaceuptech.api.core.utils;

public class Config {
    public String token;
    public String projectId;
    public String host;
    public int port;

    public Config(String projectId, String host, int port, String token) {
        this.projectId = projectId;
        this.host = host;
        this.port = port;
        this.token = token;
    }
}

