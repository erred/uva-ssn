package com.bridgefy.sdk.logging.entities;

import android.os.Build;
import android.os.Build.VERSION;
import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.bridgefy.sdk.framework.utils.Utils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

public class DeviceInfo {

    /* renamed from: a */
    String f6095a;

    /* renamed from: b */
    String f6096b;

    /* renamed from: c */
    long f6097c = System.currentTimeMillis();

    /* renamed from: d */
    String f6098d = BleHandshake.DEVICE_TYPE;

    /* renamed from: e */
    String f6099e = VERSION.RELEASE;

    /* renamed from: f */
    String f6100f;

    /* renamed from: g */
    String f6101g;

    public DeviceInfo(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(Build.MODEL);
        this.f6100f = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Build.MANUFACTURER);
        sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb2.append(Build.MODEL);
        this.f6101g = sb2.toString();
        this.f6095a = str;
        this.f6096b = String.valueOf(Utils.getCrcFromKey(this.f6095a));
    }
}
