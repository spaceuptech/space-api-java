package com.spaceuptech;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.spaceuptech.space_api.API;
import com.spaceuptech.space_api.mongo.Mongo;
import com.spaceuptech.space_api.utils.Response;
import com.spaceuptech.space_api.utils.Service;
import com.spaceuptech.space_api.utils.ServiceFunction;
import com.spaceuptech.space_api.utils.Utils;

import java.util.HashMap;
import java.util.Map;

public class Main {

//    private static Utils.ResponseListener generateListener(String event, Class c) {
//        return new Utils.ResponseListener() {
//            @Override
//            public void onResponse(int statusCode, Response response) {
//                System.out.println(event + ":: StatusCode: " + statusCode + " Data: " + response.getValue(c));
//            }
//
//            @Override
//            public void onError(Exception e) {
//                System.out.println(event + ":: Error: " + e.toString());
//            }
//        };
//    }

    public static void main(String[] args) throws Throwable {
        API api = new API("grpc", "localhost", 8081);
        Service service = api.service("service");
        service.registerFunction("echo_function", new ServiceFunction() {
            @Override
            public String run(String params, String auth) {
                return params;
            }
        });
        service.start();
//        // Tests for gRPC API
//        API api = new API("test-project", "localhost", 8081);
//        Mongo mongo = api.Mongo();
//
//        Map<String, String> document = new HashMap<>();
//        document.put("_id", "ABCDE");
//        document.put("first_name", "John");
//        document.put("last_name", "Doe");
//
//        mongo.insert("test-collection")
//                .doc(document)
//                .apply(new Utils.ResponseListener() {
//                    @Override
//                    public void onResponse(int statusCode, Response response) {
//                        System.out.println("Status Code: " + statusCode);
//                        try {
//                            System.out.println("Result: " + response.getResult(JsonObject.class));
//                        } catch (Exception e) {
//                            System.out.println(e.getMessage());
//                            System.out.println("Error: " + response.getError());
//                        }
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//                        e.printStackTrace();
//                    }
//                });
//
//        mongo.get("test-collection")
//                .apply(new Utils.ResponseListener() {
//                    @Override
//                    public void onResponse(int statusCode, Response response) {
//                        System.out.println("Status Code: " + statusCode);
//                        try {
//                            System.out.println("Result: " + response.getResult(JsonArray.class));
//                        } catch (Exception e) {
//                            System.out.println(e.getMessage());
//                            System.out.println("Error: " + response.getError());
//                        }
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//                        e.printStackTrace();
//                    }
//                });
//
//        while (true) {}





        // Tests for HTTP API
//        String name = "User 1";
//        String email = "user1@gmail.com";
//        String role = "user";

        /****************************** SQL ******************************/
//        API api = new API("realtime-mysql", "http://localhost:8080");
//        SQL mySQL = api.MySQL();
//        Utils.SQLAuthListener signUpListener = new Utils.SQLAuthListener() {
//            @Override
//            public void onResponse(int statusCode, SQLAuthResponse res) {
//                if (statusCode != 200) {
//                    System.out.println("Error in SignUp: " + statusCode);
//                    return;
//                }
//                SQLUser user = res.user;
//                if (!user.email.equals(email) || !user.role.equals(role)) {
//                    System.out.println("Error in SignUp: "  +  user.email.equals(email) + user.role.equals(role));
//                    return;
//                }
//                System.out.println("SignUp Successful");
//
//                Utils.SQLAuthListener signInListener = new Utils.SQLAuthListener() {
//                    @Override
//                    public void onResponse(int statusCode, SQLAuthResponse res) {
//                        if (statusCode != 200) {
//                            System.out.println("Error in SignIn: " + statusCode);
//                            return;
//                        }
//
//                        SQLUser user = res.user;
//                        if (!user.email.equals(email) || !user.role.equals(role) || !user.name.equals(name)|| res.token.length() == 0) {
//                            System.out.println("Error in SignIn");
//                            return;
//                        }
//
//                        api.setToken(res.token);
//
//                        Utils.ResponseListener listener = new Utils.ResponseListener() {
//                            @Override
//                            public void onResponse(int statusCode, Response response) {
//                                if (statusCode != 200) {
//                                    System.out.println("Error in inserting single post: " + statusCode);
//                                    return;
//                                }
//                                System.out.println("Inserting single post successful");
//
//                                Post[] posts = new Post[2];
//                                posts[0] = new Post("Post 2", "user1@gmail.com", "This is a better post");
//                                posts[1] = new Post("Post 3", "user2@gmail.com", "This post is excellent");
//
//                                Utils.ResponseListener listener1 = new Utils.ResponseListener() {
//                                    @Override
//                                    public void onResponse(int statusCode, Response response) {
//                                        if (statusCode != 200) {
//                                            System.out.println("Error in inserting multiple posts: " + statusCode);
//                                            return;
//                                        }
//                                        System.out.println("Inserting multiple posts successful");
//
//                                        Utils.ResponseListener listener2 = new Utils.ResponseListener() {
//                                            @Override
//                                            public void onResponse(int statusCode, Response response) {
//                                                if (statusCode != 200) {
//                                                    System.out.println("Error in reading single post: " + statusCode);
//                                                    return;
//                                                }
//
//                                                Post post = response.getValue(Post.class);
//                                                if (!post.content.equals("This is a good post")) {
//                                                    System.out.println("Error in reading single post");
//                                                    return;
//                                                }
//                                                System.out.println("Get single post successful");
//
//                                                Utils.ResponseListener listener3 = new Utils.ResponseListener() {
//                                                    @Override
//                                                    public void onResponse(int statusCode, Response response) {
//                                                        if (statusCode != 200) {
//                                                            System.out.println("Error in reading multiple post: " + statusCode);
//                                                            return;
//                                                        }
//
//                                                        Post[] posts = response.getValue(Post[].class);
//                                                        if (posts.length != 2) {
//                                                            System.out.println("Error in reading multiple posts");
//                                                            return;
//                                                        }
//                                                        System.out.println("Get multiple posts successful");
//
//                                                        Utils.ResponseListener listener4 = new Utils.ResponseListener() {
//                                                            @Override
//                                                            public void onResponse(int statusCode, Response response) {
//                                                                if (statusCode != 200) {
//                                                                    System.out.println("Error in updating single post: " + statusCode);
//                                                                    return;
//                                                                }
//                                                                System.out.println("Updating single post successful");
//
//                                                                HashMap updates = new HashMap();
//                                                                updates.put("content", "Each post is best in its own way");
//
//                                                                Utils.ResponseListener listener5 = new Utils.ResponseListener() {
//                                                                    @Override
//                                                                    public void onResponse(int statusCode, Response response) {
//                                                                        if (statusCode != 200) {
//                                                                            System.out.println("Error in updating multiple post: " + statusCode);
//                                                                            return;
//                                                                        }
//                                                                        System.out.println("Updating multiple post successful");
//
//                                                                        Utils.ResponseListener listener6 = new Utils.ResponseListener() {
//                                                                            @Override
//                                                                            public void onResponse(int statusCode, Response response) {
//                                                                                if (statusCode != 200) {
//                                                                                    System.out.println("Error in deleting posts: " + statusCode);
//                                                                                    return;
//                                                                                }
//                                                                                System.out.println("Deleting posts successful");
//
//                                                                                Utils.ResponseListener listener7 = new Utils.ResponseListener() {
//                                                                                    @Override
//                                                                                    public void onResponse(int statusCode, Response response) {
//                                                                                        if (statusCode != 200) {
//                                                                                            System.out.println("Error in editing profile: " + statusCode);
//                                                                                            return;
//                                                                                        }
//
//                                                                                        System.out.println("Editing profile successful");
//
//                                                                                        Utils.SQLProfileListener sqlProfileListener = new Utils.SQLProfileListener() {
//                                                                                            @Override
//                                                                                            public void onResponse(int statusCode, SQLUser user) {
//                                                                                                if (statusCode != 200) {
//                                                                                                    System.out.println("Error in fetching profile: " + statusCode);
//                                                                                                    return;
//                                                                                                }
//
//                                                                                                if (!user.name.equals("Jayesh")) {
//                                                                                                    System.out.println("Error in fetching profile");
//                                                                                                    return;
//                                                                                                }
//
//                                                                                                System.out.println("Fetching profile successful");
//
//                                                                                                Utils.SQLProfilesListener sqlProfilesListener = new Utils.SQLProfilesListener() {
//                                                                                                    @Override
//                                                                                                    public void onResponse(int statusCode, SQLUser[] users) {
//                                                                                                        if (statusCode != 200) {
//                                                                                                            System.out.println("Error in fetching profiles: " + statusCode);
//                                                                                                            return;
//                                                                                                        }
//
//                                                                                                        if (users.length != 1 && !(users[0].name.equals("Jayesh"))) {
//                                                                                                            System.out.println("Error in fetching profiles");
//                                                                                                            return;
//                                                                                                        }
//
//                                                                                                        System.out.println("Fetching profiles successful");
//                                                                                                    }
//
//                                                                                                    @Override
//                                                                                                    public void onError(Exception e) {
//                                                                                                        System.out.println("Exception " + e);
//                                                                                                    }
//                                                                                                };
//                                                                                                mySQL.profiles(sqlProfilesListener);
//                                                                                            }
//
//                                                                                            @Override
//                                                                                            public void onError(Exception e) {
//                                                                                                System.out.println("Exception " + e);
//                                                                                            }
//                                                                                        };
//
//                                                                                        mySQL.profile(user.id, sqlProfileListener);
//                                                                                    }
//
//                                                                                    @Override
//                                                                                    public void onError(Exception e) {
//                                                                                        System.out.println("Exception " + e);
//                                                                                    }
//                                                                                };
//                                                                                mySQL.editProfile(user.id, user.email, "Jayesh", "123", listener7);
//
//                                                                            }
//
//                                                                            @Override
//                                                                            public void onError(Exception e) {
//                                                                                System.out.println("Exception " + e);
//                                                                            }
//                                                                        };
//
//                                                                        mySQL.delete("posts").where(new Cond("title", "==", "Post 1")).all(listener6);
//                                                                    }
//
//                                                                    @Override
//                                                                    public void onError(Exception e) {
//                                                                        System.out.println("Exception " + e);
//                                                                    }
//                                                                };
//
//                                                                mySQL.update("posts").set(updates).all(listener5);
//                                                            }
//
//                                                            @Override
//                                                            public void onError(Exception e) {
//                                                                System.out.println("Exception " + e);
//                                                            }
//                                                        };
//
//                                                        HashMap updates = new HashMap();
//                                                        updates.put("content", "This post is best");
//
//                                                        mySQL.update("posts").where(new Cond("title", "==", "Post 1")).set(updates).one(listener4);
//                                                    }
//
//                                                    @Override
//                                                    public void onError(Exception e) {
//                                                        System.out.println("Exception " + e);
//                                                    }
//                                                };
//
//                                                mySQL.get("posts").where(new Cond("author", "==", user.email)).all(listener3);
//                                            }
//
//                                            @Override
//                                            public void onError(Exception e) {
//                                                System.out.println("Exception " + e);
//                                            }
//                                        };
//
//                                        mySQL.get("posts").where(new Cond("title", "==", "Post 1")).one(listener2);
//                                    }
//
//                                    @Override
//                                    public void onError(Exception e) {
//                                        System.out.println("Exception " + e);
//                                    }
//                                };
//
//                                mySQL.insert("posts").all(posts, listener1);
//                            }
//
//                            @Override
//                            public void onError(Exception e) {
//                                System.out.println("Exception " + e);
//                            }
//                        };
//
//                        mySQL.insert("posts").one(new Post("Post 1", user.email, "This is a good post"), listener);
//
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//                        System.out.println("SignIn  Error: " + e.toString());
//                    }
//                };
//                mySQL.signIn("user1@gmail.com","123", signInListener);
//
//            }
//
//            @Override
//            public void onError(Exception e) {
//                System.out.println("Error: " + e.toString());
//            }
//        };
//        mySQL.signUp("user1@gmail.com", "User 1", "123", "user", signUpListener);



        /****************************** Mongo ******************************/
//        API api = new API("test", "http://localhost:8080");
//        Mongo mongo = api.Mongo();
//        Utils.MongoAuthListener signUpListener = new Utils.MongoAuthListener() {
//            @Override
//            public void onResponse(int statusCode, MongoAuthResponse res) {
//                if (statusCode != 200) {
//                    System.out.println("Error in SignUp: " + statusCode);
//                    return;
//                }
//                MongoUser user = res.user;
//                if (!user.email.equals(email) || !user.role.equals(role)) {
//                    System.out.println("Error in SignUp: "  +  user.email.equals(email) + user.role.equals(role));
//                    return;
//                }
//                System.out.println("SignUp Successful");
//
//                Utils.MongoAuthListener signInListener = new Utils.MongoAuthListener() {
//                    @Override
//                    public void onResponse(int statusCode, MongoAuthResponse res) {
//                        if (statusCode != 200) {
//                            System.out.println("Error in SignIn: " + statusCode);
//                            return;
//                        }
//
//                        MongoUser user = res.user;
//                        if (!user.email.equals(email) || !user.role.equals(role) || !user.name.equals(name)|| res.token.length() == 0) {
//                            System.out.println("Error in SignIn");
//                            return;
//                        }
//
//                        api.setToken(res.token);
//
//                        Utils.ResponseListener listener = new Utils.ResponseListener() {
//                            @Override
//                            public void onResponse(int statusCode, Response response) {
//                                if (statusCode != 200) {
//                                    System.out.println("Error in inserting single post: " + statusCode);
//                                    return;
//                                }
//                                System.out.println("Inserting single post successful");
//
//                                Post[] posts = new Post[2];
//                                posts[0] = new Post("Post 2", "user1@gmail.com", "This is a better post");
//                                posts[1] = new Post("Post 3", "user2@gmail.com", "This post is excellent");
//
//                                Utils.ResponseListener listener1 = new Utils.ResponseListener() {
//                                    @Override
//                                    public void onResponse(int statusCode, Response response) {
//                                        if (statusCode != 200) {
//                                            System.out.println("Error in inserting multiple posts: " + statusCode);
//                                            return;
//                                        }
//                                        System.out.println("Inserting multiple posts successful");
//
//                                        Utils.ResponseListener listener2 = new Utils.ResponseListener() {
//                                            @Override
//                                            public void onResponse(int statusCode, Response response) {
//                                                if (statusCode != 200) {
//                                                    System.out.println("Error in reading single post: " + statusCode);
//                                                    return;
//                                                }
//
//                                                Post post = response.getValue(Post.class);
//                                                if (!post.content.equals("This is a good post")) {
//                                                    System.out.println("Error in reading single post");
//                                                    return;
//                                                }
//                                                System.out.println("Get single post successful");
//
//                                                Utils.ResponseListener listener3 = new Utils.ResponseListener() {
//                                                    @Override
//                                                    public void onResponse(int statusCode, Response response) {
//                                                        if (statusCode != 200) {
//                                                            System.out.println("Error in reading multiple post: " + statusCode);
//                                                            return;
//                                                        }
//
//                                                        Post[] posts = response.getValue(Post[].class);
//                                                        if (posts.length != 2) {
//                                                            System.out.println("Error in reading multiple posts");
//                                                            return;
//                                                        }
//                                                        System.out.println("Get multiple posts successful");
//
//                                                        Utils.ResponseListener listener4 = new Utils.ResponseListener() {
//                                                            @Override
//                                                            public void onResponse(int statusCode, Response response) {
//                                                                if (statusCode != 200) {
//                                                                    System.out.println("Error in updating single post: " + statusCode);
//                                                                    return;
//                                                                }
//                                                                System.out.println("Updating single post successful");
//
//                                                                HashMap updates = new HashMap();
//                                                                updates.put("content", "Each post is best in its own way");
//
//                                                                Utils.ResponseListener listener5 = new Utils.ResponseListener() {
//                                                                    @Override
//                                                                    public void onResponse(int statusCode, Response response) {
//                                                                        if (statusCode != 200) {
//                                                                            System.out.println("Error in updating multiple post: " + statusCode);
//                                                                            return;
//                                                                        }
//                                                                        System.out.println("Updating multiple post successful");
//
//                                                                        Utils.ResponseListener listener6 = new Utils.ResponseListener() {
//                                                                            @Override
//                                                                            public void onResponse(int statusCode, Response response) {
//                                                                                if (statusCode != 200) {
//                                                                                    System.out.println("Error in deleting posts: " + statusCode);
//                                                                                    return;
//                                                                                }
//                                                                                System.out.println("Deleting posts successful");
//
//                                                                                Utils.ResponseListener listener7 = new Utils.ResponseListener() {
//                                                                                    @Override
//                                                                                    public void onResponse(int statusCode, Response response) {
//                                                                                        if (statusCode != 200) {
//                                                                                            System.out.println("Error in editing profile: " + statusCode);
//                                                                                            return;
//                                                                                        }
//
//                                                                                        System.out.println("Editing profile successful");
//
//                                                                                        Utils.MongoProfileListener mongoProfileListener = new Utils.MongoProfileListener() {
//                                                                                            @Override
//                                                                                            public void onResponse(int statusCode, MongoUser user) {
//                                                                                                if (statusCode != 200) {
//                                                                                                    System.out.println("Error in fetching profile: " + statusCode);
//                                                                                                    return;
//                                                                                                }
//
//                                                                                                if (!user.name.equals("Jayesh")) {
//                                                                                                    System.out.println("Error in fetching profile");
//                                                                                                    return;
//                                                                                                }
//
//                                                                                                System.out.println("Fetching profile successful");
//
//                                                                                                Utils.MongoProfilesListener mongoProfilesListener = new Utils.MongoProfilesListener() {
//                                                                                                    @Override
//                                                                                                    public void onResponse(int statusCode, MongoUser[] users) {
//                                                                                                        if (statusCode != 200) {
//                                                                                                            System.out.println("Error in fetching profiles: " + statusCode);
//                                                                                                            return;
//                                                                                                        }
//
//                                                                                                        if (users.length != 1 && !(users[0].name.equals("Jayesh"))) {
//                                                                                                            System.out.println("Error in fetching profiles");
//                                                                                                            return;
//                                                                                                        }
//
//                                                                                                        System.out.println("Fetching profiles successful");
//                                                                                                    }
//
//                                                                                                    @Override
//                                                                                                    public void onError(Exception e) {
//                                                                                                        System.out.println("Exception " + e);
//                                                                                                    }
//                                                                                                };
//                                                                                                mongo.profiles(mongoProfilesListener);
//                                                                                            }
//
//                                                                                            @Override
//                                                                                            public void onError(Exception e) {
//                                                                                                System.out.println("Exception " + e);
//                                                                                            }
//                                                                                        };
//
//                                                                                        mongo.profile(user._id, mongoProfileListener);
//                                                                                    }
//
//                                                                                    @Override
//                                                                                    public void onError(Exception e) {
//                                                                                        System.out.println("Exception " + e);
//                                                                                    }
//                                                                                };
//                                                                                mongo.editProfile(user._id, user.email, "Jayesh", "123", listener7);
//
//                                                                            }
//
//                                                                            @Override
//                                                                            public void onError(Exception e) {
//                                                                                System.out.println("Exception " + e);
//                                                                            }
//                                                                        };
//
//                                                                        mongo.delete("posts").where(new Cond("title", "==", "Post 1")).all(listener6);
//                                                                    }
//
//                                                                    @Override
//                                                                    public void onError(Exception e) {
//                                                                        System.out.println("Exception " + e);
//                                                                    }
//                                                                };
//
//                                                                mongo.update("posts").where().set(updates).all(listener5);
//                                                            }
//
//                                                            @Override
//                                                            public void onError(Exception e) {
//                                                                System.out.println("Exception " + e);
//                                                            }
//                                                        };
//
//                                                        HashMap updates = new HashMap();
//                                                        updates.put("content", "This post is best");
//
//                                                        mongo.update("posts").where(new Cond("title", "==", "Post 1")).set(updates).one(listener4);
//                                                    }
//
//                                                    @Override
//                                                    public void onError(Exception e) {
//                                                        System.out.println("Exception " + e);
//                                                    }
//                                                };
//
//                                                mongo.get("posts").where(new Cond("author", "==", user.email)).all(listener3);
//                                            }
//
//                                            @Override
//                                            public void onError(Exception e) {
//                                                System.out.println("Exception " + e);
//                                            }
//                                        };
//
//                                        mongo.get("posts").where(new Cond("title", "==", "Post 1")).one(listener2);
//                                    }
//
//                                    @Override
//                                    public void onError(Exception e) {
//                                        System.out.println("Exception " + e);
//                                    }
//                                };
//
//                                mongo.insert("posts").all(posts, listener1);
//                            }
//
//                            @Override
//                            public void onError(Exception e) {
//                                System.out.println("Exception " + e);
//                            }
//                        };
//
//                        mongo.insert("posts").one(new Post("Post 1", user.email, "This is a good post"), listener);
//
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//                        System.out.println("SignIn  Error: " + e.toString());
//                    }
//                };
//                mongo.signIn("user1@gmail.com","123", signInListener);
//
//            }
//
//            @Override
//            public void onError(Exception e) {
//                System.out.println("Error: " + e.toString());
//            }
//        };
//        mongo.signUp("user1@gmail.com", "User 1", "123", "user", signUpListener);

//        Utils.MongoAuthListener mongoAuthListener = new Utils.MongoAuthListener() {
//            @Override
//            public void onResponse(int statusCode, MongoAuthResponse res) {
//                if (statusCode != 200) {
//                    System.out.println("Error in Signin: " + statusCode);
//                    return;
//                }
//                api.setToken(res.token);
//
//                Utils.ResponseListener responseListener = new Utils.ResponseListener() {
//                    @Override
//                    public void onResponse(int statusCode, Response response) {
//                        System.out.println("Functions Response: " + response.getValue(Object.class));
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//                        System.out.println("Error: " + e.toString());
//                    }
//                };
//                api.call("echo-service", "echo", 5000, "FaaS is awesome!", responseListener);
//            }
//
//            @Override
//            public void onError(Exception e) {
//                System.out.println("Error: " + e.toString());
//            }
//        };
//        mongo.signIn("user1@gmail.com", "123", mongoAuthListener);
//
    }
}
