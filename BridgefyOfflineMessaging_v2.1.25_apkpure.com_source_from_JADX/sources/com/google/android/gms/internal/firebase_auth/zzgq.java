package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgq extends zzed<Long> implements zzgb<Long>, zzhn, RandomAccess {
    private static final zzgq zzyx;
    private int size;
    private long[] zzyy;

    zzgq() {
        this(new long[10], 0);
    }

    private zzgq(long[] jArr, int i) {
        this.zzyy = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzew();
        if (i2 >= i) {
            System.arraycopy(this.zzyy, i2, this.zzyy, i, this.size - i2);
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
        if (!(obj instanceof zzgq)) {
            return super.equals(obj);
        }
        zzgq zzgq = (zzgq) obj;
        if (this.size != zzgq.size) {
            return false;
        }
        long[] jArr = zzgq.zzyy;
        for (int i = 0; i < this.size; i++) {
            if (this.zzyy[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzfv.zzk(this.zzyy[i2]);
        }
        return i;
    }

    public final long getLong(int i) {
        zzh(i);
        return this.zzyy[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzl(long j) {
        zzk(this.size, j);
    }

    private final void zzk(int i, long j) {
        zzew();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
        if (this.size < this.zzyy.length) {
            System.arraycopy(this.zzyy, i, this.zzyy, i + 1, this.size - i);
        } else {
            long[] jArr = new long[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzyy, 0, jArr, 0, i);
            System.arraycopy(this.zzyy, i, jArr, i + 1, this.size - i);
            this.zzyy = jArr;
        }
        this.zzyy[i] = j;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzew();
        zzfv.checkNotNull(collection);
        if (!(collection instanceof zzgq)) {
            return super.addAll(collection);
        }
        zzgq zzgq = (zzgq) collection;
        if (zzgq.size == 0) {
            return false;
        }
        if (BaseClientBuilder.API_PRIORITY_OTHER - this.size >= zzgq.size) {
            int i = this.size + zzgq.size;
            if (i > this.zzyy.length) {
                this.zzyy = Arrays.copyOf(this.zzyy, i);
            }
            System.arraycopy(zzgq.zzyy, 0, this.zzyy, this.size, zzgq.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzew();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzyy[i]))) {
                System.arraycopy(this.zzyy, i + 1, this.zzyy, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzh(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
    }

    private final String zzi(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzew();
        zzh(i);
        long j = this.zzyy[i];
        this.zzyy[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        zzew();
        zzh(i);
        long j = this.zzyy[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzyy, i + 1, this.zzyy, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzk(i, ((Long) obj).longValue());
    }

    public final /* synthetic */ zzgb zzj(int i) {
        if (i >= this.size) {
            return new zzgq(Arrays.copyOf(this.zzyy, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        zzgq zzgq = new zzgq();
        zzyx = zzgq;
        zzgq.zzev();
    }
}
