package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.C0507c;
import androidx.core.p062a.p063a.C0837b;
import androidx.core.p070g.C0943b;
import java.lang.reflect.Method;

/* renamed from: androidx.appcompat.view.menu.k */
/* compiled from: MenuItemWrapperICS */
public class C0539k extends C0522c<C0837b> implements MenuItem {

    /* renamed from: c */
    private Method f1444c;

    /* renamed from: androidx.appcompat.view.menu.k$a */
    /* compiled from: MenuItemWrapperICS */
    class C0540a extends C0943b {

        /* renamed from: a */
        final ActionProvider f1445a;

        public C0540a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f1445a = actionProvider;
        }

        /* renamed from: a */
        public View mo1681a() {
            return this.f1445a.onCreateActionView();
        }

        /* renamed from: b */
        public boolean mo1683b() {
            return this.f1445a.onPerformDefaultAction();
        }

        /* renamed from: c */
        public boolean mo1684c() {
            return this.f1445a.hasSubMenu();
        }

        /* renamed from: a */
        public void mo1682a(SubMenu subMenu) {
            this.f1445a.onPrepareSubMenu(C0539k.this.mo1429a(subMenu));
        }
    }

    /* renamed from: androidx.appcompat.view.menu.k$b */
    /* compiled from: MenuItemWrapperICS */
    static class C0541b extends FrameLayout implements C0507c {

        /* renamed from: a */
        final CollapsibleActionView f1447a;

        C0541b(View view) {
            super(view.getContext());
            this.f1447a = (CollapsibleActionView) view;
            addView(view);
        }

        /* renamed from: a */
        public void mo1252a() {
            this.f1447a.onActionViewExpanded();
        }

        /* renamed from: b */
        public void mo1253b() {
            this.f1447a.onActionViewCollapsed();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public View mo1685c() {
            return (View) this.f1447a;
        }
    }

    /* renamed from: androidx.appcompat.view.menu.k$c */
    /* compiled from: MenuItemWrapperICS */
    private class C0542c extends C0523d<OnActionExpandListener> implements OnActionExpandListener {
        C0542c(OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((OnActionExpandListener) this.f1352b).onMenuItemActionExpand(C0539k.this.mo1428a(menuItem));
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((OnActionExpandListener) this.f1352b).onMenuItemActionCollapse(C0539k.this.mo1428a(menuItem));
        }
    }

    /* renamed from: androidx.appcompat.view.menu.k$d */
    /* compiled from: MenuItemWrapperICS */
    private class C0543d extends C0523d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        C0543d(OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.f1352b).onMenuItemClick(C0539k.this.mo1428a(menuItem));
        }
    }

    C0539k(Context context, C0837b bVar) {
        super(context, bVar);
    }

    public int getItemId() {
        return ((C0837b) this.f1352b).getItemId();
    }

    public int getGroupId() {
        return ((C0837b) this.f1352b).getGroupId();
    }

    public int getOrder() {
        return ((C0837b) this.f1352b).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((C0837b) this.f1352b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((C0837b) this.f1352b).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((C0837b) this.f1352b).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((C0837b) this.f1352b).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((C0837b) this.f1352b).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((C0837b) this.f1352b).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((C0837b) this.f1352b).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((C0837b) this.f1352b).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((C0837b) this.f1352b).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((C0837b) this.f1352b).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((C0837b) this.f1352b).setShortcut(c, c2);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        ((C0837b) this.f1352b).setShortcut(c, c2, i, i2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((C0837b) this.f1352b).setNumericShortcut(c);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        ((C0837b) this.f1352b).setNumericShortcut(c, i);
        return this;
    }

    public char getNumericShortcut() {
        return ((C0837b) this.f1352b).getNumericShortcut();
    }

    public int getNumericModifiers() {
        return ((C0837b) this.f1352b).getNumericModifiers();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((C0837b) this.f1352b).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        ((C0837b) this.f1352b).setAlphabeticShortcut(c, i);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((C0837b) this.f1352b).getAlphabeticShortcut();
    }

    public int getAlphabeticModifiers() {
        return ((C0837b) this.f1352b).getAlphabeticModifiers();
    }

    public MenuItem setCheckable(boolean z) {
        ((C0837b) this.f1352b).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((C0837b) this.f1352b).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((C0837b) this.f1352b).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((C0837b) this.f1352b).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((C0837b) this.f1352b).setVisible(z);
    }

    public boolean isVisible() {
        return ((C0837b) this.f1352b).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((C0837b) this.f1352b).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((C0837b) this.f1352b).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((C0837b) this.f1352b).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return mo1429a(((C0837b) this.f1352b).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((C0837b) this.f1352b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0543d(onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((C0837b) this.f1352b).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((C0837b) this.f1352b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((C0837b) this.f1352b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0541b(view);
        }
        ((C0837b) this.f1352b).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((C0837b) this.f1352b).setActionView(i);
        View actionView = ((C0837b) this.f1352b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((C0837b) this.f1352b).setActionView((View) new C0541b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((C0837b) this.f1352b).getActionView();
        return actionView instanceof C0541b ? ((C0541b) actionView).mo1685c() : actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((C0837b) this.f1352b).mo1351a((C0943b) actionProvider != null ? mo1625a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        C0943b a = ((C0837b) this.f1352b).mo1353a();
        if (a instanceof C0540a) {
            return ((C0540a) a).f1445a;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((C0837b) this.f1352b).expandActionView();
    }

    public boolean collapseActionView() {
        return ((C0837b) this.f1352b).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((C0837b) this.f1352b).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((C0837b) this.f1352b).setOnActionExpandListener(onActionExpandListener != null ? new C0542c(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        ((C0837b) this.f1352b).mo1352a(charSequence);
        return this;
    }

    public CharSequence getContentDescription() {
        return ((C0837b) this.f1352b).getContentDescription();
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        ((C0837b) this.f1352b).mo1355b(charSequence);
        return this;
    }

    public CharSequence getTooltipText() {
        return ((C0837b) this.f1352b).getTooltipText();
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((C0837b) this.f1352b).setIconTintList(colorStateList);
        return this;
    }

    public ColorStateList getIconTintList() {
        return ((C0837b) this.f1352b).getIconTintList();
    }

    public MenuItem setIconTintMode(Mode mode) {
        ((C0837b) this.f1352b).setIconTintMode(mode);
        return this;
    }

    public Mode getIconTintMode() {
        return ((C0837b) this.f1352b).getIconTintMode();
    }

    /* renamed from: a */
    public void mo1626a(boolean z) {
        try {
            if (this.f1444c == null) {
                this.f1444c = ((C0837b) this.f1352b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f1444c.invoke(this.f1352b, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0540a mo1625a(ActionProvider actionProvider) {
        return new C0540a(this.f1349a, actionProvider);
    }
}
