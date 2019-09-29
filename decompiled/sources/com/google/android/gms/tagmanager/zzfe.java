package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.measurement.zzri;
import com.google.android.gms.internal.measurement.zzrm;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzfe implements zzfg {
    private final /* synthetic */ Map zzbfl;
    private final /* synthetic */ Map zzbfm;
    private final /* synthetic */ Map zzbfn;
    private final /* synthetic */ Map zzbfo;

    zzfe(zzfb zzfb, Map map, Map map2, Map map3, Map map4) {
        this.zzbfl = map;
        this.zzbfm = map2;
        this.zzbfn = map3;
        this.zzbfo = map4;
    }

    public final void zza(zzrm zzrm, Set<zzri> set, Set<zzri> set2, zzeq zzeq) {
        List list = (List) this.zzbfl.get(zzrm);
        this.zzbfm.get(zzrm);
        if (list != null) {
            set.addAll(list);
            zzeq.zzpc();
        }
        List list2 = (List) this.zzbfn.get(zzrm);
        this.zzbfo.get(zzrm);
        if (list2 != null) {
            set2.addAll(list2);
            zzeq.zzpd();
        }
    }
}
