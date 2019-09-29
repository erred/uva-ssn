package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzo;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzes implements zzag {
    private boolean closed;
    /* access modifiers changed from: private */
    public final String zzazo;
    private String zzbap;
    private zzdh<zzo> zzbeq;
    private zzal zzber;
    private final ScheduledExecutorService zzbet;
    private final zzev zzbeu;
    private ScheduledFuture<?> zzbev;
    /* access modifiers changed from: private */
    public final Context zzri;

    public zzes(Context context, String str, zzal zzal) {
        this(context, str, zzal, null, null);
    }

    @VisibleForTesting
    private zzes(Context context, String str, zzal zzal, zzew zzew, zzev zzev) {
        this.zzber = zzal;
        this.zzri = context;
        this.zzazo = str;
        this.zzbet = new zzet(this).zzpq();
        this.zzbeu = new zzeu(this);
    }

    public final synchronized void release() {
        zzpp();
        if (this.zzbev != null) {
            this.zzbev.cancel(false);
        }
        this.zzbet.shutdown();
        this.closed = true;
    }

    public final synchronized void zza(zzdh<zzo> zzdh) {
        zzpp();
        this.zzbeq = zzdh;
    }

    public final synchronized void zza(long j, String str) {
        String str2 = this.zzazo;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 55);
        sb.append("loadAfterDelay: containerId=");
        sb.append(str2);
        sb.append(" delay=");
        sb.append(j);
        zzdi.m8601v(sb.toString());
        zzpp();
        if (this.zzbeq != null) {
            if (this.zzbev != null) {
                this.zzbev.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.zzbet;
            zzer zza = this.zzbeu.zza(this.zzber);
            zza.zza(this.zzbeq);
            zza.zzdg(this.zzbap);
            zza.zzdy(str);
            this.zzbev = scheduledExecutorService.schedule(zza, j, TimeUnit.MILLISECONDS);
        } else {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
    }

    public final synchronized void zzdg(String str) {
        zzpp();
        this.zzbap = str;
    }

    private final synchronized void zzpp() {
        if (this.closed) {
            throw new IllegalStateException("called method after closed");
        }
    }
}
