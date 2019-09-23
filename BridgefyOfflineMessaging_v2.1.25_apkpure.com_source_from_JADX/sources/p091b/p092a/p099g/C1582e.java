package p091b.p092a.p099g;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: b.a.g.e */
/* compiled from: OptionalMethod */
class C1582e<T> {

    /* renamed from: a */
    private final Class<?> f4841a;

    /* renamed from: b */
    private final String f4842b;

    /* renamed from: c */
    private final Class[] f4843c;

    C1582e(Class<?> cls, String str, Class... clsArr) {
        this.f4841a = cls;
        this.f4842b = str;
        this.f4843c = clsArr;
    }

    /* renamed from: a */
    public boolean mo6441a(T t) {
        return m6433a(t.getClass()) != null;
    }

    /* renamed from: a */
    public Object mo6440a(T t, Object... objArr) throws InvocationTargetException {
        Method a = m6433a(t.getClass());
        if (a == null) {
            return null;
        }
        try {
            return a.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public Object mo6442b(T t, Object... objArr) {
        try {
            return mo6440a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: c */
    public Object mo6443c(T t, Object... objArr) throws InvocationTargetException {
        Method a = m6433a(t.getClass());
        if (a != null) {
            try {
                return a.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpectedly could not call: ");
                sb.append(a);
                AssertionError assertionError = new AssertionError(sb.toString());
                assertionError.initCause(e);
                throw assertionError;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Method ");
            sb2.append(this.f4842b);
            sb2.append(" not supported for object ");
            sb2.append(t);
            throw new AssertionError(sb2.toString());
        }
    }

    /* renamed from: d */
    public Object mo6444d(T t, Object... objArr) {
        try {
            return mo6443c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: a */
    private Method m6433a(Class<?> cls) {
        if (this.f4842b == null) {
            return null;
        }
        Method a = m6434a(cls, this.f4842b, this.f4843c);
        if (a == null || this.f4841a == null || this.f4841a.isAssignableFrom(a.getReturnType())) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private static Method m6434a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) != 0) {
                    return method;
                }
            } catch (NoSuchMethodException unused) {
                return method;
            }
        } catch (NoSuchMethodException unused2) {
        }
        return null;
    }
}
