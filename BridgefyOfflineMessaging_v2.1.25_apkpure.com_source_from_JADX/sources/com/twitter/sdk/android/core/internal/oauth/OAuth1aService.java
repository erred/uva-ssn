package com.twitter.sdk.android.core.internal.oauth;

import android.net.Uri;
import com.google.api.client.http.HttpMethods;
import com.twitter.sdk.android.core.C3128c;
import com.twitter.sdk.android.core.C3259p;
import com.twitter.sdk.android.core.C3262s;
import com.twitter.sdk.android.core.C3270v;
import com.twitter.sdk.android.core.C3272w;
import com.twitter.sdk.android.core.internal.C3188n;
import com.twitter.sdk.android.core.internal.p133a.C3161f;
import java.util.TreeMap;
import p091b.C1598ad;
import p136d.C3380b;
import p136d.p139b.C3389i;
import p136d.p139b.C3395o;
import p136d.p139b.C3400t;

public class OAuth1aService extends C3202g {

    /* renamed from: a */
    OAuthApi f8360a = ((OAuthApi) mo27757f().mo28281a(OAuthApi.class));

    interface OAuthApi {
        @C3395o(mo28223a = "/oauth/access_token")
        C3380b<C1598ad> getAccessToken(@C3389i(mo28219a = "Authorization") String str, @C3400t(mo28230a = "oauth_verifier") String str2);

        @C3395o(mo28223a = "/oauth/request_token")
        C3380b<C1598ad> getTempToken(@C3389i(mo28219a = "Authorization") String str);
    }

    public OAuth1aService(C3270v vVar, C3188n nVar) {
        super(vVar, nVar);
    }

    /* renamed from: a */
    public void mo27718a(C3128c<C3200f> cVar) {
        C3259p c = mo27754c().mo27914c();
        this.f8360a.getTempToken(new C3196c().mo27733a(c, null, mo27716a(c), HttpMethods.POST, mo27715a(), null)).mo28207a(mo27720b(cVar));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo27715a() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo27755d().mo27712a());
        sb.append("/oauth/request_token");
        return sb.toString();
    }

    /* renamed from: a */
    public String mo27716a(C3259p pVar) {
        return Uri.parse("twittersdk://callback").buildUpon().appendQueryParameter("version", mo27754c().mo27913b()).appendQueryParameter("app", pVar.mo27864a()).build().toString();
    }

    /* renamed from: a */
    public void mo27719a(C3128c<C3200f> cVar, C3262s sVar, String str) {
        C3262s sVar2 = sVar;
        this.f8360a.getAccessToken(new C3196c().mo27733a(mo27754c().mo27914c(), sVar2, null, HttpMethods.POST, mo27721b(), null), str).mo28207a(mo27720b(cVar));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo27721b() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo27755d().mo27712a());
        sb.append("/oauth/access_token");
        return sb.toString();
    }

    /* renamed from: a */
    public String mo27717a(C3262s sVar) {
        return mo27755d().mo27711a("oauth", "authorize").appendQueryParameter("oauth_token", sVar.f8544b).build().toString();
    }

    /* renamed from: a */
    public static C3200f m9339a(String str) {
        TreeMap a = C3161f.m9261a(str, false);
        String str2 = (String) a.get("oauth_token");
        String str3 = (String) a.get("oauth_token_secret");
        String str4 = (String) a.get("screen_name");
        long parseLong = a.containsKey("user_id") ? Long.parseLong((String) a.get("user_id")) : 0;
        if (str2 == null || str3 == null) {
            return null;
        }
        return new C3200f(new C3262s(str2, str3), str4, parseLong);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C3128c<C1598ad> mo27720b(final C3128c<C3200f> cVar) {
        return new C3128c<C1598ad>() {
            /* JADX WARNING: Removed duplicated region for block: B:16:0x005c A[Catch:{ IOException -> 0x0060 }] */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo11811a(com.twitter.sdk.android.core.C3253j<p091b.C1598ad> r5) {
                /*
                    r4 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    r1 = 0
                    java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0059 }
                    java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0059 }
                    T r5 = r5.f8523a     // Catch:{ all -> 0x0059 }
                    b.ad r5 = (p091b.C1598ad) r5     // Catch:{ all -> 0x0059 }
                    java.io.InputStream r5 = r5.mo6511d()     // Catch:{ all -> 0x0059 }
                    r3.<init>(r5)     // Catch:{ all -> 0x0059 }
                    r2.<init>(r3)     // Catch:{ all -> 0x0059 }
                L_0x0018:
                    java.lang.String r5 = r2.readLine()     // Catch:{ all -> 0x0056 }
                    if (r5 == 0) goto L_0x0022
                    r0.append(r5)     // Catch:{ all -> 0x0056 }
                    goto L_0x0018
                L_0x0022:
                    r2.close()     // Catch:{ IOException -> 0x0060 }
                    java.lang.String r5 = r0.toString()     // Catch:{ IOException -> 0x0060 }
                    com.twitter.sdk.android.core.internal.oauth.f r0 = com.twitter.sdk.android.core.internal.oauth.OAuth1aService.m9339a(r5)     // Catch:{ IOException -> 0x0060 }
                    if (r0 != 0) goto L_0x004b
                    com.twitter.sdk.android.core.c r0 = r2     // Catch:{ IOException -> 0x0060 }
                    com.twitter.sdk.android.core.q r1 = new com.twitter.sdk.android.core.q     // Catch:{ IOException -> 0x0060 }
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0060 }
                    r2.<init>()     // Catch:{ IOException -> 0x0060 }
                    java.lang.String r3 = "Failed to parse auth response: "
                    r2.append(r3)     // Catch:{ IOException -> 0x0060 }
                    r2.append(r5)     // Catch:{ IOException -> 0x0060 }
                    java.lang.String r5 = r2.toString()     // Catch:{ IOException -> 0x0060 }
                    r1.<init>(r5)     // Catch:{ IOException -> 0x0060 }
                    r0.mo11812a(r1)     // Catch:{ IOException -> 0x0060 }
                    goto L_0x0071
                L_0x004b:
                    com.twitter.sdk.android.core.c r5 = r2     // Catch:{ IOException -> 0x0060 }
                    com.twitter.sdk.android.core.j r2 = new com.twitter.sdk.android.core.j     // Catch:{ IOException -> 0x0060 }
                    r2.<init>(r0, r1)     // Catch:{ IOException -> 0x0060 }
                    r5.mo11811a(r2)     // Catch:{ IOException -> 0x0060 }
                    goto L_0x0071
                L_0x0056:
                    r5 = move-exception
                    r1 = r2
                    goto L_0x005a
                L_0x0059:
                    r5 = move-exception
                L_0x005a:
                    if (r1 == 0) goto L_0x0062
                    r1.close()     // Catch:{ IOException -> 0x0060 }
                    goto L_0x0062
                L_0x0060:
                    r5 = move-exception
                    goto L_0x0063
                L_0x0062:
                    throw r5     // Catch:{ IOException -> 0x0060 }
                L_0x0063:
                    com.twitter.sdk.android.core.c r0 = r2
                    com.twitter.sdk.android.core.q r1 = new com.twitter.sdk.android.core.q
                    java.lang.String r2 = r5.getMessage()
                    r1.<init>(r2, r5)
                    r0.mo11812a(r1)
                L_0x0071:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.oauth.OAuth1aService.C31911.mo11811a(com.twitter.sdk.android.core.j):void");
            }

            /* renamed from: a */
            public void mo11812a(C3272w wVar) {
                cVar.mo11812a(wVar);
            }
        };
    }
}
