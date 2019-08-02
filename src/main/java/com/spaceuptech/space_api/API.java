package com.spaceuptech.space_api;

import com.spaceuptech.space_api.db.DB;
import com.spaceuptech.space_api.utils.*;

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

    public DB Mongo() {
        return new DB(Constants.MONGO, this.config);
    }

    public DB MySQL() {
        return new DB(Constants.MYSQL, this.config);
    }

    public DB Postgres() {
        return new DB(Constants.POSTGRES, this.config);
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
