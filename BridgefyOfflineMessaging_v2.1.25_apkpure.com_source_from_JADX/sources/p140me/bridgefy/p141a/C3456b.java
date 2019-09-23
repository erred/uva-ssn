package p140me.bridgefy.p141a;

import android.app.Activity;
import android.content.Context;
import java.io.File;
import net.sqlcipher.database.SQLiteException;
import p140me.bridgefy.main.BridgefyApp;
import p140me.bridgefy.ormlite.DatabaseHelper;
import p140me.bridgefy.ormlite.apptools.BridgefyOrmLiteBaseActivity;
import p140me.bridgefy.ormlite.exception.OrmLiteBridgefyException;

/* renamed from: me.bridgefy.a.b */
/* compiled from: DataBaseController */
class C3456b {

    /* renamed from: a */
    private BridgefyOrmLiteBaseActivity<DatabaseHelper> f8955a;

    /* renamed from: b */
    private DatabaseHelper f8956b;

    C3456b(Activity activity) throws OrmLiteBridgefyException {
        if (activity instanceof BridgefyOrmLiteBaseActivity) {
            this.f8955a = (BridgefyOrmLiteBaseActivity) activity;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Could not activity instance of BridgefyOrmLiteBaseActivity class ");
        sb.append(activity.getClass());
        throw new OrmLiteBridgefyException(sb.toString());
    }

    C3456b(DatabaseHelper databaseHelper) {
        this.f8956b = databaseHelper;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public DatabaseHelper mo28313a() {
        boolean z = false;
        boolean z2 = this.f8955a != null;
        if (this.f8956b == null) {
            z = true;
        }
        if (z2 && z) {
            this.f8956b = (DatabaseHelper) this.f8955a.getHelper();
        }
        return this.f8956b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28314a(SQLiteException sQLiteException) {
        if (sQLiteException.getMessage().indexOf("file is encrypted or is not a database") != -1) {
            Context applicationContext = BridgefyApp.m10557c().getApplicationContext();
            String path = applicationContext.getDatabasePath(DatabaseHelper.DATABASE_NAME).getPath();
            applicationContext.deleteDatabase(DatabaseHelper.DATABASE_NAME);
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
