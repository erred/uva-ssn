package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.UUID;

/* renamed from: com.bridgefy.sdk.framework.controller.y */
class C1938y extends C1891ab {

    /* renamed from: a */
    private final UUID f6018a;

    /* renamed from: b */
    private final UUID f6019b;

    /* renamed from: c */
    private final UUID f6020c;

    /* renamed from: d */
    private final C1937x f6021d;

    /* renamed from: a */
    public boolean mo7425a() {
        return true;
    }

    /* renamed from: a */
    public void mo7423a(BluetoothGatt bluetoothGatt) {
        bluetoothGatt.readDescriptor(bluetoothGatt.getService(this.f6018a).getCharacteristic(this.f6019b).getDescriptor(this.f6020c));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7571a(BluetoothGattDescriptor bluetoothGattDescriptor) {
        this.f6021d.mo7570a(bluetoothGattDescriptor.getValue());
    }
}
