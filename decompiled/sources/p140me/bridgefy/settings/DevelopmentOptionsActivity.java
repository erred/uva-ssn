package p140me.bridgefy.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bridgefy.sdk.client.BFEnergyProfile;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.BridgefyClient;
import com.bridgefy.sdk.client.CryptoRSA;
import com.bridgefy.sdk.framework.controller.Analytics;
import com.bridgefy.sdk.framework.controller.Analytics.EventType;
import com.bridgefy.sdk.framework.controller.BridgefyCore;
import com.bridgefy.sdk.framework.utils.Utils;
import com.squareup.p131a.C3017h;
import java.util.HashMap;
import me.bridgefy.main.R;
import p140me.bridgefy.cloud.google_controller;
import p140me.bridgefy.cloud.C3518b;
import p140me.bridgefy.cloud.C3519c;
import p140me.bridgefy.cloud.C3519c.C3521a;
import p140me.bridgefy.cloud.FirebaseIdService;
import p140me.bridgefy.intro.VerificationActivity;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.main.C3608c;
import p140me.bridgefy.ormlite.DataBaseUtils;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.p141a.C3457c;
import p140me.bridgefy.p141a.C3460d;
import p140me.bridgefy.service.p147d.C3622b;
import p140me.bridgefy.utils.C3659b;
import p140me.bridgefy.utils.C3659b.C3660a;

/* renamed from: me.bridgefy.settings.DevelopmentOptionsActivity */
public class DevelopmentOptionsActivity extends BridgefyOrmLiteBaseActivity<DatabaseHelper> {

    /* renamed from: a */
    private final String f9587a = getClass().getCanonicalName();

    /* renamed from: b */
    private final String f9588b = BridgefyCore.PREFS_NAME;

    /* renamed from: c */
    private final String f9589c = "com.bridgefy.sdk.key.token";

    /* renamed from: d */
    private String f9590d = "Internet Available: ";

    /* renamed from: e */
    private TextView f9591e;

    /* renamed from: f */
    private String f9592f = "PHONE:";

    /* renamed from: g */
    private TextView f9593g;
    @BindView(2131296479)
    TableLayout infoTable;
    @BindView(2131296552)
    EditText phoneNumberTextEdit;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_development_options);
        ButterKnife.bind((Activity) this);
        BridgefyApp.m10557c().mo29530g().mo27385a((Object) this);
        String packageName = getApplicationContext().getPackageName();
        String string = this.settings.getString("user_uuid", "--");
        m10757a("BUNDLE ID: ", packageName);
        m10757a("USERNAME: ", this.settings.getString(FriendDTO.USER_NAME, "--"));
        m10757a("USER_ID: ", string);
        StringBuilder sb = new StringBuilder();
        sb.append(this.settings.getLong("digits_id", -1));
        sb.append("");
        m10757a("DIGITS_ID: ", sb.toString());
        m10757a("PROVIDER_ID: ", this.settings.getString("provider_id", null));
        m10757a(this.f9592f, this.settings.getString("user_phone", "--"));
        m10757a("PHONE (SESSION)", C3608c.m10654g());
        m10757a("Verified", String.valueOf(C3608c.m10650c()));
        m10757a("CRC-userId: ", String.valueOf(Utils.getCrcFromKey(this.settings.getString("user_uuid", ""))));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(VERSION.RELEASE);
        sb2.append(" (");
        sb2.append(String.valueOf(VERSION.SDK_INT));
        sb2.append(")");
        m10757a("OS RELEASE: ", sb2.toString());
        m10757a("APP VERSION: ", "2.1.25 (82)");
        m10757a(this.f9590d, String.valueOf(C3622b.m10715a(getBaseContext(), (DatabaseHelper) getHelper()).mo29663b()));
        m10757a("Target: ", "Production");
        m10757a("Token acquired: ", String.valueOf(google_controller.get_google_controller().get_id_token() != null));
        m10757a("Telephony Features: ", String.valueOf(C3659b.m10909e((Context) this)));
        String str = this.f9587a;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("My user id is: \n");
        sb3.append(string);
        Log.v(str, sb3.toString());
        String str2 = this.f9587a;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("My providerId is: \n");
        sb4.append(this.settings.getString("provider_id", null));
        Log.v(str2, sb4.toString());
        String string2 = getSharedPreferences(BridgefyCore.PREFS_NAME, 0).getString("com.bridgefy.sdk.key.token", null);
        String str3 = this.f9587a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("My SDK token is: \n");
        sb5.append(string2);
        Log.v(str3, sb5.toString());
        try {
            m10757a("SDK STARTED: ", String.valueOf(C3608c.m10651d()));
            String publicKey = Bridgefy.getInstance().getBridgefyClient().getPublicKey();
            String str4 = this.f9587a;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("My public key is: \n");
            sb6.append(publicKey);
            Log.v(str4, sb6.toString());
        } catch (IllegalStateException unused) {
            Log.w(this.f9587a, "Bridgefy has not been initialized so debug info is incomplete.");
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BridgefyApp.m10557c().mo29530g().mo27388b((Object) this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10756a(Boolean bool) {
        this.f9591e.setText(String.valueOf(bool));
    }

    @C3017h
    public void updateInternetStatus(Boolean bool) {
        runOnUiThread(new Runnable(bool) {
            private final /* synthetic */ Boolean f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DevelopmentOptionsActivity.this.m10756a(this.f$1);
            }
        });
    }

    public void cancelJobs(View view) {
        Log.i(this.f9587a, "cancelJobs()");
        C3518b.m10289a(this);
        Toast.makeText(getApplicationContext(), "Canceled scheduled jobs", 0).show();
    }

    public void startBridgefy(View view) {
        Log.i(this.f9587a, "startBridgefy()");
        BridgefyApp.m10557c().mo29530g().mo27391c((Object) "command.services.start");
    }

    public void stopBridgefy(View view) {
        Log.i(this.f9587a, "stopBridgefy()");
        BridgefyApp.m10557c().mo29530g().mo27391c((Object) "command.services.stop");
    }

    public void setEnergyProfile(View view) {
        Log.i(this.f9587a, "setEnergyProfile()");
        Bridgefy.setEnergyProfile(BFEnergyProfile.HIGH_PERFORMANCE);
        Toast.makeText(getApplicationContext(), "Energy Profile set to HIGH_PERFORMANCE", 0).show();
    }

    public void runStartupIntentService(View view) {
        FirebaseIdService.m10252a("test", getApplicationContext());
    }

    public void regenerateKeys(View view) {
        Log.i(this.f9587a, "regenerateKeys()");
        try {
            HashMap hashMap = (HashMap) C3660a.m10913a("generateKeys").mo29822a(CryptoRSA.class).mo29821a();
            String str = (String) hashMap.get("public");
            String str2 = (String) hashMap.get("load");
            Log.d(this.f9587a, "... generated new pair of keys");
            Toast.makeText(getApplicationContext(), "Regenerated keys", 0).show();
            Editor edit = getApplicationContext().getSharedPreferences(BridgefyCore.PREFS_NAME, 0).edit();
            edit.putString("com.bridgefy.sdk.key.public", str);
            edit.putString("com.bridgefy.sdk.key.secret", str2);
            edit.apply();
            C3660a.m10913a("setPublicKey").mo29822a(BridgefyClient.class).mo29823a((Object) Bridgefy.getInstance().getBridgefyClient()).mo29825a(str).mo29824a((Class<?>[]) new Class[]{String.class}).mo29821a();
            C3660a.m10913a("setSecretKey").mo29822a(BridgefyClient.class).mo29823a((Object) Bridgefy.getInstance().getBridgefyClient()).mo29825a(str2).mo29824a((Class<?>[]) new Class[]{String.class}).mo29821a();
        } catch (Exception e) {
            e.printStackTrace();
        }
        uploadKeys(view);
    }

    public void uploadKeys(View view) {
        Log.i(this.f9587a, "uploadKeys()");
        C3519c.m10313a((C3521a) new C3521a() {
            public void onComplete() {
                Toast.makeText(DevelopmentOptionsActivity.this.getApplicationContext(), "Keys uploaded", 0).show();
            }

            public void onError(Throwable th) {
                th.printStackTrace();
                Toast.makeText(DevelopmentOptionsActivity.this.getApplicationContext(), "Error uploading keys!", 0).show();
            }
        });
    }

    public void removeBridgefyCertificate(View view) {
        Log.i(this.f9587a, "removeBridgefyCertificate()");
        Editor edit = getSharedPreferences(BridgefyCore.PREFS_NAME, 0).edit();
        edit.remove("com.bridgefy.sdk.client.certificate.data");
        edit.remove("com.bridgefy.sdk.client.certificate.signature");
        edit.apply();
        Toast.makeText(getApplicationContext(), "Certificate removed", 0).show();
    }

    public void removeBridgefyToken(View view) {
        Log.i(this.f9587a, "removeBridgefyToken()");
        getSharedPreferences(BridgefyCore.PREFS_NAME, 0).edit().remove("com.bridgefy.sdk.key.token").apply();
        Toast.makeText(getApplicationContext(), "Token removed", 0).show();
    }

    public void removeFirebaseToken(View view) {
        Log.i(this.f9587a, "removeFirebaseToken()");
        google_controller.get_google_controller().set_id_token((String) null);
        Toast.makeText(getApplicationContext(), "Token removed", 0).show();
    }

    public void dropAnalytics(View view) {
        Log.i(this.f9587a, "dropAnalytics()");
        getApplicationContext().getSharedPreferences(BridgefyCore.PREFS_NAME, 0).edit().remove("com.bridgefy.sdk.client.analytics.messages").apply();
        C3660a.m10913a("initialize").mo29822a(Analytics.class).mo29825a(getApplicationContext()).mo29824a((Class<?>[]) new Class[]{Context.class}).mo29821a();
        Toast.makeText(getApplicationContext(), "Dropped Analytics Cache", 0).show();
    }

    public void seedAnalytics(View view) {
        Log.i(this.f9587a, "seedAnalytics()");
        C3660a.m10913a("logEvent").mo29822a(Analytics.class).mo29825a(EventType.BFAnalyticsMessageTypeBroadcastReceived).mo29824a((Class<?>[]) new Class[]{EventType.class}).mo29821a();
        Toast.makeText(getApplicationContext(), "Added BroadcastReceived event", 0).show();
    }

    public void uploadAnalytics(View view) {
        Toast.makeText(getApplicationContext(), "Analytics module is not public", 0).show();
    }

    public void resetDatabase(View view) {
        DataBaseUtils.resetDataBase((DatabaseHelper) getHelper());
        Toast.makeText(getApplicationContext(), "All local records have been deleted.", 0).show();
    }

    public void deleteFriend(View view) {
        FriendDTO e = new C3457c((DatabaseHelper) getHelper()).mo28326e(this.phoneNumberTextEdit.getText().toString());
        if (e != null) {
            e.delete(((DatabaseHelper) getHelper()).getFriendRuntimeDAO());
            new C3460d((DatabaseHelper) getHelper()).deleteMessages(e.getId());
            Context applicationContext = getApplicationContext();
            StringBuilder sb = new StringBuilder();
            sb.append("Removed friend: ");
            sb.append(e.getContactOrUsername());
            Toast.makeText(applicationContext, sb.toString(), 0).show();
            finish();
            return;
        }
        Toast.makeText(getApplicationContext(), "Unable to find friend", 0).show();
    }

    public void deleteMessages(View view) {
        new Thread(new Runnable() {
            public final void run() {
                DevelopmentOptionsActivity.this.m10755a();
            }
        }).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10755a() {
        new C3460d((DatabaseHelper) getHelper()).mo28342b();
        runOnUiThread(new Runnable() {
            public final void run() {
                DevelopmentOptionsActivity.this.m10758b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m10758b() {
        Toast.makeText(getApplicationContext(), "Messages removed", 0).show();
    }

    public void verifyUser(View view) {
        startActivityForResult(new Intent(getApplicationContext(), VerificationActivity.class).putExtra("requestCode", 2323), 2323);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 2323) {
            return;
        }
        if (i2 == -1) {
            this.f9593g.setText(intent.getStringExtra("phone"));
            Toast.makeText(getApplicationContext(), "User verified!", 0).show();
            return;
        }
        Toast.makeText(getApplicationContext(), "User not verified!", 0).show();
    }

    /* renamed from: a */
    private void m10757a(String str, String str2) {
        TableRow tableRow = new TableRow(this);
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTypeface(null, 1);
        tableRow.addView(textView);
        TextView textView2 = new TextView(this);
        textView2.setText(str2);
        tableRow.addView(textView2);
        this.infoTable.addView(tableRow, new LayoutParams(-2, -2));
        if (str.equals(this.f9590d)) {
            this.f9591e = textView2;
        } else if (str.equals(this.f9592f)) {
            this.f9593g = textView2;
        }
    }
}
