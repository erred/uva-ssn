package androidx.browser.p053a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.C0848c;
import androidx.core.content.C0875a;
import java.util.ArrayList;

/* renamed from: androidx.browser.a.a */
/* compiled from: CustomTabsIntent */
public final class C0731a {

    /* renamed from: a */
    public final Intent f2103a;

    /* renamed from: b */
    public final Bundle f2104b;

    /* renamed from: androidx.browser.a.a$a */
    /* compiled from: CustomTabsIntent */
    public static final class C0732a {

        /* renamed from: a */
        private final Intent f2105a;

        /* renamed from: b */
        private ArrayList<Bundle> f2106b;

        /* renamed from: c */
        private Bundle f2107c;

        /* renamed from: d */
        private ArrayList<Bundle> f2108d;

        /* renamed from: e */
        private boolean f2109e;

        public C0732a() {
            this(null);
        }

        public C0732a(C0733b bVar) {
            this.f2105a = new Intent("android.intent.action.VIEW");
            IBinder iBinder = null;
            this.f2106b = null;
            this.f2107c = null;
            this.f2108d = null;
            this.f2109e = true;
            if (bVar != null) {
                this.f2105a.setPackage(bVar.mo2913b().getPackageName());
            }
            Bundle bundle = new Bundle();
            String str = "android.support.customtabs.extra.SESSION";
            if (bVar != null) {
                iBinder = bVar.mo2912a();
            }
            C0848c.m3108a(bundle, str, iBinder);
            this.f2105a.putExtras(bundle);
        }

        /* renamed from: a */
        public C0732a mo2909a(int i) {
            this.f2105a.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", i);
            return this;
        }

        /* renamed from: a */
        public C0732a mo2910a(boolean z) {
            this.f2105a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z ? 1 : 0);
            return this;
        }

        /* renamed from: a */
        public C0731a mo2911a() {
            if (this.f2106b != null) {
                this.f2105a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", this.f2106b);
            }
            if (this.f2108d != null) {
                this.f2105a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", this.f2108d);
            }
            this.f2105a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f2109e);
            return new C0731a(this.f2105a, this.f2107c);
        }
    }

    /* renamed from: a */
    public void mo2908a(Context context, Uri uri) {
        this.f2103a.setData(uri);
        C0875a.m3241a(context, this.f2103a, this.f2104b);
    }

    C0731a(Intent intent, Bundle bundle) {
        this.f2103a = intent;
        this.f2104b = bundle;
    }
}
