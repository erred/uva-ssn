package p000a.p013b.p020e.p025e.p026a;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0159b;
import p000a.p013b.C0176d;
import p000a.p013b.C0350q;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p021a.C0186b;

/* renamed from: a.b.e.e.a.h */
/* compiled from: CompletableTimer */
public final class C0229h extends C0159b {

    /* renamed from: a */
    final long f437a;

    /* renamed from: b */
    final TimeUnit f438b;

    /* renamed from: c */
    final C0350q f439c;

    /* renamed from: a.b.e.e.a.h$a */
    /* compiled from: CompletableTimer */
    static final class C0230a extends AtomicReference<C0161b> implements C0161b, Runnable {

        /* renamed from: a */
        final C0176d f440a;

        C0230a(C0176d dVar) {
            this.f440a = dVar;
        }

        public void run() {
            this.f440a.onComplete();
        }

        public void dispose() {
            C0186b.m592a((AtomicReference<C0161b>) this);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo417a(C0161b bVar) {
            C0186b.m594b(this, bVar);
        }
    }

    public C0229h(long j, TimeUnit timeUnit, C0350q qVar) {
        this.f437a = j;
        this.f438b = timeUnit;
        this.f439c = qVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo349b(C0176d dVar) {
        C0230a aVar = new C0230a(dVar);
        dVar.onSubscribe(aVar);
        aVar.mo417a(this.f439c.mo334a(aVar, this.f437a, this.f438b));
    }
}
