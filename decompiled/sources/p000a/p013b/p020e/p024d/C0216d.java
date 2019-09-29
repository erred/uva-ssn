package p000a.p013b.p020e.p024d;

import org.p153a.C3683c;
import org.p153a.C3684d;
import p000a.p013b.C0176d;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p021a.C0186b;

/* renamed from: a.b.e.d.d */
/* compiled from: SubscriberCompletableObserver */
public final class C0216d<T> implements C0176d, C3684d {

    /* renamed from: a */
    final C3683c<? super T> f413a;

    /* renamed from: b */
    C0161b f414b;

    /* renamed from: a */
    public void mo408a(long j) {
    }

    public C0216d(C3683c<? super T> cVar) {
        this.f413a = cVar;
    }

    public void onComplete() {
        this.f413a.onComplete();
    }

    public void onError(Throwable th) {
        this.f413a.onError(th);
    }

    public void onSubscribe(C0161b bVar) {
        if (C0186b.m591a(this.f414b, bVar)) {
            this.f414b = bVar;
            this.f413a.onSubscribe(this);
        }
    }

    /* renamed from: a */
    public void mo407a() {
        this.f414b.dispose();
    }
}
