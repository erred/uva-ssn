package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class zzbu<V> extends FutureTask<V> implements Comparable<zzbu> {
    private final String zzapa;
    private final /* synthetic */ zzbr zzapb;
    private final long zzapc = zzbr.zzaoz.getAndIncrement();
    final boolean zzapd;

    zzbu(zzbr zzbr, Callable<V> callable, boolean z, String str) {
        this.zzapb = zzbr;
        super(callable);
        Preconditions.checkNotNull(str);
        this.zzapa = str;
        this.zzapd = z;
        if (this.zzapc == Long.MAX_VALUE) {
            zzbr.zzgt().zzjg().zzby("Tasks index overflow");
        }
    }

    zzbu(zzbr zzbr, Runnable runnable, boolean z, String str) {
        this.zzapb = zzbr;
        super(runnable, null);
        Preconditions.checkNotNull(str);
        this.zzapa = str;
        this.zzapd = false;
        if (this.zzapc == Long.MAX_VALUE) {
            zzbr.zzgt().zzjg().zzby("Tasks index overflow");
        }
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.zzapb.zzgt().zzjg().zzg(this.zzapa, th);
        if (th instanceof zzbs) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        zzbu zzbu = (zzbu) obj;
        if (this.zzapd != zzbu.zzapd) {
            return this.zzapd ? -1 : 1;
        }
        if (this.zzapc < zzbu.zzapc) {
            return -1;
        }
        if (this.zzapc > zzbu.zzapc) {
            return 1;
        }
        this.zzapb.zzgt().zzjh().zzg("Two tasks share the same index. index", Long.valueOf(this.zzapc));
        return 0;
    }
}
