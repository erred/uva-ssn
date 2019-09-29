package p000a.p013b.p020e.p025e.p026a;

import org.p153a.C3682b;
import org.p153a.C3684d;
import p000a.p013b.C0159b;
import p000a.p013b.C0176d;
import p000a.p013b.C0344k;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p034i.C0310e;

/* renamed from: a.b.e.e.a.d */
/* compiled from: CompletableFromPublisher */
public final class C0222d<T> extends C0159b {

    /* renamed from: a */
    final C3682b<T> f423a;

    /* renamed from: a.b.e.e.a.d$a */
    /* compiled from: CompletableFromPublisher */
    static final class C0223a<T> implements C0161b, C0344k<T> {

        /* renamed from: a */
        final C0176d f424a;

        /* renamed from: b */
        C3684d f425b;

        public void onNext(T t) {
        }

        C0223a(C0176d dVar) {
            this.f424a = dVar;
        }

        public void onSubscribe(C3684d dVar) {
            if (C0310e.m835a(this.f425b, dVar)) {
                this.f425b = dVar;
                this.f424a.onSubscribe(this);
                dVar.mo408a(Long.MAX_VALUE);
            }
        }

        public void onError(Throwable th) {
            this.f424a.onError(th);
        }

        public void onComplete() {
            this.f424a.onComplete();
        }

        public void dispose() {
            this.f425b.mo407a();
            this.f425b = C0310e.CANCELLED;
        }
    }

    public C0222d(C3682b<T> bVar) {
        this.f423a = bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo349b(C0176d dVar) {
        this.f423a.mo538a(new C0223a(dVar));
    }
}
