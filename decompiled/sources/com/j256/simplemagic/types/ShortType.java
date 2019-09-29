package com.j256.simplemagic.types;

import com.j256.simplemagic.endian.EndianType;

public class ShortType extends BaseLongType {
    private static final int BYTES_PER_SHORT = 2;

    public int getBytesPerType() {
        return 2;
    }

    public long maskValue(long j) {
        return j & 65535;
    }

    public ShortType(EndianType endianType) {
        super(endianType);
    }

    public int compare(boolean z, Number number, Number number2) {
        if (z) {
            return LongType.staticCompare(number, number2);
        }
        short shortValue = number.shortValue();
        short shortValue2 = number2.shortValue();
        if (shortValue > shortValue2) {
            return 1;
        }
        return shortValue < shortValue2 ? -1 : 0;
    }
}
