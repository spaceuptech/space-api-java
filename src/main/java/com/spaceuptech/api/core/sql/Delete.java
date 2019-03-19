package com.spaceuptech.api.core.sql;

import com.google.gson.Gson;
import com.spaceuptech.api.core.mongo.Mongo;
import com.spaceuptech.api.core.utils.And;
import com.spaceuptech.api.core.utils.Condition;
import com.spaceuptech.api.core.utils.Config;
import com.spaceuptech.api.core.utils.Utils;

import java.util.HashMap;

public class Delete {
    private class Params {
        HashMap<String, Object> find;
    }

    private Config config;
    private String db, table;
    private Params params;

    public Delete(String db, Config config, String table) {
        this.db = db;
        this.config = config;
        this.table = table;
        this.params = new Params();
    }

    public Delete where(Condition... conds) {
        if (conds.length == 1) this.params.find = Mongo.generateFind(conds[0]);
        else this.params.find = Mongo.generateFind(And.create(conds));
        return this;
    }


    public void all(Utils.ResponseListener listener) {
        Utils.fetch(this.config.client,"delete", this.config.token,
                SQL.sqlURL(this.config.url, this.db, this.config.projectId, this.table, ""),
                new Gson().toJson(this.params), listener);

    }
}
