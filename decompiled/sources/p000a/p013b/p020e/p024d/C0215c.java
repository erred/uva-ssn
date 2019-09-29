package p000a.p013b.p020e.p024d;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0355t;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p021a.C0186b;

/* renamed from: a.b.e.d.c */
/* compiled from: ResumeSingleObserver */
public final class C0215c<T> implements C0355t<T> {

    /* renamed from: a */
    final AtomicReference<C0161b> f411a;

    /* renamed from: b */
    final C0355t<? super T> f412b;

    public C0215c(AtomicReference<C0161b> atomicReference, C0355t<? super T> tVar) {
        this.f411a = atomicReference;
        this.f412b = tVar;
    }

    public void onSubscribe(C0161b bVar) {
        C0186b.m594b(this.f411a, bVar);
    }

    public void onSuccess(T t) {
        this.f412b.onSuccess(t);
    }

    public void onError(Throwable th) {
        this.f412b.onError(th);
    }
}
