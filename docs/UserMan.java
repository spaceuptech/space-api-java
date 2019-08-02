import com.spaceuptech.space_api.API;
import com.spaceuptech.space_api.db.DB;
import com.spaceuptech.space_api.utils.*;

import java.util.Map;

public class Get {
    public static void main(String[] args) {
        // Sign Up
        API api = new API("books-app", "localhost", 4124);
        DB db = api.MySQL();
        db.signUp("email", "name", "password", "role", new Utils.ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    try {
                        System.out.println("Token: " + response.getResult(Map.class).get("token"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(response.getError());
                }
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getMessage());
            }
        });

        // Sign In
        API api = new API("books-app", "localhost", 4124);
        DB db = api.MySQL();
        db.signIn("email", "password", new Utils.ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    try {
                        System.out.println("Token: " + response.getResult(Map.class).get("token"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(response.getError());
                }
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getMessage());
            }
        });

        // Profile
        API api = new API("books-app", "localhost", 4124);
        DB db = api.MySQL();
        db.profile("userId", new Utils.ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if(statusCode == 200) {
                    try {
                        System.out.println(response.getResult(Map.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(response.getError());
                }
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getMessage());
            }
        });

        // Profiles
        API api = new API("books-app", "localhost", 4124);
        DB db = api.MySQL();
        db.profiles(new Utils.ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    try {
                        Gson gson = new Gson();
                        System.out.println(gson.fromJson(response.getResults(Map[].class));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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
}