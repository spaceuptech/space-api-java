package com.spaceuptech.space_api.sql;

import com.spaceuptech.space_api.mongo.Mongo;
import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.utils.*;

import java.util.HashMap;

public class Update {

    private Config config;
    private String operation;
    private Meta meta;
    private HashMap<String, Object> find, update;

    public Update(String db, Config config, String table, String operation) {
        this.config = config;
        this.operation = operation;
        this.meta = Transport.makeMeta(config.projectId, table, db, config.token);
        this.update = new HashMap<>();
    }

    public Update where(Condition... conds) {
        if (conds.length == 1) this.find = Mongo.generateFind(conds[0]);
        else this.find = Mongo.generateFind(And.create(conds));
        return this;
    }

    public Update set(HashMap<String, Object> obj) {
        this.update = obj;
        return this;
    }

    public void apply(Utils.ResponseListener listener) {
        Transport.update(config.stub, this.find, this.operation, this.update, this.meta, listener);
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

    Object getUpdate() {
        return update;
    }

}
