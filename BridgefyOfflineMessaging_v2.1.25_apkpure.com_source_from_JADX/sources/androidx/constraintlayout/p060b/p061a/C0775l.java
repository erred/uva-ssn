package androidx.constraintlayout.p060b.p061a;

import androidx.constraintlayout.p060b.C0786e;
import androidx.constraintlayout.p060b.p061a.C0766f.C0768a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.constraintlayout.b.a.l */
/* compiled from: Optimizer */
public class C0775l {

    /* renamed from: a */
    static boolean[] f2344a = new boolean[3];

    /* renamed from: a */
    static void m2868a(C0769g gVar, C0786e eVar, C0766f fVar) {
        if (gVar.f2228C[0] != C0768a.WRAP_CONTENT && fVar.f2228C[0] == C0768a.MATCH_PARENT) {
            int i = fVar.f2287s.f2200d;
            int p = gVar.mo3113p() - fVar.f2289u.f2200d;
            fVar.f2287s.f2202f = eVar.mo3204a((Object) fVar.f2287s);
            fVar.f2289u.f2202f = eVar.mo3204a((Object) fVar.f2289u);
            eVar.mo3209a(fVar.f2287s.f2202f, i);
            eVar.mo3209a(fVar.f2289u.f2202f, p);
            fVar.f2251a = 2;
            fVar.mo3085c(i, p);
        }
        if (gVar.f2228C[1] != C0768a.WRAP_CONTENT && fVar.f2228C[1] == C0768a.MATCH_PARENT) {
            int i2 = fVar.f2288t.f2200d;
            int r = gVar.mo3116r() - fVar.f2290v.f2200d;
            fVar.f2288t.f2202f = eVar.mo3204a((Object) fVar.f2288t);
            fVar.f2290v.f2202f = eVar.mo3204a((Object) fVar.f2290v);
            eVar.mo3209a(fVar.f2288t.f2202f, i2);
            eVar.mo3209a(fVar.f2290v.f2202f, r);
            if (fVar.f2240O > 0 || fVar.mo3105l() == 8) {
                fVar.f2291w.f2202f = eVar.mo3204a((Object) fVar.f2291w);
                eVar.mo3209a(fVar.f2291w.f2202f, fVar.f2240O + i2);
            }
            fVar.f2270b = 2;
            fVar.mo3090d(i2, r);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x003e A[RETURN] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m2869a(androidx.constraintlayout.p060b.p061a.C0766f r4, int r5) {
        /*
            androidx.constraintlayout.b.a.f$a[] r0 = r4.f2228C
            r0 = r0[r5]
            androidx.constraintlayout.b.a.f$a r1 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.MATCH_CONSTRAINT
            r2 = 0
            if (r0 == r1) goto L_0x000a
            return r2
        L_0x000a:
            float r0 = r4.f2232G
            r1 = 0
            r3 = 1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0020
            androidx.constraintlayout.b.a.f$a[] r4 = r4.f2228C
            if (r5 != 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r3 = 0
        L_0x0018:
            r4 = r4[r3]
            androidx.constraintlayout.b.a.f$a r5 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.MATCH_CONSTRAINT
            if (r4 != r5) goto L_0x001f
            return r2
        L_0x001f:
            return r2
        L_0x0020:
            if (r5 != 0) goto L_0x0030
            int r5 = r4.f2273e
            if (r5 == 0) goto L_0x0027
            return r2
        L_0x0027:
            int r5 = r4.f2276h
            if (r5 != 0) goto L_0x002f
            int r4 = r4.f2277i
            if (r4 == 0) goto L_0x003e
        L_0x002f:
            return r2
        L_0x0030:
            int r5 = r4.f2274f
            if (r5 == 0) goto L_0x0035
            return r2
        L_0x0035:
            int r5 = r4.f2279k
            if (r5 != 0) goto L_0x003f
            int r4 = r4.f2280l
            if (r4 == 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            return r3
        L_0x003f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p060b.p061a.C0775l.m2869a(androidx.constraintlayout.b.a.f, int):boolean");
    }

    /* renamed from: a */
    static void m2867a(int i, C0766f fVar) {
        C0766f fVar2 = fVar;
        fVar.mo3097h();
        C0777n a = fVar2.f2287s.mo3038a();
        C0777n a2 = fVar2.f2288t.mo3038a();
        C0777n a3 = fVar2.f2289u.mo3038a();
        C0777n a4 = fVar2.f2290v.mo3038a();
        boolean z = (i & 8) == 8;
        boolean z2 = fVar2.f2228C[0] == C0768a.MATCH_CONSTRAINT && m2869a(fVar2, 0);
        if (!(a.f2351g == 4 || a3.f2351g == 4)) {
            if (fVar2.f2228C[0] == C0768a.FIXED || (z2 && fVar.mo3105l() == 8)) {
                if (fVar2.f2287s.f2199c == null && fVar2.f2289u.f2199c == null) {
                    a.mo3156b(1);
                    a3.mo3156b(1);
                    if (z) {
                        a3.mo3153a(a, 1, fVar.mo3099i());
                    } else {
                        a3.mo3152a(a, fVar.mo3113p());
                    }
                } else if (fVar2.f2287s.f2199c != null && fVar2.f2289u.f2199c == null) {
                    a.mo3156b(1);
                    a3.mo3156b(1);
                    if (z) {
                        a3.mo3153a(a, 1, fVar.mo3099i());
                    } else {
                        a3.mo3152a(a, fVar.mo3113p());
                    }
                } else if (fVar2.f2287s.f2199c == null && fVar2.f2289u.f2199c != null) {
                    a.mo3156b(1);
                    a3.mo3156b(1);
                    a.mo3152a(a3, -fVar.mo3113p());
                    if (z) {
                        a.mo3153a(a3, -1, fVar.mo3099i());
                    } else {
                        a.mo3152a(a3, -fVar.mo3113p());
                    }
                } else if (!(fVar2.f2287s.f2199c == null || fVar2.f2289u.f2199c == null)) {
                    a.mo3156b(2);
                    a3.mo3156b(2);
                    if (z) {
                        fVar.mo3099i().mo3164a(a);
                        fVar.mo3099i().mo3164a(a3);
                        a.mo3158b(a3, -1, fVar.mo3099i());
                        a3.mo3158b(a, 1, fVar.mo3099i());
                    } else {
                        a.mo3157b(a3, (float) (-fVar.mo3113p()));
                        a3.mo3157b(a, (float) fVar.mo3113p());
                    }
                }
            } else if (z2) {
                int p = fVar.mo3113p();
                a.mo3156b(1);
                a3.mo3156b(1);
                if (fVar2.f2287s.f2199c == null && fVar2.f2289u.f2199c == null) {
                    if (z) {
                        a3.mo3153a(a, 1, fVar.mo3099i());
                    } else {
                        a3.mo3152a(a, p);
                    }
                } else if (fVar2.f2287s.f2199c == null || fVar2.f2289u.f2199c != null) {
                    if (fVar2.f2287s.f2199c != null || fVar2.f2289u.f2199c == null) {
                        if (!(fVar2.f2287s.f2199c == null || fVar2.f2289u.f2199c == null)) {
                            if (z) {
                                fVar.mo3099i().mo3164a(a);
                                fVar.mo3099i().mo3164a(a3);
                            }
                            if (fVar2.f2232G == BitmapDescriptorFactory.HUE_RED) {
                                a.mo3156b(3);
                                a3.mo3156b(3);
                                a.mo3157b(a3, BitmapDescriptorFactory.HUE_RED);
                                a3.mo3157b(a, BitmapDescriptorFactory.HUE_RED);
                            } else {
                                a.mo3156b(2);
                                a3.mo3156b(2);
                                a.mo3157b(a3, (float) (-p));
                                a3.mo3157b(a, (float) p);
                                fVar2.mo3098h(p);
                            }
                        }
                    } else if (z) {
                        a.mo3153a(a3, -1, fVar.mo3099i());
                    } else {
                        a.mo3152a(a3, -p);
                    }
                } else if (z) {
                    a3.mo3153a(a, 1, fVar.mo3099i());
                } else {
                    a3.mo3152a(a, p);
                }
            }
        }
        boolean z3 = fVar2.f2228C[1] == C0768a.MATCH_CONSTRAINT && m2869a(fVar2, 1);
        if (a2.f2351g != 4 && a4.f2351g != 4) {
            if (fVar2.f2228C[1] == C0768a.FIXED || (z3 && fVar.mo3105l() == 8)) {
                if (fVar2.f2288t.f2199c == null && fVar2.f2290v.f2199c == null) {
                    a2.mo3156b(1);
                    a4.mo3156b(1);
                    if (z) {
                        a4.mo3153a(a2, 1, fVar.mo3101j());
                    } else {
                        a4.mo3152a(a2, fVar.mo3116r());
                    }
                    if (fVar2.f2291w.f2199c != null) {
                        fVar2.f2291w.mo3038a().mo3156b(1);
                        a2.mo3150a(1, fVar2.f2291w.mo3038a(), -fVar2.f2240O);
                    }
                } else if (fVar2.f2288t.f2199c != null && fVar2.f2290v.f2199c == null) {
                    a2.mo3156b(1);
                    a4.mo3156b(1);
                    if (z) {
                        a4.mo3153a(a2, 1, fVar.mo3101j());
                    } else {
                        a4.mo3152a(a2, fVar.mo3116r());
                    }
                    if (fVar2.f2240O > 0) {
                        fVar2.f2291w.mo3038a().mo3150a(1, a2, fVar2.f2240O);
                    }
                } else if (fVar2.f2288t.f2199c == null && fVar2.f2290v.f2199c != null) {
                    a2.mo3156b(1);
                    a4.mo3156b(1);
                    if (z) {
                        a2.mo3153a(a4, -1, fVar.mo3101j());
                    } else {
                        a2.mo3152a(a4, -fVar.mo3116r());
                    }
                    if (fVar2.f2240O > 0) {
                        fVar2.f2291w.mo3038a().mo3150a(1, a2, fVar2.f2240O);
                    }
                } else if (fVar2.f2288t.f2199c != null && fVar2.f2290v.f2199c != null) {
                    a2.mo3156b(2);
                    a4.mo3156b(2);
                    if (z) {
                        a2.mo3158b(a4, -1, fVar.mo3101j());
                        a4.mo3158b(a2, 1, fVar.mo3101j());
                        fVar.mo3101j().mo3164a(a2);
                        fVar.mo3099i().mo3164a(a4);
                    } else {
                        a2.mo3157b(a4, (float) (-fVar.mo3116r()));
                        a4.mo3157b(a2, (float) fVar.mo3116r());
                    }
                    if (fVar2.f2240O > 0) {
                        fVar2.f2291w.mo3038a().mo3150a(1, a2, fVar2.f2240O);
                    }
                }
            } else if (z3) {
                int r = fVar.mo3116r();
                a2.mo3156b(1);
                a4.mo3156b(1);
                if (fVar2.f2288t.f2199c == null && fVar2.f2290v.f2199c == null) {
                    if (z) {
                        a4.mo3153a(a2, 1, fVar.mo3101j());
                    } else {
                        a4.mo3152a(a2, r);
                    }
                } else if (fVar2.f2288t.f2199c == null || fVar2.f2290v.f2199c != null) {
                    if (fVar2.f2288t.f2199c != null || fVar2.f2290v.f2199c == null) {
                        if (fVar2.f2288t.f2199c != null && fVar2.f2290v.f2199c != null) {
                            if (z) {
                                fVar.mo3101j().mo3164a(a2);
                                fVar.mo3099i().mo3164a(a4);
                            }
                            if (fVar2.f2232G == BitmapDescriptorFactory.HUE_RED) {
                                a2.mo3156b(3);
                                a4.mo3156b(3);
                                a2.mo3157b(a4, BitmapDescriptorFactory.HUE_RED);
                                a4.mo3157b(a2, BitmapDescriptorFactory.HUE_RED);
                                return;
                            }
                            a2.mo3156b(2);
                            a4.mo3156b(2);
                            a2.mo3157b(a4, (float) (-r));
                            a4.mo3157b(a2, (float) r);
                            fVar2.mo3100i(r);
                            if (fVar2.f2240O > 0) {
                                fVar2.f2291w.mo3038a().mo3150a(1, a2, fVar2.f2240O);
                            }
                        }
                    } else if (z) {
                        a2.mo3153a(a4, -1, fVar.mo3101j());
                    } else {
                        a2.mo3152a(a4, -r);
                    }
                } else if (z) {
                    a4.mo3153a(a2, 1, fVar.mo3101j());
                } else {
                    a4.mo3152a(a2, r);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r6.f2247W == 2) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0046, code lost:
        if (r6.f2248X == 2) goto L_0x0032;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ef  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean m2870a(androidx.constraintlayout.p060b.p061a.C0769g r20, androidx.constraintlayout.p060b.C0786e r21, int r22, int r23, androidx.constraintlayout.p060b.p061a.C0760d r24) {
        /*
            r0 = r21
            r1 = r24
            androidx.constraintlayout.b.a.f r2 = r1.f2180a
            androidx.constraintlayout.b.a.f r3 = r1.f2182c
            androidx.constraintlayout.b.a.f r4 = r1.f2181b
            androidx.constraintlayout.b.a.f r5 = r1.f2183d
            androidx.constraintlayout.b.a.f r6 = r1.f2184e
            float r7 = r1.f2190k
            androidx.constraintlayout.b.a.f r8 = r1.f2185f
            androidx.constraintlayout.b.a.f r1 = r1.f2186g
            r8 = r20
            androidx.constraintlayout.b.a.f$a[] r1 = r8.f2228C
            r1 = r1[r22]
            androidx.constraintlayout.b.a.f$a r8 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            r1 = 2
            r9 = 1
            if (r22 != 0) goto L_0x0036
            int r10 = r6.f2247W
            if (r10 != 0) goto L_0x0026
            r10 = 1
            goto L_0x0027
        L_0x0026:
            r10 = 0
        L_0x0027:
            int r11 = r6.f2247W
            if (r11 != r9) goto L_0x002d
            r11 = 1
            goto L_0x002e
        L_0x002d:
            r11 = 0
        L_0x002e:
            int r6 = r6.f2247W
            if (r6 != r1) goto L_0x0034
        L_0x0032:
            r1 = 1
            goto L_0x0049
        L_0x0034:
            r1 = 0
            goto L_0x0049
        L_0x0036:
            int r10 = r6.f2248X
            if (r10 != 0) goto L_0x003c
            r10 = 1
            goto L_0x003d
        L_0x003c:
            r10 = 0
        L_0x003d:
            int r11 = r6.f2248X
            if (r11 != r9) goto L_0x0043
            r11 = 1
            goto L_0x0044
        L_0x0043:
            r11 = 0
        L_0x0044:
            int r6 = r6.f2248X
            if (r6 != r1) goto L_0x0034
            goto L_0x0032
        L_0x0049:
            r13 = r2
            r6 = 0
            r9 = 0
            r12 = 0
            r14 = 0
            r15 = 0
        L_0x004f:
            if (r12 != 0) goto L_0x00f2
            int r8 = r13.mo3105l()
            r16 = r12
            r12 = 8
            if (r8 == r12) goto L_0x008e
            int r6 = r6 + 1
            if (r22 != 0) goto L_0x0066
            int r8 = r13.mo3113p()
            float r8 = (float) r8
            float r14 = r14 + r8
            goto L_0x006c
        L_0x0066:
            int r8 = r13.mo3116r()
            float r8 = (float) r8
            float r14 = r14 + r8
        L_0x006c:
            if (r13 == r4) goto L_0x0078
            androidx.constraintlayout.b.a.e[] r8 = r13.f2226A
            r8 = r8[r23]
            int r8 = r8.mo3046e()
            float r8 = (float) r8
            float r14 = r14 + r8
        L_0x0078:
            androidx.constraintlayout.b.a.e[] r8 = r13.f2226A
            r8 = r8[r23]
            int r8 = r8.mo3046e()
            float r8 = (float) r8
            float r15 = r15 + r8
            androidx.constraintlayout.b.a.e[] r8 = r13.f2226A
            int r17 = r23 + 1
            r8 = r8[r17]
            int r8 = r8.mo3046e()
            float r8 = (float) r8
            float r15 = r15 + r8
        L_0x008e:
            androidx.constraintlayout.b.a.e[] r8 = r13.f2226A
            r8 = r8[r23]
            int r8 = r13.mo3105l()
            if (r8 == r12) goto L_0x00c3
            androidx.constraintlayout.b.a.f$a[] r8 = r13.f2228C
            r8 = r8[r22]
            androidx.constraintlayout.b.a.f$a r12 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.MATCH_CONSTRAINT
            if (r8 != r12) goto L_0x00c3
            int r9 = r9 + 1
            if (r22 != 0) goto L_0x00b4
            int r8 = r13.f2273e
            if (r8 == 0) goto L_0x00aa
            r8 = 0
            return r8
        L_0x00aa:
            r8 = 0
            int r12 = r13.f2276h
            if (r12 != 0) goto L_0x00b3
            int r12 = r13.f2277i
            if (r12 == 0) goto L_0x00c3
        L_0x00b3:
            return r8
        L_0x00b4:
            r8 = 0
            int r12 = r13.f2274f
            if (r12 == 0) goto L_0x00ba
            return r8
        L_0x00ba:
            int r12 = r13.f2279k
            if (r12 != 0) goto L_0x00c2
            int r12 = r13.f2280l
            if (r12 == 0) goto L_0x00c3
        L_0x00c2:
            return r8
        L_0x00c3:
            androidx.constraintlayout.b.a.e[] r8 = r13.f2226A
            int r12 = r23 + 1
            r8 = r8[r12]
            androidx.constraintlayout.b.a.e r8 = r8.f2199c
            if (r8 == 0) goto L_0x00e5
            androidx.constraintlayout.b.a.f r8 = r8.f2197a
            androidx.constraintlayout.b.a.e[] r12 = r8.f2226A
            r12 = r12[r23]
            androidx.constraintlayout.b.a.e r12 = r12.f2199c
            if (r12 == 0) goto L_0x00e5
            androidx.constraintlayout.b.a.e[] r12 = r8.f2226A
            r12 = r12[r23]
            androidx.constraintlayout.b.a.e r12 = r12.f2199c
            androidx.constraintlayout.b.a.f r12 = r12.f2197a
            if (r12 == r13) goto L_0x00e2
            goto L_0x00e5
        L_0x00e2:
            r18 = r8
            goto L_0x00e7
        L_0x00e5:
            r18 = 0
        L_0x00e7:
            if (r18 == 0) goto L_0x00ef
            r12 = r16
            r13 = r18
            goto L_0x004f
        L_0x00ef:
            r12 = 1
            goto L_0x004f
        L_0x00f2:
            androidx.constraintlayout.b.a.e[] r8 = r2.f2226A
            r8 = r8[r23]
            androidx.constraintlayout.b.a.n r8 = r8.mo3038a()
            androidx.constraintlayout.b.a.e[] r3 = r3.f2226A
            int r12 = r23 + 1
            r3 = r3[r12]
            androidx.constraintlayout.b.a.n r3 = r3.mo3038a()
            r19 = r2
            androidx.constraintlayout.b.a.n r2 = r8.f2347c
            if (r2 == 0) goto L_0x0352
            androidx.constraintlayout.b.a.n r2 = r3.f2347c
            if (r2 != 0) goto L_0x0110
            goto L_0x0352
        L_0x0110:
            androidx.constraintlayout.b.a.n r2 = r8.f2347c
            int r2 = r2.f2360i
            r0 = 1
            if (r2 == r0) goto L_0x011f
            androidx.constraintlayout.b.a.n r2 = r3.f2347c
            int r2 = r2.f2360i
            if (r2 == r0) goto L_0x011f
            r0 = 0
            return r0
        L_0x011f:
            r0 = 0
            if (r9 <= 0) goto L_0x0125
            if (r9 == r6) goto L_0x0125
            return r0
        L_0x0125:
            if (r1 != 0) goto L_0x012e
            if (r10 != 0) goto L_0x012e
            if (r11 == 0) goto L_0x012c
            goto L_0x012e
        L_0x012c:
            r0 = 0
            goto L_0x0147
        L_0x012e:
            if (r4 == 0) goto L_0x013a
            androidx.constraintlayout.b.a.e[] r0 = r4.f2226A
            r0 = r0[r23]
            int r0 = r0.mo3046e()
            float r0 = (float) r0
            goto L_0x013b
        L_0x013a:
            r0 = 0
        L_0x013b:
            if (r5 == 0) goto L_0x0147
            androidx.constraintlayout.b.a.e[] r2 = r5.f2226A
            r2 = r2[r12]
            int r2 = r2.mo3046e()
            float r2 = (float) r2
            float r0 = r0 + r2
        L_0x0147:
            androidx.constraintlayout.b.a.n r2 = r8.f2347c
            float r2 = r2.f2350f
            androidx.constraintlayout.b.a.n r3 = r3.f2347c
            float r3 = r3.f2350f
            int r16 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r16 >= 0) goto L_0x0156
            float r3 = r3 - r2
            float r3 = r3 - r14
            goto L_0x0159
        L_0x0156:
            float r3 = r2 - r3
            float r3 = r3 - r14
        L_0x0159:
            r16 = 1
            if (r9 <= 0) goto L_0x021b
            if (r9 != r6) goto L_0x021b
            androidx.constraintlayout.b.a.f r1 = r13.mo3103k()
            if (r1 == 0) goto L_0x0173
            androidx.constraintlayout.b.a.f r1 = r13.mo3103k()
            androidx.constraintlayout.b.a.f$a[] r1 = r1.f2228C
            r1 = r1[r22]
            androidx.constraintlayout.b.a.f$a r6 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            if (r1 != r6) goto L_0x0173
            r1 = 0
            return r1
        L_0x0173:
            float r3 = r3 + r14
            float r3 = r3 - r15
            if (r10 == 0) goto L_0x0179
            float r15 = r15 - r0
            float r3 = r3 - r15
        L_0x0179:
            if (r10 == 0) goto L_0x0195
            androidx.constraintlayout.b.a.e[] r0 = r4.f2226A
            r0 = r0[r12]
            int r0 = r0.mo3046e()
            float r0 = (float) r0
            float r2 = r2 + r0
            androidx.constraintlayout.b.a.f[] r0 = r4.f2254ac
            r0 = r0[r22]
            if (r0 == 0) goto L_0x0195
            androidx.constraintlayout.b.a.e[] r0 = r0.f2226A
            r0 = r0[r23]
            int r0 = r0.mo3046e()
            float r0 = (float) r0
            float r2 = r2 + r0
        L_0x0195:
            if (r4 == 0) goto L_0x0219
            androidx.constraintlayout.b.f r0 = androidx.constraintlayout.p060b.C0786e.f2380g
            if (r0 == 0) goto L_0x01b3
            androidx.constraintlayout.b.f r0 = androidx.constraintlayout.p060b.C0786e.f2380g
            long r10 = r0.f2399B
            long r10 = r10 - r16
            r0.f2399B = r10
            androidx.constraintlayout.b.f r0 = androidx.constraintlayout.p060b.C0786e.f2380g
            long r10 = r0.f2420s
            long r10 = r10 + r16
            r0.f2420s = r10
            androidx.constraintlayout.b.f r0 = androidx.constraintlayout.p060b.C0786e.f2380g
            long r10 = r0.f2426y
            long r10 = r10 + r16
            r0.f2426y = r10
        L_0x01b3:
            androidx.constraintlayout.b.a.f[] r0 = r4.f2254ac
            r0 = r0[r22]
            if (r0 != 0) goto L_0x01c0
            if (r4 != r5) goto L_0x01bc
            goto L_0x01c0
        L_0x01bc:
            r6 = 0
            r13 = r21
            goto L_0x0216
        L_0x01c0:
            float r1 = (float) r9
            float r1 = r3 / r1
            r6 = 0
            int r10 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r10 <= 0) goto L_0x01cf
            float[] r1 = r4.f2252aa
            r1 = r1[r22]
            float r1 = r1 * r3
            float r1 = r1 / r7
        L_0x01cf:
            androidx.constraintlayout.b.a.e[] r10 = r4.f2226A
            r10 = r10[r23]
            int r10 = r10.mo3046e()
            float r10 = (float) r10
            float r2 = r2 + r10
            androidx.constraintlayout.b.a.e[] r10 = r4.f2226A
            r10 = r10[r23]
            androidx.constraintlayout.b.a.n r10 = r10.mo3038a()
            androidx.constraintlayout.b.a.n r11 = r8.f2349e
            r10.mo3151a(r11, r2)
            androidx.constraintlayout.b.a.e[] r10 = r4.f2226A
            r10 = r10[r12]
            androidx.constraintlayout.b.a.n r10 = r10.mo3038a()
            androidx.constraintlayout.b.a.n r11 = r8.f2349e
            float r2 = r2 + r1
            r10.mo3151a(r11, r2)
            androidx.constraintlayout.b.a.e[] r1 = r4.f2226A
            r1 = r1[r23]
            androidx.constraintlayout.b.a.n r1 = r1.mo3038a()
            r13 = r21
            r1.mo3154a(r13)
            androidx.constraintlayout.b.a.e[] r1 = r4.f2226A
            r1 = r1[r12]
            androidx.constraintlayout.b.a.n r1 = r1.mo3038a()
            r1.mo3154a(r13)
            androidx.constraintlayout.b.a.e[] r1 = r4.f2226A
            r1 = r1[r12]
            int r1 = r1.mo3046e()
            float r1 = (float) r1
            float r2 = r2 + r1
        L_0x0216:
            r4 = r0
            goto L_0x0195
        L_0x0219:
            r0 = 1
            return r0
        L_0x021b:
            r13 = r21
            int r7 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r7 >= 0) goto L_0x0223
            r7 = 0
            return r7
        L_0x0223:
            if (r1 == 0) goto L_0x02aa
            float r3 = r3 - r0
            float r0 = r19.mo3125z()
            float r3 = r3 * r0
            float r2 = r2 + r3
        L_0x022d:
            if (r4 == 0) goto L_0x02a7
            androidx.constraintlayout.b.f r0 = androidx.constraintlayout.p060b.C0786e.f2380g
            if (r0 == 0) goto L_0x024b
            androidx.constraintlayout.b.f r0 = androidx.constraintlayout.p060b.C0786e.f2380g
            long r6 = r0.f2399B
            long r6 = r6 - r16
            r0.f2399B = r6
            androidx.constraintlayout.b.f r0 = androidx.constraintlayout.p060b.C0786e.f2380g
            long r6 = r0.f2420s
            long r6 = r6 + r16
            r0.f2420s = r6
            androidx.constraintlayout.b.f r0 = androidx.constraintlayout.p060b.C0786e.f2380g
            long r6 = r0.f2426y
            long r6 = r6 + r16
            r0.f2426y = r6
        L_0x024b:
            androidx.constraintlayout.b.a.f[] r0 = r4.f2254ac
            r0 = r0[r22]
            if (r0 != 0) goto L_0x0253
            if (r4 != r5) goto L_0x02a5
        L_0x0253:
            if (r22 != 0) goto L_0x025b
            int r1 = r4.mo3113p()
            float r1 = (float) r1
            goto L_0x0260
        L_0x025b:
            int r1 = r4.mo3116r()
            float r1 = (float) r1
        L_0x0260:
            androidx.constraintlayout.b.a.e[] r3 = r4.f2226A
            r3 = r3[r23]
            int r3 = r3.mo3046e()
            float r3 = (float) r3
            float r2 = r2 + r3
            androidx.constraintlayout.b.a.e[] r3 = r4.f2226A
            r3 = r3[r23]
            androidx.constraintlayout.b.a.n r3 = r3.mo3038a()
            androidx.constraintlayout.b.a.n r6 = r8.f2349e
            r3.mo3151a(r6, r2)
            androidx.constraintlayout.b.a.e[] r3 = r4.f2226A
            r3 = r3[r12]
            androidx.constraintlayout.b.a.n r3 = r3.mo3038a()
            androidx.constraintlayout.b.a.n r6 = r8.f2349e
            float r2 = r2 + r1
            r3.mo3151a(r6, r2)
            androidx.constraintlayout.b.a.e[] r1 = r4.f2226A
            r1 = r1[r23]
            androidx.constraintlayout.b.a.n r1 = r1.mo3038a()
            r1.mo3154a(r13)
            androidx.constraintlayout.b.a.e[] r1 = r4.f2226A
            r1 = r1[r12]
            androidx.constraintlayout.b.a.n r1 = r1.mo3038a()
            r1.mo3154a(r13)
            androidx.constraintlayout.b.a.e[] r1 = r4.f2226A
            r1 = r1[r12]
            int r1 = r1.mo3046e()
            float r1 = (float) r1
            float r2 = r2 + r1
        L_0x02a5:
            r4 = r0
            goto L_0x022d
        L_0x02a7:
            r0 = 1
            goto L_0x0351
        L_0x02aa:
            if (r10 != 0) goto L_0x02ae
            if (r11 == 0) goto L_0x02a7
        L_0x02ae:
            if (r10 == 0) goto L_0x02b2
            float r3 = r3 - r0
            goto L_0x02b5
        L_0x02b2:
            if (r11 == 0) goto L_0x02b5
            float r3 = r3 - r0
        L_0x02b5:
            int r0 = r6 + 1
            float r0 = (float) r0
            float r0 = r3 / r0
            if (r11 == 0) goto L_0x02c9
            r1 = 1
            if (r6 <= r1) goto L_0x02c5
            int r0 = r6 + -1
            float r0 = (float) r0
            float r0 = r3 / r0
            goto L_0x02c9
        L_0x02c5:
            r0 = 1073741824(0x40000000, float:2.0)
            float r0 = r3 / r0
        L_0x02c9:
            float r1 = r2 + r0
            if (r11 == 0) goto L_0x02da
            r3 = 1
            if (r6 <= r3) goto L_0x02da
            androidx.constraintlayout.b.a.e[] r1 = r4.f2226A
            r1 = r1[r23]
            int r1 = r1.mo3046e()
            float r1 = (float) r1
            float r1 = r1 + r2
        L_0x02da:
            if (r10 == 0) goto L_0x02e8
            if (r4 == 0) goto L_0x02e8
            androidx.constraintlayout.b.a.e[] r2 = r4.f2226A
            r2 = r2[r23]
            int r2 = r2.mo3046e()
            float r2 = (float) r2
            float r1 = r1 + r2
        L_0x02e8:
            if (r4 == 0) goto L_0x02a7
            androidx.constraintlayout.b.f r2 = androidx.constraintlayout.p060b.C0786e.f2380g
            if (r2 == 0) goto L_0x0306
            androidx.constraintlayout.b.f r2 = androidx.constraintlayout.p060b.C0786e.f2380g
            long r6 = r2.f2399B
            long r6 = r6 - r16
            r2.f2399B = r6
            androidx.constraintlayout.b.f r2 = androidx.constraintlayout.p060b.C0786e.f2380g
            long r6 = r2.f2420s
            long r6 = r6 + r16
            r2.f2420s = r6
            androidx.constraintlayout.b.f r2 = androidx.constraintlayout.p060b.C0786e.f2380g
            long r6 = r2.f2426y
            long r6 = r6 + r16
            r2.f2426y = r6
        L_0x0306:
            androidx.constraintlayout.b.a.f[] r2 = r4.f2254ac
            r2 = r2[r22]
            if (r2 != 0) goto L_0x030e
            if (r4 != r5) goto L_0x034f
        L_0x030e:
            if (r22 != 0) goto L_0x0316
            int r3 = r4.mo3113p()
            float r3 = (float) r3
            goto L_0x031b
        L_0x0316:
            int r3 = r4.mo3116r()
            float r3 = (float) r3
        L_0x031b:
            androidx.constraintlayout.b.a.e[] r6 = r4.f2226A
            r6 = r6[r23]
            androidx.constraintlayout.b.a.n r6 = r6.mo3038a()
            androidx.constraintlayout.b.a.n r7 = r8.f2349e
            r6.mo3151a(r7, r1)
            androidx.constraintlayout.b.a.e[] r6 = r4.f2226A
            r6 = r6[r12]
            androidx.constraintlayout.b.a.n r6 = r6.mo3038a()
            androidx.constraintlayout.b.a.n r7 = r8.f2349e
            float r9 = r1 + r3
            r6.mo3151a(r7, r9)
            androidx.constraintlayout.b.a.e[] r6 = r4.f2226A
            r6 = r6[r23]
            androidx.constraintlayout.b.a.n r6 = r6.mo3038a()
            r6.mo3154a(r13)
            androidx.constraintlayout.b.a.e[] r4 = r4.f2226A
            r4 = r4[r12]
            androidx.constraintlayout.b.a.n r4 = r4.mo3038a()
            r4.mo3154a(r13)
            float r3 = r3 + r0
            float r1 = r1 + r3
        L_0x034f:
            r4 = r2
            goto L_0x02e8
        L_0x0351:
            return r0
        L_0x0352:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p060b.p061a.C0775l.m2870a(androidx.constraintlayout.b.a.g, androidx.constraintlayout.b.e, int, int, androidx.constraintlayout.b.a.d):boolean");
    }
}
