package p091b.p092a.p097e;

import p091b.p092a.C1508c;
import p102c.C1677f;

/* renamed from: b.a.e.c */
/* compiled from: Header */
public final class C1536c {

    /* renamed from: a */
    public static final C1677f f4648a = C1677f.m6985a(":");

    /* renamed from: b */
    public static final C1677f f4649b = C1677f.m6985a(":status");

    /* renamed from: c */
    public static final C1677f f4650c = C1677f.m6985a(":method");

    /* renamed from: d */
    public static final C1677f f4651d = C1677f.m6985a(":path");

    /* renamed from: e */
    public static final C1677f f4652e = C1677f.m6985a(":scheme");

    /* renamed from: f */
    public static final C1677f f4653f = C1677f.m6985a(":authority");

    /* renamed from: g */
    public final C1677f f4654g;

    /* renamed from: h */
    public final C1677f f4655h;

    /* renamed from: i */
    final int f4656i;

    public C1536c(String str, String str2) {
        this(C1677f.m6985a(str), C1677f.m6985a(str2));
    }

    public C1536c(C1677f fVar, String str) {
        this(fVar, C1677f.m6985a(str));
    }

    public C1536c(C1677f fVar, C1677f fVar2) {
        this.f4654g = fVar;
        this.f4655h = fVar2;
        this.f4656i = fVar.mo6902h() + 32 + fVar2.mo6902h();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C1536c)) {
            return false;
        }
        C1536c cVar = (C1536c) obj;
        if (this.f4654g.equals(cVar.f4654g) && this.f4655h.equals(cVar.f4655h)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((527 + this.f4654g.hashCode()) * 31) + this.f4655h.hashCode();
    }

    public String toString() {
        return C1508c.m6075a("%s: %s", this.f4654g.mo6888a(), this.f4655h.mo6888a());
    }
}
