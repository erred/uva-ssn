package p091b;

import com.google.api.client.http.HttpMethods;
import com.google.common.net.HttpHeaders;
import java.util.List;
import p091b.C1640s.C1641a;
import p091b.p092a.p095c.C1518f;

/* renamed from: b.aa */
/* compiled from: Request */
public final class C1590aa {

    /* renamed from: a */
    final C1642t f4857a;

    /* renamed from: b */
    final String f4858b;

    /* renamed from: c */
    final C1640s f4859c;

    /* renamed from: d */
    final C1592ab f4860d;

    /* renamed from: e */
    final Object f4861e;

    /* renamed from: f */
    private volatile C1612d f4862f;

    /* renamed from: b.aa$a */
    /* compiled from: Request */
    public static class C1591a {

        /* renamed from: a */
        C1642t f4863a;

        /* renamed from: b */
        String f4864b;

        /* renamed from: c */
        C1641a f4865c;

        /* renamed from: d */
        C1592ab f4866d;

        /* renamed from: e */
        Object f4867e;

        public C1591a() {
            this.f4864b = HttpMethods.GET;
            this.f4865c = new C1641a();
        }

        C1591a(C1590aa aaVar) {
            this.f4863a = aaVar.f4857a;
            this.f4864b = aaVar.f4858b;
            this.f4866d = aaVar.f4860d;
            this.f4867e = aaVar.f4861e;
            this.f4865c = aaVar.f4859c.mo6646b();
        }

        /* renamed from: a */
        public C1591a mo6467a(C1642t tVar) {
            if (tVar != null) {
                this.f4863a = tVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: a */
        public C1591a mo6468a(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("http:");
                    sb.append(str.substring(3));
                    str = sb.toString();
                } else {
                    if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("https:");
                        sb2.append(str.substring(4));
                        str = sb2.toString();
                    }
                }
                C1642t e = C1642t.m6741e(str);
                if (e != null) {
                    return mo6467a(e);
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("unexpected url: ");
                sb3.append(str);
                throw new IllegalArgumentException(sb3.toString());
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: a */
        public C1591a mo6470a(String str, String str2) {
            this.f4865c.mo6657c(str, str2);
            return this;
        }

        /* renamed from: b */
        public C1591a mo6473b(String str, String str2) {
            this.f4865c.mo6653a(str, str2);
            return this;
        }

        /* renamed from: b */
        public C1591a mo6472b(String str) {
            this.f4865c.mo6655b(str);
            return this;
        }

        /* renamed from: a */
        public C1591a mo6466a(C1640s sVar) {
            this.f4865c = sVar.mo6646b();
            return this;
        }

        /* renamed from: a */
        public C1591a mo6465a(C1612d dVar) {
            String dVar2 = dVar.toString();
            if (dVar2.isEmpty()) {
                return mo6472b(HttpHeaders.CACHE_CONTROL);
            }
            return mo6470a(HttpHeaders.CACHE_CONTROL, dVar2);
        }

        /* renamed from: a */
        public C1591a mo6464a(C1592ab abVar) {
            return mo6469a(HttpMethods.POST, abVar);
        }

        /* renamed from: a */
        public C1591a mo6469a(String str, C1592ab abVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (abVar != null && !C1518f.m6130c(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append("method ");
                sb.append(str);
                sb.append(" must not have a request body.");
                throw new IllegalArgumentException(sb.toString());
            } else if (abVar != null || !C1518f.m6129b(str)) {
                this.f4864b = str;
                this.f4866d = abVar;
                return this;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("method ");
                sb2.append(str);
                sb2.append(" must have a request body.");
                throw new IllegalArgumentException(sb2.toString());
            }
        }

        /* renamed from: a */
        public C1590aa mo6471a() {
            if (this.f4863a != null) {
                return new C1590aa(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    C1590aa(C1591a aVar) {
        this.f4857a = aVar.f4863a;
        this.f4858b = aVar.f4864b;
        this.f4859c = aVar.f4865c.mo6654a();
        this.f4860d = aVar.f4866d;
        this.f4861e = aVar.f4867e != null ? aVar.f4867e : this;
    }

    /* renamed from: a */
    public C1642t mo6454a() {
        return this.f4857a;
    }

    /* renamed from: b */
    public String mo6456b() {
        return this.f4858b;
    }

    /* renamed from: c */
    public C1640s mo6458c() {
        return this.f4859c;
    }

    /* renamed from: a */
    public String mo6455a(String str) {
        return this.f4859c.mo6645a(str);
    }

    /* renamed from: b */
    public List<String> mo6457b(String str) {
        return this.f4859c.mo6648b(str);
    }

    /* renamed from: d */
    public C1592ab mo6459d() {
        return this.f4860d;
    }

    /* renamed from: e */
    public C1591a mo6460e() {
        return new C1591a(this);
    }

    /* renamed from: f */
    public C1612d mo6461f() {
        C1612d dVar = this.f4862f;
        if (dVar != null) {
            return dVar;
        }
        C1612d a = C1612d.m6590a(this.f4859c);
        this.f4862f = a;
        return a;
    }

    /* renamed from: g */
    public boolean mo6462g() {
        return this.f4857a.mo6664c();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f4858b);
        sb.append(", url=");
        sb.append(this.f4857a);
        sb.append(", tag=");
        sb.append(this.f4861e != this ? this.f4861e : null);
        sb.append('}');
        return sb.toString();
    }
}
