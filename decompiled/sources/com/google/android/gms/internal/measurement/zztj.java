package com.google.android.gms.internal.measurement;

final class zztj extends zzto {
    private final int zzbtu;
    private final int zzbtv;

    zztj(byte[] bArr, int i, int i2) {
        super(bArr);
        zzb(i, i + i2, bArr.length);
        this.zzbtu = i;
        this.zzbtv = i2;
    }

    public final byte zzam(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzbtx[this.zzbtu + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: 0000 */
    public final byte zzan(int i) {
        return this.zzbtx[this.zzbtu + i];
    }

    public final int size() {
        return this.zzbtv;
    }

    /* access modifiers changed from: protected */
    public final int zzug() {
        return this.zzbtu;
    }
}