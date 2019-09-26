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
import p000a.p013b.C0165c;
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
    private SharedPreferences f5847a;

    /* renamed from: b */
    private Editor f5848b;

    /* renamed from: c */
    private Context f5849c;

    /* renamed from: d */
    private Config f5850d;

    /* renamed from: e */
    private MessageListener f5851e;

    /* renamed from: f */
    private C1895af f5852f;

    /* renamed from: g */
    private broadcast_receiver f5853g;

    /* renamed from: h */
    private StateListener state_listener;

    /* renamed from: i */
    private C0159b f5855i = C0159b.m542a((C0184e) $$Lambda$BridgefyCore$XQDii8meLrMOm8WBhkh5XNaOGk.INSTANCE);

    public BridgefyCore(Context context, Config config) throws BridgefyException {
        this.f5849c = (Context) C1897ah.m7831a(context, "missing Context.");
        this.f5850d = (Config) C1897ah.m7831a(config, "missing Config.");
        this.f5847a = this.f5849c.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        this.f5848b = this.f5847a.edit();
        this.f5852f = new C1895af(context, config);
        this.f5853g = new broadcast_receiver(context, config);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public SharedPreferences get_shared_preferences() {
        return this.f5847a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Editor get_editor() {
        return this.f5848b;
    }

    /* renamed from: a */
    static void m7704a(Session session, BleEntity bleEntity) throws IOException, MessageException {
        C1903am.m7858a(session, bleEntity);
    }

    public void initializeServices() {
        this.f5853g.mo7400a(this.f5849c);
        this.f5853g.mo7401a(this.f5850d.getAntennaType());
        this.f5853g.mo7405d(this.f5850d.getAntennaType());
    }

    public void shutdownServices() {
        this.f5853g.mo7402b(this.f5849c);
        this.f5853g.mo7404c(this.f5850d.getAntennaType());
        this.f5853g.mo7406e(this.f5850d.getAntennaType());
        this.f5853g.mo7403b(this.f5850d.getAntennaType());
        connection_manager.m8011b();
        this.f5855i.mo341a((C0181e<? super C0330h<Throwable>, ? extends C3682b<?>>) new C1898ai<Object,Object>(3, 500)).mo342a(C0153a.m534a()).mo347b(C0331a.m925b()).mo340a((C0177a) new C0177a() {
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
    public static /* synthetic */ void m7703a(C0165c cVar) throws Exception {
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
            this.f5853g.mo7406e(this.f5850d.getAntennaType());
            this.f5853g.mo7407f(this.f5850d.getAntennaType());
            return true;
        }
        Log.e("BridgefyCore", "pauseServices: Cannot go to paused state with active connections");
        return false;
    }

    public void resumeServices() {
        this.f5853g.mo7405d(this.f5850d.getAntennaType());
        this.f5853g.mo7408g(this.f5850d.getAntennaType());
    }

    public void sendDirectMessage(Message message, Device device) {
        this.f5852f.send_direct_message(this.f5849c, message, device);
    }

    public void sendMessage(Message message, String str, BFEngineProfile bFEngineProfile) {
        this.f5852f.send_message(this.f5849c, message, DeviceManager.m7712a(str), bFEngineProfile);
    }

    public void sendBroadcastMessage(Message message, BFEngineProfile bFEngineProfile) {
        if (bFEngineProfile == null) {
            bFEngineProfile = BFEngineProfile.BFConfigProfileDefault;
        }
        this.f5852f.send_broadcast(message, bFEngineProfile);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public MessageListener get_message_listener() {
        return this.f5851e;
    }

    public void setMessageListener(MessageListener messageListener) {
        this.f5851e = messageListener;
    }

    public Context getContext() {
        return this.f5849c;
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
    public C1895af mo7366e() {
        return this.f5852f;
    }

    public void changeEnergyProfile(Antenna antenna) {
        this.f5853g.mo7409h(antenna);
    }
}
