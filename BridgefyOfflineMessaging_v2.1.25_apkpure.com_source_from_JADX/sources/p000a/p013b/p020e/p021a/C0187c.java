package p000a.p013b.p020e.p021a;

import p000a.p013b.C0176d;
import p000a.p013b.p020e.p023c.C0207b;

/* renamed from: a.b.e.a.c */
/* compiled from: EmptyDisposable */
public enum C0187c implements C0207b<Object> {
    INSTANCE,
    NEVER;

    /* renamed from: a */
    public int mo382a(int i) {
        return i & 2;
    }

    /* renamed from: b */
    public boolean mo384b() {
        return true;
    }

    /* renamed from: c */
    public void mo385c() {
    }

    public void dispose() {
    }

    /* renamed from: e_ */
    public Object mo386e_() throws Exception {
        return null;
    }

    /* renamed from: a */
    public static void m596a(C0176d dVar) {
        dVar.onSubscribe(INSTANCE);
        dVar.onComplete();
    }

    /* renamed from: a */
    public boolean mo383a(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
