package androidx.constraintlayout.p060b.p061a;

import androidx.constraintlayout.p060b.C0786e;
import androidx.constraintlayout.p060b.C0792h;
import androidx.constraintlayout.p060b.p061a.C0761e.C0765c;
import androidx.constraintlayout.p060b.p061a.C0766f.C0768a;
import java.util.ArrayList;

/* renamed from: androidx.constraintlayout.b.a.i */
/* compiled from: Guideline */
public class C0771i extends C0766f {

    /* renamed from: af */
    protected float f2332af = -1.0f;

    /* renamed from: ag */
    protected int f2333ag = -1;

    /* renamed from: ah */
    protected int f2334ah = -1;

    /* renamed from: ai */
    private C0761e f2335ai = this.f2288t;

    /* renamed from: aj */
    private int f2336aj;

    /* renamed from: ak */
    private boolean f2337ak;

    /* renamed from: al */
    private int f2338al;

    /* renamed from: am */
    private C0776m f2339am;

    /* renamed from: an */
    private int f2340an;

    /* renamed from: a */
    public boolean mo3032a() {
        return true;
    }

    public C0771i() {
        this.f2336aj = 0;
        this.f2337ak = false;
        this.f2338al = 0;
        this.f2339am = new C0776m();
        this.f2340an = 8;
        this.f2227B.clear();
        this.f2227B.add(this.f2335ai);
        int length = this.f2226A.length;
        for (int i = 0; i < length; i++) {
            this.f2226A[i] = this.f2335ai;
        }
    }

    /* renamed from: a */
    public void mo3029a(int i) {
        if (this.f2336aj != i) {
            this.f2336aj = i;
            this.f2227B.clear();
            if (this.f2336aj == 1) {
                this.f2335ai = this.f2287s;
            } else {
                this.f2335ai = this.f2288t;
            }
            this.f2227B.add(this.f2335ai);
            int length = this.f2226A.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.f2226A[i2] = this.f2335ai;
            }
        }
    }

    /* renamed from: b */
    public int mo3034b() {
        return this.f2336aj;
    }

    /* renamed from: a */
    public C0761e mo3063a(C0765c cVar) {
        switch (cVar) {
            case LEFT:
            case RIGHT:
                if (this.f2336aj == 1) {
                    return this.f2335ai;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.f2336aj == 0) {
                    return this.f2335ai;
                }
                break;
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
        }
        throw new AssertionError(cVar.name());
    }

    /* renamed from: D */
    public ArrayList<C0761e> mo3056D() {
        return this.f2227B;
    }

    /* renamed from: e */
    public void mo3143e(float f) {
        if (f > -1.0f) {
            this.f2332af = f;
            this.f2333ag = -1;
            this.f2334ah = -1;
        }
    }

    /* renamed from: q */
    public void mo3144q(int i) {
        if (i > -1) {
            this.f2332af = -1.0f;
            this.f2333ag = i;
            this.f2334ah = -1;
        }
    }

    /* renamed from: r */
    public void mo3145r(int i) {
        if (i > -1) {
            this.f2332af = -1.0f;
            this.f2333ag = -1;
            this.f2334ah = i;
        }
    }

    /* renamed from: b */
    public void mo3033b(int i) {
        C0766f k = mo3103k();
        if (k != null) {
            if (mo3034b() == 1) {
                this.f2288t.mo3038a().mo3150a(1, k.f2288t.mo3038a(), 0);
                this.f2290v.mo3038a().mo3150a(1, k.f2288t.mo3038a(), 0);
                if (this.f2333ag != -1) {
                    this.f2287s.mo3038a().mo3150a(1, k.f2287s.mo3038a(), this.f2333ag);
                    this.f2289u.mo3038a().mo3150a(1, k.f2287s.mo3038a(), this.f2333ag);
                } else if (this.f2334ah != -1) {
                    this.f2287s.mo3038a().mo3150a(1, k.f2289u.mo3038a(), -this.f2334ah);
                    this.f2289u.mo3038a().mo3150a(1, k.f2289u.mo3038a(), -this.f2334ah);
                } else if (this.f2332af != -1.0f && k.mo3059G() == C0768a.FIXED) {
                    int i2 = (int) (((float) k.f2230E) * this.f2332af);
                    this.f2287s.mo3038a().mo3150a(1, k.f2287s.mo3038a(), i2);
                    this.f2289u.mo3038a().mo3150a(1, k.f2287s.mo3038a(), i2);
                }
            } else {
                this.f2287s.mo3038a().mo3150a(1, k.f2287s.mo3038a(), 0);
                this.f2289u.mo3038a().mo3150a(1, k.f2287s.mo3038a(), 0);
                if (this.f2333ag != -1) {
                    this.f2288t.mo3038a().mo3150a(1, k.f2288t.mo3038a(), this.f2333ag);
                    this.f2290v.mo3038a().mo3150a(1, k.f2288t.mo3038a(), this.f2333ag);
                } else if (this.f2334ah != -1) {
                    this.f2288t.mo3038a().mo3150a(1, k.f2290v.mo3038a(), -this.f2334ah);
                    this.f2290v.mo3038a().mo3150a(1, k.f2290v.mo3038a(), -this.f2334ah);
                } else if (this.f2332af != -1.0f && k.mo3060H() == C0768a.FIXED) {
                    int i3 = (int) (((float) k.f2231F) * this.f2332af);
                    this.f2288t.mo3038a().mo3150a(1, k.f2288t.mo3038a(), i3);
                    this.f2290v.mo3038a().mo3150a(1, k.f2288t.mo3038a(), i3);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3030a(C0786e eVar) {
        C0769g gVar = (C0769g) mo3103k();
        if (gVar != null) {
            C0761e a = gVar.mo3063a(C0765c.LEFT);
            C0761e a2 = gVar.mo3063a(C0765c.RIGHT);
            boolean z = this.f2229D != null && this.f2229D.f2228C[0] == C0768a.WRAP_CONTENT;
            if (this.f2336aj == 0) {
                a = gVar.mo3063a(C0765c.TOP);
                a2 = gVar.mo3063a(C0765c.BOTTOM);
                z = this.f2229D != null && this.f2229D.f2228C[1] == C0768a.WRAP_CONTENT;
            }
            if (this.f2333ag != -1) {
                C0792h a3 = eVar.mo3204a((Object) this.f2335ai);
                eVar.mo3219c(a3, eVar.mo3204a((Object) a), this.f2333ag, 6);
                if (z) {
                    eVar.mo3211a(eVar.mo3204a((Object) a2), a3, 0, 5);
                }
            } else if (this.f2334ah != -1) {
                C0792h a4 = eVar.mo3204a((Object) this.f2335ai);
                C0792h a5 = eVar.mo3204a((Object) a2);
                eVar.mo3219c(a4, a5, -this.f2334ah, 6);
                if (z) {
                    eVar.mo3211a(a4, eVar.mo3204a((Object) a), 0, 5);
                    eVar.mo3211a(a5, a4, 0, 5);
                }
            } else if (this.f2332af != -1.0f) {
                eVar.mo3206a(C0786e.m2934a(eVar, eVar.mo3204a((Object) this.f2335ai), eVar.mo3204a((Object) a), eVar.mo3204a((Object) a2), this.f2332af, this.f2337ak));
            }
        }
    }

    /* renamed from: c */
    public void mo3086c(C0786e eVar) {
        if (mo3103k() != null) {
            int b = eVar.mo3214b((Object) this.f2335ai);
            if (this.f2336aj == 1) {
                mo3093f(b);
                mo3096g(0);
                mo3100i(mo3103k().mo3116r());
                mo3098h(0);
            } else {
                mo3093f(0);
                mo3096g(b);
                mo3098h(mo3103k().mo3113p());
                mo3100i(0);
            }
        }
    }
}
