package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import sun.misc.Unsafe;

final class zzhg<T> implements zzhw<T> {
    private static final int[] zzzj = new int[0];
    private static final Unsafe zzzk = zziw.zzju();
    private final zzfh<?> zzaaa;
    private final zzgx zzaab;
    private final int[] zzzl;
    private final Object[] zzzm;
    private final int zzzn;
    private final int zzzo;
    private final zzhc zzzp;
    private final boolean zzzq;
    private final boolean zzzr;
    private final boolean zzzs;
    private final boolean zzzt;
    private final int[] zzzu;
    private final int zzzv;
    private final int zzzw;
    private final zzhj zzzx;
    private final zzgm zzzy;
    private final zziq<?, ?> zzzz;

    private zzhg(int[] iArr, Object[] objArr, int i, int i2, zzhc zzhc, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzhj zzhj, zzgm zzgm, zziq<?, ?> zziq, zzfh<?> zzfh, zzgx zzgx) {
        this.zzzl = iArr;
        this.zzzm = objArr;
        this.zzzn = i;
        this.zzzo = i2;
        this.zzzr = zzhc instanceof zzft;
        this.zzzs = z;
        this.zzzq = zzfh != null && zzfh.zzf(zzhc);
        this.zzzt = false;
        this.zzzu = iArr2;
        this.zzzv = i3;
        this.zzzw = i4;
        this.zzzx = zzhj;
        this.zzzy = zzgm;
        this.zzzz = zziq;
        this.zzaaa = zzfh;
        this.zzzp = zzhc;
        this.zzaab = zzgx;
    }

    private static boolean zzaz(int i) {
        return (i & 536870912) != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x03ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.firebase_auth.zzhg<T> zza(java.lang.Class<T> r37, com.google.android.gms.internal.firebase_auth.zzha r38, com.google.android.gms.internal.firebase_auth.zzhj r39, com.google.android.gms.internal.firebase_auth.zzgm r40, com.google.android.gms.internal.firebase_auth.zziq<?, ?> r41, com.google.android.gms.internal.firebase_auth.zzfh<?> r42, com.google.android.gms.internal.firebase_auth.zzgx r43) {
        /*
            r0 = r38
            boolean r1 = r0 instanceof com.google.android.gms.internal.firebase_auth.zzhq
            if (r1 == 0) goto L_0x0441
            com.google.android.gms.internal.firebase_auth.zzhq r0 = (com.google.android.gms.internal.firebase_auth.zzhq) r0
            int r1 = r0.zzin()
            int r2 = com.google.android.gms.internal.firebase_auth.zzft.zze.zzxo
            r3 = 0
            r4 = 1
            if (r1 != r2) goto L_0x0014
            r11 = 1
            goto L_0x0015
        L_0x0014:
            r11 = 0
        L_0x0015:
            java.lang.String r1 = r0.zziw()
            int r2 = r1.length()
            char r5 = r1.charAt(r3)
            r7 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r7) goto L_0x003f
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r8 = r5
            r5 = 1
            r9 = 13
        L_0x002c:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r7) goto L_0x003c
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r8 = r8 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x002c
        L_0x003c:
            int r5 = r5 << r9
            r5 = r5 | r8
            goto L_0x0040
        L_0x003f:
            r10 = 1
        L_0x0040:
            int r8 = r10 + 1
            char r9 = r1.charAt(r10)
            if (r9 < r7) goto L_0x005f
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x004c:
            int r12 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x005c
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r10
            r9 = r9 | r8
            int r10 = r10 + 13
            r8 = r12
            goto L_0x004c
        L_0x005c:
            int r8 = r8 << r10
            r9 = r9 | r8
            goto L_0x0060
        L_0x005f:
            r12 = r8
        L_0x0060:
            if (r9 != 0) goto L_0x006e
            int[] r8 = zzzj
            r16 = r8
            r8 = 0
            r9 = 0
            r10 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            goto L_0x01a1
        L_0x006e:
            int r8 = r12 + 1
            char r9 = r1.charAt(r12)
            if (r9 < r7) goto L_0x008e
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x007a:
            int r12 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x008a
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r10
            r9 = r9 | r8
            int r10 = r10 + 13
            r8 = r12
            goto L_0x007a
        L_0x008a:
            int r8 = r8 << r10
            r8 = r8 | r9
            r9 = r8
            goto L_0x008f
        L_0x008e:
            r12 = r8
        L_0x008f:
            int r8 = r12 + 1
            char r10 = r1.charAt(r12)
            if (r10 < r7) goto L_0x00ae
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x009b:
            int r13 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x00ab
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r12
            r10 = r10 | r8
            int r12 = r12 + 13
            r8 = r13
            goto L_0x009b
        L_0x00ab:
            int r8 = r8 << r12
            r10 = r10 | r8
            goto L_0x00af
        L_0x00ae:
            r13 = r8
        L_0x00af:
            int r8 = r13 + 1
            char r12 = r1.charAt(r13)
            if (r12 < r7) goto L_0x00cf
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00bb:
            int r14 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x00cb
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r13
            r12 = r12 | r8
            int r13 = r13 + 13
            r8 = r14
            goto L_0x00bb
        L_0x00cb:
            int r8 = r8 << r13
            r8 = r8 | r12
            r12 = r8
            goto L_0x00d0
        L_0x00cf:
            r14 = r8
        L_0x00d0:
            int r8 = r14 + 1
            char r13 = r1.charAt(r14)
            if (r13 < r7) goto L_0x00f0
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00dc:
            int r15 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x00ec
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r14
            r13 = r13 | r8
            int r14 = r14 + 13
            r8 = r15
            goto L_0x00dc
        L_0x00ec:
            int r8 = r8 << r14
            r8 = r8 | r13
            r13 = r8
            goto L_0x00f1
        L_0x00f0:
            r15 = r8
        L_0x00f1:
            int r8 = r15 + 1
            char r14 = r1.charAt(r15)
            if (r14 < r7) goto L_0x0113
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x00fd:
            int r16 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x010e
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r15
            r14 = r14 | r8
            int r15 = r15 + 13
            r8 = r16
            goto L_0x00fd
        L_0x010e:
            int r8 = r8 << r15
            r8 = r8 | r14
            r14 = r8
            r8 = r16
        L_0x0113:
            int r15 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x0136
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x011f:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x0131
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r8 = r8 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x011f
        L_0x0131:
            int r15 = r15 << r16
            r8 = r8 | r15
            r15 = r17
        L_0x0136:
            int r16 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x0162
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r17 = 13
            r36 = r16
            r16 = r15
            r15 = r36
        L_0x0148:
            int r18 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x015b
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r17
            r16 = r16 | r15
            int r17 = r17 + 13
            r15 = r18
            goto L_0x0148
        L_0x015b:
            int r15 = r15 << r17
            r15 = r16 | r15
            r3 = r18
            goto L_0x0164
        L_0x0162:
            r3 = r16
        L_0x0164:
            int r16 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r7) goto L_0x018f
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r17 = 13
            r36 = r16
            r16 = r3
            r3 = r36
        L_0x0176:
            int r18 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r7) goto L_0x0189
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r17
            r16 = r16 | r3
            int r17 = r17 + 13
            r3 = r18
            goto L_0x0176
        L_0x0189:
            int r3 = r3 << r17
            r3 = r16 | r3
            r16 = r18
        L_0x018f:
            int r17 = r3 + r8
            int r15 = r17 + r15
            int[] r15 = new int[r15]
            int r17 = r9 << 1
            int r10 = r17 + r10
            r36 = r15
            r15 = r10
            r10 = r12
            r12 = r16
            r16 = r36
        L_0x01a1:
            sun.misc.Unsafe r6 = zzzk
            java.lang.Object[] r17 = r0.zzix()
            com.google.android.gms.internal.firebase_auth.zzhc r18 = r0.zzip()
            java.lang.Class r7 = r18.getClass()
            r22 = r12
            int r12 = r14 * 3
            int[] r12 = new int[r12]
            int r14 = r14 << r4
            java.lang.Object[] r14 = new java.lang.Object[r14]
            int r18 = r3 + r8
            r20 = r15
            r23 = r18
            r8 = r22
            r15 = 0
            r19 = 0
            r22 = r3
        L_0x01c5:
            if (r8 >= r2) goto L_0x0413
            int r24 = r8 + 1
            char r8 = r1.charAt(r8)
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r4) goto L_0x01f9
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r25 = 13
            r36 = r24
            r24 = r8
            r8 = r36
        L_0x01dc:
            int r26 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r4) goto L_0x01f2
            r4 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r25
            r24 = r24 | r4
            int r25 = r25 + 13
            r8 = r26
            r4 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01dc
        L_0x01f2:
            int r4 = r8 << r25
            r8 = r24 | r4
            r4 = r26
            goto L_0x01fb
        L_0x01f9:
            r4 = r24
        L_0x01fb:
            int r24 = r4 + 1
            char r4 = r1.charAt(r4)
            r27 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r2) goto L_0x022f
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r25 = 13
            r36 = r24
            r24 = r4
            r4 = r36
        L_0x0212:
            int r26 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r2) goto L_0x0228
            r2 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r25
            r24 = r24 | r2
            int r25 = r25 + 13
            r4 = r26
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0212
        L_0x0228:
            int r2 = r4 << r25
            r4 = r24 | r2
            r2 = r26
            goto L_0x0231
        L_0x022f:
            r2 = r24
        L_0x0231:
            r28 = r3
            r3 = r4 & 255(0xff, float:3.57E-43)
            r29 = r11
            r11 = r4 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x0240
            int r11 = r15 + 1
            r16[r15] = r19
            r15 = r11
        L_0x0240:
            r11 = 51
            r30 = r15
            if (r3 < r11) goto L_0x02e4
            int r11 = r2 + 1
            char r2 = r1.charAt(r2)
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r15) goto L_0x026f
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r24 = 13
        L_0x0255:
            int r25 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r15) goto L_0x026a
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r24
            r2 = r2 | r11
            int r24 = r24 + 13
            r11 = r25
            r15 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0255
        L_0x026a:
            int r11 = r11 << r24
            r2 = r2 | r11
            r11 = r25
        L_0x026f:
            int r15 = r3 + -51
            r31 = r11
            r11 = 9
            if (r15 == r11) goto L_0x0296
            r11 = 17
            if (r15 != r11) goto L_0x027c
            goto L_0x0296
        L_0x027c:
            r11 = 12
            if (r15 != r11) goto L_0x0292
            r11 = r5 & 1
            r15 = 1
            if (r11 != r15) goto L_0x0292
            int r11 = r19 / 3
            int r11 = r11 << r15
            int r11 = r11 + r15
            int r15 = r20 + 1
            r20 = r17[r20]
            r14[r11] = r20
            r24 = r15
            goto L_0x0294
        L_0x0292:
            r24 = r20
        L_0x0294:
            r15 = 1
            goto L_0x02a1
        L_0x0296:
            int r11 = r19 / 3
            r15 = 1
            int r11 = r11 << r15
            int r11 = r11 + r15
            int r24 = r20 + 1
            r20 = r17[r20]
            r14[r11] = r20
        L_0x02a1:
            int r2 = r2 << r15
            r11 = r17[r2]
            boolean r15 = r11 instanceof java.lang.reflect.Field
            if (r15 == 0) goto L_0x02ad
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
        L_0x02aa:
            r32 = r10
            goto L_0x02b6
        L_0x02ad:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zza(r7, r11)
            r17[r2] = r11
            goto L_0x02aa
        L_0x02b6:
            long r10 = r6.objectFieldOffset(r11)
            int r10 = (int) r10
            int r2 = r2 + 1
            r11 = r17[r2]
            boolean r15 = r11 instanceof java.lang.reflect.Field
            if (r15 == 0) goto L_0x02c8
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
        L_0x02c5:
            r33 = r10
            goto L_0x02d1
        L_0x02c8:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zza(r7, r11)
            r17[r2] = r11
            goto L_0x02c5
        L_0x02d1:
            long r10 = r6.objectFieldOffset(r11)
            int r2 = (int) r10
            r34 = r13
            r35 = r14
            r20 = r24
            r13 = r31
            r11 = r33
            r14 = r2
            r2 = 0
            goto L_0x03dd
        L_0x02e4:
            r32 = r10
            int r10 = r20 + 1
            r11 = r17[r20]
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zza(r7, r11)
            r15 = 9
            if (r3 == r15) goto L_0x0366
            r15 = 17
            if (r3 != r15) goto L_0x02fa
            goto L_0x0366
        L_0x02fa:
            r15 = 27
            if (r3 == r15) goto L_0x0354
            r15 = 49
            if (r3 != r15) goto L_0x0303
            goto L_0x0354
        L_0x0303:
            r15 = 12
            if (r3 == r15) goto L_0x0342
            r15 = 30
            if (r3 == r15) goto L_0x0342
            r15 = 44
            if (r3 != r15) goto L_0x0310
            goto L_0x0342
        L_0x0310:
            r15 = 50
            if (r3 != r15) goto L_0x033e
            int r15 = r22 + 1
            r16[r22] = r19
            int r20 = r19 / 3
            r22 = 1
            int r20 = r20 << 1
            int r22 = r10 + 1
            r10 = r17[r10]
            r14[r20] = r10
            r10 = r4 & 2048(0x800, float:2.87E-42)
            if (r10 == 0) goto L_0x0335
            int r20 = r20 + 1
            int r10 = r22 + 1
            r22 = r17[r22]
            r14[r20] = r22
            r34 = r13
            r35 = r14
            goto L_0x033b
        L_0x0335:
            r34 = r13
            r35 = r14
            r10 = r22
        L_0x033b:
            r22 = r15
            goto L_0x0375
        L_0x033e:
            r34 = r13
            r13 = 1
            goto L_0x0373
        L_0x0342:
            r15 = r5 & 1
            r34 = r13
            r13 = 1
            if (r15 != r13) goto L_0x0373
            int r15 = r19 / 3
            int r15 = r15 << r13
            int r15 = r15 + r13
            int r20 = r10 + 1
            r10 = r17[r10]
            r14[r15] = r10
            goto L_0x0361
        L_0x0354:
            r34 = r13
            r13 = 1
            int r15 = r19 / 3
            int r15 = r15 << r13
            int r15 = r15 + r13
            int r20 = r10 + 1
            r10 = r17[r10]
            r14[r15] = r10
        L_0x0361:
            r35 = r14
            r10 = r20
            goto L_0x0375
        L_0x0366:
            r34 = r13
            r13 = 1
            int r15 = r19 / 3
            int r15 = r15 << r13
            int r15 = r15 + r13
            java.lang.Class r20 = r11.getType()
            r14[r15] = r20
        L_0x0373:
            r35 = r14
        L_0x0375:
            long r13 = r6.objectFieldOffset(r11)
            int r11 = (int) r13
            r13 = r5 & 1
            r14 = 1
            if (r13 != r14) goto L_0x03c7
            r13 = 17
            if (r3 > r13) goto L_0x03c7
            int r13 = r2 + 1
            char r2 = r1.charAt(r2)
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r14) goto L_0x03a7
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0392:
            int r20 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r14) goto L_0x03a3
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r15
            r2 = r2 | r13
            int r15 = r15 + 13
            r13 = r20
            goto L_0x0392
        L_0x03a3:
            int r13 = r13 << r15
            r2 = r2 | r13
            r13 = r20
        L_0x03a7:
            r15 = 1
            int r20 = r9 << 1
            int r21 = r2 / 32
            int r20 = r20 + r21
            r14 = r17[r20]
            boolean r15 = r14 instanceof java.lang.reflect.Field
            if (r15 == 0) goto L_0x03b7
            java.lang.reflect.Field r14 = (java.lang.reflect.Field) r14
            goto L_0x03bf
        L_0x03b7:
            java.lang.String r14 = (java.lang.String) r14
            java.lang.reflect.Field r14 = zza(r7, r14)
            r17[r20] = r14
        L_0x03bf:
            long r14 = r6.objectFieldOffset(r14)
            int r14 = (int) r14
            int r2 = r2 % 32
            goto L_0x03ca
        L_0x03c7:
            r13 = r2
            r2 = 0
            r14 = 0
        L_0x03ca:
            r15 = 18
            if (r3 < r15) goto L_0x03db
            r15 = 49
            if (r3 > r15) goto L_0x03db
            int r15 = r23 + 1
            r16[r23] = r11
            r20 = r10
            r23 = r15
            goto L_0x03dd
        L_0x03db:
            r20 = r10
        L_0x03dd:
            int r10 = r19 + 1
            r12[r19] = r8
            int r8 = r10 + 1
            r15 = r4 & 512(0x200, float:7.175E-43)
            if (r15 == 0) goto L_0x03ea
            r15 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03eb
        L_0x03ea:
            r15 = 0
        L_0x03eb:
            r4 = r4 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x03f2
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03f3
        L_0x03f2:
            r4 = 0
        L_0x03f3:
            r4 = r4 | r15
            int r3 = r3 << 20
            r3 = r3 | r4
            r3 = r3 | r11
            r12[r10] = r3
            int r19 = r8 + 1
            int r2 = r2 << 20
            r2 = r2 | r14
            r12[r8] = r2
            r8 = r13
            r2 = r27
            r3 = r28
            r11 = r29
            r15 = r30
            r10 = r32
            r13 = r34
            r14 = r35
            r4 = 1
            goto L_0x01c5
        L_0x0413:
            r28 = r3
            r32 = r10
            r29 = r11
            r34 = r13
            r35 = r14
            com.google.android.gms.internal.firebase_auth.zzhg r1 = new com.google.android.gms.internal.firebase_auth.zzhg
            com.google.android.gms.internal.firebase_auth.zzhc r10 = r0.zzip()
            r0 = 0
            r5 = r1
            r6 = r12
            r7 = r35
            r8 = r32
            r9 = r34
            r12 = r0
            r13 = r16
            r14 = r28
            r15 = r18
            r16 = r39
            r17 = r40
            r18 = r41
            r19 = r42
            r20 = r43
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r1
        L_0x0441:
            com.google.android.gms.internal.firebase_auth.zzij r0 = (com.google.android.gms.internal.firebase_auth.zzij) r0
            r0.zzin()
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhg.zza(java.lang.Class, com.google.android.gms.internal.firebase_auth.zzha, com.google.android.gms.internal.firebase_auth.zzhj, com.google.android.gms.internal.firebase_auth.zzgm, com.google.android.gms.internal.firebase_auth.zziq, com.google.android.gms.internal.firebase_auth.zzfh, com.google.android.gms.internal.firebase_auth.zzgx):com.google.android.gms.internal.firebase_auth.zzhg");
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    public final T newInstance() {
        return this.zzzx.newInstance(this.zzzp);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzhy.zzd(com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6), com.google.android.gms.internal.firebase_auth.zziw.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziw.zzl(r10, r6) == com.google.android.gms.internal.firebase_auth.zziw.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6) == com.google.android.gms.internal.firebase_auth.zziw.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziw.zzl(r10, r6) == com.google.android.gms.internal.firebase_auth.zziw.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6) == com.google.android.gms.internal.firebase_auth.zziw.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6) == com.google.android.gms.internal.firebase_auth.zziw.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6) == com.google.android.gms.internal.firebase_auth.zziw.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzhy.zzd(com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6), com.google.android.gms.internal.firebase_auth.zziw.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzhy.zzd(com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6), com.google.android.gms.internal.firebase_auth.zziw.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzhy.zzd(com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6), com.google.android.gms.internal.firebase_auth.zziw.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziw.zzm(r10, r6) == com.google.android.gms.internal.firebase_auth.zziw.zzm(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6) == com.google.android.gms.internal.firebase_auth.zziw.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziw.zzl(r10, r6) == com.google.android.gms.internal.firebase_auth.zziw.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6) == com.google.android.gms.internal.firebase_auth.zziw.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziw.zzl(r10, r6) == com.google.android.gms.internal.firebase_auth.zziw.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziw.zzl(r10, r6) == com.google.android.gms.internal.firebase_auth.zziw.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.firebase_auth.zziw.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.firebase_auth.zziw.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.firebase_auth.zziw.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.firebase_auth.zziw.zzo(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzhy.zzd(com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6), com.google.android.gms.internal.firebase_auth.zziw.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzzl
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzax(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.zzay(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r4)
            int r4 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r3, r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r3, r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.firebase_auth.zziw.zzm(r10, r6)
            boolean r5 = com.google.android.gms.internal.firebase_auth.zziw.zzm(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.firebase_auth.zziw.zzn(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.firebase_auth.zziw.zzn(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.firebase_auth.zziw.zzo(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.firebase_auth.zziw.zzo(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = 0
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.firebase_auth.zziq<?, ?> r0 = r9.zzzz
            java.lang.Object r0 = r0.zzs(r10)
            com.google.android.gms.internal.firebase_auth.zziq<?, ?> r2 = r9.zzzz
            java.lang.Object r2 = r2.zzs(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzzq
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.firebase_auth.zzfh<?> r0 = r9.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfk r10 = r0.zzd(r10)
            com.google.android.gms.internal.firebase_auth.zzfh<?> r0 = r9.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfk r11 = r0.zzd(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhg.equals(java.lang.Object, java.lang.Object):boolean");
    }

    public final int hashCode(T t) {
        int length = this.zzzl.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int zzax = zzax(i2);
            int i3 = this.zzzl[i2];
            long j = (long) (1048575 & zzax);
            int i4 = 37;
            switch ((zzax & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzfv.zzk(Double.doubleToLongBits(zziw.zzo(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(zziw.zzn(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzfv.zzk(zziw.zzl(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzfv.zzk(zziw.zzl(t, j));
                    break;
                case 4:
                    i = (i * 53) + zziw.zzk(t, j);
                    break;
                case 5:
                    i = (i * 53) + zzfv.zzk(zziw.zzl(t, j));
                    break;
                case 6:
                    i = (i * 53) + zziw.zzk(t, j);
                    break;
                case 7:
                    i = (i * 53) + zzfv.zzu(zziw.zzm(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) zziw.zzp(t, j)).hashCode();
                    break;
                case 9:
                    Object zzp = zziw.zzp(t, j);
                    if (zzp != null) {
                        i4 = zzp.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + zziw.zzp(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + zziw.zzk(t, j);
                    break;
                case 12:
                    i = (i * 53) + zziw.zzk(t, j);
                    break;
                case 13:
                    i = (i * 53) + zziw.zzk(t, j);
                    break;
                case 14:
                    i = (i * 53) + zzfv.zzk(zziw.zzl(t, j));
                    break;
                case 15:
                    i = (i * 53) + zziw.zzk(t, j);
                    break;
                case 16:
                    i = (i * 53) + zzfv.zzk(zziw.zzl(t, j));
                    break;
                case 17:
                    Object zzp2 = zziw.zzp(t, j);
                    if (zzp2 != null) {
                        i4 = zzp2.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = (i * 53) + zziw.zzp(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + zziw.zzp(t, j).hashCode();
                    break;
                case 51:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzfv.zzk(Double.doubleToLongBits(zzf(t, j)));
                        break;
                    }
                case 52:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + Float.floatToIntBits(zzg(t, j));
                        break;
                    }
                case 53:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzfv.zzk(zzi(t, j));
                        break;
                    }
                case 54:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzfv.zzk(zzi(t, j));
                        break;
                    }
                case 55:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 56:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzfv.zzk(zzi(t, j));
                        break;
                    }
                case 57:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 58:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzfv.zzu(zzj(t, j));
                        break;
                    }
                case 59:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + ((String) zziw.zzp(t, j)).hashCode();
                        break;
                    }
                case 60:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zziw.zzp(t, j).hashCode();
                        break;
                    }
                case 61:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zziw.zzp(t, j).hashCode();
                        break;
                    }
                case 62:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 63:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 64:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 65:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzfv.zzk(zzi(t, j));
                        break;
                    }
                case 66:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 67:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzfv.zzk(zzi(t, j));
                        break;
                    }
                case 68:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zziw.zzp(t, j).hashCode();
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.zzzz.zzs(t).hashCode();
        return this.zzzq ? (hashCode * 53) + this.zzaaa.zzd(t).hashCode() : hashCode;
    }

    public final void zzc(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzzl.length; i += 3) {
                int zzax = zzax(i);
                long j = (long) (1048575 & zzax);
                int i2 = this.zzzl[i];
                switch ((zzax & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziw.zza((Object) t, j, zziw.zzo(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziw.zza((Object) t, j, zziw.zzn(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziw.zza((Object) t, j, zziw.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziw.zza((Object) t, j, zziw.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziw.zzb((Object) t, j, zziw.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziw.zza((Object) t, j, zziw.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziw.zzb((Object) t, j, zziw.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziw.zza((Object) t, j, zziw.zzm(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziw.zza((Object) t, j, zziw.zzp(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziw.zza((Object) t, j, zziw.zzp(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziw.zzb((Object) t, j, zziw.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziw.zzb((Object) t, j, zziw.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziw.zzb((Object) t, j, zziw.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziw.zza((Object) t, j, zziw.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziw.zzb((Object) t, j, zziw.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zziw.zza((Object) t, j, zziw.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzzy.zza(t, t2, j);
                        break;
                    case 50:
                        zzhy.zza(this.zzaab, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zziw.zza((Object) t, j, zziw.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zziw.zza((Object) t, j, zziw.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            if (!this.zzzs) {
                zzhy.zza(this.zzzz, t, t2);
                if (this.zzzq) {
                    zzhy.zza(this.zzaaa, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void zza(T t, T t2, int i) {
        long zzax = (long) (zzax(i) & 1048575);
        if (zza(t2, i)) {
            Object zzp = zziw.zzp(t, zzax);
            Object zzp2 = zziw.zzp(t2, zzax);
            if (zzp == null || zzp2 == null) {
                if (zzp2 != null) {
                    zziw.zza((Object) t, zzax, zzp2);
                    zzb(t, i);
                }
                return;
            }
            zziw.zza((Object) t, zzax, zzfv.zza(zzp, zzp2));
            zzb(t, i);
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzax = zzax(i);
        int i2 = this.zzzl[i];
        long j = (long) (zzax & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zziw.zzp(t, j);
            Object zzp2 = zziw.zzp(t2, j);
            if (zzp == null || zzp2 == null) {
                if (zzp2 != null) {
                    zziw.zza((Object) t, j, zzp2);
                    zzb(t, i2, i);
                }
                return;
            }
            zziw.zza((Object) t, j, zzfv.zza(zzp, zzp2));
            zzb(t, i2, i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:412:0x09cb, code lost:
        r18 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:472:0x0aef, code lost:
        r3 = r3 + 3;
        r9 = r18;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzp(T r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            boolean r2 = r0.zzzs
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x055f
            sun.misc.Unsafe r2 = zzzk
            r12 = 0
            r13 = 0
        L_0x0016:
            int[] r14 = r0.zzzl
            int r14 = r14.length
            if (r12 >= r14) goto L_0x0557
            int r14 = r0.zzax(r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zzzl
            r3 = r3[r12]
            r14 = r14 & r8
            long r5 = (long) r14
            com.google.android.gms.internal.firebase_auth.zzfn r14 = com.google.android.gms.internal.firebase_auth.zzfn.DOUBLE_LIST_PACKED
            int r14 = r14.mo14383id()
            if (r15 < r14) goto L_0x0041
            com.google.android.gms.internal.firebase_auth.zzfn r14 = com.google.android.gms.internal.firebase_auth.zzfn.SINT64_LIST_PACKED
            int r14 = r14.mo14383id()
            if (r15 > r14) goto L_0x0041
            int[] r14 = r0.zzzl
            int r17 = r12 + 2
            r14 = r14[r17]
            r14 = r14 & r8
            goto L_0x0042
        L_0x0041:
            r14 = 0
        L_0x0042:
            switch(r15) {
                case 0: goto L_0x0544;
                case 1: goto L_0x0538;
                case 2: goto L_0x0528;
                case 3: goto L_0x0518;
                case 4: goto L_0x0508;
                case 5: goto L_0x04fc;
                case 6: goto L_0x04f0;
                case 7: goto L_0x04e4;
                case 8: goto L_0x04c4;
                case 9: goto L_0x04af;
                case 10: goto L_0x049c;
                case 11: goto L_0x048b;
                case 12: goto L_0x047a;
                case 13: goto L_0x046d;
                case 14: goto L_0x0460;
                case 15: goto L_0x044f;
                case 16: goto L_0x043e;
                case 17: goto L_0x0427;
                case 18: goto L_0x041c;
                case 19: goto L_0x0411;
                case 20: goto L_0x0406;
                case 21: goto L_0x03fb;
                case 22: goto L_0x03f0;
                case 23: goto L_0x03e5;
                case 24: goto L_0x03da;
                case 25: goto L_0x03cf;
                case 26: goto L_0x03c4;
                case 27: goto L_0x03b5;
                case 28: goto L_0x03aa;
                case 29: goto L_0x039f;
                case 30: goto L_0x0394;
                case 31: goto L_0x0389;
                case 32: goto L_0x037e;
                case 33: goto L_0x0373;
                case 34: goto L_0x0368;
                case 35: goto L_0x0347;
                case 36: goto L_0x0326;
                case 37: goto L_0x0305;
                case 38: goto L_0x02e4;
                case 39: goto L_0x02c3;
                case 40: goto L_0x02a2;
                case 41: goto L_0x0281;
                case 42: goto L_0x0260;
                case 43: goto L_0x023f;
                case 44: goto L_0x021e;
                case 45: goto L_0x01fd;
                case 46: goto L_0x01dc;
                case 47: goto L_0x01bb;
                case 48: goto L_0x019a;
                case 49: goto L_0x018b;
                case 50: goto L_0x017a;
                case 51: goto L_0x016b;
                case 52: goto L_0x015e;
                case 53: goto L_0x014d;
                case 54: goto L_0x013c;
                case 55: goto L_0x012b;
                case 56: goto L_0x011e;
                case 57: goto L_0x0111;
                case 58: goto L_0x0104;
                case 59: goto L_0x00e4;
                case 60: goto L_0x00cf;
                case 61: goto L_0x00bc;
                case 62: goto L_0x00ab;
                case 63: goto L_0x009a;
                case 64: goto L_0x008d;
                case 65: goto L_0x0080;
                case 66: goto L_0x006f;
                case 67: goto L_0x005e;
                case 68: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x0551
        L_0x0047:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x0551
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r1, r5)
            com.google.android.gms.internal.firebase_auth.zzhc r5 = (com.google.android.gms.internal.firebase_auth.zzhc) r5
            com.google.android.gms.internal.firebase_auth.zzhw r6 = r0.zzau(r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzc(r3, r5, r6)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x005e:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x0551
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzf(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x006f:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x0551
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzm(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0080:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzh(r3, r9)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x008d:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzo(r3, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x009a:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x0551
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzp(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x00ab:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x0551
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzl(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x00bc:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x0551
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r1, r5)
            com.google.android.gms.internal.firebase_auth.zzeh r5 = (com.google.android.gms.internal.firebase_auth.zzeh) r5
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzc(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x00cf:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x0551
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r1, r5)
            com.google.android.gms.internal.firebase_auth.zzhw r6 = r0.zzau(r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzc(r3, r5, r6)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x00e4:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x0551
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.firebase_auth.zzeh
            if (r6 == 0) goto L_0x00fb
            com.google.android.gms.internal.firebase_auth.zzeh r5 = (com.google.android.gms.internal.firebase_auth.zzeh) r5
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzc(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x00fb:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzb(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0104:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzc(r3, r7)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0111:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzn(r3, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x011e:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzg(r3, r9)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x012b:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x0551
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzk(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x013c:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x0551
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zze(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x014d:
            boolean r14 = r0.zza((T) r1, r3, r12)
            if (r14 == 0) goto L_0x0551
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzd(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x015e:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzb(r3, r4)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x016b:
            boolean r5 = r0.zza((T) r1, r3, r12)
            if (r5 == 0) goto L_0x0551
            r5 = 0
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzb(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x017a:
            com.google.android.gms.internal.firebase_auth.zzgx r14 = r0.zzaab
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r1, r5)
            java.lang.Object r6 = r0.zzav(r12)
            int r3 = r14.zzb(r3, r5, r6)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x018b:
            java.util.List r5 = zze(r1, r5)
            com.google.android.gms.internal.firebase_auth.zzhw r6 = r0.zzau(r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r3, r5, r6)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x019a:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzhy.zzv(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzt
            if (r6 == 0) goto L_0x01ae
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01ae:
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x01bb:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzhy.zzz(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzt
            if (r6 == 0) goto L_0x01cf
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01cf:
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x01dc:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzhy.zzab(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzt
            if (r6 == 0) goto L_0x01f0
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01f0:
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x01fd:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzhy.zzaa(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzt
            if (r6 == 0) goto L_0x0211
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0211:
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x021e:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzhy.zzw(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzt
            if (r6 == 0) goto L_0x0232
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0232:
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x023f:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzhy.zzy(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzt
            if (r6 == 0) goto L_0x0253
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0253:
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0260:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzhy.zzac(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzt
            if (r6 == 0) goto L_0x0274
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0274:
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0281:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzhy.zzaa(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzt
            if (r6 == 0) goto L_0x0295
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0295:
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x02a2:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzhy.zzab(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzt
            if (r6 == 0) goto L_0x02b6
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02b6:
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x02c3:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzhy.zzx(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzt
            if (r6 == 0) goto L_0x02d7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02d7:
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x02e4:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzhy.zzu(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzt
            if (r6 == 0) goto L_0x02f8
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02f8:
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0305:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzhy.zzt(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzt
            if (r6 == 0) goto L_0x0319
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0319:
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0326:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzhy.zzaa(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzt
            if (r6 == 0) goto L_0x033a
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x033a:
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0347:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzhy.zzab(r5)
            if (r5 <= 0) goto L_0x0551
            boolean r6 = r0.zzzt
            if (r6 == 0) goto L_0x035b
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x035b:
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0368:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzq(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0373:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzu(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x037e:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzw(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0389:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzv(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0394:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzr(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x039f:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzt(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x03aa:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x03b5:
            java.util.List r5 = zze(r1, r5)
            com.google.android.gms.internal.firebase_auth.zzhw r6 = r0.zzau(r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzc(r3, r5, r6)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x03c4:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzc(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x03cf:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzx(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x03da:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzv(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x03e5:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzw(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x03f0:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzs(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x03fb:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzp(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0406:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzo(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0411:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzv(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x041c:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzw(r3, r5, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0427:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x0551
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r1, r5)
            com.google.android.gms.internal.firebase_auth.zzhc r5 = (com.google.android.gms.internal.firebase_auth.zzhc) r5
            com.google.android.gms.internal.firebase_auth.zzhw r6 = r0.zzau(r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzc(r3, r5, r6)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x043e:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x0551
            long r5 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzf(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x044f:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x0551
            int r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzm(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0460:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzh(r3, r9)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x046d:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzo(r3, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x047a:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x0551
            int r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzp(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x048b:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x0551
            int r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzl(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x049c:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x0551
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r1, r5)
            com.google.android.gms.internal.firebase_auth.zzeh r5 = (com.google.android.gms.internal.firebase_auth.zzeh) r5
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzc(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x04af:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x0551
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r1, r5)
            com.google.android.gms.internal.firebase_auth.zzhw r6 = r0.zzau(r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhy.zzc(r3, r5, r6)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x04c4:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x0551
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.firebase_auth.zzeh
            if (r6 == 0) goto L_0x04db
            com.google.android.gms.internal.firebase_auth.zzeh r5 = (com.google.android.gms.internal.firebase_auth.zzeh) r5
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzc(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x04db:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzb(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x04e4:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzc(r3, r7)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x04f0:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzn(r3, r11)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x04fc:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzg(r3, r9)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0508:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x0551
            int r5 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzk(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0518:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x0551
            long r5 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zze(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0528:
            boolean r14 = r0.zza((T) r1, r12)
            if (r14 == 0) goto L_0x0551
            long r5 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzd(r3, r5)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0538:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x0551
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzb(r3, r4)
            int r13 = r13 + r3
            goto L_0x0551
        L_0x0544:
            boolean r5 = r0.zza((T) r1, r12)
            if (r5 == 0) goto L_0x0551
            r5 = 0
            int r3 = com.google.android.gms.internal.firebase_auth.zzfa.zzb(r3, r5)
            int r13 = r13 + r3
        L_0x0551:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x0557:
            com.google.android.gms.internal.firebase_auth.zziq<?, ?> r2 = r0.zzzz
            int r1 = zza(r2, (T) r1)
            int r13 = r13 + r1
            return r13
        L_0x055f:
            sun.misc.Unsafe r2 = zzzk
            r3 = -1
            r3 = 0
            r5 = 0
            r6 = -1
            r12 = 0
        L_0x0566:
            int[] r13 = r0.zzzl
            int r13 = r13.length
            if (r3 >= r13) goto L_0x0af7
            int r13 = r0.zzax(r3)
            int[] r14 = r0.zzzl
            r14 = r14[r3]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r16 = r13 & r15
            int r15 = r16 >>> 20
            r4 = 17
            if (r15 > r4) goto L_0x0592
            int[] r4 = r0.zzzl
            int r16 = r3 + 2
            r4 = r4[r16]
            r11 = r4 & r8
            int r16 = r4 >>> 20
            int r16 = r7 << r16
            if (r11 == r6) goto L_0x05b3
            long r9 = (long) r11
            int r12 = r2.getInt(r1, r9)
            r6 = r11
            goto L_0x05b3
        L_0x0592:
            boolean r4 = r0.zzzt
            if (r4 == 0) goto L_0x05b0
            com.google.android.gms.internal.firebase_auth.zzfn r4 = com.google.android.gms.internal.firebase_auth.zzfn.DOUBLE_LIST_PACKED
            int r4 = r4.mo14383id()
            if (r15 < r4) goto L_0x05b0
            com.google.android.gms.internal.firebase_auth.zzfn r4 = com.google.android.gms.internal.firebase_auth.zzfn.SINT64_LIST_PACKED
            int r4 = r4.mo14383id()
            if (r15 > r4) goto L_0x05b0
            int[] r4 = r0.zzzl
            int r9 = r3 + 2
            r4 = r4[r9]
            r11 = r4 & r8
            r4 = r11
            goto L_0x05b1
        L_0x05b0:
            r4 = 0
        L_0x05b1:
            r16 = 0
        L_0x05b3:
            r9 = r13 & r8
            long r9 = (long) r9
            switch(r15) {
                case 0: goto L_0x0ae0;
                case 1: goto L_0x0ad0;
                case 2: goto L_0x0abe;
                case 3: goto L_0x0aad;
                case 4: goto L_0x0a9c;
                case 5: goto L_0x0a8d;
                case 6: goto L_0x0a81;
                case 7: goto L_0x0a76;
                case 8: goto L_0x0a58;
                case 9: goto L_0x0a45;
                case 10: goto L_0x0a35;
                case 11: goto L_0x0a27;
                case 12: goto L_0x0a19;
                case 13: goto L_0x0a0e;
                case 14: goto L_0x0a02;
                case 15: goto L_0x09f4;
                case 16: goto L_0x09e6;
                case 17: goto L_0x09d2;
                case 18: goto L_0x09be;
                case 19: goto L_0x09b1;
                case 20: goto L_0x09a4;
                case 21: goto L_0x0997;
                case 22: goto L_0x098a;
                case 23: goto L_0x097d;
                case 24: goto L_0x0970;
                case 25: goto L_0x0963;
                case 26: goto L_0x0957;
                case 27: goto L_0x0946;
                case 28: goto L_0x0939;
                case 29: goto L_0x092b;
                case 30: goto L_0x091d;
                case 31: goto L_0x090f;
                case 32: goto L_0x0901;
                case 33: goto L_0x08f3;
                case 34: goto L_0x08e5;
                case 35: goto L_0x08c4;
                case 36: goto L_0x08a3;
                case 37: goto L_0x0882;
                case 38: goto L_0x0861;
                case 39: goto L_0x0840;
                case 40: goto L_0x081f;
                case 41: goto L_0x07fe;
                case 42: goto L_0x07dd;
                case 43: goto L_0x07bc;
                case 44: goto L_0x079b;
                case 45: goto L_0x077a;
                case 46: goto L_0x0759;
                case 47: goto L_0x0738;
                case 48: goto L_0x0717;
                case 49: goto L_0x0706;
                case 50: goto L_0x06f5;
                case 51: goto L_0x06e6;
                case 52: goto L_0x06d8;
                case 53: goto L_0x06c7;
                case 54: goto L_0x06b6;
                case 55: goto L_0x06a5;
                case 56: goto L_0x0696;
                case 57: goto L_0x0688;
                case 58: goto L_0x067b;
                case 59: goto L_0x065b;
                case 60: goto L_0x0646;
                case 61: goto L_0x0633;
                case 62: goto L_0x0622;
                case 63: goto L_0x0611;
                case 64: goto L_0x0603;
                case 65: goto L_0x05f4;
                case 66: goto L_0x05e3;
                case 67: goto L_0x05d2;
                case 68: goto L_0x05bb;
                default: goto L_0x05b9;
            }
        L_0x05b9:
            goto L_0x09ca
        L_0x05bb:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase_auth.zzhc r4 = (com.google.android.gms.internal.firebase_auth.zzhc) r4
            com.google.android.gms.internal.firebase_auth.zzhw r9 = r0.zzau(r3)
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzc(r14, r4, r9)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x05d2:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            long r9 = zzi(r1, r9)
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzf(r14, r9)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x05e3:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzm(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x05f4:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            r9 = 0
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzh(r14, r9)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0603:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            r4 = 0
            int r9 = com.google.android.gms.internal.firebase_auth.zzfa.zzo(r14, r4)
            int r5 = r5 + r9
            goto L_0x09ca
        L_0x0611:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzp(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0622:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzl(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0633:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase_auth.zzeh r4 = (com.google.android.gms.internal.firebase_auth.zzeh) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzc(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0646:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase_auth.zzhw r9 = r0.zzau(r3)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzc(r14, r4, r9)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x065b:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            java.lang.Object r4 = r2.getObject(r1, r9)
            boolean r9 = r4 instanceof com.google.android.gms.internal.firebase_auth.zzeh
            if (r9 == 0) goto L_0x0672
            com.google.android.gms.internal.firebase_auth.zzeh r4 = (com.google.android.gms.internal.firebase_auth.zzeh) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzc(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0672:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzb(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x067b:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzc(r14, r7)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0688:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            r4 = 0
            int r9 = com.google.android.gms.internal.firebase_auth.zzfa.zzn(r14, r4)
            int r5 = r5 + r9
            goto L_0x09ca
        L_0x0696:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            r9 = 0
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzg(r14, r9)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x06a5:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzk(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x06b6:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            long r9 = zzi(r1, r9)
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zze(r14, r9)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x06c7:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            long r9 = zzi(r1, r9)
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzd(r14, r9)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x06d8:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            r4 = 0
            int r9 = com.google.android.gms.internal.firebase_auth.zzfa.zzb(r14, r4)
            int r5 = r5 + r9
            goto L_0x09ca
        L_0x06e6:
            boolean r4 = r0.zza((T) r1, r14, r3)
            if (r4 == 0) goto L_0x09ca
            r9 = 0
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzb(r14, r9)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x06f5:
            com.google.android.gms.internal.firebase_auth.zzgx r4 = r0.zzaab
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.lang.Object r10 = r0.zzav(r3)
            int r4 = r4.zzb(r14, r9, r10)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0706:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhw r9 = r0.zzau(r3)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r14, r4, r9)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0717:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhy.zzv(r9)
            if (r9 <= 0) goto L_0x09ca
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x072b
            long r10 = (long) r4
            r2.putInt(r1, r10, r9)
        L_0x072b:
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r9)
            int r4 = r4 + r10
            int r4 = r4 + r9
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0738:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhy.zzz(r9)
            if (r9 <= 0) goto L_0x09ca
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x074c
            long r10 = (long) r4
            r2.putInt(r1, r10, r9)
        L_0x074c:
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r9)
            int r4 = r4 + r10
            int r4 = r4 + r9
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0759:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhy.zzab(r9)
            if (r9 <= 0) goto L_0x09ca
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x076d
            long r10 = (long) r4
            r2.putInt(r1, r10, r9)
        L_0x076d:
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r9)
            int r4 = r4 + r10
            int r4 = r4 + r9
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x077a:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhy.zzaa(r9)
            if (r9 <= 0) goto L_0x09ca
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x078e
            long r10 = (long) r4
            r2.putInt(r1, r10, r9)
        L_0x078e:
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r9)
            int r4 = r4 + r10
            int r4 = r4 + r9
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x079b:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhy.zzw(r9)
            if (r9 <= 0) goto L_0x09ca
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x07af
            long r10 = (long) r4
            r2.putInt(r1, r10, r9)
        L_0x07af:
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r9)
            int r4 = r4 + r10
            int r4 = r4 + r9
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x07bc:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhy.zzy(r9)
            if (r9 <= 0) goto L_0x09ca
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x07d0
            long r10 = (long) r4
            r2.putInt(r1, r10, r9)
        L_0x07d0:
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r9)
            int r4 = r4 + r10
            int r4 = r4 + r9
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x07dd:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhy.zzac(r9)
            if (r9 <= 0) goto L_0x09ca
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x07f1
            long r10 = (long) r4
            r2.putInt(r1, r10, r9)
        L_0x07f1:
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r9)
            int r4 = r4 + r10
            int r4 = r4 + r9
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x07fe:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhy.zzaa(r9)
            if (r9 <= 0) goto L_0x09ca
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x0812
            long r10 = (long) r4
            r2.putInt(r1, r10, r9)
        L_0x0812:
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r9)
            int r4 = r4 + r10
            int r4 = r4 + r9
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x081f:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhy.zzab(r9)
            if (r9 <= 0) goto L_0x09ca
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x0833
            long r10 = (long) r4
            r2.putInt(r1, r10, r9)
        L_0x0833:
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r9)
            int r4 = r4 + r10
            int r4 = r4 + r9
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0840:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhy.zzx(r9)
            if (r9 <= 0) goto L_0x09ca
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x0854
            long r10 = (long) r4
            r2.putInt(r1, r10, r9)
        L_0x0854:
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r9)
            int r4 = r4 + r10
            int r4 = r4 + r9
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0861:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhy.zzu(r9)
            if (r9 <= 0) goto L_0x09ca
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x0875
            long r10 = (long) r4
            r2.putInt(r1, r10, r9)
        L_0x0875:
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r9)
            int r4 = r4 + r10
            int r4 = r4 + r9
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0882:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhy.zzt(r9)
            if (r9 <= 0) goto L_0x09ca
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x0896
            long r10 = (long) r4
            r2.putInt(r1, r10, r9)
        L_0x0896:
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r9)
            int r4 = r4 + r10
            int r4 = r4 + r9
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x08a3:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhy.zzaa(r9)
            if (r9 <= 0) goto L_0x09ca
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x08b7
            long r10 = (long) r4
            r2.putInt(r1, r10, r9)
        L_0x08b7:
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r9)
            int r4 = r4 + r10
            int r4 = r4 + r9
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x08c4:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhy.zzab(r9)
            if (r9 <= 0) goto L_0x09ca
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x08d8
            long r10 = (long) r4
            r2.putInt(r1, r10, r9)
        L_0x08d8:
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzag(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzfa.zzai(r9)
            int r4 = r4 + r10
            int r4 = r4 + r9
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x08e5:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            r11 = 0
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzq(r14, r4, r11)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x08f3:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzu(r14, r4, r11)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0901:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzw(r14, r4, r11)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x090f:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzv(r14, r4, r11)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x091d:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzr(r14, r4, r11)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x092b:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzt(r14, r4, r11)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0939:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzd(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0946:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhw r9 = r0.zzau(r3)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzc(r14, r4, r9)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0957:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzc(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0963:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            r11 = 0
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzx(r14, r4, r11)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0970:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzv(r14, r4, r11)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x097d:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzw(r14, r4, r11)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x098a:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzs(r14, r4, r11)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0997:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzp(r14, r4, r11)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x09a4:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzo(r14, r4, r11)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x09b1:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzv(r14, r4, r11)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x09be:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzw(r14, r4, r11)
            int r5 = r5 + r4
        L_0x09ca:
            r4 = 0
        L_0x09cb:
            r9 = 0
            r10 = 0
            r18 = 0
            goto L_0x0aef
        L_0x09d2:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ca
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase_auth.zzhc r4 = (com.google.android.gms.internal.firebase_auth.zzhc) r4
            com.google.android.gms.internal.firebase_auth.zzhw r9 = r0.zzau(r3)
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzc(r14, r4, r9)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x09e6:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ca
            long r9 = r2.getLong(r1, r9)
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzf(r14, r9)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x09f4:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ca
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzm(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0a02:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ca
            r9 = 0
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzh(r14, r9)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0a0e:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ca
            r4 = 0
            int r9 = com.google.android.gms.internal.firebase_auth.zzfa.zzo(r14, r4)
            int r5 = r5 + r9
            goto L_0x09ca
        L_0x0a19:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ca
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzp(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0a27:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ca
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzl(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0a35:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ca
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase_auth.zzeh r4 = (com.google.android.gms.internal.firebase_auth.zzeh) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzc(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0a45:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ca
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase_auth.zzhw r9 = r0.zzau(r3)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhy.zzc(r14, r4, r9)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0a58:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ca
            java.lang.Object r4 = r2.getObject(r1, r9)
            boolean r9 = r4 instanceof com.google.android.gms.internal.firebase_auth.zzeh
            if (r9 == 0) goto L_0x0a6d
            com.google.android.gms.internal.firebase_auth.zzeh r4 = (com.google.android.gms.internal.firebase_auth.zzeh) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzc(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0a6d:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzb(r14, r4)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0a76:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ca
            int r4 = com.google.android.gms.internal.firebase_auth.zzfa.zzc(r14, r7)
            int r5 = r5 + r4
            goto L_0x09ca
        L_0x0a81:
            r4 = r12 & r16
            if (r4 == 0) goto L_0x09ca
            r4 = 0
            int r9 = com.google.android.gms.internal.firebase_auth.zzfa.zzn(r14, r4)
            int r5 = r5 + r9
            goto L_0x09cb
        L_0x0a8d:
            r4 = 0
            r9 = r12 & r16
            if (r9 == 0) goto L_0x09cb
            r9 = 0
            int r11 = com.google.android.gms.internal.firebase_auth.zzfa.zzg(r14, r9)
            int r5 = r5 + r11
            r18 = r9
            goto L_0x0ace
        L_0x0a9c:
            r4 = 0
            r18 = 0
            r11 = r12 & r16
            if (r11 == 0) goto L_0x0ace
            int r9 = r2.getInt(r1, r9)
            int r9 = com.google.android.gms.internal.firebase_auth.zzfa.zzk(r14, r9)
            int r5 = r5 + r9
            goto L_0x0ace
        L_0x0aad:
            r4 = 0
            r18 = 0
            r11 = r12 & r16
            if (r11 == 0) goto L_0x0ace
            long r9 = r2.getLong(r1, r9)
            int r9 = com.google.android.gms.internal.firebase_auth.zzfa.zze(r14, r9)
            int r5 = r5 + r9
            goto L_0x0ace
        L_0x0abe:
            r4 = 0
            r18 = 0
            r11 = r12 & r16
            if (r11 == 0) goto L_0x0ace
            long r9 = r2.getLong(r1, r9)
            int r9 = com.google.android.gms.internal.firebase_auth.zzfa.zzd(r14, r9)
            int r5 = r5 + r9
        L_0x0ace:
            r9 = 0
            goto L_0x0add
        L_0x0ad0:
            r4 = 0
            r18 = 0
            r9 = r12 & r16
            if (r9 == 0) goto L_0x0ace
            r9 = 0
            int r10 = com.google.android.gms.internal.firebase_auth.zzfa.zzb(r14, r9)
            int r5 = r5 + r10
        L_0x0add:
            r10 = 0
            goto L_0x0aef
        L_0x0ae0:
            r4 = 0
            r9 = 0
            r18 = 0
            r10 = r12 & r16
            if (r10 == 0) goto L_0x0add
            r10 = 0
            int r13 = com.google.android.gms.internal.firebase_auth.zzfa.zzb(r14, r10)
            int r5 = r5 + r13
        L_0x0aef:
            int r3 = r3 + 3
            r9 = r18
            r4 = 0
            r11 = 0
            goto L_0x0566
        L_0x0af7:
            com.google.android.gms.internal.firebase_auth.zziq<?, ?> r2 = r0.zzzz
            int r2 = zza(r2, (T) r1)
            int r5 = r5 + r2
            boolean r2 = r0.zzzq
            if (r2 == 0) goto L_0x0b0d
            com.google.android.gms.internal.firebase_auth.zzfh<?> r2 = r0.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfk r1 = r2.zzd(r1)
            int r1 = r1.zzgw()
            int r5 = r5 + r1
        L_0x0b0d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhg.zzp(java.lang.Object):int");
    }

    private static <UT, UB> int zza(zziq<UT, UB> zziq, T t) {
        return zziq.zzp(zziq.zzs(t));
    }

    private static <E> List<E> zze(Object obj, long j) {
        return (List) zziw.zzp(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0511  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x054f  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a27  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.firebase_auth.zzjl r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzgl()
            int r1 = com.google.android.gms.internal.firebase_auth.zzft.zze.zzxr
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0527
            com.google.android.gms.internal.firebase_auth.zziq<?, ?> r0 = r13.zzzz
            zza(r0, (T) r14, r15)
            boolean r0 = r13.zzzq
            if (r0 == 0) goto L_0x0030
            com.google.android.gms.internal.firebase_auth.zzfh<?> r0 = r13.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfk r0 = r0.zzd(r14)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0030
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0032
        L_0x0030:
            r0 = r3
            r1 = r0
        L_0x0032:
            int[] r7 = r13.zzzl
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0037:
            if (r7 < 0) goto L_0x050f
            int r8 = r13.zzax(r7)
            int[] r9 = r13.zzzl
            r9 = r9[r7]
        L_0x0041:
            if (r1 == 0) goto L_0x005f
            com.google.android.gms.internal.firebase_auth.zzfh<?> r10 = r13.zzaaa
            int r10 = r10.zza(r1)
            if (r10 <= r9) goto L_0x005f
            com.google.android.gms.internal.firebase_auth.zzfh<?> r10 = r13.zzaaa
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005d
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0041
        L_0x005d:
            r1 = r3
            goto L_0x0041
        L_0x005f:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04fc;
                case 1: goto L_0x04ec;
                case 2: goto L_0x04dc;
                case 3: goto L_0x04cc;
                case 4: goto L_0x04bc;
                case 5: goto L_0x04ac;
                case 6: goto L_0x049c;
                case 7: goto L_0x048b;
                case 8: goto L_0x047a;
                case 9: goto L_0x0465;
                case 10: goto L_0x0452;
                case 11: goto L_0x0441;
                case 12: goto L_0x0430;
                case 13: goto L_0x041f;
                case 14: goto L_0x040e;
                case 15: goto L_0x03fd;
                case 16: goto L_0x03ec;
                case 17: goto L_0x03d7;
                case 18: goto L_0x03c6;
                case 19: goto L_0x03b5;
                case 20: goto L_0x03a4;
                case 21: goto L_0x0393;
                case 22: goto L_0x0382;
                case 23: goto L_0x0371;
                case 24: goto L_0x0360;
                case 25: goto L_0x034f;
                case 26: goto L_0x033e;
                case 27: goto L_0x0329;
                case 28: goto L_0x0318;
                case 29: goto L_0x0307;
                case 30: goto L_0x02f6;
                case 31: goto L_0x02e5;
                case 32: goto L_0x02d4;
                case 33: goto L_0x02c3;
                case 34: goto L_0x02b2;
                case 35: goto L_0x02a1;
                case 36: goto L_0x0290;
                case 37: goto L_0x027f;
                case 38: goto L_0x026e;
                case 39: goto L_0x025d;
                case 40: goto L_0x024c;
                case 41: goto L_0x023b;
                case 42: goto L_0x022a;
                case 43: goto L_0x0219;
                case 44: goto L_0x0208;
                case 45: goto L_0x01f7;
                case 46: goto L_0x01e6;
                case 47: goto L_0x01d5;
                case 48: goto L_0x01c4;
                case 49: goto L_0x01af;
                case 50: goto L_0x01a4;
                case 51: goto L_0x0193;
                case 52: goto L_0x0182;
                case 53: goto L_0x0171;
                case 54: goto L_0x0160;
                case 55: goto L_0x014f;
                case 56: goto L_0x013e;
                case 57: goto L_0x012d;
                case 58: goto L_0x011c;
                case 59: goto L_0x010b;
                case 60: goto L_0x00f6;
                case 61: goto L_0x00e3;
                case 62: goto L_0x00d2;
                case 63: goto L_0x00c1;
                case 64: goto L_0x00b0;
                case 65: goto L_0x009f;
                case 66: goto L_0x008e;
                case 67: goto L_0x007d;
                case 68: goto L_0x0068;
                default: goto L_0x0066;
            }
        L_0x0066:
            goto L_0x050b
        L_0x0068:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzhw r10 = r13.zzau(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x050b
        L_0x007d:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzb(r9, r10)
            goto L_0x050b
        L_0x008e:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzi(r9, r8)
            goto L_0x050b
        L_0x009f:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050b
        L_0x00b0:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzq(r9, r8)
            goto L_0x050b
        L_0x00c1:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzr(r9, r8)
            goto L_0x050b
        L_0x00d2:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x050b
        L_0x00e3:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzeh r8 = (com.google.android.gms.internal.firebase_auth.zzeh) r8
            r15.zza(r9, r8)
            goto L_0x050b
        L_0x00f6:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzhw r10 = r13.zzau(r7)
            r15.zza(r9, r8, r10)
            goto L_0x050b
        L_0x010b:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            zza(r9, r8, r15)
            goto L_0x050b
        L_0x011c:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzj(r14, r10)
            r15.zzb(r9, r8)
            goto L_0x050b
        L_0x012d:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzj(r9, r8)
            goto L_0x050b
        L_0x013e:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050b
        L_0x014f:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzg(r9, r8)
            goto L_0x050b
        L_0x0160:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zza(r9, r10)
            goto L_0x050b
        L_0x0171:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050b
        L_0x0182:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzg(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050b
        L_0x0193:
            boolean r10 = r13.zza((T) r14, r9, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzf(r14, r10)
            r15.zza(r9, r10)
            goto L_0x050b
        L_0x01a4:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            r13.zza(r15, r9, r8, r7)
            goto L_0x050b
        L_0x01af:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhw r10 = r13.zzau(r7)
            com.google.android.gms.internal.firebase_auth.zzhy.zzb(r9, r8, r15, r10)
            goto L_0x050b
        L_0x01c4:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zze(r9, r8, r15, r4)
            goto L_0x050b
        L_0x01d5:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzj(r9, r8, r15, r4)
            goto L_0x050b
        L_0x01e6:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzg(r9, r8, r15, r4)
            goto L_0x050b
        L_0x01f7:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzl(r9, r8, r15, r4)
            goto L_0x050b
        L_0x0208:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzm(r9, r8, r15, r4)
            goto L_0x050b
        L_0x0219:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzi(r9, r8, r15, r4)
            goto L_0x050b
        L_0x022a:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzn(r9, r8, r15, r4)
            goto L_0x050b
        L_0x023b:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzk(r9, r8, r15, r4)
            goto L_0x050b
        L_0x024c:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzf(r9, r8, r15, r4)
            goto L_0x050b
        L_0x025d:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzh(r9, r8, r15, r4)
            goto L_0x050b
        L_0x026e:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzd(r9, r8, r15, r4)
            goto L_0x050b
        L_0x027f:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzc(r9, r8, r15, r4)
            goto L_0x050b
        L_0x0290:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzb(r9, r8, r15, r4)
            goto L_0x050b
        L_0x02a1:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zza(r9, r8, r15, r4)
            goto L_0x050b
        L_0x02b2:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zze(r9, r8, r15, r5)
            goto L_0x050b
        L_0x02c3:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzj(r9, r8, r15, r5)
            goto L_0x050b
        L_0x02d4:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzg(r9, r8, r15, r5)
            goto L_0x050b
        L_0x02e5:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzl(r9, r8, r15, r5)
            goto L_0x050b
        L_0x02f6:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzm(r9, r8, r15, r5)
            goto L_0x050b
        L_0x0307:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzi(r9, r8, r15, r5)
            goto L_0x050b
        L_0x0318:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzb(r9, r8, r15)
            goto L_0x050b
        L_0x0329:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhw r10 = r13.zzau(r7)
            com.google.android.gms.internal.firebase_auth.zzhy.zza(r9, r8, r15, r10)
            goto L_0x050b
        L_0x033e:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zza(r9, r8, r15)
            goto L_0x050b
        L_0x034f:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzn(r9, r8, r15, r5)
            goto L_0x050b
        L_0x0360:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzk(r9, r8, r15, r5)
            goto L_0x050b
        L_0x0371:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzf(r9, r8, r15, r5)
            goto L_0x050b
        L_0x0382:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzh(r9, r8, r15, r5)
            goto L_0x050b
        L_0x0393:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzd(r9, r8, r15, r5)
            goto L_0x050b
        L_0x03a4:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzc(r9, r8, r15, r5)
            goto L_0x050b
        L_0x03b5:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zzb(r9, r8, r15, r5)
            goto L_0x050b
        L_0x03c6:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhy.zza(r9, r8, r15, r5)
            goto L_0x050b
        L_0x03d7:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzhw r10 = r13.zzau(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x050b
        L_0x03ec:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r14, r10)
            r15.zzb(r9, r10)
            goto L_0x050b
        L_0x03fd:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r14, r10)
            r15.zzi(r9, r8)
            goto L_0x050b
        L_0x040e:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050b
        L_0x041f:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r14, r10)
            r15.zzq(r9, r8)
            goto L_0x050b
        L_0x0430:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r14, r10)
            r15.zzr(r9, r8)
            goto L_0x050b
        L_0x0441:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x050b
        L_0x0452:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzeh r8 = (com.google.android.gms.internal.firebase_auth.zzeh) r8
            r15.zza(r9, r8)
            goto L_0x050b
        L_0x0465:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzhw r10 = r13.zzau(r7)
            r15.zza(r9, r8, r10)
            goto L_0x050b
        L_0x047a:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r10)
            zza(r9, r8, r15)
            goto L_0x050b
        L_0x048b:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.firebase_auth.zziw.zzm(r14, r10)
            r15.zzb(r9, r8)
            goto L_0x050b
        L_0x049c:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r14, r10)
            r15.zzj(r9, r8)
            goto L_0x050b
        L_0x04ac:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050b
        L_0x04bc:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r14, r10)
            r15.zzg(r9, r8)
            goto L_0x050b
        L_0x04cc:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r14, r10)
            r15.zza(r9, r10)
            goto L_0x050b
        L_0x04dc:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050b
        L_0x04ec:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.firebase_auth.zziw.zzn(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050b
        L_0x04fc:
            boolean r10 = r13.zza((T) r14, r7)
            if (r10 == 0) goto L_0x050b
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.firebase_auth.zziw.zzo(r14, r10)
            r15.zza(r9, r10)
        L_0x050b:
            int r7 = r7 + -3
            goto L_0x0037
        L_0x050f:
            if (r1 == 0) goto L_0x0526
            com.google.android.gms.internal.firebase_auth.zzfh<?> r14 = r13.zzaaa
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0524
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x050f
        L_0x0524:
            r1 = r3
            goto L_0x050f
        L_0x0526:
            return
        L_0x0527:
            boolean r0 = r13.zzzs
            if (r0 == 0) goto L_0x0a42
            boolean r0 = r13.zzzq
            if (r0 == 0) goto L_0x0546
            com.google.android.gms.internal.firebase_auth.zzfh<?> r0 = r13.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfk r0 = r0.zzd(r14)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0546
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0548
        L_0x0546:
            r0 = r3
            r1 = r0
        L_0x0548:
            int[] r7 = r13.zzzl
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x054d:
            if (r1 >= r7) goto L_0x0a25
            int r9 = r13.zzax(r1)
            int[] r10 = r13.zzzl
            r10 = r10[r1]
        L_0x0557:
            if (r8 == 0) goto L_0x0575
            com.google.android.gms.internal.firebase_auth.zzfh<?> r11 = r13.zzaaa
            int r11 = r11.zza(r8)
            if (r11 > r10) goto L_0x0575
            com.google.android.gms.internal.firebase_auth.zzfh<?> r11 = r13.zzaaa
            r11.zza(r15, r8)
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x0573
            java.lang.Object r8 = r0.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x0557
        L_0x0573:
            r8 = r3
            goto L_0x0557
        L_0x0575:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0a12;
                case 1: goto L_0x0a02;
                case 2: goto L_0x09f2;
                case 3: goto L_0x09e2;
                case 4: goto L_0x09d2;
                case 5: goto L_0x09c2;
                case 6: goto L_0x09b2;
                case 7: goto L_0x09a1;
                case 8: goto L_0x0990;
                case 9: goto L_0x097b;
                case 10: goto L_0x0968;
                case 11: goto L_0x0957;
                case 12: goto L_0x0946;
                case 13: goto L_0x0935;
                case 14: goto L_0x0924;
                case 15: goto L_0x0913;
                case 16: goto L_0x0902;
                case 17: goto L_0x08ed;
                case 18: goto L_0x08dc;
                case 19: goto L_0x08cb;
                case 20: goto L_0x08ba;
                case 21: goto L_0x08a9;
                case 22: goto L_0x0898;
                case 23: goto L_0x0887;
                case 24: goto L_0x0876;
                case 25: goto L_0x0865;
                case 26: goto L_0x0854;
                case 27: goto L_0x083f;
                case 28: goto L_0x082e;
                case 29: goto L_0x081d;
                case 30: goto L_0x080c;
                case 31: goto L_0x07fb;
                case 32: goto L_0x07ea;
                case 33: goto L_0x07d9;
                case 34: goto L_0x07c8;
                case 35: goto L_0x07b7;
                case 36: goto L_0x07a6;
                case 37: goto L_0x0795;
                case 38: goto L_0x0784;
                case 39: goto L_0x0773;
                case 40: goto L_0x0762;
                case 41: goto L_0x0751;
                case 42: goto L_0x0740;
                case 43: goto L_0x072f;
                case 44: goto L_0x071e;
                case 45: goto L_0x070d;
                case 46: goto L_0x06fc;
                case 47: goto L_0x06eb;
                case 48: goto L_0x06da;
                case 49: goto L_0x06c5;
                case 50: goto L_0x06ba;
                case 51: goto L_0x06a9;
                case 52: goto L_0x0698;
                case 53: goto L_0x0687;
                case 54: goto L_0x0676;
                case 55: goto L_0x0665;
                case 56: goto L_0x0654;
                case 57: goto L_0x0643;
                case 58: goto L_0x0632;
                case 59: goto L_0x0621;
                case 60: goto L_0x060c;
                case 61: goto L_0x05f9;
                case 62: goto L_0x05e8;
                case 63: goto L_0x05d7;
                case 64: goto L_0x05c6;
                case 65: goto L_0x05b5;
                case 66: goto L_0x05a4;
                case 67: goto L_0x0593;
                case 68: goto L_0x057e;
                default: goto L_0x057c;
            }
        L_0x057c:
            goto L_0x0a21
        L_0x057e:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzhw r11 = r13.zzau(r1)
            r15.zzb(r10, r9, r11)
            goto L_0x0a21
        L_0x0593:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzb(r10, r11)
            goto L_0x0a21
        L_0x05a4:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzi(r10, r9)
            goto L_0x0a21
        L_0x05b5:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a21
        L_0x05c6:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzq(r10, r9)
            goto L_0x0a21
        L_0x05d7:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzr(r10, r9)
            goto L_0x0a21
        L_0x05e8:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0a21
        L_0x05f9:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzeh r9 = (com.google.android.gms.internal.firebase_auth.zzeh) r9
            r15.zza(r10, r9)
            goto L_0x0a21
        L_0x060c:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzhw r11 = r13.zzau(r1)
            r15.zza(r10, r9, r11)
            goto L_0x0a21
        L_0x0621:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0a21
        L_0x0632:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzj(r14, r11)
            r15.zzb(r10, r9)
            goto L_0x0a21
        L_0x0643:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzj(r10, r9)
            goto L_0x0a21
        L_0x0654:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a21
        L_0x0665:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzg(r10, r9)
            goto L_0x0a21
        L_0x0676:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0a21
        L_0x0687:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a21
        L_0x0698:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzg(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a21
        L_0x06a9:
            boolean r11 = r13.zza((T) r14, r10, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzf(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0a21
        L_0x06ba:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            r13.zza(r15, r10, r9, r1)
            goto L_0x0a21
        L_0x06c5:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhw r11 = r13.zzau(r1)
            com.google.android.gms.internal.firebase_auth.zzhy.zzb(r10, r9, r15, r11)
            goto L_0x0a21
        L_0x06da:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zze(r10, r9, r15, r4)
            goto L_0x0a21
        L_0x06eb:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzj(r10, r9, r15, r4)
            goto L_0x0a21
        L_0x06fc:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzg(r10, r9, r15, r4)
            goto L_0x0a21
        L_0x070d:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzl(r10, r9, r15, r4)
            goto L_0x0a21
        L_0x071e:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzm(r10, r9, r15, r4)
            goto L_0x0a21
        L_0x072f:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzi(r10, r9, r15, r4)
            goto L_0x0a21
        L_0x0740:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzn(r10, r9, r15, r4)
            goto L_0x0a21
        L_0x0751:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzk(r10, r9, r15, r4)
            goto L_0x0a21
        L_0x0762:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzf(r10, r9, r15, r4)
            goto L_0x0a21
        L_0x0773:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzh(r10, r9, r15, r4)
            goto L_0x0a21
        L_0x0784:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzd(r10, r9, r15, r4)
            goto L_0x0a21
        L_0x0795:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzc(r10, r9, r15, r4)
            goto L_0x0a21
        L_0x07a6:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzb(r10, r9, r15, r4)
            goto L_0x0a21
        L_0x07b7:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zza(r10, r9, r15, r4)
            goto L_0x0a21
        L_0x07c8:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zze(r10, r9, r15, r5)
            goto L_0x0a21
        L_0x07d9:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzj(r10, r9, r15, r5)
            goto L_0x0a21
        L_0x07ea:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzg(r10, r9, r15, r5)
            goto L_0x0a21
        L_0x07fb:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzl(r10, r9, r15, r5)
            goto L_0x0a21
        L_0x080c:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzm(r10, r9, r15, r5)
            goto L_0x0a21
        L_0x081d:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzi(r10, r9, r15, r5)
            goto L_0x0a21
        L_0x082e:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzb(r10, r9, r15)
            goto L_0x0a21
        L_0x083f:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhw r11 = r13.zzau(r1)
            com.google.android.gms.internal.firebase_auth.zzhy.zza(r10, r9, r15, r11)
            goto L_0x0a21
        L_0x0854:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zza(r10, r9, r15)
            goto L_0x0a21
        L_0x0865:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzn(r10, r9, r15, r5)
            goto L_0x0a21
        L_0x0876:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzk(r10, r9, r15, r5)
            goto L_0x0a21
        L_0x0887:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzf(r10, r9, r15, r5)
            goto L_0x0a21
        L_0x0898:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzh(r10, r9, r15, r5)
            goto L_0x0a21
        L_0x08a9:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzd(r10, r9, r15, r5)
            goto L_0x0a21
        L_0x08ba:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzc(r10, r9, r15, r5)
            goto L_0x0a21
        L_0x08cb:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zzb(r10, r9, r15, r5)
            goto L_0x0a21
        L_0x08dc:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhy.zza(r10, r9, r15, r5)
            goto L_0x0a21
        L_0x08ed:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzhw r11 = r13.zzau(r1)
            r15.zzb(r10, r9, r11)
            goto L_0x0a21
        L_0x0902:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r14, r11)
            r15.zzb(r10, r11)
            goto L_0x0a21
        L_0x0913:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r14, r11)
            r15.zzi(r10, r9)
            goto L_0x0a21
        L_0x0924:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a21
        L_0x0935:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r14, r11)
            r15.zzq(r10, r9)
            goto L_0x0a21
        L_0x0946:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r14, r11)
            r15.zzr(r10, r9)
            goto L_0x0a21
        L_0x0957:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0a21
        L_0x0968:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzeh r9 = (com.google.android.gms.internal.firebase_auth.zzeh) r9
            r15.zza(r10, r9)
            goto L_0x0a21
        L_0x097b:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzhw r11 = r13.zzau(r1)
            r15.zza(r10, r9, r11)
            goto L_0x0a21
        L_0x0990:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0a21
        L_0x09a1:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.firebase_auth.zziw.zzm(r14, r11)
            r15.zzb(r10, r9)
            goto L_0x0a21
        L_0x09b2:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r14, r11)
            r15.zzj(r10, r9)
            goto L_0x0a21
        L_0x09c2:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a21
        L_0x09d2:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziw.zzk(r14, r11)
            r15.zzg(r10, r9)
            goto L_0x0a21
        L_0x09e2:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0a21
        L_0x09f2:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zziw.zzl(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a21
        L_0x0a02:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.firebase_auth.zziw.zzn(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a21
        L_0x0a12:
            boolean r11 = r13.zza((T) r14, r1)
            if (r11 == 0) goto L_0x0a21
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.firebase_auth.zziw.zzo(r14, r11)
            r15.zza(r10, r11)
        L_0x0a21:
            int r1 = r1 + 3
            goto L_0x054d
        L_0x0a25:
            if (r8 == 0) goto L_0x0a3c
            com.google.android.gms.internal.firebase_auth.zzfh<?> r1 = r13.zzaaa
            r1.zza(r15, r8)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a3a
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r8 = r1
            goto L_0x0a25
        L_0x0a3a:
            r8 = r3
            goto L_0x0a25
        L_0x0a3c:
            com.google.android.gms.internal.firebase_auth.zziq<?, ?> r0 = r13.zzzz
            zza(r0, (T) r14, r15)
            return
        L_0x0a42:
            r13.zzb((T) r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhg.zza(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzjl):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x0527  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r20, com.google.android.gms.internal.firebase_auth.zzjl r21) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            boolean r3 = r0.zzzq
            if (r3 == 0) goto L_0x0021
            com.google.android.gms.internal.firebase_auth.zzfh<?> r3 = r0.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfk r3 = r3.zzd(r1)
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L_0x0021
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0023
        L_0x0021:
            r3 = 0
            r5 = 0
        L_0x0023:
            r6 = -1
            int[] r7 = r0.zzzl
            int r7 = r7.length
            sun.misc.Unsafe r8 = zzzk
            r10 = r5
            r5 = 0
            r11 = 0
        L_0x002c:
            if (r5 >= r7) goto L_0x0525
            int r12 = r0.zzax(r5)
            int[] r13 = r0.zzzl
            r13 = r13[r5]
            r14 = 267386880(0xff00000, float:2.3665827E-29)
            r14 = r14 & r12
            int r14 = r14 >>> 20
            boolean r15 = r0.zzzs
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r15 != 0) goto L_0x0061
            r15 = 17
            if (r14 > r15) goto L_0x0061
            int[] r15 = r0.zzzl
            int r17 = r5 + 2
            r15 = r15[r17]
            r9 = r15 & r16
            if (r9 == r6) goto L_0x0059
            r18 = r5
            long r4 = (long) r9
            int r11 = r8.getInt(r1, r4)
            r6 = r9
            goto L_0x005b
        L_0x0059:
            r18 = r5
        L_0x005b:
            int r4 = r15 >>> 20
            r5 = 1
            int r9 = r5 << r4
            goto L_0x0064
        L_0x0061:
            r18 = r5
            r9 = 0
        L_0x0064:
            if (r10 == 0) goto L_0x0083
            com.google.android.gms.internal.firebase_auth.zzfh<?> r4 = r0.zzaaa
            int r4 = r4.zza(r10)
            if (r4 > r13) goto L_0x0083
            com.google.android.gms.internal.firebase_auth.zzfh<?> r4 = r0.zzaaa
            r4.zza(r2, r10)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0081
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r10 = r4
            goto L_0x0064
        L_0x0081:
            r10 = 0
            goto L_0x0064
        L_0x0083:
            r4 = r12 & r16
            long r4 = (long) r4
            switch(r14) {
                case 0: goto L_0x0514;
                case 1: goto L_0x0506;
                case 2: goto L_0x04f8;
                case 3: goto L_0x04ea;
                case 4: goto L_0x04dc;
                case 5: goto L_0x04ce;
                case 6: goto L_0x04c0;
                case 7: goto L_0x04b2;
                case 8: goto L_0x04a3;
                case 9: goto L_0x0490;
                case 10: goto L_0x047f;
                case 11: goto L_0x0470;
                case 12: goto L_0x0461;
                case 13: goto L_0x0452;
                case 14: goto L_0x0443;
                case 15: goto L_0x0434;
                case 16: goto L_0x0425;
                case 17: goto L_0x0412;
                case 18: goto L_0x0400;
                case 19: goto L_0x03ee;
                case 20: goto L_0x03dc;
                case 21: goto L_0x03ca;
                case 22: goto L_0x03b8;
                case 23: goto L_0x03a6;
                case 24: goto L_0x0394;
                case 25: goto L_0x0382;
                case 26: goto L_0x0371;
                case 27: goto L_0x035c;
                case 28: goto L_0x034b;
                case 29: goto L_0x0339;
                case 30: goto L_0x0327;
                case 31: goto L_0x0315;
                case 32: goto L_0x0303;
                case 33: goto L_0x02f1;
                case 34: goto L_0x02df;
                case 35: goto L_0x02cd;
                case 36: goto L_0x02bb;
                case 37: goto L_0x02a9;
                case 38: goto L_0x0297;
                case 39: goto L_0x0285;
                case 40: goto L_0x0273;
                case 41: goto L_0x0261;
                case 42: goto L_0x024f;
                case 43: goto L_0x023d;
                case 44: goto L_0x022b;
                case 45: goto L_0x0219;
                case 46: goto L_0x0207;
                case 47: goto L_0x01f5;
                case 48: goto L_0x01e3;
                case 49: goto L_0x01ce;
                case 50: goto L_0x01c3;
                case 51: goto L_0x01b2;
                case 52: goto L_0x01a1;
                case 53: goto L_0x0190;
                case 54: goto L_0x017f;
                case 55: goto L_0x016e;
                case 56: goto L_0x015d;
                case 57: goto L_0x014c;
                case 58: goto L_0x013b;
                case 59: goto L_0x012a;
                case 60: goto L_0x0115;
                case 61: goto L_0x0102;
                case 62: goto L_0x00f2;
                case 63: goto L_0x00e2;
                case 64: goto L_0x00d2;
                case 65: goto L_0x00c2;
                case 66: goto L_0x00b2;
                case 67: goto L_0x00a2;
                case 68: goto L_0x008e;
                default: goto L_0x0089;
            }
        L_0x0089:
            r12 = r18
        L_0x008b:
            r14 = 0
            goto L_0x0521
        L_0x008e:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzhw r5 = r0.zzau(r12)
            r2.zzb(r13, r4, r5)
            goto L_0x008b
        L_0x00a2:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            long r4 = zzi(r1, r4)
            r2.zzb(r13, r4)
            goto L_0x008b
        L_0x00b2:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            int r4 = zzh(r1, r4)
            r2.zzi(r13, r4)
            goto L_0x008b
        L_0x00c2:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            long r4 = zzi(r1, r4)
            r2.zzj(r13, r4)
            goto L_0x008b
        L_0x00d2:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            int r4 = zzh(r1, r4)
            r2.zzq(r13, r4)
            goto L_0x008b
        L_0x00e2:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            int r4 = zzh(r1, r4)
            r2.zzr(r13, r4)
            goto L_0x008b
        L_0x00f2:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            int r4 = zzh(r1, r4)
            r2.zzh(r13, r4)
            goto L_0x008b
        L_0x0102:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzeh r4 = (com.google.android.gms.internal.firebase_auth.zzeh) r4
            r2.zza(r13, r4)
            goto L_0x008b
        L_0x0115:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzhw r5 = r0.zzau(r12)
            r2.zza(r13, r4, r5)
            goto L_0x008b
        L_0x012a:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            java.lang.Object r4 = r8.getObject(r1, r4)
            zza(r13, r4, r2)
            goto L_0x008b
        L_0x013b:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            boolean r4 = zzj(r1, r4)
            r2.zzb(r13, r4)
            goto L_0x008b
        L_0x014c:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            int r4 = zzh(r1, r4)
            r2.zzj(r13, r4)
            goto L_0x008b
        L_0x015d:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            long r4 = zzi(r1, r4)
            r2.zzc(r13, r4)
            goto L_0x008b
        L_0x016e:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            int r4 = zzh(r1, r4)
            r2.zzg(r13, r4)
            goto L_0x008b
        L_0x017f:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            long r4 = zzi(r1, r4)
            r2.zza(r13, r4)
            goto L_0x008b
        L_0x0190:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            long r4 = zzi(r1, r4)
            r2.zzi(r13, r4)
            goto L_0x008b
        L_0x01a1:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            float r4 = zzg(r1, r4)
            r2.zza(r13, r4)
            goto L_0x008b
        L_0x01b2:
            r12 = r18
            boolean r9 = r0.zza((T) r1, r13, r12)
            if (r9 == 0) goto L_0x008b
            double r4 = zzf(r1, r4)
            r2.zza(r13, r4)
            goto L_0x008b
        L_0x01c3:
            r12 = r18
            java.lang.Object r4 = r8.getObject(r1, r4)
            r0.zza(r2, r13, r4, r12)
            goto L_0x008b
        L_0x01ce:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhw r5 = r0.zzau(r12)
            com.google.android.gms.internal.firebase_auth.zzhy.zzb(r9, r4, r2, r5)
            goto L_0x008b
        L_0x01e3:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r13 = 1
            com.google.android.gms.internal.firebase_auth.zzhy.zze(r9, r4, r2, r13)
            goto L_0x008b
        L_0x01f5:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzj(r9, r4, r2, r13)
            goto L_0x008b
        L_0x0207:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzg(r9, r4, r2, r13)
            goto L_0x008b
        L_0x0219:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzl(r9, r4, r2, r13)
            goto L_0x008b
        L_0x022b:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzm(r9, r4, r2, r13)
            goto L_0x008b
        L_0x023d:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzi(r9, r4, r2, r13)
            goto L_0x008b
        L_0x024f:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzn(r9, r4, r2, r13)
            goto L_0x008b
        L_0x0261:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzk(r9, r4, r2, r13)
            goto L_0x008b
        L_0x0273:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzf(r9, r4, r2, r13)
            goto L_0x008b
        L_0x0285:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzh(r9, r4, r2, r13)
            goto L_0x008b
        L_0x0297:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzd(r9, r4, r2, r13)
            goto L_0x008b
        L_0x02a9:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzc(r9, r4, r2, r13)
            goto L_0x008b
        L_0x02bb:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzb(r9, r4, r2, r13)
            goto L_0x008b
        L_0x02cd:
            r12 = r18
            r13 = 1
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zza(r9, r4, r2, r13)
            goto L_0x008b
        L_0x02df:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r13 = 0
            com.google.android.gms.internal.firebase_auth.zzhy.zze(r9, r4, r2, r13)
            goto L_0x008b
        L_0x02f1:
            r12 = r18
            r13 = 0
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzj(r9, r4, r2, r13)
            goto L_0x008b
        L_0x0303:
            r12 = r18
            r13 = 0
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzg(r9, r4, r2, r13)
            goto L_0x008b
        L_0x0315:
            r12 = r18
            r13 = 0
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzl(r9, r4, r2, r13)
            goto L_0x008b
        L_0x0327:
            r12 = r18
            r13 = 0
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzm(r9, r4, r2, r13)
            goto L_0x008b
        L_0x0339:
            r12 = r18
            r13 = 0
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzi(r9, r4, r2, r13)
            goto L_0x008b
        L_0x034b:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzb(r9, r4, r2)
            goto L_0x008b
        L_0x035c:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhw r5 = r0.zzau(r12)
            com.google.android.gms.internal.firebase_auth.zzhy.zza(r9, r4, r2, r5)
            goto L_0x008b
        L_0x0371:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zza(r9, r4, r2)
            goto L_0x008b
        L_0x0382:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r14 = 0
            com.google.android.gms.internal.firebase_auth.zzhy.zzn(r9, r4, r2, r14)
            goto L_0x0521
        L_0x0394:
            r12 = r18
            r14 = 0
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzk(r9, r4, r2, r14)
            goto L_0x0521
        L_0x03a6:
            r12 = r18
            r14 = 0
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzf(r9, r4, r2, r14)
            goto L_0x0521
        L_0x03b8:
            r12 = r18
            r14 = 0
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzh(r9, r4, r2, r14)
            goto L_0x0521
        L_0x03ca:
            r12 = r18
            r14 = 0
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzd(r9, r4, r2, r14)
            goto L_0x0521
        L_0x03dc:
            r12 = r18
            r14 = 0
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzc(r9, r4, r2, r14)
            goto L_0x0521
        L_0x03ee:
            r12 = r18
            r14 = 0
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zzb(r9, r4, r2, r14)
            goto L_0x0521
        L_0x0400:
            r12 = r18
            r14 = 0
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhy.zza(r9, r4, r2, r14)
            goto L_0x0521
        L_0x0412:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzhw r5 = r0.zzau(r12)
            r2.zzb(r13, r4, r5)
            goto L_0x0521
        L_0x0425:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            long r4 = r8.getLong(r1, r4)
            r2.zzb(r13, r4)
            goto L_0x0521
        L_0x0434:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            int r4 = r8.getInt(r1, r4)
            r2.zzi(r13, r4)
            goto L_0x0521
        L_0x0443:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            long r4 = r8.getLong(r1, r4)
            r2.zzj(r13, r4)
            goto L_0x0521
        L_0x0452:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            int r4 = r8.getInt(r1, r4)
            r2.zzq(r13, r4)
            goto L_0x0521
        L_0x0461:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            int r4 = r8.getInt(r1, r4)
            r2.zzr(r13, r4)
            goto L_0x0521
        L_0x0470:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            int r4 = r8.getInt(r1, r4)
            r2.zzh(r13, r4)
            goto L_0x0521
        L_0x047f:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzeh r4 = (com.google.android.gms.internal.firebase_auth.zzeh) r4
            r2.zza(r13, r4)
            goto L_0x0521
        L_0x0490:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzhw r5 = r0.zzau(r12)
            r2.zza(r13, r4, r5)
            goto L_0x0521
        L_0x04a3:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            java.lang.Object r4 = r8.getObject(r1, r4)
            zza(r13, r4, r2)
            goto L_0x0521
        L_0x04b2:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            boolean r4 = com.google.android.gms.internal.firebase_auth.zziw.zzm(r1, r4)
            r2.zzb(r13, r4)
            goto L_0x0521
        L_0x04c0:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            int r4 = r8.getInt(r1, r4)
            r2.zzj(r13, r4)
            goto L_0x0521
        L_0x04ce:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            long r4 = r8.getLong(r1, r4)
            r2.zzc(r13, r4)
            goto L_0x0521
        L_0x04dc:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            int r4 = r8.getInt(r1, r4)
            r2.zzg(r13, r4)
            goto L_0x0521
        L_0x04ea:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            long r4 = r8.getLong(r1, r4)
            r2.zza(r13, r4)
            goto L_0x0521
        L_0x04f8:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            long r4 = r8.getLong(r1, r4)
            r2.zzi(r13, r4)
            goto L_0x0521
        L_0x0506:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            float r4 = com.google.android.gms.internal.firebase_auth.zziw.zzn(r1, r4)
            r2.zza(r13, r4)
            goto L_0x0521
        L_0x0514:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0521
            double r4 = com.google.android.gms.internal.firebase_auth.zziw.zzo(r1, r4)
            r2.zza(r13, r4)
        L_0x0521:
            int r5 = r12 + 3
            goto L_0x002c
        L_0x0525:
            if (r10 == 0) goto L_0x053c
            com.google.android.gms.internal.firebase_auth.zzfh<?> r4 = r0.zzaaa
            r4.zza(r2, r10)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x053a
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r10 = r4
            goto L_0x0525
        L_0x053a:
            r10 = 0
            goto L_0x0525
        L_0x053c:
            com.google.android.gms.internal.firebase_auth.zziq<?, ?> r3 = r0.zzzz
            zza(r3, (T) r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhg.zzb(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzjl):void");
    }

    private final <K, V> void zza(zzjl zzjl, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzjl.zza(i, this.zzaab.zzo(zzav(i2)), this.zzaab.zzk(obj));
        }
    }

    private static <UT, UB> void zza(zziq<UT, UB> zziq, T t, zzjl zzjl) throws IOException {
        zziq.zza(zziq.zzs(t), zzjl);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:166:?, code lost:
        r11.zza(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x05b5, code lost:
        if (r14 == null) goto L_0x05b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x05b7, code lost:
        r14 = r11.zzt(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x05c0, code lost:
        if (r11.zza(r14, r0) == false) goto L_0x05c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x05c2, code lost:
        r0 = r1.zzzv;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x05c6, code lost:
        if (r0 < r1.zzzw) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x05c8, code lost:
        r14 = zza((java.lang.Object) r2, r1.zzzu[r0], (UB) r14, r11);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x05d3, code lost:
        if (r14 != null) goto L_0x05d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x05d5, code lost:
        r11.zzf(r2, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x05d8, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:165:0x05b2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r18, com.google.android.gms.internal.firebase_auth.zzhr r19, com.google.android.gms.internal.firebase_auth.zzfg r20) throws java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r0 = r19
            r10 = r20
            if (r10 == 0) goto L_0x05f1
            com.google.android.gms.internal.firebase_auth.zziq<?, ?> r11 = r1.zzzz
            com.google.android.gms.internal.firebase_auth.zzfh<?> r12 = r1.zzaaa
            r13 = 0
            r3 = r13
            r14 = r3
        L_0x0011:
            int r4 = r19.zzgg()     // Catch:{ all -> 0x05d9 }
            int r5 = r1.zzzn     // Catch:{ all -> 0x05d9 }
            r6 = -1
            if (r4 < r5) goto L_0x003e
            int r5 = r1.zzzo     // Catch:{ all -> 0x05d9 }
            if (r4 > r5) goto L_0x003e
            r5 = 0
            int[] r7 = r1.zzzl     // Catch:{ all -> 0x05d9 }
            int r7 = r7.length     // Catch:{ all -> 0x05d9 }
            int r7 = r7 / 3
            int r7 = r7 + -1
        L_0x0026:
            if (r5 > r7) goto L_0x003e
            int r8 = r7 + r5
            int r8 = r8 >>> 1
            int r9 = r8 * 3
            int[] r15 = r1.zzzl     // Catch:{ all -> 0x05d9 }
            r15 = r15[r9]     // Catch:{ all -> 0x05d9 }
            if (r4 != r15) goto L_0x0036
            r6 = r9
            goto L_0x003e
        L_0x0036:
            if (r4 >= r15) goto L_0x003b
            int r7 = r8 + -1
            goto L_0x0026
        L_0x003b:
            int r5 = r8 + 1
            goto L_0x0026
        L_0x003e:
            if (r6 >= 0) goto L_0x00a8
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 != r5) goto L_0x005c
            int r0 = r1.zzzv
        L_0x0047:
            int r3 = r1.zzzw
            if (r0 >= r3) goto L_0x0056
            int[] r3 = r1.zzzu
            r3 = r3[r0]
            java.lang.Object r14 = r1.zza(r2, r3, (UB) r14, r11)
            int r0 = r0 + 1
            goto L_0x0047
        L_0x0056:
            if (r14 == 0) goto L_0x005b
            r11.zzf(r2, r14)
        L_0x005b:
            return
        L_0x005c:
            boolean r5 = r1.zzzq     // Catch:{ all -> 0x05d9 }
            if (r5 != 0) goto L_0x0062
            r5 = r13
            goto L_0x0069
        L_0x0062:
            com.google.android.gms.internal.firebase_auth.zzhc r5 = r1.zzzp     // Catch:{ all -> 0x05d9 }
            java.lang.Object r4 = r12.zza(r10, r5, r4)     // Catch:{ all -> 0x05d9 }
            r5 = r4
        L_0x0069:
            if (r5 == 0) goto L_0x0081
            if (r3 != 0) goto L_0x0071
            com.google.android.gms.internal.firebase_auth.zzfk r3 = r12.zze(r2)     // Catch:{ all -> 0x05d9 }
        L_0x0071:
            r15 = r3
            r3 = r12
            r4 = r19
            r6 = r20
            r7 = r15
            r8 = r14
            r9 = r11
            java.lang.Object r3 = r3.zza(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x05d9 }
            r14 = r3
            r3 = r15
            goto L_0x0011
        L_0x0081:
            r11.zza(r0)     // Catch:{ all -> 0x05d9 }
            if (r14 != 0) goto L_0x008b
            java.lang.Object r4 = r11.zzt(r2)     // Catch:{ all -> 0x05d9 }
            r14 = r4
        L_0x008b:
            boolean r4 = r11.zza(r14, r0)     // Catch:{ all -> 0x05d9 }
            if (r4 != 0) goto L_0x0011
            int r0 = r1.zzzv
        L_0x0093:
            int r3 = r1.zzzw
            if (r0 >= r3) goto L_0x00a2
            int[] r3 = r1.zzzu
            r3 = r3[r0]
            java.lang.Object r14 = r1.zza(r2, r3, (UB) r14, r11)
            int r0 = r0 + 1
            goto L_0x0093
        L_0x00a2:
            if (r14 == 0) goto L_0x00a7
            r11.zzf(r2, r14)
        L_0x00a7:
            return
        L_0x00a8:
            int r5 = r1.zzax(r6)     // Catch:{ all -> 0x05d9 }
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r7 = r7 & r5
            int r7 = r7 >>> 20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            switch(r7) {
                case 0: goto L_0x0585;
                case 1: goto L_0x0576;
                case 2: goto L_0x0567;
                case 3: goto L_0x0558;
                case 4: goto L_0x0549;
                case 5: goto L_0x053a;
                case 6: goto L_0x052b;
                case 7: goto L_0x051c;
                case 8: goto L_0x0514;
                case 9: goto L_0x04e3;
                case 10: goto L_0x04d4;
                case 11: goto L_0x04c5;
                case 12: goto L_0x04a3;
                case 13: goto L_0x0494;
                case 14: goto L_0x0485;
                case 15: goto L_0x0476;
                case 16: goto L_0x0467;
                case 17: goto L_0x0436;
                case 18: goto L_0x0429;
                case 19: goto L_0x041c;
                case 20: goto L_0x040f;
                case 21: goto L_0x0402;
                case 22: goto L_0x03f5;
                case 23: goto L_0x03e8;
                case 24: goto L_0x03db;
                case 25: goto L_0x03ce;
                case 26: goto L_0x03ae;
                case 27: goto L_0x039d;
                case 28: goto L_0x0390;
                case 29: goto L_0x0383;
                case 30: goto L_0x036d;
                case 31: goto L_0x0360;
                case 32: goto L_0x0353;
                case 33: goto L_0x0346;
                case 34: goto L_0x0339;
                case 35: goto L_0x032c;
                case 36: goto L_0x031f;
                case 37: goto L_0x0312;
                case 38: goto L_0x0305;
                case 39: goto L_0x02f8;
                case 40: goto L_0x02eb;
                case 41: goto L_0x02de;
                case 42: goto L_0x02d1;
                case 43: goto L_0x02c4;
                case 44: goto L_0x02af;
                case 45: goto L_0x02a2;
                case 46: goto L_0x0295;
                case 47: goto L_0x0288;
                case 48: goto L_0x027b;
                case 49: goto L_0x0269;
                case 50: goto L_0x0227;
                case 51: goto L_0x0215;
                case 52: goto L_0x0203;
                case 53: goto L_0x01f1;
                case 54: goto L_0x01df;
                case 55: goto L_0x01cd;
                case 56: goto L_0x01bb;
                case 57: goto L_0x01a9;
                case 58: goto L_0x0197;
                case 59: goto L_0x018f;
                case 60: goto L_0x015e;
                case 61: goto L_0x0150;
                case 62: goto L_0x013e;
                case 63: goto L_0x0119;
                case 64: goto L_0x0107;
                case 65: goto L_0x00f5;
                case 66: goto L_0x00e3;
                case 67: goto L_0x00d1;
                case 68: goto L_0x00bf;
                default: goto L_0x00b7;
            }
        L_0x00b7:
            if (r14 != 0) goto L_0x0595
            java.lang.Object r4 = r11.zzjo()     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0594
        L_0x00bf:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzhw r5 = r1.zzau(r6)     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r5 = r0.zzb(r5, r10)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x00d1:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            long r15 = r19.zzfw()     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x00e3:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            int r5 = r19.zzfv()     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x00f5:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            long r15 = r19.zzfu()     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0107:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            int r5 = r19.zzft()     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0119:
            int r7 = r19.zzfs()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzfy r9 = r1.zzaw(r6)     // Catch:{ zzgd -> 0x05b2 }
            if (r9 == 0) goto L_0x0130
            boolean r9 = r9.zzc(r7)     // Catch:{ zzgd -> 0x05b2 }
            if (r9 == 0) goto L_0x012a
            goto L_0x0130
        L_0x012a:
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzhy.zza(r4, r7, r14, r11)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0380
        L_0x0130:
            r5 = r5 & r8
            long r8 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r8, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x013e:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            int r5 = r19.zzfr()     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0150:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzeh r5 = r19.zzfq()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x015e:
            boolean r7 = r1.zza((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            if (r7 == 0) goto L_0x017a
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r2, r7)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzhw r9 = r1.zzau(r6)     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r9 = r0.zza(r9, r10)     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzfv.zza(r5, r9)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x018a
        L_0x017a:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzhw r5 = r1.zzau(r6)     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r5 = r0.zza(r5, r10)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
        L_0x018a:
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x018f:
            r1.zza(r2, r5, r0)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0197:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            boolean r5 = r19.zzfo()     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x01a9:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            int r5 = r19.zzfn()     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x01bb:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            long r15 = r19.zzfm()     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x01cd:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            int r5 = r19.zzfl()     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x01df:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            long r15 = r19.zzfj()     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x01f1:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            long r15 = r19.zzfk()     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0203:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            float r5 = r19.readFloat()     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0215:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            double r15 = r19.readDouble()     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Double r5 = java.lang.Double.valueOf(r15)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r7, r5)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0227:
            java.lang.Object r4 = r1.zzav(r6)     // Catch:{ zzgd -> 0x05b2 }
            int r5 = r1.zzax(r6)     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r7 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            if (r7 != 0) goto L_0x0241
            com.google.android.gms.internal.firebase_auth.zzgx r7 = r1.zzaab     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r7 = r7.zzn(r4)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r5, r7)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0258
        L_0x0241:
            com.google.android.gms.internal.firebase_auth.zzgx r8 = r1.zzaab     // Catch:{ zzgd -> 0x05b2 }
            boolean r8 = r8.zzl(r7)     // Catch:{ zzgd -> 0x05b2 }
            if (r8 == 0) goto L_0x0258
            com.google.android.gms.internal.firebase_auth.zzgx r8 = r1.zzaab     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r8 = r8.zzn(r4)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzgx r9 = r1.zzaab     // Catch:{ zzgd -> 0x05b2 }
            r9.zzb(r8, r7)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r5, r8)     // Catch:{ zzgd -> 0x05b2 }
            r7 = r8
        L_0x0258:
            com.google.android.gms.internal.firebase_auth.zzgx r5 = r1.zzaab     // Catch:{ zzgd -> 0x05b2 }
            java.util.Map r5 = r5.zzj(r7)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzgx r6 = r1.zzaab     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzgv r4 = r6.zzo(r4)     // Catch:{ zzgd -> 0x05b2 }
            r0.zza(r5, r4, r10)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0269:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzhw r6 = r1.zzau(r6)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzgm r7 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r7.zza(r2, r4)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzb(r4, r6, r10)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x027b:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzs(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0288:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzr(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0295:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzq(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x02a2:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzp(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x02af:
            com.google.android.gms.internal.firebase_auth.zzgm r7 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r8 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r5 = r7.zza(r2, r8)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzo(r5)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzfy r6 = r1.zzaw(r6)     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzhy.zza(r4, r5, r6, r14, r11)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0380
        L_0x02c4:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzn(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x02d1:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzk(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x02de:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzj(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x02eb:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzi(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x02f8:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzh(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0305:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzf(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0312:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzg(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x031f:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zze(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x032c:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzd(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0339:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzs(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0346:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzr(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0353:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzq(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0360:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzp(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x036d:
            com.google.android.gms.internal.firebase_auth.zzgm r7 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r8 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r5 = r7.zza(r2, r8)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzo(r5)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzfy r6 = r1.zzaw(r6)     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzhy.zza(r4, r5, r6, r14, r11)     // Catch:{ zzgd -> 0x05b2 }
        L_0x0380:
            r14 = r4
            goto L_0x0011
        L_0x0383:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzn(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0390:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzm(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x039d:
            com.google.android.gms.internal.firebase_auth.zzhw r4 = r1.zzau(r6)     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzgm r7 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r5 = r7.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zza(r5, r4, r10)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x03ae:
            boolean r4 = zzaz(r5)     // Catch:{ zzgd -> 0x05b2 }
            if (r4 == 0) goto L_0x03c1
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzl(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x03c1:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.readStringList(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x03ce:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzk(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x03db:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzj(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x03e8:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzi(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x03f5:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzh(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0402:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzf(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x040f:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzg(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x041c:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zze(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0429:
            com.google.android.gms.internal.firebase_auth.zzgm r4 = r1.zzzy     // Catch:{ zzgd -> 0x05b2 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzgd -> 0x05b2 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgd -> 0x05b2 }
            r0.zzd(r4)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0436:
            boolean r4 = r1.zza((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            if (r4 == 0) goto L_0x0454
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r7 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r2, r4)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzhw r6 = r1.zzau(r6)     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r6 = r0.zzb(r6, r10)     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r6 = com.google.android.gms.internal.firebase_auth.zzfv.zza(r7, r6)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0454:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzhw r7 = r1.zzau(r6)     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r7 = r0.zzb(r7, r10)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0467:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            long r7 = r19.zzfw()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0476:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            int r7 = r19.zzfv()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zzb(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0485:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            long r7 = r19.zzfu()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0494:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            int r7 = r19.zzft()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zzb(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x04a3:
            int r7 = r19.zzfs()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzfy r9 = r1.zzaw(r6)     // Catch:{ zzgd -> 0x05b2 }
            if (r9 == 0) goto L_0x04ba
            boolean r9 = r9.zzc(r7)     // Catch:{ zzgd -> 0x05b2 }
            if (r9 == 0) goto L_0x04b4
            goto L_0x04ba
        L_0x04b4:
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzhy.zza(r4, r7, r14, r11)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0380
        L_0x04ba:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zzb(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x04c5:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            int r7 = r19.zzfr()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zzb(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x04d4:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzeh r7 = r19.zzfq()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x04e3:
            boolean r4 = r1.zza((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            if (r4 == 0) goto L_0x0501
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r7 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r2, r4)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzhw r6 = r1.zzau(r6)     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r6 = r0.zza(r6, r10)     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r6 = com.google.android.gms.internal.firebase_auth.zzfv.zza(r7, r6)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r4, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0501:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zzhw r7 = r1.zzau(r6)     // Catch:{ zzgd -> 0x05b2 }
            java.lang.Object r7 = r0.zza(r7, r10)     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0514:
            r1.zza(r2, r5, r0)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x051c:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            boolean r7 = r19.zzfo()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x052b:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            int r7 = r19.zzfn()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zzb(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x053a:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            long r7 = r19.zzfm()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0549:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            int r7 = r19.zzfl()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zzb(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0558:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            long r7 = r19.zzfj()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0567:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            long r7 = r19.zzfk()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0576:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            float r7 = r19.readFloat()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0585:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzgd -> 0x05b2 }
            double r7 = r19.readDouble()     // Catch:{ zzgd -> 0x05b2 }
            com.google.android.gms.internal.firebase_auth.zziw.zza(r2, r4, r7)     // Catch:{ zzgd -> 0x05b2 }
            r1.zzb((T) r2, r6)     // Catch:{ zzgd -> 0x05b2 }
            goto L_0x0011
        L_0x0594:
            r14 = r4
        L_0x0595:
            boolean r4 = r11.zza(r14, r0)     // Catch:{ zzgd -> 0x05b2 }
            if (r4 != 0) goto L_0x0011
            int r0 = r1.zzzv
        L_0x059d:
            int r3 = r1.zzzw
            if (r0 >= r3) goto L_0x05ac
            int[] r3 = r1.zzzu
            r3 = r3[r0]
            java.lang.Object r14 = r1.zza(r2, r3, (UB) r14, r11)
            int r0 = r0 + 1
            goto L_0x059d
        L_0x05ac:
            if (r14 == 0) goto L_0x05b1
            r11.zzf(r2, r14)
        L_0x05b1:
            return
        L_0x05b2:
            r11.zza(r0)     // Catch:{ all -> 0x05d9 }
            if (r14 != 0) goto L_0x05bc
            java.lang.Object r4 = r11.zzt(r2)     // Catch:{ all -> 0x05d9 }
            r14 = r4
        L_0x05bc:
            boolean r4 = r11.zza(r14, r0)     // Catch:{ all -> 0x05d9 }
            if (r4 != 0) goto L_0x0011
            int r0 = r1.zzzv
        L_0x05c4:
            int r3 = r1.zzzw
            if (r0 >= r3) goto L_0x05d3
            int[] r3 = r1.zzzu
            r3 = r3[r0]
            java.lang.Object r14 = r1.zza(r2, r3, (UB) r14, r11)
            int r0 = r0 + 1
            goto L_0x05c4
        L_0x05d3:
            if (r14 == 0) goto L_0x05d8
            r11.zzf(r2, r14)
        L_0x05d8:
            return
        L_0x05d9:
            r0 = move-exception
            int r3 = r1.zzzv
        L_0x05dc:
            int r4 = r1.zzzw
            if (r3 >= r4) goto L_0x05eb
            int[] r4 = r1.zzzu
            r4 = r4[r3]
            java.lang.Object r14 = r1.zza(r2, r4, (UB) r14, r11)
            int r3 = r3 + 1
            goto L_0x05dc
        L_0x05eb:
            if (r14 == 0) goto L_0x05f0
            r11.zzf(r2, r14)
        L_0x05f0:
            throw r0
        L_0x05f1:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhg.zza(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzhr, com.google.android.gms.internal.firebase_auth.zzfg):void");
    }

    private final zzhw zzau(int i) {
        int i2 = (i / 3) << 1;
        zzhw zzhw = (zzhw) this.zzzm[i2];
        if (zzhw != null) {
            return zzhw;
        }
        zzhw zzf = zzho.zziu().zzf((Class) this.zzzm[i2 + 1]);
        this.zzzm[i2] = zzf;
        return zzf;
    }

    private final Object zzav(int i) {
        return this.zzzm[(i / 3) << 1];
    }

    private final zzfy zzaw(int i) {
        return (zzfy) this.zzzm[((i / 3) << 1) + 1];
    }

    public final void zzf(T t) {
        for (int i = this.zzzv; i < this.zzzw; i++) {
            long zzax = (long) (zzax(this.zzzu[i]) & 1048575);
            Object zzp = zziw.zzp(t, zzax);
            if (zzp != null) {
                zziw.zza((Object) t, zzax, this.zzaab.zzm(zzp));
            }
        }
        int length = this.zzzu.length;
        for (int i2 = this.zzzw; i2 < length; i2++) {
            this.zzzy.zzb(t, (long) this.zzzu[i2]);
        }
        this.zzzz.zzf(t);
        if (this.zzzq) {
            this.zzaaa.zzf((Object) t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zziq<UT, UB> zziq) {
        int i2 = this.zzzl[i];
        Object zzp = zziw.zzp(obj, (long) (zzax(i) & 1048575));
        if (zzp == null) {
            return ub;
        }
        zzfy zzaw = zzaw(i);
        if (zzaw == null) {
            return ub;
        }
        return zza(i, i2, this.zzaab.zzj(zzp), zzaw, ub, zziq);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzfy zzfy, UB ub, zziq<UT, UB> zziq) {
        zzgv zzo = this.zzaab.zzo(zzav(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (!zzfy.zzc(((Integer) entry.getValue()).intValue())) {
                if (ub == null) {
                    ub = zziq.zzjo();
                }
                zzep zzm = zzeh.zzm(zzgu.zza(zzo, entry.getKey(), entry.getValue()));
                try {
                    zzgu.zza(zzm.zzfh(), zzo, entry.getKey(), entry.getValue());
                    zziq.zza(ub, i2, zzm.zzfg());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0104, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzq(T r14) {
        /*
            r13 = this;
            r0 = 0
            r1 = -1
            r1 = 0
            r2 = -1
            r3 = 0
        L_0x0005:
            int r4 = r13.zzzv
            r5 = 1
            if (r1 >= r4) goto L_0x0108
            int[] r4 = r13.zzzu
            r4 = r4[r1]
            int[] r6 = r13.zzzl
            r6 = r6[r4]
            int r7 = r13.zzax(r4)
            boolean r8 = r13.zzzs
            r9 = 1048575(0xfffff, float:1.469367E-39)
            if (r8 != 0) goto L_0x0035
            int[] r8 = r13.zzzl
            int r10 = r4 + 2
            r8 = r8[r10]
            r10 = r8 & r9
            int r8 = r8 >>> 20
            int r8 = r5 << r8
            if (r10 == r2) goto L_0x0036
            sun.misc.Unsafe r2 = zzzk
            long r11 = (long) r10
            int r2 = r2.getInt(r14, r11)
            r3 = r2
            r2 = r10
            goto L_0x0036
        L_0x0035:
            r8 = 0
        L_0x0036:
            r10 = 268435456(0x10000000, float:2.5243549E-29)
            r10 = r10 & r7
            if (r10 == 0) goto L_0x003d
            r10 = 1
            goto L_0x003e
        L_0x003d:
            r10 = 0
        L_0x003e:
            if (r10 == 0) goto L_0x0047
            boolean r10 = r13.zza((T) r14, r4, r3, r8)
            if (r10 != 0) goto L_0x0047
            return r0
        L_0x0047:
            r10 = 267386880(0xff00000, float:2.3665827E-29)
            r10 = r10 & r7
            int r10 = r10 >>> 20
            r11 = 9
            if (r10 == r11) goto L_0x00f3
            r11 = 17
            if (r10 == r11) goto L_0x00f3
            r8 = 27
            if (r10 == r8) goto L_0x00c7
            r8 = 60
            if (r10 == r8) goto L_0x00b6
            r8 = 68
            if (r10 == r8) goto L_0x00b6
            switch(r10) {
                case 49: goto L_0x00c7;
                case 50: goto L_0x0065;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x0104
        L_0x0065:
            com.google.android.gms.internal.firebase_auth.zzgx r6 = r13.zzaab
            r7 = r7 & r9
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r7)
            java.util.Map r6 = r6.zzk(r7)
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x00b3
            java.lang.Object r4 = r13.zzav(r4)
            com.google.android.gms.internal.firebase_auth.zzgx r7 = r13.zzaab
            com.google.android.gms.internal.firebase_auth.zzgv r4 = r7.zzo(r4)
            com.google.android.gms.internal.firebase_auth.zzjf r4 = r4.zzze
            com.google.android.gms.internal.firebase_auth.zzjk r4 = r4.zzjy()
            com.google.android.gms.internal.firebase_auth.zzjk r7 = com.google.android.gms.internal.firebase_auth.zzjk.MESSAGE
            if (r4 != r7) goto L_0x00b3
            r4 = 0
            java.util.Collection r6 = r6.values()
            java.util.Iterator r6 = r6.iterator()
        L_0x0094:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00b3
            java.lang.Object r7 = r6.next()
            if (r4 != 0) goto L_0x00ac
            com.google.android.gms.internal.firebase_auth.zzho r4 = com.google.android.gms.internal.firebase_auth.zzho.zziu()
            java.lang.Class r8 = r7.getClass()
            com.google.android.gms.internal.firebase_auth.zzhw r4 = r4.zzf(r8)
        L_0x00ac:
            boolean r7 = r4.zzq(r7)
            if (r7 != 0) goto L_0x0094
            r5 = 0
        L_0x00b3:
            if (r5 != 0) goto L_0x0104
            return r0
        L_0x00b6:
            boolean r5 = r13.zza((T) r14, r6, r4)
            if (r5 == 0) goto L_0x0104
            com.google.android.gms.internal.firebase_auth.zzhw r4 = r13.zzau(r4)
            boolean r4 = zza(r14, r7, r4)
            if (r4 != 0) goto L_0x0104
            return r0
        L_0x00c7:
            r6 = r7 & r9
            long r6 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.firebase_auth.zziw.zzp(r14, r6)
            java.util.List r6 = (java.util.List) r6
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x00f0
            com.google.android.gms.internal.firebase_auth.zzhw r4 = r13.zzau(r4)
            r7 = 0
        L_0x00db:
            int r8 = r6.size()
            if (r7 >= r8) goto L_0x00f0
            java.lang.Object r8 = r6.get(r7)
            boolean r8 = r4.zzq(r8)
            if (r8 != 0) goto L_0x00ed
            r5 = 0
            goto L_0x00f0
        L_0x00ed:
            int r7 = r7 + 1
            goto L_0x00db
        L_0x00f0:
            if (r5 != 0) goto L_0x0104
            return r0
        L_0x00f3:
            boolean r5 = r13.zza((T) r14, r4, r3, r8)
            if (r5 == 0) goto L_0x0104
            com.google.android.gms.internal.firebase_auth.zzhw r4 = r13.zzau(r4)
            boolean r4 = zza(r14, r7, r4)
            if (r4 != 0) goto L_0x0104
            return r0
        L_0x0104:
            int r1 = r1 + 1
            goto L_0x0005
        L_0x0108:
            boolean r1 = r13.zzzq
            if (r1 == 0) goto L_0x0119
            com.google.android.gms.internal.firebase_auth.zzfh<?> r1 = r13.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfk r14 = r1.zzd(r14)
            boolean r14 = r14.isInitialized()
            if (r14 != 0) goto L_0x0119
            return r0
        L_0x0119:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhg.zzq(java.lang.Object):boolean");
    }

    private static boolean zza(Object obj, int i, zzhw zzhw) {
        return zzhw.zzq(zziw.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzjl zzjl) throws IOException {
        if (obj instanceof String) {
            zzjl.zza(i, (String) obj);
        } else {
            zzjl.zza(i, (zzeh) obj);
        }
    }

    private final void zza(Object obj, int i, zzhr zzhr) throws IOException {
        if (zzaz(i)) {
            zziw.zza(obj, (long) (i & 1048575), (Object) zzhr.zzfp());
        } else if (this.zzzr) {
            zziw.zza(obj, (long) (i & 1048575), (Object) zzhr.readString());
        } else {
            zziw.zza(obj, (long) (i & 1048575), (Object) zzhr.zzfq());
        }
    }

    private final int zzax(int i) {
        return this.zzzl[i + 1];
    }

    private final int zzay(int i) {
        return this.zzzl[i + 2];
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zziw.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zziw.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zziw.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zziw.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zziw.zzp(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzzs) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzzs) {
            int zzax = zzax(i);
            long j = (long) (zzax & 1048575);
            switch ((zzax & 267386880) >>> 20) {
                case 0:
                    return zziw.zzo(t, j) != 0.0d;
                case 1:
                    return zziw.zzn(t, j) != BitmapDescriptorFactory.HUE_RED;
                case 2:
                    return zziw.zzl(t, j) != 0;
                case 3:
                    return zziw.zzl(t, j) != 0;
                case 4:
                    return zziw.zzk(t, j) != 0;
                case 5:
                    return zziw.zzl(t, j) != 0;
                case 6:
                    return zziw.zzk(t, j) != 0;
                case 7:
                    return zziw.zzm(t, j);
                case 8:
                    Object zzp = zziw.zzp(t, j);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzeh) {
                        return !zzeh.zzso.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zziw.zzp(t, j) != null;
                case 10:
                    return !zzeh.zzso.equals(zziw.zzp(t, j));
                case 11:
                    return zziw.zzk(t, j) != 0;
                case 12:
                    return zziw.zzk(t, j) != 0;
                case 13:
                    return zziw.zzk(t, j) != 0;
                case 14:
                    return zziw.zzl(t, j) != 0;
                case 15:
                    return zziw.zzk(t, j) != 0;
                case 16:
                    return zziw.zzl(t, j) != 0;
                case 17:
                    return zziw.zzp(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzay = zzay(i);
            return (zziw.zzk(t, (long) (zzay & 1048575)) & (1 << (zzay >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        if (!this.zzzs) {
            int zzay = zzay(i);
            long j = (long) (zzay & 1048575);
            zziw.zzb((Object) t, j, zziw.zzk(t, j) | (1 << (zzay >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zziw.zzk(t, (long) (zzay(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zziw.zzb((Object) t, (long) (zzay(i2) & 1048575), i);
    }
}
