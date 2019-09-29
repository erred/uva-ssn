package com.j256.simplemagic.types;

import com.j256.simplemagic.endian.EndianType;

public class LongType extends BaseLongType {
    static final int BYTES_PER_LONG = 8;

    public int getBytesPerType() {
        return 8;
    }

    public long maskValue(long j) {
        return j;
    }

    public LongType(EndianType endianType) {
        super(endianType);
    }

    public int compare(boolean z, Number number, Number number2) {
        return staticCompare(number, number2);
    }

    public static int staticCompare(Number number, Number number2) {
        int i = (number.longValue() > number2.longValue() ? 1 : (number.longValue() == number2.longValue() ? 0 : -1));
        if (i > 0) {
            return 1;
        }
        return i < 0 ? -1 : 0;
    }
}
