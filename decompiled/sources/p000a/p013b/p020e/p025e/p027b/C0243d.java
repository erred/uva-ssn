package p000a.p013b.p020e.p025e.p027b;

import java.util.concurrent.Callable;
import org.p153a.C3683c;
import p000a.p013b.C0330h;
import p000a.p013b.p018c.C0171b;
import p000a.p013b.p020e.p022b.C0204b;
import p000a.p013b.p020e.p034i.C0307b;

/* renamed from: a.b.e.e.b.d */
/* compiled from: FlowableError */
public final class C0243d<T> extends C0330h<T> {

    /* renamed from: b */
    final Callable<? extends Throwable> f457b;

    public C0243d(Callable<? extends Throwable> callable) {
        this.f457b = callable;
    }

    /* renamed from: b */
    public void mo419b(C3683c<? super T> cVar) {
        try {
            th = (Throwable) C0204b.m615a(this.f457b.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            C0171b.m584b(th);
        }
        C0307b.m808a(th, cVar);
    }
}
