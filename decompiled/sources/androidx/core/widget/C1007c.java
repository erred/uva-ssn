package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* renamed from: androidx.core.widget.c */
/* compiled from: CompoundButtonCompat */
public final class C1007c {

    /* renamed from: a */
    private static Field f3147a;

    /* renamed from: b */
    private static boolean f3148b;

    /* renamed from: a */
    public static void m3844a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintList(colorStateList);
        } else if (compoundButton instanceof C1015j) {
            ((C1015j) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    /* renamed from: a */
    public static ColorStateList m3843a(CompoundButton compoundButton) {
        if (VERSION.SDK_INT >= 21) {
            return compoundButton.getButtonTintList();
        }
        if (compoundButton instanceof C1015j) {
            return ((C1015j) compoundButton).getSupportButtonTintList();
        }
        return null;
    }

    /* renamed from: a */
    public static void m3845a(CompoundButton compoundButton, Mode mode) {
        if (VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintMode(mode);
        } else if (compoundButton instanceof C1015j) {
            ((C1015j) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    /* renamed from: b */
    public static Drawable m3846b(CompoundButton compoundButton) {
        if (VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!f3148b) {
            try {
                f3147a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f3147a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
            }
            f3148b = true;
        }
        if (f3147a != null) {
            try {
                return (Drawable) f3147a.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                f3147a = null;
            }
        }
        return null;
    }
}
