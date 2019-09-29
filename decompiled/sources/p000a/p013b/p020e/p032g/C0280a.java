package p000a.p013b.p020e.p032g;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p022b.C0190a;

/* renamed from: a.b.e.g.a */
/* compiled from: AbstractDirectTask */
abstract class C0280a extends AtomicReference<Future<?>> implements C0161b {

    /* renamed from: c */
    protected static final FutureTask<Void> f571c = new FutureTask<>(C0190a.f396b, null);

    /* renamed from: d */
    protected static final FutureTask<Void> f572d = new FutureTask<>(C0190a.f396b, null);

    /* renamed from: a */
    protected final Runnable f573a;

    /* renamed from: b */
    protected Thread f574b;

    C0280a(Runnable runnable) {
        this.f573a = runnable;
    }

    public final void dispose() {
        Future future = (Future) get();
        if (future != f571c && future != f572d && compareAndSet(future, f572d) && future != null) {
            future.cancel(this.f574b != Thread.currentThread());
        }
    }

    /* renamed from: a */
    public final void mo476a(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 != f571c) {
                if (future2 == f572d) {
                    future.cancel(this.f574b != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
