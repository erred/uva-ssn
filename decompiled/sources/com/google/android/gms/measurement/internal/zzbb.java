package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

class zzbb extends BroadcastReceiver {
    @VisibleForTesting
    private static final String zzabi = "com.google.android.gms.measurement.internal.zzbb";
    private boolean zzabj;
    private boolean zzabk;
    /* access modifiers changed from: private */
    public final zzfo zzamv;

    zzbb(zzfo zzfo) {
        Preconditions.checkNotNull(zzfo);
        this.zzamv = zzfo;
    }

    public void onReceive(Context context, Intent intent) {
        this.zzamv.zzlx();
        String action = intent.getAction();
        this.zzamv.zzgt().zzjo().zzg("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzfb = this.zzamv.zzlt().zzfb();
            if (this.zzabk != zzfb) {
                this.zzabk = zzfb;
                this.zzamv.zzgs().zzc((Runnable) new zzbc(this, zzfb));
            }
            return;
        }
        this.zzamv.zzgt().zzjj().zzg("NetworkBroadcastReceiver received unknown action", action);
    }

    public final void zzey() {
        this.zzamv.zzlx();
        this.zzamv.zzgs().zzaf();
        if (!this.zzabj) {
            this.zzamv.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.zzabk = this.zzamv.zzlt().zzfb();
            this.zzamv.zzgt().zzjo().zzg("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzabk));
            this.zzabj = true;
        }
    }

    public final void unregister() {
        this.zzamv.zzlx();
        this.zzamv.zzgs().zzaf();
        this.zzamv.zzgs().zzaf();
        if (this.zzabj) {
            this.zzamv.zzgt().zzjo().zzby("Unregistering connectivity change receiver");
            this.zzabj = false;
            this.zzabk = false;
            try {
                this.zzamv.getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzamv.zzgt().zzjg().zzg("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
