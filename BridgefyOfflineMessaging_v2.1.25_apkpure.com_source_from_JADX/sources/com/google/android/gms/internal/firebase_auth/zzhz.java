package com.google.android.gms.internal.firebase_auth;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzhz<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zzaay;
    /* access modifiers changed from: private */
    public List<zzig> zzaaz;
    /* access modifiers changed from: private */
    public Map<K, V> zzaba;
    private volatile zzii zzabb;
    /* access modifiers changed from: private */
    public Map<K, V> zzabc;
    private volatile zzic zzabd;
    private boolean zzuc;

    static <FieldDescriptorType extends zzfm<FieldDescriptorType>> zzhz<FieldDescriptorType, Object> zzbb(int i) {
        return new zzia(i);
    }

    private zzhz(int i) {
        this.zzaay = i;
        this.zzaaz = Collections.emptyList();
        this.zzaba = Collections.emptyMap();
        this.zzabc = Collections.emptyMap();
    }

    public void zzev() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzuc) {
            if (this.zzaba.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzaba);
            }
            this.zzaba = map;
            if (this.zzabc.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzabc);
            }
            this.zzabc = map2;
            this.zzuc = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzuc;
    }

    public final int zzjf() {
        return this.zzaaz.size();
    }

    public final Entry<K, V> zzbc(int i) {
        return (Entry) this.zzaaz.get(i);
    }

    public final Iterable<Entry<K, V>> zzjg() {
        if (this.zzaba.isEmpty()) {
            return zzid.zzjl();
        }
        return this.zzaba.entrySet();
    }

    public int size() {
        return this.zzaaz.size() + this.zzaba.size();
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((K) comparable) >= 0 || this.zzaba.containsKey(comparable);
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza((K) comparable);
        if (zza >= 0) {
            return ((zzig) this.zzaaz.get(zza)).getValue();
        }
        return this.zzaba.get(comparable);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzji();
        int zza = zza(k);
        if (zza >= 0) {
            return ((zzig) this.zzaaz.get(zza)).setValue(v);
        }
        zzji();
        if (this.zzaaz.isEmpty() && !(this.zzaaz instanceof ArrayList)) {
            this.zzaaz = new ArrayList(this.zzaay);
        }
        int i = -(zza + 1);
        if (i >= this.zzaay) {
            return zzjj().put(k, v);
        }
        if (this.zzaaz.size() == this.zzaay) {
            zzig zzig = (zzig) this.zzaaz.remove(this.zzaay - 1);
            zzjj().put((Comparable) zzig.getKey(), zzig.getValue());
        }
        this.zzaaz.add(i, new zzig(this, k, v));
        return null;
    }

    public void clear() {
        zzji();
        if (!this.zzaaz.isEmpty()) {
            this.zzaaz.clear();
        }
        if (!this.zzaba.isEmpty()) {
            this.zzaba.clear();
        }
    }

    public V remove(Object obj) {
        zzji();
        Comparable comparable = (Comparable) obj;
        int zza = zza((K) comparable);
        if (zza >= 0) {
            return zzbd(zza);
        }
        if (this.zzaba.isEmpty()) {
            return null;
        }
        return this.zzaba.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzbd(int i) {
        zzji();
        V value = ((zzig) this.zzaaz.remove(i)).getValue();
        if (!this.zzaba.isEmpty()) {
            Iterator it = zzjj().entrySet().iterator();
            this.zzaaz.add(new zzig(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    private final int zza(K k) {
        int size = this.zzaaz.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) ((zzig) this.zzaaz.get(size)).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) ((zzig) this.zzaaz.get(i2)).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public Set<Entry<K, V>> entrySet() {
        if (this.zzabb == null) {
            this.zzabb = new zzii(this, null);
        }
        return this.zzabb;
    }

    /* access modifiers changed from: 0000 */
    public final Set<Entry<K, V>> zzjh() {
        if (this.zzabd == null) {
            this.zzabd = new zzic(this, null);
        }
        return this.zzabd;
    }

    /* access modifiers changed from: private */
    public final void zzji() {
        if (this.zzuc) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzjj() {
        zzji();
        if (this.zzaba.isEmpty() && !(this.zzaba instanceof TreeMap)) {
            this.zzaba = new TreeMap();
            this.zzabc = ((TreeMap) this.zzaba).descendingMap();
        }
        return (SortedMap) this.zzaba;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhz)) {
            return super.equals(obj);
        }
        zzhz zzhz = (zzhz) obj;
        int size = size();
        if (size != zzhz.size()) {
            return false;
        }
        int zzjf = zzjf();
        if (zzjf != zzhz.zzjf()) {
            return entrySet().equals(zzhz.entrySet());
        }
        for (int i = 0; i < zzjf; i++) {
            if (!zzbc(i).equals(zzhz.zzbc(i))) {
                return false;
            }
        }
        if (zzjf != size) {
            return this.zzaba.equals(zzhz.zzaba);
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < zzjf(); i2++) {
            i += ((zzig) this.zzaaz.get(i2)).hashCode();
        }
        return this.zzaba.size() > 0 ? i + this.zzaba.hashCode() : i;
    }

    /* synthetic */ zzhz(int i, zzia zzia) {
        this(i);
    }
}
