package p000a.p013b.p020e.p025e.p029d;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0345l;
import p000a.p013b.C0346m;
import p000a.p013b.C0347n;
import p000a.p013b.C0349p;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p020e.p021a.C0186b;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.e.e.d.b */
/* compiled from: ObservableCreate */
public final class C0260b<T> extends C0345l<T> {

    /* renamed from: a */
    final C0347n<T> f511a;

    /* renamed from: a.b.e.e.d.b$a */
    /* compiled from: ObservableCreate */
    static final class C0261a<T> extends AtomicReference<C0161b> implements C0161b, C0346m<T> {

        /* renamed from: a */
        final C0349p<? super T> f512a;

        C0261a(C0349p<? super T> pVar) {
            this.f512a = pVar;
        }

        /* renamed from: a */
        public void on_next(T t) {
            if (t == null) {
                mo452b(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (!mo453b()) {
                this.f512a.onNext(t);
            }
        }

        /* renamed from: b */
        public void mo452b(Throwable th) {
            if (!mo451a(th)) {
                C0324a.m885a(th);
            }
        }

        /* JADX INFO: finally extract failed */
        /* renamed from: a */
        public boolean mo451a(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (mo453b()) {
                return false;
            }
            try {
                this.f512a.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }

        /* renamed from: f_ */
        public void mo427f_() {
            if (!mo453b()) {
                try {
                    this.f512a.onComplete();
                } finally {
                    dispose();
                }
            }
        }

        public void dispose() {
            C0186b.m592a((AtomicReference<C0161b>) this);
        }

        /* renamed from: b */
        public boolean mo453b() {
            return C0186b.m590a((C0161b) get());
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }

    public C0260b(C0347n<T> nVar) {
        this.f511a = nVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo449b(C0349p<? super T> pVar) {
        C0261a aVar = new C0261a(pVar);
        pVar.onSubscribe(aVar);
        try {
            this.f511a.subscribe(aVar);
        } catch (Throwable th) {
            C0171b.m584b(th);
            aVar.mo452b(th);
        }
    }
}
