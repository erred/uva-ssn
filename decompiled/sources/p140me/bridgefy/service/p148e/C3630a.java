package p140me.bridgefy.service.p148e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bridgefy.sdk.framework.controller.Constants;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.service.p145b.C3617a;

/* renamed from: me.bridgefy.service.e.a */
/* compiled from: BridgefyBroadcastReceiver */
public class C3630a extends BroadcastReceiver {

    /* renamed from: a */
    private DatabaseHelper f9581a;

    public C3630a(DatabaseHelper databaseHelper) {
        this.f9581a = databaseHelper;
    }

    public void onReceive(Context context, Intent intent) {
        if (mo29679b().isOpen()) {
            C3617a.m10690a(context, mo29679b()).mo29654a(context, intent, mo29679b());
        }
    }

    /* renamed from: a */
    public IntentFilter mo29678a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("chatMessageBackground");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction(Constants.LOGGING_EVENT_BROADCAST);
        return intentFilter;
    }

    /* renamed from: b */
    public DatabaseHelper mo29679b() {
        return this.f9581a;
    }
}
