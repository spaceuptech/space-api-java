package com.spaceuptech.api.core.sql;

import com.google.gson.Gson;
import com.spaceuptech.api.core.utils.Config;
import com.spaceuptech.api.core.utils.Utils;

public class Insert {
    private class Params {
        String op;
        Object record;
    }

    private Config config;
    private String table, db;
    private Params params;

    public Insert(String db, Config config, String table) {
        this.db = db;
        this.config = config;
        this.table = table;
        this.params = new Params();
    }

    public void one(Object record, Utils.ResponseListener listener) {
        this.params.op = "one";
        this.params.record = record;

        Utils.fetch(this.config.client,"post", this.config.token,
                SQL.sqlURL(this.config.url, this.db, this.config.projectId, this.table, ""),
                new Gson().toJson(this.params), listener);
    }

    public void all(Object records[], Utils.ResponseListener listener) {
        this.params.op = "all";
        this.params.record = records;

        Utils.fetch(this.config.client,"post", this.config.token,
                SQL.sqlURL(this.config.url, this.db, this.config.projectId, this.table, ""),
                new Gson().toJson(this.params), listener);
    }
}
