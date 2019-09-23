package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfe.zzb;
import com.google.android.gms.internal.measurement.zzfe.zzb.zza;
import java.io.IOException;

public final class zzfw extends zzyc<zzfw> {
    private static volatile zzfw[] zzaxg;
    public String zzafh;
    public String zzafi;
    public String zzafk;
    public String zzafp;
    public String zzagm;
    public String zzahr;
    public String zzawp;
    public Integer zzaxh;
    public zzft[] zzaxi;
    public zzfz[] zzaxj;
    public Long zzaxk;
    public Long zzaxl;
    public Long zzaxm;
    public Long zzaxn;
    public Long zzaxo;
    public String zzaxp;
    public String zzaxq;
    public String zzaxr;
    public Integer zzaxs;
    public Long zzaxt;
    public Long zzaxu;
    public String zzaxv;
    public Boolean zzaxw;
    public Long zzaxx;
    public Integer zzaxy;
    public Boolean zzaxz;
    public zzfr[] zzaya;
    public Integer zzayb;
    private Integer zzayc;
    private Integer zzayd;
    public String zzaye;
    public Long zzayf;
    public Long zzayg;
    public String zzayh;
    private String zzayi;
    public Integer zzayj;
    public zzb zzayk;
    public int[] zzayl;
    private Long zzaym;
    public String zzts;
    public String zztt;

    public static zzfw[] zznb() {
        if (zzaxg == null) {
            synchronized (zzyg.zzcfc) {
                if (zzaxg == null) {
                    zzaxg = new zzfw[0];
                }
            }
        }
        return zzaxg;
    }

    public zzfw() {
        this.zzaxh = null;
        this.zzaxi = zzft.zzmz();
        this.zzaxj = zzfz.zznd();
        this.zzaxk = null;
        this.zzaxl = null;
        this.zzaxm = null;
        this.zzaxn = null;
        this.zzaxo = null;
        this.zzaxp = null;
        this.zzaxq = null;
        this.zzaxr = null;
        this.zzahr = null;
        this.zzaxs = null;
        this.zzafp = null;
        this.zztt = null;
        this.zzts = null;
        this.zzaxt = null;
        this.zzaxu = null;
        this.zzaxv = null;
        this.zzaxw = null;
        this.zzafh = null;
        this.zzaxx = null;
        this.zzaxy = null;
        this.zzagm = null;
        this.zzafi = null;
        this.zzaxz = null;
        this.zzaya = zzfr.zzmx();
        this.zzafk = null;
        this.zzayb = null;
        this.zzayc = null;
        this.zzayd = null;
        this.zzaye = null;
        this.zzayf = null;
        this.zzayg = null;
        this.zzayh = null;
        this.zzayi = null;
        this.zzayj = null;
        this.zzawp = null;
        this.zzayk = null;
        this.zzayl = zzyl.zzcao;
        this.zzaym = null;
        this.zzcet = null;
        this.zzcfd = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfw)) {
            return false;
        }
        zzfw zzfw = (zzfw) obj;
        if (this.zzaxh == null) {
            if (zzfw.zzaxh != null) {
                return false;
            }
        } else if (!this.zzaxh.equals(zzfw.zzaxh)) {
            return false;
        }
        if (!zzyg.equals((Object[]) this.zzaxi, (Object[]) zzfw.zzaxi) || !zzyg.equals((Object[]) this.zzaxj, (Object[]) zzfw.zzaxj)) {
            return false;
        }
        if (this.zzaxk == null) {
            if (zzfw.zzaxk != null) {
                return false;
            }
        } else if (!this.zzaxk.equals(zzfw.zzaxk)) {
            return false;
        }
        if (this.zzaxl == null) {
            if (zzfw.zzaxl != null) {
                return false;
            }
        } else if (!this.zzaxl.equals(zzfw.zzaxl)) {
            return false;
        }
        if (this.zzaxm == null) {
            if (zzfw.zzaxm != null) {
                return false;
            }
        } else if (!this.zzaxm.equals(zzfw.zzaxm)) {
            return false;
        }
        if (this.zzaxn == null) {
            if (zzfw.zzaxn != null) {
                return false;
            }
        } else if (!this.zzaxn.equals(zzfw.zzaxn)) {
            return false;
        }
        if (this.zzaxo == null) {
            if (zzfw.zzaxo != null) {
                return false;
            }
        } else if (!this.zzaxo.equals(zzfw.zzaxo)) {
            return false;
        }
        if (this.zzaxp == null) {
            if (zzfw.zzaxp != null) {
                return false;
            }
        } else if (!this.zzaxp.equals(zzfw.zzaxp)) {
            return false;
        }
        if (this.zzaxq == null) {
            if (zzfw.zzaxq != null) {
                return false;
            }
        } else if (!this.zzaxq.equals(zzfw.zzaxq)) {
            return false;
        }
        if (this.zzaxr == null) {
            if (zzfw.zzaxr != null) {
                return false;
            }
        } else if (!this.zzaxr.equals(zzfw.zzaxr)) {
            return false;
        }
        if (this.zzahr == null) {
            if (zzfw.zzahr != null) {
                return false;
            }
        } else if (!this.zzahr.equals(zzfw.zzahr)) {
            return false;
        }
        if (this.zzaxs == null) {
            if (zzfw.zzaxs != null) {
                return false;
            }
        } else if (!this.zzaxs.equals(zzfw.zzaxs)) {
            return false;
        }
        if (this.zzafp == null) {
            if (zzfw.zzafp != null) {
                return false;
            }
        } else if (!this.zzafp.equals(zzfw.zzafp)) {
            return false;
        }
        if (this.zztt == null) {
            if (zzfw.zztt != null) {
                return false;
            }
        } else if (!this.zztt.equals(zzfw.zztt)) {
            return false;
        }
        if (this.zzts == null) {
            if (zzfw.zzts != null) {
                return false;
            }
        } else if (!this.zzts.equals(zzfw.zzts)) {
            return false;
        }
        if (this.zzaxt == null) {
            if (zzfw.zzaxt != null) {
                return false;
            }
        } else if (!this.zzaxt.equals(zzfw.zzaxt)) {
            return false;
        }
        if (this.zzaxu == null) {
            if (zzfw.zzaxu != null) {
                return false;
            }
        } else if (!this.zzaxu.equals(zzfw.zzaxu)) {
            return false;
        }
        if (this.zzaxv == null) {
            if (zzfw.zzaxv != null) {
                return false;
            }
        } else if (!this.zzaxv.equals(zzfw.zzaxv)) {
            return false;
        }
        if (this.zzaxw == null) {
            if (zzfw.zzaxw != null) {
                return false;
            }
        } else if (!this.zzaxw.equals(zzfw.zzaxw)) {
            return false;
        }
        if (this.zzafh == null) {
            if (zzfw.zzafh != null) {
                return false;
            }
        } else if (!this.zzafh.equals(zzfw.zzafh)) {
            return false;
        }
        if (this.zzaxx == null) {
            if (zzfw.zzaxx != null) {
                return false;
            }
        } else if (!this.zzaxx.equals(zzfw.zzaxx)) {
            return false;
        }
        if (this.zzaxy == null) {
            if (zzfw.zzaxy != null) {
                return false;
            }
        } else if (!this.zzaxy.equals(zzfw.zzaxy)) {
            return false;
        }
        if (this.zzagm == null) {
            if (zzfw.zzagm != null) {
                return false;
            }
        } else if (!this.zzagm.equals(zzfw.zzagm)) {
            return false;
        }
        if (this.zzafi == null) {
            if (zzfw.zzafi != null) {
                return false;
            }
        } else if (!this.zzafi.equals(zzfw.zzafi)) {
            return false;
        }
        if (this.zzaxz == null) {
            if (zzfw.zzaxz != null) {
                return false;
            }
        } else if (!this.zzaxz.equals(zzfw.zzaxz)) {
            return false;
        }
        if (!zzyg.equals((Object[]) this.zzaya, (Object[]) zzfw.zzaya)) {
            return false;
        }
        if (this.zzafk == null) {
            if (zzfw.zzafk != null) {
                return false;
            }
        } else if (!this.zzafk.equals(zzfw.zzafk)) {
            return false;
        }
        if (this.zzayb == null) {
            if (zzfw.zzayb != null) {
                return false;
            }
        } else if (!this.zzayb.equals(zzfw.zzayb)) {
            return false;
        }
        if (this.zzayc == null) {
            if (zzfw.zzayc != null) {
                return false;
            }
        } else if (!this.zzayc.equals(zzfw.zzayc)) {
            return false;
        }
        if (this.zzayd == null) {
            if (zzfw.zzayd != null) {
                return false;
            }
        } else if (!this.zzayd.equals(zzfw.zzayd)) {
            return false;
        }
        if (this.zzaye == null) {
            if (zzfw.zzaye != null) {
                return false;
            }
        } else if (!this.zzaye.equals(zzfw.zzaye)) {
            return false;
        }
        if (this.zzayf == null) {
            if (zzfw.zzayf != null) {
                return false;
            }
        } else if (!this.zzayf.equals(zzfw.zzayf)) {
            return false;
        }
        if (this.zzayg == null) {
            if (zzfw.zzayg != null) {
                return false;
            }
        } else if (!this.zzayg.equals(zzfw.zzayg)) {
            return false;
        }
        if (this.zzayh == null) {
            if (zzfw.zzayh != null) {
                return false;
            }
        } else if (!this.zzayh.equals(zzfw.zzayh)) {
            return false;
        }
        if (this.zzayi == null) {
            if (zzfw.zzayi != null) {
                return false;
            }
        } else if (!this.zzayi.equals(zzfw.zzayi)) {
            return false;
        }
        if (this.zzayj == null) {
            if (zzfw.zzayj != null) {
                return false;
            }
        } else if (!this.zzayj.equals(zzfw.zzayj)) {
            return false;
        }
        if (this.zzawp == null) {
            if (zzfw.zzawp != null) {
                return false;
            }
        } else if (!this.zzawp.equals(zzfw.zzawp)) {
            return false;
        }
        if (this.zzayk == null) {
            if (zzfw.zzayk != null) {
                return false;
            }
        } else if (!this.zzayk.equals(zzfw.zzayk)) {
            return false;
        }
        if (!zzyg.equals(this.zzayl, zzfw.zzayl)) {
            return false;
        }
        if (this.zzaym == null) {
            if (zzfw.zzaym != null) {
                return false;
            }
        } else if (!this.zzaym.equals(zzfw.zzaym)) {
            return false;
        }
        if (this.zzcet == null || this.zzcet.isEmpty()) {
            return zzfw.zzcet == null || zzfw.zzcet.isEmpty();
        }
        return this.zzcet.equals(zzfw.zzcet);
    }

    public final int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + (this.zzaxh == null ? 0 : this.zzaxh.hashCode())) * 31) + zzyg.hashCode((Object[]) this.zzaxi)) * 31) + zzyg.hashCode((Object[]) this.zzaxj)) * 31) + (this.zzaxk == null ? 0 : this.zzaxk.hashCode())) * 31) + (this.zzaxl == null ? 0 : this.zzaxl.hashCode())) * 31) + (this.zzaxm == null ? 0 : this.zzaxm.hashCode())) * 31) + (this.zzaxn == null ? 0 : this.zzaxn.hashCode())) * 31) + (this.zzaxo == null ? 0 : this.zzaxo.hashCode())) * 31) + (this.zzaxp == null ? 0 : this.zzaxp.hashCode())) * 31) + (this.zzaxq == null ? 0 : this.zzaxq.hashCode())) * 31) + (this.zzaxr == null ? 0 : this.zzaxr.hashCode())) * 31) + (this.zzahr == null ? 0 : this.zzahr.hashCode())) * 31) + (this.zzaxs == null ? 0 : this.zzaxs.hashCode())) * 31) + (this.zzafp == null ? 0 : this.zzafp.hashCode())) * 31) + (this.zztt == null ? 0 : this.zztt.hashCode())) * 31) + (this.zzts == null ? 0 : this.zzts.hashCode())) * 31) + (this.zzaxt == null ? 0 : this.zzaxt.hashCode())) * 31) + (this.zzaxu == null ? 0 : this.zzaxu.hashCode())) * 31) + (this.zzaxv == null ? 0 : this.zzaxv.hashCode())) * 31) + (this.zzaxw == null ? 0 : this.zzaxw.hashCode())) * 31) + (this.zzafh == null ? 0 : this.zzafh.hashCode())) * 31) + (this.zzaxx == null ? 0 : this.zzaxx.hashCode())) * 31) + (this.zzaxy == null ? 0 : this.zzaxy.hashCode())) * 31) + (this.zzagm == null ? 0 : this.zzagm.hashCode())) * 31) + (this.zzafi == null ? 0 : this.zzafi.hashCode())) * 31) + (this.zzaxz == null ? 0 : this.zzaxz.hashCode())) * 31) + zzyg.hashCode((Object[]) this.zzaya)) * 31) + (this.zzafk == null ? 0 : this.zzafk.hashCode())) * 31) + (this.zzayb == null ? 0 : this.zzayb.hashCode())) * 31) + (this.zzayc == null ? 0 : this.zzayc.hashCode())) * 31) + (this.zzayd == null ? 0 : this.zzayd.hashCode())) * 31) + (this.zzaye == null ? 0 : this.zzaye.hashCode())) * 31) + (this.zzayf == null ? 0 : this.zzayf.hashCode())) * 31) + (this.zzayg == null ? 0 : this.zzayg.hashCode())) * 31) + (this.zzayh == null ? 0 : this.zzayh.hashCode())) * 31) + (this.zzayi == null ? 0 : this.zzayi.hashCode())) * 31) + (this.zzayj == null ? 0 : this.zzayj.hashCode())) * 31) + (this.zzawp == null ? 0 : this.zzawp.hashCode());
        zzb zzb = this.zzayk;
        int i3 = hashCode * 31;
        if (zzb == null) {
            i = 0;
        } else {
            i = zzb.hashCode();
        }
        int hashCode2 = (((((i3 + i) * 31) + zzyg.hashCode(this.zzayl)) * 31) + (this.zzaym == null ? 0 : this.zzaym.hashCode())) * 31;
        if (this.zzcet != null && !this.zzcet.isEmpty()) {
            i2 = this.zzcet.hashCode();
        }
        return hashCode2 + i2;
    }

    public final void zza(zzya zzya) throws IOException {
        if (this.zzaxh != null) {
            zzya.zzd(1, this.zzaxh.intValue());
        }
        if (this.zzaxi != null && this.zzaxi.length > 0) {
            for (zzft zzft : this.zzaxi) {
                if (zzft != null) {
                    zzya.zza(2, (zzyi) zzft);
                }
            }
        }
        if (this.zzaxj != null && this.zzaxj.length > 0) {
            for (zzfz zzfz : this.zzaxj) {
                if (zzfz != null) {
                    zzya.zza(3, (zzyi) zzfz);
                }
            }
        }
        if (this.zzaxk != null) {
            zzya.zzi(4, this.zzaxk.longValue());
        }
        if (this.zzaxl != null) {
            zzya.zzi(5, this.zzaxl.longValue());
        }
        if (this.zzaxm != null) {
            zzya.zzi(6, this.zzaxm.longValue());
        }
        if (this.zzaxo != null) {
            zzya.zzi(7, this.zzaxo.longValue());
        }
        if (this.zzaxp != null) {
            zzya.zzb(8, this.zzaxp);
        }
        if (this.zzaxq != null) {
            zzya.zzb(9, this.zzaxq);
        }
        if (this.zzaxr != null) {
            zzya.zzb(10, this.zzaxr);
        }
        if (this.zzahr != null) {
            zzya.zzb(11, this.zzahr);
        }
        if (this.zzaxs != null) {
            zzya.zzd(12, this.zzaxs.intValue());
        }
        if (this.zzafp != null) {
            zzya.zzb(13, this.zzafp);
        }
        if (this.zztt != null) {
            zzya.zzb(14, this.zztt);
        }
        if (this.zzts != null) {
            zzya.zzb(16, this.zzts);
        }
        if (this.zzaxt != null) {
            zzya.zzi(17, this.zzaxt.longValue());
        }
        if (this.zzaxu != null) {
            zzya.zzi(18, this.zzaxu.longValue());
        }
        if (this.zzaxv != null) {
            zzya.zzb(19, this.zzaxv);
        }
        if (this.zzaxw != null) {
            zzya.zzb(20, this.zzaxw.booleanValue());
        }
        if (this.zzafh != null) {
            zzya.zzb(21, this.zzafh);
        }
        if (this.zzaxx != null) {
            zzya.zzi(22, this.zzaxx.longValue());
        }
        if (this.zzaxy != null) {
            zzya.zzd(23, this.zzaxy.intValue());
        }
        if (this.zzagm != null) {
            zzya.zzb(24, this.zzagm);
        }
        if (this.zzafi != null) {
            zzya.zzb(25, this.zzafi);
        }
        if (this.zzaxn != null) {
            zzya.zzi(26, this.zzaxn.longValue());
        }
        if (this.zzaxz != null) {
            zzya.zzb(28, this.zzaxz.booleanValue());
        }
        if (this.zzaya != null && this.zzaya.length > 0) {
            for (zzfr zzfr : this.zzaya) {
                if (zzfr != null) {
                    zzya.zza(29, (zzyi) zzfr);
                }
            }
        }
        if (this.zzafk != null) {
            zzya.zzb(30, this.zzafk);
        }
        if (this.zzayb != null) {
            zzya.zzd(31, this.zzayb.intValue());
        }
        if (this.zzayc != null) {
            zzya.zzd(32, this.zzayc.intValue());
        }
        if (this.zzayd != null) {
            zzya.zzd(33, this.zzayd.intValue());
        }
        if (this.zzaye != null) {
            zzya.zzb(34, this.zzaye);
        }
        if (this.zzayf != null) {
            zzya.zzi(35, this.zzayf.longValue());
        }
        if (this.zzayg != null) {
            zzya.zzi(36, this.zzayg.longValue());
        }
        if (this.zzayh != null) {
            zzya.zzb(37, this.zzayh);
        }
        if (this.zzayi != null) {
            zzya.zzb(38, this.zzayi);
        }
        if (this.zzayj != null) {
            zzya.zzd(39, this.zzayj.intValue());
        }
        if (this.zzawp != null) {
            zzya.zzb(41, this.zzawp);
        }
        if (this.zzayk != null) {
            zzya.zze(44, this.zzayk);
        }
        if (this.zzayl != null && this.zzayl.length > 0) {
            for (int i : this.zzayl) {
                zzya.zzc(45, 0);
                zzya.zzcd(i);
            }
        }
        if (this.zzaym != null) {
            zzya.zzi(46, this.zzaym.longValue());
        }
        super.zza(zzya);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        if (this.zzaxh != null) {
            zzf += zzya.zzh(1, this.zzaxh.intValue());
        }
        if (this.zzaxi != null && this.zzaxi.length > 0) {
            int i = zzf;
            for (zzft zzft : this.zzaxi) {
                if (zzft != null) {
                    i += zzya.zzb(2, (zzyi) zzft);
                }
            }
            zzf = i;
        }
        if (this.zzaxj != null && this.zzaxj.length > 0) {
            int i2 = zzf;
            for (zzfz zzfz : this.zzaxj) {
                if (zzfz != null) {
                    i2 += zzya.zzb(3, (zzyi) zzfz);
                }
            }
            zzf = i2;
        }
        if (this.zzaxk != null) {
            zzf += zzya.zzd(4, this.zzaxk.longValue());
        }
        if (this.zzaxl != null) {
            zzf += zzya.zzd(5, this.zzaxl.longValue());
        }
        if (this.zzaxm != null) {
            zzf += zzya.zzd(6, this.zzaxm.longValue());
        }
        if (this.zzaxo != null) {
            zzf += zzya.zzd(7, this.zzaxo.longValue());
        }
        if (this.zzaxp != null) {
            zzf += zzya.zzc(8, this.zzaxp);
        }
        if (this.zzaxq != null) {
            zzf += zzya.zzc(9, this.zzaxq);
        }
        if (this.zzaxr != null) {
            zzf += zzya.zzc(10, this.zzaxr);
        }
        if (this.zzahr != null) {
            zzf += zzya.zzc(11, this.zzahr);
        }
        if (this.zzaxs != null) {
            zzf += zzya.zzh(12, this.zzaxs.intValue());
        }
        if (this.zzafp != null) {
            zzf += zzya.zzc(13, this.zzafp);
        }
        if (this.zztt != null) {
            zzf += zzya.zzc(14, this.zztt);
        }
        if (this.zzts != null) {
            zzf += zzya.zzc(16, this.zzts);
        }
        if (this.zzaxt != null) {
            zzf += zzya.zzd(17, this.zzaxt.longValue());
        }
        if (this.zzaxu != null) {
            zzf += zzya.zzd(18, this.zzaxu.longValue());
        }
        if (this.zzaxv != null) {
            zzf += zzya.zzc(19, this.zzaxv);
        }
        if (this.zzaxw != null) {
            this.zzaxw.booleanValue();
            zzf += zzya.zzbd(20) + 1;
        }
        if (this.zzafh != null) {
            zzf += zzya.zzc(21, this.zzafh);
        }
        if (this.zzaxx != null) {
            zzf += zzya.zzd(22, this.zzaxx.longValue());
        }
        if (this.zzaxy != null) {
            zzf += zzya.zzh(23, this.zzaxy.intValue());
        }
        if (this.zzagm != null) {
            zzf += zzya.zzc(24, this.zzagm);
        }
        if (this.zzafi != null) {
            zzf += zzya.zzc(25, this.zzafi);
        }
        if (this.zzaxn != null) {
            zzf += zzya.zzd(26, this.zzaxn.longValue());
        }
        if (this.zzaxz != null) {
            this.zzaxz.booleanValue();
            zzf += zzya.zzbd(28) + 1;
        }
        if (this.zzaya != null && this.zzaya.length > 0) {
            int i3 = zzf;
            for (zzfr zzfr : this.zzaya) {
                if (zzfr != null) {
                    i3 += zzya.zzb(29, (zzyi) zzfr);
                }
            }
            zzf = i3;
        }
        if (this.zzafk != null) {
            zzf += zzya.zzc(30, this.zzafk);
        }
        if (this.zzayb != null) {
            zzf += zzya.zzh(31, this.zzayb.intValue());
        }
        if (this.zzayc != null) {
            zzf += zzya.zzh(32, this.zzayc.intValue());
        }
        if (this.zzayd != null) {
            zzf += zzya.zzh(33, this.zzayd.intValue());
        }
        if (this.zzaye != null) {
            zzf += zzya.zzc(34, this.zzaye);
        }
        if (this.zzayf != null) {
            zzf += zzya.zzd(35, this.zzayf.longValue());
        }
        if (this.zzayg != null) {
            zzf += zzya.zzd(36, this.zzayg.longValue());
        }
        if (this.zzayh != null) {
            zzf += zzya.zzc(37, this.zzayh);
        }
        if (this.zzayi != null) {
            zzf += zzya.zzc(38, this.zzayi);
        }
        if (this.zzayj != null) {
            zzf += zzya.zzh(39, this.zzayj.intValue());
        }
        if (this.zzawp != null) {
            zzf += zzya.zzc(41, this.zzawp);
        }
        if (this.zzayk != null) {
            zzf += zztv.zzc(44, (zzvv) this.zzayk);
        }
        if (this.zzayl != null && this.zzayl.length > 0) {
            int i4 = 0;
            for (int zzbl : this.zzayl) {
                i4 += zzya.zzbl(zzbl);
            }
            zzf = zzf + i4 + (this.zzayl.length * 2);
        }
        return this.zzaym != null ? zzf + zzya.zzd(46, this.zzaym.longValue()) : zzf;
    }

    public final /* synthetic */ zzyi zza(zzxz zzxz) throws IOException {
        while (true) {
            int zzuj = zzxz.zzuj();
            switch (zzuj) {
                case 0:
                    return this;
                case 8:
                    this.zzaxh = Integer.valueOf(zzxz.zzvb());
                    break;
                case 18:
                    int zzb = zzyl.zzb(zzxz, 18);
                    int length = this.zzaxi == null ? 0 : this.zzaxi.length;
                    zzft[] zzftArr = new zzft[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzaxi, 0, zzftArr, 0, length);
                    }
                    while (length < zzftArr.length - 1) {
                        zzftArr[length] = new zzft();
                        zzxz.zza((zzyi) zzftArr[length]);
                        zzxz.zzuj();
                        length++;
                    }
                    zzftArr[length] = new zzft();
                    zzxz.zza((zzyi) zzftArr[length]);
                    this.zzaxi = zzftArr;
                    break;
                case 26:
                    int zzb2 = zzyl.zzb(zzxz, 26);
                    int length2 = this.zzaxj == null ? 0 : this.zzaxj.length;
                    zzfz[] zzfzArr = new zzfz[(zzb2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzaxj, 0, zzfzArr, 0, length2);
                    }
                    while (length2 < zzfzArr.length - 1) {
                        zzfzArr[length2] = new zzfz();
                        zzxz.zza((zzyi) zzfzArr[length2]);
                        zzxz.zzuj();
                        length2++;
                    }
                    zzfzArr[length2] = new zzfz();
                    zzxz.zza((zzyi) zzfzArr[length2]);
                    this.zzaxj = zzfzArr;
                    break;
                case 32:
                    this.zzaxk = Long.valueOf(zzxz.zzvc());
                    break;
                case 40:
                    this.zzaxl = Long.valueOf(zzxz.zzvc());
                    break;
                case 48:
                    this.zzaxm = Long.valueOf(zzxz.zzvc());
                    break;
                case 56:
                    this.zzaxo = Long.valueOf(zzxz.zzvc());
                    break;
                case 66:
                    this.zzaxp = zzxz.readString();
                    break;
                case 74:
                    this.zzaxq = zzxz.readString();
                    break;
                case 82:
                    this.zzaxr = zzxz.readString();
                    break;
                case 90:
                    this.zzahr = zzxz.readString();
                    break;
                case 96:
                    this.zzaxs = Integer.valueOf(zzxz.zzvb());
                    break;
                case 106:
                    this.zzafp = zzxz.readString();
                    break;
                case 114:
                    this.zztt = zzxz.readString();
                    break;
                case 130:
                    this.zzts = zzxz.readString();
                    break;
                case 136:
                    this.zzaxt = Long.valueOf(zzxz.zzvc());
                    break;
                case 144:
                    this.zzaxu = Long.valueOf(zzxz.zzvc());
                    break;
                case 154:
                    this.zzaxv = zzxz.readString();
                    break;
                case 160:
                    this.zzaxw = Boolean.valueOf(zzxz.zzup());
                    break;
                case 170:
                    this.zzafh = zzxz.readString();
                    break;
                case 176:
                    this.zzaxx = Long.valueOf(zzxz.zzvc());
                    break;
                case 184:
                    this.zzaxy = Integer.valueOf(zzxz.zzvb());
                    break;
                case 194:
                    this.zzagm = zzxz.readString();
                    break;
                case 202:
                    this.zzafi = zzxz.readString();
                    break;
                case 208:
                    this.zzaxn = Long.valueOf(zzxz.zzvc());
                    break;
                case 224:
                    this.zzaxz = Boolean.valueOf(zzxz.zzup());
                    break;
                case 234:
                    int zzb3 = zzyl.zzb(zzxz, 234);
                    int length3 = this.zzaya == null ? 0 : this.zzaya.length;
                    zzfr[] zzfrArr = new zzfr[(zzb3 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzaya, 0, zzfrArr, 0, length3);
                    }
                    while (length3 < zzfrArr.length - 1) {
                        zzfrArr[length3] = new zzfr();
                        zzxz.zza((zzyi) zzfrArr[length3]);
                        zzxz.zzuj();
                        length3++;
                    }
                    zzfrArr[length3] = new zzfr();
                    zzxz.zza((zzyi) zzfrArr[length3]);
                    this.zzaya = zzfrArr;
                    break;
                case 242:
                    this.zzafk = zzxz.readString();
                    break;
                case 248:
                    this.zzayb = Integer.valueOf(zzxz.zzvb());
                    break;
                case 256:
                    this.zzayc = Integer.valueOf(zzxz.zzvb());
                    break;
                case 264:
                    this.zzayd = Integer.valueOf(zzxz.zzvb());
                    break;
                case 274:
                    this.zzaye = zzxz.readString();
                    break;
                case 280:
                    this.zzayf = Long.valueOf(zzxz.zzvc());
                    break;
                case 288:
                    this.zzayg = Long.valueOf(zzxz.zzvc());
                    break;
                case 298:
                    this.zzayh = zzxz.readString();
                    break;
                case 306:
                    this.zzayi = zzxz.readString();
                    break;
                case 312:
                    this.zzayj = Integer.valueOf(zzxz.zzvb());
                    break;
                case 330:
                    this.zzawp = zzxz.readString();
                    break;
                case 354:
                    zzb zzb4 = (zzb) zzxz.zza(zzb.zza());
                    if (this.zzayk != null) {
                        zzb4 = (zzb) ((zzuo) ((zza) ((zza) this.zzayk.zzwf()).zza(zzb4)).zzwo());
                    }
                    this.zzayk = zzb4;
                    break;
                case 360:
                    int zzb5 = zzyl.zzb(zzxz, 360);
                    int length4 = this.zzayl == null ? 0 : this.zzayl.length;
                    int[] iArr = new int[(zzb5 + length4)];
                    if (length4 != 0) {
                        System.arraycopy(this.zzayl, 0, iArr, 0, length4);
                    }
                    while (length4 < iArr.length - 1) {
                        iArr[length4] = zzxz.zzvb();
                        zzxz.zzuj();
                        length4++;
                    }
                    iArr[length4] = zzxz.zzvb();
                    this.zzayl = iArr;
                    break;
                case 362:
                    int zzas = zzxz.zzas(zzxz.zzvb());
                    int position = zzxz.getPosition();
                    int i = 0;
                    while (zzxz.zzyy() > 0) {
                        zzxz.zzvb();
                        i++;
                    }
                    zzxz.zzcb(position);
                    int length5 = this.zzayl == null ? 0 : this.zzayl.length;
                    int[] iArr2 = new int[(i + length5)];
                    if (length5 != 0) {
                        System.arraycopy(this.zzayl, 0, iArr2, 0, length5);
                    }
                    while (length5 < iArr2.length) {
                        iArr2[length5] = zzxz.zzvb();
                        length5++;
                    }
                    this.zzayl = iArr2;
                    zzxz.zzat(zzas);
                    break;
                case 368:
                    this.zzaym = Long.valueOf(zzxz.zzvc());
                    break;
                default:
                    if (super.zza(zzxz, zzuj)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }
}
