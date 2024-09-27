package dk.bec.poland.aa.logging.task_two;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task {
  private static final Logger log = LogManager.getLogger(Task.class);

  public static void main(String[] args) {
     log.info("This message should appear in the console");
     log.debug("This message should not be visible in the console");

    new PersonalLoggerClass().debug();
  }
}
