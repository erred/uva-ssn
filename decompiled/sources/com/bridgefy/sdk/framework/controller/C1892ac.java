package com.bridgefy.sdk.framework.controller;

import java.util.ArrayList;

/* renamed from: com.bridgefy.sdk.framework.controller.ac */
class C1892ac {

    /* renamed from: a */
    final ArrayList<gatt_operation> f5887a = new ArrayList<>();

    /* renamed from: b */
    chunk_generator f5888b;

    C1892ac(chunk_generator alVar) {
        this.f5888b = alVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7434a(gatt_operation abVar) {
        this.f5887a.add(abVar);
        abVar.mo7424a(this);
    }

    /* renamed from: a */
    public ArrayList<gatt_operation> mo7433a() {
        return this.f5887a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public chunk_generator mo7435b() {
        return this.f5888b;
    }
}
