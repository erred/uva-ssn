package p000a.p013b.p020e.p025e.p030e;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0350q;
import p000a.p013b.C0353r;
import p000a.p013b.C0355t;
import p000a.p013b.C0357v;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p021a.C0186b;
import p000a.p013b.p020e.p021a.C0189e;

/* renamed from: a.b.e.e.e.e */
/* compiled from: SingleSubscribeOn */
public final class C0276e<T> extends C0353r<T> {

    /* renamed from: a */
    final C0357v<? extends T> f550a;

    /* renamed from: b */
    final C0350q f551b;

    /* renamed from: a.b.e.e.e.e$a */
    /* compiled from: SingleSubscribeOn */
    static final class C0277a<T> extends AtomicReference<C0161b> implements C0161b, C0355t<T>, Runnable {

        /* renamed from: a */
        final C0355t<? super T> f552a;

        /* renamed from: b */
        final C0189e f553b = new C0189e();

        /* renamed from: c */
        final C0357v<? extends T> f554c;

        C0277a(C0355t<? super T> tVar, C0357v<? extends T> vVar) {
            this.f552a = tVar;
            this.f554c = vVar;
        }

        public void onSubscribe(C0161b bVar) {
            C0186b.m593a((AtomicReference<C0161b>) this, bVar);
        }

        public void onSuccess(T t) {
            this.f552a.onSuccess(t);
        }

        public void onError(Throwable th) {
            this.f552a.onError(th);
        }

        public void dispose() {
            C0186b.m592a((AtomicReference<C0161b>) this);
            this.f553b.dispose();
        }

        public void run() {
            this.f554c.mo563a(this);
        }
    }

    public C0276e(C0357v<? extends T> vVar, C0350q qVar) {
        this.f550a = vVar;
        this.f551b = qVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo462b(C0355t<? super T> tVar) {
        C0277a aVar = new C0277a(tVar, this.f550a);
        tVar.onSubscribe(aVar);
        aVar.f553b.mo389a(this.f551b.mo501a(aVar));
    }
}
