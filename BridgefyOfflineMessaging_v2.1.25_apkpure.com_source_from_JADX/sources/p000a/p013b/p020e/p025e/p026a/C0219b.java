package p000a.p013b.p020e.p025e.p026a;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.C0159b;
import p000a.p013b.C0165c;
import p000a.p013b.C0176d;
import p000a.p013b.C0184e;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p020e.p021a.C0186b;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.e.e.a.b */
/* compiled from: CompletableCreate */
public final class C0219b extends C0159b {

    /* renamed from: a */
    final C0184e f420a;

    /* renamed from: a.b.e.e.a.b$a */
    /* compiled from: CompletableCreate */
    static final class C0220a extends AtomicReference<C0161b> implements C0161b, C0165c {

        /* renamed from: a */
        final C0176d f421a;

        C0220a(C0176d dVar) {
            this.f421a = dVar;
        }

        /* renamed from: a */
        public void mo361a() {
            if (get() != C0186b.DISPOSED) {
                C0161b bVar = (C0161b) getAndSet(C0186b.DISPOSED);
                if (bVar != C0186b.DISPOSED) {
                    try {
                        this.f421a.onComplete();
                    } finally {
                        if (bVar != null) {
                            bVar.dispose();
                        }
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo362a(Throwable th) {
            if (!mo364b(th)) {
                C0324a.m885a(th);
            }
        }

        /* renamed from: b */
        public boolean mo364b(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (get() != C0186b.DISPOSED) {
                C0161b bVar = (C0161b) getAndSet(C0186b.DISPOSED);
                if (bVar != C0186b.DISPOSED) {
                    try {
                        this.f421a.onError(th);
                        return true;
                    } finally {
                        if (bVar != null) {
                            bVar.dispose();
                        }
                    }
                }
            }
            return false;
        }

        public void dispose() {
            C0186b.m592a((AtomicReference<C0161b>) this);
        }

        /* renamed from: b */
        public boolean mo363b() {
            return C0186b.m590a((C0161b) get());
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }

    public C0219b(C0184e eVar) {
        this.f420a = eVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo349b(C0176d dVar) {
        C0220a aVar = new C0220a(dVar);
        dVar.onSubscribe(aVar);
        try {
            this.f420a.subscribe(aVar);
        } catch (Throwable th) {
            C0171b.m584b(th);
            aVar.mo362a(th);
        }
    }
}
