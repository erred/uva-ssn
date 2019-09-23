package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzp;
import java.util.Map;

final class zzi extends zzbq {

    /* renamed from: ID */
    private static final String f6702ID = zza.APP_ID.toString();
    private final Context zzri;

    public zzi(Context context) {
        super(f6702ID, new String[0]);
        this.zzri = context;
    }

    public final boolean zznk() {
        return true;
    }

    public final zzp zzc(Map<String, zzp> map) {
        return zzgj.zzj(this.zzri.getPackageName());
    }
}
