package com.spaceuptech.api.core.mongo;

import com.google.gson.Gson;
import com.spaceuptech.api.core.proto.Meta;
import com.spaceuptech.api.core.utils.*;

import java.util.HashMap;

public class Update {

    private Config config;
    private String operation;
    private Meta meta;
    HashMap<String, Object> find, update;

    public Update(Config config, String collection) {
        this.config = config;
        this.meta = Transport.makeMeta(config.projectId, collection, "mongo", config.token);
        this.update = new HashMap<>();
    }

    public Update where(Condition... conds) {
        if (conds.length == 1) this.find = Mongo.generateFind(conds[0]);
        else this.find = Mongo.generateFind(And.create(conds));
        return this;
    }

    public Update set(HashMap<String, Object> obj) {
        this.update.put("$set", obj);
        return this;
    }

    public Update push(HashMap<String, Object> obj) {
        this.update.put("$push", obj);
        return this;
    }

    public Update remove(String... fields) {
        HashMap map = new HashMap<String, String>();
        for (String field : fields) {
            map.put(field, "");
        }
        this.update.put("$unset", map);
        return this;
    }

    public Update rename(HashMap<String, Object> obj) {
        this.update.put("$rename", obj);
        return this;
    }

    public Update inc(HashMap<String, Object> obj) {
        this.update.put("$inc", obj);
        return this;
    }

    public Update max(HashMap<String, Object> obj) {
        this.update.put("$max", obj);
        return this;
    }

    public Update min(HashMap<String, Object> obj) {
        this.update.put("$min", obj);
        return this;
    }

    public Update mul(HashMap<String, Object> obj) {
        this.update.put("$mul", obj);
        return this;
    }

    public Update currentTimestamp(String... fields) {
        HashMap map = this.update.containsKey("$currentDate") ? (HashMap) this.update.get("$currentDate") : new HashMap<String, Object>();
        for (String field : fields) {
            HashMap temp = new HashMap<String, String>();
            temp.put("$type", "timestamp");
            map.put(field, temp);
        }
        this.update.put("$currentDate", map);
        return this;
    }

    public Update currentDate(String... fields) {
        HashMap map = this.update.containsKey("$currentDate") ? (HashMap) this.update.get("$currentDate") : new HashMap<String, Object>();
        for (String field : fields) {
            HashMap temp = new HashMap<String, String>();
            temp.put("$type", "date");
            map.put(field, temp);
        }
        this.update.put("$currentDate", map);
        return this;
    }

    public GRPCResponse one() {
        this.operation = "one";
        return Transport.update(config.host, config.port, this.find, this.operation, this.update, this.meta);
    }

    public GRPCResponse all() {
        this.operation = "all";
        return Transport.update(config.host, config.port, this.find, this.operation, this.update, this.meta);
    }

    public GRPCResponse upsert(Utils.ResponseListener listener) {
        this.operation = "upsert";
        return Transport.update(config.host, config.port, this.find, this.operation, this.update, this.meta);
    }
}
