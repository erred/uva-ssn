package p000a.p013b.p020e.p025e.p026a;

import java.util.concurrent.atomic.AtomicInteger;
import p000a.p013b.C0159b;
import p000a.p013b.C0176d;
import p000a.p013b.C0323f;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p020e.p021a.C0189e;

/* renamed from: a.b.e.e.a.a */
/* compiled from: CompletableConcatArray */
public final class C0217a extends C0159b {

    /* renamed from: a */
    final C0323f[] f415a;

    /* renamed from: a.b.e.e.a.a$a */
    /* compiled from: CompletableConcatArray */
    static final class C0218a extends AtomicInteger implements C0176d {

        /* renamed from: a */
        final C0176d f416a;

        /* renamed from: b */
        final C0323f[] f417b;

        /* renamed from: c */
        int f418c;

        /* renamed from: d */
        final C0189e f419d = new C0189e();

        C0218a(C0176d dVar, C0323f[] fVarArr) {
            this.f416a = dVar;
            this.f417b = fVarArr;
        }

        public void onSubscribe(C0161b bVar) {
            this.f419d.mo389a(bVar);
        }

        public void onError(Throwable th) {
            this.f416a.onError(th);
        }

        public void onComplete() {
            mo409a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo409a() {
            if (!this.f419d.mo388a() && getAndIncrement() == 0) {
                C0323f[] fVarArr = this.f417b;
                while (!this.f419d.mo388a()) {
                    int i = this.f418c;
                    this.f418c = i + 1;
                    if (i == fVarArr.length) {
                        this.f416a.onComplete();
                        return;
                    }
                    fVarArr[i].mo345a(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    public C0217a(C0323f[] fVarArr) {
        this.f415a = fVarArr;
    }

    /* renamed from: b */
    public void mo349b(C0176d dVar) {
        C0218a aVar = new C0218a(dVar, this.f415a);
        dVar.onSubscribe(aVar.f419d);
        aVar.mo409a();
    }
}
