package dk.bec.poland.aa.logging.task_four;

import dk.bec.poland.aa.logging.task_four.beans.Response;
import dk.bec.poland.aa.logging.task_four.rest.RestClientWrapper;

import java.util.HashMap;
import java.util.Map;

public class Task {
    private static final String URL = "http://random-word-api.herokuapp.com";

    public static void main(String[] args) {
        System.out.println("Starting application...");

        RestClientWrapper restClientWrapper = createRestClientWrapper();
        Response response = restClientWrapper.get("/word?number=10");

        System.out.println("response = " + response);

    }

    static RestClientWrapper createRestClientWrapper() {
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "Mozilla/5.0");
        return new RestClientWrapper(URL, headers);
    }
}
