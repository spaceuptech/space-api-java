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
        this.meta = Meta.newBuilder()
                .setProject(config.projectId)
                .setCol(collection)
                .setDbType("mongo")
                .setToken(config.token).build();
    }

    public GRPCResponse one(Object doc, Utils.ResponseListener listener) {
        return Transport.create(config.host, config.port, doc, "one", this.meta);
    }

    public GRPCResponse all(Object[] docs, Utils.ResponseListener listener) {
        return Transport.create(config.host, config.port, docs, "all", this.meta);
    }
}
