package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzfd extends zzed<Double> implements zzgb<Double>, zzhn, RandomAccess {
    private static final zzfd zztr;
    private int size;
    private double[] zzts;

    zzfd() {
        this(new double[10], 0);
    }

    private zzfd(double[] dArr, int i) {
        this.zzts = dArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzew();
        if (i2 >= i) {
            System.arraycopy(this.zzts, i2, this.zzts, i, this.size - i2);
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
        if (!(obj instanceof zzfd)) {
            return super.equals(obj);
        }
        zzfd zzfd = (zzfd) obj;
        if (this.size != zzfd.size) {
            return false;
        }
        double[] dArr = zzfd.zzts;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzts[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzfv.zzk(Double.doubleToLongBits(this.zzts[i2]));
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(double d) {
        zzc(this.size, d);
    }

    private final void zzc(int i, double d) {
        zzew();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
        if (this.size < this.zzts.length) {
            System.arraycopy(this.zzts, i, this.zzts, i + 1, this.size - i);
        } else {
            double[] dArr = new double[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzts, 0, dArr, 0, i);
            System.arraycopy(this.zzts, i, dArr, i + 1, this.size - i);
            this.zzts = dArr;
        }
        this.zzts[i] = d;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzew();
        zzfv.checkNotNull(collection);
        if (!(collection instanceof zzfd)) {
            return super.addAll(collection);
        }
        zzfd zzfd = (zzfd) collection;
        if (zzfd.size == 0) {
            return false;
        }
        if (BaseClientBuilder.API_PRIORITY_OTHER - this.size >= zzfd.size) {
            int i = this.size + zzfd.size;
            if (i > this.zzts.length) {
                this.zzts = Arrays.copyOf(this.zzts, i);
            }
            System.arraycopy(zzfd.zzts, 0, this.zzts, this.size, zzfd.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzew();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzts[i]))) {
                System.arraycopy(this.zzts, i + 1, this.zzts, i, (this.size - i) - 1);
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
        double doubleValue = ((Double) obj).doubleValue();
        zzew();
        zzh(i);
        double d = this.zzts[i];
        this.zzts[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final /* synthetic */ Object remove(int i) {
        zzew();
        zzh(i);
        double d = this.zzts[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzts, i + 1, this.zzts, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Double) obj).doubleValue());
    }

    public final /* synthetic */ zzgb zzj(int i) {
        if (i >= this.size) {
            return new zzfd(Arrays.copyOf(this.zzts, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzh(i);
        return Double.valueOf(this.zzts[i]);
    }

    static {
        zzfd zzfd = new zzfd();
        zztr = zzfd;
        zzfd.zzev();
    }
}
