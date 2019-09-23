package p000a.p001a.p002a.p003a.p004a.p011f;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import p000a.p001a.p002a.p003a.C0146i;

/* renamed from: a.a.a.a.a.f.d */
/* compiled from: PreferenceStoreImpl */
public class C0106d implements C0105c {

    /* renamed from: a */
    private final SharedPreferences f215a;

    /* renamed from: b */
    private final String f216b;

    /* renamed from: c */
    private final Context f217c;

    public C0106d(Context context, String str) {
        if (context != null) {
            this.f217c = context;
            this.f216b = str;
            this.f215a = this.f217c.getSharedPreferences(this.f216b, 0);
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    @Deprecated
    public C0106d(C0146i iVar) {
        this(iVar.mo320q(), iVar.getClass().getName());
    }

    /* renamed from: a */
    public SharedPreferences mo245a() {
        return this.f215a;
    }

    /* renamed from: b */
    public Editor mo247b() {
        return this.f215a.edit();
    }

    @TargetApi(9)
    /* renamed from: a */
    public boolean mo246a(Editor editor) {
        if (VERSION.SDK_INT < 9) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }
}
