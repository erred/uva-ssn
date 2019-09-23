package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft.zze;
import java.io.IOException;
import java.util.Arrays;

public final class zzir {
    private static final zzir zzabp = new zzir(0, new int[0], new Object[0], false);
    private int count;
    private int[] zzabq;
    private boolean zzsh;
    private int zzwz;
    private Object[] zzzm;

    public static zzir zzjp() {
        return zzabp;
    }

    static zzir zzjq() {
        return new zzir();
    }

    static zzir zza(zzir zzir, zzir zzir2) {
        int i = zzir.count + zzir2.count;
        int[] copyOf = Arrays.copyOf(zzir.zzabq, i);
        System.arraycopy(zzir2.zzabq, 0, copyOf, zzir.count, zzir2.count);
        Object[] copyOf2 = Arrays.copyOf(zzir.zzzm, i);
        System.arraycopy(zzir2.zzzm, 0, copyOf2, zzir.count, zzir2.count);
        return new zzir(i, copyOf, copyOf2, true);
    }

    private zzir() {
        this(0, new int[8], new Object[8], true);
    }

    private zzir(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzwz = -1;
        this.count = i;
        this.zzabq = iArr;
        this.zzzm = objArr;
        this.zzsh = z;
    }

    public final void zzev() {
        this.zzsh = false;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzjl zzjl) throws IOException {
        if (zzjl.zzgl() == zze.zzxr) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzjl.zza(this.zzabq[i] >>> 3, this.zzzm[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzjl.zza(this.zzabq[i2] >>> 3, this.zzzm[i2]);
        }
    }

    public final void zzb(zzjl zzjl) throws IOException {
        if (this.count != 0) {
            if (zzjl.zzgl() == zze.zzxq) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzabq[i], this.zzzm[i], zzjl);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzabq[i2], this.zzzm[i2], zzjl);
            }
        }
    }

    private static void zzb(int i, Object obj, zzjl zzjl) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 != 5) {
            switch (i3) {
                case 0:
                    zzjl.zzi(i2, ((Long) obj).longValue());
                    return;
                case 1:
                    zzjl.zzc(i2, ((Long) obj).longValue());
                    return;
                case 2:
                    zzjl.zza(i2, (zzeh) obj);
                    return;
                case 3:
                    if (zzjl.zzgl() == zze.zzxq) {
                        zzjl.zzap(i2);
                        ((zzir) obj).zzb(zzjl);
                        zzjl.zzaq(i2);
                        return;
                    }
                    zzjl.zzaq(i2);
                    ((zzir) obj).zzb(zzjl);
                    zzjl.zzap(i2);
                    return;
                default:
                    throw new RuntimeException(zzgc.zzhv());
            }
        } else {
            zzjl.zzj(i2, ((Integer) obj).intValue());
        }
    }

    public final int zzjr() {
        int i = this.zzwz;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzfa.zzd(this.zzabq[i3] >>> 3, (zzeh) this.zzzm[i3]);
        }
        this.zzwz = i2;
        return i2;
    }

    public final int zzgw() {
        int i;
        int i2 = this.zzwz;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzabq[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 != 5) {
                switch (i7) {
                    case 0:
                        i = zzfa.zze(i6, ((Long) this.zzzm[i4]).longValue());
                        break;
                    case 1:
                        i = zzfa.zzg(i6, ((Long) this.zzzm[i4]).longValue());
                        break;
                    case 2:
                        i = zzfa.zzc(i6, (zzeh) this.zzzm[i4]);
                        break;
                    case 3:
                        i = (zzfa.zzag(i6) << 1) + ((zzir) this.zzzm[i4]).zzgw();
                        break;
                    default:
                        throw new IllegalStateException(zzgc.zzhv());
                }
            } else {
                i = zzfa.zzn(i6, ((Integer) this.zzzm[i4]).intValue());
            }
            i3 += i;
        }
        this.zzwz = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzir)) {
            return false;
        }
        zzir zzir = (zzir) obj;
        if (this.count == zzir.count) {
            int[] iArr = this.zzabq;
            int[] iArr2 = zzir.zzabq;
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
                Object[] objArr = this.zzzm;
                Object[] objArr2 = zzir.zzzm;
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
        int[] iArr = this.zzabq;
        int i2 = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < this.count; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i + i3) * 31;
        Object[] objArr = this.zzzm;
        for (int i6 = 0; i6 < this.count; i6++) {
            i2 = (i2 * 31) + objArr[i6].hashCode();
        }
        return i5 + i2;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzhf.zza(sb, i, String.valueOf(this.zzabq[i2] >>> 3), this.zzzm[i2]);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(int i, Object obj) {
        if (this.zzsh) {
            if (this.count == this.zzabq.length) {
                int i2 = this.count + (this.count < 4 ? 8 : this.count >> 1);
                this.zzabq = Arrays.copyOf(this.zzabq, i2);
                this.zzzm = Arrays.copyOf(this.zzzm, i2);
            }
            this.zzabq[this.count] = i;
            this.zzzm[this.count] = obj;
            this.count++;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
