package p091b.p092a.p094b;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import p091b.C1482a;
import p091b.C1601ae;
import p091b.C1614e;
import p091b.C1633p;
import p091b.C1642t;
import p091b.p092a.C1508c;

/* renamed from: b.a.b.f */
/* compiled from: RouteSelector */
public final class C1504f {

    /* renamed from: a */
    private final C1482a f4534a;

    /* renamed from: b */
    private final C1502d f4535b;

    /* renamed from: c */
    private final C1614e f4536c;

    /* renamed from: d */
    private final C1633p f4537d;

    /* renamed from: e */
    private List<Proxy> f4538e = Collections.emptyList();

    /* renamed from: f */
    private int f4539f;

    /* renamed from: g */
    private List<InetSocketAddress> f4540g = Collections.emptyList();

    /* renamed from: h */
    private final List<C1601ae> f4541h = new ArrayList();

    /* renamed from: b.a.b.f$a */
    /* compiled from: RouteSelector */
    public static final class C1505a {

        /* renamed from: a */
        private final List<C1601ae> f4542a;

        /* renamed from: b */
        private int f4543b = 0;

        C1505a(List<C1601ae> list) {
            this.f4542a = list;
        }

        /* renamed from: a */
        public boolean mo6251a() {
            return this.f4543b < this.f4542a.size();
        }

        /* renamed from: b */
        public C1601ae mo6252b() {
            if (mo6251a()) {
                List<C1601ae> list = this.f4542a;
                int i = this.f4543b;
                this.f4543b = i + 1;
                return (C1601ae) list.get(i);
            }
            throw new NoSuchElementException();
        }

        /* renamed from: c */
        public List<C1601ae> mo6253c() {
            return new ArrayList(this.f4542a);
        }
    }

    public C1504f(C1482a aVar, C1502d dVar, C1614e eVar, C1633p pVar) {
        this.f4534a = aVar;
        this.f4535b = dVar;
        this.f4536c = eVar;
        this.f4537d = pVar;
        m6039a(aVar.mo6159a(), aVar.mo6168h());
    }

    /* renamed from: a */
    public boolean mo6249a() {
        return m6041c() || !this.f4541h.isEmpty();
    }

    /* renamed from: b */
    public C1505a mo6250b() throws IOException {
        if (mo6249a()) {
            ArrayList arrayList = new ArrayList();
            while (m6041c()) {
                Proxy d = m6042d();
                int size = this.f4540g.size();
                for (int i = 0; i < size; i++) {
                    C1601ae aeVar = new C1601ae(this.f4534a, d, (InetSocketAddress) this.f4540g.get(i));
                    if (this.f4535b.mo6245c(aeVar)) {
                        this.f4541h.add(aeVar);
                    } else {
                        arrayList.add(aeVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f4541h);
                this.f4541h.clear();
            }
            return new C1505a(arrayList);
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    public void mo6248a(C1601ae aeVar, IOException iOException) {
        if (!(aeVar.mo6517b().type() == Type.DIRECT || this.f4534a.mo6167g() == null)) {
            this.f4534a.mo6167g().connectFailed(this.f4534a.mo6159a().mo6660a(), aeVar.mo6517b().address(), iOException);
        }
        this.f4535b.mo6243a(aeVar);
    }

    /* renamed from: a */
    private void m6039a(C1642t tVar, Proxy proxy) {
        List<Proxy> list;
        if (proxy != null) {
            this.f4538e = Collections.singletonList(proxy);
        } else {
            List select = this.f4534a.mo6167g().select(tVar.mo6660a());
            if (select == null || select.isEmpty()) {
                list = C1508c.m6079a((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = C1508c.m6078a(select);
            }
            this.f4538e = list;
        }
        this.f4539f = 0;
    }

    /* renamed from: c */
    private boolean m6041c() {
        return this.f4539f < this.f4538e.size();
    }

    /* renamed from: d */
    private Proxy m6042d() throws IOException {
        if (m6041c()) {
            List<Proxy> list = this.f4538e;
            int i = this.f4539f;
            this.f4539f = i + 1;
            Proxy proxy = (Proxy) list.get(i);
            m6040a(proxy);
            return proxy;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No route to ");
        sb.append(this.f4534a.mo6159a().mo6669f());
        sb.append("; exhausted proxy configurations: ");
        sb.append(this.f4538e);
        throw new SocketException(sb.toString());
    }

    /* renamed from: a */
    private void m6040a(Proxy proxy) throws IOException {
        String str;
        int i;
        this.f4540g = new ArrayList();
        if (proxy.type() == Type.DIRECT || proxy.type() == Type.SOCKS) {
            str = this.f4534a.mo6159a().mo6669f();
            i = this.f4534a.mo6159a().mo6670g();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = m6038a(inetSocketAddress);
                i = inetSocketAddress.getPort();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Proxy.address() is not an InetSocketAddress: ");
                sb.append(address.getClass());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (i < 1 || i > 65535) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No route to ");
            sb2.append(str);
            sb2.append(":");
            sb2.append(i);
            sb2.append("; port is out of range");
            throw new SocketException(sb2.toString());
        } else if (proxy.type() == Type.SOCKS) {
            this.f4540g.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            this.f4537d.mo6616a(this.f4536c, str);
            List a = this.f4534a.mo6161b().mo6608a(str);
            if (!a.isEmpty()) {
                this.f4537d.mo6617a(this.f4536c, str, a);
                int size = a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f4540g.add(new InetSocketAddress((InetAddress) a.get(i2), i));
                }
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.f4534a.mo6161b());
            sb3.append(" returned no addresses for ");
            sb3.append(str);
            throw new UnknownHostException(sb3.toString());
        }
    }

    /* renamed from: a */
    static String m6038a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
