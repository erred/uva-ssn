package com.twitter.sdk.android.core.internal.p133a;

import com.twitter.sdk.android.core.C3132f;
import com.twitter.sdk.android.core.C3254k;
import com.twitter.sdk.android.core.C3259p;
import com.twitter.sdk.android.core.C3262s;
import p091b.C1603b;
import p091b.C1617g;
import p091b.C1617g.C1618a;
import p091b.C1645u;
import p091b.C1651x;
import p091b.C1651x.C1653a;

/* renamed from: com.twitter.sdk.android.core.internal.a.e */
/* compiled from: OkHttpClientHelper */
public class C3160e {
    /* renamed from: a */
    public static C1651x m9258a(C3132f fVar) {
        return m9256a(new C1653a(), fVar).mo6735a();
    }

    /* renamed from: a */
    public static C1651x m9259a(C3254k<? extends C3262s> kVar, C3259p pVar) {
        if (kVar != null) {
            return m9257a(new C1653a(), kVar, pVar).mo6735a();
        }
        throw new IllegalArgumentException("Session must not be null.");
    }

    /* renamed from: a */
    static C1653a m9256a(C1653a aVar, C3132f fVar) {
        return aVar.mo6733a(m9255a()).mo6731a((C1603b) new C3158c(fVar)).mo6734a((C1645u) new C3156a(fVar)).mo6736b(new C3157b());
    }

    /* renamed from: a */
    static C1653a m9257a(C1653a aVar, C3254k<? extends C3262s> kVar, C3259p pVar) {
        return aVar.mo6733a(m9255a()).mo6734a((C1645u) new C3159d(kVar, pVar));
    }

    /* renamed from: a */
    public static C1617g m9255a() {
        return new C1618a().mo6563a("*.twitter.com", "sha1/I0PRSKJViZuUfUYaeX7ATP7RcLc=").mo6563a("*.twitter.com", "sha1/VRmyeKyygdftp6vBg5nDu2kEJLU=").mo6563a("*.twitter.com", "sha1/Eje6RRfurSkm/cHN/r7t8t7ZFFw=").mo6563a("*.twitter.com", "sha1/Wr7Fddyu87COJxlD/H8lDD32YeM=").mo6563a("*.twitter.com", "sha1/GiG0lStik84Ys2XsnA6TTLOB5tQ=").mo6563a("*.twitter.com", "sha1/IvGeLsbqzPxdI0b0wuj2xVTdXgc=").mo6563a("*.twitter.com", "sha1/7WYxNdMb1OymFMQp4xkGn5TBJlA=").mo6563a("*.twitter.com", "sha1/sYEIGhmkwJQf+uiVKMEkyZs0rMc=").mo6563a("*.twitter.com", "sha1/PANDaGiVHPNpKri0Jtq6j+ki5b0=").mo6563a("*.twitter.com", "sha1/u8I+KQuzKHcdrT6iTb30I70GsD0=").mo6563a("*.twitter.com", "sha1/wHqYaI2J+6sFZAwRfap9ZbjKzE4=").mo6563a("*.twitter.com", "sha1/cTg28gIxU0crbrplRqkQFVggBQk=").mo6563a("*.twitter.com", "sha1/sBmJ5+/7Sq/LFI9YRjl2IkFQ4bo=").mo6563a("*.twitter.com", "sha1/vb6nG6txV/nkddlU0rcngBqCJoI=").mo6563a("*.twitter.com", "sha1/nKmNAK90Dd2BgNITRaWLjy6UONY=").mo6563a("*.twitter.com", "sha1/h+hbY1PGI6MSjLD/u/VR/lmADiI=").mo6563a("*.twitter.com", "sha1/Xk9ThoXdT57KX9wNRW99UbHcm3s=").mo6563a("*.twitter.com", "sha1/1S4TwavjSdrotJWU73w4Q2BkZr0=").mo6563a("*.twitter.com", "sha1/gzF+YoVCU9bXeDGQ7JGQVumRueM=").mo6563a("*.twitter.com", "sha1/aDMOYTWFIVkpg6PI0tLhQG56s8E=").mo6563a("*.twitter.com", "sha1/Vv7zwhR9TtOIN/29MFI4cgHld40=").mo6564a();
    }
}
