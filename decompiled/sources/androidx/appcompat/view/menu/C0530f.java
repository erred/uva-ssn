package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.C0549o.C0550a;
import androidx.appcompat.view.menu.C0551p.C0552a;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.f */
/* compiled from: ListMenuPresenter */
public class C0530f implements OnItemClickListener, C0549o {

    /* renamed from: a */
    Context f1390a;

    /* renamed from: b */
    LayoutInflater f1391b;

    /* renamed from: c */
    C0533h f1392c;

    /* renamed from: d */
    ExpandedMenuView f1393d;

    /* renamed from: e */
    int f1394e;

    /* renamed from: f */
    int f1395f;

    /* renamed from: g */
    int f1396g;

    /* renamed from: h */
    C0531a f1397h;

    /* renamed from: i */
    private C0550a f1398i;

    /* renamed from: j */
    private int f1399j;

    /* renamed from: androidx.appcompat.view.menu.f$a */
    /* compiled from: ListMenuPresenter */
    private class C0531a extends BaseAdapter {

        /* renamed from: b */
        private int f1401b = -1;

        public long getItemId(int i) {
            return (long) i;
        }

        public C0531a() {
            mo1463a();
        }

        public int getCount() {
            int size = C0530f.this.f1392c.getNonActionItems().size() - C0530f.this.f1394e;
            return this.f1401b < 0 ? size : size - 1;
        }

        /* renamed from: a */
        public C0537j getItem(int i) {
            ArrayList nonActionItems = C0530f.this.f1392c.getNonActionItems();
            int i2 = i + C0530f.this.f1394e;
            if (this.f1401b >= 0 && i2 >= this.f1401b) {
                i2++;
            }
            return (C0537j) nonActionItems.get(i2);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = C0530f.this.f1391b.inflate(C0530f.this.f1396g, viewGroup, false);
            }
            ((C0552a) view).initialize(getItem(i), 0);
            return view;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo1463a() {
            C0537j expandedItem = C0530f.this.f1392c.getExpandedItem();
            if (expandedItem != null) {
                ArrayList nonActionItems = C0530f.this.f1392c.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (((C0537j) nonActionItems.get(i)) == expandedItem) {
                        this.f1401b = i;
                        return;
                    }
                }
            }
            this.f1401b = -1;
        }

        public void notifyDataSetChanged() {
            mo1463a();
            super.notifyDataSetChanged();
        }
    }

    public boolean collapseItemActionView(C0533h hVar, C0537j jVar) {
        return false;
    }

    public boolean expandItemActionView(C0533h hVar, C0537j jVar) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public C0530f(Context context, int i) {
        this(i, 0);
        this.f1390a = context;
        this.f1391b = LayoutInflater.from(this.f1390a);
    }

    public C0530f(int i, int i2) {
        this.f1396g = i;
        this.f1395f = i2;
    }

    public void initForMenu(Context context, C0533h hVar) {
        if (this.f1395f != 0) {
            this.f1390a = new ContextThemeWrapper(context, this.f1395f);
            this.f1391b = LayoutInflater.from(this.f1390a);
        } else if (this.f1390a != null) {
            this.f1390a = context;
            if (this.f1391b == null) {
                this.f1391b = LayoutInflater.from(this.f1390a);
            }
        }
        this.f1392c = hVar;
        if (this.f1397h != null) {
            this.f1397h.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public C0551p mo1458a(ViewGroup viewGroup) {
        if (this.f1393d == null) {
            this.f1393d = (ExpandedMenuView) this.f1391b.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1397h == null) {
                this.f1397h = new C0531a();
            }
            this.f1393d.setAdapter(this.f1397h);
            this.f1393d.setOnItemClickListener(this);
        }
        return this.f1393d;
    }

    /* renamed from: a */
    public ListAdapter mo1457a() {
        if (this.f1397h == null) {
            this.f1397h = new C0531a();
        }
        return this.f1397h;
    }

    public void updateMenuView(boolean z) {
        if (this.f1397h != null) {
            this.f1397h.notifyDataSetChanged();
        }
    }

    public void setCallback(C0550a aVar) {
        this.f1398i = aVar;
    }

    public boolean onSubMenuSelected(C0559u uVar) {
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        new C0536i(uVar).mo1560a((IBinder) null);
        if (this.f1398i != null) {
            this.f1398i.mo1031a(uVar);
        }
        return true;
    }

    public void onCloseMenu(C0533h hVar, boolean z) {
        if (this.f1398i != null) {
            this.f1398i.mo1030a(hVar, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1392c.performItemAction(this.f1397h.getItem(i), this, 0);
    }

    /* renamed from: a */
    public void mo1459a(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        if (this.f1393d != null) {
            this.f1393d.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    /* renamed from: b */
    public void mo1460b(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f1393d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public int getId() {
        return this.f1399j;
    }

    public Parcelable onSaveInstanceState() {
        if (this.f1393d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        mo1459a(bundle);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        mo1460b((Bundle) parcelable);
    }
}
