package com.spaceuptech.api.core.mongo;

import com.spaceuptech.api.core.utils.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Mongo {
    private Config config;

    public Mongo(Config config) {
        this.config = config;
    }


    // CREATE
    public Insert insert(String collection) {
        return new Insert(this.config, collection);
    }


    // READ
    public Get get(String collection) {
        return new Get(this.config, collection);
    }


    // UPADTE
    public Update update(String collection) {
        return new Update(this.config, collection);
    }


    // DELETE
    public Delete delete(String collection) {
        return new Delete(this.config, collection);
    }

    // TODO
//    public void profile(String id, Utils.MongoProfileListener listener) {
//        throw new UnsupportedOperationException();
//    }
//
//    public void editProfile(String id, String email, String name, String pass, Utils.ResponseListener listener) {
//        throw new UnsupportedOperationException();
//    }
//
//    public void profiles(Utils.MongoProfilesListener listener) {
//        throw new UnsupportedOperationException();
//    }
//
//    public void signIn(String email, String pass, Utils.MongoAuthListener listener) {
//        throw new UnsupportedOperationException();
//    }
//
//    public void signUp(String email, String name, String pass, String role, Utils.MongoAuthListener listener) {
//        throw new UnsupportedOperationException();
//    }

    public static HashMap<String, Object> generateFind(Condition condition) {
        switch (condition.condType) {
            case AND: {
                And and = (And) condition;
                HashMap<String, Object> map = new HashMap<>();
                for (Condition cond : and.conds) {
                    HashMap<String, Object> m = generateFind(cond);
                    map.putAll(m);
                }
                return map;
            }
            case OR: {
                Or or = (Or) condition;
                ArrayList<HashMap<String, Object>> conds = new ArrayList<>();
                for (Condition cond : or.conds) {
                    conds.add(generateFind(cond));
                }

                HashMap<String, Object> map2 = new HashMap<>();
                map2.put("$or", conds);
                return map2;
            }
            case COND: {
                Cond cond = (Cond) condition;
                String f1 = cond.f1;
                Object f2 = cond.f2;

                HashMap<String, Object> map = new HashMap<>();
                switch (cond.eval) {
                    case "==":
                        map.put(f1, f2);
                        break;
                    case ">":
                        map.put(f1, Utils.createMap("$gt", f2));
                        break;

                    case "<":
                        map.put(f1, Utils.createMap("$lt", f2));
                        break;
                    case ">=":
                        map.put(f1, Utils.createMap("$gte", f2));
                        break;
                    case "<=":
                        map.put(f1, Utils.createMap("$lte", f2));
                        break;
                    case "!=":
                        map.put(f1, Utils.createMap("$ne", f2));
                        break;
                    case "in":
                        map.put(f1, Utils.createMap("$in", f2));
                        break;
                    case "notIn":
                        map.put(f1, Utils.createMap("$nin", f2));
                        break;
                }
                return map;
            }
            default: {
                return null;
            }
        }
    }
}
