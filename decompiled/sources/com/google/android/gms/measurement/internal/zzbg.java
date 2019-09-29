package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbg {
    private long value;
    private boolean zzans;
    private final /* synthetic */ zzbd zzant;
    private final long zzanu;
    private final String zzoj;

    public zzbg(zzbd zzbd, String str, long j) {
        this.zzant = zzbd;
        Preconditions.checkNotEmpty(str);
        this.zzoj = str;
        this.zzanu = j;
    }

    public final long get() {
        if (!this.zzans) {
            this.zzans = true;
            this.value = this.zzant.zzju().getLong(this.zzoj, this.zzanu);
        }
        return this.value;
    }

    public final void set(long j) {
        Editor edit = this.zzant.zzju().edit();
        edit.putLong(this.zzoj, j);
        edit.apply();
        this.value = j;
    }
}
