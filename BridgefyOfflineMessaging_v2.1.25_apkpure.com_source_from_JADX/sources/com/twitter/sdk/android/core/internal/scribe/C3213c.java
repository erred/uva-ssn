package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.internal.C3176g;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.c */
/* compiled from: EnabledEventsStrategy */
public abstract class C3213c<T> implements C3227l<T> {

    /* renamed from: a */
    protected final Context f8417a;

    /* renamed from: b */
    protected final C3218g<T> f8418b;

    /* renamed from: c */
    final ScheduledExecutorService f8419c;

    /* renamed from: d */
    final AtomicReference<ScheduledFuture<?>> f8420d;

    /* renamed from: e */
    volatile int f8421e = -1;

    public C3213c(Context context, ScheduledExecutorService scheduledExecutorService, C3218g<T> gVar) {
        this.f8417a = context;
        this.f8419c = scheduledExecutorService;
        this.f8418b = gVar;
        this.f8420d = new AtomicReference<>();
    }

    /* renamed from: e */
    public void mo27778e() {
        if (this.f8421e != -1) {
            mo27777a((long) this.f8421e, (long) this.f8421e);
        }
    }

    /* renamed from: a */
    public void mo27771a() {
        mo27779f();
    }

    /* renamed from: b */
    public void mo27773b() {
        if (this.f8420d.get() != null) {
            C3176g.m9302a(this.f8417a, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.f8420d.get()).cancel(false);
            this.f8420d.set(null);
        }
    }

    /* renamed from: a */
    public void mo27772a(T t) {
        C3176g.m9302a(this.f8417a, t.toString());
        try {
            this.f8418b.mo27793a(t);
        } catch (IOException e) {
            C3176g.m9303a(this.f8417a, "Failed to write event.", (Throwable) e);
        }
        mo27778e();
    }

    /* renamed from: c */
    public boolean mo27774c() {
        try {
            return this.f8418b.mo27795a();
        } catch (IOException e) {
            C3176g.m9303a(this.f8417a, "Failed to roll file over.", (Throwable) e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27776a(int i) {
        this.f8421e = i;
        mo27777a(0, (long) this.f8421e);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo27777a(long j, long j2) {
        if (this.f8420d.get() == null) {
            C3252z zVar = new C3252z(this.f8417a, this);
            Context context = this.f8417a;
            StringBuilder sb = new StringBuilder();
            sb.append("Scheduling time based file roll over every ");
            sb.append(j2);
            sb.append(" seconds");
            C3176g.m9302a(context, sb.toString());
            try {
                this.f8420d.set(this.f8419c.scheduleAtFixedRate(zVar, j, j2, TimeUnit.SECONDS));
            } catch (RejectedExecutionException e) {
                C3176g.m9303a(this.f8417a, "Failed to schedule time based file roll over", (Throwable) e);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo27779f() {
        C3229n d = mo27775d();
        if (d == null) {
            C3176g.m9302a(this.f8417a, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        C3176g.m9302a(this.f8417a, "Sending all files");
        List e = this.f8418b.mo27799e();
        int i = 0;
        while (true) {
            try {
                if (e.size() <= 0) {
                    break;
                }
                C3176g.m9302a(this.f8417a, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(e.size())}));
                boolean a = d.mo27761a(e);
                if (a) {
                    i += e.size();
                    this.f8418b.mo27794a(e);
                }
                if (!a) {
                    break;
                }
                e = this.f8418b.mo27799e();
            } catch (Exception e2) {
                Context context = this.f8417a;
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to send batch of analytics files to server: ");
                sb.append(e2.getMessage());
                C3176g.m9303a(context, sb.toString(), (Throwable) e2);
            }
        }
        if (i == 0) {
            this.f8418b.mo27800f();
        }
    }
}
