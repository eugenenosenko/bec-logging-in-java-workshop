package dk.bec.poland.aa.logging.task_one;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Task {
    private static final Logger log = LogManager.getLogger(Task.class);

    public static void main(String[] args) throws IOException {
        log.info("Starting Example application...");
        Entity entity = new Entity(10, "number");

        for (int i = 0; i < 15; i++) {
            String randomString = entity.randString();
            if (randomString.startsWith("a")) {

                log.trace("Random string " + randomString + " starts with a; Entity is: " + entity);
            } else if (randomString.startsWith("b")) {

                log.debug("Random string " + randomString + " starts with b; loop counter is " + i);
            } else if (randomString.startsWith("c")) {

                log.info("Random string " + randomString + ";\n starts with c; Entity is: " + entity);
            } else {
                log.warn("couldn't match any conditions after trying 15 times");

            }
        }
    }
}
