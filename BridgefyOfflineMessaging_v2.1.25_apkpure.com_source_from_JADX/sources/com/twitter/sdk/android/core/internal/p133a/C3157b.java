package com.twitter.sdk.android.core.internal.p133a;

import java.io.IOException;
import p091b.C1596ac;
import p091b.C1645u;
import p091b.C1645u.C1646a;

/* renamed from: com.twitter.sdk.android.core.internal.a.b */
/* compiled from: GuestAuthNetworkInterceptor */
public class C3157b implements C1645u {
    /* renamed from: a */
    public C1596ac mo6184a(C1646a aVar) throws IOException {
        C1596ac a = aVar.mo6280a(aVar.mo6279a());
        return a.mo6481c() == 403 ? a.mo6488i().mo6496a(401).mo6506a() : a;
    }
}
