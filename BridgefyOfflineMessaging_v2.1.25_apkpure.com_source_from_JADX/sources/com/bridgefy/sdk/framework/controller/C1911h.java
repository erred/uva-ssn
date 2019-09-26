package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.BridgefyException;
import com.bridgefy.sdk.client.BridgefyUtils;
import com.bridgefy.sdk.client.Config;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.framework.exceptions.ConnectionException;
import com.bridgefy.sdk.framework.utils.Utils;
import com.bridgefy.sdk.logging.Logger;
import com.bridgefy.sdk.logging.entities.OperatorStatusLog;
import com.bridgefy.sdk.logging.entities.OperatorStatusLog.StatusEvent;
import net.sqlcipher.database.SQLiteDatabase;

/* renamed from: com.bridgefy.sdk.framework.controller.h */
class C1911h extends C1896ag {

    /* renamed from: a */
    static int f5955a = 0;

    /* renamed from: e */
    private static String f5956e = "BluetoothController";

    /* renamed from: k */
    private static gatt_manager f5957k;

    /* renamed from: c */
    private Config f5958c;

    /* renamed from: d */
    private Context f5959d;

    /* renamed from: f */
    private C1913i f5960f;

    /* renamed from: g */
    private C1899aj f5961g;

    /* renamed from: h */
    private bluetooth_le_discovery f5962h;

    /* renamed from: i */
    private C1899aj f5963i;

    /* renamed from: j */
    private boolean f5964j = true;

    /* renamed from: l */
    private C1925o f5965l;

    /* renamed from: m */
    private BluetoothAdapter f5966m;

    C1911h(Context context, Config config) throws BridgefyException {
        this.f5959d = context;
        this.f5958c = config;
        switch (mo7514d().getAntennaType()) {
            case BLUETOOTH_LE:
                m7922f();
                break;
            case BLUETOOTH:
                break;
            default:
                return;
        }
        m7924g();
    }

    /* renamed from: f */
    private void m7922f() throws BridgefyException {
        if (!mo7516e().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            this.f5964j = false;
            switch (mo7514d().getAntennaType()) {
                case BLUETOOTH_LE:
                    Log.e(f5956e, "BLE not supported.");
                    mo7514d().setAntennaType(Antenna.UNREACHABLE);
                    throw new BridgefyException(0, "Bluetooth Low Energy not supported.");
                case BLUETOOTH:
                    mo7514d().setAntennaType(Antenna.BLUETOOTH);
                    return;
                default:
                    return;
            }
        } else {
            f5957k = new gatt_manager();
        }
    }

    /* renamed from: g */
    private void m7924g() {
        this.f5966m = BridgefyUtils.getBluetoothAdapter(mo7516e());
        if (this.f5966m.getScanMode() != 23 && Bridgefy.getInstance().getConfig().getAntennaType() == Antenna.BLUETOOTH) {
            Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_DISCOVERABLE");
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("android.bluetooth.adapter.extra.DISCOVERABLE_DURATION", 0);
            mo7516e().startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void stop_advertising() {
        f5955a = 0;
        try {
            if (this.f5966m != null && this.f5966m.getBluetoothLeAdvertiser() != null) {
                BluetoothLeAdvertiser bluetoothLeAdvertiser = this.f5966m.getBluetoothLeAdvertiser();
                if (this.f5965l != null && bluetoothLeAdvertiser != null) {
                    bluetoothLeAdvertiser.stopAdvertising(this.f5965l);
                    // Logger.log(new OperatorStatusLog(StatusEvent.BFStatusTypeStopAdvertising, Antenna.BLUETOOTH_LE));
                }
            }
        } catch (NullPointerException e) {
            String str = f5956e;
            StringBuilder sb = new StringBuilder();
            sb.append("stopAdvertising: exception ");
            sb.append(e.getMessage());
            Log.e(str, sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7454a(String str) throws IllegalStateException {
        if (f5955a != 3) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                if (this.f5966m == null || this.f5966m.getBluetoothLeAdvertiser() == null || this.f5963i == null || this.f5963i.mo7462e() == null) {
                    f5955a = 1;
                    return false;
                }
                AdvertiseSettings a = C1922m.m7985a();
                AdvertiseData a2 = C1922m.m7984a(str, C1922m.m7989b());
                BluetoothLeAdvertiser bluetoothLeAdvertiser = this.f5966m.getBluetoothLeAdvertiser();
                if (bluetoothLeAdvertiser != null) {
                    this.f5965l = new C1925o();
                    Log.i(f5956e, "startAdvertising: ");
                    bluetoothLeAdvertiser.startAdvertising(a, a2, this.f5965l);
                }
                // Logger.log(new OperatorStatusLog(StatusEvent.BFStatusTypeStartAdvertising, Antenna.BLUETOOTH_LE));
                f5955a = 3;
                return true;
            } catch (IllegalStateException unused) {
                f5955a = 0;
                return false;
            }
        } else {
            Log.e(f5956e, "startAdvertising: advertising already running");
            return false;
        }
    }

    /* renamed from: h */
    private void m7926h() {
        Log.i(f5956e, "disconnectDevices: ");
        switch (mo7514d().getAntennaType()) {
            case BLUETOOTH_LE:
                SessionManager.m7753a(Antenna.BLUETOOTH_LE);
                return;
            case BLUETOOTH:
                SessionManager.m7753a(Antenna.BLUETOOTH);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:1|2|3|4|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0031 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7919b(android.content.Intent r3, android.content.Context r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "android.bluetooth.adapter.extra.STATE"
            r1 = 0
            int r3 = r3.getIntExtra(r0, r1)     // Catch:{ all -> 0x0033 }
            switch(r3) {
                case 12: goto L_0x002b;
                case 13: goto L_0x000c;
                default: goto L_0x000b;
            }     // Catch:{ all -> 0x0033 }
        L_0x000b:
            goto L_0x0031
        L_0x000c:
            java.lang.String r3 = f5956e     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = "BluetoothAdapter.STATE_TURNING_OFF"
            android.util.Log.d(r3, r0)     // Catch:{ all -> 0x0033 }
            com.bridgefy.sdk.framework.controller.connection_manager.m8011b()     // Catch:{ all -> 0x0033 }
            r2.stop_discovery(r4)     // Catch:{ Exception -> 0x0020 }
            r2.m7926h()     // Catch:{ Exception -> 0x0020 }
            r2.mo7512b()     // Catch:{ Exception -> 0x0020 }
            goto L_0x0031
        L_0x0020:
            r3 = move-exception
            java.lang.String r4 = f5956e     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0033 }
            android.util.Log.w(r4, r3)     // Catch:{ all -> 0x0033 }
            goto L_0x0031
        L_0x002b:
            r2.mo7515d(r4)     // Catch:{ ConnectionException -> 0x0031 }
            r2.mo7510a(r4)     // Catch:{ ConnectionException -> 0x0031 }
        L_0x0031:
            monitor-exit(r2)     // Catch:{ all -> 0x0033 }
            return
        L_0x0033:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0033 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bridgefy.sdk.framework.controller.C1911h.m7919b(android.content.Intent, android.content.Context):void");
    }

    /* renamed from: e */
    private void m7921e(Context context) {
        if (this.f5960f != null) {
            this.f5960f.mo7481a(true);
            return;
        }
        this.f5966m.cancelDiscovery();
        this.f5960f = new C1913i(context);
        this.f5960f.mo7477a(context);
        this.f5960f.mo7478a(context, mo7514d());
    }

    /* renamed from: a */
    public void mo7510a(Context context) {
        switch (mo7514d().getAntennaType()) {
            case BLUETOOTH_LE:
                start_bluetooth_le_discovery(context);
                return;
            case BLUETOOTH:
                mo7513b(context);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7513b(Context context) {
        if (this.f5960f == null) {
            this.f5960f = new C1913i(context);
        }
        if (!this.f5960f.mo7482a()) {
            this.f5960f.mo7478a(context, mo7514d());
        }
    }

    /* renamed from: f */
    private void start_bluetooth_le_discovery(Context context) {
        if (this.f5964j) {
            if (this.f5962h == null) {
                this.f5962h = new bluetooth_le_discovery(context);
            } else {
                Log.w(f5956e, "startBluetoothLeDiscovery: already exists");
            }
            if (!this.f5962h.mo7482a()) {
                this.f5962h.mo7478a(context, mo7514d());
            } else {
                Log.e(f5956e, "startBluetoothLeDiscovery: discovery already running");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void stop_discovery(Context context) {
        Log.i(f5956e, "stopDiscovery: ");
        if (this.f5960f != null) {
            this.f5960f.mo7477a(context);
        }
        if (this.f5962h != null && mo7514d().getAntennaType() != Antenna.BLUETOOTH) {
            this.f5962h.mo7477a(context);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo7515d(Context context) throws ConnectionException {
        switch (mo7514d().getAntennaType()) {
            case BLUETOOTH_LE:
                start_bluetooth_le_server(context);
                return;
            case BLUETOOTH:
                m7925g(context);
                return;
            default:
                return;
        }
    }

    /* renamed from: g */
    private void m7925g(Context context) throws ConnectionException {
        this.f5961g = server_factory.get_server_instance(Antenna.BLUETOOTH, true);
        if (this.f5961g != null) {
            this.f5961g.start_server();
        }
        if (this.f5966m.getScanMode() != 23) {
            Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_DISCOVERABLE");
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("android.bluetooth.adapter.extra.DISCOVERABLE_DURATION", 0);
            mo7516e().startActivity(intent);
        }
    }

    /* renamed from: h */
    private void start_bluetooth_le_server(Context context) {
        if (!this.f5964j || this.f5966m.getBluetoothLeAdvertiser() == null) {
            f5955a = 1;
            return;
        }
        this.f5963i = server_factory.get_server_instance(Antenna.BLUETOOTH_LE, true);
        try {
            this.f5963i.start_server();
        } catch (ConnectionException e) {
            Log.e(f5956e, "startBluetoothLeServer: ", e);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        mo7454a(String.valueOf(Utils.getCrcFromKey(Bridgefy.getInstance().getBridgefyClient().getUserUuid())));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7512b() throws ConnectionException {
        switch (mo7514d().getAntennaType()) {
            case BLUETOOTH_LE:
                m7929j();
                return;
            case BLUETOOTH:
                m7928i();
                return;
            default:
                return;
        }
    }

    /* renamed from: i */
    private void m7928i() throws ConnectionException {
        this.f5961g = server_factory.get_server_instance(Antenna.BLUETOOTH, false);
        if (this.f5961g != null) {
            this.f5961g.stop_server();
            this.f5961g = null;
            server_factory.m7843a((bluetooth_server) null);
        }
    }

    /* renamed from: j */
    private void m7929j() {
        this.f5963i = server_factory.get_server_instance(Antenna.BLUETOOTH_LE, false);
        if (this.f5963i != null) {
            try {
                this.f5963i.stop_server();
            } catch (ConnectionException e) {
                e.printStackTrace();
            }
            this.f5963i = null;
            server_factory.m7842a((bluetooth_le_server) null);
        }
        f5957k.mo7419d();
        stop_advertising();
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        if (r0.equals("android.bluetooth.adapter.action.DISCOVERY_STARTED") != false) goto L_0x0068;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7511a(android.content.Intent r5, android.content.Context r6) {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 23
            if (r0 < r2) goto L_0x0029
            java.lang.String r0 = r5.getAction()
            java.lang.String r2 = com.bridgefy.sdk.framework.controller.C1913i.f5968e
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0029
            java.lang.String r6 = "android.bluetooth.device.extra.DEVICE"
            android.os.Parcelable r6 = r5.getParcelableExtra(r6)
            android.bluetooth.BluetoothDevice r6 = (android.bluetooth.BluetoothDevice) r6
            java.lang.String r0 = com.bridgefy.sdk.framework.controller.C1913i.f5969f
            int r5 = r5.getIntExtra(r0, r1)
            if (r5 != 0) goto L_0x0085
            com.bridgefy.sdk.framework.controller.i r5 = r4.f5960f
            r5.mo7519b(r6)
            goto L_0x0085
        L_0x0029:
            java.lang.String r0 = r5.getAction()
            r2 = -1
            int r3 = r0.hashCode()
            switch(r3) {
                case -1780914469: goto L_0x005d;
                case -1530327060: goto L_0x0053;
                case -377527494: goto L_0x0049;
                case 6759640: goto L_0x0040;
                case 1167529923: goto L_0x0036;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x0067
        L_0x0036:
            java.lang.String r1 = "android.bluetooth.device.action.FOUND"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0067
            r1 = 3
            goto L_0x0068
        L_0x0040:
            java.lang.String r3 = "android.bluetooth.adapter.action.DISCOVERY_STARTED"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0067
            goto L_0x0068
        L_0x0049:
            java.lang.String r1 = "android.bluetooth.device.action.UUID"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0067
            r1 = 4
            goto L_0x0068
        L_0x0053:
            java.lang.String r1 = "android.bluetooth.adapter.action.STATE_CHANGED"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0067
            r1 = 0
            goto L_0x0068
        L_0x005d:
            java.lang.String r1 = "android.bluetooth.adapter.action.DISCOVERY_FINISHED"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0067
            r1 = 2
            goto L_0x0068
        L_0x0067:
            r1 = -1
        L_0x0068:
            switch(r1) {
                case 0: goto L_0x0082;
                case 1: goto L_0x007e;
                case 2: goto L_0x0078;
                case 3: goto L_0x0072;
                case 4: goto L_0x006c;
                default: goto L_0x006b;
            }
        L_0x006b:
            goto L_0x0085
        L_0x006c:
            com.bridgefy.sdk.framework.controller.i r6 = r4.f5960f
            r6.mo7521b(r5)
            goto L_0x0085
        L_0x0072:
            com.bridgefy.sdk.framework.controller.i r6 = r4.f5960f
            r6.add_bluetooth_device(r5)
            goto L_0x0085
        L_0x0078:
            com.bridgefy.sdk.framework.controller.i r5 = r4.f5960f
            r5.fetch_device_uuid_with_sdp(r6)
            goto L_0x0085
        L_0x007e:
            r4.m7921e(r6)
            goto L_0x0085
        L_0x0082:
            r4.m7919b(r5, r6)
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bridgefy.sdk.framework.controller.C1911h.mo7511a(android.content.Intent, android.content.Context):void");
    }

    /* renamed from: c */
    static gatt_manager m7920c() {
        return f5957k;
    }

    /* renamed from: d */
    public Config mo7514d() {
        return this.f5958c;
    }

    /* renamed from: e */
    public Context mo7516e() {
        return this.f5959d;
    }
}
