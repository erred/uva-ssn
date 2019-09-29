package com.bridgefy.sdk.framework.controller;

import java.util.concurrent.TimeUnit;
import org.p153a.C3682b;
import p000a.p013b.C0330h;
import p000a.p013b.p019d.C0181e;

/* renamed from: com.bridgefy.sdk.framework.controller.ai */
class C1898ai implements C0181e<C0330h<? extends Throwable>, C0330h<?>> {

    /* renamed from: a */
    private final int f5900a;

    /* renamed from: b */
    private final int f5901b;

    /* renamed from: c */
    private int f5902c = 0;

    C1898ai(int i, int i2) {
        this.f5900a = i;
        this.f5901b = i2;
    }

    /* renamed from: a */
    public C0330h<?> apply(C0330h<? extends Throwable> hVar) throws Exception {
        return hVar.mo535a((C0181e<? super T, ? extends C3682b<? extends R>>) new C0181e() {
            public final Object apply(Object obj) {
                return C1898ai.this.m7832a((Throwable) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ C0330h m7832a(Throwable th) throws Exception {
        int i = this.f5902c + 1;
        this.f5902c = i;
        if (i < this.f5900a) {
            return C0330h.m912a((long) this.f5901b, TimeUnit.MILLISECONDS);
        }
        return C0330h.m915a(th);
    }
}
