package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzwh {
    private static final zzwh zzcbj = new zzwh();
    private final zzwm zzcbk = new zzvk();
    private final ConcurrentMap<Class<?>, zzwl<?>> zzcbl = new ConcurrentHashMap();

    public static zzwh zzxt() {
        return zzcbj;
    }

    public final <T> zzwl<T> zzi(Class<T> cls) {
        zzuq.zza(cls, "messageType");
        zzwl<T> zzwl = (zzwl) this.zzcbl.get(cls);
        if (zzwl != null) {
            return zzwl;
        }
        zzwl<T> zzh = this.zzcbk.zzh(cls);
        zzuq.zza(cls, "messageType");
        zzuq.zza(zzh, "schema");
        zzwl zzwl2 = (zzwl) this.zzcbl.putIfAbsent(cls, zzh);
        return zzwl2 != null ? zzwl2 : zzh;
    }

    public final <T> zzwl<T> zzak(T t) {
        return zzi(t.getClass());
    }

    private zzwh() {
    }
}
