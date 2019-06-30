import com.spaceuptech.space_api.API;
import com.spaceuptech.space_api.sql.SQL;
import com.spaceuptech.space_api.utils.*;

import java.util.concurrent.CountDownLatch;

public class LiveQuery {

    static class Book {
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

    public static void main(String[] args) throws Throwable {
        API api = new API("books-app", "localhost", 8081);
        SQL db = api.MySQL();
        LiveQueryUnsubscribe unsubscribe = db.liveQuery("books").subscribe(new LiveDataListener() {
            @Override
            public void onSnapshot(LiveData data, String type) {
                System.out.println(type);
                for (Book book : data.getValue(Book.class)) {
                    System.out.printf("ID:%d, Name:%s, Author:%s\n", book.getId(), book.getName(), book.getAuthor());
                }
                System.out.println();
            }

            @Override
            public void onError(String error) {
                System.out.println(error);
            }
        });

        // After some condition
        unsubscribe.unsubscribe();
    }
}
