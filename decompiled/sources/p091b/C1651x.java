package p091b;

import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import p091b.C1596ac.C1597a;
import p091b.C1614e.C1615a;
import p091b.C1633p.C1636a;
import p091b.C1640s.C1641a;
import p091b.p092a.C1483a;
import p091b.p092a.C1508c;
import p091b.p092a.p093a.C1497f;
import p091b.p092a.p094b.C1501c;
import p091b.p092a.p094b.C1502d;
import p091b.p092a.p094b.C1506g;
import p091b.p092a.p099g.C1583f;
import p091b.p092a.p101i.C1587c;
import p091b.p092a.p101i.C1588d;

/* renamed from: b.x */
/* compiled from: OkHttpClient */
public class C1651x implements C1615a, Cloneable {

    /* renamed from: a */
    static final List<C1654y> f5205a = C1508c.m6079a((T[]) new C1654y[]{C1654y.HTTP_2, C1654y.HTTP_1_1});

    /* renamed from: b */
    static final List<C1625k> f5206b = C1508c.m6079a((T[]) new C1625k[]{C1625k.f5109a, C1625k.f5111c});

    /* renamed from: A */
    final int f5207A;

    /* renamed from: B */
    final int f5208B;

    /* renamed from: C */
    final int f5209C;

    /* renamed from: c */
    final C1630n f5210c;

    /* renamed from: d */
    final Proxy f5211d;

    /* renamed from: e */
    final List<C1654y> f5212e;

    /* renamed from: f */
    final List<C1625k> f5213f;

    /* renamed from: g */
    final List<C1645u> f5214g;

    /* renamed from: h */
    final List<C1645u> f5215h;

    /* renamed from: i */
    final C1636a f5216i;

    /* renamed from: j */
    final ProxySelector f5217j;

    /* renamed from: k */
    final C1628m f5218k;

    /* renamed from: l */
    final C1605c f5219l;

    /* renamed from: m */
    final C1497f f5220m;

    /* renamed from: n */
    final SocketFactory f5221n;

    /* renamed from: o */
    final SSLSocketFactory f5222o;

    /* renamed from: p */
    final C1587c f5223p;

    /* renamed from: q */
    final HostnameVerifier f5224q;

    /* renamed from: r */
    final C1617g f5225r;

    /* renamed from: s */
    final C1603b f5226s;

    /* renamed from: t */
    final C1603b f5227t;

    /* renamed from: u */
    final C1623j f5228u;

    /* renamed from: v */
    final C1631o f5229v;

    /* renamed from: w */
    final boolean f5230w;

    /* renamed from: x */
    final boolean f5231x;

    /* renamed from: y */
    final boolean f5232y;

    /* renamed from: z */
    final int f5233z;

    /* renamed from: b.x$a */
    /* compiled from: OkHttpClient */
    public static final class C1653a {

        /* renamed from: A */
        int f5234A = 0;

        /* renamed from: a */
        C1630n f5235a = new C1630n();

        /* renamed from: b */
        Proxy f5236b;

        /* renamed from: c */
        List<C1654y> f5237c = C1651x.f5205a;

        /* renamed from: d */
        List<C1625k> f5238d = C1651x.f5206b;

        /* renamed from: e */
        final List<C1645u> f5239e = new ArrayList();

        /* renamed from: f */
        final List<C1645u> f5240f = new ArrayList();

        /* renamed from: g */
        C1636a f5241g = C1633p.m6672a(C1633p.f5143a);

        /* renamed from: h */
        ProxySelector f5242h = ProxySelector.getDefault();

        /* renamed from: i */
        C1628m f5243i = C1628m.f5134a;

        /* renamed from: j */
        C1605c f5244j;

        /* renamed from: k */
        C1497f f5245k;

        /* renamed from: l */
        SocketFactory f5246l = SocketFactory.getDefault();

        /* renamed from: m */
        SSLSocketFactory f5247m;

        /* renamed from: n */
        C1587c f5248n;

        /* renamed from: o */
        HostnameVerifier f5249o = C1588d.f4856a;

        /* renamed from: p */
        C1617g f5250p = C1617g.f4977a;

        /* renamed from: q */
        C1603b f5251q = C1603b.f4919b;

        /* renamed from: r */
        C1603b f5252r = C1603b.f4919b;

        /* renamed from: s */
        C1623j f5253s = new C1623j();

        /* renamed from: t */
        C1631o f5254t = C1631o.f5142a;

        /* renamed from: u */
        boolean f5255u = true;

        /* renamed from: v */
        boolean f5256v = true;

        /* renamed from: w */
        boolean f5257w = true;

        /* renamed from: x */
        int f5258x = 10000;

        /* renamed from: y */
        int f5259y = 10000;

        /* renamed from: z */
        int f5260z = 10000;

        /* renamed from: a */
        public C1653a mo6732a(C1605c cVar) {
            this.f5244j = cVar;
            this.f5245k = null;
            return this;
        }

        /* renamed from: a */
        public C1653a mo6733a(C1617g gVar) {
            if (gVar != null) {
                this.f5250p = gVar;
                return this;
            }
            throw new NullPointerException("certificatePinner == null");
        }

        /* renamed from: a */
        public C1653a mo6731a(C1603b bVar) {
            if (bVar != null) {
                this.f5252r = bVar;
                return this;
            }
            throw new NullPointerException("authenticator == null");
        }

        /* renamed from: a */
        public C1653a mo6734a(C1645u uVar) {
            if (uVar != null) {
                this.f5239e.add(uVar);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        /* renamed from: b */
        public C1653a mo6736b(C1645u uVar) {
            if (uVar != null) {
                this.f5240f.add(uVar);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        /* renamed from: a */
        public C1651x mo6735a() {
            return new C1651x(this);
        }
    }

    static {
        C1483a.f4446a = new C1483a() {
            /* renamed from: a */
            public void mo6179a(C1641a aVar, String str) {
                aVar.mo6652a(str);
            }

            /* renamed from: a */
            public void mo6180a(C1641a aVar, String str, String str2) {
                aVar.mo6656b(str, str2);
            }

            /* renamed from: a */
            public boolean mo6182a(C1623j jVar, C1501c cVar) {
                return jVar.mo6577b(cVar);
            }

            /* renamed from: a */
            public C1501c mo6175a(C1623j jVar, C1482a aVar, C1506g gVar, C1601ae aeVar) {
                return jVar.mo6574a(aVar, gVar, aeVar);
            }

            /* renamed from: a */
            public boolean mo6181a(C1482a aVar, C1482a aVar2) {
                return aVar.mo6160a(aVar2);
            }

            /* renamed from: a */
            public Socket mo6177a(C1623j jVar, C1482a aVar, C1506g gVar) {
                return jVar.mo6575a(aVar, gVar);
            }

            /* renamed from: b */
            public void mo6183b(C1623j jVar, C1501c cVar) {
                jVar.mo6576a(cVar);
            }

            /* renamed from: a */
            public C1502d mo6176a(C1623j jVar) {
                return jVar.f5102a;
            }

            /* renamed from: a */
            public int mo6174a(C1597a aVar) {
                return aVar.f4891c;
            }

            /* renamed from: a */
            public void mo6178a(C1625k kVar, SSLSocket sSLSocket, boolean z) {
                kVar.mo6579a(sSLSocket, z);
            }
        };
    }

    public C1651x() {
        this(new C1653a());
    }

    C1651x(C1653a aVar) {
        boolean z;
        this.f5210c = aVar.f5235a;
        this.f5211d = aVar.f5236b;
        this.f5212e = aVar.f5237c;
        this.f5213f = aVar.f5238d;
        this.f5214g = C1508c.m6078a(aVar.f5239e);
        this.f5215h = C1508c.m6078a(aVar.f5240f);
        this.f5216i = aVar.f5241g;
        this.f5217j = aVar.f5242h;
        this.f5218k = aVar.f5243i;
        this.f5219l = aVar.f5244j;
        this.f5220m = aVar.f5245k;
        this.f5221n = aVar.f5246l;
        Iterator it = this.f5213f.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                C1625k kVar = (C1625k) it.next();
                if (z || kVar.mo6580a()) {
                    z = true;
                }
            }
        }
        if (aVar.f5247m != null || !z) {
            this.f5222o = aVar.f5247m;
            this.f5223p = aVar.f5248n;
        } else {
            X509TrustManager A = m6803A();
            this.f5222o = m6804a(A);
            this.f5223p = C1587c.m6466a(A);
        }
        this.f5224q = aVar.f5249o;
        this.f5225r = aVar.f5250p.mo6558a(this.f5223p);
        this.f5226s = aVar.f5251q;
        this.f5227t = aVar.f5252r;
        this.f5228u = aVar.f5253s;
        this.f5229v = aVar.f5254t;
        this.f5230w = aVar.f5255u;
        this.f5231x = aVar.f5256v;
        this.f5232y = aVar.f5257w;
        this.f5233z = aVar.f5258x;
        this.f5207A = aVar.f5259y;
        this.f5208B = aVar.f5260z;
        this.f5209C = aVar.f5234A;
        if (this.f5214g.contains(null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Null interceptor: ");
            sb.append(this.f5214g);
            throw new IllegalStateException(sb.toString());
        } else if (this.f5215h.contains(null)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Null network interceptor: ");
            sb2.append(this.f5215h);
            throw new IllegalStateException(sb2.toString());
        }
    }

    /* renamed from: A */
    private X509TrustManager m6803A() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected default trust managers:");
            sb.append(Arrays.toString(trustManagers));
            throw new IllegalStateException(sb.toString());
        } catch (GeneralSecurityException e) {
            throw C1508c.m6072a("No System TLS", (Exception) e);
        }
    }

    /* renamed from: a */
    private SSLSocketFactory m6804a(X509TrustManager x509TrustManager) {
        try {
            SSLContext k_ = C1583f.m6443c().mo6437k_();
            k_.init(null, new TrustManager[]{x509TrustManager}, null);
            return k_.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw C1508c.m6072a("No System TLS", (Exception) e);
        }
    }

    /* renamed from: a */
    public int mo6705a() {
        return this.f5233z;
    }

    /* renamed from: b */
    public int mo6706b() {
        return this.f5207A;
    }

    /* renamed from: c */
    public int mo6707c() {
        return this.f5208B;
    }

    /* renamed from: d */
    public int mo6708d() {
        return this.f5209C;
    }

    /* renamed from: e */
    public Proxy mo6709e() {
        return this.f5211d;
    }

    /* renamed from: f */
    public ProxySelector mo6710f() {
        return this.f5217j;
    }

    /* renamed from: g */
    public C1628m mo6711g() {
        return this.f5218k;
    }

    /* renamed from: h */
    public C1605c mo6712h() {
        return this.f5219l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: i */
    public C1497f mo6713i() {
        return this.f5219l != null ? this.f5219l.f4920a : this.f5220m;
    }

    /* renamed from: j */
    public C1631o mo6714j() {
        return this.f5229v;
    }

    /* renamed from: k */
    public SocketFactory mo6715k() {
        return this.f5221n;
    }

    /* renamed from: l */
    public SSLSocketFactory mo6716l() {
        return this.f5222o;
    }

    /* renamed from: m */
    public HostnameVerifier mo6717m() {
        return this.f5224q;
    }

    /* renamed from: n */
    public C1617g mo6718n() {
        return this.f5225r;
    }

    /* renamed from: o */
    public C1603b mo6719o() {
        return this.f5227t;
    }

    /* renamed from: p */
    public C1603b mo6720p() {
        return this.f5226s;
    }

    /* renamed from: q */
    public C1623j mo6721q() {
        return this.f5228u;
    }

    /* renamed from: r */
    public boolean mo6722r() {
        return this.f5230w;
    }

    /* renamed from: s */
    public boolean mo6723s() {
        return this.f5231x;
    }

    /* renamed from: t */
    public boolean mo6724t() {
        return this.f5232y;
    }

    /* renamed from: u */
    public C1630n mo6725u() {
        return this.f5210c;
    }

    /* renamed from: v */
    public List<C1654y> mo6726v() {
        return this.f5212e;
    }

    /* renamed from: w */
    public List<C1625k> mo6727w() {
        return this.f5213f;
    }

    /* renamed from: x */
    public List<C1645u> mo6728x() {
        return this.f5214g;
    }

    /* renamed from: y */
    public List<C1645u> mo6729y() {
        return this.f5215h;
    }

    /* renamed from: z */
    public C1636a mo6730z() {
        return this.f5216i;
    }

    /* renamed from: a */
    public C1614e mo6555a(C1590aa aaVar) {
        return C1655z.m6850a(this, aaVar, false);
    }
}
