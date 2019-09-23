package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import java.util.UUID;

/* renamed from: com.bridgefy.sdk.framework.controller.z */
class C1939z extends C1891ab {

    /* renamed from: a */
    private final UUID f6022a;

    /* renamed from: b */
    private final UUID f6023b;

    /* renamed from: c */
    private final UUID f6024c;

    /* renamed from: d */
    private byte[] f6025d;

    /* renamed from: a */
    public boolean mo7425a() {
        return true;
    }

    C1939z(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, UUID uuid3, byte[] bArr) {
        super(bluetoothDevice);
        this.f6022a = uuid;
        this.f6023b = uuid2;
        this.f6024c = uuid3;
        this.f6025d = bArr;
    }

    /* renamed from: a */
    public void mo7423a(BluetoothGatt bluetoothGatt) {
        BluetoothGattService service = bluetoothGatt.getService(this.f6022a);
        if (service != null) {
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(this.f6023b);
            if (characteristic != null) {
                BluetoothGattDescriptor descriptor = characteristic.getDescriptor(this.f6024c);
                if (descriptor != null) {
                    descriptor.setValue(this.f6025d);
                    bluetoothGatt.writeDescriptor(descriptor);
                }
            }
        }
    }
}
