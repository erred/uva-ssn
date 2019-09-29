package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Map;

public final class zzri {
    private final zzp zzbfq;
    private final Map<String, zzp> zzbox;

    private zzri(Map<String, zzp> map, zzp zzp) {
        this.zzbox = map;
        this.zzbfq = zzp;
    }

    public static zzrj zzsz() {
        return new zzrj();
    }

    public final void zza(String str, zzp zzp) {
        this.zzbox.put(str, zzp);
    }

    public final Map<String, zzp> zzsi() {
        return Collections.unmodifiableMap(this.zzbox);
    }

    public final zzp zzpw() {
        return this.zzbfq;
    }

    public final String toString() {
        String valueOf = String.valueOf(Collections.unmodifiableMap(this.zzbox));
        String valueOf2 = String.valueOf(this.zzbfq);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32 + String.valueOf(valueOf2).length());
        sb.append("Properties: ");
        sb.append(valueOf);
        sb.append(" pushAfterEvaluate: ");
        sb.append(valueOf2);
        return sb.toString();
    }
}
