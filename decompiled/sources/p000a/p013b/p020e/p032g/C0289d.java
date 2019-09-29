package p000a.p013b.p020e.p032g;

import java.util.concurrent.ThreadFactory;
import p000a.p013b.C0350q;
import p000a.p013b.C0350q.C0352b;

/* renamed from: a.b.e.g.d */
/* compiled from: NewThreadScheduler */
public final class C0289d extends C0350q {

    /* renamed from: c */
    private static final C0291f f607c = new C0291f("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: b */
    final ThreadFactory f608b;

    public C0289d() {
        this(f607c);
    }

    public C0289d(ThreadFactory threadFactory) {
        this.f608b = threadFactory;
    }

    /* renamed from: a */
    public C0352b mo335a() {
        return new C0290e(this.f608b);
    }
}
