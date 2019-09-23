package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfe.zza;
import com.google.android.gms.internal.measurement.zzfe.zzb;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfz;
import com.google.android.gms.internal.measurement.zzuo;
import com.google.android.gms.internal.measurement.zzya;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

final class zzdv extends zzfn {
    public zzdv(zzfo zzfo) {
        super(zzfo);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgy() {
        return false;
    }

    public final byte[] zzb(zzag zzag, String str) {
        Integer num;
        zzg zzg;
        zzfv zzfv;
        zzfw zzfw;
        Bundle bundle;
        zzac zzac;
        long j;
        zzfx zzfx;
        zzag zzag2 = zzag;
        String str2 = str;
        zzaf();
        this.zzada.zzgf();
        Preconditions.checkNotNull(zzag);
        Preconditions.checkNotEmpty(str);
        if (!zzgv().zze(str2, zzai.zzalf)) {
            zzgt().zzjn().zzg("Generating ScionPayload disabled. packageName", str2);
            return new byte[0];
        } else if ("_iap".equals(zzag2.name) || "_iapx".equals(zzag2.name)) {
            zzfv zzfv2 = new zzfv();
            zzjt().beginTransaction();
            try {
                zzg zzbm = zzjt().zzbm(str2);
                if (zzbm == null) {
                    zzgt().zzjn().zzg("Log and bundle not available. package_name", str2);
                    return new byte[0];
                } else if (!zzbm.isMeasurementEnabled()) {
                    zzgt().zzjn().zzg("Log and bundle disabled. package_name", str2);
                    byte[] bArr = new byte[0];
                    zzjt().endTransaction();
                    return bArr;
                } else {
                    zzfw zzfw2 = new zzfw();
                    zzfv2.zzaxf = new zzfw[]{zzfw2};
                    zzfw2.zzaxh = Integer.valueOf(1);
                    zzfw2.zzaxp = BleHandshake.DEVICE_TYPE;
                    zzfw2.zztt = zzbm.zzal();
                    zzfw2.zzafp = zzbm.zzhg();
                    zzfw2.zzts = zzbm.zzak();
                    long zzhf = zzbm.zzhf();
                    if (zzhf == -2147483648L) {
                        num = null;
                    } else {
                        num = Integer.valueOf((int) zzhf);
                    }
                    zzfw2.zzayb = num;
                    zzfw2.zzaxt = Long.valueOf(zzbm.zzhh());
                    zzfw2.zzafi = zzbm.getGmpAppId();
                    if (TextUtils.isEmpty(zzfw2.zzafi)) {
                        zzfw2.zzawp = zzbm.zzhb();
                    }
                    zzfw2.zzaxx = Long.valueOf(zzbm.zzhi());
                    if (this.zzada.isEnabled() && zzq.zzie() && zzgv().zzas(zzfw2.zztt)) {
                        zzfw2.zzayh = null;
                    }
                    Pair zzbz = zzgu().zzbz(zzbm.zzal());
                    if (zzbm.zzhw() && zzbz != null && !TextUtils.isEmpty((CharSequence) zzbz.first)) {
                        zzfw2.zzaxv = zzr((String) zzbz.first, Long.toString(zzag2.zzaig));
                        zzfw2.zzaxw = (Boolean) zzbz.second;
                    }
                    zzgp().zzcl();
                    zzfw2.zzaxr = Build.MODEL;
                    zzgp().zzcl();
                    zzfw2.zzaxq = VERSION.RELEASE;
                    zzfw2.zzaxs = Integer.valueOf((int) zzgp().zziw());
                    zzfw2.zzahr = zzgp().zzix();
                    try {
                        zzfw2.zzafh = zzr(zzbm.getAppInstanceId(), Long.toString(zzag2.zzaig));
                        zzfw2.zzafk = zzbm.getFirebaseInstanceId();
                        String str3 = zzfw2.zztt;
                        List zzbl = zzjt().zzbl(str3);
                        if (zzgv().zzau(str2)) {
                            Iterator it = zzbl.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    zzfx = null;
                                    break;
                                }
                                zzfx = (zzfx) it.next();
                                if ("_lte".equals(zzfx.name)) {
                                    break;
                                }
                            }
                            if (zzfx == null || zzfx.value == null) {
                                zzfx zzfx2 = new zzfx(str3, "auto", "_lte", zzbx().currentTimeMillis(), Long.valueOf(0));
                                zzbl.add(zzfx2);
                                zzjt().zza(zzfx2);
                            }
                        }
                        zzfz[] zzfzArr = new zzfz[zzbl.size()];
                        for (int i = 0; i < zzbl.size(); i++) {
                            zzfz zzfz = new zzfz();
                            zzfzArr[i] = zzfz;
                            zzfz.name = ((zzfx) zzbl.get(i)).name;
                            zzfz.zzayu = Long.valueOf(((zzfx) zzbl.get(i)).zzauk);
                            zzjr().zza(zzfz, ((zzfx) zzbl.get(i)).value);
                        }
                        zzfw2.zzaxj = zzfzArr;
                        Bundle zziy = zzag2.zzahu.zziy();
                        zziy.putLong("_c", 1);
                        zzgt().zzjn().zzby("Marking in-app purchase as real-time");
                        zziy.putLong("_r", 1);
                        zziy.putString("_o", zzag2.origin);
                        if (zzgr().zzcz(zzfw2.zztt)) {
                            zzgr().zza(zziy, "_dbg", (Object) Long.valueOf(1));
                            zzgr().zza(zziy, "_r", (Object) Long.valueOf(1));
                        }
                        zzac zzg2 = zzjt().zzg(str2, zzag2.name);
                        if (zzg2 == null) {
                            bundle = zziy;
                            zzfw = zzfw2;
                            zzfv = zzfv2;
                            zzg = zzbm;
                            zzac zzac2 = new zzac(str, zzag2.name, 0, 0, zzag2.zzaig, 0, null, null, null, null);
                            zzac = zzac2;
                            j = 0;
                        } else {
                            bundle = zziy;
                            zzfw = zzfw2;
                            zzfv = zzfv2;
                            zzg = zzbm;
                            j = zzg2.zzahx;
                            zzac = zzg2.zzae(zzag2.zzaig);
                        }
                        zzjt().zza(zzac);
                        zzab zzab = new zzab(this.zzada, zzag2.origin, str, zzag2.name, zzag2.zzaig, j, bundle);
                        zzft zzft = new zzft();
                        zzfw zzfw3 = zzfw;
                        zzfw3.zzaxi = new zzft[]{zzft};
                        zzft.zzaxb = Long.valueOf(zzab.timestamp);
                        zzft.name = zzab.name;
                        zzft.zzaxc = Long.valueOf(zzab.zzaht);
                        zzft.zzaxa = new zzfu[zzab.zzahu.size()];
                        Iterator it2 = zzab.zzahu.iterator();
                        int i2 = 0;
                        while (it2.hasNext()) {
                            String str4 = (String) it2.next();
                            zzfu zzfu = new zzfu();
                            int i3 = i2 + 1;
                            zzft.zzaxa[i2] = zzfu;
                            zzfu.name = str4;
                            zzjr().zza(zzfu, zzab.zzahu.get(str4));
                            i2 = i3;
                        }
                        zzfw3.zzayk = (zzb) ((zzuo) zzb.zzmp().zzb((zza) ((zzuo) zza.zzmn().zzan(zzac.zzahv).zzda(zzag2.name).zzwo())).zzwo());
                        zzfw3.zzaya = zzjs().zza(zzg.zzal(), (zzft[]) null, zzfw3.zzaxj);
                        zzfw3.zzaxl = zzft.zzaxb;
                        zzfw3.zzaxm = zzft.zzaxb;
                        long zzhe = zzg.zzhe();
                        zzfw3.zzaxo = zzhe != 0 ? Long.valueOf(zzhe) : null;
                        long zzhd = zzg.zzhd();
                        if (zzhd != 0) {
                            zzhe = zzhd;
                        }
                        zzfw3.zzaxn = zzhe != 0 ? Long.valueOf(zzhe) : null;
                        zzg.zzhm();
                        zzfw3.zzaxy = Integer.valueOf((int) zzg.zzhj());
                        zzfw3.zzaxu = Long.valueOf(zzgv().zzhh());
                        zzfw3.zzaxk = Long.valueOf(zzbx().currentTimeMillis());
                        zzfw3.zzaxz = Boolean.TRUE;
                        zzg zzg3 = zzg;
                        zzg3.zzo(zzfw3.zzaxl.longValue());
                        zzg3.zzp(zzfw3.zzaxm.longValue());
                        zzjt().zza(zzg3);
                        zzjt().setTransactionSuccessful();
                        zzjt().endTransaction();
                        try {
                            byte[] bArr2 = new byte[zzfv.zzvx()];
                            zzya zzk = zzya.zzk(bArr2, 0, bArr2.length);
                            zzfv.zza(zzk);
                            zzk.zzza();
                            return zzjr().zzb(bArr2);
                        } catch (IOException e) {
                            zzgt().zzjg().zze("Data loss. Failed to bundle and serialize. appId", zzas.zzbw(str), e);
                            return null;
                        }
                    } catch (SecurityException e2) {
                        zzgt().zzjn().zzg("app instance id encryption failed", e2.getMessage());
                        byte[] bArr3 = new byte[0];
                        zzjt().endTransaction();
                        return bArr3;
                    }
                }
            } catch (SecurityException e3) {
                zzgt().zzjn().zzg("Resettable device id encryption failed", e3.getMessage());
                return new byte[0];
            } finally {
                zzjt().endTransaction();
            }
        } else {
            zzgt().zzjn().zze("Generating a payload for this event is not available. package_name, event_name", str2, zzag2.name);
            return null;
        }
    }

    private static String zzr(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }
}
