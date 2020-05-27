package dk.bec.poland.aa.logging.task_one;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Task {

  private static final Logger log = LogManager.getLogger(Task.class);

  public static void main(String[] args) throws IOException {
    Entity entity = new Entity(10, "number");

    for (int i = 0; i < 15; i++) {
      String randomString = entity.randString();
      if (randomString.startsWith("a")) {
        log.trace("Random String starts with a");
      } else if (randomString.startsWith("b")) {
        log.debug("Random String starts with b");
      } else if (randomString.startsWith("c")) {
        log.info("Random String starts with c");
      } else {
        log.warn("couldn't match any condition");
      }
    }
  }
}
