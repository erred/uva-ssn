package androidx.core.p070g;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.MenuItem;
import androidx.core.p062a.p063a.C0837b;

/* renamed from: androidx.core.g.g */
/* compiled from: MenuItemCompat */
public final class C0951g {
    /* renamed from: a */
    public static MenuItem m3506a(MenuItem menuItem, C0943b bVar) {
        if (menuItem instanceof C0837b) {
            return ((C0837b) menuItem).mo1351a(bVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    /* renamed from: a */
    public static void m3510a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof C0837b) {
            ((C0837b) menuItem).mo1352a(charSequence);
        } else if (VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    /* renamed from: b */
    public static void m3512b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof C0837b) {
            ((C0837b) menuItem).mo1355b(charSequence);
        } else if (VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }

    /* renamed from: a */
    public static void m3507a(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof C0837b) {
            ((C0837b) menuItem).setNumericShortcut(c, i);
        } else if (VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c, i);
        }
    }

    /* renamed from: b */
    public static void m3511b(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof C0837b) {
            ((C0837b) menuItem).setAlphabeticShortcut(c, i);
        } else if (VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c, i);
        }
    }

    /* renamed from: a */
    public static void m3508a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof C0837b) {
            ((C0837b) menuItem).setIconTintList(colorStateList);
        } else if (VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    /* renamed from: a */
    public static void m3509a(MenuItem menuItem, Mode mode) {
        if (menuItem instanceof C0837b) {
            ((C0837b) menuItem).setIconTintMode(mode);
        } else if (VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }
}
