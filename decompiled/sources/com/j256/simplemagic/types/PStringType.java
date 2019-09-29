package com.j256.simplemagic.types;

import com.google.common.primitives.UnsignedBytes;
import com.j256.simplemagic.entries.MagicMatcher.MutableOffset;

public class PStringType extends StringType {
    public Object extractValueFromBytes(int i, byte[] bArr, boolean z) {
        if (!z) {
            return "";
        }
        if (i >= bArr.length) {
            return null;
        }
        byte b = bArr[i] & UnsignedBytes.MAX_VALUE;
        int length = (bArr.length - i) - 1;
        if (b > length) {
            b = length;
        }
        char[] cArr = new char[b];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            cArr[i2] = (char) (bArr[i + 1 + i2] & UnsignedBytes.MAX_VALUE);
        }
        return new String(cArr);
    }

    public Object isMatch(Object obj, Long l, boolean z, Object obj2, MutableOffset mutableOffset, byte[] bArr) {
        if (mutableOffset.offset >= bArr.length) {
            return null;
        }
        int i = (bArr[mutableOffset.offset] & UnsignedBytes.MAX_VALUE) + 1;
        if (i > bArr.length) {
            i = bArr.length;
        }
        return findOffsetMatch((TestInfo) obj, mutableOffset.offset + 1, mutableOffset, bArr, null, i);
    }
}
