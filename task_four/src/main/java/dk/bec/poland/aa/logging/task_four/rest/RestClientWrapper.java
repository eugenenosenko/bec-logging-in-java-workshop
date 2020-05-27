package dk.bec.poland.aa.logging.task_four.rest;

import dk.bec.poland.aa.logging.task_four.beans.Response;

import java.util.HashMap;
import java.util.Map;

public class RestClientWrapper {

    private final Map<String, String> headers = new HashMap<>();
    private final UrlConnectionHandler urlConnectionHandler;
    private final String baseUrl;

    public RestClientWrapper(String baseUrl) {
        this.urlConnectionHandler = new UrlConnectionHandler(baseUrl);
        this.baseUrl = baseUrl;
    }

    public RestClientWrapper(String baseUrl, Map<String, String> headers) {
        this.urlConnectionHandler = new UrlConnectionHandler(baseUrl);
        this.headers.putAll(headers);
        this.baseUrl = baseUrl;
    }

    public RestClientWrapper(UrlConnectionHandler urlConnectionHandler, String baseUrl, Map<String, String> headers) {
        this.urlConnectionHandler = urlConnectionHandler;
        this.baseUrl = baseUrl;
        this.headers.putAll(headers);
    }

    public Response get(String endpoint) {
        return urlConnectionHandler.doHttp(endpoint, "GET", headers);
    }

    public Response post(String endpoint, String body) {
        return urlConnectionHandler.doHttp(endpoint, "POST", headers);

    }

    public Response put(String endpoint, String body) {
        return urlConnectionHandler.doHttp(endpoint, "PUT", headers);

    }

    public Response delete(String endpoint) {
        return urlConnectionHandler.doHttp(endpoint, "DELETE", headers);
    }
}
