package com.j256.simplemagic.entries;

import com.j256.simplemagic.ContentInfoUtil.ErrorCallBack;
import java.util.regex.Pattern;

public class MagicEntryParser {
    private static final String MIME_TYPE_LINE = "!:mime";
    private static final Pattern OFFSET_PATTERN = Pattern.compile("\\(([0-9a-fA-Fx]+)\\.?([bsilBSILm]?)([\\*\\+\\-]?)([0-9a-fA-Fx]*)\\)");
    private static final String OPTIONAL_LINE = "!:optional";
    private static final String UNKNOWN_NAME = "unknown";

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0177  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.j256.simplemagic.entries.MagicEntry parseLine(com.j256.simplemagic.entries.MagicEntry r20, java.lang.String r21, com.j256.simplemagic.ContentInfoUtil.ErrorCallBack r22) {
        /*
            r1 = r21
            r2 = r22
            java.lang.String r0 = "!:"
            boolean r0 = r1.startsWith(r0)
            r3 = 0
            if (r0 == 0) goto L_0x0013
            if (r20 == 0) goto L_0x0012
            handleSpecial(r20, r21, r22)
        L_0x0012:
            return r3
        L_0x0013:
            java.lang.String[] r0 = splitLine(r21, r22)
            if (r0 != 0) goto L_0x001a
            return r3
        L_0x001a:
            r4 = 0
            r5 = r0[r4]
            r6 = 62
            int r5 = r5.lastIndexOf(r6)
            r6 = 1
            if (r5 >= 0) goto L_0x002a
            r5 = r0[r4]
            r9 = 0
            goto L_0x0033
        L_0x002a:
            int r5 = r5 + r6
            r7 = r0[r4]
            java.lang.String r7 = r7.substring(r5)
            r9 = r5
            r5 = r7
        L_0x0033:
            int r7 = r5.length()
            if (r7 != 0) goto L_0x0050
            if (r2 == 0) goto L_0x004f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "invalid offset number:"
            r0.append(r4)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r2.error(r1, r0, r3)
        L_0x004f:
            return r3
        L_0x0050:
            char r7 = r5.charAt(r4)
            r8 = 38
            if (r7 != r8) goto L_0x005e
            java.lang.String r5 = r5.substring(r6)
            r10 = 1
            goto L_0x005f
        L_0x005e:
            r10 = 0
        L_0x005f:
            char r7 = r5.charAt(r4)
            r11 = 40
            if (r7 != r11) goto L_0x0072
            r7 = -1
            com.j256.simplemagic.entries.MagicEntry$OffsetInfo r5 = parseOffset(r5, r1, r2)
            if (r5 != 0) goto L_0x006f
            return r3
        L_0x006f:
            r12 = r5
            r11 = -1
            goto L_0x007c
        L_0x0072:
            java.lang.Integer r7 = java.lang.Integer.decode(r5)     // Catch:{ NumberFormatException -> 0x01a1 }
            int r7 = r7.intValue()     // Catch:{ NumberFormatException -> 0x01a1 }
            r12 = r3
            r11 = r7
        L_0x007c:
            r5 = r0[r6]
            int r7 = r5.indexOf(r8)
            if (r7 < 0) goto L_0x00ad
            int r8 = r7 + 1
            java.lang.String r8 = r5.substring(r8)
            java.lang.Long r13 = java.lang.Long.decode(r8)     // Catch:{ NumberFormatException -> 0x0094 }
            java.lang.String r5 = r5.substring(r4, r7)
            r14 = r13
            goto L_0x00ae
        L_0x0094:
            r0 = move-exception
            r4 = r0
            if (r2 == 0) goto L_0x00ac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "invalid type AND-number: "
            r0.append(r5)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            r2.error(r1, r0, r4)
        L_0x00ac:
            return r3
        L_0x00ad:
            r14 = r3
        L_0x00ae:
            int r7 = r5.length()
            if (r7 != 0) goto L_0x00bc
            if (r2 == 0) goto L_0x00bb
            java.lang.String r0 = "blank type string"
            r2.error(r1, r0, r3)
        L_0x00bb:
            return r3
        L_0x00bc:
            com.j256.simplemagic.entries.MagicMatcher r7 = com.j256.simplemagic.entries.MagicType.matcherfromString(r5)
            if (r7 != 0) goto L_0x0101
            char r8 = r5.charAt(r4)
            r13 = 117(0x75, float:1.64E-43)
            if (r8 != r13) goto L_0x00d4
            java.lang.String r7 = r5.substring(r6)
            com.j256.simplemagic.entries.MagicMatcher r7 = com.j256.simplemagic.entries.MagicType.matcherfromString(r7)
            r8 = 1
            goto L_0x00e5
        L_0x00d4:
            r8 = 47
            int r8 = r5.indexOf(r8)
            if (r8 <= 0) goto L_0x00e4
            java.lang.String r7 = r5.substring(r4, r8)
            com.j256.simplemagic.entries.MagicMatcher r7 = com.j256.simplemagic.entries.MagicType.matcherfromString(r7)
        L_0x00e4:
            r8 = 0
        L_0x00e5:
            if (r7 != 0) goto L_0x00fe
            if (r2 == 0) goto L_0x00fd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "unknown magic type string: "
            r0.append(r4)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r2.error(r1, r0, r3)
        L_0x00fd:
            return r3
        L_0x00fe:
            r13 = r7
            r15 = r8
            goto L_0x0103
        L_0x0101:
            r13 = r7
            r15 = 0
        L_0x0103:
            r7 = 2
            r8 = r0[r7]
            java.lang.String r3 = "x"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0111
            r16 = 0
            goto L_0x0117
        L_0x0111:
            java.lang.Object r3 = r13.convertTestString(r5, r8)     // Catch:{ Exception -> 0x0187 }
            r16 = r3
        L_0x0117:
            int r1 = r0.length
            r2 = 3
            if (r1 != r2) goto L_0x0125
            java.lang.String r0 = "unknown"
            r8 = r0
            r17 = 1
            r18 = 0
            r19 = 0
            goto L_0x0180
        L_0x0125:
            r0 = r0[r2]
            java.lang.String r1 = "\\b"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x0136
            java.lang.String r0 = r0.substring(r7)
        L_0x0133:
            r1 = 0
            r6 = 0
            goto L_0x0152
        L_0x0136:
            java.lang.String r1 = "\b"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x0143
            java.lang.String r0 = r0.substring(r6)
            goto L_0x0133
        L_0x0143:
            java.lang.String r1 = "\\r"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x0151
            java.lang.String r0 = r0.substring(r7)
            r1 = 1
            goto L_0x0152
        L_0x0151:
            r1 = 0
        L_0x0152:
            com.j256.simplemagic.entries.MagicFormatter r3 = new com.j256.simplemagic.entries.MagicFormatter
            r3.<init>(r0)
            java.lang.String r0 = r0.trim()
            r2 = 32
            int r2 = r0.indexOf(r2)
            if (r2 >= 0) goto L_0x0169
            r2 = 9
            int r2 = r0.indexOf(r2)
        L_0x0169:
            if (r2 <= 0) goto L_0x0177
            java.lang.String r0 = r0.substring(r4, r2)
        L_0x016f:
            r8 = r0
            r18 = r1
            r19 = r3
            r17 = r6
            goto L_0x0180
        L_0x0177:
            int r2 = r0.length()
            if (r2 != 0) goto L_0x016f
            java.lang.String r0 = "unknown"
            goto L_0x016f
        L_0x0180:
            com.j256.simplemagic.entries.MagicEntry r0 = new com.j256.simplemagic.entries.MagicEntry
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        L_0x0187:
            r0 = move-exception
            r3 = r0
            if (r2 == 0) goto L_0x019f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "could not convert magic test string: "
            r0.append(r4)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            r2.error(r1, r0, r3)
        L_0x019f:
            r1 = 0
            return r1
        L_0x01a1:
            r0 = move-exception
            if (r2 == 0) goto L_0x01b8
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "invalid offset number:"
            r3.append(r4)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r2.error(r1, r3, r0)
        L_0x01b8:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.simplemagic.entries.MagicEntryParser.parseLine(com.j256.simplemagic.entries.MagicEntry, java.lang.String, com.j256.simplemagic.ContentInfoUtil$ErrorCallBack):com.j256.simplemagic.entries.MagicEntry");
    }

    private static String[] splitLine(String str, ErrorCallBack errorCallBack) {
        int findNonWhitespace = findNonWhitespace(str, 0);
        if (findNonWhitespace < 0) {
            return null;
        }
        int findWhitespaceWithoutEscape = findWhitespaceWithoutEscape(str, findNonWhitespace);
        if (findWhitespaceWithoutEscape < 0) {
            if (errorCallBack != null) {
                errorCallBack.error(str, "invalid number of whitespace separated fields, must be >= 4", null);
            }
            return null;
        }
        String substring = str.substring(findNonWhitespace, findWhitespaceWithoutEscape);
        int findNonWhitespace2 = findNonWhitespace(str, findWhitespaceWithoutEscape + 1);
        if (findNonWhitespace2 < 0) {
            if (errorCallBack != null) {
                errorCallBack.error(str, "invalid number of whitespace separated fields, must be >= 4", null);
            }
            return null;
        }
        int findWhitespaceWithoutEscape2 = findWhitespaceWithoutEscape(str, findNonWhitespace2);
        if (findWhitespaceWithoutEscape2 < 0) {
            if (errorCallBack != null) {
                errorCallBack.error(str, "invalid number of whitespace separated fields, must be >= 4", null);
            }
            return null;
        }
        String substring2 = str.substring(findNonWhitespace2, findWhitespaceWithoutEscape2);
        int findNonWhitespace3 = findNonWhitespace(str, findWhitespaceWithoutEscape2 + 1);
        if (findNonWhitespace3 < 0) {
            if (errorCallBack != null) {
                errorCallBack.error(str, "invalid number of whitespace separated fields, must be >= 4", null);
            }
            return null;
        }
        int findWhitespaceWithoutEscape3 = findWhitespaceWithoutEscape(str, findNonWhitespace3);
        if (findWhitespaceWithoutEscape3 < 0) {
            findWhitespaceWithoutEscape3 = str.length();
        }
        String substring3 = str.substring(findNonWhitespace3, findWhitespaceWithoutEscape3);
        int findNonWhitespace4 = findNonWhitespace(str, findWhitespaceWithoutEscape3 + 1);
        if (findNonWhitespace4 < 0) {
            return new String[]{substring, substring2, substring3};
        }
        return new String[]{substring, substring2, substring3, str.substring(findNonWhitespace4)};
    }

    private static void handleSpecial(MagicEntry magicEntry, String str, ErrorCallBack errorCallBack) {
        if (str.equals(OPTIONAL_LINE)) {
            magicEntry.setOptional(true);
            return;
        }
        int findNonWhitespace = findNonWhitespace(str, 0);
        int findWhitespaceWithoutEscape = findWhitespaceWithoutEscape(str, findNonWhitespace);
        if (findWhitespaceWithoutEscape < 0) {
            if (errorCallBack != null) {
                errorCallBack.error(str, "invalid extension line has less than 2 whitespace separated fields", null);
            }
            return;
        }
        String substring = str.substring(findNonWhitespace, findWhitespaceWithoutEscape);
        int findNonWhitespace2 = findNonWhitespace(str, findWhitespaceWithoutEscape);
        if (findNonWhitespace2 < 0) {
            if (errorCallBack != null) {
                errorCallBack.error(str, "invalid extension line has less than 2 whitespace separated fields", null);
            }
            return;
        }
        int findWhitespaceWithoutEscape2 = findWhitespaceWithoutEscape(str, findNonWhitespace2);
        if (findWhitespaceWithoutEscape2 < 0) {
            findWhitespaceWithoutEscape2 = str.length();
        }
        String substring2 = str.substring(findNonWhitespace2, findWhitespaceWithoutEscape2);
        if (substring.equals(MIME_TYPE_LINE)) {
            magicEntry.setMimeType(substring2);
        }
    }

    private static int findNonWhitespace(String str, int i) {
        while (i < str.length()) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static int findWhitespaceWithoutEscape(String str, int i) {
        boolean z = false;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == ' ') {
                if (!z) {
                    return i;
                }
            } else if (Character.isWhitespace(str.charAt(i))) {
                return i;
            } else {
                if (charAt == '\\') {
                    z = true;
                    i++;
                }
            }
            z = false;
            i++;
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.j256.simplemagic.entries.MagicEntry.OffsetInfo parseOffset(java.lang.String r17, java.lang.String r18, com.j256.simplemagic.ContentInfoUtil.ErrorCallBack r19) {
        /*
            r1 = r17
            r2 = r18
            r3 = r19
            java.util.regex.Pattern r0 = OFFSET_PATTERN
            java.util.regex.Matcher r4 = r0.matcher(r1)
            boolean r0 = r4.matches()
            r5 = 0
            if (r0 != 0) goto L_0x002a
            if (r3 == 0) goto L_0x0029
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "invalid offset pattern: "
            r0.append(r4)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3.error(r2, r0, r5)
        L_0x0029:
            return r5
        L_0x002a:
            r0 = 1
            java.lang.String r6 = r4.group(r0)     // Catch:{ NumberFormatException -> 0x013c }
            java.lang.Integer r6 = java.lang.Integer.decode(r6)     // Catch:{ NumberFormatException -> 0x013c }
            int r6 = r6.intValue()     // Catch:{ NumberFormatException -> 0x013c }
            r7 = 2
            java.lang.String r8 = r4.group(r7)
            if (r8 != 0) goto L_0x0055
            if (r3 == 0) goto L_0x0054
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "invalid long offset type: "
            r0.append(r4)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3.error(r2, r0, r5)
        L_0x0054:
            return r5
        L_0x0055:
            java.lang.String r1 = r4.group(r7)
            int r1 = r1.length()
            r8 = 0
            if (r1 != r0) goto L_0x0069
            java.lang.String r1 = r4.group(r7)
            char r1 = r1.charAt(r8)
            goto L_0x006a
        L_0x0069:
            r1 = 0
        L_0x006a:
            r9 = 66
            r10 = 4
            if (r1 == r9) goto L_0x00d1
            r9 = 73
            if (r1 == r9) goto L_0x00c8
            r9 = 76
            if (r1 == r9) goto L_0x00c1
            r9 = 83
            if (r1 == r9) goto L_0x00b7
            r9 = 98
            if (r1 == r9) goto L_0x00b0
            r9 = 105(0x69, float:1.47E-43)
            if (r1 == r9) goto L_0x00a9
            r0 = 115(0x73, float:1.61E-43)
            if (r1 == r0) goto L_0x00a2
            switch(r1) {
                case 108: goto L_0x009b;
                case 109: goto L_0x0094;
                default: goto L_0x008a;
            }
        L_0x008a:
            com.j256.simplemagic.endian.EndianType r0 = com.j256.simplemagic.endian.EndianType.LITTLE
            com.j256.simplemagic.endian.EndianConverter r0 = r0.getConverter()
        L_0x0090:
            r13 = r0
            r14 = 0
        L_0x0092:
            r15 = 4
            goto L_0x00da
        L_0x0094:
            com.j256.simplemagic.endian.EndianType r0 = com.j256.simplemagic.endian.EndianType.MIDDLE
            com.j256.simplemagic.endian.EndianConverter r0 = r0.getConverter()
            goto L_0x0090
        L_0x009b:
            com.j256.simplemagic.endian.EndianType r0 = com.j256.simplemagic.endian.EndianType.LITTLE
            com.j256.simplemagic.endian.EndianConverter r0 = r0.getConverter()
            goto L_0x0090
        L_0x00a2:
            com.j256.simplemagic.endian.EndianType r0 = com.j256.simplemagic.endian.EndianType.LITTLE
            com.j256.simplemagic.endian.EndianConverter r0 = r0.getConverter()
            goto L_0x00bd
        L_0x00a9:
            com.j256.simplemagic.endian.EndianType r1 = com.j256.simplemagic.endian.EndianType.LITTLE
            com.j256.simplemagic.endian.EndianConverter r1 = r1.getConverter()
            goto L_0x00ce
        L_0x00b0:
            com.j256.simplemagic.endian.EndianType r1 = com.j256.simplemagic.endian.EndianType.LITTLE
            com.j256.simplemagic.endian.EndianConverter r1 = r1.getConverter()
            goto L_0x00d7
        L_0x00b7:
            com.j256.simplemagic.endian.EndianType r0 = com.j256.simplemagic.endian.EndianType.BIG
            com.j256.simplemagic.endian.EndianConverter r0 = r0.getConverter()
        L_0x00bd:
            r13 = r0
            r14 = 0
            r15 = 2
            goto L_0x00da
        L_0x00c1:
            com.j256.simplemagic.endian.EndianType r0 = com.j256.simplemagic.endian.EndianType.BIG
            com.j256.simplemagic.endian.EndianConverter r0 = r0.getConverter()
            goto L_0x0090
        L_0x00c8:
            com.j256.simplemagic.endian.EndianType r1 = com.j256.simplemagic.endian.EndianType.BIG
            com.j256.simplemagic.endian.EndianConverter r1 = r1.getConverter()
        L_0x00ce:
            r13 = r1
            r14 = 1
            goto L_0x0092
        L_0x00d1:
            com.j256.simplemagic.endian.EndianType r1 = com.j256.simplemagic.endian.EndianType.BIG
            com.j256.simplemagic.endian.EndianConverter r1 = r1.getConverter()
        L_0x00d7:
            r13 = r1
            r14 = 0
            r15 = 1
        L_0x00da:
            java.lang.String r0 = r4.group(r10)
            if (r0 == 0) goto L_0x0132
            java.lang.String r0 = r4.group(r10)
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0132
            java.lang.String r0 = r4.group(r10)     // Catch:{ NumberFormatException -> 0x0116 }
            java.lang.Integer r0 = java.lang.Integer.decode(r0)     // Catch:{ NumberFormatException -> 0x0116 }
            int r0 = r0.intValue()     // Catch:{ NumberFormatException -> 0x0116 }
            r1 = 3
            java.lang.String r1 = r4.group(r1)
            java.lang.String r2 = "-"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x0108
            int r8 = -r0
            r12 = r6
            r16 = r8
            goto L_0x0135
        L_0x0108:
            java.lang.String r2 = "-"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0112
            r12 = r0
            goto L_0x0133
        L_0x0112:
            r16 = r0
            r12 = r6
            goto L_0x0135
        L_0x0116:
            r0 = move-exception
            if (r3 == 0) goto L_0x0131
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r6 = "invalid long add value: "
            r1.append(r6)
            java.lang.String r4 = r4.group(r10)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r3.error(r2, r1, r0)
        L_0x0131:
            return r5
        L_0x0132:
            r12 = r6
        L_0x0133:
            r16 = 0
        L_0x0135:
            com.j256.simplemagic.entries.MagicEntry$OffsetInfo r0 = new com.j256.simplemagic.entries.MagicEntry$OffsetInfo
            r11 = r0
            r11.<init>(r12, r13, r14, r15, r16)
            return r0
        L_0x013c:
            r0 = move-exception
            if (r3 == 0) goto L_0x0153
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "invalid long offset number: "
            r4.append(r6)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.error(r2, r1, r0)
        L_0x0153:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.simplemagic.entries.MagicEntryParser.parseOffset(java.lang.String, java.lang.String, com.j256.simplemagic.ContentInfoUtil$ErrorCallBack):com.j256.simplemagic.entries.MagicEntry$OffsetInfo");
    }
}
