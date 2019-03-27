package com.spaceuptech.api.core.utils;

import org.asynchttpclient.AsyncHttpClient;

public class Config {
    public AsyncHttpClient client;
    public String token;
    public String projectId;
    public String host;
    public int port;

    public Config(String projectId, String host, int port, AsyncHttpClient client) {
        this.projectId = projectId;
        this.host = host;
        this.port = port;
        this.client = client;
    }
}

