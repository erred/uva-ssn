package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;

public final class zzxz {
    private final byte[] buffer;
    private int zzbty;
    private int zzbtz = 64;
    private int zzbua = 67108864;
    private int zzbue;
    private int zzbug;
    private int zzbuh = BaseClientBuilder.API_PRIORITY_OTHER;
    private final int zzcem;
    private final int zzcen;
    private int zzceo;
    private int zzcep;
    private zztq zzceq;

    public static zzxz zzn(byte[] bArr) {
        return zzj(bArr, 0, bArr.length);
    }

    public static zzxz zzj(byte[] bArr, int i, int i2) {
        return new zzxz(bArr, 0, i2);
    }

    public final int zzuj() throws IOException {
        if (this.zzcep == this.zzceo) {
            this.zzbug = 0;
            return 0;
        }
        this.zzbug = zzvb();
        if (this.zzbug != 0) {
            return this.zzbug;
        }
        throw new zzyh("Protocol message contained an invalid tag (zero).");
    }

    public final void zzap(int i) throws zzyh {
        if (this.zzbug != i) {
            throw new zzyh("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzaq(int i) throws IOException {
        int zzuj;
        switch (i & 7) {
            case 0:
                zzvb();
                return true;
            case 1:
                zzve();
                return true;
            case 2:
                zzau(zzvb());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzvd();
                return true;
            default:
                throw new zzyh("Protocol message tag had invalid wire type.");
        }
        do {
            zzuj = zzuj();
            if (zzuj != 0) {
            }
            zzap(((i >>> 3) << 3) | 4);
            return true;
        } while (zzaq(zzuj));
        zzap(((i >>> 3) << 3) | 4);
        return true;
    }

    public final boolean zzup() throws IOException {
        return zzvb() != 0;
    }

    public final String readString() throws IOException {
        int zzvb = zzvb();
        if (zzvb < 0) {
            throw zzyh.zzze();
        } else if (zzvb <= this.zzceo - this.zzcep) {
            String str = new String(this.buffer, this.zzcep, zzvb, zzyg.UTF_8);
            this.zzcep += zzvb;
            return str;
        } else {
            throw zzyh.zzzd();
        }
    }

    public final void zza(zzyi zzyi, int i) throws IOException {
        if (this.zzbty < this.zzbtz) {
            this.zzbty++;
            zzyi.zza(this);
            zzap((i << 3) | 4);
            this.zzbty--;
            return;
        }
        throw zzyh.zzzg();
    }

    public final void zza(zzyi zzyi) throws IOException {
        int zzvb = zzvb();
        if (this.zzbty < this.zzbtz) {
            int zzas = zzas(zzvb);
            this.zzbty++;
            zzyi.zza(this);
            zzap(0);
            this.zzbty--;
            zzat(zzas);
            return;
        }
        throw zzyh.zzzg();
    }

    public final int zzvb() throws IOException {
        byte b;
        byte zzvg = zzvg();
        if (zzvg >= 0) {
            return zzvg;
        }
        byte b2 = zzvg & Ascii.DEL;
        byte zzvg2 = zzvg();
        if (zzvg2 >= 0) {
            b = b2 | (zzvg2 << 7);
        } else {
            byte b3 = b2 | ((zzvg2 & Ascii.DEL) << 7);
            byte zzvg3 = zzvg();
            if (zzvg3 >= 0) {
                b = b3 | (zzvg3 << Ascii.f6735SO);
            } else {
                byte b4 = b3 | ((zzvg3 & Ascii.DEL) << Ascii.f6735SO);
                byte zzvg4 = zzvg();
                if (zzvg4 >= 0) {
                    b = b4 | (zzvg4 << Ascii.NAK);
                } else {
                    byte b5 = b4 | ((zzvg4 & Ascii.DEL) << Ascii.NAK);
                    byte zzvg5 = zzvg();
                    b = b5 | (zzvg5 << Ascii.f6728FS);
                    if (zzvg5 < 0) {
                        for (int i = 0; i < 5; i++) {
                            if (zzvg() >= 0) {
                                return b;
                            }
                        }
                        throw zzyh.zzzf();
                    }
                }
            }
        }
        return b;
    }

    public final long zzvc() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzvg = zzvg();
            j |= ((long) (zzvg & Ascii.DEL)) << i;
            if ((zzvg & 128) == 0) {
                return j;
            }
        }
        throw zzyh.zzzf();
    }

    public final int zzvd() throws IOException {
        return (zzvg() & UnsignedBytes.MAX_VALUE) | ((zzvg() & UnsignedBytes.MAX_VALUE) << 8) | ((zzvg() & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((zzvg() & UnsignedBytes.MAX_VALUE) << Ascii.CAN);
    }

    public final long zzve() throws IOException {
        byte zzvg = zzvg();
        byte zzvg2 = zzvg();
        return ((((long) zzvg2) & 255) << 8) | (((long) zzvg) & 255) | ((((long) zzvg()) & 255) << 16) | ((((long) zzvg()) & 255) << 24) | ((((long) zzvg()) & 255) << 32) | ((((long) zzvg()) & 255) << 40) | ((((long) zzvg()) & 255) << 48) | ((((long) zzvg()) & 255) << 56);
    }

    private zzxz(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzcem = i;
        int i3 = i2 + i;
        this.zzceo = i3;
        this.zzcen = i3;
        this.zzcep = i;
    }

    private final zztq zzyx() throws IOException {
        if (this.zzceq == null) {
            this.zzceq = zztq.zzd(this.buffer, this.zzcem, this.zzcen);
        }
        int zzva = this.zzceq.zzva();
        int i = this.zzcep - this.zzcem;
        if (zzva <= i) {
            this.zzceq.zzau(i - zzva);
            this.zzceq.zzar(this.zzbtz - this.zzbty);
            return this.zzceq;
        }
        throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", new Object[]{Integer.valueOf(zzva), Integer.valueOf(i)}));
    }

    public final <T extends zzuo<T, ?>> T zza(zzwf<T> zzwf) throws IOException {
        try {
            T t = (zzuo) zzyx().zza(zzwf, zzub.zzvs());
            zzaq(this.zzbug);
            return t;
        } catch (zzuv e) {
            throw new zzyh("", e);
        }
    }

    public final int zzas(int i) throws zzyh {
        if (i >= 0) {
            int i2 = i + this.zzcep;
            int i3 = this.zzbuh;
            if (i2 <= i3) {
                this.zzbuh = i2;
                zzvf();
                return i3;
            }
            throw zzyh.zzzd();
        }
        throw zzyh.zzze();
    }

    private final void zzvf() {
        this.zzceo += this.zzbue;
        int i = this.zzceo;
        if (i > this.zzbuh) {
            this.zzbue = i - this.zzbuh;
            this.zzceo -= this.zzbue;
            return;
        }
        this.zzbue = 0;
    }

    public final void zzat(int i) {
        this.zzbuh = i;
        zzvf();
    }

    public final int zzyy() {
        if (this.zzbuh == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzbuh - this.zzcep;
    }

    public final int getPosition() {
        return this.zzcep - this.zzcem;
    }

    public final byte[] zzs(int i, int i2) {
        if (i2 == 0) {
            return zzyl.zzcfo;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzcem + i, bArr, 0, i2);
        return bArr;
    }

    public final void zzcb(int i) {
        zzt(i, this.zzbug);
    }

    /* access modifiers changed from: 0000 */
    public final void zzt(int i, int i2) {
        if (i > this.zzcep - this.zzcem) {
            int i3 = this.zzcep - this.zzcem;
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i);
            sb.append(" is beyond current ");
            sb.append(i3);
            throw new IllegalArgumentException(sb.toString());
        } else if (i >= 0) {
            this.zzcep = this.zzcem + i;
            this.zzbug = i2;
        } else {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    private final byte zzvg() throws IOException {
        if (this.zzcep != this.zzceo) {
            byte[] bArr = this.buffer;
            int i = this.zzcep;
            this.zzcep = i + 1;
            return bArr[i];
        }
        throw zzyh.zzzd();
    }

    private final void zzau(int i) throws IOException {
        if (i < 0) {
            throw zzyh.zzze();
        } else if (this.zzcep + i > this.zzbuh) {
            zzau(this.zzbuh - this.zzcep);
            throw zzyh.zzzd();
        } else if (i <= this.zzceo - this.zzcep) {
            this.zzcep += i;
        } else {
            throw zzyh.zzzd();
        }
    }
}
