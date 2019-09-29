package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class zzrp {
    private static final Integer zzbql = Integer.valueOf(0);
    private static final Integer zzbqm = Integer.valueOf(1);
    private final ExecutorService zzadl;
    private final Context zzri;

    public zzrp(Context context) {
        this(context, Executors.newSingleThreadExecutor());
    }

    @VisibleForTesting
    private zzrp(Context context, ExecutorService executorService) {
        this.zzri = context;
        this.zzadl = executorService;
    }
}
