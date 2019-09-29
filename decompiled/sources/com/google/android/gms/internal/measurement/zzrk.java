package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@VisibleForTesting
public final class zzrk {
    private final String version;
    private final List<zzrm> zzbov;
    private final Map<String, List<zzri>> zzbow;
    private final int zzph;

    private zzrk(List<zzrm> list, Map<String, List<zzri>> map, String str, int i) {
        this.zzbov = Collections.unmodifiableList(list);
        this.zzbow = Collections.unmodifiableMap(map);
        this.version = str;
        this.zzph = i;
    }

    public static zzrl zztb() {
        return new zzrl();
    }

    public final List<zzrm> zzsg() {
        return this.zzbov;
    }

    public final String getVersion() {
        return this.version;
    }

    public final Map<String, List<zzri>> zztc() {
        return this.zzbow;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzbov);
        String valueOf2 = String.valueOf(this.zzbow);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 17 + String.valueOf(valueOf2).length());
        sb.append("Rules: ");
        sb.append(valueOf);
        sb.append("  Macros: ");
        sb.append(valueOf2);
        return sb.toString();
    }
}
