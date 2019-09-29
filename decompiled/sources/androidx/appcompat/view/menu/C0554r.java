package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.p062a.p063a.C0836a;

/* renamed from: androidx.appcompat.view.menu.r */
/* compiled from: MenuWrapperICS */
class C0554r extends C0522c<C0836a> implements Menu {
    C0554r(Context context, C0836a aVar) {
        super(context, aVar);
    }

    public MenuItem add(CharSequence charSequence) {
        return mo1428a(((C0836a) this.f1352b).add(charSequence));
    }

    public MenuItem add(int i) {
        return mo1428a(((C0836a) this.f1352b).add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo1428a(((C0836a) this.f1352b).add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo1428a(((C0836a) this.f1352b).add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return mo1429a(((C0836a) this.f1352b).addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return mo1429a(((C0836a) this.f1352b).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return mo1429a(((C0836a) this.f1352b).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return mo1429a(((C0836a) this.f1352b).addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = ((C0836a) this.f1352b).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr2[i5] = mo1428a(menuItemArr3[i5]);
            }
        }
        return addIntentOptions;
    }

    public void removeItem(int i) {
        mo1432b(i);
        ((C0836a) this.f1352b).removeItem(i);
    }

    public void removeGroup(int i) {
        mo1431a(i);
        ((C0836a) this.f1352b).removeGroup(i);
    }

    public void clear() {
        mo1430a();
        ((C0836a) this.f1352b).clear();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((C0836a) this.f1352b).setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        ((C0836a) this.f1352b).setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((C0836a) this.f1352b).setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return ((C0836a) this.f1352b).hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return mo1428a(((C0836a) this.f1352b).findItem(i));
    }

    public int size() {
        return ((C0836a) this.f1352b).size();
    }

    public MenuItem getItem(int i) {
        return mo1428a(((C0836a) this.f1352b).getItem(i));
    }

    public void close() {
        ((C0836a) this.f1352b).close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((C0836a) this.f1352b).performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((C0836a) this.f1352b).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((C0836a) this.f1352b).performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        ((C0836a) this.f1352b).setQwertyMode(z);
    }
}
