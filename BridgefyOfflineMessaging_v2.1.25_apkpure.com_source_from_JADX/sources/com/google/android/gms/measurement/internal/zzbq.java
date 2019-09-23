package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.p052b.C0712a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfk;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzxz;
import com.google.android.gms.internal.measurement.zzya;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import java.io.IOException;
import java.util.Map;

public final class zzbq extends zzfn implements zzs {
    @VisibleForTesting
    private static int zzaoi = 65535;
    @VisibleForTesting
    private static int zzaoj = 2;
    private final Map<String, Map<String, String>> zzaok = new C0712a();
    private final Map<String, Map<String, Boolean>> zzaol = new C0712a();
    private final Map<String, Map<String, Boolean>> zzaom = new C0712a();
    private final Map<String, zzfp> zzaon = new C0712a();
    private final Map<String, Map<String, Integer>> zzaoo = new C0712a();
    private final Map<String, String> zzaop = new C0712a();

    zzbq(zzfo zzfo) {
        super(zzfo);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgy() {
        return false;
    }

    private final void zzcf(String str) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        if (this.zzaon.get(str) == null) {
            byte[] zzbo = zzjt().zzbo(str);
            if (zzbo == null) {
                this.zzaok.put(str, null);
                this.zzaol.put(str, null);
                this.zzaom.put(str, null);
                this.zzaon.put(str, null);
                this.zzaop.put(str, null);
                this.zzaoo.put(str, null);
                return;
            }
            zzfp zza = zza(str, zzbo);
            this.zzaok.put(str, zza(zza));
            zza(str, zza);
            this.zzaon.put(str, zza);
            this.zzaop.put(str, null);
        }
    }

    /* access modifiers changed from: protected */
    public final zzfp zzcg(String str) {
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        zzcf(str);
        return (zzfp) this.zzaon.get(str);
    }

    /* access modifiers changed from: protected */
    public final String zzch(String str) {
        zzaf();
        return (String) this.zzaop.get(str);
    }

    /* access modifiers changed from: protected */
    public final void zzci(String str) {
        zzaf();
        this.zzaop.put(str, null);
    }

    /* access modifiers changed from: 0000 */
    public final void zzcj(String str) {
        zzaf();
        this.zzaon.remove(str);
    }

    public final String zzf(String str, String str2) {
        zzaf();
        zzcf(str);
        Map map = (Map) this.zzaok.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    private static Map<String, String> zza(zzfp zzfp) {
        zzfq[] zzfqArr;
        C0712a aVar = new C0712a();
        if (!(zzfp == null || zzfp.zzawm == null)) {
            for (zzfq zzfq : zzfp.zzawm) {
                if (zzfq != null) {
                    aVar.put(zzfq.zzoj, zzfq.value);
                }
            }
        }
        return aVar;
    }

    private final void zza(String str, zzfp zzfp) {
        zzfo[] zzfoArr;
        C0712a aVar = new C0712a();
        C0712a aVar2 = new C0712a();
        C0712a aVar3 = new C0712a();
        if (!(zzfp == null || zzfp.zzawn == null)) {
            for (zzfo zzfo : zzfp.zzawn) {
                if (TextUtils.isEmpty(zzfo.name)) {
                    zzgt().zzjj().zzby("EventConfig contained null event name");
                } else {
                    String zzco = zzcu.zzco(zzfo.name);
                    if (!TextUtils.isEmpty(zzco)) {
                        zzfo.name = zzco;
                    }
                    aVar.put(zzfo.name, zzfo.zzawh);
                    aVar2.put(zzfo.name, zzfo.zzawi);
                    if (zzfo.zzawj != null) {
                        if (zzfo.zzawj.intValue() < zzaoj || zzfo.zzawj.intValue() > zzaoi) {
                            zzgt().zzjj().zze("Invalid sampling rate. Event name, sample rate", zzfo.name, zzfo.zzawj);
                        } else {
                            aVar3.put(zzfo.name, zzfo.zzawj);
                        }
                    }
                }
            }
        }
        this.zzaol.put(str, aVar);
        this.zzaom.put(str, aVar2);
        this.zzaoo.put(str, aVar3);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(String str, byte[] bArr, String str2) {
        byte[] bArr2;
        zzfj[] zzfjArr;
        zzfm[] zzfmArr;
        zzfk[] zzfkArr;
        String str3 = str;
        zzcl();
        zzaf();
        Preconditions.checkNotEmpty(str);
        zzfp zza = zza(str, bArr);
        if (zza == null) {
            return false;
        }
        zza(str3, zza);
        this.zzaon.put(str3, zza);
        this.zzaop.put(str3, str2);
        this.zzaok.put(str3, zza(zza));
        zzm zzjs = zzjs();
        zzfi[] zzfiArr = zza.zzawo;
        Preconditions.checkNotNull(zzfiArr);
        for (zzfi zzfi : zzfiArr) {
            for (zzfj zzfj : zzfi.zzavg) {
                String zzco = zzcu.zzco(zzfj.zzavl);
                if (zzco != null) {
                    zzfj.zzavl = zzco;
                }
                for (zzfk zzfk : zzfj.zzavm) {
                    String zzco2 = zzcv.zzco(zzfk.zzavt);
                    if (zzco2 != null) {
                        zzfk.zzavt = zzco2;
                    }
                }
            }
            for (zzfm zzfm : zzfi.zzavf) {
                String zzco3 = zzcw.zzco(zzfm.zzawa);
                if (zzco3 != null) {
                    zzfm.zzawa = zzco3;
                }
            }
        }
        zzjs.zzjt().zza(str3, zzfiArr);
        try {
            zza.zzawo = null;
            bArr2 = new byte[zza.zzvx()];
            zza.zza(zzya.zzk(bArr2, 0, bArr2.length));
        } catch (IOException e) {
            zzgt().zzjj().zze("Unable to serialize reduced-size config. Storing full config instead. appId", zzas.zzbw(str), e);
            bArr2 = bArr;
        }
        zzt zzjt = zzjt();
        Preconditions.checkNotEmpty(str);
        zzjt.zzaf();
        zzjt.zzcl();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr2);
        try {
            if (((long) zzjt.getWritableDatabase().update("apps", contentValues, "app_id = ?", new String[]{str3})) == 0) {
                zzjt.zzgt().zzjg().zzg("Failed to update remote config (got 0). appId", zzas.zzbw(str));
            }
        } catch (SQLiteException e2) {
            zzjt.zzgt().zzjg().zze("Error storing remote config. appId", zzas.zzbw(str), e2);
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzo(String str, String str2) {
        zzaf();
        zzcf(str);
        if (zzcl(str) && zzfy.zzcy(str2)) {
            return true;
        }
        if (zzcm(str) && zzfy.zzct(str2)) {
            return true;
        }
        Map map = (Map) this.zzaol.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzp(String str, String str2) {
        zzaf();
        zzcf(str);
        if (Event.ECOMMERCE_PURCHASE.equals(str2)) {
            return true;
        }
        Map map = (Map) this.zzaom.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: 0000 */
    public final int zzq(String str, String str2) {
        zzaf();
        zzcf(str);
        Map map = (Map) this.zzaoo.get(str);
        if (map == null) {
            return 1;
        }
        Integer num = (Integer) map.get(str2);
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: 0000 */
    public final long zzck(String str) {
        String zzf = zzf(str, "measurement.account.time_zone_offset_minutes");
        if (!TextUtils.isEmpty(zzf)) {
            try {
                return Long.parseLong(zzf);
            } catch (NumberFormatException e) {
                zzgt().zzjj().zze("Unable to parse timezone offset. appId", zzas.zzbw(str), e);
            }
        }
        return 0;
    }

    private final zzfp zza(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzfp();
        }
        zzxz zzj = zzxz.zzj(bArr, 0, bArr.length);
        zzfp zzfp = new zzfp();
        try {
            zzfp.zza(zzj);
            zzgt().zzjo().zze("Parsed config. version, gmp_app_id", zzfp.zzawk, zzfp.zzafi);
            return zzfp;
        } catch (IOException e) {
            zzgt().zzjj().zze("Unable to merge remote config. appId", zzas.zzbw(str), e);
            return new zzfp();
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzcl(String str) {
        return "1".equals(zzf(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzcm(String str) {
        return "1".equals(zzf(str, "measurement.upload.blacklist_public"));
    }

    public final /* bridge */ /* synthetic */ zzfu zzjr() {
        return super.zzjr();
    }

    public final /* bridge */ /* synthetic */ zzm zzjs() {
        return super.zzjs();
    }

    public final /* bridge */ /* synthetic */ zzt zzjt() {
        return super.zzjt();
    }

    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    public final /* bridge */ /* synthetic */ zzfy zzgr() {
        return super.zzgr();
    }

    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }
}
