package p000a.p013b.p020e.p021a;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p018c.C0174e;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.e.a.b */
/* compiled from: DisposableHelper */
public enum C0186b implements C0161b {
    DISPOSED;

    public void dispose() {
    }

    /* renamed from: a */
    public static boolean m590a(C0161b bVar) {
        return bVar == DISPOSED;
    }

    /* renamed from: a */
    public static boolean m593a(AtomicReference<C0161b> atomicReference, C0161b bVar) {
        C0204b.m615a(bVar, "d is null");
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() != DISPOSED) {
            m589a();
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m594b(AtomicReference<C0161b> atomicReference, C0161b bVar) {
        C0161b bVar2;
        do {
            bVar2 = (C0161b) atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar != null) {
                    bVar.dispose();
                }
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        return true;
    }

    /* renamed from: a */
    public static boolean m592a(AtomicReference<C0161b> atomicReference) {
        C0161b bVar = (C0161b) atomicReference.get();
        C0186b bVar2 = DISPOSED;
        if (bVar != bVar2) {
            C0161b bVar3 = (C0161b) atomicReference.getAndSet(bVar2);
            if (bVar3 != bVar2) {
                if (bVar3 != null) {
                    bVar3.dispose();
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m591a(C0161b bVar, C0161b bVar2) {
        if (bVar2 == null) {
            C0324a.m885a((Throwable) new NullPointerException("next is null"));
            return false;
        } else if (bVar == null) {
            return true;
        } else {
            bVar2.dispose();
            m589a();
            return false;
        }
    }

    /* renamed from: a */
    public static void m589a() {
        C0324a.m885a((Throwable) new C0174e("Disposable already set!"));
    }

    /* renamed from: c */
    public static boolean m595c(AtomicReference<C0161b> atomicReference, C0161b bVar) {
        if (atomicReference.compareAndSet(null, bVar)) {
            return true;
        }
        if (atomicReference.get() == DISPOSED) {
            bVar.dispose();
        }
        return false;
    }
}
