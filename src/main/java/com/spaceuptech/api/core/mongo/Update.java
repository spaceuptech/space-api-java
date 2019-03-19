package com.spaceuptech.api.core.mongo;

import com.google.gson.Gson;
import com.spaceuptech.api.core.utils.And;
import com.spaceuptech.api.core.utils.Condition;
import com.spaceuptech.api.core.utils.Config;
import com.spaceuptech.api.core.utils.Utils;

import java.util.HashMap;

public class Update {

    private class Params {
        String op;
        HashMap<String, Object> find, update;

    }

    private Config config;
    private String collection;
    private Params params;

    public Update(Config config, String collection) {
        this.config = config;
        this.collection = collection;
        this.params = new Params();
        this.params.update = new HashMap<>();
    }

    public Update where(Condition... conds) {
        if (conds.length == 1) this.params.find = Mongo.generateFind(conds[0]);
        else this.params.find = Mongo.generateFind(And.create(conds));
        return this;
    }

    public Update set(HashMap<String, Object> obj) {
        this.params.update.put("$set", obj);
        return this;
    }

    public Update push(HashMap<String, Object> obj) {
        this.params.update.put("$push", obj);
        return this;
    }

    public Update remove(String... fields) {
        HashMap map = new HashMap<String, String>();
        for (String field : fields) {
            map.put(field, "");
        }
        this.params.update.put("$unset", map);
        return this;
    }

    public Update rename(HashMap<String, Object> obj) {
        this.params.update.put("$rename", obj);
        return this;
    }

    public Update inc(HashMap<String, Object> obj) {
        this.params.update.put("$inc", obj);
        return this;
    }

    public Update max(HashMap<String, Object> obj) {
        this.params.update.put("$max", obj);
        return this;
    }

    public Update min(HashMap<String, Object> obj) {
        this.params.update.put("$min", obj);
        return this;
    }

    public Update mul(HashMap<String, Object> obj) {
        this.params.update.put("$mul", obj);
        return this;
    }

    public Update currentTimestamp(String... fields) {
        HashMap map = this.params.update.containsKey("$currentDate") ? (HashMap) this.params.update.get("$currentDate") : new HashMap<String, Object>();
        for (String field : fields) {
            HashMap temp = new HashMap<String, String>();
            temp.put("$type", "timestamp");
            map.put(field, temp);
        }
        this.params.update.put("$currentDate", map);
        return this;
    }

    public Update currentDate(String... fields) {
        HashMap map = this.params.update.containsKey("$currentDate") ? (HashMap) this.params.update.get("$currentDate") : new HashMap<String, Object>();
        for (String field : fields) {
            HashMap temp = new HashMap<String, String>();
            temp.put("$type", "date");
            map.put(field, temp);
        }
        this.params.update.put("$currentDate", map);
        return this;
    }

    public void one(Utils.ResponseListener listener) {
        this.params.op = "one";
        Utils.fetch(this.config.client,"put", this.config.token,
                Mongo.mongoURL(this.config.url, this.config.projectId, this.collection, ""),
                new Gson().toJson(this.params), listener);

    }

    public void all(Utils.ResponseListener listener) {
        this.params.op = "all";
        Utils.fetch(this.config.client,"put", this.config.token,
                Mongo.mongoURL(this.config.url, this.config.projectId, this.collection, ""),
                new Gson().toJson(this.params), listener);

    }

    public void upsert(Utils.ResponseListener listener) {
        this.params.op = "upsert";
        Utils.fetch(this.config.client,"put", this.config.token,
                Mongo.mongoURL(this.config.url, this.config.projectId, this.collection, ""),
                new Gson().toJson(this.params), listener);

    }

}
