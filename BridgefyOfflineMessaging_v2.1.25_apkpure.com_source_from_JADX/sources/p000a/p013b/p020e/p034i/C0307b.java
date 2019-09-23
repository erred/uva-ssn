package p000a.p013b.p020e.p034i;

import org.p153a.C3683c;
import p000a.p013b.p020e.p023c.C0209d;

/* renamed from: a.b.e.i.b */
/* compiled from: EmptySubscription */
public enum C0307b implements C0209d<Object> {
    INSTANCE;

    /* renamed from: a */
    public int mo382a(int i) {
        return i & 2;
    }

    /* renamed from: a */
    public void mo407a() {
    }

    /* renamed from: b */
    public boolean mo384b() {
        return true;
    }

    /* renamed from: c */
    public void mo385c() {
    }

    /* renamed from: e_ */
    public Object mo386e_() {
        return null;
    }

    public String toString() {
        return "EmptySubscription";
    }

    /* renamed from: a */
    public void mo408a(long j) {
        C0310e.m837b(j);
    }

    /* renamed from: a */
    public static void m808a(Throwable th, C3683c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onError(th);
    }

    /* renamed from: a */
    public static void m809a(C3683c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onComplete();
    }

    /* renamed from: a */
    public boolean mo383a(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
