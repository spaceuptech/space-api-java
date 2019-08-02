package com.spaceuptech.space_api.utils;

public class LiveQuerySubscription {
    LiveData snapshot;
    private LiveQueryUnsubscribe liveQueryUnsubscribe;

    LiveQuerySubscription(LiveQueryUnsubscribe liveQueryUnsubscribe, LiveData liveData) {
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