package com.j256.simplemagic.endian;

public class BigEndianConverter implements EndianConverter {
    BigEndianConverter() {
    }

    public Long convertNumber(int i, byte[] bArr, int i2) {
        return convertNumber(i, bArr, i2, 8, 255);
    }

    public Long convertId3(int i, byte[] bArr, int i2) {
        return convertNumber(i, bArr, i2, 7, 127);
    }

    public byte[] convertToByteArray(long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((int) (255 & j));
            j >>= 8;
        }
        return bArr;
    }

    private Long convertNumber(int i, byte[] bArr, int i2, int i3, int i4) {
        int i5 = i2 + i;
        if (i5 > bArr.length) {
            return null;
        }
        long j = 0;
        while (i < i5) {
            j = (j << i3) | ((long) (bArr[i] & i4));
            i++;
        }
        return Long.valueOf(j);
    }
}
