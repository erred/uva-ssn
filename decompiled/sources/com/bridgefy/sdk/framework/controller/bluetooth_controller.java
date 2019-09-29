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
class bluetooth_controller extends operation_controller_interface {

    /* renamed from: a */
    static int f5955a = 0;

    /* renamed from: e */
    private static String simple_name = "BluetoothController";

    /* renamed from: k */
    private static gatt_manager gatt_manager;

    /* renamed from: c */
    private Config config;

    /* renamed from: d */
    private Context context;

    /* renamed from: f */
    private bluetooth_discovery bluetooth_discovery;

    /* renamed from: g */
    private bluetooth_server bluetooth_server;

    /* renamed from: h */
    private bluetooth_le_discovery bluetooth_le_discovery;

    /* renamed from: i */
    private bluetooth_server server;

    /* renamed from: j */
    private boolean f5964j = true;

    /* renamed from: l */
    private advertise_callback advertise_callback;

    /* renamed from: m */
    private BluetoothAdapter bluetooth_adapter;

    bluetooth_controller(Context context, Config config) throws BridgefyException {
        this.context = context;
        this.config = config;
        switch (get_config().getAntennaType()) {
            case BLUETOOTH_LE:
                initialize_antenna();
                break;
            case BLUETOOTH:
                break;
            default:
                return;
        }
        start_discoverable();
    }

    /* renamed from: f */
    private void initialize_antenna() throws BridgefyException {
        if (!get_context().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            this.f5964j = false;
            switch (get_config().getAntennaType()) {
                case BLUETOOTH_LE:
                    Log.e(simple_name, "BLE not supported.");
                    get_config().setAntennaType(Antenna.UNREACHABLE);
                    throw new BridgefyException(0, "Bluetooth Low Energy not supported.");
                case BLUETOOTH:
                    get_config().setAntennaType(Antenna.BLUETOOTH);
                    return;
                default:
                    return;
            }
        } else {
            gatt_manager = new gatt_manager();
        }
    }

    /* renamed from: g */
    private void start_discoverable() {
        this.bluetooth_adapter = BridgefyUtils.getBluetoothAdapter(get_context());
        if (this.bluetooth_adapter.getScanMode() != 23 && Bridgefy.getInstance().getConfig().getAntennaType() == Antenna.BLUETOOTH) {
            Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_DISCOVERABLE");
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("android.bluetooth.adapter.extra.DISCOVERABLE_DURATION", 0);
            get_context().startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void stop_advertising() {
        f5955a = 0;
        try {
            if (this.bluetooth_adapter != null && this.bluetooth_adapter.getBluetoothLeAdvertiser() != null) {
                BluetoothLeAdvertiser bluetoothLeAdvertiser = this.bluetooth_adapter.getBluetoothLeAdvertiser();
                if (this.advertise_callback != null && bluetoothLeAdvertiser != null) {
                    bluetoothLeAdvertiser.stopAdvertising(this.advertise_callback);
                    // Logger.log(new OperatorStatusLog(StatusEvent.BFStatusTypeStopAdvertising, Antenna.BLUETOOTH_LE));
                }
            }
        } catch (NullPointerException e) {
            String str = simple_name;
            StringBuilder sb = new StringBuilder();
            sb.append("stopAdvertising: exception ");
            sb.append(e.getMessage());
            Log.e(str, sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean start_advertising(String str) throws IllegalStateException {
        if (f5955a != 3) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                if (this.bluetooth_adapter == null || this.bluetooth_adapter.getBluetoothLeAdvertiser() == null || this.server == null || this.server.mo7462e() == null) {
                    f5955a = 1;
                    return false;
                }
                AdvertiseSettings a = bluetooth_le_settings_builder.build_advertise_settings();
                AdvertiseData a2 = bluetooth_le_settings_builder.build_advertise_data(str, bluetooth_le_settings_builder.m7989b());
                BluetoothLeAdvertiser bluetoothLeAdvertiser = this.bluetooth_adapter.getBluetoothLeAdvertiser();
                if (bluetoothLeAdvertiser != null) {
                    this.advertise_callback = new advertise_callback();
                    Log.i(simple_name, "startAdvertising: ");
                    bluetoothLeAdvertiser.startAdvertising(a, a2, this.advertise_callback);
                }
                // Logger.log(new OperatorStatusLog(StatusEvent.BFStatusTypeStartAdvertising, Antenna.BLUETOOTH_LE));
                f5955a = 3;
                return true;
            } catch (IllegalStateException unused) {
                f5955a = 0;
                return false;
            }
        } else {
            Log.e(simple_name, "startAdvertising: advertising already running");
            return false;
        }
    }

    /* renamed from: h */
    private void disconnect_devices() {
        Log.i(simple_name, "disconnectDevices: ");
        switch (get_config().getAntennaType()) {
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
            java.lang.String r3 = simple_name     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = "BluetoothAdapter.STATE_TURNING_OFF"
            android.util.Log.d(r3, r0)     // Catch:{ all -> 0x0033 }
            com.bridgefy.sdk.framework.controller.connection_manager.m8011b()     // Catch:{ all -> 0x0033 }
            r2.stop_discovery(r4)     // Catch:{ Exception -> 0x0020 }
            r2.disconnect_devices()     // Catch:{ Exception -> 0x0020 }
            r2.stop_server()     // Catch:{ Exception -> 0x0020 }
            goto L_0x0031
        L_0x0020:
            r3 = move-exception
            java.lang.String r4 = simple_name     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0033 }
            android.util.Log.w(r4, r3)     // Catch:{ all -> 0x0033 }
            goto L_0x0031
        L_0x002b:
            r2.start_server(r4)     // Catch:{ ConnectionException -> 0x0031 }
            r2.mo7510a(r4)     // Catch:{ ConnectionException -> 0x0031 }
        L_0x0031:
            monitor-exit(r2)     // Catch:{ all -> 0x0033 }
            return
        L_0x0033:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0033 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bridgefy.sdk.framework.controller.bluetooth_controller.m7919b(android.content.Intent, android.content.Context):void");
    }

    /* renamed from: e */
    private void m7921e(Context context) {
        if (this.bluetooth_discovery != null) {
            this.bluetooth_discovery.mo7481a(true);
            return;
        }
        this.bluetooth_adapter.cancelDiscovery();
        this.bluetooth_discovery = new bluetooth_discovery(context);
        this.bluetooth_discovery.cancel_discovery(context);
        this.bluetooth_discovery.log_event_mo7478a(context, get_config());
    }

    /* renamed from: a */
    public void mo7510a(Context context) {
        switch (get_config().getAntennaType()) {
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
        if (this.bluetooth_discovery == null) {
            this.bluetooth_discovery = new bluetooth_discovery(context);
        }
        if (!this.bluetooth_discovery.mo7482a()) {
            this.bluetooth_discovery.log_event_mo7478a(context, get_config());
        }
    }

    /* renamed from: f */
    private void start_bluetooth_le_discovery(Context context) {
        if (this.f5964j) {
            if (this.bluetooth_le_discovery == null) {
                this.bluetooth_le_discovery = new bluetooth_le_discovery(context);
            } else {
                Log.w(simple_name, "startBluetoothLeDiscovery: already exists");
            }
            if (!this.bluetooth_le_discovery.mo7482a()) {
                this.bluetooth_le_discovery.log_event_mo7478a(context, get_config());
            } else {
                Log.e(simple_name, "startBluetoothLeDiscovery: discovery already running");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void stop_discovery(Context context) {
        Log.i(simple_name, "stopDiscovery: ");
        if (this.bluetooth_discovery != null) {
            this.bluetooth_discovery.cancel_discovery(context);
        }
        if (this.bluetooth_le_discovery != null && get_config().getAntennaType() != Antenna.BLUETOOTH) {
            this.bluetooth_le_discovery.cancel_discovery(context);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void start_server(Context context) throws ConnectionException {
        switch (get_config().getAntennaType()) {
            case BLUETOOTH_LE:
                start_bluetooth_le_server(context);
                return;
            case BLUETOOTH:
                start_bluetooth_server(context);
                return;
            default:
                return;
        }
    }

    /* renamed from: g */
    private void start_bluetooth_server(Context context) throws ConnectionException {
        this.bluetooth_server = server_factory.get_server_instance(Antenna.BLUETOOTH, true);
        if (this.bluetooth_server != null) {
            this.bluetooth_server.start_server();
        }
        if (this.bluetooth_adapter.getScanMode() != 23) {
            Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_DISCOVERABLE");
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("android.bluetooth.adapter.extra.DISCOVERABLE_DURATION", 0);
            get_context().startActivity(intent);
        }
    }

    /* renamed from: h */
    private void start_bluetooth_le_server(Context context) {
        if (!this.f5964j || this.bluetooth_adapter.getBluetoothLeAdvertiser() == null) {
            f5955a = 1;
            return;
        }
        this.server = server_factory.get_server_instance(Antenna.BLUETOOTH_LE, true);
        try {
            this.server.start_server();
        } catch (ConnectionException e) {
            Log.e(simple_name, "startBluetoothLeServer: ", e);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        start_advertising(String.valueOf(Utils.getCrcFromKey(Bridgefy.getInstance().getBridgefyClient().getUserUuid())));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void stop_server() throws ConnectionException {
        switch (get_config().getAntennaType()) {
            case BLUETOOTH_LE:
                stop_bluetooth_le_server();
                return;
            case BLUETOOTH:
                stop_bluetooth_server();
                return;
            default:
                return;
        }
    }

    /* renamed from: i */
    private void stop_bluetooth_server() throws ConnectionException {
        this.bluetooth_server = server_factory.get_server_instance(Antenna.BLUETOOTH, false);
        if (this.bluetooth_server != null) {
            this.bluetooth_server.stop_server();
            this.bluetooth_server = null;
            server_factory.m7843a((bluetooth_server) null);
        }
    }

    /* renamed from: j */
    private void stop_bluetooth_le_server() {
        this.server = server_factory.get_server_instance(Antenna.BLUETOOTH_LE, false);
        if (this.server != null) {
            try {
                this.server.stop_server();
            } catch (ConnectionException e) {
                e.printStackTrace();
            }
            this.server = null;
            server_factory.m7842a((bluetooth_le_server) null);
        }
        gatt_manager.mo7419d();
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
            java.lang.String r2 = com.bridgefy.sdk.framework.controller.bluetooth_discovery.action_sdp_record
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0029
            java.lang.String r6 = "android.bluetooth.device.extra.DEVICE"
            android.os.Parcelable r6 = r5.getParcelableExtra(r6)
            android.bluetooth.BluetoothDevice r6 = (android.bluetooth.BluetoothDevice) r6
            java.lang.String r0 = com.bridgefy.sdk.framework.controller.bluetooth_discovery.extra_sdp_search_status
            int r5 = r5.getIntExtra(r0, r1)
            if (r5 != 0) goto L_0x0085
            com.bridgefy.sdk.framework.controller.i r5 = r4.bluetooth_discovery
            r5.receive_confirmed_bluetooth_device(r6)
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
            com.bridgefy.sdk.framework.controller.i r6 = r4.bluetooth_discovery
            r6.attempt_add_device(r5)
            goto L_0x0085
        L_0x0072:
            com.bridgefy.sdk.framework.controller.i r6 = r4.bluetooth_discovery
            r6.add_bluetooth_device(r5)
            goto L_0x0085
        L_0x0078:
            com.bridgefy.sdk.framework.controller.i r5 = r4.bluetooth_discovery
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
        throw new UnsupportedOperationException("Method not decompiled: com.bridgefy.sdk.framework.controller.bluetooth_controller.mo7511a(android.content.Intent, android.content.Context):void");
    }

    /* renamed from: c */
    static gatt_manager get_gatt_manager() {
        return gatt_manager;
    }

    /* renamed from: d */
    public Config get_config() {
        return this.config;
    }

    /* renamed from: e */
    public Context get_context() {
        return this.context;
    }
}
