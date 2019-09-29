package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;

final class zzx extends Handler {
    private final ContainerAvailableListener zzbae;
    private final /* synthetic */ zzv zzbaf;

    public zzx(zzv zzv, ContainerAvailableListener containerAvailableListener, Looper looper) {
        this.zzbaf = zzv;
        super(looper);
        this.zzbae = containerAvailableListener;
    }

    public final void handleMessage(Message message) {
        if (message.what != 1) {
            zzdi.m8600e("Don't know how to handle this message.");
            return;
        }
        this.zzbae.onContainerAvailable(this.zzbaf, (String) message.obj);
    }
}
