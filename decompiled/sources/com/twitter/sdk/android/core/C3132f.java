package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.internal.oauth.C3194a;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.twitter.sdk.android.core.f */
/* compiled from: GuestSessionProvider */
public class C3132f {

    /* renamed from: a */
    private final OAuth2Service f8265a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C3255l<C3130e> f8266b;

    public C3132f(OAuth2Service oAuth2Service, C3255l<C3130e> lVar) {
        this.f8265a = oAuth2Service;
        this.f8266b = lVar;
    }

    /* renamed from: a */
    public synchronized C3130e mo27618a() {
        C3130e eVar = (C3130e) this.f8266b.mo27626b();
        if (mo27621b(eVar)) {
            return eVar;
        }
        mo27620b();
        return (C3130e) this.f8266b.mo27626b();
    }

    /* renamed from: a */
    public synchronized C3130e mo27619a(C3130e eVar) {
        C3130e eVar2 = (C3130e) this.f8266b.mo27626b();
        if (eVar != null && eVar.equals(eVar2)) {
            mo27620b();
        }
        return (C3130e) this.f8266b.mo27626b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo27620b() {
        C3256m.m9537g().mo27607a("GuestSessionProvider", "Refreshing expired guest session.");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f8265a.mo27724a((C3128c<C3194a>) new C3128c<C3194a>() {
            /* renamed from: a */
            public void mo11811a(C3253j<C3194a> jVar) {
                C3132f.this.f8266b.mo27624a(new C3130e((C3194a) jVar.f8523a));
                countDownLatch.countDown();
            }

            /* renamed from: a */
            public void mo11812a(C3272w wVar) {
                C3132f.this.f8266b.mo27629c(0);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            this.f8266b.mo27629c(0);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo27621b(C3130e eVar) {
        return (eVar == null || eVar.mo27849a() == null || ((C3194a) eVar.mo27849a()).mo27730b()) ? false : true;
    }
}
