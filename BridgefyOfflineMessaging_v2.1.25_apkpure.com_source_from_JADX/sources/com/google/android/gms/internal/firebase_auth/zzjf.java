package com.google.android.gms.internal.firebase_auth;

public enum zzjf {
    DOUBLE(zzjk.DOUBLE, 1),
    FLOAT(zzjk.FLOAT, 5),
    INT64(zzjk.LONG, 0),
    UINT64(zzjk.LONG, 0),
    INT32(zzjk.INT, 0),
    FIXED64(zzjk.LONG, 1),
    FIXED32(zzjk.INT, 5),
    BOOL(zzjk.BOOLEAN, 0),
    STRING(zzjk.STRING, 2),
    GROUP(zzjk.MESSAGE, 3),
    MESSAGE(zzjk.MESSAGE, 2),
    BYTES(zzjk.BYTE_STRING, 2),
    UINT32(zzjk.INT, 0),
    ENUM(zzjk.ENUM, 0),
    SFIXED32(zzjk.INT, 5),
    SFIXED64(zzjk.LONG, 1),
    SINT32(zzjk.INT, 0),
    SINT64(zzjk.LONG, 0);
    
    private final zzjk zzadj;
    private final int zzadk;

    private zzjf(zzjk zzjk, int i) {
        this.zzadj = zzjk;
        this.zzadk = i;
    }

    public final zzjk zzjy() {
        return this.zzadj;
    }

    public final int zzjz() {
        return this.zzadk;
    }
}
