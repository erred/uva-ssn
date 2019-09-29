package com.google.android.gms.internal.measurement;

final class zzue {
    private static final zzuc<?> zzbvf = new zzud();
    private static final zzuc<?> zzbvg = zzvt();

    private static zzuc<?> zzvt() {
        try {
            return (zzuc) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzuc<?> zzvu() {
        return zzbvf;
    }

    static zzuc<?> zzvv() {
        if (zzbvg != null) {
            return zzbvg;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
