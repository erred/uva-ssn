package com.twitter.sdk.android.core.p132a;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.twitter.sdk.android.core.a.q */
/* compiled from: TweetEntities */
public class C3121q {

    /* renamed from: a */
    static final C3121q f8246a;
    @SerializedName("urls")

    /* renamed from: b */
    public final List<C3122r> f8247b;
    @SerializedName("user_mentions")

    /* renamed from: c */
    public final List<Object> f8248c;
    @SerializedName("media")

    /* renamed from: d */
    public final List<C3112j> f8249d;
    @SerializedName("hashtags")

    /* renamed from: e */
    public final List<Object> f8250e;
    @SerializedName("symbols")

    /* renamed from: f */
    public final List<Object> f8251f;

    static {
        C3121q qVar = new C3121q(null, null, null, null, null);
        f8246a = qVar;
    }

    private C3121q() {
        this(null, null, null, null, null);
    }

    public C3121q(List<C3122r> list, List<Object> list2, List<C3112j> list3, List<Object> list4, List<Object> list5) {
        this.f8247b = C3113k.m9131a(list);
        this.f8248c = C3113k.m9131a(list2);
        this.f8249d = C3113k.m9131a(list3);
        this.f8250e = C3113k.m9131a(list4);
        this.f8251f = C3113k.m9131a(list5);
    }
}
