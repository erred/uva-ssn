package p000a.p013b.p020e.p025e.p027b;

import org.p153a.C3682b;
import org.p153a.C3683c;
import org.p153a.C3684d;
import p000a.p013b.C0330h;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p019d.C0181e;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p020e.p034i.C0307b;
import p000a.p013b.p037g.C0326a;
import p000a.p013b.p037g.C0328c;
import p000a.p013b.p039i.C0342b;

/* renamed from: a.b.e.e.b.g */
/* compiled from: FlowableRetryWhen */
public final class C0251g<T> extends C0232a<T, T> {

    /* renamed from: c */
    final C0181e<? super C0330h<Throwable>, ? extends C3682b<?>> f498c;

    /* renamed from: a.b.e.e.b.g$a */
    /* compiled from: FlowableRetryWhen */
    static final class C0252a<T> extends C0250c<T, Throwable> {
        C0252a(C3683c<? super T> cVar, C0326a<Throwable> aVar, C3684d dVar) {
            super(cVar, aVar, dVar);
        }

        public void onError(Throwable th) {
            mo446a(th);
        }

        public void onComplete() {
            this.f496c.mo407a();
            this.f494a.onComplete();
        }
    }

    public C0251g(C0330h<T> hVar, C0181e<? super C0330h<Throwable>, ? extends C3682b<?>> eVar) {
        super(hVar);
        this.f498c = eVar;
    }

    /* renamed from: b */
    public void mo419b(C3683c<? super T> cVar) {
        C0342b bVar = new C0342b(cVar);
        C0326a c = C0328c.m898a(8).mo528c();
        try {
            C3682b bVar2 = (C3682b) C0204b.m615a(this.f498c.apply(c), "handler returned a null Publisher");
            C0249b bVar3 = new C0249b(this.f442b);
            C0252a aVar = new C0252a(bVar, c, bVar3);
            bVar3.f493d = aVar;
            cVar.onSubscribe(aVar);
            bVar2.mo538a(bVar3);
            bVar3.onNext(Integer.valueOf(0));
        } catch (Throwable th) {
            C0171b.m584b(th);
            C0307b.m808a(th, cVar);
        }
    }
}
