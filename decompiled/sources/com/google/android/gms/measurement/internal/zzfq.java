package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

final class zzfq implements zzay {
    private final /* synthetic */ zzfo zzaue;
    private final /* synthetic */ String zzauf;

    zzfq(zzfo zzfo, String str) {
        this.zzaue = zzfo;
        this.zzauf = str;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzaue.zza(i, th, bArr, this.zzauf);
    }
}
