package p091b.p092a.p094b;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import p091b.C1482a;
import p091b.C1601ae;
import p091b.C1614e;
import p091b.C1622i;
import p091b.C1623j;
import p091b.C1633p;
import p091b.C1645u.C1646a;
import p091b.C1651x;
import p091b.p092a.C1483a;
import p091b.p092a.C1508c;
import p091b.p092a.p094b.C1504f.C1505a;
import p091b.p092a.p095c.C1514c;
import p091b.p092a.p097e.C1534a;
import p091b.p092a.p097e.C1535b;
import p091b.p092a.p097e.C1571n;

/* renamed from: b.a.b.g */
/* compiled from: StreamAllocation */
public final class C1506g {

    /* renamed from: d */
    static final /* synthetic */ boolean f4544d = (!C1506g.class.desiredAssertionStatus());

    /* renamed from: a */
    public final C1482a f4545a;

    /* renamed from: b */
    public final C1614e f4546b;

    /* renamed from: c */
    public final C1633p f4547c;

    /* renamed from: e */
    private C1505a f4548e;

    /* renamed from: f */
    private C1601ae f4549f;

    /* renamed from: g */
    private final C1623j f4550g;

    /* renamed from: h */
    private final Object f4551h;

    /* renamed from: i */
    private final C1504f f4552i;

    /* renamed from: j */
    private int f4553j;

    /* renamed from: k */
    private C1501c f4554k;

    /* renamed from: l */
    private boolean f4555l;

    /* renamed from: m */
    private boolean f4556m;

    /* renamed from: n */
    private boolean f4557n;

    /* renamed from: o */
    private C1514c f4558o;

    /* renamed from: b.a.b.g$a */
    /* compiled from: StreamAllocation */
    public static final class C1507a extends WeakReference<C1506g> {

        /* renamed from: a */
        public final Object f4559a;

        C1507a(C1506g gVar, Object obj) {
            super(gVar);
            this.f4559a = obj;
        }
    }

    public C1506g(C1623j jVar, C1482a aVar, C1614e eVar, C1633p pVar, Object obj) {
        this.f4550g = jVar;
        this.f4545a = aVar;
        this.f4546b = eVar;
        this.f4547c = pVar;
        this.f4552i = new C1504f(aVar, m6054i(), eVar, pVar);
        this.f4551h = obj;
    }

    /* renamed from: a */
    public C1514c mo6255a(C1651x xVar, C1646a aVar, boolean z) {
        try {
            C1514c a = m6050a(aVar.mo6282b(), aVar.mo6283c(), aVar.mo6284d(), xVar.mo6708d(), xVar.mo6724t(), z).mo6230a(xVar, aVar, this);
            synchronized (this.f4550g) {
                this.f4558o = a;
            }
            return a;
        } catch (IOException e) {
            throw new C1503e(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.mo6237a(r9) != false) goto L_0x0018;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p091b.p092a.p094b.C1501c m6050a(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            b.a.b.c r0 = r3.m6049a(r4, r5, r6, r7, r8)
            b.j r1 = r3.f4550g
            monitor-enter(r1)
            int r2 = r0.f4518b     // Catch:{ all -> 0x0019 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return r0
        L_0x000d:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            boolean r1 = r0.mo6237a(r9)
            if (r1 != 0) goto L_0x0018
            r3.mo6263e()
            goto L_0x0000
        L_0x0018:
            return r0
        L_0x0019:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.p092a.p094b.C1506g.m6050a(int, int, int, int, boolean, boolean):b.a.b.c");
    }

    /* renamed from: a */
    private C1501c m6049a(int i, int i2, int i3, int i4, boolean z) throws IOException {
        Socket h;
        Socket socket;
        C1501c cVar;
        C1501c cVar2;
        C1601ae aeVar;
        C1501c cVar3;
        boolean z2;
        boolean z3;
        synchronized (this.f4550g) {
            if (this.f4556m) {
                throw new IllegalStateException("released");
            } else if (this.f4558o != null) {
                throw new IllegalStateException("codec != null");
            } else if (!this.f4557n) {
                C1501c cVar4 = this.f4554k;
                h = m6053h();
                socket = null;
                if (this.f4554k != null) {
                    cVar2 = this.f4554k;
                    cVar = null;
                } else {
                    cVar = cVar4;
                    cVar2 = null;
                }
                if (!this.f4555l) {
                    cVar = null;
                }
                if (cVar2 == null) {
                    C1483a.f4446a.mo6175a(this.f4550g, this.f4545a, this, null);
                    if (this.f4554k != null) {
                        cVar3 = this.f4554k;
                        aeVar = null;
                        z2 = true;
                    } else {
                        aeVar = this.f4549f;
                        cVar3 = cVar2;
                    }
                } else {
                    cVar3 = cVar2;
                    aeVar = null;
                }
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        C1508c.m6083a(h);
        if (cVar != null) {
            this.f4547c.mo6623b(this.f4546b, (C1622i) cVar);
        }
        if (z2) {
            this.f4547c.mo6613a(this.f4546b, (C1622i) cVar3);
        }
        if (cVar3 != null) {
            return cVar3;
        }
        if (aeVar != null || (this.f4548e != null && this.f4548e.mo6251a())) {
            z3 = false;
        } else {
            this.f4548e = this.f4552i.mo6250b();
            z3 = true;
        }
        synchronized (this.f4550g) {
            if (!this.f4557n) {
                if (z3) {
                    List c = this.f4548e.mo6253c();
                    int size = c.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        C1601ae aeVar2 = (C1601ae) c.get(i5);
                        C1483a.f4446a.mo6175a(this.f4550g, this.f4545a, this, aeVar2);
                        if (this.f4554k != null) {
                            cVar3 = this.f4554k;
                            this.f4549f = aeVar2;
                            z2 = true;
                            break;
                        }
                        i5++;
                    }
                }
                if (!z2) {
                    if (aeVar == null) {
                        aeVar = this.f4548e.mo6252b();
                    }
                    this.f4549f = aeVar;
                    this.f4553j = 0;
                    cVar3 = new C1501c(this.f4550g, aeVar);
                    mo6257a(cVar3, false);
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (z2) {
            this.f4547c.mo6613a(this.f4546b, (C1622i) cVar3);
            return cVar3;
        }
        cVar3.mo6232a(i, i2, i3, i4, z, this.f4546b, this.f4547c);
        m6054i().mo6244b(cVar3.mo6231a());
        synchronized (this.f4550g) {
            this.f4555l = true;
            C1483a.f4446a.mo6183b(this.f4550g, cVar3);
            if (cVar3.mo6241e()) {
                socket = C1483a.f4446a.mo6177a(this.f4550g, this.f4545a, this);
                cVar3 = this.f4554k;
            }
        }
        C1508c.m6083a(socket);
        this.f4547c.mo6613a(this.f4546b, (C1622i) cVar3);
        return cVar3;
    }

    /* renamed from: h */
    private Socket m6053h() {
        if (f4544d || Thread.holdsLock(this.f4550g)) {
            C1501c cVar = this.f4554k;
            if (cVar == null || !cVar.f4517a) {
                return null;
            }
            return m6051a(false, false, true);
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public void mo6259a(boolean z, C1514c cVar, long j, IOException iOException) {
        C1501c cVar2;
        Socket a;
        boolean z2;
        this.f4547c.mo6622b(this.f4546b, j);
        synchronized (this.f4550g) {
            if (cVar != null) {
                if (cVar == this.f4558o) {
                    if (!z) {
                        this.f4554k.f4518b++;
                    }
                    cVar2 = this.f4554k;
                    a = m6051a(z, false, true);
                    if (this.f4554k != null) {
                        cVar2 = null;
                    }
                    z2 = this.f4556m;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("expected ");
            sb.append(this.f4558o);
            sb.append(" but was ");
            sb.append(cVar);
            throw new IllegalStateException(sb.toString());
        }
        C1508c.m6083a(a);
        if (cVar2 != null) {
            this.f4547c.mo6623b(this.f4546b, (C1622i) cVar2);
        }
        if (iOException != null) {
            this.f4547c.mo6615a(this.f4546b, iOException);
        } else if (z2) {
            this.f4547c.mo6628g(this.f4546b);
        }
    }

    /* renamed from: a */
    public C1514c mo6254a() {
        C1514c cVar;
        synchronized (this.f4550g) {
            cVar = this.f4558o;
        }
        return cVar;
    }

    /* renamed from: i */
    private C1502d m6054i() {
        return C1483a.f4446a.mo6176a(this.f4550g);
    }

    /* renamed from: b */
    public C1601ae mo6260b() {
        return this.f4549f;
    }

    /* renamed from: c */
    public synchronized C1501c mo6261c() {
        return this.f4554k;
    }

    /* renamed from: d */
    public void mo6262d() {
        C1501c cVar;
        Socket a;
        synchronized (this.f4550g) {
            cVar = this.f4554k;
            a = m6051a(false, true, false);
            if (this.f4554k != null) {
                cVar = null;
            }
        }
        C1508c.m6083a(a);
        if (cVar != null) {
            this.f4547c.mo6623b(this.f4546b, (C1622i) cVar);
        }
    }

    /* renamed from: e */
    public void mo6263e() {
        C1501c cVar;
        Socket a;
        synchronized (this.f4550g) {
            cVar = this.f4554k;
            a = m6051a(true, false, false);
            if (this.f4554k != null) {
                cVar = null;
            }
        }
        C1508c.m6083a(a);
        if (cVar != null) {
            this.f4547c.mo6623b(this.f4546b, (C1622i) cVar);
        }
    }

    /* renamed from: a */
    private Socket m6051a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (f4544d || Thread.holdsLock(this.f4550g)) {
            if (z3) {
                this.f4558o = null;
            }
            if (z2) {
                this.f4556m = true;
            }
            if (this.f4554k != null) {
                if (z) {
                    this.f4554k.f4517a = true;
                }
                if (this.f4558o == null && (this.f4556m || this.f4554k.f4517a)) {
                    m6052b(this.f4554k);
                    if (this.f4554k.f4520d.isEmpty()) {
                        this.f4554k.f4521e = System.nanoTime();
                        if (C1483a.f4446a.mo6182a(this.f4550g, this.f4554k)) {
                            socket = this.f4554k.mo6239c();
                            this.f4554k = null;
                            return socket;
                        }
                    }
                    socket = null;
                    this.f4554k = null;
                    return socket;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: f */
    public void mo6264f() {
        C1514c cVar;
        C1501c cVar2;
        synchronized (this.f4550g) {
            this.f4557n = true;
            cVar = this.f4558o;
            cVar2 = this.f4554k;
        }
        if (cVar != null) {
            cVar.mo6276c();
        } else if (cVar2 != null) {
            cVar2.mo6238b();
        }
    }

    /* renamed from: a */
    public void mo6258a(IOException iOException) {
        boolean z;
        C1501c cVar;
        Socket a;
        synchronized (this.f4550g) {
            if (iOException instanceof C1571n) {
                C1571n nVar = (C1571n) iOException;
                if (nVar.f4816a == C1535b.REFUSED_STREAM) {
                    this.f4553j++;
                }
                if (nVar.f4816a != C1535b.REFUSED_STREAM || this.f4553j > 1) {
                    this.f4549f = null;
                }
                z = false;
                cVar = this.f4554k;
                a = m6051a(z, false, true);
                if (this.f4554k != null || !this.f4555l) {
                    cVar = null;
                }
            } else {
                if (this.f4554k != null && (!this.f4554k.mo6241e() || (iOException instanceof C1534a))) {
                    if (this.f4554k.f4518b == 0) {
                        if (!(this.f4549f == null || iOException == null)) {
                            this.f4552i.mo6248a(this.f4549f, iOException);
                        }
                        this.f4549f = null;
                    }
                }
                z = false;
                cVar = this.f4554k;
                a = m6051a(z, false, true);
                cVar = null;
            }
            z = true;
            cVar = this.f4554k;
            a = m6051a(z, false, true);
            cVar = null;
        }
        C1508c.m6083a(a);
        if (cVar != null) {
            this.f4547c.mo6623b(this.f4546b, (C1622i) cVar);
        }
    }

    /* renamed from: a */
    public void mo6257a(C1501c cVar, boolean z) {
        if (!f4544d && !Thread.holdsLock(this.f4550g)) {
            throw new AssertionError();
        } else if (this.f4554k == null) {
            this.f4554k = cVar;
            this.f4555l = z;
            cVar.f4520d.add(new C1507a(this, this.f4551h));
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: b */
    private void m6052b(C1501c cVar) {
        int size = cVar.f4520d.size();
        for (int i = 0; i < size; i++) {
            if (((Reference) cVar.f4520d.get(i)).get() == this) {
                cVar.f4520d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public Socket mo6256a(C1501c cVar) {
        if (!f4544d && !Thread.holdsLock(this.f4550g)) {
            throw new AssertionError();
        } else if (this.f4558o == null && this.f4554k.f4520d.size() == 1) {
            Reference reference = (Reference) this.f4554k.f4520d.get(0);
            Socket a = m6051a(true, false, false);
            this.f4554k = cVar;
            cVar.f4520d.add(reference);
            return a;
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: g */
    public boolean mo6265g() {
        return this.f4549f != null || (this.f4548e != null && this.f4548e.mo6251a()) || this.f4552i.mo6249a();
    }

    public String toString() {
        C1501c c = mo6261c();
        return c != null ? c.toString() : this.f4545a.toString();
    }
}
