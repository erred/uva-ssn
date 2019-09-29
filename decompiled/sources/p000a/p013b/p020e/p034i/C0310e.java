package p000a.p013b.p020e.p034i;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.p153a.C3684d;
import p000a.p013b.p018c.C0174e;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p020e.p035j.C0313c;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.e.i.e */
/* compiled from: SubscriptionHelper */
public enum C0310e implements C3684d {
    CANCELLED;

    /* renamed from: a */
    public void mo407a() {
    }

    /* renamed from: a */
    public void mo408a(long j) {
    }

    /* renamed from: a */
    public static boolean m835a(C3684d dVar, C3684d dVar2) {
        if (dVar2 == null) {
            C0324a.m885a((Throwable) new NullPointerException("next is null"));
            return false;
        } else if (dVar == null) {
            return true;
        } else {
            dVar2.mo407a();
            m836b();
            return false;
        }
    }

    /* renamed from: b */
    public static void m836b() {
        C0324a.m885a((Throwable) new C0174e("Subscription already set!"));
    }

    /* renamed from: b */
    public static boolean m837b(long j) {
        if (j > 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("n > 0 required but it was ");
        sb.append(j);
        C0324a.m885a((Throwable) new IllegalArgumentException(sb.toString()));
        return false;
    }

    /* renamed from: c */
    public static void m838c(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("More produced than requested: ");
        sb.append(j);
        C0324a.m885a((Throwable) new C0174e(sb.toString()));
    }

    /* renamed from: a */
    public static boolean m834a(C3684d dVar) {
        return dVar == CANCELLED;
    }

    /* renamed from: a */
    public static boolean m833a(AtomicReference<C3684d> atomicReference, C3684d dVar) {
        C0204b.m615a(dVar, "s is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.mo407a();
        if (atomicReference.get() != CANCELLED) {
            m836b();
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m831a(AtomicReference<C3684d> atomicReference) {
        if (((C3684d) atomicReference.get()) != CANCELLED) {
            C3684d dVar = (C3684d) atomicReference.getAndSet(CANCELLED);
            if (dVar != CANCELLED) {
                if (dVar != null) {
                    dVar.mo407a();
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m832a(AtomicReference<C3684d> atomicReference, AtomicLong atomicLong, C3684d dVar) {
        if (!m833a(atomicReference, dVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0);
        if (andSet != 0) {
            dVar.mo408a(andSet);
        }
        return true;
    }

    /* renamed from: a */
    public static void m830a(AtomicReference<C3684d> atomicReference, AtomicLong atomicLong, long j) {
        C3684d dVar = (C3684d) atomicReference.get();
        if (dVar != null) {
            dVar.mo408a(j);
        } else if (m837b(j)) {
            C0313c.m847a(atomicLong, j);
            C3684d dVar2 = (C3684d) atomicReference.get();
            if (dVar2 != null) {
                long andSet = atomicLong.getAndSet(0);
                if (andSet != 0) {
                    dVar2.mo408a(andSet);
                }
            }
        }
    }
}
