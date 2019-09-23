package p000a.p013b.p020e.p021a;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.p017b.C0161b;

/* renamed from: a.b.e.a.e */
/* compiled from: SequentialDisposable */
public final class C0189e extends AtomicReference<C0161b> implements C0161b {
    /* renamed from: a */
    public boolean mo389a(C0161b bVar) {
        return C0186b.m594b(this, bVar);
    }

    public void dispose() {
        C0186b.m592a((AtomicReference<C0161b>) this);
    }

    /* renamed from: a */
    public boolean mo388a() {
        return C0186b.m590a((C0161b) get());
    }
}
