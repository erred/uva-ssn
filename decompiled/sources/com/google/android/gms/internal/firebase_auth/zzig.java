package com.google.android.gms.internal.firebase_auth;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Map.Entry;

final class zzig implements Comparable<zzig>, Entry<K, V> {
    private V value;
    private final /* synthetic */ zzhz zzabf;
    private final K zzabi;

    zzig(zzhz zzhz, Entry<K, V> entry) {
        this(zzhz, (Comparable) entry.getKey(), entry.getValue());
    }

    zzig(zzhz zzhz, K k, V v) {
        this.zzabf = zzhz;
        this.zzabi = k;
        this.value = v;
    }

    public final V getValue() {
        return this.value;
    }

    public final V setValue(V v) {
        this.zzabf.zzji();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return equals(this.zzabi, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.zzabi == null ? 0 : this.zzabi.hashCode();
        if (this.value != null) {
            i = this.value.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzabi);
        String valueOf2 = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        sb.append(valueOf2);
        return sb.toString();
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final /* synthetic */ Object getKey() {
        return this.zzabi;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzig) obj).getKey());
    }
}
