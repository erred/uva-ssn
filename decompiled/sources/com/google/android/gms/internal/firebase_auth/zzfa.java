package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzfa extends zzeg {
    private static final Logger logger = Logger.getLogger(zzfa.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zztp = zziw.zzjs();
    zzfc zztq = this;

    static class zza extends zzfa {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i2 + 0;
                if ((i2 | 0 | (bArr.length - i3)) >= 0) {
                    this.buffer = bArr;
                    this.offset = 0;
                    this.position = 0;
                    this.limit = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i2)}));
            }
            throw new NullPointerException("buffer");
        }

        public final void zzf(int i, int i2) throws IOException {
            zzad((i << 3) | i2);
        }

        public final void zzg(int i, int i2) throws IOException {
            zzf(i, 0);
            zzac(i2);
        }

        public final void zzh(int i, int i2) throws IOException {
            zzf(i, 0);
            zzad(i2);
        }

        public final void zzj(int i, int i2) throws IOException {
            zzf(i, 5);
            zzaf(i2);
        }

        public final void zza(int i, long j) throws IOException {
            zzf(i, 0);
            zzb(j);
        }

        public final void zzc(int i, long j) throws IOException {
            zzf(i, 1);
            zzd(j);
        }

        public final void zzb(int i, boolean z) throws IOException {
            zzf(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        public final void zza(int i, String str) throws IOException {
            zzf(i, 2);
            zzda(str);
        }

        public final void zza(int i, zzeh zzeh) throws IOException {
            zzf(i, 2);
            zza(zzeh);
        }

        public final void zza(zzeh zzeh) throws IOException {
            zzad(zzeh.size());
            zzeh.zza((zzeg) this);
        }

        public final void zzd(byte[] bArr, int i, int i2) throws IOException {
            zzad(i2);
            write(bArr, 0, i2);
        }

        /* access modifiers changed from: 0000 */
        public final void zza(int i, zzhc zzhc, zzhw zzhw) throws IOException {
            zzf(i, 2);
            zzdz zzdz = (zzdz) zzhc;
            int zzes = zzdz.zzes();
            if (zzes == -1) {
                zzes = zzhw.zzp(zzdz);
                zzdz.zzg(zzes);
            }
            zzad(zzes);
            zzhw.zza(zzhc, this.zztq);
        }

        public final void zza(int i, zzhc zzhc) throws IOException {
            zzf(1, 3);
            zzh(2, i);
            zzf(3, 2);
            zzc(zzhc);
            zzf(1, 4);
        }

        public final void zzb(int i, zzeh zzeh) throws IOException {
            zzf(1, 3);
            zzh(2, i);
            zza(3, zzeh);
            zzf(1, 4);
        }

        public final void zzc(zzhc zzhc) throws IOException {
            zzad(zzhc.zzgw());
            zzhc.zzb(this);
        }

        public final void zzc(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzac(int i) throws IOException {
            if (i >= 0) {
                zzad(i);
            } else {
                zzb((long) i);
            }
        }

        public final void zzad(int i) throws IOException {
            if (!zzfa.zztp || zzgi() < 10) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                }
            } else {
                while ((i & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    zziw.zza(bArr3, (long) i4, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zziw.zza(bArr4, (long) i5, (byte) i);
            }
        }

        public final void zzaf(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        public final void zzb(long j) throws IOException {
            if (!zzfa.zztp || zzgi() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zziw.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zziw.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        public final void zzd(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(1)}), e);
            }
        }

        private final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzda(String str) throws IOException {
            int i = this.position;
            try {
                int zzai = zzai(str.length() * 3);
                int zzai2 = zzai(str.length());
                if (zzai2 == zzai) {
                    this.position = i + zzai2;
                    int zza = zziy.zza(str, this.buffer, this.position, zzgi());
                    this.position = i;
                    zzad((zza - i) - zzai2);
                    this.position = zza;
                    return;
                }
                zzad(zziy.zza(str));
                this.position = zziy.zza(str, this.buffer, this.position, zzgi());
            } catch (zzjc e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        public final int zzgi() {
            return this.limit - this.position;
        }
    }

    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        zzb(String str, Throwable th) {
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            String valueOf2 = String.valueOf(str);
            super(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), th);
        }
    }

    public static int zzai(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzak(int i) {
        return 4;
    }

    public static int zzal(int i) {
        return 4;
    }

    private static int zzan(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static zzfa zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzf(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        if ((j & -16384) != 0) {
            i++;
        }
        return i;
    }

    public static int zzh(long j) {
        return 8;
    }

    public static int zzi(long j) {
        return 8;
    }

    private static long zzj(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzt(boolean z) {
        return 1;
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzeh zzeh) throws IOException;

    public abstract void zza(int i, zzhc zzhc) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zza(int i, zzhc zzhc, zzhw zzhw) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(zzeh zzeh) throws IOException;

    public abstract void zzac(int i) throws IOException;

    public abstract void zzad(int i) throws IOException;

    public abstract void zzaf(int i) throws IOException;

    public abstract void zzb(int i, zzeh zzeh) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(long j) throws IOException;

    public abstract void zzc(byte b) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzc(zzhc zzhc) throws IOException;

    public abstract void zzd(long j) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void zzd(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzda(String str) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzg(int i, int i2) throws IOException;

    public abstract int zzgi();

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzj(int i, int i2) throws IOException;

    private zzfa() {
    }

    public final void zzi(int i, int i2) throws IOException {
        zzh(i, zzan(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzj(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzj(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzae(int i) throws IOException {
        zzad(zzan(i));
    }

    public final void zzc(long j) throws IOException {
        zzb(zzj(j));
    }

    public final void zza(float f) throws IOException {
        zzaf(Float.floatToRawIntBits(f));
    }

    public final void zza(double d) throws IOException {
        zzd(Double.doubleToRawLongBits(d));
    }

    public final void zzs(boolean z) throws IOException {
        zzc(z ? (byte) 1 : 0);
    }

    public static int zzk(int i, int i2) {
        return zzag(i) + zzah(i2);
    }

    public static int zzl(int i, int i2) {
        return zzag(i) + zzai(i2);
    }

    public static int zzm(int i, int i2) {
        return zzag(i) + zzai(zzan(i2));
    }

    public static int zzn(int i, int i2) {
        return zzag(i) + 4;
    }

    public static int zzo(int i, int i2) {
        return zzag(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzag(i) + zzf(j);
    }

    public static int zze(int i, long j) {
        return zzag(i) + zzf(j);
    }

    public static int zzf(int i, long j) {
        return zzag(i) + zzf(zzj(j));
    }

    public static int zzg(int i, long j) {
        return zzag(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzag(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzag(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zzag(i) + 8;
    }

    public static int zzc(int i, boolean z) {
        return zzag(i) + 1;
    }

    public static int zzp(int i, int i2) {
        return zzag(i) + zzah(i2);
    }

    public static int zzb(int i, String str) {
        return zzag(i) + zzdb(str);
    }

    public static int zzc(int i, zzeh zzeh) {
        int zzag = zzag(i);
        int size = zzeh.size();
        return zzag + zzai(size) + size;
    }

    public static int zza(int i, zzgj zzgj) {
        int zzag = zzag(i);
        int zzgw = zzgj.zzgw();
        return zzag + zzai(zzgw) + zzgw;
    }

    static int zzb(int i, zzhc zzhc, zzhw zzhw) {
        return zzag(i) + zza(zzhc, zzhw);
    }

    public static int zzb(int i, zzhc zzhc) {
        return (zzag(1) << 1) + zzl(2, i) + zzag(3) + zzd(zzhc);
    }

    public static int zzd(int i, zzeh zzeh) {
        return (zzag(1) << 1) + zzl(2, i) + zzc(3, zzeh);
    }

    public static int zzb(int i, zzgj zzgj) {
        return (zzag(1) << 1) + zzl(2, i) + zza(3, zzgj);
    }

    public static int zzag(int i) {
        return zzai(i << 3);
    }

    public static int zzah(int i) {
        if (i >= 0) {
            return zzai(i);
        }
        return 10;
    }

    public static int zzaj(int i) {
        return zzai(zzan(i));
    }

    public static int zze(long j) {
        return zzf(j);
    }

    public static int zzg(long j) {
        return zzf(zzj(j));
    }

    public static int zzam(int i) {
        return zzah(i);
    }

    public static int zzdb(String str) {
        int i;
        try {
            i = zziy.zza(str);
        } catch (zzjc unused) {
            i = str.getBytes(zzfv.UTF_8).length;
        }
        return zzai(i) + i;
    }

    public static int zza(zzgj zzgj) {
        int zzgw = zzgj.zzgw();
        return zzai(zzgw) + zzgw;
    }

    public static int zzb(zzeh zzeh) {
        int size = zzeh.size();
        return zzai(size) + size;
    }

    public static int zzc(byte[] bArr) {
        int length = bArr.length;
        return zzai(length) + length;
    }

    public static int zzd(zzhc zzhc) {
        int zzgw = zzhc.zzgw();
        return zzai(zzgw) + zzgw;
    }

    static int zza(zzhc zzhc, zzhw zzhw) {
        zzdz zzdz = (zzdz) zzhc;
        int zzes = zzdz.zzes();
        if (zzes == -1) {
            zzes = zzhw.zzp(zzdz);
            zzdz.zzg(zzes);
        }
        return zzai(zzes) + zzes;
    }

    public final void zzgj() {
        if (zzgi() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(String str, zzjc zzjc) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzjc);
        byte[] bytes = str.getBytes(zzfv.UTF_8);
        try {
            zzad(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzb(e);
        } catch (zzb e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzhc zzhc, zzhw zzhw) {
        int zzag = zzag(i) << 1;
        zzdz zzdz = (zzdz) zzhc;
        int zzes = zzdz.zzes();
        if (zzes == -1) {
            zzes = zzhw.zzp(zzdz);
            zzdz.zzg(zzes);
        }
        return zzag + zzes;
    }

    @Deprecated
    public static int zze(zzhc zzhc) {
        return zzhc.zzgw();
    }

    @Deprecated
    public static int zzao(int i) {
        return zzai(i);
    }
}
