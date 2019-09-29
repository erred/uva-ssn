package p091b.p092a.p099g;

import android.os.Build.VERSION;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import p091b.C1654y;
import p091b.p092a.C1508c;
import p091b.p092a.p101i.C1587c;
import p091b.p092a.p101i.C1589e;

/* renamed from: b.a.g.a */
/* compiled from: AndroidPlatform */
class C1574a extends C1583f {

    /* renamed from: a */
    private final Class<?> f4818a;

    /* renamed from: b */
    private final C1582e<Socket> f4819b;

    /* renamed from: c */
    private final C1582e<Socket> f4820c;

    /* renamed from: d */
    private final C1582e<Socket> f4821d;

    /* renamed from: e */
    private final C1582e<Socket> f4822e;

    /* renamed from: f */
    private final C1577c f4823f = C1577c.m6418a();

    /* renamed from: b.a.g.a$a */
    /* compiled from: AndroidPlatform */
    static final class C1575a extends C1587c {

        /* renamed from: a */
        private final Object f4824a;

        /* renamed from: b */
        private final Method f4825b;

        public int hashCode() {
            return 0;
        }

        C1575a(Object obj, Method method) {
            this.f4824a = obj;
            this.f4825b = method;
        }

        /* renamed from: a */
        public List<Certificate> mo6429a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
                return (List) this.f4825b.invoke(this.f4824a, new Object[]{x509CertificateArr, "RSA", str});
            } catch (InvocationTargetException e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C1575a;
        }
    }

    /* renamed from: b.a.g.a$b */
    /* compiled from: AndroidPlatform */
    static final class C1576b implements C1589e {

        /* renamed from: a */
        private final X509TrustManager f4826a;

        /* renamed from: b */
        private final Method f4827b;

        C1576b(X509TrustManager x509TrustManager, Method method) {
            this.f4827b = method;
            this.f4826a = x509TrustManager;
        }

        /* renamed from: a */
        public X509Certificate mo6432a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f4827b.invoke(this.f4826a, new Object[]{x509Certificate});
                return trustAnchor != null ? trustAnchor.getTrustedCert() : null;
            } catch (IllegalAccessException e) {
                throw C1508c.m6072a("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1576b)) {
                return false;
            }
            C1576b bVar = (C1576b) obj;
            if (!this.f4826a.equals(bVar.f4826a) || !this.f4827b.equals(bVar.f4827b)) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return this.f4826a.hashCode() + (this.f4827b.hashCode() * 31);
        }
    }

    /* renamed from: b.a.g.a$c */
    /* compiled from: AndroidPlatform */
    static final class C1577c {

        /* renamed from: a */
        private final Method f4828a;

        /* renamed from: b */
        private final Method f4829b;

        /* renamed from: c */
        private final Method f4830c;

        C1577c(Method method, Method method2, Method method3) {
            this.f4828a = method;
            this.f4829b = method2;
            this.f4830c = method3;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public Object mo6435a(String str) {
            if (this.f4828a != null) {
                try {
                    Object invoke = this.f4828a.invoke(null, new Object[0]);
                    this.f4829b.invoke(invoke, new Object[]{str});
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo6436a(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f4830c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        /* renamed from: a */
        static C1577c m6418a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod("open", new Class[]{String.class});
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method2 = null;
                method = null;
            }
            return new C1577c(method3, method, method2);
        }
    }

    C1574a(Class<?> cls, C1582e<Socket> eVar, C1582e<Socket> eVar2, C1582e<Socket> eVar3, C1582e<Socket> eVar4) {
        this.f4818a = cls;
        this.f4819b = eVar;
        this.f4820c = eVar2;
        this.f4821d = eVar3;
        this.f4822e = eVar4;
    }

    /* renamed from: a */
    public void mo6425a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (C1508c.m6085a(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (SecurityException e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        } catch (ClassCastException e3) {
            if (VERSION.SDK_INT == 26) {
                IOException iOException2 = new IOException("Exception in connect");
                iOException2.initCause(e3);
                throw iOException2;
            }
            throw e3;
        }
    }

    /* renamed from: a */
    public void mo6426a(SSLSocket sSLSocket, String str, List<C1654y> list) {
        if (str != null) {
            this.f4819b.mo6442b(sSLSocket, Boolean.valueOf(true));
            this.f4820c.mo6442b(sSLSocket, str);
        }
        if (this.f4822e != null && this.f4822e.mo6441a(sSLSocket)) {
            this.f4822e.mo6444d(sSLSocket, m6442b(list));
        }
    }

    /* renamed from: a */
    public String mo6422a(SSLSocket sSLSocket) {
        String str = null;
        if (this.f4821d == null || !this.f4821d.mo6441a(sSLSocket)) {
            return null;
        }
        byte[] bArr = (byte[]) this.f4821d.mo6444d(sSLSocket, new Object[0]);
        if (bArr != null) {
            str = new String(bArr, C1508c.f4564e);
        }
        return str;
    }

    /* renamed from: a */
    public void mo6423a(int i, String str, Throwable th) {
        int min;
        int i2 = 5;
        if (i != 5) {
            i2 = 3;
        }
        if (th != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(10);
            sb.append(Log.getStackTraceString(th));
            str = sb.toString();
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    /* renamed from: a */
    public Object mo6421a(String str) {
        return this.f4823f.mo6435a(str);
    }

    /* renamed from: a */
    public void mo6424a(String str, Object obj) {
        if (!this.f4823f.mo6436a(obj)) {
            mo6423a(5, str, (Throwable) null);
        }
    }

    /* renamed from: b */
    public boolean mo6428b(String str) {
        try {
            Class cls = Class.forName("android.security.NetworkSecurityPolicy");
            return m6404a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.mo6428b(str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw C1508c.m6072a("unable to determine cleartext support", e);
        }
    }

    /* renamed from: a */
    private boolean m6404a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[]{String.class}).invoke(obj, new Object[]{str})).booleanValue();
        } catch (NoSuchMethodException unused) {
            return m6406b(str, cls, obj);
        }
    }

    /* renamed from: b */
    private boolean m6406b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.mo6428b(str);
        }
    }

    /* renamed from: b */
    private static boolean m6405b() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public C1587c mo6420a(X509TrustManager x509TrustManager) {
        try {
            Class cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C1575a(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception unused) {
            return super.mo6420a(x509TrustManager);
        }
    }

    /* renamed from: a */
    public static C1583f m6403a() {
        Class cls;
        C1582e eVar;
        C1582e eVar2;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException unused) {
            try {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        Class cls2 = cls;
        C1582e eVar3 = new C1582e(null, "setUseSessionTickets", Boolean.TYPE);
        C1582e eVar4 = new C1582e(null, "setHostname", String.class);
        if (m6405b()) {
            C1582e eVar5 = new C1582e(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            eVar = new C1582e(null, "setAlpnProtocols", byte[].class);
            eVar2 = eVar5;
        } else {
            eVar2 = null;
            eVar = null;
        }
        C1574a aVar = new C1574a(cls2, eVar3, eVar4, eVar2, eVar);
        return aVar;
    }

    /* renamed from: b */
    public C1589e mo6427b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new C1576b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo6427b(x509TrustManager);
        }
    }
}
