package p091b.p092a.p094b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: b.a.b.e */
/* compiled from: RouteException */
public final class C1503e extends RuntimeException {

    /* renamed from: a */
    private static final Method f4532a;

    /* renamed from: b */
    private IOException f4533b;

    static {
        Method method;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception unused) {
            method = null;
        }
        f4532a = method;
    }

    public C1503e(IOException iOException) {
        super(iOException);
        this.f4533b = iOException;
    }

    /* renamed from: a */
    public IOException mo6246a() {
        return this.f4533b;
    }

    /* renamed from: a */
    public void mo6247a(IOException iOException) {
        m6035a(iOException, this.f4533b);
        this.f4533b = iOException;
    }

    /* renamed from: a */
    private void m6035a(IOException iOException, IOException iOException2) {
        if (f4532a != null) {
            try {
                f4532a.invoke(iOException, new Object[]{iOException2});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
