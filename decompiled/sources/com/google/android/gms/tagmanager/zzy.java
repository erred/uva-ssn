package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzl;
import com.google.android.gms.internal.measurement.zzo;
import com.google.android.gms.internal.measurement.zzre;
import com.google.android.gms.internal.measurement.zzrf;
import com.google.android.gms.internal.measurement.zzrk;

@ShowFirstParty
public final class zzy extends BasePendingResult<ContainerHolder> {
    private final String zzazo;
    /* access modifiers changed from: private */
    public long zzazt;
    private final Looper zzazw;
    private final TagManager zzbad;
    private final zzaf zzbag;
    /* access modifiers changed from: private */
    public final zzej zzbah;
    private final int zzbai;
    /* access modifiers changed from: private */
    public final zzai zzbaj;
    private zzah zzbak;
    private zzrf zzbal;
    /* access modifiers changed from: private */
    public volatile zzv zzbam;
    /* access modifiers changed from: private */
    public volatile boolean zzban;
    /* access modifiers changed from: private */
    public zzo zzbao;
    private String zzbap;
    private zzag zzbaq;
    private zzac zzbar;
    private final Context zzri;
    /* access modifiers changed from: private */
    public final Clock zzrz;

    public zzy(Context context, TagManager tagManager, Looper looper, String str, int i, zzal zzal) {
        Context context2 = context;
        String str2 = str;
        zzex zzex = new zzex(context2, str2);
        zzes zzes = new zzes(context2, str2, zzal);
        zzrf zzrf = new zzrf(context2);
        Clock instance = DefaultClock.getInstance();
        zzdg zzdg = new zzdg(1, 5, 900000, 5000, "refreshing", DefaultClock.getInstance());
        this(context2, tagManager, looper, str2, i, zzex, zzes, zzrf, instance, zzdg, new zzai(context2, str2));
        this.zzbal.zzfh(zzal.zzoe());
    }

    @VisibleForTesting
    private zzy(Context context, TagManager tagManager, Looper looper, String str, int i, zzah zzah, zzag zzag, zzrf zzrf, Clock clock, zzej zzej, zzai zzai) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.zzri = context;
        this.zzbad = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.zzazw = looper;
        this.zzazo = str;
        this.zzbai = i;
        this.zzbak = zzah;
        this.zzbaq = zzag;
        this.zzbal = zzrf;
        this.zzbag = new zzaf(this, null);
        this.zzbao = new zzo();
        this.zzrz = clock;
        this.zzbah = zzej;
        this.zzbaj = zzai;
        if (zznw()) {
            zzdf(zzeh.zzpm().zzpo());
        }
    }

    public final void zznt() {
        zzrk zzv = this.zzbak.zzv(this.zzbai);
        if (zzv != null) {
            Container container = new Container(this.zzri, this.zzbad.getDataLayer(), this.zzazo, 0, zzv);
            setResult(new zzv(this.zzbad, this.zzazw, container, new zzaa(this)));
        } else {
            String str = "Default was requested, but no default container was found";
            zzdi.m8600e(str);
            setResult(createFailedResult(new Status(10, str, null)));
        }
        this.zzbaq = null;
        this.zzbak = null;
    }

    public final void zznu() {
        zzn(false);
    }

    public final void zznv() {
        zzn(true);
    }

    private final void zzn(boolean z) {
        this.zzbak.zza((zzdh<zzre>) new zzad<zzre>(this, null));
        this.zzbaq.zza(new zzae(this, null));
        zzrk zzv = this.zzbak.zzv(this.zzbai);
        if (zzv != null) {
            TagManager tagManager = this.zzbad;
            Looper looper = this.zzazw;
            Container container = new Container(this.zzri, this.zzbad.getDataLayer(), this.zzazo, 0, zzv);
            this.zzbam = new zzv(tagManager, looper, container, this.zzbag);
        }
        this.zzbar = new zzab(this, z);
        if (zznw()) {
            this.zzbaq.zza(0, "");
        } else {
            this.zzbak.zzny();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0074, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.internal.measurement.zzo r10, long r11, boolean r13) {
        /*
            r9 = this;
            monitor-enter(r9)
            if (r13 == 0) goto L_0x0008
            boolean r13 = r9.zzban     // Catch:{ all -> 0x0006 }
            goto L_0x0008
        L_0x0006:
            r10 = move-exception
            goto L_0x0075
        L_0x0008:
            boolean r13 = r9.isReady()     // Catch:{ all -> 0x0006 }
            if (r13 == 0) goto L_0x0014
            com.google.android.gms.tagmanager.zzv r13 = r9.zzbam     // Catch:{ all -> 0x0006 }
            if (r13 != 0) goto L_0x0014
            monitor-exit(r9)
            return
        L_0x0014:
            r9.zzbao = r10     // Catch:{ all -> 0x0006 }
            r9.zzazt = r11     // Catch:{ all -> 0x0006 }
            com.google.android.gms.tagmanager.zzai r13 = r9.zzbaj     // Catch:{ all -> 0x0006 }
            long r0 = r13.zznz()     // Catch:{ all -> 0x0006 }
            r2 = 0
            long r4 = r9.zzazt     // Catch:{ all -> 0x0006 }
            r13 = 0
            long r4 = r4 + r0
            com.google.android.gms.common.util.Clock r13 = r9.zzrz     // Catch:{ all -> 0x0006 }
            long r6 = r13.currentTimeMillis()     // Catch:{ all -> 0x0006 }
            r13 = 0
            long r4 = r4 - r6
            long r0 = java.lang.Math.min(r0, r4)     // Catch:{ all -> 0x0006 }
            long r0 = java.lang.Math.max(r2, r0)     // Catch:{ all -> 0x0006 }
            r9.zzao(r0)     // Catch:{ all -> 0x0006 }
            com.google.android.gms.tagmanager.Container r13 = new com.google.android.gms.tagmanager.Container     // Catch:{ all -> 0x0006 }
            android.content.Context r3 = r9.zzri     // Catch:{ all -> 0x0006 }
            com.google.android.gms.tagmanager.TagManager r0 = r9.zzbad     // Catch:{ all -> 0x0006 }
            com.google.android.gms.tagmanager.DataLayer r4 = r0.getDataLayer()     // Catch:{ all -> 0x0006 }
            java.lang.String r5 = r9.zzazo     // Catch:{ all -> 0x0006 }
            r2 = r13
            r6 = r11
            r8 = r10
            r2.<init>(r3, r4, r5, r6, r8)     // Catch:{ all -> 0x0006 }
            com.google.android.gms.tagmanager.zzv r10 = r9.zzbam     // Catch:{ all -> 0x0006 }
            if (r10 != 0) goto L_0x005b
            com.google.android.gms.tagmanager.zzv r10 = new com.google.android.gms.tagmanager.zzv     // Catch:{ all -> 0x0006 }
            com.google.android.gms.tagmanager.TagManager r11 = r9.zzbad     // Catch:{ all -> 0x0006 }
            android.os.Looper r12 = r9.zzazw     // Catch:{ all -> 0x0006 }
            com.google.android.gms.tagmanager.zzaf r0 = r9.zzbag     // Catch:{ all -> 0x0006 }
            r10.<init>(r11, r12, r13, r0)     // Catch:{ all -> 0x0006 }
            r9.zzbam = r10     // Catch:{ all -> 0x0006 }
            goto L_0x0060
        L_0x005b:
            com.google.android.gms.tagmanager.zzv r10 = r9.zzbam     // Catch:{ all -> 0x0006 }
            r10.zza(r13)     // Catch:{ all -> 0x0006 }
        L_0x0060:
            boolean r10 = r9.isReady()     // Catch:{ all -> 0x0006 }
            if (r10 != 0) goto L_0x0073
            com.google.android.gms.tagmanager.zzac r10 = r9.zzbar     // Catch:{ all -> 0x0006 }
            boolean r10 = r10.zzb(r13)     // Catch:{ all -> 0x0006 }
            if (r10 == 0) goto L_0x0073
            com.google.android.gms.tagmanager.zzv r10 = r9.zzbam     // Catch:{ all -> 0x0006 }
            r9.setResult(r10)     // Catch:{ all -> 0x0006 }
        L_0x0073:
            monitor-exit(r9)
            return
        L_0x0075:
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzy.zza(com.google.android.gms.internal.measurement.zzo, long, boolean):void");
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final synchronized void zzdf(String str) {
        this.zzbap = str;
        if (this.zzbaq != null) {
            this.zzbaq.zzdg(str);
        }
    }

    /* access modifiers changed from: 0000 */
    public final synchronized String zznq() {
        return this.zzbap;
    }

    /* access modifiers changed from: private */
    public final synchronized void zzao(long j) {
        if (this.zzbaq == null) {
            zzdi.zzab("Refresh requested, but no network load scheduler.");
        } else {
            this.zzbaq.zza(j, this.zzbao.zzqh);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zza */
    public final ContainerHolder createFailedResult(Status status) {
        if (this.zzbam != null) {
            return this.zzbam;
        }
        if (status == Status.RESULT_TIMEOUT) {
            zzdi.m8600e("timer expired: setting result to failure");
        }
        return new zzv(status);
    }

    /* access modifiers changed from: private */
    public final boolean zznw() {
        zzeh zzpm = zzeh.zzpm();
        return (zzpm.zzpn() == zza.CONTAINER || zzpm.zzpn() == zza.CONTAINER_DEBUG) && this.zzazo.equals(zzpm.getContainerId());
    }

    /* access modifiers changed from: private */
    public final synchronized void zza(zzo zzo) {
        if (this.zzbak != null) {
            zzre zzre = new zzre();
            zzre.zzbqc = this.zzazt;
            zzre.zzqg = new zzl();
            zzre.zzbqd = zzo;
            this.zzbak.zza(zzre);
        }
    }
}
