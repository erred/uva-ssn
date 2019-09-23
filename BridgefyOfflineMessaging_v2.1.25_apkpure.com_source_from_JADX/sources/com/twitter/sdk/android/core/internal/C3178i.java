package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.C3256m;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.twitter.sdk.android.core.internal.i */
/* compiled from: ExecutorUtils */
public final class C3178i {

    /* renamed from: a */
    private static final int f8329a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b */
    private static final int f8330b = (f8329a + 1);

    /* renamed from: c */
    private static final int f8331c = ((f8329a * 2) + 1);

    /* renamed from: a */
    public static ExecutorService m9311a(String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f8330b, f8331c, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), m9315c(str));
        m9312a(str, threadPoolExecutor);
        return threadPoolExecutor;
    }

    /* renamed from: b */
    public static ScheduledExecutorService m9314b(String str) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(m9315c(str));
        m9312a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    /* renamed from: c */
    static ThreadFactory m9315c(final String str) {
        final AtomicLong atomicLong = new AtomicLong(1);
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(atomicLong.getAndIncrement());
                newThread.setName(sb.toString());
                return newThread;
            }
        };
    }

    /* renamed from: a */
    static void m9312a(String str, ExecutorService executorService) {
        m9313a(str, executorService, 1, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    static void m9313a(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        final ExecutorService executorService2 = executorService;
        final long j2 = j;
        final TimeUnit timeUnit2 = timeUnit;
        final String str2 = str;
        C31802 r2 = new Runnable() {
            public void run() {
                try {
                    executorService2.shutdown();
                    if (!executorService2.awaitTermination(j2, timeUnit2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str2);
                        sb.append(" did not shutdown in the allocated time. Requesting immediate shutdown.");
                        C3256m.m9537g().mo27607a("Twitter", sb.toString());
                        executorService2.shutdownNow();
                    }
                } catch (InterruptedException unused) {
                    C3256m.m9537g().mo27607a("Twitter", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{str2}));
                    executorService2.shutdownNow();
                }
            }
        };
        StringBuilder sb = new StringBuilder();
        sb.append("Twitter Shutdown Hook for ");
        sb.append(str);
        runtime.addShutdownHook(new Thread(r2, sb.toString()));
    }
}
