package dk.bec.poland.aa.logging.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

final class Example {
    private static final Logger log = LogManager.getLogger(Example.class);

    public static void main(String[] args) {
        log.info("Starting Example application...");
        LogLevelExample logLevelExample = new LogLevelExample();

        logLevelExample.trace();
        logLevelExample.debug();
        logLevelExample.info();
        for (int i = 0; i < 100; i++) {
            logLevelExample.warn();
        }
        logLevelExample.error();
        logLevelExample.fatal();
    }
}
