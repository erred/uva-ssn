package twitter4j;

import org.apache.commons.logging.Log;

final class CommonsLoggingLogger extends Logger {
    private final Log LOGGER;

    CommonsLoggingLogger(Log log) {
        this.LOGGER = log;
    }

    public boolean isDebugEnabled() {
        return this.LOGGER.isDebugEnabled();
    }

    public boolean isInfoEnabled() {
        return this.LOGGER.isInfoEnabled();
    }

    public boolean isWarnEnabled() {
        return this.LOGGER.isWarnEnabled();
    }

    public boolean isErrorEnabled() {
        return this.LOGGER.isErrorEnabled();
    }

    public void debug(String str) {
        this.LOGGER.debug(str);
    }

    public void debug(String str, String str2) {
        Log log = this.LOGGER;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        log.debug(sb.toString());
    }

    public void info(String str) {
        this.LOGGER.info(str);
    }

    public void info(String str, String str2) {
        Log log = this.LOGGER;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        log.info(sb.toString());
    }

    public void warn(String str) {
        this.LOGGER.warn(str);
    }

    public void warn(String str, String str2) {
        Log log = this.LOGGER;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        log.warn(sb.toString());
    }

    public void error(String str) {
        this.LOGGER.error(str);
    }

    public void error(String str, Throwable th) {
        this.LOGGER.error(str, th);
    }
}
