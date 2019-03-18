package com.spaceuptech.api.core.utils;

public class Cond extends Condition {
    public String f1;
    public Object f2;
    public String eval;

    public Cond(String f1, String eval, Object f2) {
        this.condType = CondType.COND;
        this.f1 = f1;
        this.f2 = f2;
        this.eval = eval;
    }

    public static Cond create(String f1, String eval, Object f2) {
        return new Cond(f1, eval, f2);
    }
}
