package com.j256.simplemagic.types;

import com.j256.simplemagic.endian.EndianType;

public class FloatType extends DoubleType {
    private static final int BYTES_PER_FLOAT = 4;

    public int getBytesPerType() {
        return 4;
    }

    public FloatType(EndianType endianType) {
        super(endianType);
    }

    public Number decodeValueString(String str) throws NumberFormatException {
        return Float.valueOf(Float.parseFloat(str));
    }

    public int compare(boolean z, Number number, Number number2) {
        float floatValue = number.floatValue();
        float floatValue2 = number2.floatValue();
        if (floatValue > floatValue2) {
            return 1;
        }
        return floatValue < floatValue2 ? -1 : 0;
    }

    /* access modifiers changed from: protected */
    public Object longToObject(Long l) {
        return Float.valueOf(Float.intBitsToFloat(l.intValue()));
    }
}
