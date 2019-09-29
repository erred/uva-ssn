package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
@VisibleForTesting
final class zzfn extends zzfm {
    /* access modifiers changed from: private */
    public static final Object zzbfx = new Object();
    private static zzfn zzbgi;
    /* access modifiers changed from: private */
    public boolean connected = true;
    private zzcc zzbdr = new zzfo(this);
    /* access modifiers changed from: private */
    public Context zzbfy;
    /* access modifiers changed from: private */
    public zzcb zzbfz;
    private volatile zzby zzbga;
    /* access modifiers changed from: private */
    public int zzbgb = 1800000;
    private boolean zzbgc = true;
    private boolean zzbgd = false;
    private boolean zzbge = true;
    private zzfq zzbgf;
    private zzdn zzbgg;
    private boolean zzbgh = false;

    public static zzfn zzqe() {
        if (zzbgi == null) {
            zzbgi = new zzfn();
        }
        return zzbgi;
    }

    private zzfn() {
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(android.content.Context r2, com.google.android.gms.tagmanager.zzby r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            android.content.Context r0 = r1.zzbfy     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0015 }
            r1.zzbfy = r2     // Catch:{ all -> 0x0015 }
            com.google.android.gms.tagmanager.zzby r2 = r1.zzbga     // Catch:{ all -> 0x0015 }
            if (r2 != 0) goto L_0x0013
            r1.zzbga = r3     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r1)
            return
        L_0x0015:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzfn.zza(android.content.Context, com.google.android.gms.tagmanager.zzby):void");
    }

    /* access modifiers changed from: 0000 */
    public final synchronized zzcb zzqf() {
        if (this.zzbfz == null) {
            if (this.zzbfy != null) {
                this.zzbfz = new zzeb(this.zzbdr, this.zzbfy);
            } else {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
        }
        if (this.zzbgf == null) {
            this.zzbgf = new zzfr(this, null);
            if (this.zzbgb > 0) {
                this.zzbgf.zzh((long) this.zzbgb);
            }
        }
        this.zzbgd = true;
        if (this.zzbgc) {
            dispatch();
            this.zzbgc = false;
        }
        if (this.zzbgg == null && this.zzbge) {
            this.zzbgg = new zzdn(this);
            zzdn zzdn = this.zzbgg;
            Context context = this.zzbfy;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(zzdn, intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("com.google.analytics.RADIO_POWERED");
            intentFilter2.addCategory(context.getPackageName());
            context.registerReceiver(zzdn, intentFilter2);
        }
        return this.zzbfz;
    }

    public final synchronized void dispatch() {
        if (!this.zzbgd) {
            zzdi.m8601v("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zzbgc = true;
            return;
        }
        this.zzbga.zzh(new zzfp(this));
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final synchronized void zzb(boolean z, boolean z2) {
        boolean isPowerSaveMode = isPowerSaveMode();
        this.zzbgh = z;
        this.connected = z2;
        if (isPowerSaveMode() != isPowerSaveMode) {
            if (isPowerSaveMode()) {
                this.zzbgf.cancel();
                zzdi.m8601v("PowerSaveMode initiated.");
                return;
            }
            this.zzbgf.zzh((long) this.zzbgb);
            zzdi.m8601v("PowerSaveMode terminated.");
        }
    }

    public final synchronized void zzp(boolean z) {
        zzb(this.zzbgh, z);
    }

    public final synchronized void zzqd() {
        if (!isPowerSaveMode()) {
            this.zzbgf.zzqh();
        }
    }

    /* access modifiers changed from: private */
    public final boolean isPowerSaveMode() {
        return this.zzbgh || !this.connected || this.zzbgb <= 0;
    }
}
