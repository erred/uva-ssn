package p000a.p013b;

import java.util.concurrent.TimeUnit;
import org.p153a.C3682b;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p019d.C0177a;
import p000a.p013b.p019d.C0180d;
import p000a.p013b.p019d.C0181e;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p020e.p023c.C0206a;
import p000a.p013b.p020e.p024d.C0214b;
import p000a.p013b.p020e.p025e.p026a.C0217a;
import p000a.p013b.p020e.p025e.p026a.C0219b;
import p000a.p013b.p020e.p025e.p026a.C0221c;
import p000a.p013b.p020e.p025e.p026a.C0222d;
import p000a.p013b.p020e.p025e.p026a.C0224e;
import p000a.p013b.p020e.p025e.p026a.C0225f;
import p000a.p013b.p020e.p025e.p026a.C0227g;
import p000a.p013b.p020e.p025e.p026a.C0229h;
import p000a.p013b.p020e.p025e.p026a.C0231i;
import p000a.p013b.p020e.p025e.p028c.C0257a;
import p000a.p013b.p020e.p025e.p030e.C0269b;
import p000a.p013b.p036f.C0324a;
import p000a.p013b.p038h.C0331a;

/* renamed from: a.b.b */
/* compiled from: Completable */
public abstract class C0159b implements C0323f {
    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo349b(C0176d dVar);

    /* renamed from: a */
    public static C0159b m539a() {
        return C0324a.m871a(C0221c.f422a);
    }

    /* renamed from: a */
    public static C0159b m545a(C0323f... fVarArr) {
        C0204b.m615a(fVarArr, "sources is null");
        if (fVarArr.length == 0) {
            return m539a();
        }
        if (fVarArr.length == 1) {
            return m543a(fVarArr[0]);
        }
        return C0324a.m871a((C0159b) new C0217a(fVarArr));
    }

    /* renamed from: a */
    public static C0159b m542a(C0184e eVar) {
        C0204b.m615a(eVar, "source is null");
        return C0324a.m871a((C0159b) new C0219b(eVar));
    }

    /* renamed from: a */
    public static <T> C0159b m544a(C3682b<T> bVar) {
        C0204b.m615a(bVar, "publisher is null");
        return C0324a.m871a((C0159b) new C0222d(bVar));
    }

    /* renamed from: a */
    public static C0159b m540a(long j, TimeUnit timeUnit) {
        return m541a(j, timeUnit, C0331a.m924a());
    }

    /* renamed from: a */
    public static C0159b m541a(long j, TimeUnit timeUnit, C0350q qVar) {
        C0204b.m615a(timeUnit, "unit is null");
        C0204b.m615a(qVar, "scheduler is null");
        return C0324a.m871a((C0159b) new C0229h(j, timeUnit, qVar));
    }

    /* renamed from: a */
    private static NullPointerException m546a(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    /* renamed from: a */
    public static C0159b m543a(C0323f fVar) {
        C0204b.m615a(fVar, "source is null");
        if (fVar instanceof C0159b) {
            return C0324a.m871a((C0159b) fVar);
        }
        return C0324a.m871a((C0159b) new C0224e(fVar));
    }

    /* renamed from: a */
    public final <T> C0345l<T> mo343a(C0348o<T> oVar) {
        C0204b.m615a(oVar, "next is null");
        return C0324a.m874a((C0345l<T>) new C0257a<T>(this, oVar));
    }

    /* renamed from: a */
    public final <T> C0353r<T> mo344a(C0357v<T> vVar) {
        C0204b.m615a(vVar, "next is null");
        return C0324a.m879a((C0353r<T>) new C0269b<T>(vVar, this));
    }

    /* renamed from: b */
    public final C0159b mo346b(C0323f fVar) {
        return mo350c(fVar);
    }

    /* renamed from: c */
    public final C0159b mo350c(C0323f fVar) {
        C0204b.m615a(fVar, "other is null");
        return m545a(this, fVar);
    }

    /* renamed from: a */
    public final C0159b mo342a(C0350q qVar) {
        C0204b.m615a(qVar, "scheduler is null");
        return C0324a.m871a((C0159b) new C0225f(this, qVar));
    }

    /* renamed from: a */
    public final C0159b mo341a(C0181e<? super C0330h<Throwable>, ? extends C3682b<?>> eVar) {
        return m544a((C3682b<T>) mo348b().mo539b(eVar));
    }

    /* renamed from: a */
    public final void mo345a(C0176d dVar) {
        C0204b.m615a(dVar, "s is null");
        try {
            C0176d a = C0324a.m872a(this, dVar);
            C0204b.m615a(a, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            mo349b(a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            C0171b.m584b(th);
            C0324a.m885a(th);
            throw m546a(th);
        }
    }

    /* renamed from: a */
    public final C0161b mo340a(C0177a aVar, C0180d<? super Throwable> dVar) {
        C0204b.m615a(dVar, "onError is null");
        C0204b.m615a(aVar, "onComplete is null");
        C0214b bVar = new C0214b(dVar, aVar);
        mo345a((C0176d) bVar);
        return bVar;
    }

    /* renamed from: a */
    public final C0161b mo339a(C0177a aVar) {
        C0204b.m615a(aVar, "onComplete is null");
        C0214b bVar = new C0214b(aVar);
        mo345a((C0176d) bVar);
        return bVar;
    }

    /* renamed from: b */
    public final C0159b mo347b(C0350q qVar) {
        C0204b.m615a(qVar, "scheduler is null");
        return C0324a.m871a((C0159b) new C0227g(this, qVar));
    }

    /* renamed from: b */
    public final <T> C0330h<T> mo348b() {
        if (this instanceof C0206a) {
            return ((C0206a) this).mo401a();
        }
        return C0324a.m873a((C0330h<T>) new C0231i<T>(this));
    }
}
