package com.bridgefy.sdk.framework.controller;

import java.util.ArrayList;

/* renamed from: com.bridgefy.sdk.framework.controller.ac */
class chunk_generator_with_queue {

    /* renamed from: a */
    final ArrayList<gatt_operation> f5887a = new ArrayList<>();

    /* renamed from: b */
    chunk_generator chunk_generator;

    chunk_generator_with_queue(chunk_generator alVar) {
        this.chunk_generator = alVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7434a(gatt_operation abVar) {
        this.f5887a.add(abVar);
        abVar.set_chunk_generator_with_queue(this);
    }

    /* renamed from: a */
    public ArrayList<gatt_operation> mo7433a() {
        return this.f5887a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public chunk_generator get_chunk_generator() {
        return this.chunk_generator;
    }
}
