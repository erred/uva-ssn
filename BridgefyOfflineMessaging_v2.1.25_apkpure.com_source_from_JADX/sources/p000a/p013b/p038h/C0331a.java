package p000a.p013b.p038h;

import java.util.concurrent.Callable;
import p000a.p013b.C0350q;
import p000a.p013b.p020e.p032g.C0281b;
import p000a.p013b.p020e.p032g.C0285c;
import p000a.p013b.p020e.p032g.C0289d;
import p000a.p013b.p020e.p032g.C0298j;
import p000a.p013b.p020e.p032g.C0300k;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.h.a */
/* compiled from: Schedulers */
public final class C0331a {

    /* renamed from: a */
    static final C0350q f712a = C0324a.m891d(new C0339h());

    /* renamed from: b */
    static final C0350q f713b = C0324a.m878a((Callable<C0350q>) new C0333b<C0350q>());

    /* renamed from: c */
    static final C0350q f714c = C0324a.m887b((Callable<C0350q>) new C0334c<C0350q>());

    /* renamed from: d */
    static final C0350q f715d = C0300k.m797c();

    /* renamed from: e */
    static final C0350q f716e = C0324a.m889c((Callable<C0350q>) new C0337f<C0350q>());

    /* renamed from: a.b.h.a$a */
    /* compiled from: Schedulers */
    static final class C0332a {

        /* renamed from: a */
        static final C0350q f717a = new C0281b();
    }

    /* renamed from: a.b.h.a$b */
    /* compiled from: Schedulers */
    static final class C0333b implements Callable<C0350q> {
        C0333b() {
        }

        /* renamed from: a */
        public C0350q call() throws Exception {
            return C0332a.f717a;
        }
    }

    /* renamed from: a.b.h.a$c */
    /* compiled from: Schedulers */
    static final class C0334c implements Callable<C0350q> {
        C0334c() {
        }

        /* renamed from: a */
        public C0350q call() throws Exception {
            return C0335d.f718a;
        }
    }

    /* renamed from: a.b.h.a$d */
    /* compiled from: Schedulers */
    static final class C0335d {

        /* renamed from: a */
        static final C0350q f718a = new C0285c();
    }

    /* renamed from: a.b.h.a$e */
    /* compiled from: Schedulers */
    static final class C0336e {

        /* renamed from: a */
        static final C0350q f719a = new C0289d();
    }

    /* renamed from: a.b.h.a$f */
    /* compiled from: Schedulers */
    static final class C0337f implements Callable<C0350q> {
        C0337f() {
        }

        /* renamed from: a */
        public C0350q call() throws Exception {
            return C0336e.f719a;
        }
    }

    /* renamed from: a.b.h.a$g */
    /* compiled from: Schedulers */
    static final class C0338g {

        /* renamed from: a */
        static final C0350q f720a = new C0298j();
    }

    /* renamed from: a.b.h.a$h */
    /* compiled from: Schedulers */
    static final class C0339h implements Callable<C0350q> {
        C0339h() {
        }

        /* renamed from: a */
        public C0350q call() throws Exception {
            return C0338g.f720a;
        }
    }

    /* renamed from: a */
    public static C0350q m924a() {
        return C0324a.m877a(f713b);
    }

    /* renamed from: b */
    public static C0350q m925b() {
        return C0324a.m886b(f716e);
    }
}
