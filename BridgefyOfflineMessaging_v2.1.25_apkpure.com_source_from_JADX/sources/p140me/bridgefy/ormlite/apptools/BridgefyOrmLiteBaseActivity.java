package p140me.bridgefy.ormlite.apptools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.C0448d;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import me.bridgefy.main.R;
import net.sqlcipher.database.SQLiteDatabase;
import p140me.bridgefy.intro.SplashActivity;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.main.C3608c;
import p140me.bridgefy.service.BridgefyService;
import p140me.bridgefy.utils.C3657a.C3658a;
import p140me.bridgefy.utils.C3659b;

/* renamed from: me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity */
public abstract class BridgefyOrmLiteBaseActivity<H extends OrmLiteSqliteOpenHelper> extends C0448d implements C3658a {
    private static Logger logger = LoggerFactory.getLogger(BridgefyOrmLiteBaseActivity.class);
    private final String TAG = "BridgefyBaseActivity";
    public BroadcastReceiver bridgefyBaseActivityReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (((action.hashCode() == 2088248401 && action.equals("signOut")) ? (char) 0 : 65535) == 0) {
                switch (intent.getExtras().getInt("signoutType")) {
                    case 1:
                        Toast.makeText(BridgefyOrmLiteBaseActivity.this.getApplicationContext(), BridgefyOrmLiteBaseActivity.this.getString(R.string.bridgefy_signed_out), 0).show();
                        break;
                    case 2:
                        Toast.makeText(BridgefyOrmLiteBaseActivity.this.getApplicationContext(), BridgefyOrmLiteBaseActivity.this.getString(R.string.bridgefy_been_signed_out), 0).show();
                        break;
                    case 3:
                        Toast.makeText(BridgefyOrmLiteBaseActivity.this.getApplicationContext(), BridgefyOrmLiteBaseActivity.this.getString(R.string.error_try_again), 0).show();
                        break;
                }
                BridgefyOrmLiteBaseActivity.this.startActivity(new Intent(BridgefyOrmLiteBaseActivity.this.getApplicationContext(), SplashActivity.class).addFlags(268468224));
                BridgefyOrmLiteBaseActivity.this.finish();
            }
        }
    };
    private volatile boolean created = false;
    private volatile boolean destroyed = false;
    private volatile H helper;
    /* access modifiers changed from: protected */
    public SharedPreferences settings;
    private boolean stateSaved = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SQLiteDatabase.loadLibs(this);
        if (this.helper == null) {
            this.helper = getHelperInternal(this);
            this.created = true;
        }
        this.settings = getBaseContext().getSharedPreferences("BgfyPrefs", 0);
        if (C3608c.m10652e() && !BridgefyService.f9518b) {
            Log.w("BridgefyBaseActivity", "Bridgefy Service was not running. Starting now.");
            startService(new Intent(getApplicationContext(), BridgefyService.class));
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.stateSaved = false;
        registerReceiver(this.bridgefyBaseActivityReceiver, new IntentFilter("signOut"));
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.stateSaved = true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            unregisterReceiver(this.bridgefyBaseActivityReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        releaseHelper(this.helper);
        this.destroyed = true;
        super.onDestroy();
    }

    public H getHelper() {
        if (this.helper != null) {
            return this.helper;
        }
        if (!this.created) {
            throw new IllegalStateException("A call has not been made to onCreate() yet so the helper is null");
        } else if (this.destroyed) {
            throw new IllegalStateException("A call to onDestroy has already been made and the helper cannot be used after that point");
        } else {
            throw new IllegalStateException("Helper is null for some unknown reason");
        }
    }

    public void onAntennaeDelegate(boolean z) {
        if (z) {
            C3659b.m10892a(BridgefyApp.m10557c().getApplicationContext(), true);
        }
    }

    /* access modifiers changed from: protected */
    public H getHelperInternal(Context context) {
        H helper2 = OpenHelperManager.getHelper(context);
        logger.trace("{}: got new helper {} from OpenHelperManager", (Object) this, (Object) helper2);
        return helper2;
    }

    /* access modifiers changed from: protected */
    public void releaseHelper(H h) {
        OpenHelperManager.releaseHelper();
        logger.trace("{}: helper {} was released, set to null", (Object) this, (Object) h);
        this.helper = null;
    }

    public SharedPreferences getSettings() {
        return this.settings;
    }

    public boolean isStateSaved() {
        return this.stateSaved;
    }
}
