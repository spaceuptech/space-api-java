package com.spaceuptech.space_api.utils;

public class PubsubSubscription {
    private String subject;
    private Unsubscribe unsubscribe;

    PubsubSubscription(String subject, Unsubscribe unsubscribe) {
        this.subject = subject;
        this.unsubscribe = unsubscribe;
    }

    public String getSubject() {
        return subject;
    }

    public void unsubscribe() {
        unsubscribe.unsubscribe();
    }
}