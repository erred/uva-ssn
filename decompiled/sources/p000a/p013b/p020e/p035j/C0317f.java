package p000a.p013b.p020e.p035j;

import java.util.concurrent.atomic.AtomicInteger;
import org.p153a.C3683c;
import p000a.p013b.p036f.C0324a;

/* renamed from: a.b.e.j.f */
/* compiled from: HalfSerializer */
public final class C0317f {
    /* renamed from: a */
    public static <T> void m855a(C3683c<? super T> cVar, T t, AtomicInteger atomicInteger, C0312b bVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            cVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable a = bVar.mo515a();
                if (a != null) {
                    cVar.onError(a);
                } else {
                    cVar.onComplete();
                }
            }
        }
    }

    /* renamed from: a */
    public static void m856a(C3683c<?> cVar, Throwable th, AtomicInteger atomicInteger, C0312b bVar) {
        if (!bVar.mo516a(th)) {
            C0324a.m885a(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            cVar.onError(bVar.mo515a());
        }
    }

    /* renamed from: a */
    public static void m857a(C3683c<?> cVar, AtomicInteger atomicInteger, C0312b bVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable a = bVar.mo515a();
            if (a != null) {
                cVar.onError(a);
            } else {
                cVar.onComplete();
            }
        }
    }
}
