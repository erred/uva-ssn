package p140me.bridgefy.service;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.BitmapDrawable;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.C0854g.C0857c;
import com.bridgefy.sdk.client.BFEnergyProfile;
import com.bridgefy.sdk.client.BFEngineProfile;
import com.bridgefy.sdk.client.Bridgefy;
import com.bridgefy.sdk.client.BridgefyClient;
import com.bridgefy.sdk.client.Config;
import com.bridgefy.sdk.client.Config.Antenna;
import com.bridgefy.sdk.client.Config.Builder;
import com.bridgefy.sdk.client.RegistrationListener;
import com.bridgefy.sdk.framework.controller.BridgefyCore;
import com.bridgefy.sdk.logging.Logger;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;
import me.bridgefy.main.R;
import net.sqlcipher.database.SQLiteException;
import p140me.bridgefy.cloud.C3517a;
import p140me.bridgefy.cloud.C3519c;
import p140me.bridgefy.cloud.C3519c.C3521a;
import p140me.bridgefy.integration.C3549b;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.main.C3608c;
import p140me.bridgefy.main.TabbedMainActivity;
import p140me.bridgefy.ormlite.DataBaseUtils;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.service.BridgefyORMLiteService;
import p140me.bridgefy.service.p147d.C3622b;
import p140me.bridgefy.service.p148e.C3630a;
import p140me.bridgefy.utils.C3659b.C3660a;

/* renamed from: me.bridgefy.service.BridgefyService */
public class BridgefyService extends BridgefyORMLiteService {

    /* renamed from: b */
    public static boolean f9518b = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final String f9519d = "BridgefyService";

    /* renamed from: h */
    private static DatabaseHelper f9520h;

    /* renamed from: l */
    private static String f9521l;

    /* renamed from: n */
    private static HashMap<String, byte[]> f9522n = new HashMap<>();

    /* renamed from: a */
    SharedPreferences f9523a;

    /* renamed from: c */
    RegistrationListener f9524c = new RegistrationListener() {
        public void onRegistrationSuccessful(BridgefyClient bridgefyClient) {
            String f = BridgefyService.f9519d;
            StringBuilder sb = new StringBuilder();
            sb.append("onRegistrationSuccessful: current userId is: ");
            sb.append(bridgefyClient.getUserUuid());
            Log.i(f, sb.toString());
            final Editor edit = BridgefyService.this.f9523a.edit();
            edit.putString("advertising", bridgefyClient.getDeviceProfile().getDeviceEvaluation());
            C3519c.m10313a((C3521a) new C3521a() {
                public void onError(Throwable th) {
                    th.printStackTrace();
                    edit.putBoolean("pendingKeyUpload", true).apply();
                }
            });
            edit.putString("secretKey", bridgefyClient.getSecretKey()).apply();
            edit.apply();
            Logger.init(BridgefyService.this.getBaseContext(), true);
            BridgefyService.this.f9527g = new Builder().setEnergyProfile(BFEnergyProfile.HIGH_PERFORMANCE).setAntennaType(Antenna.BLUETOOTH_LE).setEngineProfile(BFEngineProfile.BFConfigProfileNoFowarding).build();
            C3608c.m10646a(true);
            if (C3608c.m10652e()) {
                BridgefyService.this.onOttoEvent("command.services.start");
            } else {
                Log.v(BridgefyService.f9519d, "Bridgefy SDK registration succeeded. Will wait for a login to start.");
            }
        }

        public void onRegistrationFailed(int i, String str) {
            String f = BridgefyService.f9519d;
            StringBuilder sb = new StringBuilder();
            sb.append("onRegistrationFailed: failed with ERROR_CODE: ");
            sb.append(i);
            sb.append(", MESSAGE: ");
            sb.append(str);
            Log.e(f, sb.toString());
            switch (i) {
                case -2:
                    Toast.makeText(BridgefyService.this, BridgefyService.this.getString(R.string.error_registration_ce), 1).show();
                    return;
                case -1:
                    Toast.makeText(BridgefyService.this, BridgefyService.this.getString(R.string.error_registration_network), 1).show();
                    return;
                default:
                    Toast.makeText(BridgefyService.this, String.format(BridgefyService.this.getString(R.string.bridgefy_registration_fail), new Object[]{Integer.valueOf(i)}), 1).show();
                    return;
            }
        }
    };

    /* renamed from: e */
    private final String f9525e = BridgefyCore.PREFS_NAME;

    /* renamed from: f */
    private C3630a f9526f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Config f9527g;

    /* renamed from: i */
    private C3613b f9528i;

    /* renamed from: j */
    private Handler f9529j;

    /* renamed from: k */
    private final IBinder f9530k = new C3612a();

    /* renamed from: m */
    private C3549b f9531m;

    /* renamed from: me.bridgefy.service.BridgefyService$a */
    public class C3612a extends Binder {
        public C3612a() {
        }
    }

    /* renamed from: me.bridgefy.service.BridgefyService$b */
    private class C3613b implements Runnable {

        /* renamed from: a */
        BFEnergyProfile f9536a;

        private C3613b(BFEnergyProfile bFEnergyProfile) {
            this.f9536a = bFEnergyProfile;
        }

        public void run() {
            if (C3608c.m10651d()) {
                Bridgefy.setEnergyProfile(this.f9536a);
            }
        }
    }

    /* renamed from: a */
    public static void m10660a(String str, byte[] bArr) {
        f9522n.put(str, bArr);
    }

    /* renamed from: a */
    public static byte[] m10662a(String str) {
        byte[] bArr = (byte[]) f9522n.get(str);
        f9522n.remove(str);
        return bArr;
    }

    public IBinder onBind(Intent intent) {
        return this.f9530k;
    }

    public void onCreate() {
        Log.i(f9519d, "onCreate()");
        super.onCreate();
        f9518b = true;
        this.f9523a = getApplicationContext().getSharedPreferences("BgfyPrefs", 0);
        this.f9529j = new Handler();
        C3517a.m10259a(getApplicationContext());
        m10668g();
        this.f9531m = new C3549b(getApplicationContext(), m10665d());
        if (BridgefyApp.m10557c().mo29530g() != null) {
            BridgefyApp.m10557c().mo29530g().mo27385a((Object) this);
        }
    }

    /* renamed from: g */
    private void m10668g() {
        if (getHelper() != null && m10665d() == null) {
            m10661a((DatabaseHelper) getHelper());
            f9520h = (DatabaseHelper) getHelper();
            Log.d(f9519d, "Configuring the databaseHelper");
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        m10668g();
        if (!(intent == null || intent.getAction() == null)) {
            String str = f9519d;
            StringBuilder sb = new StringBuilder();
            sb.append("onStartCommand() [action: ");
            sb.append(intent.getAction());
            sb.append("]");
            Log.d(str, sb.toString());
            String action = intent.getAction();
            char c = 65535;
            switch (action.hashCode()) {
                case -1208673227:
                    if (action.equals("me.bridgefy.main.service.foreground")) {
                        c = 2;
                        break;
                    }
                    break;
                case -230356960:
                    if (action.equals("me.bridgefy.main.service.background")) {
                        c = 1;
                        break;
                    }
                    break;
                case 524241044:
                    if (action.equals("command.bridgefy.init_reg")) {
                        c = 4;
                        break;
                    }
                    break;
                case 763235700:
                    if (action.equals("onlinePackageReceived")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1649956980:
                    if (action.equals("me.bridgefy.main.service.stop")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    C3622b.m10715a(getBaseContext(), m10665d()).mo29658a(intent, (Context) this, m10665d());
                    break;
                case 1:
                    m10669h();
                    if (C3608c.m10651d()) {
                        m10664c(intent.getAction());
                        break;
                    }
                    break;
                case 2:
                    m10670i();
                    if (!C3608c.m10651d()) {
                        onOttoEvent("command.services.start");
                        break;
                    } else {
                        m10664c(intent.getAction());
                        break;
                    }
                case 3:
                    if (C3608c.m10651d()) {
                        m10670i();
                        onOttoEvent("command.services.stop");
                        break;
                    }
                    break;
                case 4:
                    String stringExtra = intent.getStringExtra("userId");
                    if (stringExtra == null) {
                        Log.e(f9519d, "Impossible to initialize the Bridgefy SDK: Seeded userId was null!");
                        break;
                    } else {
                        String str2 = f9519d;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("... Requesting SDK initialization with uuid: ");
                        sb2.append(stringExtra);
                        Log.d(str2, sb2.toString());
                        C3660a.m10913a("initialize").mo29822a(Bridgefy.class).mo29825a(this, null, this.f9524c, UUID.fromString(stringExtra)).mo29824a((Class<?>[]) new Class[]{Context.class, String.class, RegistrationListener.class, UUID.class}).mo29821a();
                        break;
                    }
            }
        }
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        String str = f9519d;
        StringBuilder sb = new StringBuilder();
        sb.append("onTaskRemoved: the app was stopped ");
        sb.append(intent.getAction());
        Log.w(str, sb.toString());
        try {
            onOttoEvent("command.services.stop");
            m10670i();
        } catch (IllegalStateException unused) {
            Log.w(f9519d, "... Bridgefy SDK wasn't stopped because it hadn't been initialized.");
        }
    }

    public void onDestroy() {
        Log.w(f9519d, "onDestroy()");
        mo29637c();
        if (C3608c.m10651d()) {
            onOttoEvent("command.services.stop");
        }
        this.f9531m = null;
        f9518b = false;
        BridgefyApp.m10557c().mo29530g().mo27388b((Object) this);
        super.onDestroy();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @com.squareup.p131a.C3017h
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onOttoEvent(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = f9519d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onOttoEvent: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
            int r0 = r4.hashCode()
            r1 = 1340464085(0x4fe5dbd5, float:7.7127788E9)
            if (r0 == r1) goto L_0x003e
            r1 = 1982903855(0x7630b62f, float:8.9603454E32)
            if (r0 == r1) goto L_0x0034
            r1 = 2088248401(0x7c782451, float:5.1537048E36)
            if (r0 == r1) goto L_0x002a
            goto L_0x0048
        L_0x002a:
            java.lang.String r0 = "signOut"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0048
            r4 = 1
            goto L_0x0049
        L_0x0034:
            java.lang.String r0 = "command.services.stop"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0048
            r4 = 2
            goto L_0x0049
        L_0x003e:
            java.lang.String r0 = "command.services.start"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0048
            r4 = 0
            goto L_0x0049
        L_0x0048:
            r4 = -1
        L_0x0049:
            switch(r4) {
                case 0: goto L_0x006b;
                case 1: goto L_0x004d;
                case 2: goto L_0x0059;
                default: goto L_0x004c;
            }
        L_0x004c:
            goto L_0x00bb
        L_0x004d:
            r4 = 0
            f9520h = r4
            r3.m10670i()
            r3.stopSelf()
            r3.mo29635a()
        L_0x0059:
            com.bridgefy.sdk.client.Bridgefy.stop()
            r3.mo29637c()
            me.bridgefy.main.BridgefyApp r4 = p140me.bridgefy.main.BridgefyApp.m10557c()
            android.content.Context r4 = r4.getApplicationContext()
            p140me.bridgefy.utils.C3659b.m10890a(r4)
            goto L_0x00bb
        L_0x006b:
            boolean r4 = p140me.bridgefy.main.C3608c.m10649b()
            if (r4 == 0) goto L_0x00b4
            boolean r4 = p140me.bridgefy.main.C3608c.m10651d()
            if (r4 != 0) goto L_0x00ac
            me.bridgefy.integration.b r4 = r3.f9531m
            if (r4 != 0) goto L_0x008b
            me.bridgefy.integration.b r4 = new me.bridgefy.integration.b
            android.content.Context r0 = r3.getApplicationContext()
            me.bridgefy.ormlite.DatabaseHelper r1 = m10665d()
            r4.<init>(r0, r1)
            r3.f9531m = r4
            goto L_0x0094
        L_0x008b:
            me.bridgefy.integration.b r4 = r3.f9531m
            me.bridgefy.ormlite.DatabaseHelper r0 = m10665d()
            r4.mo29429a(r0)
        L_0x0094:
            me.bridgefy.integration.b r4 = r3.f9531m
            me.bridgefy.integration.a r0 = new me.bridgefy.integration.a
            android.content.Context r1 = r3.getApplicationContext()
            me.bridgefy.ormlite.DatabaseHelper r2 = m10665d()
            r0.<init>(r1, r2)
            com.bridgefy.sdk.client.Config r1 = r3.f9527g
            com.bridgefy.sdk.client.Bridgefy.start(r4, r0, r1)
            r3.mo29636b()
            goto L_0x00bb
        L_0x00ac:
            java.lang.String r4 = f9519d
            java.lang.String r0 = "Bridgefy already started. Won't restart."
            android.util.Log.w(r4, r0)
            goto L_0x00bb
        L_0x00b4:
            java.lang.String r4 = f9519d
            java.lang.String r0 = "COMMAND_BRIDGEFY_START was called without a successful registration."
            android.util.Log.w(r4, r0)
        L_0x00bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p140me.bridgefy.service.BridgefyService.onOttoEvent(java.lang.String):void");
    }

    /* renamed from: a */
    public void mo29635a() {
        this.f9531m.mo29430b();
        getSharedPreferences(BridgefyCore.PREFS_NAME, 0).edit().clear().apply();
        C3608c.m10646a(false);
    }

    /* renamed from: b */
    public void mo29636b() {
        if (this.f9526f == null) {
            Log.d(f9519d, "Registering BridgefyBroadcastReceiver.");
            this.f9526f = new C3630a((DatabaseHelper) getHelper());
            registerReceiver(this.f9526f, this.f9526f.mo29678a());
        }
    }

    /* renamed from: c */
    public void mo29637c() {
        if (this.f9526f != null) {
            unregisterReceiver(this.f9526f);
            this.f9526f = null;
            Log.d(f9519d, "Unregistering BridgefyBroadcastReceiver.");
        }
    }

    /* renamed from: a */
    private void m10661a(DatabaseHelper databaseHelper) {
        try {
            databaseHelper.getFriendDAO().countOf();
        } catch (SQLException | SQLiteException e) {
            if (e.getMessage().contains("file is encrypted")) {
                DataBaseUtils.dropDataBase(getApplicationContext());
            }
            String str = f9519d;
            StringBuilder sb = new StringBuilder();
            sb.append("SQLiteException: ");
            sb.append(e.getMessage());
            Log.e(str, sb.toString());
        }
    }

    /* renamed from: d */
    public static DatabaseHelper m10665d() {
        return f9520h;
    }

    /* renamed from: e */
    public static synchronized String m10666e() {
        String str;
        synchronized (BridgefyService.class) {
            str = f9521l;
        }
        return str;
    }

    /* renamed from: b */
    public static void m10663b(String str) {
        f9521l = str;
    }

    /* renamed from: c */
    private void m10664c(String str) {
        if (C3608c.m10651d()) {
            char c = 65535;
            try {
                int hashCode = str.hashCode();
                if (hashCode != -1208673227) {
                    if (hashCode == -230356960) {
                        if (str.equals("me.bridgefy.main.service.background")) {
                            c = 0;
                        }
                    }
                } else if (str.equals("me.bridgefy.main.service.foreground")) {
                    c = 1;
                }
                switch (c) {
                    case 0:
                        Bridgefy.setEnergyProfile(BFEnergyProfile.BALANCED);
                        m10659a(BFEnergyProfile.ENERGY_SAVER);
                        return;
                    case 1:
                        Bridgefy.setEnergyProfile(BFEnergyProfile.HIGH_PERFORMANCE);
                        m10659a(BFEnergyProfile.BALANCED);
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m10659a(BFEnergyProfile bFEnergyProfile) {
        this.f9529j.removeCallbacks(this.f9528i);
        C3613b bVar = new C3613b(bFEnergyProfile);
        this.f9529j.postDelayed(bVar, 120000);
        this.f9528i = bVar;
    }

    /* renamed from: h */
    private void m10669h() {
        Intent intent = new Intent(this, TabbedMainActivity.class);
        intent.setAction("me.bridgefy.main.service.foreground");
        intent.setFlags(268468224);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 0);
        Intent intent2 = new Intent(this, BridgefyService.class);
        intent2.setAction("me.bridgefy.main.service.stop");
        startForeground(555, new C0857c(this, "bridgefy_channel").mo3490a((CharSequence) getString(R.string.app_name)).mo3500c((CharSequence) getString(R.string.app_name)).mo3496b((CharSequence) getString(R.string.foreground_notification_content_title)).mo3481a((int) R.drawable.bf).mo3487a(((BitmapDrawable) BridgefyApp.m10557c().getDrawable(R.drawable.icon_40)).getBitmap()).mo3486a(activity).mo3492a(true).mo3484a(17301560, (CharSequence) getString(R.string.foreground_notification_action_stop), PendingIntent.getService(this, 0, intent2, 0)).mo3493b());
    }

    /* renamed from: i */
    private void m10670i() {
        if (VERSION.SDK_INT >= 24) {
            stopForeground(1);
        } else {
            stopForeground(true);
        }
    }
}
