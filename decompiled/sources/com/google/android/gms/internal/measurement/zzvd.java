package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzvd extends zzta<String> implements zzve, RandomAccess {
    private static final zzvd zzbzx;
    private static final zzve zzbzy = zzbzx;
    private final List<Object> zzbzz;

    public zzvd() {
        this(10);
    }

    public zzvd(int i) {
        this(new ArrayList<>(i));
    }

    private zzvd(ArrayList<Object> arrayList) {
        this.zzbzz = arrayList;
    }

    public final int size() {
        return this.zzbzz.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzua();
        if (collection instanceof zzve) {
            collection = ((zzve) collection).zzxb();
        }
        boolean addAll = this.zzbzz.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzua();
        this.zzbzz.clear();
        this.modCount++;
    }

    public final void zzc(zzte zzte) {
        zzua();
        this.zzbzz.add(zzte);
        this.modCount++;
    }

    public final Object zzbp(int i) {
        return this.zzbzz.get(i);
    }

    private static String zzaa(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzte) {
            return ((zzte) obj).zzud();
        }
        return zzuq.zzm((byte[]) obj);
    }

    public final List<?> zzxb() {
        return Collections.unmodifiableList(this.zzbzz);
    }

    public final zzve zzxc() {
        return zztz() ? new zzxg(this) : this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        String str = (String) obj;
        zzua();
        return zzaa(this.zzbzz.set(i, str));
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* synthetic */ Object remove(int i) {
        zzua();
        Object remove = this.zzbzz.remove(i);
        this.modCount++;
        return zzaa(remove);
    }

    public final /* bridge */ /* synthetic */ boolean zztz() {
        return super.zztz();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        String str = (String) obj;
        zzua();
        this.zzbzz.add(i, str);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ zzuu zzal(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzbzz);
            return new zzvd(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzbzz.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzte) {
            zzte zzte = (zzte) obj;
            String zzud = zzte.zzud();
            if (zzte.zzue()) {
                this.zzbzz.set(i, zzud);
            }
            return zzud;
        }
        byte[] bArr = (byte[]) obj;
        String zzm = zzuq.zzm(bArr);
        if (zzuq.zzl(bArr)) {
            this.zzbzz.set(i, zzm);
        }
        return zzm;
    }

    static {
        zzvd zzvd = new zzvd();
        zzbzx = zzvd;
        zzvd.zzsw();
    }
}
