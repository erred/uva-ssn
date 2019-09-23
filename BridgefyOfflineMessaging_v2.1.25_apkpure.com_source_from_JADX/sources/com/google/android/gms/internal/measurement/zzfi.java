package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfi extends zzyc<zzfi> {
    private static volatile zzfi[] zzavd;
    public Integer zzave;
    public zzfm[] zzavf;
    public zzfj[] zzavg;
    private Boolean zzavh;
    private Boolean zzavi;

    public static zzfi[] zzmr() {
        if (zzavd == null) {
            synchronized (zzyg.zzcfc) {
                if (zzavd == null) {
                    zzavd = new zzfi[0];
                }
            }
        }
        return zzavd;
    }

    public zzfi() {
        this.zzave = null;
        this.zzavf = zzfm.zzmu();
        this.zzavg = zzfj.zzms();
        this.zzavh = null;
        this.zzavi = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfi)) {
            return false;
        }
        zzfi zzfi = (zzfi) obj;
        if (this.zzave == null) {
            if (zzfi.zzave != null) {
                return false;
            }
        } else if (!this.zzave.equals(zzfi.zzave)) {
            return false;
        }
        if (!zzyg.equals((Object[]) this.zzavf, (Object[]) zzfi.zzavf) || !zzyg.equals((Object[]) this.zzavg, (Object[]) zzfi.zzavg)) {
            return false;
        }
        if (this.zzavh == null) {
            if (zzfi.zzavh != null) {
                return false;
            }
        } else if (!this.zzavh.equals(zzfi.zzavh)) {
            return false;
        }
        if (this.zzavi == null) {
            if (zzfi.zzavi != null) {
                return false;
            }
        } else if (!this.zzavi.equals(zzfi.zzavi)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfi.zzcet == null || zzfi.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfi.zzcet);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzave == null ? 0 : this.zzave.hashCode())) * 31) + zzyg.hashCode((Object[]) this.zzavf)) * 31) + zzyg.hashCode((Object[]) this.zzavg)) * 31) + (this.zzavh == null ? 0 : this.zzavh.hashCode())) * 31) + (this.zzavi == null ? 0 : this.zzavi.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzave != null) {
            zzya.zzd(1, this.zzave.intValue());
        }
        if (this.zzavf != null && this.zzavf.length > 0) {
            for (zzfm zzfm : this.zzavf) {
                if (zzfm != null) {
                    zzya.zza(2, (zzyi) zzfm);
                }
            }
        }
        if (this.zzavg != null && this.zzavg.length > 0) {
            for (zzfj zzfj : this.zzavg) {
                if (zzfj != null) {
                    zzya.zza(3, (zzyi) zzfj);
                }
            }
        }
        if (this.zzavh != null) {
            zzya.zzb(4, this.zzavh.booleanValue());
        }
        if (this.zzavi != null) {
            zzya.zzb(5, this.zzavi.booleanValue());
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzave != null) {
            zzf += zzya.zzh(1, this.zzave.intValue());
        }
        if (this.zzavf != null && this.zzavf.length > 0) {
            int i = zzf;
            for (zzfm zzfm : this.zzavf) {
                if (zzfm != null) {
                    i += zzya.zzb(2, (zzyi) zzfm);
                }
            }
            zzf = i;
        }
        if (this.zzavg != null && this.zzavg.length > 0) {
            for (zzfj zzfj : this.zzavg) {
                if (zzfj != null) {
                    zzf += zzya.zzb(3, (zzyi) zzfj);
                }
            }
        }
        if (this.zzavh != null) {
            this.zzavh.booleanValue();
            zzf += zzya.zzbd(4) + 1;
        }
        if (this.zzavi == null) {
            return zzf;
        }
        this.zzavi.booleanValue();
        return zzf + zzya.zzbd(5) + 1;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzave = Integer.valueOf(zzxz.zzvb());
            } else if (zzuj == 18) {
                int zzb = zzyl.zzb(zzxz, 18);
                int length = this.zzavf == null ? 0 : this.zzavf.length;
                zzfm[] zzfmArr = new zzfm[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzavf, 0, zzfmArr, 0, length);
                }
                while (length < zzfmArr.length - 1) {
                    zzfmArr[length] = new zzfm();
                    zzxz.zza((zzyi) zzfmArr[length]);
                    zzxz.zzuj();
                    length++;
                }
                zzfmArr[length] = new zzfm();
                zzxz.zza((zzyi) zzfmArr[length]);
                this.zzavf = zzfmArr;
            } else if (zzuj == 26) {
                int zzb2 = zzyl.zzb(zzxz, 26);
                int length2 = this.zzavg == null ? 0 : this.zzavg.length;
                zzfj[] zzfjArr = new zzfj[(zzb2 + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzavg, 0, zzfjArr, 0, length2);
                }
                while (length2 < zzfjArr.length - 1) {
                    zzfjArr[length2] = new zzfj();
                    zzxz.zza((zzyi) zzfjArr[length2]);
                    zzxz.zzuj();
                    length2++;
                }
                zzfjArr[length2] = new zzfj();
                zzxz.zza((zzyi) zzfjArr[length2]);
                this.zzavg = zzfjArr;
            } else if (zzuj == 32) {
                this.zzavh = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 40) {
                this.zzavi = Boolean.valueOf(zzxz.zzup());
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
