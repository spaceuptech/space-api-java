package com.spaceuptech.api.core.mongo;

import com.spaceuptech.api.core.proto.Meta;
import com.spaceuptech.api.core.utils.*;

public class Insert {

    private Meta meta;
    private Config config;

    public Insert(Config config, String collection) {
        this.config = config;
        this.meta = Transport.makeMeta(config.projectId, collection, "mongo", config.token);
    }

    public void one(Object doc, Utils.ResponseListener listener) {
        Transport.create(config, doc, "one", this.meta, listener);
    }

    public void all(Object[] docs, Utils.ResponseListener listener) {
        Transport.create(config, docs, "all", this.meta, listener);
    }
}
