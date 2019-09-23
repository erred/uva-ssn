package com.google.firebase.analytics.connector;

import java.util.concurrent.Executor;

final /* synthetic */ class zza implements Executor {
    static final Executor zzbss = new zza();

    private zza() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
