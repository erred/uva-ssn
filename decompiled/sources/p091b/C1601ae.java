package p091b;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

/* renamed from: b.ae */
/* compiled from: Route */
public final class C1601ae {

    /* renamed from: a */
    final C1482a f4909a;

    /* renamed from: b */
    final Proxy f4910b;

    /* renamed from: c */
    final InetSocketAddress f4911c;

    public C1601ae(C1482a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f4909a = aVar;
            this.f4910b = proxy;
            this.f4911c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    /* renamed from: a */
    public C1482a mo6516a() {
        return this.f4909a;
    }

    /* renamed from: b */
    public Proxy mo6517b() {
        return this.f4910b;
    }

    /* renamed from: c */
    public InetSocketAddress mo6518c() {
        return this.f4911c;
    }

    /* renamed from: d */
    public boolean mo6519d() {
        return this.f4909a.f4443i != null && this.f4910b.type() == Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1601ae) {
            C1601ae aeVar = (C1601ae) obj;
            if (aeVar.f4909a.equals(this.f4909a) && aeVar.f4910b.equals(this.f4910b) && aeVar.f4911c.equals(this.f4911c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f4909a.hashCode()) * 31) + this.f4910b.hashCode()) * 31) + this.f4911c.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Route{");
        sb.append(this.f4911c);
        sb.append("}");
        return sb.toString();
    }
}
