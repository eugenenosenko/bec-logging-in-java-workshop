package dk.bec.poland.aa.logging.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

final class LogLevelExample {
  private static final Logger log = LogManager.getLogger(LogLevelExample.class);

  // Trace information is rarely important
  // and is useful when debugging low level bugs
  void trace() {
    String a = "a";
    String b = "b";

    log.trace("Adding two items {} and {}", a, b);
    String result = add(a, b);
  }

  // Debug information should contain useful information
  // when you are expected bugs in your piece of code
  void debug() {
    String a = "a";
    String b = "b";

    String result = add(a, b);
    log.debug("Result for adding operation is {} ", result);
  }

  // Info information contains general event data
  // and or application state
  void info() {
    if (navigateToHomePage()) {
      log.info("User navigated back to home page");
    } else {
      log.info("User wasn't able to navigate back to home page");
    }
  }

  // Warn information should contain suspicious behaviour,
  // for example application has entered a defensive 'if' statement
  void warn() {
    if (!logoutUser()) {
      forceLogout();
    }
  }

  void forceLogout() {
    log.warn("Regular logout failed. Trying to force logout user");
  }

  // Error information contains information about the application's
  // state when an exception occurs, whether caught or rethrown
  void error() {
    if (!loginUser()) {
      log.error("Failed to login user. Will retry");
      loginUser();
    }
  }

  // Fatal information contains all the necessary information
  // about the program before it crashes or is shut down
  void fatal() {
    long timeMillis = System.currentTimeMillis();
    try {
      methodThatCanCauseException(timeMillis);
    } catch (IllegalStateException e) {
      log.fatal(
          "Application crashed after [methodThatCanCauseException] threw exception with {} argument ",
          timeMillis);
      System.exit(1);
    }
  }

  String add(String a, String b) {
    return a + " " + b;
  }

  boolean loginUser() {
    return isTrue();
  }

  boolean logoutUser() {
    return isTrue();
  }

  boolean navigateToHomePage() {
    return isTrue();
  }

  private boolean isTrue() {
    return System.currentTimeMillis() % 2 == 0;
  }

  int methodThatCanCauseException(long value) throws IllegalStateException {
    if (value % 2 == 0) {
      throw new IllegalStateException("Unexpected state");
    }
    return 0;
  }
}
