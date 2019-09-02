import com.spaceuptech.space_api.API;
import com.spaceuptech.space_api.db.*;
import com.spaceuptech.space_api.realtime.LiveData;
import com.spaceuptech.space_api.realtime.LiveDataListener;
import com.spaceuptech.space_api.realtime.LiveQuerySubscription;
import com.spaceuptech.space_api.realtime.LiveQueryOptions;
import com.spaceuptech.space_api.utils.Data;

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
        // WITH DEFAULT OPTIONS
        API api = new API("books-app", "localhost", 4124);
        DB db = api.MySQL();
        LiveQuerySubscription subscription = db.liveQuery("books").subscribe(new LiveDataListener() {
            @Override
            public void onSnapshot(LiveData data, String type, Data changedData) {
                System.out.println(type);
                for (Book book : data.getValue(Book.class)) {
                    System.out.printf("ID:%d, Name:%s, Author:%s\n", book.getId(), book.getName(), book.getAuthor());
                }
                Book book = changedData.getValue(Book.class);
                if (book != null) {
                    System.out.println("CHANGED: ");
                    System.out.printf("ID:%d, Name:%s, Author:%s\n", book.getId(), book.getName(), book.getAuthor());
                    System.out.println();
                }
                System.out.println();
            }

            @Override
            public void onError(String error) {
                System.out.println(error);
            }
        });

        // After some condition
        subscription.unsubscribe();


        // WITH ADDITIONAL OPTIONS
        API api = new API("books-app", "localhost", 4124);
        DB db = api.MySQL();
        LiveQuerySubscription subscription = db.liveQuery("books")
                .options(LiveQueryOptions.Builder().setChangesOnly(false)).subscribe(new LiveDataListener() {
                    @Override
                    public void onSnapshot(LiveData data, String type, Data changedData) {
                        System.out.println(type);
                        for (Book book : data.getValue(Book.class)) {
                            System.out.printf("ID:%d, Name:%s, Author:%s\n", book.getId(), book.getName(), book.getAuthor());
                        }
                        Book book = changedData.getValue(Book.class);
                        if (book != null) {
                            System.out.println("CHANGED: ");
                            System.out.printf("ID:%d, Name:%s, Author:%s\n", book.getId(), book.getName(), book.getAuthor());
                            System.out.println();
                        }
                        System.out.println();
                    }

                    @Override
                    public void onError(String error) {
                        System.out.println(error);
                    }
                });
        // To view the current snapshot
        LiveData snapshot = subscription.getSnapshot();
        // After some condition
        subscription.unsubscribe();
    }
}
