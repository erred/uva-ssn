package p140me.bridgefy.ormlite.service;

import com.j256.ormlite.android.apptools.OrmLiteBaseService;
import net.sqlcipher.database.SQLiteDatabase;
import p140me.bridgefy.ormlite.DatabaseHelper;

/* renamed from: me.bridgefy.ormlite.service.BridgefyORMLiteService */
public abstract class BridgefyORMLiteService extends OrmLiteBaseService<DatabaseHelper> {
    public void onCreate() {
        SQLiteDatabase.loadLibs(getApplicationContext());
        super.onCreate();
    }
}
