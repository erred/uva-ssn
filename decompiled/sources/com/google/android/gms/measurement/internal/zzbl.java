package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzu;
import com.google.firebase.analytics.FirebaseAnalytics.Param;

final class zzbl implements Runnable {
    private final /* synthetic */ zzu zzaoa;
    private final /* synthetic */ ServiceConnection zzaob;
    private final /* synthetic */ zzbk zzaoc;

    zzbl(zzbk zzbk, zzu zzu, ServiceConnection serviceConnection) {
        this.zzaoc = zzbk;
        this.zzaoa = zzu;
        this.zzaob = serviceConnection;
    }

    public final void run() {
        zzbj zzbj = this.zzaoc.zzanz;
        String zza = this.zzaoc.packageName;
        zzu zzu = this.zzaoa;
        ServiceConnection serviceConnection = this.zzaob;
        Bundle zza2 = zzbj.zza(zza, zzu);
        zzbj.zzada.zzgs().zzaf();
        if (zza2 != null) {
            long j = zza2.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                zzbj.zzada.zzgt().zzjg().zzby("Service response is missing Install Referrer install timestamp");
            } else {
                String string = zza2.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzbj.zzada.zzgt().zzjg().zzby("No referrer defined in install referrer response");
                } else {
                    zzbj.zzada.zzgt().zzjo().zzg("InstallReferrer API result", string);
                    zzfy zzgr = zzbj.zzada.zzgr();
                    String str = "?";
                    String valueOf = String.valueOf(string);
                    Bundle zza3 = zzgr.zza(Uri.parse(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)));
                    if (zza3 == null) {
                        zzbj.zzada.zzgt().zzjg().zzby("No campaign params defined in install referrer result");
                    } else {
                        String string2 = zza3.getString(Param.MEDIUM);
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = zza2.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j2 == 0) {
                                zzbj.zzada.zzgt().zzjg().zzby("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zza3.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzbj.zzada.zzgu().zzang.get()) {
                            zzbj.zzada.zzgw();
                            zzbj.zzada.zzgt().zzjo().zzby("Campaign has already been logged");
                        } else {
                            zzbj.zzada.zzgu().zzang.set(j);
                            zzbj.zzada.zzgw();
                            zzbj.zzada.zzgt().zzjo().zzg("Logging Install Referrer campaign from sdk with ", "referrer API");
                            zza3.putString("_cis", "referrer API");
                            zzbj.zzada.zzgj().logEvent("auto", "_cmp", zza3);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzbj.zzada.getContext(), serviceConnection);
        }
    }
}
