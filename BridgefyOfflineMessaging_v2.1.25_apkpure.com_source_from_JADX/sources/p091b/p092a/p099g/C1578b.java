package p091b.p092a.p099g;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;
import org.conscrypt.OpenSSLProvider;
import p091b.C1654y;

/* renamed from: b.a.g.b */
/* compiled from: ConscryptPlatform */
public class C1578b extends C1583f {
    private C1578b() {
    }

    /* renamed from: f */
    private Provider m6422f() {
        return new OpenSSLProvider();
    }

    /* renamed from: a */
    public void mo6426a(SSLSocket sSLSocket, String str, List<C1654y> list) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            if (str != null) {
                Conscrypt.setUseSessionTickets(sSLSocket, true);
                Conscrypt.setHostname(sSLSocket, str);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) C1583f.m6440a(list).toArray(new String[0]));
            return;
        }
        super.mo6426a(sSLSocket, str, list);
    }

    /* renamed from: a */
    public String mo6422a(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return super.mo6422a(sSLSocket);
    }

    /* renamed from: k_ */
    public SSLContext mo6437k_() {
        try {
            return SSLContext.getInstance("TLS", m6422f());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    /* renamed from: b */
    public static C1583f m6421b() {
        try {
            Class.forName("org.conscrypt.ConscryptEngineSocket");
            if (!Conscrypt.isAvailable()) {
                return null;
            }
            Conscrypt.setUseEngineSocketByDefault(true);
            return new C1578b();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
