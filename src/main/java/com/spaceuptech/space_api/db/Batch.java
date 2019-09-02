package com.spaceuptech.space_api.db;

import com.spaceuptech.space_api.proto.Meta;
import com.spaceuptech.space_api.proto.AllRequest;
import com.spaceuptech.space_api.utils.Config;
import com.spaceuptech.space_api.utils.Transport;
import com.spaceuptech.space_api.utils.ResponseListener;
import com.spaceuptech.space_api.utils.Utils;
import com.spaceuptech.space_api.utils.Constants;

import java.util.ArrayList;


public class Batch {
    private String dbType;
    private ArrayList<AllRequest> requests = new ArrayList<>();
    private Config config;

    Batch(String dbType, Config config) {
        this.dbType = dbType;
        this.config = config;
    }

    public Batch add(Insert request) throws Exception {
        if (!config.projectId.equals(request.getProjectID())) {
            throw new Exception("Cannot Batch Requests of Different Projects");
        }
        if (!dbType.equals(request.getDBType())) {
            throw new Exception("Cannot Batch Requests of Different Database Types");
        }
        AllRequest.Builder allRequestBuilder = AllRequest.newBuilder();
        allRequestBuilder.setCol(request.getCollection());
        allRequestBuilder.setDocument(Utils.objectToByteString(request.getAllDocs()));
        allRequestBuilder.setOperation(request.getOperation());
        allRequestBuilder.setType(Constants.CREATE);
        requests.add(allRequestBuilder.build());
        return this;
    }

    public Batch add(Update request) throws Exception {
        if (!config.projectId.equals(request.getProjectID())) {
            throw new Exception("Cannot Batch Requests of Different Projects");
        }
        if (!dbType.equals(request.getDBType())) {
            throw new Exception("Cannot Batch Requests of Different Database Types");
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

    public Batch add(Delete request) throws Exception {
        if (!config.projectId.equals(request.getProjectID())) {
            throw new Exception("Cannot Batch Requests of Different Projects");
        }
        if (!dbType.equals(request.getDBType())) {
            throw new Exception("Cannot Batch Requests of Different Database Types");
        }
        AllRequest.Builder allRequestBuilder = AllRequest.newBuilder();
        allRequestBuilder.setCol(request.getCollection());
        allRequestBuilder.setOperation(request.getOperation());
        allRequestBuilder.setFind(Utils.objectToByteString(request.getFind()));
        allRequestBuilder.setType(Constants.DELETE);
        requests.add(allRequestBuilder.build());
        return this;
    }

    public void apply(ResponseListener listener) {
        Meta m = Transport.makeMeta(config.projectId, null, dbType, config.token);
        Transport.batch(config.stub, requests, m, listener);
    }
}
