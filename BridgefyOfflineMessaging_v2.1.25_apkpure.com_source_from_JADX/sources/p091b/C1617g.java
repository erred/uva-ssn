package p091b;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import p091b.p092a.C1508c;
import p091b.p092a.p101i.C1587c;
import p102c.C1677f;

/* renamed from: b.g */
/* compiled from: CertificatePinner */
public final class C1617g {

    /* renamed from: a */
    public static final C1617g f4977a = new C1618a().mo6564a();

    /* renamed from: b */
    private final Set<C1619b> f4978b;

    /* renamed from: c */
    private final C1587c f4979c;

    /* renamed from: b.g$a */
    /* compiled from: CertificatePinner */
    public static final class C1618a {

        /* renamed from: a */
        private final List<C1619b> f4980a = new ArrayList();

        /* renamed from: a */
        public C1618a mo6563a(String str, String... strArr) {
            if (str != null) {
                for (String bVar : strArr) {
                    this.f4980a.add(new C1619b(str, bVar));
                }
                return this;
            }
            throw new NullPointerException("pattern == null");
        }

        /* renamed from: a */
        public C1617g mo6564a() {
            return new C1617g(new LinkedHashSet(this.f4980a), null);
        }
    }

    /* renamed from: b.g$b */
    /* compiled from: CertificatePinner */
    static final class C1619b {

        /* renamed from: a */
        final String f4981a;

        /* renamed from: b */
        final String f4982b;

        /* renamed from: c */
        final String f4983c;

        /* renamed from: d */
        final C1677f f4984d;

        C1619b(String str, String str2) {
            String str3;
            this.f4981a = str;
            if (str.startsWith("*.")) {
                StringBuilder sb = new StringBuilder();
                sb.append("http://");
                sb.append(str.substring("*.".length()));
                str3 = C1642t.m6741e(sb.toString()).mo6669f();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("http://");
                sb2.append(str);
                str3 = C1642t.m6741e(sb2.toString()).mo6669f();
            }
            this.f4982b = str3;
            if (str2.startsWith("sha1/")) {
                this.f4983c = "sha1/";
                this.f4984d = C1677f.m6988b(str2.substring("sha1/".length()));
            } else if (str2.startsWith("sha256/")) {
                this.f4983c = "sha256/";
                this.f4984d = C1677f.m6988b(str2.substring("sha256/".length()));
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("pins must start with 'sha256/' or 'sha1/': ");
                sb3.append(str2);
                throw new IllegalArgumentException(sb3.toString());
            }
            if (this.f4984d == null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("pins must be base64: ");
                sb4.append(str2);
                throw new IllegalArgumentException(sb4.toString());
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0030, code lost:
            if (r11.regionMatches(false, r0 + 1, r10.f4982b, 0, r10.f4982b.length()) != false) goto L_0x0034;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo6565a(java.lang.String r11) {
            /*
                r10 = this;
                java.lang.String r0 = r10.f4981a
                java.lang.String r1 = "*."
                boolean r0 = r0.startsWith(r1)
                if (r0 == 0) goto L_0x0035
                r0 = 46
                int r0 = r11.indexOf(r0)
                int r1 = r11.length()
                int r1 = r1 - r0
                r2 = 1
                int r1 = r1 - r2
                java.lang.String r3 = r10.f4982b
                int r3 = r3.length()
                if (r1 != r3) goto L_0x0033
                r5 = 0
                int r6 = r0 + 1
                java.lang.String r7 = r10.f4982b
                r8 = 0
                java.lang.String r0 = r10.f4982b
                int r9 = r0.length()
                r4 = r11
                boolean r11 = r4.regionMatches(r5, r6, r7, r8, r9)
                if (r11 == 0) goto L_0x0033
                goto L_0x0034
            L_0x0033:
                r2 = 0
            L_0x0034:
                return r2
            L_0x0035:
                java.lang.String r0 = r10.f4982b
                boolean r11 = r11.equals(r0)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: p091b.C1617g.C1619b.mo6565a(java.lang.String):boolean");
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1619b) {
                C1619b bVar = (C1619b) obj;
                if (this.f4981a.equals(bVar.f4981a) && this.f4983c.equals(bVar.f4983c) && this.f4984d.equals(bVar.f4984d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f4981a.hashCode()) * 31) + this.f4983c.hashCode()) * 31) + this.f4984d.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f4983c);
            sb.append(this.f4984d.mo6894b());
            return sb.toString();
        }
    }

    C1617g(Set<C1619b> set, C1587c cVar) {
        this.f4978b = set;
        this.f4979c = cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r3.f4978b.equals(r4.f4978b) != false) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 1
            if (r4 != r3) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r4 instanceof p091b.C1617g
            if (r1 == 0) goto L_0x001f
            b.a.i.c r1 = r3.f4979c
            b.g r4 = (p091b.C1617g) r4
            b.a.i.c r2 = r4.f4979c
            boolean r1 = p091b.p092a.C1508c.m6086a(r1, r2)
            if (r1 == 0) goto L_0x001f
            java.util.Set<b.g$b> r1 = r3.f4978b
            java.util.Set<b.g$b> r4 = r4.f4978b
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p091b.C1617g.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return ((this.f4979c != null ? this.f4979c.hashCode() : 0) * 31) + this.f4978b.hashCode();
    }

    /* renamed from: a */
    public void mo6560a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List a = mo6559a(str);
        if (!a.isEmpty()) {
            if (this.f4979c != null) {
                list = this.f4979c.mo6429a(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = a.size();
                C1677f fVar = null;
                C1677f fVar2 = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    C1619b bVar = (C1619b) a.get(i2);
                    if (bVar.f4983c.equals("sha256/")) {
                        if (fVar == null) {
                            fVar = m6615b(x509Certificate);
                        }
                        if (bVar.f4984d.equals(fVar)) {
                            return;
                        }
                    } else if (bVar.f4983c.equals("sha1/")) {
                        if (fVar2 == null) {
                            fVar2 = m6613a(x509Certificate);
                        }
                        if (bVar.f4984d.equals(fVar2)) {
                            return;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("unsupported hashAlgorithm: ");
                        sb.append(bVar.f4983c);
                        throw new AssertionError(sb.toString());
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Certificate pinning failure!");
            sb2.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                sb2.append("\n    ");
                sb2.append(m6614a((Certificate) x509Certificate2));
                sb2.append(": ");
                sb2.append(x509Certificate2.getSubjectDN().getName());
            }
            sb2.append("\n  Pinned certificates for ");
            sb2.append(str);
            sb2.append(":");
            int size4 = a.size();
            for (int i4 = 0; i4 < size4; i4++) {
                C1619b bVar2 = (C1619b) a.get(i4);
                sb2.append("\n    ");
                sb2.append(bVar2);
            }
            throw new SSLPeerUnverifiedException(sb2.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<C1619b> mo6559a(String str) {
        List<C1619b> emptyList = Collections.emptyList();
        for (C1619b bVar : this.f4978b) {
            if (bVar.mo6565a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1617g mo6558a(C1587c cVar) {
        if (C1508c.m6086a((Object) this.f4979c, (Object) cVar)) {
            return this;
        }
        return new C1617g(this.f4978b, cVar);
    }

    /* renamed from: a */
    public static String m6614a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder sb = new StringBuilder();
            sb.append("sha256/");
            sb.append(m6615b((X509Certificate) certificate).mo6894b());
            return sb.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* renamed from: a */
    static C1677f m6613a(X509Certificate x509Certificate) {
        return C1677f.m6986a(x509Certificate.getPublicKey().getEncoded()).mo6897d();
    }

    /* renamed from: b */
    static C1677f m6615b(X509Certificate x509Certificate) {
        return C1677f.m6986a(x509Certificate.getPublicKey().getEncoded()).mo6898e();
    }
}
