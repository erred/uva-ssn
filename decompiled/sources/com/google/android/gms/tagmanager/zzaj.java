package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzp;
import java.util.Map;

@VisibleForTesting
final class zzaj extends zzbq {

    /* renamed from: ID */
    private static final String f6665ID = zza.CONTAINER_VERSION.toString();
    private final String version;

    public zzaj(String str) {
        super(f6665ID, new String[0]);
        this.version = str;
    }

    public final boolean zznk() {
        return true;
    }

    public final zzp zzc(Map<String, zzp> map) {
        return this.version == null ? zzgj.zzqq() : zzgj.zzj(this.version);
    }
}
