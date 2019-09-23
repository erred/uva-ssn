package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.C0555s;
import androidx.core.p070g.C0962r;
import androidx.core.widget.C1012h;
import androidx.customview.p073b.C1024a;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.common.primitives.Ints;
import java.lang.reflect.Method;

/* renamed from: androidx.appcompat.widget.ai */
/* compiled from: ListPopupWindow */
public class C0618ai implements C0555s {

    /* renamed from: a */
    private static Method f1743a;

    /* renamed from: b */
    private static Method f1744b;

    /* renamed from: h */
    private static Method f1745h;

    /* renamed from: A */
    private Drawable f1746A;

    /* renamed from: B */
    private OnItemClickListener f1747B;

    /* renamed from: C */
    private OnItemSelectedListener f1748C;

    /* renamed from: D */
    private final C0624d f1749D;

    /* renamed from: E */
    private final C0623c f1750E;

    /* renamed from: F */
    private final C0621a f1751F;

    /* renamed from: G */
    private Runnable f1752G;

    /* renamed from: H */
    private final Rect f1753H;

    /* renamed from: I */
    private Rect f1754I;

    /* renamed from: J */
    private boolean f1755J;

    /* renamed from: c */
    C0608ae f1756c;

    /* renamed from: d */
    int f1757d;

    /* renamed from: e */
    final C0625e f1758e;

    /* renamed from: f */
    final Handler f1759f;

    /* renamed from: g */
    PopupWindow f1760g;

    /* renamed from: i */
    private Context f1761i;

    /* renamed from: j */
    private ListAdapter f1762j;

    /* renamed from: k */
    private int f1763k;

    /* renamed from: l */
    private int f1764l;

    /* renamed from: m */
    private int f1765m;

    /* renamed from: n */
    private int f1766n;

    /* renamed from: o */
    private int f1767o;

    /* renamed from: p */
    private boolean f1768p;

    /* renamed from: q */
    private boolean f1769q;

    /* renamed from: r */
    private boolean f1770r;

    /* renamed from: s */
    private boolean f1771s;

    /* renamed from: t */
    private int f1772t;

    /* renamed from: u */
    private boolean f1773u;

    /* renamed from: v */
    private boolean f1774v;

    /* renamed from: w */
    private View f1775w;

    /* renamed from: x */
    private int f1776x;

    /* renamed from: y */
    private DataSetObserver f1777y;

    /* renamed from: z */
    private View f1778z;

    /* renamed from: androidx.appcompat.widget.ai$a */
    /* compiled from: ListPopupWindow */
    private class C0621a implements Runnable {
        C0621a() {
        }

        public void run() {
            C0618ai.this.mo2278m();
        }
    }

    /* renamed from: androidx.appcompat.widget.ai$b */
    /* compiled from: ListPopupWindow */
    private class C0622b extends DataSetObserver {
        C0622b() {
        }

        public void onChanged() {
            if (C0618ai.this.mo1443c()) {
                C0618ai.this.mo1433a();
            }
        }

        public void onInvalidated() {
            C0618ai.this.mo1439b();
        }
    }

    /* renamed from: androidx.appcompat.widget.ai$c */
    /* compiled from: ListPopupWindow */
    private class C0623c implements OnScrollListener {
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        C0623c() {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !C0618ai.this.mo2279n() && C0618ai.this.f1760g.getContentView() != null) {
                C0618ai.this.f1759f.removeCallbacks(C0618ai.this.f1758e);
                C0618ai.this.f1758e.run();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ai$d */
    /* compiled from: ListPopupWindow */
    private class C0624d implements OnTouchListener {
        C0624d() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && C0618ai.this.f1760g != null && C0618ai.this.f1760g.isShowing() && x >= 0 && x < C0618ai.this.f1760g.getWidth() && y >= 0 && y < C0618ai.this.f1760g.getHeight()) {
                C0618ai.this.f1759f.postDelayed(C0618ai.this.f1758e, 250);
            } else if (action == 1) {
                C0618ai.this.f1759f.removeCallbacks(C0618ai.this.f1758e);
            }
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ai$e */
    /* compiled from: ListPopupWindow */
    private class C0625e implements Runnable {
        C0625e() {
        }

        public void run() {
            if (C0618ai.this.f1756c != null && C0962r.m3543C(C0618ai.this.f1756c) && C0618ai.this.f1756c.getCount() > C0618ai.this.f1756c.getChildCount() && C0618ai.this.f1756c.getChildCount() <= C0618ai.this.f1757d) {
                C0618ai.this.f1760g.setInputMethodMode(2);
                C0618ai.this.mo1433a();
            }
        }
    }

    static {
        try {
            f1743a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException unused) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f1744b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException unused2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            f1745h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException unused3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public C0618ai(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public C0618ai(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public C0618ai(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1763k = -2;
        this.f1764l = -2;
        this.f1767o = 1002;
        this.f1769q = true;
        this.f1772t = 0;
        this.f1773u = false;
        this.f1774v = false;
        this.f1757d = BaseClientBuilder.API_PRIORITY_OTHER;
        this.f1776x = 0;
        this.f1758e = new C0625e();
        this.f1749D = new C0624d();
        this.f1750E = new C0623c();
        this.f1751F = new C0621a();
        this.f1753H = new Rect();
        this.f1761i = context;
        this.f1759f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i, i2);
        this.f1765m = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f1766n = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f1766n != 0) {
            this.f1768p = true;
        }
        obtainStyledAttributes.recycle();
        this.f1760g = new C0692r(context, attributeSet, i, i2);
        this.f1760g.setInputMethodMode(1);
    }

    /* renamed from: a */
    public void mo2259a(ListAdapter listAdapter) {
        if (this.f1777y == null) {
            this.f1777y = new C0622b();
        } else if (this.f1762j != null) {
            this.f1762j.unregisterDataSetObserver(this.f1777y);
        }
        this.f1762j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1777y);
        }
        if (this.f1756c != null) {
            this.f1756c.setAdapter(this.f1762j);
        }
    }

    /* renamed from: a */
    public void mo2255a(int i) {
        this.f1776x = i;
    }

    /* renamed from: a */
    public void mo2261a(boolean z) {
        this.f1755J = z;
        this.f1760g.setFocusable(z);
    }

    /* renamed from: g */
    public boolean mo2270g() {
        return this.f1755J;
    }

    /* renamed from: h */
    public Drawable mo2271h() {
        return this.f1760g.getBackground();
    }

    /* renamed from: a */
    public void mo2257a(Drawable drawable) {
        this.f1760g.setBackgroundDrawable(drawable);
    }

    /* renamed from: b */
    public void mo2262b(int i) {
        this.f1760g.setAnimationStyle(i);
    }

    /* renamed from: i */
    public View mo2273i() {
        return this.f1778z;
    }

    /* renamed from: b */
    public void mo2263b(View view) {
        this.f1778z = view;
    }

    /* renamed from: j */
    public int mo2275j() {
        return this.f1765m;
    }

    /* renamed from: c */
    public void mo2265c(int i) {
        this.f1765m = i;
    }

    /* renamed from: k */
    public int mo2276k() {
        if (!this.f1768p) {
            return 0;
        }
        return this.f1766n;
    }

    /* renamed from: d */
    public void mo2266d(int i) {
        this.f1766n = i;
        this.f1768p = true;
    }

    /* renamed from: a */
    public void mo2256a(Rect rect) {
        this.f1754I = rect;
    }

    /* renamed from: e */
    public void mo2267e(int i) {
        this.f1772t = i;
    }

    /* renamed from: l */
    public int mo2277l() {
        return this.f1764l;
    }

    /* renamed from: f */
    public void mo2268f(int i) {
        this.f1764l = i;
    }

    /* renamed from: g */
    public void mo2269g(int i) {
        Drawable background = this.f1760g.getBackground();
        if (background != null) {
            background.getPadding(this.f1753H);
            this.f1764l = this.f1753H.left + this.f1753H.right + i;
            return;
        }
        mo2268f(i);
    }

    /* renamed from: a */
    public void mo2258a(OnItemClickListener onItemClickListener) {
        this.f1747B = onItemClickListener;
    }

    /* renamed from: a */
    public void mo1433a() {
        int i;
        int i2;
        int f = mo2694f();
        boolean n = mo2279n();
        C1012h.m3857a(this.f1760g, this.f1767o);
        boolean z = true;
        if (!this.f1760g.isShowing()) {
            if (this.f1764l == -1) {
                i = -1;
            } else if (this.f1764l == -2) {
                i = mo2273i().getWidth();
            } else {
                i = this.f1764l;
            }
            if (this.f1763k == -1) {
                f = -1;
            } else if (this.f1763k != -2) {
                f = this.f1763k;
            }
            this.f1760g.setWidth(i);
            this.f1760g.setHeight(f);
            mo2293c(true);
            this.f1760g.setOutsideTouchable(!this.f1774v && !this.f1773u);
            this.f1760g.setTouchInterceptor(this.f1749D);
            if (this.f1771s) {
                C1012h.m3859a(this.f1760g, this.f1770r);
            }
            if (f1745h != null) {
                try {
                    f1745h.invoke(this.f1760g, new Object[]{this.f1754I});
                } catch (Exception e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
            C1012h.m3858a(this.f1760g, mo2273i(), this.f1765m, this.f1766n, this.f1772t);
            this.f1756c.setSelection(-1);
            if (!this.f1755J || this.f1756c.isInTouchMode()) {
                mo2278m();
            }
            if (!this.f1755J) {
                this.f1759f.post(this.f1751F);
            }
        } else if (C0962r.m3543C(mo2273i())) {
            if (this.f1764l == -1) {
                i2 = -1;
            } else if (this.f1764l == -2) {
                i2 = mo2273i().getWidth();
            } else {
                i2 = this.f1764l;
            }
            if (this.f1763k == -1) {
                if (!n) {
                    f = -1;
                }
                if (n) {
                    this.f1760g.setWidth(this.f1764l == -1 ? -1 : 0);
                    this.f1760g.setHeight(0);
                } else {
                    this.f1760g.setWidth(this.f1764l == -1 ? -1 : 0);
                    this.f1760g.setHeight(-1);
                }
            } else if (this.f1763k != -2) {
                f = this.f1763k;
            }
            PopupWindow popupWindow = this.f1760g;
            if (this.f1774v || this.f1773u) {
                z = false;
            }
            popupWindow.setOutsideTouchable(z);
            this.f1760g.update(mo2273i(), this.f1765m, this.f1766n, i2 < 0 ? -1 : i2, f < 0 ? -1 : f);
        }
    }

    /* renamed from: b */
    public void mo1439b() {
        this.f1760g.dismiss();
        mo2693e();
        this.f1760g.setContentView(null);
        this.f1756c = null;
        this.f1759f.removeCallbacks(this.f1758e);
    }

    /* renamed from: a */
    public void mo2260a(OnDismissListener onDismissListener) {
        this.f1760g.setOnDismissListener(onDismissListener);
    }

    /* renamed from: e */
    private void mo2693e() {
        if (this.f1775w != null) {
            ViewParent parent = this.f1775w.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1775w);
            }
        }
    }

    /* renamed from: h */
    public void mo2272h(int i) {
        this.f1760g.setInputMethodMode(i);
    }

    /* renamed from: i */
    public void mo2274i(int i) {
        C0608ae aeVar = this.f1756c;
        if (mo1443c() && aeVar != null) {
            aeVar.setListSelectionHidden(false);
            aeVar.setSelection(i);
            if (aeVar.getChoiceMode() != 0) {
                aeVar.setItemChecked(i, true);
            }
        }
    }

    /* renamed from: m */
    public void mo2278m() {
        C0608ae aeVar = this.f1756c;
        if (aeVar != null) {
            aeVar.setListSelectionHidden(true);
            aeVar.requestLayout();
        }
    }

    /* renamed from: c */
    public boolean mo1443c() {
        return this.f1760g.isShowing();
    }

    /* renamed from: n */
    public boolean mo2279n() {
        return this.f1760g.getInputMethodMode() == 2;
    }

    /* renamed from: d */
    public ListView mo1444d() {
        return this.f1756c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0608ae mo2254a(Context context, boolean z) {
        return new C0608ae(context, z);
    }

    /* renamed from: f */
    private int mo2694f() {
        int i;
        int i2;
        int makeMeasureSpec;
        View view;
        int i3;
        int i4;
        boolean z = true;
        if (this.f1756c == null) {
            Context context = this.f1761i;
            this.f1752G = new Runnable() {
                public void run() {
                    View i = C0618ai.this.mo2273i();
                    if (i != null && i.getWindowToken() != null) {
                        C0618ai.this.mo1433a();
                    }
                }
            };
            this.f1756c = mo2254a(context, !this.f1755J);
            if (this.f1746A != null) {
                this.f1756c.setSelector(this.f1746A);
            }
            this.f1756c.setAdapter(this.f1762j);
            this.f1756c.setOnItemClickListener(this.f1747B);
            this.f1756c.setFocusable(true);
            this.f1756c.setFocusableInTouchMode(true);
            this.f1756c.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        C0608ae aeVar = C0618ai.this.f1756c;
                        if (aeVar != null) {
                            aeVar.setListSelectionHidden(false);
                        }
                    }
                }
            });
            this.f1756c.setOnScrollListener(this.f1750E);
            if (this.f1748C != null) {
                this.f1756c.setOnItemSelectedListener(this.f1748C);
            }
            View view2 = this.f1756c;
            View view3 = this.f1775w;
            if (view3 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LayoutParams layoutParams = new LayoutParams(-1, 0, 1.0f);
                switch (this.f1776x) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams);
                        linearLayout.addView(view3);
                        break;
                    default:
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid hint position ");
                        sb.append(this.f1776x);
                        Log.e("ListPopupWindow", sb.toString());
                        break;
                }
                if (this.f1764l >= 0) {
                    i4 = this.f1764l;
                    i3 = C1024a.INVALID_ID;
                } else {
                    i4 = 0;
                    i3 = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i4, i3), 0);
                LayoutParams layoutParams2 = (LayoutParams) view3.getLayoutParams();
                i = view3.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i = 0;
                view = view2;
            }
            this.f1760g.setContentView(view);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f1760g.getContentView();
            View view4 = this.f1775w;
            if (view4 != null) {
                LayoutParams layoutParams3 = (LayoutParams) view4.getLayoutParams();
                i = view4.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.f1760g.getBackground();
        if (background != null) {
            background.getPadding(this.f1753H);
            i2 = this.f1753H.top + this.f1753H.bottom;
            if (!this.f1768p) {
                this.f1766n = -this.f1753H.top;
            }
        } else {
            this.f1753H.setEmpty();
            i2 = 0;
        }
        if (this.f1760g.getInputMethodMode() != 2) {
            z = false;
        }
        int a = m2132a(mo2273i(), this.f1766n, z);
        if (this.f1773u || this.f1763k == -1) {
            return a + i2;
        }
        switch (this.f1764l) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1761i.getResources().getDisplayMetrics().widthPixels - (this.f1753H.left + this.f1753H.right), C1024a.INVALID_ID);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1761i.getResources().getDisplayMetrics().widthPixels - (this.f1753H.left + this.f1753H.right), Ints.MAX_POWER_OF_TWO);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1764l, Ints.MAX_POWER_OF_TWO);
                break;
        }
        int a2 = this.f1756c.mo2188a(makeMeasureSpec, 0, -1, a - i, -1);
        if (a2 > 0) {
            i += i2 + this.f1756c.getPaddingTop() + this.f1756c.getPaddingBottom();
        }
        return a2 + i;
    }

    /* renamed from: b */
    public void mo2264b(boolean z) {
        this.f1771s = true;
        this.f1770r = z;
    }

    /* renamed from: c */
    private void mo2293c(boolean z) {
        if (f1743a != null) {
            try {
                f1743a.invoke(this.f1760g, new Object[]{Boolean.valueOf(z)});
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* renamed from: a */
    private int m2132a(View view, int i, boolean z) {
        if (f1744b != null) {
            try {
                return ((Integer) f1744b.invoke(this.f1760g, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f1760g.getMaxAvailableHeight(view, i);
    }
}
