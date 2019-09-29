package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import androidx.appcompat.view.menu.C0533h.C0535b;
import androidx.appcompat.widget.C0645av;

public final class ExpandedMenuView extends ListView implements OnItemClickListener, C0535b, C0551p {

    /* renamed from: a */
    private static final int[] f1296a = {16842964, 16843049};

    /* renamed from: b */
    private C0533h f1297b;

    /* renamed from: c */
    private int f1298c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        C0645av a = C0645av.m2230a(context, attributeSet, f1296a, i, 0);
        if (a.mo2464g(0)) {
            setBackgroundDrawable(a.mo2449a(0));
        }
        if (a.mo2464g(1)) {
            setDivider(a.mo2449a(1));
        }
        a.mo2450a();
    }

    public void initialize(C0533h hVar) {
        this.f1297b = hVar;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    /* renamed from: a */
    public boolean mo1334a(C0537j jVar) {
        return this.f1297b.performItemAction(jVar, 0);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo1334a((C0537j) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.f1298c;
    }
}
