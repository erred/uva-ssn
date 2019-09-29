package p091b;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import p091b.C1642t.C1643a;
import p091b.p092a.C1508c;

/* renamed from: b.a */
/* compiled from: Address */
public final class C1482a {

    /* renamed from: a */
    final C1642t f4435a;

    /* renamed from: b */
    final C1631o f4436b;

    /* renamed from: c */
    final SocketFactory f4437c;

    /* renamed from: d */
    final C1603b f4438d;

    /* renamed from: e */
    final List<C1654y> f4439e;

    /* renamed from: f */
    final List<C1625k> f4440f;

    /* renamed from: g */
    final ProxySelector f4441g;

    /* renamed from: h */
    final Proxy f4442h;

    /* renamed from: i */
    final SSLSocketFactory f4443i;

    /* renamed from: j */
    final HostnameVerifier f4444j;

    /* renamed from: k */
    final C1617g f4445k;

    public C1482a(String str, int i, C1631o oVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C1617g gVar, C1603b bVar, Proxy proxy, List<C1654y> list, List<C1625k> list2, ProxySelector proxySelector) {
        this.f4435a = new C1643a().mo6685a(sSLSocketFactory != null ? "https" : "http").mo6692d(str).mo6684a(i).mo6691c();
        if (oVar != null) {
            this.f4436b = oVar;
            if (socketFactory != null) {
                this.f4437c = socketFactory;
                if (bVar != null) {
                    this.f4438d = bVar;
                    if (list != null) {
                        this.f4439e = C1508c.m6078a(list);
                        if (list2 != null) {
                            this.f4440f = C1508c.m6078a(list2);
                            if (proxySelector != null) {
                                this.f4441g = proxySelector;
                                this.f4442h = proxy;
                                this.f4443i = sSLSocketFactory;
                                this.f4444j = hostnameVerifier;
                                this.f4445k = gVar;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    /* renamed from: a */
    public C1642t mo6159a() {
        return this.f4435a;
    }

    /* renamed from: b */
    public C1631o mo6161b() {
        return this.f4436b;
    }

    /* renamed from: c */
    public SocketFactory mo6162c() {
        return this.f4437c;
    }

    /* renamed from: d */
    public C1603b mo6163d() {
        return this.f4438d;
    }

    /* renamed from: e */
    public List<C1654y> mo6164e() {
        return this.f4439e;
    }

    /* renamed from: f */
    public List<C1625k> mo6166f() {
        return this.f4440f;
    }

    /* renamed from: g */
    public ProxySelector mo6167g() {
        return this.f4441g;
    }

    /* renamed from: h */
    public Proxy mo6168h() {
        return this.f4442h;
    }

    /* renamed from: i */
    public SSLSocketFactory mo6170i() {
        return this.f4443i;
    }

    /* renamed from: j */
    public HostnameVerifier mo6171j() {
        return this.f4444j;
    }

    /* renamed from: k */
    public C1617g mo6172k() {
        return this.f4445k;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1482a) {
            C1482a aVar = (C1482a) obj;
            if (this.f4435a.equals(aVar.f4435a) && mo6160a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((527 + this.f4435a.hashCode()) * 31) + this.f4436b.hashCode()) * 31) + this.f4438d.hashCode()) * 31) + this.f4439e.hashCode()) * 31) + this.f4440f.hashCode()) * 31) + this.f4441g.hashCode()) * 31) + (this.f4442h != null ? this.f4442h.hashCode() : 0)) * 31) + (this.f4443i != null ? this.f4443i.hashCode() : 0)) * 31) + (this.f4444j != null ? this.f4444j.hashCode() : 0)) * 31;
        if (this.f4445k != null) {
            i = this.f4445k.hashCode();
        }
        return hashCode + i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo6160a(C1482a aVar) {
        return this.f4436b.equals(aVar.f4436b) && this.f4438d.equals(aVar.f4438d) && this.f4439e.equals(aVar.f4439e) && this.f4440f.equals(aVar.f4440f) && this.f4441g.equals(aVar.f4441g) && C1508c.m6086a((Object) this.f4442h, (Object) aVar.f4442h) && C1508c.m6086a((Object) this.f4443i, (Object) aVar.f4443i) && C1508c.m6086a((Object) this.f4444j, (Object) aVar.f4444j) && C1508c.m6086a((Object) this.f4445k, (Object) aVar.f4445k) && mo6159a().mo6670g() == aVar.mo6159a().mo6670g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f4435a.mo6669f());
        sb.append(":");
        sb.append(this.f4435a.mo6670g());
        if (this.f4442h != null) {
            sb.append(", proxy=");
            sb.append(this.f4442h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f4441g);
        }
        sb.append("}");
        return sb.toString();
    }
}
