package com.j256.simplemagic.endian;

import java.nio.ByteOrder;

public enum EndianType {
    BIG(new BigEndianConverter()),
    LITTLE(new LittleEndianConverter()),
    MIDDLE(new MiddleEndianConverter());
    
    private EndianConverter converter;

    static {
        BIG = new EndianType("BIG", 0, new BigEndianConverter());
        LITTLE = new EndianType("LITTLE", 1, new LittleEndianConverter());
        MIDDLE = new EndianType("MIDDLE", 2, new MiddleEndianConverter());
        NATIVE = new EndianType("NATIVE", 3, (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN ? BIG : LITTLE).getConverter());
        $VALUES = new EndianType[]{BIG, LITTLE, MIDDLE, NATIVE};
    }

    private EndianType(EndianConverter endianConverter) {
        this.converter = endianConverter;
    }

    public EndianConverter getConverter() {
        return this.converter;
    }
}
