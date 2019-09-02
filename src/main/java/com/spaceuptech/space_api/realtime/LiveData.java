package com.spaceuptech.space_api.realtime;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class LiveData {
    private ArrayList<LiveQuery.Storage> dataList;

    LiveData(ArrayList<LiveQuery.Storage> dataList) {
        this.dataList = dataList;
    }

    public <T> List<T> getValue(Class<T> c) {
        Gson gson = new Gson();
        ArrayList<T> data = new ArrayList<>();
        for (LiveQuery.Storage storage : dataList) {
            if (!storage.isDeleted) {
                data.add(gson.fromJson(storage.payload.toStringUtf8(), c));
            }
        }
        return data;
    }

    public int size() {
        return dataList.size();
    }
}
