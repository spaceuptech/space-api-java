package com.spaceuptech.api.core.mongo;

import com.spaceuptech.api.core.proto.Meta;
import com.spaceuptech.api.core.utils.Config;
import com.spaceuptech.api.core.utils.GRPCResponse;
import com.spaceuptech.api.core.utils.Transport;
import com.spaceuptech.api.core.utils.Utils;

public class Insert {

    private Meta meta;
    private Config config;

    public Insert(Config config, String collection) {
        this.config = config;
        this.meta = Transport.makeMeta(config.projectId, collection, "mongo", config.token);
    }

    public GRPCResponse one(Object doc) {
        return Transport.create(config.host, config.port, doc, "one", this.meta);
    }

    public GRPCResponse all(Object[] docs) {
        return Transport.create(config.host, config.port, docs, "all", this.meta);
    }
}
