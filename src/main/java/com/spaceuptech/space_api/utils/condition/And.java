package com.spaceuptech.space_api.utils.condition;

public class And extends Condition {
    public Condition[] conditions;

    public And(Condition[] conditions) {
        this.condType = CondType.AND;
        this.conditions = conditions;
    }

    public static And create(Condition...conditions) {
        return new And(conditions);
    }
}
