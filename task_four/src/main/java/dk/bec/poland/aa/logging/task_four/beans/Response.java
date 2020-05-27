package dk.bec.poland.aa.logging.task_four.beans;

import dk.bec.poland.aa.logging.task_four.rest.ResponseStatus;

import java.util.Objects;

public class Response {
    public final ResponseStatus responseStatus;
    public final String response;
    public final int statusCode;

    public Response(ResponseStatus responseStatus, String response, int statusCode) {
        this.responseStatus = responseStatus;
        this.response = response;
        this.statusCode = statusCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response1 = (Response) o;
        return statusCode == response1.statusCode &&
                responseStatus == response1.responseStatus &&
                Objects.equals(response, response1.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseStatus, response, statusCode);
    }

    @Override
    public String toString() {
        return "Response{" +
                "responseStatus=" + responseStatus +
                ", response='" + response + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}
