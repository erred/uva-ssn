package com.google.android.gms.internal.measurement;

final class zzwe {
    private static final zzwc zzcbh = zzxs();
    private static final zzwc zzcbi = new zzwd();

    static zzwc zzxq() {
        return zzcbh;
    }

    static zzwc zzxr() {
        return zzcbi;
    }

    private static zzwc zzxs() {
        try {
            return (zzwc) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
