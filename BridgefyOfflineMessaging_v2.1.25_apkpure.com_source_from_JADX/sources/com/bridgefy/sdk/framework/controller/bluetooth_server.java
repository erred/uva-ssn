package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.util.Log;
import com.bridgefy.sdk.client.BridgefyUtils;
import com.bridgefy.sdk.client.Config;
import com.bridgefy.sdk.client.Device;
import com.bridgefy.sdk.framework.exceptions.ConnectionException;
import com.bridgefy.sdk.framework.utils.Utils;
import com.google.gson.GsonBuilder;
import java.io.IOException;

/* renamed from: com.bridgefy.sdk.framework.controller.n */
class bluetooth_server extends C1899aj<BluetoothSocket, BluetoothServerSocket> {
    bluetooth_server(Config config, boolean z, Context context) throws ConnectionException {
        super(config, context);
        BluetoothAdapter bluetoothAdapter = BridgefyUtils.getBluetoothAdapter(context);
        connection_manager.f5998a = Utils.getCrcFromKey(bluetoothAdapter.getName());
        if (z) {
            try {
                mo7458a(bluetoothAdapter.listenUsingRfcommWithServiceRecord(bluetoothAdapter.getName(), C1922m.m7989b()));
            } catch (IOException e) {
                throw new ConnectionException(e.getMessage(), e);
            }
        } else {
            mo7458a(bluetoothAdapter.listenUsingInsecureRfcommWithServiceRecord(bluetoothAdapter.getName(), C1922m.m7989b()));
        }
    }

    /* renamed from: b */
    public void start_server() throws ConnectionException {
        String str = this.f5905c;
        StringBuilder sb = new StringBuilder();
        sb.append("startServer: is connected: ");
        sb.append(mo7461c());
        Log.i(str, sb.toString());
        if (!mo7461c()) {
            mo7460b(true);
            super.start();
        }
    }

    /* renamed from: a */
    public void stop_server() throws ConnectionException {
        if (mo7461c()) {
            try {
                mo7460b(false);
                ((BluetoothServerSocket) mo7462e()).close();
                super.interrupt();
            } catch (IOException e) {
                throw new ConnectionException((Exception) e);
            } catch (Throwable th) {
                super.interrupt();
                throw th;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void accept_connection(BluetoothSocket bluetoothSocket) {
        String str = this.f5905c;
        StringBuilder sb = new StringBuilder();
        sb.append("acceptConnection: device ");
        sb.append(bluetoothSocket.getRemoteDevice().getAddress());
        Log.w(str, sb.toString());
        Session session = new Session(bluetoothSocket);
        Device device = DeviceManager.getDevice(bluetoothSocket.getRemoteDevice().getAddress());
        if (device == null) {
            device = new Device(session.mo7484a().getRemoteDevice(), false);
        }
        session.mo7381c(device.getDeviceAddress());
        device.setSessionId(session.getSessionId());
        session.mo7490a(device);
        SessionManager.queue_session(session);
        DeviceManager.add_device_null_session(device);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(SessionManager.m7752a(2));
        sb2.append(" Connected with device: ");
        sb2.append(new GsonBuilder().setPrettyPrinting().create().toJson((Object) device));
        Log.d("BluetoothServer", sb2.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo7461c() {
        return super.isAlive() && mo7462e() != null;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:19:0x0001, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void run() {
        /*
            r3 = this;
            monitor-enter(r3)
        L_0x0001:
            boolean r0 = r3.mo7463f()     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x002e
            java.lang.Object r0 = r3.mo7462e()     // Catch:{ all -> 0x0030 }
            if (r0 != 0) goto L_0x0020
            java.lang.String r0 = r3.f5905c     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = "run: not server instance, finalize server."
            android.util.Log.e(r0, r1)     // Catch:{ all -> 0x0030 }
            r3.stop_server()     // Catch:{ ConnectionException -> 0x0018 }
            goto L_0x0020
        L_0x0018:
            r0 = move-exception
            java.lang.String r1 = r3.f5905c     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = "run: stop server in runnable"
            android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0030 }
        L_0x0020:
            java.lang.Object r0 = r3.mo7462e()     // Catch:{ IOException -> 0x0001 }
            android.bluetooth.BluetoothServerSocket r0 = (android.bluetooth.BluetoothServerSocket) r0     // Catch:{ IOException -> 0x0001 }
            android.bluetooth.BluetoothSocket r0 = r0.accept()     // Catch:{ IOException -> 0x0001 }
            r3.accept_connection(r0)     // Catch:{ IOException -> 0x0001 }
            goto L_0x0001
        L_0x002e:
            monitor-exit(r3)
            return
        L_0x0030:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bridgefy.sdk.framework.controller.bluetooth_server.run():void");
    }
}
