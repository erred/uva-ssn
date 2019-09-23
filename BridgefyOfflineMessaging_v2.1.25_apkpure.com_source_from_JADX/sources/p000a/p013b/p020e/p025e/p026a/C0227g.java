package p000a.p013b.p020e.p025e.p026a;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0159b;
import p000a.p013b.C0176d;
import p000a.p013b.C0323f;
import p000a.p013b.C0350q;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p021a.C0186b;
import p000a.p013b.p020e.p021a.C0189e;

/* renamed from: a.b.e.e.a.g */
/* compiled from: CompletableSubscribeOn */
public final class C0227g extends C0159b {

    /* renamed from: a */
    final C0323f f432a;

    /* renamed from: b */
    final C0350q f433b;

    /* renamed from: a.b.e.e.a.g$a */
    /* compiled from: CompletableSubscribeOn */
    static final class C0228a extends AtomicReference<C0161b> implements C0161b, C0176d, Runnable {

        /* renamed from: a */
        final C0176d f434a;

        /* renamed from: b */
        final C0189e f435b = new C0189e();

        /* renamed from: c */
        final C0323f f436c;

        C0228a(C0176d dVar, C0323f fVar) {
            this.f434a = dVar;
            this.f436c = fVar;
        }

        public void run() {
            this.f436c.mo345a(this);
        }

        public void onSubscribe(C0161b bVar) {
            C0186b.m593a((AtomicReference<C0161b>) this, bVar);
        }

        public void onError(Throwable th) {
            this.f434a.onError(th);
        }

        public void onComplete() {
            this.f434a.onComplete();
        }

        public void dispose() {
            C0186b.m592a((AtomicReference<C0161b>) this);
            this.f435b.dispose();
        }
    }

    public C0227g(C0323f fVar, C0350q qVar) {
        this.f432a = fVar;
        this.f433b = qVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo349b(C0176d dVar) {
        C0228a aVar = new C0228a(dVar, this.f432a);
        dVar.onSubscribe(aVar);
        aVar.f435b.mo389a(this.f433b.mo501a(aVar));
    }
}
