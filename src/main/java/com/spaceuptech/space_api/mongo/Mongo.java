package com.spaceuptech.space_api.mongo;
import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.utils.*;

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
        return new Get(this.config, collection, Constants.ALL);
    }

    public Get getOne(String collection) {
        return new Get(this.config, collection, Constants.ONE);
    }

    public Get count(String collection) {
        return new Get(this.config, collection, Constants.COUNT);
    }

    public Get distinct(String collection) {
        return new Get(this.config, collection, Constants.DISTINCT);
    }


    // UPADTE
    public Update update(String collection) {
        return new Update(this.config, collection, Constants.ALL);
    }

    public Update updateOne(String collection) {
        return new Update(this.config, collection, Constants.ONE);
    }

    public Update upsert(String collection) {
        return new Update(this.config, collection, Constants.UPSERT);
    }


    // DELETE
    public Delete delete(String collection) {
        return new Delete(this.config, collection, Constants.ALL);
    }

    public Delete deleteOne(String collection) {
        return new Delete(this.config, collection, Constants.ONE);
    }

    public Batch beginBatch() {
        return new Batch(Constants.MONGO, this.config);
    }

    public LiveQuery liveQuery(String collection) {
        return new LiveQuery(this.config, collection, Constants.MONGO);
    }

    public void profile(String id, Utils.ResponseListener listener) {
        Meta meta = Transport.makeMeta(config.projectId, null, Constants.MONGO, config.token);
        Transport.profile(config.stub, id, meta, listener);
    }

    public void profiles(Utils.ResponseListener listener) {
        Meta meta = Transport.makeMeta(config.projectId, null, Constants.MONGO, config.token);
        Transport.profiles(config.stub, meta, listener);
    }

    public void editProfile(String id, ProfileParams profileParams, Utils.ResponseListener listener) {
        Meta meta = Transport.makeMeta(config.projectId, null, Constants.MONGO, config.token);
        String email = profileParams.email;
        String name = profileParams.name;
        String password = profileParams.password;
        Transport.editProfile(config.stub, id, email, name, password, meta, listener);
    }

    public void signIn(String email, String password, Utils.ResponseListener listener) {
        Meta meta = Transport.makeMeta(config.projectId, null, Constants.MONGO, config.token);
        Transport.signIn(config.stub, email, password, meta, listener);
    }

    public void signUp(String email, String name, String password, String role, Utils.ResponseListener listener) {
        Meta meta = Transport.makeMeta(config.projectId, null, Constants.MONGO, config.token);
        Transport.signUp(config.stub, email, name, password, role, meta, listener);
    }

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
