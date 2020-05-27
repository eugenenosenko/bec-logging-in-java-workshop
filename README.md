# BEC - Automation Academy [Logging in Java]

## Checkout out the project
1. Clone repository from [GitHub](https://github.com/eugenenosenko/bec-logging-in-java-workshop.git)
2. For each `Task` create your new branch from master. Branch should follow naming convention `<YOUR_NAME>/task-<TASK_NUMBER>` i.e. `<eugene/task-1>`
3. After solving the task create a pull request to master branch

## Before starting
Check `example` module :
- Examine how different log levels are used in [LogLevelExample.java](example/src/main/java/dk/bec/poland/aa/logging/example/LogLevelExample.java)
- Check project's [pom.xml](example/pom.xml) and `log4j2.xml` configuration [log4j2.xml](example/src/main/java/dk/bec/poland/aa/logging/example/LogLevelExample.java)
- Run [Example.main()](example/src/main/java/dk/bec/poland/aa/logging/example/Example.java) and see what log messages printed

## Task 1
- Create a simple [log4j2.xml](task_one/src/main/resources/log4j2.xml) configuration for the module with the following:
    * Console appender 
    * Root logger with level set to `trace` 
- Create a loggers in [Entity.java](task_one/src/main/java/dk/bec/poland/aa/logging/task_one/Entity.java) and in [Task.java](task_one/src/main/java/dk/bec/poland/aa/logging/task_one/Task.java) and complete all `TODOs`

## Task 2
- Add `log4j2` dependencies to [pom.xml](task_two/pom.xml)
- Create a new [log4j2.xml](task_two/src/main/resources/log4j2.xml) configuration which should have the following configuration
  * Console appender
  * Logger for class `PersonalLoggerClass` with level set to `trace`
  * Root logger with level set to info 
- Complete all `TODOs` in [PersonalLoggerClass.java](task_two/src/main/java/dk/bec/poland/aa/logging/task_two/PersonalLoggerClass.java) and in [Task.java](task_two/src/main/java/dk/bec/poland/aa/logging/task_two/Task.java)

## Task 3
- Create a new [log4j2.xml](task_three/src/main/resources/log4j2.xml) configuration which should have the following configuration
    * Console appender 
    * Create two File appenders for files `output.log` and `output1.log`
    * Create two loggers, first logger should log items in [file](task_three/src/main/java/dk/bec/poland/aa/logging/task_three/file) folder to `output.log` with `trace` level 
    * Second logger should log items in [file_two](task_three/src/main/java/dk/bec/poland/aa/logging/task_three/file_two) folder to file `output1.log` with level `info` and to console with level `debug` 
    * Create a third logger for [SharedLogToFile.java](task_three/src/main/java/dk/bec/poland/aa/logging/task_three/SharedLogToFile.java) that will log to both files and console
- Create loggers in and complete `TODOs` [Task.java](task_three/src/main/java/dk/bec/poland/aa/logging/task_three/Task.java), [SharedLogToFile.java](task_three/src/main/java/dk/bec/poland/aa/logging/task_three/SharedLogToFile.java) and for classes in [file_two](task_three/src/main/java/dk/bec/poland/aa/logging/task_three/file_two) folder and in [file](task_three/src/main/java/dk/bec/poland/aa/logging/task_three/file) folder
- Run  [Task.main()](task_three/src/main/java/dk/bec/poland/aa/logging/task_three/Task.java) and check the result

## Task 4
- Create a new `log4j2.xml` in [task_four](task_four/src/main/resources) configuration which should have:
    * console appender
    * rolling file appender or file appender
    * root logger with `info` level
    * logger for everything in [processing](task_four/src/main/java/dk/bec/poland/aa/logging/task_four/processing) folder that will log to file
    * Logger for [RestClientWrapper.java](task_four/src/main/java/dk/bec/poland/aa/logging/task_four/rest/RestClientWrapper.java) that will log starting from `debug` level
- Replace all `System.out.println` and `System.err.println` with loggers
- Add additional logging wherever you seem it is appropriate

## Task 5
- Add a new a log4j2 configuration but this time using `.properties` file instead of `xml` configuration; 
- Example configuration can be found here [log4j2.properties](example/src/main/resources/example-log4j2.properties)
