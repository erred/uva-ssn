package com.p103a.p104a.p107c;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.p001a.p002a.p003a.C0135c;

/* renamed from: com.a.a.c.m */
/* compiled from: CrashlyticsUncaughtExceptionHandler */
class C1824m implements UncaughtExceptionHandler {

    /* renamed from: a */
    private final C1825a f5646a;

    /* renamed from: b */
    private final UncaughtExceptionHandler f5647b;

    /* renamed from: c */
    private final AtomicBoolean f5648c = new AtomicBoolean(false);

    /* renamed from: com.a.a.c.m$a */
    /* compiled from: CrashlyticsUncaughtExceptionHandler */
    interface C1825a {
        /* renamed from: a */
        void mo7106a(Thread thread, Throwable th);
    }

    public C1824m(C1825a aVar, UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f5646a = aVar;
        this.f5647b = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.f5648c.set(true);
        try {
            this.f5646a.mo7106a(thread, th);
        } catch (Exception e) {
            C0135c.m449h().mo280e("CrashlyticsCore", "An error occurred in the uncaught exception handler", e);
        } catch (Throwable th2) {
            C0135c.m449h().mo270a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f5647b.uncaughtException(thread, th);
            this.f5648c.set(false);
            throw th2;
        }
        C0135c.m449h().mo270a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
        this.f5647b.uncaughtException(thread, th);
        this.f5648c.set(false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo7154a() {
        return this.f5648c.get();
    }
}
