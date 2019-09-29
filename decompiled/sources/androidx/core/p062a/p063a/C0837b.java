package androidx.core.p062a.p063a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.MenuItem;
import android.view.View;
import androidx.core.p070g.C0943b;

/* renamed from: androidx.core.a.a.b */
/* compiled from: SupportMenuItem */
public interface C0837b extends MenuItem {
    /* renamed from: a */
    C0837b mo1351a(C0943b bVar);

    /* renamed from: a */
    C0837b mo1352a(CharSequence charSequence);

    /* renamed from: a */
    C0943b mo1353a();

    /* renamed from: b */
    C0837b mo1355b(CharSequence charSequence);

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    int getAlphabeticModifiers();

    CharSequence getContentDescription();

    ColorStateList getIconTintList();

    Mode getIconTintMode();

    int getNumericModifiers();

    CharSequence getTooltipText();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    MenuItem setAlphabeticShortcut(char c, int i);

    MenuItem setIconTintList(ColorStateList colorStateList);

    MenuItem setIconTintMode(Mode mode);

    MenuItem setNumericShortcut(char c, int i);

    MenuItem setShortcut(char c, char c2, int i, int i2);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);
}
