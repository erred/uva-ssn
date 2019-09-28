package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.bridgefy.sdk.client.Bridgefy;
import java.util.UUID;

/* renamed from: com.bridgefy.sdk.framework.controller.w */
class C1936w extends gatt_operation {

    /* renamed from: a */
    private final UUID f6014a;

    /* renamed from: b */
    private final UUID f6015b;

    /* renamed from: c */
    private final byte[] f6016c;

    /* renamed from: d */
    private chunk_generator f6017d;

    /* renamed from: a */
    public boolean mo7425a() {
        return true;
    }

    C1936w(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr) {
        super(bluetoothDevice);
        this.f6014a = uuid;
        this.f6015b = uuid2;
        this.f6016c = bArr;
    }

    /* renamed from: a */
    public void read_bluetooth_gatt_descriptor(BluetoothGatt bluetoothGatt) {
        BluetoothGattService service = bluetoothGatt.getService(this.f6014a);
        if (service == null) {
            this.f6017d.get_generated_chunk().remove(this.f6016c);
            if (this.f6017d.get_generated_chunk().size() == 0) {
                this.f6017d.get_transaction_manager().mo7475b(this.f6017d);
            }
            return;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(this.f6015b);
        characteristic.setValue(this.f6016c);
        characteristic.setWriteType(2);
        bluetoothGatt.writeCharacteristic(characteristic);
        if (this.f6017d != null) {
            this.f6017d.get_generated_chunk().remove(this.f6016c);
            if (this.f6017d.get_ble_entity().getData() != null && this.f6017d.get_ble_entity().getData().length > 0) {
                Bridgefy.getInstance().getBridgefyCore().get_message_listener().onMessageDataProgress(this.f6017d.get_ble_entity_uuid(), (long) (this.f6017d.get_compressed_size() - this.f6017d.get_generated_chunk().size()), (long) this.f6017d.get_compressed_size());
            }
            if (this.f6017d.get_generated_chunk().size() == 0) {
                this.f6017d.get_transaction_manager().mo7474a(this.f6017d);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7569a(chunk_generator alVar) {
        this.f6017d = alVar;
    }
}
