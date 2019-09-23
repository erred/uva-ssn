package p000a.p013b.p020e.p034i;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.p153a.C3684d;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p020e.p035j.C0313c;

/* renamed from: a.b.e.i.d */
/* compiled from: SubscriptionArbiter */
public class C0309d extends AtomicInteger implements C3684d {

    /* renamed from: d */
    C3684d f656d;

    /* renamed from: e */
    long f657e;

    /* renamed from: f */
    final AtomicReference<C3684d> f658f = new AtomicReference<>();

    /* renamed from: g */
    final AtomicLong f659g = new AtomicLong();

    /* renamed from: h */
    final AtomicLong f660h = new AtomicLong();

    /* renamed from: i */
    volatile boolean f661i;

    /* renamed from: j */
    protected boolean f662j;

    /* renamed from: a */
    public final void mo508a(C3684d dVar) {
        if (this.f661i) {
            dVar.mo407a();
            return;
        }
        C0204b.m615a(dVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            C3684d dVar2 = (C3684d) this.f658f.getAndSet(dVar);
            if (dVar2 != null) {
                dVar2.mo407a();
            }
            mo509b();
            return;
        }
        C3684d dVar3 = this.f656d;
        if (dVar3 != null) {
            dVar3.mo407a();
        }
        this.f656d = dVar;
        long j = this.f657e;
        if (decrementAndGet() != 0) {
            mo511c();
        }
        if (j != 0) {
            dVar.mo408a(j);
        }
    }

    /* renamed from: a */
    public final void mo408a(long j) {
        if (C0310e.m837b(j) && !this.f662j) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                C0313c.m847a(this.f659g, j);
                mo509b();
                return;
            }
            long j2 = this.f657e;
            if (j2 != Long.MAX_VALUE) {
                long a = C0313c.m846a(j2, j);
                this.f657e = a;
                if (a == Long.MAX_VALUE) {
                    this.f662j = true;
                }
            }
            C3684d dVar = this.f656d;
            if (decrementAndGet() != 0) {
                mo511c();
            }
            if (dVar != null) {
                dVar.mo408a(j);
            }
        }
    }

    /* renamed from: b */
    public final void mo510b(long j) {
        if (!this.f662j) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                C0313c.m847a(this.f660h, j);
                mo509b();
                return;
            }
            long j2 = this.f657e;
            if (j2 != Long.MAX_VALUE) {
                long j3 = j2 - j;
                long j4 = 0;
                if (j3 < 0) {
                    C0310e.m838c(j3);
                } else {
                    j4 = j3;
                }
                this.f657e = j4;
            }
            if (decrementAndGet() != 0) {
                mo511c();
            }
        }
    }

    /* renamed from: a */
    public void mo407a() {
        if (!this.f661i) {
            this.f661i = true;
            mo509b();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo509b() {
        if (getAndIncrement() == 0) {
            mo511c();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final void mo511c() {
        C3684d dVar = null;
        long j = 0;
        int i = 1;
        do {
            C3684d dVar2 = (C3684d) this.f658f.get();
            if (dVar2 != null) {
                dVar2 = (C3684d) this.f658f.getAndSet(null);
            }
            long j2 = this.f659g.get();
            if (j2 != 0) {
                j2 = this.f659g.getAndSet(0);
            }
            long j3 = this.f660h.get();
            if (j3 != 0) {
                j3 = this.f660h.getAndSet(0);
            }
            C3684d dVar3 = this.f656d;
            if (this.f661i) {
                if (dVar3 != null) {
                    dVar3.mo407a();
                    this.f656d = null;
                }
                if (dVar2 != null) {
                    dVar2.mo407a();
                }
            } else {
                long j4 = this.f657e;
                if (j4 != Long.MAX_VALUE) {
                    j4 = C0313c.m846a(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        long j5 = j4 - j3;
                        if (j5 < 0) {
                            C0310e.m838c(j5);
                            j5 = 0;
                        }
                        j4 = j5;
                    }
                    this.f657e = j4;
                }
                if (dVar2 != null) {
                    if (dVar3 != null) {
                        dVar3.mo407a();
                    }
                    this.f656d = dVar2;
                    if (j4 != 0) {
                        j = C0313c.m846a(j, j4);
                        dVar = dVar2;
                    }
                } else if (!(dVar3 == null || j2 == 0)) {
                    j = C0313c.m846a(j, j2);
                    dVar = dVar3;
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
        if (j != 0) {
            dVar.mo408a(j);
        }
    }
}
