package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.measurement.zzri;
import com.google.android.gms.internal.measurement.zzrm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzfi {
    private final Set<zzrm> zzbfh = new HashSet();
    private final Map<zzrm, List<zzri>> zzbfr = new HashMap();
    private final Map<zzrm, List<zzri>> zzbfs = new HashMap();
    private final Map<zzrm, List<String>> zzbft = new HashMap();
    private final Map<zzrm, List<String>> zzbfu = new HashMap();
    private zzri zzbfv;

    public final Set<zzrm> zzpx() {
        return this.zzbfh;
    }

    public final void zza(zzrm zzrm) {
        this.zzbfh.add(zzrm);
    }

    public final Map<zzrm, List<zzri>> zzpy() {
        return this.zzbfr;
    }

    public final Map<zzrm, List<String>> zzpz() {
        return this.zzbft;
    }

    public final Map<zzrm, List<String>> zzqa() {
        return this.zzbfu;
    }

    public final void zza(zzrm zzrm, zzri zzri) {
        List list = (List) this.zzbfr.get(zzrm);
        if (list == null) {
            list = new ArrayList();
            this.zzbfr.put(zzrm, list);
        }
        list.add(zzri);
    }

    public final void zza(zzrm zzrm, String str) {
        List list = (List) this.zzbft.get(zzrm);
        if (list == null) {
            list = new ArrayList();
            this.zzbft.put(zzrm, list);
        }
        list.add(str);
    }

    public final Map<zzrm, List<zzri>> zzqb() {
        return this.zzbfs;
    }

    public final void zzb(zzrm zzrm, zzri zzri) {
        List list = (List) this.zzbfs.get(zzrm);
        if (list == null) {
            list = new ArrayList();
            this.zzbfs.put(zzrm, list);
        }
        list.add(zzri);
    }

    public final void zzb(zzrm zzrm, String str) {
        List list = (List) this.zzbfu.get(zzrm);
        if (list == null) {
            list = new ArrayList();
            this.zzbfu.put(zzrm, list);
        }
        list.add(str);
    }

    public final zzri zzqc() {
        return this.zzbfv;
    }

    public final void zzb(zzri zzri) {
        this.zzbfv = zzri;
    }
}
