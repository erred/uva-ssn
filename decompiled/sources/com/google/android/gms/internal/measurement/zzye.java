package com.google.android.gms.internal.measurement;

public final class zzye implements Cloneable {
    private static final zzyf zzcew = new zzyf();
    private int mSize;
    private boolean zzcex;
    private int[] zzcey;
    private zzyf[] zzcez;

    zzye() {
        this(10);
    }

    private zzye(int i) {
        this.zzcex = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzcey = new int[idealIntArraySize];
        this.zzcez = new zzyf[idealIntArraySize];
        this.mSize = 0;
    }

    /* access modifiers changed from: 0000 */
    public final zzyf zzce(int i) {
        int zzcg = zzcg(i);
        if (zzcg < 0 || this.zzcez[zzcg] == zzcew) {
            return null;
        }
        return this.zzcez[zzcg];
    }

    /* access modifiers changed from: 0000 */
    public final void zza(int i, zzyf zzyf) {
        int zzcg = zzcg(i);
        if (zzcg >= 0) {
            this.zzcez[zzcg] = zzyf;
            return;
        }
        int i2 = ~zzcg;
        if (i2 >= this.mSize || this.zzcez[i2] != zzcew) {
            if (this.mSize >= this.zzcey.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                zzyf[] zzyfArr = new zzyf[idealIntArraySize];
                System.arraycopy(this.zzcey, 0, iArr, 0, this.zzcey.length);
                System.arraycopy(this.zzcez, 0, zzyfArr, 0, this.zzcez.length);
                this.zzcey = iArr;
                this.zzcez = zzyfArr;
            }
            if (this.mSize - i2 != 0) {
                int i3 = i2 + 1;
                System.arraycopy(this.zzcey, i2, this.zzcey, i3, this.mSize - i2);
                System.arraycopy(this.zzcez, i2, this.zzcez, i3, this.mSize - i2);
            }
            this.zzcey[i2] = i;
            this.zzcez[i2] = zzyf;
            this.mSize++;
            return;
        }
        this.zzcey[i2] = i;
        this.zzcez[i2] = zzyf;
    }

    /* access modifiers changed from: 0000 */
    public final int size() {
        return this.mSize;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    /* access modifiers changed from: 0000 */
    public final zzyf zzcf(int i) {
        return this.zzcez[i];
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzye)) {
            return false;
        }
        zzye zzye = (zzye) obj;
        if (this.mSize != zzye.mSize) {
            return false;
        }
        int[] iArr = this.zzcey;
        int[] iArr2 = zzye.zzcey;
        int i = this.mSize;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            } else if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            zzyf[] zzyfArr = this.zzcez;
            zzyf[] zzyfArr2 = zzye.zzcez;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!zzyfArr[i4].equals(zzyfArr2[i4])) {
                    z2 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzcey[i2]) * 31) + this.zzcez[i2].hashCode();
        }
        return i;
    }

    private static int idealIntArraySize(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        return i2 / 4;
    }

    private final int zzcg(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzcey[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return ~i3;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzye zzye = new zzye(i);
        System.arraycopy(this.zzcey, 0, zzye.zzcey, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzcez[i2] != null) {
                zzye.zzcez[i2] = (zzyf) this.zzcez[i2].clone();
            }
        }
        zzye.mSize = i;
        return zzye;
    }
}
