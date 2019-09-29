package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Build.VERSION;
import android.util.Log;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Device;
import com.bridgefy.sdk.client.DeviceProfile;
import com.bridgefy.sdk.framework.entities.BleEntity;
import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.bridgefy.sdk.framework.exceptions.MessageException;
import com.bridgefy.sdk.logging.LogFactory;
import com.bridgefy.sdk.logging.Logger;
import com.bridgefy.sdk.logging.entities.CommunicationLog.CommunicationEvent;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import p000a.p013b.C0159b;
import p000a.p013b.emitter;
import p000a.p013b.C0184e;

/* renamed from: com.bridgefy.sdk.framework.controller.j */
class bluetooth_gatt_connectable_device extends comparable_device {

    /* renamed from: a */
    emitter emitter;

    /* renamed from: b */
    final String simple_name = getClass().getSimpleName();

    /* renamed from: c */
    private bluetooth_gatt_callback bluetooth_gatt_callback = new bluetooth_gatt_callback();

    /* renamed from: com.bridgefy.sdk.framework.controller.j$a */
    private class bluetooth_gatt_callback extends BluetoothGattCallback {
        private bluetooth_gatt_callback() {
        }

        public void onPhyRead(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            super.onPhyRead(bluetoothGatt, i, i2, i3);
            String str = bluetooth_gatt_connectable_device.this.simple_name;
            StringBuilder sb = new StringBuilder();
            sb.append("onPhyRead: txPhy is ");
            sb.append(i);
            sb.append(" rxPhy is ");
            sb.append(i2);
            sb.append(" status ");
            sb.append(i3);
            Log.d(str, sb.toString());
        }

        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            super.onPhyUpdate(bluetoothGatt, i, i2, i3);
            String str = bluetooth_gatt_connectable_device.this.simple_name;
            StringBuilder sb = new StringBuilder();
            sb.append("onPhyUpdate: txPhy is ");
            sb.append(i);
            sb.append(" rxPhy is ");
            sb.append(i2);
            sb.append(" status ");
            sb.append(i3);
            Log.i(str, sb.toString());
        }

        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onMtuChanged(bluetoothGatt, i, i2);
            Session session = SessionManager.getSession(bluetoothGatt.getDevice().getAddress());
            if (i == 158) {
                session.mo7377a(150);
            } else {
                session.mo7377a(i);
            }
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bluetoothGatt.discoverServices();
        }

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            try {
                synchronized (this) {
                    wait(100);
                }
            } catch (InterruptedException e) {
                String str = bluetooth_gatt_connectable_device.this.simple_name;
                StringBuilder sb = new StringBuilder();
                sb.append("onConnectionStateChange: error ");
                sb.append(e.getMessage());
                Log.e(str, sb.toString());
            }
            if (i == 133) {
                String str2 = bluetooth_gatt_connectable_device.this.simple_name;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Got the status 133 bug. ");
                sb2.append(bluetoothGatt.getDevice().getAddress());
                Log.e(str2, sb2.toString());
                if (bluetoothGatt.getDevice() == null || bluetoothGatt.getDevice().getAddress() == null) {
                    // Logger.log(LogFactory.build("Got the status 133 bug."));
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Got the status 133 bug with: ");
                    sb3.append(bluetoothGatt.getDevice().getAddress());
                    // Logger.log(LogFactory.build(sb3.toString()));
                }
                clear_failed_connection(bluetoothGatt);
                return;
            }
            if (i2 == 2) {
                String str3 = bluetooth_gatt_connectable_device.this.simple_name;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("CONNECTION EVENT AS CLIENT ");
                sb4.append(bluetoothGatt.getDevice().getAddress());
                Log.d(str3, sb4.toString());
                Session session = SessionManager.getSession(bluetoothGatt.getDevice().getAddress());
                if (session == null) {
                    session = new Session(bluetoothGatt);
                } else {
                    session.set_bluetooth_gatt(bluetoothGatt);
                    Log.d(bluetooth_gatt_connectable_device.this.simple_name, "onConnectionStateChange: reusing previous empty session");
                }
                Device device = DeviceManager.getDevice(bluetoothGatt.getDevice().getAddress());
                if (device == null) {
                    device = new Device(bluetoothGatt.getDevice(), true);
                }
                device.setAntennaType(Antenna.BLUETOOTH_LE);
                device.setSessionId(session.getSessionId());
                session.set_is_client(true);
                session.set_device(device);
                SessionManager.queue_session(session);
                DeviceManager.add_device_null_session(device);
                bluetooth_controller.get_gatt_manager().mo7416b().put(bluetoothGatt.getDevice().getAddress(), bluetoothGatt);
                if (VERSION.SDK_INT >= 21) {
                    bluetoothGatt.requestMtu(DeviceProfile.getMtuForDevice());
                } else {
                    bluetoothGatt.discoverServices();
                }
            } else if (i2 == 0) {
                String str4 = bluetooth_gatt_connectable_device.this.simple_name;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onConnectionStateChange: check status ");
                sb5.append(i);
                Log.w(str4, sb5.toString());
                String str5 = bluetooth_gatt_connectable_device.this.simple_name;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("onConnectionStateChange: BluetoothProfile.STATE_DISCONNECTED ");
                sb6.append(bluetoothGatt.getDevice().getAddress());
                Log.w(str5, sb6.toString());
                if (bluetoothGatt != null) {
                    String address = bluetoothGatt.getDevice().getAddress();
                    Session session2 = SessionManager.getSession(address);
                    if (session2 == null || !(session2 == null || session2.mo7395l() == 6)) {
                        try {
                            bluetoothGatt.close();
                        } catch (Exception unused) {
                        }
                        bluetooth_controller.get_gatt_manager().mo7416b().remove(address);
                        if (bluetooth_controller.get_gatt_manager().mo7418c() != null && bluetooth_controller.get_gatt_manager().mo7418c().get_bluetooth_device().getAddress().equals(bluetoothGatt.getDevice().getAddress())) {
                            bluetooth_controller.get_gatt_manager().mo7417b((gatt_operation) null);
                        }
                        if (session2 != null) {
                            session2.disconnect();
                        }
                    }
                    bluetooth_controller.get_gatt_manager().mo7412a(bluetoothGatt.getDevice());
                    bluetooth_controller.get_gatt_manager().mo7411a();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void refresh_device(BluetoothGatt bluetoothGatt) {
            try {
                Method method = bluetoothGatt.getClass().getMethod("refresh", new Class[0]);
                if (method != null) {
                    ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                }
            } catch (Exception e) {
                Log.e(bluetooth_gatt_connectable_device.this.simple_name, "An exception occurred while refreshing device", e);
            }
        }

        /* renamed from: b */
        private void clear_failed_connection(BluetoothGatt bluetoothGatt) {
            bluetooth_controller.get_gatt_manager().mo7412a(bluetoothGatt.getDevice());
            bluetooth_controller.get_gatt_manager().mo7416b().remove(bluetoothGatt.getDevice().getAddress());
            if (bluetooth_controller.get_gatt_manager().mo7418c() != null && bluetooth_controller.get_gatt_manager().mo7418c().get_bluetooth_device().getAddress().equals(bluetoothGatt.getDevice().getAddress())) {
                bluetooth_controller.get_gatt_manager().mo7417b((gatt_operation) null);
            }
            bluetoothGatt.disconnect();
            bluetoothGatt.close();
            refresh_device(bluetoothGatt);
            Device device = DeviceManager.getDevice(bluetoothGatt.getDevice().getAddress());
            String str = bluetooth_gatt_connectable_device.this.simple_name;
            StringBuilder sb = new StringBuilder();
            sb.append("clearFailedConnection: address");
            sb.append(bluetoothGatt.getDevice().getAddress());
            Log.e(str, sb.toString());
            String str2 = bluetooth_gatt_connectable_device.this.simple_name;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("clearFailedConnection: queued device ");
            sb2.append(device);
            Log.e(str2, sb2.toString());
            connection_manager.m8012b(device);
            SessionManager.get_session(bluetoothGatt.getDevice().getAddress());
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            super.onServicesDiscovered(bluetoothGatt, i);
            if (i == 0) {
                switch (Bridgefy.getInstance().getConfig().getBleProfile()) {
                    case DOUBLE_RATE:
                        if (DeviceProfile.isLeDoubleRateSupported(Bridgefy.getInstance().getBridgefyCore().getContext())) {
                            bluetoothGatt.setPreferredPhy(2, 2, 0);
                            break;
                        }
                        break;
                    case EXTENDED_RANGE:
                        if (DeviceProfile.isLeExtendedRangeSupported(Bridgefy.getInstance().getBridgefyCore().getContext())) {
                            bluetoothGatt.setPreferredPhy(3, 3, 0);
                            break;
                        }
                        break;
                }
                try {
                    if (bluetoothGatt.setCharacteristicNotification(bluetoothGatt.getService(bluetooth_le_settings_builder.m7989b()).getCharacteristic(bluetooth_le_settings_builder.m7991c()), true)) {
                        bluetooth_gatt_connectable_device.this.send_initial_handshake(bluetooth_gatt_connectable_device.this.get_device());
                        bluetooth_controller.get_gatt_manager().mo7413a(bluetoothGatt, bluetooth_controller.get_gatt_manager().mo7418c());
                        return;
                    }
                    clear_failed_connection(bluetoothGatt);
                } catch (NullPointerException unused) {
                    Log.e(bluetooth_gatt_connectable_device.this.simple_name, "onServicesDiscovered: services discovery might have failed");
                    clear_failed_connection(bluetoothGatt);
                }
            } else {
                String str = bluetooth_gatt_connectable_device.this.simple_name;
                StringBuilder sb = new StringBuilder();
                sb.append("onServicesDiscovered received: ");
                sb.append(i);
                Log.e(str, sb.toString());
                clear_failed_connection(bluetoothGatt);
            }
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
            ((gatt_descriptor_writer) bluetooth_controller.get_gatt_manager().mo7418c()).write_descriptor(bluetoothGattDescriptor);
            bluetooth_controller.get_gatt_manager().mo7417b((gatt_operation) null);
            bluetooth_controller.get_gatt_manager().mo7411a();
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
            bluetooth_controller.get_gatt_manager().mo7417b((gatt_operation) null);
            bluetooth_controller.get_gatt_manager().mo7411a();
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            if (bluetooth_controller.get_gatt_manager().mo7418c() instanceof gatt_operation_characteristic_reader) {
                ((gatt_operation_characteristic_reader) bluetooth_controller.get_gatt_manager().mo7418c()).on_characteristic_read(bluetoothGattCharacteristic, bluetoothGatt);
            } else {
                Log.e(bluetooth_gatt_connectable_device.this.simple_name, "onCharacteristicRead: warning casting operation failed!");
            }
            bluetooth_controller.get_gatt_manager().mo7417b((gatt_operation) null);
            bluetooth_controller.get_gatt_manager().mo7411a();
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            bluetooth_controller.get_gatt_manager().mo7417b((gatt_operation) null);
            bluetooth_controller.get_gatt_manager().mo7411a();
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            int a = chunk_utils.get_bluetooth_characteristics(bluetoothGattCharacteristic);
            if (a == 5) {
                Session session = SessionManager.getSession(bluetoothGatt.getDevice().getAddress());
                bluetoothGatt.disconnect();
                session.disconnect();
            } else if (a == 7) {
                bluetooth_controller.get_gatt_manager().mo7414a((gatt_operation) new gatt_operation_characteristic_reader(bluetoothGatt.getDevice(), bluetooth_le_settings_builder.m7989b(), bluetooth_le_settings_builder.m7991c()));
            }
        }
    }

    bluetooth_gatt_connectable_device(Device device) {
        super(device);
    }

    /* renamed from: a */
    public C0159b subscribe_connect() {
        return C0159b.m542a((C0184e) new C0184e() {
            public final void subscribe(emitter cVar) {
                bluetooth_gatt_connectable_device.this.connect(cVar);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void connect(emitter cVar) throws Exception {
        this.emitter = cVar;
        BluetoothDevice bluetoothDevice = get_device().getBluetoothDevice();
        if (Bridgefy.getInstance().getBridgefyCore() != null) {
            new bluetooth_gatt_context(Bridgefy.getInstance().getBridgefyCore().getContext()).mo7508a(bluetoothDevice, false, (BluetoothGattCallback) this.bluetooth_gatt_callback);
            String str = this.simple_name;
            StringBuilder sb = new StringBuilder();
            sb.append("connect: connect as client device address: ");
            sb.append(get_device().getDeviceAddress());
            Log.d(str, sb.toString());
            Session session = SessionManager.getSession(get_device().getDeviceAddress());
            if (session == null) {
                session = new Session(bluetoothDevice, true, this.emitter);
            }
            session.setCrc(get_device().getCrc());
            session.set_session_id(get_device().getDeviceAddress());
            get_device().setSessionId(session.getSessionId());
            session.set_device(get_device());
            SessionManager.queue_session(session);
            DeviceManager.add_device_null_session(session.getDevice());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void send_initial_handshake(Device device) {
        String str = this.simple_name;
        StringBuilder sb = new StringBuilder();
        sb.append("sendInitialHandShake: ");
        sb.append(device.getDeviceAddress());
        Log.d(str, sb.toString());
        bluetooth_gatt_descriptor_writer zVar = new bluetooth_gatt_descriptor_writer(device.getBluetoothDevice(), bluetooth_le_settings_builder.m7989b(), bluetooth_le_settings_builder.m7991c(), bluetooth_le_settings_builder.client_characteristic_configuration_uuid, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        bluetooth_controller.get_gatt_manager().mo7414a((gatt_operation) zVar);
        try {
            BleEntity generateHandShake = BleEntity.generateHandShake();
            // Logger.log(LogFactory.build(device, (BleHandshake) generateHandShake.getCt(), CommunicationEvent.BFCommunicationTypeSentHandshakePacket));
            Iterator it = chunk_utils.generate_compressed_chunk(generateHandShake, 150, true, Bridgefy.getInstance().getConfig().isEncryption(), null).iterator();
            while (it.hasNext()) {
                bluetooth_controller.get_gatt_manager().mo7414a((gatt_operation) new gatt_operation_characteristic_writer(device.getBluetoothDevice(), bluetooth_le_settings_builder.m7989b(), bluetooth_le_settings_builder.m7991c(), (byte[]) it.next()));
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("crc generated with device address: ");
            sb2.append(device.getDeviceAddress());
            // Logger.log(LogFactory.build(device, sb2.toString(), CommunicationEvent.BFCommunicationTypeSentHandshakePacket));
        } catch (MessageException | IOException e) {
            Log.e(this.simple_name, "sendInitialHandShake: ", e);
        }
    }
}
