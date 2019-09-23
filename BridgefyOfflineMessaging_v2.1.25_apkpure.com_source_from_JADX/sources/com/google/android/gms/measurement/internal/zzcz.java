package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzcz {
    boolean zzadg = true;
    String zzadi;
    String zzaph;
    String zzapi;
    Boolean zzaqb;
    zzan zzaqw;
    final Context zzri;

    @VisibleForTesting
    public zzcz(Context context, zzan zzan) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zzri = applicationContext;
        if (zzan != null) {
            this.zzaqw = zzan;
            this.zzadi = zzan.zzadi;
            this.zzaph = zzan.origin;
            this.zzapi = zzan.zzadh;
            this.zzadg = zzan.zzadg;
            if (zzan.zzadj != null) {
                this.zzaqb = Boolean.valueOf(zzan.zzadj.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
