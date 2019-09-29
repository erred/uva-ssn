package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.C0825e;
import androidx.core.p064b.C0870a;
import androidx.core.p070g.C0946c;
import androidx.core.p070g.C0962r;
import androidx.core.p070g.C0976z;
import androidx.customview.p073b.C1024a;
import com.google.common.primitives.Ints;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    private int overlayTop;
    final Rect tempRect1 = new Rect();
    final Rect tempRect2 = new Rect();
    private int verticalLayoutGap = 0;

    private static int resolveGravity(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    public abstract View findFirstDependency(List<View> list);

    /* access modifiers changed from: 0000 */
    public float getOverlapRatioForOffset(View view) {
        return 1.0f;
    }

    /* access modifiers changed from: protected */
    public boolean shouldHeaderOverlapScrollingChild() {
        return false;
    }

    public HeaderScrollingViewBehavior() {
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
            if (findFirstDependency != null) {
                if (C0962r.m3596s(findFirstDependency) && !C0962r.m3596s(view)) {
                    C0962r.m3570b(view, true);
                    if (C0962r.m3596s(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                int size = MeasureSpec.getSize(i3);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                int scrollRange = size + getScrollRange(findFirstDependency);
                int measuredHeight = findFirstDependency.getMeasuredHeight();
                if (shouldHeaderOverlapScrollingChild()) {
                    view.setTranslationY((float) (-measuredHeight));
                } else {
                    scrollRange -= measuredHeight;
                }
                coordinatorLayout.onMeasureChild(view, i, i2, MeasureSpec.makeMeasureSpec(scrollRange, i5 == -1 ? Ints.MAX_POWER_OF_TWO : C1024a.INVALID_ID), i4);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        View findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
        if (findFirstDependency != null) {
            C0825e eVar = (C0825e) view.getLayoutParams();
            Rect rect = this.tempRect1;
            rect.set(coordinatorLayout.getPaddingLeft() + eVar.leftMargin, findFirstDependency.getBottom() + eVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - eVar.rightMargin, ((coordinatorLayout.getHeight() + findFirstDependency.getBottom()) - coordinatorLayout.getPaddingBottom()) - eVar.bottomMargin);
            C0976z lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && C0962r.m3596s(coordinatorLayout) && !C0962r.m3596s(view)) {
                rect.left += lastWindowInsets.mo3776a();
                rect.right -= lastWindowInsets.mo3779c();
            }
            Rect rect2 = this.tempRect2;
            C0946c.m3494a(resolveGravity(eVar.f2691c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int overlapPixelsForOffset = getOverlapPixelsForOffset(findFirstDependency);
            view.layout(rect2.left, rect2.top - overlapPixelsForOffset, rect2.right, rect2.bottom - overlapPixelsForOffset);
            this.verticalLayoutGap = rect2.top - findFirstDependency.getBottom();
            return;
        }
        super.layoutChild(coordinatorLayout, view, i);
        this.verticalLayoutGap = 0;
    }

    /* access modifiers changed from: 0000 */
    public final int getOverlapPixelsForOffset(View view) {
        if (this.overlayTop == 0) {
            return 0;
        }
        return C0870a.m3224a((int) (getOverlapRatioForOffset(view) * ((float) this.overlayTop)), 0, this.overlayTop);
    }

    /* access modifiers changed from: 0000 */
    public int getScrollRange(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: 0000 */
    public final int getVerticalLayoutGap() {
        return this.verticalLayoutGap;
    }

    public final void setOverlayTop(int i) {
        this.overlayTop = i;
    }

    public final int getOverlayTop() {
        return this.overlayTop;
    }
}
