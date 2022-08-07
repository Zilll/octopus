package logger;

import org.slf4j.LoggerFactory;

public class Logger {
    public static org.slf4j.Logger logger = LoggerFactory.getLogger(new Object() { }.getClass().getSimpleName());
}
