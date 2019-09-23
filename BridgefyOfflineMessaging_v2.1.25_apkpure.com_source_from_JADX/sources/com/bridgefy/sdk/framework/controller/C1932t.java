package com.bridgefy.sdk.framework.controller;

import com.bridgefy.sdk.client.Device;
import java.util.UUID;
import p000a.p013b.C0159b;

/* renamed from: com.bridgefy.sdk.framework.controller.t */
abstract class C1932t implements Comparable {

    /* renamed from: a */
    private String f6004a = UUID.randomUUID().toString();

    /* renamed from: b */
    private Device f6005b;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract C0159b mo7509a();

    C1932t(Device device) {
        this.f6005b = device;
    }

    /* renamed from: b */
    public Device mo7556b() {
        return this.f6005b;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C1932t)) {
            return false;
        }
        C1932t tVar = (C1932t) obj;
        if (this.f6005b.getDeviceAddress().equalsIgnoreCase(tVar.mo7556b().getDeviceAddress()) || this.f6005b.getCrc() == tVar.mo7556b().getCrc()) {
            z = true;
        }
        return z;
    }

    public int compareTo(Object obj) {
        return this.f6005b.getDeviceAddress().compareTo(((C1932t) obj).mo7556b().getDeviceAddress());
    }
}
