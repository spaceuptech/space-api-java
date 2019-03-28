package com.spaceuptech.api.core.mongo;

import com.spaceuptech.api.core.proto.Meta;
import com.spaceuptech.api.core.proto.ReadOptions;
import com.spaceuptech.api.core.utils.*;


import java.util.HashMap;

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

    public Get select(HashMap<String, Integer> select) {
        // TODO set select for readOptions
        return this;
    }

    public Get sort(String... sort) {
        // TODO set sort for readOptions
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

    public GRPCResponse one() {
        this.operation = "one";
        return Transport.read(config.host, config.port, this.find, this.operation, this.readOptions.build(), this.meta);
    }

    public GRPCResponse all() {
        this.operation = "all";
        return Transport.read(config.host, config.port, this.find, this.operation, this.readOptions.build(), this.meta);
    }

    public GRPCResponse count() {
        this.operation = "count";
        return Transport.read(config.host, config.port, this.find, this.operation, this.readOptions.build(), this.meta);
    }

    public GRPCResponse distinct(String key) {
        this.operation = "distinct";
        this.readOptions.setDistinct(key);
        return Transport.read(config.host, config.port, this.find, this.operation, this.readOptions.build(), this.meta);
    }
}
