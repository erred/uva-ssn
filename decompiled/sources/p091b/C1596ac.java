package p091b;

import java.io.Closeable;
import p091b.C1640s.C1641a;

/* renamed from: b.ac */
/* compiled from: Response */
public final class C1596ac implements Closeable {

    /* renamed from: a */
    final C1590aa f4876a;

    /* renamed from: b */
    final C1654y f4877b;

    /* renamed from: c */
    final int f4878c;

    /* renamed from: d */
    final String f4879d;

    /* renamed from: e */
    final C1639r f4880e;

    /* renamed from: f */
    final C1640s f4881f;

    /* renamed from: g */
    final C1598ad f4882g;

    /* renamed from: h */
    final C1596ac f4883h;

    /* renamed from: i */
    final C1596ac f4884i;

    /* renamed from: j */
    final C1596ac f4885j;

    /* renamed from: k */
    final long f4886k;

    /* renamed from: l */
    final long f4887l;

    /* renamed from: m */
    private volatile C1612d f4888m;

    /* renamed from: b.ac$a */
    /* compiled from: Response */
    public static class C1597a {

        /* renamed from: a */
        C1590aa f4889a;

        /* renamed from: b */
        C1654y f4890b;

        /* renamed from: c */
        int f4891c;

        /* renamed from: d */
        String f4892d;

        /* renamed from: e */
        C1639r f4893e;

        /* renamed from: f */
        C1641a f4894f;

        /* renamed from: g */
        C1598ad f4895g;

        /* renamed from: h */
        C1596ac f4896h;

        /* renamed from: i */
        C1596ac f4897i;

        /* renamed from: j */
        C1596ac f4898j;

        /* renamed from: k */
        long f4899k;

        /* renamed from: l */
        long f4900l;

        public C1597a() {
            this.f4891c = -1;
            this.f4894f = new C1641a();
        }

        C1597a(C1596ac acVar) {
            this.f4891c = -1;
            this.f4889a = acVar.f4876a;
            this.f4890b = acVar.f4877b;
            this.f4891c = acVar.f4878c;
            this.f4892d = acVar.f4879d;
            this.f4893e = acVar.f4880e;
            this.f4894f = acVar.f4881f.mo6646b();
            this.f4895g = acVar.f4882g;
            this.f4896h = acVar.f4883h;
            this.f4897i = acVar.f4884i;
            this.f4898j = acVar.f4885j;
            this.f4899k = acVar.f4886k;
            this.f4900l = acVar.f4887l;
        }

        /* renamed from: a */
        public C1597a mo6498a(C1590aa aaVar) {
            this.f4889a = aaVar;
            return this;
        }

        /* renamed from: a */
        public C1597a mo6503a(C1654y yVar) {
            this.f4890b = yVar;
            return this;
        }

        /* renamed from: a */
        public C1597a mo6496a(int i) {
            this.f4891c = i;
            return this;
        }

        /* renamed from: a */
        public C1597a mo6504a(String str) {
            this.f4892d = str;
            return this;
        }

        /* renamed from: a */
        public C1597a mo6501a(C1639r rVar) {
            this.f4893e = rVar;
            return this;
        }

        /* renamed from: a */
        public C1597a mo6505a(String str, String str2) {
            this.f4894f.mo6653a(str, str2);
            return this;
        }

        /* renamed from: a */
        public C1597a mo6502a(C1640s sVar) {
            this.f4894f = sVar.mo6646b();
            return this;
        }

        /* renamed from: a */
        public C1597a mo6500a(C1598ad adVar) {
            this.f4895g = adVar;
            return this;
        }

        /* renamed from: a */
        public C1597a mo6499a(C1596ac acVar) {
            if (acVar != null) {
                m6527a("networkResponse", acVar);
            }
            this.f4896h = acVar;
            return this;
        }

        /* renamed from: b */
        public C1597a mo6508b(C1596ac acVar) {
            if (acVar != null) {
                m6527a("cacheResponse", acVar);
            }
            this.f4897i = acVar;
            return this;
        }

        /* renamed from: a */
        private void m6527a(String str, C1596ac acVar) {
            if (acVar.f4882g != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(".body != null");
                throw new IllegalArgumentException(sb.toString());
            } else if (acVar.f4883h != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(".networkResponse != null");
                throw new IllegalArgumentException(sb2.toString());
            } else if (acVar.f4884i != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(".cacheResponse != null");
                throw new IllegalArgumentException(sb3.toString());
            } else if (acVar.f4885j != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(".priorResponse != null");
                throw new IllegalArgumentException(sb4.toString());
            }
        }

        /* renamed from: c */
        public C1597a mo6509c(C1596ac acVar) {
            if (acVar != null) {
                m6528d(acVar);
            }
            this.f4898j = acVar;
            return this;
        }

        /* renamed from: d */
        private void m6528d(C1596ac acVar) {
            if (acVar.f4882g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: a */
        public C1597a mo6497a(long j) {
            this.f4899k = j;
            return this;
        }

        /* renamed from: b */
        public C1597a mo6507b(long j) {
            this.f4900l = j;
            return this;
        }

        /* renamed from: a */
        public C1596ac mo6506a() {
            if (this.f4889a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f4890b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f4891c < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("code < 0: ");
                sb.append(this.f4891c);
                throw new IllegalStateException(sb.toString());
            } else if (this.f4892d != null) {
                return new C1596ac(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }
    }

    C1596ac(C1597a aVar) {
        this.f4876a = aVar.f4889a;
        this.f4877b = aVar.f4890b;
        this.f4878c = aVar.f4891c;
        this.f4879d = aVar.f4892d;
        this.f4880e = aVar.f4893e;
        this.f4881f = aVar.f4894f.mo6654a();
        this.f4882g = aVar.f4895g;
        this.f4883h = aVar.f4896h;
        this.f4884i = aVar.f4897i;
        this.f4885j = aVar.f4898j;
        this.f4886k = aVar.f4899k;
        this.f4887l = aVar.f4900l;
    }

    /* renamed from: a */
    public C1590aa mo6477a() {
        return this.f4876a;
    }

    /* renamed from: b */
    public C1654y mo6480b() {
        return this.f4877b;
    }

    /* renamed from: c */
    public int mo6481c() {
        return this.f4878c;
    }

    /* renamed from: d */
    public boolean mo6483d() {
        return this.f4878c >= 200 && this.f4878c < 300;
    }

    /* renamed from: e */
    public String mo6484e() {
        return this.f4879d;
    }

    /* renamed from: f */
    public C1639r mo6485f() {
        return this.f4880e;
    }

    /* renamed from: a */
    public String mo6478a(String str) {
        return mo6479a(str, null);
    }

    /* renamed from: a */
    public String mo6479a(String str, String str2) {
        String a = this.f4881f.mo6645a(str);
        return a != null ? a : str2;
    }

    /* renamed from: g */
    public C1640s mo6486g() {
        return this.f4881f;
    }

    /* renamed from: h */
    public C1598ad mo6487h() {
        return this.f4882g;
    }

    /* renamed from: i */
    public C1597a mo6488i() {
        return new C1597a(this);
    }

    /* renamed from: j */
    public C1596ac mo6489j() {
        return this.f4883h;
    }

    /* renamed from: k */
    public C1596ac mo6490k() {
        return this.f4884i;
    }

    /* renamed from: l */
    public C1596ac mo6491l() {
        return this.f4885j;
    }

    /* renamed from: m */
    public C1612d mo6492m() {
        C1612d dVar = this.f4888m;
        if (dVar != null) {
            return dVar;
        }
        C1612d a = C1612d.m6590a(this.f4881f);
        this.f4888m = a;
        return a;
    }

    /* renamed from: n */
    public long mo6493n() {
        return this.f4886k;
    }

    /* renamed from: o */
    public long mo6494o() {
        return this.f4887l;
    }

    public void close() {
        if (this.f4882g != null) {
            this.f4882g.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Response{protocol=");
        sb.append(this.f4877b);
        sb.append(", code=");
        sb.append(this.f4878c);
        sb.append(", message=");
        sb.append(this.f4879d);
        sb.append(", url=");
        sb.append(this.f4876a.mo6454a());
        sb.append('}');
        return sb.toString();
    }
}
