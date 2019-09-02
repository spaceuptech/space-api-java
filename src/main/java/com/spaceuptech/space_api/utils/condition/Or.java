package com.spaceuptech.space_api.utils.condition;

public class Or extends Condition {
    public Condition[] conditions;

    public Or(Condition[] conditions) {
        this.condType = CondType.OR;
        this.conditions = conditions;
    }

    public static Or create(Condition...conditions) {
        return new Or(conditions);
    }
}
