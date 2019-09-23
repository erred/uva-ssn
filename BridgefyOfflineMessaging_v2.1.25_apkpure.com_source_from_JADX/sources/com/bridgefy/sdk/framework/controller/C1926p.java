package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.os.Build;
import android.util.Log;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.BridgefyUtils;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.framework.entities.BleEntity;
import com.bridgefy.sdk.framework.utils.Utils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* renamed from: com.bridgefy.sdk.framework.controller.p */
class C1926p extends BluetoothGattServerCallback {
    C1926p() {
    }

    public void onPhyUpdate(BluetoothDevice bluetoothDevice, int i, int i2, int i3) {
        super.onPhyUpdate(bluetoothDevice, i, i2, i3);
        StringBuilder sb = new StringBuilder();
        sb.append("onPhyUpdate: txPhy is ");
        sb.append(i);
        Log.i("GattServer_Callback", sb.toString());
    }

    public void onMtuChanged(BluetoothDevice bluetoothDevice, int i) {
        super.onMtuChanged(bluetoothDevice, i);
        SessionManager.getSession(bluetoothDevice.getAddress()).mo7377a(i);
    }

    public void onDescriptorWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z, boolean z2, int i2, byte[] bArr) {
        super.onDescriptorWriteRequest(bluetoothDevice, i, bluetoothGattDescriptor, z, z2, i2, bArr);
        ((BluetoothGattServer) m7997a().mo7462e()).sendResponse(bluetoothDevice, i, 0, i2, bArr);
    }

    public void onNotificationSent(BluetoothDevice bluetoothDevice, int i) {
        super.onNotificationSent(bluetoothDevice, i);
    }

    public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) {
        super.onConnectionStateChange(bluetoothDevice, i, i2);
        if (i == 143) {
            StringBuilder sb = new StringBuilder();
            sb.append("doInBackground: connection congested ");
            sb.append(i);
            Log.e("GattServer_Callback", sb.toString());
        } else if (i == 257) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("doInBackground: gatt failure ");
            sb2.append(i);
            Log.e("GattServer_Callback", sb2.toString());
        }
        if (i2 == 0) {
            DeviceManager.getDevice(bluetoothDevice.getAddress());
            Session session = SessionManager.getSession(bluetoothDevice.getAddress());
            if (session != null && session.mo7395l() != 1) {
                if (C1928r.m8006a() == null || !C1928r.m8006a().mo7556b().getDeviceAddress().equals(bluetoothDevice.getAddress())) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("BluetoothProfile.STATE_DISCONNECTED ");
                    sb3.append(bluetoothDevice.getAddress());
                    Log.e("GattServer_Callback", sb3.toString());
                    if (!(m7997a() == null || m7997a().mo7462e() == null)) {
                        ((BluetoothGattServer) m7997a().mo7462e()).cancelConnection(bluetoothDevice);
                    }
                    session.mo7391i();
                }
            }
        } else if (i2 == 2) {
            if (Build.MODEL != null && Build.MODEL.equals("iot_rpi3")) {
                Log.w("GattServer_Callback", "onConnectionStateChange: restarting advertising for rpi3");
                BridgefyUtils.getBluetoothAdapter(Bridgefy.getInstance().getBridgefyCore().getContext()).getBluetoothLeAdvertiser().startAdvertising(C1922m.m7985a(), C1922m.m7984a(String.valueOf(Utils.getCrcFromKey(Bridgefy.getInstance().getBridgefyClient().getUserUuid())), C1922m.m7989b()), new C1925o());
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Client connecting to our server BluetoothProfile.STATE_CONNECTED ");
            sb4.append(bluetoothDevice.getAddress());
            Log.v("GattServer_Callback", sb4.toString());
            if (SessionManager.f5869a.get(bluetoothDevice.getAddress()) != null || m7997a() == null || m7997a().mo7462e() == null || !m7997a().mo7461c()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("doInBackground: Bridgefy Server Callback device ");
                sb5.append(bluetoothDevice);
                sb5.append(" new state STATE_CONNECTED status ");
                sb5.append(i);
                Log.v("GattServer_Callback", sb5.toString());
                return;
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Server Connection ");
            sb6.append(bluetoothDevice.getName());
            sb6.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb6.append(bluetoothDevice.getAddress());
            Log.w("GattServer_Callback", sb6.toString());
            ((BluetoothGattServer) m7997a().mo7462e()).connect(bluetoothDevice, false);
            m7997a().mo7538a(bluetoothDevice);
        }
    }

    public void onServiceAdded(int i, BluetoothGattService bluetoothGattService) {
        super.onServiceAdded(i, bluetoothGattService);
    }

    public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super.onCharacteristicReadRequest(bluetoothDevice, i, i2, bluetoothGattCharacteristic);
        C1902al a = C1903am.m7854a(bluetoothDevice);
        if (a == null || a.mo7464a().size() <= 0) {
            Log.e("GattServer_Callback", "onCharacteristicReadRequest: requesting a read when there is no info!");
            ((BluetoothGattServer) m7997a().mo7462e()).sendResponse(bluetoothDevice, i, 0, i2, null);
            return;
        }
        byte[] bArr = (byte[]) a.mo7464a().get(0);
        if (bArr != null) {
            ((BluetoothGattServer) m7997a().mo7462e()).sendResponse(bluetoothDevice, i, 0, i2, bArr);
            a.mo7464a().remove(0);
        }
        if (a.mo7469e().getData() != null && a.mo7469e().getData().length > 0) {
            Bridgefy.getInstance().getBridgefyCore().get_message_listener().onMessageDataProgress(a.mo7473h(), (long) (a.mo7472g() - a.mo7464a().size()), (long) a.mo7472g());
        }
        if (a.mo7464a().isEmpty()) {
            a.mo7471f();
            a.mo7468d().mo7474a(a);
        }
    }

    public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr) {
        super.onCharacteristicWriteRequest(bluetoothDevice, i, bluetoothGattCharacteristic, z, z2, i2, bArr);
        ((BluetoothGattServer) m7997a().mo7462e()).sendResponse(bluetoothDevice, i, 0, i2, bArr);
        Session session = SessionManager.getSession(bluetoothDevice.getAddress());
        if (session != null && session.getBluetoothDevice() != null && session.getBluetoothDevice().equals(bluetoothDevice)) {
            session.mo7503g().add(C1927q.m8002a(bArr));
            if (C1927q.m8004c(bArr) == 2) {
                BleEntity a = C1927q.m7999a(session.mo7503g(), true, Bridgefy.getInstance().getConfig().isEncryption());
                if (a != null) {
                    session.mo7378a(a);
                }
                session.mo7503g().clear();
            }
        }
    }

    public void onExecuteWrite(BluetoothDevice bluetoothDevice, int i, boolean z) {
        super.onExecuteWrite(bluetoothDevice, i, z);
        ((BluetoothGattServer) m7997a().mo7462e()).sendResponse(bluetoothDevice, i, 0, 0, null);
    }

    /* renamed from: a */
    private C1921l m7997a() {
        return (C1921l) C1900ak.m7841a(Antenna.BLUETOOTH_LE, true);
    }
}
