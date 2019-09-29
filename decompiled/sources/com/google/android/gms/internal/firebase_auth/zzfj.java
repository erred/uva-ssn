package com.google.android.gms.internal.firebase_auth;

final class zzfj {
    private static final zzfh<?> zztz = new zzfi();
    private static final zzfh<?> zzua = zzgs();

    private static zzfh<?> zzgs() {
        try {
            return (zzfh) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzfh<?> zzgt() {
        return zztz;
    }

    static zzfh<?> zzgu() {
        if (zzua != null) {
            return zzua;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
