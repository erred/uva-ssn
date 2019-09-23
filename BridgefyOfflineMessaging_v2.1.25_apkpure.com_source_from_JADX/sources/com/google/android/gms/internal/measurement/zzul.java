package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzul extends zzta<Float> implements zzuu<Float>, zzwg, RandomAccess {
    private static final zzul zzbxz;
    private int size;
    private float[] zzbya;

    zzul() {
        this(new float[10], 0);
    }

    private zzul(float[] fArr, int i) {
        this.zzbya = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzua();
        if (i2 >= i) {
            System.arraycopy(this.zzbya, i2, this.zzbya, i, this.size - i2);
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
        if (!(obj instanceof zzul)) {
            return super.equals(obj);
        }
        zzul zzul = (zzul) obj;
        if (this.size != zzul.size) {
            return false;
        }
        float[] fArr = zzul.zzbya;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzbya[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzbya[i2]);
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
        zzua();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzak(i));
        }
        if (this.size < this.zzbya.length) {
            System.arraycopy(this.zzbya, i, this.zzbya, i + 1, this.size - i);
        } else {
            float[] fArr = new float[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzbya, 0, fArr, 0, i);
            System.arraycopy(this.zzbya, i, fArr, i + 1, this.size - i);
            this.zzbya = fArr;
        }
        this.zzbya[i] = f;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof zzul)) {
            return super.addAll(collection);
        }
        zzul zzul = (zzul) collection;
        if (zzul.size == 0) {
            return false;
        }
        if (BaseClientBuilder.API_PRIORITY_OTHER - this.size >= zzul.size) {
            int i = this.size + zzul.size;
            if (i > this.zzbya.length) {
                this.zzbya = Arrays.copyOf(this.zzbya, i);
            }
            System.arraycopy(zzul.zzbya, 0, this.zzbya, this.size, zzul.size);
            this.size = i;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzbya[i]))) {
                System.arraycopy(this.zzbya, i + 1, this.zzbya, i, (this.size - i) - 1);
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
        float floatValue = ((Float) obj).floatValue();
        zzua();
        zzaj(i);
        float f = this.zzbya[i];
        this.zzbya[i] = floatValue;
        return Float.valueOf(f);
    }

    public final /* synthetic */ Object remove(int i) {
        zzua();
        zzaj(i);
        float f = this.zzbya[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzbya, i + 1, this.zzbya, i, (this.size - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Float) obj).floatValue());
    }

    public final /* synthetic */ zzuu zzal(int i) {
        if (i >= this.size) {
            return new zzul(Arrays.copyOf(this.zzbya, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzaj(i);
        return Float.valueOf(this.zzbya[i]);
    }

    static {
        zzul zzul = new zzul();
        zzbxz = zzul;
        zzul.zzsw();
    }
}
