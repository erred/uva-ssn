package p000a.p013b.p020e.p032g;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0350q;
import p000a.p013b.C0350q.C0352b;
import p000a.p013b.p017b.C0160a;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p021a.C0187c;
import p000a.p013b.p020e.p021a.C0188d;

/* renamed from: a.b.e.g.b */
/* compiled from: ComputationScheduler */
public final class C0281b extends C0350q {

    /* renamed from: b */
    static final C0283b f575b = new C0283b(0, f576c);

    /* renamed from: c */
    static final C0291f f576c = new C0291f("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);

    /* renamed from: d */
    static final int f577d = m761a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: e */
    static final C0284c f578e = new C0284c(new C0291f("RxComputationShutdown"));

    /* renamed from: f */
    final ThreadFactory f579f;

    /* renamed from: g */
    final AtomicReference<C0283b> f580g;

    /* renamed from: a.b.e.g.b$a */
    /* compiled from: ComputationScheduler */
    static final class C0282a extends C0352b {

        /* renamed from: a */
        volatile boolean f581a;

        /* renamed from: b */
        private final C0188d f582b = new C0188d();

        /* renamed from: c */
        private final C0160a f583c = new C0160a();

        /* renamed from: d */
        private final C0188d f584d = new C0188d();

        /* renamed from: e */
        private final C0284c f585e;

        C0282a(C0284c cVar) {
            this.f585e = cVar;
            this.f584d.mo353a((C0161b) this.f582b);
            this.f584d.mo353a((C0161b) this.f583c);
        }

        public void dispose() {
            if (!this.f581a) {
                this.f581a = true;
                this.f584d.dispose();
            }
        }

        /* renamed from: a */
        public C0161b mo478a(Runnable runnable) {
            if (this.f581a) {
                return C0187c.INSTANCE;
            }
            return this.f585e.mo489a(runnable, 0, TimeUnit.MILLISECONDS, this.f582b);
        }

        /* renamed from: a */
        public C0161b mo336a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f581a) {
                return C0187c.INSTANCE;
            }
            return this.f585e.mo489a(runnable, j, timeUnit, this.f583c);
        }
    }

    /* renamed from: a.b.e.g.b$b */
    /* compiled from: ComputationScheduler */
    static final class C0283b {

        /* renamed from: a */
        final int f586a;

        /* renamed from: b */
        final C0284c[] f587b;

        /* renamed from: c */
        long f588c;

        C0283b(int i, ThreadFactory threadFactory) {
            this.f586a = i;
            this.f587b = new C0284c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f587b[i2] = new C0284c(threadFactory);
            }
        }

        /* renamed from: a */
        public C0284c mo479a() {
            int i = this.f586a;
            if (i == 0) {
                return C0281b.f578e;
            }
            C0284c[] cVarArr = this.f587b;
            long j = this.f588c;
            this.f588c = 1 + j;
            return cVarArr[(int) (j % ((long) i))];
        }

        /* renamed from: b */
        public void mo480b() {
            for (C0284c dispose : this.f587b) {
                dispose.dispose();
            }
        }
    }

    /* renamed from: a.b.e.g.b$c */
    /* compiled from: ComputationScheduler */
    static final class C0284c extends C0290e {
        C0284c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    /* renamed from: a */
    static int m761a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    static {
        f578e.dispose();
        f575b.mo480b();
    }

    public C0281b() {
        this(f576c);
    }

    public C0281b(ThreadFactory threadFactory) {
        this.f579f = threadFactory;
        this.f580g = new AtomicReference<>(f575b);
        mo477b();
    }

    /* renamed from: a */
    public C0352b mo335a() {
        return new C0282a(((C0283b) this.f580g.get()).mo479a());
    }

    /* renamed from: a */
    public C0161b mo334a(Runnable runnable, long j, TimeUnit timeUnit) {
        return ((C0283b) this.f580g.get()).mo479a().mo490b(runnable, j, timeUnit);
    }

    /* renamed from: b */
    public void mo477b() {
        C0283b bVar = new C0283b(f577d, this.f579f);
        if (!this.f580g.compareAndSet(f575b, bVar)) {
            bVar.mo480b();
        }
    }
}
