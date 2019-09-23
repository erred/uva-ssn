package p000a.p001a.p002a.p003a.p004a.p010e;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.HashMap;

/* renamed from: a.a.a.a.a.e.i */
/* compiled from: SystemKeyStore */
class C0102i {

    /* renamed from: a */
    final KeyStore f210a;

    /* renamed from: b */
    private final HashMap<Principal, X509Certificate> f211b;

    public C0102i(InputStream inputStream, String str) {
        KeyStore a = m364a(inputStream, str);
        this.f211b = m365a(a);
        this.f210a = a;
    }

    /* renamed from: a */
    public boolean mo241a(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = (X509Certificate) this.f211b.get(x509Certificate.getSubjectX500Principal());
        return x509Certificate2 != null && x509Certificate2.getPublicKey().equals(x509Certificate.getPublicKey());
    }

    /* renamed from: b */
    public X509Certificate mo242b(X509Certificate x509Certificate) {
        X509Certificate x509Certificate2 = (X509Certificate) this.f211b.get(x509Certificate.getIssuerX500Principal());
        if (x509Certificate2 == null || x509Certificate2.getSubjectX500Principal().equals(x509Certificate.getSubjectX500Principal())) {
            return null;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return x509Certificate2;
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private HashMap<Principal, X509Certificate> m365a(KeyStore keyStore) {
        try {
            HashMap<Principal, X509Certificate> hashMap = new HashMap<>();
            Enumeration aliases = keyStore.aliases();
            while (aliases.hasMoreElements()) {
                X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate((String) aliases.nextElement());
                if (x509Certificate != null) {
                    hashMap.put(x509Certificate.getSubjectX500Principal(), x509Certificate);
                }
            }
            return hashMap;
        } catch (KeyStoreException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    private KeyStore m364a(InputStream inputStream, String str) {
        BufferedInputStream bufferedInputStream;
        try {
            KeyStore instance = KeyStore.getInstance("BKS");
            bufferedInputStream = new BufferedInputStream(inputStream);
            instance.load(bufferedInputStream, str.toCharArray());
            bufferedInputStream.close();
            return instance;
        } catch (KeyStoreException e) {
            throw new AssertionError(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        } catch (CertificateException e3) {
            throw new AssertionError(e3);
        } catch (IOException e4) {
            throw new AssertionError(e4);
        } catch (Throwable th) {
            bufferedInputStream.close();
            throw th;
        }
    }
}
