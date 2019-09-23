package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.C0875a;
import androidx.core.graphics.drawable.C0983a;
import androidx.core.p062a.p063a.C0837b;
import androidx.core.p070g.C0943b;

/* renamed from: androidx.appcompat.view.menu.a */
/* compiled from: ActionMenuItem */
public class C0520a implements C0837b {

    /* renamed from: a */
    private final int f1317a;

    /* renamed from: b */
    private final int f1318b;

    /* renamed from: c */
    private final int f1319c;

    /* renamed from: d */
    private final int f1320d;

    /* renamed from: e */
    private CharSequence f1321e;

    /* renamed from: f */
    private CharSequence f1322f;

    /* renamed from: g */
    private Intent f1323g;

    /* renamed from: h */
    private char f1324h;

    /* renamed from: i */
    private int f1325i = 4096;

    /* renamed from: j */
    private char f1326j;

    /* renamed from: k */
    private int f1327k = 4096;

    /* renamed from: l */
    private Drawable f1328l;

    /* renamed from: m */
    private int f1329m = 0;

    /* renamed from: n */
    private Context f1330n;

    /* renamed from: o */
    private OnMenuItemClickListener f1331o;

    /* renamed from: p */
    private CharSequence f1332p;

    /* renamed from: q */
    private CharSequence f1333q;

    /* renamed from: r */
    private ColorStateList f1334r = null;

    /* renamed from: s */
    private Mode f1335s = null;

    /* renamed from: t */
    private boolean f1336t = false;

    /* renamed from: u */
    private boolean f1337u = false;

    /* renamed from: v */
    private int f1338v = 16;

    /* renamed from: a */
    public C0943b mo1353a() {
        return null;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public View getActionView() {
        return null;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public void setShowAsAction(int i) {
    }

    public C0520a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f1330n = context;
        this.f1317a = i2;
        this.f1318b = i;
        this.f1319c = i3;
        this.f1320d = i4;
        this.f1321e = charSequence;
    }

    public char getAlphabeticShortcut() {
        return this.f1326j;
    }

    public int getAlphabeticModifiers() {
        return this.f1327k;
    }

    public int getGroupId() {
        return this.f1318b;
    }

    public Drawable getIcon() {
        return this.f1328l;
    }

    public Intent getIntent() {
        return this.f1323g;
    }

    public int getItemId() {
        return this.f1317a;
    }

    public char getNumericShortcut() {
        return this.f1324h;
    }

    public int getNumericModifiers() {
        return this.f1325i;
    }

    public int getOrder() {
        return this.f1320d;
    }

    public CharSequence getTitle() {
        return this.f1321e;
    }

    public CharSequence getTitleCondensed() {
        return this.f1322f != null ? this.f1322f : this.f1321e;
    }

    public boolean isCheckable() {
        return (this.f1338v & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f1338v & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f1338v & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1338v & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f1326j = Character.toLowerCase(c);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f1326j = Character.toLowerCase(c);
        this.f1327k = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f1338v = z | (this.f1338v & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f1338v = (z ? 2 : 0) | (this.f1338v & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f1338v = (z ? 16 : 0) | (this.f1338v & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1328l = drawable;
        this.f1329m = 0;
        m1726b();
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1329m = i;
        this.f1328l = C0875a.m3239a(this.f1330n, i);
        m1726b();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1323g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f1324h = c;
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        this.f1324h = c;
        this.f1325i = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1331o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1324h = c;
        this.f1326j = Character.toLowerCase(c2);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f1324h = c;
        this.f1325i = KeyEvent.normalizeMetaState(i);
        this.f1326j = Character.toLowerCase(c2);
        this.f1327k = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1321e = charSequence;
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f1321e = this.f1330n.getResources().getString(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1322f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        int i = 8;
        int i2 = this.f1338v & 8;
        if (z) {
            i = 0;
        }
        this.f1338v = i2 | i;
        return this;
    }

    /* renamed from: a */
    public C0837b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public C0837b setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public C0837b mo1351a(C0943b bVar) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    public C0837b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public C0837b setContentDescription(CharSequence charSequence) {
        this.f1332p = charSequence;
        return this;
    }

    public CharSequence getContentDescription() {
        return this.f1332p;
    }

    /* renamed from: b */
    public C0837b setTooltipText(CharSequence charSequence) {
        this.f1333q = charSequence;
        return this;
    }

    public CharSequence getTooltipText() {
        return this.f1333q;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1334r = colorStateList;
        this.f1336t = true;
        m1726b();
        return this;
    }

    public ColorStateList getIconTintList() {
        return this.f1334r;
    }

    public MenuItem setIconTintMode(Mode mode) {
        this.f1335s = mode;
        this.f1337u = true;
        m1726b();
        return this;
    }

    public Mode getIconTintMode() {
        return this.f1335s;
    }

    /* renamed from: b */
    private void m1726b() {
        if (this.f1328l == null) {
            return;
        }
        if (this.f1336t || this.f1337u) {
            this.f1328l = C0983a.m3709g(this.f1328l);
            this.f1328l = this.f1328l.mutate();
            if (this.f1336t) {
                C0983a.m3698a(this.f1328l, this.f1334r);
            }
            if (this.f1337u) {
                C0983a.m3701a(this.f1328l, this.f1335s);
            }
        }
    }
}
