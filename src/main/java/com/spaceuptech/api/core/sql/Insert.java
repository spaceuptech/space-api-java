package com.spaceuptech.api.core.sql;

import com.spaceuptech.api.core.proto.Meta;
import com.spaceuptech.api.core.proto.Response;
import com.spaceuptech.api.core.utils.Config;
import com.spaceuptech.api.core.utils.Transport;
import com.spaceuptech.api.core.utils.Utils;
import io.grpc.stub.StreamObserver;

public class Insert {

    private Meta meta;
    private Config config;

    public Insert(String db, Config config, String table) {
        this.config = config;
        this.meta = Transport.makeMeta(config.projectId, table, db, config.token);
    }

    public void one(Object record, Utils.ResponseListener listener) {
        Transport.create(config, record, "one", this.meta, listener);
    }

    public void all(Object records[], Utils.ResponseListener listener) {
        Transport.create(config, records, "one", this.meta, listener);
    }
}
