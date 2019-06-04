package com.spaceuptech.space_api.utils;

public class Or extends Condition {
    public Condition conds[];

    public Or(CondType condType, Condition conds[]) {
        this.condType = condType;
        this.conds = conds;
    }

    public static Or create(Condition ...conds) {
        return new Or(CondType.OR, conds);
    }
}
