package p000a.p013b.p020e.p032g;

import java.util.concurrent.Callable;

/* renamed from: a.b.e.g.g */
/* compiled from: ScheduledDirectTask */
public final class C0293g extends C0280a implements Callable<Void> {
    public C0293g(Runnable runnable) {
        super(runnable);
    }

    /* renamed from: a */
    public Void call() throws Exception {
        this.f574b = Thread.currentThread();
        try {
            this.f573a.run();
            return null;
        } finally {
            lazySet(f571c);
            this.f574b = null;
        }
    }
}
