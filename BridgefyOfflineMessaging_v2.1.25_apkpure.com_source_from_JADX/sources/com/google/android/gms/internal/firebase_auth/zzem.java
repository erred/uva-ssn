package com.google.android.gms.internal.firebase_auth;

final class zzem extends zzer {
    private final int zzst;
    private final int zzsu;

    zzem(byte[] bArr, int i, int i2) {
        super(bArr);
        zzd(i, i + i2, bArr.length);
        this.zzst = i;
        this.zzsu = i2;
    }

    public final byte zzk(int i) {
        zze(i, size());
        return this.zzsw[this.zzst + i];
    }

    /* access modifiers changed from: 0000 */
    public final byte zzl(int i) {
        return this.zzsw[this.zzst + i];
    }

    public final int size() {
        return this.zzsu;
    }

    /* access modifiers changed from: protected */
    public final int zzff() {
        return this.zzst;
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzsw, zzff() + i, bArr, i2, i3);
    }
}
