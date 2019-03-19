package com.spaceuptech.api.core.utils;

import org.asynchttpclient.AsyncHttpClient;

public class Config {
    public AsyncHttpClient client;
    public String token;
    public String projectId;
    public String url;

    public Config(String projectId, String url, AsyncHttpClient client) {
        this.projectId = projectId;
        this.url = url;
        this.client = client;
    }
}

