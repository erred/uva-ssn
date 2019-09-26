package com.bridgefy.sdk.framework.controller;

import android.content.Context;
import com.bridgefy.sdk.client.Config;
import com.bridgefy.sdk.framework.exceptions.ConnectionException;

/* renamed from: com.bridgefy.sdk.framework.controller.aj */
abstract class bluetooth_server<SOCKET, SERVER_SOCKET> extends Thread {

    /* renamed from: a */
    protected Config f5903a;

    /* renamed from: b */
    protected Context f5904b;

    /* renamed from: c */
    public final String f5905c = getClass().getCanonicalName();

    /* renamed from: d */
    private SERVER_SOCKET f5906d;

    /* renamed from: e */
    private boolean f5907e = false;

    /* renamed from: a */
    public abstract void stop_server() throws ConnectionException;

    /* renamed from: b */
    public abstract void start_server() throws ConnectionException;

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public abstract boolean mo7461c();

    protected bluetooth_server(Config config, Context context) throws ConnectionException {
        this.f5903a = config;
        this.f5904b = context;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public SERVER_SOCKET mo7462e() {
        return this.f5906d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7458a(SERVER_SOCKET server_socket) {
        this.f5906d = server_socket;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7460b(boolean z) {
        this.f5907e = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo7463f() {
        return this.f5907e;
    }
}
