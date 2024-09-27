package dk.bec.poland.aa.logging.task_two;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.dc.path.PathError;

class PersonalLoggerClass {
  private static final Logger log = LogManager.getLogger(PersonalLoggerClass.class);

  void debug() {
     log.trace("This message should appear in the console");
  }
}
