package com.j256.simplemagic.types;

import com.j256.simplemagic.entries.MagicMatcher.MutableOffset;

public class BigEndianString16Type extends StringType {
    /* access modifiers changed from: protected */
    public char bytesToChar(int i, int i2) {
        return (char) ((i << 8) + i2);
    }

    public Object extractValueFromBytes(int i, byte[] bArr, boolean z) {
        while (i < bArr.length - 1 && (bArr[i] != 0 || bArr[i + 1] != 0)) {
            i += 2;
        }
        char[] cArr = new char[(i / 2)];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            int i3 = i2 * 2;
            cArr[i2] = bytesToChar(bArr[i3], bArr[i3 + 1]);
        }
        return cArr;
    }

    public Object isMatch(Object obj, Long l, boolean z, Object obj2, MutableOffset mutableOffset, byte[] bArr) {
        char[] cArr = (char[]) obj2;
        return super.findOffsetMatch((TestInfo) obj, mutableOffset.offset, mutableOffset, null, cArr, cArr.length);
    }
}
