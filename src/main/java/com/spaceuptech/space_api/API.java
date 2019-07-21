package com.spaceuptech.space_api;

import com.spaceuptech.space_api.mongo.Mongo;
import com.spaceuptech.space_api.sql.SQL;
import com.spaceuptech.space_api.utils.Config;
import com.spaceuptech.space_api.utils.Transport;
import com.spaceuptech.space_api.utils.Utils;
import com.spaceuptech.space_api.utils.Service;
import com.spaceuptech.space_api.utils.FileStore;

public class API {
    private Config config;

    public API(String projectId, String host, int port) {
        this.config = new Config(projectId, host, port);
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

    public void call(String serviceName, String funcName, int timeout, Object params, Utils.ResponseListener listener) {
        Transport.call(config.stub, params, timeout, serviceName, funcName, config.token, listener);
    }

    public Service service(String serviceName) {
        return new Service(config, serviceName);
    }

    public FileStore fileStore() {
        return new FileStore(config);
    }

}
