package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.io.IOException;

public abstract class zzet {
    int zzsx;
    int zzsy;
    int zzsz;
    zzey zzta;
    private boolean zztb;

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    static zzet zza(byte[] bArr, int i, int i2, boolean z) {
        zzev zzev = new zzev(bArr, 0, i2, false);
        try {
            zzev.zzp(i2);
            return zzev;
        } catch (zzgc e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zzr(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract int zzfi() throws IOException;

    public abstract long zzfj() throws IOException;

    public abstract long zzfk() throws IOException;

    public abstract int zzfl() throws IOException;

    public abstract long zzfm() throws IOException;

    public abstract int zzfn() throws IOException;

    public abstract boolean zzfo() throws IOException;

    public abstract String zzfp() throws IOException;

    public abstract zzeh zzfq() throws IOException;

    public abstract int zzfr() throws IOException;

    public abstract int zzfs() throws IOException;

    public abstract int zzft() throws IOException;

    public abstract long zzfu() throws IOException;

    public abstract int zzfv() throws IOException;

    public abstract long zzfw() throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract long zzfx() throws IOException;

    public abstract boolean zzfy() throws IOException;

    public abstract int zzfz();

    public abstract void zzn(int i) throws zzgc;

    public abstract boolean zzo(int i) throws IOException;

    public abstract int zzp(int i) throws zzgc;

    public abstract void zzq(int i);

    private zzet() {
        this.zzsy = 100;
        this.zzsz = BaseClientBuilder.API_PRIORITY_OTHER;
        this.zztb = false;
    }
}
