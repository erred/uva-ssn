package androidx.constraintlayout.p060b.p061a;

import androidx.constraintlayout.p060b.C0784c;
import androidx.constraintlayout.p060b.C0786e;
import androidx.constraintlayout.p060b.p061a.C0761e.C0764b;
import androidx.constraintlayout.p060b.p061a.C0761e.C0765c;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;

/* renamed from: androidx.constraintlayout.b.a.f */
/* compiled from: ConstraintWidget */
public class C0766f {

    /* renamed from: R */
    public static float f2225R = 0.5f;

    /* renamed from: A */
    protected C0761e[] f2226A = {this.f2287s, this.f2289u, this.f2288t, this.f2290v, this.f2291w, this.f2294z};

    /* renamed from: B */
    protected ArrayList<C0761e> f2227B = new ArrayList<>();

    /* renamed from: C */
    protected C0768a[] f2228C = {C0768a.FIXED, C0768a.FIXED};

    /* renamed from: D */
    C0766f f2229D = null;

    /* renamed from: E */
    int f2230E = 0;

    /* renamed from: F */
    int f2231F = 0;

    /* renamed from: G */
    protected float f2232G = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: H */
    protected int f2233H = -1;

    /* renamed from: I */
    protected int f2234I = 0;

    /* renamed from: J */
    protected int f2235J = 0;

    /* renamed from: K */
    int f2236K = 0;

    /* renamed from: L */
    int f2237L = 0;

    /* renamed from: M */
    protected int f2238M = 0;

    /* renamed from: N */
    protected int f2239N = 0;

    /* renamed from: O */
    int f2240O = 0;

    /* renamed from: P */
    protected int f2241P;

    /* renamed from: Q */
    protected int f2242Q;

    /* renamed from: S */
    float f2243S = f2225R;

    /* renamed from: T */
    float f2244T = f2225R;

    /* renamed from: U */
    boolean f2245U;

    /* renamed from: V */
    boolean f2246V;

    /* renamed from: W */
    int f2247W = 0;

    /* renamed from: X */
    int f2248X = 0;

    /* renamed from: Y */
    boolean f2249Y;

    /* renamed from: Z */
    boolean f2250Z;

    /* renamed from: a */
    public int f2251a = -1;

    /* renamed from: aa */
    float[] f2252aa = {-1.0f, -1.0f};

    /* renamed from: ab */
    protected C0766f[] f2253ab = {null, null};

    /* renamed from: ac */
    protected C0766f[] f2254ac = {null, null};

    /* renamed from: ad */
    C0766f f2255ad = null;

    /* renamed from: ae */
    C0766f f2256ae = null;

    /* renamed from: af */
    private int[] f2257af = {BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER};

    /* renamed from: ag */
    private float f2258ag = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: ah */
    private int f2259ah = 0;

    /* renamed from: ai */
    private int f2260ai = 0;

    /* renamed from: aj */
    private int f2261aj = 0;

    /* renamed from: ak */
    private int f2262ak = 0;

    /* renamed from: al */
    private int f2263al;

    /* renamed from: am */
    private int f2264am;

    /* renamed from: an */
    private Object f2265an;

    /* renamed from: ao */
    private int f2266ao = 0;

    /* renamed from: ap */
    private int f2267ap = 0;

    /* renamed from: aq */
    private String f2268aq = null;

    /* renamed from: ar */
    private String f2269ar = null;

    /* renamed from: b */
    public int f2270b = -1;

    /* renamed from: c */
    C0778o f2271c;

    /* renamed from: d */
    C0778o f2272d;

    /* renamed from: e */
    int f2273e = 0;

    /* renamed from: f */
    int f2274f = 0;

    /* renamed from: g */
    int[] f2275g = new int[2];

    /* renamed from: h */
    int f2276h = 0;

    /* renamed from: i */
    int f2277i = 0;

    /* renamed from: j */
    float f2278j = 1.0f;

    /* renamed from: k */
    int f2279k = 0;

    /* renamed from: l */
    int f2280l = 0;

    /* renamed from: m */
    float f2281m = 1.0f;

    /* renamed from: n */
    boolean f2282n;

    /* renamed from: o */
    boolean f2283o;

    /* renamed from: p */
    int f2284p = -1;

    /* renamed from: q */
    float f2285q = 1.0f;

    /* renamed from: r */
    C0770h f2286r = null;

    /* renamed from: s */
    C0761e f2287s = new C0761e(this, C0765c.LEFT);

    /* renamed from: t */
    C0761e f2288t = new C0761e(this, C0765c.TOP);

    /* renamed from: u */
    C0761e f2289u = new C0761e(this, C0765c.RIGHT);

    /* renamed from: v */
    C0761e f2290v = new C0761e(this, C0765c.BOTTOM);

    /* renamed from: w */
    C0761e f2291w = new C0761e(this, C0765c.BASELINE);

    /* renamed from: x */
    C0761e f2292x = new C0761e(this, C0765c.CENTER_X);

    /* renamed from: y */
    C0761e f2293y = new C0761e(this, C0765c.CENTER_Y);

    /* renamed from: z */
    C0761e f2294z = new C0761e(this, C0765c.CENTER);

    /* renamed from: androidx.constraintlayout.b.a.f$a */
    /* compiled from: ConstraintWidget */
    public enum C0768a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    /* renamed from: d */
    public void mo3036d() {
    }

    /* renamed from: c */
    public void mo3084c(int i) {
        this.f2257af[0] = i;
    }

    /* renamed from: d */
    public void mo3089d(int i) {
        this.f2257af[1] = i;
    }

    /* renamed from: e */
    public boolean mo3092e() {
        return this.f2273e == 0 && this.f2232G == BitmapDescriptorFactory.HUE_RED && this.f2276h == 0 && this.f2277i == 0 && this.f2228C[0] == C0768a.MATCH_CONSTRAINT;
    }

    /* renamed from: f */
    public boolean mo3094f() {
        return this.f2274f == 0 && this.f2232G == BitmapDescriptorFactory.HUE_RED && this.f2279k == 0 && this.f2280l == 0 && this.f2228C[1] == C0768a.MATCH_CONSTRAINT;
    }

    /* renamed from: g */
    public void mo3095g() {
        this.f2287s.mo3050i();
        this.f2288t.mo3050i();
        this.f2289u.mo3050i();
        this.f2290v.mo3050i();
        this.f2291w.mo3050i();
        this.f2292x.mo3050i();
        this.f2293y.mo3050i();
        this.f2294z.mo3050i();
        this.f2229D = null;
        this.f2258ag = BitmapDescriptorFactory.HUE_RED;
        this.f2230E = 0;
        this.f2231F = 0;
        this.f2232G = BitmapDescriptorFactory.HUE_RED;
        this.f2233H = -1;
        this.f2234I = 0;
        this.f2235J = 0;
        this.f2259ah = 0;
        this.f2260ai = 0;
        this.f2261aj = 0;
        this.f2262ak = 0;
        this.f2238M = 0;
        this.f2239N = 0;
        this.f2240O = 0;
        this.f2241P = 0;
        this.f2242Q = 0;
        this.f2263al = 0;
        this.f2264am = 0;
        this.f2243S = f2225R;
        this.f2244T = f2225R;
        this.f2228C[0] = C0768a.FIXED;
        this.f2228C[1] = C0768a.FIXED;
        this.f2265an = null;
        this.f2266ao = 0;
        this.f2267ap = 0;
        this.f2269ar = null;
        this.f2245U = false;
        this.f2246V = false;
        this.f2247W = 0;
        this.f2248X = 0;
        this.f2249Y = false;
        this.f2250Z = false;
        this.f2252aa[0] = -1.0f;
        this.f2252aa[1] = -1.0f;
        this.f2251a = -1;
        this.f2270b = -1;
        this.f2257af[0] = Integer.MAX_VALUE;
        this.f2257af[1] = Integer.MAX_VALUE;
        this.f2273e = 0;
        this.f2274f = 0;
        this.f2278j = 1.0f;
        this.f2281m = 1.0f;
        this.f2277i = BaseClientBuilder.API_PRIORITY_OTHER;
        this.f2280l = BaseClientBuilder.API_PRIORITY_OTHER;
        this.f2276h = 0;
        this.f2279k = 0;
        this.f2284p = -1;
        this.f2285q = 1.0f;
        if (this.f2271c != null) {
            this.f2271c.mo3155b();
        }
        if (this.f2272d != null) {
            this.f2272d.mo3155b();
        }
        this.f2286r = null;
    }

    /* renamed from: c */
    public void mo3035c() {
        for (int i = 0; i < 6; i++) {
            this.f2226A[i].mo3038a().mo3155b();
        }
    }

    /* renamed from: h */
    public void mo3097h() {
        for (int i = 0; i < 6; i++) {
            this.f2226A[i].mo3038a().mo3159c();
        }
    }

    /* renamed from: b */
    public void mo3033b(int i) {
        C0775l.m2867a(i, this);
    }

    /* renamed from: i */
    public C0778o mo3099i() {
        if (this.f2271c == null) {
            this.f2271c = new C0778o();
        }
        return this.f2271c;
    }

    /* renamed from: j */
    public C0778o mo3101j() {
        if (this.f2272d == null) {
            this.f2272d = new C0778o();
        }
        return this.f2272d;
    }

    public C0766f() {
        mo3034b();
    }

    /* renamed from: a */
    public void mo3072a(C0784c cVar) {
        this.f2287s.mo3039a(cVar);
        this.f2288t.mo3039a(cVar);
        this.f2289u.mo3039a(cVar);
        this.f2290v.mo3039a(cVar);
        this.f2291w.mo3039a(cVar);
        this.f2294z.mo3039a(cVar);
        this.f2292x.mo3039a(cVar);
        this.f2293y.mo3039a(cVar);
    }

    /* renamed from: b */
    private void mo3034b() {
        this.f2227B.add(this.f2287s);
        this.f2227B.add(this.f2288t);
        this.f2227B.add(this.f2289u);
        this.f2227B.add(this.f2290v);
        this.f2227B.add(this.f2292x);
        this.f2227B.add(this.f2293y);
        this.f2227B.add(this.f2294z);
        this.f2227B.add(this.f2291w);
    }

    /* renamed from: k */
    public C0766f mo3103k() {
        return this.f2229D;
    }

    /* renamed from: a_ */
    public void mo3076a_(C0766f fVar) {
        this.f2229D = fVar;
    }

    /* renamed from: b */
    public void mo3082b(boolean z) {
        this.f2282n = z;
    }

    /* renamed from: c */
    public void mo3087c(boolean z) {
        this.f2283o = z;
    }

    /* renamed from: a */
    public void mo3071a(C0766f fVar, float f, int i) {
        mo3069a(C0765c.CENTER, fVar, C0765c.CENTER, i, 0);
        this.f2258ag = f;
    }

    /* renamed from: e */
    public void mo3091e(int i) {
        this.f2267ap = i;
    }

    /* renamed from: l */
    public int mo3105l() {
        return this.f2267ap;
    }

    /* renamed from: m */
    public String mo3107m() {
        return this.f2268aq;
    }

    /* renamed from: b */
    public void mo3081b(C0786e eVar) {
        eVar.mo3204a((Object) this.f2287s);
        eVar.mo3204a((Object) this.f2288t);
        eVar.mo3204a((Object) this.f2289u);
        eVar.mo3204a((Object) this.f2290v);
        if (this.f2240O > 0) {
            eVar.mo3204a((Object) this.f2291w);
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (this.f2269ar != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("type: ");
            sb2.append(this.f2269ar);
            sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            str = sb2.toString();
        } else {
            str = "";
        }
        sb.append(str);
        if (this.f2268aq != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("id: ");
            sb3.append(this.f2268aq);
            sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            str2 = sb3.toString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.f2234I);
        sb.append(", ");
        sb.append(this.f2235J);
        sb.append(") - (");
        sb.append(this.f2230E);
        sb.append(" x ");
        sb.append(this.f2231F);
        sb.append(") wrap: (");
        sb.append(this.f2263al);
        sb.append(" x ");
        sb.append(this.f2264am);
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: n */
    public int mo3109n() {
        return this.f2234I;
    }

    /* renamed from: o */
    public int mo3111o() {
        return this.f2235J;
    }

    /* renamed from: p */
    public int mo3113p() {
        if (this.f2267ap == 8) {
            return 0;
        }
        return this.f2230E;
    }

    /* renamed from: q */
    public int mo3115q() {
        return this.f2263al;
    }

    /* renamed from: r */
    public int mo3116r() {
        if (this.f2267ap == 8) {
            return 0;
        }
        return this.f2231F;
    }

    /* renamed from: s */
    public int mo3117s() {
        return this.f2264am;
    }

    /* renamed from: t */
    public int mo3118t() {
        return this.f2259ah + this.f2238M;
    }

    /* renamed from: u */
    public int mo3120u() {
        return this.f2260ai + this.f2239N;
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public int mo3121v() {
        return this.f2234I + this.f2238M;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public int mo3122w() {
        return this.f2235J + this.f2239N;
    }

    /* renamed from: x */
    public int mo3123x() {
        return mo3109n() + this.f2230E;
    }

    /* renamed from: y */
    public int mo3124y() {
        return mo3111o() + this.f2231F;
    }

    /* renamed from: z */
    public float mo3125z() {
        return this.f2243S;
    }

    /* renamed from: A */
    public boolean mo3053A() {
        return this.f2240O > 0;
    }

    /* renamed from: B */
    public int mo3054B() {
        return this.f2240O;
    }

    /* renamed from: C */
    public Object mo3055C() {
        return this.f2265an;
    }

    /* renamed from: D */
    public ArrayList<C0761e> mo3056D() {
        return this.f2227B;
    }

    /* renamed from: f */
    public void mo3093f(int i) {
        this.f2234I = i;
    }

    /* renamed from: g */
    public void mo3096g(int i) {
        this.f2235J = i;
    }

    /* renamed from: a */
    public void mo3065a(int i, int i2) {
        this.f2234I = i;
        this.f2235J = i2;
    }

    /* renamed from: b */
    public void mo3078b(int i, int i2) {
        this.f2238M = i;
        this.f2239N = i2;
    }

    /* renamed from: E */
    public void mo3057E() {
        int i = this.f2234I;
        int i2 = this.f2235J;
        int i3 = this.f2234I + this.f2230E;
        int i4 = this.f2235J + this.f2231F;
        this.f2259ah = i;
        this.f2260ai = i2;
        this.f2261aj = i3 - i;
        this.f2262ak = i4 - i2;
    }

    /* renamed from: h */
    public void mo3098h(int i) {
        this.f2230E = i;
        if (this.f2230E < this.f2241P) {
            this.f2230E = this.f2241P;
        }
    }

    /* renamed from: i */
    public void mo3100i(int i) {
        this.f2231F = i;
        if (this.f2231F < this.f2242Q) {
            this.f2231F = this.f2242Q;
        }
    }

    /* renamed from: a */
    public void mo3067a(int i, int i2, int i3, float f) {
        this.f2273e = i;
        this.f2276h = i2;
        this.f2277i = i3;
        this.f2278j = f;
        if (f < 1.0f && this.f2273e == 0) {
            this.f2273e = 2;
        }
    }

    /* renamed from: b */
    public void mo3079b(int i, int i2, int i3, float f) {
        this.f2274f = i;
        this.f2279k = i2;
        this.f2280l = i3;
        this.f2281m = f;
        if (f < 1.0f && this.f2274f == 0) {
            this.f2274f = 2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3074a(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x008e
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x008e
        L_0x000b:
            r1 = -1
            int r2 = r9.length()
            r3 = 44
            int r3 = r9.indexOf(r3)
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L_0x0037
            int r6 = r2 + -1
            if (r3 >= r6) goto L_0x0037
            java.lang.String r6 = r9.substring(r4, r3)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002c
            r1 = 0
            goto L_0x0035
        L_0x002c:
            java.lang.String r4 = "H"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0035
            r1 = 1
        L_0x0035:
            int r4 = r3 + 1
        L_0x0037:
            r3 = 58
            int r3 = r9.indexOf(r3)
            if (r3 < 0) goto L_0x0075
            int r2 = r2 - r5
            if (r3 >= r2) goto L_0x0075
            java.lang.String r2 = r9.substring(r4, r3)
            int r3 = r3 + r5
            java.lang.String r9 = r9.substring(r3)
            int r3 = r2.length()
            if (r3 <= 0) goto L_0x0084
            int r3 = r9.length()
            if (r3 <= 0) goto L_0x0084
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            if (r1 != r5) goto L_0x006f
            float r9 = r9 / r2
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x006f:
            float r2 = r2 / r9
            float r9 = java.lang.Math.abs(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0075:
            java.lang.String r9 = r9.substring(r4)
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0084
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0084:
            r9 = 0
        L_0x0085:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008d
            r8.f2232G = r9
            r8.f2233H = r1
        L_0x008d:
            return
        L_0x008e:
            r8.f2232G = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p060b.p061a.C0766f.mo3074a(java.lang.String):void");
    }

    /* renamed from: a */
    public void mo3064a(float f) {
        this.f2243S = f;
    }

    /* renamed from: b */
    public void mo3077b(float f) {
        this.f2244T = f;
    }

    /* renamed from: j */
    public void mo3102j(int i) {
        if (i < 0) {
            this.f2241P = 0;
        } else {
            this.f2241P = i;
        }
    }

    /* renamed from: k */
    public void mo3104k(int i) {
        if (i < 0) {
            this.f2242Q = 0;
        } else {
            this.f2242Q = i;
        }
    }

    /* renamed from: l */
    public void mo3106l(int i) {
        this.f2263al = i;
    }

    /* renamed from: m */
    public void mo3108m(int i) {
        this.f2264am = i;
    }

    /* renamed from: a */
    public void mo3068a(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.f2234I = i;
        this.f2235J = i2;
        if (this.f2267ap == 8) {
            this.f2230E = 0;
            this.f2231F = 0;
            return;
        }
        if (this.f2228C[0] == C0768a.FIXED && i5 < this.f2230E) {
            i5 = this.f2230E;
        }
        if (this.f2228C[1] == C0768a.FIXED && i6 < this.f2231F) {
            i6 = this.f2231F;
        }
        this.f2230E = i5;
        this.f2231F = i6;
        if (this.f2231F < this.f2242Q) {
            this.f2231F = this.f2242Q;
        }
        if (this.f2230E < this.f2241P) {
            this.f2230E = this.f2241P;
        }
    }

    /* renamed from: a */
    public void mo3066a(int i, int i2, int i3) {
        if (i3 == 0) {
            mo3085c(i, i2);
        } else if (i3 == 1) {
            mo3090d(i, i2);
        }
    }

    /* renamed from: c */
    public void mo3085c(int i, int i2) {
        this.f2234I = i;
        this.f2230E = i2 - i;
        if (this.f2230E < this.f2241P) {
            this.f2230E = this.f2241P;
        }
    }

    /* renamed from: d */
    public void mo3090d(int i, int i2) {
        this.f2235J = i;
        this.f2231F = i2 - i;
        if (this.f2231F < this.f2242Q) {
            this.f2231F = this.f2242Q;
        }
    }

    /* renamed from: n */
    public void mo3110n(int i) {
        this.f2240O = i;
    }

    /* renamed from: a */
    public void mo3073a(Object obj) {
        this.f2265an = obj;
    }

    /* renamed from: c */
    public void mo3083c(float f) {
        this.f2252aa[0] = f;
    }

    /* renamed from: d */
    public void mo3088d(float f) {
        this.f2252aa[1] = f;
    }

    /* renamed from: o */
    public void mo3112o(int i) {
        this.f2247W = i;
    }

    /* renamed from: p */
    public void mo3114p(int i) {
        this.f2248X = i;
    }

    /* renamed from: a */
    public boolean mo3032a() {
        return this.f2267ap != 8;
    }

    /* renamed from: a */
    public void mo3069a(C0765c cVar, C0766f fVar, C0765c cVar2, int i, int i2) {
        mo3063a(cVar).mo3041a(fVar.mo3063a(cVar2), i, i2, C0764b.STRONG, 0, true);
    }

    /* renamed from: F */
    public void mo3058F() {
        C0766f k = mo3103k();
        if (k == null || !(k instanceof C0769g) || !((C0769g) mo3103k()).mo3134S()) {
            int size = this.f2227B.size();
            for (int i = 0; i < size; i++) {
                ((C0761e) this.f2227B.get(i)).mo3050i();
            }
        }
    }

    /* renamed from: a */
    public C0761e mo3063a(C0765c cVar) {
        switch (cVar) {
            case LEFT:
                return this.f2287s;
            case TOP:
                return this.f2288t;
            case RIGHT:
                return this.f2289u;
            case BOTTOM:
                return this.f2290v;
            case BASELINE:
                return this.f2291w;
            case CENTER:
                return this.f2294z;
            case CENTER_X:
                return this.f2292x;
            case CENTER_Y:
                return this.f2293y;
            case NONE:
                return null;
            default:
                throw new AssertionError(cVar.name());
        }
    }

    /* renamed from: G */
    public C0768a mo3059G() {
        return this.f2228C[0];
    }

    /* renamed from: H */
    public C0768a mo3060H() {
        return this.f2228C[1];
    }

    /* renamed from: a */
    public void mo3070a(C0768a aVar) {
        this.f2228C[0] = aVar;
        if (aVar == C0768a.WRAP_CONTENT) {
            mo3098h(this.f2263al);
        }
    }

    /* renamed from: b */
    public void mo3080b(C0768a aVar) {
        this.f2228C[1] = aVar;
        if (aVar == C0768a.WRAP_CONTENT) {
            mo3100i(this.f2264am);
        }
    }

    /* renamed from: I */
    public boolean mo3061I() {
        return (this.f2287s.f2199c != null && this.f2287s.f2199c.f2199c == this.f2287s) || (this.f2289u.f2199c != null && this.f2289u.f2199c.f2199c == this.f2289u);
    }

    /* renamed from: J */
    public boolean mo3062J() {
        return (this.f2288t.f2199c != null && this.f2288t.f2199c.f2199c == this.f2288t) || (this.f2290v.f2199c != null && this.f2290v.f2199c.f2199c == this.f2290v);
    }

    /* renamed from: a */
    private boolean mo3029a(int i) {
        int i2 = i * 2;
        if (!(this.f2226A[i2].f2199c == null || this.f2226A[i2].f2199c.f2199c == this.f2226A[i2])) {
            int i3 = i2 + 1;
            if (this.f2226A[i3].f2199c != null && this.f2226A[i3].f2199c.f2199c == this.f2226A[i3]) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01c4, code lost:
        if (r15.f2284p == -1) goto L_0x01c8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x026b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0327  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x035a  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01bd  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3030a(androidx.constraintlayout.p060b.C0786e r39) {
        /*
            r38 = this;
            r15 = r38
            r14 = r39
            androidx.constraintlayout.b.a.e r0 = r15.f2287s
            androidx.constraintlayout.b.h r21 = r14.mo3204a(r0)
            androidx.constraintlayout.b.a.e r0 = r15.f2289u
            androidx.constraintlayout.b.h r10 = r14.mo3204a(r0)
            androidx.constraintlayout.b.a.e r0 = r15.f2288t
            androidx.constraintlayout.b.h r6 = r14.mo3204a(r0)
            androidx.constraintlayout.b.a.e r0 = r15.f2290v
            androidx.constraintlayout.b.h r4 = r14.mo3204a(r0)
            androidx.constraintlayout.b.a.e r0 = r15.f2291w
            androidx.constraintlayout.b.h r3 = r14.mo3204a(r0)
            androidx.constraintlayout.b.a.f r0 = r15.f2229D
            r1 = 8
            r2 = 1
            r13 = 0
            if (r0 == 0) goto L_0x00b6
            androidx.constraintlayout.b.a.f r0 = r15.f2229D
            if (r0 == 0) goto L_0x003a
            androidx.constraintlayout.b.a.f r0 = r15.f2229D
            androidx.constraintlayout.b.a.f$a[] r0 = r0.f2228C
            r0 = r0[r13]
            androidx.constraintlayout.b.a.f$a r5 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            if (r0 != r5) goto L_0x003a
            r0 = 1
            goto L_0x003b
        L_0x003a:
            r0 = 0
        L_0x003b:
            androidx.constraintlayout.b.a.f r5 = r15.f2229D
            if (r5 == 0) goto L_0x004b
            androidx.constraintlayout.b.a.f r5 = r15.f2229D
            androidx.constraintlayout.b.a.f$a[] r5 = r5.f2228C
            r5 = r5[r2]
            androidx.constraintlayout.b.a.f$a r7 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            if (r5 != r7) goto L_0x004b
            r5 = 1
            goto L_0x004c
        L_0x004b:
            r5 = 0
        L_0x004c:
            boolean r7 = r15.mo3029a(r13)
            if (r7 == 0) goto L_0x005b
            androidx.constraintlayout.b.a.f r7 = r15.f2229D
            androidx.constraintlayout.b.a.g r7 = (androidx.constraintlayout.p060b.p061a.C0769g) r7
            r7.mo3135a(r15, r13)
            r7 = 1
            goto L_0x005f
        L_0x005b:
            boolean r7 = r38.mo3061I()
        L_0x005f:
            boolean r8 = r15.mo3029a(r2)
            if (r8 == 0) goto L_0x006e
            androidx.constraintlayout.b.a.f r8 = r15.f2229D
            androidx.constraintlayout.b.a.g r8 = (androidx.constraintlayout.p060b.p061a.C0769g) r8
            r8.mo3135a(r15, r2)
            r8 = 1
            goto L_0x0072
        L_0x006e:
            boolean r8 = r38.mo3062J()
        L_0x0072:
            if (r0 == 0) goto L_0x008f
            int r9 = r15.f2267ap
            if (r9 == r1) goto L_0x008f
            androidx.constraintlayout.b.a.e r9 = r15.f2287s
            androidx.constraintlayout.b.a.e r9 = r9.f2199c
            if (r9 != 0) goto L_0x008f
            androidx.constraintlayout.b.a.e r9 = r15.f2289u
            androidx.constraintlayout.b.a.e r9 = r9.f2199c
            if (r9 != 0) goto L_0x008f
            androidx.constraintlayout.b.a.f r9 = r15.f2229D
            androidx.constraintlayout.b.a.e r9 = r9.f2289u
            androidx.constraintlayout.b.h r9 = r14.mo3204a(r9)
            r14.mo3211a(r9, r10, r13, r2)
        L_0x008f:
            if (r5 == 0) goto L_0x00b0
            int r9 = r15.f2267ap
            if (r9 == r1) goto L_0x00b0
            androidx.constraintlayout.b.a.e r9 = r15.f2288t
            androidx.constraintlayout.b.a.e r9 = r9.f2199c
            if (r9 != 0) goto L_0x00b0
            androidx.constraintlayout.b.a.e r9 = r15.f2290v
            androidx.constraintlayout.b.a.e r9 = r9.f2199c
            if (r9 != 0) goto L_0x00b0
            androidx.constraintlayout.b.a.e r9 = r15.f2291w
            if (r9 != 0) goto L_0x00b0
            androidx.constraintlayout.b.a.f r9 = r15.f2229D
            androidx.constraintlayout.b.a.e r9 = r9.f2290v
            androidx.constraintlayout.b.h r9 = r14.mo3204a(r9)
            r14.mo3211a(r9, r4, r13, r2)
        L_0x00b0:
            r12 = r5
            r16 = r7
            r22 = r8
            goto L_0x00bc
        L_0x00b6:
            r0 = 0
            r12 = 0
            r16 = 0
            r22 = 0
        L_0x00bc:
            int r5 = r15.f2230E
            int r7 = r15.f2241P
            if (r5 >= r7) goto L_0x00c4
            int r5 = r15.f2241P
        L_0x00c4:
            int r7 = r15.f2231F
            int r8 = r15.f2242Q
            if (r7 >= r8) goto L_0x00cc
            int r7 = r15.f2242Q
        L_0x00cc:
            androidx.constraintlayout.b.a.f$a[] r8 = r15.f2228C
            r8 = r8[r13]
            androidx.constraintlayout.b.a.f$a r9 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.MATCH_CONSTRAINT
            if (r8 == r9) goto L_0x00d6
            r8 = 1
            goto L_0x00d7
        L_0x00d6:
            r8 = 0
        L_0x00d7:
            androidx.constraintlayout.b.a.f$a[] r9 = r15.f2228C
            r9 = r9[r2]
            androidx.constraintlayout.b.a.f$a r11 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.MATCH_CONSTRAINT
            if (r9 == r11) goto L_0x00e1
            r9 = 1
            goto L_0x00e2
        L_0x00e1:
            r9 = 0
        L_0x00e2:
            int r11 = r15.f2233H
            r15.f2284p = r11
            float r11 = r15.f2232G
            r15.f2285q = r11
            int r11 = r15.f2273e
            int r2 = r15.f2274f
            float r13 = r15.f2232G
            r17 = 0
            r18 = 4
            int r13 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1))
            if (r13 <= 0) goto L_0x01a5
            int r13 = r15.f2267ap
            r1 = 8
            if (r13 == r1) goto L_0x01a5
            androidx.constraintlayout.b.a.f$a[] r1 = r15.f2228C
            r13 = 0
            r1 = r1[r13]
            androidx.constraintlayout.b.a.f$a r13 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.MATCH_CONSTRAINT
            r27 = r3
            r3 = 3
            if (r1 != r13) goto L_0x010d
            if (r11 != 0) goto L_0x010d
            r11 = 3
        L_0x010d:
            androidx.constraintlayout.b.a.f$a[] r1 = r15.f2228C
            r13 = 1
            r1 = r1[r13]
            androidx.constraintlayout.b.a.f$a r13 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.MATCH_CONSTRAINT
            if (r1 != r13) goto L_0x0119
            if (r2 != 0) goto L_0x0119
            r2 = 3
        L_0x0119:
            androidx.constraintlayout.b.a.f$a[] r1 = r15.f2228C
            r13 = 0
            r1 = r1[r13]
            androidx.constraintlayout.b.a.f$a r13 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.MATCH_CONSTRAINT
            if (r1 != r13) goto L_0x0134
            androidx.constraintlayout.b.a.f$a[] r1 = r15.f2228C
            r13 = 1
            r1 = r1[r13]
            androidx.constraintlayout.b.a.f$a r13 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.MATCH_CONSTRAINT
            if (r1 != r13) goto L_0x0134
            if (r11 != r3) goto L_0x0134
            if (r2 != r3) goto L_0x0134
            r15.mo3075a(r0, r12, r8, r9)
            goto L_0x019a
        L_0x0134:
            androidx.constraintlayout.b.a.f$a[] r1 = r15.f2228C
            r8 = 0
            r1 = r1[r8]
            androidx.constraintlayout.b.a.f$a r9 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.MATCH_CONSTRAINT
            if (r1 != r9) goto L_0x0160
            if (r11 != r3) goto L_0x0160
            r15.f2284p = r8
            float r1 = r15.f2285q
            int r3 = r15.f2231F
            float r3 = (float) r3
            float r1 = r1 * r3
            int r1 = (int) r1
            androidx.constraintlayout.b.a.f$a[] r3 = r15.f2228C
            r8 = 1
            r3 = r3[r8]
            androidx.constraintlayout.b.a.f$a r5 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.MATCH_CONSTRAINT
            if (r3 == r5) goto L_0x015b
            r29 = r1
            r25 = r2
            r30 = r7
            r20 = 4
            goto L_0x01af
        L_0x015b:
            r29 = r1
            r25 = r2
            goto L_0x019e
        L_0x0160:
            r8 = 1
            androidx.constraintlayout.b.a.f$a[] r1 = r15.f2228C
            r1 = r1[r8]
            androidx.constraintlayout.b.a.f$a r9 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.MATCH_CONSTRAINT
            if (r1 != r9) goto L_0x019a
            if (r2 != r3) goto L_0x019a
            r15.f2284p = r8
            int r1 = r15.f2233H
            r3 = -1
            if (r1 != r3) goto L_0x0179
            r1 = 1065353216(0x3f800000, float:1.0)
            float r3 = r15.f2285q
            float r1 = r1 / r3
            r15.f2285q = r1
        L_0x0179:
            float r1 = r15.f2285q
            int r3 = r15.f2230E
            float r3 = (float) r3
            float r1 = r1 * r3
            int r1 = (int) r1
            androidx.constraintlayout.b.a.f$a[] r3 = r15.f2228C
            r7 = 0
            r3 = r3[r7]
            androidx.constraintlayout.b.a.f$a r7 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.MATCH_CONSTRAINT
            if (r3 == r7) goto L_0x0193
            r30 = r1
            r29 = r5
            r20 = r11
            r25 = 4
            goto L_0x01af
        L_0x0193:
            r30 = r1
            r25 = r2
            r29 = r5
            goto L_0x01a0
        L_0x019a:
            r25 = r2
            r29 = r5
        L_0x019e:
            r30 = r7
        L_0x01a0:
            r20 = r11
            r28 = 1
            goto L_0x01b1
        L_0x01a5:
            r27 = r3
            r25 = r2
            r29 = r5
            r30 = r7
            r20 = r11
        L_0x01af:
            r28 = 0
        L_0x01b1:
            int[] r1 = r15.f2275g
            r2 = 0
            r1[r2] = r20
            int[] r1 = r15.f2275g
            r2 = 1
            r1[r2] = r25
            if (r28 == 0) goto L_0x01cb
            int r1 = r15.f2284p
            if (r1 == 0) goto L_0x01c7
            int r1 = r15.f2284p
            r2 = -1
            if (r1 != r2) goto L_0x01cc
            goto L_0x01c8
        L_0x01c7:
            r2 = -1
        L_0x01c8:
            r26 = 1
            goto L_0x01ce
        L_0x01cb:
            r2 = -1
        L_0x01cc:
            r26 = 0
        L_0x01ce:
            androidx.constraintlayout.b.a.f$a[] r1 = r15.f2228C
            r3 = 0
            r1 = r1[r3]
            androidx.constraintlayout.b.a.f$a r3 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            if (r1 != r3) goto L_0x01de
            boolean r1 = r15 instanceof androidx.constraintlayout.p060b.p061a.C0769g
            if (r1 == 0) goto L_0x01de
            r31 = 1
            goto L_0x01e0
        L_0x01de:
            r31 = 0
        L_0x01e0:
            androidx.constraintlayout.b.a.e r1 = r15.f2294z
            boolean r1 = r1.mo3051j()
            r3 = 1
            r23 = r1 ^ 1
            int r1 = r15.f2251a
            r13 = 2
            r32 = 0
            if (r1 == r13) goto L_0x025a
            androidx.constraintlayout.b.a.f r1 = r15.f2229D
            if (r1 == 0) goto L_0x01ff
            androidx.constraintlayout.b.a.f r1 = r15.f2229D
            androidx.constraintlayout.b.a.e r1 = r1.f2289u
            androidx.constraintlayout.b.h r1 = r14.mo3204a(r1)
            r33 = r1
            goto L_0x0201
        L_0x01ff:
            r33 = r32
        L_0x0201:
            androidx.constraintlayout.b.a.f r1 = r15.f2229D
            if (r1 == 0) goto L_0x0210
            androidx.constraintlayout.b.a.f r1 = r15.f2229D
            androidx.constraintlayout.b.a.e r1 = r1.f2287s
            androidx.constraintlayout.b.h r1 = r14.mo3204a(r1)
            r34 = r1
            goto L_0x0212
        L_0x0210:
            r34 = r32
        L_0x0212:
            androidx.constraintlayout.b.a.f$a[] r1 = r15.f2228C
            r17 = 0
            r5 = r1[r17]
            androidx.constraintlayout.b.a.e r7 = r15.f2287s
            androidx.constraintlayout.b.a.e r8 = r15.f2289u
            int r9 = r15.f2234I
            int r11 = r15.f2241P
            int[] r1 = r15.f2257af
            r1 = r1[r17]
            r24 = r12
            r12 = r1
            float r1 = r15.f2243S
            r13 = r1
            int r1 = r15.f2276h
            r17 = r1
            int r1 = r15.f2277i
            r18 = r1
            float r1 = r15.f2278j
            r19 = r1
            r35 = r0
            r0 = r38
            r1 = r39
            r2 = r35
            r36 = r27
            r3 = r34
            r27 = r4
            r4 = r33
            r37 = r6
            r6 = r31
            r31 = r10
            r10 = r29
            r14 = r26
            r15 = r16
            r16 = r20
            r20 = r23
            r0.m2748a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            goto L_0x0264
        L_0x025a:
            r37 = r6
            r31 = r10
            r24 = r12
            r36 = r27
            r27 = r4
        L_0x0264:
            r15 = r38
            int r0 = r15.f2270b
            r1 = 2
            if (r0 != r1) goto L_0x026c
            return
        L_0x026c:
            androidx.constraintlayout.b.a.f$a[] r0 = r15.f2228C
            r14 = 1
            r0 = r0[r14]
            androidx.constraintlayout.b.a.f$a r1 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            if (r0 != r1) goto L_0x027b
            boolean r0 = r15 instanceof androidx.constraintlayout.p060b.p061a.C0769g
            if (r0 == 0) goto L_0x027b
            r6 = 1
            goto L_0x027c
        L_0x027b:
            r6 = 0
        L_0x027c:
            if (r28 == 0) goto L_0x028a
            int r0 = r15.f2284p
            if (r0 == r14) goto L_0x0287
            int r0 = r15.f2284p
            r1 = -1
            if (r0 != r1) goto L_0x028a
        L_0x0287:
            r16 = 1
            goto L_0x028c
        L_0x028a:
            r16 = 0
        L_0x028c:
            int r0 = r15.f2240O
            if (r0 <= 0) goto L_0x02cb
            androidx.constraintlayout.b.a.e r0 = r15.f2291w
            androidx.constraintlayout.b.a.n r0 = r0.mo3038a()
            int r0 = r0.f2360i
            if (r0 != r14) goto L_0x02a8
            androidx.constraintlayout.b.a.e r0 = r15.f2291w
            androidx.constraintlayout.b.a.n r0 = r0.mo3038a()
            r10 = r39
            r0.mo3154a(r10)
            r4 = r37
            goto L_0x02cf
        L_0x02a8:
            r10 = r39
            int r0 = r38.mo3054B()
            r1 = 6
            r2 = r36
            r4 = r37
            r10.mo3219c(r2, r4, r0, r1)
            androidx.constraintlayout.b.a.e r0 = r15.f2291w
            androidx.constraintlayout.b.a.e r0 = r0.f2199c
            if (r0 == 0) goto L_0x02cf
            androidx.constraintlayout.b.a.e r0 = r15.f2291w
            androidx.constraintlayout.b.a.e r0 = r0.f2199c
            androidx.constraintlayout.b.h r0 = r10.mo3204a(r0)
            r3 = 0
            r10.mo3219c(r2, r0, r3, r1)
            r20 = 0
            goto L_0x02d1
        L_0x02cb:
            r4 = r37
            r10 = r39
        L_0x02cf:
            r20 = r23
        L_0x02d1:
            androidx.constraintlayout.b.a.f r0 = r15.f2229D
            if (r0 == 0) goto L_0x02e0
            androidx.constraintlayout.b.a.f r0 = r15.f2229D
            androidx.constraintlayout.b.a.e r0 = r0.f2290v
            androidx.constraintlayout.b.h r0 = r10.mo3204a(r0)
            r23 = r0
            goto L_0x02e2
        L_0x02e0:
            r23 = r32
        L_0x02e2:
            androidx.constraintlayout.b.a.f r0 = r15.f2229D
            if (r0 == 0) goto L_0x02f0
            androidx.constraintlayout.b.a.f r0 = r15.f2229D
            androidx.constraintlayout.b.a.e r0 = r0.f2288t
            androidx.constraintlayout.b.h r0 = r10.mo3204a(r0)
            r3 = r0
            goto L_0x02f2
        L_0x02f0:
            r3 = r32
        L_0x02f2:
            androidx.constraintlayout.b.a.f$a[] r0 = r15.f2228C
            r5 = r0[r14]
            androidx.constraintlayout.b.a.e r7 = r15.f2288t
            androidx.constraintlayout.b.a.e r8 = r15.f2290v
            int r9 = r15.f2235J
            int r11 = r15.f2242Q
            int[] r0 = r15.f2257af
            r12 = r0[r14]
            float r13 = r15.f2244T
            int r0 = r15.f2279k
            r17 = r0
            int r0 = r15.f2280l
            r18 = r0
            float r0 = r15.f2281m
            r19 = r0
            r0 = r38
            r1 = r39
            r2 = r24
            r24 = r4
            r4 = r23
            r10 = r30
            r14 = r16
            r15 = r22
            r16 = r25
            r0.m2748a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            if (r28 == 0) goto L_0x0350
            r6 = 6
            r7 = r38
            int r0 = r7.f2284p
            r1 = 1
            if (r0 != r1) goto L_0x0340
            float r5 = r7.f2285q
            r6 = 6
            r0 = r39
            r1 = r27
            r2 = r24
            r3 = r31
            r4 = r21
            r0.mo3212a(r1, r2, r3, r4, r5, r6)
            goto L_0x0352
        L_0x0340:
            float r5 = r7.f2285q
            r0 = r39
            r1 = r31
            r2 = r21
            r3 = r27
            r4 = r24
            r0.mo3212a(r1, r2, r3, r4, r5, r6)
            goto L_0x0352
        L_0x0350:
            r7 = r38
        L_0x0352:
            androidx.constraintlayout.b.a.e r0 = r7.f2294z
            boolean r0 = r0.mo3051j()
            if (r0 == 0) goto L_0x037a
            androidx.constraintlayout.b.a.e r0 = r7.f2294z
            androidx.constraintlayout.b.a.e r0 = r0.mo3048g()
            androidx.constraintlayout.b.a.f r0 = r0.mo3044c()
            float r1 = r7.f2258ag
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            androidx.constraintlayout.b.a.e r2 = r7.f2294z
            int r2 = r2.mo3046e()
            r3 = r39
            r3.mo3205a(r7, r0, r1, r2)
        L_0x037a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p060b.p061a.C0766f.mo3030a(androidx.constraintlayout.b.e):void");
    }

    /* renamed from: a */
    public void mo3075a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.f2284p == -1) {
            if (z3 && !z4) {
                this.f2284p = 0;
            } else if (!z3 && z4) {
                this.f2284p = 1;
                if (this.f2233H == -1) {
                    this.f2285q = 1.0f / this.f2285q;
                }
            }
        }
        if (this.f2284p == 0 && (!this.f2288t.mo3051j() || !this.f2290v.mo3051j())) {
            this.f2284p = 1;
        } else if (this.f2284p == 1 && (!this.f2287s.mo3051j() || !this.f2289u.mo3051j())) {
            this.f2284p = 0;
        }
        if (this.f2284p == -1 && (!this.f2288t.mo3051j() || !this.f2290v.mo3051j() || !this.f2287s.mo3051j() || !this.f2289u.mo3051j())) {
            if (this.f2288t.mo3051j() && this.f2290v.mo3051j()) {
                this.f2284p = 0;
            } else if (this.f2287s.mo3051j() && this.f2289u.mo3051j()) {
                this.f2285q = 1.0f / this.f2285q;
                this.f2284p = 1;
            }
        }
        if (this.f2284p == -1) {
            if (z && !z2) {
                this.f2284p = 0;
            } else if (!z && z2) {
                this.f2285q = 1.0f / this.f2285q;
                this.f2284p = 1;
            }
        }
        if (this.f2284p == -1) {
            if (this.f2276h > 0 && this.f2279k == 0) {
                this.f2284p = 0;
            } else if (this.f2276h == 0 && this.f2279k > 0) {
                this.f2285q = 1.0f / this.f2285q;
                this.f2284p = 1;
            }
        }
        if (this.f2284p == -1 && z && z2) {
            this.f2285q = 1.0f / this.f2285q;
            this.f2284p = 1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:156:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01de  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2748a(androidx.constraintlayout.p060b.C0786e r31, boolean r32, androidx.constraintlayout.p060b.C0792h r33, androidx.constraintlayout.p060b.C0792h r34, androidx.constraintlayout.p060b.p061a.C0766f.C0768a r35, boolean r36, androidx.constraintlayout.p060b.p061a.C0761e r37, androidx.constraintlayout.p060b.p061a.C0761e r38, int r39, int r40, int r41, int r42, float r43, boolean r44, boolean r45, int r46, int r47, int r48, float r49, boolean r50) {
        /*
            r30 = this;
            r0 = r30
            r10 = r31
            r11 = r33
            r12 = r34
            r1 = r41
            r2 = r42
            r13 = r37
            androidx.constraintlayout.b.h r9 = r10.mo3204a(r13)
            r8 = r38
            androidx.constraintlayout.b.h r7 = r10.mo3204a(r8)
            androidx.constraintlayout.b.a.e r6 = r37.mo3048g()
            androidx.constraintlayout.b.h r6 = r10.mo3204a(r6)
            androidx.constraintlayout.b.a.e r14 = r38.mo3048g()
            androidx.constraintlayout.b.h r14 = r10.mo3204a(r14)
            boolean r8 = r10.f2384c
            r15 = 1
            if (r8 == 0) goto L_0x0066
            androidx.constraintlayout.b.a.n r8 = r37.mo3038a()
            int r8 = r8.f2360i
            r13 = 1
            if (r8 != r13) goto L_0x0066
            androidx.constraintlayout.b.a.n r8 = r38.mo3038a()
            int r8 = r8.f2360i
            if (r8 != r13) goto L_0x0066
            androidx.constraintlayout.b.f r1 = androidx.constraintlayout.p060b.C0786e.m2935a()
            if (r1 == 0) goto L_0x004e
            androidx.constraintlayout.b.f r1 = androidx.constraintlayout.p060b.C0786e.m2935a()
            long r2 = r1.f2420s
            long r2 = r2 + r15
            r1.f2420s = r2
        L_0x004e:
            androidx.constraintlayout.b.a.n r1 = r37.mo3038a()
            r1.mo3154a(r10)
            androidx.constraintlayout.b.a.n r1 = r38.mo3038a()
            r1.mo3154a(r10)
            if (r45 != 0) goto L_0x0065
            if (r32 == 0) goto L_0x0065
            r1 = 0
            r2 = 6
            r10.mo3211a(r12, r7, r1, r2)
        L_0x0065:
            return
        L_0x0066:
            androidx.constraintlayout.b.f r8 = androidx.constraintlayout.p060b.C0786e.m2935a()
            if (r8 == 0) goto L_0x0078
            androidx.constraintlayout.b.f r8 = androidx.constraintlayout.p060b.C0786e.m2935a()
            r20 = r14
            long r13 = r8.f2399B
            long r13 = r13 + r15
            r8.f2399B = r13
            goto L_0x007a
        L_0x0078:
            r20 = r14
        L_0x007a:
            boolean r8 = r37.mo3051j()
            boolean r13 = r38.mo3051j()
            androidx.constraintlayout.b.a.e r14 = r0.f2294z
            boolean r21 = r14.mo3051j()
            if (r8 == 0) goto L_0x008c
            r14 = 1
            goto L_0x008d
        L_0x008c:
            r14 = 0
        L_0x008d:
            if (r13 == 0) goto L_0x0091
            int r14 = r14 + 1
        L_0x0091:
            if (r21 == 0) goto L_0x0095
            int r14 = r14 + 1
        L_0x0095:
            if (r44 == 0) goto L_0x0099
            r11 = 3
            goto L_0x009b
        L_0x0099:
            r11 = r46
        L_0x009b:
            int[] r15 = androidx.constraintlayout.p060b.p061a.C0766f.C07671.f2296b
            int r16 = r35.ordinal()
            r15 = r15[r16]
            r12 = 4
            switch(r15) {
                case 1: goto L_0x00a7;
                case 2: goto L_0x00a7;
                case 3: goto L_0x00a7;
                case 4: goto L_0x00a9;
                default: goto L_0x00a7;
            }
        L_0x00a7:
            r15 = 0
            goto L_0x00ad
        L_0x00a9:
            if (r11 != r12) goto L_0x00ac
            goto L_0x00a7
        L_0x00ac:
            r15 = 1
        L_0x00ad:
            int r12 = r0.f2267ap
            r22 = r14
            r14 = 8
            if (r12 != r14) goto L_0x00b8
            r12 = 0
            r15 = 0
            goto L_0x00ba
        L_0x00b8:
            r12 = r40
        L_0x00ba:
            if (r50 == 0) goto L_0x00d7
            if (r8 != 0) goto L_0x00c8
            if (r13 != 0) goto L_0x00c8
            if (r21 != 0) goto L_0x00c8
            r14 = r39
            r10.mo3209a(r9, r14)
            goto L_0x00d7
        L_0x00c8:
            if (r8 == 0) goto L_0x00d7
            if (r13 != 0) goto L_0x00d7
            int r14 = r37.mo3046e()
            r23 = r13
            r13 = 6
            r10.mo3219c(r9, r6, r14, r13)
            goto L_0x00da
        L_0x00d7:
            r23 = r13
            r13 = 6
        L_0x00da:
            if (r15 != 0) goto L_0x010a
            if (r36 == 0) goto L_0x00f4
            r13 = 3
            r14 = 0
            r10.mo3219c(r7, r9, r14, r13)
            if (r1 <= 0) goto L_0x00ea
            r14 = 6
            r10.mo3211a(r7, r9, r1, r14)
            goto L_0x00eb
        L_0x00ea:
            r14 = 6
        L_0x00eb:
            r12 = 2147483647(0x7fffffff, float:NaN)
            if (r2 >= r12) goto L_0x00f9
            r10.mo3216b(r7, r9, r2, r14)
            goto L_0x00f9
        L_0x00f4:
            r13 = 3
            r14 = 6
            r10.mo3219c(r7, r9, r12, r14)
        L_0x00f9:
            r13 = r47
            r2 = r48
            r24 = r6
            r27 = r11
            r6 = r20
            r0 = r22
            r11 = 2
            r20 = 4
            goto L_0x01e7
        L_0x010a:
            r13 = 3
            r2 = -2
            r14 = r47
            if (r14 != r2) goto L_0x0114
            r14 = r48
            r13 = r12
            goto L_0x0117
        L_0x0114:
            r13 = r14
            r14 = r48
        L_0x0117:
            if (r14 != r2) goto L_0x011b
            r2 = r12
            goto L_0x011c
        L_0x011b:
            r2 = r14
        L_0x011c:
            if (r13 <= 0) goto L_0x012e
            if (r32 == 0) goto L_0x0125
            r14 = 6
            r10.mo3211a(r7, r9, r13, r14)
            goto L_0x0129
        L_0x0125:
            r14 = 6
            r10.mo3211a(r7, r9, r13, r14)
        L_0x0129:
            int r12 = java.lang.Math.max(r12, r13)
            goto L_0x012f
        L_0x012e:
            r14 = 6
        L_0x012f:
            if (r2 <= 0) goto L_0x0140
            if (r32 == 0) goto L_0x0139
            r14 = 1
            r10.mo3216b(r7, r9, r2, r14)
            r14 = 6
            goto L_0x013c
        L_0x0139:
            r10.mo3216b(r7, r9, r2, r14)
        L_0x013c:
            int r12 = java.lang.Math.min(r12, r2)
        L_0x0140:
            r14 = 1
            if (r11 != r14) goto L_0x0159
            if (r32 == 0) goto L_0x014b
            r14 = 6
            r10.mo3219c(r7, r9, r12, r14)
            goto L_0x01c7
        L_0x014b:
            if (r45 == 0) goto L_0x0153
            r14 = 4
            r10.mo3219c(r7, r9, r12, r14)
            goto L_0x01c7
        L_0x0153:
            r14 = 1
            r10.mo3219c(r7, r9, r12, r14)
            goto L_0x01c7
        L_0x0159:
            r14 = 2
            if (r11 != r14) goto L_0x01c7
            androidx.constraintlayout.b.a.e$c r14 = r37.mo3045d()
            r24 = r6
            androidx.constraintlayout.b.a.e$c r6 = androidx.constraintlayout.p060b.p061a.C0761e.C0765c.TOP
            if (r14 == r6) goto L_0x018e
            androidx.constraintlayout.b.a.e$c r6 = r37.mo3045d()
            androidx.constraintlayout.b.a.e$c r14 = androidx.constraintlayout.p060b.p061a.C0761e.C0765c.BOTTOM
            if (r6 != r14) goto L_0x016f
            goto L_0x018e
        L_0x016f:
            androidx.constraintlayout.b.a.f r6 = r0.f2229D
            androidx.constraintlayout.b.a.e$c r14 = androidx.constraintlayout.p060b.p061a.C0761e.C0765c.LEFT
            androidx.constraintlayout.b.a.e r6 = r6.mo3063a(r14)
            androidx.constraintlayout.b.h r6 = r10.mo3204a(r6)
            androidx.constraintlayout.b.a.f r14 = r0.f2229D
            r25 = r6
            androidx.constraintlayout.b.a.e$c r6 = androidx.constraintlayout.p060b.p061a.C0761e.C0765c.RIGHT
            androidx.constraintlayout.b.a.e r6 = r14.mo3063a(r6)
            androidx.constraintlayout.b.h r6 = r10.mo3204a(r6)
            r17 = r6
            r18 = r25
            goto L_0x01ac
        L_0x018e:
            androidx.constraintlayout.b.a.f r6 = r0.f2229D
            androidx.constraintlayout.b.a.e$c r14 = androidx.constraintlayout.p060b.p061a.C0761e.C0765c.TOP
            androidx.constraintlayout.b.a.e r6 = r6.mo3063a(r14)
            androidx.constraintlayout.b.h r6 = r10.mo3204a(r6)
            androidx.constraintlayout.b.a.f r14 = r0.f2229D
            r26 = r6
            androidx.constraintlayout.b.a.e$c r6 = androidx.constraintlayout.p060b.p061a.C0761e.C0765c.BOTTOM
            androidx.constraintlayout.b.a.e r6 = r14.mo3063a(r6)
            androidx.constraintlayout.b.h r6 = r10.mo3204a(r6)
            r17 = r6
            r18 = r26
        L_0x01ac:
            androidx.constraintlayout.b.b r14 = r31.mo3218c()
            r27 = r11
            r6 = r20
            r0 = r22
            r11 = 2
            r20 = 4
            r15 = r7
            r16 = r9
            r19 = r49
            androidx.constraintlayout.b.b r14 = r14.mo3183a(r15, r16, r17, r18, r19)
            r10.mo3206a(r14)
            r15 = 0
            goto L_0x01d2
        L_0x01c7:
            r24 = r6
            r27 = r11
            r6 = r20
            r0 = r22
            r11 = 2
            r20 = 4
        L_0x01d2:
            if (r15 == 0) goto L_0x01e7
            if (r0 == r11) goto L_0x01e7
            if (r44 != 0) goto L_0x01e7
            int r12 = java.lang.Math.max(r13, r12)
            if (r2 <= 0) goto L_0x01e2
            int r12 = java.lang.Math.min(r2, r12)
        L_0x01e2:
            r14 = 6
            r10.mo3219c(r7, r9, r12, r14)
            r15 = 0
        L_0x01e7:
            if (r50 == 0) goto L_0x02f2
            if (r45 == 0) goto L_0x01ed
            goto L_0x02f2
        L_0x01ed:
            r0 = 5
            if (r8 != 0) goto L_0x0204
            if (r23 != 0) goto L_0x0204
            if (r21 != 0) goto L_0x0204
            if (r32 == 0) goto L_0x01fd
            r4 = 0
            r12 = r34
            r10.mo3211a(r12, r7, r4, r0)
            goto L_0x01ff
        L_0x01fd:
            r12 = r34
        L_0x01ff:
            r2 = r7
            r0 = 0
            r1 = 6
            goto L_0x02ec
        L_0x0204:
            r4 = 0
            r5 = 4
            r12 = r34
            if (r8 == 0) goto L_0x0212
            if (r23 != 0) goto L_0x0212
            if (r32 == 0) goto L_0x01ff
            r10.mo3211a(r12, r7, r4, r0)
            goto L_0x01ff
        L_0x0212:
            if (r8 != 0) goto L_0x0227
            if (r23 == 0) goto L_0x0227
            int r1 = r38.mo3046e()
            int r1 = -r1
            r2 = 6
            r10.mo3219c(r7, r6, r1, r2)
            if (r32 == 0) goto L_0x01ff
            r14 = r33
            r10.mo3211a(r9, r14, r4, r0)
            goto L_0x01ff
        L_0x0227:
            r11 = 3
            r14 = r33
            if (r8 == 0) goto L_0x01ff
            if (r23 == 0) goto L_0x01ff
            if (r15 == 0) goto L_0x0291
            if (r32 == 0) goto L_0x0238
            if (r1 != 0) goto L_0x0238
            r1 = 6
            r10.mo3211a(r7, r9, r4, r1)
        L_0x0238:
            if (r27 != 0) goto L_0x0260
            if (r2 > 0) goto L_0x0242
            if (r13 <= 0) goto L_0x023f
            goto L_0x0242
        L_0x023f:
            r1 = 0
            r5 = 6
            goto L_0x0243
        L_0x0242:
            r1 = 1
        L_0x0243:
            int r3 = r37.mo3046e()
            r8 = r24
            r10.mo3219c(r9, r8, r3, r5)
            int r3 = r38.mo3046e()
            int r3 = -r3
            r10.mo3219c(r7, r6, r3, r5)
            if (r2 > 0) goto L_0x025b
            if (r13 <= 0) goto L_0x0259
            goto L_0x025b
        L_0x0259:
            r13 = 0
            goto L_0x025c
        L_0x025b:
            r13 = 1
        L_0x025c:
            r15 = r1
            r11 = r30
            goto L_0x02a8
        L_0x0260:
            r8 = r24
            r1 = r27
            r13 = 1
            if (r1 != r13) goto L_0x026c
            r0 = 6
            r11 = r30
        L_0x026a:
            r15 = 1
            goto L_0x02a8
        L_0x026c:
            if (r1 != r11) goto L_0x028d
            if (r44 != 0) goto L_0x027b
            r11 = r30
            int r1 = r11.f2284p
            r3 = -1
            if (r1 == r3) goto L_0x027d
            if (r2 > 0) goto L_0x027d
            r5 = 6
            goto L_0x027d
        L_0x027b:
            r11 = r30
        L_0x027d:
            int r1 = r37.mo3046e()
            r10.mo3219c(r9, r8, r1, r5)
            int r1 = r38.mo3046e()
            int r1 = -r1
            r10.mo3219c(r7, r6, r1, r5)
            goto L_0x026a
        L_0x028d:
            r11 = r30
            r13 = 0
            goto L_0x02a7
        L_0x0291:
            r8 = r24
            r11 = r30
            r13 = 1
            if (r32 == 0) goto L_0x02a7
            int r1 = r37.mo3046e()
            r10.mo3211a(r9, r8, r1, r0)
            int r1 = r38.mo3046e()
            int r1 = -r1
            r10.mo3216b(r7, r6, r1, r0)
        L_0x02a7:
            r15 = 0
        L_0x02a8:
            if (r13 == 0) goto L_0x02c4
            int r4 = r37.mo3046e()
            int r13 = r38.mo3046e()
            r1 = r31
            r2 = r9
            r3 = r8
            r5 = r43
            r28 = r6
            r29 = r7
            r11 = r8
            r8 = r13
            r13 = r9
            r9 = r0
            r1.mo3210a(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x02ca
        L_0x02c4:
            r28 = r6
            r29 = r7
            r11 = r8
            r13 = r9
        L_0x02ca:
            if (r15 == 0) goto L_0x02e1
            int r0 = r37.mo3046e()
            r1 = 6
            r10.mo3211a(r13, r11, r0, r1)
            int r0 = r38.mo3046e()
            int r0 = -r0
            r3 = r28
            r2 = r29
            r10.mo3216b(r2, r3, r0, r1)
            goto L_0x02e4
        L_0x02e1:
            r2 = r29
            r1 = 6
        L_0x02e4:
            if (r32 == 0) goto L_0x02eb
            r0 = 0
            r10.mo3211a(r13, r14, r0, r1)
            goto L_0x02ec
        L_0x02eb:
            r0 = 0
        L_0x02ec:
            if (r32 == 0) goto L_0x02f1
            r10.mo3211a(r12, r2, r0, r1)
        L_0x02f1:
            return
        L_0x02f2:
            r3 = r0
            r2 = r7
            r13 = r9
            r0 = 0
            r1 = 6
            r12 = r34
            r14 = r33
            if (r3 >= r11) goto L_0x0305
            if (r32 == 0) goto L_0x0305
            r10.mo3211a(r13, r14, r0, r1)
            r10.mo3211a(r12, r2, r0, r1)
        L_0x0305:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p060b.p061a.C0766f.m2748a(androidx.constraintlayout.b.e, boolean, androidx.constraintlayout.b.h, androidx.constraintlayout.b.h, androidx.constraintlayout.b.a.f$a, boolean, androidx.constraintlayout.b.a.e, androidx.constraintlayout.b.a.e, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }

    /* renamed from: c */
    public void mo3086c(C0786e eVar) {
        int b = eVar.mo3214b((Object) this.f2287s);
        int b2 = eVar.mo3214b((Object) this.f2288t);
        int b3 = eVar.mo3214b((Object) this.f2289u);
        int b4 = eVar.mo3214b((Object) this.f2290v);
        int i = b4 - b2;
        if (b3 - b < 0 || i < 0 || b == Integer.MIN_VALUE || b == Integer.MAX_VALUE || b2 == Integer.MIN_VALUE || b2 == Integer.MAX_VALUE || b3 == Integer.MIN_VALUE || b3 == Integer.MAX_VALUE || b4 == Integer.MIN_VALUE || b4 == Integer.MAX_VALUE) {
            b4 = 0;
            b = 0;
            b2 = 0;
            b3 = 0;
        }
        mo3068a(b, b2, b3, b4);
    }
}
