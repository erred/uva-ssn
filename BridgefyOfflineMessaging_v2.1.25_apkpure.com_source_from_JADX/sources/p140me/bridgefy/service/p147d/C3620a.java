package p140me.bridgefy.service.p147d;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.C0854g.C0857c;
import androidx.core.app.C0854g.C0858d;
import androidx.core.app.C0854g.C0858d.C0859a;
import androidx.core.app.C0854g.C0860e;
import androidx.core.app.C0863j.C0864a;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.p113c.p114a.p115a.C1947b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import me.bridgefy.main.R;
import net.sqlcipher.database.SQLiteDatabase;
import p140me.bridgefy.chat.ChatActivity;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.service.C3614a;

/* renamed from: me.bridgefy.service.d.a */
/* compiled from: BridgefyNotification */
public class C3620a {

    /* renamed from: b */
    private static CopyOnWriteArrayList<C3614a> f9551b;

    /* renamed from: c */
    private static C3620a f9552c = new C3620a();

    /* renamed from: a */
    SharedPreferences f9553a = BridgefyApp.m10557c().getSharedPreferences("BgfyPrefs", 0);

    private C3620a() {
        f9551b = new CopyOnWriteArrayList<>();
    }

    /* renamed from: a */
    public static C3620a m10702a() {
        if (f9552c == null) {
            f9552c = new C3620a();
        }
        return f9552c;
    }

    /* renamed from: a */
    public void mo29656a(Bundle bundle, String str) {
        int i;
        if (this.f9553a.getBoolean("settings_notifications_enabled", true)) {
            Intent intent = new Intent().setAction("chatMessageBackground").setClass(BridgefyApp.m10557c(), ChatActivity.class);
            final Message create = Message.create(bundle.getString("bridgefyMessageLabel"));
            String string = bundle.getString("otherUserId");
            Iterator it = f9551b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                C3614a aVar = (C3614a) it.next();
                if (aVar.mo29644b().equals(string)) {
                    aVar.mo29645c().add(create);
                    bundle.putParcelableArrayList("chatMessagesArray", aVar.mo29645c());
                    i = aVar.mo29643a();
                    bundle.putInt("notificationId", i);
                    m10704a(i, intent.putExtras(bundle), str);
                    break;
                }
            }
            if (i == -1) {
                i = new Random().nextInt(10000);
                bundle.putInt("notificationId", i);
                if (string == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Parameter was null: conversationId: ");
                    sb.append(string);
                    Log.w("BridgefyNotification", sb.toString());
                }
                C36211 r3 = new ArrayList<Message>() {
                    {
                        add(create);
                    }
                };
                f9551b.add(new C3614a(string, r3, i));
                bundle.putParcelableArrayList("chatMessagesArray", r3);
                m10704a(i, intent.putExtras(bundle), str);
            }
            int i2 = i;
            if (create != null && create.getText() != null && !create.getText().isEmpty()) {
                C1947b.m8084a(BridgefyApp.m10557c(), string, bundle.getString("otherUserName"), create.getText(), ((BitmapDrawable) BridgefyApp.m10557c().getDrawable(R.drawable.bf)).getBitmap(), null, i2);
            }
        }
    }

    /* renamed from: a */
    private synchronized void m10704a(int i, Intent intent, String str) {
        intent.getExtras().remove("bridgefyMessage");
        PendingIntent activity = PendingIntent.getActivity(BridgefyApp.m10557c().getBaseContext(), 0, intent, SQLiteDatabase.CREATE_IF_NECESSARY);
        ArrayList parcelableArrayList = intent.getExtras().getParcelableArrayList("chatMessagesArray");
        C0857c a = new C0857c(BridgefyApp.m10557c(), "bridgefy_channel").mo3490a((CharSequence) str).mo3502d(BridgefyApp.m10557c().getResources().getColor(R.color.bridgefy_primary)).mo3496b((CharSequence) ((Message) parcelableArrayList.get(parcelableArrayList.size() - 1)).getText()).mo3481a((int) R.drawable.bf).mo3499c(4).mo3482a(BridgefyApp.m10557c().getResources().getColor(R.color.apptheme_color), 1000, (int) AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS).mo3497b(true).mo3501c(true).mo3488a(Uri.parse(this.f9553a.getString("notificationSound", RingtoneManager.getDefaultUri(2).toString()))).mo3494b(2).mo3486a(activity);
        if (VERSION.SDK_INT >= 21) {
            a.mo3487a(((BitmapDrawable) BridgefyApp.m10557c().getDrawable(R.drawable.icon_40)).getBitmap());
        }
        C0864a aVar = new C0864a();
        aVar.mo3527a(str);
        C0858d dVar = new C0858d(aVar.mo3528a());
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            Message message = (Message) it.next();
            dVar.mo3504a(new C0859a(message.getText(), Long.parseLong(message.getDateSent()), aVar.mo3528a()));
        }
        a.mo3489a((C0860e) dVar);
        m10703a(i, a.mo3493b());
    }

    /* renamed from: a */
    public static boolean m10705a(String str) {
        Iterator it = f9551b.iterator();
        while (it.hasNext()) {
            C3614a aVar = (C3614a) it.next();
            if (str != null) {
                if (aVar.mo29644b().equals(str)) {
                }
            }
            ((NotificationManager) BridgefyApp.m10557c().getSystemService("notification")).cancel(aVar.mo29643a());
            f9551b.remove(aVar);
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static void m10703a(int i, Notification notification) {
        new Handler(Looper.getMainLooper()).post(new Runnable(i, notification) {
            private final /* synthetic */ int f$0;
            private final /* synthetic */ Notification f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                ((NotificationManager) BridgefyApp.m10557c().getSystemService("notification")).notify(this.f$0, this.f$1);
            }
        });
    }

    /* renamed from: a */
    public static Bundle m10700a(Context context, Message message, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("otherUserName", str);
        bundle.putString("otherUserId", message.getSender());
        bundle.putString("bridgefyMessage", message.serialize());
        bundle.putString("bridgefyMessageLabel", m10701a(context, message).serialize());
        ArrayList arrayList = new ArrayList();
        arrayList.add(m10701a(context, message));
        bundle.putParcelableArrayList("chatMessagesArray", arrayList);
        if (message.getFileName() != null && message.getFileName().length() > 0) {
            bundle.putString("messageUri", message.getFileName());
        }
        return bundle;
    }

    /* renamed from: a */
    private static Message m10701a(Context context, Message message) {
        String str = "";
        switch (message.getType()) {
            case 1:
                StringBuilder sb = new StringBuilder();
                sb.append(context.getString(R.string.placeholder_image));
                sb.append(" 🖼");
                str = sb.toString();
                break;
            case 2:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(context.getString(R.string.placeholder_location));
                sb2.append(" 📌");
                str = sb2.toString();
                break;
            default:
                if (message.getText() != null && message.getText().length() > 0) {
                    str = message.getText();
                    break;
                }
        }
        message.setText(str);
        return message;
    }
}
