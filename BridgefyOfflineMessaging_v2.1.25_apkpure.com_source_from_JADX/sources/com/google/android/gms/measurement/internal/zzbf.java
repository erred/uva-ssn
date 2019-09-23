package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbf {
    private boolean value;
    private final boolean zzanr = true;
    private boolean zzans;
    private final /* synthetic */ zzbd zzant;
    private final String zzoj;

    public zzbf(zzbd zzbd, String str, boolean z) {
        this.zzant = zzbd;
        Preconditions.checkNotEmpty(str);
        this.zzoj = str;
    }

    public final boolean get() {
        if (!this.zzans) {
            this.zzans = true;
            this.value = this.zzant.zzju().getBoolean(this.zzoj, this.zzanr);
        }
        return this.value;
    }

    public final void set(boolean z) {
        Editor edit = this.zzant.zzju().edit();
        edit.putBoolean(this.zzoj, z);
        edit.apply();
        this.value = z;
    }
}
