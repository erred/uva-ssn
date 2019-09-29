package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import java.util.UUID;

/* renamed from: com.bridgefy.sdk.framework.controller.v */
class C1935v extends gatt_operation {

    /* renamed from: a */
    private final UUID f6012a;

    /* renamed from: b */
    private final UUID f6013b;

    /* renamed from: a */
    public boolean mo7425a() {
        return true;
    }

    C1935v(BluetoothDevice bluetoothDevice, UUID uuid, UUID uuid2) {
        super(bluetoothDevice);
        this.f6012a = uuid;
        this.f6013b = uuid2;
    }

    /* renamed from: a */
    public void read_bluetooth_gatt_descriptor(BluetoothGatt bluetoothGatt) {
        bluetoothGatt.readCharacteristic(bluetoothGatt.getService(this.f6012a).getCharacteristic(this.f6013b));
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (r4.getValue().length <= 0) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        r1.mo7503g().add(com.bridgefy.sdk.framework.controller.chunk_utils.m8002a(r4.getValue()));
        r4 = com.bridgefy.sdk.framework.controller.chunk_utils.get_bluetooth_characteristics(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        switch(r4) {
            case 1: goto L_0x0099;
            case 2: goto L_0x0045;
            case 3: goto L_0x0099;
            case 4: goto L_0x0099;
            default: goto L_0x0042;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        r5 = "GATT__READ_char";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r1.mo7378a(com.bridgefy.sdk.framework.controller.chunk_utils.stitch_chunks_to_entity(r1.mo7503g(), true, com.bridgefy.sdk.client.Bridgefy.getInstance().getConfig().isEncryption()));
        r1.mo7503g().clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r4 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        r1.mo7495a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006d, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0070, code lost:
        r5 = "GATT__READ_char";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0 = new java.lang.StringBuilder();
        r0.append("onRead: warning reading entity failed ");
        r0.append(r4.getMessage());
        android.util.Log.e(r5, r0.toString(), r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r4 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0090, code lost:
        r1.mo7495a(new java.util.ArrayList<>());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0098, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0099, code lost:
        com.bridgefy.sdk.framework.controller.C1911h.get_gatt_manager().mo7414a((com.bridgefy.sdk.framework.controller.gatt_operation) new com.bridgefy.sdk.framework.controller.C1935v(r5.getDevice(), com.bridgefy.sdk.framework.controller.C1922m.m7989b(), com.bridgefy.sdk.framework.controller.C1922m.m7991c()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b2, code lost:
        r0 = new java.lang.StringBuilder();
        r0.append("call: default read case something went wrong in here ");
        r0.append(r4);
        android.util.Log.e(r5, r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c7, code lost:
        android.util.Log.e("GATT__READ_char", "call: read characteristic with empty value, this should not happen!");
        r1.mo7495a(new java.util.ArrayList<>());
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7568a(android.bluetooth.BluetoothGattCharacteristic r4, android.bluetooth.BluetoothGatt r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.ArrayList r0 = com.bridgefy.sdk.framework.controller.SessionManager.getSessions()     // Catch:{ all -> 0x00d8 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00d8 }
        L_0x0009:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00d8 }
            if (r1 == 0) goto L_0x00d6
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00d8 }
            com.bridgefy.sdk.framework.controller.Session r1 = (com.bridgefy.sdk.framework.controller.Session) r1     // Catch:{ all -> 0x00d8 }
            android.bluetooth.BluetoothGatt r2 = r1.get_bluetooth_gatt()     // Catch:{ all -> 0x00d8 }
            if (r2 == 0) goto L_0x0009
            android.bluetooth.BluetoothGatt r2 = r1.get_bluetooth_gatt()     // Catch:{ all -> 0x00d8 }
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x00d8 }
            if (r2 == 0) goto L_0x0009
            byte[] r0 = r4.getValue()     // Catch:{ all -> 0x00d8 }
            int r0 = r0.length     // Catch:{ all -> 0x00d8 }
            if (r0 <= 0) goto L_0x00c7
            byte[] r0 = r4.getValue()     // Catch:{ all -> 0x00d8 }
            byte[] r0 = com.bridgefy.sdk.framework.controller.chunk_utils.m8002a(r0)     // Catch:{ all -> 0x00d8 }
            java.util.ArrayList r2 = r1.mo7503g()     // Catch:{ all -> 0x00d8 }
            r2.add(r0)     // Catch:{ all -> 0x00d8 }
            int r4 = com.bridgefy.sdk.framework.controller.chunk_utils.get_bluetooth_characteristics(r4)     // Catch:{ all -> 0x00d8 }
            switch(r4) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0045;
                case 3: goto L_0x0099;
                case 4: goto L_0x0099;
                default: goto L_0x0042;
            }     // Catch:{ all -> 0x00d8 }
        L_0x0042:
            java.lang.String r5 = "GATT__READ_char"
            goto L_0x00b2
        L_0x0045:
            java.util.ArrayList r4 = r1.mo7503g()     // Catch:{ Exception -> 0x006f }
            r5 = 1
            com.bridgefy.sdk.client.Bridgefy r0 = com.bridgefy.sdk.client.Bridgefy.getInstance()     // Catch:{ Exception -> 0x006f }
            com.bridgefy.sdk.client.Config r0 = r0.getConfig()     // Catch:{ Exception -> 0x006f }
            boolean r0 = r0.isEncryption()     // Catch:{ Exception -> 0x006f }
            com.bridgefy.sdk.framework.entities.BleEntity r4 = com.bridgefy.sdk.framework.controller.chunk_utils.stitch_chunks_to_entity(r4, r5, r0)     // Catch:{ Exception -> 0x006f }
            r1.mo7378a(r4)     // Catch:{ Exception -> 0x006f }
            java.util.ArrayList r4 = r1.mo7503g()     // Catch:{ Exception -> 0x006f }
            r4.clear()     // Catch:{ Exception -> 0x006f }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00d8 }
            r4.<init>()     // Catch:{ all -> 0x00d8 }
        L_0x0069:
            r1.mo7495a(r4)     // Catch:{ all -> 0x00d8 }
            goto L_0x00d6
        L_0x006d:
            r4 = move-exception
            goto L_0x0090
        L_0x006f:
            r4 = move-exception
            java.lang.String r5 = "GATT__READ_char"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r0.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r2 = "onRead: warning reading entity failed "
            r0.append(r2)     // Catch:{ all -> 0x006d }
            java.lang.String r2 = r4.getMessage()     // Catch:{ all -> 0x006d }
            r0.append(r2)     // Catch:{ all -> 0x006d }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x006d }
            android.util.Log.e(r5, r0, r4)     // Catch:{ all -> 0x006d }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00d8 }
            r4.<init>()     // Catch:{ all -> 0x00d8 }
            goto L_0x0069
        L_0x0090:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x00d8 }
            r5.<init>()     // Catch:{ all -> 0x00d8 }
            r1.mo7495a(r5)     // Catch:{ all -> 0x00d8 }
            throw r4     // Catch:{ all -> 0x00d8 }
        L_0x0099:
            com.bridgefy.sdk.framework.controller.v r4 = new com.bridgefy.sdk.framework.controller.v     // Catch:{ all -> 0x00d8 }
            android.bluetooth.BluetoothDevice r5 = r5.getDevice()     // Catch:{ all -> 0x00d8 }
            java.util.UUID r0 = com.bridgefy.sdk.framework.controller.C1922m.m7989b()     // Catch:{ all -> 0x00d8 }
            java.util.UUID r1 = com.bridgefy.sdk.framework.controller.C1922m.m7991c()     // Catch:{ all -> 0x00d8 }
            r4.<init>(r5, r0, r1)     // Catch:{ all -> 0x00d8 }
            com.bridgefy.sdk.framework.controller.aa r5 = com.bridgefy.sdk.framework.controller.C1911h.get_gatt_manager()     // Catch:{ all -> 0x00d8 }
            r5.mo7414a(r4)     // Catch:{ all -> 0x00d8 }
            goto L_0x00d6
        L_0x00b2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r0.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r1 = "call: default read case something went wrong in here "
            r0.append(r1)     // Catch:{ all -> 0x00d8 }
            r0.append(r4)     // Catch:{ all -> 0x00d8 }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x00d8 }
            android.util.Log.e(r5, r4)     // Catch:{ all -> 0x00d8 }
            goto L_0x00d6
        L_0x00c7:
            java.lang.String r4 = "GATT__READ_char"
            java.lang.String r5 = "call: read characteristic with empty value, this should not happen!"
            android.util.Log.e(r4, r5)     // Catch:{ all -> 0x00d8 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00d8 }
            r4.<init>()     // Catch:{ all -> 0x00d8 }
            r1.mo7495a(r4)     // Catch:{ all -> 0x00d8 }
        L_0x00d6:
            monitor-exit(r3)     // Catch:{ all -> 0x00d8 }
            return
        L_0x00d8:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00d8 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bridgefy.sdk.framework.controller.C1935v.mo7568a(android.bluetooth.BluetoothGattCharacteristic, android.bluetooth.BluetoothGatt):void");
    }
}
