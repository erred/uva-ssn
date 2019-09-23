package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zztc extends zzta<Boolean> implements zzuu<Boolean>, zzwg, RandomAccess {
    private static final zztc zzbto;
    private int size;
    private boolean[] zzbtp;

    zztc() {
        this(new boolean[10], 0);
    }

    private zztc(boolean[] zArr, int i) {
        this.zzbtp = zArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzua();
        if (i2 >= i) {
            System.arraycopy(this.zzbtp, i2, this.zzbtp, i, this.size - i2);
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
        if (!(obj instanceof zztc)) {
            return super.equals(obj);
        }
        zztc zztc = (zztc) obj;
        if (this.size != zztc.size) {
            return false;
        }
        boolean[] zArr = zztc.zzbtp;
        for (int i = 0; i < this.size; i++) {
            if (this.zzbtp[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzuq.zzu(this.zzbtp[i2]);
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
        zzua();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
        if (this.size < this.zzbtp.length) {
            System.arraycopy(this.zzbtp, i, this.zzbtp, i + 1, this.size - i);
        } else {
            boolean[] zArr = new boolean[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzbtp, 0, zArr, 0, i);
            System.arraycopy(this.zzbtp, i, zArr, i + 1, this.size - i);
            this.zzbtp = zArr;
        }
        this.zzbtp[i] = z;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof zztc)) {
            return super.addAll(collection);
        }
        zztc zztc = (zztc) collection;
        if (zztc.size == 0) {
            return false;
        }
        if (BaseClientBuilder.API_PRIORITY_OTHER - this.size >= zztc.size) {
            int i = this.size + zztc.size;
            if (i > this.zzbtp.length) {
                this.zzbtp = Arrays.copyOf(this.zzbtp, i);
            }
            System.arraycopy(zztc.zzbtp, 0, this.zzbtp, this.size, zztc.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzbtp[i]))) {
                System.arraycopy(this.zzbtp, i + 1, this.zzbtp, i, (this.size - i) - 1);
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzua();
        zzaj(i);
        boolean z = this.zzbtp[i];
        this.zzbtp[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ Object remove(int i) {
        zzua();
        zzaj(i);
        boolean z = this.zzbtp[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzbtp, i + 1, this.zzbtp, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zza(i, ((Boolean) obj).booleanValue());
    }

    public final /* synthetic */ zzuu zzal(int i) {
        if (i >= this.size) {
            return new zztc(Arrays.copyOf(this.zzbtp, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzaj(i);
        return Boolean.valueOf(this.zzbtp[i]);
    }

    static {
        zztc zztc = new zztc();
        zzbto = zztc;
        zztc.zzsw();
    }
}
