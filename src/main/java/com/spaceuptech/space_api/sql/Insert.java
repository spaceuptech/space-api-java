package com.spaceuptech.space_api.sql;

import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.utils.Config;
import com.spaceuptech.space_api.utils.Transport;
import com.spaceuptech.space_api.utils.Utils;
import com.spaceuptech.space_api.utils.Constants;

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
        this.operation = Constants.ONE;
        this.doc = record;
        return this;
    }

    public Insert docs(Object records[]) {
        this.operation = Constants.ALL;
        this.docs = records;
        return this;
    }

    public void apply(Utils.ResponseListener listener) {
        if (this.operation.equals(Constants.ONE)) {
            Transport.create(config.stub, this.doc, this.operation, this.meta, listener);
        } else if (this.operation.equals(Constants.ALL)) {
            Transport.create(config.stub, this.docs, this.operation, this.meta, listener);
        } else {
            listener.onError(new Exception("Operation not specified"));
        }
    }
}
