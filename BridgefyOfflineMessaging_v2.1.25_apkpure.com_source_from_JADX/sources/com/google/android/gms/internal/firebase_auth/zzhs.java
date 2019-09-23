package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

final class zzhs extends zzeh {
    /* access modifiers changed from: private */
    public static final int[] zzaai;
    private final int zzaaj;
    /* access modifiers changed from: private */
    public final zzeh zzaak;
    /* access modifiers changed from: private */
    public final zzeh zzaal;
    private final int zzaam;
    private final int zzaan;

    private zzhs(zzeh zzeh, zzeh zzeh2) {
        this.zzaak = zzeh;
        this.zzaal = zzeh2;
        this.zzaam = zzeh.size();
        this.zzaaj = this.zzaam + zzeh2.size();
        this.zzaan = Math.max(zzeh.zzfc(), zzeh2.zzfc()) + 1;
    }

    static zzeh zza(zzeh zzeh, zzeh zzeh2) {
        if (zzeh2.size() == 0) {
            return zzeh;
        }
        if (zzeh.size() == 0) {
            return zzeh2;
        }
        int size = zzeh.size() + zzeh2.size();
        if (size < 128) {
            return zzb(zzeh, zzeh2);
        }
        if (zzeh instanceof zzhs) {
            zzhs zzhs = (zzhs) zzeh;
            if (zzhs.zzaal.size() + zzeh2.size() < 128) {
                return new zzhs(zzhs.zzaak, zzb(zzhs.zzaal, zzeh2));
            } else if (zzhs.zzaak.zzfc() > zzhs.zzaal.zzfc() && zzhs.zzfc() > zzeh2.zzfc()) {
                return new zzhs(zzhs.zzaak, new zzhs(zzhs.zzaal, zzeh2));
            }
        }
        if (size >= zzaai[Math.max(zzeh.zzfc(), zzeh2.zzfc()) + 1]) {
            return new zzhs(zzeh, zzeh2);
        }
        return new zzhu(null).zzc(zzeh, zzeh2);
    }

    private static zzeh zzb(zzeh zzeh, zzeh zzeh2) {
        int size = zzeh.size();
        int size2 = zzeh2.size();
        byte[] bArr = new byte[(size + size2)];
        zzeh.zza(bArr, 0, 0, size);
        zzeh2.zza(bArr, 0, size, size2);
        return zzeh.zza(bArr);
    }

    public final byte zzk(int i) {
        zze(i, this.zzaaj);
        return zzl(i);
    }

    /* access modifiers changed from: 0000 */
    public final byte zzl(int i) {
        if (i < this.zzaam) {
            return this.zzaak.zzl(i);
        }
        return this.zzaal.zzl(i - this.zzaam);
    }

    public final int size() {
        return this.zzaaj;
    }

    public final zzeo zzez() {
        return new zzht(this);
    }

    /* access modifiers changed from: protected */
    public final int zzfc() {
        return this.zzaan;
    }

    /* access modifiers changed from: protected */
    public final boolean zzfd() {
        return this.zzaaj >= zzaai[this.zzaan];
    }

    public final zzeh zzd(int i, int i2) {
        int zzd = zzd(i, i2, this.zzaaj);
        if (zzd == 0) {
            return zzeh.zzso;
        }
        if (zzd == this.zzaaj) {
            return this;
        }
        if (i2 <= this.zzaam) {
            return this.zzaak.zzd(i, i2);
        }
        if (i >= this.zzaam) {
            return this.zzaal.zzd(i - this.zzaam, i2 - this.zzaam);
        }
        zzeh zzeh = this.zzaak;
        return new zzhs(zzeh.zzd(i, zzeh.size()), this.zzaal.zzd(0, i2 - this.zzaam));
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        if (i + i3 <= this.zzaam) {
            this.zzaak.zzb(bArr, i, i2, i3);
        } else if (i >= this.zzaam) {
            this.zzaal.zzb(bArr, i - this.zzaam, i2, i3);
        } else {
            int i4 = this.zzaam - i;
            this.zzaak.zzb(bArr, i, i2, i4);
            this.zzaal.zzb(bArr, 0, i2 + i4, i3 - i4);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzeg zzeg) throws IOException {
        this.zzaak.zza(zzeg);
        this.zzaal.zza(zzeg);
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        byte[] bArr;
        int size = size();
        if (size == 0) {
            bArr = zzfv.EMPTY_BYTE_ARRAY;
        } else {
            byte[] bArr2 = new byte[size];
            zzb(bArr2, 0, 0, size);
            bArr = bArr2;
        }
        return new String(bArr, charset);
    }

    public final boolean zzfb() {
        if (this.zzaal.zzb(this.zzaak.zzb(0, 0, this.zzaam), 0, this.zzaal.size()) == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int zzb(int i, int i2, int i3) {
        if (i2 + i3 <= this.zzaam) {
            return this.zzaak.zzb(i, i2, i3);
        }
        if (i2 >= this.zzaam) {
            return this.zzaal.zzb(i, i2 - this.zzaam, i3);
        }
        int i4 = this.zzaam - i2;
        return this.zzaal.zzb(this.zzaak.zzb(i, i2, i4), 0, i3 - i4);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeh)) {
            return false;
        }
        zzeh zzeh = (zzeh) obj;
        if (this.zzaaj != zzeh.size()) {
            return false;
        }
        if (this.zzaaj == 0) {
            return true;
        }
        int zzfe = zzfe();
        int zzfe2 = zzeh.zzfe();
        if (zzfe != 0 && zzfe2 != 0 && zzfe != zzfe2) {
            return false;
        }
        zzhv zzhv = new zzhv(this, null);
        zzeq zzeq = (zzeq) zzhv.next();
        zzhv zzhv2 = new zzhv(zzeh, null);
        zzeq zzeq2 = (zzeq) zzhv2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = zzeq.size() - i;
            int size2 = zzeq2.size() - i2;
            int min = Math.min(size, size2);
            if (i == 0) {
                z = zzeq.zza(zzeq2, i2, min);
            } else {
                z = zzeq2.zza(zzeq, i, min);
            }
            if (!z) {
                return false;
            }
            i3 += min;
            if (i3 < this.zzaaj) {
                if (min == size) {
                    zzeq = (zzeq) zzhv.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    zzeq2 = (zzeq) zzhv2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == this.zzaaj) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int zzc(int i, int i2, int i3) {
        if (i2 + i3 <= this.zzaam) {
            return this.zzaak.zzc(i, i2, i3);
        }
        if (i2 >= this.zzaam) {
            return this.zzaal.zzc(i, i2 - this.zzaam, i3);
        }
        int i4 = this.zzaam - i2;
        return this.zzaal.zzc(this.zzaak.zzc(i, i2, i4), 0, i3 - i4);
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    /* synthetic */ zzhs(zzeh zzeh, zzeh zzeh2, zzht zzht) {
        this(zzeh, zzeh2);
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER));
        zzaai = new int[arrayList.size()];
        for (int i4 = 0; i4 < zzaai.length; i4++) {
            zzaai[i4] = ((Integer) arrayList.get(i4)).intValue();
        }
    }
}
