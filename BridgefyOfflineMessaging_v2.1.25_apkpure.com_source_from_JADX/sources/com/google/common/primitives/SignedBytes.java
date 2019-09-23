package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import java.util.Comparator;

@GwtCompatible
public final class SignedBytes {
    public static final byte MAX_POWER_OF_TWO = 64;

    private enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        public int compare(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = SignedBytes.compare(bArr[i], bArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return bArr.length - bArr2.length;
        }
    }

    public static int compare(byte b, byte b2) {
        return b - b2;
    }

    public static byte saturatedCast(long j) {
        if (j > 127) {
            return Ascii.DEL;
        }
        if (j < -128) {
            return Byte.MIN_VALUE;
        }
        return (byte) ((int) j);
    }

    private SignedBytes() {
    }

    public static byte checkedCast(long j) {
        byte b = (byte) ((int) j);
        if (((long) b) == j) {
            return b;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Out of range: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    public static byte min(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            if (bArr[i] < b) {
                b = bArr[i];
            }
        }
        return b;
    }

    public static byte max(byte... bArr) {
        Preconditions.checkArgument(bArr.length > 0);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            if (bArr[i] > b) {
                b = bArr[i];
            }
        }
        return b;
    }

    public static String join(String str, byte... bArr) {
        Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 5);
        sb.append(bArr[0]);
        for (int i = 1; i < bArr.length; i++) {
            sb.append(str);
            sb.append(bArr[i]);
        }
        return sb.toString();
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }
}
