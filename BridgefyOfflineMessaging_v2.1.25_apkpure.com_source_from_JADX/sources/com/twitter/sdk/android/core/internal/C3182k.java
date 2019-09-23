package com.twitter.sdk.android.core.internal;

import android.app.Activity;
import com.twitter.sdk.android.core.C3254k;
import com.twitter.sdk.android.core.C3255l;
import com.twitter.sdk.android.core.internal.C3152a.C3155b;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;

/* renamed from: com.twitter.sdk.android.core.internal.k */
/* compiled from: SessionMonitor */
public class C3182k<T extends C3254k> {

    /* renamed from: a */
    protected final C3185a f8347a;

    /* renamed from: b */
    private final C3187m f8348b;

    /* renamed from: c */
    private final C3255l<T> f8349c;

    /* renamed from: d */
    private final ExecutorService f8350d;

    /* renamed from: e */
    private final C3186l f8351e;

    /* renamed from: com.twitter.sdk.android.core.internal.k$a */
    /* compiled from: SessionMonitor */
    protected static class C3185a {

        /* renamed from: a */
        public boolean f8354a;

        /* renamed from: b */
        public long f8355b;

        /* renamed from: c */
        private final Calendar f8356c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
            return false;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean mo27708a(long r7) {
            /*
                r6 = this;
                monitor-enter(r6)
                long r0 = r6.f8355b     // Catch:{ all -> 0x0027 }
                r2 = 0
                long r0 = r7 - r0
                r2 = 21600000(0x1499700, double:1.0671818E-316)
                r4 = 0
                r5 = 1
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 <= 0) goto L_0x0011
                r0 = 1
                goto L_0x0012
            L_0x0011:
                r0 = 0
            L_0x0012:
                long r1 = r6.f8355b     // Catch:{ all -> 0x0027 }
                boolean r7 = r6.m9325a(r7, r1)     // Catch:{ all -> 0x0027 }
                r7 = r7 ^ r5
                boolean r8 = r6.f8354a     // Catch:{ all -> 0x0027 }
                if (r8 != 0) goto L_0x0025
                if (r0 != 0) goto L_0x0021
                if (r7 == 0) goto L_0x0025
            L_0x0021:
                r6.f8354a = r5     // Catch:{ all -> 0x0027 }
                monitor-exit(r6)
                return r5
            L_0x0025:
                monitor-exit(r6)
                return r4
            L_0x0027:
                r7 = move-exception
                monitor-exit(r6)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.C3182k.C3185a.mo27708a(long):boolean");
        }

        /* renamed from: b */
        public synchronized void mo27709b(long j) {
            this.f8354a = false;
            this.f8355b = j;
        }

        /* renamed from: a */
        private boolean m9325a(long j, long j2) {
            this.f8356c.setTimeInMillis(j);
            int i = this.f8356c.get(6);
            int i2 = this.f8356c.get(1);
            this.f8356c.setTimeInMillis(j2);
            int i3 = this.f8356c.get(6);
            int i4 = this.f8356c.get(1);
            if (i == i3 && i2 == i4) {
                return true;
            }
            return false;
        }
    }

    public C3182k(C3255l<T> lVar, ExecutorService executorService, C3186l<T> lVar2) {
        this(lVar, new C3187m(), executorService, new C3185a(), lVar2);
    }

    C3182k(C3255l<T> lVar, C3187m mVar, ExecutorService executorService, C3185a aVar, C3186l lVar2) {
        this.f8348b = mVar;
        this.f8349c = lVar;
        this.f8350d = executorService;
        this.f8347a = aVar;
        this.f8351e = lVar2;
    }

    /* renamed from: a */
    public void mo27705a(C3152a aVar) {
        aVar.mo27659a(new C3155b() {
            /* renamed from: a */
            public void mo27667a(Activity activity) {
                C3182k.this.mo27704a();
            }
        });
    }

    /* renamed from: a */
    public void mo27704a() {
        if (this.f8349c.mo27626b() != null && this.f8347a.mo27708a(this.f8348b.mo27698a())) {
            this.f8350d.submit(new Runnable() {
                public void run() {
                    C3182k.this.mo27706b();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo27706b() {
        for (C3254k a : this.f8349c.mo27628c().values()) {
            this.f8351e.mo27710a(a);
        }
        this.f8347a.mo27709b(this.f8348b.mo27698a());
    }
}
