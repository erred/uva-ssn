package p140me.bridgefy.service.p147d;

import android.content.Context;
import android.util.Log;
import com.bridgefy.sdk.client.Bridgefy;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.p141a.C3455a;
import p140me.bridgefy.p141a.C3457c;
import p140me.bridgefy.p141a.C3460d;

@Deprecated
/* renamed from: me.bridgefy.service.d.c */
/* compiled from: WifiBaseManager */
abstract class C3629c {

    /* renamed from: a */
    private DatabaseHelper f9575a;

    /* renamed from: b */
    private Context f9576b;

    /* renamed from: c */
    String f9577c;

    /* renamed from: d */
    C3457c f9578d;

    /* renamed from: e */
    C3460d f9579e;

    /* renamed from: f */
    C3455a f9580f;

    public C3629c(Context context, DatabaseHelper databaseHelper) {
        this.f9576b = context;
        this.f9575a = databaseHelper;
        try {
            this.f9577c = Bridgefy.getInstance().getBridgefyClient().getSecretKey();
        } catch (IllegalStateException unused) {
            Log.w("OnlineManager", "Bridgefy has not been initialized. Using stored secret key.");
            this.f9577c = context.getSharedPreferences("BgfyPrefs", 0).getString("secretKey", null);
        }
        this.f9578d = new C3457c(databaseHelper);
        this.f9580f = new C3455a(databaseHelper);
        this.f9579e = new C3460d(databaseHelper);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Context mo29676c() {
        return this.f9576b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public DatabaseHelper mo29677d() {
        return this.f9575a;
    }
}
