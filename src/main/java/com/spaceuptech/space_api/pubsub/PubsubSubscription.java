package com.spaceuptech.space_api.pubsub;


public class PubsubSubscription {
    private String subject;
    private PubsubUnsubscribe unsubscribe;

    PubsubSubscription(String subject, PubsubUnsubscribe unsubscribe) {
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