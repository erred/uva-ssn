package p000a.p013b.p020e.p025e.p030e;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0353r;
import p000a.p013b.C0355t;
import p000a.p013b.C0357v;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p019d.C0181e;
import p000a.p013b.p020e.p021a.C0186b;
import p000a.p013b.p020e.p022b.C0204b;

/* renamed from: a.b.e.e.e.c */
/* compiled from: SingleFlatMap */
public final class C0271c<T, R> extends C0353r<R> {

    /* renamed from: a */
    final C0357v<? extends T> f538a;

    /* renamed from: b */
    final C0181e<? super T, ? extends C0357v<? extends R>> f539b;

    /* renamed from: a.b.e.e.e.c$a */
    /* compiled from: SingleFlatMap */
    static final class C0272a<T, R> extends AtomicReference<C0161b> implements C0161b, C0355t<T> {

        /* renamed from: a */
        final C0355t<? super R> f540a;

        /* renamed from: b */
        final C0181e<? super T, ? extends C0357v<? extends R>> f541b;

        /* renamed from: a.b.e.e.e.c$a$a */
        /* compiled from: SingleFlatMap */
        static final class C0273a<R> implements C0355t<R> {

            /* renamed from: a */
            final AtomicReference<C0161b> f542a;

            /* renamed from: b */
            final C0355t<? super R> f543b;

            C0273a(AtomicReference<C0161b> atomicReference, C0355t<? super R> tVar) {
                this.f542a = atomicReference;
                this.f543b = tVar;
            }

            public void onSubscribe(C0161b bVar) {
                C0186b.m594b(this.f542a, bVar);
            }

            public void onSuccess(R r) {
                this.f543b.onSuccess(r);
            }

            public void onError(Throwable th) {
                this.f543b.onError(th);
            }
        }

        C0272a(C0355t<? super R> tVar, C0181e<? super T, ? extends C0357v<? extends R>> eVar) {
            this.f540a = tVar;
            this.f541b = eVar;
        }

        public void dispose() {
            C0186b.m592a((AtomicReference<C0161b>) this);
        }

        /* renamed from: a */
        public boolean mo467a() {
            return C0186b.m590a((C0161b) get());
        }

        public void onSubscribe(C0161b bVar) {
            if (C0186b.m593a((AtomicReference<C0161b>) this, bVar)) {
                this.f540a.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            try {
                C0357v vVar = (C0357v) C0204b.m615a(this.f541b.apply(t), "The single returned by the mapper is null");
                if (!mo467a()) {
                    vVar.mo563a(new C0273a(this, this.f540a));
                }
            } catch (Throwable th) {
                C0171b.m584b(th);
                this.f540a.onError(th);
            }
        }

        public void onError(Throwable th) {
            this.f540a.onError(th);
        }
    }

    public C0271c(C0357v<? extends T> vVar, C0181e<? super T, ? extends C0357v<? extends R>> eVar) {
        this.f539b = eVar;
        this.f538a = vVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo462b(C0355t<? super R> tVar) {
        this.f538a.mo563a(new C0272a(tVar, this.f539b));
    }
}
