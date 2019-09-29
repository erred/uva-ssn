package p140me.bridgefy.storage.p149a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import p140me.bridgefy.entities.Message;
import p140me.bridgefy.ormlite.entities.MessageDTO;
import p140me.bridgefy.storage.service.UploadService;

/* renamed from: me.bridgefy.storage.a.a */
/* compiled from: StorageBroadcastReceiver */
public abstract class C3643a extends BroadcastReceiver {
    /* renamed from: a */
    public abstract void mo29142a(String str, int i);

    /* renamed from: a */
    public abstract void mo29143a(String str, int i, String str2);

    /* renamed from: a */
    public abstract void mo29144a(String str, Exception exc);

    public void onReceive(Context context, Intent intent) {
        if (intent != null && UploadService.m10853b().equals(intent.getAction())) {
            int intExtra = intent.getIntExtra(MessageDTO.STATUS, 0);
            String stringExtra = intent.getStringExtra("id");
            Message.create(intent.getStringExtra("bridgefyMessage"));
            switch (intExtra) {
                case 1:
                    mo29142a(stringExtra, intent.getIntExtra("progress", 0));
                    return;
                case 2:
                    mo29143a(stringExtra, intent.getIntExtra("serverResponseCode", 0), intent.getStringExtra("serverResponseMessage"));
                    return;
                case 3:
                    mo29144a(stringExtra, (Exception) intent.getSerializableExtra("errorException"));
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public void mo29738a(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(UploadService.m10853b());
        context.registerReceiver(this, intentFilter);
    }

    /* renamed from: b */
    public void mo29739b(Context context) {
        context.unregisterReceiver(this);
    }
}
