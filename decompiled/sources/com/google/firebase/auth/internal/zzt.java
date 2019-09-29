package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

final class zzt implements Runnable {
    private final String zzqt;
    final /* synthetic */ zzs zzrh;

    zzt(zzs zzs, String str) {
        this.zzrh = zzs;
        this.zzqt = Preconditions.checkNotEmpty(str);
    }

    public final void run() {
        boolean z;
        FirebaseApp instance = FirebaseApp.getInstance(this.zzqt);
        FirebaseAuth instance2 = FirebaseAuth.getInstance(instance);
        zzy.initialize(instance.getApplicationContext());
        try {
            z = ((Boolean) zzy.zzrn.get()).booleanValue();
        } catch (SecurityException unused) {
            z = true;
        }
        if (instance2.getCurrentUser() != null && z) {
            Task accessToken = instance2.getAccessToken(true);
            zzs.zzgg.mo13502v("Token refreshing started", new Object[0]);
            accessToken.addOnFailureListener(new zzu(this));
        }
    }
}
