package p091b.p092a.p101i;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import p091b.p092a.p099g.C1583f;

/* renamed from: b.a.i.c */
/* compiled from: CertificateChainCleaner */
public abstract class C1587c {
    /* renamed from: a */
    public abstract List<Certificate> mo6429a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;

    /* renamed from: a */
    public static C1587c m6466a(X509TrustManager x509TrustManager) {
        return C1583f.m6443c().mo6420a(x509TrustManager);
    }
}
