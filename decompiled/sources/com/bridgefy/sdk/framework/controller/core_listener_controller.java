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
class core_listener_controller {

    /* renamed from: b */
    private static boolean f5894b = false;

    /* renamed from: a */
    public final String simple_name = getClass().getSimpleName();

    /* renamed from: c */
    private Config config;

    /* renamed from: d */
    private message_listener_controller message_listener_controller;

    /* renamed from: e */
    private forward_controller forward_controller;

    core_listener_controller(Context context, Config config) {
        this.config = (Config) abstract_config.null_or_except_msg(config, "Missing Config.");
        this.message_listener_controller = new message_listener_controller(config);
        this.forward_controller = new forward_controller();
        this.message_listener_controller.set_context(context);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void on_direct_message_received(Message message, Session session) {
        message.setMesh(false);
        this.message_listener_controller.wrap_on_message_received(message);
        // Logger.log(LogFactory.build(message, (Session) session, MessageEvent.BFMessageTypeDirectMessageReceived));
        // Analytics.m7693a(EventType.BFAnalyticsMessageTypeDirectReceived);
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
                core_listener_controller.this.m7815b(this.f$1, this.f$2);
            }
        }.run();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m7815b(Session session, boolean z) {
        if (session != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(session);
            this.forward_controller.execute_on_executor(arrayList, z);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void on_mesh_message_incoming_action(Session session, BleEntity bleEntity) {
        List<ForwardPacket> mesh = ((ForwardTransaction) bleEntity.getCt()).getMesh();
        ArrayList a = byte_arraylist_to_byte_arrayb.deserialize(bleEntity.getBinaryPart());
        if (mesh != null) {
            ArrayList arrayList = new ArrayList();
            for (ForwardPacket forwardPacket : mesh) {
                forwardPacket.decreaseRemainingHops();
                if (forwardPacket.getReceiver_type() == 0) {
                    String receiver = forwardPacket.getReceiver();
                    if (receiver == null || !receiver.trim().equalsIgnoreCase(Bridgefy.getInstance().getBridgefyClient().getUserUuid().trim())) {
                        // Logger.log(LogFactory.build((Session) session, forwardPacket, MeshEvent.BFMeshTypePacketReceivedToForward));
                        ForwardPacket a2 = m7809a(forwardPacket, a);
                        if (a2 == null || a2.getHops() <= 0 || Bridgefy.getInstance().getBridgefyClient().getUserUuid().equalsIgnoreCase(a2.getSender())) {
                            String str = this.simple_name;
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
                            forwardPacket = decrypt_forward_packet(forwardPacket, a);
                        } catch (Exception e) {
                            this.message_listener_controller.message_received_exception(forwardPacket.getSender(), new MessageException("Can't be possible decrypt message.", e));
                        }
                        // Logger.log(LogFactory.build((Session) session, forwardPacket, MeshEvent.BFMeshTypePacketReceivedReached));
                        // Analytics.m7693a(EventType.BFAnalyticsMessageTypeMeshReceived);
                        Message b = repack_message(forwardPacket);
                        if (b == null || b.getContent() != null) {
                            this.message_listener_controller.wrap_on_message_received(b);
                        } else {
                            this.message_listener_controller.message_received_exception(forwardPacket.getSender(), new MessageException("Unable to decrypt message."));
                        }
                        this.forward_controller.send_mesh_reach(forwardPacket);
                    }
                } else if (forwardPacket.getReceiver_type() == 1) {
                    // Logger.log(LogFactory.build((Session) session, forwardPacket, MeshEvent.BFMeshTypePacketReceivedBroadcast));
                    // Analytics.m7693a(EventType.BFAnalyticsMessageTypeBroadcastReceived);
                    Message b2 = repack_message(forwardPacket);
                    if (!this.forward_controller.seen_packet(forwardPacket) && forwardPacket.getHops() >= 0 && !b2.getSenderId().trim().equalsIgnoreCase(Bridgefy.getInstance().getBridgefyClient().getUserUuid())) {
                        new Bundle().putParcelable("parcelable.forwardPacket", forwardPacket);
                        mo7451a(forwardPacket);
                        if (Bridgefy.getInstance().getBridgefyCore().get_message_listener() != null) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    Bridgefy.getInstance().getBridgefyCore().get_message_listener().onBroadcastMessageReceived(Message.this);
                                }
                            });
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                this.forward_controller.receive_list_add_or_drop(arrayList, session);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7451a(ForwardPacket forwardPacket) {
        if (!this.forward_controller.seen_packet(forwardPacket)) {
            forwardPacket.setAdded(new Date(System.currentTimeMillis()));
            this.forward_controller.add_forward_packet_to_list(forwardPacket, true);
        }
    }

    /* renamed from: b */
    private Message repack_message(ForwardPacket forwardPacket) {
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
    private ForwardPacket decrypt_forward_packet(ForwardPacket forwardPacket, ArrayList<byte[]> arrayList) throws Exception {
        if (forwardPacket.getEnc_payload() >= 0) {
            byte[] bArr = (byte[]) arrayList.get(forwardPacket.getEnc_payload());
            new String(bArr, "ISO-8859-1");
            forwardPacket.setPayload((HashMap) Utils.fromMessagePacktoEntity(chunk_utils.setup_gzip_byte_stream(CryptoRSA.decrypt(Bridgefy.getInstance().getBridgefyClient().getSecretKey(), bArr)), HashMap.class));
            forwardPacket.setEnc_payload(-1);
        }
        return forwardPacket;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7452a(String str) {
        this.forward_controller.mo7565b(str);
    }

    /* renamed from: c */
    private void forward_to_list(ForwardPacket forwardPacket) {
        // Logger.log(LogFactory.build(forwardPacket));
        // Analytics.m7693a(EventType.BFAnalyticsMessageTypeMeshSent);
        this.forward_controller.add_forward_packet_to_list(forwardPacket, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    // send message
    public void send_message(Context context, Message message, Device device, BFEngineProfile bFEngineProfile) {
        if (get_config().isEncryption() && !Session.get_key_pairs().containsKey(message.getReceiverId())) {
            MessageListener c = Bridgefy.getInstance().getBridgefyCore().get_message_listener();
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to send message, missing public key for receiver: ");
            sb.append(message.getReceiverId());
            c.onMessageFailed(message, new MessageException(sb.toString()));
        }
        if (device != null) {
            send_direct_message(context, message, device);
        } else if (bFEngineProfile != BFEngineProfile.BFConfigProfileNoFowarding) {
            forward_to_list(new ForwardPacket(message, 0, bFEngineProfile));
            if (DeviceManager.get_devices().isEmpty()) {
                this.message_listener_controller.mo7441a(message, new MessageException("No nearby devices, message will be queued for later."));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    // broadcast message
    public void send_broadcast(Message message, BFEngineProfile bFEngineProfile) {
        send_broadcast_2(message, bFEngineProfile);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    // direct message
    public void send_direct_message(Context context, Message message, Device device) {
        send_direct_2(context, message, device);
    }

    /* renamed from: b */
    private void send_direct_2(Context context, Message message, Device device) {
        Session session;
        set_context(context);
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
                BridgefyCore.send_entity(session, BleEntity.message(message));
                // Logger.log(LogFactory.build(message, (Session) session, MessageEvent.BFMessageTypeDirectMessageSent));
                // Analytics.m7693a(EventType.BFAnalyticsMessageTypeDirectSent);
            } catch (IOException e) {
                // Logger.log(LogFactory.build(message, new MessageException((Exception) e)));
                session.disconnect();
                this.message_listener_controller.mo7441a(message, new MessageException((Exception) e));
            } catch (MessageException e2) {
                // Logger.log(LogFactory.build(message, new MessageException((Exception) e2)));
                this.message_listener_controller.mo7441a(message, new MessageException((Exception) e2));
            }
            return;
        }
        if (device != null) {
            device.setSessionId(null);
        }
    }

    /* renamed from: b */
    private void send_broadcast_2(Message message, BFEngineProfile bFEngineProfile) {
        this.forward_controller.add_forward_packet_to_list(new ForwardPacket(message, 1, bFEngineProfile), true);
        // Logger.log(LogFactory.build(message));
        // Analytics.m7693a(EventType.BFAnalyticsMessageTypeBroadcastSent);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void set_context(Context context) {
        this.message_listener_controller.set_context(context);
    }

    /* renamed from: a */
    public Config get_config() {
        return this.config;
    }
}
