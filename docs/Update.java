import com.spaceuptech.space_api.API;
import com.spaceuptech.space_api.db.DB;
import com.spaceuptech.space_api.db.Mongo;
import com.spaceuptech.space_api.utils.*;

public class Get {
    public static void main(String[] args) {
        class Book {
            private int id;
            private String name, author;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }
        }

        // Update
        API api = new API("books-app", "localhost", 4124);
        DB db = api.MySQL();
        HashMap<String, Object> set = new HashMap<>();
        set.put("name", "Book1");
        db.update("books").where(new Cond("id", "==", 1)).set(set).apply(new ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    System.out.println("Success");
                } else {
                    System.out.println(response.getError());
                }
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getMessage());
            }
        });

        // Update One
        API api = new API("books-app", "localhost", 4124);
        DB db = api.MySQL();
        HashMap<String, Object> set = new HashMap<>();
        set.put("name", "Book1");
        db.updateOne("books").where(new Cond("id", "==", 1)).set(set).apply(new ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    System.out.println("Success");
                } else {
                    System.out.println(response.getError());
                }
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getMessage());
            }
        });

        // Upsert
        API api = new API("books-app", "localhost", 4124);
        Mongo db = api.Mongo();
        HashMap<String, Object> set = new HashMap<>();
        set.put("name", "Book1");
        db.upsert("books").where(new Cond("id", "==", 1)).set(set).apply(new ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    System.out.println("Success");
                } else {
                    System.out.println(response.getError());
                }
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getMessage());
            }
        });

        // Update Multiple Conditions
        API api = new API("books-app", "localhost", 4124);
        DB db = api.MySQL();
        HashMap<String, Object> set = new HashMap<>();
        set.put("name", "Book1");
        db.update("books").where(Or.create(new Cond("id", "==", 1), new Cond("name", "==", "aBook"))).set(set).apply(new ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    System.out.println("Success");
                } else {
                    System.out.println(response.getError());
                }
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getMessage());
            }
        });

        // Push
        API api = new API("books-app", "localhost", 4124);
        Mongo db = api.Mongo();
        HashMap<String, Object> push = new HashMap<>();
        push.put("name", "Book1");
        db.update("books").where(new Cond("id", "==", 1)).push(push).apply(new ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    System.out.println("Success");
                } else {
                    System.out.println(response.getError());
                }
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getMessage());
            }
        });

        // Remove
        API api = new API("books-app", "localhost", 4124);
        Mongo db = api.Mongo();
        db.update("books").where(new Cond("id", "==", 1)).remove("author").apply(new ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    System.out.println("Success");
                } else {
                    System.out.println(response.getError());
                }
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getMessage());
            }
        });

        // Rename
        API api = new API("books-app", "localhost", 4124);
        Mongo db = api.Mongo();
        HashMap<String, Object> rename = new HashMap<>();
        rename.put("name", "bookName");
        db.update("books").where(new Cond("id", "==", 1)).rename(rename).apply(new ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    System.out.println("Success");
                } else {
                    System.out.println(response.getError());
                }
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getMessage());
            }
        });

        // Increment
        API api = new API("books-app", "localhost", 4124);
        Mongo db = api.Mongo();
        HashMap<String, Object> increment = new HashMap<>();
        increment.put("likes", 1);
        db.update("books").where(new Cond("id", "==", 1)).inc(increment).apply(new ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    System.out.println("Success");
                } else {
                    System.out.println(response.getError());
                }
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getMessage());
            }
        });

        // Multiply
        API api = new API("books-app", "localhost", 4124);
        Mongo db = api.Mongo();
        HashMap<String, Object> mul = new HashMap<>();
        mul.put("likes", 2);
        db.update("books").where(new Cond("id", "==", 1)).mul(mul).apply(new ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    System.out.println("Success");
                } else {
                    System.out.println(response.getError());
                }
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getMessage());
            }
        });

        // Max
        API api = new API("books-app", "localhost", 4124);
        Mongo db = api.Mongo();
        HashMap<String, Object> max = new HashMap<>();
        max.put("likes", 100);
        db.update("books").where(new Cond("id", "==", 1)).max(max).apply(new ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    System.out.println("Success");
                } else {
                    System.out.println(response.getError());
                }
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getMessage());
            }
        });

        // Min
        API api = new API("books-app", "localhost", 4124);
        Mongo db = api.Mongo();
        HashMap<String, Object> min = new HashMap<>();
        min.put("likes", 100);
        db.update("books").where(new Cond("id", "==", 1)).min(min).apply(new ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    System.out.println("Success");
                } else {
                    System.out.println(response.getError());
                }
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getMessage());
            }
        });

        // Current Timestamp
        API api = new API("books-app", "localhost", 4124);
        Mongo db = api.Mongo();
        db.update("books").where(new Cond("id", "==", 1)).currentTimestamp("last_read").apply(new ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    System.out.println("Success");
                } else {
                    System.out.println(response.getError());
                }
            }

            @Override
            public void onError(Exception e) {
                System.out.println(e.getMessage());
            }
        });

        // Current Date
        API api = new API("books-app", "localhost", 4124);
        Mongo db = api.Mongo();
        db.update("books").where(new Cond("id", "==", 1)).currentDate("last_read").apply(new ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    System.out.println("Success");
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