package com.spaceuptech.space_api.utils;

public class And extends Condition {
    public Condition conds[];

    public And(Condition conds[]) {
        this.condType = CondType.AND;
        this.conds = conds;
    }

    public static And create(Condition ...conds) {
        return new And(conds);
    }
}
