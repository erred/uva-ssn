package com.j256.simplemagic.types;

import com.j256.simplemagic.endian.EndianType;

public class ByteType extends BaseLongType {
    public int getBytesPerType() {
        return 1;
    }

    public long maskValue(long j) {
        return j & 255;
    }

    public ByteType() {
        super(EndianType.NATIVE);
    }

    public int compare(boolean z, Number number, Number number2) {
        if (z) {
            return LongType.staticCompare(number, number2);
        }
        byte byteValue = number.byteValue();
        byte byteValue2 = number2.byteValue();
        if (byteValue > byteValue2) {
            return 1;
        }
        return byteValue < byteValue2 ? -1 : 0;
    }
}
