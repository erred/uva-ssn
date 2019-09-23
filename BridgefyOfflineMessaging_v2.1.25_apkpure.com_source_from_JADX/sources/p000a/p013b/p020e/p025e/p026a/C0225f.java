package p000a.p013b.p020e.p025e.p026a;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0159b;
import p000a.p013b.C0176d;
import p000a.p013b.C0323f;
import p000a.p013b.C0350q;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p021a.C0186b;

/* renamed from: a.b.e.e.a.f */
/* compiled from: CompletableObserveOn */
public final class C0225f extends C0159b {

    /* renamed from: a */
    final C0323f f427a;

    /* renamed from: b */
    final C0350q f428b;

    /* renamed from: a.b.e.e.a.f$a */
    /* compiled from: CompletableObserveOn */
    static final class C0226a extends AtomicReference<C0161b> implements C0161b, C0176d, Runnable {

        /* renamed from: a */
        final C0176d f429a;

        /* renamed from: b */
        final C0350q f430b;

        /* renamed from: c */
        Throwable f431c;

        C0226a(C0176d dVar, C0350q qVar) {
            this.f429a = dVar;
            this.f430b = qVar;
        }

        public void dispose() {
            C0186b.m592a((AtomicReference<C0161b>) this);
        }

        public void onSubscribe(C0161b bVar) {
            if (C0186b.m593a((AtomicReference<C0161b>) this, bVar)) {
                this.f429a.onSubscribe(this);
            }
        }

        public void onError(Throwable th) {
            this.f431c = th;
            C0186b.m594b(this, this.f430b.mo501a(this));
        }

        public void onComplete() {
            C0186b.m594b(this, this.f430b.mo501a(this));
        }

        public void run() {
            Throwable th = this.f431c;
            if (th != null) {
                this.f431c = null;
                this.f429a.onError(th);
                return;
            }
            this.f429a.onComplete();
        }
    }

    public C0225f(C0323f fVar, C0350q qVar) {
        this.f427a = fVar;
        this.f428b = qVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo349b(C0176d dVar) {
        this.f427a.mo345a(new C0226a(dVar, this.f428b));
    }
}
