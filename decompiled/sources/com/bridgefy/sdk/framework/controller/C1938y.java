package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.UUID;

/* renamed from: com.bridgefy.sdk.framework.controller.y */
class C1938y extends gatt_operation {

    /* renamed from: a */
    private final UUID service_uuid;

    /* renamed from: b */
    private final UUID characteristic_uuid;

    /* renamed from: c */
    private final UUID descriptor_uuid;

    /* renamed from: d */
    private final C1937x f6021d;

    /* renamed from: a */
    public boolean mo7425a() {
        return true;
    }

    /* renamed from: a */
    public void read_bluetooth_gatt_descriptor(BluetoothGatt bluetoothGatt) {
        bluetoothGatt.readDescriptor(bluetoothGatt.getService(this.service_uuid).getCharacteristic(this.characteristic_uuid).getDescriptor(this.descriptor_uuid));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7571a(BluetoothGattDescriptor bluetoothGattDescriptor) {
        this.f6021d.mo7570a(bluetoothGattDescriptor.getValue());
    }
}
