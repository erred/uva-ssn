package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

public final class zzef extends zzaj implements HasOptions {
    private final String zzmo;

    private zzef(String str) {
        this.zzmo = Preconditions.checkNotEmpty(str, "A valid API key must be provided");
    }

    public final String getApiKey() {
        return this.zzmo;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzef)) {
            return false;
        }
        return Objects.equal(this.zzmo, ((zzef) obj).zzmo);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzmo);
    }

    public final /* synthetic */ zzaj zzcz() {
        return (zzef) clone();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new zzeg(this.zzmo).zzdk();
    }

    /* synthetic */ zzef(String str, zzee zzee) {
        this(str);
    }
}
