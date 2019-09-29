package p091b.p092a.p099g;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import p091b.C1651x;
import p091b.C1654y;
import p091b.p092a.p101i.C1585a;
import p091b.p092a.p101i.C1586b;
import p091b.p092a.p101i.C1587c;
import p091b.p092a.p101i.C1589e;
import p102c.C1672c;

/* renamed from: b.a.g.f */
/* compiled from: Platform */
public class C1583f {

    /* renamed from: a */
    private static final C1583f f4844a = m6441b();

    /* renamed from: b */
    private static final Logger f4845b = Logger.getLogger(C1651x.class.getName());

    /* renamed from: a */
    public String mo6422a(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: a */
    public void mo6426a(SSLSocket sSLSocket, String str, List<C1654y> list) {
    }

    /* renamed from: b */
    public void mo6438b(SSLSocket sSLSocket) {
    }

    /* renamed from: b */
    public boolean mo6428b(String str) {
        return true;
    }

    /* renamed from: d */
    public String mo6445d() {
        return "OkHttp";
    }

    /* renamed from: c */
    public static C1583f m6443c() {
        return f4844a;
    }

    /* renamed from: a */
    public void mo6425a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: a */
    public void mo6423a(int i, String str, Throwable th) {
        f4845b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* renamed from: a */
    public Object mo6421a(String str) {
        if (f4845b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* renamed from: a */
    public void mo6424a(String str, Object obj) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
            str = sb.toString();
        }
        mo6423a(5, str, (Throwable) obj);
    }

    /* renamed from: a */
    public static List<String> m6440a(List<C1654y> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C1654y yVar = (C1654y) list.get(i);
            if (yVar != C1654y.HTTP_1_0) {
                arrayList.add(yVar.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public C1587c mo6420a(X509TrustManager x509TrustManager) {
        return new C1585a(mo6427b(x509TrustManager));
    }

    /* renamed from: e */
    public static boolean m6444e() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    /* renamed from: b */
    private static C1583f m6441b() {
        C1583f a = C1574a.m6403a();
        if (a != null) {
            return a;
        }
        if (m6444e()) {
            C1583f b = C1578b.m6421b();
            if (b != null) {
                return b;
            }
        }
        C1579c b2 = C1579c.m6426b();
        if (b2 != null) {
            return b2;
        }
        C1583f b3 = C1580d.m6429b();
        if (b3 != null) {
            return b3;
        }
        return new C1583f();
    }

    /* renamed from: b */
    static byte[] m6442b(List<C1654y> list) {
        C1672c cVar = new C1672c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C1654y yVar = (C1654y) list.get(i);
            if (yVar != C1654y.HTTP_1_0) {
                cVar.mo6854i(yVar.toString().length());
                cVar.mo6828b(yVar.toString());
            }
        }
        return cVar.mo6869s();
    }

    /* renamed from: k_ */
    public SSLContext mo6437k_() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    /* renamed from: b */
    public C1589e mo6427b(X509TrustManager x509TrustManager) {
        return new C1586b(x509TrustManager.getAcceptedIssuers());
    }
}
