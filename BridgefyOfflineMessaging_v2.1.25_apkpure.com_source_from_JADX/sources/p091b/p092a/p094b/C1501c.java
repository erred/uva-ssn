package p091b.p092a.p094b;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import p091b.C1482a;
import p091b.C1590aa;
import p091b.C1590aa.C1591a;
import p091b.C1596ac;
import p091b.C1601ae;
import p091b.C1614e;
import p091b.C1622i;
import p091b.C1623j;
import p091b.C1633p;
import p091b.C1639r;
import p091b.C1642t;
import p091b.C1645u.C1646a;
import p091b.C1651x;
import p091b.C1654y;
import p091b.p092a.C1483a;
import p091b.p092a.C1508c;
import p091b.p092a.C1525d;
import p091b.p092a.p095c.C1514c;
import p091b.p092a.p095c.C1517e;
import p091b.p092a.p096d.C1526a;
import p091b.p092a.p097e.C1535b;
import p091b.p092a.p097e.C1541f;
import p091b.p092a.p097e.C1543g;
import p091b.p092a.p097e.C1543g.C1550a;
import p091b.p092a.p097e.C1543g.C1551b;
import p091b.p092a.p097e.C1561i;
import p091b.p092a.p099g.C1583f;
import p091b.p092a.p101i.C1588d;
import p102c.C1675d;
import p102c.C1676e;
import p102c.C1683l;
import p102c.C1695s;

/* renamed from: b.a.b.c */
/* compiled from: RealConnection */
public final class C1501c extends C1551b implements C1622i {

    /* renamed from: a */
    public boolean f4517a;

    /* renamed from: b */
    public int f4518b;

    /* renamed from: c */
    public int f4519c = 1;

    /* renamed from: d */
    public final List<Reference<C1506g>> f4520d = new ArrayList();

    /* renamed from: e */
    public long f4521e = Long.MAX_VALUE;

    /* renamed from: g */
    private final C1623j f4522g;

    /* renamed from: h */
    private final C1601ae f4523h;

    /* renamed from: i */
    private Socket f4524i;

    /* renamed from: j */
    private Socket f4525j;

    /* renamed from: k */
    private C1639r f4526k;

    /* renamed from: l */
    private C1654y f4527l;

    /* renamed from: m */
    private C1543g f4528m;

    /* renamed from: n */
    private C1676e f4529n;

    /* renamed from: o */
    private C1675d f4530o;

    public C1501c(C1623j jVar, C1601ae aeVar) {
        this.f4522g = jVar;
        this.f4523h = aeVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0131 A[EDGE_INSN: B:58:0x0131->B:54:0x0131 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo6232a(int r17, int r18, int r19, int r20, boolean r21, p091b.C1614e r22, p091b.C1633p r23) {
        /*
            r16 = this;
            r7 = r16
            r8 = r22
            r9 = r23
            b.y r0 = r7.f4527l
            if (r0 != 0) goto L_0x0132
            b.ae r0 = r7.f4523h
            b.a r0 = r0.mo6516a()
            java.util.List r0 = r0.mo6166f()
            b.a.b.b r10 = new b.a.b.b
            r10.<init>(r0)
            b.ae r1 = r7.f4523h
            b.a r1 = r1.mo6516a()
            javax.net.ssl.SSLSocketFactory r1 = r1.mo6170i()
            if (r1 != 0) goto L_0x0074
            b.k r1 = p091b.C1625k.f5111c
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0067
            b.ae r0 = r7.f4523h
            b.a r0 = r0.mo6516a()
            b.t r0 = r0.mo6159a()
            java.lang.String r0 = r0.mo6669f()
            b.a.g.f r1 = p091b.p092a.p099g.C1583f.m6443c()
            boolean r1 = r1.mo6428b(r0)
            if (r1 == 0) goto L_0x0046
            goto L_0x0074
        L_0x0046:
            b.a.b.e r1 = new b.a.b.e
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "CLEARTEXT communication to "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            r1.<init>(r2)
            throw r1
        L_0x0067:
            b.a.b.e r0 = new b.a.b.e
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "CLEARTEXT communication not enabled for client"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0074:
            r11 = 0
            r12 = r11
        L_0x0076:
            b.ae r0 = r7.f4523h     // Catch:{ IOException -> 0x00e7 }
            boolean r0 = r0.mo6519d()     // Catch:{ IOException -> 0x00e7 }
            if (r0 == 0) goto L_0x0097
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r23
            r1.m6014a(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00e7 }
            java.net.Socket r0 = r7.f4524i     // Catch:{ IOException -> 0x00e7 }
            if (r0 != 0) goto L_0x0092
            goto L_0x00b4
        L_0x0092:
            r13 = r17
            r14 = r18
            goto L_0x009e
        L_0x0097:
            r13 = r17
            r14 = r18
            r7.m6015a(r13, r14, r8, r9)     // Catch:{ IOException -> 0x00e5 }
        L_0x009e:
            r15 = r20
            r7.m6017a(r10, r15, r8, r9)     // Catch:{ IOException -> 0x00e3 }
            b.ae r0 = r7.f4523h     // Catch:{ IOException -> 0x00e3 }
            java.net.InetSocketAddress r0 = r0.mo6518c()     // Catch:{ IOException -> 0x00e3 }
            b.ae r1 = r7.f4523h     // Catch:{ IOException -> 0x00e3 }
            java.net.Proxy r1 = r1.mo6517b()     // Catch:{ IOException -> 0x00e3 }
            b.y r2 = r7.f4527l     // Catch:{ IOException -> 0x00e3 }
            r9.mo6619a(r8, r0, r1, r2)     // Catch:{ IOException -> 0x00e3 }
        L_0x00b4:
            b.ae r0 = r7.f4523h
            boolean r0 = r0.mo6519d()
            if (r0 == 0) goto L_0x00ce
            java.net.Socket r0 = r7.f4524i
            if (r0 == 0) goto L_0x00c1
            goto L_0x00ce
        L_0x00c1:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = "Too many tunnel connections attempted: 21"
            r0.<init>(r1)
            b.a.b.e r1 = new b.a.b.e
            r1.<init>(r0)
            throw r1
        L_0x00ce:
            b.a.e.g r0 = r7.f4528m
            if (r0 == 0) goto L_0x00e2
            b.j r1 = r7.f4522g
            monitor-enter(r1)
            b.a.e.g r0 = r7.f4528m     // Catch:{ all -> 0x00df }
            int r0 = r0.mo6318a()     // Catch:{ all -> 0x00df }
            r7.f4519c = r0     // Catch:{ all -> 0x00df }
            monitor-exit(r1)     // Catch:{ all -> 0x00df }
            goto L_0x00e2
        L_0x00df:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00df }
            throw r0
        L_0x00e2:
            return
        L_0x00e3:
            r0 = move-exception
            goto L_0x00ee
        L_0x00e5:
            r0 = move-exception
            goto L_0x00ec
        L_0x00e7:
            r0 = move-exception
            r13 = r17
            r14 = r18
        L_0x00ec:
            r15 = r20
        L_0x00ee:
            java.net.Socket r1 = r7.f4525j
            p091b.p092a.C1508c.m6083a(r1)
            java.net.Socket r1 = r7.f4524i
            p091b.p092a.C1508c.m6083a(r1)
            r7.f4525j = r11
            r7.f4524i = r11
            r7.f4529n = r11
            r7.f4530o = r11
            r7.f4526k = r11
            r7.f4527l = r11
            r7.f4528m = r11
            b.ae r1 = r7.f4523h
            java.net.InetSocketAddress r3 = r1.mo6518c()
            b.ae r1 = r7.f4523h
            java.net.Proxy r4 = r1.mo6517b()
            r5 = 0
            r1 = r23
            r2 = r22
            r6 = r0
            r1.mo6620a(r2, r3, r4, r5, r6)
            if (r12 != 0) goto L_0x0124
            b.a.b.e r1 = new b.a.b.e
            r1.<init>(r0)
            r12 = r1
            goto L_0x0127
        L_0x0124:
            r12.mo6247a(r0)
        L_0x0127:
            if (r21 == 0) goto L_0x0131
            boolean r0 = r10.mo6229a(r0)
            if (r0 == 0) goto L_0x0131
            goto L_0x0076
        L_0x0131:
            throw r12
        L_0x0132:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p094b.C1501c.mo6232a(int, int, int, int, boolean, b.e, b.p):void");
    }

    /* renamed from: a */
    private void m6014a(int i, int i2, int i3, C1614e eVar, C1633p pVar) throws IOException {
        C1590aa f = m6019f();
        C1642t a = f.mo6454a();
        int i4 = 0;
        while (i4 < 21) {
            m6015a(i, i2, eVar, pVar);
            f = m6013a(i2, i3, f, a);
            if (f != null) {
                C1508c.m6083a(this.f4524i);
                this.f4524i = null;
                this.f4530o = null;
                this.f4529n = null;
                pVar.mo6619a(eVar, this.f4523h.mo6518c(), this.f4523h.mo6517b(), null);
                i4++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m6015a(int i, int i2, C1614e eVar, C1633p pVar) throws IOException {
        Socket socket;
        Proxy b = this.f4523h.mo6517b();
        C1482a a = this.f4523h.mo6516a();
        if (b.type() == Type.DIRECT || b.type() == Type.HTTP) {
            socket = a.mo6162c().createSocket();
        } else {
            socket = new Socket(b);
        }
        this.f4524i = socket;
        pVar.mo6618a(eVar, this.f4523h.mo6518c(), b);
        this.f4524i.setSoTimeout(i2);
        try {
            C1583f.m6443c().mo6425a(this.f4524i, this.f4523h.mo6518c(), i);
            try {
                this.f4529n = C1683l.m7033a(C1683l.m7043b(this.f4524i));
                this.f4530o = C1683l.m7032a(C1683l.m7037a(this.f4524i));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to connect to ");
            sb.append(this.f4523h.mo6518c());
            ConnectException connectException = new ConnectException(sb.toString());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* renamed from: a */
    private void m6017a(C1500b bVar, int i, C1614e eVar, C1633p pVar) throws IOException {
        if (this.f4523h.mo6516a().mo6170i() == null) {
            this.f4527l = C1654y.HTTP_1_1;
            this.f4525j = this.f4524i;
            return;
        }
        pVar.mo6621b(eVar);
        m6016a(bVar);
        pVar.mo6614a(eVar, this.f4526k);
        if (this.f4527l == C1654y.HTTP_2) {
            this.f4525j.setSoTimeout(0);
            this.f4528m = new C1550a(true).mo6342a(this.f4525j, this.f4523h.mo6516a().mo6159a().mo6669f(), this.f4529n, this.f4530o).mo6341a((C1551b) this).mo6340a(i).mo6343a();
            this.f4528m.mo6335c();
        }
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x011f A[Catch:{ all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0125 A[Catch:{ all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0128  */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6016a(p091b.p092a.p094b.C1500b r8) throws java.io.IOException {
        /*
            r7 = this;
            b.ae r0 = r7.f4523h
            b.a r0 = r0.mo6516a()
            javax.net.ssl.SSLSocketFactory r1 = r0.mo6170i()
            r2 = 0
            java.net.Socket r3 = r7.f4524i     // Catch:{ AssertionError -> 0x0118 }
            b.t r4 = r0.mo6159a()     // Catch:{ AssertionError -> 0x0118 }
            java.lang.String r4 = r4.mo6669f()     // Catch:{ AssertionError -> 0x0118 }
            b.t r5 = r0.mo6159a()     // Catch:{ AssertionError -> 0x0118 }
            int r5 = r5.mo6670g()     // Catch:{ AssertionError -> 0x0118 }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x0118 }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x0118 }
            b.k r8 = r8.mo6228a(r1)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            boolean r3 = r8.mo6584d()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            if (r3 == 0) goto L_0x0041
            b.a.g.f r3 = p091b.p092a.p099g.C1583f.m6443c()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            b.t r4 = r0.mo6159a()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.lang.String r4 = r4.mo6669f()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.util.List r5 = r0.mo6164e()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            r3.mo6426a(r1, r4, r5)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
        L_0x0041:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            boolean r4 = r7.m6018a(r3)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            if (r4 == 0) goto L_0x0108
            b.r r4 = p091b.C1639r.m6707a(r3)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            javax.net.ssl.HostnameVerifier r5 = r0.mo6171j()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            b.t r6 = r0.mo6159a()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.lang.String r6 = r6.mo6669f()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            boolean r3 = r5.verify(r6, r3)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            if (r3 == 0) goto L_0x00b6
            b.g r3 = r0.mo6172k()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            b.t r0 = r0.mo6159a()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.lang.String r0 = r0.mo6669f()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.util.List r5 = r4.mo6639c()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            r3.mo6560a(r0, r5)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            boolean r8 = r8.mo6584d()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            if (r8 == 0) goto L_0x0085
            b.a.g.f r8 = p091b.p092a.p099g.C1583f.m6443c()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.lang.String r2 = r8.mo6422a(r1)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
        L_0x0085:
            r7.f4525j = r1     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.net.Socket r8 = r7.f4525j     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            c.s r8 = p102c.C1683l.m7043b(r8)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            c.e r8 = p102c.C1683l.m7033a(r8)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            r7.f4529n = r8     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.net.Socket r8 = r7.f4525j     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            c.r r8 = p102c.C1683l.m7037a(r8)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            c.d r8 = p102c.C1683l.m7032a(r8)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            r7.f4530o = r8     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            r7.f4526k = r4     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            if (r2 == 0) goto L_0x00a8
            b.y r8 = p091b.C1654y.m6848a(r2)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            goto L_0x00aa
        L_0x00a8:
            b.y r8 = p091b.C1654y.HTTP_1_1     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
        L_0x00aa:
            r7.f4527l = r8     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            if (r1 == 0) goto L_0x00b5
            b.a.g.f r8 = p091b.p092a.p099g.C1583f.m6443c()
            r8.mo6438b(r1)
        L_0x00b5:
            return
        L_0x00b6:
            java.util.List r8 = r4.mo6639c()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            r3.<init>()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.lang.String r4 = "Hostname "
            r3.append(r4)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            b.t r0 = r0.mo6159a()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.lang.String r0 = r0.mo6669f()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.lang.String r0 = " not verified:\n    certificate: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.lang.String r0 = p091b.C1617g.m6614a(r8)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.lang.String r0 = "\n    DN: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.lang.String r0 = "\n    subjectAltNames: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.util.List r8 = p091b.p092a.p101i.C1588d.m6468a(r8)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            r3.append(r8)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.lang.String r8 = r3.toString()     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            r2.<init>(r8)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            throw r2     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
        L_0x0108:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            java.lang.String r0 = "a valid ssl session was not established"
            r8.<init>(r0)     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
            throw r8     // Catch:{ AssertionError -> 0x0112, all -> 0x0110 }
        L_0x0110:
            r8 = move-exception
            goto L_0x0126
        L_0x0112:
            r8 = move-exception
            r2 = r1
            goto L_0x0119
        L_0x0115:
            r8 = move-exception
            r1 = r2
            goto L_0x0126
        L_0x0118:
            r8 = move-exception
        L_0x0119:
            boolean r0 = p091b.p092a.C1508c.m6085a(r8)     // Catch:{ all -> 0x0115 }
            if (r0 == 0) goto L_0x0125
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0115 }
            r0.<init>(r8)     // Catch:{ all -> 0x0115 }
            throw r0     // Catch:{ all -> 0x0115 }
        L_0x0125:
            throw r8     // Catch:{ all -> 0x0115 }
        L_0x0126:
            if (r1 == 0) goto L_0x012f
            b.a.g.f r0 = p091b.p092a.p099g.C1583f.m6443c()
            r0.mo6438b(r1)
        L_0x012f:
            p091b.p092a.C1508c.m6083a(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p094b.C1501c.m6016a(b.a.b.b):void");
    }

    /* renamed from: a */
    private boolean m6018a(SSLSession sSLSession) {
        return !"NONE".equals(sSLSession.getProtocol()) && !"SSL_NULL_WITH_NULL_NULL".equals(sSLSession.getCipherSuite());
    }

    /* renamed from: a */
    private C1590aa m6013a(int i, int i2, C1590aa aaVar, C1642t tVar) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("CONNECT ");
        sb.append(C1508c.m6073a(tVar, true));
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        while (true) {
            C1526a aVar = new C1526a(null, null, this.f4529n, this.f4530o);
            this.f4529n.mo6186a().mo6912a((long) i, TimeUnit.MILLISECONDS);
            this.f4530o.mo6306a().mo6912a((long) i2, TimeUnit.MILLISECONDS);
            aVar.mo6299a(aaVar.mo6458c(), sb2);
            aVar.mo6275b();
            C1596ac a = aVar.mo6270a(false).mo6498a(aaVar).mo6506a();
            long a2 = C1517e.m6115a(a);
            if (a2 == -1) {
                a2 = 0;
            }
            C1695s b = aVar.mo6301b(a2);
            C1508c.m6092b(b, (int) BaseClientBuilder.API_PRIORITY_OTHER, TimeUnit.MILLISECONDS);
            b.close();
            int c = a.mo6481c();
            if (c != 200) {
                if (c == 407) {
                    C1590aa a3 = this.f4523h.mo6516a().mo6163d().mo6524a(this.f4523h, a);
                    if (a3 == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(a.mo6478a(HttpHeaders.CONNECTION))) {
                        return a3;
                    } else {
                        aaVar = a3;
                    }
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unexpected response code for CONNECT: ");
                    sb3.append(a.mo6481c());
                    throw new IOException(sb3.toString());
                }
            } else if (this.f4529n.mo6829c().mo6844f() && this.f4530o.mo6829c().mo6844f()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    /* renamed from: f */
    private C1590aa m6019f() {
        return new C1591a().mo6467a(this.f4523h.mo6516a().mo6159a()).mo6470a(HttpHeaders.HOST, C1508c.m6073a(this.f4523h.mo6516a().mo6159a(), true)).mo6470a("Proxy-Connection", "Keep-Alive").mo6470a(HttpHeaders.USER_AGENT, C1525d.m6161a()).mo6471a();
    }

    /* renamed from: a */
    public boolean mo6235a(C1482a aVar, C1601ae aeVar) {
        if (this.f4520d.size() >= this.f4519c || this.f4517a || !C1483a.f4446a.mo6181a(this.f4523h.mo6516a(), aVar)) {
            return false;
        }
        if (aVar.mo6159a().mo6669f().equals(mo6231a().mo6516a().mo6159a().mo6669f())) {
            return true;
        }
        if (this.f4528m == null || aeVar == null || aeVar.mo6517b().type() != Type.DIRECT || this.f4523h.mo6517b().type() != Type.DIRECT || !this.f4523h.mo6518c().equals(aeVar.mo6518c()) || aeVar.mo6516a().mo6171j() != C1588d.f4856a || !mo6236a(aVar.mo6159a())) {
            return false;
        }
        try {
            aVar.mo6172k().mo6560a(aVar.mo6159a().mo6669f(), mo6240d().mo6639c());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean mo6236a(C1642t tVar) {
        if (tVar.mo6670g() != this.f4523h.mo6516a().mo6159a().mo6670g()) {
            return false;
        }
        boolean z = true;
        if (tVar.mo6669f().equals(this.f4523h.mo6516a().mo6159a().mo6669f())) {
            return true;
        }
        if (this.f4526k == null || !C1588d.f4856a.mo6452a(tVar.mo6669f(), (X509Certificate) this.f4526k.mo6639c().get(0))) {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    public C1514c mo6230a(C1651x xVar, C1646a aVar, C1506g gVar) throws SocketException {
        if (this.f4528m != null) {
            return new C1541f(xVar, aVar, gVar, this.f4528m);
        }
        this.f4525j.setSoTimeout(aVar.mo6283c());
        this.f4529n.mo6186a().mo6912a((long) aVar.mo6283c(), TimeUnit.MILLISECONDS);
        this.f4530o.mo6306a().mo6912a((long) aVar.mo6284d(), TimeUnit.MILLISECONDS);
        return new C1526a(xVar, gVar, this.f4529n, this.f4530o);
    }

    /* renamed from: a */
    public C1601ae mo6231a() {
        return this.f4523h;
    }

    /* renamed from: b */
    public void mo6238b() {
        C1508c.m6083a(this.f4524i);
    }

    /* renamed from: c */
    public Socket mo6239c() {
        return this.f4525j;
    }

    /* renamed from: a */
    public boolean mo6237a(boolean z) {
        int soTimeout;
        if (this.f4525j.isClosed() || this.f4525j.isInputShutdown() || this.f4525j.isOutputShutdown()) {
            return false;
        }
        if (this.f4528m != null) {
            return !this.f4528m.mo6339d();
        }
        if (z) {
            try {
                soTimeout = this.f4525j.getSoTimeout();
                this.f4525j.setSoTimeout(1);
                if (this.f4529n.mo6844f()) {
                    this.f4525j.setSoTimeout(soTimeout);
                    return false;
                }
                this.f4525j.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f4525j.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void mo6234a(C1561i iVar) throws IOException {
        iVar.mo6359a(C1535b.REFUSED_STREAM);
    }

    /* renamed from: a */
    public void mo6233a(C1543g gVar) {
        synchronized (this.f4522g) {
            this.f4519c = gVar.mo6318a();
        }
    }

    /* renamed from: d */
    public C1639r mo6240d() {
        return this.f4526k;
    }

    /* renamed from: e */
    public boolean mo6241e() {
        return this.f4528m != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f4523h.mo6516a().mo6159a().mo6669f());
        sb.append(":");
        sb.append(this.f4523h.mo6516a().mo6159a().mo6670g());
        sb.append(", proxy=");
        sb.append(this.f4523h.mo6517b());
        sb.append(" hostAddress=");
        sb.append(this.f4523h.mo6518c());
        sb.append(" cipherSuite=");
        sb.append(this.f4526k != null ? this.f4526k.mo6638b() : "none");
        sb.append(" protocol=");
        sb.append(this.f4527l);
        sb.append('}');
        return sb.toString();
    }
}
