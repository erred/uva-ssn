package p000a.p013b;

import p000a.p013b.p018c.C0171b;
import p000a.p013b.p019d.C0181e;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p020e.p025e.p030e.C0267a;
import p000a.p013b.p020e.p025e.p030e.C0271c;
import p000a.p013b.p020e.p025e.p030e.C0274d;
import p000a.p013b.p020e.p025e.p030e.C0276e;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.r */
/* compiled from: Single */
public abstract class C0353r<T> implements C0357v<T> {
    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo462b(C0355t<? super T> tVar);

    /* renamed from: a */
    public static <T> C0353r<T> m949a(C0356u<T> uVar) {
        C0204b.m615a(uVar, "source is null");
        return C0324a.m879a((C0353r<T>) new C0267a<T>(uVar));
    }

    /* renamed from: a */
    public final <R> C0353r<R> mo561a(C0181e<? super T, ? extends C0357v<? extends R>> eVar) {
        C0204b.m615a(eVar, "mapper is null");
        return C0324a.m879a((C0353r<T>) new C0271c<T>(this, eVar));
    }

    /* renamed from: a */
    public final C0353r<T> mo562a(C0350q qVar) {
        C0204b.m615a(qVar, "scheduler is null");
        return C0324a.m879a((C0353r<T>) new C0274d<T>(this, qVar));
    }

    /* renamed from: a */
    public final void mo563a(C0355t<? super T> tVar) {
        C0204b.m615a(tVar, "subscriber is null");
        C0355t a = C0324a.m880a(this, tVar);
        C0204b.m615a(a, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            mo462b(a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            C0171b.m584b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    /* renamed from: b */
    public final C0353r<T> mo564b(C0350q qVar) {
        C0204b.m615a(qVar, "scheduler is null");
        return C0324a.m879a((C0353r<T>) new C0276e<T>(this, qVar));
    }
}
