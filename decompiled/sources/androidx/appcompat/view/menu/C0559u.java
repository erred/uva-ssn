package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.C0533h.C0534a;

/* renamed from: androidx.appcompat.view.menu.u */
/* compiled from: SubMenuBuilder */
public class C0559u extends C0533h implements SubMenu {
    private C0537j mItem;
    private C0533h mParentMenu;

    public C0559u(Context context, C0533h hVar, C0537j jVar) {
        super(context);
        this.mParentMenu = hVar;
        this.mItem = jVar;
    }

    public void setQwertyMode(boolean z) {
        this.mParentMenu.setQwertyMode(z);
    }

    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    public void setShortcutsVisible(boolean z) {
        this.mParentMenu.setShortcutsVisible(z);
    }

    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    public MenuItem getItem() {
        return this.mItem;
    }

    public void setCallback(C0534a aVar) {
        this.mParentMenu.setCallback(aVar);
    }

    public C0533h getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    /* access modifiers changed from: 0000 */
    public boolean dispatchMenuItemSelected(C0533h hVar, MenuItem menuItem) {
        return super.dispatchMenuItemSelected(hVar, menuItem) || this.mParentMenu.dispatchMenuItemSelected(hVar, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.mItem.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.mItem.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.setHeaderIconInt(drawable);
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.setHeaderIconInt(i);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.setHeaderTitleInt(charSequence);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.setHeaderTitleInt(i);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.setHeaderViewInt(view);
    }

    public boolean expandItemActionView(C0537j jVar) {
        return this.mParentMenu.expandItemActionView(jVar);
    }

    public boolean collapseItemActionView(C0537j jVar) {
        return this.mParentMenu.collapseItemActionView(jVar);
    }

    public String getActionViewStatesKey() {
        int itemId = this.mItem != null ? this.mItem.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(super.getActionViewStatesKey());
        sb.append(":");
        sb.append(itemId);
        return sb.toString();
    }

    public void setGroupDividerEnabled(boolean z) {
        this.mParentMenu.setGroupDividerEnabled(z);
    }

    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }
}
