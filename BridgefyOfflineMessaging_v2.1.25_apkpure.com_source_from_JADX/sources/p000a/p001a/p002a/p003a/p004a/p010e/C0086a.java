package p000a.p001a.p002a.p003a.p004a.p010e;

import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

/* renamed from: a.a.a.a.a.e.a */
/* compiled from: CertificateChainCleaner */
final class C0086a {
    /* renamed from: a */
    public static X509Certificate[] m280a(X509Certificate[] x509CertificateArr, C0102i iVar) throws CertificateException {
        LinkedList linkedList = new LinkedList();
        boolean a = iVar.mo241a(x509CertificateArr[0]);
        linkedList.add(x509CertificateArr[0]);
        boolean z = true;
        boolean z2 = a;
        int i = 1;
        while (i < x509CertificateArr.length) {
            if (iVar.mo241a(x509CertificateArr[i])) {
                z2 = true;
            }
            if (!m279a(x509CertificateArr[i], x509CertificateArr[i - 1])) {
                break;
            }
            linkedList.add(x509CertificateArr[i]);
            i++;
        }
        X509Certificate b = iVar.mo242b(x509CertificateArr[i - 1]);
        if (b != null) {
            linkedList.add(b);
        } else {
            z = z2;
        }
        if (z) {
            return (X509Certificate[]) linkedList.toArray(new X509Certificate[linkedList.size()]);
        }
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
    }

    /* renamed from: a */
    private static boolean m279a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getSubjectX500Principal().equals(x509Certificate2.getIssuerX500Principal())) {
            return false;
        }
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
