package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import androidx.appcompat.R;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {

    /* renamed from: a */
    private int f1684a;

    /* renamed from: b */
    private int f1685b;

    /* renamed from: c */
    private WeakReference<View> f1686c;

    /* renamed from: d */
    private LayoutInflater f1687d;

    /* renamed from: e */
    private C0601a f1688e;

    /* renamed from: androidx.appcompat.widget.ViewStubCompat$a */
    public interface C0601a {
        /* renamed from: a */
        void mo2139a(ViewStubCompat viewStubCompat, View view);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1684a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewStubCompat, i, 0);
        this.f1685b = obtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
        this.f1684a = obtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public int getInflatedId() {
        return this.f1685b;
    }

    public void setInflatedId(int i) {
        this.f1685b = i;
    }

    public int getLayoutResource() {
        return this.f1684a;
    }

    public void setLayoutResource(int i) {
        this.f1684a = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1687d = layoutInflater;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1687d;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setVisibility(int i) {
        if (this.f1686c != null) {
            View view = (View) this.f1686c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            mo2127a();
        }
    }

    /* renamed from: a */
    public View mo2127a() {
        LayoutInflater layoutInflater;
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f1684a != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (this.f1687d != null) {
                layoutInflater = this.f1687d;
            } else {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f1684a, viewGroup, false);
            if (this.f1685b != -1) {
                inflate.setId(this.f1685b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f1686c = new WeakReference<>(inflate);
            if (this.f1688e != null) {
                this.f1688e.mo2139a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public void setOnInflateListener(C0601a aVar) {
        this.f1688e = aVar;
    }
}
