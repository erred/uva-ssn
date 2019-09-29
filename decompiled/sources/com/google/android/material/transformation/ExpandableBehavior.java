package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.C0822b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.C0825e;
import androidx.core.p070g.C0962r;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

public abstract class ExpandableBehavior extends C0822b<View> {
    private static final int STATE_COLLAPSED = 2;
    private static final int STATE_EXPANDED = 1;
    private static final int STATE_UNINITIALIZED = 0;
    /* access modifiers changed from: private */
    public int currentState = 0;

    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* access modifiers changed from: protected */
    public abstract boolean onExpandedStateChange(View view, View view2, boolean z, boolean z2);

    public ExpandableBehavior() {
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, final View view, int i) {
        if (!C0962r.m3603z(view)) {
            final ExpandableWidget findExpandableWidget = findExpandableWidget(coordinatorLayout, view);
            if (findExpandableWidget != null && didStateChange(findExpandableWidget.isExpanded())) {
                this.currentState = findExpandableWidget.isExpanded() ? 1 : 2;
                final int i2 = this.currentState;
                view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                    public boolean onPreDraw() {
                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (ExpandableBehavior.this.currentState == i2) {
                            ExpandableBehavior.this.onExpandedStateChange((View) findExpandableWidget, view, findExpandableWidget.isExpanded(), false);
                        }
                        return false;
                    }
                });
            }
        }
        return false;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        if (!didStateChange(expandableWidget.isExpanded())) {
            return false;
        }
        this.currentState = expandableWidget.isExpanded() ? 1 : 2;
        return onExpandedStateChange((View) expandableWidget, view, expandableWidget.isExpanded(), true);
    }

    /* access modifiers changed from: protected */
    public ExpandableWidget findExpandableWidget(CoordinatorLayout coordinatorLayout, View view) {
        List dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) dependencies.get(i);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (ExpandableWidget) view2;
            }
        }
        return null;
    }

    private boolean didStateChange(boolean z) {
        boolean z2 = false;
        if (z) {
            if (this.currentState == 0 || this.currentState == 2) {
                z2 = true;
            }
            return z2;
        }
        if (this.currentState == 1) {
            z2 = true;
        }
        return z2;
    }

    public static <T extends ExpandableBehavior> T from(View view, Class<T> cls) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof C0825e) {
            C0822b b = ((C0825e) layoutParams).mo3420b();
            if (b instanceof ExpandableBehavior) {
                return (ExpandableBehavior) cls.cast(b);
            }
            throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
}
