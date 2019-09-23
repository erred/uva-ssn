package p000a.p013b.p020e.p032g;

import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import p000a.p013b.C0350q.C0352b;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p021a.C0185a;
import p000a.p013b.p020e.p021a.C0187c;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.e.g.e */
/* compiled from: NewThreadWorker */
public class C0290e extends C0352b implements C0161b {

    /* renamed from: a */
    volatile boolean f609a;

    /* renamed from: b */
    private final ScheduledExecutorService f610b;

    public C0290e(ThreadFactory threadFactory) {
        this.f610b = C0295i.m787a(threadFactory);
    }

    /* renamed from: a */
    public C0161b mo478a(Runnable runnable) {
        return mo336a(runnable, 0, null);
    }

    /* renamed from: a */
    public C0161b mo336a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f609a) {
            return C0187c.INSTANCE;
        }
        return mo489a(runnable, j, timeUnit, null);
    }

    /* renamed from: b */
    public C0161b mo490b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        C0293g gVar = new C0293g(C0324a.m883a(runnable));
        if (j <= 0) {
            try {
                future = this.f610b.submit(gVar);
            } catch (RejectedExecutionException e) {
                C0324a.m885a((Throwable) e);
                return C0187c.INSTANCE;
            }
        } else {
            future = this.f610b.schedule(gVar, j, timeUnit);
        }
        gVar.mo476a(future);
        return gVar;
    }

    /* renamed from: a */
    public C0294h mo489a(Runnable runnable, long j, TimeUnit timeUnit, C0185a aVar) {
        Future future;
        C0294h hVar = new C0294h(C0324a.m883a(runnable), aVar);
        if (aVar != null && !aVar.mo353a(hVar)) {
            return hVar;
        }
        if (j <= 0) {
            try {
                future = this.f610b.submit(hVar);
            } catch (RejectedExecutionException e) {
                if (aVar != null) {
                    aVar.mo355b(hVar);
                }
                C0324a.m885a((Throwable) e);
            }
        } else {
            future = this.f610b.schedule(hVar, j, timeUnit);
        }
        hVar.mo496a(future);
        return hVar;
    }

    public void dispose() {
        if (!this.f609a) {
            this.f609a = true;
            this.f610b.shutdownNow();
        }
    }

    /* renamed from: b */
    public void mo491b() {
        if (!this.f609a) {
            this.f609a = true;
            this.f610b.shutdown();
        }
    }
}
