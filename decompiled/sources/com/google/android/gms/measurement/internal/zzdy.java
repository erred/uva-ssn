package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.p052b.C0712a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

public final class zzdy extends zzf {
    @VisibleForTesting
    protected zzdx zzarq;
    private volatile zzdx zzarr;
    private zzdx zzars;
    private final Map<Activity, zzdx> zzart = new C0712a();
    private zzdx zzaru;
    private String zzarv;

    public zzdy(zzbw zzbw) {
        super(zzbw);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgy() {
        return false;
    }

    public final zzdx zzle() {
        zzcl();
        zzaf();
        return this.zzarq;
    }

    public final void setCurrentScreen(Activity activity, String str, String str2) {
        if (this.zzarr == null) {
            zzgt().zzjj().zzby("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzart.get(activity) == null) {
            zzgt().zzjj().zzby("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zzcq(activity.getClass().getCanonicalName());
            }
            boolean equals = this.zzarr.zzarn.equals(str2);
            boolean zzv = zzfy.zzv(this.zzarr.zzuw, str);
            if (equals && zzv) {
                zzgt().zzjl().zzby("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzgt().zzjj().zzg("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzgt().zzjo().zze("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzdx zzdx = new zzdx(str, str2, zzgr().zzmj());
                this.zzart.put(activity, zzdx);
                zza(activity, zzdx, true);
            } else {
                zzgt().zzjj().zzg("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public final zzdx zzlf() {
        zzgg();
        return this.zzarr;
    }

    private final void zza(Activity activity, zzdx zzdx, boolean z) {
        zzdx zzdx2 = this.zzarr == null ? this.zzars : this.zzarr;
        if (zzdx.zzarn == null) {
            zzdx = new zzdx(zzdx.zzuw, zzcq(activity.getClass().getCanonicalName()), zzdx.zzaro);
        }
        this.zzars = this.zzarr;
        this.zzarr = zzdx;
        zzgs().zzc((Runnable) new zzdz(this, z, zzdx2, zzdx));
    }

    /* access modifiers changed from: private */
    public final void zza(zzdx zzdx, boolean z) {
        zzgi().zzm(zzbx().elapsedRealtime());
        if (zzgo().zza(zzdx.zzarp, z)) {
            zzdx.zzarp = false;
        }
    }

    public static void zza(zzdx zzdx, Bundle bundle, boolean z) {
        if (bundle == null || zzdx == null || (bundle.containsKey("_sc") && !z)) {
            if (bundle != null && zzdx == null && z) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
            }
            return;
        }
        if (zzdx.zzuw != null) {
            bundle.putString("_sn", zzdx.zzuw);
        } else {
            bundle.remove("_sn");
        }
        bundle.putString("_sc", zzdx.zzarn);
        bundle.putLong("_si", zzdx.zzaro);
    }

    public final void zza(String str, zzdx zzdx) {
        zzaf();
        synchronized (this) {
            if (this.zzarv == null || this.zzarv.equals(str) || zzdx != null) {
                this.zzarv = str;
                this.zzaru = zzdx;
            }
        }
    }

    @VisibleForTesting
    private static String zzcq(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    private final zzdx zze(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzdx zzdx = (zzdx) this.zzart.get(activity);
        if (zzdx != null) {
            return zzdx;
        }
        zzdx zzdx2 = new zzdx(null, zzcq(activity.getClass().getCanonicalName()), zzgr().zzmj());
        this.zzart.put(activity, zzdx2);
        return zzdx2;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle("com.google.app_measurement.screen_service");
            if (bundle2 != null) {
                this.zzart.put(activity, new zzdx(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
            }
        }
    }

    public final void onActivityResumed(Activity activity) {
        zza(activity, zze(activity), false);
        zza zzgi = zzgi();
        zzgi.zzgs().zzc((Runnable) new zzd(zzgi, zzgi.zzbx().elapsedRealtime()));
    }

    public final void onActivityPaused(Activity activity) {
        zzdx zze = zze(activity);
        this.zzars = this.zzarr;
        this.zzarr = null;
        zzgs().zzc((Runnable) new zzea(this, zze));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (bundle != null) {
            zzdx zzdx = (zzdx) this.zzart.get(activity);
            if (zzdx != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong("id", zzdx.zzaro);
                bundle2.putString("name", zzdx.zzuw);
                bundle2.putString("referrer_name", zzdx.zzarn);
                bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
            }
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zzart.remove(activity);
    }

    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    public final /* bridge */ /* synthetic */ zza zzgi() {
        return super.zzgi();
    }

    public final /* bridge */ /* synthetic */ zzda zzgj() {
        return super.zzgj();
    }

    public final /* bridge */ /* synthetic */ zzam zzgk() {
        return super.zzgk();
    }

    public final /* bridge */ /* synthetic */ zzeb zzgl() {
        return super.zzgl();
    }

    public final /* bridge */ /* synthetic */ zzdy zzgm() {
        return super.zzgm();
    }

    public final /* bridge */ /* synthetic */ zzao zzgn() {
        return super.zzgn();
    }

    public final /* bridge */ /* synthetic */ zzfd zzgo() {
        return super.zzgo();
    }

    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    public final /* bridge */ /* synthetic */ zzfy zzgr() {
        return super.zzgr();
    }

    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }
}
