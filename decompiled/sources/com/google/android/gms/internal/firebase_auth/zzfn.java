package com.google.android.gms.internal.firebase_auth;

import java.lang.reflect.Type;

public enum zzfn {
    DOUBLE(0, zzfp.SCALAR, zzge.DOUBLE),
    FLOAT(1, zzfp.SCALAR, zzge.FLOAT),
    INT64(2, zzfp.SCALAR, zzge.LONG),
    UINT64(3, zzfp.SCALAR, zzge.LONG),
    INT32(4, zzfp.SCALAR, zzge.INT),
    FIXED64(5, zzfp.SCALAR, zzge.LONG),
    FIXED32(6, zzfp.SCALAR, zzge.INT),
    BOOL(7, zzfp.SCALAR, zzge.BOOLEAN),
    STRING(8, zzfp.SCALAR, zzge.STRING),
    MESSAGE(9, zzfp.SCALAR, zzge.MESSAGE),
    BYTES(10, zzfp.SCALAR, zzge.BYTE_STRING),
    UINT32(11, zzfp.SCALAR, zzge.INT),
    ENUM(12, zzfp.SCALAR, zzge.ENUM),
    SFIXED32(13, zzfp.SCALAR, zzge.INT),
    SFIXED64(14, zzfp.SCALAR, zzge.LONG),
    SINT32(15, zzfp.SCALAR, zzge.INT),
    SINT64(16, zzfp.SCALAR, zzge.LONG),
    GROUP(17, zzfp.SCALAR, zzge.MESSAGE),
    DOUBLE_LIST(18, zzfp.VECTOR, zzge.DOUBLE),
    FLOAT_LIST(19, zzfp.VECTOR, zzge.FLOAT),
    INT64_LIST(20, zzfp.VECTOR, zzge.LONG),
    UINT64_LIST(21, zzfp.VECTOR, zzge.LONG),
    INT32_LIST(22, zzfp.VECTOR, zzge.INT),
    FIXED64_LIST(23, zzfp.VECTOR, zzge.LONG),
    FIXED32_LIST(24, zzfp.VECTOR, zzge.INT),
    BOOL_LIST(25, zzfp.VECTOR, zzge.BOOLEAN),
    STRING_LIST(26, zzfp.VECTOR, zzge.STRING),
    MESSAGE_LIST(27, zzfp.VECTOR, zzge.MESSAGE),
    BYTES_LIST(28, zzfp.VECTOR, zzge.BYTE_STRING),
    UINT32_LIST(29, zzfp.VECTOR, zzge.INT),
    ENUM_LIST(30, zzfp.VECTOR, zzge.ENUM),
    SFIXED32_LIST(31, zzfp.VECTOR, zzge.INT),
    SFIXED64_LIST(32, zzfp.VECTOR, zzge.LONG),
    SINT32_LIST(33, zzfp.VECTOR, zzge.INT),
    SINT64_LIST(34, zzfp.VECTOR, zzge.LONG),
    DOUBLE_LIST_PACKED(35, zzfp.PACKED_VECTOR, zzge.DOUBLE),
    FLOAT_LIST_PACKED(36, zzfp.PACKED_VECTOR, zzge.FLOAT),
    INT64_LIST_PACKED(37, zzfp.PACKED_VECTOR, zzge.LONG),
    UINT64_LIST_PACKED(38, zzfp.PACKED_VECTOR, zzge.LONG),
    INT32_LIST_PACKED(39, zzfp.PACKED_VECTOR, zzge.INT),
    FIXED64_LIST_PACKED(40, zzfp.PACKED_VECTOR, zzge.LONG),
    FIXED32_LIST_PACKED(41, zzfp.PACKED_VECTOR, zzge.INT),
    BOOL_LIST_PACKED(42, zzfp.PACKED_VECTOR, zzge.BOOLEAN),
    UINT32_LIST_PACKED(43, zzfp.PACKED_VECTOR, zzge.INT),
    ENUM_LIST_PACKED(44, zzfp.PACKED_VECTOR, zzge.ENUM),
    SFIXED32_LIST_PACKED(45, zzfp.PACKED_VECTOR, zzge.INT),
    SFIXED64_LIST_PACKED(46, zzfp.PACKED_VECTOR, zzge.LONG),
    SINT32_LIST_PACKED(47, zzfp.PACKED_VECTOR, zzge.INT),
    SINT64_LIST_PACKED(48, zzfp.PACKED_VECTOR, zzge.LONG),
    GROUP_LIST(49, zzfp.VECTOR, zzge.MESSAGE),
    MAP(50, zzfp.MAP, zzge.VOID);
    
    private static final zzfn[] zzwj = null;
    private static final Type[] zzwk = null;

    /* renamed from: id */
    private final int f6663id;
    private final zzge zzwf;
    private final zzfp zzwg;
    private final Class<?> zzwh;
    private final boolean zzwi;

    private zzfn(int i, zzfp zzfp, zzge zzge) {
        this.f6663id = i;
        this.zzwg = zzfp;
        this.zzwf = zzge;
        switch (zzfo.zzwm[zzfp.ordinal()]) {
            case 1:
                this.zzwh = zzge.zzhz();
                break;
            case 2:
                this.zzwh = zzge.zzhz();
                break;
            default:
                this.zzwh = null;
                break;
        }
        boolean z = false;
        if (zzfp == zzfp.SCALAR) {
            switch (zzfo.zzwn[zzge.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    break;
                default:
                    z = true;
                    break;
            }
        }
        this.zzwi = z;
    }

    /* renamed from: id */
    public final int mo14383id() {
        return this.f6663id;
    }

    static {
        int i;
        zzwk = new Type[0];
        zzfn[] values = values();
        zzwj = new zzfn[values.length];
        for (zzfn zzfn : values) {
            zzwj[zzfn.f6663id] = zzfn;
        }
    }
}
