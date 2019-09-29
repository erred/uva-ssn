package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Message;

final class zzfr implements zzfq {
    private Handler handler;
    final /* synthetic */ zzfn zzbgj;

    private zzfr(zzfn zzfn) {
        this.zzbgj = zzfn;
        this.handler = new Handler(this.zzbgj.zzbfy.getMainLooper(), new zzfs(this));
    }

    public final void zzqh() {
        this.handler.removeMessages(1, zzfn.zzbfx);
        this.handler.sendMessage(obtainMessage());
    }

    public final void cancel() {
        this.handler.removeMessages(1, zzfn.zzbfx);
    }

    public final void zzh(long j) {
        this.handler.removeMessages(1, zzfn.zzbfx);
        this.handler.sendMessageDelayed(obtainMessage(), j);
    }

    private final Message obtainMessage() {
        return this.handler.obtainMessage(1, zzfn.zzbfx);
    }

    /* synthetic */ zzfr(zzfn zzfn, zzfo zzfo) {
        this(zzfn);
    }
}
