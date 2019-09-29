package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import java.util.UUID;

/* renamed from: com.bridgefy.sdk.framework.controller.ab */
abstract class gatt_operation {

    /* renamed from: a */
    private BluetoothDevice f5884a;

    /* renamed from: b */
    private C1892ac f5885b;

    /* renamed from: c */
    private String operation_id = UUID.randomUUID().toString();

    /* renamed from: a */
    public abstract void read_bluetooth_gatt_descriptor(BluetoothGatt bluetoothGatt);

    /* renamed from: a */
    public abstract boolean mo7425a();

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public int mo7427c() {
        return 20000;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.operation_id.equals(((gatt_operation) obj).operation_id);
    }

    public int hashCode() {
        return this.operation_id.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GattOperation {\toperationId='");
        sb.append(this.operation_id);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    gatt_operation(BluetoothDevice bluetoothDevice) {
        this.f5884a = bluetoothDevice;
    }

    /* renamed from: b */
    public BluetoothDevice mo7426b() {
        return this.f5884a;
    }

    /* renamed from: d */
    public C1892ac mo7428d() {
        return this.f5885b;
    }

    /* renamed from: a */
    public void mo7424a(C1892ac acVar) {
        this.f5885b = acVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String get_operation_id() {
        return this.operation_id;
    }
}
