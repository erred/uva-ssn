package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzf;
import com.google.firebase.FirebaseApp;

public final class zzs {
    /* access modifiers changed from: private */
    public static Logger zzgg = new Logger("TokenRefresher", "FirebaseAuth:");
    @VisibleForTesting
    private Handler handler;
    private final FirebaseApp zzgm;
    @VisibleForTesting
    volatile long zzrc;
    @VisibleForTesting
    volatile long zzrd;
    @VisibleForTesting
    private long zzre;
    @VisibleForTesting
    private HandlerThread zzrf = new HandlerThread("TokenRefresher", 10);
    @VisibleForTesting
    private Runnable zzrg;

    public zzs(FirebaseApp firebaseApp) {
        zzgg.mo13502v("Initializing TokenRefresher", new Object[0]);
        this.zzgm = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzrf.start();
        this.handler = new zzf(this.zzrf.getLooper());
        this.zzrg = new zzt(this, this.zzgm.getName());
        this.zzre = 300000;
    }

    public final void zzeh() {
        Logger logger = zzgg;
        long j = this.zzrc - this.zzre;
        StringBuilder sb = new StringBuilder(43);
        sb.append("Scheduling refresh for ");
        sb.append(j);
        logger.mo13502v(sb.toString(), new Object[0]);
        cancel();
        this.zzrd = Math.max((this.zzrc - DefaultClock.getInstance().currentTimeMillis()) - this.zzre, 0) / 1000;
        this.handler.postDelayed(this.zzrg, this.zzrd * 1000);
    }

    /* access modifiers changed from: 0000 */
    public final void zzei() {
        int i = (int) this.zzrd;
        long j = (i == 30 || i == 60 || i == 120 || i == 240 || i == 480) ? 2 * this.zzrd : i != 960 ? 30 : 960;
        this.zzrd = j;
        this.zzrc = DefaultClock.getInstance().currentTimeMillis() + (this.zzrd * 1000);
        Logger logger = zzgg;
        long j2 = this.zzrc;
        StringBuilder sb = new StringBuilder(43);
        sb.append("Scheduling refresh for ");
        sb.append(j2);
        logger.mo13502v(sb.toString(), new Object[0]);
        this.handler.postDelayed(this.zzrg, this.zzrd * 1000);
    }

    public final void cancel() {
        this.handler.removeCallbacks(this.zzrg);
    }
}
