package p140me.bridgefy.service.p145b;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.p079f.p080a.C1049a;
import com.bridgefy.sdk.client.ConnectionType;
import com.bridgefy.sdk.framework.controller.Constants;
import com.bridgefy.sdk.logging.entities.CommunicationLog;
import com.bridgefy.sdk.logging.entities.LogEntity;
import com.bridgefy.sdk.logging.entities.MeshLog;
import com.bridgefy.sdk.logging.entities.MessageLog;
import com.bridgefy.sdk.logging.entities.OperatorStatusLog;
import p140me.bridgefy.chat.ChatActivity;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.p141a.C3457c;
import p140me.bridgefy.p141a.C3460d;
import p140me.bridgefy.service.p147d.C3620a;
import p140me.bridgefy.service.p147d.C3622b;

/* renamed from: me.bridgefy.service.b.a */
/* compiled from: BridgefyController */
public class C3617a {

    /* renamed from: a */
    private static C3617a f9546a;

    /* renamed from: b */
    private C3460d f9547b;

    /* renamed from: c */
    private C3457c f9548c;

    /* renamed from: d */
    private C3622b f9549d;

    private C3617a(Context context, DatabaseHelper databaseHelper) {
        Log.d("BridgefyController", "Creating new BridgefyController instance");
        this.f9549d = C3622b.m10715a(context, databaseHelper);
    }

    /* renamed from: a */
    public static C3617a m10690a(Context context, DatabaseHelper databaseHelper) {
        if (f9546a == null) {
            f9546a = new C3617a(context, databaseHelper);
        }
        return f9546a;
    }

    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo29654a(android.content.Context r3, android.content.Intent r4, p140me.bridgefy.ormlite.DatabaseHelper r5) {
        /*
            r2 = this;
            java.lang.String r0 = r4.getAction()
            int r1 = r0.hashCode()
            switch(r1) {
                case -1530327060: goto L_0x0034;
                case -1172645946: goto L_0x002a;
                case -343630553: goto L_0x0020;
                case 1290347742: goto L_0x0016;
                case 1814682653: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003e
        L_0x000c:
            java.lang.String r1 = "chatMessageBackground"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003e
            r0 = 2
            goto L_0x003f
        L_0x0016:
            java.lang.String r1 = "broadcast.logging.event"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003e
            r0 = 4
            goto L_0x003f
        L_0x0020:
            java.lang.String r1 = "android.net.wifi.STATE_CHANGE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003e
            r0 = 0
            goto L_0x003f
        L_0x002a:
            java.lang.String r1 = "android.net.conn.CONNECTIVITY_CHANGE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003e
            r0 = 1
            goto L_0x003f
        L_0x0034:
            java.lang.String r1 = "android.bluetooth.adapter.action.STATE_CHANGED"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003e
            r0 = 3
            goto L_0x003f
        L_0x003e:
            r0 = -1
        L_0x003f:
            switch(r0) {
                case 0: goto L_0x004f;
                case 1: goto L_0x004f;
                case 2: goto L_0x004b;
                case 3: goto L_0x0047;
                case 4: goto L_0x0043;
                default: goto L_0x0042;
            }
        L_0x0042:
            goto L_0x0052
        L_0x0043:
            r2.m10692a(r4, r3)
            goto L_0x0052
        L_0x0047:
            r2.m10691a(r4)
            goto L_0x0052
        L_0x004b:
            r2.m10693a(r4, r3, r5)
            goto L_0x0052
        L_0x004f:
            r2.m10695b(r4)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p140me.bridgefy.service.p145b.C3617a.mo29654a(android.content.Context, android.content.Intent, me.bridgefy.ormlite.DatabaseHelper):void");
    }

    /* renamed from: a */
    private void m10692a(Intent intent, Context context) {
        String str = null;
        try {
            switch (LogEntity.logTypeOrdinalValues[intent.getExtras().getInt(Constants.LOGGING_EVENT_TYPE)]) {
                case OPERATOR_STATUS:
                case OPERATOR_STATUS_ERROR:
                    str = OperatorStatusLog.create(intent.getExtras().getString(Constants.LOGGING_EVENT_ENTRY)).getMessage();
                    break;
                case COMMUNICATION:
                case COMMUNICATION_ERROR:
                    str = CommunicationLog.create(intent.getExtras().getString(Constants.LOGGING_EVENT_ENTRY)).getMessage();
                    break;
                case MESH:
                case MESH_ERROR:
                    str = MeshLog.create(intent.getExtras().getString(Constants.LOGGING_EVENT_ENTRY)).getMessage();
                    break;
                case MESSAGE:
                case MESSAGE_ERROR:
                    str = MessageLog.create(intent.getExtras().getString(Constants.LOGGING_EVENT_ENTRY)).getMessage();
                    break;
            }
            Toast.makeText(context, str, 0).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m10693a(Intent intent, Context context, DatabaseHelper databaseHelper) {
        Log.e("BridgefyController", "launching notification from BridgefyController#onMessageReceived");
        Message create = Message.create(intent.getStringExtra("bridgefyMessage"));
        String stringExtra = intent.getStringExtra("otherUserId");
        if (this.f9548c == null) {
            this.f9548c = new C3457c(databaseHelper);
        }
        FriendDTO c = this.f9548c.query_friend_dto_by_id(stringExtra);
        if (this.f9547b == null) {
            this.f9547b = new C3460d(databaseHelper);
        }
        this.f9547b.mo28336a(c, create, c.getPhoneNumber());
        Bundle extras = intent.getExtras();
        if (!C1049a.m3996a(context).mo4060a(new Intent().setAction("chatMessage").setClass(context, ChatActivity.class).putExtras(extras))) {
            C3620a.m10702a().mo29656a(extras, create.getOtherUserName());
        }
    }

    /* renamed from: a */
    private void m10694a(ConnectionType connectionType, boolean z) {
        C1049a.m3996a(BridgefyApp.m10557c().getApplicationContext()).mo4060a(new Intent("antennaStateChangedSignal").putExtra("peerConnectionType", connectionType).putExtra("antennaStateChangedStatus", z));
    }

    /* renamed from: a */
    private void m10691a(Intent intent) {
        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
        if (intExtra == 10) {
            m10694a(ConnectionType.BLUETOOTH_LE, false);
        } else if (intExtra == 12) {
            m10694a(ConnectionType.ACCESS_POINT, true);
        }
    }

    /* renamed from: b */
    private void m10695b(Intent intent) {
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        switch (networkInfo.getType()) {
            case 0:
            case 1:
                if (networkInfo.isConnected()) {
                    this.f9549d.mo29662a(true);
                    return;
                } else if (!networkInfo.isConnected() && m10689a(BridgefyApp.m10557c().getBaseContext()) < 0) {
                    this.f9549d.mo29662a(false);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* renamed from: a */
    private int m10689a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getType();
        }
        return -1;
    }
}
