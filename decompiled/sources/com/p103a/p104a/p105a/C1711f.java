package com.p103a.p104a.p105a;

import java.io.File;
import java.util.List;
import p000a.p001a.p002a.p003a.p004a.p007c.p008a.C0056b;
import p000a.p001a.p002a.p003a.p004a.p007c.p008a.C0057c;
import p000a.p001a.p002a.p003a.p004a.p007c.p008a.C0059e;
import p000a.p001a.p002a.p003a.p004a.p009d.C0082f;

/* renamed from: com.a.a.a.f */
/* compiled from: AnswersRetryFilesSender */
class C1711f implements C0082f {

    /* renamed from: a */
    private final C1724p f5366a;

    /* renamed from: b */
    private final C1720m f5367b;

    /* renamed from: a */
    public static C1711f m7179a(C1724p pVar) {
        return new C1711f(pVar, new C1720m(new C0059e(new C1719l(new C0057c(1000, 8), 0.1d), new C0056b(5))));
    }

    C1711f(C1724p pVar, C1720m mVar) {
        this.f5366a = pVar;
        this.f5367b = mVar;
    }

    /* renamed from: a */
    public boolean mo180a(List<File> list) {
        long nanoTime = System.nanoTime();
        if (!this.f5367b.mo6978a(nanoTime)) {
            return false;
        }
        if (this.f5366a.mo180a(list)) {
            this.f5367b.mo6977a();
            return true;
        }
        this.f5367b.mo6979b(nanoTime);
        return false;
    }
}
