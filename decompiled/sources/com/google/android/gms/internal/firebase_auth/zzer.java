package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.nio.charset.Charset;

class zzer extends zzeq {
    protected final byte[] zzsw;

    zzer(byte[] bArr) {
        if (bArr != null) {
            this.zzsw = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public int zzff() {
        return 0;
    }

    public byte zzk(int i) {
        return this.zzsw[i];
    }

    /* access modifiers changed from: 0000 */
    public byte zzl(int i) {
        return this.zzsw[i];
    }

    public int size() {
        return this.zzsw.length;
    }

    public final zzeh zzd(int i, int i2) {
        int zzd = zzd(i, i2, size());
        if (zzd == 0) {
            return zzeh.zzso;
        }
        return new zzem(this.zzsw, zzff() + i, zzd);
    }

    /* access modifiers changed from: protected */
    public void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzsw, i, bArr, i2, i3);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzeg zzeg) throws IOException {
        zzeg.zza(this.zzsw, zzff(), size());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzsw, zzff(), size(), charset);
    }

    public final boolean zzfb() {
        int zzff = zzff();
        return zziy.zze(this.zzsw, zzff, size() + zzff);
    }

    /* access modifiers changed from: protected */
    public final int zzb(int i, int i2, int i3) {
        int zzff = zzff() + i2;
        return zziy.zzb(i, this.zzsw, zzff, i3 + zzff);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeh) || size() != ((zzeh) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzer)) {
            return obj.equals(this);
        }
        zzer zzer = (zzer) obj;
        int zzfe = zzfe();
        int zzfe2 = zzer.zzfe();
        if (zzfe == 0 || zzfe2 == 0 || zzfe == zzfe2) {
            return zza(zzer, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(zzeh zzeh, int i, int i2) {
        if (i2 <= zzeh.size()) {
            int i3 = i + i2;
            if (i3 > zzeh.size()) {
                int size = zzeh.size();
                StringBuilder sb = new StringBuilder(59);
                sb.append("Ran off end of other: ");
                sb.append(i);
                sb.append(", ");
                sb.append(i2);
                sb.append(", ");
                sb.append(size);
                throw new IllegalArgumentException(sb.toString());
            } else if (!(zzeh instanceof zzer)) {
                return zzeh.zzd(i, i3).equals(zzd(0, i2));
            } else {
                zzer zzer = (zzer) zzeh;
                byte[] bArr = this.zzsw;
                byte[] bArr2 = zzer.zzsw;
                int zzff = zzff() + i2;
                int zzff2 = zzff();
                int zzff3 = zzer.zzff() + i;
                while (zzff2 < zzff) {
                    if (bArr[zzff2] != bArr2[zzff3]) {
                        return false;
                    }
                    zzff2++;
                    zzff3++;
                }
                return true;
            }
        } else {
            int size2 = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i2);
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    public final int zzc(int i, int i2, int i3) {
        return zzfv.zza(i, this.zzsw, zzff() + i2, i3);
    }
}
