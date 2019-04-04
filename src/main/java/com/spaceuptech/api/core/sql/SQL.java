package com.spaceuptech.api.core.sql;

import com.spaceuptech.api.core.utils.*;

public class SQL {
    private Config config;
    private String db;

    public SQL(String db, Config config) {
        this.db = db;
        this.config = config;
    }

    public Get get(String collection) {
        return new Get(this.db, this.config, collection);
    }

    public Insert insert(String collection) {
        return new Insert(this.db, this.config, collection);
    }

    public Update update(String collection) {
        return new Update(this.db, this.config, collection);
    }

    public Delete delete(String collection) {
        return new Delete(this.db, this.config, collection);
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
