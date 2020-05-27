package dk.bec.poland.aa.logging.task_two;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task {
  // create a logger here
  private static final Logger log = LogManager.getLogger(Task.class);


    public static void main(String[] args) {
    //  uncomment this line after you created logger
    log.info("This message should appear in the console 1");
    log.debug("This message should not be visible in the console");

    // this should appear on console
    new PersonalLoggerClass().debug();
  }
}
