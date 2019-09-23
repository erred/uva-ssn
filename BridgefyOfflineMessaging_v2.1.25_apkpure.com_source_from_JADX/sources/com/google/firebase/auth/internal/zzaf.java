package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener;

final class zzaf implements BackgroundStateChangeListener {
    private final /* synthetic */ zzae zzsc;

    zzaf(zzae zzae) {
        this.zzsc = zzae;
    }

    public final void onBackgroundStateChanged(boolean z) {
        if (z) {
            this.zzsc.zzsb = true;
            this.zzsc.cancel();
            return;
        }
        this.zzsc.zzsb = false;
        if (this.zzsc.zzep()) {
            this.zzsc.zzsa.zzeh();
        }
    }
}
