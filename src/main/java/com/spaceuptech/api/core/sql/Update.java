package com.spaceuptech.api.core.sql;

import com.google.gson.Gson;
import com.spaceuptech.api.core.mongo.Mongo;
import com.spaceuptech.api.core.utils.And;
import com.spaceuptech.api.core.utils.Condition;
import com.spaceuptech.api.core.utils.Config;
import com.spaceuptech.api.core.utils.Utils;

import java.util.HashMap;

public class Update {
    private class Params {
        String op;
        HashMap<String, Object> find, record;
    }

    private Config config;
    private String table, db;
    private Params params;

    public Update(String db, Config config, String table) {
        this.db = db;
        this.config = config;
        this.table = table;
        this.params = new Params();
    }

    public Update where(Condition... conds) {
        if (conds.length == 1) this.params.find = Mongo.generateFind(conds[0]);
        else this.params.find = Mongo.generateFind(And.create(conds));
        return this;
    }

    public Update set(HashMap<String, Object> obj) {
        this.params.record = obj;
        return this;
    }

    public void one(Utils.ResponseListener listener) {
        this.params.op = "one";
        Utils.fetch(this.config.client,"put", this.config.token,
                SQL.sqlURL(this.config.url, this.db, this.config.projectId, this.table, ""),
                new Gson().toJson(this.params), listener);

    }

    public void all(Utils.ResponseListener listener) {
        this.params.op = "all";
        Utils.fetch(this.config.client,"put", this.config.token,
                SQL.sqlURL(this.config.url, this.db, this.config.projectId, this.table, ""),
                new Gson().toJson(this.params), listener);

    }
}
