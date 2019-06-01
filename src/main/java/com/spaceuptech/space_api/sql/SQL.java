package com.spaceuptech.space_api.sql;
import com.spaceuptech.space_api.utils.Config;

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
        return new Get(this.db, this.config, collection, "all");
    }

    public Get getOne(String collection) {
        return new Get(this.db, this.config, collection, "one");
    }


    // UPDATE
    public Update update(String collection) {
        return new Update(this.db, this.config, collection, "all");
    }

    public Update upsert(String collection) {
        return new Update(this.db, this.config, collection, "upsert");
    }


    // DELETE
    public Delete delete(String collection) {
        return new Delete(this.db, this.config, collection, "all");
    }

    // TODO
//    public void profile(String id, Utils.SQLProfileListener listener) {
//        throw new UnsupportedOperationException();
//    }
//
//    public void editProfile(String id, String email, String name, String pass, Utils.ResponseListener listener) {
//        throw new UnsupportedOperationException();
//    }
//
//    public void profiles(Utils.SQLProfilesListener listener) {
//        throw new UnsupportedOperationException();
//    }
//
//    public void signIn(String email, String pass, Utils.SQLAuthListener listener) {
//        throw new UnsupportedOperationException();
//    }
//
//    public void signUp(String email, String name, String pass, String role, Utils.SQLAuthListener listener) {
//        throw new UnsupportedOperationException();
//    }
}
