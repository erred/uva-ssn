package com.google.android.gms.internal.firebase_auth;

final class zzgz {
    private static final zzgx zzzh = zzim();
    private static final zzgx zzzi = new zzgy();

    static zzgx zzik() {
        return zzzh;
    }

    static zzgx zzil() {
        return zzzi;
    }

    private static zzgx zzim() {
        try {
            return (zzgx) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
