package p140me.bridgefy.cloud;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import p140me.bridgefy.service.BridgefyService;
import p140me.bridgefy.service.BridgefyService.C3612a;
import p140me.bridgefy.service.p147d.C3622b;

/* renamed from: me.bridgefy.cloud.FirebaseListenerService */
public class FirebaseListenerService extends FirebaseMessagingService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Intent f9148a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f9149b = false;

    /* renamed from: c */
    private ServiceConnection f9150c = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C3612a aVar = (C3612a) iBinder;
            C3622b.m10715a(FirebaseListenerService.this.getBaseContext(), BridgefyService.get_database_helper()).mo29658a(FirebaseListenerService.this.f9148a, FirebaseListenerService.this.getApplicationContext(), BridgefyService.get_database_helper());
            FirebaseListenerService.this.f9149b = true;
        }

        public void onServiceDisconnected(ComponentName componentName) {
            FirebaseListenerService.this.f9149b = false;
        }
    };

    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (!BridgefyService.f9518b) {
            Intent action = new Intent(this, BridgefyService.class).setAction("me.bridgefy.main.service.background");
            if (VERSION.SDK_INT >= 26) {
                startForegroundService(action);
            } else {
                startService(action);
            }
        }
        remoteMessage.getFrom();
        Map data = remoteMessage.getData();
        HashMap hashMap = new HashMap();
        for (Entry entry : data.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        Bundle bundle = new Bundle();
        StringBuilder sb = new StringBuilder();
        sb.append("onMessageReceived: map empty: ");
        sb.append(hashMap.size());
        Log.w("FirebaseListenerService", sb.toString());
        bundle.putSerializable("map", hashMap);
        if (hashMap.isEmpty()) {
            return;
        }
        if (BridgefyService.f9518b && this.f9149b) {
            C3622b.m10715a(getBaseContext(), BridgefyService.get_database_helper()).mo29658a(new Intent().putExtras(bundle), getApplicationContext(), BridgefyService.get_database_helper());
            return;
        }
        this.f9148a = new Intent();
        this.f9148a.putExtras(bundle);
        bindService(new Intent(this, BridgefyService.class).setAction("me.bridgefy.main.service.background"), this.f9150c, 1);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f9149b) {
            unbindService(this.f9150c);
        }
    }
}
