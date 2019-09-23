package com.j256.simplemagic.types;

import com.j256.simplemagic.endian.EndianType;

public class IntegerType extends BaseLongType {
    private static final int BYTES_PER_INTEGER = 4;

    public int getBytesPerType() {
        return 4;
    }

    public long maskValue(long j) {
        return j & 4294967295L;
    }

    public IntegerType(EndianType endianType) {
        super(endianType);
    }

    public int compare(boolean z, Number number, Number number2) {
        if (z) {
            return LongType.staticCompare(number, number2);
        }
        int intValue = number.intValue();
        int intValue2 = number2.intValue();
        if (intValue > intValue2) {
            return 1;
        }
        return intValue < intValue2 ? -1 : 0;
    }
}
