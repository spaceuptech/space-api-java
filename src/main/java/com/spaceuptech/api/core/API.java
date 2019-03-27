package com.spaceuptech.api.core;
import com.spaceuptech.api.core.mongo.Mongo;
import com.spaceuptech.api.core.sql.SQL;
import com.spaceuptech.api.core.utils.Config;
import com.spaceuptech.api.core.utils.Utils;

import static org.asynchttpclient.Dsl.asyncHttpClient;

public class API {
    private Config config;

    public API(String projectId, String host, int port) {
        this.config = new Config(projectId, host, port, asyncHttpClient());
    }

    public void setToken(String token) {
        this.config.token = token;
    }

    public void setProjectId(String projectId) {
        this.config.projectId = projectId;
    }

    public Mongo Mongo() {
        return new Mongo(this.config);
    }

    public SQL MySQL() {
        return new SQL("sql-mysql", this.config);
    }

    public SQL Postgres() {
        return new SQL("sql-postgres", this.config);
    }

    public void call(String engineName, String funcName, int timeout, Object params, Utils.ResponseListener listener) {
        throw new UnsupportedOperationException();
    }
}
