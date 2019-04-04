package com.spaceuptech.api.core.mongo;

import com.spaceuptech.api.core.proto.Meta;
import com.spaceuptech.api.core.proto.ReadOptions;
import com.spaceuptech.api.core.utils.*;


import java.util.HashMap;
import java.util.Map;

public class Get {

    private Meta meta;
    private ReadOptions.Builder readOptions;
    private String operation;
    private HashMap<String, Object> find;
    private Config config;

    public Get(Config config, String collection) {
        this.config = config;
        this.meta = Transport.makeMeta(config.projectId, collection, "mongo", config.token);
        this.readOptions = ReadOptions.newBuilder();
    }

    public Get where(Condition... conds) {
        if (conds.length == 1) this.find = Mongo.generateFind(conds[0]);
        else this.find = Mongo.generateFind(And.create(conds));
        return this;
    }

    public Get select(Map<String, Integer> select) {
        this.readOptions.putAllSelect(select);
        return this;
    }

    public Get sort(Map<String, Integer> sort) {
        this.readOptions.putAllSort(sort);
        return this;
    }

    public Get skip(int skip) {
        this.readOptions.setSkip(skip);
        return this;
    }

    public Get limit(int limit) {
        this.readOptions.setLimit(limit);
        return this;
    }

    public void one(Utils.ResponseListener listener) {
        this.operation = "one";
        Transport.read(config.stub, this.find, this.operation, this.readOptions.build(), this.meta, listener);
    }

    public void all(Utils.ResponseListener listener) {
        this.operation = "all";
        Transport.read(config.stub, this.find, this.operation, this.readOptions.build(), this.meta, listener);
    }

    public void count(Utils.ResponseListener listener) {
        this.operation = "count";
        Transport.read(config.stub, this.find, this.operation, this.readOptions.build(), this.meta, listener);
    }

    public void distinct(String key, Utils.ResponseListener listener) {
        this.operation = "distinct";
        this.readOptions.setDistinct(key);
        Transport.read(config.stub, this.find, this.operation, this.readOptions.build(), this.meta, listener);
    }
}
