package p000a.p013b.p014a.p015a;

import java.util.concurrent.Callable;
import p000a.p013b.C0350q;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p019d.C0181e;

/* renamed from: a.b.a.a.a */
/* compiled from: RxAndroidPlugins */
public final class C0152a {

    /* renamed from: a */
    private static volatile C0181e<Callable<C0350q>, C0350q> f369a;

    /* renamed from: b */
    private static volatile C0181e<C0350q, C0350q> f370b;

    /* renamed from: a */
    public static C0350q m531a(Callable<C0350q> callable) {
        if (callable != null) {
            C0181e<Callable<C0350q>, C0350q> eVar = f369a;
            if (eVar == null) {
                return m533b(callable);
            }
            return m529a(eVar, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    /* renamed from: a */
    public static C0350q m530a(C0350q qVar) {
        if (qVar != null) {
            C0181e<C0350q, C0350q> eVar = f370b;
            if (eVar == null) {
                return qVar;
            }
            return (C0350q) m532a(eVar, (T) qVar);
        }
        throw new NullPointerException("scheduler == null");
    }

    /* renamed from: b */
    static C0350q m533b(Callable<C0350q> callable) {
        try {
            C0350q qVar = (C0350q) callable.call();
            if (qVar != null) {
                return qVar;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw C0171b.m583a(th);
        }
    }

    /* renamed from: a */
    static C0350q m529a(C0181e<Callable<C0350q>, C0350q> eVar, Callable<C0350q> callable) {
        C0350q qVar = (C0350q) m532a(eVar, (T) callable);
        if (qVar != null) {
            return qVar;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    /* renamed from: a */
    static <T, R> R m532a(C0181e<T, R> eVar, T t) {
        try {
            return eVar.apply(t);
        } catch (Throwable th) {
            throw C0171b.m583a(th);
        }
    }
}
