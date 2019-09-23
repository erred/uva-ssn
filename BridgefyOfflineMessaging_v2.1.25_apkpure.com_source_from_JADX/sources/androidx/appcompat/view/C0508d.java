package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import androidx.appcompat.R;

/* renamed from: androidx.appcompat.view.d */
/* compiled from: ContextThemeWrapper */
public class C0508d extends ContextWrapper {

    /* renamed from: a */
    private int f1215a;

    /* renamed from: b */
    private Theme f1216b;

    /* renamed from: c */
    private LayoutInflater f1217c;

    /* renamed from: d */
    private Configuration f1218d;

    /* renamed from: e */
    private Resources f1219e;

    public C0508d() {
        super(null);
    }

    public C0508d(Context context, int i) {
        super(context);
        this.f1215a = i;
    }

    public C0508d(Context context, Theme theme) {
        super(context);
        this.f1216b = theme;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public Resources getResources() {
        return m1664b();
    }

    /* renamed from: b */
    private Resources m1664b() {
        if (this.f1219e == null) {
            if (this.f1218d == null) {
                this.f1219e = super.getResources();
            } else if (VERSION.SDK_INT >= 17) {
                this.f1219e = createConfigurationContext(this.f1218d).getResources();
            }
        }
        return this.f1219e;
    }

    public void setTheme(int i) {
        if (this.f1215a != i) {
            this.f1215a = i;
            m1665c();
        }
    }

    /* renamed from: a */
    public int mo1254a() {
        return this.f1215a;
    }

    public Theme getTheme() {
        if (this.f1216b != null) {
            return this.f1216b;
        }
        if (this.f1215a == 0) {
            this.f1215a = R.style.Theme_AppCompat_Light;
        }
        m1665c();
        return this.f1216b;
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1217c == null) {
            this.f1217c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1217c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1255a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    /* renamed from: c */
    private void m1665c() {
        boolean z = this.f1216b == null;
        if (z) {
            this.f1216b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1216b.setTo(theme);
            }
        }
        mo1255a(this.f1216b, this.f1215a, z);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}
