package dk.bec.poland.aa.logging.task_four.processing;

import dk.bec.poland.aa.logging.task_four.beans.Response;

public interface Processor {
    boolean process(Response response);
}
