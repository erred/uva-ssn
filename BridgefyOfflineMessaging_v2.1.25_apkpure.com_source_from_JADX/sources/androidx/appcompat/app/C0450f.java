package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.appcompat.app.C0444b.C0445a;
import androidx.appcompat.view.C0505b;
import androidx.appcompat.view.C0505b.C0506a;
import androidx.appcompat.widget.Toolbar;

/* renamed from: androidx.appcompat.app.f */
/* compiled from: AppCompatDelegate */
public abstract class C0450f {

    /* renamed from: a */
    private static int f976a = -1;

    /* renamed from: a */
    public abstract <T extends View> T mo967a(int i);

    /* renamed from: a */
    public abstract C0440a mo968a();

    /* renamed from: a */
    public abstract C0505b mo969a(C0506a aVar);

    /* renamed from: a */
    public abstract void mo970a(Configuration configuration);

    /* renamed from: a */
    public abstract void mo971a(Bundle bundle);

    /* renamed from: a */
    public abstract void mo972a(View view);

    /* renamed from: a */
    public abstract void mo973a(View view, LayoutParams layoutParams);

    /* renamed from: a */
    public abstract void mo974a(Toolbar toolbar);

    /* renamed from: a */
    public abstract void mo975a(CharSequence charSequence);

    /* renamed from: b */
    public abstract MenuInflater mo976b();

    /* renamed from: b */
    public abstract void mo977b(int i);

    /* renamed from: b */
    public abstract void mo978b(Bundle bundle);

    /* renamed from: b */
    public abstract void mo979b(View view, LayoutParams layoutParams);

    /* renamed from: c */
    public abstract void mo980c();

    /* renamed from: c */
    public abstract void mo981c(Bundle bundle);

    /* renamed from: c */
    public abstract boolean mo982c(int i);

    /* renamed from: d */
    public abstract void mo983d();

    /* renamed from: e */
    public abstract void mo984e();

    /* renamed from: f */
    public abstract void mo985f();

    /* renamed from: g */
    public abstract void mo986g();

    /* renamed from: h */
    public abstract C0445a mo987h();

    /* renamed from: i */
    public abstract void mo988i();

    /* renamed from: j */
    public abstract boolean mo989j();

    /* renamed from: a */
    public static C0450f m1333a(Activity activity, C0449e eVar) {
        return new C0451g(activity, activity.getWindow(), eVar);
    }

    /* renamed from: a */
    public static C0450f m1334a(Dialog dialog, C0449e eVar) {
        return new C0451g(dialog.getContext(), dialog.getWindow(), eVar);
    }

    C0450f() {
    }

    /* renamed from: k */
    public static int m1335k() {
        return f976a;
    }
}
