package com.twitter.sdk.android.core.internal.oauth;

import com.google.common.net.HttpHeaders;
import com.twitter.sdk.android.core.C3270v;
import com.twitter.sdk.android.core.internal.C3188n;
import com.twitter.sdk.android.core.internal.p133a.C3160e;
import java.io.IOException;
import p091b.C1596ac;
import p091b.C1645u;
import p091b.C1645u.C1646a;
import p091b.C1651x.C1653a;
import p136d.C3407e.C3408a;
import p136d.C3446m;
import p136d.C3446m.C3448a;
import p136d.p137a.p138a.C3377a;

/* renamed from: com.twitter.sdk.android.core.internal.oauth.g */
/* compiled from: OAuthService */
abstract class C3202g {

    /* renamed from: a */
    private final C3270v f8382a;

    /* renamed from: b */
    private final C3188n f8383b;

    /* renamed from: c */
    private final String f8384c;

    /* renamed from: d */
    private final C3446m f8385d = new C3448a().mo28290a(mo27755d().mo27712a()).mo28288a(new C1653a().mo6734a((C1645u) new C1645u() {
        /* renamed from: a */
        public C1596ac mo6184a(C1646a aVar) throws IOException {
            return aVar.mo6280a(aVar.mo6279a().mo6460e().mo6470a(HttpHeaders.USER_AGENT, C3202g.this.mo27756e()).mo6471a());
        }
    }).mo6733a(C3160e.m9255a()).mo6735a()).mo28289a((C3408a) C3377a.m9854a()).mo28291a();

    C3202g(C3270v vVar, C3188n nVar) {
        this.f8382a = vVar;
        this.f8383b = nVar;
        this.f8384c = C3188n.m9331a("TwitterAndroidSDK", vVar.mo27913b());
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C3270v mo27754c() {
        return this.f8382a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C3188n mo27755d() {
        return this.f8383b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo27756e() {
        return this.f8384c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public C3446m mo27757f() {
        return this.f8385d;
    }
}
