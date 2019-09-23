package p000a.p013b.p018c;

import p000a.p013b.p020e.p035j.C0315e;

/* renamed from: a.b.c.b */
/* compiled from: Exceptions */
public final class C0171b {
    /* renamed from: a */
    public static RuntimeException m583a(Throwable th) {
        throw C0315e.m852a(th);
    }

    /* renamed from: b */
    public static void m584b(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        } else if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        } else if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }
}
