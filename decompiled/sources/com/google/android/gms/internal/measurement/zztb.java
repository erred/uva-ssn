package com.google.android.gms.internal.measurement;

final class zztb {
    private static final Class<?> zzbtm = zzfz("libcore.io.Memory");
    private static final boolean zzbtn = (zzfz("org.robolectric.Robolectric") != null);

    static boolean zzub() {
        return zzbtm != null && !zzbtn;
    }

    static Class<?> zzuc() {
        return zzbtm;
    }

    private static <T> Class<T> zzfz(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
