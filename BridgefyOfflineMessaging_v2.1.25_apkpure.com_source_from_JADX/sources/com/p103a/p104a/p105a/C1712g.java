package com.p103a.p104a.p105a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p000a.p001a.p002a.p003a.C0135c;

/* renamed from: com.a.a.a.g */
/* compiled from: BackgroundManager */
class C1712g {

    /* renamed from: a */
    final AtomicReference<ScheduledFuture<?>> f5368a = new AtomicReference<>();

    /* renamed from: b */
    boolean f5369b = true;

    /* renamed from: c */
    private final ScheduledExecutorService f5370c;

    /* renamed from: d */
    private final List<C1714a> f5371d = new ArrayList();

    /* renamed from: e */
    private volatile boolean f5372e = true;

    /* renamed from: com.a.a.a.g$a */
    /* compiled from: BackgroundManager */
    public interface C1714a {
        /* renamed from: a */
        void mo6968a();
    }

    public C1712g(ScheduledExecutorService scheduledExecutorService) {
        this.f5370c = scheduledExecutorService;
    }

    /* renamed from: a */
    public void mo6965a(boolean z) {
        this.f5372e = z;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m7182c() {
        for (C1714a a : this.f5371d) {
            a.mo6968a();
        }
    }

    /* renamed from: a */
    public void mo6964a(C1714a aVar) {
        this.f5371d.add(aVar);
    }

    /* renamed from: a */
    public void mo6963a() {
        this.f5369b = false;
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.f5368a.getAndSet(null);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    /* renamed from: b */
    public void mo6966b() {
        if (this.f5372e && !this.f5369b) {
            this.f5369b = true;
            try {
                this.f5368a.compareAndSet(null, this.f5370c.schedule(new Runnable() {
                    public void run() {
                        C1712g.this.f5368a.set(null);
                        C1712g.this.m7182c();
                    }
                }, 5000, TimeUnit.MILLISECONDS));
            } catch (RejectedExecutionException e) {
                C0135c.m449h().mo271a("Answers", "Failed to schedule background detector", (Throwable) e);
            }
        }
    }
}
