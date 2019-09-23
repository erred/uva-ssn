package androidx.constraintlayout.p060b;

import androidx.constraintlayout.p060b.C0792h.C0793a;
import androidx.constraintlayout.p060b.p061a.C0761e;
import androidx.constraintlayout.p060b.p061a.C0761e.C0765c;
import androidx.constraintlayout.p060b.p061a.C0766f;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: androidx.constraintlayout.b.e */
/* compiled from: LinearSystem */
public class C0786e {

    /* renamed from: g */
    public static C0788f f2380g = null;

    /* renamed from: h */
    private static int f2381h = 1000;

    /* renamed from: a */
    int f2382a;

    /* renamed from: b */
    C0783b[] f2383b;

    /* renamed from: c */
    public boolean f2384c;

    /* renamed from: d */
    int f2385d;

    /* renamed from: e */
    int f2386e;

    /* renamed from: f */
    final C0784c f2387f;

    /* renamed from: i */
    private HashMap<String, C0792h> f2388i;

    /* renamed from: j */
    private C0787a f2389j;

    /* renamed from: k */
    private int f2390k;

    /* renamed from: l */
    private int f2391l;

    /* renamed from: m */
    private boolean[] f2392m;

    /* renamed from: n */
    private int f2393n;

    /* renamed from: o */
    private C0792h[] f2394o;

    /* renamed from: p */
    private int f2395p;

    /* renamed from: q */
    private C0783b[] f2396q;

    /* renamed from: r */
    private final C0787a f2397r;

    /* renamed from: androidx.constraintlayout.b.e$a */
    /* compiled from: LinearSystem */
    interface C0787a {
        /* renamed from: a */
        C0792h mo3184a(C0786e eVar, boolean[] zArr);

        /* renamed from: a */
        void mo3185a(C0787a aVar);

        /* renamed from: d */
        void mo3198d(C0792h hVar);

        /* renamed from: f */
        void mo3200f();

        /* renamed from: g */
        C0792h mo3201g();
    }

    public C0786e() {
        this.f2382a = 0;
        this.f2388i = null;
        this.f2390k = 32;
        this.f2391l = this.f2390k;
        this.f2383b = null;
        this.f2384c = false;
        this.f2392m = new boolean[this.f2390k];
        this.f2385d = 1;
        this.f2386e = 0;
        this.f2393n = this.f2390k;
        this.f2394o = new C0792h[f2381h];
        this.f2395p = 0;
        this.f2396q = new C0783b[this.f2390k];
        this.f2383b = new C0783b[this.f2390k];
        m2942i();
        this.f2387f = new C0784c();
        this.f2389j = new C0785d(this.f2387f);
        this.f2397r = new C0783b(this.f2387f);
    }

    /* renamed from: a */
    public static C0788f m2935a() {
        return f2380g;
    }

    /* renamed from: h */
    private void m2941h() {
        this.f2390k *= 2;
        this.f2383b = (C0783b[]) Arrays.copyOf(this.f2383b, this.f2390k);
        this.f2387f.f2379c = (C0792h[]) Arrays.copyOf(this.f2387f.f2379c, this.f2390k);
        this.f2392m = new boolean[this.f2390k];
        this.f2391l = this.f2390k;
        this.f2393n = this.f2390k;
        if (f2380g != null) {
            C0788f fVar = f2380g;
            fVar.f2405d++;
            f2380g.f2417p = Math.max(f2380g.f2417p, (long) this.f2390k);
            f2380g.f2401D = f2380g.f2417p;
        }
    }

    /* renamed from: i */
    private void m2942i() {
        for (int i = 0; i < this.f2383b.length; i++) {
            C0783b bVar = this.f2383b[i];
            if (bVar != null) {
                this.f2387f.f2377a.mo3227a(bVar);
            }
            this.f2383b[i] = null;
        }
    }

    /* renamed from: b */
    public void mo3215b() {
        for (C0792h hVar : this.f2387f.f2379c) {
            if (hVar != null) {
                hVar.mo3230b();
            }
        }
        this.f2387f.f2378b.mo3226a(this.f2394o, this.f2395p);
        this.f2395p = 0;
        Arrays.fill(this.f2387f.f2379c, null);
        if (this.f2388i != null) {
            this.f2388i.clear();
        }
        this.f2382a = 0;
        this.f2389j.mo3200f();
        this.f2385d = 1;
        for (int i = 0; i < this.f2386e; i++) {
            this.f2383b[i].f2374c = false;
        }
        m2942i();
        this.f2386e = 0;
    }

    /* renamed from: a */
    public C0792h mo3204a(Object obj) {
        C0792h hVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f2385d + 1 >= this.f2391l) {
            m2941h();
        }
        if (obj instanceof C0761e) {
            C0761e eVar = (C0761e) obj;
            hVar = eVar.mo3043b();
            if (hVar == null) {
                eVar.mo3039a(this.f2387f);
                hVar = eVar.mo3043b();
            }
            if (hVar.f2435a == -1 || hVar.f2435a > this.f2382a || this.f2387f.f2379c[hVar.f2435a] == null) {
                if (hVar.f2435a != -1) {
                    hVar.mo3230b();
                }
                this.f2382a++;
                this.f2385d++;
                hVar.f2435a = this.f2382a;
                hVar.f2440f = C0793a.UNRESTRICTED;
                this.f2387f.f2379c[this.f2382a] = hVar;
            }
        }
        return hVar;
    }

    /* renamed from: c */
    public C0783b mo3218c() {
        C0783b bVar = (C0783b) this.f2387f.f2377a.mo3225a();
        if (bVar == null) {
            bVar = new C0783b(this.f2387f);
        } else {
            bVar.mo3195c();
        }
        C0792h.m2976a();
        return bVar;
    }

    /* renamed from: d */
    public C0792h mo3220d() {
        if (f2380g != null) {
            C0788f fVar = f2380g;
            fVar.f2415n++;
        }
        if (this.f2385d + 1 >= this.f2391l) {
            m2941h();
        }
        C0792h a = m2936a(C0793a.SLACK, (String) null);
        this.f2382a++;
        this.f2385d++;
        a.f2435a = this.f2382a;
        this.f2387f.f2379c[this.f2382a] = a;
        return a;
    }

    /* renamed from: e */
    public C0792h mo3221e() {
        if (f2380g != null) {
            C0788f fVar = f2380g;
            fVar.f2416o++;
        }
        if (this.f2385d + 1 >= this.f2391l) {
            m2941h();
        }
        C0792h a = m2936a(C0793a.SLACK, (String) null);
        this.f2382a++;
        this.f2385d++;
        a.f2435a = this.f2382a;
        this.f2387f.f2379c[this.f2382a] = a;
        return a;
    }

    /* renamed from: b */
    private void m2938b(C0783b bVar) {
        bVar.mo3177a(this, 0);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3207a(C0783b bVar, int i, int i2) {
        bVar.mo3194c(mo3203a(i2, (String) null), i);
    }

    /* renamed from: a */
    public C0792h mo3203a(int i, String str) {
        if (f2380g != null) {
            C0788f fVar = f2380g;
            fVar.f2414m++;
        }
        if (this.f2385d + 1 >= this.f2391l) {
            m2941h();
        }
        C0792h a = m2936a(C0793a.ERROR, str);
        this.f2382a++;
        this.f2385d++;
        a.f2435a = this.f2382a;
        a.f2437c = i;
        this.f2387f.f2379c[this.f2382a] = a;
        this.f2389j.mo3198d(a);
        return a;
    }

    /* renamed from: a */
    private C0792h m2936a(C0793a aVar, String str) {
        C0792h hVar = (C0792h) this.f2387f.f2378b.mo3225a();
        if (hVar == null) {
            hVar = new C0792h(aVar, str);
            hVar.mo3229a(aVar, str);
        } else {
            hVar.mo3230b();
            hVar.mo3229a(aVar, str);
        }
        if (this.f2395p >= f2381h) {
            f2381h *= 2;
            this.f2394o = (C0792h[]) Arrays.copyOf(this.f2394o, f2381h);
        }
        C0792h[] hVarArr = this.f2394o;
        int i = this.f2395p;
        this.f2395p = i + 1;
        hVarArr[i] = hVar;
        return hVar;
    }

    /* renamed from: b */
    public int mo3214b(Object obj) {
        C0792h b = ((C0761e) obj).mo3043b();
        if (b != null) {
            return (int) (b.f2438d + 0.5f);
        }
        return 0;
    }

    /* renamed from: f */
    public void mo3222f() throws Exception {
        if (f2380g != null) {
            C0788f fVar = f2380g;
            fVar.f2406e++;
        }
        if (this.f2384c) {
            if (f2380g != null) {
                C0788f fVar2 = f2380g;
                fVar2.f2419r++;
            }
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.f2386e) {
                    z = true;
                    break;
                } else if (!this.f2383b[i].f2376e) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                mo3208a(this.f2389j);
                return;
            }
            if (f2380g != null) {
                C0788f fVar3 = f2380g;
                fVar3.f2418q++;
            }
            m2943j();
            return;
        }
        mo3208a(this.f2389j);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3208a(C0787a aVar) throws Exception {
        if (f2380g != null) {
            C0788f fVar = f2380g;
            fVar.f2421t++;
            f2380g.f2422u = Math.max(f2380g.f2422u, (long) this.f2385d);
            f2380g.f2423v = Math.max(f2380g.f2423v, (long) this.f2386e);
        }
        m2939c((C0783b) aVar);
        m2937b(aVar);
        m2933a(aVar, false);
        m2943j();
    }

    /* renamed from: c */
    private final void m2939c(C0783b bVar) {
        if (this.f2386e > 0) {
            bVar.f2375d.mo3021a(bVar, this.f2383b);
            if (bVar.f2375d.f2166a == 0) {
                bVar.f2376e = true;
            }
        }
    }

    /* renamed from: a */
    public void mo3206a(C0783b bVar) {
        if (bVar != null) {
            if (f2380g != null) {
                C0788f fVar = f2380g;
                fVar.f2407f++;
                if (bVar.f2376e) {
                    C0788f fVar2 = f2380g;
                    fVar2.f2408g++;
                }
            }
            if (this.f2386e + 1 >= this.f2393n || this.f2385d + 1 >= this.f2391l) {
                m2941h();
            }
            boolean z = false;
            if (!bVar.f2376e) {
                m2939c(bVar);
                if (!bVar.mo3199e()) {
                    bVar.mo3197d();
                    if (bVar.mo3187a(this)) {
                        C0792h e = mo3221e();
                        bVar.f2372a = e;
                        m2940d(bVar);
                        this.f2397r.mo3185a(bVar);
                        m2933a(this.f2397r, true);
                        if (e.f2436b == -1) {
                            if (bVar.f2372a == e) {
                                C0792h b = bVar.mo3192b(e);
                                if (b != null) {
                                    if (f2380g != null) {
                                        C0788f fVar3 = f2380g;
                                        fVar3.f2411j++;
                                    }
                                    bVar.mo3196c(b);
                                }
                            }
                            if (!bVar.f2376e) {
                                bVar.f2372a.mo3232c(bVar);
                            }
                            this.f2386e--;
                        }
                        z = true;
                    }
                    if (!bVar.mo3186a()) {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!z) {
                m2940d(bVar);
            }
        }
    }

    /* renamed from: d */
    private final void m2940d(C0783b bVar) {
        if (this.f2383b[this.f2386e] != null) {
            this.f2387f.f2377a.mo3227a(this.f2383b[this.f2386e]);
        }
        this.f2383b[this.f2386e] = bVar;
        bVar.f2372a.f2436b = this.f2386e;
        this.f2386e++;
        bVar.f2372a.mo3232c(bVar);
    }

    /* renamed from: a */
    private final int m2933a(C0787a aVar, boolean z) {
        if (f2380g != null) {
            C0788f fVar = f2380g;
            fVar.f2409h++;
        }
        for (int i = 0; i < this.f2385d; i++) {
            this.f2392m[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            if (f2380g != null) {
                C0788f fVar2 = f2380g;
                fVar2.f2410i++;
            }
            i2++;
            if (i2 >= this.f2385d * 2) {
                return i2;
            }
            if (aVar.mo3201g() != null) {
                this.f2392m[aVar.mo3201g().f2435a] = true;
            }
            C0792h a = aVar.mo3184a(this, this.f2392m);
            if (a != null) {
                if (this.f2392m[a.f2435a]) {
                    return i2;
                }
                this.f2392m[a.f2435a] = true;
            }
            if (a != null) {
                int i3 = -1;
                float f = Float.MAX_VALUE;
                for (int i4 = 0; i4 < this.f2386e; i4++) {
                    C0783b bVar = this.f2383b[i4];
                    if (bVar.f2372a.f2440f != C0793a.UNRESTRICTED && !bVar.f2376e && bVar.mo3188a(a)) {
                        float b = bVar.f2375d.mo3026b(a);
                        if (b < BitmapDescriptorFactory.HUE_RED) {
                            float f2 = (-bVar.f2373b) / b;
                            if (f2 < f) {
                                i3 = i4;
                                f = f2;
                            }
                        }
                    }
                }
                if (i3 > -1) {
                    C0783b bVar2 = this.f2383b[i3];
                    bVar2.f2372a.f2436b = -1;
                    if (f2380g != null) {
                        C0788f fVar3 = f2380g;
                        fVar3.f2411j++;
                    }
                    bVar2.mo3196c(a);
                    bVar2.f2372a.f2436b = i3;
                    bVar2.f2372a.mo3232c(bVar2);
                }
            }
            z2 = true;
        }
        return i2;
    }

    /* renamed from: b */
    private int m2937b(C0787a aVar) throws Exception {
        float f;
        boolean z;
        int i = 0;
        while (true) {
            int i2 = this.f2386e;
            f = BitmapDescriptorFactory.HUE_RED;
            if (i >= i2) {
                z = false;
                break;
            } else if (this.f2383b[i].f2372a.f2440f != C0793a.UNRESTRICTED && this.f2383b[i].f2373b < BitmapDescriptorFactory.HUE_RED) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            if (f2380g != null) {
                C0788f fVar = f2380g;
                fVar.f2412k++;
            }
            i3++;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            float f2 = Float.MAX_VALUE;
            int i7 = 0;
            while (i4 < this.f2386e) {
                C0783b bVar = this.f2383b[i4];
                if (bVar.f2372a.f2440f != C0793a.UNRESTRICTED && !bVar.f2376e && bVar.f2373b < f) {
                    int i8 = 1;
                    while (i8 < this.f2385d) {
                        C0792h hVar = this.f2387f.f2379c[i8];
                        float b = bVar.f2375d.mo3026b(hVar);
                        if (b > f) {
                            int i9 = i7;
                            float f3 = f2;
                            int i10 = i6;
                            int i11 = i5;
                            for (int i12 = 0; i12 < 7; i12++) {
                                float f4 = hVar.f2439e[i12] / b;
                                if ((f4 < f3 && i12 == i9) || i12 > i9) {
                                    i10 = i8;
                                    i11 = i4;
                                    f3 = f4;
                                    i9 = i12;
                                }
                            }
                            i5 = i11;
                            i6 = i10;
                            f2 = f3;
                            i7 = i9;
                        }
                        i8++;
                        f = BitmapDescriptorFactory.HUE_RED;
                    }
                }
                i4++;
                f = BitmapDescriptorFactory.HUE_RED;
            }
            if (i5 != -1) {
                C0783b bVar2 = this.f2383b[i5];
                bVar2.f2372a.f2436b = -1;
                if (f2380g != null) {
                    C0788f fVar2 = f2380g;
                    fVar2.f2411j++;
                }
                bVar2.mo3196c(this.f2387f.f2379c[i6]);
                bVar2.f2372a.f2436b = i5;
                bVar2.f2372a.mo3232c(bVar2);
            } else {
                z2 = true;
            }
            if (i3 > this.f2385d / 2) {
                z2 = true;
            }
            f = BitmapDescriptorFactory.HUE_RED;
        }
        return i3;
    }

    /* renamed from: j */
    private void m2943j() {
        for (int i = 0; i < this.f2386e; i++) {
            C0783b bVar = this.f2383b[i];
            bVar.f2372a.f2438d = bVar.f2373b;
        }
    }

    /* renamed from: g */
    public C0784c mo3223g() {
        return this.f2387f;
    }

    /* renamed from: a */
    public void mo3211a(C0792h hVar, C0792h hVar2, int i, int i2) {
        C0783b c = mo3218c();
        C0792h d = mo3220d();
        d.f2437c = 0;
        c.mo3182a(hVar, hVar2, d, i);
        if (i2 != 6) {
            mo3207a(c, (int) (c.f2375d.mo3026b(d) * -1.0f), i2);
        }
        mo3206a(c);
    }

    /* renamed from: a */
    public void mo3213a(C0792h hVar, C0792h hVar2, boolean z) {
        C0783b c = mo3218c();
        C0792h d = mo3220d();
        d.f2437c = 0;
        c.mo3182a(hVar, hVar2, d, 0);
        if (z) {
            mo3207a(c, (int) (c.f2375d.mo3026b(d) * -1.0f), 1);
        }
        mo3206a(c);
    }

    /* renamed from: b */
    public void mo3216b(C0792h hVar, C0792h hVar2, int i, int i2) {
        C0783b c = mo3218c();
        C0792h d = mo3220d();
        d.f2437c = 0;
        c.mo3190b(hVar, hVar2, d, i);
        if (i2 != 6) {
            mo3207a(c, (int) (c.f2375d.mo3026b(d) * -1.0f), i2);
        }
        mo3206a(c);
    }

    /* renamed from: b */
    public void mo3217b(C0792h hVar, C0792h hVar2, boolean z) {
        C0783b c = mo3218c();
        C0792h d = mo3220d();
        d.f2437c = 0;
        c.mo3190b(hVar, hVar2, d, 0);
        if (z) {
            mo3207a(c, (int) (c.f2375d.mo3026b(d) * -1.0f), 1);
        }
        mo3206a(c);
    }

    /* renamed from: a */
    public void mo3210a(C0792h hVar, C0792h hVar2, int i, float f, C0792h hVar3, C0792h hVar4, int i2, int i3) {
        int i4 = i3;
        C0783b c = mo3218c();
        c.mo3180a(hVar, hVar2, i, f, hVar3, hVar4, i2);
        if (i4 != 6) {
            c.mo3177a(this, i4);
        }
        mo3206a(c);
    }

    /* renamed from: a */
    public void mo3212a(C0792h hVar, C0792h hVar2, C0792h hVar3, C0792h hVar4, float f, int i) {
        C0783b c = mo3218c();
        c.mo3183a(hVar, hVar2, hVar3, hVar4, f);
        if (i != 6) {
            c.mo3177a(this, i);
        }
        mo3206a(c);
    }

    /* renamed from: c */
    public C0783b mo3219c(C0792h hVar, C0792h hVar2, int i, int i2) {
        C0783b c = mo3218c();
        c.mo3179a(hVar, hVar2, i);
        if (i2 != 6) {
            c.mo3177a(this, i2);
        }
        mo3206a(c);
        return c;
    }

    /* renamed from: a */
    public void mo3209a(C0792h hVar, int i) {
        int i2 = hVar.f2436b;
        if (hVar.f2436b != -1) {
            C0783b bVar = this.f2383b[i2];
            if (bVar.f2376e) {
                bVar.f2373b = (float) i;
            } else if (bVar.f2375d.f2166a == 0) {
                bVar.f2376e = true;
                bVar.f2373b = (float) i;
            } else {
                C0783b c = mo3218c();
                c.mo3189b(hVar, i);
                mo3206a(c);
            }
        } else {
            C0783b c2 = mo3218c();
            c2.mo3178a(hVar, i);
            mo3206a(c2);
        }
    }

    /* renamed from: a */
    public static C0783b m2934a(C0786e eVar, C0792h hVar, C0792h hVar2, C0792h hVar3, float f, boolean z) {
        C0783b c = eVar.mo3218c();
        if (z) {
            eVar.m2938b(c);
        }
        return c.mo3181a(hVar, hVar2, hVar3, f);
    }

    /* renamed from: a */
    public void mo3205a(C0766f fVar, C0766f fVar2, float f, int i) {
        C0766f fVar3 = fVar;
        C0766f fVar4 = fVar2;
        C0792h a = mo3204a((Object) fVar3.mo3063a(C0765c.LEFT));
        C0792h a2 = mo3204a((Object) fVar3.mo3063a(C0765c.TOP));
        C0792h a3 = mo3204a((Object) fVar3.mo3063a(C0765c.RIGHT));
        C0792h a4 = mo3204a((Object) fVar3.mo3063a(C0765c.BOTTOM));
        C0792h a5 = mo3204a((Object) fVar4.mo3063a(C0765c.LEFT));
        C0792h a6 = mo3204a((Object) fVar4.mo3063a(C0765c.TOP));
        C0792h a7 = mo3204a((Object) fVar4.mo3063a(C0765c.RIGHT));
        C0792h a8 = mo3204a((Object) fVar4.mo3063a(C0765c.BOTTOM));
        C0783b c = mo3218c();
        double d = (double) f;
        C0792h hVar = a3;
        double d2 = (double) i;
        C0792h hVar2 = a7;
        c.mo3191b(a2, a4, a6, a8, (float) (Math.sin(d) * d2));
        mo3206a(c);
        C0783b c2 = mo3218c();
        c2.mo3191b(a, hVar, a5, hVar2, (float) (Math.cos(d) * d2));
        mo3206a(c2);
    }
}
