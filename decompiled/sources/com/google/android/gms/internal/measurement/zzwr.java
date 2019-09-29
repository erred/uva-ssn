package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzwr extends zzwx {
    private final /* synthetic */ zzwo zzcby;

    private zzwr(zzwo zzwo) {
        this.zzcby = zzwo;
        super(zzwo, null);
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new zzwq(this.zzcby, null);
    }

    /* synthetic */ zzwr(zzwo zzwo, zzwp zzwp) {
        this(zzwo);
    }
}
