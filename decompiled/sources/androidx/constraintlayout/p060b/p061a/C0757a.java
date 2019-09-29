package androidx.constraintlayout.p060b.p061a;

import androidx.constraintlayout.p060b.p061a.C0761e.C0765c;
import androidx.constraintlayout.p060b.p061a.C0766f.C0768a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: androidx.constraintlayout.b.a.a */
/* compiled from: Analyzer */
public class C0757a {
    /* renamed from: a */
    public static void m2716a(C0769g gVar) {
        if ((gVar.mo3034b() & 32) != 32) {
            m2720b(gVar);
            return;
        }
        gVar.f2319au = true;
        gVar.f2314ap = false;
        gVar.f2315aq = false;
        gVar.f2316ar = false;
        ArrayList<C0766f> arrayList = gVar.f2371aw;
        List<C0770h> list = gVar.f2313ao;
        boolean z = gVar.mo3059G() == C0768a.WRAP_CONTENT;
        boolean z2 = gVar.mo3060H() == C0768a.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (C0766f fVar : arrayList) {
            fVar.f2286r = null;
            fVar.f2288t.mo3038a().f2359h.clear();
            fVar.f2290v.mo3038a().f2359h.clear();
            fVar.f2287s.mo3038a().f2359h.clear();
            fVar.f2289u.mo3038a().f2359h.clear();
            fVar.f2291w.mo3038a().f2359h.clear();
            fVar.f2294z.mo3038a().f2359h.clear();
        }
        for (C0766f fVar2 : arrayList) {
            if (fVar2.f2286r == null && !m2719a(fVar2, list, z3)) {
                m2720b(gVar);
                gVar.f2319au = false;
                return;
            }
        }
        if (gVar.f2319au) {
            int i = 0;
            int i2 = 0;
            for (C0770h hVar : list) {
                if (z || !z3) {
                    i = Math.max(i, m2713a(hVar, 0));
                }
                if (z2 || !z3) {
                    i2 = Math.max(i2, m2713a(hVar, 1));
                }
            }
            if (z) {
                gVar.mo3070a(C0768a.FIXED);
                gVar.mo3098h(i);
                gVar.f2314ap = true;
                gVar.f2315aq = true;
                gVar.f2317as = i;
            }
            if (z2) {
                gVar.mo3080b(C0768a.FIXED);
                gVar.mo3100i(i2);
                gVar.f2314ap = true;
                gVar.f2316ar = true;
                gVar.f2318at = i2;
            }
            if ((!z2 || !z) && z3) {
                gVar.f2319au = false;
            } else {
                gVar.f2319au = true;
                m2717a(list, 0, i);
                m2717a(list, 1, i2);
            }
        }
    }

    /* renamed from: a */
    private static boolean m2719a(C0766f fVar, List<C0770h> list, boolean z) {
        C0770h hVar = new C0770h(new ArrayList());
        list.add(hVar);
        return m2718a(fVar, hVar, list, z);
    }

    /* renamed from: a */
    private static boolean m2718a(C0766f fVar, C0770h hVar, List<C0770h> list, boolean z) {
        if (fVar == null) {
            return true;
        }
        C0769g gVar = (C0769g) fVar.mo3103k();
        if (fVar.f2286r == null) {
            hVar.f2324a.add(fVar);
            fVar.f2286r = hVar;
            if (fVar.f2287s.f2199c == null && fVar.f2289u.f2199c == null && fVar.f2288t.f2199c == null && fVar.f2290v.f2199c == null && fVar.f2291w.f2199c == null && fVar.f2294z.f2199c == null) {
                gVar.f2319au = false;
                if (z) {
                    return false;
                }
            }
            if (!(fVar.f2288t.f2199c == null || fVar.f2290v.f2199c == null)) {
                gVar.f2319au = false;
                if (z) {
                    return false;
                }
            }
            if (!(fVar.f2287s.f2199c == null || fVar.f2289u.f2199c == null)) {
                gVar.f2319au = false;
                if (z) {
                    return false;
                }
            }
            if (!((fVar.mo3059G() == C0768a.MATCH_CONSTRAINT) ^ (fVar.mo3060H() == C0768a.MATCH_CONSTRAINT)) || fVar.f2232G == BitmapDescriptorFactory.HUE_RED) {
                if (fVar.mo3059G() == C0768a.MATCH_CONSTRAINT || fVar.mo3060H() == C0768a.MATCH_CONSTRAINT) {
                    gVar.f2319au = false;
                    if (z) {
                        return false;
                    }
                }
            } else if (fVar.mo3059G() == C0768a.MATCH_CONSTRAINT) {
                fVar.mo3098h((int) (((float) fVar.mo3116r()) / fVar.f2232G));
            } else if (fVar.mo3060H() == C0768a.MATCH_CONSTRAINT) {
                fVar.mo3100i((int) (((float) fVar.mo3113p()) / fVar.f2232G));
            }
            if ((fVar.f2287s.f2199c == null && fVar.f2289u.f2199c == null) || ((fVar.f2287s.f2199c != null && fVar.f2287s.f2199c.f2197a == fVar.f2229D) || (fVar.f2289u.f2199c != null && fVar.f2289u.f2199c.f2197a == fVar.f2229D))) {
                hVar.f2328e.add(fVar);
            }
            if ((fVar.f2288t.f2199c == null && fVar.f2290v.f2199c == null && fVar.f2291w.f2199c == null) || ((fVar.f2288t.f2199c != null && fVar.f2288t.f2199c.f2197a == fVar.f2229D) || (fVar.f2290v.f2199c != null && fVar.f2290v.f2199c.f2197a == fVar.f2229D))) {
                hVar.f2329f.add(fVar);
            }
            if (fVar instanceof C0774k) {
                gVar.f2319au = false;
                if (z) {
                    return false;
                }
                C0774k kVar = (C0774k) fVar;
                for (int i = 0; i < kVar.f2343ag; i++) {
                    if (!m2718a(kVar.f2342af[i], hVar, list, z)) {
                        return false;
                    }
                }
            }
            for (C0761e eVar : fVar.f2226A) {
                if (!(eVar.f2199c == null || eVar.f2199c.f2197a == fVar.mo3103k())) {
                    if (eVar.f2198b == C0765c.CENTER) {
                        gVar.f2319au = false;
                        if (z) {
                            return false;
                        }
                    } else {
                        m2714a(eVar);
                    }
                    if (!m2718a(eVar.f2199c.f2197a, hVar, list, z)) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (fVar.f2286r != hVar) {
            hVar.f2324a.addAll(fVar.f2286r.f2324a);
            hVar.f2328e.addAll(fVar.f2286r.f2328e);
            hVar.f2329f.addAll(fVar.f2286r.f2329f);
            list.remove(fVar.f2286r);
            for (C0766f fVar2 : fVar.f2286r.f2324a) {
                fVar2.f2286r = hVar;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static int m2713a(C0770h hVar, int i) {
        Iterator it = hVar.mo3141a(i).iterator();
        int i2 = 0;
        while (it.hasNext()) {
            C0766f fVar = (C0766f) it.next();
            boolean z = true;
            if (fVar.f2226A[(i * 2) + 1].f2199c != null) {
                z = false;
            }
            i2 = Math.max(i2, m2712a(fVar, i, z, 0));
        }
        hVar.f2327d[i] = i2;
        return i2;
    }

    /* renamed from: a */
    private static int m2712a(C0766f fVar, int i, boolean z, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int p;
        int i9;
        int i10;
        int i11;
        C0766f fVar2 = fVar;
        int i12 = i;
        boolean z2 = z;
        boolean z3 = fVar2.f2291w.f2199c != null && i12 == 1;
        if (z2) {
            i6 = fVar.mo3054B();
            i5 = fVar.mo3116r() - fVar.mo3054B();
            i4 = i12 * 2;
            i3 = i4 + 1;
        } else {
            i6 = fVar.mo3116r() - fVar.mo3054B();
            i5 = fVar.mo3054B();
            i3 = i12 * 2;
            i4 = i3 + 1;
        }
        if (fVar2.f2226A[i3].f2199c == null || fVar2.f2226A[i4].f2199c != null) {
            i7 = i3;
            i8 = 1;
        } else {
            i7 = i4;
            i4 = i3;
            i8 = -1;
        }
        int i13 = z3 ? i2 - i6 : i2;
        int e = fVar2.f2226A[i4].mo3046e() * i8;
        int i14 = e + i13;
        int p2 = (i12 == 0 ? fVar.mo3113p() : fVar.mo3116r()) * i8;
        Iterator it = fVar2.f2226A[i4].mo3038a().f2359h.iterator();
        int i15 = 0;
        while (it.hasNext()) {
            i15 = Math.max(i15, m2712a(((C0777n) ((C0779p) it.next())).f2345a.f2197a, i12, z2, i14));
        }
        Iterator it2 = fVar2.f2226A[i7].mo3038a().f2359h.iterator();
        int i16 = 0;
        while (it2.hasNext()) {
            Iterator it3 = it2;
            i16 = Math.max(i16, m2712a(((C0777n) ((C0779p) it2.next())).f2345a.f2197a, i12, z2, p2 + i14));
            it2 = it3;
        }
        if (z3) {
            i15 -= i6;
            p = i16 + i5;
        } else {
            p = i16 + ((i12 == 0 ? fVar.mo3113p() : fVar.mo3116r()) * i8);
        }
        int i17 = 1;
        if (i12 == 1) {
            Iterator it4 = fVar2.f2291w.mo3038a().f2359h.iterator();
            int i18 = 0;
            while (it4.hasNext()) {
                Iterator it5 = it4;
                C0777n nVar = (C0777n) ((C0779p) it4.next());
                if (i8 == i17) {
                    i18 = Math.max(i18, m2712a(nVar.f2345a.f2197a, i12, z2, i6 + i14));
                    i11 = p2;
                } else {
                    i11 = p2;
                    i18 = Math.max(i18, m2712a(nVar.f2345a.f2197a, i12, z2, (i5 * i8) + i14));
                }
                it4 = it5;
                p2 = i11;
                i17 = 1;
            }
            i9 = p2;
            i10 = i18;
            if (fVar2.f2291w.mo3038a().f2359h.size() > 0 && !z3) {
                i10 = i8 == 1 ? i10 + i6 : i10 - i5;
            }
        } else {
            i9 = p2;
            i10 = 0;
        }
        int max = e + Math.max(i15, Math.max(p, i10));
        int e2 = i13 + (fVar2.f2226A[i4].mo3046e() * i8);
        int i19 = e2 + i9;
        if (i8 == -1) {
            int i20 = e2;
            e2 = i19;
            i19 = i20;
        }
        if (z2) {
            fVar2.mo3066a(e2, i19, i12);
        } else if (i12 == 0) {
            fVar2.f2286r.f2330g.add(fVar2);
            fVar2.f2236K = e2;
        } else if (i12 == 1) {
            fVar2.f2286r.f2331h.add(fVar2);
            fVar2.f2237L = e2;
        }
        return max;
    }

    /* renamed from: a */
    private static void m2714a(C0761e eVar) {
        C0777n a = eVar.mo3038a();
        if (eVar.f2199c != null && eVar.f2199c.f2199c != eVar) {
            eVar.f2199c.mo3038a().mo3164a(a);
        }
    }

    /* renamed from: b */
    private static void m2720b(C0769g gVar) {
        gVar.f2313ao.clear();
        gVar.f2313ao.add(0, new C0770h(gVar.f2371aw));
    }

    /* renamed from: a */
    public static void m2717a(List<C0770h> list, int i, int i2) {
        for (C0770h b : list) {
            Iterator it = b.mo3142b(i).iterator();
            while (it.hasNext()) {
                m2715a((C0766f) it.next(), i, i2);
            }
        }
    }

    /* renamed from: a */
    private static void m2715a(C0766f fVar, int i, int i2) {
        if (i == 0) {
            int p = i2 - (fVar.f2236K + fVar.mo3113p());
            fVar.mo3085c(p, fVar.mo3113p() + p);
        } else if (i == 1) {
            int r = i2 - (fVar.f2237L + fVar.mo3116r());
            fVar.mo3090d(r, fVar.mo3116r() + r);
        }
    }
}
