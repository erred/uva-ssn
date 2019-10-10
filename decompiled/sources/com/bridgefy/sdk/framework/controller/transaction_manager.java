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
    private static ConcurrentSkipListMap<Session, ConcurrentNavigableMap<chunk_generator, Boolean>> sessions_to_chunk_queues = new ConcurrentSkipListMap<>();

    /* renamed from: c */
    private static ConcurrentNavigableMap<chunk_generator, Boolean> queue_ble = new ConcurrentSkipListMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static ConcurrentNavigableMap<chunk_generator, Boolean> queue_bluetooth = new ConcurrentSkipListMap();

    /* renamed from: e */
    private static boolean f5924e = false;

    /* renamed from: f */
    private static transaction_manager transaction_manager = new transaction_manager();

    private transaction_manager() {
    }

    /* renamed from: a */
    static void send_entity(Session session, BleEntity bleEntity) {
        synchronized (session) {
            chunk_generator alVar = new chunk_generator(session, bleEntity, transaction_manager);
            if (session.getAntennaType() != Antenna.BLUETOOTH_LE) {
                queue_bluetooth.put(alVar, Boolean.TRUE);
                send_message_in_background();
            } else if (session.is_gatt_server()) {
                if (get_or_add_sessions_to_chunk_queues(session).containsKey(alVar)) {
                    Log.e(f5920a, "sendEntity: transaction was queued");
                } else {
                    get_or_add_sessions_to_chunk_queues(session).put(alVar, Boolean.TRUE);
                }
                m7861b(session);
            } else {
                queue_ble.put(alVar, Boolean.TRUE);
                send_entity_ble();
            }
        }
    }

    /* renamed from: a */
    static chunk_generator match_bluetooth_device(BluetoothDevice bluetoothDevice) {
        for (ConcurrentNavigableMap keySet : sessions_to_chunk_queues.values()) {
            Iterator it = keySet.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    chunk_generator alVar = (chunk_generator) it.next();
                    if (alVar.get_bluetooth_device().equals(bluetoothDevice)) {
                        return alVar;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    static void remove_duplicate_in_queues(Session session) {
        ConcurrentNavigableMap concurrentNavigableMap = (ConcurrentNavigableMap) sessions_to_chunk_queues.remove(session);
        ArrayList arrayList = new ArrayList();
        for (chunk_generator alVar : queue_ble.keySet()) {
            if (alVar.get_session().equals(session)) {
                arrayList.add(alVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            queue_ble.remove((chunk_generator) it.next());
        }
        for (chunk_generator alVar2 : queue_bluetooth.keySet()) {
            if (alVar2.get_session().equals(session)) {
                queue_bluetooth.remove(alVar2);
            }
        }
        arrayList.clear();
    }

    /* renamed from: c */
    private synchronized boolean remove_chunk_from_sessions_queue(chunk_generator alVar) {
        get_or_add_sessions_to_chunk_queues(alVar.get_session()).remove(alVar);
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
            boolean r1 = r4.is_gatt_server()     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x001b
            java.util.concurrent.ConcurrentSkipListMap<com.bridgefy.sdk.framework.controller.Session, java.util.concurrent.ConcurrentNavigableMap<com.bridgefy.sdk.framework.controller.al, java.lang.Boolean>> r1 = sessions_to_chunk_queues     // Catch:{ all -> 0x004c }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x004c }
            java.util.concurrent.ConcurrentNavigableMap r1 = (java.util.concurrent.ConcurrentNavigableMap) r1     // Catch:{ all -> 0x004c }
            int r1 = r1.size()     // Catch:{ all -> 0x004c }
            if (r1 <= 0) goto L_0x001b
            change_bluetooth_characteristics_m7864c(r4)     // Catch:{ all -> 0x004c }
            goto L_0x004a
        L_0x001b:
            java.util.concurrent.ConcurrentSkipListMap<com.bridgefy.sdk.framework.controller.Session, java.util.concurrent.ConcurrentNavigableMap<com.bridgefy.sdk.framework.controller.al, java.lang.Boolean>> r1 = sessions_to_chunk_queues     // Catch:{ all -> 0x004c }
            java.util.NavigableSet r1 = r1.keySet()     // Catch:{ all -> 0x004c }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x004c }
        L_0x0025:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x004a
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x004c }
            com.bridgefy.sdk.framework.controller.Session r2 = (com.bridgefy.sdk.framework.controller.Session) r2     // Catch:{ all -> 0x004c }
            boolean r3 = r2.equals(r4)     // Catch:{ all -> 0x004c }
            if (r3 != 0) goto L_0x0025
            java.util.concurrent.ConcurrentSkipListMap<com.bridgefy.sdk.framework.controller.Session, java.util.concurrent.ConcurrentNavigableMap<com.bridgefy.sdk.framework.controller.al, java.lang.Boolean>> r3 = sessions_to_chunk_queues     // Catch:{ all -> 0x004c }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x004c }
            java.util.concurrent.ConcurrentNavigableMap r3 = (java.util.concurrent.ConcurrentNavigableMap) r3     // Catch:{ all -> 0x004c }
            int r3 = r3.size()     // Catch:{ all -> 0x004c }
            if (r3 <= 0) goto L_0x0025
            change_bluetooth_characteristics_m7864c(r2)     // Catch:{ all -> 0x004c }
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
    private static void change_bluetooth_characteristics_m7864c(Session session) {
        try {
            BluetoothGattCharacteristic characteristic = session.get_bluetooth_gatt_server().getService(bluetooth_le_settings_builder.m7989b()).getCharacteristic(bluetooth_le_settings_builder.m7991c());
            characteristic.setValue(new byte[]{7});
            session.get_bluetooth_gatt_server().notifyCharacteristicChanged(session.getBluetoothDevice(), characteristic, false);
        } catch (NullPointerException unused) {
            SessionManager.m7757b(session.getSessionId());
        }
    }

    /* renamed from: c */
    private static void send_entity_ble() {
        chunk_generator alVar = (chunk_generator) queue_ble.pollFirstEntry().getKey();
        Session c = alVar.get_session();
        chunk_generator_with_queue acVar = new chunk_generator_with_queue(alVar);
        for (int i = 0; i < alVar.get_generated_chunk().size(); i++) {
            gatt_operation_characteristic_writer wVar = new gatt_operation_characteristic_writer(c.get_bluetooth_gatt().getDevice(), bluetooth_le_settings_builder.m7989b(), bluetooth_le_settings_builder.m7991c(), (byte[]) alVar.get_generated_chunk().get(i));
            wVar.set_chunk_generator(alVar);
            acVar.mo7434a(wVar);
        }
        bluetooth_controller.get_gatt_manager().mo7415a(acVar);
    }

    /* renamed from: d */
    private static void send_message_in_background() {
        new AsyncTask() {
            /* access modifiers changed from: protected */
            public synchronized Object doInBackground(Object[] objArr) {
                if (transaction_manager.queue_bluetooth.size() > 0) {
                    chunk_generator alVar = (chunk_generator) transaction_manager.queue_bluetooth.pollFirstEntry().getKey();
                    try {
                        alVar.get_session().mo7380b(alVar.get_ble_entity());
                        alVar.get_transaction_manager().send_message(alVar);
                    } catch (IOException e) {
                        e.printStackTrace();
                        alVar.get_transaction_manager().fail_send_message(alVar);
                    } catch (MessageException e2) {
                        e2.printStackTrace();
                        alVar.get_transaction_manager().fail_send_message(alVar);
                    } catch (InterruptedException e3) {
                        Log.e(transaction_manager.f5920a, "doInBackground: ", e3);
                        transaction_manager.queue_bluetooth.put(alVar, Boolean.TRUE);
                    }
                }
                return null;
            }
        }.execute(new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void send_message(chunk_generator alVar) {
        int et = alVar.get_ble_entity().getEt();
        if (et == 1) {
            for (Message message : get_ble_entity_content(alVar)) {
                if (Bridgefy.getInstance().getBridgefyCore().get_message_listener() != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            transaction_manager.on_message_sent(Message.this);
                        }
                    });
                }
            }
        } else if (et == 3) {
            ForwardTransaction g = get_forward_transaction(alVar);
            if (SessionManager.getSession(alVar.get_bluetooth_device().getAddress()) != null && g.getMesh() != null && g.getMesh().size() > 0) {
                forward_controller.m8027a(g.getMesh());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void on_message_sent(Message message) {
        Bridgefy.getInstance().getBridgefyCore().get_message_listener().onMessageSent(message.getUuid());
        Bridgefy.getInstance().getBridgefyCore().get_message_listener().onMessageSent(message);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void fail_send_message(chunk_generator alVar) {
        int et = alVar.get_ble_entity().getEt();
        if (et == 1) {
            for (Message message : get_ble_entity_content(alVar)) {
                if (Bridgefy.getInstance().getBridgefyCore().get_message_listener() != null) {
                    Bridgefy.getInstance().getBridgefyCore().get_message_listener().onMessageFailed(message, new MessageException("Send Message Failed."));
                }
            }
        } else if (et == 3) {
            ForwardTransaction g = get_forward_transaction(alVar);
            Session session = SessionManager.getSession(alVar.get_bluetooth_device().getAddress());
            if (session != null) {
                forward_controller.fail_match_sender_self(g.getMesh(), session);
            }
        }
    }

    /* renamed from: f */
    private List<Message> get_ble_entity_content(chunk_generator alVar) {
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
    private ForwardTransaction get_forward_transaction(chunk_generator alVar) {
        if (alVar.get_ble_entity().getEt() != 3) {
            return null;
        }
        return (ForwardTransaction) alVar.get_ble_entity().getCt();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void send_remove_queue(chunk_generator alVar) {
        alVar.get_session();
        send_message(alVar);
        remove_chunk_from_sessions_queue(alVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void failed_send_remove_queue(chunk_generator alVar) {
        alVar.get_session();
        fail_send_message(alVar);
        remove_chunk_from_sessions_queue(alVar);
    }

    /* renamed from: d */
    private static ConcurrentNavigableMap get_or_add_sessions_to_chunk_queues(Session session) {
        ConcurrentNavigableMap concurrentNavigableMap = (ConcurrentNavigableMap) sessions_to_chunk_queues.get(session);
        if (concurrentNavigableMap != null) {
            return concurrentNavigableMap;
        }
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();
        sessions_to_chunk_queues.put(session, concurrentSkipListMap);
        return concurrentSkipListMap;
    }
}
