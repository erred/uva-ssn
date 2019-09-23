package androidx.appcompat.widget;

import android.os.Build.VERSION;
import android.view.View;

/* renamed from: androidx.appcompat.widget.ax */
/* compiled from: TooltipCompat */
public class C0649ax {
    /* renamed from: a */
    public static void m2296a(View view, CharSequence charSequence) {
        if (VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            C0650ay.m2297a(view, charSequence);
        }
    }
}
