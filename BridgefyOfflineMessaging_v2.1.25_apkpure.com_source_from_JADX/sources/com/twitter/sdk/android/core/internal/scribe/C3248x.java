package com.twitter.sdk.android.core.internal.scribe;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.x */
/* compiled from: SyndicatedSdkImpressionEvent */
public class C3248x extends C3238s {
    @SerializedName("external_ids")

    /* renamed from: f */
    public final C3249a f8511f;
    @SerializedName("device_id_created_at")

    /* renamed from: g */
    public final long f8512g = 0;
    @SerializedName("language")

    /* renamed from: h */
    public final String f8513h;

    /* renamed from: com.twitter.sdk.android.core.internal.scribe.x$a */
    /* compiled from: SyndicatedSdkImpressionEvent */
    public class C3249a {
        @SerializedName("AD_ID")

        /* renamed from: a */
        public final String f8514a;

        public C3249a(String str) {
            this.f8514a = str;
        }
    }

    public C3248x(C3215e eVar, long j, String str, String str2, List<C3243w> list) {
        super("syndicated_sdk_impression", eVar, j, list);
        this.f8513h = str;
        this.f8511f = new C3249a(str2);
    }
}
