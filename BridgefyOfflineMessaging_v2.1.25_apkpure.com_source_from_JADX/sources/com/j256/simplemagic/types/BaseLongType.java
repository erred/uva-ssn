package com.j256.simplemagic.types;

import com.j256.simplemagic.endian.EndianType;

public abstract class BaseLongType extends NumberType {
    public BaseLongType(EndianType endianType) {
        super(endianType);
    }

    public Number decodeValueString(String str) throws NumberFormatException {
        return Long.decode(str);
    }

    public byte[] getStartingBytes(Object obj) {
        return this.endianConverter.convertToByteArray(((NumberComparison) obj).getValue().longValue(), getBytesPerType());
    }
}
