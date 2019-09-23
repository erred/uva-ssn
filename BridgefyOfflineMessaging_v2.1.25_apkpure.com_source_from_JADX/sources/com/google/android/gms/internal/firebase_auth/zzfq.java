package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzfq extends zzed<Float> implements zzgb<Float>, zzhn, RandomAccess {
    private static final zzfq zzwu;
    private int size;
    private float[] zzwv;

    zzfq() {
        this(new float[10], 0);
    }

    private zzfq(float[] fArr, int i) {
        this.zzwv = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzew();
        if (i2 >= i) {
            System.arraycopy(this.zzwv, i2, this.zzwv, i, this.size - i2);
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
        if (!(obj instanceof zzfq)) {
            return super.equals(obj);
        }
        zzfq zzfq = (zzfq) obj;
        if (this.size != zzfq.size) {
            return false;
        }
        float[] fArr = zzfq.zzwv;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzwv[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzwv[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(float f) {
        zzc(this.size, f);
    }

    private final void zzc(int i, float f) {
        zzew();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
        if (this.size < this.zzwv.length) {
            System.arraycopy(this.zzwv, i, this.zzwv, i + 1, this.size - i);
        } else {
            float[] fArr = new float[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzwv, 0, fArr, 0, i);
            System.arraycopy(this.zzwv, i, fArr, i + 1, this.size - i);
            this.zzwv = fArr;
        }
        this.zzwv[i] = f;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzew();
        zzfv.checkNotNull(collection);
        if (!(collection instanceof zzfq)) {
            return super.addAll(collection);
        }
        zzfq zzfq = (zzfq) collection;
        if (zzfq.size == 0) {
            return false;
        }
        if (BaseClientBuilder.API_PRIORITY_OTHER - this.size >= zzfq.size) {
            int i = this.size + zzfq.size;
            if (i > this.zzwv.length) {
                this.zzwv = Arrays.copyOf(this.zzwv, i);
            }
            System.arraycopy(zzfq.zzwv, 0, this.zzwv, this.size, zzfq.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzew();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzwv[i]))) {
                System.arraycopy(this.zzwv, i + 1, this.zzwv, i, (this.size - i) - 1);
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
        float floatValue = ((Float) obj).floatValue();
        zzew();
        zzh(i);
        float f = this.zzwv[i];
        this.zzwv[i] = floatValue;
        return Float.valueOf(f);
    }

    public final /* synthetic */ Object remove(int i) {
        zzew();
        zzh(i);
        float f = this.zzwv[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzwv, i + 1, this.zzwv, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Float) obj).floatValue());
    }

    public final /* synthetic */ zzgb zzj(int i) {
        if (i >= this.size) {
            return new zzfq(Arrays.copyOf(this.zzwv, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzh(i);
        return Float.valueOf(this.zzwv[i]);
    }

    static {
        zzfq zzfq = new zzfq();
        zzwu = zzfq;
        zzfq.zzev();
    }
}
