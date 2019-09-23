package p000a.p013b.p020e.p035j;

import java.util.concurrent.atomic.AtomicReference;
import p000a.p013b.p018c.C0166a;

/* renamed from: a.b.e.j.e */
/* compiled from: ExceptionHelper */
public final class C0315e {

    /* renamed from: a */
    public static final Throwable f669a = new C0316a();

    /* renamed from: a.b.e.j.e$a */
    /* compiled from: ExceptionHelper */
    static final class C0316a extends Throwable {
        public Throwable fillInStackTrace() {
            return this;
        }

        C0316a() {
            super("No further exceptions");
        }
    }

    /* renamed from: a */
    public static RuntimeException m852a(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            return (RuntimeException) th;
        } else {
            return new RuntimeException(th);
        }
    }

    /* renamed from: a */
    public static <T> boolean m854a(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        Throwable th3;
        do {
            th2 = (Throwable) atomicReference.get();
            if (th2 == f669a) {
                return false;
            }
            if (th2 == null) {
                th3 = th;
            } else {
                th3 = new C0166a(th2, th);
            }
        } while (!atomicReference.compareAndSet(th2, th3));
        return true;
    }

    /* renamed from: a */
    public static <T> Throwable m853a(AtomicReference<Throwable> atomicReference) {
        Throwable th = (Throwable) atomicReference.get();
        return th != f669a ? (Throwable) atomicReference.getAndSet(f669a) : th;
    }
}
