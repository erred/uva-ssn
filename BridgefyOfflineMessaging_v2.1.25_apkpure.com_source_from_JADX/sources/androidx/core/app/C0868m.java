package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.C0875a;
import java.util.ArrayList;
import java.util.Iterator;
import net.sqlcipher.database.SQLiteDatabase;

/* renamed from: androidx.core.app.m */
/* compiled from: TaskStackBuilder */
public final class C0868m implements Iterable<Intent> {

    /* renamed from: a */
    private final ArrayList<Intent> f2822a = new ArrayList<>();

    /* renamed from: b */
    private final Context f2823b;

    /* renamed from: androidx.core.app.m$a */
    /* compiled from: TaskStackBuilder */
    public interface C0869a {
        Intent getSupportParentActivityIntent();
    }

    private C0868m(Context context) {
        this.f2823b = context;
    }

    /* renamed from: a */
    public static C0868m m3217a(Context context) {
        return new C0868m(context);
    }

    /* renamed from: a */
    public C0868m mo3544a(Intent intent) {
        this.f2822a.add(intent);
        return this;
    }

    /* renamed from: a */
    public C0868m mo3542a(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof C0869a ? ((C0869a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = C0852e.m3111a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f2823b.getPackageManager());
            }
            mo3543a(component);
            mo3544a(supportParentActivityIntent);
        }
        return this;
    }

    /* renamed from: a */
    public C0868m mo3543a(ComponentName componentName) {
        int size = this.f2822a.size();
        try {
            Intent a = C0852e.m3112a(this.f2823b, componentName);
            while (a != null) {
                this.f2822a.add(size, a);
                a = C0852e.m3112a(this.f2823b, a.getComponent());
            }
            return this;
        } catch (NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f2822a.iterator();
    }

    /* renamed from: a */
    public void mo3545a() {
        mo3546a((Bundle) null);
    }

    /* renamed from: a */
    public void mo3546a(Bundle bundle) {
        if (!this.f2822a.isEmpty()) {
            Intent[] intentArr = (Intent[]) this.f2822a.toArray(new Intent[this.f2822a.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!C0875a.m3242a(this.f2823b, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.f2823b.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
