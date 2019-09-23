package com.google.android.gms.internal.firebase_auth;

final class zzjd extends zzja {
    zzjd() {
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziw.zza(r1, r8) > -65) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0062, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziw.zza(r1, r8) > -65) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0104, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x012c, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(int r24, byte[] r25, int r26, int r27) {
        /*
            r23 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            r4 = r2 | r3
            int r5 = r1.length
            int r5 = r5 - r3
            r4 = r4 | r5
            r7 = 0
            if (r4 < 0) goto L_0x0160
            long r8 = (long) r2
            long r2 = (long) r3
            r4 = -19
            r10 = -16
            r11 = -62
            r12 = 16
            r13 = -96
            r14 = -32
            r15 = -1
            r6 = -65
            r16 = 1
            if (r0 == 0) goto L_0x00ad
            int r18 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r18 < 0) goto L_0x002a
            return r0
        L_0x002a:
            byte r5 = (byte) r0
            if (r5 >= r14) goto L_0x0038
            if (r5 < r11) goto L_0x0037
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_auth.zziw.zza(r1, r8)
            if (r0 <= r6) goto L_0x00af
        L_0x0037:
            return r15
        L_0x0038:
            if (r5 >= r10) goto L_0x0065
            int r0 = r0 >> 8
            int r0 = ~r0
            byte r0 = (byte) r0
            if (r0 != 0) goto L_0x0051
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_auth.zziw.zza(r1, r8)
            int r8 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
            if (r8 < 0) goto L_0x004f
            int r0 = com.google.android.gms.internal.firebase_auth.zziy.zzt(r5, r0)
            return r0
        L_0x004f:
            r8 = r19
        L_0x0051:
            if (r0 > r6) goto L_0x0064
            if (r5 != r14) goto L_0x0057
            if (r0 < r13) goto L_0x0064
        L_0x0057:
            if (r5 != r4) goto L_0x005b
            if (r0 >= r13) goto L_0x0064
        L_0x005b:
            r0 = 0
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_auth.zziw.zza(r1, r8)
            if (r0 <= r6) goto L_0x00af
        L_0x0064:
            return r15
        L_0x0065:
            int r4 = r0 >> 8
            int r4 = ~r4
            byte r4 = (byte) r4
            if (r4 != 0) goto L_0x007e
            long r19 = r8 + r16
            byte r4 = com.google.android.gms.internal.firebase_auth.zziw.zza(r1, r8)
            int r0 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x007a
            int r0 = com.google.android.gms.internal.firebase_auth.zziy.zzt(r5, r4)
            return r0
        L_0x007a:
            r8 = r19
            r0 = 0
            goto L_0x0080
        L_0x007e:
            int r0 = r0 >> r12
            byte r0 = (byte) r0
        L_0x0080:
            if (r0 != 0) goto L_0x0093
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_auth.zziw.zza(r1, r8)
            int r8 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
            if (r8 < 0) goto L_0x0091
            int r0 = com.google.android.gms.internal.firebase_auth.zziy.zze(r5, r4, r0)
            return r0
        L_0x0091:
            r8 = r19
        L_0x0093:
            if (r4 > r6) goto L_0x00ac
            int r5 = r5 << 28
            int r4 = r4 + 112
            int r5 = r5 + r4
            int r4 = r5 >> 30
            if (r4 != 0) goto L_0x00ac
            if (r0 > r6) goto L_0x00ac
            long r4 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_auth.zziw.zza(r1, r8)
            if (r0 <= r6) goto L_0x00a9
            goto L_0x00ac
        L_0x00a9:
            r19 = r4
            goto L_0x00af
        L_0x00ac:
            return r15
        L_0x00ad:
            r19 = r8
        L_0x00af:
            r0 = 0
            long r2 = r2 - r19
            int r0 = (int) r2
            if (r0 >= r12) goto L_0x00b7
            r2 = 0
            goto L_0x00ca
        L_0x00b7:
            r3 = r19
            r2 = 0
        L_0x00ba:
            if (r2 >= r0) goto L_0x00c9
            long r8 = r3 + r16
            byte r3 = com.google.android.gms.internal.firebase_auth.zziw.zza(r1, r3)
            if (r3 >= 0) goto L_0x00c5
            goto L_0x00ca
        L_0x00c5:
            int r2 = r2 + 1
            r3 = r8
            goto L_0x00ba
        L_0x00c9:
            r2 = r0
        L_0x00ca:
            int r0 = r0 - r2
            long r2 = (long) r2
            long r19 = r19 + r2
        L_0x00ce:
            r2 = r19
            r4 = 0
        L_0x00d1:
            if (r0 <= 0) goto L_0x00e3
            long r4 = r2 + r16
            byte r2 = com.google.android.gms.internal.firebase_auth.zziw.zza(r1, r2)
            if (r2 < 0) goto L_0x00e8
            int r0 = r0 + -1
            r21 = r4
            r4 = r2
            r2 = r21
            goto L_0x00d1
        L_0x00e3:
            r21 = r2
            r2 = r4
            r4 = r21
        L_0x00e8:
            if (r0 != 0) goto L_0x00eb
            return r7
        L_0x00eb:
            int r0 = r0 + -1
            if (r2 >= r14) goto L_0x0105
            if (r0 != 0) goto L_0x00f2
            return r2
        L_0x00f2:
            int r0 = r0 + -1
            if (r2 < r11) goto L_0x0104
            long r2 = r4 + r16
            byte r4 = com.google.android.gms.internal.firebase_auth.zziw.zza(r1, r4)
            if (r4 <= r6) goto L_0x00ff
            goto L_0x0104
        L_0x00ff:
            r19 = r2
            r12 = -19
            goto L_0x00ce
        L_0x0104:
            return r15
        L_0x0105:
            if (r2 >= r10) goto L_0x012d
            r3 = 2
            if (r0 >= r3) goto L_0x010f
            int r0 = zza(r1, r2, r4, r0)
            return r0
        L_0x010f:
            int r0 = r0 + -2
            long r8 = r4 + r16
            byte r3 = com.google.android.gms.internal.firebase_auth.zziw.zza(r1, r4)
            if (r3 > r6) goto L_0x012c
            if (r2 != r14) goto L_0x011d
            if (r3 < r13) goto L_0x012c
        L_0x011d:
            r12 = -19
            if (r2 != r12) goto L_0x0123
            if (r3 >= r13) goto L_0x012c
        L_0x0123:
            r2 = 0
            long r19 = r8 + r16
            byte r2 = com.google.android.gms.internal.firebase_auth.zziw.zza(r1, r8)
            if (r2 <= r6) goto L_0x00ce
        L_0x012c:
            return r15
        L_0x012d:
            r3 = 3
            r12 = -19
            if (r0 >= r3) goto L_0x0137
            int r0 = zza(r1, r2, r4, r0)
            return r0
        L_0x0137:
            int r0 = r0 + -3
            long r8 = r4 + r16
            byte r3 = com.google.android.gms.internal.firebase_auth.zziw.zza(r1, r4)
            if (r3 > r6) goto L_0x015f
            int r2 = r2 << 28
            int r3 = r3 + 112
            int r2 = r2 + r3
            int r2 = r2 >> 30
            if (r2 != 0) goto L_0x015f
            long r2 = r8 + r16
            byte r4 = com.google.android.gms.internal.firebase_auth.zziw.zza(r1, r8)
            if (r4 > r6) goto L_0x015f
            long r4 = r2 + r16
            byte r2 = com.google.android.gms.internal.firebase_auth.zziw.zza(r1, r2)
            if (r2 <= r6) goto L_0x015b
            goto L_0x015f
        L_0x015b:
            r19 = r4
            goto L_0x00ce
        L_0x015f:
            return r15
        L_0x0160:
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            int r1 = r1.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4[r7] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r26)
            r2 = 1
            r4[r2] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r27)
            r2 = 2
            r4[r2] = r1
            java.lang.String r1 = "Array length=%d, index=%d, limit=%d"
            java.lang.String r1 = java.lang.String.format(r1, r4)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjd.zzb(int, byte[], int, int):int");
    }

    /* access modifiers changed from: 0000 */
    public final String zzg(byte[] bArr, int i, int i2) throws zzgc {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (r13 < i3) {
                byte zza = zziw.zza(bArr, (long) r13);
                if (!zziz.zzd(zza)) {
                    break;
                }
                i = r13 + 1;
                int i5 = i4 + 1;
                zziz.zza(zza, cArr, i4);
                i4 = i5;
            }
            int i6 = i4;
            while (r13 < i3) {
                int i7 = r13 + 1;
                byte zza2 = zziw.zza(bArr, (long) r13);
                if (zziz.zzd(zza2)) {
                    int i8 = i6 + 1;
                    zziz.zza(zza2, cArr, i6);
                    while (i7 < i3) {
                        byte zza3 = zziw.zza(bArr, (long) i7);
                        if (!zziz.zzd(zza3)) {
                            break;
                        }
                        i7++;
                        int i9 = i8 + 1;
                        zziz.zza(zza3, cArr, i8);
                        i8 = i9;
                    }
                    r13 = i7;
                    i6 = i8;
                } else if (zziz.zze(zza2)) {
                    if (i7 < i3) {
                        int i10 = i7 + 1;
                        int i11 = i6 + 1;
                        zziz.zza(zza2, zziw.zza(bArr, (long) i7), cArr, i6);
                        r13 = i10;
                        i6 = i11;
                    } else {
                        throw zzgc.zzhy();
                    }
                } else if (zziz.zzf(zza2)) {
                    if (i7 < i3 - 1) {
                        int i12 = i7 + 1;
                        int i13 = i12 + 1;
                        int i14 = i6 + 1;
                        zziz.zza(zza2, zziw.zza(bArr, (long) i7), zziw.zza(bArr, (long) i12), cArr, i6);
                        r13 = i13;
                        i6 = i14;
                    } else {
                        throw zzgc.zzhy();
                    }
                } else if (i7 < i3 - 2) {
                    int i15 = i7 + 1;
                    byte zza4 = zziw.zza(bArr, (long) i7);
                    int i16 = i15 + 1;
                    int i17 = i16 + 1;
                    int i18 = i6 + 1;
                    zziz.zza(zza2, zza4, zziw.zza(bArr, (long) i15), zziw.zza(bArr, (long) i16), cArr, i6);
                    r13 = i17;
                    i6 = i18 + 1;
                } else {
                    throw zzgc.zzhy();
                }
            }
            return new String(cArr, 0, i6);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    /* access modifiers changed from: 0000 */
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        long j2;
        CharSequence charSequence2 = charSequence;
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        long j3 = (long) i3;
        long j4 = ((long) i4) + j3;
        int length = charSequence.length();
        if (length > i4 || bArr2.length - i4 < i3) {
            char charAt = charSequence2.charAt(length - 1);
            int i5 = i3 + i4;
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt);
            sb.append(" at index ");
            sb.append(i5);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i6 = 0;
        while (i6 < length) {
            char charAt2 = charSequence2.charAt(i6);
            if (charAt2 >= 128) {
                break;
            }
            long j5 = 1 + j;
            zziw.zza(bArr2, j, (byte) charAt2);
            i6++;
            j3 = j5;
        }
        if (i6 == length) {
            return (int) j;
        }
        while (i6 < length) {
            char charAt3 = charSequence2.charAt(i6);
            if (charAt3 < 128 && j < j4) {
                j2 = j + 1;
                zziw.zza(bArr2, j, (byte) charAt3);
            } else if (charAt3 < 2048 && j <= j4 - 2) {
                long j6 = j + 1;
                zziw.zza(bArr2, j, (byte) ((charAt3 >>> 6) | 960));
                j = j6 + 1;
                zziw.zza(bArr2, j6, (byte) ((charAt3 & '?') | 128));
                i6++;
            } else if ((charAt3 < 55296 || 57343 < charAt3) && j <= j4 - 3) {
                long j7 = j + 1;
                zziw.zza(bArr2, j, (byte) ((charAt3 >>> 12) | 480));
                long j8 = j7 + 1;
                zziw.zza(bArr2, j7, (byte) (((charAt3 >>> 6) & 63) | 128));
                j2 = j8 + 1;
                zziw.zza(bArr2, j8, (byte) ((charAt3 & '?') | 128));
            } else if (j <= j4 - 4) {
                int i7 = i6 + 1;
                if (i7 != length) {
                    char charAt4 = charSequence2.charAt(i7);
                    if (Character.isSurrogatePair(charAt3, charAt4)) {
                        int codePoint = Character.toCodePoint(charAt3, charAt4);
                        long j9 = j + 1;
                        zziw.zza(bArr2, j, (byte) ((codePoint >>> 18) | 240));
                        long j10 = j9 + 1;
                        zziw.zza(bArr2, j9, (byte) (((codePoint >>> 12) & 63) | 128));
                        long j11 = j10 + 1;
                        zziw.zza(bArr2, j10, (byte) (((codePoint >>> 6) & 63) | 128));
                        j = j11 + 1;
                        zziw.zza(bArr2, j11, (byte) ((codePoint & 63) | 128));
                        i6 = i7;
                        i6++;
                    }
                } else {
                    i7 = i6;
                }
                throw new zzjc(i7 - 1, length);
            } else {
                if (55296 <= charAt3 && charAt3 <= 57343) {
                    int i8 = i6 + 1;
                    if (i8 == length || !Character.isSurrogatePair(charAt3, charSequence2.charAt(i8))) {
                        throw new zzjc(i6, length);
                    }
                }
                StringBuilder sb2 = new StringBuilder(46);
                sb2.append("Failed writing ");
                sb2.append(charAt3);
                sb2.append(" at index ");
                sb2.append(j);
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            }
            j = j2;
            i6++;
        }
        return (int) j;
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        switch (i2) {
            case 0:
                return zziy.zzbe(i);
            case 1:
                return zziy.zzt(i, zziw.zza(bArr, j));
            case 2:
                return zziy.zze(i, (int) zziw.zza(bArr, j), (int) zziw.zza(bArr, j + 1));
            default:
                throw new AssertionError();
        }
    }
}
