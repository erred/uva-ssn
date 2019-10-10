package p140me.bridgefy.main;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.widget.Toast;
import com.bridgefy.sdk.client.Config.Antenna;
import com.firebase.p117a.C1989a;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p140me.bridgefy.backend.p143v3.bgfyUserApi.model.BgfyUser;
import p140me.bridgefy.cloud.google_controller;
import p140me.bridgefy.cloud.C3518b;
import p140me.bridgefy.ormlite.DataBaseUtils;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.entities.FriendDTO;
import p140me.bridgefy.service.p144a.C3615a;
import p140me.bridgefy.service.p147d.C3620a;
import p140me.bridgefy.service.p147d.C3622b;
import p140me.bridgefy.utils.C3659b;

/* renamed from: me.bridgefy.main.c */
/* compiled from: BridgefySession */
public class C3608c {

    /* renamed from: h */
    private static C3608c f9503h;

    /* renamed from: a */
    private String f9504a;

    /* renamed from: b */
    private String f9505b;

    /* renamed from: c */
    private String f9506c;

    /* renamed from: d */
    private String f9507d;

    /* renamed from: e */
    private String f9508e;

    /* renamed from: f */
    private boolean f9509f = false;

    /* renamed from: g */
    private boolean f9510g = false;

    /* renamed from: i */
    private SharedPreferences f9511i;

    private C3608c(BgfyUser bgfyUser, boolean z) {
        this.f9504a = bgfyUser.getUuid();
        this.f9505b = bgfyUser.getDigitsId();
        this.f9506c = bgfyUser.getPublicName();
        this.f9507d = bgfyUser.getPhone();
        this.f9509f = z;
        this.f9508e = bgfyUser.getRegistrationId();
    }

    private C3608c(Context context) {
        this.f9511i = context.getSharedPreferences("BgfyPrefs", 0);
        this.f9504a = this.f9511i.getString("user_uuid", null);
        this.f9505b = this.f9511i.getString("provider_id", null);
        this.f9506c = this.f9511i.getString(FriendDTO.USER_NAME, null);
        this.f9507d = this.f9511i.getString("user_phone", null);
        this.f9508e = this.f9511i.getString("cgmRegistrationId", null);
    }

    /* renamed from: a */
    public static void m10641a(Context context, BgfyUser bgfyUser) {
        f9503h = new C3608c(bgfyUser, m10649b());
        Editor edit = context.getSharedPreferences("BgfyPrefs", 0).edit();
        edit.putString("user_uuid", bgfyUser.getUuid());
        edit.putString("provider_id", bgfyUser.getDigitsId());
        edit.putString(FriendDTO.USER_NAME, bgfyUser.getPublicName());
        edit.putString("cgmRegistrationId", bgfyUser.getRegistrationId());
        edit.putLong("creation_date", System.currentTimeMillis());
        edit.commit();
    }

    /* renamed from: a */
    public static void m10640a(Context context) {
        f9503h = new C3608c(context);
        if (m10652e()) {
            f9503h.m10655h();
        }
    }

    /* renamed from: a */
    public static void m10642a(Context context, DatabaseHelper databaseHelper, int i) {
        Log.w("BridgefySession", "Starting sign out...");
        SharedPreferences sharedPreferences = context.getSharedPreferences("BgfyPrefs", 0);
        try {
            C3659b.m10894a("Session", "logout", String.valueOf(Integer.valueOf(C3659b.m10911f(sharedPreferences.getString("user_phone", "")))), (System.currentTimeMillis() - sharedPreferences.getLong("creation_date", System.currentTimeMillis())) / 1000, BridgefyApp.m10557c().mo29529e());
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            try {
                Log.w("BridgefySession", "... Unable to track logout event");
                e.printStackTrace();
            } catch (Exception e2) {
                Toast.makeText(context, context.getString(R.string.signout_error), 0).show();
                Log.e("BridgefySession", "Unable to complete logout.");
                e2.printStackTrace();
                return;
            }
        }
        Log.w("BridgefySession", "... clearing notifications");
        C3620a.m10705a(null);
        Log.w("BridgefySession", "... clearing shared preferences");
        sharedPreferences.edit().clear().apply();
        Log.w("BridgefySession", "... resetting database");
        DataBaseUtils.resetDataBase(databaseHelper);
        Log.w("BridgefySession", "... removing all active connections");
        C3615a.m10678a().mo29648a(Antenna.UNREACHABLE);
        FirebaseAuth.getInstance().signOut();
        Log.w("BridgefySession", "... Stopping Bridgefy Framework");
        BridgefyApp.m10557c().mo29530g().mo27391c((Object) "signOut");
        C3518b.m10289a(context);
        Log.w("BridgefySession", "Destroying OnlineManager & GoogleController");
        C3622b.m10715a(context, databaseHelper).mo29657a();
        google_controller.reset_google_controller();
        m10640a(context);
        Log.i("BridgefySession", "... Finalizing by broadcast to BridgefyActivity");
        context.sendBroadcast(new Intent("signOut").putExtra("signoutType", i));
    }

    /* renamed from: b */
    public static void m10647b(Context context) {
        int i = context.getSharedPreferences("me.bridgefy.main.SIGNOUT_NOTIFICATION", 0).getInt("signOutNotification", -1);
        if (i != -1) {
            ((NotificationManager) BridgefyApp.m10557c().getSystemService("notification")).cancel(i);
        }
    }

    /* renamed from: a */
    public static int m10639a() {
        if (m10652e()) {
            return 1;
        }
        return m10650c() ? 2 : 0;
    }

    /* renamed from: b */
    public static boolean m10649b() {
        return f9503h.f9509f;
    }

    /* renamed from: a */
    public static void m10646a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("registered = ");
        sb.append(z);
        Log.v("BridgefySession", sb.toString());
        f9503h.f9509f = z;
    }

    /* renamed from: c */
    public static boolean m10650c() {
        return f9503h.f9507d != null && !f9503h.f9507d.trim().equals("");
    }

    /* renamed from: d */
    public static boolean m10651d() {
        return f9503h == null || f9503h.f9510g;
    }

    /* renamed from: b */
    public static void m10648b(boolean z) {
        f9503h.f9510g = z;
    }

    /* renamed from: e */
    public static boolean m10652e() {
        return f9503h.f9504a != null;
    }

    /* renamed from: f */
    public static String m10653f() {
        return f9503h.f9504a;
    }

    /* renamed from: g */
    public static String m10654g() {
        return f9503h.f9507d;
    }

    /* renamed from: a */
    public static void m10644a(String str) {
        f9503h.f9507d = str;
    }

    /* renamed from: h */
    private void m10655h() {
        if (!m10656i()) {
            StringBuilder sb = new StringBuilder();
            sb.append("PREFS_DIGITS_ID: ");
            sb.append(this.f9511i.getLong("digits_id", -1));
            Log.w("BridgefySession", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("PREFS_PROVIDER_ID: ");
            sb2.append(this.f9511i.getString("provider_id", null));
            Log.w("BridgefySession", sb2.toString());
            Log.i("BridgefySession", "Found PREFS_DIGITS_ID field found. Starting Digits migration...");
            m10657j();
        }
    }

    /* renamed from: i */
    private boolean m10656i() {
        return this.f9511i.contains("provider_id");
    }

    /* renamed from: j */
    private void m10657j() {
        int availableProcessors = Runtime.getRuntime().availableProcessors() * 2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(availableProcessors, availableProcessors, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        C1989a.m8102a().mo11767a(false).addOnSuccessListener((Executor) threadPoolExecutor, (OnSuccessListener<? super TResult>) new OnSuccessListener() {
            public final void onSuccess(Object obj) {
                C3608c.this.m10645a((Void) obj);
            }
        }).addOnFailureListener($$Lambda$c$dA_vahkNfFxu52D_xieskykVmec.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10645a(Void voidR) {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            Log.i("BridgefySession", "... Digits->Firebase migration succeeded!");
            StringBuilder sb = new StringBuilder();
            sb.append("... ... Digits id preserved: ");
            sb.append(currentUser.getUid());
            Log.v("BridgefySession", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("... ... Digits phone number preserved: ");
            sb2.append(currentUser.getPhoneNumber());
            Log.v("BridgefySession", sb2.toString());
            this.f9511i.edit().putString("provider_id", currentUser.getUid()).remove("auth_token").remove("digits_id").apply();
            Log.d("BridgefySession", "... Updated local values in Shared Preferences.");
            return;
        }
        Log.e("BridgefySession", "Digits->Firebase migration failed. Will retry next time TMA is started.");
    }
}
