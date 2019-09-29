package p000a.p013b;

import p000a.p013b.p018c.C0171b;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p020e.p025e.p029d.C0260b;
import p000a.p013b.p020e.p025e.p029d.C0262c;
import p000a.p013b.p020e.p025e.p029d.C0264d;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.l */
/* compiled from: Observable */
public abstract class C0345l<T> implements C0348o<T> {
    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo449b(C0349p<? super T> pVar);

    /* renamed from: a */
    public static int m933a() {
        return C0330h.m911a();
    }

    /* renamed from: a */
    public static <T> C0345l<T> m934a(C0347n<T> nVar) {
        C0204b.m615a(nVar, "source is null");
        return C0324a.m874a((C0345l<T>) new C0260b<T>(nVar));
    }

    /* renamed from: a */
    public final C0345l<T> mo554a(C0350q qVar) {
        return mo555a(qVar, false, m933a());
    }

    /* renamed from: a */
    public final C0345l<T> mo555a(C0350q qVar, boolean z, int i) {
        C0204b.m615a(qVar, "scheduler is null");
        C0204b.m613a(i, "bufferSize");
        return C0324a.m874a((C0345l<T>) new C0262c<T>(this, qVar, z, i));
    }

    /* renamed from: a */
    public final void mo556a(C0349p<? super T> pVar) {
        C0204b.m615a(pVar, "observer is null");
        try {
            C0349p a = C0324a.m875a(this, pVar);
            C0204b.m615a(a, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            mo449b(a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            C0171b.m584b(th);
            C0324a.m885a(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    /* renamed from: b */
    public final C0345l<T> mo557b(C0350q qVar) {
        C0204b.m615a(qVar, "scheduler is null");
        return C0324a.m874a((C0345l<T>) new C0264d<T>(this, qVar));
    }
}
