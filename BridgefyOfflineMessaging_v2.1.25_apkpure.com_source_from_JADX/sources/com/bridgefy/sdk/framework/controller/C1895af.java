package com.bridgefy.sdk.framework.controller;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bridgefy.sdk.client.BFEngineProfile;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.Config;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.CryptoRSA;
import com.bridgefy.sdk.client.Device;
import com.bridgefy.sdk.client.Message;
import com.bridgefy.sdk.client.MessageListener;
import com.bridgefy.sdk.client.Session;
import com.bridgefy.sdk.framework.controller.Analytics.EventType;
import com.bridgefy.sdk.framework.entities.BleEntity;
import com.bridgefy.sdk.framework.entities.ForwardPacket;
import com.bridgefy.sdk.framework.entities.ForwardTransaction;
import com.bridgefy.sdk.framework.exceptions.MessageException;
import com.bridgefy.sdk.framework.utils.Utils;
import com.bridgefy.sdk.logging.LogFactory;
import com.bridgefy.sdk.logging.Logger;
import com.bridgefy.sdk.logging.entities.MeshLog.MeshEvent;
import com.bridgefy.sdk.logging.entities.MessageLog.MessageEvent;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.bridgefy.sdk.framework.controller.af */
class C1895af {

    /* renamed from: b */
    private static boolean f5894b = false;

    /* renamed from: a */
    public final String f5895a = getClass().getSimpleName();

    /* renamed from: c */
    private Config f5896c;

    /* renamed from: d */
    private C1894ae f5897d;

    /* renamed from: e */
    private C1933u f5898e;

    C1895af(Context context, Config config) {
        this.f5896c = (Config) C1897ah.m7831a(config, "Missing Config.");
        this.f5897d = new C1894ae(config);
        this.f5898e = new C1933u();
        this.f5897d.mo7436a(context);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7448a(Message message, Session session) {
        message.setMesh(false);
        this.f5897d.mo7440a(message);
        Logger.log(LogFactory.build(message, (Session) session, MessageEvent.BFMessageTypeDirectMessageReceived));
        Analytics.m7693a(EventType.BFAnalyticsMessageTypeDirectReceived);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7450a(Session session, boolean z) {
        new Runnable(session, z) {
            private final /* synthetic */ Session f$1;
            private final /* synthetic */ boolean f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                C1895af.this.m7815b(this.f$1, this.f$2);
            }
        }.run();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m7815b(Session session, boolean z) {
        if (session != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(session);
            this.f5898e.mo7562a(arrayList, z);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7449a(Session session, BleEntity bleEntity) {
        List<ForwardPacket> mesh = ((ForwardTransaction) bleEntity.getCt()).getMesh();
        ArrayList a = C1905b.m7874a(bleEntity.getBinaryPart());
        if (mesh != null) {
            ArrayList arrayList = new ArrayList();
            for (ForwardPacket forwardPacket : mesh) {
                forwardPacket.decreaseRemainingHops();
                if (forwardPacket.getReceiver_type() == 0) {
                    String receiver = forwardPacket.getReceiver();
                    if (receiver == null || !receiver.trim().equalsIgnoreCase(Bridgefy.getInstance().getBridgefyClient().getUserUuid().trim())) {
                        Logger.log(LogFactory.build((Session) session, forwardPacket, MeshEvent.BFMeshTypePacketReceivedToForward));
                        ForwardPacket a2 = m7809a(forwardPacket, a);
                        if (a2 == null || a2.getHops() <= 0 || Bridgefy.getInstance().getBridgefyClient().getUserUuid().equalsIgnoreCase(a2.getSender())) {
                            String str = this.f5895a;
                            StringBuilder sb = new StringBuilder();
                            sb.append("onMeshMessageIncomingAction:  hops: ");
                            sb.append(forwardPacket.getHops());
                            sb.append(" discard message mesh ");
                            sb.append(forwardPacket.getId());
                            sb.append(" track: ");
                            sb.append(new Gson().toJson((Object) forwardPacket.getTrack()));
                            Log.e(str, sb.toString());
                        } else {
                            arrayList.add(a2);
                        }
                    } else {
                        try {
                            forwardPacket = m7812b(forwardPacket, a);
                        } catch (Exception e) {
                            this.f5897d.mo7442a(forwardPacket.getSender(), new MessageException("Can't be possible decrypt message.", e));
                        }
                        Logger.log(LogFactory.build((Session) session, forwardPacket, MeshEvent.BFMeshTypePacketReceivedReached));
                        Analytics.m7693a(EventType.BFAnalyticsMessageTypeMeshReceived);
                        Message b = m7811b(forwardPacket);
                        if (b == null || b.getContent() != null) {
                            this.f5897d.mo7440a(b);
                        } else {
                            this.f5897d.mo7442a(forwardPacket.getSender(), new MessageException("Unable to decrypt message."));
                        }
                        this.f5898e.mo7564b(forwardPacket);
                    }
                } else if (forwardPacket.getReceiver_type() == 1) {
                    Logger.log(LogFactory.build((Session) session, forwardPacket, MeshEvent.BFMeshTypePacketReceivedBroadcast));
                    Analytics.m7693a(EventType.BFAnalyticsMessageTypeBroadcastReceived);
                    Message b2 = m7811b(forwardPacket);
                    if (!this.f5898e.mo7563a(forwardPacket) && forwardPacket.getHops() >= 0 && !b2.getSenderId().trim().equalsIgnoreCase(Bridgefy.getInstance().getBridgefyClient().getUserUuid())) {
                        new Bundle().putParcelable("parcelable.forwardPacket", forwardPacket);
                        mo7451a(forwardPacket);
                        if (Bridgefy.getInstance().getBridgefyCore().mo7363c() != null) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    Bridgefy.getInstance().getBridgefyCore().mo7363c().onBroadcastMessageReceived(Message.this);
                                }
                            });
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                this.f5898e.mo7561a(arrayList, session);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7451a(ForwardPacket forwardPacket) {
        if (!this.f5898e.mo7563a(forwardPacket)) {
            forwardPacket.setAdded(new Date(System.currentTimeMillis()));
            this.f5898e.mo7560a(forwardPacket, true);
        }
    }

    /* renamed from: b */
    private Message m7811b(ForwardPacket forwardPacket) {
        Message message = new Message(forwardPacket.getPayload(), forwardPacket.getReceiver(), forwardPacket.getSender(), true, forwardPacket.getHopsLimitForEngineProfile() - forwardPacket.getHops());
        message.setDateSent(forwardPacket.getCreation());
        if (forwardPacket.getId() != null && forwardPacket.getId().trim().length() > 0) {
            message.setUuid(forwardPacket.getId());
        }
        return message;
    }

    /* renamed from: a */
    private ForwardPacket m7809a(ForwardPacket forwardPacket, ArrayList<byte[]> arrayList) {
        if (forwardPacket.getEnc_payload() >= 0 && arrayList != null && !arrayList.isEmpty()) {
            forwardPacket.setForwardedPayload((byte[]) arrayList.get(forwardPacket.getEnc_payload()));
            forwardPacket.setEnc_payload(-1);
        }
        return forwardPacket;
    }

    /* renamed from: b */
    private ForwardPacket m7812b(ForwardPacket forwardPacket, ArrayList<byte[]> arrayList) throws Exception {
        if (forwardPacket.getEnc_payload() >= 0) {
            byte[] bArr = (byte[]) arrayList.get(forwardPacket.getEnc_payload());
            new String(bArr, "ISO-8859-1");
            forwardPacket.setPayload((HashMap) Utils.fromMessagePacktoEntity(C1927q.m8005d(CryptoRSA.decrypt(Bridgefy.getInstance().getBridgefyClient().getSecretKey(), bArr)), HashMap.class));
            forwardPacket.setEnc_payload(-1);
        }
        return forwardPacket;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7452a(String str) {
        this.f5898e.mo7565b(str);
    }

    /* renamed from: c */
    private void m7816c(ForwardPacket forwardPacket) {
        Logger.log(LogFactory.build(forwardPacket));
        Analytics.m7693a(EventType.BFAnalyticsMessageTypeMeshSent);
        this.f5898e.mo7560a(forwardPacket, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7446a(Context context, Message message, Device device, BFEngineProfile bFEngineProfile) {
        if (mo7443a().isEncryption() && !Session.m7735j().containsKey(message.getReceiverId())) {
            MessageListener c = Bridgefy.getInstance().getBridgefyCore().mo7363c();
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to send message, missing public key for receiver: ");
            sb.append(message.getReceiverId());
            c.onMessageFailed(message, new MessageException(sb.toString()));
        }
        if (device != null) {
            mo7445a(context, message, device);
        } else if (bFEngineProfile != BFEngineProfile.BFConfigProfileNoFowarding) {
            m7816c(new ForwardPacket(message, 0, bFEngineProfile));
            if (DeviceManager.m7713a().isEmpty()) {
                this.f5897d.mo7441a(message, new MessageException("No nearby devices, message will be queued for later."));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7447a(Message message, BFEngineProfile bFEngineProfile) {
        m7814b(message, bFEngineProfile);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7445a(Context context, Message message, Device device) {
        m7813b(context, message, device);
    }

    /* renamed from: b */
    private void m7813b(Context context, Message message, Device device) {
        Session session;
        mo7444a(context);
        if (device.getAntennaType() == Antenna.BLUETOOTH || device.getAntennaType() == Antenna.BLUETOOTH_LE) {
            session = SessionManager.getSession(device.getDeviceAddress());
        } else {
            session = SessionManager.getSession(device.getSessionId());
        }
        if (session == null) {
            session = SessionManager.getSession(message.getReceiverId());
        }
        if (session != null) {
            try {
                BridgefyCore.m7704a(session, BleEntity.message(message));
                Logger.log(LogFactory.build(message, (Session) session, MessageEvent.BFMessageTypeDirectMessageSent));
                Analytics.m7693a(EventType.BFAnalyticsMessageTypeDirectSent);
            } catch (IOException e) {
                Logger.log(LogFactory.build(message, new MessageException((Exception) e)));
                session.mo7391i();
                this.f5897d.mo7441a(message, new MessageException((Exception) e));
            } catch (MessageException e2) {
                Logger.log(LogFactory.build(message, new MessageException((Exception) e2)));
                this.f5897d.mo7441a(message, new MessageException((Exception) e2));
            }
            return;
        }
        if (device != null) {
            device.setSessionId(null);
        }
    }

    /* renamed from: b */
    private void m7814b(Message message, BFEngineProfile bFEngineProfile) {
        this.f5898e.mo7560a(new ForwardPacket(message, 1, bFEngineProfile), true);
        Logger.log(LogFactory.build(message));
        Analytics.m7693a(EventType.BFAnalyticsMessageTypeBroadcastSent);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7444a(Context context) {
        this.f5897d.mo7436a(context);
    }

    /* renamed from: a */
    public Config mo7443a() {
        return this.f5896c;
    }
}
