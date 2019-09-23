package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzes implements ServiceConnection, BaseConnectionCallbacks, BaseOnConnectionFailedListener {
    final /* synthetic */ zzeb zzasi;
    /* access modifiers changed from: private */
    public volatile boolean zzaso;
    private volatile zzar zzasp;

    protected zzes(zzeb zzeb) {
        this.zzasi = zzeb;
    }

    public final void zzb(Intent intent) {
        this.zzasi.zzaf();
        Context context = this.zzasi.getContext();
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzaso) {
                this.zzasi.zzgt().zzjo().zzby("Connection attempt already in progress");
                return;
            }
            this.zzasi.zzgt().zzjo().zzby("Using local app measurement service");
            this.zzaso = true;
            instance.bindService(context, intent, this.zzasi.zzasb, 129);
        }
    }

    public final void zzlk() {
        if (this.zzasp != null && (this.zzasp.isConnected() || this.zzasp.isConnecting())) {
            this.zzasp.disconnect();
        }
        this.zzasp = null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r3.zzasi.zzgt().zzjg().zzby("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0063 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            java.lang.String r4 = "MeasurementServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r4)
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x001f
            r3.zzaso = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzeb r4 = r3.zzasi     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzas r4 = r4.zzgt()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzau r4 = r4.zzjg()     // Catch:{ all -> 0x001c }
            java.lang.String r5 = "Service connected with null binder"
            r4.zzby(r5)     // Catch:{ all -> 0x001c }
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x001c:
            r4 = move-exception
            goto L_0x009a
        L_0x001f:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0063 }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x0063 }
            if (r2 == 0) goto L_0x0053
            if (r5 != 0) goto L_0x002f
            goto L_0x0043
        L_0x002f:
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x0063 }
            boolean r2 = r1 instanceof com.google.android.gms.measurement.internal.zzaj     // Catch:{ RemoteException -> 0x0063 }
            if (r2 == 0) goto L_0x003d
            com.google.android.gms.measurement.internal.zzaj r1 = (com.google.android.gms.measurement.internal.zzaj) r1     // Catch:{ RemoteException -> 0x0063 }
        L_0x003b:
            r0 = r1
            goto L_0x0043
        L_0x003d:
            com.google.android.gms.measurement.internal.zzal r1 = new com.google.android.gms.measurement.internal.zzal     // Catch:{ RemoteException -> 0x0063 }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x0063 }
            goto L_0x003b
        L_0x0043:
            com.google.android.gms.measurement.internal.zzeb r5 = r3.zzasi     // Catch:{ RemoteException -> 0x0063 }
            com.google.android.gms.measurement.internal.zzas r5 = r5.zzgt()     // Catch:{ RemoteException -> 0x0063 }
            com.google.android.gms.measurement.internal.zzau r5 = r5.zzjo()     // Catch:{ RemoteException -> 0x0063 }
            java.lang.String r1 = "Bound to IMeasurementService interface"
            r5.zzby(r1)     // Catch:{ RemoteException -> 0x0063 }
            goto L_0x0072
        L_0x0053:
            com.google.android.gms.measurement.internal.zzeb r5 = r3.zzasi     // Catch:{ RemoteException -> 0x0063 }
            com.google.android.gms.measurement.internal.zzas r5 = r5.zzgt()     // Catch:{ RemoteException -> 0x0063 }
            com.google.android.gms.measurement.internal.zzau r5 = r5.zzjg()     // Catch:{ RemoteException -> 0x0063 }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.zzg(r2, r1)     // Catch:{ RemoteException -> 0x0063 }
            goto L_0x0072
        L_0x0063:
            com.google.android.gms.measurement.internal.zzeb r5 = r3.zzasi     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzas r5 = r5.zzgt()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzau r5 = r5.zzjg()     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "Service connect failed to get IMeasurementService"
            r5.zzby(r1)     // Catch:{ all -> 0x001c }
        L_0x0072:
            if (r0 != 0) goto L_0x008a
            r3.zzaso = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.common.stats.ConnectionTracker r4 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ IllegalArgumentException -> 0x0098 }
            com.google.android.gms.measurement.internal.zzeb r5 = r3.zzasi     // Catch:{ IllegalArgumentException -> 0x0098 }
            android.content.Context r5 = r5.getContext()     // Catch:{ IllegalArgumentException -> 0x0098 }
            com.google.android.gms.measurement.internal.zzeb r0 = r3.zzasi     // Catch:{ IllegalArgumentException -> 0x0098 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzasb     // Catch:{ IllegalArgumentException -> 0x0098 }
            r4.unbindService(r5, r0)     // Catch:{ IllegalArgumentException -> 0x0098 }
            goto L_0x0098
        L_0x008a:
            com.google.android.gms.measurement.internal.zzeb r4 = r3.zzasi     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzbr r4 = r4.zzgs()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzet r5 = new com.google.android.gms.measurement.internal.zzet     // Catch:{ all -> 0x001c }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x001c }
            r4.zzc(r5)     // Catch:{ all -> 0x001c }
        L_0x0098:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x009a:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzes.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zzasi.zzgt().zzjn().zzby("Service disconnected");
        this.zzasi.zzgs().zzc((Runnable) new zzeu(this, componentName));
    }

    public final void zzll() {
        this.zzasi.zzaf();
        Context context = this.zzasi.getContext();
        synchronized (this) {
            if (this.zzaso) {
                this.zzasi.zzgt().zzjo().zzby("Connection attempt already in progress");
            } else if (this.zzasp == null || (!this.zzasp.isConnecting() && !this.zzasp.isConnected())) {
                this.zzasp = new zzar(context, Looper.getMainLooper(), this, this);
                this.zzasi.zzgt().zzjo().zzby("Connecting to remote service");
                this.zzaso = true;
                this.zzasp.checkAvailabilityAndConnect();
            } else {
                this.zzasi.zzgt().zzjo().zzby("Already awaiting connection attempt");
            }
        }
    }

    public final void onConnected(Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.zzasi.zzgs().zzc((Runnable) new zzev(this, (zzaj) this.zzasp.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzasp = null;
                this.zzaso = false;
            }
        }
    }

    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zzasi.zzgt().zzjn().zzby("Service connection suspended");
        this.zzasi.zzgs().zzc((Runnable) new zzew(this));
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzas zzkj = this.zzasi.zzada.zzkj();
        if (zzkj != null) {
            zzkj.zzjj().zzg("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzaso = false;
            this.zzasp = null;
        }
        this.zzasi.zzgs().zzc((Runnable) new zzex(this));
    }
}
