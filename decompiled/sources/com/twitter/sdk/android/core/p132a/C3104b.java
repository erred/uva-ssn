package com.twitter.sdk.android.core.p132a;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.twitter.sdk.android.core.a.b */
/* compiled from: ApiErrors */
public class C3104b {
    @SerializedName("errors")

    /* renamed from: a */
    public final List<C3103a> f8161a;

    private C3104b() {
        this(null);
    }

    public C3104b(List<C3103a> list) {
        this.f8161a = C3113k.m9131a(list);
    }
}
