package androidx.core.p069f;

/* renamed from: androidx.core.f.e */
/* compiled from: Preconditions */
public class C0930e {
    /* renamed from: a */
    public static <T> T m3403a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static <T> T m3404a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* renamed from: a */
    public static int m3402a(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }
}
