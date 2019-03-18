package com.spaceuptech.api.core.sql;

import com.google.gson.Gson;
import com.spaceuptech.api.core.mongo.Mongo;
import com.spaceuptech.api.core.utils.And;
import com.spaceuptech.api.core.utils.Condition;
import com.spaceuptech.api.core.utils.Config;
import com.spaceuptech.api.core.utils.Utils;

import java.util.HashMap;

public class Get {
    private class Params {
        HashMap<String, Object> find;
        int offset, limit;
        String[] order;
        HashMap<String, Integer> select;
        String op;
    }

    private String table, db;
    private Config config;

    private Params params;

    public Get(String db, Config config, String table) {
        this.db = db;
        this.config = config;
        this.table = table;
        this.params = new Params();
    }

    public Get where(Condition... conds) {
        if (conds.length == 1) this.params.find = Mongo.generateFind(conds[0]);
        else this.params.find = Mongo.generateFind(And.create(conds));
        return this;
    }

    public Get select(HashMap<String, Integer> select) {
        this.params.select = select;
        return this;
    }

    public Get order(String... order) {
        this.params.order = order;
        return this;
    }

    public Get offset(int offset) {
        this.params.offset = offset;
        return this;
    }

    public Get limit(int limit) {
        this.params.limit = limit;
        return this;
    }

    public void one(Utils.ResponseListener listener) {
        this.params.op = "one";

        Utils.fetch(this.config.client,"get", this.config.token, this.getUrl(), "", listener);
    }

    public void all(Utils.ResponseListener listener) {
        this.params.op = "all";

        Utils.fetch(this.config.client,"get", this.config.token, this.getUrl(), "", listener);
    }


    private String getUrl() {
        Gson gson = new Gson();

        String params = "op=" + this.params.op;
        params += "&find=" + gson.toJson(this.params.find);
        if (this.params.select != null && this.params.select.keySet().size() > 0) params += "&select=" + gson.toJson(this.params.select);
        if (this.params.order != null && this.params.order.length > 0) params += "&order=" + gson.toJson(this.params.order);
        if (this.params.limit > 0) params += "&limit=" + this.params.limit;
        if (this.params.offset > 0) params += "&skip=" + this.params.offset;
        return SQL.sqlURL(this.config.url, this.db, this.config.projectId, this.table, params);
    }
}
