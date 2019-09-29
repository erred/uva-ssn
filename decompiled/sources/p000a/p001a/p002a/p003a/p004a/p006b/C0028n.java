package p000a.p001a.p002a.p003a.p004a.p006b;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import p000a.p001a.p002a.p003a.C0135c;

/* renamed from: a.a.a.a.a.b.n */
/* compiled from: ExecutorUtils */
public final class C0028n {
    /* renamed from: a */
    public static ExecutorService m102a(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(m106c(str));
        m103a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    /* renamed from: b */
    public static ScheduledExecutorService m105b(String str) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(m106c(str));
        m103a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    /* renamed from: c */
    public static final ThreadFactory m106c(final String str) {
        final AtomicLong atomicLong = new AtomicLong(1);
        return new ThreadFactory() {
            public Thread newThread(final Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(new C0019h() {
                    /* renamed from: a */
                    public void mo30a() {
                        runnable.run();
                    }
                });
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(atomicLong.getAndIncrement());
                newThread.setName(sb.toString());
                return newThread;
            }
        };
    }

    /* renamed from: a */
    private static final void m103a(String str, ExecutorService executorService) {
        m104a(str, executorService, 2, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    public static final void m104a(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        final String str2 = str;
        final ExecutorService executorService2 = executorService;
        final long j2 = j;
        final TimeUnit timeUnit2 = timeUnit;
        C00312 r2 = new C0019h() {
            /* renamed from: a */
            public void mo30a() {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Executing shutdown hook for ");
                    sb.append(str2);
                    C0135c.m449h().mo270a("Fabric", sb.toString());
                    executorService2.shutdown();
                    if (!executorService2.awaitTermination(j2, timeUnit2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append(" did not shut down in the allocated time. Requesting immediate shutdown.");
                        C0135c.m449h().mo270a("Fabric", sb2.toString());
                        executorService2.shutdownNow();
                    }
                } catch (InterruptedException unused) {
                    C0135c.m449h().mo270a("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{str2}));
                    executorService2.shutdownNow();
                }
            }
        };
        StringBuilder sb = new StringBuilder();
        sb.append("Crashlytics Shutdown Hook for ");
        sb.append(str);
        runtime.addShutdownHook(new Thread(r2, sb.toString()));
    }
}
