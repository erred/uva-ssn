package androidx.core.p070g;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.R;
import androidx.core.p070g.p071a.C0935b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: androidx.core.g.r */
/* compiled from: ViewCompat */
public class C0962r {

    /* renamed from: a */
    private static final AtomicInteger f3012a = new AtomicInteger(1);

    /* renamed from: b */
    private static Field f3013b;

    /* renamed from: c */
    private static boolean f3014c;

    /* renamed from: d */
    private static Field f3015d;

    /* renamed from: e */
    private static boolean f3016e;

    /* renamed from: f */
    private static WeakHashMap<View, String> f3017f;

    /* renamed from: g */
    private static WeakHashMap<View, C0969v> f3018g = null;

    /* renamed from: h */
    private static Field f3019h;

    /* renamed from: i */
    private static boolean f3020i = false;

    /* renamed from: j */
    private static ThreadLocal<Rect> f3021j;

    /* renamed from: androidx.core.g.r$a */
    /* compiled from: ViewCompat */
    public interface C0964a {
        /* renamed from: a */
        boolean mo3759a(View view, KeyEvent keyEvent);
    }

    /* renamed from: androidx.core.g.r$b */
    /* compiled from: ViewCompat */
    static class C0965b {

        /* renamed from: a */
        private static final ArrayList<WeakReference<View>> f3023a = new ArrayList<>();

        /* renamed from: b */
        private WeakHashMap<View, Boolean> f3024b = null;

        /* renamed from: c */
        private SparseArray<WeakReference<View>> f3025c = null;

        /* renamed from: d */
        private WeakReference<KeyEvent> f3026d = null;

        C0965b() {
        }

        /* renamed from: a */
        private SparseArray<WeakReference<View>> m3605a() {
            if (this.f3025c == null) {
                this.f3025c = new SparseArray<>();
            }
            return this.f3025c;
        }

        /* renamed from: a */
        static C0965b m3606a(View view) {
            C0965b bVar = (C0965b) view.getTag(R.id.tag_unhandled_key_event_manager);
            if (bVar != null) {
                return bVar;
            }
            C0965b bVar2 = new C0965b();
            view.setTag(R.id.tag_unhandled_key_event_manager, bVar2);
            return bVar2;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo3761a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                m3608b();
            }
            View b = m3607b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (b != null && !KeyEvent.isModifierKey(keyCode)) {
                    m3605a().put(keyCode, new WeakReference(b));
                }
            }
            return b != null;
        }

        /* renamed from: b */
        private View m3607b(View view, KeyEvent keyEvent) {
            if (this.f3024b == null || !this.f3024b.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View b = m3607b(viewGroup.getChildAt(childCount), keyEvent);
                    if (b != null) {
                        return b;
                    }
                }
            }
            if (m3609c(view, keyEvent)) {
                return view;
            }
            return null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo3760a(KeyEvent keyEvent) {
            if (this.f3026d != null && this.f3026d.get() == keyEvent) {
                return false;
            }
            this.f3026d = new WeakReference<>(keyEvent);
            WeakReference weakReference = null;
            SparseArray a = m3605a();
            if (keyEvent.getAction() == 1) {
                int indexOfKey = a.indexOfKey(keyEvent.getKeyCode());
                if (indexOfKey >= 0) {
                    weakReference = (WeakReference) a.valueAt(indexOfKey);
                    a.removeAt(indexOfKey);
                }
            }
            if (weakReference == null) {
                weakReference = (WeakReference) a.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && C0962r.m3543C(view)) {
                m3609c(view, keyEvent);
            }
            return true;
        }

        /* renamed from: c */
        private boolean m3609c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((C0964a) arrayList.get(size)).mo3759a(view, keyEvent)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* renamed from: b */
        private void m3608b() {
            if (this.f3024b != null) {
                this.f3024b.clear();
            }
            if (!f3023a.isEmpty()) {
                synchronized (f3023a) {
                    if (this.f3024b == null) {
                        this.f3024b = new WeakHashMap<>();
                    }
                    for (int size = f3023a.size() - 1; size >= 0; size--) {
                        View view = (View) ((WeakReference) f3023a.get(size)).get();
                        if (view == null) {
                            f3023a.remove(size);
                        } else {
                            this.f3024b.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.f3024b.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static Rect m3548a() {
        if (f3021j == null) {
            f3021j = new ThreadLocal<>();
        }
        Rect rect = (Rect) f3021j.get();
        if (rect == null) {
            rect = new Rect();
            f3021j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    /* renamed from: a */
    public static void m3558a(View view, C0935b bVar) {
        view.onInitializeAccessibilityNodeInfo(bVar.mo3668a());
    }

    /* renamed from: a */
    public static void m3559a(View view, C0932a aVar) {
        view.setAccessibilityDelegate(aVar == null ? null : aVar.getBridge());
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public static int m3547a(View view) {
        if (VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    /* renamed from: a */
    public static void m3551a(View view, int i) {
        if (VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i);
        }
    }

    /* renamed from: b */
    public static boolean m3571b(View view) {
        boolean z = false;
        if (f3020i) {
            return false;
        }
        if (f3019h == null) {
            try {
                f3019h = View.class.getDeclaredField("mAccessibilityDelegate");
                f3019h.setAccessible(true);
            } catch (Throwable unused) {
                f3020i = true;
                return false;
            }
        }
        try {
            if (f3019h.get(view) != null) {
                z = true;
            }
            return z;
        } catch (Throwable unused2) {
            f3020i = true;
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m3574c(View view) {
        if (VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    /* renamed from: a */
    public static void m3565a(View view, boolean z) {
        if (VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    /* renamed from: d */
    public static void m3575d(View view) {
        if (VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    /* renamed from: a */
    public static void m3562a(View view, Runnable runnable) {
        if (VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    /* renamed from: a */
    public static void m3563a(View view, Runnable runnable, long j) {
        if (VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    /* renamed from: e */
    public static int m3577e(View view) {
        if (VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    /* renamed from: b */
    public static void m3569b(View view, int i) {
        if (VERSION.SDK_INT >= 19) {
            view.setImportantForAccessibility(i);
        } else if (VERSION.SDK_INT >= 16) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }
    }

    /* renamed from: a */
    public static boolean m3566a(View view, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i, bundle);
        }
        return false;
    }

    /* renamed from: f */
    public static int m3579f(View view) {
        if (VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    /* renamed from: c */
    public static void m3573c(View view, int i) {
        if (VERSION.SDK_INT >= 17) {
            view.setLayoutDirection(i);
        }
    }

    /* renamed from: g */
    public static int m3581g(View view) {
        if (VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    /* renamed from: d */
    public static void m3576d(View view, int i) {
        if (VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i);
        }
    }

    /* renamed from: h */
    public static int m3583h(View view) {
        if (VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    /* renamed from: i */
    public static int m3585i(View view) {
        if (VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    /* renamed from: a */
    public static void m3553a(View view, int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i, i2, i3, i4);
        } else {
            view.setPadding(i, i2, i3, i4);
        }
    }

    @Deprecated
    /* renamed from: j */
    public static float m3587j(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    /* renamed from: k */
    public static float m3588k(View view) {
        return view.getTranslationY();
    }

    /* renamed from: l */
    public static int m3589l(View view) {
        if (VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!f3014c) {
            try {
                f3013b = View.class.getDeclaredField("mMinWidth");
                f3013b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f3014c = true;
        }
        if (f3013b != null) {
            try {
                return ((Integer) f3013b.get(view)).intValue();
            } catch (Exception unused2) {
            }
        }
        return 0;
    }

    /* renamed from: m */
    public static int m3590m(View view) {
        if (VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!f3016e) {
            try {
                f3015d = View.class.getDeclaredField("mMinHeight");
                f3015d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f3016e = true;
        }
        if (f3015d != null) {
            try {
                return ((Integer) f3015d.get(view)).intValue();
            } catch (Exception unused2) {
            }
        }
        return 0;
    }

    /* renamed from: n */
    public static C0969v m3591n(View view) {
        if (f3018g == null) {
            f3018g = new WeakHashMap<>();
        }
        C0969v vVar = (C0969v) f3018g.get(view);
        if (vVar != null) {
            return vVar;
        }
        C0969v vVar2 = new C0969v(view);
        f3018g.put(view, vVar2);
        return vVar2;
    }

    /* renamed from: a */
    public static void m3550a(View view, float f) {
        if (VERSION.SDK_INT >= 21) {
            view.setElevation(f);
        }
    }

    /* renamed from: o */
    public static float m3592o(View view) {
        return VERSION.SDK_INT >= 21 ? view.getElevation() : BitmapDescriptorFactory.HUE_RED;
    }

    /* renamed from: a */
    public static void m3564a(View view, String str) {
        if (VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f3017f == null) {
            f3017f = new WeakHashMap<>();
        }
        f3017f.put(view, str);
    }

    /* renamed from: p */
    public static String m3593p(View view) {
        if (VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        if (f3017f == null) {
            return null;
        }
        return (String) f3017f.get(view);
    }

    /* renamed from: q */
    public static int m3594q(View view) {
        if (VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    /* renamed from: r */
    public static void m3595r(View view) {
        if (VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else if (VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    /* renamed from: s */
    public static boolean m3596s(View view) {
        if (VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    @Deprecated
    /* renamed from: b */
    public static void m3570b(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    /* renamed from: a */
    public static void m3560a(View view, final C0959o oVar) {
        if (VERSION.SDK_INT >= 21) {
            if (oVar == null) {
                view.setOnApplyWindowInsetsListener(null);
                return;
            }
            view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return (WindowInsets) C0976z.m3649a(oVar.onApplyWindowInsets(view, C0976z.m3648a((Object) windowInsets)));
                }
            });
        }
    }

    /* renamed from: a */
    public static C0976z m3549a(View view, C0976z zVar) {
        if (VERSION.SDK_INT < 21) {
            return zVar;
        }
        WindowInsets windowInsets = (WindowInsets) C0976z.m3649a(zVar);
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        if (onApplyWindowInsets != windowInsets) {
            windowInsets = new WindowInsets(onApplyWindowInsets);
        }
        return C0976z.m3648a((Object) windowInsets);
    }

    /* renamed from: b */
    public static C0976z m3568b(View view, C0976z zVar) {
        if (VERSION.SDK_INT < 21) {
            return zVar;
        }
        WindowInsets windowInsets = (WindowInsets) C0976z.m3649a(zVar);
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        if (dispatchApplyWindowInsets != windowInsets) {
            windowInsets = new WindowInsets(dispatchApplyWindowInsets);
        }
        return C0976z.m3648a((Object) windowInsets);
    }

    /* renamed from: t */
    public static boolean m3597t(View view) {
        if (VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    /* renamed from: u */
    public static boolean m3598u(View view) {
        if (VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    /* renamed from: a */
    public static void m3557a(View view, Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    /* renamed from: v */
    public static ColorStateList m3599v(View view) {
        if (VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        return view instanceof C0961q ? ((C0961q) view).getSupportBackgroundTintList() : null;
    }

    /* renamed from: a */
    public static void m3554a(View view, ColorStateList colorStateList) {
        if (VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof C0961q) {
            ((C0961q) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* renamed from: w */
    public static Mode m3600w(View view) {
        if (VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        return view instanceof C0961q ? ((C0961q) view).getSupportBackgroundTintMode() : null;
    }

    /* renamed from: a */
    public static void m3555a(View view, Mode mode) {
        if (VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof C0961q) {
            ((C0961q) view).setSupportBackgroundTintMode(mode);
        }
    }

    /* renamed from: x */
    public static boolean m3601x(View view) {
        if (VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof C0953i) {
            return ((C0953i) view).isNestedScrollingEnabled();
        }
        return false;
    }

    /* renamed from: y */
    public static void m3602y(View view) {
        if (VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof C0953i) {
            ((C0953i) view).stopNestedScroll();
        }
    }

    /* renamed from: e */
    public static void m3578e(View view, int i) {
        if (view instanceof C0954j) {
            ((C0954j) view).stopNestedScroll(i);
        } else if (i == 0) {
            m3602y(view);
        }
    }

    /* renamed from: z */
    public static boolean m3603z(View view) {
        if (VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* renamed from: A */
    public static float m3541A(View view) {
        return VERSION.SDK_INT >= 21 ? view.getZ() : BitmapDescriptorFactory.HUE_RED;
    }

    /* renamed from: f */
    public static void m3580f(View view, int i) {
        if (VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i);
        } else if (VERSION.SDK_INT >= 21) {
            Rect a = m3548a();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            m3584h(view, i);
            if (z && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(a);
            }
        } else {
            m3584h(view, i);
        }
    }

    /* renamed from: h */
    private static void m3584h(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            m3546F(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                m3546F((View) parent);
            }
        }
    }

    /* renamed from: g */
    public static void m3582g(View view, int i) {
        if (VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i);
        } else if (VERSION.SDK_INT >= 21) {
            Rect a = m3548a();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            m3586i(view, i);
            if (z && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(a);
            }
        } else {
            m3586i(view, i);
        }
    }

    /* renamed from: i */
    private static void m3586i(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            m3546F(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                m3546F((View) parent);
            }
        }
    }

    /* renamed from: F */
    private static void m3546F(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    /* renamed from: a */
    public static void m3556a(View view, Rect rect) {
        if (VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    /* renamed from: B */
    public static Rect m3542B(View view) {
        if (VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    /* renamed from: C */
    public static boolean m3543C(View view) {
        if (VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    /* renamed from: D */
    public static boolean m3544D(View view) {
        if (VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    /* renamed from: a */
    public static void m3552a(View view, int i, int i2) {
        if (VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, i2);
        }
    }

    /* renamed from: a */
    public static void m3561a(View view, C0960p pVar) {
        if (VERSION.SDK_INT >= 24) {
            view.setPointerIcon((PointerIcon) (pVar != null ? pVar.mo3757a() : null));
        }
    }

    /* renamed from: E */
    public static Display m3545E(View view) {
        if (VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (m3543C(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    /* renamed from: a */
    static boolean m3567a(View view, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 28) {
            return false;
        }
        return C0965b.m3606a(view).mo3760a(keyEvent);
    }

    /* renamed from: b */
    static boolean m3572b(View view, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 28) {
            return false;
        }
        return C0965b.m3606a(view).mo3761a(view, keyEvent);
    }
}
