package dk.bec.poland.aa.logging.task_one;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Task {
  //TODO:  Create a logger for the class Task here
  private static final Logger log = LogManager.getLogger(Task.class);

  public static void main(String[] args) throws IOException {
    log.info("Starting Example application...");
    Entity entity = new Entity(10, "number");

    for (int i = 0; i < 15; i++) {
      String randomString = entity.randString();
      if (randomString.startsWith("a")) {
        //TODO:  TRACE entity instance
        log.trace("entity instance");
      } else if (randomString.startsWith("b")) {
        //TODO:  DEBUG randomString
        log.debug("randomString");
      } else if (randomString.startsWith("c")) {
        //TODO: INFO randomString and entity instance
        log.info("randomString and entity instance");
      } else {
        log.warn("couldn't match any condition");
        //TODO:  WARN "couldn't match any condition"
      }
    }
  }
}
