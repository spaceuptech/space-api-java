package com.spaceuptech.space_api.db;

import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.utils.Transport;
import com.spaceuptech.space_api.utils.Config;
import com.spaceuptech.space_api.utils.ResponseListener;


import java.util.HashMap;

public class Aggregate {

    private String operation, dbType, collection;
    private HashMap<String, Object>[] params;
    private Config config;

    Aggregate(String dbType, Config config, String collection, String operation) {
        this.operation = operation;
        this.config = config;
        this.dbType = dbType;
        this.collection = collection;
    }

    public Aggregate pipe(HashMap<String, Object>[] pipeObj) {
        params = pipeObj;
        return this;
    }

    public void apply(ResponseListener listener) {
        Meta m = Transport.makeMeta(config.projectId, collection, dbType, config.token);
        Transport.aggregate(config.stub, params, operation, m, listener);
    }
}
