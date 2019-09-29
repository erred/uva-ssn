package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.firebase_auth.zzf;
import java.util.concurrent.Executor;

public final class zzag implements Executor {
    private static zzag zzsd = new zzag();
    private Handler handler = new zzf(Looper.getMainLooper());

    private zzag() {
    }

    public final void execute(Runnable runnable) {
        this.handler.post(runnable);
    }

    public static zzag zzeq() {
        return zzsd;
    }
}
