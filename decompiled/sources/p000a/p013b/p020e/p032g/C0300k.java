package p000a.p013b.p020e.p032g;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p000a.p013b.C0350q;
import p000a.p013b.C0350q.C0352b;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p017b.C0162c;
import p000a.p013b.p020e.p021a.C0187c;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.e.g.k */
/* compiled from: TrampolineScheduler */
public final class C0300k extends C0350q {

    /* renamed from: b */
    private static final C0300k f632b = new C0300k();

    /* renamed from: a.b.e.g.k$a */
    /* compiled from: TrampolineScheduler */
    static final class C0301a implements Runnable {

        /* renamed from: a */
        private final Runnable f633a;

        /* renamed from: b */
        private final C0303c f634b;

        /* renamed from: c */
        private final long f635c;

        C0301a(Runnable runnable, C0303c cVar, long j) {
            this.f633a = runnable;
            this.f634b = cVar;
            this.f635c = j;
        }

        public void run() {
            if (!this.f634b.f642c) {
                long a = this.f634b.mo560a(TimeUnit.MILLISECONDS);
                if (this.f635c > a) {
                    try {
                        Thread.sleep(this.f635c - a);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        C0324a.m885a((Throwable) e);
                        return;
                    }
                }
                if (!this.f634b.f642c) {
                    this.f633a.run();
                }
            }
        }
    }

    /* renamed from: a.b.e.g.k$b */
    /* compiled from: TrampolineScheduler */
    static final class C0302b implements Comparable<C0302b> {

        /* renamed from: a */
        final Runnable f636a;

        /* renamed from: b */
        final long f637b;

        /* renamed from: c */
        final int f638c;

        /* renamed from: d */
        volatile boolean f639d;

        C0302b(Runnable runnable, Long l, int i) {
            this.f636a = runnable;
            this.f637b = l.longValue();
            this.f638c = i;
        }

        /* renamed from: a */
        public int compareTo(C0302b bVar) {
            int a = C0204b.m614a(this.f637b, bVar.f637b);
            return a == 0 ? C0204b.m612a(this.f638c, bVar.f638c) : a;
        }
    }

    /* renamed from: a.b.e.g.k$c */
    /* compiled from: TrampolineScheduler */
    static final class C0303c extends C0352b implements C0161b {

        /* renamed from: a */
        final PriorityBlockingQueue<C0302b> f640a = new PriorityBlockingQueue<>();

        /* renamed from: b */
        final AtomicInteger f641b = new AtomicInteger();

        /* renamed from: c */
        volatile boolean f642c;

        /* renamed from: d */
        private final AtomicInteger f643d = new AtomicInteger();

        /* renamed from: a.b.e.g.k$c$a */
        /* compiled from: TrampolineScheduler */
        final class C0304a implements Runnable {

            /* renamed from: a */
            final C0302b f644a;

            C0304a(C0302b bVar) {
                this.f644a = bVar;
            }

            public void run() {
                this.f644a.f639d = true;
                C0303c.this.f640a.remove(this.f644a);
            }
        }

        C0303c() {
        }

        /* renamed from: a */
        public C0161b mo478a(Runnable runnable) {
            return mo505a(runnable, mo560a(TimeUnit.MILLISECONDS));
        }

        /* renamed from: a */
        public C0161b mo336a(Runnable runnable, long j, TimeUnit timeUnit) {
            long a = mo560a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return mo505a(new C0301a(runnable, this, a), a);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0161b mo505a(Runnable runnable, long j) {
            if (this.f642c) {
                return C0187c.INSTANCE;
            }
            C0302b bVar = new C0302b(runnable, Long.valueOf(j), this.f641b.incrementAndGet());
            this.f640a.add(bVar);
            if (this.f643d.getAndIncrement() != 0) {
                return C0162c.m566a(new C0304a(bVar));
            }
            int i = 1;
            while (!this.f642c) {
                C0302b bVar2 = (C0302b) this.f640a.poll();
                if (bVar2 == null) {
                    i = this.f643d.addAndGet(-i);
                    if (i == 0) {
                        return C0187c.INSTANCE;
                    }
                } else if (!bVar2.f639d) {
                    bVar2.f636a.run();
                }
            }
            this.f640a.clear();
            return C0187c.INSTANCE;
        }

        public void dispose() {
            this.f642c = true;
        }
    }

    /* renamed from: c */
    public static C0300k m797c() {
        return f632b;
    }

    /* renamed from: a */
    public C0352b mo335a() {
        return new C0303c();
    }

    C0300k() {
    }

    /* renamed from: a */
    public C0161b mo501a(Runnable runnable) {
        C0324a.m883a(runnable).run();
        return C0187c.INSTANCE;
    }

    /* renamed from: a */
    public C0161b mo334a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            C0324a.m883a(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            C0324a.m885a((Throwable) e);
        }
        return C0187c.INSTANCE;
    }
}
