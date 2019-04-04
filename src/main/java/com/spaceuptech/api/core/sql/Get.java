package com.spaceuptech.api.core.sql;

import com.spaceuptech.api.core.mongo.Mongo;
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

    public Get(String db, Config config, String table) {
        this.config = config;
        this.meta = Transport.makeMeta(config.projectId, table, db, config.token);
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

    public Get order(Map<String, Integer> order) {
        this.readOptions.putAllSort(order);
        return this;
    }

    public Get offset(int offset) {
        this.readOptions.setSkip(offset);
        return this;
    }

    public Get limit(int limit) {
        this.readOptions.setLimit(limit);
        return this;
    }

    public void one(Utils.ResponseListener listener) {
        this.operation = "one";
        Transport.read(config, this.find, this.operation, this.readOptions.build(), this.meta, listener);
    }

    public void all(Utils.ResponseListener listener) {
        this.operation = "all";
        Transport.read(config, this.find, this.operation, this.readOptions.build(), this.meta, listener);
    }
}
