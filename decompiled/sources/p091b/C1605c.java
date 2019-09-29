package p091b;

import com.google.api.client.http.HttpMethods;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p091b.C1590aa.C1591a;
import p091b.C1596ac.C1597a;
import p091b.C1640s.C1641a;
import p091b.p092a.C1508c;
import p091b.p092a.p093a.C1486b;
import p091b.p092a.p093a.C1487c;
import p091b.p092a.p093a.C1489d;
import p091b.p092a.p093a.C1489d.C1492a;
import p091b.p092a.p093a.C1489d.C1495c;
import p091b.p092a.p093a.C1497f;
import p091b.p092a.p095c.C1517e;
import p091b.p092a.p095c.C1518f;
import p091b.p092a.p095c.C1523k;
import p091b.p092a.p098f.C1572a;
import p091b.p092a.p099g.C1583f;
import p102c.C1672c;
import p102c.C1675d;
import p102c.C1676e;
import p102c.C1677f;
import p102c.C1678g;
import p102c.C1679h;
import p102c.C1683l;
import p102c.C1694r;
import p102c.C1695s;

/* renamed from: b.c */
/* compiled from: Cache */
public final class C1605c implements Closeable, Flushable {

    /* renamed from: a */
    final C1497f f4920a;

    /* renamed from: b */
    final C1489d f4921b;

    /* renamed from: c */
    int f4922c;

    /* renamed from: d */
    int f4923d;

    /* renamed from: e */
    private int f4924e;

    /* renamed from: f */
    private int f4925f;

    /* renamed from: g */
    private int f4926g;

    /* renamed from: b.c$a */
    /* compiled from: Cache */
    private final class C1607a implements C1486b {

        /* renamed from: a */
        boolean f4928a;

        /* renamed from: c */
        private final C1492a f4930c;

        /* renamed from: d */
        private C1694r f4931d;

        /* renamed from: e */
        private C1694r f4932e;

        C1607a(final C1492a aVar) {
            this.f4930c = aVar;
            this.f4931d = aVar.mo6207a(1);
            this.f4932e = new C1678g(this.f4931d, C1605c.this) {
                public void close() throws IOException {
                    synchronized (C1605c.this) {
                        if (!C1607a.this.f4928a) {
                            C1607a.this.f4928a = true;
                            C1605c.this.f4922c++;
                            super.close();
                            aVar.mo6209b();
                        }
                    }
                }
            };
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r4.f4930c.mo6210c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
            p091b.p092a.C1508c.m6082a((java.io.Closeable) r4.f4931d);
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo6188a() {
            /*
                r4 = this;
                b.c r0 = p091b.C1605c.this
                monitor-enter(r0)
                boolean r1 = r4.f4928a     // Catch:{ all -> 0x001f }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x001f }
                return
            L_0x0009:
                r1 = 1
                r4.f4928a = r1     // Catch:{ all -> 0x001f }
                b.c r2 = p091b.C1605c.this     // Catch:{ all -> 0x001f }
                int r3 = r2.f4923d     // Catch:{ all -> 0x001f }
                int r3 = r3 + r1
                r2.f4923d = r3     // Catch:{ all -> 0x001f }
                monitor-exit(r0)     // Catch:{ all -> 0x001f }
                c.r r0 = r4.f4931d
                p091b.p092a.C1508c.m6082a(r0)
                b.a.a.d$a r0 = r4.f4930c     // Catch:{ IOException -> 0x001e }
                r0.mo6210c()     // Catch:{ IOException -> 0x001e }
            L_0x001e:
                return
            L_0x001f:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x001f }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p091b.C1605c.C1607a.mo6188a():void");
        }

        /* renamed from: b */
        public C1694r mo6189b() {
            return this.f4932e;
        }
    }

    /* renamed from: b.c$b */
    /* compiled from: Cache */
    private static class C1609b extends C1598ad {

        /* renamed from: a */
        final C1495c f4936a;

        /* renamed from: b */
        private final C1676e f4937b;

        /* renamed from: c */
        private final String f4938c;

        /* renamed from: d */
        private final String f4939d;

        C1609b(final C1495c cVar, String str, String str2) {
            this.f4936a = cVar;
            this.f4938c = str;
            this.f4939d = str2;
            this.f4937b = C1683l.m7033a((C1695s) new C1679h(cVar.mo6215a(1)) {
                public void close() throws IOException {
                    cVar.close();
                    super.close();
                }
            });
        }

        /* renamed from: a */
        public C1647v mo6290a() {
            if (this.f4938c != null) {
                return C1647v.m6791a(this.f4938c);
            }
            return null;
        }

        /* renamed from: b */
        public long mo6291b() {
            long j = -1;
            try {
                if (this.f4939d != null) {
                    j = Long.parseLong(this.f4939d);
                }
                return j;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        /* renamed from: c */
        public C1676e mo6292c() {
            return this.f4937b;
        }
    }

    /* renamed from: b.c$c */
    /* compiled from: Cache */
    private static final class C1611c {

        /* renamed from: a */
        private static final String f4942a;

        /* renamed from: b */
        private static final String f4943b;

        /* renamed from: c */
        private final String f4944c;

        /* renamed from: d */
        private final C1640s f4945d;

        /* renamed from: e */
        private final String f4946e;

        /* renamed from: f */
        private final C1654y f4947f;

        /* renamed from: g */
        private final int f4948g;

        /* renamed from: h */
        private final String f4949h;

        /* renamed from: i */
        private final C1640s f4950i;

        /* renamed from: j */
        private final C1639r f4951j;

        /* renamed from: k */
        private final long f4952k;

        /* renamed from: l */
        private final long f4953l;

        static {
            StringBuilder sb = new StringBuilder();
            sb.append(C1583f.m6443c().mo6445d());
            sb.append("-Sent-Millis");
            f4942a = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(C1583f.m6443c().mo6445d());
            sb2.append("-Received-Millis");
            f4943b = sb2.toString();
        }

        C1611c(C1695s sVar) throws IOException {
            C1602af afVar;
            try {
                C1676e a = C1683l.m7033a(sVar);
                this.f4944c = a.mo6867r();
                this.f4946e = a.mo6867r();
                C1641a aVar = new C1641a();
                int a2 = C1605c.m6564a(a);
                for (int i = 0; i < a2; i++) {
                    aVar.mo6652a(a.mo6867r());
                }
                this.f4945d = aVar.mo6654a();
                C1523k a3 = C1523k.m6160a(a.mo6867r());
                this.f4947f = a3.f4607a;
                this.f4948g = a3.f4608b;
                this.f4949h = a3.f4609c;
                C1641a aVar2 = new C1641a();
                int a4 = C1605c.m6564a(a);
                for (int i2 = 0; i2 < a4; i2++) {
                    aVar2.mo6652a(a.mo6867r());
                }
                String c = aVar2.mo6658c(f4942a);
                String c2 = aVar2.mo6658c(f4943b);
                aVar2.mo6655b(f4942a);
                aVar2.mo6655b(f4943b);
                long j = 0;
                this.f4952k = c != null ? Long.parseLong(c) : 0;
                if (c2 != null) {
                    j = Long.parseLong(c2);
                }
                this.f4953l = j;
                this.f4950i = aVar2.mo6654a();
                if (m6586a()) {
                    String r = a.mo6867r();
                    if (r.length() <= 0) {
                        C1620h a5 = C1620h.m6622a(a.mo6867r());
                        List a6 = m6584a(a);
                        List a7 = m6584a(a);
                        if (!a.mo6844f()) {
                            afVar = C1602af.m6559a(a.mo6867r());
                        } else {
                            afVar = C1602af.SSL_3_0;
                        }
                        this.f4951j = C1639r.m6706a(afVar, a5, a6, a7);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("expected \"\" but was \"");
                        sb.append(r);
                        sb.append("\"");
                        throw new IOException(sb.toString());
                    }
                } else {
                    this.f4951j = null;
                }
            } finally {
                sVar.close();
            }
        }

        C1611c(C1596ac acVar) {
            this.f4944c = acVar.mo6477a().mo6454a().toString();
            this.f4945d = C1517e.m6124c(acVar);
            this.f4946e = acVar.mo6477a().mo6456b();
            this.f4947f = acVar.mo6480b();
            this.f4948g = acVar.mo6481c();
            this.f4949h = acVar.mo6484e();
            this.f4950i = acVar.mo6486g();
            this.f4951j = acVar.mo6485f();
            this.f4952k = acVar.mo6493n();
            this.f4953l = acVar.mo6494o();
        }

        /* renamed from: a */
        public void mo6534a(C1492a aVar) throws IOException {
            C1675d a = C1683l.m7032a(aVar.mo6207a(0));
            a.mo6828b(this.f4944c).mo6854i(10);
            a.mo6828b(this.f4946e).mo6854i(10);
            a.mo6860l((long) this.f4945d.mo6643a()).mo6854i(10);
            int a2 = this.f4945d.mo6643a();
            for (int i = 0; i < a2; i++) {
                a.mo6828b(this.f4945d.mo6644a(i)).mo6828b(": ").mo6828b(this.f4945d.mo6647b(i)).mo6854i(10);
            }
            a.mo6828b(new C1523k(this.f4947f, this.f4948g, this.f4949h).toString()).mo6854i(10);
            a.mo6860l((long) (this.f4950i.mo6643a() + 2)).mo6854i(10);
            int a3 = this.f4950i.mo6643a();
            for (int i2 = 0; i2 < a3; i2++) {
                a.mo6828b(this.f4950i.mo6644a(i2)).mo6828b(": ").mo6828b(this.f4950i.mo6647b(i2)).mo6854i(10);
            }
            a.mo6828b(f4942a).mo6828b(": ").mo6860l(this.f4952k).mo6854i(10);
            a.mo6828b(f4943b).mo6828b(": ").mo6860l(this.f4953l).mo6854i(10);
            if (m6586a()) {
                a.mo6854i(10);
                a.mo6828b(this.f4951j.mo6638b().mo6569a()).mo6854i(10);
                m6585a(a, this.f4951j.mo6639c());
                m6585a(a, this.f4951j.mo6640d());
                a.mo6828b(this.f4951j.mo6637a().mo6523a()).mo6854i(10);
            }
            a.close();
        }

        /* renamed from: a */
        private boolean m6586a() {
            return this.f4944c.startsWith("https://");
        }

        /* renamed from: a */
        private List<Certificate> m6584a(C1676e eVar) throws IOException {
            int a = C1605c.m6564a(eVar);
            if (a == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(a);
                for (int i = 0; i < a; i++) {
                    String r = eVar.mo6867r();
                    C1672c cVar = new C1672c();
                    cVar.mo6827b(C1677f.m6988b(r));
                    arrayList.add(instance.generateCertificate(cVar.mo6846g()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        /* renamed from: a */
        private void m6585a(C1675d dVar, List<Certificate> list) throws IOException {
            try {
                dVar.mo6860l((long) list.size()).mo6854i(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    dVar.mo6828b(C1677f.m6986a(((Certificate) list.get(i)).getEncoded()).mo6894b()).mo6854i(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        /* renamed from: a */
        public boolean mo6535a(C1590aa aaVar, C1596ac acVar) {
            return this.f4944c.equals(aaVar.mo6454a().toString()) && this.f4946e.equals(aaVar.mo6456b()) && C1517e.m6120a(acVar, this.f4945d, aaVar);
        }

        /* renamed from: a */
        public C1596ac mo6533a(C1495c cVar) {
            String a = this.f4950i.mo6645a(HttpHeaders.CONTENT_TYPE);
            String a2 = this.f4950i.mo6645a(HttpHeaders.CONTENT_LENGTH);
            return new C1597a().mo6498a(new C1591a().mo6468a(this.f4944c).mo6469a(this.f4946e, (C1592ab) null).mo6466a(this.f4945d).mo6471a()).mo6503a(this.f4947f).mo6496a(this.f4948g).mo6504a(this.f4949h).mo6502a(this.f4950i).mo6500a((C1598ad) new C1609b(cVar, a, a2)).mo6501a(this.f4951j).mo6497a(this.f4952k).mo6507b(this.f4953l).mo6506a();
        }
    }

    public C1605c(File file, long j) {
        this(file, j, C1572a.f4817a);
    }

    C1605c(File file, long j, C1572a aVar) {
        this.f4920a = new C1497f() {
            /* renamed from: a */
            public C1596ac mo6221a(C1590aa aaVar) throws IOException {
                return C1605c.this.mo6526a(aaVar);
            }

            /* renamed from: a */
            public C1486b mo6220a(C1596ac acVar) throws IOException {
                return C1605c.this.mo6525a(acVar);
            }

            /* renamed from: b */
            public void mo6225b(C1590aa aaVar) throws IOException {
                C1605c.this.mo6530b(aaVar);
            }

            /* renamed from: a */
            public void mo6224a(C1596ac acVar, C1596ac acVar2) {
                C1605c.this.mo6529a(acVar, acVar2);
            }

            /* renamed from: a */
            public void mo6222a() {
                C1605c.this.mo6527a();
            }

            /* renamed from: a */
            public void mo6223a(C1487c cVar) {
                C1605c.this.mo6528a(cVar);
            }
        };
        this.f4921b = C1489d.m5969a(aVar, file, 201105, 2, j);
    }

    /* renamed from: a */
    public static String m6565a(C1642t tVar) {
        return C1677f.m6985a(tVar.toString()).mo6895c().mo6900f();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1596ac mo6526a(C1590aa aaVar) {
        try {
            C1495c a = this.f4921b.mo6192a(m6565a(aaVar.mo6454a()));
            if (a == null) {
                return null;
            }
            try {
                C1611c cVar = new C1611c(a.mo6215a(0));
                C1596ac a2 = cVar.mo6533a(a);
                if (cVar.mo6535a(aaVar, a2)) {
                    return a2;
                }
                C1508c.m6082a((Closeable) a2.mo6487h());
                return null;
            } catch (IOException unused) {
                C1508c.m6082a((Closeable) a);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1486b mo6525a(C1596ac acVar) {
        C1492a aVar;
        String b = acVar.mo6477a().mo6456b();
        if (C1518f.m6128a(acVar.mo6477a().mo6456b())) {
            try {
                mo6530b(acVar.mo6477a());
            } catch (IOException unused) {
            }
            return null;
        } else if (!b.equals(HttpMethods.GET) || C1517e.m6122b(acVar)) {
            return null;
        } else {
            C1611c cVar = new C1611c(acVar);
            try {
                aVar = this.f4921b.mo6196b(m6565a(acVar.mo6477a().mo6454a()));
                if (aVar == null) {
                    return null;
                }
                try {
                    cVar.mo6534a(aVar);
                    return new C1607a(aVar);
                } catch (IOException unused2) {
                    m6566a(aVar);
                    return null;
                }
            } catch (IOException unused3) {
                aVar = null;
                m6566a(aVar);
                return null;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo6530b(C1590aa aaVar) throws IOException {
        this.f4921b.mo6199c(m6565a(aaVar.mo6454a()));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6529a(C1596ac acVar, C1596ac acVar2) {
        C1492a aVar;
        C1611c cVar = new C1611c(acVar2);
        try {
            aVar = ((C1609b) acVar.mo6487h()).f4936a.mo6214a();
            if (aVar != null) {
                try {
                    cVar.mo6534a(aVar);
                    aVar.mo6209b();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            aVar = null;
            m6566a(aVar);
        }
    }

    /* renamed from: a */
    private void m6566a(C1492a aVar) {
        if (aVar != null) {
            try {
                aVar.mo6210c();
            } catch (IOException unused) {
            }
        }
    }

    public void flush() throws IOException {
        this.f4921b.flush();
    }

    public void close() throws IOException {
        this.f4921b.close();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo6528a(C1487c cVar) {
        this.f4926g++;
        if (cVar.f4453a != null) {
            this.f4924e++;
        } else if (cVar.f4454b != null) {
            this.f4925f++;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo6527a() {
        this.f4925f++;
    }

    /* renamed from: a */
    static int m6564a(C1676e eVar) throws IOException {
        try {
            long n = eVar.mo6863n();
            String r = eVar.mo6867r();
            if (n >= 0 && n <= 2147483647L && r.isEmpty()) {
                return (int) n;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("expected an int but was \"");
            sb.append(n);
            sb.append(r);
            sb.append("\"");
            throw new IOException(sb.toString());
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }
}
