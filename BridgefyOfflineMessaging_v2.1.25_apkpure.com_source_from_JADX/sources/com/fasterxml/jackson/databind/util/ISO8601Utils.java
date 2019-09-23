package com.fasterxml.jackson.databind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils {
    @Deprecated
    private static final String GMT_ID = "GMT";
    @Deprecated
    private static final TimeZone TIMEZONE_GMT = TimeZone.getTimeZone(GMT_ID);
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    private static final TimeZone TIMEZONE_Z = TIMEZONE_UTC;
    private static final String UTC_ID = "UTC";

    @Deprecated
    public static TimeZone timeZoneGMT() {
        return TIMEZONE_GMT;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder("yyyy-MM-ddThh:mm:ss".length() + (z ? ".sss".length() : 0) + (timeZone.getRawOffset() == 0 ? "Z" : "+hh:mm").length());
        padInt(sb, gregorianCalendar.get(1), "yyyy".length());
        char c = '-';
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, "MM".length());
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), "dd".length());
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), "hh".length());
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), "mm".length());
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), "ss".length());
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), "sss".length());
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int abs = Math.abs(i / 60);
            int abs2 = Math.abs(i % 60);
            if (offset >= 0) {
                c = '+';
            }
            sb.append(c);
            padInt(sb, abs, "hh".length());
            sb.append(':');
            padInt(sb, abs2, "mm".length());
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c5 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x0199 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0191 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x0199 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date parse(java.lang.String r17, java.text.ParsePosition r18) throws java.text.ParseException {
        /*
            r1 = r17
            r2 = r18
            int r0 = r18.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            int r3 = r0 + 4
            int r0 = parseInt(r1, r0, r3)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r4 = 45
            boolean r5 = checkOffset(r1, r3, r4)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            if (r5 == 0) goto L_0x0018
            int r3 = r3 + 1
        L_0x0018:
            int r5 = r3 + 2
            int r3 = parseInt(r1, r3, r5)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            boolean r6 = checkOffset(r1, r5, r4)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            if (r6 == 0) goto L_0x0026
            int r5 = r5 + 1
        L_0x0026:
            int r6 = r5 + 2
            int r5 = parseInt(r1, r5, r6)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r7 = 84
            boolean r7 = checkOffset(r1, r6, r7)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r8 = 1
            if (r7 != 0) goto L_0x0049
            int r9 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            if (r9 > r6) goto L_0x0049
            java.util.GregorianCalendar r4 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            int r3 = r3 - r8
            r4.<init>(r0, r3, r5)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r2.setIndex(r6)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            java.util.Date r0 = r4.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            return r0
        L_0x0049:
            r9 = 43
            r10 = 90
            r11 = 0
            if (r7 == 0) goto L_0x00ba
            int r6 = r6 + 1
            int r7 = r6 + 2
            int r6 = parseInt(r1, r6, r7)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r12 = 58
            boolean r13 = checkOffset(r1, r7, r12)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            if (r13 == 0) goto L_0x0062
            int r7 = r7 + 1
        L_0x0062:
            int r13 = r7 + 2
            int r7 = parseInt(r1, r7, r13)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            boolean r12 = checkOffset(r1, r13, r12)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            if (r12 == 0) goto L_0x0070
            int r13 = r13 + 1
        L_0x0070:
            int r12 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            if (r12 <= r13) goto L_0x00bd
            char r12 = r1.charAt(r13)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            if (r12 == r10) goto L_0x00bd
            if (r12 == r9) goto L_0x00bd
            if (r12 == r4) goto L_0x00bd
            int r12 = r13 + 2
            int r13 = parseInt(r1, r13, r12)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r14 = 59
            if (r13 <= r14) goto L_0x008f
            r15 = 63
            if (r13 >= r15) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r14 = r13
        L_0x0090:
            r13 = 46
            boolean r13 = checkOffset(r1, r12, r13)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            if (r13 == 0) goto L_0x00b7
            int r12 = r12 + 1
            int r13 = r12 + 1
            int r13 = indexOfNonDigit(r1, r13)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            int r15 = r12 + 3
            int r15 = java.lang.Math.min(r13, r15)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            int r16 = parseInt(r1, r12, r15)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            int r15 = r15 - r12
            switch(r15) {
                case 1: goto L_0x00b2;
                case 2: goto L_0x00af;
                default: goto L_0x00ae;
            }     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
        L_0x00ae:
            goto L_0x00b4
        L_0x00af:
            int r16 = r16 * 10
            goto L_0x00b4
        L_0x00b2:
            int r16 = r16 * 100
        L_0x00b4:
            r12 = r16
            goto L_0x00bf
        L_0x00b7:
            r13 = r12
            r12 = 0
            goto L_0x00bf
        L_0x00ba:
            r13 = r6
            r6 = 0
            r7 = 0
        L_0x00bd:
            r12 = 0
            r14 = 0
        L_0x00bf:
            int r15 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            if (r15 <= r13) goto L_0x0191
            char r15 = r1.charAt(r13)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            if (r15 != r10) goto L_0x00d0
            java.util.TimeZone r4 = TIMEZONE_Z     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            int r13 = r13 + r8
            goto L_0x0160
        L_0x00d0:
            if (r15 == r9) goto L_0x00f1
            if (r15 != r4) goto L_0x00d5
            goto L_0x00f1
        L_0x00d5:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            java.lang.String r4 = "Invalid time zone indicator '"
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r3.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            java.lang.String r4 = "'"
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
        L_0x00f1:
            java.lang.String r4 = r1.substring(r13)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            int r9 = r4.length()     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            int r13 = r13 + r9
            java.lang.String r9 = "+0000"
            boolean r9 = r9.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            if (r9 != 0) goto L_0x015e
            java.lang.String r9 = "+00:00"
            boolean r9 = r9.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            if (r9 == 0) goto L_0x010b
            goto L_0x015e
        L_0x010b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r9.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            java.lang.String r10 = "GMT"
            r9.append(r10)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r9.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            java.lang.String r4 = r9.toString()     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            java.util.TimeZone r9 = java.util.TimeZone.getTimeZone(r4)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            java.lang.String r10 = r9.getID()     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            boolean r15 = r10.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            if (r15 != 0) goto L_0x015c
            java.lang.String r15 = ":"
            java.lang.String r8 = ""
            java.lang.String r8 = r10.replace(r15, r8)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            boolean r8 = r8.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            if (r8 == 0) goto L_0x0139
            goto L_0x015c
        L_0x0139:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            java.lang.String r5 = "Mismatching time zone indicator: "
            r3.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            java.lang.String r4 = " given, resolves to "
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            java.lang.String r4 = r9.getID()     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
        L_0x015c:
            r4 = r9
            goto L_0x0160
        L_0x015e:
            java.util.TimeZone r4 = TIMEZONE_Z     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
        L_0x0160:
            java.util.GregorianCalendar r8 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r8.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r8.setLenient(r11)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r4 = 1
            r8.set(r4, r0)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            int r3 = r3 - r4
            r0 = 2
            r8.set(r0, r3)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r0 = 5
            r8.set(r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r0 = 11
            r8.set(r0, r6)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r0 = 12
            r8.set(r0, r7)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r0 = 13
            r8.set(r0, r14)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r0 = 14
            r8.set(r0, r12)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            r2.setIndex(r13)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            java.util.Date r0 = r8.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            return r0
        L_0x0191:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            java.lang.String r3 = "No time zone indicator"
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x019d, NumberFormatException -> 0x019b, IllegalArgumentException -> 0x0199 }
        L_0x0199:
            r0 = move-exception
            goto L_0x019e
        L_0x019b:
            r0 = move-exception
            goto L_0x019e
        L_0x019d:
            r0 = move-exception
        L_0x019e:
            if (r1 != 0) goto L_0x01a2
            r1 = 0
            goto L_0x01b6
        L_0x01a2:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 34
            r3.append(r4)
            r3.append(r1)
            r3.append(r4)
            java.lang.String r1 = r3.toString()
        L_0x01b6:
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L_0x01c2
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x01e0
        L_0x01c2:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "("
            r3.append(r4)
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r4 = ")"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x01e0:
            java.text.ParseException r4 = new java.text.ParseException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to parse date "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = ": "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = r5.toString()
            int r2 = r18.getIndex()
            r4.<init>(r1, r2)
            r4.initCause(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid number: ");
                sb.append(str.substring(i, i2));
                throw new NumberFormatException(sb.toString());
            }
        } else {
            i4 = i;
            i3 = 0;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i4 = i5;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Invalid number: ");
                sb2.append(str.substring(i, i2));
                throw new NumberFormatException(sb2.toString());
            }
        }
        return -i3;
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
