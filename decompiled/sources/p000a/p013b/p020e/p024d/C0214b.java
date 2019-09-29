package p000a.p013b.p020e.p024d;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0176d;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p018c.C0173d;
import p000a.p013b.p019d.C0177a;
import p000a.p013b.p019d.C0180d;
import p000a.p013b.p020e.p021a.C0186b;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.e.d.b */
/* compiled from: CallbackCompletableObserver */
public final class C0214b extends AtomicReference<C0161b> implements C0161b, C0176d, C0180d<Throwable> {

    /* renamed from: a */
    final C0180d<? super Throwable> f409a;

    /* renamed from: b */
    final C0177a f410b;

    public C0214b(C0177a aVar) {
        this.f409a = this;
        this.f410b = aVar;
    }

    public C0214b(C0180d<? super Throwable> dVar, C0177a aVar) {
        this.f409a = dVar;
        this.f410b = aVar;
    }

    /* renamed from: a */
    public void accept(Throwable th) {
        C0324a.m885a((Throwable) new C0173d(th));
    }

    public void onComplete() {
        try {
            this.f410b.run();
        } catch (Throwable th) {
            C0171b.m584b(th);
            C0324a.m885a(th);
        }
        lazySet(C0186b.DISPOSED);
    }

    public void onError(Throwable th) {
        try {
            this.f409a.accept(th);
        } catch (Throwable th2) {
            C0171b.m584b(th2);
            C0324a.m885a(th2);
        }
        lazySet(C0186b.DISPOSED);
    }

    public void onSubscribe(C0161b bVar) {
        C0186b.m593a((AtomicReference<C0161b>) this, bVar);
    }

    public void dispose() {
        C0186b.m592a((AtomicReference<C0161b>) this);
    }
}
