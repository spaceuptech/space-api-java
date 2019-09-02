import com.spaceuptech.space_api.API;
import com.spaceuptech.space_api.db.Batch;
import com.spaceuptech.space_api.db.DB;
import com.spaceuptech.space_api.utils.*;

import java.util.HashMap;
import java.util.Map;

public class Batch {

    public static void main(String[] args) throws Exception {
        API api = new API("books-app", "localhost", 4124);
        DB db = api.MySQL();
        Batch batch = db.beginBatch();
        Map<String, String> document = new HashMap<>();
        document.put("name", "aBook");
        batch.add(db.insert("books").doc(document));
        HashMap<String, Object> set = new HashMap<>();
        set.put("name", "Book1");
        batch.add(db.update("books").where(new Cond("id", "==", 1)).set(set));
        batch.add(db.delete("books").where(new Cond("id", "==", 1)));
        batch.apply(new ResponseListener() {
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
        while (true) {
        }
    }
}