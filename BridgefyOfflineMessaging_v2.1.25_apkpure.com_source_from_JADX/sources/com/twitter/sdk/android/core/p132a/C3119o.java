package com.twitter.sdk.android.core.p132a;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.twitter.sdk.android.core.a.o */
/* compiled from: Tweet */
public class C3119o {
    @SerializedName(alternate = {"full_text"}, value = "text")

    /* renamed from: A */
    public final String f8178A;
    @SerializedName("display_text_range")

    /* renamed from: B */
    public final List<Integer> f8179B;
    @SerializedName("truncated")

    /* renamed from: C */
    public final boolean f8180C;
    @SerializedName("user")

    /* renamed from: D */
    public final C3123s f8181D;
    @SerializedName("withheld_copyright")

    /* renamed from: E */
    public final boolean f8182E;
    @SerializedName("withheld_in_countries")

    /* renamed from: F */
    public final List<String> f8183F;
    @SerializedName("withheld_scope")

    /* renamed from: G */
    public final String f8184G;
    @SerializedName("card")

    /* renamed from: H */
    public final C3107e f8185H;
    @SerializedName("coordinates")

    /* renamed from: a */
    public final C3108f f8186a;
    @SerializedName("created_at")

    /* renamed from: b */
    public final String f8187b;
    @SerializedName("current_user_retweet")

    /* renamed from: c */
    public final Object f8188c;
    @SerializedName("entities")

    /* renamed from: d */
    public final C3121q f8189d;
    @SerializedName("extended_entities")

    /* renamed from: e */
    public final C3121q f8190e;
    @SerializedName("favorite_count")

    /* renamed from: f */
    public final Integer f8191f;
    @SerializedName("favorited")

    /* renamed from: g */
    public final boolean f8192g;
    @SerializedName("filter_level")

    /* renamed from: h */
    public final String f8193h;
    @SerializedName("id")

    /* renamed from: i */
    public final long f8194i;
    @SerializedName("id_str")

    /* renamed from: j */
    public final String f8195j;
    @SerializedName("in_reply_to_screen_name")

    /* renamed from: k */
    public final String f8196k;
    @SerializedName("in_reply_to_status_id")

    /* renamed from: l */
    public final long f8197l;
    @SerializedName("in_reply_to_status_id_str")

    /* renamed from: m */
    public final String f8198m;
    @SerializedName("in_reply_to_user_id")

    /* renamed from: n */
    public final long f8199n;
    @SerializedName("in_reply_to_user_id_str")

    /* renamed from: o */
    public final String f8200o;
    @SerializedName("lang")

    /* renamed from: p */
    public final String f8201p;
    @SerializedName("place")

    /* renamed from: q */
    public final C3114l f8202q;
    @SerializedName("possibly_sensitive")

    /* renamed from: r */
    public final boolean f8203r;
    @SerializedName("scopes")

    /* renamed from: s */
    public final Object f8204s;
    @SerializedName("quoted_status_id")

    /* renamed from: t */
    public final long f8205t;
    @SerializedName("quoted_status_id_str")

    /* renamed from: u */
    public final String f8206u;
    @SerializedName("quoted_status")

    /* renamed from: v */
    public final C3119o f8207v;
    @SerializedName("retweet_count")

    /* renamed from: w */
    public final int f8208w;
    @SerializedName("retweeted")

    /* renamed from: x */
    public final boolean f8209x;
    @SerializedName("retweeted_status")

    /* renamed from: y */
    public final C3119o f8210y;
    @SerializedName("source")

    /* renamed from: z */
    public final String f8211z;

    private C3119o() {
        this(null, null, null, C3121q.f8246a, C3121q.f8246a, Integer.valueOf(0), false, null, 0, "0", null, 0, "0", 0, "0", null, null, false, null, 0, "0", null, 0, false, null, null, null, null, false, null, false, null, null, null);
    }

    public C3119o(C3108f fVar, String str, Object obj, C3121q qVar, C3121q qVar2, Integer num, boolean z, String str2, long j, String str3, String str4, long j2, String str5, long j3, String str6, String str7, C3114l lVar, boolean z2, Object obj2, long j4, String str8, C3119o oVar, int i, boolean z3, C3119o oVar2, String str9, String str10, List<Integer> list, boolean z4, C3123s sVar, boolean z5, List<String> list2, String str11, C3107e eVar) {
        this.f8186a = fVar;
        this.f8187b = str;
        this.f8188c = obj;
        this.f8189d = qVar == null ? C3121q.f8246a : qVar;
        this.f8190e = qVar2 == null ? C3121q.f8246a : qVar2;
        this.f8191f = num;
        this.f8192g = z;
        this.f8193h = str2;
        this.f8194i = j;
        this.f8195j = str3;
        this.f8196k = str4;
        this.f8197l = j2;
        this.f8198m = str5;
        this.f8199n = j3;
        this.f8200o = str6;
        this.f8201p = str7;
        this.f8202q = lVar;
        this.f8203r = z2;
        this.f8204s = obj2;
        this.f8205t = j4;
        this.f8206u = str8;
        this.f8207v = oVar;
        this.f8208w = i;
        this.f8209x = z3;
        this.f8210y = oVar2;
        this.f8211z = str9;
        this.f8178A = str10;
        this.f8179B = C3113k.m9131a(list);
        this.f8180C = z4;
        this.f8181D = sVar;
        this.f8182E = z5;
        this.f8183F = C3113k.m9131a(list2);
        this.f8184G = str11;
        this.f8185H = eVar;
    }

    /* renamed from: a */
    public long mo27595a() {
        return this.f8194i;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null || !(obj instanceof C3119o)) {
            return false;
        }
        if (this.f8194i == ((C3119o) obj).f8194i) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (int) this.f8194i;
    }
}
