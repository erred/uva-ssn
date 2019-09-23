package com.twitter.sdk.android.core.internal.p133a;

import com.google.common.net.HttpHeaders;
import com.twitter.sdk.android.core.C3130e;
import com.twitter.sdk.android.core.C3132f;
import com.twitter.sdk.android.core.internal.oauth.C3194a;
import java.io.IOException;
import p091b.C1590aa;
import p091b.C1590aa.C1591a;
import p091b.C1596ac;
import p091b.C1601ae;
import p091b.C1603b;
import p091b.C1640s;

/* renamed from: com.twitter.sdk.android.core.internal.a.c */
/* compiled from: GuestAuthenticator */
public class C3158c implements C1603b {

    /* renamed from: a */
    final C3132f f8309a;

    public C3158c(C3132f fVar) {
        this.f8309a = fVar;
    }

    /* renamed from: a */
    public C1590aa mo6524a(C1601ae aeVar, C1596ac acVar) throws IOException {
        return mo27675a(acVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1590aa mo27675a(C1596ac acVar) {
        C3194a aVar;
        if (mo27677c(acVar)) {
            C3130e a = this.f8309a.mo27619a(mo27676b(acVar));
            if (a == null) {
                aVar = null;
            } else {
                aVar = (C3194a) a.mo27849a();
            }
            if (aVar != null) {
                return mo27674a(acVar.mo6477a(), aVar);
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C3130e mo27676b(C1596ac acVar) {
        C1640s c = acVar.mo6477a().mo6458c();
        String a = c.mo6645a(HttpHeaders.AUTHORIZATION);
        String a2 = c.mo6645a("x-guest-token");
        if (a == null || a2 == null) {
            return null;
        }
        return new C3130e(new C3194a("bearer", a.replace("bearer ", ""), a2));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1590aa mo27674a(C1590aa aaVar, C3194a aVar) {
        C1591a e = aaVar.mo6460e();
        C3156a.m9243a(e, aVar);
        return e.mo6471a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo27677c(C1596ac acVar) {
        int i = 1;
        while (true) {
            acVar = acVar.mo6491l();
            if (acVar == null) {
                break;
            }
            i++;
        }
        return i < 2;
    }
}
