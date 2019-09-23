package com.google.api.client.util.escape;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

public class PercentEscaper extends UnicodeEscaper {
    public static final String SAFECHARS_URLENCODER = "-_.*";
    public static final String SAFEPATHCHARS_URLENCODER = "-_.!~*'()@:$&,;=";
    public static final String SAFEQUERYSTRINGCHARS_URLENCODER = "-_.!~*'()@:$,;/?:";
    public static final String SAFEUSERINFOCHARS_URLENCODER = "-_.!~*'():$&,;=";
    public static final String SAFE_PLUS_RESERVED_CHARS_URLENCODER = "-_.!~*'()@:$&,;=+/?";
    private static final char[] UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    private static final char[] URI_ESCAPED_SPACE = {'+'};
    private final boolean plusForSpace;
    private final boolean[] safeOctets;

    public PercentEscaper(String str, boolean z) {
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        } else if (z && str.contains(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        } else if (!str.contains("%")) {
            this.plusForSpace = z;
            this.safeOctets = createSafeOctets(str);
        } else {
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        }
    }

    private static boolean[] createSafeOctets(String str) {
        char[] charArray = str.toCharArray();
        int i = 122;
        for (char max : charArray) {
            i = Math.max(max, i);
        }
        boolean[] zArr = new boolean[(i + 1)];
        for (int i2 = 48; i2 <= 57; i2++) {
            zArr[i2] = true;
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            zArr[i3] = true;
        }
        for (int i4 = 97; i4 <= 122; i4++) {
            zArr[i4] = true;
        }
        for (char c : charArray) {
            zArr[c] = true;
        }
        return zArr;
    }

    /* access modifiers changed from: protected */
    public int nextEscapeIndex(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if (charAt >= this.safeOctets.length || !this.safeOctets[charAt]) {
                break;
            }
            i++;
        }
        return i;
    }

    public String escape(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt >= this.safeOctets.length || !this.safeOctets[charAt]) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public char[] escape(int i) {
        if (i < this.safeOctets.length && this.safeOctets[i]) {
            return null;
        }
        if (i == 32 && this.plusForSpace) {
            return URI_ESCAPED_SPACE;
        }
        if (i <= 127) {
            char[] cArr = new char[3];
            cArr[0] = '%';
            cArr[2] = UPPER_HEX_DIGITS[i & 15];
            cArr[1] = UPPER_HEX_DIGITS[i >>> 4];
            return cArr;
        } else if (i <= 2047) {
            char[] cArr2 = new char[6];
            cArr2[0] = '%';
            cArr2[3] = '%';
            cArr2[5] = UPPER_HEX_DIGITS[i & 15];
            int i2 = i >>> 4;
            cArr2[4] = UPPER_HEX_DIGITS[(i2 & 3) | 8];
            int i3 = i2 >>> 2;
            cArr2[2] = UPPER_HEX_DIGITS[i3 & 15];
            cArr2[1] = UPPER_HEX_DIGITS[(i3 >>> 4) | 12];
            return cArr2;
        } else if (i <= 65535) {
            char[] cArr3 = new char[9];
            cArr3[0] = '%';
            cArr3[1] = 'E';
            cArr3[3] = '%';
            cArr3[6] = '%';
            cArr3[8] = UPPER_HEX_DIGITS[i & 15];
            int i4 = i >>> 4;
            cArr3[7] = UPPER_HEX_DIGITS[(i4 & 3) | 8];
            int i5 = i4 >>> 2;
            cArr3[5] = UPPER_HEX_DIGITS[i5 & 15];
            int i6 = i5 >>> 4;
            cArr3[4] = UPPER_HEX_DIGITS[(i6 & 3) | 8];
            cArr3[2] = UPPER_HEX_DIGITS[i6 >>> 2];
            return cArr3;
        } else if (i <= 1114111) {
            char[] cArr4 = new char[12];
            cArr4[0] = '%';
            cArr4[1] = 'F';
            cArr4[3] = '%';
            cArr4[6] = '%';
            cArr4[9] = '%';
            cArr4[11] = UPPER_HEX_DIGITS[i & 15];
            int i7 = i >>> 4;
            cArr4[10] = UPPER_HEX_DIGITS[(i7 & 3) | 8];
            int i8 = i7 >>> 2;
            cArr4[8] = UPPER_HEX_DIGITS[i8 & 15];
            int i9 = i8 >>> 4;
            cArr4[7] = UPPER_HEX_DIGITS[(i9 & 3) | 8];
            int i10 = i9 >>> 2;
            cArr4[5] = UPPER_HEX_DIGITS[i10 & 15];
            int i11 = i10 >>> 4;
            cArr4[4] = UPPER_HEX_DIGITS[(i11 & 3) | 8];
            cArr4[2] = UPPER_HEX_DIGITS[(i11 >>> 2) & 7];
            return cArr4;
        } else {
            StringBuilder sb = new StringBuilder(43);
            sb.append("Invalid unicode character value ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
