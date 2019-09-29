package twitter4j;

import java.io.PrintStream;
import java.util.Date;
import twitter4j.conf.ConfigurationContext;

final class StdOutLogger extends Logger {
    private static final boolean DEBUG = ConfigurationContext.getInstance().isDebugEnabled();

    public boolean isErrorEnabled() {
        return true;
    }

    public boolean isInfoEnabled() {
        return true;
    }

    public boolean isWarnEnabled() {
        return true;
    }

    StdOutLogger() {
    }

    public boolean isDebugEnabled() {
        return DEBUG;
    }

    public void debug(String str) {
        if (DEBUG) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(new Date());
            sb.append("]");
            sb.append(str);
            printStream.println(sb.toString());
        }
    }

    public void debug(String str, String str2) {
        if (DEBUG) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            debug(sb.toString());
        }
    }

    public void info(String str) {
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(new Date());
        sb.append("]");
        sb.append(str);
        printStream.println(sb.toString());
    }

    public void info(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        info(sb.toString());
    }

    public void warn(String str) {
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(new Date());
        sb.append("]");
        sb.append(str);
        printStream.println(sb.toString());
    }

    public void warn(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        warn(sb.toString());
    }

    public void error(String str) {
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(new Date());
        sb.append("]");
        sb.append(str);
        printStream.println(sb.toString());
    }

    public void error(String str, Throwable th) {
        System.out.println(str);
        th.printStackTrace(System.err);
    }
}
