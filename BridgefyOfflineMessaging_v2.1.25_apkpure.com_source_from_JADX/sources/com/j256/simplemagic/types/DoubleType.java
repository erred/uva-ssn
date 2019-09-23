package com.j256.simplemagic.types;

import com.j256.simplemagic.endian.EndianType;

public class DoubleType extends NumberType {
    private static final int BYTES_PER_DOUBLE = 8;

    public int getBytesPerType() {
        return 8;
    }

    public byte[] getStartingBytes(Object obj) {
        return null;
    }

    public long maskValue(long j) {
        return j;
    }

    public DoubleType(EndianType endianType) {
        super(endianType);
    }

    public Number decodeValueString(String str) throws NumberFormatException {
        return Double.valueOf(Double.parseDouble(str));
    }

    public Object extractValueFromBytes(int i, byte[] bArr, boolean z) {
        Long convertNumber = this.endianConverter.convertNumber(i, bArr, getBytesPerType());
        if (convertNumber == null) {
            return null;
        }
        return longToObject(convertNumber);
    }

    public int compare(boolean z, Number number, Number number2) {
        double doubleValue = number.doubleValue();
        double doubleValue2 = number2.doubleValue();
        if (doubleValue > doubleValue2) {
            return 1;
        }
        return doubleValue < doubleValue2 ? -1 : 0;
    }

    /* access modifiers changed from: protected */
    public Object longToObject(Long l) {
        return Double.valueOf(Double.longBitsToDouble(l.longValue()));
    }
}
