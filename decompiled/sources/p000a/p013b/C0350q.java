package p000a.p013b;

import java.util.concurrent.TimeUnit;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p032g.C0290e;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.q */
/* compiled from: Scheduler */
public abstract class C0350q {

    /* renamed from: a */
    static final long f727a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* renamed from: a.b.q$a */
    /* compiled from: Scheduler */
    static final class C0351a implements C0161b, Runnable {

        /* renamed from: a */
        final Runnable f728a;

        /* renamed from: b */
        final C0352b f729b;

        /* renamed from: c */
        Thread f730c;

        C0351a(Runnable runnable, C0352b bVar) {
            this.f728a = runnable;
            this.f729b = bVar;
        }

        public void run() {
            this.f730c = Thread.currentThread();
            try {
                this.f728a.run();
            } finally {
                dispose();
                this.f730c = null;
            }
        }

        public void dispose() {
            if (this.f730c != Thread.currentThread() || !(this.f729b instanceof C0290e)) {
                this.f729b.dispose();
            } else {
                ((C0290e) this.f729b).mo491b();
            }
        }
    }

    /* renamed from: a.b.q$b */
    /* compiled from: Scheduler */
    public static abstract class C0352b implements C0161b {
        /* renamed from: a */
        public abstract C0161b mo336a(Runnable runnable, long j, TimeUnit timeUnit);

        /* renamed from: a */
        public C0161b mo478a(Runnable runnable) {
            return mo336a(runnable, 0, TimeUnit.NANOSECONDS);
        }

        /* renamed from: a */
        public long mo560a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: a */
    public abstract C0352b mo335a();

    /* renamed from: b */
    public void mo477b() {
    }

    /* renamed from: a */
    public C0161b mo501a(Runnable runnable) {
        return mo334a(runnable, 0, TimeUnit.NANOSECONDS);
    }

    /* renamed from: a */
    public C0161b mo334a(Runnable runnable, long j, TimeUnit timeUnit) {
        C0352b a = mo335a();
        C0351a aVar = new C0351a(C0324a.m883a(runnable), a);
        a.mo336a(aVar, j, timeUnit);
        return aVar;
    }
}
