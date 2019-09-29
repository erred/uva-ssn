package p000a.p013b.p020e.p025e.p027b;

import java.util.concurrent.Callable;
import org.p153a.C3682b;
import org.p153a.C3683c;
import p000a.p013b.C0330h;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p019d.C0181e;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p020e.p034i.C0307b;
import p000a.p013b.p020e.p034i.C0308c;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.e.e.b.h */
/* compiled from: FlowableScalarXMap */
public final class C0253h {

    /* renamed from: a.b.e.e.b.h$a */
    /* compiled from: FlowableScalarXMap */
    static final class C0254a<T, R> extends C0330h<R> {

        /* renamed from: b */
        final T f499b;

        /* renamed from: c */
        final C0181e<? super T, ? extends C3682b<? extends R>> f500c;

        C0254a(T t, C0181e<? super T, ? extends C3682b<? extends R>> eVar) {
            this.f499b = t;
            this.f500c = eVar;
        }

        /* renamed from: b */
        public void mo419b(C3683c<? super R> cVar) {
            try {
                C3682b bVar = (C3682b) C0204b.m615a(this.f500c.apply(this.f499b), "The mapper returned a null Publisher");
                if (bVar instanceof Callable) {
                    try {
                        Object call = ((Callable) bVar).call();
                        if (call == null) {
                            C0307b.m809a(cVar);
                            return;
                        }
                        cVar.onSubscribe(new C0308c(cVar, call));
                    } catch (Throwable th) {
                        C0171b.m584b(th);
                        C0307b.m808a(th, cVar);
                    }
                } else {
                    bVar.mo538a(cVar);
                }
            } catch (Throwable th2) {
                C0307b.m808a(th2, cVar);
            }
        }
    }

    /* renamed from: a */
    public static <T, R> boolean m697a(C3682b<T> bVar, C3683c<? super R> cVar, C0181e<? super T, ? extends C3682b<? extends R>> eVar) {
        if (!(bVar instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) bVar).call();
            if (call == null) {
                C0307b.m809a(cVar);
                return true;
            }
            try {
                C3682b bVar2 = (C3682b) C0204b.m615a(eVar.apply(call), "The mapper returned a null Publisher");
                if (bVar2 instanceof Callable) {
                    try {
                        Object call2 = ((Callable) bVar2).call();
                        if (call2 == null) {
                            C0307b.m809a(cVar);
                            return true;
                        }
                        cVar.onSubscribe(new C0308c(cVar, call2));
                    } catch (Throwable th) {
                        C0171b.m584b(th);
                        C0307b.m808a(th, cVar);
                        return true;
                    }
                } else {
                    bVar2.mo538a(cVar);
                }
                return true;
            } catch (Throwable th2) {
                C0171b.m584b(th2);
                C0307b.m808a(th2, cVar);
                return true;
            }
        } catch (Throwable th3) {
            C0171b.m584b(th3);
            C0307b.m808a(th3, cVar);
            return true;
        }
    }

    /* renamed from: a */
    public static <T, U> C0330h<U> m696a(T t, C0181e<? super T, ? extends C3682b<? extends U>> eVar) {
        return C0324a.m873a((C0330h<T>) new C0254a<T>(t, eVar));
    }
}
