package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.C0822b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.C0825e;
import androidx.core.p064b.C0870a;
import androidx.core.p070g.C0962r;
import androidx.customview.p072a.C1021a;
import androidx.customview.p073b.C1032c;
import androidx.customview.p073b.C1032c.C1035a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.C2167R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends C0822b<V> {
    private static final int DEF_STYLE_RES = C2167R.style.Widget_Design_BottomSheet_Modal;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    int activePointerId;
    private BottomSheetCallback callback;
    int collapsedOffset;
    private final C1035a dragCallback = new C1035a() {
        public boolean tryCaptureView(View view, int i) {
            boolean z = true;
            if (BottomSheetBehavior.this.state == 1 || BottomSheetBehavior.this.touchingScrollingChild) {
                return false;
            }
            if (BottomSheetBehavior.this.state == 3 && BottomSheetBehavior.this.activePointerId == i) {
                View view2 = BottomSheetBehavior.this.nestedScrollingChildRef != null ? (View) BottomSheetBehavior.this.nestedScrollingChildRef.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            if (BottomSheetBehavior.this.viewRef == null || BottomSheetBehavior.this.viewRef.get() != view) {
                z = false;
            }
            return z;
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.dispatchOnSlide(i2);
        }

        public void onViewDragStateChanged(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:43:0x00e2  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00f3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onViewReleased(android.view.View r8, float r9, float r10) {
            /*
                r7 = this;
                r0 = 0
                r1 = 0
                r2 = 4
                r3 = 6
                r4 = 3
                int r5 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
                if (r5 >= 0) goto L_0x002c
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.fitToContents
                if (r9 == 0) goto L_0x0018
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r9 = r9.fitToContentsOffset
            L_0x0015:
                r2 = 3
                goto L_0x00d4
            L_0x0018:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.halfExpandedOffset
                if (r9 <= r10) goto L_0x002a
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r9.halfExpandedOffset
            L_0x0026:
                r9 = r0
                r2 = 6
                goto L_0x00d4
            L_0x002a:
                r9 = 0
                goto L_0x0015
            L_0x002c:
                com.google.android.material.bottomsheet.BottomSheetBehavior r5 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r5 = r5.hideable
                if (r5 == 0) goto L_0x0057
                com.google.android.material.bottomsheet.BottomSheetBehavior r5 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r5 = r5.shouldHide(r8, r10)
                if (r5 == 0) goto L_0x0057
                int r5 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = r6.collapsedOffset
                if (r5 > r6) goto L_0x0050
                float r5 = java.lang.Math.abs(r9)
                float r6 = java.lang.Math.abs(r10)
                int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                if (r5 >= 0) goto L_0x0057
            L_0x0050:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r9 = r9.parentHeight
                r2 = 5
                goto L_0x00d4
            L_0x0057:
                int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
                if (r1 == 0) goto L_0x006d
                float r9 = java.lang.Math.abs(r9)
                float r10 = java.lang.Math.abs(r10)
                int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
                if (r9 <= 0) goto L_0x0068
                goto L_0x006d
            L_0x0068:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r9 = r9.collapsedOffset
                goto L_0x00d4
            L_0x006d:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r10.fitToContents
                if (r10 == 0) goto L_0x009a
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.fitToContentsOffset
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.collapsedOffset
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x0094
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r9.fitToContentsOffset
                r9 = r0
                goto L_0x0015
            L_0x0094:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r9.collapsedOffset
            L_0x0098:
                r9 = r0
                goto L_0x00d4
            L_0x009a:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.halfExpandedOffset
                if (r9 >= r10) goto L_0x00b4
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.collapsedOffset
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                if (r9 >= r10) goto L_0x00ae
                goto L_0x002a
            L_0x00ae:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r9.halfExpandedOffset
                goto L_0x0026
            L_0x00b4:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.halfExpandedOffset
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.collapsedOffset
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00cf
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r9.halfExpandedOffset
                goto L_0x0026
            L_0x00cf:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r9.collapsedOffset
                goto L_0x0098
            L_0x00d4:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                androidx.customview.b.c r10 = r10.viewDragHelper
                int r0 = r8.getLeft()
                boolean r9 = r10.mo3997a(r0, r9)
                if (r9 == 0) goto L_0x00f3
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                r10 = 2
                r9.setStateInternal(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior$SettleRunnable r9 = new com.google.android.material.bottomsheet.BottomSheetBehavior$SettleRunnable
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                r9.<init>(r8, r2)
                androidx.core.p070g.C0962r.m3562a(r8, r9)
                goto L_0x00f8
            L_0x00f3:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                r8.setStateInternal(r2)
            L_0x00f8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.C21922.onViewReleased(android.view.View, float, float):void");
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return C0870a.m3224a(i, BottomSheetBehavior.this.getExpandedOffset(), BottomSheetBehavior.this.hideable ? BottomSheetBehavior.this.parentHeight : BottomSheetBehavior.this.collapsedOffset);
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return view.getLeft();
        }

        public int getViewVerticalDragRange(View view) {
            if (BottomSheetBehavior.this.hideable) {
                return BottomSheetBehavior.this.parentHeight;
            }
            return BottomSheetBehavior.this.collapsedOffset;
        }
    };
    /* access modifiers changed from: private */
    public boolean fitToContents = true;
    int fitToContentsOffset;
    int halfExpandedOffset;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private int lastNestedScrollDy;
    private int lastPeekHeight;
    private MaterialShapeDrawable materialShapeDrawable;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    int parentHeight;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    private boolean skipCollapsed;
    int state = 4;
    boolean touchingScrollingChild;
    private VelocityTracker velocityTracker;
    C1032c viewDragHelper;
    WeakReference<V> viewRef;

    public static abstract class BottomSheetCallback {
        public abstract void onSlide(View view, float f);

        public abstract void onStateChanged(View view, int i);
    }

    protected static class SavedState extends C1021a {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final int state;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }
    }

    private class SettleRunnable implements Runnable {
        private final int targetState;
        private final View view;

        SettleRunnable(View view2, int i) {
            this.view = view2;
            this.targetState = i;
        }

        public void run() {
            if (BottomSheetBehavior.this.viewDragHelper == null || !BottomSheetBehavior.this.viewDragHelper.mo4000a(true)) {
                BottomSheetBehavior.this.setStateInternal(this.targetState);
            } else {
                C0962r.m3562a(this.view, (Runnable) this);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public BottomSheetBehavior() {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2167R.styleable.BottomSheetBehavior_Layout);
        this.shapeThemingEnabled = obtainStyledAttributes.hasValue(C2167R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean hasValue = obtainStyledAttributes.hasValue(C2167R.styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (hasValue) {
            createMaterialShapeDrawable(context, attributeSet, hasValue, MaterialResources.getColorStateList(context, obtainStyledAttributes, C2167R.styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            createMaterialShapeDrawable(context, attributeSet, hasValue);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(C2167R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(C2167R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            setPeekHeight(peekValue.data);
        }
        setHideable(obtainStyledAttributes.getBoolean(C2167R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setFitToContents(obtainStyledAttributes.getBoolean(C2167R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(C2167R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.maximumVelocity = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), this.state);
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        if (savedState.state == 1 || savedState.state == 2) {
            this.state = 4;
        } else {
            this.state = savedState.state;
        }
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (C0962r.m3596s(coordinatorLayout) && !C0962r.m3596s(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.shapeThemingEnabled && this.materialShapeDrawable != null) {
            C0962r.m3557a((View) v, (Drawable) this.materialShapeDrawable);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i);
        this.parentHeight = coordinatorLayout.getHeight();
        if (this.peekHeightAuto) {
            if (this.peekHeightMin == 0) {
                this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(C2167R.dimen.design_bottom_sheet_peek_height_min);
            }
            this.lastPeekHeight = Math.max(this.peekHeightMin, this.parentHeight - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.lastPeekHeight = this.peekHeight;
        }
        this.fitToContentsOffset = Math.max(0, this.parentHeight - v.getHeight());
        this.halfExpandedOffset = this.parentHeight / 2;
        calculateCollapsedOffset();
        if (this.state == 3) {
            C0962r.m3580f(v, getExpandedOffset());
        } else if (this.state == 6) {
            C0962r.m3580f(v, this.halfExpandedOffset);
        } else if (this.hideable && this.state == 5) {
            C0962r.m3580f(v, this.parentHeight);
        } else if (this.state == 4) {
            C0962r.m3580f(v, this.collapsedOffset);
        } else if (this.state == 1 || this.state == 2) {
            C0962r.m3580f(v, top - v.getTop());
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = C1032c.m3918a((ViewGroup) coordinatorLayout, this.dragCallback);
        }
        this.viewRef = new WeakReference<>(v);
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v));
        return true;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = false;
        if (!v.isShown()) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        View view = null;
        if (actionMasked != 3) {
            switch (actionMasked) {
                case 0:
                    int x = (int) motionEvent.getX();
                    this.initialY = (int) motionEvent.getY();
                    View view2 = this.nestedScrollingChildRef != null ? (View) this.nestedScrollingChildRef.get() : null;
                    if (view2 != null && coordinatorLayout.isPointInChildBounds(view2, x, this.initialY)) {
                        this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.touchingScrollingChild = true;
                    }
                    this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.initialY);
                    break;
                case 1:
                    break;
            }
        }
        this.touchingScrollingChild = false;
        this.activePointerId = -1;
        if (this.ignoreEvents) {
            this.ignoreEvents = false;
            return false;
        }
        if (!this.ignoreEvents && this.viewDragHelper != null && this.viewDragHelper.mo3998a(motionEvent)) {
            return true;
        }
        if (this.nestedScrollingChildRef != null) {
            view = (View) this.nestedScrollingChildRef.get();
        }
        if (actionMasked == 2 && view != null && !this.ignoreEvents && this.state != 1 && !coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY()) && this.viewDragHelper != null && Math.abs(((float) this.initialY) - motionEvent.getY()) > ((float) this.viewDragHelper.mo4001b())) {
            z = true;
        }
        return z;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        if (this.viewDragHelper != null) {
            this.viewDragHelper.mo4003b(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.ignoreEvents && Math.abs(((float) this.initialY) - motionEvent.getY()) > ((float) this.viewDragHelper.mo4001b())) {
            this.viewDragHelper.mo3995a((View) v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 != 1) {
            if (view == (this.nestedScrollingChildRef != null ? (View) this.nestedScrollingChildRef.get() : null)) {
                int top = v.getTop();
                int i4 = top - i2;
                if (i2 > 0) {
                    if (i4 < getExpandedOffset()) {
                        iArr[1] = top - getExpandedOffset();
                        C0962r.m3580f(v, -iArr[1]);
                        setStateInternal(3);
                    } else {
                        iArr[1] = i2;
                        C0962r.m3580f(v, -i2);
                        setStateInternal(1);
                    }
                } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                    if (i4 <= this.collapsedOffset || this.hideable) {
                        iArr[1] = i2;
                        C0962r.m3580f(v, -i2);
                        setStateInternal(1);
                    } else {
                        iArr[1] = top - this.collapsedOffset;
                        C0962r.m3580f(v, -iArr[1]);
                        setStateInternal(4);
                    }
                }
                dispatchOnSlide(v.getTop());
                this.lastNestedScrollDy = i2;
                this.nestedScrolled = true;
            }
        }
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        int i2;
        int i3;
        int i4 = 3;
        if (v.getTop() == getExpandedOffset()) {
            setStateInternal(3);
        } else if (this.nestedScrollingChildRef != null && view == this.nestedScrollingChildRef.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                i2 = getExpandedOffset();
            } else if (!this.hideable || !shouldHide(v, getYVelocity())) {
                if (this.lastNestedScrollDy == 0) {
                    int top = v.getTop();
                    if (!this.fitToContents) {
                        if (top < this.halfExpandedOffset) {
                            if (top < Math.abs(top - this.collapsedOffset)) {
                                i2 = 0;
                            } else {
                                i2 = this.halfExpandedOffset;
                            }
                        } else if (Math.abs(top - this.halfExpandedOffset) < Math.abs(top - this.collapsedOffset)) {
                            i2 = this.halfExpandedOffset;
                        } else {
                            i3 = this.collapsedOffset;
                        }
                        i4 = 6;
                    } else if (Math.abs(top - this.fitToContentsOffset) < Math.abs(top - this.collapsedOffset)) {
                        i2 = this.fitToContentsOffset;
                    } else {
                        i3 = this.collapsedOffset;
                    }
                } else {
                    i3 = this.collapsedOffset;
                }
                i4 = 4;
            } else {
                i2 = this.parentHeight;
                i4 = 5;
            }
            if (this.viewDragHelper.mo3999a((View) v, v.getLeft(), i2)) {
                setStateInternal(2);
                C0962r.m3562a((View) v, (Runnable) new SettleRunnable(v, i4));
            } else {
                setStateInternal(i4);
            }
            this.nestedScrolled = false;
        }
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        boolean z = false;
        if (this.nestedScrollingChildRef == null) {
            return false;
        }
        if (view == this.nestedScrollingChildRef.get() && (this.state != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2))) {
            z = true;
        }
        return z;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public void setFitToContents(boolean z) {
        if (this.fitToContents != z) {
            this.fitToContents = z;
            if (this.viewRef != null) {
                calculateCollapsedOffset();
            }
            setStateInternal((!this.fitToContents || this.state != 6) ? this.state : 3);
        }
    }

    public final void setPeekHeight(int i) {
        setPeekHeight(i, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setPeekHeight(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto L_0x000c
            boolean r4 = r3.peekHeightAuto
            if (r4 != 0) goto L_0x0015
            r3.peekHeightAuto = r0
            goto L_0x0024
        L_0x000c:
            boolean r2 = r3.peekHeightAuto
            if (r2 != 0) goto L_0x0017
            int r2 = r3.peekHeight
            if (r2 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x0024
        L_0x0017:
            r3.peekHeightAuto = r1
            int r1 = java.lang.Math.max(r1, r4)
            r3.peekHeight = r1
            int r1 = r3.parentHeight
            int r1 = r1 - r4
            r3.collapsedOffset = r1
        L_0x0024:
            if (r0 == 0) goto L_0x0044
            int r4 = r3.state
            r0 = 4
            if (r4 != r0) goto L_0x0044
            java.lang.ref.WeakReference<V> r4 = r3.viewRef
            if (r4 == 0) goto L_0x0044
            java.lang.ref.WeakReference<V> r4 = r3.viewRef
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L_0x0044
            if (r5 == 0) goto L_0x0041
            int r4 = r3.state
            r3.startSettlingAnimationPendingLayout(r4)
            goto L_0x0044
        L_0x0041:
            r4.requestLayout()
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.setPeekHeight(int, boolean):void");
    }

    public final int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    public void setHideable(boolean z) {
        this.hideable = z;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public void setSkipCollapsed(boolean z) {
        this.skipCollapsed = z;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.callback = bottomSheetCallback;
    }

    public final void setState(int i) {
        if (i != this.state) {
            if (this.viewRef == null) {
                if (i == 4 || i == 3 || i == 6 || (this.hideable && i == 5)) {
                    this.state = i;
                }
                return;
            }
            startSettlingAnimationPendingLayout(i);
        }
    }

    private void startSettlingAnimationPendingLayout(final int i) {
        final View view = (View) this.viewRef.get();
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null || !parent.isLayoutRequested() || !C0962r.m3543C(view)) {
                startSettlingAnimation(view, i);
            } else {
                view.post(new Runnable() {
                    public void run() {
                        BottomSheetBehavior.this.startSettlingAnimation(view, i);
                    }
                });
            }
        }
    }

    public final int getState() {
        return this.state;
    }

    /* access modifiers changed from: 0000 */
    public void setStateInternal(int i) {
        if (this.state != i) {
            this.state = i;
            if (this.viewRef != null) {
                View view = (View) this.viewRef.get();
                if (view != null) {
                    if (i == 6 || i == 3) {
                        updateImportantForAccessibility(true);
                    } else if (i == 5 || i == 4) {
                        updateImportantForAccessibility(false);
                    }
                    C0962r.m3569b(view, 1);
                    view.sendAccessibilityEvent(32);
                    updateDrawableOnStateChange(i);
                    if (this.callback != null) {
                        this.callback.onStateChanged(view, i);
                    }
                }
            }
        }
    }

    private void updateDrawableOnStateChange(int i) {
        if (this.materialShapeDrawable != null) {
            if (i == 3 && this.parentHeight <= ((View) this.viewRef.get()).getHeight()) {
                this.materialShapeDrawable.getShapeAppearanceModel().setCornerRadius(BitmapDescriptorFactory.HUE_RED);
                this.materialShapeDrawable.invalidateSelf();
            }
            if (i == 4 || i == 1) {
                this.materialShapeDrawable.setShapeAppearanceModel(this.shapeAppearanceModelDefault);
            }
        }
    }

    private void calculateCollapsedOffset() {
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - this.lastPeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - this.lastPeekHeight;
        }
    }

    private void reset() {
        this.activePointerId = -1;
        if (this.velocityTracker != null) {
            this.velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldHide(View view, float f) {
        boolean z = true;
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (f * HIDE_FRICTION)) - ((float) this.collapsedOffset)) / ((float) this.peekHeight) <= HIDE_THRESHOLD) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public View findScrollingChild(View view) {
        if (C0962r.m3601x(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i));
                if (findScrollingChild != null) {
                    return findScrollingChild;
                }
            }
        }
        return null;
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z) {
        createMaterialShapeDrawable(context, attributeSet, z, null);
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = new ShapeAppearanceModel(context, attributeSet, C2167R.attr.bottomSheetStyle, DEF_STYLE_RES);
            this.materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            if (!z || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.materialShapeDrawable.setTint(typedValue.data);
                return;
            }
            this.materialShapeDrawable.setFillColor(colorStateList);
        }
    }

    private float getYVelocity() {
        if (this.velocityTracker == null) {
            return BitmapDescriptorFactory.HUE_RED;
        }
        this.velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    /* access modifiers changed from: private */
    public int getExpandedOffset() {
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public void startSettlingAnimation(View view, int i) {
        int i2;
        if (i == 4) {
            i2 = this.collapsedOffset;
        } else if (i == 6) {
            int i3 = this.halfExpandedOffset;
            if (!this.fitToContents || i3 > this.fitToContentsOffset) {
                i2 = i3;
            } else {
                i2 = this.fitToContentsOffset;
                i = 3;
            }
        } else if (i == 3) {
            i2 = getExpandedOffset();
        } else if (!this.hideable || i != 5) {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal state argument: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else {
            i2 = this.parentHeight;
        }
        if (this.viewDragHelper.mo3999a(view, view.getLeft(), i2)) {
            setStateInternal(2);
            C0962r.m3562a(view, (Runnable) new SettleRunnable(view, i));
            return;
        }
        setStateInternal(i);
    }

    /* access modifiers changed from: 0000 */
    public void dispatchOnSlide(int i) {
        View view = (View) this.viewRef.get();
        if (view != null && this.callback != null) {
            if (i > this.collapsedOffset) {
                this.callback.onSlide(view, ((float) (this.collapsedOffset - i)) / ((float) (this.parentHeight - this.collapsedOffset)));
            } else {
                this.callback.onSlide(view, ((float) (this.collapsedOffset - i)) / ((float) (this.collapsedOffset - getExpandedOffset())));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v) {
        LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof C0825e) {
            C0822b b = ((C0825e) layoutParams).mo3420b();
            if (b instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) b;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private void updateImportantForAccessibility(boolean z) {
        if (this.viewRef != null) {
            ViewParent parent = ((View) this.viewRef.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (VERSION.SDK_INT >= 16 && z) {
                    if (this.importantForAccessibilityMap == null) {
                        this.importantForAccessibilityMap = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i = 0; i < childCount; i++) {
                    View childAt = coordinatorLayout.getChildAt(i);
                    if (childAt != this.viewRef.get()) {
                        if (z) {
                            if (VERSION.SDK_INT >= 16) {
                                this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            }
                            C0962r.m3569b(childAt, 4);
                        } else if (this.importantForAccessibilityMap != null && this.importantForAccessibilityMap.containsKey(childAt)) {
                            C0962r.m3569b(childAt, ((Integer) this.importantForAccessibilityMap.get(childAt)).intValue());
                        }
                    }
                }
                if (!z) {
                    this.importantForAccessibilityMap = null;
                }
            }
        }
    }
}
