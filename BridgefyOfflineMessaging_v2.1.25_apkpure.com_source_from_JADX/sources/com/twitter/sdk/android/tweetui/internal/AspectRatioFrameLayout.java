package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.google.common.primitives.Ints;
import com.twitter.sdk.android.tweetui.R;

public class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: a */
    protected double f8676a;

    /* renamed from: b */
    private int f8677b;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9692a(i);
    }

    /* renamed from: a */
    private void m9692a(int i) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(i, R.styleable.AspectRatioFrameLayout);
        try {
            this.f8676a = (double) obtainStyledAttributes.getFloat(R.styleable.AspectRatioFrameLayout_tw__frame_layout_aspect_ratio, 1.0f);
            this.f8677b = obtainStyledAttributes.getInt(R.styleable.AspectRatioFrameLayout_tw__frame_layout_dimension_to_adjust, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setAspectRatio(double d) {
        this.f8676a = d;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int measuredHeight;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.f8677b == 0) {
            if (MeasureSpec.getMode(i) == 1073741824) {
                i4 = MeasureSpec.getSize(i) - paddingLeft;
            } else {
                super.onMeasure(i, i2);
                i4 = getMeasuredWidth() - paddingLeft;
            }
            i3 = (int) (((double) i4) / this.f8676a);
        } else {
            if (MeasureSpec.getMode(i2) == 1073741824) {
                measuredHeight = MeasureSpec.getSize(i2) - paddingBottom;
            } else {
                super.onMeasure(i, i2);
                measuredHeight = getMeasuredHeight() - paddingBottom;
            }
            i3 = measuredHeight;
            i4 = (int) (((double) i3) * this.f8676a);
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(i4 + paddingLeft, Ints.MAX_POWER_OF_TWO), MeasureSpec.makeMeasureSpec(i3 + paddingBottom, Ints.MAX_POWER_OF_TWO));
    }
}
