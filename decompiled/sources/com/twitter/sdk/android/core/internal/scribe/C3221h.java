package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.internal.C3176g;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.twitter.sdk.android.core.internal.scribe.h */
/* compiled from: EventsHandler */
public abstract class C3221h<T> implements C3226k {

    /* renamed from: a */
    protected final Context f8445a;

    /* renamed from: b */
    protected final ScheduledExecutorService f8446b;

    /* renamed from: c */
    protected C3227l<T> f8447c;

    public C3221h(Context context, C3227l<T> lVar, C3218g gVar, ScheduledExecutorService scheduledExecutorService) {
        this.f8445a = context.getApplicationContext();
        this.f8446b = scheduledExecutorService;
        this.f8447c = lVar;
        gVar.mo27792a((C3226k) this);
    }

    /* renamed from: a */
    public void mo27803a(final T t, final boolean z) {
        mo27804a((Runnable) new Runnable() {
            public void run() {
                try {
                    C3221h.this.f8447c.mo27772a(t);
                    if (z) {
                        C3221h.this.f8447c.mo27774c();
                    }
                } catch (Exception e) {
                    C3176g.m9303a(C3221h.this.f8445a, "Failed to record event.", (Throwable) e);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo27805a(String str) {
        mo27804a((Runnable) new Runnable() {
            public void run() {
                try {
                    C3221h.this.f8447c.mo27771a();
                } catch (Exception e) {
                    C3176g.m9303a(C3221h.this.f8445a, "Failed to send events files.", (Throwable) e);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo27804a(Runnable runnable) {
        try {
            this.f8446b.submit(runnable);
        } catch (Exception e) {
            C3176g.m9303a(this.f8445a, "Failed to submit events task", (Throwable) e);
        }
    }
}
