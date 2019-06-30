import com.spaceuptech.space_api.API;
import com.spaceuptech.space_api.sql.SQL;
import com.spaceuptech.space_api.mongo.Mongo;
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

        // Get One
        API api = new API("books-app", "localhost", 8081);
        SQL db = api.MySQL();
        db.getOne("books").apply(new Utils.ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    try {
                        Book b = response.getResult(Book.class);
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

        // Get One Conditional
        API api = new API("books-app", "localhost", 8081);
        SQL db = api.MySQL();
        db.getOne("books").where(new Cond("id", "==", 1)).apply(new Utils.ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    try {
                        Book b = response.getResult(Book.class);
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

        // Get all
        API api = new API("books-app", "localhost", 8081);
        SQL db = api.MySQL();
        db.get("books").where(new Cond("author", "==", "myself")).apply(new Utils.ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    try {
                        Book[] books = response.getResults(Book[].class);
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

        // Distinct
        API api = new API("books-app", "localhost", 8081);
        Mongo db = api.Mongo();
        db.distinct("books").apply(new Utils.ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if(statusCode==200) {
                    try {
                        Book[] books = response.getResults(Book[].class);
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

        // Count
        API api = new API("books-app", "localhost", 8081);
        Mongo db = api.Mongo();
        db.count("books").apply(new Utils.ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if(statusCode==200) {
                    try {
                        Book[] books = response.getResults(Book[].class);
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

        // Get Multiple Conditions
        API api = new API("books-app", "localhost", 8081);
        SQL db = api.MySQL();
        db.get("books").where(Or.create(new Cond("author", "==", "myself"), new Cond("author", "==", "someAuthor"))).apply(new Utils.ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    try {
                        Book[] books = response.getResults(Book[].class);
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

        // Select
        API api = new API("books-app", "localhost", 8081);
        SQL db = api.MySQL();
        HashMap<String, Integer> select = new HashMap<>();
        select.put("name", 1);
        db.get("books").select(select).apply(new Utils.ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    try {
                        Book[] books = response.getResults(Book[].class);
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

        // Sort
        API api = new API("books-app", "localhost", 8081);
        SQL db = api.MySQL();
        db.get("books").sort("id", "-name").apply(new Utils.ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    try {
                        Book[] books = response.getResults(Book[].class);
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

        // Skip
        API api = new API("books-app", "localhost", 8081);
        SQL db = api.MySQL();
        db.get("books").skip(2).apply(new Utils.ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    try {
                        Book[] books = response.getResults(Book[].class);
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

        // Limit
        API api = new API("books-app", "localhost", 8081);
        SQL db = api.MySQL();
        db.get("books").limit(2).apply(new Utils.ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                if (statusCode == 200) {
                    try {
                        Book[] books = response.getResults(Book[].class);
                        System.out.println(books);
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