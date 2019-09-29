package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfn extends zzyc<zzfn> {
    public Integer zzawc;
    public String zzawd;
    public Boolean zzawe;
    public String[] zzawf;

    public zzfn() {
        this.zzawc = null;
        this.zzawd = null;
        this.zzawe = null;
        this.zzawf = zzyl.zzcfm;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfn)) {
            return false;
        }
        zzfn zzfn = (zzfn) obj;
        if (this.zzawc == null) {
            if (zzfn.zzawc != null) {
                return false;
            }
        } else if (!this.zzawc.equals(zzfn.zzawc)) {
            return false;
        }
        if (this.zzawd == null) {
            if (zzfn.zzawd != null) {
                return false;
            }
        } else if (!this.zzawd.equals(zzfn.zzawd)) {
            return false;
        }
        if (this.zzawe == null) {
            if (zzfn.zzawe != null) {
                return false;
            }
        } else if (!this.zzawe.equals(zzfn.zzawe)) {
            return false;
        }
        if (!zzyg.equals((Object[]) this.zzawf, (Object[]) zzfn.zzawf)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfn.zzcet == null || zzfn.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfn.zzcet);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzawc == null ? 0 : this.zzawc.intValue())) * 31) + (this.zzawd == null ? 0 : this.zzawd.hashCode())) * 31) + (this.zzawe == null ? 0 : this.zzawe.hashCode())) * 31) + zzyg.hashCode((Object[]) this.zzawf)) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i = this.zzcet.hashCode();
        }
        return hashCode + i;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzawc != null) {
            zzya.zzd(1, this.zzawc.intValue());
        }
        if (this.zzawd != null) {
            zzya.zzb(2, this.zzawd);
        }
        if (this.zzawe != null) {
            zzya.zzb(3, this.zzawe.booleanValue());
        }
        if (this.zzawf != null && this.zzawf.length > 0) {
            for (String str : this.zzawf) {
                if (str != null) {
                    zzya.zzb(4, str);
                }
            }
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzawc != null) {
            zzf += zzya.zzh(1, this.zzawc.intValue());
        }
        if (this.zzawd != null) {
            zzf += zzya.zzc(2, this.zzawd);
        }
        if (this.zzawe != null) {
            this.zzawe.booleanValue();
            zzf += zzya.zzbd(3) + 1;
        }
        if (this.zzawf == null || this.zzawf.length <= 0) {
            return zzf;
        }
        int i = 0;
        int i2 = 0;
        for (String str : this.zzawf) {
            if (str != null) {
                i2++;
                i += zzya.zzgc(str);
            }
        }
        return zzf + i + (i2 * 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzfn zza(zzxz zzxz) throws IOException {
        int zzvb;
        while (true) {
            int zzuj = zzxz.zzuj();
            if (zzuj == 0) {
                return this;
            }
            if (zzuj == 8) {
                try {
                    zzvb = zzxz.zzvb();
                    if (zzvb < 0 || zzvb > 6) {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append(zzvb);
                        sb.append(" is not a valid enum MatchType");
                    } else {
                        this.zzawc = Integer.valueOf(zzvb);
                    }
                } catch (IllegalArgumentException unused) {
                    zzxz.zzcb(zzxz.getPosition());
                    zza(zzxz, zzuj);
                }
            } else if (zzuj == 18) {
                this.zzawd = zzxz.readString();
            } else if (zzuj == 24) {
                this.zzawe = Boolean.valueOf(zzxz.zzup());
            } else if (zzuj == 34) {
                int zzb = zzyl.zzb(zzxz, 34);
                int length = this.zzawf == null ? 0 : this.zzawf.length;
                String[] strArr = new String[(zzb + length)];
                if (length != 0) {
                    System.arraycopy(this.zzawf, 0, strArr, 0, length);
                }
                while (length < strArr.length - 1) {
                    strArr[length] = zzxz.readString();
                    zzxz.zzuj();
                    length++;
                }
                strArr[length] = zzxz.readString();
                this.zzawf = strArr;
            } else if (!super.zza(zzxz, zzuj)) {
                return this;
            }
        }
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append(zzvb);
        sb2.append(" is not a valid enum MatchType");
        throw new IllegalArgumentException(sb2.toString());
    }
}
