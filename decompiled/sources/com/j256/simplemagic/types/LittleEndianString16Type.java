package com.j256.simplemagic.types;

public class LittleEndianString16Type extends BigEndianString16Type {
    /* access modifiers changed from: protected */
    public char bytesToChar(int i, int i2) {
        return (char) ((i2 << 8) + i);
    }
}
