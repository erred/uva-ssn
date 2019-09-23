package com.twitter.sdk.android.core.internal.scribe;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.y */
/* compiled from: SyndicationClientEvent */
public class C3250y extends C3238s {
    @SerializedName("language")

    /* renamed from: f */
    public final String f8516f;
    @SerializedName("event_info")

    /* renamed from: g */
    public final String f8517g;
    @SerializedName("external_ids")

    /* renamed from: h */
    public final C3251a f8518h;

    /* renamed from: com.twitter.sdk.android.core.internal.scribe.y$a */
    /* compiled from: SyndicationClientEvent */
    public class C3251a {
        @SerializedName("6")

        /* renamed from: a */
        public final String f8519a;

        public C3251a(String str) {
            this.f8519a = str;
        }
    }

    public C3250y(C3215e eVar, String str, long j, String str2, String str3, List<C3243w> list) {
        super("tfw_client_event", eVar, j, list);
        this.f8516f = str2;
        this.f8517g = str;
        this.f8518h = new C3251a(str3);
    }
}
