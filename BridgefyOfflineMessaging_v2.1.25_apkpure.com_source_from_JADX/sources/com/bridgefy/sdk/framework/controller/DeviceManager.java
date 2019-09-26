package com.bridgefy.sdk.framework.controller;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Device;
import com.bridgefy.sdk.logging.LogFactory;
import com.bridgefy.sdk.logging.Logger;
import com.bridgefy.sdk.logging.entities.CommunicationLog.CommunicationEvent;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DeviceManager {

    /* renamed from: a */
    private static ConcurrentHashMap<String, Device> devices_map = new ConcurrentHashMap<>();

    /* renamed from: b */
    private static ConcurrentHashMap<String, ScheduledFuture> f5857b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private static ScheduledThreadPoolExecutor f5858c = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1);

    private DeviceManager() {
        try {
            f5858c.awaitTermination(200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    static void add_device_null_session(Device device) {
        add_device(device, (Session) null);
    }

    /* renamed from: a */
    static void add_device(Device device, Session session) {
        sync_device_ids(device, getDevice(device.getDeviceAddress()));
        if (devices_map.put(device.getDeviceAddress(), device) == null) {
            // Logger.log(LogFactory.build(device, String.valueOf(devices_map.size()), CommunicationEvent.BFCommunicationTypePeerDetected));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("... Adding device: ");
        sb.append(device.getDeviceAddress());
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(device.getAntennaType());
        sb.append(". DeviceList size: ");
        sb.append(devices_map.size());
        Log.v("DeviceManager", sb.toString());
        m7720b(device, session);
        m7721c(device);
    }

    /* renamed from: b */
    private static void m7720b(Device device, Session session) {
        new Handler(Looper.getMainLooper()).post(new Runnable(device) {
            private final /* synthetic */ Device f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DeviceManager.m7718a(Session.this, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m7718a(Session session, Device device) {
        if (Bridgefy.getInstance().getBridgefyCore() != null && session != null && Bridgefy.getInstance().getBridgefyCore().get_state_listener() != null) {
            Bridgefy.getInstance().getBridgefyCore().get_state_listener().onDeviceConnected(device, session);
        }
    }

    /* renamed from: a */
    private static void sync_device_ids(Device device, Device device2) {
        if (device2 != null) {
            if (device.getSessionId() != null) {
                device2.setSessionId(device.getSessionId());
            } else if (device2.getSessionId() != null) {
                device.setSessionId(device2.getSessionId());
            }
            if (device.getUserId() != null) {
                device2.setUserId(device.getUserId());
            } else if (device2.getUserId() != null) {
                device.setUserId(device2.getUserId());
            }
            if (device.getCrc() > 0) {
                device2.setCrc(device.getCrc());
            } else if (device2.getCrc() > 0) {
                device.setCrc(device2.getCrc());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f9  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void m7719b(com.bridgefy.sdk.client.Device r7) {
        /*
            java.lang.Class<com.bridgefy.sdk.framework.controller.DeviceManager> r0 = com.bridgefy.sdk.framework.controller.DeviceManager.class
            monitor-enter(r0)
            if (r7 == 0) goto L_0x010e
            java.lang.String r1 = r7.getDeviceAddress()     // Catch:{ all -> 0x010b }
            com.bridgefy.sdk.framework.controller.Session r1 = com.bridgefy.sdk.framework.controller.SessionManager.getSession(r1)     // Catch:{ all -> 0x010b }
            if (r1 == 0) goto L_0x0032
            int r1 = r1.mo7395l()     // Catch:{ all -> 0x010b }
            r2 = 1
            if (r1 != r2) goto L_0x0032
            java.lang.String r1 = "DeviceManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x010b }
            r2.<init>()     // Catch:{ all -> 0x010b }
            java.lang.String r3 = "removeDevice: won't remove device because it has a suspended connection: "
            r2.append(r3)     // Catch:{ all -> 0x010b }
            java.lang.String r7 = r7.getDeviceAddress()     // Catch:{ all -> 0x010b }
            r2.append(r7)     // Catch:{ all -> 0x010b }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x010b }
            android.util.Log.w(r1, r7)     // Catch:{ all -> 0x010b }
            goto L_0x010e
        L_0x0032:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bridgefy.sdk.client.Device> r1 = devices_map     // Catch:{ all -> 0x010b }
            java.lang.String r2 = r7.getDeviceAddress()     // Catch:{ all -> 0x010b }
            boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x010b }
            if (r1 == 0) goto L_0x010e
            m7722d(r7)     // Catch:{ all -> 0x010b }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bridgefy.sdk.client.Device> r1 = devices_map     // Catch:{ Exception -> 0x007b }
            java.lang.String r2 = r7.getDeviceAddress()     // Catch:{ Exception -> 0x007b }
            java.lang.Object r1 = r1.remove(r2)     // Catch:{ Exception -> 0x007b }
            com.bridgefy.sdk.client.Device r1 = (com.bridgefy.sdk.client.Device) r1     // Catch:{ Exception -> 0x007b }
            java.lang.String r7 = r1.getUserId()     // Catch:{ Exception -> 0x0079 }
            if (r7 == 0) goto L_0x0071
            java.lang.String r7 = "DeviceManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0079 }
            r2.<init>()     // Catch:{ Exception -> 0x0079 }
            java.lang.String r3 = "removeDevice: on device lost "
            r2.append(r3)     // Catch:{ Exception -> 0x0079 }
            java.lang.String r3 = r1.getUserId()     // Catch:{ Exception -> 0x0079 }
            r2.append(r3)     // Catch:{ Exception -> 0x0079 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0079 }
            android.util.Log.i(r7, r2)     // Catch:{ Exception -> 0x0079 }
            on_device_lost(r1)     // Catch:{ Exception -> 0x0079 }
            goto L_0x0099
        L_0x0071:
            java.lang.String r7 = "DeviceManager"
            java.lang.String r2 = "removeDevice: not calling on device lost becuase userid was null"
            android.util.Log.e(r7, r2)     // Catch:{ Exception -> 0x0079 }
            goto L_0x0099
        L_0x0079:
            r7 = move-exception
            goto L_0x007f
        L_0x007b:
            r1 = move-exception
            r6 = r1
            r1 = r7
            r7 = r6
        L_0x007f:
            java.lang.String r2 = "DeviceManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x010b }
            r3.<init>()     // Catch:{ all -> 0x010b }
            java.lang.String r4 = "removeDevice: device could be null "
            r3.append(r4)     // Catch:{ all -> 0x010b }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x010b }
            r3.append(r7)     // Catch:{ all -> 0x010b }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x010b }
            android.util.Log.e(r2, r7)     // Catch:{ all -> 0x010b }
        L_0x0099:
            java.lang.String r7 = "DeviceManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x010b }
            r2.<init>()     // Catch:{ all -> 0x010b }
            java.lang.String r3 = "Removing device: "
            r2.append(r3)     // Catch:{ all -> 0x010b }
            java.lang.String r3 = r1.getDeviceAddress()     // Catch:{ all -> 0x010b }
            r2.append(r3)     // Catch:{ all -> 0x010b }
            java.lang.String r3 = " ("
            r2.append(r3)     // Catch:{ all -> 0x010b }
            java.lang.String r3 = r1.getUserId()     // Catch:{ all -> 0x010b }
            r2.append(r3)     // Catch:{ all -> 0x010b }
            java.lang.String r3 = ") "
            r2.append(r3)     // Catch:{ all -> 0x010b }
            com.bridgefy.sdk.client.Config$Antenna r3 = r1.getAntennaType()     // Catch:{ all -> 0x010b }
            r2.append(r3)     // Catch:{ all -> 0x010b }
            java.lang.String r3 = ". DeviceList size: "
            r2.append(r3)     // Catch:{ all -> 0x010b }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bridgefy.sdk.client.Device> r3 = devices_map     // Catch:{ all -> 0x010b }
            int r3 = r3.size()     // Catch:{ all -> 0x010b }
            r2.append(r3)     // Catch:{ all -> 0x010b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x010b }
            android.util.Log.w(r7, r2)     // Catch:{ all -> 0x010b }
            long r2 = r1.getCrc()     // Catch:{ all -> 0x010b }
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 != 0) goto L_0x00f9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x010b }
            r7.<init>()     // Catch:{ all -> 0x010b }
            java.lang.String r2 = "crc generated with device address: "
            r7.append(r2)     // Catch:{ all -> 0x010b }
            java.lang.String r2 = r1.getDeviceAddress()     // Catch:{ all -> 0x010b }
            r7.append(r2)     // Catch:{ all -> 0x010b }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x010b }
            goto L_0x0101
        L_0x00f9:
            long r2 = r1.getCrc()     // Catch:{ all -> 0x010b }
            java.lang.String r7 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x010b }
        L_0x0101:
            com.bridgefy.sdk.logging.entities.CommunicationLog$CommunicationEvent r2 = com.bridgefy.sdk.logging.entities.CommunicationLog.CommunicationEvent.BFCommunicationTypePeerLost     // Catch:{ all -> 0x010b }
            com.bridgefy.sdk.logging.entities.LogEntity r7 = com.bridgefy.sdk.logging.LogFactory.build(r1, r7, r2)     // Catch:{ all -> 0x010b }
            com.bridgefy.sdk.logging.Logger.log(r7)     // Catch:{ all -> 0x010b }
            goto L_0x010e
        L_0x010b:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        L_0x010e:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bridgefy.sdk.framework.controller.DeviceManager.m7719b(com.bridgefy.sdk.client.Device):void");
    }

    /* renamed from: f */
    private static void on_device_lost(Device device) {
        Log.i("DeviceManager", "onDeviceLost: ");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                DeviceManager.on_device_lost_2(Device.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static /* synthetic */ void on_device_lost_2(Device device) {
        if (Bridgefy.getInstance().getBridgefyCore() != null && Bridgefy.getInstance().getBridgefyCore().get_state_listener() != null) {
            Log.i("DeviceManager", "onDeviceLost: ondevicelost");
            Bridgefy.getInstance().getBridgefyCore().get_state_listener().onDeviceLost(device);
        }
    }

    public static Device getDevice(String str) {
        Device device;
        synchronized (devices_map) {
            if (devices_map == null) {
                devices_map = new ConcurrentHashMap<>();
            }
            device = (Device) devices_map.get(str);
        }
        return device;
    }

    public static synchronized Device getDeviceByUserId(String str) {
        synchronized (DeviceManager.class) {
            for (Device device : devices_map.values()) {
                if (device.getUserId() != null && device.getUserId().trim().equalsIgnoreCase(str)) {
                    return device;
                }
            }
            return null;
        }
    }

    public static synchronized ArrayList<Device> getConnectedDevices() {
        ArrayList<Device> arrayList;
        synchronized (DeviceManager.class) {
            arrayList = new ArrayList<>();
            for (Device device : devices_map.values()) {
                if (device.getUserId() != null) {
                    arrayList.add(device);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static void m7714a(Antenna antenna) {
        for (Device device : devices_map.values()) {
            if (device.getAntennaType() == antenna) {
                m7719b(device);
            }
        }
    }

    /* renamed from: c */
    static synchronized void m7721c(Device device) {
        synchronized (DeviceManager.class) {
            f5857b.put(device.getDeviceAddress(), m7723e(device));
        }
    }

    /* renamed from: d */
    static synchronized void m7722d(Device device) {
        synchronized (DeviceManager.class) {
            ScheduledFuture scheduledFuture = (ScheduledFuture) f5857b.remove(device.getDeviceAddress());
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
        }
    }

    /* renamed from: e */
    static synchronized ScheduledFuture m7723e(Device device) {
        ScheduledFuture schedule;
        synchronized (DeviceManager.class) {
            m7722d(device);
            schedule = f5858c.schedule(new Runnable() {
                public final void run() {
                    DeviceManager.setup_long_timeout(Device.this);
                }
            }, Constants.KEEP_ALIVE_INTERVAL, TimeUnit.MILLISECONDS);
        }
        return schedule;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static /* synthetic */ void setup_long_timeout(Device device) {
        synchronized (device) {
            Session session = SessionManager.getSession(device.getSessionId());
            if (session == null) {
                session = SessionManager.getSession(device.getDeviceAddress());
            }
            if (device.getSessionId() == null && session == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("setupLongTimeout: remove device because device is unconnected. ");
                sb.append(device.getDeviceAddress());
                Log.i("DeviceManager", sb.toString());
                m7722d(device);
                m7719b(device);
            }
        }
    }

    /* renamed from: a */
    static List<Device> get_devices() {
        return new ArrayList(devices_map.values());
    }

    /* renamed from: a */
    static Device m7712a(String str) {
        for (Device device : get_devices()) {
            if (device.getUserId() != null && device.getUserId().equals(str)) {
                return device;
            }
        }
        return null;
    }
}
