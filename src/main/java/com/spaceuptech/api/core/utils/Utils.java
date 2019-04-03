package com.spaceuptech.api.core.utils;

import java.util.HashMap;

public class Utils {

    public interface ResponseListener {
        public void onResponse(int statusCode, Response response);
        public void onError(Exception e);
    }

//    public interface SQLAuthListener {
//        public void onResponse(int statusCode, SQLAuthResponse res);
//        public void onError(Exception e);
//    }
//
//    public interface SQLProfileListener {
//        public void onResponse(int statusCode, SQLUser user);
//        public void onError(Exception e);
//    }
//
//    public interface SQLProfilesListener {
//        public void onResponse(int statusCode, SQLUser[] users);
//        public void onError(Exception e);
//    }
//
//    public interface MongoAuthListener {
//        public void onResponse(int statusCode, MongoAuthResponse res);
//        public void onError(Exception e);
//    }
//
//    public interface MongoProfileListener {
//        public void onResponse(int statusCode, MongoUser user);
//        public void onError(Exception e);
//    }
//
//    public interface MongoProfilesListener {
//        public void onResponse(int statusCode, MongoUser[] users);
//        public void onError(Exception e);
//    }

    public static HashMap<String, Object> createMap(String k, Object v) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(k, v);
        return map;
    }
}
