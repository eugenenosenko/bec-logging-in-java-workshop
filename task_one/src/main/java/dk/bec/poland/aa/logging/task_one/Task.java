package dk.bec.poland.aa.logging.task_one;

import java.io.IOException;

public class Task {
  //TODO:  Create a logger for the class Task here

  public static void main(String[] args) throws IOException {
    Entity entity = new Entity(10, "number");

    for (int i = 0; i < 15; i++) {
      String randomString = entity.randString();
      if (randomString.startsWith("a")) {
        //TODO:  TRACE entity instance
      } else if (randomString.startsWith("b")) {
        //TODO:  DEBUG randomString
      } else if (randomString.startsWith("c")) {
        //TODO: INFO randomString and entity instance
      } else {
        //TODO:  WARN "couldn't match any condition"
      }
    }
  }
}
