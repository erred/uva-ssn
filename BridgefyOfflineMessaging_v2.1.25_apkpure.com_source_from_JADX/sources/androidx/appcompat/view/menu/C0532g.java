package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.C0551p.C0552a;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.g */
/* compiled from: MenuAdapter */
public class C0532g extends BaseAdapter {

    /* renamed from: a */
    C0533h f1402a;

    /* renamed from: b */
    private int f1403b = -1;

    /* renamed from: c */
    private boolean f1404c;

    /* renamed from: d */
    private final boolean f1405d;

    /* renamed from: e */
    private final LayoutInflater f1406e;

    /* renamed from: f */
    private final int f1407f;

    public long getItemId(int i) {
        return (long) i;
    }

    public C0532g(C0533h hVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.f1405d = z;
        this.f1406e = layoutInflater;
        this.f1402a = hVar;
        this.f1407f = i;
        mo1472b();
    }

    /* renamed from: a */
    public void mo1471a(boolean z) {
        this.f1404c = z;
    }

    public int getCount() {
        ArrayList nonActionItems = this.f1405d ? this.f1402a.getNonActionItems() : this.f1402a.getVisibleItems();
        if (this.f1403b < 0) {
            return nonActionItems.size();
        }
        return nonActionItems.size() - 1;
    }

    /* renamed from: a */
    public C0533h mo1469a() {
        return this.f1402a;
    }

    /* renamed from: a */
    public C0537j getItem(int i) {
        ArrayList nonActionItems = this.f1405d ? this.f1402a.getNonActionItems() : this.f1402a.getVisibleItems();
        if (this.f1403b >= 0 && i >= this.f1403b) {
            i++;
        }
        return (C0537j) nonActionItems.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1406e.inflate(this.f1407f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f1402a.isGroupDividerEnabled() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        C0552a aVar = (C0552a) view;
        if (this.f1404c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.initialize(getItem(i), 0);
        return view;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo1472b() {
        C0537j expandedItem = this.f1402a.getExpandedItem();
        if (expandedItem != null) {
            ArrayList nonActionItems = this.f1402a.getNonActionItems();
            int size = nonActionItems.size();
            for (int i = 0; i < size; i++) {
                if (((C0537j) nonActionItems.get(i)) == expandedItem) {
                    this.f1403b = i;
                    return;
                }
            }
        }
        this.f1403b = -1;
    }

    public void notifyDataSetChanged() {
        mo1472b();
        super.notifyDataSetChanged();
    }
}
