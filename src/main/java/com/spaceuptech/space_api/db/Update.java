package com.spaceuptech.space_api.db;

import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.utils.condition.*;
import com.spaceuptech.space_api.utils.Config;
import com.spaceuptech.space_api.utils.Transport;
import com.spaceuptech.space_api.utils.ResponseListener;

import java.util.HashMap;

public class Update {

    private Config config;
    private String operation, dbType, collection;
    private HashMap<String, Object> find, update;

    Update(String dbType, Config config, String collection, String operation) {
        this.operation = operation;
        this.config = config;
        this.dbType = dbType;
        this.collection = collection;
        this.update = new HashMap<>();
    }

    public Update where(Condition... conditions) {
        if (conditions.length == 1) find = Condition.generateFind(conditions[0]);
        else find = Condition.generateFind(And.create(conditions));
        return this;
    }

    public Update set(HashMap<String, Object> obj) {
        update.put("$set", obj);
        return this;
    }

    public Update push(HashMap<String, Object> obj) {
        update.put("$push", obj);
        return this;
    }

    public Update remove(String... fields) {
        HashMap map = new HashMap<String, String>();
        for (String field : fields) {
            map.put(field, "");
        }
        update.put("$unset", map);
        return this;
    }

    public Update rename(HashMap<String, Object> obj) {
        update.put("$rename", obj);
        return this;
    }

    public Update inc(HashMap<String, Object> obj) {
        update.put("$inc", obj);
        return this;
    }

    public Update max(HashMap<String, Object> obj) {
        update.put("$max", obj);
        return this;
    }

    public Update min(HashMap<String, Object> obj) {
        update.put("$min", obj);
        return this;
    }

    public Update mul(HashMap<String, Object> obj) {
        update.put("$mul", obj);
        return this;
    }

    public Update currentTimestamp(String... fields) {
        HashMap map = update.containsKey("$currentDate") ? (HashMap) update.get("$currentDate") : new HashMap<String, Object>();
        for (String field : fields) {
            HashMap temp = new HashMap<String, String>();
            temp.put("$type", "timestamp");
            map.put(field, temp);
        }
        update.put("$currentDate", map);
        return this;
    }

    public Update currentDate(String... fields) {
        HashMap map = update.containsKey("$currentDate") ? (HashMap) update.get("$currentDate") : new HashMap<String, Object>();
        for (String field : fields) {
            HashMap temp = new HashMap<String, String>();
            temp.put("$type", "date");
            map.put(field, temp);
        }
        update.put("$currentDate", map);
        return this;
    }

    public void apply(ResponseListener listener) {
        Meta m  = Transport.makeMeta(config.projectId, collection, dbType, config.token);
        Transport.update(config.stub, find, operation, update, m, listener);
    }

    String getProjectID() {
        return config.projectId;
    }

    String getDBType() {
        return dbType;
    }

    String getToken() {
        return config.token;
    }

    String getCollection() {
        return collection;
    }

    String getOperation() {
        return operation;
    }

    Object getFind() {
        return find;
    }

    Object getUpdate() {
        return update;
    }
}
