package com.spaceuptech.space_api.sql;

import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.utils.*;

public class SQL {
    private Config config;
    private String db;

    public SQL(String db, Config config) {
        this.db = db;
        this.config = config;
    }

    // CREATE
    public Insert insert(String collection) {
        return new Insert(this.db, this.config, collection);
    }


    // READ
    public Get get(String collection) {
        return new Get(this.db, this.config, collection, Constants.ALL);
    }

    public Get getOne(String collection) {
        return new Get(this.db, this.config, collection, Constants.ONE);
    }


    // UPDATE
    public Update update(String collection) {
        return new Update(this.db, this.config, collection, Constants.ALL);
    }
    public Update updateOne(String collection) {
        return new Update(this.db, this.config, collection, Constants.ONE);
    }

//    public Update upsert(String collection) {
//        return new Update(this.db, this.config, collection, Constants.UPSERT);
//    }

    public Batch beginBatch() {
        return new Batch(this.db, this.config);
    }


    // DELETE
    public Delete delete(String collection) {
        return new Delete(this.db, this.config, collection, Constants.ALL);
    }
    public Delete deleteOne(String collection) {
        return new Delete(this.db, this.config, collection, Constants.ONE);
    }

    public LiveQuery liveQuery(String collection) {
        return new LiveQuery(this.config, collection, this.db);
    }

    public void profile(String id, Utils.ResponseListener listener) {
        Meta meta = Transport.makeMeta(config.projectId, null, db, config.token);
        Transport.profile(config.stub, id, meta, listener);
    }

    public void profiles(Utils.ResponseListener listener) {
        Meta meta = Transport.makeMeta(config.projectId, null, db, config.token);
        Transport.profiles(config.stub, meta, listener);
    }

    public void editProfile(String id, ProfileParams profileParams, Utils.ResponseListener listener) {
        Meta meta = Transport.makeMeta(config.projectId, null, db, config.token);
        String email = profileParams.email;
        String name = profileParams.name;
        String password = profileParams.password;
        Transport.editProfile(config.stub, id, email, name, password, meta, listener);
    }

    public void signIn(String email, String password, Utils.ResponseListener listener) {
        Meta meta = Transport.makeMeta(config.projectId, null, db, config.token);
        Transport.signIn(config.stub, email, password, meta, listener);
    }

    public void signUp(String email, String name, String password, String role, Utils.ResponseListener listener) {
        Meta meta = Transport.makeMeta(config.projectId, null, db, config.token);
        Transport.signUp(config.stub, email, name, password, role, meta, listener);
    }
}
