package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzp;
import java.util.Map;

final class zzea extends zzbq {

    /* renamed from: ID */
    private static final String f6688ID = zza.OS_VERSION.toString();

    public zzea() {
        super(f6688ID, new String[0]);
    }

    public final boolean zznk() {
        return true;
    }

    public final zzp zzc(Map<String, zzp> map) {
        return zzgj.zzj(VERSION.RELEASE);
    }
}
