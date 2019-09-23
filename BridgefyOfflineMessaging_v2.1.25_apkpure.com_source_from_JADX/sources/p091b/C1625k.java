package p091b;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import p091b.p092a.C1508c;

/* renamed from: b.k */
/* compiled from: ConnectionSpec */
public final class C1625k {

    /* renamed from: a */
    public static final C1625k f5109a = new C1626a(true).mo6590a(f5112h).mo6589a(C1602af.TLS_1_3, C1602af.TLS_1_2, C1602af.TLS_1_1, C1602af.TLS_1_0).mo6588a(true).mo6592a();

    /* renamed from: b */
    public static final C1625k f5110b = new C1626a(f5109a).mo6589a(C1602af.TLS_1_0).mo6588a(true).mo6592a();

    /* renamed from: c */
    public static final C1625k f5111c = new C1626a(false).mo6592a();

    /* renamed from: h */
    private static final C1620h[] f5112h = {C1620h.f5035aX, C1620h.f5066bb, C1620h.f5036aY, C1620h.f5067bc, C1620h.f5073bi, C1620h.f5072bh, C1620h.f5020aI, C1620h.f5021aJ, C1620h.f5044ag, C1620h.f5045ah, C1620h.f4989E, C1620h.f4993I, C1620h.f5081i};

    /* renamed from: d */
    final boolean f5113d;

    /* renamed from: e */
    final boolean f5114e;

    /* renamed from: f */
    final String[] f5115f;

    /* renamed from: g */
    final String[] f5116g;

    /* renamed from: b.k$a */
    /* compiled from: ConnectionSpec */
    public static final class C1626a {

        /* renamed from: a */
        boolean f5117a;

        /* renamed from: b */
        String[] f5118b;

        /* renamed from: c */
        String[] f5119c;

        /* renamed from: d */
        boolean f5120d;

        C1626a(boolean z) {
            this.f5117a = z;
        }

        public C1626a(C1625k kVar) {
            this.f5117a = kVar.f5113d;
            this.f5118b = kVar.f5115f;
            this.f5119c = kVar.f5116g;
            this.f5120d = kVar.f5114e;
        }

        /* renamed from: a */
        public C1626a mo6590a(C1620h... hVarArr) {
            if (this.f5117a) {
                String[] strArr = new String[hVarArr.length];
                for (int i = 0; i < hVarArr.length; i++) {
                    strArr[i] = hVarArr[i].f5099bj;
                }
                return mo6591a(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        /* renamed from: a */
        public C1626a mo6591a(String... strArr) {
            if (!this.f5117a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f5118b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        /* renamed from: a */
        public C1626a mo6589a(C1602af... afVarArr) {
            if (this.f5117a) {
                String[] strArr = new String[afVarArr.length];
                for (int i = 0; i < afVarArr.length; i++) {
                    strArr[i] = afVarArr[i].f4918f;
                }
                return mo6593b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        /* renamed from: b */
        public C1626a mo6593b(String... strArr) {
            if (!this.f5117a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f5119c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        /* renamed from: a */
        public C1626a mo6588a(boolean z) {
            if (this.f5117a) {
                this.f5120d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        /* renamed from: a */
        public C1625k mo6592a() {
            return new C1625k(this);
        }
    }

    C1625k(C1626a aVar) {
        this.f5113d = aVar.f5117a;
        this.f5115f = aVar.f5118b;
        this.f5116g = aVar.f5119c;
        this.f5114e = aVar.f5120d;
    }

    /* renamed from: a */
    public boolean mo6580a() {
        return this.f5113d;
    }

    /* renamed from: b */
    public List<C1620h> mo6582b() {
        if (this.f5115f != null) {
            return C1620h.m6624a(this.f5115f);
        }
        return null;
    }

    /* renamed from: c */
    public List<C1602af> mo6583c() {
        if (this.f5116g != null) {
            return C1602af.m6560a(this.f5116g);
        }
        return null;
    }

    /* renamed from: d */
    public boolean mo6584d() {
        return this.f5114e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6579a(SSLSocket sSLSocket, boolean z) {
        C1625k b = m6633b(sSLSocket, z);
        if (b.f5116g != null) {
            sSLSocket.setEnabledProtocols(b.f5116g);
        }
        if (b.f5115f != null) {
            sSLSocket.setEnabledCipherSuites(b.f5115f);
        }
    }

    /* renamed from: b */
    private C1625k m6633b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (this.f5115f != null) {
            strArr = C1508c.m6088a(C1620h.f5011a, sSLSocket.getEnabledCipherSuites(), this.f5115f);
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f5116g != null) {
            strArr2 = C1508c.m6088a(C1508c.f4567h, sSLSocket.getEnabledProtocols(), this.f5116g);
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a = C1508c.m6071a(C1620h.f5011a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a != -1) {
            strArr = C1508c.m6089a(strArr, supportedCipherSuites[a]);
        }
        return new C1626a(this).mo6591a(strArr).mo6593b(strArr2).mo6592a();
    }

    /* renamed from: a */
    public boolean mo6581a(SSLSocket sSLSocket) {
        if (!this.f5113d) {
            return false;
        }
        if (this.f5116g != null && !C1508c.m6093b(C1508c.f4567h, this.f5116g, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        if (this.f5115f == null || C1508c.m6093b(C1620h.f5011a, this.f5115f, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1625k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C1625k kVar = (C1625k) obj;
        if (this.f5113d != kVar.f5113d) {
            return false;
        }
        return !this.f5113d || (Arrays.equals(this.f5115f, kVar.f5115f) && Arrays.equals(this.f5116g, kVar.f5116g) && this.f5114e == kVar.f5114e);
    }

    public int hashCode() {
        if (this.f5113d) {
            return ((((527 + Arrays.hashCode(this.f5115f)) * 31) + Arrays.hashCode(this.f5116g)) * 31) + (this.f5114e ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f5113d) {
            return "ConnectionSpec()";
        }
        String obj = this.f5115f != null ? mo6582b().toString() : "[all enabled]";
        String obj2 = this.f5116g != null ? mo6583c().toString() : "[all enabled]";
        StringBuilder sb = new StringBuilder();
        sb.append("ConnectionSpec(cipherSuites=");
        sb.append(obj);
        sb.append(", tlsVersions=");
        sb.append(obj2);
        sb.append(", supportsTlsExtensions=");
        sb.append(this.f5114e);
        sb.append(")");
        return sb.toString();
    }
}
