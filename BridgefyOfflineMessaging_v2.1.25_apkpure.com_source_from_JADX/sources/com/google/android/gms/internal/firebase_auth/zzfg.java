package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft.zzd;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzfg {
    private static volatile boolean zztu = false;
    private static final Class<?> zztv = zzgp();
    private static volatile zzfg zztw;
    static final zzfg zztx = new zzfg(true);
    private final Map<zza, zzd<?, ?>> zzty;

    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.object == zza.object && this.number == zza.number) {
                return true;
            }
            return false;
        }
    }

    private static Class<?> zzgp() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzfg zzgq() {
        return zzff.zzgn();
    }

    public static zzfg zzgr() {
        zzfg zzfg = zztw;
        if (zzfg == null) {
            synchronized (zzfg.class) {
                zzfg = zztw;
                if (zzfg == null) {
                    zzfg = zzff.zzgo();
                    zztw = zzfg;
                }
            }
        }
        return zzfg;
    }

    static zzfg zzgo() {
        return zzfr.zza(zzfg.class);
    }

    public final <ContainingType extends zzhc> zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzd) this.zzty.get(new zza(containingtype, i));
    }

    zzfg() {
        this.zzty = new HashMap();
    }

    private zzfg(boolean z) {
        this.zzty = Collections.emptyMap();
    }
}
