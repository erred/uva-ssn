package p091b.p092a.p095c;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import p091b.C1590aa;
import p091b.C1596ac;
import p091b.C1596ac.C1597a;
import p091b.C1645u;
import p091b.C1645u.C1646a;
import p091b.p092a.C1508c;
import p091b.p092a.p094b.C1501c;
import p091b.p092a.p094b.C1506g;
import p102c.C1672c;
import p102c.C1675d;
import p102c.C1678g;
import p102c.C1683l;
import p102c.C1694r;

/* renamed from: b.a.c.b */
/* compiled from: CallServerInterceptor */
public final class C1512b implements C1645u {

    /* renamed from: a */
    private final boolean f4581a;

    /* renamed from: b.a.c.b$a */
    /* compiled from: CallServerInterceptor */
    static final class C1513a extends C1678g {

        /* renamed from: a */
        long f4582a;

        C1513a(C1694r rVar) {
            super(rVar);
        }

        /* renamed from: a_ */
        public void mo6217a_(C1672c cVar, long j) throws IOException {
            super.mo6217a_(cVar, j);
            this.f4582a += j;
        }
    }

    public C1512b(boolean z) {
        this.f4581a = z;
    }

    /* renamed from: a */
    public C1596ac mo6184a(C1646a aVar) throws IOException {
        C1596ac acVar;
        C1519g gVar = (C1519g) aVar;
        C1514c g = gVar.mo6287g();
        C1506g f = gVar.mo6286f();
        C1501c cVar = (C1501c) gVar.mo6285e();
        C1590aa a = gVar.mo6279a();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.mo6289i().mo6624c(gVar.mo6288h());
        g.mo6274a(a);
        gVar.mo6289i().mo6611a(gVar.mo6288h(), a);
        C1597a aVar2 = null;
        if (C1518f.m6130c(a.mo6456b()) && a.mo6459d() != null) {
            if ("100-continue".equalsIgnoreCase(a.mo6455a(HttpHeaders.EXPECT))) {
                g.mo6273a();
                gVar.mo6289i().mo6626e(gVar.mo6288h());
                aVar2 = g.mo6270a(true);
            }
            if (aVar2 == null) {
                gVar.mo6289i().mo6625d(gVar.mo6288h());
                C1513a aVar3 = new C1513a(g.mo6272a(a, a.mo6459d().mo6476c()));
                C1675d a2 = C1683l.m7032a((C1694r) aVar3);
                a.mo6459d().mo6474a(a2);
                a2.close();
                gVar.mo6289i().mo6610a(gVar.mo6288h(), aVar3.f4582a);
            } else if (!cVar.mo6241e()) {
                f.mo6263e();
            }
        }
        g.mo6275b();
        if (aVar2 == null) {
            gVar.mo6289i().mo6626e(gVar.mo6288h());
            aVar2 = g.mo6270a(false);
        }
        C1596ac a3 = aVar2.mo6498a(a).mo6501a(f.mo6261c().mo6240d()).mo6497a(currentTimeMillis).mo6507b(System.currentTimeMillis()).mo6506a();
        int c = a3.mo6481c();
        if (c == 100) {
            a3 = g.mo6270a(false).mo6498a(a).mo6501a(f.mo6261c().mo6240d()).mo6497a(currentTimeMillis).mo6507b(System.currentTimeMillis()).mo6506a();
            c = a3.mo6481c();
        }
        gVar.mo6289i().mo6612a(gVar.mo6288h(), a3);
        if (!this.f4581a || c != 101) {
            acVar = a3.mo6488i().mo6500a(g.mo6271a(a3)).mo6506a();
        } else {
            acVar = a3.mo6488i().mo6500a(C1508c.f4562c).mo6506a();
        }
        if ("close".equalsIgnoreCase(acVar.mo6477a().mo6455a(HttpHeaders.CONNECTION)) || "close".equalsIgnoreCase(acVar.mo6478a(HttpHeaders.CONNECTION))) {
            f.mo6263e();
        }
        if ((c != 204 && c != 205) || acVar.mo6487h().mo6291b() <= 0) {
            return acVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP ");
        sb.append(c);
        sb.append(" had non-zero Content-Length: ");
        sb.append(acVar.mo6487h().mo6291b());
        throw new ProtocolException(sb.toString());
    }
}
