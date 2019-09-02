package com.spaceuptech.space_api.db;

import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.utils.*;
import com.spaceuptech.space_api.realtime.LiveQuery;

public class DB {
    private Config config;
    private String dbType;

    public DB(String dbType, Config config) {
        this.dbType = dbType;
        this.config = config;
    }


    // CREATE
    public Insert insert(String collection) {
        return new Insert(this.dbType, this.config, collection);
    }


    // READ
    public Get get(String collection) {
        return new Get(this.dbType, this.config, collection, Constants.ALL);
    }

    public Get getOne(String collection) {
        return new Get(this.dbType, this.config, collection, Constants.ONE);
    }

    public Get count(String collection) {
        return new Get(this.dbType, this.config, collection, Constants.COUNT);
    }

    public Get distinct(String collection) {
        return new Get(this.dbType, this.config, collection, Constants.DISTINCT);
    }


    // UPDATE
    public Update update(String collection) {
        return new Update(this.dbType, this.config, collection, Constants.ALL);
    }

    public Update updateOne(String collection) {
        return new Update(this.dbType, this.config, collection, Constants.ONE);
    }

    public Update upsert(String collection) {
        return new Update(this.dbType, this.config, collection, Constants.UPSERT);
    }


    // DELETE
    public Delete delete(String collection) {
        return new Delete(this.dbType, this.config, collection, Constants.ALL);
    }

    public Delete deleteOne(String collection) {
        return new Delete(this.dbType, this.config, collection, Constants.ONE);
    }

    // AGGREGATE
    public Aggregate aggr(String collection) {
        return new Aggregate(this.dbType, this.config, collection, Constants.ONE);
    }

    public Aggregate aggrOne(String collection) {
        return new Aggregate(this.dbType, this.config, collection, Constants.ONE);
    }

    public Batch beginBatch() {
        return new Batch(this.dbType, this.config);
    }

    public LiveQuery liveQuery(String collection) {
        return new LiveQuery(this.dbType, this.config, collection);
    }

    public void profile(String id, ResponseListener listener) {
        Meta meta = Transport.makeMeta(config.projectId, null, this.dbType, config.token);
        Transport.profile(config.stub, id, meta, listener);
    }

    public void profiles(ResponseListener listener) {
        Meta meta = Transport.makeMeta(config.projectId, null, this.dbType, config.token);
        Transport.profiles(config.stub, meta, listener);
    }

    public void editProfile(String id, ProfileParams profileParams, ResponseListener listener) {
        Meta meta = Transport.makeMeta(config.projectId, null, this.dbType, config.token);
        String email = profileParams.email;
        String name = profileParams.name;
        String password = profileParams.password;
        Transport.editProfile(config.stub, id, email, name, password, meta, listener);
    }

    public void signIn(String email, String password, ResponseListener listener) {
        Meta meta = Transport.makeMeta(config.projectId, null, this.dbType, config.token);
        Transport.signIn(config.stub, email, password, meta, listener);
    }

    public void signUp(String email, String name, String password, String role, ResponseListener listener) {
        Meta meta = Transport.makeMeta(config.projectId, null, this.dbType, config.token);
        Transport.signUp(config.stub, email, name, password, role, meta, listener);
    }
}
