package com.twitter.sdk.android.core.internal.p133a;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.common.net.HttpHeaders;
import com.twitter.sdk.android.core.C3130e;
import com.twitter.sdk.android.core.C3132f;
import com.twitter.sdk.android.core.internal.oauth.C3194a;
import java.io.IOException;
import p091b.C1590aa;
import p091b.C1590aa.C1591a;
import p091b.C1596ac;
import p091b.C1645u;
import p091b.C1645u.C1646a;

/* renamed from: com.twitter.sdk.android.core.internal.a.a */
/* compiled from: GuestAuthInterceptor */
public class C3156a implements C1645u {

    /* renamed from: a */
    final C3132f f8308a;

    public C3156a(C3132f fVar) {
        this.f8308a = fVar;
    }

    /* renamed from: a */
    public C1596ac mo6184a(C1646a aVar) throws IOException {
        C3194a aVar2;
        C1590aa a = aVar.mo6279a();
        C3130e a2 = this.f8308a.mo27618a();
        if (a2 == null) {
            aVar2 = null;
        } else {
            aVar2 = (C3194a) a2.mo27849a();
        }
        if (aVar2 == null) {
            return aVar.mo6280a(a);
        }
        C1591a e = a.mo6460e();
        m9243a(e, aVar2);
        return aVar.mo6280a(e.mo6471a());
    }

    /* renamed from: a */
    static void m9243a(C1591a aVar, C3194a aVar2) {
        StringBuilder sb = new StringBuilder();
        sb.append(aVar2.mo27739c());
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(aVar2.mo27740d());
        aVar.mo6470a(HttpHeaders.AUTHORIZATION, sb.toString());
        aVar.mo6470a("x-guest-token", aVar2.mo27729a());
    }
}
