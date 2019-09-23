package com.bridgefy.sdk.framework.controller;

import java.util.ArrayList;

/* renamed from: com.bridgefy.sdk.framework.controller.ac */
class C1892ac {

    /* renamed from: a */
    final ArrayList<C1891ab> f5887a = new ArrayList<>();

    /* renamed from: b */
    C1902al f5888b;

    C1892ac(C1902al alVar) {
        this.f5888b = alVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7434a(C1891ab abVar) {
        this.f5887a.add(abVar);
        abVar.mo7424a(this);
    }

    /* renamed from: a */
    public ArrayList<C1891ab> mo7433a() {
        return this.f5887a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C1902al mo7435b() {
        return this.f5888b;
    }
}
