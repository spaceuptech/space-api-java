import com.spaceuptech.space_api.API;
import com.spaceuptech.space_api.utils.*;

import java.io.*;

public class FileMan {
    public static void main(String[] args) {
        // Create Folder
        API api = new API("books-app", "localhost", 4124);
        FileStore fileStore = api.fileStore();

        fileStore.createFolder("\\", "aNewFolder", new Utils.ResponseListener() {
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


        // Delete File
        API api = new API("books-app", "localhost", 4124);
        FileStore fileStore = api.fileStore();

        fileStore.deleteFile("\\aNewFolder", new Utils.ResponseListener() {
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


        // List Files
        API api = new API("books-app", "localhost", 4124);
        FileStore fileStore = api.fileStore();

        fileStore.listFiles("\\", new Utils.ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                System.out.println(statusCode);
                if (statusCode == 200) {
                    try {
                        Map[] files = response.getResults(Map[].class);
                        for (Map file : files) {
                            System.out.println("Name: " + file.get("name"));
                            System.out.println("Type: " + file.get("type"));
                        }
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


        // Upload File
        API api = new API("books-app", "localhost", 4124);
        FileStore fileStore = api.fileStore();
        InputStream inputStream = new FileInputStream("input.txt");
        fileStore.uploadFile("\\", "file.txt", inputStream, new Utils.ResponseListener() {
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


        // Download File
        API api = new API("books-app", "localhost", 4124);
        FileStore fileStore = api.fileStore();
        OutputStream outputStream = new FileOutputStream("output.txt";);
        fileStore.downloadFile("\\file.txt", outputStream, new Utils.ResponseListener() {
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