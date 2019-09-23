package androidx.constraintlayout.p060b.p061a;

import androidx.constraintlayout.p060b.C0784c;
import androidx.constraintlayout.p060b.C0792h;
import androidx.constraintlayout.p060b.C0792h.C0793a;

/* renamed from: androidx.constraintlayout.b.a.e */
/* compiled from: ConstraintAnchor */
public class C0761e {

    /* renamed from: a */
    final C0766f f2197a;

    /* renamed from: b */
    final C0765c f2198b;

    /* renamed from: c */
    C0761e f2199c;

    /* renamed from: d */
    public int f2200d = 0;

    /* renamed from: e */
    int f2201e = -1;

    /* renamed from: f */
    C0792h f2202f;

    /* renamed from: g */
    private C0777n f2203g = new C0777n(this);

    /* renamed from: h */
    private C0764b f2204h = C0764b.NONE;

    /* renamed from: i */
    private C0763a f2205i = C0763a.RELAXED;

    /* renamed from: j */
    private int f2206j = 0;

    /* renamed from: androidx.constraintlayout.b.a.e$a */
    /* compiled from: ConstraintAnchor */
    public enum C0763a {
        RELAXED,
        STRICT
    }

    /* renamed from: androidx.constraintlayout.b.a.e$b */
    /* compiled from: ConstraintAnchor */
    public enum C0764b {
        NONE,
        STRONG,
        WEAK
    }

    /* renamed from: androidx.constraintlayout.b.a.e$c */
    /* compiled from: ConstraintAnchor */
    public enum C0765c {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    /* renamed from: a */
    public C0777n mo3038a() {
        return this.f2203g;
    }

    public C0761e(C0766f fVar, C0765c cVar) {
        this.f2197a = fVar;
        this.f2198b = cVar;
    }

    /* renamed from: b */
    public C0792h mo3043b() {
        return this.f2202f;
    }

    /* renamed from: a */
    public void mo3039a(C0784c cVar) {
        if (this.f2202f == null) {
            this.f2202f = new C0792h(C0793a.UNRESTRICTED, null);
        } else {
            this.f2202f.mo3230b();
        }
    }

    /* renamed from: c */
    public C0766f mo3044c() {
        return this.f2197a;
    }

    /* renamed from: d */
    public C0765c mo3045d() {
        return this.f2198b;
    }

    /* renamed from: e */
    public int mo3046e() {
        if (this.f2197a.mo3105l() == 8) {
            return 0;
        }
        if (this.f2201e <= -1 || this.f2199c == null || this.f2199c.f2197a.mo3105l() != 8) {
            return this.f2200d;
        }
        return this.f2201e;
    }

    /* renamed from: f */
    public C0764b mo3047f() {
        return this.f2204h;
    }

    /* renamed from: g */
    public C0761e mo3048g() {
        return this.f2199c;
    }

    /* renamed from: h */
    public int mo3049h() {
        return this.f2206j;
    }

    /* renamed from: i */
    public void mo3050i() {
        this.f2199c = null;
        this.f2200d = 0;
        this.f2201e = -1;
        this.f2204h = C0764b.STRONG;
        this.f2206j = 0;
        this.f2205i = C0763a.RELAXED;
        this.f2203g.mo3155b();
    }

    /* renamed from: a */
    public boolean mo3042a(C0761e eVar, int i, C0764b bVar, int i2) {
        return mo3041a(eVar, i, -1, bVar, i2, false);
    }

    /* renamed from: a */
    public boolean mo3041a(C0761e eVar, int i, int i2, C0764b bVar, int i3, boolean z) {
        if (eVar == null) {
            this.f2199c = null;
            this.f2200d = 0;
            this.f2201e = -1;
            this.f2204h = C0764b.NONE;
            this.f2206j = 2;
            return true;
        } else if (!z && !mo3040a(eVar)) {
            return false;
        } else {
            this.f2199c = eVar;
            if (i > 0) {
                this.f2200d = i;
            } else {
                this.f2200d = 0;
            }
            this.f2201e = i2;
            this.f2204h = bVar;
            this.f2206j = i3;
            return true;
        }
    }

    /* renamed from: j */
    public boolean mo3051j() {
        return this.f2199c != null;
    }

    /* renamed from: a */
    public boolean mo3040a(C0761e eVar) {
        boolean z = false;
        if (eVar == null) {
            return false;
        }
        C0765c d = eVar.mo3045d();
        if (d != this.f2198b) {
            switch (this.f2198b) {
                case CENTER:
                    if (!(d == C0765c.BASELINE || d == C0765c.CENTER_X || d == C0765c.CENTER_Y)) {
                        z = true;
                    }
                    return z;
                case LEFT:
                case RIGHT:
                    boolean z2 = d == C0765c.LEFT || d == C0765c.RIGHT;
                    if (eVar.mo3044c() instanceof C0771i) {
                        z2 = z2 || d == C0765c.CENTER_X;
                    }
                    return z2;
                case TOP:
                case BOTTOM:
                    boolean z3 = d == C0765c.TOP || d == C0765c.BOTTOM;
                    if (eVar.mo3044c() instanceof C0771i) {
                        z3 = z3 || d == C0765c.CENTER_Y;
                    }
                    return z3;
                case BASELINE:
                case CENTER_X:
                case CENTER_Y:
                case NONE:
                    return false;
                default:
                    throw new AssertionError(this.f2198b.name());
            }
        } else if (this.f2198b != C0765c.BASELINE || (eVar.mo3044c().mo3053A() && mo3044c().mo3053A())) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2197a.mo3107m());
        sb.append(":");
        sb.append(this.f2198b.toString());
        return sb.toString();
    }
}
