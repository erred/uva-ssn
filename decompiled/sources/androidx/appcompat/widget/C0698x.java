package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.core.p070g.C0961q;
import androidx.core.p070g.C0962r;

/* renamed from: androidx.appcompat.widget.x */
/* compiled from: AppCompatSpinner */
public class C0698x extends Spinner implements C0961q {

    /* renamed from: d */
    private static final int[] f2017d = {16843505};

    /* renamed from: a */
    C0701b f2018a;

    /* renamed from: b */
    int f2019b;

    /* renamed from: c */
    final Rect f2020c;

    /* renamed from: e */
    private final C0675f f2021e;

    /* renamed from: f */
    private final Context f2022f;

    /* renamed from: g */
    private C0613ag f2023g;

    /* renamed from: h */
    private SpinnerAdapter f2024h;

    /* renamed from: i */
    private final boolean f2025i;

    /* renamed from: androidx.appcompat.widget.x$a */
    /* compiled from: AppCompatSpinner */
    private static class C0700a implements ListAdapter, SpinnerAdapter {

        /* renamed from: a */
        private SpinnerAdapter f2028a;

        /* renamed from: b */
        private ListAdapter f2029b;

        public int getItemViewType(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public C0700a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.f2028a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f2029b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof C0641ar) {
                C0641ar arVar = (C0641ar) spinnerAdapter;
                if (arVar.mo2439a() == null) {
                    arVar.mo2440a(theme);
                }
            }
        }

        public int getCount() {
            if (this.f2028a == null) {
                return 0;
            }
            return this.f2028a.getCount();
        }

        public Object getItem(int i) {
            if (this.f2028a == null) {
                return null;
            }
            return this.f2028a.getItem(i);
        }

        public long getItemId(int i) {
            if (this.f2028a == null) {
                return -1;
            }
            return this.f2028a.getItemId(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.f2028a == null) {
                return null;
            }
            return this.f2028a.getDropDownView(i, view, viewGroup);
        }

        public boolean hasStableIds() {
            return this.f2028a != null && this.f2028a.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2028a != null) {
                this.f2028a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f2028a != null) {
                this.f2028a.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f2029b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f2029b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* renamed from: androidx.appcompat.widget.x$b */
    /* compiled from: AppCompatSpinner */
    private class C0701b extends C0618ai {

        /* renamed from: a */
        ListAdapter f2030a;

        /* renamed from: h */
        private CharSequence f2032h;

        /* renamed from: i */
        private final Rect f2033i = new Rect();

        public C0701b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            mo2263b((View) C0698x.this);
            mo2261a(true);
            mo2255a(0);
            mo2258a((OnItemClickListener) new OnItemClickListener(C0698x.this) {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    C0698x.this.setSelection(i);
                    if (C0698x.this.getOnItemClickListener() != null) {
                        C0698x.this.performItemClick(view, i, C0701b.this.f2030a.getItemId(i));
                    }
                    C0701b.this.mo1439b();
                }
            });
        }

        /* renamed from: a */
        public void mo2259a(ListAdapter listAdapter) {
            super.mo2259a(listAdapter);
            this.f2030a = listAdapter;
        }

        /* renamed from: e */
        public CharSequence mo2693e() {
            return this.f2032h;
        }

        /* renamed from: a */
        public void mo2691a(CharSequence charSequence) {
            this.f2032h = charSequence;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public void mo2694f() {
            Drawable h = mo2271h();
            int i = 0;
            if (h != null) {
                h.getPadding(C0698x.this.f2020c);
                i = C0656bb.m2314a(C0698x.this) ? C0698x.this.f2020c.right : -C0698x.this.f2020c.left;
            } else {
                Rect rect = C0698x.this.f2020c;
                C0698x.this.f2020c.right = 0;
                rect.left = 0;
            }
            int paddingLeft = C0698x.this.getPaddingLeft();
            int paddingRight = C0698x.this.getPaddingRight();
            int width = C0698x.this.getWidth();
            if (C0698x.this.f2019b == -2) {
                int a = C0698x.this.mo2656a((SpinnerAdapter) this.f2030a, mo2271h());
                int i2 = (C0698x.this.getContext().getResources().getDisplayMetrics().widthPixels - C0698x.this.f2020c.left) - C0698x.this.f2020c.right;
                if (a > i2) {
                    a = i2;
                }
                mo2269g(Math.max(a, (width - paddingLeft) - paddingRight));
            } else if (C0698x.this.f2019b == -1) {
                mo2269g((width - paddingLeft) - paddingRight);
            } else {
                mo2269g(C0698x.this.f2019b);
            }
            mo2265c(C0656bb.m2314a(C0698x.this) ? i + ((width - paddingRight) - mo2277l()) : i + paddingLeft);
        }

        /* renamed from: a */
        public void mo1433a() {
            boolean c = mo1443c();
            mo2694f();
            mo2272h(2);
            super.mo1433a();
            mo1444d().setChoiceMode(1);
            mo2274i(C0698x.this.getSelectedItemPosition());
            if (!c) {
                ViewTreeObserver viewTreeObserver = C0698x.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final C07032 r1 = new OnGlobalLayoutListener() {
                        public void onGlobalLayout() {
                            if (!C0701b.this.mo2692a((View) C0698x.this)) {
                                C0701b.this.mo1439b();
                                return;
                            }
                            C0701b.this.mo2694f();
                            C0701b.super.mo1433a();
                        }
                    };
                    viewTreeObserver.addOnGlobalLayoutListener(r1);
                    mo2260a((OnDismissListener) new OnDismissListener() {
                        public void onDismiss() {
                            ViewTreeObserver viewTreeObserver = C0698x.this.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(r1);
                            }
                        }
                    });
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo2692a(View view) {
            return C0962r.m3543C(view) && view.getGlobalVisibleRect(this.f2033i);
        }
    }

    public C0698x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.spinnerStyle);
    }

    public C0698x(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public C0698x(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        if (r12 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        r12.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006b, code lost:
        if (r12 != null) goto L_0x0059;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0698x(android.content.Context r8, android.util.AttributeSet r9, int r10, int r11, android.content.res.Resources.Theme r12) {
        /*
            r7 = this;
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r7.f2020c = r0
            int[] r0 = androidx.appcompat.R.styleable.Spinner
            r1 = 0
            androidx.appcompat.widget.av r0 = androidx.appcompat.widget.C0645av.m2230a(r8, r9, r0, r10, r1)
            androidx.appcompat.widget.f r2 = new androidx.appcompat.widget.f
            r2.<init>(r7)
            r7.f2021e = r2
            r2 = 0
            if (r12 == 0) goto L_0x0023
            androidx.appcompat.view.d r3 = new androidx.appcompat.view.d
            r3.<init>(r8, r12)
            r7.f2022f = r3
            goto L_0x003e
        L_0x0023:
            int r12 = androidx.appcompat.R.styleable.Spinner_popupTheme
            int r12 = r0.mo2463g(r12, r1)
            if (r12 == 0) goto L_0x0033
            androidx.appcompat.view.d r3 = new androidx.appcompat.view.d
            r3.<init>(r8, r12)
            r7.f2022f = r3
            goto L_0x003e
        L_0x0033:
            int r12 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r12 >= r3) goto L_0x003b
            r12 = r8
            goto L_0x003c
        L_0x003b:
            r12 = r2
        L_0x003c:
            r7.f2022f = r12
        L_0x003e:
            android.content.Context r12 = r7.f2022f
            r3 = 1
            if (r12 == 0) goto L_0x00ad
            r12 = -1
            if (r11 != r12) goto L_0x0075
            int[] r12 = f2017d     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            android.content.res.TypedArray r12 = r8.obtainStyledAttributes(r9, r12, r10, r1)     // Catch:{ Exception -> 0x0062, all -> 0x005f }
            boolean r4 = r12.hasValue(r1)     // Catch:{ Exception -> 0x005d }
            if (r4 == 0) goto L_0x0057
            int r4 = r12.getInt(r1, r1)     // Catch:{ Exception -> 0x005d }
            r11 = r4
        L_0x0057:
            if (r12 == 0) goto L_0x0075
        L_0x0059:
            r12.recycle()
            goto L_0x0075
        L_0x005d:
            r4 = move-exception
            goto L_0x0064
        L_0x005f:
            r8 = move-exception
            r12 = r2
            goto L_0x006f
        L_0x0062:
            r4 = move-exception
            r12 = r2
        L_0x0064:
            java.lang.String r5 = "AppCompatSpinner"
            java.lang.String r6 = "Could not read android:spinnerMode"
            android.util.Log.i(r5, r6, r4)     // Catch:{ all -> 0x006e }
            if (r12 == 0) goto L_0x0075
            goto L_0x0059
        L_0x006e:
            r8 = move-exception
        L_0x006f:
            if (r12 == 0) goto L_0x0074
            r12.recycle()
        L_0x0074:
            throw r8
        L_0x0075:
            if (r11 != r3) goto L_0x00ad
            androidx.appcompat.widget.x$b r11 = new androidx.appcompat.widget.x$b
            android.content.Context r12 = r7.f2022f
            r11.<init>(r12, r9, r10)
            android.content.Context r12 = r7.f2022f
            int[] r4 = androidx.appcompat.R.styleable.Spinner
            androidx.appcompat.widget.av r12 = androidx.appcompat.widget.C0645av.m2230a(r12, r9, r4, r10, r1)
            int r1 = androidx.appcompat.R.styleable.Spinner_android_dropDownWidth
            r4 = -2
            int r1 = r12.mo2461f(r1, r4)
            r7.f2019b = r1
            int r1 = androidx.appcompat.R.styleable.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r1 = r12.mo2449a(r1)
            r11.mo2257a(r1)
            int r1 = androidx.appcompat.R.styleable.Spinner_android_prompt
            java.lang.String r1 = r0.mo2458d(r1)
            r11.mo2691a(r1)
            r12.mo2450a()
            r7.f2018a = r11
            androidx.appcompat.widget.x$1 r12 = new androidx.appcompat.widget.x$1
            r12.<init>(r7, r11)
            r7.f2023g = r12
        L_0x00ad:
            int r11 = androidx.appcompat.R.styleable.Spinner_android_entries
            java.lang.CharSequence[] r11 = r0.mo2462f(r11)
            if (r11 == 0) goto L_0x00c5
            android.widget.ArrayAdapter r12 = new android.widget.ArrayAdapter
            r1 = 17367048(0x1090008, float:2.5162948E-38)
            r12.<init>(r8, r1, r11)
            int r8 = androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            r12.setDropDownViewResource(r8)
            r7.setAdapter(r12)
        L_0x00c5:
            r0.mo2450a()
            r7.f2025i = r3
            android.widget.SpinnerAdapter r8 = r7.f2024h
            if (r8 == 0) goto L_0x00d5
            android.widget.SpinnerAdapter r8 = r7.f2024h
            r7.setAdapter(r8)
            r7.f2024h = r2
        L_0x00d5:
            androidx.appcompat.widget.f r8 = r7.f2021e
            r8.mo2547a(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0698x.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    public Context getPopupContext() {
        if (this.f2018a != null) {
            return this.f2022f;
        }
        if (VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f2018a != null) {
            this.f2018a.mo2257a(drawable);
        } else if (VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C0424a.m1270b(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        if (this.f2018a != null) {
            return this.f2018a.mo2271h();
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.f2018a != null) {
            this.f2018a.mo2266d(i);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        if (this.f2018a != null) {
            return this.f2018a.mo2276k();
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.f2018a != null) {
            this.f2018a.mo2265c(i);
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        if (this.f2018a != null) {
            return this.f2018a.mo2275j();
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i) {
        if (this.f2018a != null) {
            this.f2019b = i;
        } else if (VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.f2018a != null) {
            return this.f2019b;
        }
        if (VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f2025i) {
            this.f2024h = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f2018a != null) {
            this.f2018a.mo2259a((ListAdapter) new C0700a(spinnerAdapter, (this.f2022f == null ? getContext() : this.f2022f).getTheme()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2018a != null && this.f2018a.mo1443c()) {
            this.f2018a.mo1439b();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f2023g == null || !this.f2023g.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2018a != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), mo2656a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        if (this.f2018a == null) {
            return super.performClick();
        }
        if (!this.f2018a.mo1443c()) {
            this.f2018a.mo1433a();
        }
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.f2018a != null) {
            this.f2018a.mo2691a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        return this.f2018a != null ? this.f2018a.mo2693e() : super.getPrompt();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2021e != null) {
            this.f2021e.mo2543a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2021e != null) {
            this.f2021e.mo2546a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2021e != null) {
            this.f2021e.mo2544a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f2021e != null) {
            return this.f2021e.mo2542a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2021e != null) {
            this.f2021e.mo2545a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        if (this.f2021e != null) {
            return this.f2021e.mo2548b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2021e != null) {
            this.f2021e.mo2550c();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo2656a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.f2020c);
            i2 += this.f2020c.left + this.f2020c.right;
        }
        return i2;
    }
}
