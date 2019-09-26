package com.bridgefy.sdk.framework.controller;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Message;
import com.bridgefy.sdk.client.Message.Builder;
import com.bridgefy.sdk.framework.entities.BleEntity;
import com.bridgefy.sdk.framework.entities.BleEntityContent;
import com.bridgefy.sdk.framework.entities.ForwardTransaction;
import com.bridgefy.sdk.framework.exceptions.MessageException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* renamed from: com.bridgefy.sdk.framework.controller.am */
class transaction_manager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f5920a = "TransactionManager";

    /* renamed from: b */
    private static ConcurrentSkipListMap<Session, ConcurrentNavigableMap<C1902al, Boolean>> f5921b = new ConcurrentSkipListMap<>();

    /* renamed from: c */
    private static ConcurrentNavigableMap<C1902al, Boolean> f5922c = new ConcurrentSkipListMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static ConcurrentNavigableMap<C1902al, Boolean> f5923d = new ConcurrentSkipListMap();

    /* renamed from: e */
    private static boolean f5924e = false;

    /* renamed from: f */
    private static transaction_manager f5925f = new transaction_manager();

    private transaction_manager() {
    }

    /* renamed from: a */
    static void send_entity(Session session, BleEntity bleEntity) {
        synchronized (session) {
            C1902al alVar = new C1902al(session, bleEntity, f5925f);
            if (session.getAntennaType() != Antenna.BLUETOOTH_LE) {
                f5923d.put(alVar, Boolean.TRUE);
                m7867d();
            } else if (session.mo7396m()) {
                if (m7866d(session).containsKey(alVar)) {
                    Log.e(f5920a, "sendEntity: transaction was queued");
                } else {
                    m7866d(session).put(alVar, Boolean.TRUE);
                }
                m7861b(session);
            } else {
                f5922c.put(alVar, Boolean.TRUE);
                m7863c();
            }
        }
    }

    /* renamed from: a */
    static C1902al m7854a(BluetoothDevice bluetoothDevice) {
        for (ConcurrentNavigableMap keySet : f5921b.values()) {
            Iterator it = keySet.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    C1902al alVar = (C1902al) it.next();
                    if (alVar.get_bluetooth_device().equals(bluetoothDevice)) {
                        return alVar;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    static void m7857a(Session session) {
        ConcurrentNavigableMap concurrentNavigableMap = (ConcurrentNavigableMap) f5921b.remove(session);
        ArrayList arrayList = new ArrayList();
        for (C1902al alVar : f5922c.keySet()) {
            if (alVar.get_session().equals(session)) {
                arrayList.add(alVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f5922c.remove((C1902al) it.next());
        }
        for (C1902al alVar2 : f5923d.keySet()) {
            if (alVar2.get_session().equals(session)) {
                f5923d.remove(alVar2);
            }
        }
        arrayList.clear();
    }

    /* renamed from: c */
    private synchronized boolean m7865c(C1902al alVar) {
        m7866d(alVar.get_session()).remove(alVar);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void m7861b(com.bridgefy.sdk.framework.controller.Session r4) {
        /*
            java.lang.Class<com.bridgefy.sdk.framework.controller.am> r0 = com.bridgefy.sdk.framework.controller.transaction_manager.class
            monitor-enter(r0)
            boolean r1 = r4.mo7396m()     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x001b
            java.util.concurrent.ConcurrentSkipListMap<com.bridgefy.sdk.framework.controller.Session, java.util.concurrent.ConcurrentNavigableMap<com.bridgefy.sdk.framework.controller.al, java.lang.Boolean>> r1 = f5921b     // Catch:{ all -> 0x004c }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x004c }
            java.util.concurrent.ConcurrentNavigableMap r1 = (java.util.concurrent.ConcurrentNavigableMap) r1     // Catch:{ all -> 0x004c }
            int r1 = r1.size()     // Catch:{ all -> 0x004c }
            if (r1 <= 0) goto L_0x001b
            m7864c(r4)     // Catch:{ all -> 0x004c }
            goto L_0x004a
        L_0x001b:
            java.util.concurrent.ConcurrentSkipListMap<com.bridgefy.sdk.framework.controller.Session, java.util.concurrent.ConcurrentNavigableMap<com.bridgefy.sdk.framework.controller.al, java.lang.Boolean>> r1 = f5921b     // Catch:{ all -> 0x004c }
            java.util.NavigableSet r1 = r1.keySet()     // Catch:{ all -> 0x004c }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x004c }
        L_0x0025:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x004a
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x004c }
            com.bridgefy.sdk.framework.controller.Session r2 = (com.bridgefy.sdk.framework.controller.Session) r2     // Catch:{ all -> 0x004c }
            boolean r3 = r2.equals(r4)     // Catch:{ all -> 0x004c }
            if (r3 != 0) goto L_0x0025
            java.util.concurrent.ConcurrentSkipListMap<com.bridgefy.sdk.framework.controller.Session, java.util.concurrent.ConcurrentNavigableMap<com.bridgefy.sdk.framework.controller.al, java.lang.Boolean>> r3 = f5921b     // Catch:{ all -> 0x004c }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x004c }
            java.util.concurrent.ConcurrentNavigableMap r3 = (java.util.concurrent.ConcurrentNavigableMap) r3     // Catch:{ all -> 0x004c }
            int r3 = r3.size()     // Catch:{ all -> 0x004c }
            if (r3 <= 0) goto L_0x0025
            m7864c(r2)     // Catch:{ all -> 0x004c }
            monitor-exit(r0)
            return
        L_0x004a:
            monitor-exit(r0)
            return
        L_0x004c:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bridgefy.sdk.framework.controller.transaction_manager.m7861b(com.bridgefy.sdk.framework.controller.Session):void");
    }

    /* renamed from: c */
    private static void m7864c(Session session) {
        try {
            BluetoothGattCharacteristic characteristic = session.mo7502f().getService(C1922m.m7989b()).getCharacteristic(C1922m.m7991c());
            characteristic.setValue(new byte[]{7});
            session.mo7502f().notifyCharacteristicChanged(session.getBluetoothDevice(), characteristic, false);
        } catch (NullPointerException unused) {
            SessionManager.m7757b(session.getSessionId());
        }
    }

    /* renamed from: c */
    private static void m7863c() {
        C1902al alVar = (C1902al) f5922c.pollFirstEntry().getKey();
        Session c = alVar.get_session();
        C1892ac acVar = new C1892ac(alVar);
        for (int i = 0; i < alVar.mo7464a().size(); i++) {
            C1936w wVar = new C1936w(c.mo7501e().getDevice(), C1922m.m7989b(), C1922m.m7991c(), (byte[]) alVar.mo7464a().get(i));
            wVar.mo7569a(alVar);
            acVar.mo7434a(wVar);
        }
        C1911h.get_gatt_manager().mo7415a(acVar);
    }

    /* renamed from: d */
    private static void m7867d() {
        new AsyncTask() {
            /* access modifiers changed from: protected */
            public synchronized Object doInBackground(Object[] objArr) {
                if (transaction_manager.f5923d.size() > 0) {
                    C1902al alVar = (C1902al) transaction_manager.f5923d.pollFirstEntry().getKey();
                    try {
                        alVar.get_session().mo7380b(alVar.get_ble_entity());
                        alVar.mo7468d().m7868d(alVar);
                    } catch (IOException e) {
                        e.printStackTrace();
                        alVar.mo7468d().m7869e(alVar);
                    } catch (MessageException e2) {
                        e2.printStackTrace();
                        alVar.mo7468d().m7869e(alVar);
                    } catch (InterruptedException e3) {
                        Log.e(transaction_manager.f5920a, "doInBackground: ", e3);
                        transaction_manager.f5923d.put(alVar, Boolean.TRUE);
                    }
                }
                return null;
            }
        }.execute(new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m7868d(C1902al alVar) {
        int et = alVar.get_ble_entity().getEt();
        if (et == 1) {
            for (Message message : m7870f(alVar)) {
                if (Bridgefy.getInstance().getBridgefyCore().get_message_listener() != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            transaction_manager.m7856a(Message.this);
                        }
                    });
                }
            }
        } else if (et == 3) {
            ForwardTransaction g = m7871g(alVar);
            if (SessionManager.getSession(alVar.get_bluetooth_device().getAddress()) != null && g.getMesh() != null && g.getMesh().size() > 0) {
                forward_controller.m8027a(g.getMesh());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m7856a(Message message) {
        Bridgefy.getInstance().getBridgefyCore().get_message_listener().onMessageSent(message.getUuid());
        Bridgefy.getInstance().getBridgefyCore().get_message_listener().onMessageSent(message);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m7869e(C1902al alVar) {
        int et = alVar.get_ble_entity().getEt();
        if (et == 1) {
            for (Message message : m7870f(alVar)) {
                if (Bridgefy.getInstance().getBridgefyCore().get_message_listener() != null) {
                    Bridgefy.getInstance().getBridgefyCore().get_message_listener().onMessageFailed(message, new MessageException("Send Message Failed."));
                }
            }
        } else if (et == 3) {
            ForwardTransaction g = m7871g(alVar);
            Session session = SessionManager.getSession(alVar.get_bluetooth_device().getAddress());
            if (session != null) {
                forward_controller.m8028a(g.getMesh(), session);
            }
        }
    }

    /* renamed from: f */
    private List<Message> m7870f(C1902al alVar) {
        ArrayList arrayList = new ArrayList();
        if (alVar.get_ble_entity().getEt() == 1) {
            BleEntityContent bleEntityContent = (BleEntityContent) alVar.get_ble_entity().getCt();
            Builder builder = new Builder();
            builder.setContent(bleEntityContent.getPld());
            builder.setReceiverId(null);
            Message build = builder.build();
            build.setUuid(bleEntityContent.getId());
            arrayList.add(build);
        }
        return arrayList;
    }

    /* renamed from: g */
    private ForwardTransaction m7871g(C1902al alVar) {
        if (alVar.get_ble_entity().getEt() != 3) {
            return null;
        }
        return (ForwardTransaction) alVar.get_ble_entity().getCt();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7474a(C1902al alVar) {
        alVar.get_session();
        m7868d(alVar);
        m7865c(alVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7475b(C1902al alVar) {
        alVar.get_session();
        m7869e(alVar);
        m7865c(alVar);
    }

    /* renamed from: d */
    private static ConcurrentNavigableMap m7866d(Session session) {
        ConcurrentNavigableMap concurrentNavigableMap = (ConcurrentNavigableMap) f5921b.get(session);
        if (concurrentNavigableMap != null) {
            return concurrentNavigableMap;
        }
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();
        f5921b.put(session, concurrentSkipListMap);
        return concurrentSkipListMap;
    }
}
