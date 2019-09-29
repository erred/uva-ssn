package p000a.p013b.p020e.p032g;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0350q;
import p000a.p013b.C0350q.C0352b;
import p000a.p013b.p017b.C0160a;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p021a.C0187c;

/* renamed from: a.b.e.g.c */
/* compiled from: IoScheduler */
public final class C0285c extends C0350q {

    /* renamed from: b */
    static final C0291f f589b;

    /* renamed from: c */
    static final C0291f f590c;

    /* renamed from: d */
    static final C0288c f591d = new C0288c(new C0291f("RxCachedThreadSchedulerShutdown"));

    /* renamed from: g */
    static final C0286a f592g = new C0286a(0, null, f589b);

    /* renamed from: h */
    private static final TimeUnit f593h = TimeUnit.SECONDS;

    /* renamed from: e */
    final ThreadFactory f594e;

    /* renamed from: f */
    final AtomicReference<C0286a> f595f;

    /* renamed from: a.b.e.g.c$a */
    /* compiled from: IoScheduler */
    static final class C0286a implements Runnable {

        /* renamed from: a */
        final C0160a f596a;

        /* renamed from: b */
        private final long f597b;

        /* renamed from: c */
        private final ConcurrentLinkedQueue<C0288c> f598c;

        /* renamed from: d */
        private final ScheduledExecutorService f599d;

        /* renamed from: e */
        private final Future<?> f600e;

        /* renamed from: f */
        private final ThreadFactory f601f;

        C0286a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            Future<?> future;
            this.f597b = timeUnit != null ? timeUnit.toNanos(j) : 0;
            this.f598c = new ConcurrentLinkedQueue<>();
            this.f596a = new C0160a();
            this.f601f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, C0285c.f590c);
                future = scheduledExecutorService.scheduleWithFixedDelay(this, this.f597b, this.f597b, TimeUnit.NANOSECONDS);
            } else {
                future = null;
            }
            this.f599d = scheduledExecutorService;
            this.f600e = future;
        }

        public void run() {
            mo483b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0288c mo481a() {
            if (this.f596a.mo352a()) {
                return C0285c.f591d;
            }
            while (!this.f598c.isEmpty()) {
                C0288c cVar = (C0288c) this.f598c.poll();
                if (cVar != null) {
                    return cVar;
                }
            }
            C0288c cVar2 = new C0288c(this.f601f);
            this.f596a.mo353a((C0161b) cVar2);
            return cVar2;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo482a(C0288c cVar) {
            cVar.mo488a(mo484c() + this.f597b);
            this.f598c.offer(cVar);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo483b() {
            if (!this.f598c.isEmpty()) {
                long c = mo484c();
                Iterator it = this.f598c.iterator();
                while (it.hasNext()) {
                    C0288c cVar = (C0288c) it.next();
                    if (cVar.mo487a() > c) {
                        return;
                    }
                    if (this.f598c.remove(cVar)) {
                        this.f596a.mo355b(cVar);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public long mo484c() {
            return System.nanoTime();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo485d() {
            this.f596a.dispose();
            if (this.f600e != null) {
                this.f600e.cancel(true);
            }
            if (this.f599d != null) {
                this.f599d.shutdownNow();
            }
        }
    }

    /* renamed from: a.b.e.g.c$b */
    /* compiled from: IoScheduler */
    static final class C0287b extends C0352b {

        /* renamed from: a */
        final AtomicBoolean f602a = new AtomicBoolean();

        /* renamed from: b */
        private final C0160a f603b;

        /* renamed from: c */
        private final C0286a f604c;

        /* renamed from: d */
        private final C0288c f605d;

        C0287b(C0286a aVar) {
            this.f604c = aVar;
            this.f603b = new C0160a();
            this.f605d = aVar.mo481a();
        }

        public void dispose() {
            if (this.f602a.compareAndSet(false, true)) {
                this.f603b.dispose();
                this.f604c.mo482a(this.f605d);
            }
        }

        /* renamed from: a */
        public C0161b mo336a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f603b.mo352a()) {
                return C0187c.INSTANCE;
            }
            return this.f605d.mo489a(runnable, j, timeUnit, this.f603b);
        }
    }

    /* renamed from: a.b.e.g.c$c */
    /* compiled from: IoScheduler */
    static final class C0288c extends C0290e {

        /* renamed from: b */
        private long f606b = 0;

        C0288c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        /* renamed from: a */
        public long mo487a() {
            return this.f606b;
        }

        /* renamed from: a */
        public void mo488a(long j) {
            this.f606b = j;
        }
    }

    static {
        f591d.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f589b = new C0291f("RxCachedThreadScheduler", max);
        f590c = new C0291f("RxCachedWorkerPoolEvictor", max);
        f592g.mo485d();
    }

    public C0285c() {
        this(f589b);
    }

    public C0285c(ThreadFactory threadFactory) {
        this.f594e = threadFactory;
        this.f595f = new AtomicReference<>(f592g);
        mo477b();
    }

    /* renamed from: b */
    public void mo477b() {
        C0286a aVar = new C0286a(60, f593h, this.f594e);
        if (!this.f595f.compareAndSet(f592g, aVar)) {
            aVar.mo485d();
        }
    }

    /* renamed from: a */
    public C0352b mo335a() {
        return new C0287b((C0286a) this.f595f.get());
    }
}
