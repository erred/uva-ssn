package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
public final class zzrj {
    private zzp zzbfq;
    private final Map<String, zzp> zzbox;

    private zzrj() {
        this.zzbox = new HashMap();
    }

    public final zzrj zzb(String str, zzp zzp) {
        this.zzbox.put(str, zzp);
        return this;
    }

    public final zzrj zzm(zzp zzp) {
        this.zzbfq = zzp;
        return this;
    }

    public final zzri zzta() {
        return new zzri(this.zzbox, this.zzbfq);
    }
}
