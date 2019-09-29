package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzhh<T> implements zzhw<T> {
    private final zzfh<?> zzaaa;
    private final zzhc zzzp;
    private final boolean zzzq;
    private final zziq<?, ?> zzzz;

    private zzhh(zziq<?, ?> zziq, zzfh<?> zzfh, zzhc zzhc) {
        this.zzzz = zziq;
        this.zzzq = zzfh.zzf(zzhc);
        this.zzaaa = zzfh;
        this.zzzp = zzhc;
    }

    static <T> zzhh<T> zza(zziq<?, ?> zziq, zzfh<?> zzfh, zzhc zzhc) {
        return new zzhh<>(zziq, zzfh, zzhc);
    }

    public final T newInstance() {
        return this.zzzp.zzhh().zzhm();
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzzz.zzs(t).equals(this.zzzz.zzs(t2))) {
            return false;
        }
        if (this.zzzq) {
            return this.zzaaa.zzd(t).equals(this.zzaaa.zzd(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzzz.zzs(t).hashCode();
        return this.zzzq ? (hashCode * 53) + this.zzaaa.zzd(t).hashCode() : hashCode;
    }

    public final void zzc(T t, T t2) {
        zzhy.zza(this.zzzz, t, t2);
        if (this.zzzq) {
            zzhy.zza(this.zzaaa, t, t2);
        }
    }

    public final void zza(T t, zzjl zzjl) throws IOException {
        Iterator it = this.zzaaa.zzd(t).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzfm zzfm = (zzfm) entry.getKey();
            if (zzfm.zzgz() != zzjk.MESSAGE || zzfm.zzha() || zzfm.zzhb()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof zzgh) {
                zzjl.zza(zzfm.zzbi(), (Object) ((zzgh) entry).zzib().zzer());
            } else {
                zzjl.zza(zzfm.zzbi(), entry.getValue());
            }
        }
        zziq<?, ?> zziq = this.zzzz;
        zziq.zzc(zziq.zzs(t), zzjl);
    }

    public final void zza(T t, zzhr zzhr, zzfg zzfg) throws IOException {
        boolean z;
        zziq<?, ?> zziq = this.zzzz;
        zzfh<?> zzfh = this.zzaaa;
        Object zzt = zziq.zzt(t);
        zzfk zze = zzfh.zze(t);
        do {
            try {
                if (zzhr.zzgg() == Integer.MAX_VALUE) {
                    zziq.zzf(t, zzt);
                    return;
                }
                int tag = zzhr.getTag();
                if (tag == 11) {
                    Object obj = null;
                    zzeh zzeh = null;
                    int i = 0;
                    while (zzhr.zzgg() != Integer.MAX_VALUE) {
                        int tag2 = zzhr.getTag();
                        if (tag2 == 16) {
                            i = zzhr.zzfr();
                            obj = zzfh.zza(zzfg, this.zzzp, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzfh.zza(zzhr, obj, zzfg, zze);
                            } else {
                                zzeh = zzhr.zzfq();
                            }
                        } else if (!zzhr.zzgh()) {
                            break;
                        }
                    }
                    if (zzhr.getTag() != 12) {
                        throw zzgc.zzhu();
                    } else if (zzeh != null) {
                        if (obj != null) {
                            zzfh.zza(zzeh, obj, zzfg, zze);
                        } else {
                            zziq.zza(zzt, i, zzeh);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzfh.zza(zzfg, this.zzzp, tag >>> 3);
                    if (zza != null) {
                        zzfh.zza(zzhr, zza, zzfg, zze);
                    } else {
                        z = zziq.zza(zzt, zzhr);
                        continue;
                    }
                } else {
                    z = zzhr.zzgh();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zziq.zzf(t, zzt);
            }
        } while (z);
    }

    public final void zzf(T t) {
        this.zzzz.zzf(t);
        this.zzaaa.zzf((Object) t);
    }

    public final boolean zzq(T t) {
        return this.zzaaa.zzd(t).isInitialized();
    }

    public final int zzp(T t) {
        zziq<?, ?> zziq = this.zzzz;
        int zzu = zziq.zzu(zziq.zzs(t)) + 0;
        return this.zzzq ? zzu + this.zzaaa.zzd(t).zzgx() : zzu;
    }
}
