package com.spaceuptech.space_api.db;

import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.utils.Config;
import com.spaceuptech.space_api.utils.Constants;
import com.spaceuptech.space_api.utils.Transport;
import com.spaceuptech.space_api.utils.Utils;

public class Insert {

    private Meta meta;
    private Config config;
    private Object doc = null;
    private String operation;
    private Object[] docs = null;

    public Insert(String dbType, Config config, String collection) {
        this.config = config;
        this.meta = Transport.makeMeta(config.projectId, collection, dbType, config.token);
    }

    public Insert doc(Object doc) {
        this.operation = Constants.ONE;
        this.doc = doc;
        return this;
    }

    public Insert docs(Object[] docs) {
        this.operation = Constants.ALL;
        this.docs = docs;
        return this;
    }

    public void apply(Utils.ResponseListener listener) {
        if (this.operation.equals(Constants.ONE)) {
            Transport.create(config.stub, doc, this.operation, this.meta, listener);
        } else if (this.operation.equals(Constants.ALL)) {
            Transport.create(config.stub, docs, this.operation, this.meta, listener);
        } else {
            listener.onError(new Exception("Operation not specified"));
        }
    }

    String getProjectID() {
        return config.projectId;
    }

    String getDBType() {
        return meta.getDbType();
    }

    String getToken() {
        return config.token;
    }

    String getCollection() {
        return meta.getCol();
    }

    String getOperation() {
        return operation;
    }

    Object getAllDocs() {
        if (this.operation.equals(Constants.ONE)) {
            return doc;
        } else {
            return docs;
        }
    }
}
