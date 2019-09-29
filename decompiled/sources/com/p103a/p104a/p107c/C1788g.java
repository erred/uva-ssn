package com.p103a.p104a.p107c;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import p000a.p001a.p002a.p003a.C0135c;

/* renamed from: com.a.a.c.g */
/* compiled from: CrashlyticsBackgroundWorker */
class C1788g {

    /* renamed from: a */
    private final ExecutorService f5568a;

    public C1788g(ExecutorService executorService) {
        this.f5568a = executorService;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <T> T mo7083a(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.f5568a.submit(callable).get(4, TimeUnit.SECONDS);
            }
            return this.f5568a.submit(callable).get();
        } catch (RejectedExecutionException unused) {
            C0135c.m449h().mo270a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Exception e) {
            C0135c.m449h().mo280e("CrashlyticsCore", "Failed to execute task.", e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Future<?> mo7084a(final Runnable runnable) {
        try {
            return this.f5568a.submit(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        C0135c.m449h().mo280e("CrashlyticsCore", "Failed to execute task.", e);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            C0135c.m449h().mo270a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public <T> Future<T> mo7085b(final Callable<T> callable) {
        try {
            return this.f5568a.submit(new Callable<T>() {
                public T call() throws Exception {
                    try {
                        return callable.call();
                    } catch (Exception e) {
                        C0135c.m449h().mo280e("CrashlyticsCore", "Failed to execute task.", e);
                        return null;
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            C0135c.m449h().mo270a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
