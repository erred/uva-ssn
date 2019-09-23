package androidx.customview.p073b;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.p070g.C0932a;
import androidx.core.p070g.C0962r;
import androidx.core.p070g.C0968u;
import androidx.core.p070g.p071a.C0934a;
import androidx.core.p070g.p071a.C0935b;
import androidx.core.p070g.p071a.C0939c;
import androidx.core.p070g.p071a.C0942d;
import androidx.customview.p073b.C1028b.C1029a;
import androidx.customview.p073b.C1028b.C1030b;
import androidx.p052b.C0726h;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.customview.b.a */
/* compiled from: ExploreByTouchHelper */
public abstract class C1024a extends C0932a {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(BaseClientBuilder.API_PRIORITY_OTHER, BaseClientBuilder.API_PRIORITY_OTHER, INVALID_ID, INVALID_ID);
    private static final C1029a<C0935b> NODE_ADAPTER = new C1029a<C0935b>() {
        /* renamed from: a */
        public void mo3988a(C0935b bVar, Rect rect) {
            bVar.mo3670a(rect);
        }
    };
    private static final C1030b<C0726h<C0935b>, C0935b> SPARSE_VALUES_ADAPTER = new C1030b<C0726h<C0935b>, C0935b>() {
        /* renamed from: a */
        public C0935b mo3992a(C0726h<C0935b> hVar, int i) {
            return (C0935b) hVar.mo2905e(i);
        }

        /* renamed from: a */
        public int mo3990a(C0726h<C0935b> hVar) {
            return hVar.mo2897b();
        }
    };
    int mAccessibilityFocusedVirtualViewId = INVALID_ID;
    private final View mHost;
    private int mHoveredVirtualViewId = INVALID_ID;
    int mKeyboardFocusedVirtualViewId = INVALID_ID;
    private final AccessibilityManager mManager;
    private C1027a mNodeProvider;
    private final int[] mTempGlobalRect = new int[2];
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();

    /* renamed from: androidx.customview.b.a$a */
    /* compiled from: ExploreByTouchHelper */
    private class C1027a extends C0939c {
        C1027a() {
        }

        /* renamed from: a */
        public C0935b mo3721a(int i) {
            return C0935b.m3415a(C1024a.this.obtainAccessibilityNodeInfo(i));
        }

        /* renamed from: a */
        public boolean mo3724a(int i, int i2, Bundle bundle) {
            return C1024a.this.performAction(i, i2, bundle);
        }

        /* renamed from: b */
        public C0935b mo3725b(int i) {
            int i2 = i == 2 ? C1024a.this.mAccessibilityFocusedVirtualViewId : C1024a.this.mKeyboardFocusedVirtualViewId;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return mo3721a(i2);
        }
    }

    private static int keyToDirection(int i) {
        switch (i) {
            case 19:
                return 33;
            case 21:
                return 17;
            case 22:
                return 66;
            default:
                return 130;
        }
    }

    /* access modifiers changed from: protected */
    public abstract int getVirtualViewAt(float f, float f2);

    /* access modifiers changed from: protected */
    public abstract void getVisibleVirtualViews(List<Integer> list);

    /* access modifiers changed from: protected */
    public abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    /* access modifiers changed from: protected */
    public void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void onPopulateNodeForHost(C0935b bVar) {
    }

    /* access modifiers changed from: protected */
    public abstract void onPopulateNodeForVirtualView(int i, C0935b bVar);

    /* access modifiers changed from: protected */
    public void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
    }

    public C1024a(View view) {
        if (view != null) {
            this.mHost = view;
            this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (C0962r.m3577e(view) == 0) {
                C0962r.m3569b(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    public C0939c getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new C1027a();
        }
        return this.mNodeProvider;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            switch (action) {
                case 9:
                    break;
                case 10:
                    if (this.mHoveredVirtualViewId == Integer.MIN_VALUE) {
                        return false;
                    }
                    updateHoveredVirtualView(INVALID_ID);
                    return true;
                default:
                    return false;
            }
        }
        int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
        updateHoveredVirtualView(virtualViewAt);
        if (virtualViewAt != Integer.MIN_VALUE) {
            z = true;
        }
        return z;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int keyToDirection = keyToDirection(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z = false;
                        while (i < repeatCount && moveFocus(keyToDirection, null)) {
                            i++;
                            z = true;
                        }
                        return z;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            clickKeyboardFocusedVirtualView();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return moveFocus(2, null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return moveFocus(1, null);
            }
            return false;
        }
    }

    public final void onFocusChanged(boolean z, int i, Rect rect) {
        if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
        }
        if (z) {
            moveFocus(i, rect);
        }
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    private void getBoundsInParent(int i, Rect rect) {
        obtainAccessibilityNodeInfo(i).mo3670a(rect);
    }

    private boolean moveFocus(int i, Rect rect) {
        C0935b bVar;
        C0935b bVar2;
        C0726h allNodes = getAllNodes();
        int i2 = this.mKeyboardFocusedVirtualViewId;
        int i3 = INVALID_ID;
        if (i2 == Integer.MIN_VALUE) {
            bVar = null;
        } else {
            bVar = (C0935b) allNodes.mo2895a(i2);
        }
        C0935b bVar3 = bVar;
        if (i == 17 || i == 33 || i == 66 || i == 130) {
            Rect rect2 = new Rect();
            if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
                getBoundsInParent(this.mKeyboardFocusedVirtualViewId, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                guessPreviouslyFocusedRect(this.mHost, i, rect2);
            }
            bVar2 = (C0935b) C1028b.m3897a(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, bVar3, rect2, i);
        } else {
            switch (i) {
                case 1:
                case 2:
                    bVar2 = (C0935b) C1028b.m3896a(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, bVar3, i, C0962r.m3579f(this.mHost) == 1, false);
                    break;
                default:
                    throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
        }
        if (bVar2 != null) {
            i3 = allNodes.mo2904d(allNodes.mo2893a(bVar2));
        }
        return requestKeyboardFocusForVirtualView(i3);
    }

    private C0726h<C0935b> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        C0726h<C0935b> hVar = new C0726h<>();
        for (int i = 0; i < arrayList.size(); i++) {
            hVar.mo2899b(i, createNodeForChild(i));
        }
        return hVar;
    }

    private static Rect guessPreviouslyFocusedRect(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        return this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE && onPerformActionForVirtualView(this.mKeyboardFocusedVirtualViewId, 16, null);
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled()) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        if (parent == null) {
            return false;
        }
        return C0968u.m3625a(parent, this.mHost, createEvent(i, i2));
    }

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i) {
        invalidateVirtualView(i, 0);
    }

    public final void invalidateVirtualView(int i, int i2) {
        if (i != Integer.MIN_VALUE && this.mManager.isEnabled()) {
            ViewParent parent = this.mHost.getParent();
            if (parent != null) {
                AccessibilityEvent createEvent = createEvent(i, 2048);
                C0934a.m3412a(createEvent, i2);
                C0968u.m3625a(parent, this.mHost, createEvent);
            }
        }
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    private void updateHoveredVirtualView(int i) {
        if (this.mHoveredVirtualViewId != i) {
            int i2 = this.mHoveredVirtualViewId;
            this.mHoveredVirtualViewId = i;
            sendEventForVirtualView(i, 128);
            sendEventForVirtualView(i2, 256);
        }
    }

    private AccessibilityEvent createEvent(int i, int i2) {
        if (i != -1) {
            return createEventForChild(i, i2);
        }
        return createEventForHost(i2);
    }

    private AccessibilityEvent createEventForHost(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    private AccessibilityEvent createEventForChild(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        C0935b obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
        obtain.getText().add(obtainAccessibilityNodeInfo.mo3715q());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.mo3716r());
        obtain.setScrollable(obtainAccessibilityNodeInfo.mo3712n());
        obtain.setPassword(obtainAccessibilityNodeInfo.mo3711m());
        obtain.setEnabled(obtainAccessibilityNodeInfo.mo3710l());
        obtain.setChecked(obtainAccessibilityNodeInfo.mo3697f());
        onPopulateEventForVirtualView(i, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(obtainAccessibilityNodeInfo.mo3714p());
            C0942d.m3478a(obtain, this.mHost, i);
            obtain.setPackageName(this.mHost.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    /* access modifiers changed from: 0000 */
    public C0935b obtainAccessibilityNodeInfo(int i) {
        if (i == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(i);
    }

    private C0935b createNodeForHost() {
        C0935b a = C0935b.m3413a(this.mHost);
        C0962r.m3558a(this.mHost, a);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (a.mo3682c() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                a.mo3678b(this.mHost, ((Integer) arrayList.get(i)).intValue());
            }
            return a;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0935b bVar) {
        super.onInitializeAccessibilityNodeInfo(view, bVar);
        onPopulateNodeForHost(bVar);
    }

    private C0935b createNodeForChild(int i) {
        C0935b b = C0935b.m3417b();
        b.mo3700h(true);
        b.mo3686c(true);
        b.mo3679b((CharSequence) DEFAULT_CLASS_NAME);
        b.mo3676b(INVALID_PARENT_BOUNDS);
        b.mo3688d(INVALID_PARENT_BOUNDS);
        b.mo3677b(this.mHost);
        onPopulateNodeForVirtualView(i, b);
        if (b.mo3715q() == null && b.mo3716r() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        b.mo3670a(this.mTempParentRect);
        if (!this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
            int d = b.mo3687d();
            if ((d & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((d & 128) == 0) {
                b.mo3673a((CharSequence) this.mHost.getContext().getPackageName());
                b.mo3671a(this.mHost, i);
                if (this.mAccessibilityFocusedVirtualViewId == i) {
                    b.mo3696f(true);
                    b.mo3669a(128);
                } else {
                    b.mo3696f(false);
                    b.mo3669a(64);
                }
                boolean z = this.mKeyboardFocusedVirtualViewId == i;
                if (z) {
                    b.mo3669a(2);
                } else if (b.mo3699g()) {
                    b.mo3669a(1);
                }
                b.mo3690d(z);
                this.mHost.getLocationOnScreen(this.mTempGlobalRect);
                b.mo3683c(this.mTempScreenRect);
                if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
                    b.mo3670a(this.mTempScreenRect);
                    if (b.f2954a != -1) {
                        C0935b b2 = C0935b.m3417b();
                        for (int i2 = b.f2954a; i2 != -1; i2 = b2.f2954a) {
                            b2.mo3684c(this.mHost, -1);
                            b2.mo3676b(INVALID_PARENT_BOUNDS);
                            onPopulateNodeForVirtualView(i2, b2);
                            b2.mo3670a(this.mTempParentRect);
                            this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
                        }
                        b2.mo3717s();
                    }
                    this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                }
                if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                    this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                    if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                        b.mo3688d(this.mTempScreenRect);
                        if (isVisibleToUser(this.mTempScreenRect)) {
                            b.mo3692e(true);
                        }
                    }
                }
                return b;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean performAction(int i, int i2, Bundle bundle) {
        if (i != -1) {
            return performActionForChild(i, i2, bundle);
        }
        return performActionForHost(i2, bundle);
    }

    private boolean performActionForHost(int i, Bundle bundle) {
        return C0962r.m3566a(this.mHost, i, bundle);
    }

    private boolean performActionForChild(int i, int i2, Bundle bundle) {
        if (i2 == 64) {
            return requestAccessibilityFocus(i);
        }
        if (i2 == 128) {
            return clearAccessibilityFocus(i);
        }
        switch (i2) {
            case 1:
                return requestKeyboardFocusForVirtualView(i);
            case 2:
                return clearKeyboardFocusForVirtualView(i);
            default:
                return onPerformActionForVirtualView(i, i2, bundle);
        }
    }

    private boolean isVisibleToUser(Rect rect) {
        boolean z = false;
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= BitmapDescriptorFactory.HUE_RED || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent != null) {
            z = true;
        }
        return z;
    }

    private boolean requestAccessibilityFocus(int i) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || this.mAccessibilityFocusedVirtualViewId == i) {
            return false;
        }
        if (this.mAccessibilityFocusedVirtualViewId != Integer.MIN_VALUE) {
            clearAccessibilityFocus(this.mAccessibilityFocusedVirtualViewId);
        }
        this.mAccessibilityFocusedVirtualViewId = i;
        this.mHost.invalidate();
        sendEventForVirtualView(i, 32768);
        return true;
    }

    private boolean clearAccessibilityFocus(int i) {
        if (this.mAccessibilityFocusedVirtualViewId != i) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = INVALID_ID;
        this.mHost.invalidate();
        sendEventForVirtualView(i, 65536);
        return true;
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || this.mKeyboardFocusedVirtualViewId == i) {
            return false;
        }
        if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
        }
        this.mKeyboardFocusedVirtualViewId = i;
        onVirtualViewKeyboardFocusChanged(i, true);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.mKeyboardFocusedVirtualViewId != i) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = INVALID_ID;
        onVirtualViewKeyboardFocusChanged(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }
}
