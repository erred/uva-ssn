package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfr extends zzyc<zzfr> {
    private static volatile zzfr[] zzaws;
    public Integer zzave;
    public zzfx zzawt;
    public zzfx zzawu;
    public Boolean zzawv;

    public static zzfr[] zzmx() {
        if (zzaws == null) {
            synchronized (zzyg.zzcfc) {
                if (zzaws == null) {
                    zzaws = new zzfr[0];
                }
            }
        }
        return zzaws;
    }

    public zzfr() {
        this.zzave = null;
        this.zzawt = null;
        this.zzawu = null;
        this.zzawv = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfr)) {
            return false;
        }
        zzfr zzfr = (zzfr) obj;
        if (this.zzave == null) {
            if (zzfr.zzave != null) {
                return false;
            }
        } else if (!this.zzave.equals(zzfr.zzave)) {
            return false;
        }
        if (this.zzawt == null) {
            if (zzfr.zzawt != null) {
                return false;
            }
        } else if (!this.zzawt.equals(zzfr.zzawt)) {
            return false;
        }
        if (this.zzawu == null) {
            if (zzfr.zzawu != null) {
                return false;
            }
        } else if (!this.zzawu.equals(zzfr.zzawu)) {
            return false;
        }
        if (this.zzawv == null) {
            if (zzfr.zzawv != null) {
                return false;
            }
        } else if (!this.zzawv.equals(zzfr.zzawv)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfr.zzcet == null || zzfr.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfr.zzcet);
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3 = 0;
        int hashCode = ((getClass().getName().hashCode() + 527) * 31) + (this.zzave == null ? 0 : this.zzave.hashCode());
        zzfx zzfx = this.zzawt;
        int i4 = hashCode * 31;
        if (zzfx == null) {
            i = 0;
        } else {
            i = zzfx.hashCode();
        }
        int i5 = i4 + i;
        zzfx zzfx2 = this.zzawu;
        int i6 = i5 * 31;
        if (zzfx2 == null) {
            i2 = 0;
        } else {
            i2 = zzfx2.hashCode();
        }
        int hashCode2 = (((i6 + i2) * 31) + (this.zzawv == null ? 0 : this.zzawv.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i3 = this.zzcet.hashCode();
        }
        return hashCode2 + i3;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzave != null) {
            zzya.zzd(1, this.zzave.intValue());
        }
        if (this.zzawt != null) {
            zzya.zza(2, (zzyi) this.zzawt);
        }
        if (this.zzawu != null) {
            zzya.zza(3, (zzyi) this.zzawu);
        }
        if (this.zzawv != null) {
            zzya.zzb(4, this.zzawv.booleanValue());
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzave != null) {
            zzf += zzya.zzh(1, this.zzave.intValue());
        }
        if (this.zzawt != null) {
            zzf += zzya.zzb(2, (zzyi) this.zzawt);
        }
        if (this.zzawu != null) {
            zzf += zzya.zzb(3, (zzyi) this.zzawu);
        }
        if (this.zzawv == null) {
            return zzf;
        }
        this.zzawv.booleanValue();
        return zzf + zzya.zzbd(4) + 1;
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
                if (this.zzawt == null) {
                    this.zzawt = new zzfx();
                }
                zzxz.zza((zzyi) this.zzawt);
            } else if (zzuj == 26) {
                if (this.zzawu == null) {
                    this.zzawu = new zzfx();
                }
                zzxz.zza((zzyi) this.zzawu);
            } else if (zzuj == 32) {
                this.zzawv = Boolean.valueOf(zzxz.zzup());
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
