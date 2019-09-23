package com.google.android.gms.internal.firebase_auth;

final class zzhl {
    private static final zzhj zzaac = zzit();
    private static final zzhj zzaad = new zzhk();

    static zzhj zzir() {
        return zzaac;
    }

    static zzhj zzis() {
        return zzaad;
    }

    private static zzhj zzit() {
        try {
            return (zzhj) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
