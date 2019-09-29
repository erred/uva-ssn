package p140me.bridgefy.utils;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.service.p147d.C3620a;

/* renamed from: me.bridgefy.utils.MyPushbulletExtension */
public class MyPushbulletExtension extends C3671i<DatabaseHelper> {

    /* renamed from: a */
    String f9654a;

    /* renamed from: b */
    String f9655b;

    public void onCreate() {
        super.onCreate();
        Log.d("PushBullet", "onCreate()");
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("BgfyPrefs", 0);
        this.f9654a = sharedPreferences.getString(FriendDTO.USER_NAME, "");
        this.f9655b = sharedPreferences.getString("user_uuid", "");
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7720a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Pushbullet MessagingExtension: onMessageReceived(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(")");
        Log.i("PushBullet", sb.toString());
        Message message = new Message(str, this.f9655b, str2, this.f9654a, 0);
        try {
            mo29805a(message);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        C3620a.m10702a();
        C3620a.m10705a(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7719a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Pushbullet MessagingExtension: onConversationDismissed(");
        sb.append(str);
        sb.append(")");
        Log.i("PushBullet", sb.toString());
        C3620a.m10702a();
        C3620a.m10705a(str);
    }

    /* renamed from: a */
    public void mo29805a(Message message) {
        sendBroadcast(new Intent().setAction("chatMessageSendqueueBackground").putExtra("bridgefyMessage", message.getReceiver()).putExtra("bridgefyMessage", message.serialize()));
    }
}
