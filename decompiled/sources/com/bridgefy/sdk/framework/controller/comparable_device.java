package com.bridgefy.sdk.framework.controller;

import com.bridgefy.sdk.client.Device;
import java.util.UUID;
import p000a.p013b.C0159b;

/* renamed from: com.bridgefy.sdk.framework.controller.t */
abstract class comparable_device implements Comparable {

    /* renamed from: a */
    private String f6004a = UUID.randomUUID().toString();

    /* renamed from: b */
    private Device device;

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract C0159b subscribe_connect();

    comparable_device(Device device) {
        this.device = device;
    }

    /* renamed from: b */
    public Device get_device() {
        return this.device;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof comparable_device)) {
            return false;
        }
        comparable_device tVar = (comparable_device) obj;
        if (this.device.getDeviceAddress().equalsIgnoreCase(tVar.get_device().getDeviceAddress()) || this.device.getCrc() == tVar.get_device().getCrc()) {
            z = true;
        }
        return z;
    }

    public int compareTo(Object obj) {
        return this.device.getDeviceAddress().compareTo(((comparable_device) obj).get_device().getDeviceAddress());
    }
}
