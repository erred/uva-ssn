package com.bridgefy.sdk.framework.controller;

import android.content.Context;
import com.bridgefy.sdk.client.Config;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Device;
import p000a.p013b.C0330h;
import p000a.p013b.C0344k;
import p000a.p013b.p039i.C0341a;

/* renamed from: com.bridgefy.sdk.framework.controller.c */
abstract class C1906c {

    /* renamed from: a */
    protected String f5926a = getClass().getSimpleName();

    /* renamed from: b */
    C0341a<Device> f5927b;

    /* renamed from: c */
    C0330h<Device> f5928c;

    /* renamed from: d */
    private Config f5929d;

    /* renamed from: e */
    private boolean f5930e = false;

    C1906c() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7478a(Context context, Config config) {
        this.f5927b = new connection_subscriber();
        this.f5928c.mo537a((C0344k<? super T>) this.f5927b);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7477a(Context context) {
        if (this.f5927b != null) {
            this.f5927b.dispose();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7479a(Antenna antenna) {
        DeviceManager.m7714a(antenna);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo7482a() {
        return this.f5930e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7481a(boolean z) {
        this.f5930e = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Config mo7483b() {
        return this.f5929d;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7480a(Config config) {
        this.f5929d = config;
    }
}
