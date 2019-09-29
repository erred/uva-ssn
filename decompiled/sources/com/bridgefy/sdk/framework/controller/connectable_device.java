package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.BridgefyUtils;
import com.bridgefy.sdk.client.Device;
import java.io.IOException;
import org.p153a.C3682b;
import p000a.p013b.C0159b;
import p000a.p013b.emitter;
import p000a.p013b.C0184e;
import p000a.p013b.C0330h;
import p000a.p013b.p019d.C0181e;

/* renamed from: com.bridgefy.sdk.framework.controller.g */
class connectable_device extends comparable_device {

    /* renamed from: a */
    final String simple_name = getClass().getSimpleName();

    /* renamed from: b */
    private boolean is_encryption = false;

    connectable_device(Device device, boolean z) {
        super(device);
        this.is_encryption = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0159b subscribe_connect() {
        return C0159b.m542a((C0184e) new C0184e() {
            public final void subscribe(emitter cVar) {
                connectable_device.this.connect(cVar);
            }
        }).mo341a((C0181e<? super C0330h<Throwable>, ? extends C3682b<?>>) new error_handler_C1898ai<Object,Object>(3, 1000));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void connect(emitter cVar) throws Exception {
        BluetoothSocket bluetoothSocket;
        try {
            BluetoothAdapter bluetoothAdapter = BridgefyUtils.getBluetoothAdapter(Bridgefy.getInstance().getBridgefyCore().getContext());
            if (bluetoothAdapter != null && bluetoothAdapter.isDiscovering()) {
                bluetoothAdapter.cancelDiscovery();
            }
            if (this.is_encryption) {
                bluetoothSocket = get_device().getBluetoothDevice().createRfcommSocketToServiceRecord(bluetooth_le_settings_builder.m7989b());
            } else {
                bluetoothSocket = get_device().getBluetoothDevice().createInsecureRfcommSocketToServiceRecord(bluetooth_le_settings_builder.m7989b());
            }
            bluetoothSocket.connect();
            Session session = new Session(bluetoothSocket);
            session.set_session_id(get_device().getDeviceAddress());
            session.set_is_client(true);
            get_device().setSessionId(session.getSessionId());
            session.set_device(get_device());
            SessionManager.queue_session(session);
            DeviceManager.add_device_null_session(session.getDevice());
            cVar.mo361a();
        } catch (IOException e) {
            String str = this.simple_name;
            StringBuilder sb = new StringBuilder();
            sb.append("connect: fail [ ");
            sb.append(e.getMessage());
            sb.append(" ]");
            Log.e(str, sb.toString());
            cVar.mo364b(e);
        }
    }
}
