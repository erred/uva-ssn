package p140me.bridgefy.cloud;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import p140me.bridgefy.cloud.C3519c.C3521a;

/* renamed from: me.bridgefy.cloud.FirebaseIdService */
public class FirebaseIdService extends FirebaseInstanceIdService {
    public void onTokenRefresh() {
        super.onTokenRefresh();
        Log.d("FirebaseIdService", "A new token has been generated");
        String token = FirebaseInstanceId.getInstance().getToken();
        StringBuilder sb = new StringBuilder();
        sb.append("Refreshed token: ");
        sb.append(token);
        Log.d("FirebaseIdService", sb.toString());
        m10252a(token, getApplicationContext());
    }

    /* renamed from: a */
    public static void m10252a(String str, Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("updateToken: token is ");
        sb.append(str);
        Log.i("FirebaseIdService", sb.toString());
        final Editor edit = context.getSharedPreferences("BgfyPrefs", 0).edit();
        google_controller.initialize_google_controller(context);
        C3519c.m10304a(str, context, (C3521a) new C3521a() {
            public void onComplete() {
                edit.remove("pendingRegister").commit();
            }

            public void onError(Throwable th) {
                edit.putBoolean("pendingRegister", true).commit();
            }
        });
    }
}
