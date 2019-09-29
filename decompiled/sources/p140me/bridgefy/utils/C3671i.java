package p140me.bridgefy.utils;

import android.content.Context;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.p113c.p114a.p115a.C1947b;
import net.sqlcipher.database.SQLiteDatabase;

/* renamed from: me.bridgefy.utils.i */
/* compiled from: MessagingExtensionBase */
public abstract class C3671i<H extends OrmLiteSqliteOpenHelper> extends C1947b {

    /* renamed from: a */
    private volatile H f9706a;

    /* renamed from: b */
    private volatile boolean f9707b = false;

    /* renamed from: c */
    private volatile boolean f9708c = false;

    public void onCreate() {
        SQLiteDatabase.loadLibs(getApplicationContext());
        if (this.f9706a == null) {
            this.f9706a = mo29843a((Context) this);
            this.f9707b = true;
        }
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
        mo29844a(this.f9706a);
        this.f9708c = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public H mo29843a(Context context) {
        return OpenHelperManager.getHelper(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29844a(H h) {
        OpenHelperManager.releaseHelper();
        this.f9706a = null;
    }
}
