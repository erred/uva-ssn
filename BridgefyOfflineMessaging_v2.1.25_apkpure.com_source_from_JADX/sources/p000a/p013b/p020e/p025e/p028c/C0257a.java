package p000a.p013b.p020e.p025e.p028c;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0176d;
import p000a.p013b.C0323f;
import p000a.p013b.C0345l;
import p000a.p013b.C0348o;
import p000a.p013b.C0349p;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p021a.C0186b;

/* renamed from: a.b.e.e.c.a */
/* compiled from: CompletableAndThenObservable */
public final class C0257a<R> extends C0345l<R> {

    /* renamed from: a */
    final C0323f f506a;

    /* renamed from: b */
    final C0348o<? extends R> f507b;

    /* renamed from: a.b.e.e.c.a$a */
    /* compiled from: CompletableAndThenObservable */
    static final class C0258a<R> extends AtomicReference<C0161b> implements C0161b, C0176d, C0349p<R> {

        /* renamed from: a */
        final C0349p<? super R> f508a;

        /* renamed from: b */
        C0348o<? extends R> f509b;

        C0258a(C0349p<? super R> pVar, C0348o<? extends R> oVar) {
            this.f509b = oVar;
            this.f508a = pVar;
        }

        public void onNext(R r) {
            this.f508a.onNext(r);
        }

        public void onError(Throwable th) {
            this.f508a.onError(th);
        }

        public void onComplete() {
            C0348o<? extends R> oVar = this.f509b;
            if (oVar == null) {
                this.f508a.onComplete();
                return;
            }
            this.f509b = null;
            oVar.mo556a(this);
        }

        public void dispose() {
            C0186b.m592a((AtomicReference<C0161b>) this);
        }

        public void onSubscribe(C0161b bVar) {
            C0186b.m594b(this, bVar);
        }
    }

    public C0257a(C0323f fVar, C0348o<? extends R> oVar) {
        this.f506a = fVar;
        this.f507b = oVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo449b(C0349p<? super R> pVar) {
        C0258a aVar = new C0258a(pVar, this.f507b);
        pVar.onSubscribe(aVar);
        this.f506a.mo345a(aVar);
    }
}
