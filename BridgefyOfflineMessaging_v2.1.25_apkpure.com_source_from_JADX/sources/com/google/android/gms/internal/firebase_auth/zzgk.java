package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzgk extends zzed<String> implements zzgl, RandomAccess {
    private static final zzgk zzyr;
    private static final zzgl zzys = zzyr;
    private final List<Object> zzyt;

    public zzgk() {
        this(10);
    }

    public zzgk(int i) {
        this(new ArrayList<>(i));
    }

    private zzgk(ArrayList<Object> arrayList) {
        this.zzyt = arrayList;
    }

    public final int size() {
        return this.zzyt.size();
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzew();
        if (collection instanceof zzgl) {
            collection = ((zzgl) collection).zzic();
        }
        boolean addAll = this.zzyt.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        zzew();
        this.zzyt.clear();
        this.modCount++;
    }

    public final void zzc(zzeh zzeh) {
        zzew();
        this.zzyt.add(zzeh);
        this.modCount++;
    }

    public final Object zzat(int i) {
        return this.zzyt.get(i);
    }

    private static String zzh(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeh) {
            return ((zzeh) obj).zzfa();
        }
        return zzfv.zze((byte[]) obj);
    }

    public final List<?> zzic() {
        return Collections.unmodifiableList(this.zzyt);
    }

    public final zzgl zzid() {
        return zzeu() ? new zzit(this) : this;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        String str = (String) obj;
        zzew();
        return zzh(this.zzyt.set(i, str));
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
        zzew();
        Object remove = this.zzyt.remove(i);
        this.modCount++;
        return zzh(remove);
    }

    public final /* bridge */ /* synthetic */ boolean zzeu() {
        return super.zzeu();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        String str = (String) obj;
        zzew();
        this.zzyt.add(i, str);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ zzgb zzj(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzyt);
            return new zzgk(arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzyt.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeh) {
            zzeh zzeh = (zzeh) obj;
            String zzfa = zzeh.zzfa();
            if (zzeh.zzfb()) {
                this.zzyt.set(i, zzfa);
            }
            return zzfa;
        }
        byte[] bArr = (byte[]) obj;
        String zze = zzfv.zze(bArr);
        if (zzfv.zzd(bArr)) {
            this.zzyt.set(i, zze);
        }
        return zze;
    }

    static {
        zzgk zzgk = new zzgk();
        zzyr = zzgk;
        zzgk.zzev();
    }
}
