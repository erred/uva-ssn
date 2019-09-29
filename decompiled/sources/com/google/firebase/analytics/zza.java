package com.google.firebase.analytics;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

final class zza implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zzbso;

    zza(FirebaseAnalytics firebaseAnalytics) {
        this.zzbso = firebaseAnalytics;
    }

    public final /* synthetic */ Object call() throws Exception {
        String zza = this.zzbso.zzgc();
        if (zza != null) {
            return zza;
        }
        String zzag = this.zzbso.zzada.zzgj().zzag(120000);
        if (zzag != null) {
            this.zzbso.zzcp(zzag);
            return zzag;
        }
        throw new TimeoutException();
    }
}
