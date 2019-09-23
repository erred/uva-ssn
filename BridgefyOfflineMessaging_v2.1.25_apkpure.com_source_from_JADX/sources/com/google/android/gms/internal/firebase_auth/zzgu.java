package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

public final class zzgu<K, V> {
    static <K, V> void zza(zzfa zzfa, zzgv<K, V> zzgv, K k, V v) throws IOException {
        zzfk.zza(zzfa, zzgv.zzzc, 1, k);
        zzfk.zza(zzfa, zzgv.zzze, 2, v);
    }

    static <K, V> int zza(zzgv<K, V> zzgv, K k, V v) {
        return zzfk.zza(zzgv.zzzc, 1, k) + zzfk.zza(zzgv.zzze, 2, v);
    }
}
