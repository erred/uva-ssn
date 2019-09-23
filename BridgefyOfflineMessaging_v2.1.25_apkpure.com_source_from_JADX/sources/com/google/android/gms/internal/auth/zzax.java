package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi.SpatulaHeaderResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

public final class zzax implements SpatulaHeaderResult {
    private Status mStatus;
    private String zzci;

    public zzax(String str) {
        this.zzci = (String) Preconditions.checkNotNull(str);
        this.mStatus = Status.RESULT_SUCCESS;
    }

    public zzax(Status status) {
        this.mStatus = (Status) Preconditions.checkNotNull(status);
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final String getSpatulaHeader() {
        return this.zzci;
    }
}
