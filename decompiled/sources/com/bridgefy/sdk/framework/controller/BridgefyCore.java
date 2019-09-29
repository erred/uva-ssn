package com.bridgefy.sdk.framework.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.bridgefy.sdk.client.BFEngineProfile;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.BridgefyException;
import com.bridgefy.sdk.client.Config;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Device;
import com.bridgefy.sdk.client.Message;
import com.bridgefy.sdk.client.MessageListener;
import com.bridgefy.sdk.client.StateListener;
import com.bridgefy.sdk.framework.entities.BleEntity;
import com.bridgefy.sdk.framework.exceptions.MessageException;
import java.io.IOException;
import org.p153a.C3682b;
import p000a.p013b.C0159b;
import p000a.p013b.emitter;
import p000a.p013b.C0184e;
import p000a.p013b.C0330h;
import p000a.p013b.p014a.p016b.C0153a;
import p000a.p013b.p019d.C0177a;
import p000a.p013b.p019d.C0180d;
import p000a.p013b.p019d.C0181e;
import p000a.p013b.p038h.C0331a;

public class BridgefyCore {
    public static final String PREFS_NAME = "com.bridgefy.sdk.client";
    public static final String PREFS_USER_UUID = "com.bridgefy.sdk.uuid";

    /* renamed from: a */
    private SharedPreferences shared_preferences;

    /* renamed from: b */
    private Editor editor;

    /* renamed from: c */
    private Context context;

    /* renamed from: d */
    private Config config;

    /* renamed from: e */
    private MessageListener message_listener;

    /* renamed from: f */
    private core_listener_controller core_listener_controller;

    /* renamed from: g */
    private broadcast_receiver broadcast_receiver;

    /* renamed from: h */
    private StateListener state_listener;

    /* renamed from: i */
    private C0159b f5855i = C0159b.m542a((C0184e) $$Lambda$BridgefyCore$XQDii8meLrMOm8WBhkh5XNaOGk.INSTANCE);

    public BridgefyCore(Context context, Config config) throws BridgefyException {
        this.context = (Context) abstract_config.null_or_except_msg(context, "missing Context.");
        this.config = (Config) abstract_config.null_or_except_msg(config, "missing Config.");
        this.shared_preferences = this.context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        this.editor = this.shared_preferences.edit();
        this.core_listener_controller = new core_listener_controller(context, config);
        this.broadcast_receiver = new broadcast_receiver(context, config);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public SharedPreferences get_shared_preferences() {
        return this.shared_preferences;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Editor get_editor() {
        return this.editor;
    }

    /* renamed from: a */
    static void send_entity(Session session, BleEntity bleEntity) throws IOException, MessageException {
        transaction_manager.send_entity(session, bleEntity);
    }

    public void initializeServices() {
        this.broadcast_receiver.mo7400a(this.context);
        this.broadcast_receiver.mo7401a(this.config.getAntennaType());
        this.broadcast_receiver.mo7405d(this.config.getAntennaType());
    }

    public void shutdownServices() {
        this.broadcast_receiver.mo7402b(this.context);
        this.broadcast_receiver.mo7404c(this.config.getAntennaType());
        this.broadcast_receiver.mo7406e(this.config.getAntennaType());
        this.broadcast_receiver.mo7403b(this.config.getAntennaType());
        connection_manager.m8011b();
        this.f5855i.mo341a((C0181e<? super C0330h<Throwable>, ? extends C3682b<?>>) new error_handler_C1898ai<Object,Object>(3, 500)).mo342a(C0153a.m534a()).mo347b(C0331a.m925b()).mo340a((C0177a) new C0177a() {
            public final void run() {
                BridgefyCore.this.m7706f();
            }
        }, (C0180d<? super Throwable>) $$Lambda$BridgefyCore$QaZ_AlMzS0bFiU6QAHcyfdeKtBs.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m7706f() throws Exception {
        if (get_state_listener() != null) {
            Log.w("BridgefyCore", "setting null bridgefy core: ");
            Bridgefy.getInstance().setBridgefyCore(null);
            get_state_listener().onStopped();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void accept(Throwable th) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("accept: error ");
        sb.append(th.getMessage());
        Log.e("BridgefyCore", sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void check_sessions_cleaned_up(emitter cVar) throws Exception {
        if (SessionManager.getSessions().isEmpty()) {
            Log.w("BridgefyCore", "sessions are cleaned up:");
            cVar.mo361a();
            return;
        }
        Log.i("BridgefyCore", "connections are still active: ");
        cVar.mo364b(new Exception("Connections are still active"));
    }

    public boolean pauseServices() {
        if (SessionManager.sessions.isEmpty()) {
            this.broadcast_receiver.mo7406e(this.config.getAntennaType());
            this.broadcast_receiver.mo7407f(this.config.getAntennaType());
            return true;
        }
        Log.e("BridgefyCore", "pauseServices: Cannot go to paused state with active connections");
        return false;
    }

    public void resumeServices() {
        this.broadcast_receiver.mo7405d(this.config.getAntennaType());
        this.broadcast_receiver.mo7408g(this.config.getAntennaType());
    }

    public void sendDirectMessage(Message message, Device device) {
        this.core_listener_controller.send_direct_message(this.context, message, device);
    }

    public void sendMessage(Message message, String str, BFEngineProfile bFEngineProfile) {
        this.core_listener_controller.send_message(this.context, message, DeviceManager.m7712a(str), bFEngineProfile);
    }

    public void sendBroadcastMessage(Message message, BFEngineProfile bFEngineProfile) {
        if (bFEngineProfile == null) {
            bFEngineProfile = BFEngineProfile.BFConfigProfileDefault;
        }
        this.core_listener_controller.send_broadcast(message, bFEngineProfile);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public MessageListener get_message_listener() {
        return this.message_listener;
    }

    public void setMessageListener(MessageListener messageListener) {
        this.message_listener = messageListener;
    }

    public Context getContext() {
        return this.context;
    }

    public void setStateListener(StateListener stateListener) {
        this.state_listener = stateListener;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public StateListener get_state_listener() {
        return this.state_listener;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public core_listener_controller get_core_listener_controller() {
        return this.core_listener_controller;
    }

    public void changeEnergyProfile(Antenna antenna) {
        this.broadcast_receiver.set_antenna(antenna);
    }
}
