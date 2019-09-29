package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo.zze;
import java.io.IOException;
import java.util.Arrays;

public final class zzxe {
    private static final zzxe zzccf = new zzxe(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzbtl;
    private int zzbye;
    private Object[] zzcar;
    private int[] zzccg;

    public static zzxe zzyl() {
        return zzccf;
    }

    static zzxe zzym() {
        return new zzxe();
    }

    static zzxe zza(zzxe zzxe, zzxe zzxe2) {
        int i = zzxe.count + zzxe2.count;
        int[] copyOf = Arrays.copyOf(zzxe.zzccg, i);
        System.arraycopy(zzxe2.zzccg, 0, copyOf, zzxe.count, zzxe2.count);
        Object[] copyOf2 = Arrays.copyOf(zzxe.zzcar, i);
        System.arraycopy(zzxe2.zzcar, 0, copyOf2, zzxe.count, zzxe2.count);
        return new zzxe(i, copyOf, copyOf2, true);
    }

    private zzxe() {
        this(0, new int[8], new Object[8], true);
    }

    private zzxe(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzbye = -1;
        this.count = i;
        this.zzccg = iArr;
        this.zzcar = objArr;
        this.zzbtl = z;
    }

    public final void zzsw() {
        this.zzbtl = false;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzxy zzxy) throws IOException {
        if (zzxy.zzvm() == zze.zzbyw) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzxy.zza(this.zzccg[i] >>> 3, this.zzcar[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzxy.zza(this.zzccg[i2] >>> 3, this.zzcar[i2]);
        }
    }

    public final void zzb(zzxy zzxy) throws IOException {
        if (this.count != 0) {
            if (zzxy.zzvm() == zze.zzbyv) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzccg[i], this.zzcar[i], zzxy);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzccg[i2], this.zzcar[i2], zzxy);
            }
        }
    }

    private static void zzb(int i, Object obj, zzxy zzxy) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 != 5) {
            switch (i3) {
                case 0:
                    zzxy.zzi(i2, ((Long) obj).longValue());
                    return;
                case 1:
                    zzxy.zzc(i2, ((Long) obj).longValue());
                    return;
                case 2:
                    zzxy.zza(i2, (zzte) obj);
                    return;
                case 3:
                    if (zzxy.zzvm() == zze.zzbyv) {
                        zzxy.zzbm(i2);
                        ((zzxe) obj).zzb(zzxy);
                        zzxy.zzbn(i2);
                        return;
                    }
                    zzxy.zzbn(i2);
                    ((zzxe) obj).zzb(zzxy);
                    zzxy.zzbm(i2);
                    return;
                default:
                    throw new RuntimeException(zzuv.zzwu());
            }
        } else {
            zzxy.zzg(i2, ((Integer) obj).intValue());
        }
    }

    public final int zzyn() {
        int i = this.zzbye;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zztv.zzd(this.zzccg[i3] >>> 3, (zzte) this.zzcar[i3]);
        }
        this.zzbye = i2;
        return i2;
    }

    public final int zzvx() {
        int i;
        int i2 = this.zzbye;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzccg[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 != 5) {
                switch (i7) {
                    case 0:
                        i = zztv.zze(i6, ((Long) this.zzcar[i4]).longValue());
                        break;
                    case 1:
                        i = zztv.zzg(i6, ((Long) this.zzcar[i4]).longValue());
                        break;
                    case 2:
                        i = zztv.zzc(i6, (zzte) this.zzcar[i4]);
                        break;
                    case 3:
                        i = (zztv.zzbd(i6) << 1) + ((zzxe) this.zzcar[i4]).zzvx();
                        break;
                    default:
                        throw new IllegalStateException(zzuv.zzwu());
                }
            } else {
                i = zztv.zzk(i6, ((Integer) this.zzcar[i4]).intValue());
            }
            i3 += i;
        }
        this.zzbye = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzxe)) {
            return false;
        }
        zzxe zzxe = (zzxe) obj;
        if (this.count == zzxe.count) {
            int[] iArr = this.zzccg;
            int[] iArr2 = zzxe.zzccg;
            int i = this.count;
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
                Object[] objArr = this.zzcar;
                Object[] objArr2 = zzxe.zzcar;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = (this.count + 527) * 31;
        int[] iArr = this.zzccg;
        int i2 = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < this.count; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i + i3) * 31;
        Object[] objArr = this.zzcar;
        for (int i6 = 0; i6 < this.count; i6++) {
            i2 = (i2 * 31) + objArr[i6].hashCode();
        }
        return i5 + i2;
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzvy.zzb(sb, i, String.valueOf(this.zzccg[i2] >>> 3), this.zzcar[i2]);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(int i, Object obj) {
        if (this.zzbtl) {
            if (this.count == this.zzccg.length) {
                int i2 = this.count + (this.count < 4 ? 8 : this.count >> 1);
                this.zzccg = Arrays.copyOf(this.zzccg, i2);
                this.zzcar = Arrays.copyOf(this.zzcar, i2);
            }
            this.zzccg[this.count] = i;
            this.zzcar[this.count] = obj;
            this.count++;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
