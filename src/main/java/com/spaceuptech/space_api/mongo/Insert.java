package com.spaceuptech.space_api.mongo;

import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.utils.Config;
import com.spaceuptech.space_api.utils.Transport;
import com.spaceuptech.space_api.utils.Utils;

public class Insert {

    private Meta meta;
    private Config config;
    private Object doc = null;
    private String operation;
    private Object[] docs = null;

    public Insert(Config config, String collection) {
        this.config = config;
        this.meta = Transport.makeMeta(config.projectId, collection, "mongo", config.token);
    }

    public Insert doc(Object doc) {
        this.operation = "one";
        this.doc = doc;
        return this;
    }

    public Insert docs(Object[] docs) {
        this.operation = "all";
        this.docs = docs;
        return this;
    }

    public void apply(Utils.ResponseListener listener) {
        if (this.operation.equals("one")) {
            Transport.create(config.stub, doc, this.operation, this.meta, listener);
        } else if (this.operation.equals("all")) {
            Transport.create(config.stub, docs, this.operation, this.meta, listener);
        } else {
            listener.onError(new Exception("Operation not specified"));
        }
    }
}
