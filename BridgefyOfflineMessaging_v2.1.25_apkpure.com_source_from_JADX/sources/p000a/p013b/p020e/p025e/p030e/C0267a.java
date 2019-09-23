package p000a.p013b.p020e.p025e.p030e;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0353r;
import p000a.p013b.C0354s;
import p000a.p013b.C0355t;
import p000a.p013b.C0356u;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p020e.p021a.C0186b;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.e.e.e.a */
/* compiled from: SingleCreate */
public final class C0267a<T> extends C0353r<T> {

    /* renamed from: a */
    final C0356u<T> f532a;

    /* renamed from: a.b.e.e.e.a$a */
    /* compiled from: SingleCreate */
    static final class C0268a<T> extends AtomicReference<C0161b> implements C0161b, C0354s<T> {

        /* renamed from: a */
        final C0355t<? super T> f533a;

        C0268a(C0355t<? super T> tVar) {
            this.f533a = tVar;
        }

        /* renamed from: a */
        public void mo463a(T t) {
            if (get() != C0186b.DISPOSED) {
                C0161b bVar = (C0161b) getAndSet(C0186b.DISPOSED);
                if (bVar != C0186b.DISPOSED) {
                    if (t == null) {
                        try {
                            this.f533a.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                        } catch (Throwable th) {
                            if (bVar != null) {
                                bVar.dispose();
                            }
                            throw th;
                        }
                    } else {
                        this.f533a.onSuccess(t);
                    }
                    if (bVar != null) {
                        bVar.dispose();
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo464a(Throwable th) {
            if (!mo465b(th)) {
                C0324a.m885a(th);
            }
        }

        /* renamed from: b */
        public boolean mo465b(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (get() != C0186b.DISPOSED) {
                C0161b bVar = (C0161b) getAndSet(C0186b.DISPOSED);
                if (bVar != C0186b.DISPOSED) {
                    try {
                        this.f533a.onError(th);
                        return true;
                    } finally {
                        if (bVar != null) {
                            bVar.dispose();
                        }
                    }
                }
            }
            return false;
        }

        public void dispose() {
            C0186b.m592a((AtomicReference<C0161b>) this);
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }

    public C0267a(C0356u<T> uVar) {
        this.f532a = uVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo462b(C0355t<? super T> tVar) {
        C0268a aVar = new C0268a(tVar);
        tVar.onSubscribe(aVar);
        try {
            this.f532a.subscribe(aVar);
        } catch (Throwable th) {
            C0171b.m584b(th);
            aVar.mo464a(th);
        }
    }
}
