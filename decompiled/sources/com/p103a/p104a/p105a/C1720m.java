package com.p103a.p104a.p105a;

import p000a.p001a.p002a.p003a.p004a.p007c.p008a.C0059e;

/* renamed from: com.a.a.a.m */
/* compiled from: RetryManager */
class C1720m {

    /* renamed from: a */
    long f5390a;

    /* renamed from: b */
    private C0059e f5391b;

    public C1720m(C0059e eVar) {
        if (eVar != null) {
            this.f5391b = eVar;
            return;
        }
        throw new NullPointerException("retryState must not be null");
    }

    /* renamed from: a */
    public boolean mo6978a(long j) {
        return j - this.f5390a >= this.f5391b.mo102a() * 1000000;
    }

    /* renamed from: b */
    public void mo6979b(long j) {
        this.f5390a = j;
        this.f5391b = this.f5391b.mo103b();
    }

    /* renamed from: a */
    public void mo6977a() {
        this.f5390a = 0;
        this.f5391b = this.f5391b.mo104c();
    }
}
