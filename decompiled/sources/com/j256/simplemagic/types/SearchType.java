package com.j256.simplemagic.types;

import com.j256.simplemagic.entries.MagicMatcher.MutableOffset;

public class SearchType extends StringType {
    public Object isMatch(Object obj, Long l, boolean z, Object obj2, MutableOffset mutableOffset, byte[] bArr) {
        TestInfo testInfo = (TestInfo) obj;
        int i = testInfo.maxOffset;
        if (testInfo.optionalWhiteSpace) {
            i = bArr.length;
        }
        int length = mutableOffset.offset + i + testInfo.pattern.length();
        if (length > bArr.length) {
            length = bArr.length;
        }
        for (int i2 = mutableOffset.offset; i2 < length; i2++) {
            String findOffsetMatch = findOffsetMatch(testInfo, i2, mutableOffset, bArr, null, bArr.length);
            if (findOffsetMatch != null) {
                return findOffsetMatch;
            }
        }
        return null;
    }
}
