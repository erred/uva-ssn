package org.msgpack.core;

import com.bridgefy.sdk.client.StateListener;
import com.google.common.primitives.UnsignedBytes;
import org.msgpack.core.MessagePack.Code;
import org.msgpack.core.annotations.VisibleForTesting;
import org.msgpack.p160b.C3769z;

public enum MessageFormat {
    POSFIXINT(C3769z.INTEGER),
    FIXMAP(C3769z.MAP),
    FIXARRAY(C3769z.ARRAY),
    FIXSTR(C3769z.STRING),
    NIL(C3769z.NIL),
    NEVER_USED(null),
    BOOLEAN(C3769z.BOOLEAN),
    BIN8(C3769z.BINARY),
    BIN16(C3769z.BINARY),
    BIN32(C3769z.BINARY),
    EXT8(C3769z.EXTENSION),
    EXT16(C3769z.EXTENSION),
    EXT32(C3769z.EXTENSION),
    FLOAT32(C3769z.FLOAT),
    FLOAT64(C3769z.FLOAT),
    UINT8(C3769z.INTEGER),
    UINT16(C3769z.INTEGER),
    UINT32(C3769z.INTEGER),
    UINT64(C3769z.INTEGER),
    INT8(C3769z.INTEGER),
    INT16(C3769z.INTEGER),
    INT32(C3769z.INTEGER),
    INT64(C3769z.INTEGER),
    FIXEXT1(C3769z.EXTENSION),
    FIXEXT2(C3769z.EXTENSION),
    FIXEXT4(C3769z.EXTENSION),
    FIXEXT8(C3769z.EXTENSION),
    FIXEXT16(C3769z.EXTENSION),
    STR8(C3769z.STRING),
    STR16(C3769z.STRING),
    STR32(C3769z.STRING),
    ARRAY16(C3769z.ARRAY),
    ARRAY32(C3769z.ARRAY),
    MAP16(C3769z.MAP),
    MAP32(C3769z.MAP),
    NEGFIXINT(C3769z.INTEGER);
    
    private static final MessageFormat[] formatTable = null;
    private final C3769z valueType;

    static {
        formatTable = new MessageFormat[256];
        for (int i = 0; i <= 255; i++) {
            formatTable[i] = toMessageFormat((byte) i);
        }
    }

    private MessageFormat(C3769z zVar) {
        this.valueType = zVar;
    }

    public C3769z getValueType() throws MessageFormatException {
        if (this != NEVER_USED) {
            return this.valueType;
        }
        throw new MessageFormatException("Cannot convert NEVER_USED to ValueType");
    }

    public static MessageFormat valueOf(byte b) {
        return formatTable[b & UnsignedBytes.MAX_VALUE];
    }

    @VisibleForTesting
    static MessageFormat toMessageFormat(byte b) {
        if (Code.isPosFixInt(b)) {
            return POSFIXINT;
        }
        if (Code.isNegFixInt(b)) {
            return NEGFIXINT;
        }
        if (Code.isFixStr(b)) {
            return FIXSTR;
        }
        if (Code.isFixedArray(b)) {
            return FIXARRAY;
        }
        if (Code.isFixedMap(b)) {
            return FIXMAP;
        }
        switch (b) {
            case -64:
                return NIL;
            case -62:
            case -61:
                return BOOLEAN;
            case -60:
                return BIN8;
            case -59:
                return BIN16;
            case -58:
                return BIN32;
            case -57:
                return EXT8;
            case -56:
                return EXT16;
            case -55:
                return EXT32;
            case -54:
                return FLOAT32;
            case -53:
                return FLOAT64;
            case -52:
                return UINT8;
            case -51:
                return UINT16;
            case -50:
                return UINT32;
            case -49:
                return UINT64;
            case -48:
                return INT8;
            case -47:
                return INT16;
            case -46:
                return INT32;
            case -45:
                return INT64;
            case -44:
                return FIXEXT1;
            case -43:
                return FIXEXT2;
            case -42:
                return FIXEXT4;
            case -41:
                return FIXEXT8;
            case StateListener.INITIALIZATION_ERROR /*-40*/:
                return FIXEXT16;
            case -39:
                return STR8;
            case -38:
                return STR16;
            case -37:
                return STR32;
            case -36:
                return ARRAY16;
            case -35:
                return ARRAY32;
            case -34:
                return MAP16;
            case -33:
                return MAP32;
            default:
                return NEVER_USED;
        }
    }
}
