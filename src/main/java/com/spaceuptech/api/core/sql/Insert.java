package com.spaceuptech.api.core.sql;

import com.spaceuptech.api.core.proto.Meta;
import com.spaceuptech.api.core.utils.Config;
import com.spaceuptech.api.core.utils.Transport;
import com.spaceuptech.api.core.utils.Utils;

public class Insert {

    private Meta meta;
    private Config config;
    private String operation;
    private Object doc = null;
    private Object[] docs = null;

    public Insert(String db, Config config, String table) {
        this.config = config;
        this.meta = Transport.makeMeta(config.projectId, table, db, config.token);
    }

    public Insert doc(Object record) {
        this.operation = "one";
        this.doc = record;
        return this;
    }

    public Insert docs(Object records[]) {
        this.operation = "all";
        this.docs = records;
        return this;
    }

    public void apply(Utils.ResponseListener listener) {
        if (this.operation.equals("one")) {
            Transport.create(config.stub, this.doc, this.operation, this.meta, listener);
        } else if (this.operation.equals("all")) {
            Transport.create(config.stub, this.docs, this.operation, this.meta, listener);
        } else {
            listener.onError(new Exception("Operation not specified"));
        }
    }
}
