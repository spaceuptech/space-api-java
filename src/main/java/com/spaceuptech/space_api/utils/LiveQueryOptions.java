package com.spaceuptech.space_api.utils;

public class LiveQueryOptions {
    private boolean changesOnly;
    private boolean skipInitial;

    private LiveQueryOptions() {
        this.changesOnly = false;
        this.skipInitial = false;
    }

    public static LiveQueryOptions Builder() {
        return new LiveQueryOptions();
    }

    public LiveQueryOptions setChangesOnly(boolean changesOnly) {
        this.changesOnly = changesOnly;
        this.skipInitial = changesOnly;
        return this;
    }

    public LiveQueryOptions build() {
        return this;
    }

    boolean getChangesOnly() {
        return changesOnly;
    }

    boolean getSkipInitial() {
        return skipInitial;
    }
}