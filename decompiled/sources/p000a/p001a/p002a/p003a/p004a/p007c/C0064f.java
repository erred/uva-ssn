package p000a.p001a.p002a.p003a.p004a.p007c;

import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import p000a.p001a.p002a.p003a.p004a.p007c.C0044a.C0053d;

/* renamed from: a.a.a.a.a.c.f */
/* compiled from: PriorityAsyncTask */
public abstract class C0064f<Params, Progress, Result> extends C0044a<Params, Progress, Result> implements C0060b<C0073l>, C0069i, C0073l {

    /* renamed from: a */
    private final C0070j f145a = new C0070j();

    /* renamed from: a.a.a.a.a.c.f$a */
    /* compiled from: PriorityAsyncTask */
    private static class C0065a<Result> implements Executor {

        /* renamed from: a */
        private final Executor f146a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final C0064f f147b;

        public C0065a(Executor executor, C0064f fVar) {
            this.f146a = executor;
            this.f147b = fVar;
        }

        public void execute(Runnable runnable) {
            this.f146a.execute(new C0068h<Result>(runnable, null) {
                /* renamed from: a */
                public <T extends C0060b<C0073l> & C0069i & C0073l> T mo141a() {
                    return C0065a.this.f147b;
                }
            });
        }
    }

    /* renamed from: a */
    public final void mo134a(ExecutorService executorService, Params... paramsArr) {
        super.mo84a((Executor) new C0065a(executorService, this), paramsArr);
    }

    public int compareTo(Object obj) {
        return C0063e.m199a(this, obj);
    }

    /* renamed from: a */
    public void mo106c(C0073l lVar) {
        if (mo91c_() == C0053d.PENDING) {
            ((C0060b) ((C0069i) mo139g())).mo106c(lVar);
            return;
        }
        throw new IllegalStateException("Must not add Dependency after task is running");
    }

    /* renamed from: c */
    public Collection<C0073l> mo105c() {
        return ((C0060b) ((C0069i) mo139g())).mo105c();
    }

    /* renamed from: d */
    public boolean mo107d() {
        return ((C0060b) ((C0069i) mo139g())).mo107d();
    }

    /* renamed from: b */
    public C0063e mo135b() {
        return ((C0069i) mo139g()).mo135b();
    }

    /* renamed from: b */
    public void mo136b(boolean z) {
        ((C0073l) ((C0069i) mo139g())).mo136b(z);
    }

    /* renamed from: f */
    public boolean mo138f() {
        return ((C0073l) ((C0069i) mo139g())).mo138f();
    }

    /* renamed from: a */
    public void mo133a(Throwable th) {
        ((C0073l) ((C0069i) mo139g())).mo133a(th);
    }

    /* renamed from: g */
    public <T extends C0060b<C0073l> & C0069i & C0073l> T mo139g() {
        return this.f145a;
    }
}
