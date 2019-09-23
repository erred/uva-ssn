package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class zzeo implements Runnable {
    private final /* synthetic */ String zzads;
    private final /* synthetic */ String zzadz;
    private final /* synthetic */ String zzagj;
    private final /* synthetic */ zzk zzaqk;
    private final /* synthetic */ zzeb zzasi;
    private final /* synthetic */ AtomicReference zzasj;

    zzeo(zzeb zzeb, AtomicReference atomicReference, String str, String str2, String str3, zzk zzk) {
        this.zzasi = zzeb;
        this.zzasj = atomicReference;
        this.zzagj = str;
        this.zzads = str2;
        this.zzadz = str3;
        this.zzaqk = zzk;
    }

    public final void run() {
        synchronized (this.zzasj) {
            try {
                zzaj zzd = this.zzasi.zzasc;
                if (zzd == null) {
                    this.zzasi.zzgt().zzjg().zzd("Failed to get conditional properties", zzas.zzbw(this.zzagj), this.zzads, this.zzadz);
                    this.zzasj.set(Collections.emptyList());
                    this.zzasj.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.zzagj)) {
                    this.zzasj.set(zzd.zza(this.zzads, this.zzadz, this.zzaqk));
                } else {
                    this.zzasj.set(zzd.zze(this.zzagj, this.zzads, this.zzadz));
                }
                this.zzasi.zzcy();
                this.zzasj.notify();
            } catch (RemoteException e) {
                try {
                    this.zzasi.zzgt().zzjg().zzd("Failed to get conditional properties", zzas.zzbw(this.zzagj), this.zzads, e);
                    this.zzasj.set(Collections.emptyList());
                    this.zzasj.notify();
                } catch (Throwable th) {
                    this.zzasj.notify();
                    throw th;
                }
            }
        }
    }
}
