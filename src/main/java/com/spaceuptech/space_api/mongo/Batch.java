package com.spaceuptech.space_api.mongo;

import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.proto.AllRequest;
import com.spaceuptech.space_api.utils.*;

import java.util.ArrayList;


public class Batch {
    private String db;
    private ArrayList<AllRequest> requests;
    private Meta meta;
    private Config config;

    public Batch(String db, Config config) {
        this.db = db;
        this.config = config;
        this.meta = Transport.makeMeta(config.projectId, null, db, config.token);
    }

    public Batch add(Insert request) throws  Exception{
        if(!this.config.projectId.equals(request.getProjectID())) {
            throw new Exception("Cannot Batch Requests of Different Projects");
        }
        if(!this.db.equals(request.getDBType())) {
            throw new Exception("Cannot Batch Requests of Different Database Types");
        }
        if(!this.config.token.equals(request.getToken())) {
            throw new Exception("Cannot Batch Requests using Different Tokens");
        }
        AllRequest.Builder allRequestBuilder = AllRequest.newBuilder();
        allRequestBuilder.setCol(request.getCollection());
        allRequestBuilder.setDocument(Utils.objectToByteString(request.getAllDocs()));
        allRequestBuilder.setOperation(request.getOperation());
        allRequestBuilder.setType(Constants.CREATE);
        requests.add(allRequestBuilder.build());
        return this;
    }

    public Batch add(Update request) throws  Exception{
        if(!this.config.projectId.equals(request.getProjectID())) {
            throw new Exception("Cannot Batch Requests of Different Projects");
        }
        if(!this.db.equals(request.getDBType())) {
            throw new Exception("Cannot Batch Requests of Different Database Types");
        }
        if(!this.config.token.equals(request.getToken())) {
            throw new Exception("Cannot Batch Requests using Different Tokens");
        }
        AllRequest.Builder allRequestBuilder = AllRequest.newBuilder();
        allRequestBuilder.setCol(request.getCollection());
        allRequestBuilder.setOperation(request.getOperation());
        allRequestBuilder.setFind(Utils.objectToByteString(request.getFind()));
        allRequestBuilder.setUpdate(Utils.objectToByteString(request.getUpdate()));
        allRequestBuilder.setType(Constants.UPDATE);
        requests.add(allRequestBuilder.build());
        return this;
    }

    public Batch add(Delete request) throws  Exception{
        if(!this.config.projectId.equals(request.getProjectID())) {
            throw new Exception("Cannot Batch Requests of Different Projects");
        }
        if(!this.db.equals(request.getDBType())) {
            throw new Exception("Cannot Batch Requests of Different Database Types");
        }
        if(!this.config.token.equals(request.getToken())) {
            throw new Exception("Cannot Batch Requests using Different Tokens");
        }
        AllRequest.Builder allRequestBuilder = AllRequest.newBuilder();
        allRequestBuilder.setCol(request.getCollection());
        allRequestBuilder.setOperation(request.getOperation());
        allRequestBuilder.setFind(Utils.objectToByteString(request.getFind()));
        allRequestBuilder.setType(Constants.DELETE);
        requests.add(allRequestBuilder.build());
        return this;
    }

    public void apply(Utils.ResponseListener listener) {
        Transport.batch(config.stub, this.requests, this.meta, listener);
    }
}
