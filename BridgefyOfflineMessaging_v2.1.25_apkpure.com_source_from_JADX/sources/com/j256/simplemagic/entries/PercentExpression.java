package com.j256.simplemagic.entries;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.regex.Pattern;

public class PercentExpression {
    private static final Pattern FORMAT_PATTERN = Pattern.compile("%([0#+ -]*)([0-9]*)(\\.([0-9]+))?([lqh]*)([%bcdeEfFgGiosuxX])");
    private static final String SPACE_CHARS = "                                                                      ";
    private static final String ZERO_CHARS = "00000000000000000000000000000000000000000000000000000000000000000000000";
    private final Format altDecimalFormat;
    private final boolean alternativeForm;
    private final Format decimalFormat;
    private final String expression;
    private final boolean justValue;
    private final boolean leftAdjust;
    private final char patternChar;
    private final boolean plusPrefix;
    private final boolean spacePrefix;
    private final int totalWidth;
    private final int truncateWidth;
    private final boolean zeroPrefix;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0088, code lost:
        r6.decimalFormat = decimalFormat(r1);
        r6.altDecimalFormat = scientificFormat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0095, code lost:
        r6.decimalFormat = decimalFormat(r1);
        r6.altDecimalFormat = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x009e, code lost:
        r6.decimalFormat = scientificFormat(r1);
        r6.altDecimalFormat = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00aa, code lost:
        if (r6.patternChar == 's') goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00b0, code lost:
        if (r6.patternChar != 'b') goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b3, code lost:
        r6.truncateWidth = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b6, code lost:
        r6.truncateWidth = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b8, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    PercentExpression(java.lang.String r7) {
        /*
            r6 = this;
            r6.<init>()
            r6.expression = r7
            java.util.regex.Pattern r0 = FORMAT_PATTERN
            java.util.regex.Matcher r7 = r0.matcher(r7)
            boolean r0 = r7.matches()
            r1 = 1
            r2 = -1
            r3 = 0
            r4 = 0
            if (r0 == 0) goto L_0x00b9
            r0 = 6
            java.lang.String r5 = r7.group(r0)
            if (r5 == 0) goto L_0x00b9
            java.lang.String r5 = r7.group(r0)
            int r5 = r5.length()
            if (r5 == r1) goto L_0x0028
            goto L_0x00b9
        L_0x0028:
            r6.justValue = r4
            java.lang.String r1 = r7.group(r1)
            r5 = 35
            boolean r5 = readFlag(r1, r5)
            r6.alternativeForm = r5
            r5 = 48
            boolean r5 = readFlag(r1, r5)
            r6.zeroPrefix = r5
            r5 = 43
            boolean r5 = readFlag(r1, r5)
            r6.plusPrefix = r5
            boolean r5 = r6.plusPrefix
            if (r5 == 0) goto L_0x004d
            r6.spacePrefix = r4
            goto L_0x0055
        L_0x004d:
            r5 = 32
            boolean r5 = readFlag(r1, r5)
            r6.spacePrefix = r5
        L_0x0055:
            r5 = 45
            boolean r1 = readFlag(r1, r5)
            r6.leftAdjust = r1
            r1 = 2
            java.lang.String r1 = r7.group(r1)
            int r1 = readPrecision(r1, r2)
            r6.totalWidth = r1
            r1 = 4
            java.lang.String r1 = r7.group(r1)
            int r1 = readPrecision(r1, r2)
            java.lang.String r7 = r7.group(r0)
            char r7 = r7.charAt(r4)
            r6.patternChar = r7
            char r7 = r6.patternChar
            switch(r7) {
                case 69: goto L_0x009e;
                case 70: goto L_0x0095;
                case 71: goto L_0x0088;
                default: goto L_0x0080;
            }
        L_0x0080:
            switch(r7) {
                case 101: goto L_0x009e;
                case 102: goto L_0x0095;
                case 103: goto L_0x0088;
                default: goto L_0x0083;
            }
        L_0x0083:
            r6.decimalFormat = r3
            r6.altDecimalFormat = r3
            goto L_0x00a6
        L_0x0088:
            java.text.Format r7 = r6.decimalFormat(r1)
            r6.decimalFormat = r7
            java.text.Format r7 = r6.scientificFormat(r1)
            r6.altDecimalFormat = r7
            goto L_0x00a6
        L_0x0095:
            java.text.Format r7 = r6.decimalFormat(r1)
            r6.decimalFormat = r7
            r6.altDecimalFormat = r3
            goto L_0x00a6
        L_0x009e:
            java.text.Format r7 = r6.scientificFormat(r1)
            r6.decimalFormat = r7
            r6.altDecimalFormat = r3
        L_0x00a6:
            char r7 = r6.patternChar
            r0 = 115(0x73, float:1.61E-43)
            if (r7 == r0) goto L_0x00b6
            char r7 = r6.patternChar
            r0 = 98
            if (r7 != r0) goto L_0x00b3
            goto L_0x00b6
        L_0x00b3:
            r6.truncateWidth = r2
            goto L_0x00b8
        L_0x00b6:
            r6.truncateWidth = r1
        L_0x00b8:
            return
        L_0x00b9:
            r6.justValue = r1
            r6.alternativeForm = r4
            r6.patternChar = r4
            r6.zeroPrefix = r4
            r6.plusPrefix = r4
            r6.spacePrefix = r4
            r6.leftAdjust = r4
            r6.totalWidth = r2
            r6.truncateWidth = r2
            r6.decimalFormat = r3
            r6.altDecimalFormat = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.simplemagic.entries.PercentExpression.<init>(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0071, code lost:
        if ((r13 instanceof java.lang.Number) == false) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0073, code lost:
        r0 = ((java.lang.Number) r13).doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007d, code lost:
        if (java.lang.Double.isInfinite(r0) == false) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007f, code lost:
        r14.append("inf");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0084, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0089, code lost:
        if (java.lang.Double.isNaN(r0) == false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008b, code lost:
        r14.append("nan");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0090, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0095, code lost:
        if (r0 < 0.0d) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0099, code lost:
        if (r12.plusPrefix == false) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009b, code lost:
        r5 = "+";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a0, code lost:
        if (r12.spacePrefix == false) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a2, code lost:
        r5 = com.fasterxml.jackson.core.util.MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a5, code lost:
        r5 = "-";
        r0 = -r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a8, code lost:
        r4 = r5;
        r13 = r12.decimalFormat.format(java.lang.Double.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b5, code lost:
        if (r12.altDecimalFormat == null) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b7, code lost:
        r0 = r12.altDecimalFormat.format(java.lang.Double.valueOf(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c9, code lost:
        if (r0.length() >= r13.length()) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00cb, code lost:
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00cd, code lost:
        r6 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ce, code lost:
        appendValue(r14, r4, null, r6, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void append(java.lang.Object r13, java.lang.StringBuilder r14) {
        /*
            r12 = this;
            boolean r0 = r12.justValue
            if (r0 == 0) goto L_0x0008
            r14.append(r13)
            return
        L_0x0008:
            char r0 = r12.patternChar
            r1 = 88
            r2 = 1
            if (r0 == r1) goto L_0x0150
            r1 = 105(0x69, float:1.47E-43)
            r3 = 0
            r5 = 0
            if (r0 == r1) goto L_0x0124
            r1 = 111(0x6f, float:1.56E-43)
            if (r0 == r1) goto L_0x00fe
            r1 = 115(0x73, float:1.61E-43)
            r6 = 0
            if (r0 == r1) goto L_0x00de
            r1 = 117(0x75, float:1.64E-43)
            if (r0 == r1) goto L_0x0124
            r1 = 120(0x78, float:1.68E-43)
            if (r0 == r1) goto L_0x00d6
            switch(r0) {
                case 69: goto L_0x006f;
                case 70: goto L_0x006f;
                case 71: goto L_0x006f;
                default: goto L_0x002a;
            }
        L_0x002a:
            switch(r0) {
                case 98: goto L_0x00de;
                case 99: goto L_0x002f;
                case 100: goto L_0x0124;
                case 101: goto L_0x006f;
                case 102: goto L_0x006f;
                case 103: goto L_0x006f;
                default: goto L_0x002d;
            }
        L_0x002d:
            goto L_0x0158
        L_0x002f:
            boolean r0 = r13 instanceof java.lang.Character
            if (r0 == 0) goto L_0x003f
            java.lang.Character r13 = (java.lang.Character) r13
            char r13 = r13.charValue()
            java.lang.String r13 = java.lang.Character.toString(r13)
        L_0x003d:
            r4 = r13
            goto L_0x0066
        L_0x003f:
            boolean r0 = r13 instanceof java.lang.Number
            if (r0 == 0) goto L_0x004f
            java.lang.Number r13 = (java.lang.Number) r13
            short r13 = r13.shortValue()
            char r13 = (char) r13
            java.lang.String r13 = java.lang.Character.toString(r13)
            goto L_0x003d
        L_0x004f:
            boolean r0 = r13 instanceof java.lang.String
            if (r0 == 0) goto L_0x0063
            java.lang.String r13 = (java.lang.String) r13
            int r0 = r13.length()
            if (r0 != 0) goto L_0x005e
            java.lang.String r13 = ""
            goto L_0x003d
        L_0x005e:
            java.lang.String r13 = r13.substring(r6, r2)
            goto L_0x003d
        L_0x0063:
            java.lang.String r13 = "?"
            goto L_0x003d
        L_0x0066:
            r2 = 0
            r3 = 0
            r5 = 0
            r0 = r12
            r1 = r14
            r0.appendValue(r1, r2, r3, r4, r5)
            return
        L_0x006f:
            boolean r0 = r13 instanceof java.lang.Number
            if (r0 == 0) goto L_0x0158
            java.lang.Number r13 = (java.lang.Number) r13
            double r0 = r13.doubleValue()
            boolean r13 = java.lang.Double.isInfinite(r0)
            if (r13 == 0) goto L_0x0085
            java.lang.String r13 = "inf"
            r14.append(r13)
            return
        L_0x0085:
            boolean r13 = java.lang.Double.isNaN(r0)
            if (r13 == 0) goto L_0x0091
            java.lang.String r13 = "nan"
            r14.append(r13)
            return
        L_0x0091:
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 < 0) goto L_0x00a5
            boolean r13 = r12.plusPrefix
            if (r13 == 0) goto L_0x009e
            java.lang.String r5 = "+"
            goto L_0x00a8
        L_0x009e:
            boolean r13 = r12.spacePrefix
            if (r13 == 0) goto L_0x00a8
            java.lang.String r5 = " "
            goto L_0x00a8
        L_0x00a5:
            java.lang.String r5 = "-"
            double r0 = -r0
        L_0x00a8:
            r4 = r5
            java.text.Format r13 = r12.decimalFormat
            java.lang.Double r2 = java.lang.Double.valueOf(r0)
            java.lang.String r13 = r13.format(r2)
            java.text.Format r2 = r12.altDecimalFormat
            if (r2 == 0) goto L_0x00cd
            java.text.Format r2 = r12.altDecimalFormat
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            java.lang.String r0 = r2.format(r0)
            int r1 = r0.length()
            int r2 = r13.length()
            if (r1 >= r2) goto L_0x00cd
            r6 = r0
            goto L_0x00ce
        L_0x00cd:
            r6 = r13
        L_0x00ce:
            r5 = 0
            r7 = 1
            r2 = r12
            r3 = r14
            r2.appendValue(r3, r4, r5, r6, r7)
            return
        L_0x00d6:
            boolean r0 = r13 instanceof java.lang.Number
            if (r0 == 0) goto L_0x0158
            r12.appendHex(r14, r6, r13)
            return
        L_0x00de:
            java.lang.String r13 = r13.toString()
            int r0 = r12.truncateWidth
            if (r0 < 0) goto L_0x00f4
            int r0 = r13.length()
            int r1 = r12.truncateWidth
            if (r0 <= r1) goto L_0x00f4
            int r0 = r12.truncateWidth
            java.lang.String r13 = r13.substring(r6, r0)
        L_0x00f4:
            r4 = r13
            r2 = 0
            r3 = 0
            r5 = 0
            r0 = r12
            r1 = r14
            r0.appendValue(r1, r2, r3, r4, r5)
            return
        L_0x00fe:
            boolean r0 = r13 instanceof java.lang.Number
            if (r0 == 0) goto L_0x0158
            java.lang.Number r13 = (java.lang.Number) r13
            long r0 = r13.longValue()
            int r13 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x0111
            java.lang.String r13 = "-"
            long r0 = -r0
            r8 = r13
            goto L_0x0112
        L_0x0111:
            r8 = r5
        L_0x0112:
            boolean r13 = r12.alternativeForm
            if (r13 == 0) goto L_0x0118
            java.lang.String r5 = "0"
        L_0x0118:
            r9 = r5
            java.lang.String r10 = java.lang.Long.toOctalString(r0)
            r11 = 1
            r6 = r12
            r7 = r14
            r6.appendValue(r7, r8, r9, r10, r11)
            return
        L_0x0124:
            boolean r0 = r13 instanceof java.lang.Number
            if (r0 == 0) goto L_0x0158
            java.lang.Number r13 = (java.lang.Number) r13
            long r0 = r13.longValue()
            int r13 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r13 < 0) goto L_0x0140
            boolean r13 = r12.plusPrefix
            if (r13 == 0) goto L_0x0139
            java.lang.String r5 = "+"
            goto L_0x0143
        L_0x0139:
            boolean r13 = r12.spacePrefix
            if (r13 == 0) goto L_0x0143
            java.lang.String r5 = " "
            goto L_0x0143
        L_0x0140:
            java.lang.String r5 = "-"
            long r0 = -r0
        L_0x0143:
            r4 = r5
            java.lang.String r6 = java.lang.Long.toString(r0)
            r5 = 0
            r7 = 1
            r2 = r12
            r3 = r14
            r2.appendValue(r3, r4, r5, r6, r7)
            return
        L_0x0150:
            boolean r0 = r13 instanceof java.lang.Number
            if (r0 == 0) goto L_0x0158
            r12.appendHex(r14, r2, r13)
            return
        L_0x0158:
            r14.append(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.simplemagic.entries.PercentExpression.append(java.lang.Object, java.lang.StringBuilder):void");
    }

    public String toString() {
        return this.expression;
    }

    private static int readPrecision(String str, int i) {
        if (str == null || str.length() == 0) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    private static boolean readFlag(String str, char c) {
        return str != null && str.indexOf(c) >= 0;
    }

    private void appendHex(StringBuilder sb, boolean z, Object obj) {
        String str;
        long longValue = ((Number) obj).longValue();
        String str2 = null;
        if (longValue < 0) {
            longValue = -longValue;
            str = "-";
        } else {
            str = null;
        }
        if (this.alternativeForm) {
            str2 = z ? "0X" : "0x";
        }
        String str3 = str2;
        String hexString = Long.toHexString(longValue);
        appendValue(sb, str, str3, z ? hexString.toUpperCase() : hexString, true);
    }

    private void appendValue(StringBuilder sb, String str, String str2, String str3, boolean z) {
        int i = 0;
        int length = str != null ? str.length() + 0 : 0;
        if (str2 != null) {
            length += str2.length();
        }
        int length2 = this.totalWidth - (length + str3.length());
        if (length2 >= 0) {
            i = length2;
        }
        if (!this.leftAdjust) {
            if (!z || !this.zeroPrefix) {
                appendChars(sb, SPACE_CHARS, i);
            } else {
                if (str != null) {
                    sb.append(str);
                    str = null;
                }
                if (str2 != null) {
                    sb.append(str2);
                    str2 = null;
                }
                appendChars(sb, ZERO_CHARS, i);
            }
        }
        if (str != null) {
            sb.append(str);
        }
        if (str2 != null) {
            sb.append(str2);
        }
        sb.append(str3);
        if (this.leftAdjust) {
            appendChars(sb, SPACE_CHARS, i);
        }
    }

    private void appendChars(StringBuilder sb, String str, int i) {
        while (i > str.length()) {
            sb.append(str);
            i -= str.length();
        }
        sb.append(str, 0, i);
    }

    private Format decimalFormat(int i) {
        if (i == 0) {
            return new DecimalFormat("###0");
        }
        if (i <= 0) {
            return new DecimalFormat("###0.###");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("###0.");
        appendChars(sb, ZERO_CHARS, i);
        return new DecimalFormat(sb.toString());
    }

    private Format scientificFormat(int i) {
        if (i == 0) {
            return new DecimalFormat("0E0");
        }
        if (i <= 0) {
            return new DecimalFormat("0.###E0");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        appendChars(sb, ZERO_CHARS, i);
        sb.append("E0");
        return new DecimalFormat(sb.toString());
    }
}
