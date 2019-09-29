package com.google.android.gms.common.api.internal;

import androidx.p052b.C0712a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;

public final class zak {
    private final C0712a<zai<?>, ConnectionResult> zaay = new C0712a<>();
    private final C0712a<zai<?>, String> zada = new C0712a<>();
    private final TaskCompletionSource<Map<zai<?>, String>> zadb = new TaskCompletionSource<>();
    private int zadc;
    private boolean zadd = false;

    public zak(Iterable<? extends GoogleApi<?>> iterable) {
        for (GoogleApi zak : iterable) {
            this.zaay.put(zak.zak(), null);
        }
        this.zadc = this.zaay.keySet().size();
    }

    public final Set<zai<?>> zap() {
        return this.zaay.keySet();
    }

    public final Task<Map<zai<?>, String>> getTask() {
        return this.zadb.getTask();
    }

    public final void zaa(zai<?> zai, ConnectionResult connectionResult, String str) {
        this.zaay.put(zai, connectionResult);
        this.zada.put(zai, str);
        this.zadc--;
        if (!connectionResult.isSuccess()) {
            this.zadd = true;
        }
        if (this.zadc == 0) {
            if (this.zadd) {
                this.zadb.setException(new AvailabilityException(this.zaay));
                return;
            }
            this.zadb.setResult(this.zada);
        }
    }
}
