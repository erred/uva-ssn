package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.appcompat.view.menu.C0551p.C0552a;
import androidx.core.graphics.drawable.C0983a;
import androidx.core.p062a.p063a.C0837b;
import androidx.core.p070g.C0943b;
import androidx.core.p070g.C0943b.C0945b;

/* renamed from: androidx.appcompat.view.menu.j */
/* compiled from: MenuItemImpl */
public final class C0537j implements C0837b {

    /* renamed from: A */
    private View f1412A;

    /* renamed from: B */
    private C0943b f1413B;

    /* renamed from: C */
    private OnActionExpandListener f1414C;

    /* renamed from: D */
    private boolean f1415D = false;

    /* renamed from: E */
    private ContextMenuInfo f1416E;

    /* renamed from: a */
    C0533h f1417a;

    /* renamed from: b */
    private final int f1418b;

    /* renamed from: c */
    private final int f1419c;

    /* renamed from: d */
    private final int f1420d;

    /* renamed from: e */
    private final int f1421e;

    /* renamed from: f */
    private CharSequence f1422f;

    /* renamed from: g */
    private CharSequence f1423g;

    /* renamed from: h */
    private Intent f1424h;

    /* renamed from: i */
    private char f1425i;

    /* renamed from: j */
    private int f1426j = 4096;

    /* renamed from: k */
    private char f1427k;

    /* renamed from: l */
    private int f1428l = 4096;

    /* renamed from: m */
    private Drawable f1429m;

    /* renamed from: n */
    private int f1430n = 0;

    /* renamed from: o */
    private C0559u f1431o;

    /* renamed from: p */
    private Runnable f1432p;

    /* renamed from: q */
    private OnMenuItemClickListener f1433q;

    /* renamed from: r */
    private CharSequence f1434r;

    /* renamed from: s */
    private CharSequence f1435s;

    /* renamed from: t */
    private ColorStateList f1436t = null;

    /* renamed from: u */
    private Mode f1437u = null;

    /* renamed from: v */
    private boolean f1438v = false;

    /* renamed from: w */
    private boolean f1439w = false;

    /* renamed from: x */
    private boolean f1440x = false;

    /* renamed from: y */
    private int f1441y = 16;

    /* renamed from: z */
    private int f1442z = 0;

    C0537j(C0533h hVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f1417a = hVar;
        this.f1418b = i2;
        this.f1419c = i;
        this.f1420d = i3;
        this.f1421e = i4;
        this.f1422f = charSequence;
        this.f1442z = i5;
    }

    /* renamed from: b */
    public boolean mo1572b() {
        if ((this.f1433q != null && this.f1433q.onMenuItemClick(this)) || this.f1417a.dispatchMenuItemSelected(this.f1417a, this)) {
            return true;
        }
        if (this.f1432p != null) {
            this.f1432p.run();
            return true;
        }
        if (this.f1424h != null) {
            try {
                this.f1417a.getContext().startActivity(this.f1424h);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.f1413B == null || !this.f1413B.mo1683b()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.f1441y & 16) != 0;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f1441y |= 16;
        } else {
            this.f1441y &= -17;
        }
        this.f1417a.onItemsChanged(false);
        return this;
    }

    public int getGroupId() {
        return this.f1419c;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f1418b;
    }

    public int getOrder() {
        return this.f1420d;
    }

    /* renamed from: c */
    public int mo1573c() {
        return this.f1421e;
    }

    public Intent getIntent() {
        return this.f1424h;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1424h = intent;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.f1427k;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f1427k == c) {
            return this;
        }
        this.f1427k = Character.toLowerCase(c);
        this.f1417a.onItemsChanged(false);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f1427k == c && this.f1428l == i) {
            return this;
        }
        this.f1427k = Character.toLowerCase(c);
        this.f1428l = KeyEvent.normalizeMetaState(i);
        this.f1417a.onItemsChanged(false);
        return this;
    }

    public int getAlphabeticModifiers() {
        return this.f1428l;
    }

    public char getNumericShortcut() {
        return this.f1425i;
    }

    public int getNumericModifiers() {
        return this.f1426j;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f1425i == c) {
            return this;
        }
        this.f1425i = c;
        this.f1417a.onItemsChanged(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        if (this.f1425i == c && this.f1426j == i) {
            return this;
        }
        this.f1425i = c;
        this.f1426j = KeyEvent.normalizeMetaState(i);
        this.f1417a.onItemsChanged(false);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1425i = c;
        this.f1427k = Character.toLowerCase(c2);
        this.f1417a.onItemsChanged(false);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f1425i = c;
        this.f1426j = KeyEvent.normalizeMetaState(i);
        this.f1427k = Character.toLowerCase(c2);
        this.f1428l = KeyEvent.normalizeMetaState(i2);
        this.f1417a.onItemsChanged(false);
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public char mo1575d() {
        return this.f1417a.isQwertyMode() ? this.f1427k : this.f1425i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo1577e() {
        char d = mo1575d();
        if (d == 0) {
            return "";
        }
        Resources resources = this.f1417a.getContext().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f1417a.getContext()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
        }
        int i = this.f1417a.isQwertyMode() ? this.f1428l : this.f1426j;
        m1787a(sb, i, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
        m1787a(sb, i, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
        m1787a(sb, i, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
        m1787a(sb, i, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
        m1787a(sb, i, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
        m1787a(sb, i, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
        if (d == 8) {
            sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
        } else if (d == 10) {
            sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
        } else if (d != ' ') {
            sb.append(d);
        } else {
            sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static void m1787a(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public boolean mo1579f() {
        return this.f1417a.isShortcutsVisible() && mo1575d() != 0;
    }

    public SubMenu getSubMenu() {
        return this.f1431o;
    }

    public boolean hasSubMenu() {
        return this.f1431o != null;
    }

    /* renamed from: a */
    public void mo1568a(C0559u uVar) {
        this.f1431o = uVar;
        uVar.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1422f;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public CharSequence mo1566a(C0552a aVar) {
        if (aVar == null || !aVar.prefersCondensedTitle()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1422f = charSequence;
        this.f1417a.onItemsChanged(false);
        if (this.f1431o != null) {
            this.f1431o.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle((CharSequence) this.f1417a.getContext().getString(i));
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1423g != null ? this.f1423g : this.f1422f;
        return (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1423g = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f1422f;
        }
        this.f1417a.onItemsChanged(false);
        return this;
    }

    public Drawable getIcon() {
        if (this.f1429m != null) {
            return m1786a(this.f1429m);
        }
        if (this.f1430n == 0) {
            return null;
        }
        Drawable b = C0424a.m1270b(this.f1417a.getContext(), this.f1430n);
        this.f1430n = 0;
        this.f1429m = b;
        return m1786a(b);
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1430n = 0;
        this.f1429m = drawable;
        this.f1440x = true;
        this.f1417a.onItemsChanged(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1429m = null;
        this.f1430n = i;
        this.f1440x = true;
        this.f1417a.onItemsChanged(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1436t = colorStateList;
        this.f1438v = true;
        this.f1440x = true;
        this.f1417a.onItemsChanged(false);
        return this;
    }

    public ColorStateList getIconTintList() {
        return this.f1436t;
    }

    public MenuItem setIconTintMode(Mode mode) {
        this.f1437u = mode;
        this.f1439w = true;
        this.f1440x = true;
        this.f1417a.onItemsChanged(false);
        return this;
    }

    public Mode getIconTintMode() {
        return this.f1437u;
    }

    /* renamed from: a */
    private Drawable m1786a(Drawable drawable) {
        if (drawable != null && this.f1440x && (this.f1438v || this.f1439w)) {
            drawable = C0983a.m3709g(drawable).mutate();
            if (this.f1438v) {
                C0983a.m3698a(drawable, this.f1436t);
            }
            if (this.f1439w) {
                C0983a.m3701a(drawable, this.f1437u);
            }
            this.f1440x = false;
        }
        return drawable;
    }

    public boolean isCheckable() {
        return (this.f1441y & 1) == 1;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f1441y;
        this.f1441y = z | (this.f1441y & true) ? 1 : 0;
        if (i != this.f1441y) {
            this.f1417a.onItemsChanged(false);
        }
        return this;
    }

    /* renamed from: a */
    public void mo1569a(boolean z) {
        this.f1441y = (z ? 4 : 0) | (this.f1441y & -5);
    }

    /* renamed from: g */
    public boolean mo1580g() {
        return (this.f1441y & 4) != 0;
    }

    public boolean isChecked() {
        return (this.f1441y & 2) == 2;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f1441y & 4) != 0) {
            this.f1417a.setExclusiveItemChecked(this);
        } else {
            mo1571b(z);
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo1571b(boolean z) {
        int i = this.f1441y;
        this.f1441y = (z ? 2 : 0) | (this.f1441y & -3);
        if (i != this.f1441y) {
            this.f1417a.onItemsChanged(false);
        }
    }

    public boolean isVisible() {
        boolean z = false;
        if (this.f1413B == null || !this.f1413B.mo1691d()) {
            if ((this.f1441y & 8) == 0) {
                z = true;
            }
            return z;
        }
        if ((this.f1441y & 8) == 0 && this.f1413B.mo1692e()) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo1574c(boolean z) {
        int i = this.f1441y;
        this.f1441y = (z ? 0 : 8) | (this.f1441y & -9);
        if (i != this.f1441y) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean z) {
        if (mo1574c(z)) {
            this.f1417a.onItemVisibleChanged(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1433q = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        if (this.f1422f != null) {
            return this.f1422f.toString();
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo1567a(ContextMenuInfo contextMenuInfo) {
        this.f1416E = contextMenuInfo;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f1416E;
    }

    /* renamed from: h */
    public void mo1593h() {
        this.f1417a.onItemActionRequestChanged(this);
    }

    /* renamed from: i */
    public boolean mo1595i() {
        return this.f1417a.getOptionalIconsVisible();
    }

    /* renamed from: j */
    public boolean mo1600j() {
        return (this.f1441y & 32) == 32;
    }

    /* renamed from: k */
    public boolean mo1601k() {
        return (this.f1442z & 1) == 1;
    }

    /* renamed from: l */
    public boolean mo1602l() {
        return (this.f1442z & 2) == 2;
    }

    /* renamed from: d */
    public void mo1576d(boolean z) {
        if (z) {
            this.f1441y |= 32;
        } else {
            this.f1441y &= -33;
        }
    }

    /* renamed from: m */
    public boolean mo1603m() {
        return (this.f1442z & 4) == 4;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f1442z = i;
                this.f1417a.onItemActionRequestChanged(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    /* renamed from: a */
    public C0837b setActionView(View view) {
        this.f1412A = view;
        this.f1413B = null;
        if (view != null && view.getId() == -1 && this.f1418b > 0) {
            view.setId(this.f1418b);
        }
        this.f1417a.onItemActionRequestChanged(this);
        return this;
    }

    /* renamed from: a */
    public C0837b setActionView(int i) {
        Context context = this.f1417a.getContext();
        setActionView(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    public View getActionView() {
        if (this.f1412A != null) {
            return this.f1412A;
        }
        if (this.f1413B == null) {
            return null;
        }
        this.f1412A = this.f1413B.mo1689a((MenuItem) this);
        return this.f1412A;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    /* renamed from: a */
    public C0943b mo1353a() {
        return this.f1413B;
    }

    /* renamed from: a */
    public C0837b mo1351a(C0943b bVar) {
        if (this.f1413B != null) {
            this.f1413B.mo3734f();
        }
        this.f1412A = null;
        this.f1413B = bVar;
        this.f1417a.onItemsChanged(true);
        if (this.f1413B != null) {
            this.f1413B.mo1690a((C0945b) new C0945b() {
                /* renamed from: a */
                public void mo1624a(boolean z) {
                    C0537j.this.f1417a.onItemVisibleChanged(C0537j.this);
                }
            });
        }
        return this;
    }

    /* renamed from: b */
    public C0837b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        if (!mo1604n()) {
            return false;
        }
        if (this.f1414C == null || this.f1414C.onMenuItemActionExpand(this)) {
            return this.f1417a.expandItemActionView(this);
        }
        return false;
    }

    public boolean collapseActionView() {
        if ((this.f1442z & 8) == 0) {
            return false;
        }
        if (this.f1412A == null) {
            return true;
        }
        if (this.f1414C == null || this.f1414C.onMenuItemActionCollapse(this)) {
            return this.f1417a.collapseItemActionView(this);
        }
        return false;
    }

    /* renamed from: n */
    public boolean mo1604n() {
        boolean z = false;
        if ((this.f1442z & 8) == 0) {
            return false;
        }
        if (this.f1412A == null && this.f1413B != null) {
            this.f1412A = this.f1413B.mo1689a((MenuItem) this);
        }
        if (this.f1412A != null) {
            z = true;
        }
        return z;
    }

    /* renamed from: e */
    public void mo1578e(boolean z) {
        this.f1415D = z;
        this.f1417a.onItemsChanged(false);
    }

    public boolean isActionViewExpanded() {
        return this.f1415D;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        this.f1414C = onActionExpandListener;
        return this;
    }

    /* renamed from: a */
    public C0837b setContentDescription(CharSequence charSequence) {
        this.f1434r = charSequence;
        this.f1417a.onItemsChanged(false);
        return this;
    }

    public CharSequence getContentDescription() {
        return this.f1434r;
    }

    /* renamed from: b */
    public C0837b setTooltipText(CharSequence charSequence) {
        this.f1435s = charSequence;
        this.f1417a.onItemsChanged(false);
        return this;
    }

    public CharSequence getTooltipText() {
        return this.f1435s;
    }
}
