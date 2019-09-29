package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.bridgefy.sdk.client.Bridgefy;
import java.util.UUID;

/* renamed from: com.bridgefy.sdk.framework.controller.w */
class gatt_operation_characteristic_writer extends gatt_operation {

    /* renamed from: a */
    private final UUID bluetooth_gatt_service_uuid;

    /* renamed from: b */
    private final UUID bluetooth_gatt_characteristic_uuid;

    /* renamed from: c */
    private final byte[] bluetooth_gatt_characteristic;

    /* renamed from: d */
    private chunk_generator chunk_generator;

    /* renamed from: a */
    public boolean mo7425a() {
        return true;
    }

    gatt_operation_characteristic_writer(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2, byte[] bArr) {
        super(bluetoothDevice);
        this.bluetooth_gatt_service_uuid = uuid;
        this.bluetooth_gatt_characteristic_uuid = uuid2;
        this.bluetooth_gatt_characteristic = bArr;
    }

    /* renamed from: a */
    public void write_bluetooth_gatt_descriptor(BluetoothGatt bluetoothGatt) {
        BluetoothGattService service = bluetoothGatt.getService(this.bluetooth_gatt_service_uuid);
        if (service == null) {
            this.chunk_generator.get_generated_chunk().remove(this.bluetooth_gatt_characteristic);
            if (this.chunk_generator.get_generated_chunk().size() == 0) {
                this.chunk_generator.get_transaction_manager().mo7475b(this.chunk_generator);
            }
            return;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(this.bluetooth_gatt_characteristic_uuid);
        characteristic.setValue(this.bluetooth_gatt_characteristic);
        characteristic.setWriteType(2);
        bluetoothGatt.writeCharacteristic(characteristic);
        if (this.chunk_generator != null) {
            this.chunk_generator.get_generated_chunk().remove(this.bluetooth_gatt_characteristic);
            if (this.chunk_generator.get_ble_entity().getData() != null && this.chunk_generator.get_ble_entity().getData().length > 0) {
                Bridgefy.getInstance().getBridgefyCore().get_message_listener().onMessageDataProgress(this.chunk_generator.get_ble_entity_uuid(), (long) (this.chunk_generator.get_compressed_size() - this.chunk_generator.get_generated_chunk().size()), (long) this.chunk_generator.get_compressed_size());
            }
            if (this.chunk_generator.get_generated_chunk().size() == 0) {
                this.chunk_generator.get_transaction_manager().mo7474a(this.chunk_generator);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void set_chunk_generator(chunk_generator alVar) {
        this.chunk_generator = alVar;
    }
}
