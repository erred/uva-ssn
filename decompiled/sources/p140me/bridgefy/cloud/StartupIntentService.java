package p140me.bridgefy.cloud;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser;
import p140me.bridgefy.cloud.C3519c.C3523c;
import p140me.bridgefy.main.C3608c;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.service.BridgefyORMLiteIntentService;

/* renamed from: me.bridgefy.cloud.StartupIntentService */
public class StartupIntentService extends BridgefyORMLiteIntentService<DatabaseHelper> {
    public StartupIntentService() {
        super("StartupCheck");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        Log.d("StartupCheck", "Starting StartupIntentService.");
        if (C3608c.m10652e()) {
            final SharedPreferences sharedPreferences = getSharedPreferences("BgfyPrefs", 0);
            C3519c.m10314a((C3523c) new C3523c<BgfyUser>() {
                /* renamed from: a */
                public void onSuccess(BgfyUser bgfyUser) {
                    if (bgfyUser.getUuid() != null) {
                        if (sharedPreferences.getBoolean("pendingRegister", false)) {
                            C3518b.m10290a(StartupIntentService.this.getApplicationContext(), 6002);
                        }
                        if (sharedPreferences.getBoolean("pendingKeyUpload", false)) {
                            C3518b.m10290a(StartupIntentService.this.getApplicationContext(), 6001);
                        }
                        if (sharedPreferences.contains("pendingChangeUsername")) {
                            C3518b.m10290a(StartupIntentService.this.getApplicationContext(), 6003);
                        }
                        try {
                            C3518b.m10290a(StartupIntentService.this.getApplicationContext(), 6004);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                public void onError(Throwable th) {
                    th.printStackTrace();
                }
            });
        }
    }
}
