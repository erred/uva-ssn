package androidx.constraintlayout.p057a.p059b;

import android.view.View;

/* renamed from: androidx.constraintlayout.a.b.a */
/* compiled from: Debug */
public class C0755a {
    /* renamed from: a */
    public static String m2696a(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }
}
