package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.C0532g;
import androidx.appcompat.view.menu.C0533h;
import androidx.appcompat.view.menu.C0537j;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* renamed from: androidx.appcompat.widget.ak */
/* compiled from: MenuPopupWindow */
public class C0627ak extends C0618ai implements C0626aj {

    /* renamed from: a */
    private static Method f1786a;

    /* renamed from: b */
    private C0626aj f1787b;

    /* renamed from: androidx.appcompat.widget.ak$a */
    /* compiled from: MenuPopupWindow */
    public static class C0628a extends C0608ae {

        /* renamed from: b */
        final int f1788b;

        /* renamed from: c */
        final int f1789c;

        /* renamed from: d */
        private C0626aj f1790d;

        /* renamed from: e */
        private MenuItem f1791e;

        /* renamed from: a */
        public /* bridge */ /* synthetic */ int mo2188a(int i, int i2, int i3, int i4, int i5) {
            return super.mo2188a(i, i2, i3, i4, i5);
        }

        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo2189a(MotionEvent motionEvent, int i) {
            return super.mo2189a(motionEvent, i);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }

        public C0628a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.f1788b = 22;
                this.f1789c = 21;
                return;
            }
            this.f1788b = 21;
            this.f1789c = 22;
        }

        public void setHoverListener(C0626aj ajVar) {
            this.f1790d = ajVar;
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f1788b) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.f1789c) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ((C0532g) getAdapter()).mo1469a().close(false);
                return true;
            }
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i;
            C0532g gVar;
            if (this.f1790d != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    gVar = (C0532g) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i = 0;
                    gVar = (C0532g) adapter;
                }
                C0537j jVar = null;
                if (motionEvent.getAction() != 10) {
                    int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (pointToPosition != -1) {
                        int i2 = pointToPosition - i;
                        if (i2 >= 0 && i2 < gVar.getCount()) {
                            jVar = gVar.getItem(i2);
                        }
                    }
                }
                MenuItem menuItem = this.f1791e;
                if (menuItem != jVar) {
                    C0533h a = gVar.mo1469a();
                    if (menuItem != null) {
                        this.f1790d.mo1453a(a, menuItem);
                    }
                    this.f1791e = jVar;
                    if (jVar != null) {
                        this.f1790d.mo1454b(a, jVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }

    static {
        try {
            f1786a = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public C0627ak(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0608ae mo2254a(Context context, boolean z) {
        C0628a aVar = new C0628a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    /* renamed from: a */
    public void mo2291a(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.f1760g.setEnterTransition((Transition) obj);
        }
    }

    /* renamed from: b */
    public void mo2292b(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.f1760g.setExitTransition((Transition) obj);
        }
    }

    /* renamed from: a */
    public void mo2290a(C0626aj ajVar) {
        this.f1787b = ajVar;
    }

    /* renamed from: c */
    public void mo2293c(boolean z) {
        if (f1786a != null) {
            try {
                f1786a.invoke(this.f1760g, new Object[]{Boolean.valueOf(z)});
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    /* renamed from: b */
    public void mo1454b(C0533h hVar, MenuItem menuItem) {
        if (this.f1787b != null) {
            this.f1787b.mo1454b(hVar, menuItem);
        }
    }

    /* renamed from: a */
    public void mo1453a(C0533h hVar, MenuItem menuItem) {
        if (this.f1787b != null) {
            this.f1787b.mo1453a(hVar, menuItem);
        }
    }
}
