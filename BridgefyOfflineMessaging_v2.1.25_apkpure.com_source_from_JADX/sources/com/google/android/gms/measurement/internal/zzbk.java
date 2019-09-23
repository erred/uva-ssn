package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zzu;
import com.google.android.gms.internal.measurement.zzv;

public final class zzbk implements ServiceConnection {
    /* access modifiers changed from: private */
    public final String packageName;
    final /* synthetic */ zzbj zzanz;

    zzbk(zzbj zzbj, String str) {
        this.zzanz = zzbj;
        this.packageName = str;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.zzanz.zzada.zzgt().zzjj().zzby("Install Referrer connection returned with null binder");
            return;
        }
        try {
            zzu zza = zzv.zza(iBinder);
            if (zza == null) {
                this.zzanz.zzada.zzgt().zzjj().zzby("Install Referrer Service implementation was not found");
                return;
            }
            this.zzanz.zzada.zzgt().zzjm().zzby("Install Referrer Service connected");
            this.zzanz.zzada.zzgs().zzc((Runnable) new zzbl(this, zza, this));
        } catch (Exception e) {
            this.zzanz.zzada.zzgt().zzjj().zzg("Exception occurred while calling Install Referrer API", e);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.zzanz.zzada.zzgt().zzjm().zzby("Install Referrer Service disconnected");
    }
}
