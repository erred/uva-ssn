package p091b;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import p091b.p092a.C1508c;

/* renamed from: b.r */
/* compiled from: Handshake */
public final class C1639r {

    /* renamed from: a */
    private final C1602af f5151a;

    /* renamed from: b */
    private final C1620h f5152b;

    /* renamed from: c */
    private final List<Certificate> f5153c;

    /* renamed from: d */
    private final List<Certificate> f5154d;

    private C1639r(C1602af afVar, C1620h hVar, List<Certificate> list, List<Certificate> list2) {
        this.f5151a = afVar;
        this.f5152b = hVar;
        this.f5153c = list;
        this.f5154d = list2;
    }

    /* renamed from: a */
    public static C1639r m6707a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            C1620h a = C1620h.m6622a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                C1602af a2 = C1602af.m6559a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = C1508c.m6079a((T[]) certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = C1508c.m6079a((T[]) localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                return new C1639r(a2, a, list, list2);
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    /* renamed from: a */
    public static C1639r m6706a(C1602af afVar, C1620h hVar, List<Certificate> list, List<Certificate> list2) {
        if (afVar == null) {
            throw new NullPointerException("tlsVersion == null");
        } else if (hVar != null) {
            return new C1639r(afVar, hVar, C1508c.m6078a(list), C1508c.m6078a(list2));
        } else {
            throw new NullPointerException("cipherSuite == null");
        }
    }

    /* renamed from: a */
    public C1602af mo6637a() {
        return this.f5151a;
    }

    /* renamed from: b */
    public C1620h mo6638b() {
        return this.f5152b;
    }

    /* renamed from: c */
    public List<Certificate> mo6639c() {
        return this.f5153c;
    }

    /* renamed from: d */
    public List<Certificate> mo6640d() {
        return this.f5154d;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C1639r)) {
            return false;
        }
        C1639r rVar = (C1639r) obj;
        if (this.f5151a.equals(rVar.f5151a) && this.f5152b.equals(rVar.f5152b) && this.f5153c.equals(rVar.f5153c) && this.f5154d.equals(rVar.f5154d)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((((((527 + this.f5151a.hashCode()) * 31) + this.f5152b.hashCode()) * 31) + this.f5153c.hashCode()) * 31) + this.f5154d.hashCode();
    }
}
