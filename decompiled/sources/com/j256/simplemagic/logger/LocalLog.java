package com.j256.simplemagic.logger;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.j256.simplemagic.logger.Log.Level;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class LocalLog implements Log {
    private static final Level DEFAULT_LEVEL = Level.DEBUG;
    public static final String LOCAL_LOG_FILE_PROPERTY = "com.j256.simplemagic.logger.file";
    public static final String LOCAL_LOG_LEVEL_PROPERTY = "com.j256.simplemagic.logger.level";
    public static final String LOCAL_LOG_PROPERTIES_FILE = "/simplemagicLocalLog.properties";
    private static final List<PatternLevel> classLevels = readLevelResourceFile(LocalLog.class.getResourceAsStream(LOCAL_LOG_PROPERTIES_FILE));
    private static final ThreadLocal<DateFormat> dateFormatThreadLocal = new ThreadLocal<DateFormat>() {
        /* access modifiers changed from: protected */
        public DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        }
    };
    private static PrintStream printStream;
    private final String className;
    private final Level level;

    private static class PatternLevel {
        Level level;
        Pattern pattern;

        public PatternLevel(Pattern pattern2, Level level2) {
            this.pattern = pattern2;
            this.level = level2;
        }
    }

    static {
        openLogFile(System.getProperty(LOCAL_LOG_FILE_PROPERTY));
    }

    public LocalLog(String str) {
        this.className = LoggerFactory.getSimpleClassName(str);
        Level level2 = null;
        if (classLevels != null) {
            for (PatternLevel patternLevel : classLevels) {
                if (patternLevel.pattern.matcher(str).matches() && (level2 == null || patternLevel.level.ordinal() < level2.ordinal())) {
                    level2 = patternLevel.level;
                }
            }
        }
        if (level2 == null) {
            String property = System.getProperty(LOCAL_LOG_LEVEL_PROPERTY);
            if (property == null) {
                level2 = DEFAULT_LEVEL;
            } else {
                try {
                    level2 = Level.valueOf(property.toUpperCase());
                } catch (IllegalArgumentException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Level '");
                    sb.append(property);
                    sb.append("' was not found");
                    throw new IllegalArgumentException(sb.toString(), e);
                }
            }
        }
        this.level = level2;
    }

    public static void openLogFile(String str) {
        if (str == null) {
            printStream = System.out;
            return;
        }
        try {
            printStream = new PrintStream(new File(str));
        } catch (FileNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Log file ");
            sb.append(str);
            sb.append(" was not found");
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }

    public boolean isLevelEnabled(Level level2) {
        return this.level.isEnabled(level2);
    }

    public void log(Level level2, String str) {
        printMessage(level2, str, null);
    }

    public void log(Level level2, String str, Throwable th) {
        printMessage(level2, str, th);
    }

    /* access modifiers changed from: 0000 */
    public void flush() {
        printStream.flush();
    }

    static List<PatternLevel> readLevelResourceFile(InputStream inputStream) {
        if (inputStream != null) {
            try {
                List<PatternLevel> configureClassLevels = configureClassLevels(inputStream);
                try {
                    return configureClassLevels;
                } catch (IOException unused) {
                    return configureClassLevels;
                }
            } catch (IOException e) {
                PrintStream printStream2 = System.err;
                StringBuilder sb = new StringBuilder();
                sb.append("IO exception reading the log properties file '/simplemagicLocalLog.properties': ");
                sb.append(e);
                printStream2.println(sb.toString());
            } finally {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
        }
        return null;
    }

    private static List<PatternLevel> configureClassLevels(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            if (!(readLine.length() == 0 || readLine.charAt(0) == '#')) {
                String[] split = readLine.split(SimpleComparison.EQUAL_TO_OPERATION);
                if (split.length != 2) {
                    PrintStream printStream2 = System.err;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Line is not in the format of 'pattern = level': ");
                    sb.append(readLine);
                    printStream2.println(sb.toString());
                } else {
                    try {
                        arrayList.add(new PatternLevel(Pattern.compile(split[0].trim()), Level.valueOf(split[1].trim())));
                    } catch (IllegalArgumentException unused) {
                        PrintStream printStream3 = System.err;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Level '");
                        sb2.append(split[1]);
                        sb2.append("' was not found");
                        printStream3.println(sb2.toString());
                    }
                }
            }
        }
    }

    private void printMessage(Level level2, String str, Throwable th) {
        if (isLevelEnabled(level2)) {
            StringBuilder sb = new StringBuilder(128);
            sb.append(((DateFormat) dateFormatThreadLocal.get()).format(new Date()));
            sb.append(" [");
            sb.append(level2.name());
            sb.append("] ");
            sb.append(this.className);
            sb.append(' ');
            sb.append(str);
            printStream.println(sb.toString());
            if (th != null) {
                th.printStackTrace(printStream);
            }
        }
    }
}
