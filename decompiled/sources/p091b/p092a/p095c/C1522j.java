package p091b.p092a.p095c;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpStatusCodes;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import p091b.C1482a;
import p091b.C1590aa;
import p091b.C1590aa.C1591a;
import p091b.C1592ab;
import p091b.C1596ac;
import p091b.C1598ad;
import p091b.C1601ae;
import p091b.C1614e;
import p091b.C1617g;
import p091b.C1633p;
import p091b.C1642t;
import p091b.C1645u;
import p091b.C1645u.C1646a;
import p091b.C1651x;
import p091b.p092a.C1508c;
import p091b.p092a.p094b.C1503e;
import p091b.p092a.p094b.C1506g;
import p091b.p092a.p097e.C1534a;

/* renamed from: b.a.c.j */
/* compiled from: RetryAndFollowUpInterceptor */
public final class C1522j implements C1645u {

    /* renamed from: a */
    private final C1651x f4602a;

    /* renamed from: b */
    private final boolean f4603b;

    /* renamed from: c */
    private volatile C1506g f4604c;

    /* renamed from: d */
    private Object f4605d;

    /* renamed from: e */
    private volatile boolean f4606e;

    public C1522j(C1651x xVar, boolean z) {
        this.f4602a = xVar;
        this.f4603b = z;
    }

    /* renamed from: a */
    public void mo6293a() {
        this.f4606e = true;
        C1506g gVar = this.f4604c;
        if (gVar != null) {
            gVar.mo6264f();
        }
    }

    /* renamed from: b */
    public boolean mo6295b() {
        return this.f4606e;
    }

    /* renamed from: a */
    public void mo6294a(Object obj) {
        this.f4605d = obj;
    }

    /* renamed from: a */
    public C1596ac mo6184a(C1646a aVar) throws IOException {
        C1590aa a = aVar.mo6279a();
        C1519g gVar = (C1519g) aVar;
        C1614e h = gVar.mo6288h();
        C1633p i = gVar.mo6289i();
        C1506g gVar2 = new C1506g(this.f4602a.mo6721q(), m6151a(a.mo6454a()), h, i, this.f4605d);
        this.f4604c = gVar2;
        C1596ac acVar = null;
        int i2 = 0;
        while (!this.f4606e) {
            try {
                C1596ac a2 = gVar.mo6281a(a, gVar2, null, null);
                C1596ac a3 = acVar != null ? a2.mo6488i().mo6509c(acVar.mo6488i().mo6500a((C1598ad) null).mo6506a()).mo6506a() : a2;
                C1590aa a4 = m6152a(a3, gVar2.mo6260b());
                if (a4 == null) {
                    if (!this.f4603b) {
                        gVar2.mo6262d();
                    }
                    return a3;
                }
                C1508c.m6082a((Closeable) a3.mo6487h());
                int i3 = i2 + 1;
                if (i3 > 20) {
                    gVar2.mo6262d();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Too many follow-up requests: ");
                    sb.append(i3);
                    throw new ProtocolException(sb.toString());
                } else if (!(a4.mo6459d() instanceof C1524l)) {
                    if (!m6153a(a3, a4.mo6454a())) {
                        gVar2.mo6262d();
                        gVar2 = new C1506g(this.f4602a.mo6721q(), m6151a(a4.mo6454a()), h, i, this.f4605d);
                        this.f4604c = gVar2;
                    } else if (gVar2.mo6254a() != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Closing the body of ");
                        sb2.append(a3);
                        sb2.append(" didn't close its backing stream. Bad interceptor?");
                        throw new IllegalStateException(sb2.toString());
                    }
                    acVar = a3;
                    a = a4;
                    i2 = i3;
                } else {
                    gVar2.mo6262d();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", a3.mo6481c());
                }
            } catch (C1503e e) {
                if (!m6154a(e.mo6246a(), gVar2, false, a)) {
                    throw e.mo6246a();
                }
            } catch (IOException e2) {
                if (!m6154a(e2, gVar2, !(e2 instanceof C1534a), a)) {
                    throw e2;
                }
            } catch (Throwable th) {
                gVar2.mo6258a((IOException) null);
                gVar2.mo6262d();
                throw th;
            }
        }
        gVar2.mo6262d();
        throw new IOException("Canceled");
    }

    /* renamed from: a */
    private C1482a m6151a(C1642t tVar) {
        C1617g gVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (tVar.mo6664c()) {
            SSLSocketFactory l = this.f4602a.mo6716l();
            hostnameVerifier = this.f4602a.mo6717m();
            sSLSocketFactory = l;
            gVar = this.f4602a.mo6718n();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        C1482a aVar = new C1482a(tVar.mo6669f(), tVar.mo6670g(), this.f4602a.mo6714j(), this.f4602a.mo6715k(), sSLSocketFactory, hostnameVerifier, gVar, this.f4602a.mo6720p(), this.f4602a.mo6709e(), this.f4602a.mo6726v(), this.f4602a.mo6727w(), this.f4602a.mo6710f());
        return aVar;
    }

    /* renamed from: a */
    private boolean m6154a(IOException iOException, C1506g gVar, boolean z, C1590aa aaVar) {
        gVar.mo6258a(iOException);
        if (!this.f4602a.mo6724t()) {
            return false;
        }
        if ((!z || !(aaVar.mo6459d() instanceof C1524l)) && m6155a(iOException, z) && gVar.mo6265g()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m6155a(IOException iOException, boolean z) {
        boolean z2 = false;
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if ((iOException instanceof SocketTimeoutException) && !z) {
                z2 = true;
            }
            return z2;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    private C1590aa m6152a(C1596ac acVar, C1601ae aeVar) throws IOException {
        Proxy proxy;
        if (acVar != null) {
            int c = acVar.mo6481c();
            String b = acVar.mo6477a().mo6456b();
            C1592ab abVar = null;
            switch (c) {
                case 300:
                case HttpStatusCodes.STATUS_CODE_MOVED_PERMANENTLY /*301*/:
                case 302:
                case HttpStatusCodes.STATUS_CODE_SEE_OTHER /*303*/:
                    break;
                case HttpStatusCodes.STATUS_CODE_TEMPORARY_REDIRECT /*307*/:
                case 308:
                    if (!b.equals(HttpMethods.GET) && !b.equals(HttpMethods.HEAD)) {
                        return null;
                    }
                case 401:
                    return this.f4602a.mo6719o().mo6524a(aeVar, acVar);
                case 407:
                    if (aeVar != null) {
                        proxy = aeVar.mo6517b();
                    } else {
                        proxy = this.f4602a.mo6709e();
                    }
                    if (proxy.type() == Type.HTTP) {
                        return this.f4602a.mo6720p().mo6524a(aeVar, acVar);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                case 408:
                    if (!this.f4602a.mo6724t() || (acVar.mo6477a().mo6459d() instanceof C1524l)) {
                        return null;
                    }
                    if ((acVar.mo6491l() == null || acVar.mo6491l().mo6481c() != 408) && m6150a(acVar, 0) <= 0) {
                        return acVar.mo6477a();
                    }
                    return null;
                case 503:
                    if ((acVar.mo6491l() == null || acVar.mo6491l().mo6481c() != 503) && m6150a(acVar, (int) BaseClientBuilder.API_PRIORITY_OTHER) == 0) {
                        return acVar.mo6477a();
                    }
                    return null;
                default:
                    return null;
            }
            if (!this.f4602a.mo6723s()) {
                return null;
            }
            String a = acVar.mo6478a(HttpHeaders.LOCATION);
            if (a == null) {
                return null;
            }
            C1642t c2 = acVar.mo6477a().mo6454a().mo6663c(a);
            if (c2 == null) {
                return null;
            }
            if (!c2.mo6661b().equals(acVar.mo6477a().mo6454a().mo6661b()) && !this.f4602a.mo6722r()) {
                return null;
            }
            C1591a e = acVar.mo6477a().mo6460e();
            if (C1518f.m6130c(b)) {
                boolean d = C1518f.m6131d(b);
                if (C1518f.m6132e(b)) {
                    e.mo6469a(HttpMethods.GET, (C1592ab) null);
                } else {
                    if (d) {
                        abVar = acVar.mo6477a().mo6459d();
                    }
                    e.mo6469a(b, abVar);
                }
                if (!d) {
                    e.mo6472b(HttpHeaders.TRANSFER_ENCODING);
                    e.mo6472b(HttpHeaders.CONTENT_LENGTH);
                    e.mo6472b(HttpHeaders.CONTENT_TYPE);
                }
            }
            if (!m6153a(acVar, c2)) {
                e.mo6472b(HttpHeaders.AUTHORIZATION);
            }
            return e.mo6467a(c2).mo6471a();
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    private int m6150a(C1596ac acVar, int i) {
        String a = acVar.mo6478a(HttpHeaders.RETRY_AFTER);
        if (a == null) {
            return i;
        }
        return a.matches("\\d+") ? Integer.valueOf(a).intValue() : BaseClientBuilder.API_PRIORITY_OTHER;
    }

    /* renamed from: a */
    private boolean m6153a(C1596ac acVar, C1642t tVar) {
        C1642t a = acVar.mo6477a().mo6454a();
        return a.mo6669f().equals(tVar.mo6669f()) && a.mo6670g() == tVar.mo6670g() && a.mo6661b().equals(tVar.mo6661b());
    }
}
