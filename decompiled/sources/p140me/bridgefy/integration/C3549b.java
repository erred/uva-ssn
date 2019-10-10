package p140me.bridgefy.integration;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import androidx.p079f.p080a.C1049a;
import com.bridgefy.sdk.client.BFEngineProfile;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Message;
import com.bridgefy.sdk.client.Message.Builder;
import com.bridgefy.sdk.client.MessageListener;
import com.bridgefy.sdk.framework.entities.BleHandshake;
import com.bridgefy.sdk.framework.exceptions.MessageException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p140me.bridgefy.entities.AppHandShake;
import p140me.bridgefy.entities.AppRequestJson;
import p140me.bridgefy.entities.AppResponseJson;
import p140me.bridgefy.entities.BridgefyPeer;
import p140me.bridgefy.entities.transport.AppEntity;
import p140me.bridgefy.entities.transport.AppEntityBroadcast;
import p140me.bridgefy.entities.transport.AppEntityHandShake;
import p140me.bridgefy.entities.transport.AppEntityMessage;
import p140me.bridgefy.entities.transport.AppEntitySignal;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.main.C3608c;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.ormlite.entities.MessageDTO;
import p140me.bridgefy.p141a.C3457c;
import p140me.bridgefy.p141a.C3460d;
import p140me.bridgefy.service.BridgefyService;
import p140me.bridgefy.service.p144a.C3615a;
import p140me.bridgefy.service.p147d.C3620a;
import p140me.bridgefy.service.p147d.C3622b;
import p140me.bridgefy.storage.service.UploadService;
import p140me.bridgefy.utils.C3667g;

/* renamed from: me.bridgefy.integration.b */
/* compiled from: MessageCenter */
public class C3549b extends MessageListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f9292a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C3457c f9293b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C3460d f9294c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f9295d;

    /* renamed from: e */
    private String f9296e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public DatabaseHelper f9297f;

    /* renamed from: g */
    private C3551a f9298g = new C3551a();

    /* renamed from: me.bridgefy.integration.b$a */
    /* compiled from: MessageCenter */
    private class C3551a extends BroadcastReceiver {
        private C3551a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0077  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00a1  */
        /* JADX WARNING: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r7, android.content.Intent r8) {
            /*
                r6 = this;
                java.lang.String r7 = r8.getAction()
                int r0 = r7.hashCode()
                r1 = 672715421(0x2818d29d, float:8.4833645E-15)
                r2 = 2
                r3 = 0
                r4 = -1
                r5 = 1
                if (r0 == r1) goto L_0x0030
                r1 = 1178001221(0x4636df45, float:11703.817)
                if (r0 == r1) goto L_0x0026
                r1 = 1478749832(0x5823ee88, float:7.2097952E14)
                if (r0 == r1) goto L_0x001c
                goto L_0x003a
            L_0x001c:
                java.lang.String r0 = "chatMessageSendqueueBackground"
                boolean r7 = r7.equals(r0)
                if (r7 == 0) goto L_0x003a
                r7 = 0
                goto L_0x003b
            L_0x0026:
                java.lang.String r0 = "chatMessageBroadcastSendqueueBackground"
                boolean r7 = r7.equals(r0)
                if (r7 == 0) goto L_0x003a
                r7 = 1
                goto L_0x003b
            L_0x0030:
                java.lang.String r0 = "chatMessageBroadcastChangequeueBackground"
                boolean r7 = r7.equals(r0)
                if (r7 == 0) goto L_0x003a
                r7 = 2
                goto L_0x003b
            L_0x003a:
                r7 = -1
            L_0x003b:
                switch(r7) {
                    case 0: goto L_0x00a1;
                    case 1: goto L_0x0077;
                    case 2: goto L_0x0040;
                    default: goto L_0x003e;
                }
            L_0x003e:
                goto L_0x0181
            L_0x0040:
                java.lang.String r7 = "broadcastClosed"
                boolean r7 = r8.getBooleanExtra(r7, r3)
                me.bridgefy.entities.transport.AppEntityBroadcast r7 = p140me.bridgefy.entities.transport.AppEntityBroadcast.getAppEntityBroadcastChange(r7)
                me.bridgefy.service.a.a r8 = p140me.bridgefy.service.p144a.C3615a.m10678a()
                java.util.List r8 = r8.mo29652b()
                java.util.Iterator r8 = r8.iterator()
            L_0x0056:
                boolean r0 = r8.hasNext()
                if (r0 == 0) goto L_0x0181
                java.lang.Object r0 = r8.next()
                me.bridgefy.entities.BridgefyPeer r0 = (p140me.bridgefy.entities.BridgefyPeer) r0
                java.lang.String r0 = r0.getId()
                com.bridgefy.sdk.client.Device r0 = com.bridgefy.sdk.framework.controller.DeviceManager.getDeviceByUserId(r0)
                java.util.HashMap r1 = r7.toHashMap()     // Catch:{ Exception -> 0x0072 }
                r0.sendMessage(r1)     // Catch:{ Exception -> 0x0072 }
                goto L_0x0056
            L_0x0072:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0056
            L_0x0077:
                java.lang.String r7 = "bridgefyMessage"
                java.lang.String r7 = r8.getStringExtra(r7)     // Catch:{ Exception -> 0x009b }
                me.bridgefy.entities.Message r7 = p140me.bridgefy.entities.Message.create(r7)     // Catch:{ Exception -> 0x009b }
                me.bridgefy.entities.transport.AppEntityMessage r8 = new me.bridgefy.entities.transport.AppEntityMessage     // Catch:{ Exception -> 0x009b }
                r8.<init>(r7, r2)     // Catch:{ Exception -> 0x009b }
                boolean r7 = p140me.bridgefy.main.C3608c.m10650c()     // Catch:{ Exception -> 0x009b }
                r7 = r7 ^ r5
                r8.setKu(r7)     // Catch:{ Exception -> 0x009b }
                java.util.HashMap r7 = r8.toHashMap()     // Catch:{ Exception -> 0x009b }
                com.bridgefy.sdk.client.Message r7 = com.bridgefy.sdk.client.Bridgefy.createMessage(r7)     // Catch:{ Exception -> 0x009b }
                com.bridgefy.sdk.client.Bridgefy.sendBroadcastMessage(r7)     // Catch:{ Exception -> 0x009b }
                goto L_0x0181
            L_0x009b:
                r7 = move-exception
                r7.printStackTrace()
                goto L_0x0181
            L_0x00a1:
                android.os.Bundle r7 = r8.getExtras()
                java.lang.String r0 = "userId"
                r1 = 0
                java.lang.String r7 = r7.getString(r0, r1)
                if (r7 == 0) goto L_0x0181
                me.bridgefy.integration.b r0 = p140me.bridgefy.integration.C3549b.this
                me.bridgefy.a.d r0 = r0.f9294c
                java.util.ArrayList r0 = r0.mo28344c(r7)
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.lang.String r2 = "bridgefyMessage"
                java.lang.String r8 = r8.getStringExtra(r2)
                if (r8 == 0) goto L_0x00fe
                me.bridgefy.entities.Message r8 = p140me.bridgefy.entities.Message.create(r8)     // Catch:{ JsonSyntaxException -> 0x00f7 }
                java.lang.String r2 = r8.getMessageId()     // Catch:{ JsonSyntaxException -> 0x00f7 }
                java.lang.String r3 = java.lang.String.valueOf(r4)     // Catch:{ JsonSyntaxException -> 0x00f7 }
                boolean r2 = r2.equals(r3)     // Catch:{ JsonSyntaxException -> 0x00f7 }
                if (r2 == 0) goto L_0x00e9
                java.util.UUID r2 = java.util.UUID.randomUUID()     // Catch:{ JsonSyntaxException -> 0x00f7 }
                java.lang.String r2 = r2.toString()     // Catch:{ JsonSyntaxException -> 0x00f7 }
                r8.setMessageId(r2)     // Catch:{ JsonSyntaxException -> 0x00f7 }
                java.lang.String r2 = r8.getMessageId()     // Catch:{ JsonSyntaxException -> 0x00f7 }
                r8.setOfflineId(r2)     // Catch:{ JsonSyntaxException -> 0x00f7 }
            L_0x00e9:
                int r2 = r8.getType()     // Catch:{ JsonSyntaxException -> 0x00f7 }
                if (r2 != r5) goto L_0x00f3
                r1.add(r8)     // Catch:{ JsonSyntaxException -> 0x00f7 }
                goto L_0x00fe
            L_0x00f3:
                r0.add(r8)     // Catch:{ JsonSyntaxException -> 0x00f7 }
                goto L_0x00fe
            L_0x00f7:
                java.lang.String r8 = "MessageCenter"
                java.lang.String r2 = "Sending queue without any new message at the top."
                android.util.Log.w(r8, r2)
            L_0x00fe:
                java.util.Iterator r8 = r0.iterator()
            L_0x0102:
                boolean r2 = r8.hasNext()
                if (r2 == 0) goto L_0x0118
                java.lang.Object r2 = r8.next()
                me.bridgefy.entities.Message r2 = (p140me.bridgefy.entities.Message) r2
                int r3 = r2.getType()
                if (r3 != r5) goto L_0x0102
                r1.add(r2)
                goto L_0x0102
            L_0x0118:
                r0.remove(r1)
                int r8 = r1.size()
                if (r8 <= 0) goto L_0x0161
                me.bridgefy.service.a.a r8 = p140me.bridgefy.service.p144a.C3615a.m10678a()
                boolean r8 = r8.mo29651a(r7)
                if (r8 == 0) goto L_0x0146
                me.bridgefy.integration.b r8 = p140me.bridgefy.integration.C3549b.this
                android.content.Context r8 = r8.mo29428a()
                me.bridgefy.integration.b r2 = p140me.bridgefy.integration.C3549b.this
                me.bridgefy.ormlite.DatabaseHelper r2 = r2.f9297f
                me.bridgefy.service.d.b r8 = p140me.bridgefy.service.p147d.C3622b.m10715a(r8, r2)
                boolean r8 = r8.mo29663b()
                if (r8 != 0) goto L_0x0146
                me.bridgefy.integration.b r8 = p140me.bridgefy.integration.C3549b.this
                r8.m10414a(r1)
            L_0x0146:
                me.bridgefy.integration.b r8 = p140me.bridgefy.integration.C3549b.this
                android.content.Context r8 = r8.mo29428a()
                me.bridgefy.integration.b r2 = p140me.bridgefy.integration.C3549b.this
                me.bridgefy.ormlite.DatabaseHelper r2 = r2.f9297f
                me.bridgefy.service.d.b r8 = p140me.bridgefy.service.p147d.C3622b.m10715a(r8, r2)
                boolean r8 = r8.mo29663b()
                if (r8 == 0) goto L_0x0161
                me.bridgefy.integration.b r8 = p140me.bridgefy.integration.C3549b.this
                r8.m10415a(r1, r7)
            L_0x0161:
                int r8 = r0.size()
                if (r8 <= 0) goto L_0x0181
                me.bridgefy.service.a.a r8 = p140me.bridgefy.service.p144a.C3615a.m10678a()
                boolean r8 = r8.mo29651a(r7)
                if (r8 == 0) goto L_0x0177
                me.bridgefy.integration.b r7 = p140me.bridgefy.integration.C3549b.this
                r7.m10414a(r0)
                goto L_0x0181
            L_0x0177:
                me.bridgefy.integration.b r8 = p140me.bridgefy.integration.C3549b.this
                r8.m10414a(r0)
                me.bridgefy.integration.b r8 = p140me.bridgefy.integration.C3549b.this
                r8.m10415a(r0, r7)
            L_0x0181:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p140me.bridgefy.integration.C3549b.C3551a.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    public C3549b(Context context, DatabaseHelper databaseHelper) {
        StringBuilder sb = new StringBuilder();
        sb.append("Creating new MessageCenter#");
        sb.append(hashCode());
        Log.i("MessageCenter", sb.toString());
        this.f9292a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("BgfyPrefs", 0);
        this.f9293b = new C3457c(databaseHelper);
        this.f9294c = new C3460d(databaseHelper);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("chatMessageSendqueueBackground");
        intentFilter.addAction("chatMessageBroadcastSendqueueBackground");
        intentFilter.addAction("chatMessageBroadcastChangequeueBackground");
        C1049a.m3996a(context).mo4059a(this.f9298g, intentFilter);
        this.f9295d = sharedPreferences.getString("user_uuid", "");
        this.f9296e = sharedPreferences.getString(FriendDTO.USER_NAME, "");
        this.f9297f = databaseHelper;
    }

    public void onMessageReceived(Message message) {
        String json = new Gson().toJson((Object) message.getContent());
        AppEntity appEntity = (AppEntity) new Gson().fromJson(json, AppEntity.class);
        if (appEntity != null) {
            switch (appEntity.getEntityType()) {
                case 0:
                    m10416a(m10411a(((AppEntityHandShake) new Gson().fromJson(json, AppEntityHandShake.class)).getHandShake(), message.getSenderId()), message);
                    return;
                case 1:
                    AppEntityMessage appEntityMessage = (AppEntityMessage) new Gson().fromJson(json, AppEntityMessage.class);
                    appEntityMessage.setMessageId(message.getUuid());
                    m10419a(appEntityMessage, message);
                    return;
                case 3:
                    AppEntityBroadcast appEntityBroadcast = (AppEntityBroadcast) new Gson().fromJson(json, AppEntityBroadcast.class);
                    appEntityBroadcast.setMessageId(message.getUuid());
                    m10418a(appEntityBroadcast);
                    return;
                case 4:
                    m10420a((AppEntitySignal) new Gson().fromJson(json, AppEntitySignal.class));
                    return;
                default:
                    return;
            }
        } else {
            Log.e("MessageCenter", "onMessageReceived: this should not happen!!!");
        }
    }

    /* renamed from: a */
    private void m10416a(AppHandShake appHandShake, Message message) {
        if (appHandShake == null) {
            return;
        }
        if (appHandShake.getRequestJson() != null || appHandShake.getResponseJson() != null) {
            AppEntityHandShake appEntityHandShake = new AppEntityHandShake(appHandShake);
            Builder builder = new Builder();
            builder.setReceiverId(message.getSenderId()).setContent(appEntityHandShake.toHashMap());
            Bridgefy.sendMessage(builder.build());
        }
    }

    /* renamed from: a */
    private void m10419a(final AppEntityMessage appEntityMessage, final Message message) {
        try {
            new Thread() {
                public void run() {
                    String senderId = message.getSenderId();
                    if (C3549b.this.f9293b.mo28329h(senderId)) {
                        HashMap hashMap = new AppEntitySignal(663, message.getUuid()).toHashMap();
                        Builder builder = new Builder();
                        builder.setReceiverId(senderId).setContent(hashMap);
                        Bridgefy.sendMessage(builder.build(), BFEngineProfile.BFConfigProfileNoFowarding);
                    } else {
                        if (BridgefyService.m10666e() == null || !BridgefyService.m10666e().equalsIgnoreCase(senderId)) {
                            HashMap hashMap2 = new AppEntitySignal(662, message.getUuid()).toHashMap();
                            Builder builder2 = new Builder();
                            builder2.setReceiverId(senderId).setContent(hashMap2);
                            if (Bridgefy.sendMessage(builder2.build(), BFEngineProfile.BFConfigProfileNoFowarding) == null) {
                                C3622b.m10715a(C3549b.this.mo29428a(), BridgefyService.get_database_helper()).mo29660a(senderId, -1);
                            }
                        }
                        FriendDTO c = C3549b.this.f9293b.query_friend_dto_by_id(senderId);
                        String a = C3549b.this.f9293b.mo28316a(c, senderId, null, null, C3549b.this.mo29428a());
                        p140me.bridgefy.entities.Message message = new p140me.bridgefy.entities.Message(message.getUuid(), appEntityMessage.getDateSent(), C3549b.this.f9295d, senderId, "", a, appEntityMessage.getMessageType());
                        message.setStatus(-1);
                        if (C3549b.this.f9294c.mo28341b(message.getMessageId()) == null && C3549b.this.f9294c.mo28334a(String.valueOf(appEntityMessage.getDateSent()), senderId) == null) {
                            try {
                                if (message.getType() != 1) {
                                    message.setText(new String(appEntityMessage.getCt()));
                                } else {
                                    message.setFileContent(message.getData());
                                    if (message.getFileName() == null) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(message.getDateSent());
                                        sb.append("-");
                                        sb.append(message.getOtherUserName());
                                        message.setFileName(sb.toString());
                                    }
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(message.getDateSent());
                                    sb2.append("_");
                                    sb2.append(message.getFileName());
                                    message.setFileName(sb2.toString());
                                    C3667g.m10941a(message, "Bridgefy");
                                }
                                C3549b.this.f9294c.mo28336a(c, message, null);
                                if (message.getConversation().trim().equalsIgnoreCase("broadcast.public")) {
                                    BridgefyApp.m10557c().mo29530g().mo27391c((Object) message);
                                }
                                Bundle a2 = C3620a.m10700a(C3549b.this.f9292a, message, a);
                                C1049a.m3996a(C3549b.this.mo29428a()).mo4060a(new Intent().setAction("chatMessage").putExtras(a2));
                                if (!message.getSender().equals(BridgefyService.m10666e())) {
                                    C3620a.m10702a().mo29656a(a2, a);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }.start();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m10418a(AppEntityBroadcast appEntityBroadcast) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAppBroadcastChange: implements actions ");
        sb.append(appEntityBroadcast);
        Log.d("MessageCenter", sb.toString());
    }

    /* renamed from: a */
    private void m10420a(AppEntitySignal appEntitySignal) {
        int signalType = appEntitySignal.getSignalType();
        if (signalType != 666) {
            switch (signalType) {
                case 662:
                    p140me.bridgefy.entities.Message b = this.f9294c.mo28341b(appEntitySignal.getMessageId());
                    if (b != null) {
                        b.setStatus(4);
                        this.f9294c.mo28337a(b);
                        m10417a(b);
                        return;
                    }
                    Log.w("MessageCenter", "Message to be ACK'd wasn't found. Maybe the user deleted it before we could confirm it.");
                    return;
                case 663:
                    p140me.bridgefy.entities.Message b2 = this.f9294c.mo28341b(appEntitySignal.getMessageId());
                    if (b2 != null) {
                        b2.setStatus(3);
                        this.f9294c.mo28337a(b2);
                        m10417a(b2);
                        return;
                    }
                    Log.w("MessageCenter", "Message to be ACK'd wasn't found. Maybe the user deleted it before we could confirm it.");
                    return;
                default:
                    return;
            }
        } else {
            Iterator it = ((ArrayList) this.f9294c.mo28332a(appEntitySignal.getMessageId().split(","))).iterator();
            while (it.hasNext()) {
                MessageDTO messageDTO = (MessageDTO) it.next();
                messageDTO.setStatus(5);
                this.f9294c.mo28338a(messageDTO);
                m10417a(new p140me.bridgefy.entities.Message(messageDTO));
            }
        }
    }

    public void onMessageFailed(Message message, MessageException messageException) {
        StringBuilder sb = new StringBuilder();
        sb.append("onMessageFailed: id: ");
        sb.append(message.getUuid());
        sb.append(", cause: ");
        sb.append(messageException.getMessage());
        Log.w("MessageCenter", sb.toString());
        new ScheduledThreadPoolExecutor(1).schedule(new Runnable(message) {
            private final /* synthetic */ Message f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                C3549b.this.m10412a(this.f$1);
            }
        }, C3622b.m10715a(mo29428a(), BridgefyService.get_database_helper()).mo29663b() ? 6000 : 500, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10412a(Message message) {
        p140me.bridgefy.entities.Message b = this.f9294c.mo28341b(message.getUuid());
        if (b != null) {
            b.setStatus(2);
            this.f9294c.mo28337a(b);
            m10417a(b);
        }
    }

    public void onMessageSent(Message message) {
        p140me.bridgefy.entities.Message b = this.f9294c.mo28341b(message.getUuid());
        if (b != null) {
            b.setStatus(3);
            this.f9294c.mo28337a(b);
            m10417a(b);
        }
    }

    public void onMessageDataProgress(UUID uuid, long j, long j2) {
        Intent intent = new Intent(UploadService.m10853b());
        intent.putExtra("id", uuid.toString());
        intent.putExtra(MessageDTO.STATUS, 1);
        intent.putExtra("progress", (int) ((j * 100) / j2));
        mo29428a().sendBroadcast(intent);
    }

    public void onMessageReceivedException(String str, MessageException messageException) {
        StringBuilder sb = new StringBuilder();
        sb.append("onMessageReceivedException: forwardPacket id ");
        sb.append(str);
        Log.e("MessageCenter", sb.toString());
    }

    public void onBroadcastMessageReceived(Message message) {
        Gson gson = new Gson();
        try {
            AppEntityMessage appEntityMessage = (AppEntityMessage) gson.fromJson(gson.toJson((Object) message.getContent()), AppEntityMessage.class);
            p140me.bridgefy.entities.Message message2 = new p140me.bridgefy.entities.Message(appEntityMessage.getMessageId() == null ? UUID.randomUUID().toString() : appEntityMessage.getMessageId(), message.getDateSent(), this.f9295d, message.getSenderId(), appEntityMessage.getCt(), appEntityMessage.getName(), appEntityMessage.getMessageType());
            if (this.f9294c.mo28341b(message2.getMessageId()) == null && !this.f9293b.mo28329h(message2.getSender())) {
                this.f9294c.mo28333a(mo29428a(), message2);
                BridgefyApp.m10557c().mo29530g().mo27391c((Object) message2);
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m10415a(ArrayList<p140me.bridgefy.entities.Message> arrayList, String str) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            p140me.bridgefy.entities.Message message = (p140me.bridgefy.entities.Message) it.next();
            message.setStatus(1);
            this.f9294c.mo28337a(message);
        }
        C3622b.m10715a(this.f9292a, this.f9297f).mo29661a(arrayList, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m10414a(ArrayList<p140me.bridgefy.entities.Message> arrayList) {
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                p140me.bridgefy.entities.Message message = (p140me.bridgefy.entities.Message) it.next();
                message.setStatus(1);
                AppEntityMessage appEntityMessage = new AppEntityMessage(message, 1);
                Builder builder = new Builder();
                builder.setReceiverId(message.getReceiver()).setContent(appEntityMessage.toHashMap());
                Message build = builder.build();
                build.setUuid(message.getOfflineId());
                if (message.getType() == 1) {
                    build.setData(C3667g.m10943a(message, false, mo29428a()));
                }
                if (message.getType() == 1 && build.getData() == null) {
                    message.setStatus(2);
                } else {
                    String sendMessage = Bridgefy.sendMessage(build);
                    message.setMessageId(sendMessage);
                    message.setOfflineId(sendMessage);
                }
                this.f9294c.mo28337a(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    /* renamed from: a */
    public static void m10417a(p140me.bridgefy.entities.Message message) {
        C1049a.m3996a((Context) BridgefyApp.m10557c()).mo4060a(new Intent("messageStatusUpdate").putExtra("bridgefyMessage", message.serialize()));
    }

    /* renamed from: a */
    private AppHandShake m10411a(AppHandShake appHandShake, String str) {
        AppResponseJson appResponseJson;
        AppRequestJson appRequestJson = null;
        if (!(appHandShake == null || appHandShake.getRequestJson() == null)) {
            switch (appHandShake.getRequestJson().getTp()) {
                case 0:
                    boolean z = !C3608c.m10650c();
                    appResponseJson = AppResponseJson.ResponseTypeGeneral(this.f9296e, z ? 1 : 0, Bridgefy.getInstance().getBridgefyClient().getUserUuid());
                    break;
                case 1:
                    if (!C3608c.m10650c()) {
                        appResponseJson = AppResponseJson.ResponseTypeTelephone(null, Bridgefy.getInstance().getBridgefyClient().getUserUuid());
                        appResponseJson.setDn(true);
                        break;
                    } else {
                        appResponseJson = AppResponseJson.ResponseTypeTelephone(C3608c.m10654g(), Bridgefy.getInstance().getBridgefyClient().getUserUuid());
                        appResponseJson.setDn(false);
                        break;
                    }
            }
        }
        appResponseJson = null;
        if (!(appHandShake == null || appHandShake.getResponseJson() == null)) {
            switch (appHandShake.getResponseJson().getTp()) {
                case 0:
                    if (appHandShake.getResponseJson().getUid() != null) {
                        FriendDTO c = this.f9293b.query_friend_dto_by_id(appHandShake.getResponseJson().getUid());
                        if (c == null) {
                            c = new FriendDTO(appHandShake.getResponseJson().getUid(), appHandShake.getResponseJson().getUn(), null);
                            this.f9293b.set_friend_dto(c);
                        }
                        if (c.getPhoneNumber() == null && appHandShake.getResponseJson().getVrf() != 1) {
                            appRequestJson = new AppRequestJson(1, BleHandshake.DEVICE_TYPE);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (!appHandShake.getResponseJson().isDn()) {
                        FriendDTO c2 = this.f9293b.query_friend_dto_by_id(str);
                        c2.setPhoneNumber(appHandShake.getResponseJson().getPh());
                        this.f9293b.set_friend_dto(c2);
                        break;
                    } else {
                        appResponseJson = AppResponseJson.ResponseTypeHandshakeFinished(str);
                        m10413a(str);
                        break;
                    }
                case 2:
                    if (this.f9293b.query_friend_dto_by_id(str) == null) {
                        appRequestJson = new AppRequestJson(0, BleHandshake.DEVICE_TYPE);
                        break;
                    } else {
                        m10413a(str);
                        return null;
                    }
            }
        }
        FriendDTO c3 = this.f9293b.query_friend_dto_by_id(str);
        if (appRequestJson == null && c3 == null) {
            appRequestJson = new AppRequestJson(0, BleHandshake.DEVICE_TYPE);
        } else if (!(c3 == null || ((c3.getPhoneNumber() != null && c3.getPhoneNumber().trim().length() != 0) || appHandShake == null || appHandShake.getResponseJson() == null || appHandShake.getResponseJson().getVrf() == 1 || appHandShake.getResponseJson().isDn()))) {
            appRequestJson = new AppRequestJson(1, BleHandshake.DEVICE_TYPE);
        }
        if (!(appHandShake == null || appHandShake.getRequestJson() != null || appRequestJson != null || appHandShake.getResponseJson() == null || appHandShake.getResponseJson().getTp() == 2)) {
            appResponseJson = AppResponseJson.ResponseTypeHandshakeFinished(str);
            m10413a(str);
        }
        if (appRequestJson == null && appResponseJson == null) {
            appResponseJson = AppResponseJson.ResponseTypeHandshakeFinished(str);
            m10413a(str);
        }
        return new AppHandShake(appRequestJson, appResponseJson);
    }

    /* renamed from: a */
    private void m10413a(String str) {
        FriendDTO c = this.f9293b.query_friend_dto_by_id(str);
        BridgefyPeer bridgefyPeer = c != null ? new BridgefyPeer(c) : null;
        if (bridgefyPeer != null) {
            C3615a.m10678a().mo29650a(bridgefyPeer, Antenna.BLUETOOTH_LE);
            C1049a.m3996a(mo29428a()).mo4060a(new Intent("deviceFound").putExtra("bridgefyDevice", bridgefyPeer).putExtra("peerConnectionType", Antenna.BLUETOOTH_LE));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("reportNearbyPeer: peer not found in DB ");
        sb.append(str);
        Log.w("MessageCenter", sb.toString());
    }

    /* renamed from: a */
    public Context mo29428a() {
        return this.f9292a;
    }

    /* renamed from: b */
    public void mo29430b() {
        Log.w("MessageCenter", "unregistering MessageCenter's Broadcast Receiver");
        C1049a.m3996a(this.f9292a).mo4058a((BroadcastReceiver) this.f9298g);
    }

    /* renamed from: a */
    public void mo29429a(DatabaseHelper databaseHelper) {
        StringBuilder sb = new StringBuilder();
        sb.append("Refreshing MessageCenter#");
        sb.append(hashCode());
        Log.d("MessageCenter", sb.toString());
        this.f9297f = databaseHelper;
        this.f9294c = new C3460d(databaseHelper);
        this.f9293b = new C3457c(databaseHelper);
    }
}
