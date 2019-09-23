package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.view.ViewConfiguration;
import androidx.appcompat.R;

/* renamed from: androidx.appcompat.view.a */
/* compiled from: ActionBarPolicy */
public class C0504a {

    /* renamed from: a */
    private Context f1212a;

    /* renamed from: a */
    public static C0504a m1633a(Context context) {
        return new C0504a(context);
    }

    private C0504a(Context context) {
        this.f1212a = context;
    }

    /* renamed from: a */
    public int mo1242a() {
        Configuration configuration = this.f1212a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600 || ((i > 960 && i2 > 720) || (i > 720 && i2 > 960))) {
            return 5;
        }
        if (i >= 500 || ((i > 640 && i2 > 480) || (i > 480 && i2 > 640))) {
            return 4;
        }
        return i >= 360 ? 3 : 2;
    }

    /* renamed from: b */
    public boolean mo1243b() {
        if (VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f1212a).hasPermanentMenuKey();
    }

    /* renamed from: c */
    public int mo1244c() {
        return this.f1212a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    /* renamed from: d */
    public boolean mo1245d() {
        return this.f1212a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    /* renamed from: e */
    public int mo1246e() {
        TypedArray obtainStyledAttributes = this.f1212a.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0);
        Resources resources = this.f1212a.getResources();
        if (!mo1245d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    /* renamed from: f */
    public boolean mo1247f() {
        return this.f1212a.getApplicationInfo().targetSdkVersion < 14;
    }

    /* renamed from: g */
    public int mo1248g() {
        return this.f1212a.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }
}
