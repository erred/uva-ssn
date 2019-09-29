package p000a.p013b.p020e.p025e.p030e;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0176d;
import p000a.p013b.C0323f;
import p000a.p013b.C0353r;
import p000a.p013b.C0355t;
import p000a.p013b.C0357v;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p021a.C0186b;
import p000a.p013b.p020e.p024d.C0215c;

/* renamed from: a.b.e.e.e.b */
/* compiled from: SingleDelayWithCompletable */
public final class C0269b<T> extends C0353r<T> {

    /* renamed from: a */
    final C0357v<T> f534a;

    /* renamed from: b */
    final C0323f f535b;

    /* renamed from: a.b.e.e.e.b$a */
    /* compiled from: SingleDelayWithCompletable */
    static final class C0270a<T> extends AtomicReference<C0161b> implements C0161b, C0176d {

        /* renamed from: a */
        final C0355t<? super T> f536a;

        /* renamed from: b */
        final C0357v<T> f537b;

        C0270a(C0355t<? super T> tVar, C0357v<T> vVar) {
            this.f536a = tVar;
            this.f537b = vVar;
        }

        public void onSubscribe(C0161b bVar) {
            if (C0186b.m593a((AtomicReference<C0161b>) this, bVar)) {
                this.f536a.onSubscribe(this);
            }
        }

        public void onError(Throwable th) {
            this.f536a.onError(th);
        }

        public void onComplete() {
            this.f537b.mo563a(new C0215c(this, this.f536a));
        }

        public void dispose() {
            C0186b.m592a((AtomicReference<C0161b>) this);
        }
    }

    public C0269b(C0357v<T> vVar, C0323f fVar) {
        this.f534a = vVar;
        this.f535b = fVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo462b(C0355t<? super T> tVar) {
        this.f535b.mo345a(new C0270a(tVar, this.f534a));
    }
}
