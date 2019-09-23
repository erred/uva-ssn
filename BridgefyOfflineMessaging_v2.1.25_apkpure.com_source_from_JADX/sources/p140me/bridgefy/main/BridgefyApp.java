package p140me.bridgefy.main;

import android.annotation.TargetApi;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.p082g.C1122a;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.p131a.C3007b;
import com.squareup.p131a.C3018i;
import java.util.Objects;
import p140me.bridgefy.ormlite.DataBaseUtils;
import p140me.bridgefy.utils.C3666f;

/* renamed from: me.bridgefy.main.BridgefyApp */
public class BridgefyApp extends Application {

    /* renamed from: b */
    public static Tracker f9457b = null;

    /* renamed from: e */
    private static String f9458e = "BridgefyApp";

    /* renamed from: f */
    private static BridgefyApp f9459f;

    /* renamed from: a */
    SharedPreferences f9460a;

    /* renamed from: c */
    public C3007b f9461c;

    /* renamed from: d */
    C3602a f9462d;

    public void onCreate() {
        Log.i(f9458e, "onCreate()");
        super.onCreate();
        this.f9460a = getApplicationContext().getSharedPreferences("BgfyPrefs", 0);
        this.f9461c = new C3007b(C3018i.f7874a);
        f9459f = this;
        new C3666f(this).mo29834a();
        mo29527b();
        FirebaseAuth.getInstance((FirebaseApp) Objects.requireNonNull(FirebaseApp.initializeApp(getApplicationContext())));
        this.f9462d = new C3605b(getApplicationContext());
        try {
            mo29528d();
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        m10559h();
        if (this.f9460a.getLong("creation_date", 0) == 0) {
            this.f9460a.edit().putLong("creation_date", System.currentTimeMillis()).apply();
        }
        if (VERSION.SDK_INT >= 26) {
            mo29525a();
        }
        C3608c.m10640a((Context) this);
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(26)
    /* renamed from: a */
    public void mo29525a() {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        String string = getString(R.string.channel_name);
        String string2 = getString(R.string.channel_description);
        NotificationChannel notificationChannel = new NotificationChannel("bridgefy_channel", string, 4);
        notificationChannel.setDescription(string2);
        notificationChannel.enableLights(true);
        notificationManager.createNotificationChannel(notificationChannel);
    }

    /* renamed from: b */
    public void mo29527b() {
        int i;
        if (this.f9460a.getInt("me.bridgefy.main.updated", 0) == 0) {
            Editor edit = this.f9460a.edit();
            edit.putBoolean("settings_analytics", false).apply();
            try {
                i = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
            } catch (NameNotFoundException e) {
                e.printStackTrace();
                i = 0;
            }
            edit.putInt("me.bridgefy.main.updated", i).apply();
        }
        this.f9460a.getBoolean("settings_analytics", false);
    }

    /* renamed from: c */
    public static BridgefyApp m10557c() {
        return f9459f;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        C1122a.m4361a((Context) this);
    }

    /* renamed from: h */
    private void m10559h() {
        DataBaseUtils.persistentDataBaseConfiguration(getApplicationContext());
    }

    /* renamed from: d */
    public Tracker mo29528d() throws NameNotFoundException {
        f9457b = GoogleAnalytics.getInstance(this).newTracker((String) getApplicationContext().getPackageManager().getApplicationInfo(getApplicationContext().getPackageName(), 128).metaData.get("me.bridgefy.tracker.production"));
        f9457b.enableAdvertisingIdCollection(true);
        f9457b.enableAutoActivityTracking(true);
        f9457b.enableExceptionReporting(false);
        f9457b.setAppName(getResources().getString(R.string.app_name));
        f9457b.setAppVersion("2.1.25");
        return f9457b;
    }

    /* renamed from: e */
    public Tracker mo29529e() {
        if (m10557c().getApplicationContext().getSharedPreferences("BgfyPrefs", 0).getBoolean("settings_analytics", false)) {
            return f9457b;
        }
        return null;
    }

    /* renamed from: f */
    public static C3602a m10558f() {
        return m10557c().f9462d;
    }

    /* renamed from: g */
    public C3007b mo29530g() {
        return this.f9461c;
    }
}
