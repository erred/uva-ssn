package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.ParcelUuid;
import android.util.Log;
import com.bridgefy.sdk.client.Config;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Device;
import com.bridgefy.sdk.client.DeviceProfile;
import com.bridgefy.sdk.logging.Logger;
import com.bridgefy.sdk.logging.entities.OperatorStatusLog;
import com.bridgefy.sdk.logging.entities.OperatorStatusLog.StatusEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import p000a.p013b.C0151a;
import p000a.p013b.C0159b;
import p000a.p013b.C0330h;
import p000a.p013b.C0340i;
import p000a.p013b.C0343j;
import p000a.p013b.p017b.C0160a;
import p000a.p013b.p019d.C0177a;
import p000a.p013b.p019d.C0180d;

/* renamed from: com.bridgefy.sdk.framework.controller.k */
class C1918k extends C1906c {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public BluetoothAdapter f5983d;

    /* renamed from: e */
    private HashMap<Long, BluetoothDevice> f5984e;

    /* renamed from: f */
    private C0160a f5985f = new C0160a();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ScanCallback f5986g;

    C1918k(Context context) {
        this.f5983d = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
        if (this.f5983d == null) {
            Log.e("Bluetooth_LE_Discovery", "BluetoothAdapter was null!");
        }
        this.f5984e = new HashMap<>();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7965a(ScanResult scanResult, C0340i<Device> iVar) {
        long a = mo7533a(scanResult);
        if (a > -1 && this.f5983d != null && this.f5983d.isEnabled()) {
            Device a2 = mo7534a(a, scanResult.getDevice());
            if (a2 != null) {
                iVar.mo429a(a2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7964a(int i) {
        mo7481a(false);
        switch (i) {
            case 1:
                Log.e("Bluetooth_LE_Discovery", "onScanFailed: already started");
                break;
            case 2:
                Log.e("Bluetooth_LE_Discovery", "onScanFailed: registration failed");
                break;
            case 3:
                Log.e("Bluetooth_LE_Discovery", "onScanFailed: internal error");
                break;
            case 4:
                Log.e("Bluetooth_LE_Discovery", "onScanFailed: feature unsupported");
                break;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SCANNING FAILED WITH ERROR CODE ");
        sb.append(i);
        Log.e("Bluetooth_LE_Discovery", sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7478a(Context context, Config config) {
        this.f5928c = C0330h.m914a((C0343j<T>) new C0343j<Device>() {
            public void subscribe(final C0340i<Device> iVar) throws Exception {
                if (C1918k.this.f5983d != null && C1918k.this.f5983d.isEnabled()) {
                    if (C1918k.this.f5983d.getBluetoothLeScanner() == null) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        C1918k.this.f5983d.getBluetoothLeScanner().startScan(C1922m.m7988b(C1922m.m7989b()), C1922m.m7992d(), C1918k.this.f5986g = new ScanCallback() {
                            public void onScanResult(int i, ScanResult scanResult) {
                                super.onScanResult(i, scanResult);
                                C1918k.this.m7965a(scanResult, iVar);
                            }

                            public void onScanFailed(int i) {
                                super.onScanFailed(i);
                                C1918k.this.m7964a(i);
                            }

                            public void onBatchScanResults(List<ScanResult> list) {
                                super.onBatchScanResults(list);
                                ArrayList arrayList = new ArrayList();
                                Log.d("Bluetooth_LE_Discovery", "onBatchScanResults: beginnning of batch");
                                for (ScanResult scanResult : list) {
                                    long a = C1918k.this.mo7533a(scanResult);
                                    if (a > -1) {
                                        Device a2 = C1918k.this.mo7534a(a, scanResult.getDevice());
                                        if (a2 != null) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("onBatchScanResults: adding to batch ");
                                            sb.append(scanResult.getDevice().getAddress());
                                            Log.d("Bluetooth_LE_Discovery", sb.toString());
                                            arrayList.add(a2);
                                        }
                                    }
                                }
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    iVar.mo429a((Device) it.next());
                                }
                            }
                        });
                        C1918k.this.mo7481a(true);
                    } catch (IllegalStateException e2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("run: ");
                        sb.append(e2.getMessage());
                        Log.e("Bluetooth_LE_Discovery", sb.toString());
                    }
                    Logger.log(new OperatorStatusLog(StatusEvent.BFStatusTypeDiscoveryStarted, Antenna.BLUETOOTH_LE));
                }
            }
        }, C0151a.BUFFER);
        super.mo7478a(context, config);
        mo7480a(config);
        C0159b.m540a(60, TimeUnit.SECONDS).mo340a((C0177a) new C0177a() {
            public final void run() {
                C1918k.this.m7970c();
            }
        }, (C0180d<? super Throwable>) $$Lambda$k$I6tE8IQSJJIJ2kNUdCkNYXsiaA.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m7970c() throws Exception {
        if (SessionManager.f5869a.isEmpty()) {
            Log.i("Bluetooth_LE_Discovery", "startDiscovery: resetting");
            mo7477a((Context) null);
            mo7478a((Context) null, mo7483b());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m7968a(Throwable th) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("accept: error");
        sb.append(th.getMessage());
        Log.e("Bluetooth_LE_Discovery", sb.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7477a(Context context) {
        super.mo7477a(context);
        this.f5985f.mo354b();
        if (this.f5983d == null || this.f5986g == null || !this.f5983d.isEnabled() || this.f5983d.getBluetoothLeScanner() == null) {
            Log.w("Bluetooth_LE_Discovery", "BluetoothAdapter or PresenceCallback were null!");
        } else {
            try {
                this.f5983d.getBluetoothLeScanner().stopScan(this.f5986g);
            } catch (IllegalStateException unused) {
            }
        }
        mo7481a(false);
        Logger.log(new OperatorStatusLog(StatusEvent.BFStatusTypeDiscoveryStopped, Antenna.BLUETOOTH_LE));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7479a(Antenna antenna) {
        super.mo7479a(antenna);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public long mo7533a(ScanResult scanResult) {
        List<ParcelUuid> serviceUuids = scanResult.getScanRecord().getServiceUuids();
        Map serviceData = scanResult.getScanRecord().getServiceData();
        BluetoothDevice device = scanResult.getDevice();
        long j = -1;
        if (serviceUuids != null && !serviceUuids.isEmpty()) {
            long j2 = -1;
            for (ParcelUuid equals : serviceUuids) {
                if (equals.equals(new ParcelUuid(C1922m.m7989b()))) {
                    try {
                        j2 = Long.parseLong(device.getName());
                        if (this.f5984e.get(Long.valueOf(j2)) == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("IOS DEVICE FOUND ");
                            sb.append(j2);
                            Log.v("Bluetooth_LE_Discovery", sb.toString());
                            this.f5984e.put(Long.valueOf(j2), device);
                        }
                    } catch (NumberFormatException unused) {
                        return -1;
                    }
                }
            }
            j = j2;
        } else if (!(serviceData == null || serviceData.entrySet() == null)) {
            for (Entry entry : serviceData.entrySet()) {
                if (((ParcelUuid) entry.getKey()).getUuid().toString().equalsIgnoreCase(C1922m.m7989b().toString()) || ((ParcelUuid) entry.getKey()).getUuid().toString().equalsIgnoreCase(C1922m.m7987a(C1922m.m7989b()).toString())) {
                    j = Long.parseLong(new String((byte[]) entry.getValue()).replaceAll("\\D+", ""));
                    if (this.f5984e.get(Long.valueOf(j)) == null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Android Device Found ");
                        sb2.append(device.getAddress());
                        sb2.append(" crc: ");
                        sb2.append(j);
                        Log.v("Bluetooth_LE_Discovery", sb2.toString());
                        this.f5984e.put(Long.valueOf(j), device);
                    }
                }
            }
        }
        return j;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f1, code lost:
        return r0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.bridgefy.sdk.client.Device mo7534a(long r12, android.bluetooth.BluetoothDevice r14) {
        /*
            r11 = this;
            monitor-enter(r11)
            android.bluetooth.BluetoothAdapter r0 = r11.f5983d     // Catch:{ all -> 0x00fd }
            boolean r0 = r0.isEnabled()     // Catch:{ all -> 0x00fd }
            r1 = 0
            if (r0 == 0) goto L_0x00f4
            if (r14 == 0) goto L_0x00f4
            java.lang.String r0 = r14.getAddress()     // Catch:{ all -> 0x00fd }
            boolean r0 = com.bridgefy.sdk.framework.controller.C1928r.m8010a(r0)     // Catch:{ all -> 0x00fd }
            if (r0 == 0) goto L_0x001f
            java.lang.String r12 = "Bluetooth_LE_Discovery"
            java.lang.String r13 = "Device is blacklisted, won't connect"
            android.util.Log.d(r12, r13)     // Catch:{ all -> 0x00fd }
            monitor-exit(r11)
            return r1
        L_0x001f:
            java.util.concurrent.ConcurrentSkipListMap<java.lang.String, com.bridgefy.sdk.framework.controller.Session> r0 = com.bridgefy.sdk.framework.controller.SessionManager.f5869a     // Catch:{ all -> 0x00fd }
            java.lang.String r2 = r14.getAddress()     // Catch:{ all -> 0x00fd }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x00fd }
            if (r0 == 0) goto L_0x002d
            monitor-exit(r11)
            return r1
        L_0x002d:
            com.bridgefy.sdk.client.Bridgefy r0 = com.bridgefy.sdk.client.Bridgefy.getInstance()     // Catch:{ all -> 0x00fd }
            com.bridgefy.sdk.client.BridgefyClient r0 = r0.getBridgefyClient()     // Catch:{ all -> 0x00fd }
            java.lang.String r0 = r0.getUserUuid()     // Catch:{ all -> 0x00fd }
            long r3 = com.bridgefy.sdk.framework.utils.Utils.getCrcFromKey(r0)     // Catch:{ all -> 0x00fd }
            java.util.concurrent.ConcurrentSkipListMap<java.lang.String, com.bridgefy.sdk.framework.controller.Session> r0 = com.bridgefy.sdk.framework.controller.SessionManager.f5869a     // Catch:{ all -> 0x00fd }
            java.util.Collection r0 = r0.values()     // Catch:{ all -> 0x00fd }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00fd }
            r2 = 0
            r8 = 0
        L_0x0049:
            boolean r5 = r0.hasNext()     // Catch:{ all -> 0x00fd }
            r9 = 1
            if (r5 == 0) goto L_0x0092
            java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x00fd }
            com.bridgefy.sdk.framework.controller.Session r5 = (com.bridgefy.sdk.framework.controller.Session) r5     // Catch:{ all -> 0x00fd }
            long r6 = r5.getCrc()     // Catch:{ all -> 0x00fd }
            int r6 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r6 != 0) goto L_0x0060
        L_0x005e:
            r7 = 1
            goto L_0x0093
        L_0x0060:
            android.bluetooth.BluetoothGatt r6 = r5.mo7501e()     // Catch:{ all -> 0x00fd }
            if (r6 == 0) goto L_0x007f
            android.bluetooth.BluetoothGatt r6 = r5.mo7501e()     // Catch:{ all -> 0x00fd }
            android.bluetooth.BluetoothDevice r6 = r6.getDevice()     // Catch:{ all -> 0x00fd }
            if (r6 == 0) goto L_0x007f
            android.bluetooth.BluetoothGatt r6 = r5.mo7501e()     // Catch:{ all -> 0x00fd }
            android.bluetooth.BluetoothDevice r6 = r6.getDevice()     // Catch:{ all -> 0x00fd }
            boolean r6 = r6.equals(r14)     // Catch:{ all -> 0x00fd }
            if (r6 == 0) goto L_0x007f
            goto L_0x005e
        L_0x007f:
            android.bluetooth.BluetoothGattServer r6 = r5.mo7502f()     // Catch:{ all -> 0x00fd }
            if (r6 == 0) goto L_0x0049
            long r5 = r5.getCrc()     // Catch:{ all -> 0x00fd }
            r9 = 0
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x0049
            int r8 = r8 + 1
            goto L_0x0049
        L_0x0092:
            r7 = 0
        L_0x0093:
            java.util.HashMap<java.lang.Long, android.bluetooth.BluetoothDevice> r0 = r11.f5984e     // Catch:{ all -> 0x00fd }
            java.lang.Long r5 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x00fd }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x00fd }
            if (r0 != 0) goto L_0x00ca
            java.lang.String r0 = "Bluetooth_LE_Discovery"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fd }
            r5.<init>()     // Catch:{ all -> 0x00fd }
            java.lang.String r6 = "processPresenceResult: mycrc "
            r5.append(r6)     // Catch:{ all -> 0x00fd }
            r5.append(r3)     // Catch:{ all -> 0x00fd }
            java.lang.String r6 = " > "
            r5.append(r6)     // Catch:{ all -> 0x00fd }
            r5.append(r12)     // Catch:{ all -> 0x00fd }
            java.lang.String r6 = " = "
            r5.append(r6)     // Catch:{ all -> 0x00fd }
            int r6 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r6 <= 0) goto L_0x00c0
            r2 = 1
        L_0x00c0:
            r5.append(r2)     // Catch:{ all -> 0x00fd }
            java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x00fd }
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00fd }
        L_0x00ca:
            r2 = r11
            r5 = r12
            boolean r0 = r2.m7969a(r3, r5, r7, r8)     // Catch:{ all -> 0x00fd }
            if (r0 == 0) goto L_0x00f2
            java.lang.String r0 = r14.getAddress()     // Catch:{ all -> 0x00fd }
            com.bridgefy.sdk.client.Device r0 = com.bridgefy.sdk.framework.controller.DeviceManager.getDevice(r0)     // Catch:{ all -> 0x00fd }
            if (r0 != 0) goto L_0x00f0
            com.bridgefy.sdk.client.Device r0 = new com.bridgefy.sdk.client.Device     // Catch:{ all -> 0x00fd }
            r0.<init>(r14, r9)     // Catch:{ all -> 0x00fd }
            com.bridgefy.sdk.client.Config$Antenna r14 = com.bridgefy.sdk.client.Config.Antenna.BLUETOOTH_LE     // Catch:{ all -> 0x00fd }
            r0.setAntennaType(r14)     // Catch:{ all -> 0x00fd }
            java.lang.String r14 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x00fd }
            r0.setDeviceName(r14)     // Catch:{ all -> 0x00fd }
            r0.setCrc(r12)     // Catch:{ all -> 0x00fd }
        L_0x00f0:
            monitor-exit(r11)
            return r0
        L_0x00f2:
            monitor-exit(r11)
            return r1
        L_0x00f4:
            java.lang.String r12 = "Bluetooth_LE_Discovery"
            java.lang.String r13 = "processPresenceResult: could not process Bluetooth device"
            android.util.Log.e(r12, r13)     // Catch:{ all -> 0x00fd }
            monitor-exit(r11)
            return r1
        L_0x00fd:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bridgefy.sdk.framework.controller.C1918k.mo7534a(long, android.bluetooth.BluetoothDevice):com.bridgefy.sdk.client.Device");
    }

    /* renamed from: a */
    private boolean m7969a(long j, long j2, boolean z, int i) {
        if (!z && j2 > -1) {
            if ((C1911h.f5955a < 3 || j > j2) || (i >= DeviceProfile.getMaxServerConnections())) {
                return true;
            }
        }
        return false;
    }
}
