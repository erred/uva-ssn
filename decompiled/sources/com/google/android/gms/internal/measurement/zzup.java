package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzup extends zzta<Integer> implements zzuu<Integer>, zzwg, RandomAccess {
    private static final zzup zzbyy;
    private int size;
    private int[] zzbyz;

    zzup() {
        this(new int[10], 0);
    }

    private zzup(int[] iArr, int i) {
        this.zzbyz = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzua();
        if (i2 >= i) {
            System.arraycopy(this.zzbyz, i2, this.zzbyz, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzup)) {
            return super.equals(obj);
        }
        zzup zzup = (zzup) obj;
        if (this.size != zzup.size) {
            return false;
        }
        int[] iArr = zzup.zzbyz;
        for (int i = 0; i < this.size; i++) {
            if (this.zzbyz[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzbyz[i2];
        }
        return i;
    }

    public final int getInt(int i) {
        zzaj(i);
        return this.zzbyz[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzbo(int i) {
        zzp(this.size, i);
    }

    private final void zzp(int i, int i2) {
        zzua();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
        if (this.size < this.zzbyz.length) {
            System.arraycopy(this.zzbyz, i, this.zzbyz, i + 1, this.size - i);
        } else {
            int[] iArr = new int[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzbyz, 0, iArr, 0, i);
            System.arraycopy(this.zzbyz, i, iArr, i + 1, this.size - i);
            this.zzbyz = iArr;
        }
        this.zzbyz[i] = i2;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof zzup)) {
            return super.addAll(collection);
        }
        zzup zzup = (zzup) collection;
        if (zzup.size == 0) {
            return false;
        }
        if (BaseClientBuilder.API_PRIORITY_OTHER - this.size >= zzup.size) {
            int i = this.size + zzup.size;
            if (i > this.zzbyz.length) {
                this.zzbyz = Arrays.copyOf(this.zzbyz, i);
            }
            System.arraycopy(zzup.zzbyz, 0, this.zzbyz, this.size, zzup.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzbyz[i]))) {
                System.arraycopy(this.zzbyz, i + 1, this.zzbyz, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzaj(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
    }

    private final String zzak(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzua();
        zzaj(i);
        int i2 = this.zzbyz[i];
        this.zzbyz[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzua();
        zzaj(i);
        int i2 = this.zzbyz[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzbyz, i + 1, this.zzbyz, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzp(i, ((Integer) obj).intValue());
    }

    public final /* synthetic */ zzuu zzal(int i) {
        if (i >= this.size) {
            return new zzup(Arrays.copyOf(this.zzbyz, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzup zzup = new zzup();
        zzbyy = zzup;
        zzup.zzsw();
    }
}
