package com.spaceuptech.space_api.utils;

public class LiveQuerySubscription {
    LiveData snapshot;
    private Unsubscribe liveQueryUnsubscribe;

    LiveQuerySubscription(Unsubscribe liveQueryUnsubscribe, LiveData liveData) {
        this.liveQueryUnsubscribe = liveQueryUnsubscribe;
        this.snapshot = liveData;
    }

    public LiveData getSnapshot() {
        return snapshot;
    }

    public void unsubscribe() {
        liveQueryUnsubscribe.unsubscribe();
    }
}