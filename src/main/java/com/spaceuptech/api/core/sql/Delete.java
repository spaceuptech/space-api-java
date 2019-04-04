package com.spaceuptech.api.core.sql;

import com.google.gson.Gson;
import com.spaceuptech.api.core.mongo.Mongo;
import com.spaceuptech.api.core.proto.Meta;
import com.spaceuptech.api.core.utils.*;

import java.util.HashMap;

public class Delete {

    private Meta meta;
    private String operation;
    private HashMap<String, Object> find;
    private Config config;

    public Delete(String db, Config config, String table) {
        this.config = config;
        this.meta = Transport.makeMeta(config.projectId, table, db, config.token);
    }

    public Delete where(Condition... conds) {
        if (conds.length == 1) this.find = Mongo.generateFind(conds[0]);
        else this.find = Mongo.generateFind(And.create(conds));
        return this;
    }

    public void all(Utils.ResponseListener listener) {
        this.operation = "all";
        Transport.delete(config.stub, this.find, this.operation, this.meta, listener);
    }
}
