package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;

@TargetApi(12)
final class zzdb<K, V> implements zzp<K, V> {
    private LruCache<K, V> zzbdj;

    zzdb(int i, zzs<K, V> zzs) {
        this.zzbdj = new zzdc(this, 1048576, zzs);
    }

    public final void zza(K k, V v) {
        this.zzbdj.put(k, v);
    }

    public final V get(K k) {
        return this.zzbdj.get(k);
    }
}
