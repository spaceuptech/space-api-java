package com.spaceuptech.space_api.mongo;

import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.utils.*;

import java.util.HashMap;

public class Delete {

    private Meta meta;
    private String operation;
    private HashMap<String, Object> find;
    private Config config;

    public Delete(Config config, String collection, String operation) {
        this.operation = operation;
        this.config = config;
        this.meta = Transport.makeMeta(config.projectId, collection, Constants.MONGO, config.token);
    }

    public Delete where(Condition... conds) {
        if (conds.length == 1) this.find = Condition.generateFind(conds[0]);
        else this.find = Condition.generateFind(And.create(conds));
        return this;
    }

    public void apply(Utils.ResponseListener listener) {
        Transport.delete(config.stub, this.find, this.operation, this.meta, listener);
    }

    String getProjectID() {
        return config.projectId;
    }

    String getDBType() {
        return meta.getDbType();
    }

    String getToken() {
        return config.token;
    }

    String getCollection() {
        return meta.getCol();
    }

    String getOperation() {
        return operation;
    }

    Object getFind() {
        return find;
    }
}
