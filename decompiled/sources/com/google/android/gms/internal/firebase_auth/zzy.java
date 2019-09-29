package com.google.android.gms.internal.firebase_auth;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

public abstract class zzy<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzfm = new Object[0];

    zzy() {
    }

    /* renamed from: zzbo */
    public abstract zzad<E> iterator();

    /* access modifiers changed from: 0000 */
    public Object[] zzbp() {
        return null;
    }

    public final Object[] toArray() {
        return toArray(zzfm);
    }

    public final <T> T[] toArray(T[] tArr) {
        zzv.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzbp = zzbp();
            if (zzbp != null) {
                return Arrays.copyOfRange(zzbp, zzbq(), zzbr(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: 0000 */
    public int zzbq() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: 0000 */
    public int zzbr() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: 0000 */
    public int zza(Object[] objArr, int i) {
        zzad zzad = (zzad) iterator();
        while (zzad.hasNext()) {
            int i2 = i + 1;
            objArr[i] = zzad.next();
            i = i2;
        }
        return i;
    }
}
