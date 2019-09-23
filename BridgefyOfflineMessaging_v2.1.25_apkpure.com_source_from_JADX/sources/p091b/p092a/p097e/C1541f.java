package p091b.p092a.p097e;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import p091b.C1590aa;
import p091b.C1596ac;
import p091b.C1596ac.C1597a;
import p091b.C1598ad;
import p091b.C1640s;
import p091b.C1640s.C1641a;
import p091b.C1645u.C1646a;
import p091b.C1651x;
import p091b.C1654y;
import p091b.p092a.C1483a;
import p091b.p092a.C1508c;
import p091b.p092a.p094b.C1506g;
import p091b.p092a.p095c.C1514c;
import p091b.p092a.p095c.C1517e;
import p091b.p092a.p095c.C1520h;
import p091b.p092a.p095c.C1521i;
import p091b.p092a.p095c.C1523k;
import p102c.C1672c;
import p102c.C1677f;
import p102c.C1679h;
import p102c.C1683l;
import p102c.C1694r;
import p102c.C1695s;

/* renamed from: b.a.e.f */
/* compiled from: Http2Codec */
public final class C1541f implements C1514c {

    /* renamed from: b */
    private static final C1677f f4681b = C1677f.m6985a("connection");

    /* renamed from: c */
    private static final C1677f f4682c = C1677f.m6985a("host");

    /* renamed from: d */
    private static final C1677f f4683d = C1677f.m6985a("keep-alive");

    /* renamed from: e */
    private static final C1677f f4684e = C1677f.m6985a("proxy-connection");

    /* renamed from: f */
    private static final C1677f f4685f = C1677f.m6985a("transfer-encoding");

    /* renamed from: g */
    private static final C1677f f4686g = C1677f.m6985a("te");

    /* renamed from: h */
    private static final C1677f f4687h = C1677f.m6985a("encoding");

    /* renamed from: i */
    private static final C1677f f4688i = C1677f.m6985a("upgrade");

    /* renamed from: j */
    private static final List<C1677f> f4689j = C1508c.m6079a((T[]) new C1677f[]{f4681b, f4682c, f4683d, f4684e, f4686g, f4685f, f4687h, f4688i, C1536c.f4650c, C1536c.f4651d, C1536c.f4652e, C1536c.f4653f});

    /* renamed from: k */
    private static final List<C1677f> f4690k = C1508c.m6079a((T[]) new C1677f[]{f4681b, f4682c, f4683d, f4684e, f4686g, f4685f, f4687h, f4688i});

    /* renamed from: a */
    final C1506g f4691a;

    /* renamed from: l */
    private final C1651x f4692l;

    /* renamed from: m */
    private final C1646a f4693m;

    /* renamed from: n */
    private final C1543g f4694n;

    /* renamed from: o */
    private C1561i f4695o;

    /* renamed from: b.a.e.f$a */
    /* compiled from: Http2Codec */
    class C1542a extends C1679h {

        /* renamed from: a */
        boolean f4696a = false;

        /* renamed from: b */
        long f4697b = 0;

        C1542a(C1695s sVar) {
            super(sVar);
        }

        /* renamed from: a */
        public long mo6185a(C1672c cVar, long j) throws IOException {
            try {
                long a = mo6907b().mo6185a(cVar, j);
                if (a > 0) {
                    this.f4697b += a;
                }
                return a;
            } catch (IOException e) {
                m6230a(e);
                throw e;
            }
        }

        public void close() throws IOException {
            super.close();
            m6230a(null);
        }

        /* renamed from: a */
        private void m6230a(IOException iOException) {
            if (!this.f4696a) {
                this.f4696a = true;
                C1541f.this.f4691a.mo6259a(false, C1541f.this, this.f4697b, iOException);
            }
        }
    }

    public C1541f(C1651x xVar, C1646a aVar, C1506g gVar, C1543g gVar2) {
        this.f4692l = xVar;
        this.f4693m = aVar;
        this.f4691a = gVar;
        this.f4694n = gVar2;
    }

    /* renamed from: a */
    public C1694r mo6272a(C1590aa aaVar, long j) {
        return this.f4695o.mo6370h();
    }

    /* renamed from: a */
    public void mo6274a(C1590aa aaVar) throws IOException {
        if (this.f4695o == null) {
            this.f4695o = this.f4694n.mo6320a(m6222b(aaVar), aaVar.mo6459d() != null);
            this.f4695o.mo6367e().mo6912a((long) this.f4693m.mo6283c(), TimeUnit.MILLISECONDS);
            this.f4695o.mo6368f().mo6912a((long) this.f4693m.mo6284d(), TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: a */
    public void mo6273a() throws IOException {
        this.f4694n.mo6333b();
    }

    /* renamed from: b */
    public void mo6275b() throws IOException {
        this.f4695o.mo6370h().close();
    }

    /* renamed from: a */
    public C1597a mo6270a(boolean z) throws IOException {
        C1597a a = m6221a(this.f4695o.mo6366d());
        if (!z || C1483a.f4446a.mo6174a(a) != 100) {
            return a;
        }
        return null;
    }

    /* renamed from: b */
    public static List<C1536c> m6222b(C1590aa aaVar) {
        C1640s c = aaVar.mo6458c();
        ArrayList arrayList = new ArrayList(c.mo6643a() + 4);
        arrayList.add(new C1536c(C1536c.f4650c, aaVar.mo6456b()));
        arrayList.add(new C1536c(C1536c.f4651d, C1521i.m6148a(aaVar.mo6454a())));
        String a = aaVar.mo6455a(HttpHeaders.HOST);
        if (a != null) {
            arrayList.add(new C1536c(C1536c.f4653f, a));
        }
        arrayList.add(new C1536c(C1536c.f4652e, aaVar.mo6454a().mo6661b()));
        int a2 = c.mo6643a();
        for (int i = 0; i < a2; i++) {
            C1677f a3 = C1677f.m6985a(c.mo6644a(i).toLowerCase(Locale.US));
            if (!f4689j.contains(a3)) {
                arrayList.add(new C1536c(a3, c.mo6647b(i)));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static C1597a m6221a(List<C1536c> list) throws IOException {
        C1641a aVar = new C1641a();
        int size = list.size();
        C1641a aVar2 = aVar;
        C1523k kVar = null;
        for (int i = 0; i < size; i++) {
            C1536c cVar = (C1536c) list.get(i);
            if (cVar != null) {
                C1677f fVar = cVar.f4654g;
                String a = cVar.f4655h.mo6888a();
                if (fVar.equals(C1536c.f4649b)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("HTTP/1.1 ");
                    sb.append(a);
                    kVar = C1523k.m6160a(sb.toString());
                } else if (!f4690k.contains(fVar)) {
                    C1483a.f4446a.mo6180a(aVar2, fVar.mo6888a(), a);
                }
            } else if (kVar != null && kVar.f4608b == 100) {
                aVar2 = new C1641a();
                kVar = null;
            }
        }
        if (kVar != null) {
            return new C1597a().mo6503a(C1654y.HTTP_2).mo6496a(kVar.f4608b).mo6504a(kVar.f4609c).mo6502a(aVar2.mo6654a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    /* renamed from: a */
    public C1598ad mo6271a(C1596ac acVar) throws IOException {
        this.f4691a.f4547c.mo6627f(this.f4691a.f4546b);
        return new C1520h(acVar.mo6478a(HttpHeaders.CONTENT_TYPE), C1517e.m6115a(acVar), C1683l.m7033a((C1695s) new C1542a(this.f4695o.mo6369g())));
    }

    /* renamed from: c */
    public void mo6276c() {
        if (this.f4695o != null) {
            this.f4695o.mo6362b(C1535b.CANCEL);
        }
    }
}
