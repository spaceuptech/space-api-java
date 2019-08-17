package com.spaceuptech;

import com.spaceuptech.space_api.API;
import com.spaceuptech.space_api.utils.*;

import java.util.HashMap;

public class Pubsub {
    public static void main(String[] args) throws Exception {
        API api = new API("books-app", "localhost", 4124);
        Pubsub pubsub = api.pubsub();
        PubsubSubscription subscription = pubsub.subscribe("/subject/", new PubsubListener() {
            @Override
            public void onReceive(String subject, Data data) {
                System.out.println(subject);
                System.out.println(data.getValue(HashMap.class));
            }

            @Override
            public void onError(String error) {
                System.out.println(error);
            }
        });
        for (int i = 0; i < 30; i++) {
            Thread.sleep(500);
            HashMap<String, Object> h = new HashMap<>();
            h.put("key1", 12);
            h.put("key2", "sdfadsf");
            h.put("key3", 7.58);
            h.put("key4", true);
            pubsub.publish("/subject/a/", h, new Utils.ResponseListener() {
                @Override
                public void onResponse(int statusCode, Response response) {
                    if (statusCode == 200) {
                        System.out.println("Successfully published");
                    } else {
                        System.out.println(response.getError());
                    }
                }

                @Override
                public void onError(Exception e) {
                    System.out.println(e.getMessage());
                }
            });
        }

        // After some condition
        subscription.unsubscribe();
    }
}