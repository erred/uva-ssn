package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

final /* synthetic */ class zzsq implements OnSharedPreferenceChangeListener {
    private final zzsp zzbsc;

    zzsq(zzsp zzsp) {
        this.zzbsc = zzsp;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zzbsc.zza(sharedPreferences, str);
    }
}
