package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzrm {
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

    private zzrm(List<zzri> list, List<zzri> list2, List<zzri> list3, List<zzri> list4, List<zzri> list5, List<zzri> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
        this.zzboz = Collections.unmodifiableList(list);
        this.zzbpa = Collections.unmodifiableList(list2);
        this.zzbpb = Collections.unmodifiableList(list3);
        this.zzbpc = Collections.unmodifiableList(list4);
        this.zzbqf = Collections.unmodifiableList(list5);
        this.zzbqg = Collections.unmodifiableList(list6);
        this.zzbqh = Collections.unmodifiableList(list7);
        this.zzbqi = Collections.unmodifiableList(list8);
        this.zzbqj = Collections.unmodifiableList(list9);
        this.zzbqk = Collections.unmodifiableList(list10);
    }

    public final List<zzri> zzsk() {
        return this.zzboz;
    }

    public final List<zzri> zzsl() {
        return this.zzbpa;
    }

    public final List<zzri> zzsm() {
        return this.zzbpb;
    }

    public final List<zzri> zzsn() {
        return this.zzbpc;
    }

    public final List<zzri> zzte() {
        return this.zzbqf;
    }

    public final List<zzri> zztf() {
        return this.zzbqg;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzboz);
        String valueOf2 = String.valueOf(this.zzbpa);
        String valueOf3 = String.valueOf(this.zzbpb);
        String valueOf4 = String.valueOf(this.zzbpc);
        String valueOf5 = String.valueOf(this.zzbqf);
        String valueOf6 = String.valueOf(this.zzbqg);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 102 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length() + String.valueOf(valueOf6).length());
        sb.append("Positive predicates: ");
        sb.append(valueOf);
        sb.append("  Negative predicates: ");
        sb.append(valueOf2);
        sb.append("  Add tags: ");
        sb.append(valueOf3);
        sb.append("  Remove tags: ");
        sb.append(valueOf4);
        sb.append("  Add macros: ");
        sb.append(valueOf5);
        sb.append("  Remove macros: ");
        sb.append(valueOf6);
        return sb.toString();
    }
}
