package androidx.constraintlayout.p060b.p061a;

import androidx.constraintlayout.p060b.C0786e;

/* renamed from: androidx.constraintlayout.b.a.c */
/* compiled from: Chain */
class C0759c {
    /* renamed from: a */
    static void m2729a(C0769g gVar, C0786e eVar, int i) {
        int i2;
        C0760d[] dVarArr;
        int i3;
        if (i == 0) {
            int i4 = gVar.f2309ak;
            dVarArr = gVar.f2312an;
            i2 = i4;
            i3 = 0;
        } else {
            i3 = 2;
            int i5 = gVar.f2310al;
            i2 = i5;
            dVarArr = gVar.f2311am;
        }
        for (int i6 = 0; i6 < i2; i6++) {
            C0760d dVar = dVarArr[i6];
            dVar.mo3037a();
            if (!gVar.mo3140q(4)) {
                m2730a(gVar, eVar, i, i3, dVar);
            } else if (!C0775l.m2870a(gVar, eVar, i, i3, dVar)) {
                m2730a(gVar, eVar, i, i3, dVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r2.f2247W == 2) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
        if (r2.f2248X == 2) goto L_0x0037;
     */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x03b7  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x047d  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x04d7  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x04dc  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x04e2  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x04e7  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x04eb  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x04fd  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0182  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m2730a(androidx.constraintlayout.p060b.p061a.C0769g r47, androidx.constraintlayout.p060b.C0786e r48, int r49, int r50, androidx.constraintlayout.p060b.p061a.C0760d r51) {
        /*
            r0 = r47
            r9 = r48
            r1 = r51
            androidx.constraintlayout.b.a.f r11 = r1.f2180a
            androidx.constraintlayout.b.a.f r12 = r1.f2182c
            androidx.constraintlayout.b.a.f r13 = r1.f2181b
            androidx.constraintlayout.b.a.f r14 = r1.f2183d
            androidx.constraintlayout.b.a.f r2 = r1.f2184e
            float r3 = r1.f2190k
            androidx.constraintlayout.b.a.f r4 = r1.f2185f
            androidx.constraintlayout.b.a.f r4 = r1.f2186g
            androidx.constraintlayout.b.a.f$a[] r4 = r0.f2228C
            r4 = r4[r49]
            androidx.constraintlayout.b.a.f$a r5 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.WRAP_CONTENT
            r7 = 1
            if (r4 != r5) goto L_0x0021
            r4 = 1
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            r5 = 2
            if (r49 != 0) goto L_0x0042
            int r8 = r2.f2247W
            if (r8 != 0) goto L_0x002b
            r8 = 1
            goto L_0x002c
        L_0x002b:
            r8 = 0
        L_0x002c:
            int r6 = r2.f2247W
            if (r6 != r7) goto L_0x0032
            r6 = 1
            goto L_0x0033
        L_0x0032:
            r6 = 0
        L_0x0033:
            int r7 = r2.f2247W
            if (r7 != r5) goto L_0x0039
        L_0x0037:
            r5 = 1
            goto L_0x003a
        L_0x0039:
            r5 = 0
        L_0x003a:
            r7 = r5
            r18 = r6
            r17 = r8
            r6 = r11
            r5 = 0
            goto L_0x0056
        L_0x0042:
            int r6 = r2.f2248X
            if (r6 != 0) goto L_0x0048
            r8 = 1
            goto L_0x0049
        L_0x0048:
            r8 = 0
        L_0x0049:
            int r6 = r2.f2248X
            r7 = 1
            if (r6 != r7) goto L_0x0050
            r6 = 1
            goto L_0x0051
        L_0x0050:
            r6 = 0
        L_0x0051:
            int r7 = r2.f2248X
            if (r7 != r5) goto L_0x0039
            goto L_0x0037
        L_0x0056:
            r21 = 0
            if (r5 != 0) goto L_0x0135
            androidx.constraintlayout.b.a.e[] r8 = r6.f2226A
            r8 = r8[r50]
            if (r4 != 0) goto L_0x0066
            if (r7 == 0) goto L_0x0063
            goto L_0x0066
        L_0x0063:
            r23 = 4
            goto L_0x0068
        L_0x0066:
            r23 = 1
        L_0x0068:
            int r24 = r8.mo3046e()
            r25 = r3
            androidx.constraintlayout.b.a.e r3 = r8.f2199c
            if (r3 == 0) goto L_0x007c
            if (r6 == r11) goto L_0x007c
            androidx.constraintlayout.b.a.e r3 = r8.f2199c
            int r3 = r3.mo3046e()
            int r24 = r24 + r3
        L_0x007c:
            r3 = r24
            if (r7 == 0) goto L_0x008a
            if (r6 == r11) goto L_0x008a
            if (r6 == r13) goto L_0x008a
            r27 = r2
            r26 = r5
            r5 = 6
            goto L_0x009a
        L_0x008a:
            if (r17 == 0) goto L_0x0094
            if (r4 == 0) goto L_0x0094
            r27 = r2
            r26 = r5
            r5 = 4
            goto L_0x009a
        L_0x0094:
            r27 = r2
            r26 = r5
            r5 = r23
        L_0x009a:
            androidx.constraintlayout.b.a.e r2 = r8.f2199c
            if (r2 == 0) goto L_0x00c7
            if (r6 != r13) goto L_0x00af
            androidx.constraintlayout.b.h r2 = r8.f2202f
            r28 = r11
            androidx.constraintlayout.b.a.e r11 = r8.f2199c
            androidx.constraintlayout.b.h r11 = r11.f2202f
            r29 = r7
            r7 = 5
            r9.mo3211a(r2, r11, r3, r7)
            goto L_0x00bd
        L_0x00af:
            r29 = r7
            r28 = r11
            androidx.constraintlayout.b.h r2 = r8.f2202f
            androidx.constraintlayout.b.a.e r7 = r8.f2199c
            androidx.constraintlayout.b.h r7 = r7.f2202f
            r11 = 6
            r9.mo3211a(r2, r7, r3, r11)
        L_0x00bd:
            androidx.constraintlayout.b.h r2 = r8.f2202f
            androidx.constraintlayout.b.a.e r7 = r8.f2199c
            androidx.constraintlayout.b.h r7 = r7.f2202f
            r9.mo3219c(r2, r7, r3, r5)
            goto L_0x00cb
        L_0x00c7:
            r29 = r7
            r28 = r11
        L_0x00cb:
            if (r4 == 0) goto L_0x0102
            int r2 = r6.mo3105l()
            r3 = 8
            if (r2 == r3) goto L_0x00f1
            androidx.constraintlayout.b.a.f$a[] r2 = r6.f2228C
            r2 = r2[r49]
            androidx.constraintlayout.b.a.f$a r3 = androidx.constraintlayout.p060b.p061a.C0766f.C0768a.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x00f1
            androidx.constraintlayout.b.a.e[] r2 = r6.f2226A
            int r3 = r50 + 1
            r2 = r2[r3]
            androidx.constraintlayout.b.h r2 = r2.f2202f
            androidx.constraintlayout.b.a.e[] r3 = r6.f2226A
            r3 = r3[r50]
            androidx.constraintlayout.b.h r3 = r3.f2202f
            r5 = 0
            r7 = 5
            r9.mo3211a(r2, r3, r5, r7)
            goto L_0x00f2
        L_0x00f1:
            r5 = 0
        L_0x00f2:
            androidx.constraintlayout.b.a.e[] r2 = r6.f2226A
            r2 = r2[r50]
            androidx.constraintlayout.b.h r2 = r2.f2202f
            androidx.constraintlayout.b.a.e[] r3 = r0.f2226A
            r3 = r3[r50]
            androidx.constraintlayout.b.h r3 = r3.f2202f
            r7 = 6
            r9.mo3211a(r2, r3, r5, r7)
        L_0x0102:
            androidx.constraintlayout.b.a.e[] r2 = r6.f2226A
            int r3 = r50 + 1
            r2 = r2[r3]
            androidx.constraintlayout.b.a.e r2 = r2.f2199c
            if (r2 == 0) goto L_0x0123
            androidx.constraintlayout.b.a.f r2 = r2.f2197a
            androidx.constraintlayout.b.a.e[] r3 = r2.f2226A
            r3 = r3[r50]
            androidx.constraintlayout.b.a.e r3 = r3.f2199c
            if (r3 == 0) goto L_0x0123
            androidx.constraintlayout.b.a.e[] r3 = r2.f2226A
            r3 = r3[r50]
            androidx.constraintlayout.b.a.e r3 = r3.f2199c
            androidx.constraintlayout.b.a.f r3 = r3.f2197a
            if (r3 == r6) goto L_0x0121
            goto L_0x0123
        L_0x0121:
            r21 = r2
        L_0x0123:
            if (r21 == 0) goto L_0x012a
            r6 = r21
            r5 = r26
            goto L_0x012b
        L_0x012a:
            r5 = 1
        L_0x012b:
            r3 = r25
            r2 = r27
            r11 = r28
            r7 = r29
            goto L_0x0056
        L_0x0135:
            r27 = r2
            r25 = r3
            r29 = r7
            r28 = r11
            if (r14 == 0) goto L_0x0161
            androidx.constraintlayout.b.a.e[] r2 = r12.f2226A
            int r3 = r50 + 1
            r2 = r2[r3]
            androidx.constraintlayout.b.a.e r2 = r2.f2199c
            if (r2 == 0) goto L_0x0161
            androidx.constraintlayout.b.a.e[] r2 = r14.f2226A
            r2 = r2[r3]
            androidx.constraintlayout.b.h r5 = r2.f2202f
            androidx.constraintlayout.b.a.e[] r6 = r12.f2226A
            r3 = r6[r3]
            androidx.constraintlayout.b.a.e r3 = r3.f2199c
            androidx.constraintlayout.b.h r3 = r3.f2202f
            int r2 = r2.mo3046e()
            int r2 = -r2
            r8 = 5
            r9.mo3216b(r5, r3, r2, r8)
            goto L_0x0162
        L_0x0161:
            r8 = 5
        L_0x0162:
            if (r4 == 0) goto L_0x017e
            androidx.constraintlayout.b.a.e[] r0 = r0.f2226A
            int r2 = r50 + 1
            r0 = r0[r2]
            androidx.constraintlayout.b.h r0 = r0.f2202f
            androidx.constraintlayout.b.a.e[] r3 = r12.f2226A
            r3 = r3[r2]
            androidx.constraintlayout.b.h r3 = r3.f2202f
            androidx.constraintlayout.b.a.e[] r4 = r12.f2226A
            r2 = r4[r2]
            int r2 = r2.mo3046e()
            r4 = 6
            r9.mo3211a(r0, r3, r2, r4)
        L_0x017e:
            java.util.ArrayList<androidx.constraintlayout.b.a.f> r0 = r1.f2187h
            if (r0 == 0) goto L_0x0236
            int r2 = r0.size()
            r7 = 1
            if (r2 <= r7) goto L_0x0236
            boolean r3 = r1.f2191l
            if (r3 == 0) goto L_0x0195
            boolean r3 = r1.f2193n
            if (r3 != 0) goto L_0x0195
            int r3 = r1.f2189j
            float r3 = (float) r3
            goto L_0x0197
        L_0x0195:
            r3 = r25
        L_0x0197:
            r4 = 0
            r6 = r21
            r5 = 0
            r31 = 0
        L_0x019d:
            if (r5 >= r2) goto L_0x0236
            java.lang.Object r11 = r0.get(r5)
            androidx.constraintlayout.b.a.f r11 = (androidx.constraintlayout.p060b.p061a.C0766f) r11
            float[] r7 = r11.f2252aa
            r7 = r7[r49]
            int r16 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r16 >= 0) goto L_0x01cb
            boolean r7 = r1.f2193n
            if (r7 == 0) goto L_0x01c7
            androidx.constraintlayout.b.a.e[] r7 = r11.f2226A
            int r16 = r50 + 1
            r7 = r7[r16]
            androidx.constraintlayout.b.h r7 = r7.f2202f
            androidx.constraintlayout.b.a.e[] r11 = r11.f2226A
            r11 = r11[r50]
            androidx.constraintlayout.b.h r11 = r11.f2202f
            r4 = 4
            r8 = 0
            r9.mo3219c(r7, r11, r8, r4)
            r4 = 0
            r8 = 6
            goto L_0x01e4
        L_0x01c7:
            r4 = 4
            r7 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01cc
        L_0x01cb:
            r4 = 4
        L_0x01cc:
            r8 = 0
            int r16 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r16 != 0) goto L_0x01e9
            androidx.constraintlayout.b.a.e[] r7 = r11.f2226A
            int r16 = r50 + 1
            r7 = r7[r16]
            androidx.constraintlayout.b.h r7 = r7.f2202f
            androidx.constraintlayout.b.a.e[] r11 = r11.f2226A
            r11 = r11[r50]
            androidx.constraintlayout.b.h r11 = r11.f2202f
            r4 = 0
            r8 = 6
            r9.mo3219c(r7, r11, r4, r8)
        L_0x01e4:
            r39 = r0
            r40 = r2
            goto L_0x022b
        L_0x01e9:
            r4 = 0
            r8 = 6
            if (r6 == 0) goto L_0x0224
            androidx.constraintlayout.b.a.e[] r4 = r6.f2226A
            r4 = r4[r50]
            androidx.constraintlayout.b.h r4 = r4.f2202f
            androidx.constraintlayout.b.a.e[] r6 = r6.f2226A
            int r15 = r50 + 1
            r6 = r6[r15]
            androidx.constraintlayout.b.h r6 = r6.f2202f
            androidx.constraintlayout.b.a.e[] r8 = r11.f2226A
            r8 = r8[r50]
            androidx.constraintlayout.b.h r8 = r8.f2202f
            r39 = r0
            androidx.constraintlayout.b.a.e[] r0 = r11.f2226A
            r0 = r0[r15]
            androidx.constraintlayout.b.h r0 = r0.f2202f
            r40 = r2
            androidx.constraintlayout.b.b r2 = r48.mo3218c()
            r30 = r2
            r32 = r3
            r33 = r7
            r34 = r4
            r35 = r6
            r36 = r8
            r37 = r0
            r30.mo3176a(r31, r32, r33, r34, r35, r36, r37)
            r9.mo3206a(r2)
            goto L_0x0228
        L_0x0224:
            r39 = r0
            r40 = r2
        L_0x0228:
            r31 = r7
            r6 = r11
        L_0x022b:
            int r5 = r5 + 1
            r0 = r39
            r2 = r40
            r4 = 0
            r7 = 1
            r8 = 5
            goto L_0x019d
        L_0x0236:
            if (r13 == 0) goto L_0x02a3
            if (r13 == r14) goto L_0x023c
            if (r29 == 0) goto L_0x02a3
        L_0x023c:
            r11 = r28
            androidx.constraintlayout.b.a.e[] r0 = r11.f2226A
            r0 = r0[r50]
            androidx.constraintlayout.b.a.e[] r1 = r12.f2226A
            int r2 = r50 + 1
            r1 = r1[r2]
            androidx.constraintlayout.b.a.e[] r3 = r11.f2226A
            r3 = r3[r50]
            androidx.constraintlayout.b.a.e r3 = r3.f2199c
            if (r3 == 0) goto L_0x0259
            androidx.constraintlayout.b.a.e[] r3 = r11.f2226A
            r3 = r3[r50]
            androidx.constraintlayout.b.a.e r3 = r3.f2199c
            androidx.constraintlayout.b.h r3 = r3.f2202f
            goto L_0x025b
        L_0x0259:
            r3 = r21
        L_0x025b:
            androidx.constraintlayout.b.a.e[] r4 = r12.f2226A
            r4 = r4[r2]
            androidx.constraintlayout.b.a.e r4 = r4.f2199c
            if (r4 == 0) goto L_0x026d
            androidx.constraintlayout.b.a.e[] r4 = r12.f2226A
            r4 = r4[r2]
            androidx.constraintlayout.b.a.e r4 = r4.f2199c
            androidx.constraintlayout.b.h r4 = r4.f2202f
            r5 = r4
            goto L_0x026f
        L_0x026d:
            r5 = r21
        L_0x026f:
            if (r13 != r14) goto L_0x0279
            androidx.constraintlayout.b.a.e[] r0 = r13.f2226A
            r0 = r0[r50]
            androidx.constraintlayout.b.a.e[] r1 = r13.f2226A
            r1 = r1[r2]
        L_0x0279:
            if (r3 == 0) goto L_0x04c3
            if (r5 == 0) goto L_0x04c3
            if (r49 != 0) goto L_0x0285
            r2 = r27
            float r2 = r2.f2243S
        L_0x0283:
            r4 = r2
            goto L_0x028a
        L_0x0285:
            r2 = r27
            float r2 = r2.f2244T
            goto L_0x0283
        L_0x028a:
            int r6 = r0.mo3046e()
            int r7 = r1.mo3046e()
            androidx.constraintlayout.b.h r2 = r0.f2202f
            androidx.constraintlayout.b.h r8 = r1.f2202f
            r10 = 5
            r0 = r48
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.mo3210a(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04c3
        L_0x02a3:
            r11 = r28
            if (r17 == 0) goto L_0x039c
            if (r13 == 0) goto L_0x039c
            int r0 = r1.f2189j
            if (r0 <= 0) goto L_0x02b6
            int r0 = r1.f2188i
            int r1 = r1.f2189j
            if (r0 != r1) goto L_0x02b6
            r38 = 1
            goto L_0x02b8
        L_0x02b6:
            r38 = 0
        L_0x02b8:
            r0 = r13
            r8 = r0
        L_0x02ba:
            if (r8 == 0) goto L_0x04c3
            androidx.constraintlayout.b.a.f[] r1 = r8.f2254ac
            r7 = r1[r49]
            if (r7 != 0) goto L_0x02ce
            if (r8 != r14) goto L_0x02c5
            goto L_0x02ce
        L_0x02c5:
            r20 = r7
            r15 = r8
        L_0x02c8:
            r16 = 6
            r22 = 4
            goto L_0x0397
        L_0x02ce:
            androidx.constraintlayout.b.a.e[] r1 = r8.f2226A
            r1 = r1[r50]
            androidx.constraintlayout.b.h r2 = r1.f2202f
            androidx.constraintlayout.b.a.e r3 = r1.f2199c
            if (r3 == 0) goto L_0x02dd
            androidx.constraintlayout.b.a.e r3 = r1.f2199c
            androidx.constraintlayout.b.h r3 = r3.f2202f
            goto L_0x02df
        L_0x02dd:
            r3 = r21
        L_0x02df:
            if (r0 == r8) goto L_0x02ea
            androidx.constraintlayout.b.a.e[] r3 = r0.f2226A
            int r4 = r50 + 1
            r3 = r3[r4]
            androidx.constraintlayout.b.h r3 = r3.f2202f
            goto L_0x0301
        L_0x02ea:
            if (r8 != r13) goto L_0x0301
            if (r0 != r8) goto L_0x0301
            androidx.constraintlayout.b.a.e[] r3 = r11.f2226A
            r3 = r3[r50]
            androidx.constraintlayout.b.a.e r3 = r3.f2199c
            if (r3 == 0) goto L_0x02ff
            androidx.constraintlayout.b.a.e[] r3 = r11.f2226A
            r3 = r3[r50]
            androidx.constraintlayout.b.a.e r3 = r3.f2199c
            androidx.constraintlayout.b.h r3 = r3.f2202f
            goto L_0x0301
        L_0x02ff:
            r3 = r21
        L_0x0301:
            int r1 = r1.mo3046e()
            androidx.constraintlayout.b.a.e[] r4 = r8.f2226A
            int r5 = r50 + 1
            r4 = r4[r5]
            int r4 = r4.mo3046e()
            if (r7 == 0) goto L_0x0322
            androidx.constraintlayout.b.a.e[] r6 = r7.f2226A
            r6 = r6[r50]
            r41 = r7
            androidx.constraintlayout.b.h r7 = r6.f2202f
            r42 = r6
            androidx.constraintlayout.b.a.e[] r6 = r8.f2226A
            r6 = r6[r5]
            androidx.constraintlayout.b.h r6 = r6.f2202f
            goto L_0x033d
        L_0x0322:
            r41 = r7
            androidx.constraintlayout.b.a.e[] r6 = r12.f2226A
            r6 = r6[r5]
            androidx.constraintlayout.b.a.e r6 = r6.f2199c
            if (r6 == 0) goto L_0x0331
            androidx.constraintlayout.b.h r7 = r6.f2202f
            r43 = r6
            goto L_0x0335
        L_0x0331:
            r43 = r6
            r7 = r21
        L_0x0335:
            androidx.constraintlayout.b.a.e[] r6 = r8.f2226A
            r6 = r6[r5]
            androidx.constraintlayout.b.h r6 = r6.f2202f
            r42 = r43
        L_0x033d:
            if (r42 == 0) goto L_0x0344
            int r15 = r42.mo3046e()
            int r4 = r4 + r15
        L_0x0344:
            if (r0 == 0) goto L_0x034f
            androidx.constraintlayout.b.a.e[] r0 = r0.f2226A
            r0 = r0[r5]
            int r0 = r0.mo3046e()
            int r1 = r1 + r0
        L_0x034f:
            if (r2 == 0) goto L_0x0392
            if (r3 == 0) goto L_0x0392
            if (r7 == 0) goto L_0x0392
            if (r6 == 0) goto L_0x0392
            if (r8 != r13) goto L_0x0363
            androidx.constraintlayout.b.a.e[] r0 = r13.f2226A
            r0 = r0[r50]
            int r0 = r0.mo3046e()
            r15 = r0
            goto L_0x0364
        L_0x0363:
            r15 = r1
        L_0x0364:
            if (r8 != r14) goto L_0x0371
            androidx.constraintlayout.b.a.e[] r0 = r14.f2226A
            r0 = r0[r5]
            int r0 = r0.mo3046e()
            r16 = r0
            goto L_0x0373
        L_0x0371:
            r16 = r4
        L_0x0373:
            if (r38 == 0) goto L_0x0378
            r19 = 6
            goto L_0x037a
        L_0x0378:
            r19 = 4
        L_0x037a:
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r48
            r1 = r2
            r2 = r3
            r3 = r15
            r15 = 4
            r5 = r7
            r20 = r41
            r7 = r16
            r15 = r8
            r16 = 6
            r22 = 4
            r8 = r19
            r0.mo3210a(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0397
        L_0x0392:
            r15 = r8
            r20 = r41
            goto L_0x02c8
        L_0x0397:
            r0 = r15
            r8 = r20
            goto L_0x02ba
        L_0x039c:
            r16 = 6
            r22 = 4
            if (r18 == 0) goto L_0x04c3
            if (r13 == 0) goto L_0x04c3
            int r0 = r1.f2189j
            if (r0 <= 0) goto L_0x03b1
            int r0 = r1.f2188i
            int r1 = r1.f2189j
            if (r0 != r1) goto L_0x03b1
            r38 = 1
            goto L_0x03b3
        L_0x03b1:
            r38 = 0
        L_0x03b3:
            r0 = r13
            r8 = r0
        L_0x03b5:
            if (r8 == 0) goto L_0x0464
            androidx.constraintlayout.b.a.f[] r1 = r8.f2254ac
            r1 = r1[r49]
            if (r8 == r13) goto L_0x045c
            if (r8 == r14) goto L_0x045c
            if (r1 == 0) goto L_0x045c
            if (r1 != r14) goto L_0x03c6
            r7 = r21
            goto L_0x03c7
        L_0x03c6:
            r7 = r1
        L_0x03c7:
            androidx.constraintlayout.b.a.e[] r1 = r8.f2226A
            r1 = r1[r50]
            androidx.constraintlayout.b.h r2 = r1.f2202f
            androidx.constraintlayout.b.a.e r3 = r1.f2199c
            if (r3 == 0) goto L_0x03d5
            androidx.constraintlayout.b.a.e r3 = r1.f2199c
            androidx.constraintlayout.b.h r3 = r3.f2202f
        L_0x03d5:
            androidx.constraintlayout.b.a.e[] r3 = r0.f2226A
            int r4 = r50 + 1
            r3 = r3[r4]
            androidx.constraintlayout.b.h r3 = r3.f2202f
            int r1 = r1.mo3046e()
            androidx.constraintlayout.b.a.e[] r5 = r8.f2226A
            r5 = r5[r4]
            int r5 = r5.mo3046e()
            if (r7 == 0) goto L_0x0404
            androidx.constraintlayout.b.a.e[] r6 = r7.f2226A
            r6 = r6[r50]
            r44 = r7
            androidx.constraintlayout.b.h r7 = r6.f2202f
            r45 = r7
            androidx.constraintlayout.b.a.e r7 = r6.f2199c
            if (r7 == 0) goto L_0x03fe
            androidx.constraintlayout.b.a.e r7 = r6.f2199c
            androidx.constraintlayout.b.h r7 = r7.f2202f
            goto L_0x0400
        L_0x03fe:
            r7 = r21
        L_0x0400:
            r46 = r6
            r6 = r7
            goto L_0x041f
        L_0x0404:
            r44 = r7
            androidx.constraintlayout.b.a.e[] r6 = r8.f2226A
            r6 = r6[r4]
            androidx.constraintlayout.b.a.e r6 = r6.f2199c
            if (r6 == 0) goto L_0x0413
            androidx.constraintlayout.b.h r7 = r6.f2202f
            r46 = r6
            goto L_0x0417
        L_0x0413:
            r46 = r6
            r7 = r21
        L_0x0417:
            androidx.constraintlayout.b.a.e[] r6 = r8.f2226A
            r6 = r6[r4]
            androidx.constraintlayout.b.h r6 = r6.f2202f
            r45 = r7
        L_0x041f:
            if (r46 == 0) goto L_0x0426
            int r7 = r46.mo3046e()
            int r5 = r5 + r7
        L_0x0426:
            r7 = r5
            if (r0 == 0) goto L_0x0432
            androidx.constraintlayout.b.a.e[] r0 = r0.f2226A
            r0 = r0[r4]
            int r0 = r0.mo3046e()
            int r1 = r1 + r0
        L_0x0432:
            r4 = r1
            if (r38 == 0) goto L_0x0437
            r15 = 6
            goto L_0x0438
        L_0x0437:
            r15 = 4
        L_0x0438:
            if (r2 == 0) goto L_0x0454
            if (r3 == 0) goto L_0x0454
            if (r45 == 0) goto L_0x0454
            if (r6 == 0) goto L_0x0454
            r5 = 1056964608(0x3f000000, float:0.5)
            r0 = r48
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r45
            r19 = r44
            r20 = r8
            r10 = 5
            r8 = r15
            r0.mo3210a(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0459
        L_0x0454:
            r20 = r8
            r19 = r44
            r10 = 5
        L_0x0459:
            r8 = r19
            goto L_0x0460
        L_0x045c:
            r20 = r8
            r10 = 5
            r8 = r1
        L_0x0460:
            r0 = r20
            goto L_0x03b5
        L_0x0464:
            r10 = 5
            androidx.constraintlayout.b.a.e[] r0 = r13.f2226A
            r0 = r0[r50]
            androidx.constraintlayout.b.a.e[] r1 = r11.f2226A
            r1 = r1[r50]
            androidx.constraintlayout.b.a.e r1 = r1.f2199c
            androidx.constraintlayout.b.a.e[] r2 = r14.f2226A
            int r3 = r50 + 1
            r11 = r2[r3]
            androidx.constraintlayout.b.a.e[] r2 = r12.f2226A
            r2 = r2[r3]
            androidx.constraintlayout.b.a.e r8 = r2.f2199c
            if (r1 == 0) goto L_0x04b1
            if (r13 == r14) goto L_0x048b
            androidx.constraintlayout.b.h r2 = r0.f2202f
            androidx.constraintlayout.b.h r1 = r1.f2202f
            int r0 = r0.mo3046e()
            r9.mo3219c(r2, r1, r0, r10)
            goto L_0x04b1
        L_0x048b:
            if (r8 == 0) goto L_0x04b1
            androidx.constraintlayout.b.h r2 = r0.f2202f
            androidx.constraintlayout.b.h r3 = r1.f2202f
            int r4 = r0.mo3046e()
            r5 = 1056964608(0x3f000000, float:0.5)
            androidx.constraintlayout.b.h r6 = r11.f2202f
            androidx.constraintlayout.b.h r7 = r8.f2202f
            int r15 = r11.mo3046e()
            r16 = 5
            r0 = r48
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r15
            r10 = r8
            r8 = r16
            r0.mo3210a(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04b2
        L_0x04b1:
            r10 = r8
        L_0x04b2:
            if (r10 == 0) goto L_0x04c3
            if (r13 == r14) goto L_0x04c3
            androidx.constraintlayout.b.h r0 = r11.f2202f
            androidx.constraintlayout.b.h r1 = r10.f2202f
            int r2 = r11.mo3046e()
            int r2 = -r2
            r3 = 5
            r9.mo3219c(r0, r1, r2, r3)
        L_0x04c3:
            if (r17 != 0) goto L_0x04c7
            if (r18 == 0) goto L_0x052a
        L_0x04c7:
            if (r13 == 0) goto L_0x052a
            androidx.constraintlayout.b.a.e[] r0 = r13.f2226A
            r0 = r0[r50]
            androidx.constraintlayout.b.a.e[] r1 = r14.f2226A
            int r2 = r50 + 1
            r1 = r1[r2]
            androidx.constraintlayout.b.a.e r3 = r0.f2199c
            if (r3 == 0) goto L_0x04dc
            androidx.constraintlayout.b.a.e r3 = r0.f2199c
            androidx.constraintlayout.b.h r3 = r3.f2202f
            goto L_0x04de
        L_0x04dc:
            r3 = r21
        L_0x04de:
            androidx.constraintlayout.b.a.e r4 = r1.f2199c
            if (r4 == 0) goto L_0x04e7
            androidx.constraintlayout.b.a.e r4 = r1.f2199c
            androidx.constraintlayout.b.h r4 = r4.f2202f
            goto L_0x04e9
        L_0x04e7:
            r4 = r21
        L_0x04e9:
            if (r12 == r14) goto L_0x04fa
            androidx.constraintlayout.b.a.e[] r4 = r12.f2226A
            r4 = r4[r2]
            androidx.constraintlayout.b.a.e r5 = r4.f2199c
            if (r5 == 0) goto L_0x04f8
            androidx.constraintlayout.b.a.e r4 = r4.f2199c
            androidx.constraintlayout.b.h r4 = r4.f2202f
            goto L_0x04fa
        L_0x04f8:
            r4 = r21
        L_0x04fa:
            r5 = r4
            if (r13 != r14) goto L_0x0505
            androidx.constraintlayout.b.a.e[] r0 = r13.f2226A
            r0 = r0[r50]
            androidx.constraintlayout.b.a.e[] r1 = r13.f2226A
            r1 = r1[r2]
        L_0x0505:
            if (r3 == 0) goto L_0x052a
            if (r5 == 0) goto L_0x052a
            r4 = 1056964608(0x3f000000, float:0.5)
            int r6 = r0.mo3046e()
            if (r14 != 0) goto L_0x0512
            goto L_0x0513
        L_0x0512:
            r12 = r14
        L_0x0513:
            androidx.constraintlayout.b.a.e[] r7 = r12.f2226A
            r2 = r7[r2]
            int r7 = r2.mo3046e()
            androidx.constraintlayout.b.h r2 = r0.f2202f
            androidx.constraintlayout.b.h r8 = r1.f2202f
            r10 = 5
            r0 = r48
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.mo3210a(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x052a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p060b.p061a.C0759c.m2730a(androidx.constraintlayout.b.a.g, androidx.constraintlayout.b.e, int, int, androidx.constraintlayout.b.a.d):void");
    }
}
