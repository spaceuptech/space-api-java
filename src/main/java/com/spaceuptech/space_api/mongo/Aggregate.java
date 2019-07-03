package com.spaceuptech.space_api.mongo;

import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.utils.*;

import java.util.HashMap;

public class Aggregate {

    private Meta meta;
    private String operation;
    private HashMap<String, Object> params;
    private Config config;

    Aggregate(Config config, String collection, String operation) {
        this.operation = operation;
        this.config = config;
        this.meta = Transport.makeMeta(config.projectId, collection, Constants.MONGO, config.token);
    }

    public Aggregate pipe(HashMap<String, Object> pipeObj) {
        params = pipeObj;
        return this;
    }

    public void apply(Utils.ResponseListener listener) {
        Transport.aggregate(config.stub, this.params, this.operation, this.meta, listener);
    }
}
