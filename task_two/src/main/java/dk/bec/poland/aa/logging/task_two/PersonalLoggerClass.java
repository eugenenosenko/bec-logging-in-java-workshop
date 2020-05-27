package dk.bec.poland.aa.logging.task_two;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class PersonalLoggerClass {
  // create a logger here
  private static final Logger log = LogManager.getLogger(PersonalLoggerClass.class);


    void debug() {
    // uncomment this line after you created logger
    log.trace("This message should appear in the console 2");
  }
}
