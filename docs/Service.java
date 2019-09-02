import com.spaceuptech.space_api.API;
import com.spaceuptech.space_api.service.ReturnCallback;
import com.spaceuptech.space_api.service.Service;
import com.spaceuptech.space_api.service.ServiceFunction;
import com.spaceuptech.space_api.utils.Data;
import com.spaceuptech.space_api.utils.Response;
import com.spaceuptech.space_api.utils.ResponseListener;

public class Service {

    public static void main(String[] args) throws Throwable {
        // Start a service
        API api = new API("books-app", "localhost", 4124);

        Service service = api.service("service");
        service.registerFunc("echo_func", new ServiceFunction() {
            @Override
            public void onInvocation(Data params, Data auth, ReturnCallback cb) {
                cb.send("response", params.getValue(Object.class));
            }
        });
        service.start(); // Is blocking

        // Call a function
        API api = new API("books-app", "localhost", 4124);

        ResponseListener responseListener = new ResponseListener() {
            @Override
            public void onResponse(int statusCode, Response response) {
                try {
                    System.out.println("Functions Response: " + response.getResult(Object.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {
                System.out.println("Error: " + e.toString());
            }
        };
        api.call("service", "echo_func", 5000, "FaaS is awesome!", responseListener);
    }
}

