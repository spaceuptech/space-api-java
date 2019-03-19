package com.spaceuptech.api.core.mongo;

import com.google.gson.Gson;
import com.spaceuptech.api.core.utils.And;
import com.spaceuptech.api.core.utils.Condition;
import com.spaceuptech.api.core.utils.Config;
import com.spaceuptech.api.core.utils.Utils;

import java.util.HashMap;

public class Delete {
    private class Params {
        String op;
        HashMap<String, Object> find;

    }

    private Config config;
    private String collection;
    private Params params;

    public Delete(Config config, String collection) {
        this.config = config;
        this.collection = collection;
        this.params = new Params();
    }

    public Delete where(Condition... conds) {
        if (conds.length == 1) this.params.find = Mongo.generateFind(conds[0]);
        else this.params.find = Mongo.generateFind(And.create(conds));
        return this;
    }

    public void one(Utils.ResponseListener listener) {
        this.params.op = "one";
        Utils.fetch(this.config.client,"delete", this.config.token,
                Mongo.mongoURL(this.config.url, this.config.projectId, this.collection, ""),
                new Gson().toJson(this.params), listener);

    }

    public void all(Utils.ResponseListener listener) {
        this.params.op = "all";
        Utils.fetch(this.config.client,"delete", this.config.token,
                Mongo.mongoURL(this.config.url, this.config.projectId, this.collection, ""),
                new Gson().toJson(this.params), listener);

    }

}
