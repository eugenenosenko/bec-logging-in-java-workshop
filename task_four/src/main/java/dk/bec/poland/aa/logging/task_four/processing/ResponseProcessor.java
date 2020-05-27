package dk.bec.poland.aa.logging.task_four.processing;

import dk.bec.poland.aa.logging.task_four.beans.Response;

public class ResponseProcessor implements Processor {

    @Override
    public boolean process(Response response) {
        switch (response.responseStatus) {
            case ERROR:
                System.err.println("error occurred");
                return false;
            case REDIRECT:
                System.out.println("redirect ocurrred");
                return processRedirect(response);
            case SUCCESS:
                System.out.println("success occurred");
                return processSuccess(response);
        }

        throw new UnsupportedOperationException("error");
    }

    private boolean processSuccess(Response response) {
        if (response.statusCode == 200 && response.response.contains("a")) {
            return true;
        }

        System.out.println("Status code was not 200");
        return false;
    }


    private boolean processRedirect(Response response) {
        if (response.statusCode == 301) {
            return true;
        }

        System.out.println("status was not 301");
        return false;

    }

}
