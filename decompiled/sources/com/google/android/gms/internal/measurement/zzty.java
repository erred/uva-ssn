package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzty extends zzta<Double> implements zzuu<Double>, zzwg, RandomAccess {
    private static final zzty zzbux;
    private int size;
    private double[] zzbuy;

    zzty() {
        this(new double[10], 0);
    }

    private zzty(double[] dArr, int i) {
        this.zzbuy = dArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzua();
        if (i2 >= i) {
            System.arraycopy(this.zzbuy, i2, this.zzbuy, i, this.size - i2);
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
        if (!(obj instanceof zzty)) {
            return super.equals(obj);
        }
        zzty zzty = (zzty) obj;
        if (this.size != zzty.size) {
            return false;
        }
        double[] dArr = zzty.zzbuy;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzbuy[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzuq.zzbd(Double.doubleToLongBits(this.zzbuy[i2]));
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzd(double d) {
        zzc(this.size, d);
    }

    private final void zzc(int i, double d) {
        zzua();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
        if (this.size < this.zzbuy.length) {
            System.arraycopy(this.zzbuy, i, this.zzbuy, i + 1, this.size - i);
        } else {
            double[] dArr = new double[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzbuy, 0, dArr, 0, i);
            System.arraycopy(this.zzbuy, i, dArr, i + 1, this.size - i);
            this.zzbuy = dArr;
        }
        this.zzbuy[i] = d;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof zzty)) {
            return super.addAll(collection);
        }
        zzty zzty = (zzty) collection;
        if (zzty.size == 0) {
            return false;
        }
        if (BaseClientBuilder.API_PRIORITY_OTHER - this.size >= zzty.size) {
            int i = this.size + zzty.size;
            if (i > this.zzbuy.length) {
                this.zzbuy = Arrays.copyOf(this.zzbuy, i);
            }
            System.arraycopy(zzty.zzbuy, 0, this.zzbuy, this.size, zzty.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzbuy[i]))) {
                System.arraycopy(this.zzbuy, i + 1, this.zzbuy, i, (this.size - i) - 1);
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
        double doubleValue = ((Double) obj).doubleValue();
        zzua();
        zzaj(i);
        double d = this.zzbuy[i];
        this.zzbuy[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final /* synthetic */ Object remove(int i) {
        zzua();
        zzaj(i);
        double d = this.zzbuy[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzbuy, i + 1, this.zzbuy, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Double) obj).doubleValue());
    }

    public final /* synthetic */ zzuu zzal(int i) {
        if (i >= this.size) {
            return new zzty(Arrays.copyOf(this.zzbuy, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzaj(i);
        return Double.valueOf(this.zzbuy[i]);
    }

    static {
        zzty zzty = new zzty();
        zzbux = zzty;
        zzty.zzsw();
    }
}
