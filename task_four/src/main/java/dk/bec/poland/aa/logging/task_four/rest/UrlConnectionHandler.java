package dk.bec.poland.aa.logging.task_four.rest;

import dk.bec.poland.aa.logging.task_four.beans.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Map;

public final class UrlConnectionHandler {
    private final String url;

    public UrlConnectionHandler(String url) {
        this.url = url;
    }

    public Response doHttp(String endpoint, String method, Map<String, String> headers) {
        return doHttp(endpoint, method, headers, createUrlConnection(endpoint, method, headers));

    }

    public Response doHttp(String endpoint, String method, Map<String, String> headers, HttpURLConnection urlConnection) {
        try {
            System.out.println("doHttp");
            int responseCode = urlConnection.getResponseCode();
            String rawResponse = readResponse(urlConnection);
            ResponseStatus status;

            if (responseCode >= 200 && responseCode < 300) {
                System.out.println("success");
                status = ResponseStatus.SUCCESS;
            } else if (responseCode >= 300 && responseCode < 400) {
                System.out.println("redirect");
                status = ResponseStatus.REDIRECT;
            } else if (responseCode >= 400 && responseCode < 500) {
                status = ResponseStatus.ERROR;
            } else {
                System.err.println("Server error occurred");
                throw new RuntimeException("Error 5xx");
            }

            return new Response(status, rawResponse, responseCode);
        } catch (ConnectException e) {
            try {
                return doHttp(endpoint, method, headers, createConnectionWithProxy(endpoint, method, headers));
            } catch (Exception exception) {
                System.err.println("failed with proxy");
                throw new RuntimeException("failed");
            }

        } catch (IOException e) {
            System.err.println("Error ocurred");
            throw new RuntimeException("IO exception");
        }

    }

    private HttpURLConnection createConnectionWithProxy(String endpoint, String method, Map<String, String> headers) {
        Proxy proxy = createProxy();
        HttpURLConnection urlConnection;
        try {
            urlConnection = (HttpURLConnection) new URL(url + endpoint).openConnection(proxy);
            headers.forEach(urlConnection::setRequestProperty);
            urlConnection.setRequestMethod(method);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return urlConnection;
    }


    private Proxy createProxy() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress("bluecoat-vip.bec.dk", 80));
    }


    private String readResponse(HttpURLConnection urlConnection) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            String response;

            while ((response = reader.readLine()) != null) {
                sb.append(response);
            }

        } catch (IOException e) {
            System.err.println("Error ocurred");
        }

        return sb.toString();
    }


    private HttpURLConnection createUrlConnection(String endpoint, String method, Map<String, String> headers) {
        HttpURLConnection urlConnection;
        try {
            urlConnection = (HttpURLConnection) new URL(url + endpoint).openConnection();
            headers.forEach(urlConnection::setRequestProperty);
            urlConnection.setRequestMethod(method);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return urlConnection;
    }

}
