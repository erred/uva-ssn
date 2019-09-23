package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.C0505b;
import androidx.appcompat.view.menu.C0533h;
import androidx.core.p070g.C0962r;
import androidx.core.p070g.C0969v;
import androidx.customview.p073b.C1024a;
import com.google.common.primitives.Ints;

public class ActionBarContextView extends C0602a {

    /* renamed from: g */
    private CharSequence f1499g;

    /* renamed from: h */
    private CharSequence f1500h;

    /* renamed from: i */
    private View f1501i;

    /* renamed from: j */
    private View f1502j;

    /* renamed from: k */
    private LinearLayout f1503k;

    /* renamed from: l */
    private TextView f1504l;

    /* renamed from: m */
    private TextView f1505m;

    /* renamed from: n */
    private int f1506n;

    /* renamed from: o */
    private int f1507o;

    /* renamed from: p */
    private boolean f1508p;

    /* renamed from: q */
    private int f1509q;

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ C0969v mo1776a(int i, long j) {
        return super.mo1776a(i, j);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0645av a = C0645av.m2230a(context, attributeSet, R.styleable.ActionMode, i, 0);
        C0962r.m3557a((View) this, a.mo2449a(R.styleable.ActionMode_background));
        this.f1506n = a.mo2463g(R.styleable.ActionMode_titleTextStyle, 0);
        this.f1507o = a.mo2463g(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.f1693e = a.mo2461f(R.styleable.ActionMode_height, 0);
        this.f1509q = a.mo2463g(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        a.mo2450a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1692d != null) {
            this.f1692d.mo2500d();
            this.f1692d.mo2502f();
        }
    }

    public void setContentHeight(int i) {
        this.f1693e = i;
    }

    public void setCustomView(View view) {
        if (this.f1502j != null) {
            removeView(this.f1502j);
        }
        this.f1502j = view;
        if (!(view == null || this.f1503k == null)) {
            removeView(this.f1503k);
            this.f1503k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1499g = charSequence;
        m1884e();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1500h = charSequence;
        m1884e();
    }

    public CharSequence getTitle() {
        return this.f1499g;
    }

    public CharSequence getSubtitle() {
        return this.f1500h;
    }

    /* renamed from: e */
    private void m1884e() {
        if (this.f1503k == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            this.f1503k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1504l = (TextView) this.f1503k.findViewById(R.id.action_bar_title);
            this.f1505m = (TextView) this.f1503k.findViewById(R.id.action_bar_subtitle);
            if (this.f1506n != 0) {
                this.f1504l.setTextAppearance(getContext(), this.f1506n);
            }
            if (this.f1507o != 0) {
                this.f1505m.setTextAppearance(getContext(), this.f1507o);
            }
        }
        this.f1504l.setText(this.f1499g);
        this.f1505m.setText(this.f1500h);
        boolean z = !TextUtils.isEmpty(this.f1499g);
        boolean z2 = !TextUtils.isEmpty(this.f1500h);
        int i = 8;
        this.f1505m.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = this.f1503k;
        if (z || z2) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.f1503k.getParent() == null) {
            addView(this.f1503k);
        }
    }

    /* renamed from: a */
    public void mo1777a(final C0505b bVar) {
        if (this.f1501i == null) {
            this.f1501i = LayoutInflater.from(getContext()).inflate(this.f1509q, this, false);
            addView(this.f1501i);
        } else if (this.f1501i.getParent() == null) {
            addView(this.f1501i);
        }
        this.f1501i.findViewById(R.id.action_mode_close_button).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                bVar.mo1104c();
            }
        });
        C0533h hVar = (C0533h) bVar.mo1101b();
        if (this.f1692d != null) {
            this.f1692d.mo2501e();
        }
        this.f1692d = new C0658c(getContext());
        this.f1692d.mo2495a(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        hVar.addMenuPresenter(this.f1692d, this.f1690b);
        this.f1691c = (ActionMenuView) this.f1692d.mo1412a((ViewGroup) this);
        C0962r.m3557a((View) this.f1691c, (Drawable) null);
        addView(this.f1691c, layoutParams);
    }

    /* renamed from: b */
    public void mo1779b() {
        if (this.f1501i == null) {
            mo1780c();
        }
    }

    /* renamed from: c */
    public void mo1780c() {
        removeAllViews();
        this.f1502j = null;
        this.f1691c = null;
    }

    /* renamed from: a */
    public boolean mo1778a() {
        if (this.f1692d != null) {
            return this.f1692d.mo2499c();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int mode = MeasureSpec.getMode(i);
        int i4 = Ints.MAX_POWER_OF_TWO;
        if (mode != 1073741824) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(" can only be used ");
            sb.append("with android:layout_width=\"match_parent\" (or fill_parent)");
            throw new IllegalStateException(sb.toString());
        } else if (MeasureSpec.getMode(i2) != 0) {
            int size = MeasureSpec.getSize(i);
            if (this.f1693e > 0) {
                i3 = this.f1693e;
            } else {
                i3 = MeasureSpec.getSize(i2);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = i3 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, C1024a.INVALID_ID);
            if (this.f1501i != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1501i.getLayoutParams();
                paddingLeft = mo2140a(this.f1501i, paddingLeft, makeMeasureSpec, 0) - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            if (this.f1691c != null && this.f1691c.getParent() == this) {
                paddingLeft = mo2140a(this.f1691c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f1503k != null && this.f1502j == null) {
                if (this.f1508p) {
                    this.f1503k.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f1503k.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.f1503k.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = mo2140a(this.f1503k, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f1502j != null) {
                LayoutParams layoutParams = this.f1502j.getLayoutParams();
                int i6 = layoutParams.width != -2 ? Ints.MAX_POWER_OF_TWO : C1024a.INVALID_ID;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i4 = C1024a.INVALID_ID;
                }
                if (layoutParams.height >= 0) {
                    i5 = Math.min(layoutParams.height, i5);
                }
                this.f1502j.measure(MeasureSpec.makeMeasureSpec(paddingLeft, i6), MeasureSpec.makeMeasureSpec(i5, i4));
            }
            if (this.f1693e <= 0) {
                int childCount = getChildCount();
                int i7 = 0;
                for (int i8 = 0; i8 < childCount; i8++) {
                    int measuredHeight = getChildAt(i8).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i7) {
                        i7 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i7);
                return;
            }
            setMeasuredDimension(size, i3);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getClass().getSimpleName());
            sb2.append(" can only be used ");
            sb2.append("with android:layout_height=\"wrap_content\"");
            throw new IllegalStateException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = C0656bb.m2314a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f1501i == null || this.f1501i.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1501i.getLayoutParams();
            int i6 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int a2 = m2025a(paddingRight, i6, a);
            i5 = m2025a(a2 + mo2141a(this.f1501i, a2, paddingTop, paddingTop2, a), i7, a);
        }
        if (!(this.f1503k == null || this.f1502j != null || this.f1503k.getVisibility() == 8)) {
            i5 += mo2141a(this.f1503k, i5, paddingTop, paddingTop2, a);
        }
        int i8 = i5;
        if (this.f1502j != null) {
            mo2141a(this.f1502j, i8, paddingTop, paddingTop2, a);
        }
        int paddingLeft = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.f1691c != null) {
            mo2141a(this.f1691c, paddingLeft, paddingTop, paddingTop2, !a);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1499g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1508p) {
            requestLayout();
        }
        this.f1508p = z;
    }

    /* renamed from: d */
    public boolean mo1781d() {
        return this.f1508p;
    }
}
