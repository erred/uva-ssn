package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.C0549o.C0550a;
import androidx.appcompat.view.menu.C0551p.C0552a;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.b */
/* compiled from: BaseMenuPresenter */
public abstract class C0521b implements C0549o {

    /* renamed from: a */
    protected Context f1339a;

    /* renamed from: b */
    protected Context f1340b;

    /* renamed from: c */
    protected C0533h f1341c;

    /* renamed from: d */
    protected LayoutInflater f1342d;

    /* renamed from: e */
    protected LayoutInflater f1343e;

    /* renamed from: f */
    protected C0551p f1344f;

    /* renamed from: g */
    private C0550a f1345g;

    /* renamed from: h */
    private int f1346h;

    /* renamed from: i */
    private int f1347i;

    /* renamed from: j */
    private int f1348j;

    /* renamed from: a */
    public abstract void mo1415a(C0537j jVar, C0552a aVar);

    /* renamed from: a */
    public boolean mo1416a(int i, C0537j jVar) {
        return true;
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

    public C0521b(Context context, int i, int i2) {
        this.f1339a = context;
        this.f1342d = LayoutInflater.from(context);
        this.f1346h = i;
        this.f1347i = i2;
    }

    public void initForMenu(Context context, C0533h hVar) {
        this.f1340b = context;
        this.f1343e = LayoutInflater.from(this.f1340b);
        this.f1341c = hVar;
    }

    /* renamed from: a */
    public C0551p mo1412a(ViewGroup viewGroup) {
        if (this.f1344f == null) {
            this.f1344f = (C0551p) this.f1342d.inflate(this.f1346h, viewGroup, false);
            this.f1344f.initialize(this.f1341c);
            updateMenuView(true);
        }
        return this.f1344f;
    }

    public void updateMenuView(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f1344f;
        if (viewGroup != null) {
            int i = 0;
            if (this.f1341c != null) {
                this.f1341c.flagActionItems();
                ArrayList visibleItems = this.f1341c.getVisibleItems();
                int size = visibleItems.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    C0537j jVar = (C0537j) visibleItems.get(i3);
                    if (mo1416a(i2, jVar)) {
                        View childAt = viewGroup.getChildAt(i2);
                        C0537j itemData = childAt instanceof C0552a ? ((C0552a) childAt).getItemData() : null;
                        View a = mo1410a(jVar, childAt, viewGroup);
                        if (jVar != itemData) {
                            a.setPressed(false);
                            a.jumpDrawablesToCurrentState();
                        }
                        if (a != childAt) {
                            mo1414a(a, i2);
                        }
                        i2++;
                    }
                }
                i = i2;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo1417a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1414a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1344f).addView(view, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo1417a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public void setCallback(C0550a aVar) {
        this.f1345g = aVar;
    }

    /* renamed from: a */
    public C0550a mo1411a() {
        return this.f1345g;
    }

    /* renamed from: b */
    public C0552a mo1418b(ViewGroup viewGroup) {
        return (C0552a) this.f1342d.inflate(this.f1347i, viewGroup, false);
    }

    /* renamed from: a */
    public View mo1410a(C0537j jVar, View view, ViewGroup viewGroup) {
        C0552a aVar;
        if (view instanceof C0552a) {
            aVar = (C0552a) view;
        } else {
            aVar = mo1418b(viewGroup);
        }
        mo1415a(jVar, aVar);
        return (View) aVar;
    }

    public void onCloseMenu(C0533h hVar, boolean z) {
        if (this.f1345g != null) {
            this.f1345g.mo1030a(hVar, z);
        }
    }

    public boolean onSubMenuSelected(C0559u uVar) {
        if (this.f1345g != null) {
            return this.f1345g.mo1031a(uVar);
        }
        return false;
    }

    public int getId() {
        return this.f1348j;
    }

    /* renamed from: a */
    public void mo1413a(int i) {
        this.f1348j = i;
    }
}
