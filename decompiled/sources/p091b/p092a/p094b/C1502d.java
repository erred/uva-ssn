package p091b.p092a.p094b;

import java.util.LinkedHashSet;
import java.util.Set;
import p091b.C1601ae;

/* renamed from: b.a.b.d */
/* compiled from: RouteDatabase */
public final class C1502d {

    /* renamed from: a */
    private final Set<C1601ae> f4531a = new LinkedHashSet();

    /* renamed from: a */
    public synchronized void mo6243a(C1601ae aeVar) {
        this.f4531a.add(aeVar);
    }

    /* renamed from: b */
    public synchronized void mo6244b(C1601ae aeVar) {
        this.f4531a.remove(aeVar);
    }

    /* renamed from: c */
    public synchronized boolean mo6245c(C1601ae aeVar) {
        return this.f4531a.contains(aeVar);
    }
}
