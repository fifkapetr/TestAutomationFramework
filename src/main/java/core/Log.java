package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Log {
    private static final Logger logger = LogManager.getLogger("CoreLogger");

    public static void info(String text) {
        logger.info(text);
    }

    public static void warn(String text) {
        logger.warn(text);
    }

    public static void fail(String text, Throwable e) {
        logger.error(text);
        fail(e);
    }

    public static void critical(String text) {
        critical(text, new RuntimeException(text));
    }

    public static void critical(String text, Throwable e) {
        logger.error("CRITICAL: " + text);
        throw new RuntimeException(e);
    }

    public static void fail(Throwable e) {
//        String stackTrace = Arrays.stream(e.getStackTrace())
//                .map(StackTraceElement::toString)
//                .collect(Collectors.joining("\n"));
        logger.error("Test failed.", e);
        throw new RuntimeException(e);
    }

    public static void fail(String text) {
        fail(text, new RuntimeException(text));
    }

    public static void debug(String text) {
        logger.debug(text);
    }

}
