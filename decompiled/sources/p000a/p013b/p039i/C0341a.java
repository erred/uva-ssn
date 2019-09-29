package p000a.p013b.p039i;

import java.util.concurrent.atomic.AtomicReference;
import org.p153a.C3684d;
import p000a.p013b.C0344k;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p034i.C0310e;
import p000a.p013b.p020e.p035j.C0314d;

/* renamed from: a.b.i.a */
/* compiled from: DisposableSubscriber */
public abstract class C0341a<T> implements C0161b, C0344k<T> {
    final AtomicReference<C3684d> upstream = new AtomicReference<>();

    public final void onSubscribe(C3684d dVar) {
        if (C0314d.m851a(this.upstream, dVar, getClass())) {
            onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        ((C3684d) this.upstream.get()).mo408a(Long.MAX_VALUE);
    }

    /* access modifiers changed from: protected */
    public final void request(long j) {
        ((C3684d) this.upstream.get()).mo408a(j);
    }

    /* access modifiers changed from: protected */
    public final void cancel() {
        dispose();
    }

    public final boolean isDisposed() {
        return this.upstream.get() == C0310e.CANCELLED;
    }

    public final void dispose() {
        C0310e.m831a(this.upstream);
    }
}
