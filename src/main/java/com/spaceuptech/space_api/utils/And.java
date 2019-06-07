package com.spaceuptech.space_api.utils;

public class And extends Condition {
    public Condition conds[];

    public And(CondType condType, Condition conds[]) {
        this.condType = condType;
        this.conds = conds;
    }

    public static And create(Condition ...conds) {
        return new And(CondType.AND, conds);
    }
}
