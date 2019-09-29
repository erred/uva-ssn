package androidx.p043a.p044a.p045a;

import java.util.concurrent.Executor;

/* renamed from: androidx.a.a.a.a */
/* compiled from: ArchTaskExecutor */
public class C0406a extends C0411c {

    /* renamed from: a */
    private static volatile C0406a f824a;

    /* renamed from: d */
    private static final Executor f825d = new Executor() {
        public void execute(Runnable runnable) {
            C0406a.m1231a().mo767b(runnable);
        }
    };

    /* renamed from: e */
    private static final Executor f826e = new Executor() {
        public void execute(Runnable runnable) {
            C0406a.m1231a().mo766a(runnable);
        }
    };

    /* renamed from: b */
    private C0411c f827b = this.f828c;

    /* renamed from: c */
    private C0411c f828c = new C0409b();

    private C0406a() {
    }

    /* renamed from: a */
    public static C0406a m1231a() {
        if (f824a != null) {
            return f824a;
        }
        synchronized (C0406a.class) {
            if (f824a == null) {
                f824a = new C0406a();
            }
        }
        return f824a;
    }

    /* renamed from: a */
    public void mo766a(Runnable runnable) {
        this.f827b.mo766a(runnable);
    }

    /* renamed from: b */
    public void mo767b(Runnable runnable) {
        this.f827b.mo767b(runnable);
    }

    /* renamed from: b */
    public boolean mo768b() {
        return this.f827b.mo768b();
    }
}
