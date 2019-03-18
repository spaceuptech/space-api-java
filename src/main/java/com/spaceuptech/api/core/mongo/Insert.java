package com.spaceuptech.api.core.mongo;

import com.google.gson.Gson;
import com.spaceuptech.api.core.utils.Config;
import com.spaceuptech.api.core.utils.Utils;

public class Insert {
    private class Params {
        String op;
        Object doc;
    }

    private Config config;
    private String collection;
    private Params params;

    public Insert(Config config, String collection) {
        this.config = config;
        this.collection = collection;
        this.params = new Params();
    }

    public void one(Object doc, Utils.ResponseListener listener) {
        this.params.op = "one";
        this.params.doc = doc;

        Utils.fetch(this.config.client,"post", this.config.token,
                Mongo.mongoURL(this.config.url, this.config.projectId, this.collection, ""),
                new Gson().toJson(this.params), listener);
    }

    public void all(Object docs[], Utils.ResponseListener listener) {
        this.params.op = "all";
        this.params.doc = docs;

        Utils.fetch(this.config.client,"post", this.config.token,
                Mongo.mongoURL(this.config.url, this.config.projectId, this.collection, ""),
                new Gson().toJson(this.params), listener);
    }
}
