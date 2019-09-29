package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

final class zzew extends zzet {
    private final byte[] buffer;
    private int pos;
    private int zztd;
    private int zztf;
    private int zztg;
    private final InputStream zzth;
    private int zzti;
    private int zztj;
    private zzex zztk;

    private zzew(InputStream inputStream, int i) {
        super();
        this.zztg = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zztk = null;
        zzfv.zza(inputStream, "input");
        this.zzth = inputStream;
        this.buffer = new byte[i];
        this.zzti = 0;
        this.pos = 0;
        this.zztj = 0;
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
                if (this.zzti - this.pos >= 10) {
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
        if (zzga > 0 && zzga <= this.zzti - this.pos) {
            String str = new String(this.buffer, this.pos, zzga, zzfv.UTF_8);
            this.pos += zzga;
            return str;
        } else if (zzga == 0) {
            return "";
        } else {
            if (zzga > this.zzti) {
                return new String(zzv(zzga), zzfv.UTF_8);
            }
            zzt(zzga);
            String str2 = new String(this.buffer, this.pos, zzga, zzfv.UTF_8);
            this.pos += zzga;
            return str2;
        }
    }

    public final String zzfp() throws IOException {
        byte[] bArr;
        int zzga = zzga();
        int i = this.pos;
        int i2 = 0;
        if (zzga <= this.zzti - i && zzga > 0) {
            bArr = this.buffer;
            this.pos = i + zzga;
            i2 = i;
        } else if (zzga == 0) {
            return "";
        } else {
            if (zzga <= this.zzti) {
                zzt(zzga);
                bArr = this.buffer;
                this.pos = zzga;
            } else {
                bArr = zzv(zzga);
            }
        }
        return zziy.zzg(bArr, i2, zzga);
    }

    public final zzeh zzfq() throws IOException {
        int zzga = zzga();
        if (zzga <= this.zzti - this.pos && zzga > 0) {
            zzeh zzb = zzeh.zzb(this.buffer, this.pos, zzga);
            this.pos += zzga;
            return zzb;
        } else if (zzga == 0) {
            return zzeh.zzso;
        } else {
            byte[] zzw = zzw(zzga);
            if (zzw != null) {
                return zzeh.zza(zzw);
            }
            int i = this.pos;
            int i2 = this.zzti - this.pos;
            this.zztj += this.zzti;
            this.pos = 0;
            this.zzti = 0;
            List<byte[]> zzx = zzx(zzga - i2);
            ArrayList arrayList = new ArrayList(zzx.size() + 1);
            arrayList.add(zzeh.zzb(this.buffer, i, i2));
            for (byte[] zza : zzx) {
                arrayList.add(zzeh.zza(zza));
            }
            return zzeh.zze(arrayList);
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
            int r1 = r5.zzti
            if (r1 == r0) goto L_0x006d
            byte[] r1 = r5.buffer
            int r2 = r0 + 1
            byte r0 = r1[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r2
            return r0
        L_0x0011:
            int r3 = r5.zzti
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzew.zzga():int");
    }

    private final long zzgb() throws IOException {
        long j;
        int i;
        long j2;
        long j3;
        int i2 = this.pos;
        if (this.zzti != i2) {
            byte[] bArr = this.buffer;
            int i3 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.pos = i3;
                return (long) b;
            } else if (this.zzti - i3 >= 9) {
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
        if (this.zzti - i < 4) {
            zzt(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
    }

    private final long zzgd() throws IOException {
        int i = this.pos;
        if (this.zzti - i < 8) {
            zzt(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final int zzp(int i) throws zzgc {
        if (i >= 0) {
            int i2 = i + this.zztj + this.pos;
            int i3 = this.zztg;
            if (i2 <= i3) {
                this.zztg = i2;
                zzge();
                return i3;
            }
            throw zzgc.zzhq();
        }
        throw zzgc.zzhr();
    }

    private final void zzge() {
        this.zzti += this.zztd;
        int i = this.zztj + this.zzti;
        if (i > this.zztg) {
            this.zztd = i - this.zztg;
            this.zzti -= this.zztd;
            return;
        }
        this.zztd = 0;
    }

    public final void zzq(int i) {
        this.zztg = i;
        zzge();
    }

    public final boolean zzfy() throws IOException {
        return this.pos == this.zzti && !zzu(1);
    }

    public final int zzfz() {
        return this.zztj + this.pos;
    }

    private final void zzt(int i) throws IOException {
        if (zzu(i)) {
            return;
        }
        if (i > (this.zzsz - this.zztj) - this.pos) {
            throw zzgc.zzhw();
        }
        throw zzgc.zzhq();
    }

    private final boolean zzu(int i) throws IOException {
        while (this.pos + i > this.zzti) {
            if (i > (this.zzsz - this.zztj) - this.pos || this.zztj + this.pos + i > this.zztg) {
                return false;
            }
            int i2 = this.pos;
            if (i2 > 0) {
                if (this.zzti > i2) {
                    System.arraycopy(this.buffer, i2, this.buffer, 0, this.zzti - i2);
                }
                this.zztj += i2;
                this.zzti -= i2;
                this.pos = 0;
            }
            int read = this.zzth.read(this.buffer, this.zzti, Math.min(this.buffer.length - this.zzti, (this.zzsz - this.zztj) - this.zzti));
            if (read == 0 || read < -1 || read > this.buffer.length) {
                String valueOf = String.valueOf(this.zzth.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 91);
                sb.append(valueOf);
                sb.append("#read(byte[]) returned invalid result: ");
                sb.append(read);
                sb.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb.toString());
            } else if (read <= 0) {
                return false;
            } else {
                this.zzti += read;
                zzge();
                if (this.zzti >= i) {
                    return true;
                }
            }
        }
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("refillBuffer() called when ");
        sb2.append(i);
        sb2.append(" bytes were already available in buffer");
        throw new IllegalStateException(sb2.toString());
    }

    private final byte zzgf() throws IOException {
        if (this.pos == this.zzti) {
            zzt(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final byte[] zzv(int i) throws IOException {
        byte[] zzw = zzw(i);
        if (zzw != null) {
            return zzw;
        }
        int i2 = this.pos;
        int i3 = this.zzti - this.pos;
        this.zztj += this.zzti;
        this.pos = 0;
        this.zzti = 0;
        List<byte[]> zzx = zzx(i - i3);
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, i2, bArr, 0, i3);
        for (byte[] bArr2 : zzx) {
            System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
            i3 += bArr2.length;
        }
        return bArr;
    }

    private final byte[] zzw(int i) throws IOException {
        if (i == 0) {
            return zzfv.EMPTY_BYTE_ARRAY;
        }
        if (i >= 0) {
            int i2 = this.zztj + this.pos + i;
            if (i2 - this.zzsz > 0) {
                throw zzgc.zzhw();
            } else if (i2 <= this.zztg) {
                int i3 = this.zzti - this.pos;
                int i4 = i - i3;
                if (i4 >= 4096 && i4 > this.zzth.available()) {
                    return null;
                }
                byte[] bArr = new byte[i];
                System.arraycopy(this.buffer, this.pos, bArr, 0, i3);
                this.zztj += this.zzti;
                this.pos = 0;
                this.zzti = 0;
                while (i3 < bArr.length) {
                    int read = this.zzth.read(bArr, i3, i - i3);
                    if (read != -1) {
                        this.zztj += read;
                        i3 += read;
                    } else {
                        throw zzgc.zzhq();
                    }
                }
                return bArr;
            } else {
                zzs((this.zztg - this.zztj) - this.pos);
                throw zzgc.zzhq();
            }
        } else {
            throw zzgc.zzhr();
        }
    }

    private final List<byte[]> zzx(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            byte[] bArr = new byte[Math.min(i, 4096)];
            int i2 = 0;
            while (i2 < bArr.length) {
                int read = this.zzth.read(bArr, i2, bArr.length - i2);
                if (read != -1) {
                    this.zztj += read;
                    i2 += read;
                } else {
                    throw zzgc.zzhq();
                }
            }
            i -= bArr.length;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzs(int i) throws IOException {
        if (i <= this.zzti - this.pos && i >= 0) {
            this.pos += i;
        } else if (i < 0) {
            throw zzgc.zzhr();
        } else if (this.zztj + this.pos + i <= this.zztg) {
            this.zztj += this.pos;
            int i2 = this.zzti - this.pos;
            this.zzti = 0;
            this.pos = 0;
            while (i2 < i) {
                try {
                    long j = (long) (i - i2);
                    long skip = this.zzth.skip(j);
                    if (skip < 0 || skip > j) {
                        String valueOf = String.valueOf(this.zzth.getClass());
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 92);
                        sb.append(valueOf);
                        sb.append("#skip returned invalid result: ");
                        sb.append(skip);
                        sb.append("\nThe InputStream implementation is buggy.");
                        throw new IllegalStateException(sb.toString());
                    }
                    i2 += (int) skip;
                } catch (Throwable th) {
                    this.zztj += i2;
                    zzge();
                    throw th;
                }
            }
            this.zztj += i2;
            zzge();
        } else {
            zzs((this.zztg - this.zztj) - this.pos);
            throw zzgc.zzhq();
        }
    }
}
