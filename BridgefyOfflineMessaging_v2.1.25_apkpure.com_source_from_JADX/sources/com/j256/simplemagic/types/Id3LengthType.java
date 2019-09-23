package com.j256.simplemagic.types;

import com.google.common.base.Ascii;
import com.j256.simplemagic.endian.EndianType;

public class Id3LengthType extends IntegerType {
    public Id3LengthType(EndianType endianType) {
        super(endianType);
    }

    public Object extractValueFromBytes(int i, byte[] bArr, boolean z) {
        int bytesPerType = getBytesPerType();
        byte[] bArr2 = new byte[bytesPerType];
        for (int i2 = 0; i2 < bytesPerType; i2++) {
            bArr2[i2] = (byte) (bArr[i + i2] & Ascii.DEL);
        }
        return this.endianConverter.convertNumber(0, bArr2, bytesPerType);
    }
}
