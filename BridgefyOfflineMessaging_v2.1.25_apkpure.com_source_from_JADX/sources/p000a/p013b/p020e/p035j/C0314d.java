package p000a.p013b.p020e.p035j;

import java.util.concurrent.atomic.AtomicReference;
import org.p153a.C3684d;
import p000a.p013b.p018c.C0174e;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p020e.p034i.C0310e;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.e.j.d */
/* compiled from: EndConsumerHelper */
public final class C0314d {
    /* renamed from: a */
    public static boolean m851a(AtomicReference<C3684d> atomicReference, C3684d dVar, Class<?> cls) {
        C0204b.m615a(dVar, "next is null");
        if (atomicReference.compareAndSet(null, dVar)) {
            return true;
        }
        dVar.mo407a();
        if (atomicReference.get() != C0310e.CANCELLED) {
            m850a(cls);
        }
        return false;
    }

    /* renamed from: a */
    public static String m849a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("It is not allowed to subscribe with a(n) ");
        sb.append(str);
        sb.append(" multiple times. Please create a fresh instance of ");
        sb.append(str);
        sb.append(" and subscribe that to the target source instead.");
        return sb.toString();
    }

    /* renamed from: a */
    public static void m850a(Class<?> cls) {
        C0324a.m885a((Throwable) new C0174e(m849a(cls.getName())));
    }
}
