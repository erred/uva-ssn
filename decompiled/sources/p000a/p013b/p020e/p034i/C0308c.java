package p000a.p013b.p020e.p034i;

import java.util.concurrent.atomic.AtomicInteger;
import org.p153a.C3683c;
import p000a.p013b.p020e.p023c.C0209d;

/* renamed from: a.b.e.i.c */
/* compiled from: ScalarSubscription */
public final class C0308c<T> extends AtomicInteger implements C0209d<T> {

    /* renamed from: a */
    final T f654a;

    /* renamed from: b */
    final C3683c<? super T> f655b;

    /* renamed from: a */
    public int mo382a(int i) {
        return i & 1;
    }

    public C0308c(C3683c<? super T> cVar, T t) {
        this.f655b = cVar;
        this.f654a = t;
    }

    /* renamed from: a */
    public void mo408a(long j) {
        if (C0310e.m837b(j) && compareAndSet(0, 1)) {
            C3683c<? super T> cVar = this.f655b;
            cVar.onNext(this.f654a);
            if (get() != 2) {
                cVar.onComplete();
            }
        }
    }

    /* renamed from: a */
    public void mo407a() {
        lazySet(2);
    }

    /* renamed from: a */
    public boolean mo383a(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    /* renamed from: e_ */
    public T mo386e_() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.f654a;
    }

    /* renamed from: b */
    public boolean mo384b() {
        return get() != 0;
    }

    /* renamed from: c */
    public void mo385c() {
        lazySet(1);
    }
}
