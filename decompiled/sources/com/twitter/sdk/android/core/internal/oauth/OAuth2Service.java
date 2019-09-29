package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.C3128c;
import com.twitter.sdk.android.core.C3253j;
import com.twitter.sdk.android.core.C3256m;
import com.twitter.sdk.android.core.C3259p;
import com.twitter.sdk.android.core.C3270v;
import com.twitter.sdk.android.core.C3272w;
import com.twitter.sdk.android.core.internal.C3188n;
import com.twitter.sdk.android.core.internal.p133a.C3161f;
import p102c.C1677f;
import p136d.C3380b;
import p136d.p139b.C3383c;
import p136d.p139b.C3385e;
import p136d.p139b.C3389i;
import p136d.p139b.C3391k;
import p136d.p139b.C3395o;

public class OAuth2Service extends C3202g {

    /* renamed from: a */
    OAuth2Api f8363a = ((OAuth2Api) mo27757f().mo28281a(OAuth2Api.class));

    interface OAuth2Api {
        @C3385e
        @C3391k(mo28220a = {"Content-Type: application/x-www-form-urlencoded;charset=UTF-8"})
        @C3395o(mo28223a = "/oauth2/token")
        C3380b<C3198e> getAppAuthToken(@C3389i(mo28219a = "Authorization") String str, @C3383c(mo28211a = "grant_type") String str2);

        @C3395o(mo28223a = "/1.1/guest/activate.json")
        C3380b<C3195b> getGuestToken(@C3389i(mo28219a = "Authorization") String str);
    }

    public OAuth2Service(C3270v vVar, C3188n nVar) {
        super(vVar, nVar);
    }

    /* renamed from: a */
    public void mo27724a(final C3128c<C3194a> cVar) {
        mo27726b(new C3128c<C3198e>() {
            /* renamed from: a */
            public void mo11811a(C3253j<C3198e> jVar) {
                final C3198e eVar = (C3198e) jVar.f8523a;
                OAuth2Service.this.mo27725a(new C3128c<C3195b>() {
                    /* renamed from: a */
                    public void mo11811a(C3253j<C3195b> jVar) {
                        cVar.mo11811a(new C3253j<>(new C3194a(eVar.mo27739c(), eVar.mo27740d(), ((C3195b) jVar.f8523a).f8369a), null));
                    }

                    /* renamed from: a */
                    public void mo11812a(C3272w wVar) {
                        C3256m.m9537g().mo27613c("Twitter", "Your app may not allow guest auth. Please talk to us regarding upgrading your consumer key.", wVar);
                        cVar.mo11812a(wVar);
                    }
                }, eVar);
            }

            /* renamed from: a */
            public void mo11812a(C3272w wVar) {
                C3256m.m9537g().mo27613c("Twitter", "Failed to get app auth token", wVar);
                if (cVar != null) {
                    cVar.mo11812a(wVar);
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo27726b(C3128c<C3198e> cVar) {
        this.f8363a.getAppAuthToken(m9349a(), "client_credentials").mo28207a(cVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27725a(C3128c<C3195b> cVar, C3198e eVar) {
        this.f8363a.getGuestToken(m9350a(eVar)).mo28207a(cVar);
    }

    /* renamed from: a */
    private String m9350a(C3198e eVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        sb.append(eVar.mo27740d());
        return sb.toString();
    }

    /* renamed from: a */
    private String m9349a() {
        C3259p c = mo27754c().mo27914c();
        StringBuilder sb = new StringBuilder();
        sb.append(C3161f.m9264c(c.mo27864a()));
        sb.append(":");
        sb.append(C3161f.m9264c(c.mo27865b()));
        C1677f a = C1677f.m6985a(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Basic ");
        sb2.append(a.mo6894b());
        return sb2.toString();
    }
}
