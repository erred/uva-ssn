package com.j256.simplemagic.types;

import com.google.common.primitives.UnsignedBytes;
import com.j256.simplemagic.entries.MagicFormatter;
import com.j256.simplemagic.entries.MagicMatcher;
import com.j256.simplemagic.entries.MagicMatcher.MutableOffset;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringType implements MagicMatcher {
    protected static final String EMPTY = "";
    private static final Pattern TYPE_PATTERN = Pattern.compile("[^/]+(/\\d+)?(/[BbcwWt]*)?");

    protected static class TestInfo {
        final boolean caseInsensitive;
        final boolean compactWhiteSpace;
        final int maxOffset;
        final StringOperator operator;
        final boolean optionalWhiteSpace;
        final String pattern;

        public TestInfo(StringOperator stringOperator, String str, boolean z, boolean z2, boolean z3, int i) {
            this.operator = stringOperator;
            this.pattern = str;
            this.compactWhiteSpace = z;
            this.optionalWhiteSpace = z2;
            this.caseInsensitive = z3;
            this.maxOffset = i;
        }

        public byte[] getStartingBytes() {
            if (this.pattern == null || this.pattern.length() < 4) {
                return null;
            }
            return new byte[]{(byte) this.pattern.charAt(0), (byte) this.pattern.charAt(1), (byte) this.pattern.charAt(2), (byte) this.pattern.charAt(3)};
        }

        public String toString() {
            return this.pattern;
        }
    }

    public Object extractValueFromBytes(int i, byte[] bArr, boolean z) {
        return "";
    }

    public Object convertTestString(String str, String str2) {
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        char[] charArray;
        Matcher matcher = TYPE_PATTERN.matcher(str);
        if (!matcher.matches()) {
            TestInfo testInfo = new TestInfo(StringOperator.DEFAULT_OPERATOR, str2, false, false, false, 0);
            return testInfo;
        }
        String group = matcher.group(1);
        if (group == null || group.length() <= 1) {
            i = 0;
        } else {
            try {
                i = Integer.decode(group.substring(1)).intValue();
            } catch (NumberFormatException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid format for search length: ");
                sb.append(str2);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        String group2 = matcher.group(2);
        if (group2 != null) {
            z3 = false;
            z2 = false;
            z = false;
            for (char c : group2.toCharArray()) {
                if (c != 'B') {
                    switch (c) {
                        case 'b':
                            z2 = true;
                            break;
                        case 'c':
                            z = true;
                            break;
                    }
                } else {
                    z3 = true;
                }
            }
        } else {
            z3 = false;
            z2 = false;
            z = false;
        }
        StringOperator fromTest = StringOperator.fromTest(str2);
        if (fromTest == null) {
            fromTest = StringOperator.DEFAULT_OPERATOR;
        } else {
            str2 = str2.substring(1);
        }
        TestInfo testInfo2 = new TestInfo(fromTest, preProcessPattern(str2), z3, z2, z, i);
        return testInfo2;
    }

    public Object isMatch(Object obj, Long l, boolean z, Object obj2, MutableOffset mutableOffset, byte[] bArr) {
        return findOffsetMatch((TestInfo) obj, mutableOffset.offset, mutableOffset, bArr, null, bArr.length);
    }

    public void renderValue(StringBuilder sb, Object obj, MagicFormatter magicFormatter) {
        magicFormatter.format(sb, obj);
    }

    public byte[] getStartingBytes(Object obj) {
        if (obj == null) {
            return null;
        }
        return ((TestInfo) obj).getStartingBytes();
    }

    /* access modifiers changed from: protected */
    public String findOffsetMatch(TestInfo testInfo, int i, MutableOffset mutableOffset, byte[] bArr, char[] cArr, int i2) {
        char[] cArr2;
        char c;
        char charFromByte;
        int i3 = i;
        boolean z = false;
        for (int i4 = 0; i4 < testInfo.pattern.length(); i4++) {
            char charAt = testInfo.pattern.charAt(i4);
            boolean z2 = true;
            if (i4 != testInfo.pattern.length() - 1) {
                z2 = false;
            }
            if (i3 >= i2) {
                return null;
            }
            if (bArr == null) {
                c = cArr[i3];
            } else {
                c = charFromByte(bArr, i3);
            }
            i3++;
            if (!testInfo.operator.doTest(c, charAt, z2)) {
                if ((z || testInfo.optionalWhiteSpace) && Character.isWhitespace(c)) {
                    while (i3 < i2) {
                        if (bArr == null) {
                            charFromByte = cArr[i3];
                        } else {
                            charFromByte = charFromByte(bArr, i3);
                        }
                        i3++;
                        if (!Character.isWhitespace(c)) {
                            break;
                        }
                    }
                    if (testInfo.operator.doTest(c, charAt, z2)) {
                        if (testInfo.compactWhiteSpace) {
                            z = Character.isWhitespace(charAt);
                        }
                    }
                }
                if (!testInfo.caseInsensitive || !Character.isLowerCase(charAt) || !testInfo.operator.doTest(Character.toLowerCase(c), charAt, z2)) {
                    return null;
                }
            } else if (testInfo.compactWhiteSpace) {
                z = Character.isWhitespace(charAt);
            }
        }
        if (bArr == null) {
            cArr2 = Arrays.copyOfRange(cArr, i, i3);
        } else {
            cArr2 = new char[(i3 - i)];
            for (int i5 = 0; i5 < cArr2.length; i5++) {
                cArr2[i5] = charFromByte(bArr, i + i5);
            }
        }
        mutableOffset.offset = i3;
        return new String(cArr2);
    }

    private char charFromByte(byte[] bArr, int i) {
        return (char) (bArr[i] & UnsignedBytes.MAX_VALUE);
    }

    private String preProcessPattern(String str) {
        if (str.indexOf(92) < 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            if (i < str.length()) {
                char charAt = str.charAt(i);
                if (charAt != '\\') {
                    sb.append(charAt);
                } else {
                    i++;
                    if (i >= str.length()) {
                        sb.append(charAt);
                    } else {
                        char charAt2 = str.charAt(i);
                        if (charAt2 == 'b') {
                            sb.append(8);
                        } else if (charAt2 == 'f') {
                            sb.append(12);
                        } else if (charAt2 == 'n') {
                            sb.append(10);
                        } else if (charAt2 == 'r') {
                            sb.append(13);
                        } else if (charAt2 == 't') {
                            sb.append(9);
                        } else if (charAt2 != 'x') {
                            switch (charAt2) {
                                case '0':
                                case '1':
                                case '2':
                                case '3':
                                    if (i + 3 > str.length()) {
                                        if (charAt2 != '0') {
                                            sb.append(charAt2);
                                            break;
                                        } else {
                                            sb.append(0);
                                            break;
                                        }
                                    } else {
                                        int radixCharsToChar = radixCharsToChar(str, i, 3, 8);
                                        if (radixCharsToChar < 0) {
                                            break;
                                        } else {
                                            sb.append((char) radixCharsToChar);
                                            i += 2;
                                            break;
                                        }
                                    }
                                default:
                                    sb.append(charAt2);
                                    break;
                            }
                        } else {
                            int i2 = i + 2;
                            if (i2 < str.length()) {
                                int radixCharsToChar2 = radixCharsToChar(str, i + 1, 2, 16);
                                if (radixCharsToChar2 >= 0) {
                                    sb.append((char) radixCharsToChar2);
                                    i = i2;
                                }
                            } else {
                                sb.append(charAt2);
                            }
                        }
                    }
                }
                i++;
            }
        }
        return sb.toString();
    }

    private int radixCharsToChar(String str, int i, int i2, int i3) {
        if (i + i2 > str.length()) {
            return -1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int digit = Character.digit(str.charAt(i + i5), i3);
            if (digit < 0) {
                return -1;
            }
            i4 = (i4 * i3) + digit;
        }
        return i4;
    }
}
