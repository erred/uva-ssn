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
import p000a.p013b.C0165c;
import p000a.p013b.C0184e;

/* renamed from: com.bridgefy.sdk.framework.controller.j */
class C1915j extends C1932t {

    /* renamed from: a */
    C0165c f5978a;

    /* renamed from: b */
    final String f5979b = getClass().getSimpleName();

    /* renamed from: c */
    private C1917a f5980c = new C1917a();

    /* renamed from: com.bridgefy.sdk.framework.controller.j$a */
    private class C1917a extends BluetoothGattCallback {
        private C1917a() {
        }

        public void onPhyRead(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            super.onPhyRead(bluetoothGatt, i, i2, i3);
            String str = C1915j.this.f5979b;
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
            String str = C1915j.this.f5979b;
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
                String str = C1915j.this.f5979b;
                StringBuilder sb = new StringBuilder();
                sb.append("onConnectionStateChange: error ");
                sb.append(e.getMessage());
                Log.e(str, sb.toString());
            }
            if (i == 133) {
                String str2 = C1915j.this.f5979b;
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
                m7960b(bluetoothGatt);
                return;
            }
            if (i2 == 2) {
                String str3 = C1915j.this.f5979b;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("CONNECTION EVENT AS CLIENT ");
                sb4.append(bluetoothGatt.getDevice().getAddress());
                Log.d(str3, sb4.toString());
                Session session = SessionManager.getSession(bluetoothGatt.getDevice().getAddress());
                if (session == null) {
                    session = new Session(bluetoothGatt);
                } else {
                    session.mo7486a(bluetoothGatt);
                    Log.d(C1915j.this.f5979b, "onConnectionStateChange: reusing previous empty session");
                }
                Device device = DeviceManager.getDevice(bluetoothGatt.getDevice().getAddress());
                if (device == null) {
                    device = new Device(bluetoothGatt.getDevice(), true);
                }
                device.setAntennaType(Antenna.BLUETOOTH_LE);
                device.setSessionId(session.getSessionId());
                session.mo7498b(true);
                session.mo7490a(device);
                SessionManager.m7754a(session);
                DeviceManager.m7715a(device);
                C1911h.m7920c().mo7416b().put(bluetoothGatt.getDevice().getAddress(), bluetoothGatt);
                if (VERSION.SDK_INT >= 21) {
                    bluetoothGatt.requestMtu(DeviceProfile.getMtuForDevice());
                } else {
                    bluetoothGatt.discoverServices();
                }
            } else if (i2 == 0) {
                String str4 = C1915j.this.f5979b;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onConnectionStateChange: check status ");
                sb5.append(i);
                Log.w(str4, sb5.toString());
                String str5 = C1915j.this.f5979b;
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
                        C1911h.m7920c().mo7416b().remove(address);
                        if (C1911h.m7920c().mo7418c() != null && C1911h.m7920c().mo7418c().mo7426b().getAddress().equals(bluetoothGatt.getDevice().getAddress())) {
                            C1911h.m7920c().mo7417b((gatt_operation) null);
                        }
                        if (session2 != null) {
                            session2.mo7391i();
                        }
                    }
                    C1911h.m7920c().mo7412a(bluetoothGatt.getDevice());
                    C1911h.m7920c().mo7411a();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7522a(BluetoothGatt bluetoothGatt) {
            try {
                Method method = bluetoothGatt.getClass().getMethod("refresh", new Class[0]);
                if (method != null) {
                    ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                }
            } catch (Exception e) {
                Log.e(C1915j.this.f5979b, "An exception occurred while refreshing device", e);
            }
        }

        /* renamed from: b */
        private void m7960b(BluetoothGatt bluetoothGatt) {
            C1911h.m7920c().mo7412a(bluetoothGatt.getDevice());
            C1911h.m7920c().mo7416b().remove(bluetoothGatt.getDevice().getAddress());
            if (C1911h.m7920c().mo7418c() != null && C1911h.m7920c().mo7418c().mo7426b().getAddress().equals(bluetoothGatt.getDevice().getAddress())) {
                C1911h.m7920c().mo7417b((gatt_operation) null);
            }
            bluetoothGatt.disconnect();
            bluetoothGatt.close();
            mo7522a(bluetoothGatt);
            Device device = DeviceManager.getDevice(bluetoothGatt.getDevice().getAddress());
            String str = C1915j.this.f5979b;
            StringBuilder sb = new StringBuilder();
            sb.append("clearFailedConnection: address");
            sb.append(bluetoothGatt.getDevice().getAddress());
            Log.e(str, sb.toString());
            String str2 = C1915j.this.f5979b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("clearFailedConnection: queued device ");
            sb2.append(device);
            Log.e(str2, sb2.toString());
            C1928r.m8012b(device);
            SessionManager.m7755a(bluetoothGatt.getDevice().getAddress());
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
                    if (bluetoothGatt.setCharacteristicNotification(bluetoothGatt.getService(C1922m.m7989b()).getCharacteristic(C1922m.m7991c()), true)) {
                        C1915j.this.m7957a(C1915j.this.mo7556b());
                        C1911h.m7920c().mo7413a(bluetoothGatt, C1911h.m7920c().mo7418c());
                        return;
                    }
                    m7960b(bluetoothGatt);
                } catch (NullPointerException unused) {
                    Log.e(C1915j.this.f5979b, "onServicesDiscovered: services discovery might have failed");
                    m7960b(bluetoothGatt);
                }
            } else {
                String str = C1915j.this.f5979b;
                StringBuilder sb = new StringBuilder();
                sb.append("onServicesDiscovered received: ");
                sb.append(i);
                Log.e(str, sb.toString());
                m7960b(bluetoothGatt);
            }
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
            ((C1938y) C1911h.m7920c().mo7418c()).mo7571a(bluetoothGattDescriptor);
            C1911h.m7920c().mo7417b((gatt_operation) null);
            C1911h.m7920c().mo7411a();
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
            C1911h.m7920c().mo7417b((gatt_operation) null);
            C1911h.m7920c().mo7411a();
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            if (C1911h.m7920c().mo7418c() instanceof C1935v) {
                ((C1935v) C1911h.m7920c().mo7418c()).mo7568a(bluetoothGattCharacteristic, bluetoothGatt);
            } else {
                Log.e(C1915j.this.f5979b, "onCharacteristicRead: warning casting operation failed!");
            }
            C1911h.m7920c().mo7417b((gatt_operation) null);
            C1911h.m7920c().mo7411a();
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            C1911h.m7920c().mo7417b((gatt_operation) null);
            C1911h.m7920c().mo7411a();
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            int a = C1927q.m7998a(bluetoothGattCharacteristic);
            if (a == 5) {
                Session session = SessionManager.getSession(bluetoothGatt.getDevice().getAddress());
                bluetoothGatt.disconnect();
                session.mo7391i();
            } else if (a == 7) {
                C1911h.m7920c().mo7414a((gatt_operation) new C1935v(bluetoothGatt.getDevice(), C1922m.m7989b(), C1922m.m7991c()));
            }
        }
    }

    C1915j(Device device) {
        super(device);
    }

    /* renamed from: a */
    public C0159b mo7509a() {
        return C0159b.m542a((C0184e) new C0184e() {
            public final void subscribe(C0165c cVar) {
                C1915j.this.m7956a(cVar);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7956a(C0165c cVar) throws Exception {
        this.f5978a = cVar;
        BluetoothDevice bluetoothDevice = mo7556b().getBluetoothDevice();
        if (Bridgefy.getInstance().getBridgefyCore() != null) {
            new C1909f(Bridgefy.getInstance().getBridgefyCore().getContext()).mo7508a(bluetoothDevice, false, (BluetoothGattCallback) this.f5980c);
            String str = this.f5979b;
            StringBuilder sb = new StringBuilder();
            sb.append("connect: connect as client device address: ");
            sb.append(mo7556b().getDeviceAddress());
            Log.d(str, sb.toString());
            Session session = SessionManager.getSession(mo7556b().getDeviceAddress());
            if (session == null) {
                session = new Session(bluetoothDevice, true, this.f5978a);
            }
            session.setCrc(mo7556b().getCrc());
            session.mo7381c(mo7556b().getDeviceAddress());
            mo7556b().setSessionId(session.getSessionId());
            session.mo7490a(mo7556b());
            SessionManager.m7754a(session);
            DeviceManager.m7715a(session.getDevice());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7957a(Device device) {
        String str = this.f5979b;
        StringBuilder sb = new StringBuilder();
        sb.append("sendInitialHandShake: ");
        sb.append(device.getDeviceAddress());
        Log.d(str, sb.toString());
        C1939z zVar = new C1939z(device.getBluetoothDevice(), C1922m.m7989b(), C1922m.m7991c(), C1922m.f5994a, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        C1911h.m7920c().mo7414a((gatt_operation) zVar);
        try {
            BleEntity generateHandShake = BleEntity.generateHandShake();
            // Logger.log(LogFactory.build(device, (BleHandshake) generateHandShake.getCt(), CommunicationEvent.BFCommunicationTypeSentHandshakePacket));
            Iterator it = C1927q.m8001a(generateHandShake, 150, true, Bridgefy.getInstance().getConfig().isEncryption(), null).iterator();
            while (it.hasNext()) {
                C1911h.m7920c().mo7414a((gatt_operation) new C1936w(device.getBluetoothDevice(), C1922m.m7989b(), C1922m.m7991c(), (byte[]) it.next()));
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("crc generated with device address: ");
            sb2.append(device.getDeviceAddress());
            // Logger.log(LogFactory.build(device, sb2.toString(), CommunicationEvent.BFCommunicationTypeSentHandshakePacket));
        } catch (MessageException | IOException e) {
            Log.e(this.f5979b, "sendInitialHandShake: ", e);
        }
    }
}
