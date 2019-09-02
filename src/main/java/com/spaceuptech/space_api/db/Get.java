package com.spaceuptech.space_api.db;

import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.proto.ReadOptions;
import com.spaceuptech.space_api.utils.condition.*;
import com.spaceuptech.space_api.utils.Config;
import com.spaceuptech.space_api.utils.Transport;
import com.spaceuptech.space_api.utils.ResponseListener;


import java.util.HashMap;
import java.util.Map;

public class Get {

    private ReadOptions.Builder readOptions;
    private String operation, dbType, collection;
    private HashMap<String, Object> find;
    private Config config;

    Get(String dbType, Config config, String collection, String operation) {
        this.operation = operation;
        this.dbType = dbType;
        this.collection = collection;
        this.config = config;
        this.readOptions = ReadOptions.newBuilder();
    }

    public Get where(Condition... conditions) {
        if (conditions.length == 1) find = Condition.generateFind(conditions[0]);
        else find = Condition.generateFind(And.create(conditions));
        return this;
    }

    public Get select(Map<String, Integer> select) {
        readOptions.putAllSelect(select);
        return this;
    }

    public Get sort(String... sort) {
        HashMap<String, Integer> s = new HashMap<>();
        for (String condition : sort) {
            if (condition.startsWith("-")) {
                s.put(condition.substring(1), -1);
            } else {
                s.put(condition, 1);
            }
        }
        readOptions.putAllSort(s);
        return this;
    }

    public Get skip(int skip) {
        readOptions.setSkip(skip);
        return this;
    }

    public Get limit(int limit) {
        readOptions.setLimit(limit);
        return this;
    }

    public Get key(String key) {
        readOptions.setDistinct(key);
        return this;
    }

    public void apply(ResponseListener listener) {
        Meta m = Transport.makeMeta(config.projectId, collection, dbType, config.token);
        Transport.read(config.stub, find, operation, readOptions.build(), m, listener);
    }
}
