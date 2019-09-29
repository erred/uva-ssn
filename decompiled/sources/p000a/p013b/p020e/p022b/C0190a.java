package p000a.p013b.p020e.p022b;

import java.util.Comparator;
import java.util.concurrent.Callable;
import org.p153a.C3684d;
import p000a.p013b.p018c.C0173d;
import p000a.p013b.p019d.C0177a;
import p000a.p013b.p019d.C0180d;
import p000a.p013b.p019d.C0181e;
import p000a.p013b.p019d.C0182f;
import p000a.p013b.p019d.C0183g;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.e.b.a */
/* compiled from: Functions */
public final class C0190a {

    /* renamed from: a */
    static final C0181e<Object, Object> f395a = new C0197g();

    /* renamed from: b */
    public static final Runnable f396b = new C0194d();

    /* renamed from: c */
    public static final C0177a f397c = new C0191a();

    /* renamed from: d */
    static final C0180d<Object> f398d = new C0192b();

    /* renamed from: e */
    public static final C0180d<Throwable> f399e = new C0195e();

    /* renamed from: f */
    public static final C0180d<Throwable> f400f = new C0202l();

    /* renamed from: g */
    public static final C0182f f401g = new C0193c();

    /* renamed from: h */
    static final C0183g<Object> f402h = new C0203m();

    /* renamed from: i */
    static final C0183g<Object> f403i = new C0196f();

    /* renamed from: j */
    static final Callable<Object> f404j = new C0201k();

    /* renamed from: k */
    static final Comparator<Object> f405k = new C0200j();

    /* renamed from: l */
    public static final C0180d<C3684d> f406l = new C0199i();

    /* renamed from: a.b.e.b.a$a */
    /* compiled from: Functions */
    static final class C0191a implements C0177a {
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }

        C0191a() {
        }
    }

    /* renamed from: a.b.e.b.a$b */
    /* compiled from: Functions */
    static final class C0192b implements C0180d<Object> {
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }

        C0192b() {
        }
    }

    /* renamed from: a.b.e.b.a$c */
    /* compiled from: Functions */
    static final class C0193c implements C0182f {
        C0193c() {
        }
    }

    /* renamed from: a.b.e.b.a$d */
    /* compiled from: Functions */
    static final class C0194d implements Runnable {
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }

        C0194d() {
        }
    }

    /* renamed from: a.b.e.b.a$e */
    /* compiled from: Functions */
    static final class C0195e implements C0180d<Throwable> {
        C0195e() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            C0324a.m885a(th);
        }
    }

    /* renamed from: a.b.e.b.a$f */
    /* compiled from: Functions */
    static final class C0196f implements C0183g<Object> {
        C0196f() {
        }
    }

    /* renamed from: a.b.e.b.a$g */
    /* compiled from: Functions */
    static final class C0197g implements C0181e<Object, Object> {
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }

        C0197g() {
        }
    }

    /* renamed from: a.b.e.b.a$h */
    /* compiled from: Functions */
    static final class C0198h<T, U> implements C0181e<T, U>, Callable<U> {

        /* renamed from: a */
        final U f407a;

        C0198h(U u) {
            this.f407a = u;
        }

        public U call() throws Exception {
            return this.f407a;
        }

        public U apply(T t) throws Exception {
            return this.f407a;
        }
    }

    /* renamed from: a.b.e.b.a$i */
    /* compiled from: Functions */
    static final class C0199i implements C0180d<C3684d> {
        C0199i() {
        }

        /* renamed from: a */
        public void accept(C3684d dVar) throws Exception {
            dVar.mo408a(Long.MAX_VALUE);
        }
    }

    /* renamed from: a.b.e.b.a$j */
    /* compiled from: Functions */
    static final class C0200j implements Comparator<Object> {
        C0200j() {
        }

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* renamed from: a.b.e.b.a$k */
    /* compiled from: Functions */
    static final class C0201k implements Callable<Object> {
        public Object call() {
            return null;
        }

        C0201k() {
        }
    }

    /* renamed from: a.b.e.b.a$l */
    /* compiled from: Functions */
    static final class C0202l implements C0180d<Throwable> {
        C0202l() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            C0324a.m885a((Throwable) new C0173d(th));
        }
    }

    /* renamed from: a.b.e.b.a$m */
    /* compiled from: Functions */
    static final class C0203m implements C0183g<Object> {
        C0203m() {
        }
    }

    /* renamed from: a */
    public static <T> Callable<T> m608a(T t) {
        return new C0198h(t);
    }
}
