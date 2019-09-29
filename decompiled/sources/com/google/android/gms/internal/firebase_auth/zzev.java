package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.util.Arrays;

final class zzev extends zzet {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zztc;
    private int zztd;
    private int zzte;
    private int zztf;
    private int zztg;

    private zzev(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zztg = BaseClientBuilder.API_PRIORITY_OTHER;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzte = this.pos;
        this.zztc = z;
    }

    public final int zzfi() throws IOException {
        if (zzfy()) {
            this.zztf = 0;
            return 0;
        }
        this.zztf = zzga();
        if ((this.zztf >>> 3) != 0) {
            return this.zztf;
        }
        throw zzgc.zzht();
    }

    public final void zzn(int i) throws zzgc {
        if (this.zztf != i) {
            throw zzgc.zzhu();
        }
    }

    public final boolean zzo(int i) throws IOException {
        int zzfi;
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.limit - this.pos >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        this.pos = i3 + 1;
                        if (bArr[i3] < 0) {
                            i2++;
                        }
                    }
                    throw zzgc.zzhs();
                }
                while (i2 < 10) {
                    if (zzgf() < 0) {
                        i2++;
                    }
                }
                throw zzgc.zzhs();
                return true;
            case 1:
                zzs(8);
                return true;
            case 2:
                zzs(zzga());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzs(4);
                return true;
            default:
                throw zzgc.zzhv();
        }
        do {
            zzfi = zzfi();
            if (zzfi != 0) {
            }
            zzn(((i >>> 3) << 3) | 4);
            return true;
        } while (zzo(zzfi));
        zzn(((i >>> 3) << 3) | 4);
        return true;
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzgd());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzgc());
    }

    public final long zzfj() throws IOException {
        return zzgb();
    }

    public final long zzfk() throws IOException {
        return zzgb();
    }

    public final int zzfl() throws IOException {
        return zzga();
    }

    public final long zzfm() throws IOException {
        return zzgd();
    }

    public final int zzfn() throws IOException {
        return zzgc();
    }

    public final boolean zzfo() throws IOException {
        return zzgb() != 0;
    }

    public final String readString() throws IOException {
        int zzga = zzga();
        if (zzga > 0 && zzga <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzga, zzfv.UTF_8);
            this.pos += zzga;
            return str;
        } else if (zzga == 0) {
            return "";
        } else {
            if (zzga < 0) {
                throw zzgc.zzhr();
            }
            throw zzgc.zzhq();
        }
    }

    public final String zzfp() throws IOException {
        int zzga = zzga();
        if (zzga > 0 && zzga <= this.limit - this.pos) {
            String zzg = zziy.zzg(this.buffer, this.pos, zzga);
            this.pos += zzga;
            return zzg;
        } else if (zzga == 0) {
            return "";
        } else {
            if (zzga <= 0) {
                throw zzgc.zzhr();
            }
            throw zzgc.zzhq();
        }
    }

    public final zzeh zzfq() throws IOException {
        byte[] bArr;
        int zzga = zzga();
        if (zzga > 0 && zzga <= this.limit - this.pos) {
            zzeh zzb = zzeh.zzb(this.buffer, this.pos, zzga);
            this.pos += zzga;
            return zzb;
        } else if (zzga == 0) {
            return zzeh.zzso;
        } else {
            if (zzga > 0 && zzga <= this.limit - this.pos) {
                int i = this.pos;
                this.pos += zzga;
                bArr = Arrays.copyOfRange(this.buffer, i, this.pos);
            } else if (zzga > 0) {
                throw zzgc.zzhq();
            } else if (zzga == 0) {
                bArr = zzfv.EMPTY_BYTE_ARRAY;
            } else {
                throw zzgc.zzhr();
            }
            return zzeh.zza(bArr);
        }
    }

    public final int zzfr() throws IOException {
        return zzga();
    }

    public final int zzfs() throws IOException {
        return zzga();
    }

    public final int zzft() throws IOException {
        return zzgc();
    }

    public final long zzfu() throws IOException {
        return zzgd();
    }

    public final int zzfv() throws IOException {
        return zzr(zzga());
    }

    public final long zzfw() throws IOException {
        return zza(zzgb());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        if (r1[r2] >= 0) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzga() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.limit
            if (r1 == r0) goto L_0x006d
            byte[] r1 = r5.buffer
            int r2 = r0 + 1
            byte r0 = r1[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r2
            return r0
        L_0x0011:
            int r3 = r5.limit
            int r3 = r3 - r2
            r4 = 9
            if (r3 < r4) goto L_0x006d
            int r3 = r2 + 1
            byte r2 = r1[r2]
            int r2 = r2 << 7
            r0 = r0 ^ r2
            if (r0 >= 0) goto L_0x0024
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x006a
        L_0x0024:
            int r2 = r3 + 1
            byte r3 = r1[r3]
            int r3 = r3 << 14
            r0 = r0 ^ r3
            if (r0 < 0) goto L_0x0031
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002f:
            r3 = r2
            goto L_0x006a
        L_0x0031:
            int r3 = r2 + 1
            byte r2 = r1[r2]
            int r2 = r2 << 21
            r0 = r0 ^ r2
            if (r0 >= 0) goto L_0x003f
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L_0x006a
        L_0x003f:
            int r2 = r3 + 1
            byte r3 = r1[r3]
            int r4 = r3 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r3 >= 0) goto L_0x002f
            int r3 = r2 + 1
            byte r2 = r1[r2]
            if (r2 >= 0) goto L_0x006a
            int r2 = r3 + 1
            byte r3 = r1[r3]
            if (r3 >= 0) goto L_0x002f
            int r3 = r2 + 1
            byte r2 = r1[r2]
            if (r2 >= 0) goto L_0x006a
            int r2 = r3 + 1
            byte r3 = r1[r3]
            if (r3 >= 0) goto L_0x002f
            int r3 = r2 + 1
            byte r1 = r1[r2]
            if (r1 < 0) goto L_0x006d
        L_0x006a:
            r5.pos = r3
            return r0
        L_0x006d:
            long r0 = r5.zzfx()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzev.zzga():int");
    }

    private final long zzgb() throws IOException {
        long j;
        int i;
        long j2;
        long j3;
        int i2 = this.pos;
        if (this.limit != i2) {
            byte[] bArr = this.buffer;
            int i3 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.pos = i3;
                return (long) b;
            } else if (this.limit - i3 >= 9) {
                int i4 = i3 + 1;
                byte b2 = b ^ (bArr[i3] << 7);
                if (b2 < 0) {
                    j3 = (long) (b2 ^ Byte.MIN_VALUE);
                } else {
                    int i5 = i4 + 1;
                    byte b3 = b2 ^ (bArr[i4] << Ascii.f6735SO);
                    if (b3 >= 0) {
                        long j4 = (long) (b3 ^ 16256);
                        i = i5;
                        j = j4;
                    } else {
                        i4 = i5 + 1;
                        byte b4 = b3 ^ (bArr[i5] << Ascii.NAK);
                        if (b4 < 0) {
                            j3 = (long) (b4 ^ -2080896);
                        } else {
                            long j5 = (long) b4;
                            i = i4 + 1;
                            long j6 = (((long) bArr[i4]) << 28) ^ j5;
                            if (j6 >= 0) {
                                j = j6 ^ 266354560;
                            } else {
                                int i6 = i + 1;
                                long j7 = j6 ^ (((long) bArr[i]) << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L ^ j7;
                                } else {
                                    i = i6 + 1;
                                    long j8 = j7 ^ (((long) bArr[i6]) << 42);
                                    if (j8 >= 0) {
                                        j = j8 ^ 4363953127296L;
                                    } else {
                                        i6 = i + 1;
                                        long j9 = j8 ^ (((long) bArr[i]) << 49);
                                        if (j9 < 0) {
                                            j2 = -558586000294016L ^ j9;
                                        } else {
                                            i = i6 + 1;
                                            long j10 = (j9 ^ (((long) bArr[i6]) << 56)) ^ 71499008037633920L;
                                            if (j10 < 0) {
                                                i6 = i + 1;
                                                if (((long) bArr[i]) >= 0) {
                                                    j = j10;
                                                    i = i6;
                                                }
                                            } else {
                                                j = j10;
                                            }
                                        }
                                    }
                                }
                                j = j2;
                                i = i6;
                            }
                        }
                    }
                    this.pos = i;
                    return j;
                }
                j = j3;
                i = i4;
                this.pos = i;
                return j;
            }
        }
        return zzfx();
    }

    /* access modifiers changed from: 0000 */
    public final long zzfx() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzgf = zzgf();
            j |= ((long) (zzgf & Ascii.DEL)) << i;
            if ((zzgf & 128) == 0) {
                return j;
            }
        }
        throw zzgc.zzhs();
    }

    private final int zzgc() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
        }
        throw zzgc.zzhq();
    }

    private final long zzgd() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzgc.zzhq();
    }

    public final int zzp(int i) throws zzgc {
        if (i >= 0) {
            int zzfz = i + zzfz();
            int i2 = this.zztg;
            if (zzfz <= i2) {
                this.zztg = zzfz;
                zzge();
                return i2;
            }
            throw zzgc.zzhq();
        }
        throw zzgc.zzhr();
    }

    private final void zzge() {
        this.limit += this.zztd;
        int i = this.limit - this.zzte;
        if (i > this.zztg) {
            this.zztd = i - this.zztg;
            this.limit -= this.zztd;
            return;
        }
        this.zztd = 0;
    }

    public final void zzq(int i) {
        this.zztg = i;
        zzge();
    }

    public final boolean zzfy() throws IOException {
        return this.pos == this.limit;
    }

    public final int zzfz() {
        return this.pos - this.zzte;
    }

    private final byte zzgf() throws IOException {
        if (this.pos != this.limit) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzgc.zzhq();
    }

    private final void zzs(int i) throws IOException {
        if (i >= 0 && i <= this.limit - this.pos) {
            this.pos += i;
        } else if (i < 0) {
            throw zzgc.zzhr();
        } else {
            throw zzgc.zzhq();
        }
    }
}
