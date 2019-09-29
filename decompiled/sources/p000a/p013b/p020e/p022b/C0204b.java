package p000a.p013b.p020e.p022b;

import p000a.p013b.p019d.C0179c;

/* renamed from: a.b.e.b.b */
/* compiled from: ObjectHelper */
public final class C0204b {

    /* renamed from: a */
    static final C0179c<Object, Object> f408a = new C0205a();

    /* renamed from: a.b.e.b.b$a */
    /* compiled from: ObjectHelper */
    static final class C0205a implements C0179c<Object, Object> {
        C0205a() {
        }
    }

    /* renamed from: a */
    public static int m612a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    /* renamed from: a */
    public static int m614a(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    /* renamed from: a */
    public static <T> T m615a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* renamed from: a */
    public static boolean m616a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static int m613a(int i, String str) {
        if (i > 0) {
            return i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" > 0 required but it was ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
