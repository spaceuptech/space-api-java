package com.spaceuptech.space_api.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Condition {
    public enum CondType{
        AND, OR, COND
    }

    public CondType condType;

    public static HashMap<String, Object> generateFind(Condition condition) {
        switch (condition.condType) {
            case AND: {
                And and = (And) condition;
                HashMap<String, Object> map = new HashMap<>();
                for (Condition cond : and.conds) {
                    HashMap<String, Object> generated = generateFind(cond);
                    if(cond.condType == CondType.COND) {
                        Cond c = (Cond) cond;
                        if(! map.containsKey(c.f1)) {
                            map.putAll(generated);
                        } else {
                            HashMap<String, Object> hashMap = (HashMap<String, Object>) map.get(c.f1);
                            hashMap.putAll((HashMap<String, Object>)generated.get(c.f1));
                        }
                    } else {
                        map.putAll(generated);
                    }
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
