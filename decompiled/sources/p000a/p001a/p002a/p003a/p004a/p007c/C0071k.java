package p000a.p001a.p002a.p003a.p004a.p007c;

import android.annotation.TargetApi;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: a.a.a.a.a.c.k */
/* compiled from: PriorityThreadPoolExecutor */
public class C0071k extends ThreadPoolExecutor {

    /* renamed from: a */
    private static final int f153a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b */
    private static final int f154b = (f153a + 1);

    /* renamed from: c */
    private static final int f155c = ((f153a * 2) + 1);

    /* renamed from: a.a.a.a.a.c.k$a */
    /* compiled from: PriorityThreadPoolExecutor */
    protected static final class C0072a implements ThreadFactory {

        /* renamed from: a */
        private final int f156a;

        public C0072a(int i) {
            this.f156a = i;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f156a);
            thread.setName("Queue");
            return thread;
        }
    }

    <T extends Runnable & C0060b & C0073l & C0069i> C0071k(int i, int i2, long j, TimeUnit timeUnit, C0061c<T> cVar, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, cVar, threadFactory);
        prestartAllCoreThreads();
    }

    /* renamed from: a */
    public static <T extends Runnable & C0060b & C0073l & C0069i> C0071k m233a(int i, int i2) {
        C0071k kVar = new C0071k(i, i2, 1, TimeUnit.SECONDS, new C0061c(), new C0072a(10));
        return kVar;
    }

    /* renamed from: a */
    public static C0071k m232a() {
        return m233a(f154b, f155c);
    }

    /* access modifiers changed from: protected */
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C0068h(runnable, t);
    }

    /* access modifiers changed from: protected */
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0068h(callable);
    }

    @TargetApi(9)
    public void execute(Runnable runnable) {
        if (C0070j.m223a((Object) runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    /* access modifiers changed from: protected */
    public void afterExecute(Runnable runnable, Throwable th) {
        C0073l lVar = (C0073l) runnable;
        lVar.mo136b(true);
        lVar.mo133a(th);
        getQueue().mo119d();
        super.afterExecute(runnable, th);
    }

    /* renamed from: b */
    public C0061c getQueue() {
        return (C0061c) super.getQueue();
    }
}
