package com.google.android.gms.internal.firebase_auth;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzho {
    private static final zzho zzaae = new zzho();
    private final zzhx zzaaf = new zzgr();
    private final ConcurrentMap<Class<?>, zzhw<?>> zzaag = new ConcurrentHashMap();

    public static zzho zziu() {
        return zzaae;
    }

    public final <T> zzhw<T> zzf(Class<T> cls) {
        zzfv.zza(cls, "messageType");
        zzhw<T> zzhw = (zzhw) this.zzaag.get(cls);
        if (zzhw != null) {
            return zzhw;
        }
        zzhw<T> zze = this.zzaaf.zze(cls);
        zzfv.zza(cls, "messageType");
        zzfv.zza(zze, "schema");
        zzhw zzhw2 = (zzhw) this.zzaag.putIfAbsent(cls, zze);
        return zzhw2 != null ? zzhw2 : zze;
    }

    public final <T> zzhw<T> zzr(T t) {
        return zzf(t.getClass());
    }

    private zzho() {
    }
}
