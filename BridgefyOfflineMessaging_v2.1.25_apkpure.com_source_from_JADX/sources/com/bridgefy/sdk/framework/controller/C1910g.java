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
import p000a.p013b.C0165c;
import p000a.p013b.C0184e;
import p000a.p013b.C0330h;
import p000a.p013b.p019d.C0181e;

/* renamed from: com.bridgefy.sdk.framework.controller.g */
class C1910g extends comparable_device {

    /* renamed from: a */
    final String simple_name = getClass().getSimpleName();

    /* renamed from: b */
    private boolean f5954b = false;

    C1910g(Device device, boolean z) {
        super(device);
        this.f5954b = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0159b mo7509a() {
        return C0159b.m542a((C0184e) new C0184e() {
            public final void subscribe(C0165c cVar) {
                C1910g.this.connect(cVar);
            }
        }).mo341a((C0181e<? super C0330h<Throwable>, ? extends C3682b<?>>) new C1898ai<Object,Object>(3, 1000));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void connect(C0165c cVar) throws Exception {
        BluetoothSocket bluetoothSocket;
        try {
            BluetoothAdapter bluetoothAdapter = BridgefyUtils.getBluetoothAdapter(Bridgefy.getInstance().getBridgefyCore().getContext());
            if (bluetoothAdapter != null && bluetoothAdapter.isDiscovering()) {
                bluetoothAdapter.cancelDiscovery();
            }
            if (this.f5954b) {
                bluetoothSocket = get_device().getBluetoothDevice().createRfcommSocketToServiceRecord(C1922m.m7989b());
            } else {
                bluetoothSocket = get_device().getBluetoothDevice().createInsecureRfcommSocketToServiceRecord(C1922m.m7989b());
            }
            bluetoothSocket.connect();
            Session session = new Session(bluetoothSocket);
            session.mo7381c(get_device().getDeviceAddress());
            session.mo7498b(true);
            get_device().setSessionId(session.getSessionId());
            session.mo7490a(get_device());
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
