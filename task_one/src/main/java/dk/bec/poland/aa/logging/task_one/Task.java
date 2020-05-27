package dk.bec.poland.aa.logging.task_one;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Task {
  //TODO:  Create a logger for the class Task here
  private static final Logger Log = LogManager.getLogger(Task.class);

  public static void main(String[] args) throws IOException {
    Entity entity = new Entity(10, "number");

    for (int i = 0; i < 100; i++) {
      String randomString = entity.randString();
      if (randomString.startsWith("a")) {
        //TODO:  TRACE entity instance
        Log.trace("Entity is ===> "+ entity);
      } else if (randomString.startsWith("b")) {
        Log.debug(randomString);
        //TODO:  DEBUG randomString
      } else if (randomString.startsWith("c")) {
        //TODO: INFO randomString and entity instance
        Log.info("Randomstring = [" + randomString + "]; Entity = " + entity);
      } else {
        //TODO:  WARN "couldn't match any condition"
        Log.warn("couldn't match any condition");
      }
    }
  }
}
