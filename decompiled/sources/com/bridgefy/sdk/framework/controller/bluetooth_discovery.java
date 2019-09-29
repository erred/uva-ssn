package com.bridgefy.sdk.framework.controller;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.util.Log;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.BridgefyUtils;
import com.bridgefy.sdk.client.Config;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Device;
import com.bridgefy.sdk.framework.utils.Utils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.p156b.C3691c;
import org.p153a.C3682b;
import p000a.p013b.C0151a;
import p000a.p013b.C0159b;
import p000a.p013b.emitter;
import p000a.p013b.C0176d;
import p000a.p013b.C0184e;
import p000a.p013b.C0330h;
import p000a.p013b.C0340i;
import p000a.p013b.C0343j;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p019d.C0181e;

/* renamed from: com.bridgefy.sdk.framework.controller.i */
class bluetooth_discovery extends abstract_bluetooth_discovery {

    /* renamed from: e */
    static String action_sdp_record;

    /* renamed from: f */
    static String extra_sdp_search_status;

    /* renamed from: d */
    Context context;

    /* renamed from: g */
    private BluetoothAdapter bluetooth_adapter;

    /* renamed from: h */
    private CopyOnWriteArrayList<BluetoothDevice> connected_devices = new CopyOnWriteArrayList<>();

    /* renamed from: i */
    private CopyOnWriteArrayList<Device> f5973i = new CopyOnWriteArrayList<>();

    /* renamed from: j */
    private CopyOnWriteArrayList<BluetoothDevice> discovered_devices = new CopyOnWriteArrayList<>();

    /* renamed from: k */
    private C0340i<Device> f5975k;

    bluetooth_discovery(Context context) {
        this.context = context;
        this.bluetooth_adapter = BridgefyUtils.getBluetoothAdapter(context);
        if (VERSION.SDK_INT >= 23) {
            try {
                action_sdp_record = (String) BluetoothDevice.class.getDeclaredField("ACTION_SDP_RECORD").get(null);
                extra_sdp_search_status = (String) BluetoothDevice.class.getDeclaredField("EXTRA_SDP_SEARCH_STATUS").get(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f5928c = C0330h.m914a((C0343j<T>) new C0343j() {
            public final void subscribe(C0340i iVar) {
                bluetooth_discovery.this.set_f5975k(iVar);
            }
        }, C0151a.BUFFER);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void set_f5975k(C0340i iVar) throws Exception {
        this.f5975k = iVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void log_event_mo7478a(final Context context, Config config) {
        super.log_event_mo7478a(context, config);
        set_config(config);
        if (!this.bluetooth_adapter.isDiscovering()) {
            C0159b.m542a((C0184e) new C0184e() {
                public final void subscribe(emitter cVar) {
                    bluetooth_discovery.this.start_discovery(cVar);
                }
            }).mo341a((C0181e<? super C0330h<Throwable>, ? extends C3682b<?>>) new error_handler_C1898ai<Object,Object>(3, 500)).mo345a((C0176d) new C0176d() {
                public void onComplete() {
                }

                public void onSubscribe(C0161b bVar) {
                }

                public void onError(Throwable th) {
                    bluetooth_discovery.this.cancel_discovery(context);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void start_discovery(emitter cVar) throws Exception {
        if (!this.bluetooth_adapter.startDiscovery()) {
            cVar.mo364b(new Throwable("Discovery could not be started"));
        } else {
            cVar.mo361a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void cancel_discovery(Context context) {
        super.cancel_discovery(context);
        this.bluetooth_adapter.cancelDiscovery();
        if (!this.bluetooth_adapter.isEnabled()) {
            mo7479a(Antenna.BLUETOOTH);
        }
        mo7481a(false);
        this.discovered_devices.clear();
        this.f5973i.clear();
    }

    /* renamed from: c */
    private void invoke_sdp_search(BluetoothDevice bluetoothDevice) {
        try {
            String str = this.simple_name;
            StringBuilder sb = new StringBuilder();
            sb.append("... fetching with reflection ");
            sb.append(bluetoothDevice.getAddress());
            sb.append(" (");
            sb.append(bluetoothDevice.getName());
            sb.append(")");
            Log.v(str, sb.toString());
            bluetoothDevice.getClass().getDeclaredMethod("sdpSearch", new Class[]{ParcelUuid.class}).invoke(bluetoothDevice, new Object[]{new ParcelUuid(bluetooth_le_settings_builder.m7989b())});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void fetch_device_uuid_with_sdp(Context context) {
        Log.i(this.simple_name, "actionDiscoveryFinished: ");
        mo7481a(false);
        this.f5973i.clear();
        if (!this.bluetooth_adapter.isEnabled()) {
            return;
        }
        if (!this.discovered_devices.isEmpty()) {
            String str = this.simple_name;
            StringBuilder sb = new StringBuilder();
            sb.append("running fetchDeviceUuidWithSdp() for ");
            sb.append(this.discovered_devices.size());
            sb.append(" devices found during discovery: ");
            Log.v(str, sb.toString());
            Iterator it = this.discovered_devices.iterator();
            while (it.hasNext()) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) it.next();
                new ScheduledThreadPoolExecutor(1).schedule(new Runnable(bluetoothDevice) {
                    private final /* synthetic */ BluetoothDevice f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        bluetooth_discovery.this.timeout_remove_device(this.f$1);
                    }
                }, Constants.KEEP_ALIVE_INTERVAL, TimeUnit.MILLISECONDS);
                if (VERSION.SDK_INT < 23) {
                    String str2 = this.simple_name;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("... fetching ");
                    sb2.append(bluetoothDevice.getAddress());
                    sb2.append(" (");
                    sb2.append(bluetoothDevice.getName());
                    sb2.append(")");
                    Log.v(str2, sb2.toString());
                    bluetoothDevice.fetchUuidsWithSdp();
                } else {
                    invoke_sdp_search(bluetoothDevice);
                }
            }
            log_event_mo7478a(context, get_config());
            return;
        }
        log_event_mo7478a(context, get_config());
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void timeout_remove_device(BluetoothDevice bluetoothDevice) {
        remove_device(bluetoothDevice);
        String str = this.simple_name;
        StringBuilder sb = new StringBuilder();
        sb.append("... ... removed device due to fetch timeout: ");
        sb.append(bluetoothDevice.getAddress());
        Log.w(str, sb.toString());
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"HardwareIds"})
    /* renamed from: a */
    public void add_bluetooth_device(Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice != null && bluetoothDevice.getAddress() != null && bluetoothDevice.getName() != null && bluetoothDevice.getBluetoothClass() != null) {
            if (bluetoothDevice.getBluetoothClass().getDeviceClass() == 524 || bluetoothDevice.getBluetoothClass().getDeviceClass() == 272) {
                boolean z = true;
                if (!this.connected_devices.contains(bluetoothDevice) || SessionManager.getSession(bluetoothDevice.getAddress()) != null) {
                    Device device = DeviceManager.getDevice(bluetoothDevice.getAddress());
                    if (device == null || device.getSessionId() == null) {
                        String name = this.bluetooth_adapter.getName();
                        String name2 = bluetoothDevice.getName();
                        if (name2 != null) {
                            long crcFromKey = Utils.getCrcFromKey(Bridgefy.getInstance().getBridgefyClient().getUserUuid());
                            String[] split = name2.split("%&%");
                            long longValue = (split.length <= 1 || !C3691c.m10981b(split[0])) ? 0 : Long.valueOf(split[0]).longValue();
                            if (longValue > 0) {
                                int i = (crcFromKey > longValue ? 1 : (crcFromKey == longValue ? 0 : -1));
                                if (i >= 0) {
                                    String str = this.simple_name;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("addBluetoothDevice: my device name: ");
                                    sb.append(name);
                                    sb.append(" to device name: ");
                                    sb.append(name2);
                                    Log.d(str, sb.toString());
                                    String str2 = this.simple_name;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("addBluetoothDevice: myCrcname ");
                                    sb2.append(crcFromKey);
                                    sb2.append(" > ");
                                    sb2.append(longValue);
                                    sb2.append(" otherCrcName: ");
                                    sb2.append(i >= 0);
                                    Log.d(str2, sb2.toString());
                                }
                            }
                        }
                    } else {
                        Log.w(this.simple_name, "... won't try to fetchUuid() because we're already connected to that device.");
                    }
                    z = false;
                } else {
                    Log.v(this.simple_name, "... device previously known to be a Bridgefy user.");
                }
                if (z) {
                    add_connected_or_discovered(bluetoothDevice, z, false);
                }
            }
        }
    }

    /* renamed from: a */
    private void add_connected_or_discovered(BluetoothDevice bluetoothDevice, boolean z, boolean z2) {
        if (z) {
            Device device = new Device(bluetoothDevice, z2);
            this.f5973i.addIfAbsent(device);
            if (z) {
                DeviceManager.add_device_null_session(device);
                connected_devices_add(bluetoothDevice);
                this.f5975k.mo429a(device);
            } else if (!z && !z2) {
                discovered_devices_add(bluetoothDevice);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void connected_devices_add(BluetoothDevice bluetoothDevice) {
        this.connected_devices.addIfAbsent(bluetoothDevice);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void receive_confirmed_bluetooth_device(BluetoothDevice bluetoothDevice) {
        String str = this.simple_name;
        StringBuilder sb = new StringBuilder();
        sb.append("... received confirmed BluetoothDevice: ");
        sb.append(bluetoothDevice.getAddress());
        sb.append(" (");
        sb.append(bluetoothDevice.getName());
        sb.append(")");
        Log.v(str, sb.toString());
        add_connected_or_discovered(bluetoothDevice, true, false);
        discovered_devices_remove(bluetoothDevice);
    }

    /* renamed from: d */
    private void discovered_devices_add(BluetoothDevice bluetoothDevice) {
        this.discovered_devices.addIfAbsent(bluetoothDevice);
    }

    /* renamed from: e */
    private boolean remove_device(BluetoothDevice bluetoothDevice) {
        return this.discovered_devices.remove(bluetoothDevice);
    }

    /* renamed from: f */
    private void discovered_devices_remove(BluetoothDevice bluetoothDevice) {
        remove_device(bluetoothDevice);
        if (this.discovered_devices.size() == 0) {
            log_event_mo7478a(this.context, get_config());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void attempt_add_device(Intent intent) {
        boolean equals;
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.bluetooth.device.extra.UUID");
        if (!(bluetoothDevice == null || bluetoothDevice.getAddress() == null)) {
            if (parcelableArrayExtra != null) {
                int length = parcelableArrayExtra.length;
                boolean z = false;
                for (int i = 0; i < length; i++) {
                    Parcelable parcelable = parcelableArrayExtra[i];
                    String str = this.simple_name;
                    StringBuilder sb = new StringBuilder();
                    sb.append("... ... ... HELLO UUID ");
                    sb.append(parcelable.toString());
                    sb.append(" DEVICE ");
                    sb.append(bluetoothDevice.getName());
                    sb.append(" address ");
                    sb.append(bluetoothDevice.getAddress());
                    Log.v(str, sb.toString());
                    if (parcelable.equals(flip_uuid_byte_order(UUID.fromString(parcelable.toString()))) || parcelable.equals(bluetooth_le_settings_builder.m7989b())) {
                        Log.v(this.simple_name, "... ... Matching device found!");
                        z = true;
                    }
                }
                add_connected_or_discovered(bluetoothDevice, z, false);
            } else {
                String str2 = this.simple_name;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("... ... Received null UUIDs for ");
                sb2.append(bluetoothDevice.getName());
                sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                sb2.append(bluetoothDevice.getAddress());
                Log.v(str2, sb2.toString());
            }
        }
        discovered_devices_remove(bluetoothDevice);
    }

    /* renamed from: a */
    private UUID flip_uuid_byte_order(UUID uuid) {
        ByteBuffer allocate = ByteBuffer.allocate(16);
        allocate.putLong(uuid.getLeastSignificantBits()).putLong(uuid.getMostSignificantBits());
        allocate.rewind();
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        return new UUID(allocate.getLong(), allocate.getLong());
    }
}
