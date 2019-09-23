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
import p000a.p013b.C0165c;
import p000a.p013b.C0176d;
import p000a.p013b.C0184e;
import p000a.p013b.C0330h;
import p000a.p013b.C0340i;
import p000a.p013b.C0343j;
import p000a.p013b.p017b.C0161b;
import p000a.p013b.p019d.C0181e;

/* renamed from: com.bridgefy.sdk.framework.controller.i */
class C1913i extends C1906c {

    /* renamed from: e */
    static String f5968e;

    /* renamed from: f */
    static String f5969f;

    /* renamed from: d */
    Context f5970d;

    /* renamed from: g */
    private BluetoothAdapter f5971g;

    /* renamed from: h */
    private CopyOnWriteArrayList<BluetoothDevice> f5972h = new CopyOnWriteArrayList<>();

    /* renamed from: i */
    private CopyOnWriteArrayList<Device> f5973i = new CopyOnWriteArrayList<>();

    /* renamed from: j */
    private CopyOnWriteArrayList<BluetoothDevice> f5974j = new CopyOnWriteArrayList<>();

    /* renamed from: k */
    private C0340i<Device> f5975k;

    C1913i(Context context) {
        this.f5970d = context;
        this.f5971g = BridgefyUtils.getBluetoothAdapter(context);
        if (VERSION.SDK_INT >= 23) {
            try {
                f5968e = (String) BluetoothDevice.class.getDeclaredField("ACTION_SDP_RECORD").get(null);
                f5969f = (String) BluetoothDevice.class.getDeclaredField("EXTRA_SDP_SEARCH_STATUS").get(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f5928c = C0330h.m914a((C0343j<T>) new C0343j() {
            public final void subscribe(C0340i iVar) {
                C1913i.this.m7942a(iVar);
            }
        }, C0151a.BUFFER);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7942a(C0340i iVar) throws Exception {
        this.f5975k = iVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7478a(final Context context, Config config) {
        super.mo7478a(context, config);
        mo7480a(config);
        if (!this.f5971g.isDiscovering()) {
            C0159b.m542a((C0184e) new C0184e() {
                public final void subscribe(C0165c cVar) {
                    C1913i.this.m7941a(cVar);
                }
            }).mo341a((C0181e<? super C0330h<Throwable>, ? extends C3682b<?>>) new C1898ai<Object,Object>(3, 500)).mo345a((C0176d) new C0176d() {
                public void onComplete() {
                }

                public void onSubscribe(C0161b bVar) {
                }

                public void onError(Throwable th) {
                    C1913i.this.mo7477a(context);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m7941a(C0165c cVar) throws Exception {
        if (!this.f5971g.startDiscovery()) {
            cVar.mo364b(new Throwable("Discovery could not be started"));
        } else {
            cVar.mo361a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7477a(Context context) {
        super.mo7477a(context);
        this.f5971g.cancelDiscovery();
        if (!this.f5971g.isEnabled()) {
            mo7479a(Antenna.BLUETOOTH);
        }
        mo7481a(false);
        this.f5974j.clear();
        this.f5973i.clear();
    }

    /* renamed from: c */
    private void m7944c(BluetoothDevice bluetoothDevice) {
        try {
            String str = this.f5926a;
            StringBuilder sb = new StringBuilder();
            sb.append("... fetching with reflection ");
            sb.append(bluetoothDevice.getAddress());
            sb.append(" (");
            sb.append(bluetoothDevice.getName());
            sb.append(")");
            Log.v(str, sb.toString());
            bluetoothDevice.getClass().getDeclaredMethod("sdpSearch", new Class[]{ParcelUuid.class}).invoke(bluetoothDevice, new Object[]{new ParcelUuid(C1922m.m7989b())});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7520b(Context context) {
        Log.i(this.f5926a, "actionDiscoveryFinished: ");
        mo7481a(false);
        this.f5973i.clear();
        if (!this.f5971g.isEnabled()) {
            return;
        }
        if (!this.f5974j.isEmpty()) {
            String str = this.f5926a;
            StringBuilder sb = new StringBuilder();
            sb.append("running fetchDeviceUuidWithSdp() for ");
            sb.append(this.f5974j.size());
            sb.append(" devices found during discovery: ");
            Log.v(str, sb.toString());
            Iterator it = this.f5974j.iterator();
            while (it.hasNext()) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) it.next();
                new ScheduledThreadPoolExecutor(1).schedule(new Runnable(bluetoothDevice) {
                    private final /* synthetic */ BluetoothDevice f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        C1913i.this.m7948g(this.f$1);
                    }
                }, Constants.KEEP_ALIVE_INTERVAL, TimeUnit.MILLISECONDS);
                if (VERSION.SDK_INT < 23) {
                    String str2 = this.f5926a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("... fetching ");
                    sb2.append(bluetoothDevice.getAddress());
                    sb2.append(" (");
                    sb2.append(bluetoothDevice.getName());
                    sb2.append(")");
                    Log.v(str2, sb2.toString());
                    bluetoothDevice.fetchUuidsWithSdp();
                } else {
                    m7944c(bluetoothDevice);
                }
            }
            mo7478a(context, mo7483b());
            return;
        }
        mo7478a(context, mo7483b());
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m7948g(BluetoothDevice bluetoothDevice) {
        m7946e(bluetoothDevice);
        String str = this.f5926a;
        StringBuilder sb = new StringBuilder();
        sb.append("... ... removed device due to fetch timeout: ");
        sb.append(bluetoothDevice.getAddress());
        Log.w(str, sb.toString());
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"HardwareIds"})
    /* renamed from: a */
    public void mo7518a(Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (bluetoothDevice != null && bluetoothDevice.getAddress() != null && bluetoothDevice.getName() != null && bluetoothDevice.getBluetoothClass() != null) {
            if (bluetoothDevice.getBluetoothClass().getDeviceClass() == 524 || bluetoothDevice.getBluetoothClass().getDeviceClass() == 272) {
                boolean z = true;
                if (!this.f5972h.contains(bluetoothDevice) || SessionManager.getSession(bluetoothDevice.getAddress()) != null) {
                    Device device = DeviceManager.getDevice(bluetoothDevice.getAddress());
                    if (device == null || device.getSessionId() == null) {
                        String name = this.f5971g.getName();
                        String name2 = bluetoothDevice.getName();
                        if (name2 != null) {
                            long crcFromKey = Utils.getCrcFromKey(Bridgefy.getInstance().getBridgefyClient().getUserUuid());
                            String[] split = name2.split("%&%");
                            long longValue = (split.length <= 1 || !C3691c.m10981b(split[0])) ? 0 : Long.valueOf(split[0]).longValue();
                            if (longValue > 0) {
                                int i = (crcFromKey > longValue ? 1 : (crcFromKey == longValue ? 0 : -1));
                                if (i >= 0) {
                                    String str = this.f5926a;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("addBluetoothDevice: my device name: ");
                                    sb.append(name);
                                    sb.append(" to device name: ");
                                    sb.append(name2);
                                    Log.d(str, sb.toString());
                                    String str2 = this.f5926a;
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
                        Log.w(this.f5926a, "... won't try to fetchUuid() because we're already connected to that device.");
                    }
                    z = false;
                } else {
                    Log.v(this.f5926a, "... device previously known to be a Bridgefy user.");
                }
                if (z) {
                    m7943a(bluetoothDevice, z, false);
                }
            }
        }
    }

    /* renamed from: a */
    private void m7943a(BluetoothDevice bluetoothDevice, boolean z, boolean z2) {
        if (z) {
            Device device = new Device(bluetoothDevice, z2);
            this.f5973i.addIfAbsent(device);
            if (z) {
                DeviceManager.m7715a(device);
                mo7517a(bluetoothDevice);
                this.f5975k.mo429a(device);
            } else if (!z && !z2) {
                m7945d(bluetoothDevice);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7517a(BluetoothDevice bluetoothDevice) {
        this.f5972h.addIfAbsent(bluetoothDevice);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7519b(BluetoothDevice bluetoothDevice) {
        String str = this.f5926a;
        StringBuilder sb = new StringBuilder();
        sb.append("... received confirmed BluetoothDevice: ");
        sb.append(bluetoothDevice.getAddress());
        sb.append(" (");
        sb.append(bluetoothDevice.getName());
        sb.append(")");
        Log.v(str, sb.toString());
        m7943a(bluetoothDevice, true, false);
        m7947f(bluetoothDevice);
    }

    /* renamed from: d */
    private void m7945d(BluetoothDevice bluetoothDevice) {
        this.f5974j.addIfAbsent(bluetoothDevice);
    }

    /* renamed from: e */
    private boolean m7946e(BluetoothDevice bluetoothDevice) {
        return this.f5974j.remove(bluetoothDevice);
    }

    /* renamed from: f */
    private void m7947f(BluetoothDevice bluetoothDevice) {
        m7946e(bluetoothDevice);
        if (this.f5974j.size() == 0) {
            mo7478a(this.f5970d, mo7483b());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7521b(Intent intent) {
        boolean equals;
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.bluetooth.device.extra.UUID");
        if (!(bluetoothDevice == null || bluetoothDevice.getAddress() == null)) {
            if (parcelableArrayExtra != null) {
                int length = parcelableArrayExtra.length;
                boolean z = false;
                for (int i = 0; i < length; i++) {
                    Parcelable parcelable = parcelableArrayExtra[i];
                    String str = this.f5926a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("... ... ... HELLO UUID ");
                    sb.append(parcelable.toString());
                    sb.append(" DEVICE ");
                    sb.append(bluetoothDevice.getName());
                    sb.append(" address ");
                    sb.append(bluetoothDevice.getAddress());
                    Log.v(str, sb.toString());
                    if (parcelable.equals(m7940a(UUID.fromString(parcelable.toString()))) || parcelable.equals(C1922m.m7989b())) {
                        Log.v(this.f5926a, "... ... Matching device found!");
                        z = true;
                    }
                }
                m7943a(bluetoothDevice, z, false);
            } else {
                String str2 = this.f5926a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("... ... Received null UUIDs for ");
                sb2.append(bluetoothDevice.getName());
                sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                sb2.append(bluetoothDevice.getAddress());
                Log.v(str2, sb2.toString());
            }
        }
        m7947f(bluetoothDevice);
    }

    /* renamed from: a */
    private UUID m7940a(UUID uuid) {
        ByteBuffer allocate = ByteBuffer.allocate(16);
        allocate.putLong(uuid.getLeastSignificantBits()).putLong(uuid.getMostSignificantBits());
        allocate.rewind();
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        return new UUID(allocate.getLong(), allocate.getLong());
    }
}
