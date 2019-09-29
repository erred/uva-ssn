package p102c;

/* renamed from: c.p */
/* compiled from: SegmentPool */
final class C1692p {

    /* renamed from: a */
    static C1691o f5330a;

    /* renamed from: b */
    static long f5331b;

    private C1692p() {
    }

    /* renamed from: a */
    static C1691o m7101a() {
        synchronized (C1692p.class) {
            if (f5330a == null) {
                return new C1691o();
            }
            C1691o oVar = f5330a;
            f5330a = oVar.f5328f;
            oVar.f5328f = null;
            f5331b -= 8192;
            return oVar;
        }
    }

    /* renamed from: a */
    static void m7102a(C1691o oVar) {
        if (oVar.f5328f != null || oVar.f5329g != null) {
            throw new IllegalArgumentException();
        } else if (!oVar.f5326d) {
            synchronized (C1692p.class) {
                if (f5331b + 8192 <= 65536) {
                    f5331b += 8192;
                    oVar.f5328f = f5330a;
                    oVar.f5325c = 0;
                    oVar.f5324b = 0;
                    f5330a = oVar;
                }
            }
        }
    }
}
