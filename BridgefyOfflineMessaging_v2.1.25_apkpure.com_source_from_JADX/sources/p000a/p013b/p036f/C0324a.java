package p000a.p013b.p036f;

import java.util.concurrent.Callable;
import org.p153a.C3683c;
import p000a.p013b.C0159b;
import p000a.p013b.C0176d;
import p000a.p013b.C0330h;
import p000a.p013b.C0345l;
import p000a.p013b.C0349p;
import p000a.p013b.C0350q;
import p000a.p013b.C0353r;
import p000a.p013b.C0355t;
import p000a.p013b.p018c.C0166a;
import p000a.p013b.p018c.C0172c;
import p000a.p013b.p018c.C0173d;
import p000a.p013b.p018c.C0175f;
import p000a.p013b.p019d.C0178b;
import p000a.p013b.p019d.C0180d;
import p000a.p013b.p019d.C0181e;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p020e.p035j.C0315e;

/* renamed from: a.b.f.a */
/* compiled from: RxJavaPlugins */
public final class C0324a {

    /* renamed from: a */
    static volatile C0180d<? super Throwable> f679a;

    /* renamed from: b */
    static volatile C0181e<? super Runnable, ? extends Runnable> f680b;

    /* renamed from: c */
    static volatile C0181e<? super Callable<C0350q>, ? extends C0350q> f681c;

    /* renamed from: d */
    static volatile C0181e<? super Callable<C0350q>, ? extends C0350q> f682d;

    /* renamed from: e */
    static volatile C0181e<? super Callable<C0350q>, ? extends C0350q> f683e;

    /* renamed from: f */
    static volatile C0181e<? super Callable<C0350q>, ? extends C0350q> f684f;

    /* renamed from: g */
    static volatile C0181e<? super C0350q, ? extends C0350q> f685g;

    /* renamed from: h */
    static volatile C0181e<? super C0350q, ? extends C0350q> f686h;

    /* renamed from: i */
    static volatile C0181e<? super C0330h, ? extends C0330h> f687i;

    /* renamed from: j */
    static volatile C0181e<? super C0345l, ? extends C0345l> f688j;

    /* renamed from: k */
    static volatile C0181e<? super C0353r, ? extends C0353r> f689k;

    /* renamed from: l */
    static volatile C0181e<? super C0159b, ? extends C0159b> f690l;

    /* renamed from: m */
    static volatile C0178b<? super C0330h, ? super C3683c, ? extends C3683c> f691m;

    /* renamed from: n */
    static volatile C0178b<? super C0345l, ? super C0349p, ? extends C0349p> f692n;

    /* renamed from: o */
    static volatile C0178b<? super C0353r, ? super C0355t, ? extends C0355t> f693o;

    /* renamed from: p */
    static volatile C0178b<? super C0159b, ? super C0176d, ? extends C0176d> f694p;

    /* renamed from: a */
    public static C0350q m878a(Callable<C0350q> callable) {
        C0204b.m615a(callable, "Scheduler Callable can't be null");
        C0181e<? super Callable<C0350q>, ? extends C0350q> eVar = f681c;
        if (eVar == null) {
            return m892e(callable);
        }
        return m876a(eVar, callable);
    }

    /* renamed from: b */
    public static C0350q m887b(Callable<C0350q> callable) {
        C0204b.m615a(callable, "Scheduler Callable can't be null");
        C0181e<? super Callable<C0350q>, ? extends C0350q> eVar = f683e;
        if (eVar == null) {
            return m892e(callable);
        }
        return m876a(eVar, callable);
    }

    /* renamed from: c */
    public static C0350q m889c(Callable<C0350q> callable) {
        C0204b.m615a(callable, "Scheduler Callable can't be null");
        C0181e<? super Callable<C0350q>, ? extends C0350q> eVar = f684f;
        if (eVar == null) {
            return m892e(callable);
        }
        return m876a(eVar, callable);
    }

    /* renamed from: d */
    public static C0350q m891d(Callable<C0350q> callable) {
        C0204b.m615a(callable, "Scheduler Callable can't be null");
        C0181e<? super Callable<C0350q>, ? extends C0350q> eVar = f682d;
        if (eVar == null) {
            return m892e(callable);
        }
        return m876a(eVar, callable);
    }

    /* renamed from: a */
    public static C0350q m877a(C0350q qVar) {
        C0181e<? super C0350q, ? extends C0350q> eVar = f685g;
        if (eVar == null) {
            return qVar;
        }
        return (C0350q) m882a(eVar, (T) qVar);
    }

    /* renamed from: a */
    public static void m885a(Throwable th) {
        C0180d<? super Throwable> dVar = f679a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!m888b(th)) {
            th = new C0175f(th);
        }
        if (dVar != null) {
            try {
                dVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                m890c(th2);
            }
        }
        th.printStackTrace();
        m890c(th);
    }

    /* renamed from: b */
    static boolean m888b(Throwable th) {
        if (!(th instanceof C0173d) && !(th instanceof C0172c) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof C0166a)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    static void m890c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    /* renamed from: b */
    public static C0350q m886b(C0350q qVar) {
        C0181e<? super C0350q, ? extends C0350q> eVar = f686h;
        if (eVar == null) {
            return qVar;
        }
        return (C0350q) m882a(eVar, (T) qVar);
    }

    /* renamed from: a */
    public static Runnable m883a(Runnable runnable) {
        C0204b.m615a(runnable, "run is null");
        C0181e<? super Runnable, ? extends Runnable> eVar = f680b;
        if (eVar == null) {
            return runnable;
        }
        return (Runnable) m882a(eVar, (T) runnable);
    }

    /* renamed from: a */
    public static <T> C3683c<? super T> m884a(C0330h<T> hVar, C3683c<? super T> cVar) {
        C0178b<? super C0330h, ? super C3683c, ? extends C3683c> bVar = f691m;
        return bVar != null ? (C3683c) m881a(bVar, hVar, cVar) : cVar;
    }

    /* renamed from: a */
    public static <T> C0349p<? super T> m875a(C0345l<T> lVar, C0349p<? super T> pVar) {
        C0178b<? super C0345l, ? super C0349p, ? extends C0349p> bVar = f692n;
        return bVar != null ? (C0349p) m881a(bVar, lVar, pVar) : pVar;
    }

    /* renamed from: a */
    public static <T> C0355t<? super T> m880a(C0353r<T> rVar, C0355t<? super T> tVar) {
        C0178b<? super C0353r, ? super C0355t, ? extends C0355t> bVar = f693o;
        return bVar != null ? (C0355t) m881a(bVar, rVar, tVar) : tVar;
    }

    /* renamed from: a */
    public static C0176d m872a(C0159b bVar, C0176d dVar) {
        C0178b<? super C0159b, ? super C0176d, ? extends C0176d> bVar2 = f694p;
        return bVar2 != null ? (C0176d) m881a(bVar2, bVar, dVar) : dVar;
    }

    /* renamed from: a */
    public static <T> C0330h<T> m873a(C0330h<T> hVar) {
        C0181e<? super C0330h, ? extends C0330h> eVar = f687i;
        return eVar != null ? (C0330h) m882a(eVar, (T) hVar) : hVar;
    }

    /* renamed from: a */
    public static <T> C0345l<T> m874a(C0345l<T> lVar) {
        C0181e<? super C0345l, ? extends C0345l> eVar = f688j;
        return eVar != null ? (C0345l) m882a(eVar, (T) lVar) : lVar;
    }

    /* renamed from: a */
    public static <T> C0353r<T> m879a(C0353r<T> rVar) {
        C0181e<? super C0353r, ? extends C0353r> eVar = f689k;
        return eVar != null ? (C0353r) m882a(eVar, (T) rVar) : rVar;
    }

    /* renamed from: a */
    public static C0159b m871a(C0159b bVar) {
        C0181e<? super C0159b, ? extends C0159b> eVar = f690l;
        return eVar != null ? (C0159b) m882a(eVar, (T) bVar) : bVar;
    }

    /* renamed from: a */
    static <T, R> R m882a(C0181e<T, R> eVar, T t) {
        try {
            return eVar.apply(t);
        } catch (Throwable th) {
            throw C0315e.m852a(th);
        }
    }

    /* renamed from: a */
    static <T, U, R> R m881a(C0178b<T, U, R> bVar, T t, U u) {
        try {
            return bVar.mo378a(t, u);
        } catch (Throwable th) {
            throw C0315e.m852a(th);
        }
    }

    /* renamed from: e */
    static C0350q m892e(Callable<C0350q> callable) {
        try {
            return (C0350q) C0204b.m615a(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw C0315e.m852a(th);
        }
    }

    /* renamed from: a */
    static C0350q m876a(C0181e<? super Callable<C0350q>, ? extends C0350q> eVar, Callable<C0350q> callable) {
        return (C0350q) C0204b.m615a(m882a(eVar, (T) callable), "Scheduler Callable result can't be null");
    }
}
