package p000a.p013b.p020e.p032g;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0350q;
import p000a.p013b.C0350q.C0352b;
import p000a.p013b.p017b.C0160a;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p021a.C0187c;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.e.g.j */
/* compiled from: SingleScheduler */
public final class C0298j extends C0350q {

    /* renamed from: d */
    static final C0291f f625d = new C0291f("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);

    /* renamed from: e */
    static final ScheduledExecutorService f626e = Executors.newScheduledThreadPool(0);

    /* renamed from: b */
    final ThreadFactory f627b;

    /* renamed from: c */
    final AtomicReference<ScheduledExecutorService> f628c;

    /* renamed from: a.b.e.g.j$a */
    /* compiled from: SingleScheduler */
    static final class C0299a extends C0352b {

        /* renamed from: a */
        final ScheduledExecutorService f629a;

        /* renamed from: b */
        final C0160a f630b = new C0160a();

        /* renamed from: c */
        volatile boolean f631c;

        C0299a(ScheduledExecutorService scheduledExecutorService) {
            this.f629a = scheduledExecutorService;
        }

        /* renamed from: a */
        public C0161b mo336a(Runnable runnable, long j, TimeUnit timeUnit) {
            Future future;
            if (this.f631c) {
                return C0187c.INSTANCE;
            }
            C0294h hVar = new C0294h(C0324a.m883a(runnable), this.f630b);
            this.f630b.mo353a((C0161b) hVar);
            if (j <= 0) {
                try {
                    future = this.f629a.submit(hVar);
                } catch (RejectedExecutionException e) {
                    dispose();
                    C0324a.m885a((Throwable) e);
                    return C0187c.INSTANCE;
                }
            } else {
                future = this.f629a.schedule(hVar, j, timeUnit);
            }
            hVar.mo496a(future);
            return hVar;
        }

        public void dispose() {
            if (!this.f631c) {
                this.f631c = true;
                this.f630b.dispose();
            }
        }
    }

    static {
        f626e.shutdown();
    }

    public C0298j() {
        this(f625d);
    }

    public C0298j(ThreadFactory threadFactory) {
        this.f628c = new AtomicReference<>();
        this.f627b = threadFactory;
        this.f628c.lazySet(m792a(threadFactory));
    }

    /* renamed from: a */
    static ScheduledExecutorService m792a(ThreadFactory threadFactory) {
        return C0295i.m787a(threadFactory);
    }

    /* renamed from: b */
    public void mo477b() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = (ScheduledExecutorService) this.f628c.get();
            if (scheduledExecutorService != f626e) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = m792a(this.f627b);
            }
        } while (!this.f628c.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
    }

    /* renamed from: a */
    public C0352b mo335a() {
        return new C0299a((ScheduledExecutorService) this.f628c.get());
    }

    /* renamed from: a */
    public C0161b mo334a(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        C0293g gVar = new C0293g(C0324a.m883a(runnable));
        if (j <= 0) {
            try {
                future = ((ScheduledExecutorService) this.f628c.get()).submit(gVar);
            } catch (RejectedExecutionException e) {
                C0324a.m885a((Throwable) e);
                return C0187c.INSTANCE;
            }
        } else {
            future = ((ScheduledExecutorService) this.f628c.get()).schedule(gVar, j, timeUnit);
        }
        gVar.mo476a(future);
        return gVar;
    }
}
