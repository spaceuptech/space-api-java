package com.spaceuptech.api.core.sql;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.spaceuptech.api.core.utils.*;

import java.util.HashMap;

public class SQL {
    private Config config;
    private String db;

    public SQL(String db, Config config) {
        this.db = db;
        this.config = config;
    }

    public Get get(String collection) {
        return new Get(this.db, this.config, collection);
    }

    public Insert insert(String collection) {
        return new Insert(this.db, this.config, collection);
    }

    public Update update(String collection) {
        return new Update(this.db, this.config, collection);
    }

    public Delete delete(String collection) {
        return new Delete(this.db, this.config, collection);
    }
//
//    public void profile(String id, Utils.SQLProfileListener listener) {
//
//        Utils.ResponseListener listener1 = new Utils.ResponseListener() {
//            @Override
//            public void onResponse(int statusCode, Response response) {
//                Gson gson = new Gson();
//                JsonElement userJsonElement = response.jsonObject.get("user");
//                SQLUser sqlUser = gson.fromJson(userJsonElement, SQLUser.class);
//                listener.onResponse(statusCode, sqlUser);
//            }
//
//            @Override
//            public void onError(Exception e) {
//                listener.onError(e);
//            }
//        };
//
//        Utils.fetch(this.config.client, "get", this.config.token,
//                this.config.url + "v1/auth/" + this.db + "/profile/" + id, "", listener1);
//    }
//
//    public void editProfile(String id, String email, String name, String pass, Utils.ResponseListener listener) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("email", email);
//        map.put("name", name);
//        map.put("pass", pass);
//
//        Utils.fetch(this.config.client, "put", this.config.token,
//                this.config.url + "v1/auth/" + this.db + "/profile/" + id,
//                new Gson().toJson(Utils.createMap("record", map)), listener);
//    }
//
//    public void profiles(Utils.SQLProfilesListener listener) {
//
//        Utils.ResponseListener listener1 = new Utils.ResponseListener() {
//            @Override
//            public void onResponse(int statusCode, Response response) {
//                Gson gson = new Gson();
//                JsonElement userJsonElement = response.jsonObject.get("users");
//                SQLUser[] sqlUsers = gson.fromJson(userJsonElement, SQLUser[].class);
//                listener.onResponse(statusCode, sqlUsers);
//            }
//
//            @Override
//            public void onError(Exception e) {
//                listener.onError(e);
//            }
//        };
//
//        Utils.fetch(this.config.client, "get", this.config.token,
//                this.config.url + "v1/auth/" + this.db + "/profiles", "", listener1);
//    }
//
//    public void signIn(String email, String pass, Utils.SQLAuthListener listener) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("email", email);
//        map.put("pass", pass);
//        map.put("db", this.db);
//
//        Utils.ResponseListener listener1 = new Utils.ResponseListener() {
//            @Override
//            public void onResponse(int statusCode, Response response) {
//                Gson gson = new Gson();
//                SQLAuthResponse sqlAuthResponse = gson.fromJson(response.jsonObject, SQLAuthResponse.class);
//                listener.onResponse(statusCode, sqlAuthResponse);
//            }
//
//            @Override
//            public void onError(Exception e) {
//                listener.onError(e);
//            }
//        };
//
//        Utils.fetch(this.config.client, "post", this.config.token, this.config.url + "v1/auth/email/signin",
//                new Gson().toJson(map), listener1);
//    }
//
//    public void signUp(String email, String name, String pass, String role, Utils.SQLAuthListener listener) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("email", email);
//        map.put("name", name);
//        map.put("pass", pass);
//        map.put("role", role);
//        map.put("db", this.db);
//
//        Utils.ResponseListener listener1 = new Utils.ResponseListener() {
//            @Override
//            public void onResponse(int statusCode, Response response) {
//                Gson gson = new Gson();
//                SQLAuthResponse sqlAuthResponse = gson.fromJson(response.jsonObject, SQLAuthResponse.class);
//                listener.onResponse(statusCode, sqlAuthResponse);
//            }
//
//            @Override
//            public void onError(Exception e) {
//                listener.onError(e);
//            }
//        };
//
//        Utils.fetch(this.config.client, "post", this.config.token, this.config.url + "v1/auth/email/signup",
//                new Gson().toJson(map), listener1);
//    }
//
//
//    public static String sqlURL(String url, String db, String projectId, String table, String params) {
//        String temp = url + "v1/sql/" + db + "/" + projectId + "/" + table;
//        if (params.length() > 0) {
//            temp += "?" + params;
//        }
//        return temp;
//    }
}
