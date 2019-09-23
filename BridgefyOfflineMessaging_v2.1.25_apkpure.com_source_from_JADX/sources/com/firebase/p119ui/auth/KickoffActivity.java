package com.firebase.p119ui.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.p081a.C1071e;
import com.firebase.p119ui.auth.p121b.C2032d;
import com.firebase.p119ui.auth.p121b.p123b.C2025c;
import com.firebase.p119ui.auth.p124ui.C2051d;

/* renamed from: com.firebase.ui.auth.KickoffActivity */
public class KickoffActivity extends C2051d {

    /* renamed from: a */
    private boolean f6187a = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null || bundle.getBoolean("is_waiting_for_play_services")) {
            if (m8135e()) {
                Log.d("KickoffActivity", "No network connection");
                mo11883a(0, C2034c.m8234a(10));
            } else if (C2032d.m8232a(this, 1, new OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    KickoffActivity.this.mo11883a(0, C2034c.m8234a(20));
                }
            })) {
                m8134a();
            } else {
                this.f6187a = true;
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("has_existing_instance", true);
        bundle.putBoolean("is_waiting_for_play_services", this.f6187a);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            C2025c a = C2025c.m8210a((C1071e) this);
            if (a != null) {
                a.onActivityResult(i, i2, intent);
            }
        } else if (i2 == -1) {
            m8134a();
        } else {
            mo11883a(0, C2034c.m8234a(20));
        }
    }

    /* renamed from: a */
    private void m8134a() {
        C2025c.m8212a((C1071e) this, mo11886b());
    }

    /* renamed from: e */
    private boolean m8135e() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        return connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
