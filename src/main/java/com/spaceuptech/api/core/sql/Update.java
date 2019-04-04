package com.spaceuptech.api.core.sql;

import com.spaceuptech.api.core.mongo.Mongo;
import com.spaceuptech.api.core.proto.Meta;
import com.spaceuptech.api.core.utils.*;

import java.util.HashMap;

public class Update {

    private Config config;
    private String operation;
    private Meta meta;
    private HashMap<String, Object> find, update;

    public Update(String db, Config config, String table) {
        this.config = config;
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

    public void one(Utils.ResponseListener listener) {
        this.operation = "one";
        Transport.update(config.stub, this.find, this.operation, this.update, this.meta, listener);
    }

    public void all(Utils.ResponseListener listener) {
        this.operation = "all";
        Transport.update(config.stub, this.find, this.operation, this.update, this.meta, listener);
    }
}
