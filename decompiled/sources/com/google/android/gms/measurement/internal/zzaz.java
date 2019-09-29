package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;

final class zzaz implements Runnable {
    private final String packageName;
    private final int status;
    private final zzay zzamn;
    private final Throwable zzamo;
    private final byte[] zzamp;
    private final Map<String, List<String>> zzamq;

    private zzaz(String str, zzay zzay, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        Preconditions.checkNotNull(zzay);
        this.zzamn = zzay;
        this.status = i;
        this.zzamo = th;
        this.zzamp = bArr;
        this.packageName = str;
        this.zzamq = map;
    }

    public final void run() {
        this.zzamn.zza(this.packageName, this.status, this.zzamo, this.zzamp, this.zzamq);
    }
}
