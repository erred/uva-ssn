package p000a.p013b.p020e.p025e.p029d;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0348o;
import p000a.p013b.C0349p;
import p000a.p013b.C0350q;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p021a.C0186b;

/* renamed from: a.b.e.e.d.d */
/* compiled from: ObservableSubscribeOn */
public final class C0264d<T> extends C0259a<T, T> {

    /* renamed from: b */
    final C0350q f527b;

    /* renamed from: a.b.e.e.d.d$a */
    /* compiled from: ObservableSubscribeOn */
    static final class C0265a<T> extends AtomicReference<C0161b> implements C0161b, C0349p<T> {

        /* renamed from: a */
        final C0349p<? super T> f528a;

        /* renamed from: b */
        final AtomicReference<C0161b> f529b = new AtomicReference<>();

        C0265a(C0349p<? super T> pVar) {
            this.f528a = pVar;
        }

        public void onSubscribe(C0161b bVar) {
            C0186b.m593a(this.f529b, bVar);
        }

        public void onNext(T t) {
            this.f528a.onNext(t);
        }

        public void onError(Throwable th) {
            this.f528a.onError(th);
        }

        public void onComplete() {
            this.f528a.onComplete();
        }

        public void dispose() {
            C0186b.m592a(this.f529b);
            C0186b.m592a((AtomicReference<C0161b>) this);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo460a(C0161b bVar) {
            C0186b.m593a((AtomicReference<C0161b>) this, bVar);
        }
    }

    /* renamed from: a.b.e.e.d.d$b */
    /* compiled from: ObservableSubscribeOn */
    final class C0266b implements Runnable {

        /* renamed from: b */
        private final C0265a<T> f531b;

        C0266b(C0265a<T> aVar) {
            this.f531b = aVar;
        }

        public void run() {
            C0264d.this.f510a.mo556a(this.f531b);
        }
    }

    public C0264d(C0348o<T> oVar, C0350q qVar) {
        super(oVar);
        this.f527b = qVar;
    }

    /* renamed from: b */
    public void mo449b(C0349p<? super T> pVar) {
        C0265a aVar = new C0265a(pVar);
        pVar.onSubscribe(aVar);
        aVar.mo460a(this.f527b.mo501a(new C0266b(aVar)));
    }
}
