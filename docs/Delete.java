import com.spaceuptech.space_api.API;
import com.spaceuptech.space_api.db.DB;
import com.spaceuptech.space_api.utils.condition.*;
import com.spaceuptech.space_api.utils.ResponseListener;
import com.spaceuptech.space_api.utils.Response;

public class Delete {
    public static void main(String[] args) {
        // Delete one
        API api = new API("books-app", "localhost", 4124);
        DB db = api.MySQL();
        db.deleteOne("books").apply(new ResponseListener() {
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

        // Delete all
        API api = new API("books-app", "localhost", 4124);
        DB db = api.MySQL();
        db.delete("books").apply(new ResponseListener() {
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

        // Delete where
        API api = new API("books-app", "localhost", 4124);
        DB db = api.MySQL();
        db.delete("books").where(new Cond("name", "==", "aBook")).apply(new ResponseListener() {
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

        // Delete multiple conditions
        API api = new API("books-app", "localhost", 4124);
        DB db = api.MySQL();
        db.delete("books").where(And.create(new Cond("name", "==", "aBook"), new Cond("author", "==", "myelf"))).apply(new ResponseListener() {
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