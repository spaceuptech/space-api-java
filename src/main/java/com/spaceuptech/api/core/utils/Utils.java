package com.spaceuptech.api.core.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.ListenableFuture;

import java.util.HashMap;
import java.util.concurrent.Executors;

public class Utils {

    public interface ResponseListener {
        public void onResponse(int statusCode, Response response);
        public void onError(Exception e);
    }

    public interface SQLAuthListener {
        public void onResponse(int statusCode, SQLAuthResponse res);
        public void onError(Exception e);
    }

    public interface SQLProfileListener {
        public void onResponse(int statusCode, SQLUser user);
        public void onError(Exception e);
    }

    public interface SQLProfilesListener {
        public void onResponse(int statusCode, SQLUser[] users);
        public void onError(Exception e);
    }

    public interface MongoAuthListener {
        public void onResponse(int statusCode, MongoAuthResponse res);
        public void onError(Exception e);
    }

    public interface MongoProfileListener {
        public void onResponse(int statusCode, MongoUser user);
        public void onError(Exception e);
    }

    public interface MongoProfilesListener {
        public void onResponse(int statusCode, MongoUser[] users);
        public void onError(Exception e);
    }

    private static ListenableFuture<org.asynchttpclient.Response> getFuture(AsyncHttpClient client, String method, String token, String url, String body) {
        BoundRequestBuilder builder;

        switch (method) {
            case "get":
                builder = client.prepareGet(url);
                break;

            case "post":
                builder = client.preparePost(url).setBody(body);
                break;

            case "delete":
                builder = client.prepareDelete(url).setBody(body);
                break;

            case "put":
                builder = client.preparePut(url).setBody(body);
                break;

            default:
                return null;

        }

        return builder
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + token)
                .execute();
    }

    public static HashMap<String, Object> createMap(String k, Object v) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(k, v);
        return map;
    }

    public static void fetch(AsyncHttpClient client, String method, String token, String url, String body, ResponseListener listener) {
        ListenableFuture<org.asynchttpclient.Response> req = getFuture(client, method, token, url, body);

        req.addListener(() -> {
            try {
                org.asynchttpclient.Response response = req.get();
                String b = response.getResponseBody();
                JsonObject jsonObject = null;
                if (b.length() > 0) {
                    Gson gson = new Gson();
                    jsonObject = gson.fromJson(b, JsonObject.class);
                }
                Response r = new Response(jsonObject);
                listener.onResponse(response.getStatusCode(), r);
            } catch (Exception e) {
                listener.onError(e);
            }
        }, Executors.newSingleThreadExecutor());
    }
}
