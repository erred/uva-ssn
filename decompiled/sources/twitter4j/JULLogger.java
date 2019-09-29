package twitter4j;

import java.util.logging.Level;
import java.util.logging.Logger;

final class JULLogger extends Logger {
    private final Logger LOGGER;

    JULLogger(Logger logger) {
        this.LOGGER = logger;
    }

    public boolean isDebugEnabled() {
        return this.LOGGER.isLoggable(Level.FINE);
    }

    public boolean isInfoEnabled() {
        return this.LOGGER.isLoggable(Level.INFO);
    }

    public boolean isWarnEnabled() {
        return this.LOGGER.isLoggable(Level.WARNING);
    }

    public boolean isErrorEnabled() {
        return this.LOGGER.isLoggable(Level.SEVERE);
    }

    public void debug(String str) {
        this.LOGGER.fine(str);
    }

    public void debug(String str, String str2) {
        // Logger logger = this.LOGGER;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        logger.fine(sb.toString());
    }

    public void info(String str) {
        this.LOGGER.info(str);
    }

    public void info(String str, String str2) {
        // Logger logger = this.LOGGER;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        logger.info(sb.toString());
    }

    public void warn(String str) {
        this.LOGGER.warning(str);
    }

    public void warn(String str, String str2) {
        // Logger logger = this.LOGGER;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        logger.warning(sb.toString());
    }

    public void error(String str) {
        this.LOGGER.severe(str);
    }

    public void error(String str, Throwable th) {
        // Logger logger = this.LOGGER;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(th.getMessage());
        logger.severe(sb.toString());
    }
}
