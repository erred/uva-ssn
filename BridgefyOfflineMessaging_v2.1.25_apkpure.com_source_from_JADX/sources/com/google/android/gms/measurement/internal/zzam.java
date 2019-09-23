package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzam extends zzf {
    private String zzafi;
    private String zzafp;
    private long zzafs;
    private String zzafv;
    private int zzagp;
    private int zzalk;
    private long zzall;
    private String zztr;
    private String zzts;
    private String zztt;

    zzam(zzbw zzbw) {
        super(zzbw);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgy() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x019f A[Catch:{ IllegalStateException -> 0x01d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01a2 A[Catch:{ IllegalStateException -> 0x01d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01ab A[Catch:{ IllegalStateException -> 0x01d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01be A[Catch:{ IllegalStateException -> 0x01d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzgz() {
        /*
            r10 = this;
            java.lang.String r0 = "unknown"
            java.lang.String r1 = "Unknown"
            java.lang.String r2 = "Unknown"
            android.content.Context r3 = r10.getContext()
            java.lang.String r3 = r3.getPackageName()
            android.content.Context r4 = r10.getContext()
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            r5 = 0
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 != 0) goto L_0x002d
            com.google.android.gms.measurement.internal.zzas r4 = r10.zzgt()
            com.google.android.gms.measurement.internal.zzau r4 = r4.zzjg()
            java.lang.String r7 = "PackageManager is null, app identity information might be inaccurate. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzas.zzbw(r3)
            r4.zzg(r7, r8)
            goto L_0x008b
        L_0x002d:
            java.lang.String r7 = r4.getInstallerPackageName(r3)     // Catch:{ IllegalArgumentException -> 0x0033 }
            r0 = r7
            goto L_0x0044
        L_0x0033:
            com.google.android.gms.measurement.internal.zzas r7 = r10.zzgt()
            com.google.android.gms.measurement.internal.zzau r7 = r7.zzjg()
            java.lang.String r8 = "Error retrieving app installer package name. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzas.zzbw(r3)
            r7.zzg(r8, r9)
        L_0x0044:
            if (r0 != 0) goto L_0x0049
            java.lang.String r0 = "manual_install"
            goto L_0x0053
        L_0x0049:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0053
            java.lang.String r0 = ""
        L_0x0053:
            android.content.Context r7 = r10.getContext()     // Catch:{ NameNotFoundException -> 0x007a }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x007a }
            android.content.pm.PackageInfo r7 = r4.getPackageInfo(r7, r5)     // Catch:{ NameNotFoundException -> 0x007a }
            if (r7 == 0) goto L_0x008b
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x007a }
            java.lang.CharSequence r4 = r4.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x007a }
            boolean r8 = android.text.TextUtils.isEmpty(r4)     // Catch:{ NameNotFoundException -> 0x007a }
            if (r8 != 0) goto L_0x0072
            java.lang.String r4 = r4.toString()     // Catch:{ NameNotFoundException -> 0x007a }
            r2 = r4
        L_0x0072:
            java.lang.String r4 = r7.versionName     // Catch:{ NameNotFoundException -> 0x007a }
            int r1 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0079 }
            r6 = r1
            r1 = r4
            goto L_0x008b
        L_0x0079:
            r1 = r4
        L_0x007a:
            com.google.android.gms.measurement.internal.zzas r4 = r10.zzgt()
            com.google.android.gms.measurement.internal.zzau r4 = r4.zzjg()
            java.lang.String r7 = "Error retrieving package info. appId, appName"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzas.zzbw(r3)
            r4.zze(r7, r8, r2)
        L_0x008b:
            r10.zztt = r3
            r10.zzafp = r0
            r10.zzts = r1
            r10.zzalk = r6
            r10.zztr = r2
            r0 = 0
            r10.zzall = r0
            r10.zzgw()
            android.content.Context r2 = r10.getContext()
            com.google.android.gms.common.api.Status r2 = com.google.android.gms.common.api.internal.GoogleServices.initialize(r2)
            r4 = 1
            if (r2 == 0) goto L_0x00af
            boolean r6 = r2.isSuccess()
            if (r6 == 0) goto L_0x00af
            r6 = 1
            goto L_0x00b0
        L_0x00af:
            r6 = 0
        L_0x00b0:
            com.google.android.gms.measurement.internal.zzbw r7 = r10.zzada
            java.lang.String r7 = r7.zzko()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x00cc
            java.lang.String r7 = "am"
            com.google.android.gms.measurement.internal.zzbw r8 = r10.zzada
            java.lang.String r8 = r8.zzkp()
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x00cc
            r7 = 1
            goto L_0x00cd
        L_0x00cc:
            r7 = 0
        L_0x00cd:
            r6 = r6 | r7
            if (r6 != 0) goto L_0x00f9
            if (r2 != 0) goto L_0x00e0
            com.google.android.gms.measurement.internal.zzas r2 = r10.zzgt()
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjg()
            java.lang.String r7 = "GoogleService failed to initialize (no status)"
            r2.zzby(r7)
            goto L_0x00f9
        L_0x00e0:
            com.google.android.gms.measurement.internal.zzas r7 = r10.zzgt()
            com.google.android.gms.measurement.internal.zzau r7 = r7.zzjg()
            java.lang.String r8 = "GoogleService failed to initialize, status"
            int r9 = r2.getStatusCode()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = r2.getStatusMessage()
            r7.zze(r8, r9, r2)
        L_0x00f9:
            if (r6 == 0) goto L_0x0165
            com.google.android.gms.measurement.internal.zzq r2 = r10.zzgv()
            java.lang.Boolean r2 = r2.zzia()
            com.google.android.gms.measurement.internal.zzq r6 = r10.zzgv()
            boolean r6 = r6.zzhz()
            if (r6 == 0) goto L_0x0123
            com.google.android.gms.measurement.internal.zzbw r2 = r10.zzada
            boolean r2 = r2.zzkn()
            if (r2 == 0) goto L_0x0165
            com.google.android.gms.measurement.internal.zzas r2 = r10.zzgt()
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjm()
            java.lang.String r4 = "Collection disabled with firebase_analytics_collection_deactivated=1"
            r2.zzby(r4)
            goto L_0x0165
        L_0x0123:
            if (r2 == 0) goto L_0x0141
            boolean r6 = r2.booleanValue()
            if (r6 != 0) goto L_0x0141
            com.google.android.gms.measurement.internal.zzbw r2 = r10.zzada
            boolean r2 = r2.zzkn()
            if (r2 == 0) goto L_0x0165
            com.google.android.gms.measurement.internal.zzas r2 = r10.zzgt()
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjm()
            java.lang.String r4 = "Collection disabled with firebase_analytics_collection_enabled=0"
            r2.zzby(r4)
            goto L_0x0165
        L_0x0141:
            if (r2 != 0) goto L_0x0157
            boolean r2 = com.google.android.gms.common.api.internal.GoogleServices.isMeasurementExplicitlyDisabled()
            if (r2 == 0) goto L_0x0157
            com.google.android.gms.measurement.internal.zzas r2 = r10.zzgt()
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjm()
            java.lang.String r4 = "Collection disabled with google_app_measurement_enable=0"
            r2.zzby(r4)
            goto L_0x0165
        L_0x0157:
            com.google.android.gms.measurement.internal.zzas r2 = r10.zzgt()
            com.google.android.gms.measurement.internal.zzau r2 = r2.zzjo()
            java.lang.String r6 = "Collection enabled"
            r2.zzby(r6)
            goto L_0x0166
        L_0x0165:
            r4 = 0
        L_0x0166:
            java.lang.String r2 = ""
            r10.zzafi = r2
            java.lang.String r2 = ""
            r10.zzafv = r2
            r10.zzafs = r0
            r10.zzgw()
            com.google.android.gms.measurement.internal.zzbw r0 = r10.zzada
            java.lang.String r0 = r0.zzko()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0195
            java.lang.String r0 = "am"
            com.google.android.gms.measurement.internal.zzbw r1 = r10.zzada
            java.lang.String r1 = r1.zzkp()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0195
            com.google.android.gms.measurement.internal.zzbw r0 = r10.zzada
            java.lang.String r0 = r0.zzko()
            r10.zzafv = r0
        L_0x0195:
            java.lang.String r0 = com.google.android.gms.common.api.internal.GoogleServices.getGoogleAppId()     // Catch:{ IllegalStateException -> 0x01d0 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IllegalStateException -> 0x01d0 }
            if (r1 == 0) goto L_0x01a2
            java.lang.String r1 = ""
            goto L_0x01a3
        L_0x01a2:
            r1 = r0
        L_0x01a3:
            r10.zzafi = r1     // Catch:{ IllegalStateException -> 0x01d0 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IllegalStateException -> 0x01d0 }
            if (r0 != 0) goto L_0x01bc
            com.google.android.gms.common.internal.StringResourceValueReader r0 = new com.google.android.gms.common.internal.StringResourceValueReader     // Catch:{ IllegalStateException -> 0x01d0 }
            android.content.Context r1 = r10.getContext()     // Catch:{ IllegalStateException -> 0x01d0 }
            r0.<init>(r1)     // Catch:{ IllegalStateException -> 0x01d0 }
            java.lang.String r1 = "admob_app_id"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ IllegalStateException -> 0x01d0 }
            r10.zzafv = r0     // Catch:{ IllegalStateException -> 0x01d0 }
        L_0x01bc:
            if (r4 == 0) goto L_0x01e2
            com.google.android.gms.measurement.internal.zzas r0 = r10.zzgt()     // Catch:{ IllegalStateException -> 0x01d0 }
            com.google.android.gms.measurement.internal.zzau r0 = r0.zzjo()     // Catch:{ IllegalStateException -> 0x01d0 }
            java.lang.String r1 = "App package, google app id"
            java.lang.String r2 = r10.zztt     // Catch:{ IllegalStateException -> 0x01d0 }
            java.lang.String r4 = r10.zzafi     // Catch:{ IllegalStateException -> 0x01d0 }
            r0.zze(r1, r2, r4)     // Catch:{ IllegalStateException -> 0x01d0 }
            goto L_0x01e2
        L_0x01d0:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzas r1 = r10.zzgt()
            com.google.android.gms.measurement.internal.zzau r1 = r1.zzjg()
            java.lang.String r2 = "getGoogleAppId or isMeasurementEnabled failed with exception. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzas.zzbw(r3)
            r1.zze(r2, r3, r0)
        L_0x01e2:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 16
            if (r0 < r1) goto L_0x01f3
            android.content.Context r0 = r10.getContext()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r10.zzagp = r0
            return
        L_0x01f3:
            r10.zzagp = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzgz():void");
    }

    /* access modifiers changed from: 0000 */
    public final zzk zzbs(String str) {
        String str2;
        zzaf();
        zzgg();
        String zzal = zzal();
        String gmpAppId = getGmpAppId();
        zzcl();
        String str3 = this.zzts;
        long zzjd = (long) zzjd();
        zzcl();
        String str4 = this.zzafp;
        long zzhh = zzgv().zzhh();
        zzcl();
        zzaf();
        if (this.zzall == 0) {
            this.zzall = this.zzada.zzgr().zzd(getContext(), getContext().getPackageName());
        }
        long j = this.zzall;
        boolean isEnabled = this.zzada.isEnabled();
        boolean z = !zzgu().zzanq;
        zzaf();
        zzgg();
        if (!zzgv().zzaz(this.zztt) || this.zzada.isEnabled()) {
            str2 = zzjc();
        } else {
            str2 = null;
        }
        String str5 = str2;
        zzcl();
        boolean z2 = z;
        String str6 = str5;
        long j2 = this.zzafs;
        long zzkt = this.zzada.zzkt();
        int zzje = zzje();
        zzq zzgv = zzgv();
        zzgv.zzgg();
        Boolean zzar = zzgv.zzar("google_analytics_adid_collection_enabled");
        boolean booleanValue = Boolean.valueOf(zzar == null || zzar.booleanValue()).booleanValue();
        zzq zzgv2 = zzgv();
        zzgv2.zzgg();
        Boolean zzar2 = zzgv2.zzar("google_analytics_ssaid_collection_enabled");
        zzk zzk = new zzk(zzal, gmpAppId, str3, zzjd, str4, zzhh, j, str, isEnabled, z2, str6, j2, zzkt, zzje, booleanValue, Boolean.valueOf(zzar2 == null || zzar2.booleanValue()).booleanValue(), zzgu().zzkb(), zzhb());
        return zzk;
    }

    @VisibleForTesting
    private final String zzjc() {
        try {
            Class loadClass = getContext().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (loadClass == null) {
                return null;
            }
            try {
                Object invoke = loadClass.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
                if (invoke == null) {
                    return null;
                }
                try {
                    return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception unused) {
                    zzgt().zzjl().zzby("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                zzgt().zzjk().zzby("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final String zzal() {
        zzcl();
        return this.zztt;
    }

    /* access modifiers changed from: 0000 */
    public final String getGmpAppId() {
        zzcl();
        return this.zzafi;
    }

    /* access modifiers changed from: 0000 */
    public final String zzhb() {
        zzcl();
        return this.zzafv;
    }

    /* access modifiers changed from: 0000 */
    public final int zzjd() {
        zzcl();
        return this.zzalk;
    }

    /* access modifiers changed from: 0000 */
    public final int zzje() {
        zzcl();
        return this.zzagp;
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
