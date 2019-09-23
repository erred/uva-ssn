package p091b.p092a.p095c;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.List;
import p091b.C1590aa;
import p091b.C1590aa.C1591a;
import p091b.C1592ab;
import p091b.C1596ac;
import p091b.C1596ac.C1597a;
import p091b.C1598ad;
import p091b.C1627l;
import p091b.C1628m;
import p091b.C1645u;
import p091b.C1645u.C1646a;
import p091b.C1647v;
import p091b.p092a.C1508c;
import p091b.p092a.C1525d;
import p102c.C1681j;
import p102c.C1683l;
import p102c.C1695s;

/* renamed from: b.a.c.a */
/* compiled from: BridgeInterceptor */
public final class C1511a implements C1645u {

    /* renamed from: a */
    private final C1628m f4580a;

    public C1511a(C1628m mVar) {
        this.f4580a = mVar;
    }

    /* renamed from: a */
    public C1596ac mo6184a(C1646a aVar) throws IOException {
        C1590aa a = aVar.mo6279a();
        C1591a e = a.mo6460e();
        C1592ab d = a.mo6459d();
        if (d != null) {
            C1647v b = d.mo6475b();
            if (b != null) {
                e.mo6470a(HttpHeaders.CONTENT_TYPE, b.toString());
            }
            long c = d.mo6476c();
            if (c != -1) {
                e.mo6470a(HttpHeaders.CONTENT_LENGTH, Long.toString(c));
                e.mo6472b(HttpHeaders.TRANSFER_ENCODING);
            } else {
                e.mo6470a(HttpHeaders.TRANSFER_ENCODING, "chunked");
                e.mo6472b(HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (a.mo6455a(HttpHeaders.HOST) == null) {
            e.mo6470a(HttpHeaders.HOST, C1508c.m6073a(a.mo6454a(), false));
        }
        if (a.mo6455a(HttpHeaders.CONNECTION) == null) {
            e.mo6470a(HttpHeaders.CONNECTION, "Keep-Alive");
        }
        if (a.mo6455a(HttpHeaders.ACCEPT_ENCODING) == null && a.mo6455a(HttpHeaders.RANGE) == null) {
            z = true;
            e.mo6470a(HttpHeaders.ACCEPT_ENCODING, "gzip");
        }
        List a2 = this.f4580a.mo6600a(a.mo6454a());
        if (!a2.isEmpty()) {
            e.mo6470a(HttpHeaders.COOKIE, m6099a(a2));
        }
        if (a.mo6455a(HttpHeaders.USER_AGENT) == null) {
            e.mo6470a(HttpHeaders.USER_AGENT, C1525d.m6161a());
        }
        C1596ac a3 = aVar.mo6280a(e.mo6471a());
        C1517e.m6119a(this.f4580a, a.mo6454a(), a3.mo6486g());
        C1597a a4 = a3.mo6488i().mo6498a(a);
        if (z && "gzip".equalsIgnoreCase(a3.mo6478a(HttpHeaders.CONTENT_ENCODING)) && C1517e.m6126d(a3)) {
            C1681j jVar = new C1681j(a3.mo6487h().mo6292c());
            a4.mo6502a(a3.mo6486g().mo6646b().mo6655b(HttpHeaders.CONTENT_ENCODING).mo6655b(HttpHeaders.CONTENT_LENGTH).mo6654a());
            a4.mo6500a((C1598ad) new C1520h(a3.mo6478a(HttpHeaders.CONTENT_TYPE), -1, C1683l.m7033a((C1695s) jVar)));
        }
        return a4.mo6506a();
    }

    /* renamed from: a */
    private String m6099a(List<C1627l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            C1627l lVar = (C1627l) list.get(i);
            sb.append(lVar.mo6594a());
            sb.append('=');
            sb.append(lVar.mo6596b());
        }
        return sb.toString();
    }
}
