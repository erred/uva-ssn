package com.twitter.sdk.android.core;

import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.C3102a;

/* renamed from: com.twitter.sdk.android.core.k */
/* compiled from: Session */
public class C3254k<T extends C3102a> {
    @SerializedName("auth_token")

    /* renamed from: a */
    private final T f8525a;
    @SerializedName("id")

    /* renamed from: b */
    private final long f8526b;

    public C3254k(T t, long j) {
        if (t != null) {
            this.f8525a = t;
            this.f8526b = j;
            return;
        }
        throw new IllegalArgumentException("AuthToken must not be null.");
    }

    /* renamed from: a */
    public T mo27849a() {
        return this.f8525a;
    }

    /* renamed from: b */
    public long mo27850b() {
        return this.f8526b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3254k kVar = (C3254k) obj;
        if (this.f8526b != kVar.f8526b) {
            return false;
        }
        if (this.f8525a != null) {
            z = this.f8525a.equals(kVar.f8525a);
        } else if (kVar.f8525a != null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((this.f8525a != null ? this.f8525a.hashCode() : 0) * 31) + ((int) (this.f8526b ^ (this.f8526b >>> 32)));
    }
}
