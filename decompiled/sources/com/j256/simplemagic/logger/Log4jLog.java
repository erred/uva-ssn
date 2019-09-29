package com.j256.simplemagic.logger;

import com.j256.simplemagic.logger.Log.Level;
import org.apache.log4j.Logger;

public class Log4jLog implements Log {
    private final Logger logger;

    public Log4jLog(String str) {
        this.logger = Logger.getLogger(str);
    }

    public boolean isLevelEnabled(Level level) {
        return this.logger.isEnabledFor(levelToLog4jLevel(level));
    }

    public void log(Level level, String str) {
        this.logger.log(levelToLog4jLevel(level), str);
    }

    public void log(Level level, String str, Throwable th) {
        this.logger.log(levelToLog4jLevel(level), str, th);
    }

    private org.apache.log4j.Level levelToLog4jLevel(Level level) {
        switch (level) {
            case TRACE:
                return org.apache.log4j.Level.TRACE;
            case DEBUG:
                return org.apache.log4j.Level.DEBUG;
            case INFO:
                return org.apache.log4j.Level.INFO;
            case WARNING:
                return org.apache.log4j.Level.WARN;
            case ERROR:
                return org.apache.log4j.Level.ERROR;
            case FATAL:
                return org.apache.log4j.Level.FATAL;
            default:
                return org.apache.log4j.Level.INFO;
        }
    }
}
