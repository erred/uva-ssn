package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.firebase.auth.ProviderQueryResult;
import java.util.List;

public final class zzp implements ProviderQueryResult {
    private List<String> zzrb;

    public zzp(zzcj zzcj) {
        Preconditions.checkNotNull(zzcj);
        this.zzrb = zzcj.getAllProviders();
    }

    public final List<String> getProviders() {
        return this.zzrb;
    }
}
