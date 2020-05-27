package dk.bec.poland.aa.logging.task_three;

import dk.bec.poland.aa.logging.task_three.file.ShouldLogToFile;
import dk.bec.poland.aa.logging.task_three.file.ShouldLogToFile2;
import dk.bec.poland.aa.logging.task_three.file_two.ShouldLogToFile3;

public class Task {
  // TODO: add Logger here

  public static void main(String[] args) {
    // TODO: uncomment after creating logger
    // log.info("Running Task application...);

    new ShouldLogToFile().trace();
    new ShouldLogToFile2().info();
    new ShouldLogToFile3().debug();
    new SharedLogToFile().debug();
  }
}
