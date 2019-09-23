package com.google.android.gms.internal.measurement;

final class zzvs {
    private static final zzvq zzcam = zzxl();
    private static final zzvq zzcan = new zzvr();

    static zzvq zzxj() {
        return zzcam;
    }

    static zzvq zzxk() {
        return zzcan;
    }

    private static zzvq zzxl() {
        try {
            return (zzvq) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
