package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.bridgefy.sdk.client.Bridgefy;
import java.util.UUID;

/* renamed from: com.bridgefy.sdk.framework.controller.w */
class C1936w extends C1891ab {

    /* renamed from: a */
    private final UUID f6014a;

    /* renamed from: b */
    private final UUID f6015b;

    /* renamed from: c */
    private final byte[] f6016c;

    /* renamed from: d */
    private C1902al f6017d;

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
    public void mo7423a(BluetoothGatt bluetoothGatt) {
        BluetoothGattService service = bluetoothGatt.getService(this.f6014a);
        if (service == null) {
            this.f6017d.mo7464a().remove(this.f6016c);
            if (this.f6017d.mo7464a().size() == 0) {
                this.f6017d.mo7468d().mo7475b(this.f6017d);
            }
            return;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(this.f6015b);
        characteristic.setValue(this.f6016c);
        characteristic.setWriteType(2);
        bluetoothGatt.writeCharacteristic(characteristic);
        if (this.f6017d != null) {
            this.f6017d.mo7464a().remove(this.f6016c);
            if (this.f6017d.mo7469e().getData() != null && this.f6017d.mo7469e().getData().length > 0) {
                Bridgefy.getInstance().getBridgefyCore().mo7363c().onMessageDataProgress(this.f6017d.mo7473h(), (long) (this.f6017d.mo7472g() - this.f6017d.mo7464a().size()), (long) this.f6017d.mo7472g());
            }
            if (this.f6017d.mo7464a().size() == 0) {
                this.f6017d.mo7468d().mo7474a(this.f6017d);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7569a(C1902al alVar) {
        this.f6017d = alVar;
    }
}
