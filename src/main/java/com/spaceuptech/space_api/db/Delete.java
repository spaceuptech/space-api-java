package com.spaceuptech.space_api.db;

import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.utils.condition.*;
import com.spaceuptech.space_api.utils.Config;
import com.spaceuptech.space_api.utils.Transport;
import com.spaceuptech.space_api.utils.ResponseListener;

import java.util.HashMap;

public class Delete {

    private String operation, dbType, collection;
    private HashMap<String, Object> find;
    private Config config;

    Delete(String dbType, Config config, String collection, String operation) {
        this.operation = operation;
        this.dbType = dbType;
        this.collection = collection;
        this.config = config;
    }

    public Delete where(Condition... conditions) {
        if (conditions.length == 1) find = Condition.generateFind(conditions[0]);
        else find = Condition.generateFind(And.create(conditions));
        return this;
    }

    public void apply(ResponseListener listener) {
        Meta m = Transport.makeMeta(config.projectId, collection, dbType, config.token);
        Transport.delete(config.stub, find, operation, m, listener);
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
}
