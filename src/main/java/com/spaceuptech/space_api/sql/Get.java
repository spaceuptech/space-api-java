package com.spaceuptech.space_api.sql;

import com.spaceuptech.space_api.mongo.Mongo;
import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.proto.ReadOptions;
import com.spaceuptech.space_api.utils.*;

import java.util.HashMap;
import java.util.Map;

public class Get {

    private Meta meta;
    private ReadOptions.Builder readOptions;
    private String operation;
    private HashMap<String, Object> find;
    private Config config;

    public Get(String db, Config config, String table, String operation) {
        this.operation = operation;
        this.config = config;
        this.meta = Transport.makeMeta(config.projectId, table, db, config.token);
        this.readOptions = ReadOptions.newBuilder();
    }

    public Get where(Condition... conds) {
        if (conds.length == 1) this.find = Condition.generateFind(conds[0]);
        else this.find = Condition.generateFind(And.create(conds));
        return this;
    }

    public Get select(Map<String, Integer> select) {
        this.readOptions.putAllSelect(select);
        return this;
    }

    public Get sort(String... sort) {
        HashMap<String, Integer> s = new HashMap<>();
        for (String condition: sort) {
            if(condition.startsWith("-")) {
                s.put(condition.substring(1), -1);
            } else {
                s.put(condition, 1);
            }
        }
        this.readOptions.putAllSort(s);
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

    public void apply(Utils.ResponseListener listener) {
        Transport.read(config.stub, this.find, this.operation, this.readOptions.build(), this.meta, listener);
    }
}
