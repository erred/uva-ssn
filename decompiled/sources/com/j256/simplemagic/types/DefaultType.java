package com.j256.simplemagic.types;

import com.j256.simplemagic.entries.MagicFormatter;
import com.j256.simplemagic.entries.MagicMatcher;
import com.j256.simplemagic.entries.MagicMatcher.MutableOffset;

public class DefaultType implements MagicMatcher {
    private static final String EMPTY = "";

    public Object convertTestString(String str, String str2) {
        return "";
    }

    public Object extractValueFromBytes(int i, byte[] bArr, boolean z) {
        return "";
    }

    public byte[] getStartingBytes(Object obj) {
        return null;
    }

    public Object isMatch(Object obj, Long l, boolean z, Object obj2, MutableOffset mutableOffset, byte[] bArr) {
        return "";
    }

    public void renderValue(StringBuilder sb, Object obj, MagicFormatter magicFormatter) {
        magicFormatter.format(sb, obj);
    }
}
