package androidx.constraintlayout.p060b.p061a;

import java.util.HashSet;
import java.util.Iterator;

/* renamed from: androidx.constraintlayout.b.a.p */
/* compiled from: ResolutionNode */
public class C0779p {

    /* renamed from: h */
    HashSet<C0779p> f2359h = new HashSet<>(2);

    /* renamed from: i */
    int f2360i = 0;

    /* renamed from: a */
    public void mo3149a() {
    }

    /* renamed from: a */
    public void mo3164a(C0779p pVar) {
        this.f2359h.add(pVar);
    }

    /* renamed from: b */
    public void mo3155b() {
        this.f2360i = 0;
        this.f2359h.clear();
    }

    /* renamed from: e */
    public void mo3165e() {
        this.f2360i = 0;
        Iterator it = this.f2359h.iterator();
        while (it.hasNext()) {
            ((C0779p) it.next()).mo3165e();
        }
    }

    /* renamed from: f */
    public void mo3166f() {
        this.f2360i = 1;
        Iterator it = this.f2359h.iterator();
        while (it.hasNext()) {
            ((C0779p) it.next()).mo3149a();
        }
    }

    /* renamed from: g */
    public boolean mo3167g() {
        return this.f2360i == 1;
    }
}
