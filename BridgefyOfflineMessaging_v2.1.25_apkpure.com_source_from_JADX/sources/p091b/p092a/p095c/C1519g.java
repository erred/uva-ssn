package p091b.p092a.p095c;

import java.io.IOException;
import java.util.List;
import p091b.C1590aa;
import p091b.C1596ac;
import p091b.C1614e;
import p091b.C1622i;
import p091b.C1633p;
import p091b.C1645u;
import p091b.C1645u.C1646a;
import p091b.p092a.p094b.C1501c;
import p091b.p092a.p094b.C1506g;

/* renamed from: b.a.c.g */
/* compiled from: RealInterceptorChain */
public final class C1519g implements C1646a {

    /* renamed from: a */
    private final List<C1645u> f4587a;

    /* renamed from: b */
    private final C1506g f4588b;

    /* renamed from: c */
    private final C1514c f4589c;

    /* renamed from: d */
    private final C1501c f4590d;

    /* renamed from: e */
    private final int f4591e;

    /* renamed from: f */
    private final C1590aa f4592f;

    /* renamed from: g */
    private final C1614e f4593g;

    /* renamed from: h */
    private final C1633p f4594h;

    /* renamed from: i */
    private final int f4595i;

    /* renamed from: j */
    private final int f4596j;

    /* renamed from: k */
    private final int f4597k;

    /* renamed from: l */
    private int f4598l;

    public C1519g(List<C1645u> list, C1506g gVar, C1514c cVar, C1501c cVar2, int i, C1590aa aaVar, C1614e eVar, C1633p pVar, int i2, int i3, int i4) {
        this.f4587a = list;
        this.f4590d = cVar2;
        this.f4588b = gVar;
        this.f4589c = cVar;
        this.f4591e = i;
        this.f4592f = aaVar;
        this.f4593g = eVar;
        this.f4594h = pVar;
        this.f4595i = i2;
        this.f4596j = i3;
        this.f4597k = i4;
    }

    /* renamed from: e */
    public C1622i mo6285e() {
        return this.f4590d;
    }

    /* renamed from: b */
    public int mo6282b() {
        return this.f4595i;
    }

    /* renamed from: c */
    public int mo6283c() {
        return this.f4596j;
    }

    /* renamed from: d */
    public int mo6284d() {
        return this.f4597k;
    }

    /* renamed from: f */
    public C1506g mo6286f() {
        return this.f4588b;
    }

    /* renamed from: g */
    public C1514c mo6287g() {
        return this.f4589c;
    }

    /* renamed from: h */
    public C1614e mo6288h() {
        return this.f4593g;
    }

    /* renamed from: i */
    public C1633p mo6289i() {
        return this.f4594h;
    }

    /* renamed from: a */
    public C1590aa mo6279a() {
        return this.f4592f;
    }

    /* renamed from: a */
    public C1596ac mo6280a(C1590aa aaVar) throws IOException {
        return mo6281a(aaVar, this.f4588b, this.f4589c, this.f4590d);
    }

    /* renamed from: a */
    public C1596ac mo6281a(C1590aa aaVar, C1506g gVar, C1514c cVar, C1501c cVar2) throws IOException {
        if (this.f4591e < this.f4587a.size()) {
            this.f4598l++;
            if (this.f4589c != null && !this.f4590d.mo6236a(aaVar.mo6454a())) {
                StringBuilder sb = new StringBuilder();
                sb.append("network interceptor ");
                sb.append(this.f4587a.get(this.f4591e - 1));
                sb.append(" must retain the same host and port");
                throw new IllegalStateException(sb.toString());
            } else if (this.f4589c == null || this.f4598l <= 1) {
                C1519g gVar2 = new C1519g(this.f4587a, gVar, cVar, cVar2, this.f4591e + 1, aaVar, this.f4593g, this.f4594h, this.f4595i, this.f4596j, this.f4597k);
                C1645u uVar = (C1645u) this.f4587a.get(this.f4591e);
                C1596ac a = uVar.mo6184a(gVar2);
                if (cVar != null && this.f4591e + 1 < this.f4587a.size() && gVar2.f4598l != 1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("network interceptor ");
                    sb2.append(uVar);
                    sb2.append(" must call proceed() exactly once");
                    throw new IllegalStateException(sb2.toString());
                } else if (a == null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("interceptor ");
                    sb3.append(uVar);
                    sb3.append(" returned null");
                    throw new NullPointerException(sb3.toString());
                } else if (a.mo6487h() != null) {
                    return a;
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("interceptor ");
                    sb4.append(uVar);
                    sb4.append(" returned a response with no body");
                    throw new IllegalStateException(sb4.toString());
                }
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("network interceptor ");
                sb5.append(this.f4587a.get(this.f4591e - 1));
                sb5.append(" must call proceed() exactly once");
                throw new IllegalStateException(sb5.toString());
            }
        } else {
            throw new AssertionError();
        }
    }
}
