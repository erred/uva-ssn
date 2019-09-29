package p136d;

import p091b.C1596ac;
import p091b.C1598ad;
import p091b.C1640s;

/* renamed from: d.l */
/* compiled from: Response */
public final class C3445l<T> {

    /* renamed from: a */
    private final C1596ac f8889a;

    /* renamed from: b */
    private final T f8890b;

    /* renamed from: c */
    private final C1598ad f8891c;

    /* renamed from: a */
    public static <T> C3445l<T> m9982a(T t, C1596ac acVar) {
        if (acVar == null) {
            throw new NullPointerException("rawResponse == null");
        } else if (acVar.mo6483d()) {
            return new C3445l<>(acVar, t, null);
        } else {
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
    }

    /* renamed from: a */
    public static <T> C3445l<T> m9981a(C1598ad adVar, C1596ac acVar) {
        if (adVar == null) {
            throw new NullPointerException("body == null");
        } else if (acVar == null) {
            throw new NullPointerException("rawResponse == null");
        } else if (!acVar.mo6483d()) {
            return new C3445l<>(acVar, null, adVar);
        } else {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
    }

    private C3445l(C1596ac acVar, T t, C1598ad adVar) {
        this.f8889a = acVar;
        this.f8890b = t;
        this.f8891c = adVar;
    }

    /* renamed from: a */
    public int mo28269a() {
        return this.f8889a.mo6481c();
    }

    /* renamed from: b */
    public C1640s mo28270b() {
        return this.f8889a.mo6486g();
    }

    /* renamed from: c */
    public boolean mo28271c() {
        return this.f8889a.mo6483d();
    }

    /* renamed from: d */
    public T mo28272d() {
        return this.f8890b;
    }

    /* renamed from: e */
    public C1598ad mo28273e() {
        return this.f8891c;
    }
}
