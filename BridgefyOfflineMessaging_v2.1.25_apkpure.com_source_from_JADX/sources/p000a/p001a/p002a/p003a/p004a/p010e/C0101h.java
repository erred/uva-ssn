package p000a.p001a.p002a.p003a.p004a.p010e;

import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import p000a.p001a.p002a.p003a.C0135c;

/* renamed from: a.a.a.a.a.e.h */
/* compiled from: PinningTrustManager */
class C0101h implements X509TrustManager {

    /* renamed from: a */
    private static final X509Certificate[] f204a = new X509Certificate[0];

    /* renamed from: b */
    private final TrustManager[] f205b;

    /* renamed from: c */
    private final C0102i f206c;

    /* renamed from: d */
    private final long f207d;

    /* renamed from: e */
    private final List<byte[]> f208e = new LinkedList();

    /* renamed from: f */
    private final Set<X509Certificate> f209f = Collections.synchronizedSet(new HashSet());

    public C0101h(C0102i iVar, C0100g gVar) {
        this.f205b = m363a(iVar);
        this.f206c = iVar;
        this.f207d = gVar.mo237d();
        for (String a : gVar.mo236c()) {
            this.f208e.add(m362a(a));
        }
    }

    /* renamed from: a */
    private TrustManager[] m363a(C0102i iVar) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(iVar.f210a);
            return instance.getTrustManagers();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (KeyStoreException e2) {
            throw new AssertionError(e2);
        }
    }

    /* renamed from: a */
    private boolean m361a(X509Certificate x509Certificate) throws CertificateException {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.f208e) {
                if (Arrays.equals(equals, digest)) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchAlgorithmException e) {
            throw new CertificateException(e);
        }
    }

    /* renamed from: a */
    private void m360a(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        for (TrustManager trustManager : this.f205b) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    /* renamed from: a */
    private void m359a(X509Certificate[] x509CertificateArr) throws CertificateException {
        if (this.f207d == -1 || System.currentTimeMillis() - this.f207d <= 15552000000L) {
            X509Certificate[] a = C0086a.m280a(x509CertificateArr, this.f206c);
            int length = a.length;
            int i = 0;
            while (i < length) {
                if (!m361a(a[i])) {
                    i++;
                } else {
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pins are stale, (");
        sb.append(System.currentTimeMillis() - this.f207d);
        sb.append(" millis vs ");
        sb.append(15552000000L);
        sb.append(" millis) falling back to system trust.");
        C0135c.m449h().mo277d("Fabric", sb.toString());
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (!this.f209f.contains(x509CertificateArr[0])) {
            m360a(x509CertificateArr, str);
            m359a(x509CertificateArr);
            this.f209f.add(x509CertificateArr[0]);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return f204a;
    }

    /* renamed from: a */
    private byte[] m362a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
