package androidx.constraintlayout.p060b.p061a;

import androidx.constraintlayout.p060b.C0786e;
import androidx.constraintlayout.p060b.C0788f;
import androidx.constraintlayout.p060b.C0792h;
import androidx.constraintlayout.p060b.p061a.C0761e.C0765c;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.constraintlayout.b.a.n */
/* compiled from: ResolutionAnchor */
public class C0777n extends C0779p {

    /* renamed from: a */
    C0761e f2345a;

    /* renamed from: b */
    float f2346b;

    /* renamed from: c */
    C0777n f2347c;

    /* renamed from: d */
    float f2348d;

    /* renamed from: e */
    C0777n f2349e;

    /* renamed from: f */
    float f2350f;

    /* renamed from: g */
    int f2351g = 0;

    /* renamed from: j */
    private C0777n f2352j;

    /* renamed from: k */
    private float f2353k;

    /* renamed from: l */
    private C0778o f2354l = null;

    /* renamed from: m */
    private int f2355m = 1;

    /* renamed from: n */
    private C0778o f2356n = null;

    /* renamed from: o */
    private int f2357o = 1;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo3148a(int i) {
        return i == 1 ? "DIRECT" : i == 2 ? "CENTER" : i == 3 ? "MATCH" : i == 4 ? "CHAIN" : i == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public C0777n(C0761e eVar) {
        this.f2345a = eVar;
    }

    public String toString() {
        if (this.f2360i != 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("{ ");
            sb.append(this.f2345a);
            sb.append(" UNRESOLVED} type: ");
            sb.append(mo3148a(this.f2351g));
            return sb.toString();
        } else if (this.f2349e == this) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(this.f2345a);
            sb2.append(", RESOLVED: ");
            sb2.append(this.f2350f);
            sb2.append("]  type: ");
            sb2.append(mo3148a(this.f2351g));
            return sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("[");
            sb3.append(this.f2345a);
            sb3.append(", RESOLVED: ");
            sb3.append(this.f2349e);
            sb3.append(":");
            sb3.append(this.f2350f);
            sb3.append("] type: ");
            sb3.append(mo3148a(this.f2351g));
            return sb3.toString();
        }
    }

    /* renamed from: a */
    public void mo3151a(C0777n nVar, float f) {
        if (this.f2360i == 0 || !(this.f2349e == nVar || this.f2350f == f)) {
            this.f2349e = nVar;
            this.f2350f = f;
            if (this.f2360i == 1) {
                mo3165e();
            }
            mo3166f();
        }
    }

    /* renamed from: a */
    public void mo3149a() {
        float f;
        float f2;
        float f3;
        boolean z = true;
        if (this.f2360i != 1 && this.f2351g != 4) {
            if (this.f2354l != null) {
                if (this.f2354l.f2360i == 1) {
                    this.f2348d = ((float) this.f2355m) * this.f2354l.f2358a;
                } else {
                    return;
                }
            }
            if (this.f2356n != null) {
                if (this.f2356n.f2360i == 1) {
                    this.f2353k = ((float) this.f2357o) * this.f2356n.f2358a;
                } else {
                    return;
                }
            }
            if (this.f2351g == 1 && (this.f2347c == null || this.f2347c.f2360i == 1)) {
                if (this.f2347c == null) {
                    this.f2349e = this;
                    this.f2350f = this.f2348d;
                } else {
                    this.f2349e = this.f2347c.f2349e;
                    this.f2350f = this.f2347c.f2350f + this.f2348d;
                }
                mo3166f();
            } else if (this.f2351g == 2 && this.f2347c != null && this.f2347c.f2360i == 1 && this.f2352j != null && this.f2352j.f2347c != null && this.f2352j.f2347c.f2360i == 1) {
                if (C0786e.m2935a() != null) {
                    C0788f a = C0786e.m2935a();
                    a.f2424w++;
                }
                this.f2349e = this.f2347c.f2349e;
                this.f2352j.f2349e = this.f2352j.f2347c.f2349e;
                int i = 0;
                if (!(this.f2345a.f2198b == C0765c.RIGHT || this.f2345a.f2198b == C0765c.BOTTOM)) {
                    z = false;
                }
                if (z) {
                    f = this.f2347c.f2350f - this.f2352j.f2347c.f2350f;
                } else {
                    f = this.f2352j.f2347c.f2350f - this.f2347c.f2350f;
                }
                if (this.f2345a.f2198b == C0765c.LEFT || this.f2345a.f2198b == C0765c.RIGHT) {
                    f3 = f - ((float) this.f2345a.f2197a.mo3113p());
                    f2 = this.f2345a.f2197a.f2243S;
                } else {
                    f3 = f - ((float) this.f2345a.f2197a.mo3116r());
                    f2 = this.f2345a.f2197a.f2244T;
                }
                int e = this.f2345a.mo3046e();
                int e2 = this.f2352j.f2345a.mo3046e();
                if (this.f2345a.mo3048g() == this.f2352j.f2345a.mo3048g()) {
                    f2 = 0.5f;
                    e2 = 0;
                } else {
                    i = e;
                }
                float f4 = (float) i;
                float f5 = (float) e2;
                float f6 = (f3 - f4) - f5;
                if (z) {
                    this.f2352j.f2350f = this.f2352j.f2347c.f2350f + f5 + (f6 * f2);
                    this.f2350f = (this.f2347c.f2350f - f4) - (f6 * (1.0f - f2));
                } else {
                    this.f2350f = this.f2347c.f2350f + f4 + (f6 * f2);
                    this.f2352j.f2350f = (this.f2352j.f2347c.f2350f - f5) - (f6 * (1.0f - f2));
                }
                mo3166f();
                this.f2352j.mo3166f();
            } else if (this.f2351g == 3 && this.f2347c != null && this.f2347c.f2360i == 1 && this.f2352j != null && this.f2352j.f2347c != null && this.f2352j.f2347c.f2360i == 1) {
                if (C0786e.m2935a() != null) {
                    C0788f a2 = C0786e.m2935a();
                    a2.f2425x++;
                }
                this.f2349e = this.f2347c.f2349e;
                this.f2352j.f2349e = this.f2352j.f2347c.f2349e;
                this.f2350f = this.f2347c.f2350f + this.f2348d;
                this.f2352j.f2350f = this.f2352j.f2347c.f2350f + this.f2352j.f2348d;
                mo3166f();
                this.f2352j.mo3166f();
            } else if (this.f2351g == 5) {
                this.f2345a.f2197a.mo3036d();
            }
        }
    }

    /* renamed from: b */
    public void mo3156b(int i) {
        this.f2351g = i;
    }

    /* renamed from: b */
    public void mo3155b() {
        super.mo3155b();
        this.f2347c = null;
        this.f2348d = BitmapDescriptorFactory.HUE_RED;
        this.f2354l = null;
        this.f2355m = 1;
        this.f2356n = null;
        this.f2357o = 1;
        this.f2349e = null;
        this.f2350f = BitmapDescriptorFactory.HUE_RED;
        this.f2346b = BitmapDescriptorFactory.HUE_RED;
        this.f2352j = null;
        this.f2353k = BitmapDescriptorFactory.HUE_RED;
        this.f2351g = 0;
    }

    /* renamed from: c */
    public void mo3159c() {
        C0761e g = this.f2345a.mo3048g();
        if (g != null) {
            if (g.mo3048g() == this.f2345a) {
                this.f2351g = 4;
                g.mo3038a().f2351g = 4;
            }
            int e = this.f2345a.mo3046e();
            if (this.f2345a.f2198b == C0765c.RIGHT || this.f2345a.f2198b == C0765c.BOTTOM) {
                e = -e;
            }
            mo3152a(g.mo3038a(), e);
        }
    }

    /* renamed from: a */
    public void mo3150a(int i, C0777n nVar, int i2) {
        this.f2351g = i;
        this.f2347c = nVar;
        this.f2348d = (float) i2;
        this.f2347c.mo3164a(this);
    }

    /* renamed from: a */
    public void mo3152a(C0777n nVar, int i) {
        this.f2347c = nVar;
        this.f2348d = (float) i;
        this.f2347c.mo3164a(this);
    }

    /* renamed from: a */
    public void mo3153a(C0777n nVar, int i, C0778o oVar) {
        this.f2347c = nVar;
        this.f2347c.mo3164a(this);
        this.f2354l = oVar;
        this.f2355m = i;
        this.f2354l.mo3164a(this);
    }

    /* renamed from: b */
    public void mo3157b(C0777n nVar, float f) {
        this.f2352j = nVar;
        this.f2353k = f;
    }

    /* renamed from: b */
    public void mo3158b(C0777n nVar, int i, C0778o oVar) {
        this.f2352j = nVar;
        this.f2356n = oVar;
        this.f2357o = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3154a(C0786e eVar) {
        C0792h b = this.f2345a.mo3043b();
        if (this.f2349e == null) {
            eVar.mo3209a(b, (int) this.f2350f);
        } else {
            eVar.mo3219c(b, eVar.mo3204a((Object) this.f2349e.f2345a), (int) this.f2350f, 6);
        }
    }

    /* renamed from: d */
    public float mo3160d() {
        return this.f2350f;
    }
}
