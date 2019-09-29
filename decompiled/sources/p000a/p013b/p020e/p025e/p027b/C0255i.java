package p000a.p013b.p020e.p025e.p027b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.p153a.C3683c;
import org.p153a.C3684d;
import p000a.p013b.C0330h;
import p000a.p013b.C0350q;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p018c.C0172c;
import p000a.p013b.p020e.p021a.C0186b;
import p000a.p013b.p020e.p021a.C0187c;
import p000a.p013b.p020e.p034i.C0310e;

/* renamed from: a.b.e.e.b.i */
/* compiled from: FlowableTimer */
public final class C0255i extends C0330h<Long> {

    /* renamed from: b */
    final C0350q f501b;

    /* renamed from: c */
    final long f502c;

    /* renamed from: d */
    final TimeUnit f503d;

    /* renamed from: a.b.e.e.b.i$a */
    /* compiled from: FlowableTimer */
    static final class C0256a extends AtomicReference<C0161b> implements Runnable, C3684d {

        /* renamed from: a */
        final C3683c<? super Long> f504a;

        /* renamed from: b */
        volatile boolean f505b;

        C0256a(C3683c<? super Long> cVar) {
            this.f504a = cVar;
        }

        /* renamed from: a */
        public void mo408a(long j) {
            if (C0310e.m837b(j)) {
                this.f505b = true;
            }
        }

        /* renamed from: a */
        public void mo407a() {
            C0186b.m592a((AtomicReference<C0161b>) this);
        }

        public void run() {
            if (get() == C0186b.DISPOSED) {
                return;
            }
            if (this.f505b) {
                this.f504a.onNext(Long.valueOf(0));
                lazySet(C0187c.INSTANCE);
                this.f504a.onComplete();
                return;
            }
            lazySet(C0187c.INSTANCE);
            this.f504a.onError(new C0172c("Can't deliver value due to lack of requests"));
        }

        /* renamed from: a */
        public void mo447a(C0161b bVar) {
            C0186b.m595c(this, bVar);
        }
    }

    public C0255i(long j, TimeUnit timeUnit, C0350q qVar) {
        this.f502c = j;
        this.f503d = timeUnit;
        this.f501b = qVar;
    }

    /* renamed from: b */
    public void mo419b(C3683c<? super Long> cVar) {
        C0256a aVar = new C0256a(cVar);
        cVar.onSubscribe(aVar);
        aVar.mo447a(this.f501b.mo334a(aVar, this.f502c, this.f503d));
    }
}
