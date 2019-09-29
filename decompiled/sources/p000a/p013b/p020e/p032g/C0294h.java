package p000a.p013b.p020e.p032g;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p021a.C0185a;

/* renamed from: a.b.e.g.h */
/* compiled from: ScheduledRunnable */
public final class C0294h extends AtomicReferenceArray<Object> implements C0161b, Runnable, Callable<Object> {

    /* renamed from: b */
    static final Object f614b = new Object();

    /* renamed from: c */
    static final Object f615c = new Object();

    /* renamed from: d */
    static final Object f616d = new Object();

    /* renamed from: e */
    static final Object f617e = new Object();

    /* renamed from: a */
    final Runnable f618a;

    public C0294h(Runnable runnable, C0185a aVar) {
        super(3);
        this.f618a = runnable;
        lazySet(0, aVar);
    }

    public Object call() {
        run();
        return null;
    }

    public void run() {
        Object obj;
        Object obj2;
        lazySet(2, Thread.currentThread());
        try {
            this.f618a.run();
        } catch (Throwable th) {
            lazySet(2, null);
            Object obj3 = get(0);
            if (!(obj3 == f614b || !compareAndSet(0, obj3, f617e) || obj3 == null)) {
                ((C0185a) obj3).mo356c(this);
            }
            do {
                obj2 = get(1);
                if (obj2 == f615c || obj2 == f616d) {
                    throw th;
                }
            } while (!compareAndSet(1, obj2, f617e));
            throw th;
        }
        lazySet(2, null);
        Object obj4 = get(0);
        if (!(obj4 == f614b || !compareAndSet(0, obj4, f617e) || obj4 == null)) {
            ((C0185a) obj4).mo356c(this);
        }
        do {
            obj = get(1);
            if (obj == f615c || obj == f616d) {
                return;
            }
        } while (!compareAndSet(1, obj, f617e));
    }

    /* renamed from: a */
    public void mo496a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj != f617e) {
                if (obj == f615c) {
                    future.cancel(false);
                    return;
                } else if (obj == f616d) {
                    future.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispose() {
        /*
            r5 = this;
        L_0x0000:
            r0 = 1
            java.lang.Object r1 = r5.get(r0)
            java.lang.Object r2 = f617e
            r3 = 0
            if (r1 == r2) goto L_0x0035
            java.lang.Object r2 = f615c
            if (r1 == r2) goto L_0x0035
            java.lang.Object r2 = f616d
            if (r1 != r2) goto L_0x0013
            goto L_0x0035
        L_0x0013:
            r2 = 2
            java.lang.Object r2 = r5.get(r2)
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            if (r2 == r4) goto L_0x0020
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            if (r2 == 0) goto L_0x0026
            java.lang.Object r4 = f616d
            goto L_0x0028
        L_0x0026:
            java.lang.Object r4 = f615c
        L_0x0028:
            boolean r0 = r5.compareAndSet(r0, r1, r4)
            if (r0 == 0) goto L_0x0000
            if (r1 == 0) goto L_0x0035
            java.util.concurrent.Future r1 = (java.util.concurrent.Future) r1
            r1.cancel(r2)
        L_0x0035:
            java.lang.Object r0 = r5.get(r3)
            java.lang.Object r1 = f617e
            if (r0 == r1) goto L_0x0052
            java.lang.Object r1 = f614b
            if (r0 == r1) goto L_0x0052
            if (r0 != 0) goto L_0x0044
            goto L_0x0052
        L_0x0044:
            java.lang.Object r1 = f614b
            boolean r1 = r5.compareAndSet(r3, r0, r1)
            if (r1 == 0) goto L_0x0035
            a.b.e.a.a r0 = (p000a.p013b.p020e.p021a.C0185a) r0
            r0.mo356c(r5)
            return
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p013b.p020e.p032g.C0294h.dispose():void");
    }
}
