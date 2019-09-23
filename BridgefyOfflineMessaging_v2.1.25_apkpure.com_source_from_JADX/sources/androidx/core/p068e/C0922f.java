package androidx.core.p068e;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

/* renamed from: androidx.core.e.f */
/* compiled from: TextUtilsCompat */
public final class C0922f {

    /* renamed from: a */
    private static final Locale f2945a = new Locale("", "");

    /* renamed from: a */
    public static int m3389a(Locale locale) {
        if (VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale != null && !locale.equals(f2945a)) {
            String a = C0910b.m3366a(locale);
            if (a == null) {
                return m3390b(locale);
            }
            if (a.equalsIgnoreCase("Arab") || a.equalsIgnoreCase("Hebr")) {
                return 1;
            }
        }
        return 0;
    }

    /* renamed from: b */
    private static int m3390b(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case 1:
            case 2:
                return 1;
            default:
                return 0;
        }
    }
}
