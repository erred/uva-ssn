package com.twitter.sdk.android.core;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.twitter.sdk.android.core.a */
/* compiled from: AuthToken */
public abstract class C3102a {
    @SerializedName("created_at")

    /* renamed from: a */
    protected final long f8159a;

    public C3102a() {
        this(System.currentTimeMillis());
    }

    protected C3102a(long j) {
        this.f8159a = j;
    }
}
