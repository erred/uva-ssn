package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

/* renamed from: androidx.appcompat.view.menu.m */
/* compiled from: MenuPopup */
abstract class C0546m implements OnItemClickListener, C0549o, C0555s {

    /* renamed from: a */
    private Rect f1452a;

    /* renamed from: a */
    public abstract void mo1434a(int i);

    /* renamed from: a */
    public abstract void mo1435a(View view);

    /* renamed from: a */
    public abstract void mo1436a(OnDismissListener onDismissListener);

    /* renamed from: a */
    public abstract void mo1437a(C0533h hVar);

    /* renamed from: a */
    public abstract void mo1438a(boolean z);

    /* renamed from: b */
    public abstract void mo1440b(int i);

    /* renamed from: b */
    public abstract void mo1441b(boolean z);

    /* renamed from: c */
    public abstract void mo1442c(int i);

    public boolean collapseItemActionView(C0533h hVar, C0537j jVar) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo1445e() {
        return true;
    }

    public boolean expandItemActionView(C0533h hVar, C0537j jVar) {
        return false;
    }

    public int getId() {
        return 0;
    }

    public void initForMenu(Context context, C0533h hVar) {
    }

    C0546m() {
    }

    /* renamed from: a */
    public void mo1694a(Rect rect) {
        this.f1452a = rect;
    }

    /* renamed from: f */
    public Rect mo1695f() {
        return this.f1452a;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        m1832a(listAdapter).f1402a.performItemAction((MenuItem) listAdapter.getItem(i), this, mo1445e() ? 0 : 4);
    }

    /* renamed from: a */
    protected static int m1831a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        ViewGroup viewGroup2 = viewGroup;
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            if (viewGroup2 == null) {
                viewGroup2 = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, viewGroup2);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i3) {
                i3 = measuredWidth;
            }
        }
        return i3;
    }

    /* renamed from: a */
    protected static C0532g m1832a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (C0532g) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (C0532g) listAdapter;
    }

    /* renamed from: b */
    protected static boolean m1833b(C0533h hVar) {
        int size = hVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = hVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }
}
