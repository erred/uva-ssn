package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfj extends zzyc<zzfj> {
    private static volatile zzfj[] zzavj;
    public Boolean zzavh;
    public Boolean zzavi;
    public Integer zzavk;
    public String zzavl;
    public zzfk[] zzavm;
    private Boolean zzavn;
    public zzfl zzavo;

    public static zzfj[] zzms() {
        if (zzavj == null) {
            synchronized (zzyg.zzcfc) {
                if (zzavj == null) {
                    zzavj = new zzfj[0];
                }
            }
        }
        return zzavj;
    }

    public zzfj() {
        this.zzavk = null;
        this.zzavl = null;
        this.zzavm = zzfk.zzmt();
        this.zzavn = null;
        this.zzavo = null;
        this.zzavh = null;
        this.zzavi = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfj)) {
            return false;
        }
        zzfj zzfj = (zzfj) obj;
        if (this.zzavk == null) {
            if (zzfj.zzavk != null) {
                return false;
            }
        } else if (!this.zzavk.equals(zzfj.zzavk)) {
            return false;
        }
        if (this.zzavl == null) {
            if (zzfj.zzavl != null) {
                return false;
            }
        } else if (!this.zzavl.equals(zzfj.zzavl)) {
            return false;
        }
        if (!zzyg.equals((Object[]) this.zzavm, (Object[]) zzfj.zzavm)) {
            return false;
        }
        if (this.zzavn == null) {
            if (zzfj.zzavn != null) {
                return false;
            }
        } else if (!this.zzavn.equals(zzfj.zzavn)) {
            return false;
        }
        if (this.zzavo == null) {
            if (zzfj.zzavo != null) {
                return false;
            }
        } else if (!this.zzavo.equals(zzfj.zzavo)) {
            return false;
        }
        if (this.zzavh == null) {
            if (zzfj.zzavh != null) {
                return false;
            }
        } else if (!this.zzavh.equals(zzfj.zzavh)) {
            return false;
        }
        if (this.zzavi == null) {
            if (zzfj.zzavi != null) {
                return false;
            }
        } else if (!this.zzavi.equals(zzfj.zzavi)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfj.zzcet == null || zzfj.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfj.zzcet);
    }

    public final int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzavk == null ? 0 : this.zzavk.hashCode())) * 31) + (this.zzavl == null ? 0 : this.zzavl.hashCode())) * 31) + zzyg.hashCode((Object[]) this.zzavm)) * 31) + (this.zzavn == null ? 0 : this.zzavn.hashCode());
        zzfl zzfl = this.zzavo;
        int i3 = hashCode * 31;
        if (zzfl == null) {
            i = 0;
        } else {
            i = zzfl.hashCode();
        }
        int hashCode2 = (((((i3 + i) * 31) + (this.zzavh == null ? 0 : this.zzavh.hashCode())) * 31) + (this.zzavi == null ? 0 : this.zzavi.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i2 = this.zzcet.hashCode();
        }
        return hashCode2 + i2;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzavk != null) {
            zzya.zzd(1, this.zzavk.intValue());
        }
        if (this.zzavl != null) {
            zzya.zzb(2, this.zzavl);
        }
        if (this.zzavm != null && this.zzavm.length > 0) {
            for (zzfk zzfk : this.zzavm) {
                if (zzfk != null) {
                    zzya.zza(3, (zzyi) zzfk);
                }
            }
        }
        if (this.zzavn != null) {
            zzya.zzb(4, this.zzavn.booleanValue());
        }
        if (this.zzavo != null) {
            zzya.zza(5, (zzyi) this.zzavo);
        }
        if (this.zzavh != null) {
            zzya.zzb(6, this.zzavh.booleanValue());
        }
        if (this.zzavi != null) {
            zzya.zzb(7, this.zzavi.booleanValue());
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzavk != null) {
            zzf += zzya.zzh(1, this.zzavk.intValue());
        }
        if (this.zzavl != null) {
            zzf += zzya.zzc(2, this.zzavl);
        }
        if (this.zzavm != null && this.zzavm.length > 0) {
            for (zzfk zzfk : this.zzavm) {
                if (zzfk != null) {
                    zzf += zzya.zzb(3, (zzyi) zzfk);
                }
            }
        }
        if (this.zzavn != null) {
            this.zzavn.booleanValue();
            zzf += zzya.zzbd(4) + 1;
        }
        if (this.zzavo != null) {
            zzf += zzya.zzb(5, (zzyi) this.zzavo);
        }
        if (this.zzavh != null) {
            this.zzavh.booleanValue();
            zzf += zzya.zzbd(6) + 1;
        }
        if (this.zzavi == null) {
            return zzf;
        }
        this.zzavi.booleanValue();
        return zzf + zzya.zzbd(7) + 1;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzavk = Integer.valueOf(zzxz.zzvb());
            } else if (zzuj == 18) {
                this.zzavl = zzxz.readString();
            } else if (zzuj == 26) {
                int zzb = zzyl.zzb(zzxz, 26);
                int length = this.zzavm == null ? 0 : this.zzavm.length;
                zzfk[] zzfkArr = new zzfk[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzavm, 0, zzfkArr, 0, length);
                }
                while (length < zzfkArr.length - 1) {
                    zzfkArr[length] = new zzfk();
                    zzxz.zza((zzyi) zzfkArr[length]);
                    zzxz.zzuj();
                    length++;
                }
                zzfkArr[length] = new zzfk();
                zzxz.zza((zzyi) zzfkArr[length]);
                this.zzavm = zzfkArr;
            } else if (zzuj == 32) {
                this.zzavn = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 42) {
                if (this.zzavo == null) {
                    this.zzavo = new zzfl();
                }
                zzxz.zza((zzyi) this.zzavo);
            } else if (zzuj == 48) {
                this.zzavh = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 56) {
                this.zzavi = Boolean.valueOf(zzxz.zzup());
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
