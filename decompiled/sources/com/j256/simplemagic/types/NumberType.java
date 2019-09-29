package com.j256.simplemagic.types;

import com.j256.simplemagic.endian.EndianConverter;
import com.j256.simplemagic.endian.EndianType;
import com.j256.simplemagic.entries.MagicFormatter;
import com.j256.simplemagic.entries.MagicMatcher;
import com.j256.simplemagic.entries.MagicMatcher.MutableOffset;

public abstract class NumberType implements MagicMatcher {
    protected final EndianConverter endianConverter;

    public abstract int compare(boolean z, Number number, Number number2);

    public abstract Number decodeValueString(String str) throws NumberFormatException;

    public abstract int getBytesPerType();

    public abstract long maskValue(long j);

    public NumberType(EndianType endianType) {
        this.endianConverter = endianType.getConverter();
    }

    public Object convertTestString(String str, String str2) {
        return new NumberComparison(this, str2);
    }

    public Object extractValueFromBytes(int i, byte[] bArr, boolean z) {
        return this.endianConverter.convertNumber(i, bArr, getBytesPerType());
    }

    public Object isMatch(Object obj, Long l, boolean z, Object obj2, MutableOffset mutableOffset, byte[] bArr) {
        if (!((NumberComparison) obj).isMatch(l, z, (Number) obj2)) {
            return null;
        }
        mutableOffset.offset += getBytesPerType();
        return obj2;
    }

    public void renderValue(StringBuilder sb, Object obj, MagicFormatter magicFormatter) {
        magicFormatter.format(sb, obj);
    }
}
