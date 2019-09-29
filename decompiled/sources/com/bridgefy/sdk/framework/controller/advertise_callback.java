package com.bridgefy.sdk.framework.controller;

import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseSettings;
import android.util.Log;

/* renamed from: com.bridgefy.sdk.framework.controller.o */
class advertise_callback extends AdvertiseCallback {
    advertise_callback() {
    }

    public void onStartSuccess(AdvertiseSettings advertiseSettings) {
        super.onStartSuccess(advertiseSettings);
        C1911h.f5955a = 3;
    }

    public void onStartFailure(int i) {
        super.onStartFailure(i);
        StringBuilder sb = new StringBuilder();
        sb.append("Advertising  presence BLE failed ");
        sb.append(i);
        Log.e("Advertise_Callback", sb.toString());
        C1911h.f5955a = 0;
    }
}
