package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import java.util.UUID;

/* renamed from: com.bridgefy.sdk.framework.controller.z */
class bluetooth_gatt_descriptor_writer extends gatt_operation {

    /* renamed from: a */
    private final UUID bluetooth_gatt_service_uuid;

    /* renamed from: b */
    private final UUID bluetooth_characteristic_uuid;

    /* renamed from: c */
    private final UUID bluetooth_descriptor_uuid;

    /* renamed from: d */
    private byte[] f6025d;

    /* renamed from: a */
    public boolean mo7425a() {
        return true;
    }

    bluetooth_gatt_descriptor_writer(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, UUID uuid3, byte[] bArr) {
        super(bluetoothDevice);
        this.bluetooth_gatt_service_uuid = uuid;
        this.bluetooth_characteristic_uuid = uuid2;
        this.bluetooth_descriptor_uuid = uuid3;
        this.f6025d = bArr;
    }

    /* renamed from: a */
    public void write_bluetooth_gatt_descriptor(BluetoothGatt bluetoothGatt) {
        BluetoothGattService service = bluetoothGatt.getService(this.bluetooth_gatt_service_uuid);
        if (service != null) {
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(this.bluetooth_characteristic_uuid);
            if (characteristic != null) {
                BluetoothGattDescriptor descriptor = characteristic.getDescriptor(this.bluetooth_descriptor_uuid);
                if (descriptor != null) {
                    descriptor.setValue(this.f6025d);
                    bluetoothGatt.writeDescriptor(descriptor);
                }
            }
        }
    }
}
