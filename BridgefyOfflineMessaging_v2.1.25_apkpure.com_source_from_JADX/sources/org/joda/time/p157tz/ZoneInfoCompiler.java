package org.joda.time.p157tz;

import androidx.customview.p073b.C1024a;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.common.net.HttpHeaders;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.MutableDateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.LenientChronology;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/* renamed from: org.joda.time.tz.ZoneInfoCompiler */
public class ZoneInfoCompiler {
    static Chronology cLenientISO;
    static DateTimeOfYear cStartOfYear;
    static ThreadLocal<Boolean> cVerbose = new ThreadLocal<Boolean>() {
        /* access modifiers changed from: protected */
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };
    private List<String> iLinks = new ArrayList();
    private Map<String, RuleSet> iRuleSets = new HashMap();
    private List<Zone> iZones = new ArrayList();

    /* renamed from: org.joda.time.tz.ZoneInfoCompiler$DateTimeOfYear */
    static class DateTimeOfYear {
        public final boolean iAdvanceDayOfWeek;
        public final int iDayOfMonth;
        public final int iDayOfWeek;
        public final int iMillisOfDay;
        public final int iMonthOfYear;
        public final char iZoneChar;

        DateTimeOfYear() {
            this.iMonthOfYear = 1;
            this.iDayOfMonth = 1;
            this.iDayOfWeek = 0;
            this.iAdvanceDayOfWeek = false;
            this.iMillisOfDay = 0;
            this.iZoneChar = 'w';
        }

        DateTimeOfYear(StringTokenizer stringTokenizer) {
            int i;
            boolean z;
            int i2;
            int i3;
            int i4 = 0;
            char c = 'w';
            if (stringTokenizer.hasMoreTokens()) {
                i3 = ZoneInfoCompiler.parseMonth(stringTokenizer.nextToken());
                if (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    if (nextToken.startsWith("last")) {
                        i2 = ZoneInfoCompiler.parseDayOfWeek(nextToken.substring(4));
                        z = false;
                        i = -1;
                    } else {
                        try {
                            i = Integer.parseInt(nextToken);
                            i2 = 0;
                        } catch (NumberFormatException unused) {
                            int indexOf = nextToken.indexOf(SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION);
                            if (indexOf > 0) {
                                i = Integer.parseInt(nextToken.substring(indexOf + 2));
                                i2 = ZoneInfoCompiler.parseDayOfWeek(nextToken.substring(0, indexOf));
                                z = true;
                            } else {
                                int indexOf2 = nextToken.indexOf(SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION);
                                if (indexOf2 > 0) {
                                    i = Integer.parseInt(nextToken.substring(indexOf2 + 2));
                                    i2 = ZoneInfoCompiler.parseDayOfWeek(nextToken.substring(0, indexOf2));
                                } else {
                                    throw new IllegalArgumentException(nextToken);
                                }
                            }
                        }
                        z = false;
                    }
                    if (stringTokenizer.hasMoreTokens()) {
                        String nextToken2 = stringTokenizer.nextToken();
                        c = ZoneInfoCompiler.parseZoneChar(nextToken2.charAt(nextToken2.length() - 1));
                        if (!nextToken2.equals("24:00")) {
                            i4 = ZoneInfoCompiler.parseTime(nextToken2);
                        } else if (i3 == 12 && i == 31) {
                            i4 = ZoneInfoCompiler.parseTime("23:59:59.999");
                        } else {
                            LocalDate plusMonths = i == -1 ? new LocalDate(2001, i3, 1).plusMonths(1) : new LocalDate(2001, i3, i).plusDays(1);
                            boolean z2 = (i == -1 || i2 == 0) ? false : true;
                            int monthOfYear = plusMonths.getMonthOfYear();
                            int dayOfMonth = plusMonths.getDayOfMonth();
                            if (i2 != 0) {
                                i2 = (((i2 - 1) + 1) % 7) + 1;
                            }
                            i = dayOfMonth;
                            int i5 = monthOfYear;
                            z = z2;
                            i3 = i5;
                        }
                    }
                    this.iMonthOfYear = i3;
                    this.iDayOfMonth = i;
                    this.iDayOfWeek = i2;
                    this.iAdvanceDayOfWeek = z;
                    this.iMillisOfDay = i4;
                    this.iZoneChar = c;
                }
            } else {
                i3 = 1;
            }
            i2 = 0;
            z = false;
            i = 1;
            this.iMonthOfYear = i3;
            this.iDayOfMonth = i;
            this.iDayOfWeek = i2;
            this.iAdvanceDayOfWeek = z;
            this.iMillisOfDay = i4;
            this.iZoneChar = c;
        }

        public void addRecurring(DateTimeZoneBuilder dateTimeZoneBuilder, String str, int i, int i2, int i3) {
            dateTimeZoneBuilder.addRecurringSavings(str, i, i2, i3, this.iZoneChar, this.iMonthOfYear, this.iDayOfMonth, this.iDayOfWeek, this.iAdvanceDayOfWeek, this.iMillisOfDay);
        }

        public void addCutover(DateTimeZoneBuilder dateTimeZoneBuilder, int i) {
            dateTimeZoneBuilder.addCutover(i, this.iZoneChar, this.iMonthOfYear, this.iDayOfMonth, this.iDayOfWeek, this.iAdvanceDayOfWeek, this.iMillisOfDay);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MonthOfYear: ");
            sb.append(this.iMonthOfYear);
            sb.append("\n");
            sb.append("DayOfMonth: ");
            sb.append(this.iDayOfMonth);
            sb.append("\n");
            sb.append("DayOfWeek: ");
            sb.append(this.iDayOfWeek);
            sb.append("\n");
            sb.append("AdvanceDayOfWeek: ");
            sb.append(this.iAdvanceDayOfWeek);
            sb.append("\n");
            sb.append("MillisOfDay: ");
            sb.append(this.iMillisOfDay);
            sb.append("\n");
            sb.append("ZoneChar: ");
            sb.append(this.iZoneChar);
            sb.append("\n");
            return sb.toString();
        }
    }

    /* renamed from: org.joda.time.tz.ZoneInfoCompiler$Rule */
    private static class Rule {
        public final DateTimeOfYear iDateTimeOfYear;
        public final int iFromYear;
        public final String iLetterS;
        public final String iName;
        public final int iSaveMillis;
        public final int iToYear;
        public final String iType;

        Rule(StringTokenizer stringTokenizer) {
            this.iName = stringTokenizer.nextToken().intern();
            this.iFromYear = ZoneInfoCompiler.parseYear(stringTokenizer.nextToken(), 0);
            this.iToYear = ZoneInfoCompiler.parseYear(stringTokenizer.nextToken(), this.iFromYear);
            if (this.iToYear >= this.iFromYear) {
                this.iType = ZoneInfoCompiler.parseOptional(stringTokenizer.nextToken());
                this.iDateTimeOfYear = new DateTimeOfYear(stringTokenizer);
                this.iSaveMillis = ZoneInfoCompiler.parseTime(stringTokenizer.nextToken());
                this.iLetterS = ZoneInfoCompiler.parseOptional(stringTokenizer.nextToken());
                return;
            }
            throw new IllegalArgumentException();
        }

        public void addRecurring(DateTimeZoneBuilder dateTimeZoneBuilder, String str) {
            DateTimeZoneBuilder dateTimeZoneBuilder2 = dateTimeZoneBuilder;
            this.iDateTimeOfYear.addRecurring(dateTimeZoneBuilder2, formatName(str), this.iSaveMillis, this.iFromYear, this.iToYear);
        }

        private String formatName(String str) {
            String str2;
            int indexOf = str.indexOf(47);
            if (indexOf <= 0) {
                int indexOf2 = str.indexOf("%s");
                if (indexOf2 < 0) {
                    return str;
                }
                String substring = str.substring(0, indexOf2);
                String substring2 = str.substring(indexOf2 + 2);
                if (this.iLetterS == null) {
                    str2 = substring.concat(substring2);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(substring);
                    sb.append(this.iLetterS);
                    sb.append(substring2);
                    str2 = sb.toString();
                }
                return str2.intern();
            } else if (this.iSaveMillis == 0) {
                return str.substring(0, indexOf).intern();
            } else {
                return str.substring(indexOf + 1).intern();
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[Rule]\nName: ");
            sb.append(this.iName);
            sb.append("\n");
            sb.append("FromYear: ");
            sb.append(this.iFromYear);
            sb.append("\n");
            sb.append("ToYear: ");
            sb.append(this.iToYear);
            sb.append("\n");
            sb.append("Type: ");
            sb.append(this.iType);
            sb.append("\n");
            sb.append(this.iDateTimeOfYear);
            sb.append("SaveMillis: ");
            sb.append(this.iSaveMillis);
            sb.append("\n");
            sb.append("LetterS: ");
            sb.append(this.iLetterS);
            sb.append("\n");
            return sb.toString();
        }
    }

    /* renamed from: org.joda.time.tz.ZoneInfoCompiler$RuleSet */
    private static class RuleSet {
        private List<Rule> iRules = new ArrayList();

        RuleSet(Rule rule) {
            this.iRules.add(rule);
        }

        /* access modifiers changed from: 0000 */
        public void addRule(Rule rule) {
            if (rule.iName.equals(((Rule) this.iRules.get(0)).iName)) {
                this.iRules.add(rule);
                return;
            }
            throw new IllegalArgumentException("Rule name mismatch");
        }

        public void addRecurring(DateTimeZoneBuilder dateTimeZoneBuilder, String str) {
            for (int i = 0; i < this.iRules.size(); i++) {
                ((Rule) this.iRules.get(i)).addRecurring(dateTimeZoneBuilder, str);
            }
        }
    }

    /* renamed from: org.joda.time.tz.ZoneInfoCompiler$Zone */
    private static class Zone {
        public final String iFormat;
        public final String iName;
        private Zone iNext;
        public final int iOffsetMillis;
        public final String iRules;
        public final DateTimeOfYear iUntilDateTimeOfYear;
        public final int iUntilYear;

        Zone(StringTokenizer stringTokenizer) {
            this(stringTokenizer.nextToken(), stringTokenizer);
        }

        private Zone(String str, StringTokenizer stringTokenizer) {
            int i;
            this.iName = str.intern();
            this.iOffsetMillis = ZoneInfoCompiler.parseTime(stringTokenizer.nextToken());
            this.iRules = ZoneInfoCompiler.parseOptional(stringTokenizer.nextToken());
            this.iFormat = stringTokenizer.nextToken().intern();
            DateTimeOfYear startOfYear = ZoneInfoCompiler.getStartOfYear();
            if (stringTokenizer.hasMoreTokens()) {
                i = Integer.parseInt(stringTokenizer.nextToken());
                if (stringTokenizer.hasMoreTokens()) {
                    startOfYear = new DateTimeOfYear(stringTokenizer);
                }
            } else {
                i = BaseClientBuilder.API_PRIORITY_OTHER;
            }
            this.iUntilYear = i;
            this.iUntilDateTimeOfYear = startOfYear;
        }

        /* access modifiers changed from: 0000 */
        public void chain(StringTokenizer stringTokenizer) {
            if (this.iNext != null) {
                this.iNext.chain(stringTokenizer);
            } else {
                this.iNext = new Zone(this.iName, stringTokenizer);
            }
        }

        public void addToBuilder(DateTimeZoneBuilder dateTimeZoneBuilder, Map<String, RuleSet> map) {
            addToBuilder(this, dateTimeZoneBuilder, map);
        }

        private static void addToBuilder(Zone zone, DateTimeZoneBuilder dateTimeZoneBuilder, Map<String, RuleSet> map) {
            while (zone != null) {
                dateTimeZoneBuilder.setStandardOffset(zone.iOffsetMillis);
                if (zone.iRules == null) {
                    dateTimeZoneBuilder.setFixedSavings(zone.iFormat, 0);
                } else {
                    try {
                        dateTimeZoneBuilder.setFixedSavings(zone.iFormat, ZoneInfoCompiler.parseTime(zone.iRules));
                    } catch (Exception unused) {
                        RuleSet ruleSet = (RuleSet) map.get(zone.iRules);
                        if (ruleSet != null) {
                            ruleSet.addRecurring(dateTimeZoneBuilder, zone.iFormat);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Rules not found: ");
                            sb.append(zone.iRules);
                            throw new IllegalArgumentException(sb.toString());
                        }
                    }
                }
                if (zone.iUntilYear != Integer.MAX_VALUE) {
                    zone.iUntilDateTimeOfYear.addCutover(dateTimeZoneBuilder, zone.iUntilYear);
                    zone = zone.iNext;
                } else {
                    return;
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[Zone]\nName: ");
            sb.append(this.iName);
            sb.append("\n");
            sb.append("OffsetMillis: ");
            sb.append(this.iOffsetMillis);
            sb.append("\n");
            sb.append("Rules: ");
            sb.append(this.iRules);
            sb.append("\n");
            sb.append("Format: ");
            sb.append(this.iFormat);
            sb.append("\n");
            sb.append("UntilYear: ");
            sb.append(this.iUntilYear);
            sb.append("\n");
            sb.append(this.iUntilDateTimeOfYear);
            String sb2 = sb.toString();
            if (this.iNext == null) {
                return sb2;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append("...\n");
            sb3.append(this.iNext.toString());
            return sb3.toString();
        }
    }

    static char parseZoneChar(char c) {
        if (c != 'G') {
            if (c != 'S') {
                if (!(c == 'U' || c == 'Z' || c == 'g')) {
                    if (c != 's') {
                        if (!(c == 'u' || c == 'z')) {
                            return 'w';
                        }
                    }
                }
            }
            return 's';
        }
        return 'u';
    }

    public static boolean verbose() {
        return ((Boolean) cVerbose.get()).booleanValue();
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length == 0) {
            printUsage();
            return;
        }
        int i = 0;
        File file = null;
        File file2 = null;
        int i2 = 0;
        boolean z = false;
        while (true) {
            if (i2 >= strArr.length) {
                break;
            }
            try {
                if ("-src".equals(strArr[i2])) {
                    i2++;
                    file = new File(strArr[i2]);
                } else if ("-dst".equals(strArr[i2])) {
                    i2++;
                    file2 = new File(strArr[i2]);
                } else if ("-verbose".equals(strArr[i2])) {
                    z = true;
                } else if ("-?".equals(strArr[i2])) {
                    printUsage();
                    return;
                }
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                printUsage();
                return;
            }
        }
        if (i2 >= strArr.length) {
            printUsage();
            return;
        }
        File[] fileArr = new File[(strArr.length - i2)];
        while (i2 < strArr.length) {
            fileArr[i] = file == null ? new File(strArr[i2]) : new File(file, strArr[i2]);
            i2++;
            i++;
        }
        cVerbose.set(Boolean.valueOf(z));
        new ZoneInfoCompiler().compile(file2, fileArr);
    }

    private static void printUsage() {
        System.out.println("Usage: java org.joda.time.tz.ZoneInfoCompiler <options> <source files>");
        System.out.println("where possible options include:");
        System.out.println("  -src <directory>    Specify where to read source files");
        System.out.println("  -dst <directory>    Specify where to write generated files");
        System.out.println("  -verbose            Output verbosely (default false)");
    }

    static DateTimeOfYear getStartOfYear() {
        if (cStartOfYear == null) {
            cStartOfYear = new DateTimeOfYear();
        }
        return cStartOfYear;
    }

    static Chronology getLenientISOChronology() {
        if (cLenientISO == null) {
            cLenientISO = LenientChronology.getInstance(ISOChronology.getInstanceUTC());
        }
        return cLenientISO;
    }

    static void writeZoneInfoMap(DataOutputStream dataOutputStream, Map<String, DateTimeZone> map) throws IOException {
        HashMap hashMap = new HashMap(map.size());
        TreeMap treeMap = new TreeMap();
        short s = 0;
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (!hashMap.containsKey(str)) {
                Short valueOf = Short.valueOf(s);
                hashMap.put(str, valueOf);
                treeMap.put(valueOf, str);
                s = (short) (s + 1);
                if (s == 0) {
                    throw new InternalError("Too many time zone ids");
                }
            }
            String id = ((DateTimeZone) entry.getValue()).getID();
            if (!hashMap.containsKey(id)) {
                Short valueOf2 = Short.valueOf(s);
                hashMap.put(id, valueOf2);
                treeMap.put(valueOf2, id);
                s = (short) (s + 1);
                if (s == 0) {
                    throw new InternalError("Too many time zone ids");
                }
            }
        }
        dataOutputStream.writeShort(treeMap.size());
        for (String writeUTF : treeMap.values()) {
            dataOutputStream.writeUTF(writeUTF);
        }
        dataOutputStream.writeShort(map.size());
        for (Entry entry2 : map.entrySet()) {
            dataOutputStream.writeShort(((Short) hashMap.get((String) entry2.getKey())).shortValue());
            dataOutputStream.writeShort(((Short) hashMap.get(((DateTimeZone) entry2.getValue()).getID())).shortValue());
        }
    }

    static int parseYear(String str, int i) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("minimum") || lowerCase.equals("min")) {
            return C1024a.INVALID_ID;
        }
        if (lowerCase.equals("maximum") || lowerCase.equals("max")) {
            return BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (lowerCase.equals("only")) {
            return i;
        }
        return Integer.parseInt(lowerCase);
    }

    static int parseMonth(String str) {
        DateTimeField monthOfYear = ISOChronology.getInstanceUTC().monthOfYear();
        return monthOfYear.get(monthOfYear.set(0, str, Locale.ENGLISH));
    }

    static int parseDayOfWeek(String str) {
        DateTimeField dayOfWeek = ISOChronology.getInstanceUTC().dayOfWeek();
        return dayOfWeek.get(dayOfWeek.set(0, str, Locale.ENGLISH));
    }

    static String parseOptional(String str) {
        if (str.equals("-")) {
            return null;
        }
        return str;
    }

    static int parseTime(String str) {
        DateTimeFormatter hourMinuteSecondFraction = ISODateTimeFormat.hourMinuteSecondFraction();
        MutableDateTime mutableDateTime = new MutableDateTime(0, getLenientISOChronology());
        boolean startsWith = str.startsWith("-");
        if (hourMinuteSecondFraction.parseInto(mutableDateTime, str, startsWith ? 1 : 0) != (!startsWith)) {
            int millis = (int) mutableDateTime.getMillis();
            return startsWith ? -millis : millis;
        }
        throw new IllegalArgumentException(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d2, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean test(java.lang.String r14, org.joda.time.DateTimeZone r15) {
        /*
            java.lang.String r0 = r15.getID()
            boolean r14 = r14.equals(r0)
            r0 = 1
            if (r14 != 0) goto L_0x000c
            return r0
        L_0x000c:
            org.joda.time.chrono.ISOChronology r14 = org.joda.time.chrono.ISOChronology.getInstanceUTC()
            org.joda.time.DateTimeField r14 = r14.year()
            r1 = 1850(0x73a, float:2.592E-42)
            r2 = 0
            long r4 = r14.set(r2, r1)
            org.joda.time.chrono.ISOChronology r14 = org.joda.time.chrono.ISOChronology.getInstanceUTC()
            org.joda.time.DateTimeField r14 = r14.year()
            r6 = 2050(0x802, float:2.873E-42)
            long r7 = r14.set(r2, r6)
            int r14 = r15.getOffset(r4)
            java.lang.String r9 = r15.getNameKey(r4)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x0037:
            long r11 = r15.nextTransition(r4)
            r13 = 0
            int r4 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x00d3
            int r4 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x0046
            goto L_0x00d3
        L_0x0046:
            int r4 = r15.getOffset(r11)
            java.lang.String r5 = r15.getNameKey(r11)
            if (r14 != r4) goto L_0x0082
            boolean r14 = r9.equals(r5)
            if (r14 == 0) goto L_0x0082
            java.io.PrintStream r14 = java.lang.System.out
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "*d* Error in "
            r0.append(r1)
            java.lang.String r15 = r15.getID()
            r0.append(r15)
            java.lang.String r15 = " "
            r0.append(r15)
            org.joda.time.DateTime r15 = new org.joda.time.DateTime
            org.joda.time.chrono.ISOChronology r1 = org.joda.time.chrono.ISOChronology.getInstanceUTC()
            r15.<init>(r11, r1)
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            r14.println(r15)
            return r13
        L_0x0082:
            if (r5 == 0) goto L_0x009f
            int r14 = r5.length()
            r9 = 3
            if (r14 >= r9) goto L_0x0094
            java.lang.String r14 = "??"
            boolean r14 = r14.equals(r5)
            if (r14 != 0) goto L_0x0094
            goto L_0x009f
        L_0x0094:
            java.lang.Long r14 = java.lang.Long.valueOf(r11)
            r10.add(r14)
            r14 = r4
            r9 = r5
            r4 = r11
            goto L_0x0037
        L_0x009f:
            java.io.PrintStream r14 = java.lang.System.out
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "*s* Error in "
            r0.append(r1)
            java.lang.String r15 = r15.getID()
            r0.append(r15)
            java.lang.String r15 = " "
            r0.append(r15)
            org.joda.time.DateTime r15 = new org.joda.time.DateTime
            org.joda.time.chrono.ISOChronology r1 = org.joda.time.chrono.ISOChronology.getInstanceUTC()
            r15.<init>(r11, r1)
            r0.append(r15)
            java.lang.String r15 = ", nameKey="
            r0.append(r15)
            r0.append(r5)
            java.lang.String r15 = r0.toString()
            r14.println(r15)
            return r13
        L_0x00d3:
            org.joda.time.chrono.ISOChronology r14 = org.joda.time.chrono.ISOChronology.getInstanceUTC()
            org.joda.time.DateTimeField r14 = r14.year()
            long r4 = r14.set(r2, r6)
            org.joda.time.chrono.ISOChronology r14 = org.joda.time.chrono.ISOChronology.getInstanceUTC()
            org.joda.time.DateTimeField r14 = r14.year()
            long r1 = r14.set(r2, r1)
            int r14 = r10.size()
        L_0x00ef:
            int r14 = r14 + -1
            if (r14 < 0) goto L_0x0150
            long r6 = r15.previousTransition(r4)
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x0150
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x0100
            goto L_0x0150
        L_0x0100:
            java.lang.Object r3 = r10.get(r14)
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            r8 = 1
            long r3 = r3 - r8
            int r5 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x014e
            java.io.PrintStream r14 = java.lang.System.out
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "*r* Error in "
            r0.append(r1)
            java.lang.String r15 = r15.getID()
            r0.append(r15)
            java.lang.String r15 = " "
            r0.append(r15)
            org.joda.time.DateTime r15 = new org.joda.time.DateTime
            org.joda.time.chrono.ISOChronology r1 = org.joda.time.chrono.ISOChronology.getInstanceUTC()
            r15.<init>(r6, r1)
            r0.append(r15)
            java.lang.String r15 = " != "
            r0.append(r15)
            org.joda.time.DateTime r15 = new org.joda.time.DateTime
            org.joda.time.chrono.ISOChronology r1 = org.joda.time.chrono.ISOChronology.getInstanceUTC()
            r15.<init>(r3, r1)
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            r14.println(r15)
            return r13
        L_0x014e:
            r4 = r6
            goto L_0x00ef
        L_0x0150:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.p157tz.ZoneInfoCompiler.test(java.lang.String, org.joda.time.DateTimeZone):boolean");
    }

    /* JADX INFO: finally extract failed */
    public Map<String, DateTimeZone> compile(File file, File[] fileArr) throws IOException {
        if (fileArr != null) {
            for (File fileReader : fileArr) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileReader));
                parseDataFile(bufferedReader);
                bufferedReader.close();
            }
        }
        if (file != null) {
            if (!file.exists() && !file.mkdirs()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Destination directory doesn't exist and cannot be created: ");
                sb.append(file);
                throw new IOException(sb.toString());
            } else if (!file.isDirectory()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Destination is not a directory: ");
                sb2.append(file);
                throw new IOException(sb2.toString());
            }
        }
        TreeMap treeMap = new TreeMap();
        System.out.println("Writing zoneinfo files");
        for (int i = 0; i < this.iZones.size(); i++) {
            Zone zone = (Zone) this.iZones.get(i);
            DateTimeZoneBuilder dateTimeZoneBuilder = new DateTimeZoneBuilder();
            zone.addToBuilder(dateTimeZoneBuilder, this.iRuleSets);
            DateTimeZone dateTimeZone = dateTimeZoneBuilder.toDateTimeZone(zone.iName, true);
            if (test(dateTimeZone.getID(), dateTimeZone)) {
                treeMap.put(dateTimeZone.getID(), dateTimeZone);
                if (file != null) {
                    if (verbose()) {
                        PrintStream printStream = System.out;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Writing ");
                        sb3.append(dateTimeZone.getID());
                        printStream.println(sb3.toString());
                    }
                    File file2 = new File(file, dateTimeZone.getID());
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        dateTimeZoneBuilder.writeTo(zone.iName, (OutputStream) fileOutputStream);
                        fileOutputStream.close();
                        FileInputStream fileInputStream = new FileInputStream(file2);
                        DateTimeZone readFrom = DateTimeZoneBuilder.readFrom((InputStream) fileInputStream, dateTimeZone.getID());
                        fileInputStream.close();
                        if (!dateTimeZone.equals(readFrom)) {
                            PrintStream printStream2 = System.out;
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("*e* Error in ");
                            sb4.append(dateTimeZone.getID());
                            sb4.append(": Didn't read properly from file");
                            printStream2.println(sb4.toString());
                        }
                    } catch (Throwable th) {
                        fileOutputStream.close();
                        throw th;
                    }
                }
            }
        }
        for (int i2 = 0; i2 < 2; i2++) {
            for (int i3 = 0; i3 < this.iLinks.size(); i3 += 2) {
                String str = (String) this.iLinks.get(i3);
                String str2 = (String) this.iLinks.get(i3 + 1);
                DateTimeZone dateTimeZone2 = (DateTimeZone) treeMap.get(str);
                if (dateTimeZone2 != null) {
                    treeMap.put(str2, dateTimeZone2);
                } else if (i2 > 0) {
                    PrintStream printStream3 = System.out;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Cannot find time zone '");
                    sb5.append(str);
                    sb5.append("' to link alias '");
                    sb5.append(str2);
                    sb5.append("' to");
                    printStream3.println(sb5.toString());
                }
            }
        }
        if (file != null) {
            System.out.println("Writing ZoneInfoMap");
            File file3 = new File(file, "ZoneInfoMap");
            if (!file3.getParentFile().exists()) {
                file3.getParentFile().mkdirs();
            }
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file3));
            try {
                TreeMap treeMap2 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                treeMap2.putAll(treeMap);
                writeZoneInfoMap(dataOutputStream, treeMap2);
            } finally {
                dataOutputStream.close();
            }
        }
        return treeMap;
    }

    public void parseDataFile(BufferedReader bufferedReader) throws IOException {
        Zone zone;
        loop0:
        while (true) {
            zone = null;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break loop0;
                }
                String trim = readLine.trim();
                if (!(trim.length() == 0 || trim.charAt(0) == '#')) {
                    int indexOf = readLine.indexOf(35);
                    if (indexOf >= 0) {
                        readLine = readLine.substring(0, indexOf);
                    }
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine, " \t");
                    if (!Character.isWhitespace(readLine.charAt(0)) || !stringTokenizer.hasMoreTokens()) {
                        if (zone != null) {
                            this.iZones.add(zone);
                        }
                        if (!stringTokenizer.hasMoreTokens()) {
                            break;
                        }
                        String nextToken = stringTokenizer.nextToken();
                        if (nextToken.equalsIgnoreCase("Rule")) {
                            Rule rule = new Rule(stringTokenizer);
                            RuleSet ruleSet = (RuleSet) this.iRuleSets.get(rule.iName);
                            if (ruleSet == null) {
                                this.iRuleSets.put(rule.iName, new RuleSet(rule));
                            } else {
                                ruleSet.addRule(rule);
                            }
                        } else if (nextToken.equalsIgnoreCase("Zone")) {
                            zone = new Zone(stringTokenizer);
                        } else if (nextToken.equalsIgnoreCase(HttpHeaders.LINK)) {
                            this.iLinks.add(stringTokenizer.nextToken());
                            this.iLinks.add(stringTokenizer.nextToken());
                        } else {
                            PrintStream printStream = System.out;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unknown line: ");
                            sb.append(readLine);
                            printStream.println(sb.toString());
                        }
                    } else if (zone != null) {
                        zone.chain(stringTokenizer);
                    }
                }
            }
        }
        if (zone != null) {
            this.iZones.add(zone);
        }
    }
}
