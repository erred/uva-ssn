package com.google.android.gms.internal.firebase_auth;

import java.util.List;

final class zzgp extends zzgm {
    private zzgp() {
        super();
    }

    /* access modifiers changed from: 0000 */
    public final <L> List<L> zza(Object obj, long j) {
        zzgb zzd = zzd(obj, j);
        if (zzd.zzeu()) {
            return zzd;
        }
        int size = zzd.size();
        zzgb zzj = zzd.zzj(size == 0 ? 10 : size << 1);
        zziw.zza(obj, j, (Object) zzj);
        return zzj;
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(Object obj, long j) {
        zzd(obj, j).zzev();
    }

    /* access modifiers changed from: 0000 */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzgb zzd = zzd(obj, j);
        zzgb zzd2 = zzd(obj2, j);
        int size = zzd.size();
        int size2 = zzd2.size();
        if (size > 0 && size2 > 0) {
            if (!zzd.zzeu()) {
                zzd = zzd.zzj(size2 + size);
            }
            zzd.addAll(zzd2);
        }
        if (size > 0) {
            zzd2 = zzd;
        }
        zziw.zza(obj, j, (Object) zzd2);
    }

    private static <E> zzgb<E> zzd(Object obj, long j) {
        return (zzgb) zziw.zzp(obj, j);
    }
}
