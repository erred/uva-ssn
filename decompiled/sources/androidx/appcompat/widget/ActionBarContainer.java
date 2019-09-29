package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import androidx.core.p070g.C0962r;
import androidx.customview.p073b.C1024a;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.api.client.googleapis.media.MediaHttpUploader;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: a */
    Drawable f1489a;

    /* renamed from: b */
    Drawable f1490b;

    /* renamed from: c */
    Drawable f1491c;

    /* renamed from: d */
    boolean f1492d;

    /* renamed from: e */
    boolean f1493e;

    /* renamed from: f */
    private boolean f1494f;

    /* renamed from: g */
    private View f1495g;

    /* renamed from: h */
    private View f1496h;

    /* renamed from: i */
    private View f1497i;

    /* renamed from: j */
    private int f1498j;

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0962r.m3557a((View) this, (Drawable) new C0654b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.f1489a = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.f1490b = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.f1498j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        if (getId() == R.id.split_action_bar) {
            this.f1492d = true;
            this.f1491c = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.f1492d ? this.f1489a == null && this.f1490b == null : this.f1491c == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1496h = findViewById(R.id.action_bar);
        this.f1497i = findViewById(R.id.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        if (this.f1489a != null) {
            this.f1489a.setCallback(null);
            unscheduleDrawable(this.f1489a);
        }
        this.f1489a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1496h != null) {
                this.f1489a.setBounds(this.f1496h.getLeft(), this.f1496h.getTop(), this.f1496h.getRight(), this.f1496h.getBottom());
            }
        }
        boolean z = false;
        if (!this.f1492d ? this.f1489a == null && this.f1490b == null : this.f1491c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        if (this.f1490b != null) {
            this.f1490b.setCallback(null);
            unscheduleDrawable(this.f1490b);
        }
        this.f1490b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1493e && this.f1490b != null) {
                this.f1490b.setBounds(this.f1495g.getLeft(), this.f1495g.getTop(), this.f1495g.getRight(), this.f1495g.getBottom());
            }
        }
        boolean z = false;
        if (!this.f1492d ? this.f1489a == null && this.f1490b == null : this.f1491c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        if (this.f1491c != null) {
            this.f1491c.setCallback(null);
            unscheduleDrawable(this.f1491c);
        }
        this.f1491c = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1492d && this.f1491c != null) {
                this.f1491c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1492d ? this.f1489a == null && this.f1490b == null : this.f1491c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f1489a != null) {
            this.f1489a.setVisible(z, false);
        }
        if (this.f1490b != null) {
            this.f1490b.setVisible(z, false);
        }
        if (this.f1491c != null) {
            this.f1491c.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1489a && !this.f1492d) || (drawable == this.f1490b && this.f1493e) || ((drawable == this.f1491c && this.f1492d) || super.verifyDrawable(drawable));
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1489a != null && this.f1489a.isStateful()) {
            this.f1489a.setState(getDrawableState());
        }
        if (this.f1490b != null && this.f1490b.isStateful()) {
            this.f1490b.setState(getDrawableState());
        }
        if (this.f1491c != null && this.f1491c.isStateful()) {
            this.f1491c.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f1489a != null) {
            this.f1489a.jumpToCurrentState();
        }
        if (this.f1490b != null) {
            this.f1490b.jumpToCurrentState();
        }
        if (this.f1491c != null) {
            this.f1491c.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean z) {
        this.f1494f = z;
        setDescendantFocusability(z ? 393216 : MediaHttpUploader.MINIMUM_CHUNK_SIZE);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1494f || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(C0631an anVar) {
        if (this.f1495g != null) {
            removeView(this.f1495g);
        }
        this.f1495g = anVar;
        if (anVar != null) {
            addView(anVar);
            LayoutParams layoutParams = anVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            anVar.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.f1495g;
    }

    public ActionMode startActionModeForChild(View view, Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    /* renamed from: a */
    private boolean m1882a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* renamed from: b */
    private int m1883b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public void onMeasure(int i, int i2) {
        if (this.f1496h == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f1498j >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.f1498j, MeasureSpec.getSize(i2)), C1024a.INVALID_ID);
        }
        super.onMeasure(i, i2);
        if (this.f1496h != null) {
            int mode = MeasureSpec.getMode(i2);
            if (!(this.f1495g == null || this.f1495g.getVisibility() == 8 || mode == 1073741824)) {
                int i3 = !m1882a(this.f1496h) ? m1883b(this.f1496h) : !m1882a(this.f1497i) ? m1883b(this.f1497i) : 0;
                setMeasuredDimension(getMeasuredWidth(), Math.min(i3 + m1883b(this.f1495g), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : BaseClientBuilder.API_PRIORITY_OTHER));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f1495g;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f1492d) {
            if (this.f1489a != null) {
                if (this.f1496h.getVisibility() == 0) {
                    this.f1489a.setBounds(this.f1496h.getLeft(), this.f1496h.getTop(), this.f1496h.getRight(), this.f1496h.getBottom());
                } else if (this.f1497i == null || this.f1497i.getVisibility() != 0) {
                    this.f1489a.setBounds(0, 0, 0, 0);
                } else {
                    this.f1489a.setBounds(this.f1497i.getLeft(), this.f1497i.getTop(), this.f1497i.getRight(), this.f1497i.getBottom());
                }
                z3 = true;
            }
            this.f1493e = z4;
            if (!z4 || this.f1490b == null) {
                z2 = z3;
            } else {
                this.f1490b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f1491c != null) {
            this.f1491c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            z2 = false;
        }
        if (z2) {
            invalidate();
        }
    }
}
