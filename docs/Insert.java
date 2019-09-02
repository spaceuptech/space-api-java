import com.spaceuptech.space_api.API;
import com.spaceuptech.space_api.db.DB;
import com.spaceuptech.space_api.utils.*;

import java.util.HashMap;
import java.util.Map;

public class Insert {
    public static void main(String[] args) {
        // Insert one
        API api = new API("books-app", "localhost", 4124);
        DB db = api.MySQL();
        Map<String, String> document = new HashMap<>();
        document.put("name", "aBook");
        db.insert("books").doc(document).apply(new ResponseListener() {
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