package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.util.Log;
import com.bridgefy.sdk.client.Config;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Device;
import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.bridgefy.sdk.framework.exceptions.ConnectionException;

/* renamed from: com.bridgefy.sdk.framework.controller.l */
class bluetooth_le_server extends bluetooth_server<BluetoothDevice, BluetoothGattServer> {

    /* renamed from: d */
    private BluetoothManager f5990d;

    /* renamed from: e */
    private BluetoothGattService f5991e;

    /* renamed from: f */
    private boolean f5992f = false;

    /* renamed from: g */
    private Object f5993g = new Object();

    bluetooth_le_server(Config config, Context context) throws ConnectionException {
        super(config, context);
        this.f5990d = (BluetoothManager) context.getSystemService("bluetooth");
        m7976a(context);
        Log.d("BluetoothLeServer", "BluetoothLeServer: bluetooth le server created.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7538a(BluetoothDevice bluetoothDevice) {
        Session session = new Session(bluetoothDevice, true, null);
        session.set_session_id(bluetoothDevice.getAddress());
        Device device = new Device(bluetoothDevice, true);
        device.setSessionId(session.getSessionId());
        session.set_device(device);
        session.set_bluetooth_gatt_server((BluetoothGattServer) server_factory.get_server_instance(Antenna.BLUETOOTH_LE, true).mo7462e());
        SessionManager.queue_session(session);
    }

    /* renamed from: a */
    public void stop_server() {
        if (mo7461c()) {
            try {
                mo7460b(false);
                ((BluetoothGattServer) mo7462e()).clearServices();
                ((BluetoothGattServer) mo7462e()).close();
            } catch (Exception e) {
                String str = "BluetoothLeServer";
                StringBuilder sb = new StringBuilder();
                sb.append("stopServer: ");
                sb.append(e.getMessage());
                Log.e(str, sb.toString());
            } catch (Throwable th) {
                mo7458a(null);
                mo7539a(false);
                throw th;
            }
            mo7458a(null);
            mo7539a(false);
        }
    }

    /* renamed from: b */
    public void start_server() {
        synchronized (this.f5993g) {
            if (mo7461c() || mo7540d()) {
                Log.w("BluetoothLeServer", "startServer: trying started server fail, server was started.");
            } else {
                mo7539a(true);
                mo7460b(true);
                run();
            }
        }
    }

    /* renamed from: g */
    private boolean m7977g() {
        byte[] bytes = new BleHandshake(null, null).toString().getBytes();
        BluetoothGattCharacteristic characteristic = this.f5991e.getCharacteristic(bluetooth_le_settings_builder.m7991c());
        if (characteristic == null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(bluetooth_le_settings_builder.m7991c(), 26, 17);
            bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(bluetooth_le_settings_builder.client_characteristic_configuration_uuid, 16));
            bluetoothGattCharacteristic.setValue(bytes);
            if (this.f5991e == null) {
                return false;
            }
            this.f5991e.addCharacteristic(bluetoothGattCharacteristic);
            return true;
        }
        characteristic.setValue(bytes);
        return true;
    }

    public void run() {
        if (mo7462e() != null) {
            this.f5991e = ((BluetoothGattServer) mo7462e()).getService(bluetooth_le_settings_builder.m7989b());
        }
        if (this.f5991e == null && mo7462e() != null) {
            this.f5991e = new BluetoothGattService(bluetooth_le_settings_builder.m7989b(), 0);
            if (m7977g()) {
                ((BluetoothGattServer) mo7462e()).addService(this.f5991e);
            }
        }
    }

    /* renamed from: a */
    private void m7976a(Context context) {
        if (mo7462e() == null) {
            mo7458a(this.f5990d.openGattServer(context, new gatt_server_callback()));
        }
    }

    /* renamed from: c */
    public boolean mo7461c() {
        return mo7462e() != null && ((BluetoothGattServer) mo7462e()).getServices().size() > 0;
    }

    /* renamed from: a */
    public void mo7539a(boolean z) {
        this.f5992f = z;
    }

    /* renamed from: d */
    public boolean mo7540d() {
        return this.f5992f;
    }
}
