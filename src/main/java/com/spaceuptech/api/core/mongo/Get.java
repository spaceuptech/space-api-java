package com.spaceuptech.api.core.mongo;

import com.google.gson.Gson;
import com.spaceuptech.api.core.utils.Condition;
import com.spaceuptech.api.core.utils.Config;
import com.spaceuptech.api.core.utils.Utils;
import com.spaceuptech.api.core.utils.And;


import java.util.HashMap;

public class Get {
    private class Params {
        HashMap<String, Object> find;
        int skip, limit;
        String[] sort;
        HashMap<String, Integer> select;
        String op, distinct;
    }

    private String collection;
    private Config config;

    private Params params;

    public Get(Config config, String collection) {
        this.config = config;
        this.collection = collection;
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

    public Get sort(String... sort) {
        this.params.sort = sort;
        return this;
    }

    public Get skip(int skip) {
        this.params.skip = skip;
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

    public void count(Utils.ResponseListener listener) {
        this.params.op = "count";

        Utils.fetch(this.config.client,"get", this.config.token, this.getUrl(), "", listener);
    }

    public void distinct(String key, Utils.ResponseListener listener) {
        this.params.op = "distinct";
        this.params.distinct = key;
        Utils.fetch(this.config.client,"get", this.config.token, this.getUrl(), "", listener);
    }

    private String getUrl() {
        Gson gson = new Gson();

        String params = "op=" + this.params.op;
        if (this.params.op == "distinct") params += "&distinct=" + this.params.distinct;
        params += "&find=" + gson.toJson(this.params.find);
        if (this.params.select != null && this.params.select.keySet().size() > 0) params += "&select=" + gson.toJson(this.params.select);
        if (this.params.sort != null && this.params.sort.length > 0) params += "&sort=" + gson.toJson(this.params.sort);
        if (this.params.limit > 0) params += "&limit=" + this.params.limit;
        if (this.params.skip > 0) params += "&skip=" + this.params.skip;
        return Mongo.mongoURL(this.config.url, this.config.projectId, this.collection, params);
    }
}
