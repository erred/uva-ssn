package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.util.Log;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Device;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SessionManager {

    /* renamed from: a */
    static ConcurrentSkipListMap<String, Session> sessions = new ConcurrentSkipListMap<>();

    /* renamed from: b */
    private static final int available_processors = Runtime.getRuntime().availableProcessors();

    /* renamed from: c */
    private static final int threads_in_use;

    /* renamed from: d */
    private static final ThreadPoolExecutor thread_pool_executor;

    static {
        int i = 3;
        if (available_processors + 1 > 3) {
            i = available_processors;
        }
        threads_in_use = i;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(threads_in_use, 9, 3, TimeUnit.SECONDS, new LinkedBlockingQueue());
        thread_pool_executor = threadPoolExecutor;
    }

    private SessionManager() {
    }

    /* renamed from: a */
    static void queue_session(Session session) {
        if (!sessions.containsKey(session.getSessionId())) {
            StringBuilder sb = new StringBuilder();
            sb.append("queueSession: ");
            sb.append(session.getSessionId());
            sb.append(" for the first time.");
            Log.w("SessionManager", sb.toString());
            session.set_is_connected(true);
            if (session.getAntennaType() != Antenna.BLUETOOTH_LE) {
                session.mo7390h();
            }
            sessions.put(session.getSessionId(), session);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.bridgefy.sdk.framework.controller.Session getSession(java.lang.String r5) {
        /*
            java.lang.Class<com.bridgefy.sdk.framework.controller.SessionManager> r0 = com.bridgefy.sdk.framework.controller.SessionManager.class
            monitor-enter(r0)
            if (r5 != 0) goto L_0x0008
            r5 = 0
            monitor-exit(r0)
            return r5
        L_0x0008:
            java.util.concurrent.ConcurrentSkipListMap<java.lang.String, com.bridgefy.sdk.framework.controller.Session> r1 = sessions     // Catch:{ all -> 0x0052 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0052 }
            com.bridgefy.sdk.framework.controller.Session r1 = (com.bridgefy.sdk.framework.controller.Session) r1     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x0014
            monitor-exit(r0)
            return r1
        L_0x0014:
            java.util.concurrent.ConcurrentSkipListMap<java.lang.String, com.bridgefy.sdk.framework.controller.Session> r2 = sessions     // Catch:{ all -> 0x0052 }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x0052 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0052 }
        L_0x001e:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0052 }
            if (r3 == 0) goto L_0x0050
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0052 }
            com.bridgefy.sdk.framework.controller.Session r3 = (com.bridgefy.sdk.framework.controller.Session) r3     // Catch:{ all -> 0x0052 }
            com.bridgefy.sdk.client.Device r4 = r3.getDevice()     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x001e
            java.lang.String r4 = r3.getUserId()     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x001e
            java.lang.String r4 = r3.getUserId()     // Catch:{ all -> 0x0052 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x0052 }
            if (r4 != 0) goto L_0x004e
            com.bridgefy.sdk.client.Device r4 = r3.getDevice()     // Catch:{ all -> 0x0052 }
            java.lang.String r4 = r4.getDeviceAddress()     // Catch:{ all -> 0x0052 }
            boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x001e
        L_0x004e:
            monitor-exit(r0)
            return r3
        L_0x0050:
            monitor-exit(r0)
            return r1
        L_0x0052:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bridgefy.sdk.framework.controller.SessionManager.getSession(java.lang.String):com.bridgefy.sdk.framework.controller.Session");
    }

    public static ArrayList<Session> getSessions() {
        return new ArrayList<>(sessions.values());
    }

    public static List<Session> getSessionsByType(Antenna antenna) {
        ArrayList arrayList = new ArrayList();
        for (Session session : sessions.values()) {
            if (antenna == session.getAntennaType()) {
                arrayList.add(session);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static void m7753a(Antenna antenna) {
        for (Session session : sessions.values()) {
            if (antenna == session.getAntennaType()) {
                session.disconnect();
            }
        }
    }

    /* renamed from: b */
    static void remove_session(Session session) {
        StringBuilder sb = new StringBuilder();
        sb.append("remove Session: id - ");
        sb.append(session.getSessionId());
        Log.w("SessionManager", sb.toString());
        transaction_manager.m7857a(session);
        C1897ah.m7830a(session);
        Device device = session.getDevice();
        if (session.getEmitter() != null) {
            Log.i("SessionManager", "removeQueueSession: dispatching onconnection result disconnected");
            if (!session.getEmitter().mo363b()) {
                session.getEmitter().mo364b(new Exception("Connection closed"));
            }
        }
        sessions.remove(session.getSessionId());
        DeviceManager.remove_device(device);
    }

    /* renamed from: a */
    static void get_session(String str) {
        C1897ah.m7831a(str, "Session Id can't be null.");
        Session session = getSession(str);
        if (session != null && session.mo7395l() != 1) {
            remove_session(session);
        }
    }

    /* renamed from: b */
    static synchronized void m7757b(String str) {
        synchronized (SessionManager.class) {
            Session session = (Session) sessions.get(str);
            if (session != null) {
                if (session.getAntennaType() == Antenna.BLUETOOTH_LE) {
                    if (session.get_bluetooth_gatt() != null) {
                        session.get_bluetooth_gatt().disconnect();
                        session.get_bluetooth_gatt().close();
                    }
                    try {
                        BluetoothGattServer bluetoothGattServer = (BluetoothGattServer) server_factory.get_server_instance(Antenna.BLUETOOTH_LE, true).mo7462e();
                        if (!(session.getBluetoothDevice() == null || bluetoothGattServer == null)) {
                            BluetoothGattCharacteristic characteristic = bluetoothGattServer.getService(C1922m.m7989b()).getCharacteristic(C1922m.m7991c());
                            characteristic.setValue(new byte[]{5});
                            try {
                                bluetoothGattServer.notifyCharacteristicChanged(session.getBluetoothDevice(), characteristic, false);
                            } catch (NullPointerException e) {
                                String str2 = "SessionManager";
                                StringBuilder sb = new StringBuilder();
                                sb.append("exception closing session, it might not be a mistake ");
                                sb.append(e.getMessage());
                                Log.e(str2, sb.toString());
                            }
                            bluetoothGattServer.cancelConnection(session.getBluetoothDevice());
                        }
                    } catch (NullPointerException unused) {
                        Log.w("SessionManager", "disconnectLeDevices: server objects disappeared ahead of time");
                    }
                }
                session.disconnect();
            }
        }
    }

    /* renamed from: a */
    static int m7752a(int i) {
        int i2 = 0;
        for (Session l : sessions.values()) {
            if (l.mo7395l() == i) {
                i2++;
            }
        }
        return i2;
    }
}
