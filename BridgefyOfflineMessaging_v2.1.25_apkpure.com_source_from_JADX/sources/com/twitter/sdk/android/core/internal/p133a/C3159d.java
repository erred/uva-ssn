package com.twitter.sdk.android.core.internal.p133a;

import com.google.api.client.http.HttpMethods;
import com.google.common.net.HttpHeaders;
import com.twitter.sdk.android.core.C3254k;
import com.twitter.sdk.android.core.C3259p;
import com.twitter.sdk.android.core.C3262s;
import com.twitter.sdk.android.core.internal.oauth.C3196c;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p091b.C1590aa;
import p091b.C1592ab;
import p091b.C1596ac;
import p091b.C1637q;
import p091b.C1642t;
import p091b.C1642t.C1643a;
import p091b.C1645u;
import p091b.C1645u.C1646a;

/* renamed from: com.twitter.sdk.android.core.internal.a.d */
/* compiled from: OAuth1aInterceptor */
public class C3159d implements C1645u {

    /* renamed from: a */
    final C3254k<? extends C3262s> f8310a;

    /* renamed from: b */
    final C3259p f8311b;

    public C3159d(C3254k<? extends C3262s> kVar, C3259p pVar) {
        this.f8310a = kVar;
        this.f8311b = pVar;
    }

    /* renamed from: a */
    public C1596ac mo6184a(C1646a aVar) throws IOException {
        C1590aa a = aVar.mo6279a();
        C1590aa a2 = a.mo6460e().mo6467a(mo27678a(a.mo6454a())).mo6471a();
        return aVar.mo6280a(a2.mo6460e().mo6470a(HttpHeaders.AUTHORIZATION, mo27679a(a2)).mo6471a());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1642t mo27678a(C1642t tVar) {
        C1643a e = tVar.mo6680p().mo6693e(null);
        int m = tVar.mo6677m();
        for (int i = 0; i < m; i++) {
            e.mo6689b(C3161f.m9264c(tVar.mo6659a(i)), C3161f.m9264c(tVar.mo6662b(i)));
        }
        return e.mo6691c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo27679a(C1590aa aaVar) throws IOException {
        return new C3196c().mo27733a(this.f8311b, (C3262s) this.f8310a.mo27849a(), null, aaVar.mo6456b(), aaVar.mo6454a().toString(), mo27680b(aaVar));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Map<String, String> mo27680b(C1590aa aaVar) throws IOException {
        HashMap hashMap = new HashMap();
        if (HttpMethods.POST.equals(aaVar.mo6456b().toUpperCase(Locale.US))) {
            C1592ab d = aaVar.mo6459d();
            if (d instanceof C1637q) {
                C1637q qVar = (C1637q) d;
                for (int i = 0; i < qVar.mo6630a(); i++) {
                    hashMap.put(qVar.mo6631a(i), qVar.mo6633c(i));
                }
            }
        }
        return hashMap;
    }
}
