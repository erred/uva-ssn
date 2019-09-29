package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfx extends zzyc<zzfx> {
    public long[] zzayn;
    public long[] zzayo;
    public zzfs[] zzayp;
    public zzfy[] zzayq;

    public zzfx() {
        this.zzayn = zzyl.zzcfi;
        this.zzayo = zzyl.zzcfi;
        this.zzayp = zzfs.zzmy();
        this.zzayq = zzfy.zznc();
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfx)) {
            return false;
        }
        zzfx zzfx = (zzfx) obj;
        if (!zzyg.equals(this.zzayn, zzfx.zzayn) || !zzyg.equals(this.zzayo, zzfx.zzayo) || !zzyg.equals((Object[]) this.zzayp, (Object[]) zzfx.zzayp) || !zzyg.equals((Object[]) this.zzayq, (Object[]) zzfx.zzayq)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfx.zzcet == null || zzfx.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfx.zzcet);
    }

    public final int hashCode() {
        return ((((((((((getClass().getName().hashCode() + 527) * 31) + zzyg.hashCode(this.zzayn)) * 31) + zzyg.hashCode(this.zzayo)) * 31) + zzyg.hashCode((Object[]) this.zzayp)) * 31) + zzyg.hashCode((Object[]) this.zzayq)) * 31) + ((this.zzcet == null || this.zzcet.isEmpty()) ? 0 : this.zzcet.hashCode());
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzayn != null && this.zzayn.length > 0) {
            for (long zza : this.zzayn) {
                zzya.zza(1, zza);
            }
        }
        if (this.zzayo != null && this.zzayo.length > 0) {
            for (long zza2 : this.zzayo) {
                zzya.zza(2, zza2);
            }
        }
        if (this.zzayp != null && this.zzayp.length > 0) {
            for (zzfs zzfs : this.zzayp) {
                if (zzfs != null) {
                    zzya.zza(3, (zzyi) zzfs);
                }
            }
        }
        if (this.zzayq != null && this.zzayq.length > 0) {
            for (zzfy zzfy : this.zzayq) {
                if (zzfy != null) {
                    zzya.zza(4, (zzyi) zzfy);
                }
            }
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzayn != null && this.zzayn.length > 0) {
            int i = 0;
            for (long zzbg : this.zzayn) {
                i += zzya.zzbg(zzbg);
            }
            zzf = zzf + i + (this.zzayn.length * 1);
        }
        if (this.zzayo != null && this.zzayo.length > 0) {
            int i2 = 0;
            for (long zzbg2 : this.zzayo) {
                i2 += zzya.zzbg(zzbg2);
            }
            zzf = zzf + i2 + (this.zzayo.length * 1);
        }
        if (this.zzayp != null && this.zzayp.length > 0) {
            int i3 = zzf;
            for (zzfs zzfs : this.zzayp) {
                if (zzfs != null) {
                    i3 += zzya.zzb(3, (zzyi) zzfs);
                }
            }
            zzf = i3;
        }
        if (this.zzayq != null && this.zzayq.length > 0) {
            for (zzfy zzfy : this.zzayq) {
                if (zzfy != null) {
                    zzf += zzya.zzb(4, (zzyi) zzfy);
                }
            }
        }
        return zzf;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                int zzb = zzyl.zzb(zzxz, 8);
                int length = this.zzayn == null ? 0 : this.zzayn.length;
                long[] jArr = new long[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzayn, 0, jArr, 0, length);
                }
                while (length < jArr.length - 1) {
                    jArr[length] = zzxz.zzvc();
                    zzxz.zzuj();
                    length++;
                }
                jArr[length] = zzxz.zzvc();
                this.zzayn = jArr;
            } else if (zzuj == 10) {
                int zzas = zzxz.zzas(zzxz.zzvb());
                int position = zzxz.getPosition();
                int i = 0;
                while (zzxz.zzyy() > 0) {
                    zzxz.zzvc();
                    i++;
                }
                zzxz.zzcb(position);
                int length2 = this.zzayn == null ? 0 : this.zzayn.length;
                long[] jArr2 = new long[(i + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzayn, 0, jArr2, 0, length2);
                }
                while (length2 < jArr2.length) {
                    jArr2[length2] = zzxz.zzvc();
                    length2++;
                }
                this.zzayn = jArr2;
                zzxz.zzat(zzas);
            } else if (zzuj == 16) {
                int zzb2 = zzyl.zzb(zzxz, 16);
                int length3 = this.zzayo == null ? 0 : this.zzayo.length;
                long[] jArr3 = new long[(zzb2 + length3)];
                if (length3 != 0) {
                    System.arraycopy(this.zzayo, 0, jArr3, 0, length3);
                }
                while (length3 < jArr3.length - 1) {
                    jArr3[length3] = zzxz.zzvc();
                    zzxz.zzuj();
                    length3++;
                }
                jArr3[length3] = zzxz.zzvc();
                this.zzayo = jArr3;
            } else if (zzuj == 18) {
                int zzas2 = zzxz.zzas(zzxz.zzvb());
                int position2 = zzxz.getPosition();
                int i2 = 0;
                while (zzxz.zzyy() > 0) {
                    zzxz.zzvc();
                    i2++;
                }
                zzxz.zzcb(position2);
                int length4 = this.zzayo == null ? 0 : this.zzayo.length;
                long[] jArr4 = new long[(i2 + length4)];
                if (length4 != 0) {
                    System.arraycopy(this.zzayo, 0, jArr4, 0, length4);
                }
                while (length4 < jArr4.length) {
                    jArr4[length4] = zzxz.zzvc();
                    length4++;
                }
                this.zzayo = jArr4;
                zzxz.zzat(zzas2);
            } else if (zzuj == 26) {
                int zzb3 = zzyl.zzb(zzxz, 26);
                int length5 = this.zzayp == null ? 0 : this.zzayp.length;
                zzfs[] zzfsArr = new zzfs[(zzb3 + length5)];
                if (length5 != 0) {
                    System.arraycopy(this.zzayp, 0, zzfsArr, 0, length5);
                }
                while (length5 < zzfsArr.length - 1) {
                    zzfsArr[length5] = new zzfs();
                    zzxz.zza((zzyi) zzfsArr[length5]);
                    zzxz.zzuj();
                    length5++;
                }
                zzfsArr[length5] = new zzfs();
                zzxz.zza((zzyi) zzfsArr[length5]);
                this.zzayp = zzfsArr;
            } else if (zzuj == 34) {
                int zzb4 = zzyl.zzb(zzxz, 34);
                int length6 = this.zzayq == null ? 0 : this.zzayq.length;
                zzfy[] zzfyArr = new zzfy[(zzb4 + length6)];
                if (length6 != 0) {
                    System.arraycopy(this.zzayq, 0, zzfyArr, 0, length6);
                }
                while (length6 < zzfyArr.length - 1) {
                    zzfyArr[length6] = new zzfy();
                    zzxz.zza((zzyi) zzfyArr[length6]);
                    zzxz.zzuj();
                    length6++;
                }
                zzfyArr[length6] = new zzfy();
                zzxz.zza((zzyi) zzfyArr[length6]);
                this.zzayq = zzfyArr;
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
