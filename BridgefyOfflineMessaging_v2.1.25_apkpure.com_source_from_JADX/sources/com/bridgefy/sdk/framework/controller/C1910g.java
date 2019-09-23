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
class C1910g extends C1932t {

    /* renamed from: a */
    final String f5953a = getClass().getSimpleName();

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
                C1910g.this.m7917a(cVar);
            }
        }).mo341a((C0181e<? super C0330h<Throwable>, ? extends C3682b<?>>) new C1898ai<Object,Object>(3, 1000));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7917a(C0165c cVar) throws Exception {
        BluetoothSocket bluetoothSocket;
        try {
            BluetoothAdapter bluetoothAdapter = BridgefyUtils.getBluetoothAdapter(Bridgefy.getInstance().getBridgefyCore().getContext());
            if (bluetoothAdapter != null && bluetoothAdapter.isDiscovering()) {
                bluetoothAdapter.cancelDiscovery();
            }
            if (this.f5954b) {
                bluetoothSocket = mo7556b().getBluetoothDevice().createRfcommSocketToServiceRecord(C1922m.m7989b());
            } else {
                bluetoothSocket = mo7556b().getBluetoothDevice().createInsecureRfcommSocketToServiceRecord(C1922m.m7989b());
            }
            bluetoothSocket.connect();
            Session session = new Session(bluetoothSocket);
            session.mo7381c(mo7556b().getDeviceAddress());
            session.mo7498b(true);
            mo7556b().setSessionId(session.getSessionId());
            session.mo7490a(mo7556b());
            SessionManager.m7754a(session);
            DeviceManager.m7715a(session.getDevice());
            cVar.mo361a();
        } catch (IOException e) {
            String str = this.f5953a;
            StringBuilder sb = new StringBuilder();
            sb.append("connect: fail [ ");
            sb.append(e.getMessage());
            sb.append(" ]");
            Log.e(str, sb.toString());
            cVar.mo364b(e);
        }
    }
}
