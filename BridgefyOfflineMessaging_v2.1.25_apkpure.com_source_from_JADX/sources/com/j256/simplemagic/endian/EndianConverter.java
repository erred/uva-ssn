package com.j256.simplemagic.endian;

public interface EndianConverter {
    Long convertId3(int i, byte[] bArr, int i2);

    Long convertNumber(int i, byte[] bArr, int i2);

    byte[] convertToByteArray(long j, int i);
}
