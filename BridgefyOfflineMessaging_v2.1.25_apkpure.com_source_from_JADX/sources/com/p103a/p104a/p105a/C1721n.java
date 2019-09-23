package com.p103a.p104a.p105a;

import java.util.HashSet;
import java.util.Set;

/* renamed from: com.a.a.a.n */
/* compiled from: SamplingEventFilter */
class C1721n implements C1717j {

    /* renamed from: b */
    static final Set<C1730b> f5392b = new HashSet<C1730b>() {
        {
            add(C1730b.START);
            add(C1730b.RESUME);
            add(C1730b.PAUSE);
            add(C1730b.STOP);
        }
    };

    /* renamed from: a */
    final int f5393a;

    public C1721n(int i) {
        this.f5393a = i;
    }

    /* renamed from: a */
    public boolean mo6975a(C1727s sVar) {
        boolean z = f5392b.contains(sVar.f5403c) && sVar.f5401a.f5432g == null;
        boolean z2 = Math.abs(sVar.f5401a.f5428c.hashCode() % this.f5393a) != 0;
        if (!z || !z2) {
            return false;
        }
        return true;
    }
}
