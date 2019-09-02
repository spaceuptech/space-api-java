package com.spaceuptech.space_api.db;

import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.utils.Config;
import com.spaceuptech.space_api.utils.Constants;
import com.spaceuptech.space_api.utils.Transport;
import com.spaceuptech.space_api.utils.ResponseListener;

public class Insert {

    private Config config;
    private Object doc = null;
    private String operation, dbType, collection;
    private Object[] docs = null;

    Insert(String dbType, Config config, String collection) {
        this.config = config;
        this.dbType = dbType;
        this.collection = collection;
    }

    public Insert doc(Object doc) {
        operation = Constants.ONE;
        doc = doc;
        return this;
    }

    public Insert docs(Object[] docs) {
        operation = Constants.ALL;
        docs = docs;
        return this;
    }

    public void apply(ResponseListener listener) {
        Meta m = Transport.makeMeta(config.projectId, collection, dbType, config.token);
        if (operation.equals(Constants.ONE)) {
            Transport.create(config.stub, doc, operation, m, listener);
        } else if (operation.equals(Constants.ALL)) {
            Transport.create(config.stub, docs, operation, m, listener);
        } else {
            listener.onError(new Exception("Operation not specified"));
        }
    }

    String getProjectID() {
        return config.projectId;
    }

    String getDBType() {
        return dbType;
    }

    String getToken() {
        return config.token;
    }

    String getCollection() {
        return collection;
    }

    String getOperation() {
        return operation;
    }

    Object getAllDocs() {
        if (operation.equals(Constants.ONE)) {
            return doc;
        } else {
            return docs;
        }
    }
}
