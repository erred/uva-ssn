package com.bridgefy.sdk.framework.controller;

import android.os.AsyncTask;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Message;
import com.bridgefy.sdk.client.MessageListener;
import com.bridgefy.sdk.client.Session;
import com.bridgefy.sdk.framework.entities.BleEntity;
import com.bridgefy.sdk.framework.entities.ForwardPacket;
import com.bridgefy.sdk.framework.exceptions.MessageException;
import com.bridgefy.sdk.logging.Log;
import com.bridgefy.sdk.logging.LogFactory;
import com.bridgefy.sdk.logging.Logger;
import com.bridgefy.sdk.logging.entities.MeshLog.MeshErrorEvent;
import com.bridgefy.sdk.logging.entities.MeshLog.MeshEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* renamed from: com.bridgefy.sdk.framework.controller.u */
class forward_controller {

    /* renamed from: a */
    protected final String simple_name = getClass().getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ConcurrentNavigableMap<ForwardPacket, Boolean> current_map = new ConcurrentSkipListMap();

    /* renamed from: c */
    private ConcurrentNavigableMap<String, Boolean> expirec_map = new ConcurrentSkipListMap();

    /* renamed from: d */
    private final int f6009d = 80;

    /* renamed from: com.bridgefy.sdk.framework.controller.u$a */
    private class C1934a extends AsyncTask<Session, Void, Void> {

        /* renamed from: b */
        private boolean f6011b = false;

        C1934a(boolean z) {
            this.f6011b = z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Session... sessionArr) {
            if (forward_controller.this.current_map.size() > 0 || this.f6011b) {
                ArrayList<Session> arrayList = new ArrayList<>();
                for (Session session : sessionArr) {
                    if (!(session == null || session.getUserId() == null)) {
                        arrayList.add(session);
                    }
                }
                for (Session a : arrayList) {
                    send_pack_to_session(a);
                }
            }
            return null;
        }

        /* renamed from: a */
        private void send_pack_to_session(Session session) {
            List a = forward_controller.this.resolve_forward_current_map(String.valueOf(session.getCrc()));
            if (a.size() > 0 || this.f6011b) {
                BleEntity meshMessage = BleEntity.meshMessage(this.f6011b, (ArrayList) a, Bridgefy.getInstance().getBridgefyClient().getUserUuid());
                if (session.getAntennaType() != Antenna.BLUETOOTH_LE) {
                    try {
                        String str = forward_controller.this.simple_name;
                        StringBuilder sb = new StringBuilder();
                        sb.append("sendPackToSession: call writeValue ");
                        sb.append(this.f6011b);
                        sb.append(": ");
                        sb.append(meshMessage);
                        Log.m8078w(str, sb.toString());
                        transaction_manager.send_entity(session, meshMessage);
                    } catch (Exception e) {
                        e.printStackTrace();
                        forward_controller.un_resolve_forward_packets(a, String.valueOf(session.getCrc()));
                    }
                } else {
                    try {
                        BridgefyCore.send_entity(session, meshMessage);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        forward_controller.un_resolve_forward_packets(a, String.valueOf(session.getCrc()));
                    }
                }
                String str2 = forward_controller.this.simple_name;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("sendPackToSession [ ");
                sb2.append(session.getDevice().getDeviceName());
                sb2.append(" ] messages: ");
                sb2.append(a.size());
                sb2.append(" dump: ");
                sb2.append(this.f6011b);
                Log.m8073d(str2, sb2.toString());
                // Logger.log(LogFactory.build(a.size()));
            }
        }
    }

    forward_controller() {
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cc, code lost:
        if (r11 == false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ce, code lost:
        execute_on_executor(com.bridgefy.sdk.framework.controller.SessionManager.getSessions(), false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d6, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b0  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void add_forward_packet_to_list(com.bridgefy.sdk.framework.entities.ForwardPacket r10, boolean r11) {
        /*
            r9 = this;
            boolean r0 = r10.expired()
            if (r0 != 0) goto L_0x00da
            java.util.concurrent.ConcurrentNavigableMap<java.lang.String, java.lang.Boolean> r0 = r9.expirec_map
            java.lang.String r1 = r10.getId()
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x0014
            goto L_0x00da
        L_0x0014:
            java.util.concurrent.ConcurrentNavigableMap<com.bridgefy.sdk.framework.entities.ForwardPacket, java.lang.Boolean> r0 = r9.current_map
            monitor-enter(r0)
            com.bridgefy.sdk.framework.entities.ForwardPacket r1 = r9.get_in_current_map(r10)     // Catch:{ all -> 0x00d7 }
            if (r1 == 0) goto L_0x001f
            monitor-exit(r0)     // Catch:{ all -> 0x00d7 }
            return
        L_0x001f:
            r9.discard_expired_packets()     // Catch:{ all -> 0x00d7 }
            java.util.concurrent.ConcurrentNavigableMap<com.bridgefy.sdk.framework.entities.ForwardPacket, java.lang.Boolean> r1 = r9.current_map     // Catch:{ all -> 0x00d7 }
            int r1 = r1.size()     // Catch:{ all -> 0x00d7 }
            r2 = 80
            r3 = 0
            if (r1 >= r2) goto L_0x002e
            goto L_0x0099
        L_0x002e:
            java.util.concurrent.ConcurrentNavigableMap<com.bridgefy.sdk.framework.entities.ForwardPacket, java.lang.Boolean> r1 = r9.current_map     // Catch:{ all -> 0x00d7 }
            java.util.NavigableSet r1 = r1.descendingKeySet()     // Catch:{ all -> 0x00d7 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00d7 }
            r2 = r3
        L_0x0039:
            boolean r4 = r1.hasNext()     // Catch:{ all -> 0x00d7 }
            if (r4 == 0) goto L_0x006a
            java.lang.Object r4 = r1.next()     // Catch:{ all -> 0x00d7 }
            com.bridgefy.sdk.framework.entities.ForwardPacket r4 = (com.bridgefy.sdk.framework.entities.ForwardPacket) r4     // Catch:{ all -> 0x00d7 }
            if (r2 != 0) goto L_0x0048
            goto L_0x0068
        L_0x0048:
            java.util.Date r5 = r2.getAdded()     // Catch:{ all -> 0x00d7 }
            long r5 = r5.getTime()     // Catch:{ all -> 0x00d7 }
            java.util.Date r7 = r4.getAdded()     // Catch:{ all -> 0x00d7 }
            long r7 = r7.getTime()     // Catch:{ all -> 0x00d7 }
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0039
            int r5 = r4.getProfile()     // Catch:{ all -> 0x00d7 }
            com.bridgefy.sdk.client.BFEngineProfile r6 = com.bridgefy.sdk.client.BFEngineProfile.BFConfigProfileLongReach     // Catch:{ all -> 0x00d7 }
            int r6 = r6.ordinal()     // Catch:{ all -> 0x00d7 }
            if (r5 == r6) goto L_0x0039
        L_0x0068:
            r2 = r4
            goto L_0x0039
        L_0x006a:
            java.util.Date r1 = r2.getAdded()     // Catch:{ all -> 0x00d7 }
            long r4 = r1.getTime()     // Catch:{ all -> 0x00d7 }
            java.util.Date r1 = r10.getAdded()     // Catch:{ all -> 0x00d7 }
            long r6 = r1.getTime()     // Catch:{ all -> 0x00d7 }
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 >= 0) goto L_0x009a
            int r1 = r2.getPropagation()     // Catch:{ all -> 0x00d7 }
            if (r1 != 0) goto L_0x0094
            com.bridgefy.sdk.logging.entities.MeshLog$MeshErrorEvent r1 = com.bridgefy.sdk.logging.entities.MeshLog.MeshErrorEvent.BFErrorMeshTypeDiscardInvalidMessages     // Catch:{ all -> 0x00d7 }
            com.bridgefy.sdk.logging.entities.LogEntity r1 = com.bridgefy.sdk.logging.LogFactory.build(r2, r1)     // Catch:{ all -> 0x00d7 }
            com.bridgefy.sdk.logging.Logger.log(r1)     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = r9.simple_name     // Catch:{ all -> 0x00d7 }
            java.lang.String r3 = "addForwardPacketToList: notify meshDidNotForwardMeshIDs forward id"
            com.bridgefy.sdk.logging.Log.m8074e(r1, r3)     // Catch:{ all -> 0x00d7 }
        L_0x0094:
            java.util.concurrent.ConcurrentNavigableMap<com.bridgefy.sdk.framework.entities.ForwardPacket, java.lang.Boolean> r1 = r9.current_map     // Catch:{ all -> 0x00d7 }
            r1.remove(r2)     // Catch:{ all -> 0x00d7 }
        L_0x0099:
            r3 = r10
        L_0x009a:
            if (r3 == 0) goto L_0x00b0
            java.util.Date r10 = new java.util.Date     // Catch:{ all -> 0x00d7 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00d7 }
            r10.<init>(r1)     // Catch:{ all -> 0x00d7 }
            r3.setAdded(r10)     // Catch:{ all -> 0x00d7 }
            java.util.concurrent.ConcurrentNavigableMap<com.bridgefy.sdk.framework.entities.ForwardPacket, java.lang.Boolean> r10 = r9.current_map     // Catch:{ all -> 0x00d7 }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00d7 }
            r10.put(r3, r1)     // Catch:{ all -> 0x00d7 }
            goto L_0x00cb
        L_0x00b0:
            java.util.concurrent.ConcurrentNavigableMap<java.lang.String, java.lang.Boolean> r1 = r9.expirec_map     // Catch:{ all -> 0x00d7 }
            java.lang.String r2 = r10.getId()     // Catch:{ all -> 0x00d7 }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00d7 }
            r1.put(r2, r3)     // Catch:{ all -> 0x00d7 }
            com.bridgefy.sdk.logging.entities.MeshLog$MeshErrorEvent r1 = com.bridgefy.sdk.logging.entities.MeshLog.MeshErrorEvent.BFErrorMeshTypeDiscardInvalidMessages     // Catch:{ all -> 0x00d7 }
            com.bridgefy.sdk.logging.entities.LogEntity r10 = com.bridgefy.sdk.logging.LogFactory.build(r10, r1)     // Catch:{ all -> 0x00d7 }
            com.bridgefy.sdk.logging.Logger.log(r10)     // Catch:{ all -> 0x00d7 }
            java.lang.String r10 = r9.simple_name     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = "addForwardPacketToList: notify meshDidNotForwardMeshIDs"
            com.bridgefy.sdk.logging.Log.m8074e(r10, r1)     // Catch:{ all -> 0x00d7 }
        L_0x00cb:
            monitor-exit(r0)     // Catch:{ all -> 0x00d7 }
            if (r11 == 0) goto L_0x00d6
            java.util.ArrayList r10 = com.bridgefy.sdk.framework.controller.SessionManager.getSessions()
            r11 = 0
            r9.execute_on_executor(r10, r11)
        L_0x00d6:
            return
        L_0x00d7:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00d7 }
            throw r10
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bridgefy.sdk.framework.controller.forward_controller.add_forward_packet_to_list(com.bridgefy.sdk.framework.entities.ForwardPacket, boolean):void");
    }

    /* renamed from: a */
    private void discard_expired_packets() {
        synchronized (this.current_map) {
            ArrayList<ForwardPacket> arrayList = new ArrayList<>();
            for (ForwardPacket forwardPacket : this.current_map.descendingKeySet()) {
                if (forwardPacket.expired()) {
                    arrayList.add(forwardPacket);
                }
            }
            if (arrayList.size() > 0) {
                // Logger.log(LogFactory.build(arrayList));
                String str = this.simple_name;
                StringBuilder sb = new StringBuilder();
                sb.append("discardExpiredPackets: implements log for remove forwardPackets: ");
                sb.append(arrayList.size());
                Log.m8074e(str, sb.toString());
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (ForwardPacket forwardPacket2 : arrayList) {
                this.current_map.remove(forwardPacket2);
                // Logger.log(LogFactory.build(forwardPacket2, MeshErrorEvent.BFErrorMeshTypeDiscardInvalidMessages));
                arrayList2.add(forwardPacket2.getId());
            }
            for (String str2 : arrayList2) {
                this.expirec_map.put(str2, Boolean.TRUE);
                String str3 = this.simple_name;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("discardExpiredPackets: implements log for discard id ");
                sb2.append(str2);
                Log.m8074e(str3, sb2.toString());
            }
        }
    }

    /* renamed from: b */
    private void remove_and_expire(ForwardPacket forwardPacket, boolean z) {
        this.current_map.remove(forwardPacket);
        if (z) {
            this.expirec_map.put(forwardPacket.getId(), Boolean.TRUE);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public List<ForwardPacket> resolve_forward_current_map(String str) {
        ArrayList arrayList = new ArrayList();
        for (ForwardPacket add : this.current_map.descendingKeySet()) {
            arrayList.add(add);
        }
        return resolve_forward_packets((List<ForwardPacket>) arrayList, str);
    }

    /* renamed from: b */
    private List<ForwardPacket> resolve_forward_packets(List<ForwardPacket> list, String str) {
        ArrayList arrayList = new ArrayList();
        long longValue = Long.valueOf(str).longValue();
        for (ForwardPacket forwardPacket : list) {
            if (!forwardPacket.containsCRC(longValue)) {
                forwardPacket.addTrackingCRC(longValue);
                arrayList.add(forwardPacket);
                forwardPacket.setPropagation(forwardPacket.getPropagation() - 1);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static List<ForwardPacket> un_resolve_forward_packets(List<ForwardPacket> list, String str) {
        ArrayList arrayList = new ArrayList();
        long longValue = Long.valueOf(str).longValue();
        StringBuilder sb = new StringBuilder();
        sb.append("unResolveForwardPackets: for crc ");
        sb.append(str);
        sb.append(" messages: ");
        sb.append(list.size());
        Log.m8074e("ForwardController", sb.toString());
        for (ForwardPacket forwardPacket : list) {
            if (forwardPacket.containsCRC(longValue)) {
                forwardPacket.removeTracking(longValue);
                arrayList.add(forwardPacket);
                forwardPacket.setPropagation(forwardPacket.getPropagation() + 1);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ForwardPacket get_in_current_map_2(String str) {
        for (ForwardPacket forwardPacket : this.current_map.descendingKeySet()) {
            if (forwardPacket.getId().equalsIgnoreCase(str.trim())) {
                return forwardPacket;
            }
        }
        return null;
    }

    /* renamed from: c */
    private ForwardPacket get_in_current_map(ForwardPacket forwardPacket) {
        if (this.current_map.containsKey(forwardPacket)) {
            for (ForwardPacket forwardPacket2 : this.current_map.descendingKeySet()) {
                if (forwardPacket2.equals(forwardPacket)) {
                    return forwardPacket2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void execute_on_executor(ArrayList<Session> arrayList, boolean z) {
        new C1934a(z).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, arrayList.toArray(new Session[arrayList.size()]));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7565b(String str) {
        remove_and_expire(get_in_current_map_2(str), true);
    }

    /* renamed from: a */
    static void m8027a(List<ForwardPacket> list) {
        for (ForwardPacket forwardPacket : list) {
            if (Bridgefy.getInstance().getBridgefyClient().getUserUuid().equalsIgnoreCase(forwardPacket.getSender())) {
                Message message = new Message(forwardPacket.getPayload(), null, null);
                message.setUuid(forwardPacket.getId());
                Bridgefy.getInstance().getBridgefyCore().get_message_listener().onMessageSent(message.getUuid());
                Bridgefy.getInstance().getBridgefyCore().get_message_listener().onMessageSent(message);
            }
        }
    }

    /* renamed from: a */
    static void fail_match_sender_self(List<ForwardPacket> list, Session session) {
        un_resolve_forward_packets(list, String.valueOf(session.getCrc()));
        for (ForwardPacket forwardPacket : list) {
            if (Bridgefy.getInstance().getBridgefyClient().getUserUuid().equalsIgnoreCase(forwardPacket.getSender())) {
                Message message = new Message(forwardPacket.getPayload(), null, null);
                message.setUuid(forwardPacket.getId());
                MessageListener c = Bridgefy.getInstance().getBridgefyCore().get_message_listener();
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to acquire session: ");
                sb.append(session.getSessionId());
                c.onMessageFailed(message, new MessageException(sb.toString()));
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean seen_packet(ForwardPacket forwardPacket) {
        return this.expirec_map.containsKey(forwardPacket.getId()) || this.current_map.containsKey(forwardPacket);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void receive_list_add_or_drop(ArrayList<ForwardPacket> arrayList, Session session) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ForwardPacket forwardPacket = (ForwardPacket) it.next();
            forwardPacket.setAdded(new Date(System.currentTimeMillis()));
            receive_add_or_drop(forwardPacket, session);
        }
        execute_on_executor(SessionManager.getSessions(), false);
    }

    /* renamed from: a */
    private void receive_add_or_drop(ForwardPacket forwardPacket, Session session) {
        if (seen_packet(forwardPacket)) {
            // Logger.log(LogFactory.build((Session) session, forwardPacket, MeshEvent.BFMeshTypePacketReceivedDuplicated));
        } else {
            add_forward_packet_to_list(forwardPacket, false);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void send_mesh_reach(ForwardPacket forwardPacket) {
        BleEntity meshReach = BleEntity.meshReach(forwardPacket.getId());
        Iterator it = SessionManager.getSessions().iterator();
        while (it.hasNext()) {
            try {
                BridgefyCore.send_entity((Session) it.next(), meshReach);
            } catch (Exception e) {
                Log.m8075e(this.simple_name, "sendMeshReach: error sending mesh reach!!", e);
            }
        }
    }
}
