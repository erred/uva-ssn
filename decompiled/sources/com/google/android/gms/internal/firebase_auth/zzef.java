package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzef extends zzed<Boolean> implements zzgb<Boolean>, zzhn, RandomAccess {
    private static final zzef zzsm;
    private int size;
    private boolean[] zzsn;

    zzef() {
        this(new boolean[10], 0);
    }

    private zzef(boolean[] zArr, int i) {
        this.zzsn = zArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzew();
        if (i2 >= i) {
            System.arraycopy(this.zzsn, i2, this.zzsn, i, this.size - i2);
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
        if (!(obj instanceof zzef)) {
            return super.equals(obj);
        }
        zzef zzef = (zzef) obj;
        if (this.size != zzef.size) {
            return false;
        }
        boolean[] zArr = zzef.zzsn;
        for (int i = 0; i < this.size; i++) {
            if (this.zzsn[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzfv.zzu(this.zzsn[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void addBoolean(boolean z) {
        zza(this.size, z);
    }

    private final void zza(int i, boolean z) {
        zzew();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
        if (this.size < this.zzsn.length) {
            System.arraycopy(this.zzsn, i, this.zzsn, i + 1, this.size - i);
        } else {
            boolean[] zArr = new boolean[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzsn, 0, zArr, 0, i);
            System.arraycopy(this.zzsn, i, zArr, i + 1, this.size - i);
            this.zzsn = zArr;
        }
        this.zzsn[i] = z;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzew();
        zzfv.checkNotNull(collection);
        if (!(collection instanceof zzef)) {
            return super.addAll(collection);
        }
        zzef zzef = (zzef) collection;
        if (zzef.size == 0) {
            return false;
        }
        if (BaseClientBuilder.API_PRIORITY_OTHER - this.size >= zzef.size) {
            int i = this.size + zzef.size;
            if (i > this.zzsn.length) {
                this.zzsn = Arrays.copyOf(this.zzsn, i);
            }
            System.arraycopy(zzef.zzsn, 0, this.zzsn, this.size, zzef.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzew();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzsn[i]))) {
                System.arraycopy(this.zzsn, i + 1, this.zzsn, i, (this.size - i) - 1);
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzew();
        zzh(i);
        boolean z = this.zzsn[i];
        this.zzsn[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Object remove(int i) {
        zzew();
        zzh(i);
        boolean z = this.zzsn[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzsn, i + 1, this.zzsn, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zza(i, ((Boolean) obj).booleanValue());
    }

    public final /* synthetic */ zzgb zzj(int i) {
        if (i >= this.size) {
            return new zzef(Arrays.copyOf(this.zzsn, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzh(i);
        return Boolean.valueOf(this.zzsn[i]);
    }

    static {
        zzef zzef = new zzef();
        zzsm = zzef;
        zzef.zzev();
    }
}
