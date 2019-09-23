package p140me.bridgefy.intro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.C0448d;
import com.google.android.gms.common.ConnectionResult;
import me.bridgefy.main.R;

/* renamed from: me.bridgefy.intro.SplashActivity */
public class SplashActivity extends C0448d {

    /* renamed from: a */
    private final int f9338a = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_splash);
        getWindow().setFlags(1024, 1024);
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                SplashActivity.this.m10453a();
            }
        }, 1500);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10453a() {
        startActivity(new Intent(this, IntroActivity.class));
        finish();
    }
}
