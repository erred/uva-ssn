package p091b.p092a.p093a;

import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import p091b.C1590aa;
import p091b.C1596ac;
import p091b.C1596ac.C1597a;
import p091b.C1598ad;
import p091b.C1640s;
import p091b.C1640s.C1641a;
import p091b.C1645u;
import p091b.C1645u.C1646a;
import p091b.C1654y;
import p091b.p092a.C1483a;
import p091b.p092a.C1508c;
import p091b.p092a.p093a.C1487c.C1488a;
import p091b.p092a.p095c.C1517e;
import p091b.p092a.p095c.C1518f;
import p091b.p092a.p095c.C1520h;
import p102c.C1672c;
import p102c.C1675d;
import p102c.C1676e;
import p102c.C1683l;
import p102c.C1694r;
import p102c.C1695s;
import p102c.C1696t;
import twitter4j.HttpResponseCode;

/* renamed from: b.a.a.a */
/* compiled from: CacheInterceptor */
public final class C1484a implements C1645u {

    /* renamed from: a */
    final C1497f f4447a;

    public C1484a(C1497f fVar) {
        this.f4447a = fVar;
    }

    /* renamed from: a */
    public C1596ac mo6184a(C1646a aVar) throws IOException {
        C1596ac a = this.f4447a != null ? this.f4447a.mo6221a(aVar.mo6279a()) : null;
        C1487c a2 = new C1488a(System.currentTimeMillis(), aVar.mo6279a(), a).mo6190a();
        C1590aa aaVar = a2.f4453a;
        C1596ac acVar = a2.f4454b;
        if (this.f4447a != null) {
            this.f4447a.mo6223a(a2);
        }
        if (a != null && acVar == null) {
            C1508c.m6082a((Closeable) a.mo6487h());
        }
        if (aaVar == null && acVar == null) {
            return new C1597a().mo6498a(aVar.mo6279a()).mo6503a(C1654y.HTTP_1_1).mo6496a((int) HttpResponseCode.GATEWAY_TIMEOUT).mo6504a("Unsatisfiable Request (only-if-cached)").mo6500a(C1508c.f4562c).mo6497a(-1).mo6507b(System.currentTimeMillis()).mo6506a();
        }
        if (aaVar == null) {
            return acVar.mo6488i().mo6508b(m5953a(acVar)).mo6506a();
        }
        try {
            C1596ac a3 = aVar.mo6280a(aaVar);
            if (a3 == null && a != null) {
            }
            if (acVar != null) {
                if (a3.mo6481c() == 304) {
                    C1596ac a4 = acVar.mo6488i().mo6502a(m5954a(acVar.mo6486g(), a3.mo6486g())).mo6497a(a3.mo6493n()).mo6507b(a3.mo6494o()).mo6508b(m5953a(acVar)).mo6499a(m5953a(a3)).mo6506a();
                    a3.mo6487h().close();
                    this.f4447a.mo6222a();
                    this.f4447a.mo6224a(acVar, a4);
                    return a4;
                }
                C1508c.m6082a((Closeable) acVar.mo6487h());
            }
            C1596ac a5 = a3.mo6488i().mo6508b(m5953a(acVar)).mo6499a(m5953a(a3)).mo6506a();
            if (this.f4447a != null) {
                if (C1517e.m6126d(a5) && C1487c.m5962a(a5, aaVar)) {
                    return m5952a(this.f4447a.mo6220a(a5), a5);
                }
                if (C1518f.m6128a(aaVar.mo6456b())) {
                    try {
                        this.f4447a.mo6225b(aaVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return a5;
        } finally {
            if (a != null) {
                C1508c.m6082a((Closeable) a.mo6487h());
            }
        }
    }

    /* renamed from: a */
    private static C1596ac m5953a(C1596ac acVar) {
        return (acVar == null || acVar.mo6487h() == null) ? acVar : acVar.mo6488i().mo6500a((C1598ad) null).mo6506a();
    }

    /* renamed from: a */
    private C1596ac m5952a(final C1486b bVar, C1596ac acVar) throws IOException {
        if (bVar == null) {
            return acVar;
        }
        C1694r b = bVar.mo6189b();
        if (b == null) {
            return acVar;
        }
        final C1676e c = acVar.mo6487h().mo6292c();
        final C1675d a = C1683l.m7032a(b);
        C14851 r2 = new C1695s() {

            /* renamed from: a */
            boolean f4448a;

            /* renamed from: a */
            public long mo6185a(C1672c cVar, long j) throws IOException {
                try {
                    long a = c.mo6185a(cVar, j);
                    if (a == -1) {
                        if (!this.f4448a) {
                            this.f4448a = true;
                            a.close();
                        }
                        return -1;
                    }
                    cVar.mo6811a(a.mo6829c(), cVar.mo6823b() - a, a);
                    a.mo6874w();
                    return a;
                } catch (IOException e) {
                    if (!this.f4448a) {
                        this.f4448a = true;
                        bVar.mo6188a();
                    }
                    throw e;
                }
            }

            /* renamed from: a */
            public C1696t mo6186a() {
                return c.mo6186a();
            }

            public void close() throws IOException {
                if (!this.f4448a && !C1508c.m6084a((C1695s) this, 100, TimeUnit.MILLISECONDS)) {
                    this.f4448a = true;
                    bVar.mo6188a();
                }
                c.close();
            }
        };
        return acVar.mo6488i().mo6500a((C1598ad) new C1520h(acVar.mo6478a(HttpHeaders.CONTENT_TYPE), acVar.mo6487h().mo6291b(), C1683l.m7033a((C1695s) r2))).mo6506a();
    }

    /* renamed from: a */
    private static C1640s m5954a(C1640s sVar, C1640s sVar2) {
        C1641a aVar = new C1641a();
        int a = sVar.mo6643a();
        for (int i = 0; i < a; i++) {
            String a2 = sVar.mo6644a(i);
            String b = sVar.mo6647b(i);
            if ((!HttpHeaders.WARNING.equalsIgnoreCase(a2) || !b.startsWith("1")) && (m5956b(a2) || !m5955a(a2) || sVar2.mo6645a(a2) == null)) {
                C1483a.f4446a.mo6180a(aVar, a2, b);
            }
        }
        int a3 = sVar2.mo6643a();
        for (int i2 = 0; i2 < a3; i2++) {
            String a4 = sVar2.mo6644a(i2);
            if (!m5956b(a4) && m5955a(a4)) {
                C1483a.f4446a.mo6180a(aVar, a4, sVar2.mo6647b(i2));
            }
        }
        return aVar.mo6654a();
    }

    /* renamed from: a */
    static boolean m5955a(String str) {
        return !HttpHeaders.CONNECTION.equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(str) && !HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) && !HttpHeaders.f6789TE.equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !HttpHeaders.TRANSFER_ENCODING.equalsIgnoreCase(str) && !HttpHeaders.UPGRADE.equalsIgnoreCase(str);
    }

    /* renamed from: b */
    static boolean m5956b(String str) {
        return HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(str) || HttpHeaders.CONTENT_ENCODING.equalsIgnoreCase(str) || HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(str);
    }
}
