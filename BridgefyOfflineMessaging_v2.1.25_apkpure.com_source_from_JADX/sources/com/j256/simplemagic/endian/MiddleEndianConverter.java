package com.j256.simplemagic.endian;

public class MiddleEndianConverter implements EndianConverter {
    MiddleEndianConverter() {
    }

    public Long convertNumber(int i, byte[] bArr, int i2) {
        return convertNumber(i, bArr, i2, 8, 255);
    }

    public Long convertId3(int i, byte[] bArr, int i2) {
        return convertNumber(i, bArr, i2, 7, 127);
    }

    public byte[] convertToByteArray(long j, int i) {
        if (i != 4) {
            return null;
        }
        return new byte[]{(byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 0) & 255)), (byte) ((int) ((j >> 8) & 255))};
    }

    private Long convertNumber(int i, byte[] bArr, int i2, int i3, int i4) {
        if (i2 != 4) {
            throw new UnsupportedOperationException("Middle-endian only supports 4-byte integers");
        } else if (i + i2 > bArr.length) {
            return null;
        } else {
            return Long.valueOf(((long) (bArr[2] & i4)) | (((((((0 << i3) | ((long) (bArr[1] & i4))) << i3) | ((long) (bArr[0] & i4))) << i3) | ((long) (bArr[3] & i4))) << i3));
        }
    }
}
