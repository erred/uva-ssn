package com.google.android.gms.internal.firebase_auth;

final class zziy {
    private static final zzja zzacq;

    /* access modifiers changed from: private */
    public static int zzbe(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static boolean zzd(byte[] bArr) {
        return zzacq.zze(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: private */
    public static int zze(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    /* access modifiers changed from: private */
    public static int zzt(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static boolean zze(byte[] bArr, int i, int i2) {
        return zzacq.zze(bArr, i, i2);
    }

    public static int zzb(int i, byte[] bArr, int i2, int i3) {
        return zzacq.zzb(i, bArr, i2, i3);
    }

    /* access modifiers changed from: private */
    public static int zzf(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return zzbe(b);
            case 1:
                return zzt(b, bArr[i]);
            case 2:
                return zze((int) b, (int) bArr[i], (int) bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }

    static int zza(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new zzjc(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j = ((long) i3) + 4294967296L;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return zzacq.zzb(charSequence, bArr, i, i2);
    }

    static String zzg(byte[] bArr, int i, int i2) throws zzgc {
        return zzacq.zzg(bArr, i, i2);
    }

    static {
        zzja zzja;
        if (!(zziw.zzjs() && zziw.zzjt()) || zzee.zzex()) {
            zzja = new zzjb();
        } else {
            zzja = new zzjd();
        }
        zzacq = zzja;
    }
}
