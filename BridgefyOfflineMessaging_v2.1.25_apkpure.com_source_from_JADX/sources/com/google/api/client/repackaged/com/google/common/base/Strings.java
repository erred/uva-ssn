package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.GwtCompatible;
import com.google.api.client.repackaged.com.google.common.annotations.VisibleForTesting;

@GwtCompatible
public final class Strings {
    public static String nullToEmpty(String str) {
        return str == null ? "" : str;
    }

    private Strings() {
    }

    public static String emptyToNull(String str) {
        if (isNullOrEmpty(str)) {
            return null;
        }
        return str;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String padStart(String str, int i, char c) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i);
        for (int length = str.length(); length < i; length++) {
            sb.append(c);
        }
        sb.append(str);
        return sb.toString();
    }

    public static String padEnd(String str, int i, char c) {
        Preconditions.checkNotNull(str);
        if (str.length() >= i) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        for (int length = str.length(); length < i; length++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String repeat(String str, int i) {
        Preconditions.checkNotNull(str);
        if (i <= 1) {
            Preconditions.checkArgument(i >= 0, "invalid count: %s", Integer.valueOf(i));
            if (i == 0) {
                str = "";
            }
            return str;
        }
        int length = str.length();
        long j = ((long) length) * ((long) i);
        int i2 = (int) j;
        if (((long) i2) == j) {
            char[] cArr = new char[i2];
            str.getChars(0, length, cArr, 0);
            while (true) {
                int i3 = i2 - length;
                if (length < i3) {
                    System.arraycopy(cArr, 0, cArr, length, length);
                    length <<= 1;
                } else {
                    System.arraycopy(cArr, 0, cArr, length, i3);
                    return new String(cArr);
                }
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Required array size too large: ");
            sb.append(j);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
    }

    public static String commonPrefix(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i = 0;
        while (i < min && charSequence.charAt(i) == charSequence2.charAt(i)) {
            i++;
        }
        int i2 = i - 1;
        if (validSurrogatePairAt(charSequence, i2) || validSurrogatePairAt(charSequence2, i2)) {
            i--;
        }
        return charSequence.subSequence(0, i).toString();
    }

    public static String commonSuffix(CharSequence charSequence, CharSequence charSequence2) {
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(charSequence2);
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i = 0;
        while (i < min && charSequence.charAt((charSequence.length() - i) - 1) == charSequence2.charAt((charSequence2.length() - i) - 1)) {
            i++;
        }
        if (validSurrogatePairAt(charSequence, (charSequence.length() - i) - 1) || validSurrogatePairAt(charSequence2, (charSequence2.length() - i) - 1)) {
            i--;
        }
        return charSequence.subSequence(charSequence.length() - i, charSequence.length()).toString();
    }

    @VisibleForTesting
    static boolean validSurrogatePairAt(CharSequence charSequence, int i) {
        return i >= 0 && i <= charSequence.length() + -2 && Character.isHighSurrogate(charSequence.charAt(i)) && Character.isLowSurrogate(charSequence.charAt(i + 1));
    }
}
