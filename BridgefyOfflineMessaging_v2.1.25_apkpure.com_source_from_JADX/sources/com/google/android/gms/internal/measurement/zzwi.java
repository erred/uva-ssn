package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

final class zzwi<E> extends zzta<E> {
    private static final zzwi<Object> zzcbm;
    private final List<E> zzbzz;

    public static <E> zzwi<E> zzxu() {
        return zzcbm;
    }

    zzwi() {
        this(new ArrayList(10));
    }

    private zzwi(List<E> list) {
        this.zzbzz = list;
    }

    public final void add(int i, E e) {
        zzua();
        this.zzbzz.add(i, e);
        this.modCount++;
    }

    public final E get(int i) {
        return this.zzbzz.get(i);
    }

    public final E remove(int i) {
        zzua();
        E remove = this.zzbzz.remove(i);
        this.modCount++;
        return remove;
    }

    public final E set(int i, E e) {
        zzua();
        E e2 = this.zzbzz.set(i, e);
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.zzbzz.size();
    }

    public final /* synthetic */ zzuu zzal(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzbzz);
            return new zzwi(arrayList);
        }
        throw new IllegalArgumentException();
    }

    static {
        zzwi<Object> zzwi = new zzwi<>();
        zzcbm = zzwi;
        zzwi.zzsw();
    }
}
