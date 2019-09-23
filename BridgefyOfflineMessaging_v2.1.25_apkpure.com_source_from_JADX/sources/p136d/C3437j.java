package p136d;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p136d.C3404c.C3405a;

/* renamed from: d.j */
/* compiled from: Platform */
class C3437j {

    /* renamed from: a */
    private static final C3437j f8872a = m9956c();

    /* renamed from: d.j$a */
    /* compiled from: Platform */
    static class C3438a extends C3437j {

        /* renamed from: d.j$a$a */
        /* compiled from: Platform */
        static class C3439a implements Executor {

            /* renamed from: a */
            private final Handler f8873a = new Handler(Looper.getMainLooper());

            C3439a() {
            }

            public void execute(Runnable runnable) {
                this.f8873a.post(runnable);
            }
        }

        C3438a() {
        }

        /* renamed from: b */
        public Executor mo28257b() {
            return new C3439a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C3405a mo28254a(Executor executor) {
            return new C3411g(executor);
        }
    }

    /* renamed from: d.j$b */
    /* compiled from: Platform */
    static class C3440b extends C3437j {

        /* renamed from: d.j$b$a */
        /* compiled from: Platform */
        static class C3441a implements Executor {

            /* renamed from: a */
            private static Object f8874a;

            /* renamed from: b */
            private static Method f8875b;

            C3441a() {
            }

            static {
                try {
                    Class cls = Class.forName("org.robovm.apple.foundation.NSOperationQueue");
                    f8874a = cls.getDeclaredMethod("getMainQueue", new Class[0]).invoke(null, new Object[0]);
                    f8875b = cls.getDeclaredMethod("addOperation", new Class[]{Runnable.class});
                } catch (Exception e) {
                    throw new AssertionError(e);
                }
            }

            public void execute(Runnable runnable) {
                try {
                    f8875b.invoke(f8874a, new Object[]{runnable});
                } catch (IllegalAccessException | IllegalArgumentException e) {
                    throw new AssertionError(e);
                } catch (InvocationTargetException e2) {
                    Throwable cause = e2.getCause();
                    if (cause instanceof RuntimeException) {
                        throw ((RuntimeException) cause);
                    } else if (cause instanceof Error) {
                        throw ((Error) cause);
                    } else {
                        throw new RuntimeException(cause);
                    }
                }
            }
        }

        C3440b() {
        }

        /* renamed from: b */
        public Executor mo28257b() {
            return new C3441a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C3405a mo28254a(Executor executor) {
            return new C3411g(executor);
        }
    }

    @IgnoreJRERequirement
    /* renamed from: d.j$c */
    /* compiled from: Platform */
    static class C3442c extends C3437j {
        C3442c() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo28256a(Method method) {
            return method.isDefault();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public Object mo28255a(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            Constructor declaredConstructor = Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
            declaredConstructor.setAccessible(true);
            return ((Lookup) declaredConstructor.newInstance(new Object[]{cls, Integer.valueOf(-1)})).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo28256a(Method method) {
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Executor mo28257b() {
        return null;
    }

    C3437j() {
    }

    /* renamed from: a */
    static C3437j m9955a() {
        return f8872a;
    }

    /* renamed from: c */
    private static C3437j m9956c() {
        try {
            Class.forName("android.os.Build");
            if (VERSION.SDK_INT != 0) {
                return new C3438a();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new C3442c();
        } catch (ClassNotFoundException unused2) {
            try {
                Class.forName("org.robovm.apple.foundation.NSObject");
                return new C3440b();
            } catch (ClassNotFoundException unused3) {
                return new C3437j();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C3405a mo28254a(Executor executor) {
        if (executor != null) {
            return new C3411g(executor);
        }
        return C3409f.f8821a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Object mo28255a(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }
}
