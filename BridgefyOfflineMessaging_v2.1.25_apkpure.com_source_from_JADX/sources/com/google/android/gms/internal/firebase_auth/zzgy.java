package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class zzgy implements zzgx {
    zzgy() {
    }

    public final Map<?, ?> zzj(Object obj) {
        return (zzgw) obj;
    }

    public final zzgv<?, ?> zzo(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzk(Object obj) {
        return (zzgw) obj;
    }

    public final boolean zzl(Object obj) {
        return !((zzgw) obj).isMutable();
    }

    public final Object zzm(Object obj) {
        ((zzgw) obj).zzev();
        return obj;
    }

    public final Object zzn(Object obj) {
        return zzgw.zzih().zzii();
    }

    public final Object zzb(Object obj, Object obj2) {
        zzgw zzgw = (zzgw) obj;
        zzgw zzgw2 = (zzgw) obj2;
        if (!zzgw2.isEmpty()) {
            if (!zzgw.isMutable()) {
                zzgw = zzgw.zzii();
            }
            zzgw.zza(zzgw2);
        }
        return zzgw;
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzgw zzgw = (zzgw) obj;
        if (zzgw.isEmpty()) {
            return 0;
        }
        Iterator it = zzgw.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Entry entry = (Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
