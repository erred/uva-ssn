package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo.zzd;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzub {
    private static volatile boolean zzbva = false;
    private static final Class<?> zzbvb = zzvq();
    private static volatile zzub zzbvc;
    static final zzub zzbvd = new zzub(true);
    private final Map<zza, zzd<?, ?>> zzbve;

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

    private static Class<?> zzvq() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzub zzvr() {
        return zzua.zzvo();
    }

    public static zzub zzvs() {
        zzub zzub = zzbvc;
        if (zzub == null) {
            synchronized (zzub.class) {
                zzub = zzbvc;
                if (zzub == null) {
                    zzub = zzua.zzvp();
                    zzbvc = zzub;
                }
            }
        }
        return zzub;
    }

    static zzub zzvp() {
        return zzum.zzd(zzub.class);
    }

    public final <ContainingType extends zzvv> zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzd) this.zzbve.get(new zza(containingtype, i));
    }

    zzub() {
        this.zzbve = new HashMap();
    }

    private zzub(boolean z) {
        this.zzbve = Collections.emptyMap();
    }
}
