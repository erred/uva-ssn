package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfp extends zzyc<zzfp> {
    public String zzafi;
    public Long zzawk;
    private Integer zzawl;
    public zzfq[] zzawm;
    public zzfo[] zzawn;
    public zzfi[] zzawo;
    private String zzawp;
    private Boolean zzawq;

    public zzfp() {
        this.zzawk = null;
        this.zzafi = null;
        this.zzawl = null;
        this.zzawm = zzfq.zzmw();
        this.zzawn = zzfo.zzmv();
        this.zzawo = zzfi.zzmr();
        this.zzawp = null;
        this.zzawq = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfp)) {
            return false;
        }
        zzfp zzfp = (zzfp) obj;
        if (this.zzawk == null) {
            if (zzfp.zzawk != null) {
                return false;
            }
        } else if (!this.zzawk.equals(zzfp.zzawk)) {
            return false;
        }
        if (this.zzafi == null) {
            if (zzfp.zzafi != null) {
                return false;
            }
        } else if (!this.zzafi.equals(zzfp.zzafi)) {
            return false;
        }
        if (this.zzawl == null) {
            if (zzfp.zzawl != null) {
                return false;
            }
        } else if (!this.zzawl.equals(zzfp.zzawl)) {
            return false;
        }
        if (!zzyg.equals((Object[]) this.zzawm, (Object[]) zzfp.zzawm) || !zzyg.equals((Object[]) this.zzawn, (Object[]) zzfp.zzawn) || !zzyg.equals((Object[]) this.zzawo, (Object[]) zzfp.zzawo)) {
            return false;
        }
        if (this.zzawp == null) {
            if (zzfp.zzawp != null) {
                return false;
            }
        } else if (!this.zzawp.equals(zzfp.zzawp)) {
            return false;
        }
        if (this.zzawq == null) {
            if (zzfp.zzawq != null) {
                return false;
            }
        } else if (!this.zzawq.equals(zzfp.zzawq)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfp.zzcet == null || zzfp.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfp.zzcet);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzawk == null ? 0 : this.zzawk.hashCode())) * 31) + (this.zzafi == null ? 0 : this.zzafi.hashCode())) * 31) + (this.zzawl == null ? 0 : this.zzawl.hashCode())) * 31) + zzyg.hashCode((Object[]) this.zzawm)) * 31) + zzyg.hashCode((Object[]) this.zzawn)) * 31) + zzyg.hashCode((Object[]) this.zzawo)) * 31) + (this.zzawp == null ? 0 : this.zzawp.hashCode())) * 31) + (this.zzawq == null ? 0 : this.zzawq.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzawk != null) {
            zzya.zzi(1, this.zzawk.longValue());
        }
        if (this.zzafi != null) {
            zzya.zzb(2, this.zzafi);
        }
        if (this.zzawl != null) {
            zzya.zzd(3, this.zzawl.intValue());
        }
        if (this.zzawm != null && this.zzawm.length > 0) {
            for (zzfq zzfq : this.zzawm) {
                if (zzfq != null) {
                    zzya.zza(4, (zzyi) zzfq);
                }
            }
        }
        if (this.zzawn != null && this.zzawn.length > 0) {
            for (zzfo zzfo : this.zzawn) {
                if (zzfo != null) {
                    zzya.zza(5, (zzyi) zzfo);
                }
            }
        }
        if (this.zzawo != null && this.zzawo.length > 0) {
            for (zzfi zzfi : this.zzawo) {
                if (zzfi != null) {
                    zzya.zza(6, (zzyi) zzfi);
                }
            }
        }
        if (this.zzawp != null) {
            zzya.zzb(7, this.zzawp);
        }
        if (this.zzawq != null) {
            zzya.zzb(8, this.zzawq.booleanValue());
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzawk != null) {
            zzf += zzya.zzd(1, this.zzawk.longValue());
        }
        if (this.zzafi != null) {
            zzf += zzya.zzc(2, this.zzafi);
        }
        if (this.zzawl != null) {
            zzf += zzya.zzh(3, this.zzawl.intValue());
        }
        if (this.zzawm != null && this.zzawm.length > 0) {
            int i = zzf;
            for (zzfq zzfq : this.zzawm) {
                if (zzfq != null) {
                    i += zzya.zzb(4, (zzyi) zzfq);
                }
            }
            zzf = i;
        }
        if (this.zzawn != null && this.zzawn.length > 0) {
            int i2 = zzf;
            for (zzfo zzfo : this.zzawn) {
                if (zzfo != null) {
                    i2 += zzya.zzb(5, (zzyi) zzfo);
                }
            }
            zzf = i2;
        }
        if (this.zzawo != null && this.zzawo.length > 0) {
            for (zzfi zzfi : this.zzawo) {
                if (zzfi != null) {
                    zzf += zzya.zzb(6, (zzyi) zzfi);
                }
            }
        }
        if (this.zzawp != null) {
            zzf += zzya.zzc(7, this.zzawp);
        }
        if (this.zzawq == null) {
            return zzf;
        }
        this.zzawq.booleanValue();
        return zzf + zzya.zzbd(8) + 1;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                this.zzawk = Long.valueOf(zzxz.zzvc());
            } else if (zzuj == 18) {
                this.zzafi = zzxz.readString();
            } else if (zzuj == 24) {
                this.zzawl = Integer.valueOf(zzxz.zzvb());
            } else if (zzuj == 34) {
                int zzb = zzyl.zzb(zzxz, 34);
                int length = this.zzawm == null ? 0 : this.zzawm.length;
                zzfq[] zzfqArr = new zzfq[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzawm, 0, zzfqArr, 0, length);
                }
                while (length < zzfqArr.length - 1) {
                    zzfqArr[length] = new zzfq();
                    zzxz.zza((zzyi) zzfqArr[length]);
                    zzxz.zzuj();
                    length++;
                }
                zzfqArr[length] = new zzfq();
                zzxz.zza((zzyi) zzfqArr[length]);
                this.zzawm = zzfqArr;
            } else if (zzuj == 42) {
                int zzb2 = zzyl.zzb(zzxz, 42);
                int length2 = this.zzawn == null ? 0 : this.zzawn.length;
                zzfo[] zzfoArr = new zzfo[(zzb2 + length2)];
                if (length2 != 0) {
                    System.arraycopy(this.zzawn, 0, zzfoArr, 0, length2);
                }
                while (length2 < zzfoArr.length - 1) {
                    zzfoArr[length2] = new zzfo();
                    zzxz.zza((zzyi) zzfoArr[length2]);
                    zzxz.zzuj();
                    length2++;
                }
                zzfoArr[length2] = new zzfo();
                zzxz.zza((zzyi) zzfoArr[length2]);
                this.zzawn = zzfoArr;
            } else if (zzuj == 50) {
                int zzb3 = zzyl.zzb(zzxz, 50);
                int length3 = this.zzawo == null ? 0 : this.zzawo.length;
                zzfi[] zzfiArr = new zzfi[(zzb3 + length3)];
                if (length3 != 0) {
                    System.arraycopy(this.zzawo, 0, zzfiArr, 0, length3);
                }
                while (length3 < zzfiArr.length - 1) {
                    zzfiArr[length3] = new zzfi();
                    zzxz.zza((zzyi) zzfiArr[length3]);
                    zzxz.zzuj();
                    length3++;
                }
                zzfiArr[length3] = new zzfi();
                zzxz.zza((zzyi) zzfiArr[length3]);
                this.zzawo = zzfiArr;
            } else if (zzuj == 58) {
                this.zzawp = zzxz.readString();
            } else if (zzuj == 64) {
                this.zzawq = Boolean.valueOf(zzxz.zzup());
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
    }
}
