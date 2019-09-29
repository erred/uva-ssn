package p000a.p013b;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.p153a.C3682b;
import org.p153a.C3683c;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p019d.C0181e;
import p000a.p013b.p020e.p022b.C0190a;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p020e.p023c.C0210e;
import p000a.p013b.p020e.p025e.p027b.C0233b;
import p000a.p013b.p020e.p025e.p027b.C0242c;
import p000a.p013b.p020e.p025e.p027b.C0243d;
import p000a.p013b.p020e.p025e.p027b.C0244e;
import p000a.p013b.p020e.p025e.p027b.C0251g;
import p000a.p013b.p020e.p025e.p027b.C0253h;
import p000a.p013b.p020e.p025e.p027b.C0255i;
import p000a.p013b.p020e.p033h.C0305a;
import p000a.p013b.p036f.C0324a;
import p000a.p013b.p038h.C0331a;

/* renamed from: a.b.h */
/* compiled from: Flowable */
public abstract class C0330h<T> implements C3682b<T> {

    /* renamed from: a */
    static final int f711a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo419b(C3683c<? super T> cVar);

    /* renamed from: a */
    public static int m911a() {
        return f711a;
    }

    /* renamed from: a */
    public static <T> C0330h<T> m914a(C0343j<T> jVar, C0151a aVar) {
        C0204b.m615a(jVar, "source is null");
        C0204b.m615a(aVar, "mode is null");
        return C0324a.m873a((C0330h<T>) new C0233b<T>(jVar, aVar));
    }

    /* renamed from: b */
    public static <T> C0330h<T> m917b() {
        return C0324a.m873a(C0242c.f456b);
    }

    /* renamed from: a */
    public static <T> C0330h<T> m916a(Callable<? extends Throwable> callable) {
        C0204b.m615a(callable, "errorSupplier is null");
        return C0324a.m873a((C0330h<T>) new C0243d<T>(callable));
    }

    /* renamed from: a */
    public static <T> C0330h<T> m915a(Throwable th) {
        C0204b.m615a(th, "throwable is null");
        return m916a(C0190a.m608a(th));
    }

    /* renamed from: a */
    public static C0330h<Long> m912a(long j, TimeUnit timeUnit) {
        return m913a(j, timeUnit, C0331a.m924a());
    }

    /* renamed from: a */
    public static C0330h<Long> m913a(long j, TimeUnit timeUnit, C0350q qVar) {
        C0204b.m615a(timeUnit, "unit is null");
        C0204b.m615a(qVar, "scheduler is null");
        return C0324a.m873a((C0330h<T>) new C0255i<T>(Math.max(0, j), timeUnit, qVar));
    }

    /* renamed from: a */
    public final <R> C0330h<R> mo535a(C0181e<? super T, ? extends C3682b<? extends R>> eVar) {
        return mo536a(eVar, false, m911a(), m911a());
    }

    /* renamed from: a */
    public final <R> C0330h<R> mo536a(C0181e<? super T, ? extends C3682b<? extends R>> eVar, boolean z, int i, int i2) {
        C0204b.m615a(eVar, "mapper is null");
        C0204b.m613a(i, "maxConcurrency");
        C0204b.m613a(i2, "bufferSize");
        if (this instanceof C0210e) {
            Object call = ((C0210e) this).call();
            if (call == null) {
                return m917b();
            }
            return C0253h.m696a(call, eVar);
        }
        C0244e eVar2 = new C0244e(this, eVar, z, i, i2);
        return C0324a.m873a((C0330h<T>) eVar2);
    }

    /* renamed from: b */
    public final C0330h<T> mo539b(C0181e<? super C0330h<Throwable>, ? extends C3682b<?>> eVar) {
        C0204b.m615a(eVar, "handler is null");
        return C0324a.m873a((C0330h<T>) new C0251g<T>(this, eVar));
    }

    /* renamed from: a */
    public final void mo538a(C3683c<? super T> cVar) {
        if (cVar instanceof C0344k) {
            mo537a((C0344k) cVar);
            return;
        }
        C0204b.m615a(cVar, "s is null");
        mo537a((C0344k<? super T>) new C0305a<Object>(cVar));
    }

    /* renamed from: a */
    public final void mo537a(C0344k<? super T> kVar) {
        C0204b.m615a(kVar, "s is null");
        try {
            C3683c a = C0324a.m884a(this, (C3683c<? super T>) kVar);
            C0204b.m615a(a, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            mo419b(a);
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
}
