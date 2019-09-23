package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzp;
import java.util.Map;

final class zzh extends zzbq {

    /* renamed from: ID */
    private static final String f6701ID = zza.ADWORDS_CLICK_REFERRER.toString();
    private static final String zzazg = zzb.COMPONENT.toString();
    private static final String zzazh = zzb.CONVERSION_ID.toString();
    private final Context zzri;

    public zzh(Context context) {
        super(f6701ID, zzazh);
        this.zzri = context;
    }

    public final boolean zznk() {
        return true;
    }

    public final zzp zzc(Map<String, zzp> map) {
        zzp zzp = (zzp) map.get(zzazh);
        if (zzp == null) {
            return zzgj.zzqq();
        }
        String zzc = zzgj.zzc(zzp);
        zzp zzp2 = (zzp) map.get(zzazg);
        String zzc2 = zzp2 != null ? zzgj.zzc(zzp2) : null;
        Context context = this.zzri;
        String str = (String) zzcw.zzbcv.get(zzc);
        if (str == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            str = sharedPreferences != null ? sharedPreferences.getString(zzc, "") : "";
            zzcw.zzbcv.put(zzc, str);
        }
        String zzw = zzcw.zzw(str, zzc2);
        return zzw != null ? zzgj.zzj(zzw) : zzgj.zzqq();
    }
}
