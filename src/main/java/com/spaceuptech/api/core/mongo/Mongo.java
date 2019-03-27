package com.spaceuptech.api.core.mongo;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.spaceuptech.api.core.utils.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Mongo {
    private Config config;

    public Mongo(Config config) {
        this.config = config;
    }

    public Get get(String collection) {
        return new Get(this.config, collection);
    }

    public Insert insert(String collection) {
        return new Insert(this.config, collection);
    }

    public Update update(String collection) {
        return new Update(this.config, collection);
    }

    public Delete delete(String collection) {
        return new Delete(this.config, collection);
    }
//
//    public void profile(String id, Utils.MongoProfileListener listener) {
//
//        Utils.ResponseListener listener1 = new Utils.ResponseListener() {
//            @Override
//            public void onResponse(int statusCode, Response response) {
//                Gson gson = new Gson();
//                JsonElement userJsonElement = response.jsonObject.get("user");
//                MongoUser mongoUser = gson.fromJson(userJsonElement, MongoUser.class);
//                listener.onResponse(statusCode, mongoUser);
//            }
//
//            @Override
//            public void onError(Exception e) {
//                listener.onError(e);
//            }
//        };
//
//        Utils.fetch(this.config.client, "get", this.config.token, this.config.url + "v1/auth/profile/" + id,
//                "", listener1);
//    }
//
//    public void editProfile(String id, String email, String name, String pass, Utils.ResponseListener listener) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("email", email);
//        map.put("name", name);
//        map.put("pass", pass);
//
//        Utils.fetch(this.config.client, "put", this.config.token, this.config.url + "v1/auth/profile/" + id,
//                new Gson().toJson(Utils.createMap("update", Utils.createMap("$set", map))), listener);
//    }
//
//    public void profiles(Utils.MongoProfilesListener listener) {
//
//        Utils.ResponseListener listener1 = new Utils.ResponseListener() {
//            @Override
//            public void onResponse(int statusCode, Response response) {
//                Gson gson = new Gson();
//                JsonElement userJsonElement = response.jsonObject.get("users");
//                MongoUser[] mongoUsers = gson.fromJson(userJsonElement, MongoUser[].class);
//                listener.onResponse(statusCode, mongoUsers);
//            }
//
//            @Override
//            public void onError(Exception e) {
//                listener.onError(e);
//            }
//        };
//
//        Utils.fetch(this.config.client, "get", this.config.token, this.config.url + "v1/auth/profiles",
//                "", listener1);
//    }
//
//    public void signIn(String email, String pass, Utils.MongoAuthListener listener) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("email", email);
//        map.put("pass", pass);
//
//        Utils.ResponseListener listener1 = new Utils.ResponseListener() {
//            @Override
//            public void onResponse(int statusCode, Response response) {
//                Gson gson = new Gson();
//                MongoAuthResponse mongoAuthResponse = gson.fromJson(response.jsonObject, MongoAuthResponse.class);
//                listener.onResponse(statusCode, mongoAuthResponse);
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
//    public void signUp(String email, String name, String pass, String role, Utils.MongoAuthListener listener) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("email", email);
//        map.put("name", name);
//        map.put("pass", pass);
//        map.put("role", role);
//
//        Utils.ResponseListener listener1 = new Utils.ResponseListener() {
//            @Override
//            public void onResponse(int statusCode, Response response) {
//                Gson gson = new Gson();
//                MongoAuthResponse mongoAuthResponse = gson.fromJson(response.jsonObject, MongoAuthResponse.class);
//                listener.onResponse(statusCode, mongoAuthResponse);
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
    public static String mongoURL(String url, String projectId, String collection, String params) {
        String temp = url + "v1/mongo/" + projectId + "/" + collection;
        if (params.length() > 0) {
            temp += "?" + params;
        }
        return temp;
    }

    public static HashMap<String, Object> generateFind(Condition condition) {
        switch (condition.condType) {
            case AND: {
                And and = (And) condition;
                HashMap<String, Object> map = new HashMap<>();
                for (Condition cond : and.conds) {
                    HashMap<String, Object> m = generateFind(cond);
                    map.putAll(m);
                }
                return map;
            }
            case OR: {
                Or or = (Or) condition;
                ArrayList<HashMap<String, Object>> conds = new ArrayList<>();
                for (Condition cond : or.conds) {
                    conds.add(generateFind(cond));
                }

                HashMap<String, Object> map2 = new HashMap<>();
                map2.put("$or", conds);
                return map2;
            }
            case COND: {
                Cond cond = (Cond) condition;
                String f1 = cond.f1;
                Object f2 = cond.f2;

                HashMap<String, Object> map = new HashMap<>();
                switch (cond.eval) {
                    case "==":
                        map.put(f1, f2);
                        break;
                    case ">":
                        map.put(f1, Utils.createMap("$gt", f2));
                        break;

                    case "<":
                        map.put(f1, Utils.createMap("$lt", f2));
                        break;
                    case ">=":
                        map.put(f1, Utils.createMap("$gte", f2));
                        break;
                    case "<=":
                        map.put(f1, Utils.createMap("$lte", f2));
                        break;
                    case "!=":
                        map.put(f1, Utils.createMap("$ne", f2));
                        break;
                    case "in":
                        map.put(f1, Utils.createMap("$in", f2));
                        break;
                    case "notIn":
                        map.put(f1, Utils.createMap("$nin", f2));
                        break;
                }
                return map;
            }
            default: {
                return null;
            }
        }
    }
}
