package com.google.android.gms.tagmanager;

import android.os.Handler.Callback;
import android.os.Message;

final class zzfs implements Callback {
    private final /* synthetic */ zzfr zzbgk;

    zzfs(zzfr zzfr) {
        this.zzbgk = zzfr;
    }

    public final boolean handleMessage(Message message) {
        if (1 == message.what && zzfn.zzbfx.equals(message.obj)) {
            this.zzbgk.zzbgj.dispatch();
            if (!this.zzbgk.zzbgj.isPowerSaveMode()) {
                this.zzbgk.zzh((long) this.zzbgk.zzbgj.zzbgb);
            }
        }
        return true;
    }
}
