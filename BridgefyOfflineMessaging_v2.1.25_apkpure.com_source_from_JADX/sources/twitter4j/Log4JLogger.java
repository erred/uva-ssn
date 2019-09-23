package twitter4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

final class Log4JLogger extends Logger {
    private final Logger LOGGER;

    Log4JLogger(Logger logger) {
        this.LOGGER = logger;
    }

    public boolean isDebugEnabled() {
        return this.LOGGER.isDebugEnabled();
    }

    public boolean isInfoEnabled() {
        return this.LOGGER.isInfoEnabled();
    }

    public boolean isWarnEnabled() {
        return this.LOGGER.isEnabledFor(Level.WARN);
    }

    public boolean isErrorEnabled() {
        return this.LOGGER.isEnabledFor(Level.WARN);
    }

    public void debug(String str) {
        this.LOGGER.debug(str);
    }

    public void debug(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        debug(sb.toString());
    }

    public void info(String str) {
        this.LOGGER.info(str);
    }

    public void info(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        info(sb.toString());
    }

    public void warn(String str) {
        this.LOGGER.warn(str);
    }

    public void warn(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        warn(sb.toString());
    }

    public void error(String str) {
        this.LOGGER.error(str);
    }

    public void error(String str, Throwable th) {
        this.LOGGER.error(str, th);
    }
}
