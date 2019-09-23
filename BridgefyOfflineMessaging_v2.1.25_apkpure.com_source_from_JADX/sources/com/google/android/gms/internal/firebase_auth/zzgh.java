package com.google.android.gms.internal.firebase_auth;

import java.util.Map.Entry;

final class zzgh<K> implements Entry<K, Object> {
    private Entry<K, zzgf> zzym;

    private zzgh(Entry<K, zzgf> entry) {
        this.zzym = entry;
    }

    public final K getKey() {
        return this.zzym.getKey();
    }

    public final Object getValue() {
        if (((zzgf) this.zzym.getValue()) == null) {
            return null;
        }
        return zzgf.zzia();
    }

    public final zzgf zzib() {
        return (zzgf) this.zzym.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzhc) {
            return ((zzgf) this.zzym.getValue()).zzj((zzhc) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
