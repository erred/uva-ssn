package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzya {
    private final ByteBuffer zzbur;
    private zztv zzcer;
    private int zzces;

    private zzya(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int zzbg(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int zzbl(int i) {
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

    private zzya(ByteBuffer byteBuffer) {
        this.zzbur = byteBuffer;
        this.zzbur.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static zzya zzo(byte[] bArr) {
        return zzk(bArr, 0, bArr.length);
    }

    public static zzya zzk(byte[] bArr, int i, int i2) {
        return new zzya(bArr, 0, i2);
    }

    private final zztv zzyz() throws IOException {
        if (this.zzcer == null) {
            this.zzcer = zztv.zza(this.zzbur);
            this.zzces = this.zzbur.position();
        } else if (this.zzces != this.zzbur.position()) {
            this.zzcer.write(this.zzbur.array(), this.zzces, this.zzbur.position() - this.zzces);
            this.zzces = this.zzbur.position();
        }
        return this.zzcer;
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, 1);
        long doubleToLongBits = Double.doubleToLongBits(d);
        if (this.zzbur.remaining() >= 8) {
            this.zzbur.putLong(doubleToLongBits);
            return;
        }
        throw new zzyb(this.zzbur.position(), this.zzbur.limit());
    }

    public final void zza(int i, float f) throws IOException {
        zzc(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        if (this.zzbur.remaining() >= 4) {
            this.zzbur.putInt(floatToIntBits);
            return;
        }
        throw new zzyb(this.zzbur.position(), this.zzbur.limit());
    }

    public final void zza(int i, long j) throws IOException {
        zzc(i, 0);
        zzbf(j);
    }

    public final void zzi(int i, long j) throws IOException {
        zzc(i, 0);
        zzbf(j);
    }

    public final void zzd(int i, int i2) throws IOException {
        zzc(i, 0);
        if (i2 >= 0) {
            zzcd(i2);
        } else {
            zzbf((long) i2);
        }
    }

    public final void zzb(int i, boolean z) throws IOException {
        zzc(i, 0);
        byte b = z ? (byte) 1 : 0;
        if (this.zzbur.hasRemaining()) {
            this.zzbur.put(b);
            return;
        }
        throw new zzyb(this.zzbur.position(), this.zzbur.limit());
    }

    public final void zzb(int i, String str) throws IOException {
        zzc(i, 2);
        try {
            int zzbl = zzbl(str.length());
            if (zzbl == zzbl(str.length() * 3)) {
                int position = this.zzbur.position();
                if (this.zzbur.remaining() >= zzbl) {
                    this.zzbur.position(position + zzbl);
                    zzd((CharSequence) str, this.zzbur);
                    int position2 = this.zzbur.position();
                    this.zzbur.position(position);
                    zzcd((position2 - position) - zzbl);
                    this.zzbur.position(position2);
                    return;
                }
                throw new zzyb(position + zzbl, this.zzbur.limit());
            }
            zzcd(zza(str));
            zzd((CharSequence) str, this.zzbur);
        } catch (BufferOverflowException e) {
            zzyb zzyb = new zzyb(this.zzbur.position(), this.zzbur.limit());
            zzyb.initCause(e);
            throw zzyb;
        }
    }

    public final void zza(int i, zzyi zzyi) throws IOException {
        zzc(i, 2);
        zzb(zzyi);
    }

    public final void zze(int i, zzvv zzvv) throws IOException {
        zztv zzyz = zzyz();
        zzyz.zza(i, zzvv);
        zzyz.flush();
        this.zzces = this.zzbur.position();
    }

    private static int zza(CharSequence charSequence) {
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
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i2);
                                throw new IllegalArgumentException(sb.toString());
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
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(j);
        throw new IllegalArgumentException(sb2.toString());
    }

    private static void zzd(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        if (!byteBuffer.isReadOnly()) {
            int i3 = 0;
            if (byteBuffer.hasArray()) {
                try {
                    byte[] array = byteBuffer.array();
                    int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                    int remaining = byteBuffer.remaining();
                    int length = charSequence.length();
                    int i4 = remaining + arrayOffset;
                    while (i3 < length) {
                        int i5 = i3 + arrayOffset;
                        if (i5 >= i4) {
                            break;
                        }
                        char charAt = charSequence.charAt(i3);
                        if (charAt >= 128) {
                            break;
                        }
                        array[i5] = (byte) charAt;
                        i3++;
                    }
                    if (i3 == length) {
                        i = arrayOffset + length;
                    } else {
                        i = arrayOffset + i3;
                        while (i3 < length) {
                            char charAt2 = charSequence.charAt(i3);
                            if (charAt2 < 128 && i < i4) {
                                i2 = i + 1;
                                array[i] = (byte) charAt2;
                            } else if (charAt2 < 2048 && i <= i4 - 2) {
                                int i6 = i + 1;
                                array[i] = (byte) ((charAt2 >>> 6) | 960);
                                i = i6 + 1;
                                array[i6] = (byte) ((charAt2 & '?') | 128);
                                i3++;
                            } else if ((charAt2 < 55296 || 57343 < charAt2) && i <= i4 - 3) {
                                int i7 = i + 1;
                                array[i] = (byte) ((charAt2 >>> 12) | 480);
                                int i8 = i7 + 1;
                                array[i7] = (byte) (((charAt2 >>> 6) & 63) | 128);
                                i2 = i8 + 1;
                                array[i8] = (byte) ((charAt2 & '?') | 128);
                            } else if (i <= i4 - 4) {
                                int i9 = i3 + 1;
                                if (i9 != charSequence.length()) {
                                    char charAt3 = charSequence.charAt(i9);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        int i10 = i + 1;
                                        array[i] = (byte) ((codePoint >>> 18) | 240);
                                        int i11 = i10 + 1;
                                        array[i10] = (byte) (((codePoint >>> 12) & 63) | 128);
                                        int i12 = i11 + 1;
                                        array[i11] = (byte) (((codePoint >>> 6) & 63) | 128);
                                        i = i12 + 1;
                                        array[i12] = (byte) ((codePoint & 63) | 128);
                                        i3 = i9;
                                        i3++;
                                    } else {
                                        i3 = i9;
                                    }
                                }
                                int i13 = i3 - 1;
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i13);
                                throw new IllegalArgumentException(sb.toString());
                            } else {
                                StringBuilder sb2 = new StringBuilder(37);
                                sb2.append("Failed writing ");
                                sb2.append(charAt2);
                                sb2.append(" at index ");
                                sb2.append(i);
                                throw new ArrayIndexOutOfBoundsException(sb2.toString());
                            }
                            i = i2;
                            i3++;
                        }
                    }
                    byteBuffer.position(i - byteBuffer.arrayOffset());
                } catch (ArrayIndexOutOfBoundsException e) {
                    BufferOverflowException bufferOverflowException = new BufferOverflowException();
                    bufferOverflowException.initCause(e);
                    throw bufferOverflowException;
                }
            } else {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char charAt4 = charSequence.charAt(i3);
                    if (charAt4 < 128) {
                        byteBuffer.put((byte) charAt4);
                    } else if (charAt4 < 2048) {
                        byteBuffer.put((byte) ((charAt4 >>> 6) | 960));
                        byteBuffer.put((byte) ((charAt4 & '?') | 128));
                    } else if (charAt4 < 55296 || 57343 < charAt4) {
                        byteBuffer.put((byte) ((charAt4 >>> 12) | 480));
                        byteBuffer.put((byte) (((charAt4 >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((charAt4 & '?') | 128));
                    } else {
                        int i14 = i3 + 1;
                        if (i14 != charSequence.length()) {
                            char charAt5 = charSequence.charAt(i14);
                            if (Character.isSurrogatePair(charAt4, charAt5)) {
                                int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                byteBuffer.put((byte) ((codePoint2 >>> 18) | 240));
                                byteBuffer.put((byte) (((codePoint2 >>> 12) & 63) | 128));
                                byteBuffer.put((byte) (((codePoint2 >>> 6) & 63) | 128));
                                byteBuffer.put((byte) ((codePoint2 & 63) | 128));
                                i3 = i14;
                            } else {
                                i3 = i14;
                            }
                        }
                        int i15 = i3 - 1;
                        StringBuilder sb3 = new StringBuilder(39);
                        sb3.append("Unpaired surrogate at index ");
                        sb3.append(i15);
                        throw new IllegalArgumentException(sb3.toString());
                    }
                    i3++;
                }
            }
        } else {
            throw new ReadOnlyBufferException();
        }
    }

    public final void zzb(zzyi zzyi) throws IOException {
        zzcd(zzyi.zzzh());
        zzyi.zza(this);
    }

    public static int zzd(int i, long j) {
        return zzbd(i) + zzbg(j);
    }

    public static int zzh(int i, int i2) {
        return zzbd(i) + zzbe(i2);
    }

    public static int zzc(int i, String str) {
        return zzbd(i) + zzgc(str);
    }

    public static int zzb(int i, zzyi zzyi) {
        int zzbd = zzbd(i);
        int zzvx = zzyi.zzvx();
        return zzbd + zzbl(zzvx) + zzvx;
    }

    public static int zzbe(int i) {
        if (i >= 0) {
            return zzbl(i);
        }
        return 10;
    }

    public static int zzgc(String str) {
        int zza = zza(str);
        return zzbl(zza) + zza;
    }

    public final void zzza() {
        if (this.zzbur.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.zzbur.remaining())}));
        }
    }

    private final void zzcc(int i) throws IOException {
        byte b = (byte) i;
        if (this.zzbur.hasRemaining()) {
            this.zzbur.put(b);
            return;
        }
        throw new zzyb(this.zzbur.position(), this.zzbur.limit());
    }

    public final void zzp(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.zzbur.remaining() >= length) {
            this.zzbur.put(bArr, 0, length);
            return;
        }
        throw new zzyb(this.zzbur.position(), this.zzbur.limit());
    }

    public final void zzc(int i, int i2) throws IOException {
        zzcd((i << 3) | i2);
    }

    public static int zzbd(int i) {
        return zzbl(i << 3);
    }

    public final void zzcd(int i) throws IOException {
        while ((i & -128) != 0) {
            zzcc((i & 127) | 128);
            i >>>= 7;
        }
        zzcc(i);
    }

    private final void zzbf(long j) throws IOException {
        while ((-128 & j) != 0) {
            zzcc((((int) j) & 127) | 128);
            j >>>= 7;
        }
        zzcc((int) j);
    }
}
