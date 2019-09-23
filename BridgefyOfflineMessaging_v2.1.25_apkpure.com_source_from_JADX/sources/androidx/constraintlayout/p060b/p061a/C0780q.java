package androidx.constraintlayout.p060b.p061a;

import androidx.constraintlayout.p060b.p061a.C0761e.C0764b;
import java.util.ArrayList;

/* renamed from: androidx.constraintlayout.b.a.q */
/* compiled from: Snapshot */
public class C0780q {

    /* renamed from: a */
    private int f2361a;

    /* renamed from: b */
    private int f2362b;

    /* renamed from: c */
    private int f2363c;

    /* renamed from: d */
    private int f2364d;

    /* renamed from: e */
    private ArrayList<C0781a> f2365e = new ArrayList<>();

    /* renamed from: androidx.constraintlayout.b.a.q$a */
    /* compiled from: Snapshot */
    static class C0781a {

        /* renamed from: a */
        private C0761e f2366a;

        /* renamed from: b */
        private C0761e f2367b;

        /* renamed from: c */
        private int f2368c;

        /* renamed from: d */
        private C0764b f2369d;

        /* renamed from: e */
        private int f2370e;

        public C0781a(C0761e eVar) {
            this.f2366a = eVar;
            this.f2367b = eVar.mo3048g();
            this.f2368c = eVar.mo3046e();
            this.f2369d = eVar.mo3047f();
            this.f2370e = eVar.mo3049h();
        }

        /* renamed from: a */
        public void mo3170a(C0766f fVar) {
            this.f2366a = fVar.mo3063a(this.f2366a.mo3045d());
            if (this.f2366a != null) {
                this.f2367b = this.f2366a.mo3048g();
                this.f2368c = this.f2366a.mo3046e();
                this.f2369d = this.f2366a.mo3047f();
                this.f2370e = this.f2366a.mo3049h();
                return;
            }
            this.f2367b = null;
            this.f2368c = 0;
            this.f2369d = C0764b.STRONG;
            this.f2370e = 0;
        }

        /* renamed from: b */
        public void mo3171b(C0766f fVar) {
            fVar.mo3063a(this.f2366a.mo3045d()).mo3042a(this.f2367b, this.f2368c, this.f2369d, this.f2370e);
        }
    }

    public C0780q(C0766f fVar) {
        this.f2361a = fVar.mo3109n();
        this.f2362b = fVar.mo3111o();
        this.f2363c = fVar.mo3113p();
        this.f2364d = fVar.mo3116r();
        ArrayList D = fVar.mo3056D();
        int size = D.size();
        for (int i = 0; i < size; i++) {
            this.f2365e.add(new C0781a((C0761e) D.get(i)));
        }
    }

    /* renamed from: a */
    public void mo3168a(C0766f fVar) {
        this.f2361a = fVar.mo3109n();
        this.f2362b = fVar.mo3111o();
        this.f2363c = fVar.mo3113p();
        this.f2364d = fVar.mo3116r();
        int size = this.f2365e.size();
        for (int i = 0; i < size; i++) {
            ((C0781a) this.f2365e.get(i)).mo3170a(fVar);
        }
    }

    /* renamed from: b */
    public void mo3169b(C0766f fVar) {
        fVar.mo3093f(this.f2361a);
        fVar.mo3096g(this.f2362b);
        fVar.mo3098h(this.f2363c);
        fVar.mo3100i(this.f2364d);
        int size = this.f2365e.size();
        for (int i = 0; i < size; i++) {
            ((C0781a) this.f2365e.get(i)).mo3171b(fVar);
        }
    }
}
