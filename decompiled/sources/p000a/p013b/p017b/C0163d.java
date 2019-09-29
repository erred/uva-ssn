package p000a.p013b.p017b;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.p020e.p022b.C0204b;

/* renamed from: a.b.b.d */
/* compiled from: ReferenceDisposable */
abstract class C0163d<T> extends AtomicReference<T> implements C0161b {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo357a(T t);

    C0163d(T t) {
        super(C0204b.m615a(t, "value is null"));
    }

    public final void dispose() {
        if (get() != null) {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                mo357a(andSet);
            }
        }
    }

    /* renamed from: a */
    public final boolean mo358a() {
        return get() == null;
    }
}
