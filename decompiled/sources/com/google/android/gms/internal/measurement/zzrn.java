package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

public final class zzrn {
    private final List<zzri> zzboz;
    private final List<zzri> zzbpa;
    private final List<zzri> zzbpb;
    private final List<zzri> zzbpc;
    private final List<zzri> zzbqf;
    private final List<zzri> zzbqg;
    private final List<String> zzbqh;
    private final List<String> zzbqi;
    private final List<String> zzbqj;
    private final List<String> zzbqk;

    private zzrn() {
        this.zzboz = new ArrayList();
        this.zzbpa = new ArrayList();
        this.zzbpb = new ArrayList();
        this.zzbpc = new ArrayList();
        this.zzbqf = new ArrayList();
        this.zzbqg = new ArrayList();
        this.zzbqh = new ArrayList();
        this.zzbqi = new ArrayList();
        this.zzbqj = new ArrayList();
        this.zzbqk = new ArrayList();
    }

    public final zzrn zzd(zzri zzri) {
        this.zzboz.add(zzri);
        return this;
    }

    public final zzrn zze(zzri zzri) {
        this.zzbpa.add(zzri);
        return this;
    }

    public final zzrn zzf(zzri zzri) {
        this.zzbpb.add(zzri);
        return this;
    }

    public final zzrn zzfj(String str) {
        this.zzbqj.add(str);
        return this;
    }

    public final zzrn zzg(zzri zzri) {
        this.zzbpc.add(zzri);
        return this;
    }

    public final zzrn zzfk(String str) {
        this.zzbqk.add(str);
        return this;
    }

    public final zzrn zzh(zzri zzri) {
        this.zzbqf.add(zzri);
        return this;
    }

    public final zzrn zzfl(String str) {
        this.zzbqh.add(str);
        return this;
    }

    public final zzrn zzi(zzri zzri) {
        this.zzbqg.add(zzri);
        return this;
    }

    public final zzrn zzfm(String str) {
        this.zzbqi.add(str);
        return this;
    }

    public final zzrm zztg() {
        zzrm zzrm = new zzrm(this.zzboz, this.zzbpa, this.zzbpb, this.zzbpc, this.zzbqf, this.zzbqg, this.zzbqh, this.zzbqi, this.zzbqj, this.zzbqk);
        return zzrm;
    }
}
