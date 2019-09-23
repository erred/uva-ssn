package com.google.android.gms.tagmanager;

final class zzfp implements Runnable {
    private final /* synthetic */ zzfn zzbgj;

    zzfp(zzfn zzfn) {
        this.zzbgj = zzfn;
    }

    public final void run() {
        this.zzbgj.zzbfz.dispatch();
    }
}
