package p000a.p013b.p020e.p025e.p030e;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0350q;
import p000a.p013b.C0353r;
import p000a.p013b.C0355t;
import p000a.p013b.C0357v;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p021a.C0186b;

/* renamed from: a.b.e.e.e.d */
/* compiled from: SingleObserveOn */
public final class C0274d<T> extends C0353r<T> {

    /* renamed from: a */
    final C0357v<T> f544a;

    /* renamed from: b */
    final C0350q f545b;

    /* renamed from: a.b.e.e.e.d$a */
    /* compiled from: SingleObserveOn */
    static final class C0275a<T> extends AtomicReference<C0161b> implements C0161b, C0355t<T>, Runnable {

        /* renamed from: a */
        final C0355t<? super T> f546a;

        /* renamed from: b */
        final C0350q f547b;

        /* renamed from: c */
        T f548c;

        /* renamed from: d */
        Throwable f549d;

        C0275a(C0355t<? super T> tVar, C0350q qVar) {
            this.f546a = tVar;
            this.f547b = qVar;
        }

        public void onSubscribe(C0161b bVar) {
            if (C0186b.m593a((AtomicReference<C0161b>) this, bVar)) {
                this.f546a.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.f548c = t;
            C0186b.m594b(this, this.f547b.mo501a(this));
        }

        public void onError(Throwable th) {
            this.f549d = th;
            C0186b.m594b(this, this.f547b.mo501a(this));
        }

        public void run() {
            Throwable th = this.f549d;
            if (th != null) {
                this.f546a.onError(th);
            } else {
                this.f546a.onSuccess(this.f548c);
            }
        }

        public void dispose() {
            C0186b.m592a((AtomicReference<C0161b>) this);
        }
    }

    public C0274d(C0357v<T> vVar, C0350q qVar) {
        this.f544a = vVar;
        this.f545b = qVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo462b(C0355t<? super T> tVar) {
        this.f544a.mo563a(new C0275a(tVar, this.f545b));
    }
}
