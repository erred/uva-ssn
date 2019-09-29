package com.j256.simplemagic.logger;

import com.j256.simplemagic.logger.Log.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Log implements Log {
    private final Logger logger;

    public Log4j2Log(String str) {
        this.logger = LogManager.getLogger(str);
    }

    public boolean isLevelEnabled(Level level) {
        switch (level) {
            case TRACE:
                return this.logger.isTraceEnabled();
            case DEBUG:
                return this.logger.isDebugEnabled();
            case INFO:
                return this.logger.isInfoEnabled();
            case WARNING:
                return this.logger.isWarnEnabled();
            case ERROR:
                return this.logger.isErrorEnabled();
            case FATAL:
                return this.logger.isFatalEnabled();
            default:
                return this.logger.isInfoEnabled();
        }
    }

    public void log(Level level, String str) {
        switch (level) {
            case TRACE:
                this.logger.trace(str);
                return;
            case DEBUG:
                this.logger.debug(str);
                return;
            case INFO:
                this.logger.info(str);
                return;
            case WARNING:
                this.logger.warn(str);
                return;
            case ERROR:
                this.logger.error(str);
                return;
            case FATAL:
                this.logger.fatal(str);
                return;
            default:
                this.logger.info(str);
                return;
        }
    }

    public void log(Level level, String str, Throwable th) {
        switch (level) {
            case TRACE:
                this.logger.trace(str, th);
                return;
            case DEBUG:
                this.logger.debug(str, th);
                return;
            case INFO:
                this.logger.info(str, th);
                return;
            case WARNING:
                this.logger.warn(str, th);
                return;
            case ERROR:
                this.logger.error(str, th);
                return;
            case FATAL:
                this.logger.fatal(str, th);
                return;
            default:
                this.logger.info(str, th);
                return;
        }
    }
}
