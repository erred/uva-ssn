package com.google.android.gms.internal.measurement;

import android.net.Uri;

public final class zzso {
    private final String zzbrs;
    /* access modifiers changed from: private */
    public final Uri zzbrt;
    /* access modifiers changed from: private */
    public final String zzbru;
    /* access modifiers changed from: private */
    public final String zzbrv;
    private final boolean zzbrw;
    private final boolean zzbrx;
    private final boolean zzbry;

    public zzso(Uri uri) {
        this(null, uri, "", "", false, false, false);
    }

    private zzso(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3) {
        this.zzbrs = null;
        this.zzbrt = uri;
        this.zzbru = str2;
        this.zzbrv = str3;
        this.zzbrw = false;
        this.zzbrx = false;
        this.zzbry = false;
    }

    public final zzsi<Long> zze(String str, long j) {
        return zzsi.zza(this, str, j);
    }

    public final zzsi<Boolean> zzd(String str, boolean z) {
        return zzsi.zza(this, str, z);
    }

    public final zzsi<Integer> zzd(String str, int i) {
        return zzsi.zza(this, str, i);
    }

    public final zzsi<Double> zzb(String str, double d) {
        return zzsi.zza(this, str, d);
    }

    public final zzsi<String> zzy(String str, String str2) {
        return zzsi.zza(this, str, str2);
    }
}
