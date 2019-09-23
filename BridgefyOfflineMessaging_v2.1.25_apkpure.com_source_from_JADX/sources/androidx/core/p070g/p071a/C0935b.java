package androidx.core.p070g.p071a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import com.google.api.client.googleapis.media.MediaHttpUploader;

/* renamed from: androidx.core.g.a.b */
/* compiled from: AccessibilityNodeInfoCompat */
public class C0935b {

    /* renamed from: a */
    public int f2954a = -1;

    /* renamed from: b */
    private final AccessibilityNodeInfo f2955b;

    /* renamed from: androidx.core.g.a.b$a */
    /* compiled from: AccessibilityNodeInfoCompat */
    public static class C0936a {

        /* renamed from: A */
        public static final C0936a f2956A = new C0936a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_DOWN : null);

        /* renamed from: B */
        public static final C0936a f2957B = new C0936a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_RIGHT : null);

        /* renamed from: C */
        public static final C0936a f2958C = new C0936a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_CONTEXT_CLICK : null);

        /* renamed from: D */
        public static final C0936a f2959D = new C0936a(VERSION.SDK_INT >= 24 ? AccessibilityAction.ACTION_SET_PROGRESS : null);

        /* renamed from: E */
        public static final C0936a f2960E = new C0936a(VERSION.SDK_INT >= 26 ? AccessibilityAction.ACTION_MOVE_WINDOW : null);

        /* renamed from: F */
        public static final C0936a f2961F = new C0936a(VERSION.SDK_INT >= 28 ? AccessibilityAction.ACTION_SHOW_TOOLTIP : null);

        /* renamed from: G */
        public static final C0936a f2962G;

        /* renamed from: a */
        public static final C0936a f2963a = new C0936a(1, null);

        /* renamed from: b */
        public static final C0936a f2964b = new C0936a(2, null);

        /* renamed from: c */
        public static final C0936a f2965c = new C0936a(4, null);

        /* renamed from: d */
        public static final C0936a f2966d = new C0936a(8, null);

        /* renamed from: e */
        public static final C0936a f2967e = new C0936a(16, null);

        /* renamed from: f */
        public static final C0936a f2968f = new C0936a(32, null);

        /* renamed from: g */
        public static final C0936a f2969g = new C0936a(64, null);

        /* renamed from: h */
        public static final C0936a f2970h = new C0936a(128, null);

        /* renamed from: i */
        public static final C0936a f2971i = new C0936a(256, null);

        /* renamed from: j */
        public static final C0936a f2972j = new C0936a(512, null);

        /* renamed from: k */
        public static final C0936a f2973k = new C0936a(1024, null);

        /* renamed from: l */
        public static final C0936a f2974l = new C0936a(2048, null);

        /* renamed from: m */
        public static final C0936a f2975m = new C0936a(4096, null);

        /* renamed from: n */
        public static final C0936a f2976n = new C0936a(8192, null);

        /* renamed from: o */
        public static final C0936a f2977o = new C0936a(16384, null);

        /* renamed from: p */
        public static final C0936a f2978p = new C0936a(32768, null);

        /* renamed from: q */
        public static final C0936a f2979q = new C0936a(65536, null);

        /* renamed from: r */
        public static final C0936a f2980r = new C0936a(131072, null);

        /* renamed from: s */
        public static final C0936a f2981s = new C0936a(MediaHttpUploader.MINIMUM_CHUNK_SIZE, null);

        /* renamed from: t */
        public static final C0936a f2982t = new C0936a(524288, null);

        /* renamed from: u */
        public static final C0936a f2983u = new C0936a(1048576, null);

        /* renamed from: v */
        public static final C0936a f2984v = new C0936a(2097152, null);

        /* renamed from: w */
        public static final C0936a f2985w = new C0936a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SHOW_ON_SCREEN : null);

        /* renamed from: x */
        public static final C0936a f2986x = new C0936a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_TO_POSITION : null);

        /* renamed from: y */
        public static final C0936a f2987y = new C0936a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_UP : null);

        /* renamed from: z */
        public static final C0936a f2988z = new C0936a(VERSION.SDK_INT >= 23 ? AccessibilityAction.ACTION_SCROLL_LEFT : null);

        /* renamed from: H */
        final Object f2989H;

        static {
            AccessibilityAction accessibilityAction = null;
            if (VERSION.SDK_INT >= 28) {
                accessibilityAction = AccessibilityAction.ACTION_HIDE_TOOLTIP;
            }
            f2962G = new C0936a(accessibilityAction);
        }

        public C0936a(int i, CharSequence charSequence) {
            this(VERSION.SDK_INT >= 21 ? new AccessibilityAction(i, charSequence) : null);
        }

        C0936a(Object obj) {
            this.f2989H = obj;
        }
    }

    /* renamed from: androidx.core.g.a.b$b */
    /* compiled from: AccessibilityNodeInfoCompat */
    public static class C0937b {

        /* renamed from: a */
        final Object f2990a;

        /* renamed from: a */
        public static C0937b m3470a(int i, int i2, boolean z, int i3) {
            if (VERSION.SDK_INT >= 21) {
                return new C0937b(CollectionInfo.obtain(i, i2, z, i3));
            }
            if (VERSION.SDK_INT >= 19) {
                return new C0937b(CollectionInfo.obtain(i, i2, z));
            }
            return new C0937b(null);
        }

        /* renamed from: a */
        public static C0937b m3469a(int i, int i2, boolean z) {
            if (VERSION.SDK_INT >= 19) {
                return new C0937b(CollectionInfo.obtain(i, i2, z));
            }
            return new C0937b(null);
        }

        C0937b(Object obj) {
            this.f2990a = obj;
        }
    }

    /* renamed from: androidx.core.g.a.b$c */
    /* compiled from: AccessibilityNodeInfoCompat */
    public static class C0938c {

        /* renamed from: a */
        final Object f2991a;

        /* renamed from: a */
        public static C0938c m3471a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            if (VERSION.SDK_INT >= 21) {
                return new C0938c(CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (VERSION.SDK_INT >= 19) {
                return new C0938c(CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new C0938c(null);
        }

        C0938c(Object obj) {
            this.f2991a = obj;
        }
    }

    /* renamed from: b */
    private static String m3418b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    private C0935b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f2955b = accessibilityNodeInfo;
    }

    /* renamed from: a */
    public static C0935b m3414a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new C0935b(accessibilityNodeInfo);
    }

    /* renamed from: a */
    public AccessibilityNodeInfo mo3668a() {
        return this.f2955b;
    }

    /* renamed from: a */
    public static C0935b m3413a(View view) {
        return m3414a(AccessibilityNodeInfo.obtain(view));
    }

    /* renamed from: b */
    public static C0935b m3417b() {
        return m3414a(AccessibilityNodeInfo.obtain());
    }

    /* renamed from: a */
    public static C0935b m3415a(C0935b bVar) {
        return m3414a(AccessibilityNodeInfo.obtain(bVar.f2955b));
    }

    /* renamed from: a */
    public void mo3671a(View view, int i) {
        if (VERSION.SDK_INT >= 16) {
            this.f2955b.setSource(view, i);
        }
    }

    /* renamed from: c */
    public int mo3682c() {
        return this.f2955b.getChildCount();
    }

    /* renamed from: b */
    public void mo3678b(View view, int i) {
        if (VERSION.SDK_INT >= 16) {
            this.f2955b.addChild(view, i);
        }
    }

    /* renamed from: d */
    public int mo3687d() {
        return this.f2955b.getActions();
    }

    /* renamed from: a */
    public void mo3669a(int i) {
        this.f2955b.addAction(i);
    }

    /* renamed from: a */
    public void mo3672a(C0936a aVar) {
        if (VERSION.SDK_INT >= 21) {
            this.f2955b.addAction((AccessibilityAction) aVar.f2989H);
        }
    }

    /* renamed from: b */
    public void mo3677b(View view) {
        this.f2955b.setParent(view);
    }

    /* renamed from: c */
    public void mo3684c(View view, int i) {
        this.f2954a = i;
        if (VERSION.SDK_INT >= 16) {
            this.f2955b.setParent(view, i);
        }
    }

    /* renamed from: a */
    public void mo3670a(Rect rect) {
        this.f2955b.getBoundsInParent(rect);
    }

    /* renamed from: b */
    public void mo3676b(Rect rect) {
        this.f2955b.setBoundsInParent(rect);
    }

    /* renamed from: c */
    public void mo3683c(Rect rect) {
        this.f2955b.getBoundsInScreen(rect);
    }

    /* renamed from: d */
    public void mo3688d(Rect rect) {
        this.f2955b.setBoundsInScreen(rect);
    }

    /* renamed from: e */
    public boolean mo3693e() {
        return this.f2955b.isCheckable();
    }

    /* renamed from: a */
    public void mo3675a(boolean z) {
        this.f2955b.setCheckable(z);
    }

    /* renamed from: f */
    public boolean mo3697f() {
        return this.f2955b.isChecked();
    }

    /* renamed from: b */
    public void mo3681b(boolean z) {
        this.f2955b.setChecked(z);
    }

    /* renamed from: g */
    public boolean mo3699g() {
        return this.f2955b.isFocusable();
    }

    /* renamed from: c */
    public void mo3686c(boolean z) {
        this.f2955b.setFocusable(z);
    }

    /* renamed from: h */
    public boolean mo3701h() {
        return this.f2955b.isFocused();
    }

    /* renamed from: d */
    public void mo3690d(boolean z) {
        this.f2955b.setFocused(z);
    }

    /* renamed from: e */
    public void mo3692e(boolean z) {
        if (VERSION.SDK_INT >= 16) {
            this.f2955b.setVisibleToUser(z);
        }
    }

    /* renamed from: f */
    public void mo3696f(boolean z) {
        if (VERSION.SDK_INT >= 16) {
            this.f2955b.setAccessibilityFocused(z);
        }
    }

    /* renamed from: i */
    public boolean mo3704i() {
        return this.f2955b.isSelected();
    }

    /* renamed from: j */
    public boolean mo3706j() {
        return this.f2955b.isClickable();
    }

    /* renamed from: g */
    public void mo3698g(boolean z) {
        this.f2955b.setClickable(z);
    }

    /* renamed from: k */
    public boolean mo3708k() {
        return this.f2955b.isLongClickable();
    }

    /* renamed from: l */
    public boolean mo3710l() {
        return this.f2955b.isEnabled();
    }

    /* renamed from: h */
    public void mo3700h(boolean z) {
        this.f2955b.setEnabled(z);
    }

    /* renamed from: m */
    public boolean mo3711m() {
        return this.f2955b.isPassword();
    }

    /* renamed from: n */
    public boolean mo3712n() {
        return this.f2955b.isScrollable();
    }

    /* renamed from: i */
    public void mo3703i(boolean z) {
        this.f2955b.setScrollable(z);
    }

    /* renamed from: o */
    public CharSequence mo3713o() {
        return this.f2955b.getPackageName();
    }

    /* renamed from: a */
    public void mo3673a(CharSequence charSequence) {
        this.f2955b.setPackageName(charSequence);
    }

    /* renamed from: p */
    public CharSequence mo3714p() {
        return this.f2955b.getClassName();
    }

    /* renamed from: b */
    public void mo3679b(CharSequence charSequence) {
        this.f2955b.setClassName(charSequence);
    }

    /* renamed from: q */
    public CharSequence mo3715q() {
        return this.f2955b.getText();
    }

    /* renamed from: c */
    public void mo3685c(CharSequence charSequence) {
        this.f2955b.setText(charSequence);
    }

    /* renamed from: r */
    public CharSequence mo3716r() {
        return this.f2955b.getContentDescription();
    }

    /* renamed from: d */
    public void mo3689d(CharSequence charSequence) {
        this.f2955b.setContentDescription(charSequence);
    }

    /* renamed from: s */
    public void mo3717s() {
        this.f2955b.recycle();
    }

    /* renamed from: t */
    public String mo3718t() {
        if (VERSION.SDK_INT >= 18) {
            return this.f2955b.getViewIdResourceName();
        }
        return null;
    }

    /* renamed from: a */
    public void mo3674a(Object obj) {
        if (VERSION.SDK_INT >= 19) {
            this.f2955b.setCollectionInfo(obj == null ? null : (CollectionInfo) ((C0937b) obj).f2990a);
        }
    }

    /* renamed from: b */
    public void mo3680b(Object obj) {
        if (VERSION.SDK_INT >= 19) {
            this.f2955b.setCollectionItemInfo(obj == null ? null : (CollectionItemInfo) ((C0938c) obj).f2991a);
        }
    }

    /* renamed from: j */
    public void mo3705j(boolean z) {
        if (VERSION.SDK_INT >= 19) {
            this.f2955b.setContentInvalid(z);
        }
    }

    /* renamed from: e */
    public void mo3691e(CharSequence charSequence) {
        if (VERSION.SDK_INT >= 26) {
            this.f2955b.setHintText(charSequence);
        } else if (VERSION.SDK_INT >= 19) {
            this.f2955b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    /* renamed from: f */
    public void mo3695f(CharSequence charSequence) {
        if (VERSION.SDK_INT >= 21) {
            this.f2955b.setError(charSequence);
        }
    }

    /* renamed from: u */
    public Bundle mo3720u() {
        if (VERSION.SDK_INT >= 19) {
            return this.f2955b.getExtras();
        }
        return new Bundle();
    }

    /* renamed from: k */
    public void mo3707k(boolean z) {
        if (VERSION.SDK_INT >= 19) {
            this.f2955b.setDismissable(z);
        }
    }

    /* renamed from: l */
    public void mo3709l(boolean z) {
        if (VERSION.SDK_INT >= 26) {
            this.f2955b.setShowingHintText(z);
        } else {
            m3416a(4, z);
        }
    }

    public int hashCode() {
        if (this.f2955b == null) {
            return 0;
        }
        return this.f2955b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0935b bVar = (C0935b) obj;
        if (this.f2955b == null) {
            if (bVar.f2955b != null) {
                return false;
            }
        } else if (!this.f2955b.equals(bVar.f2955b)) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        mo3670a(rect);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("; boundsInParent: ");
        sb2.append(rect);
        sb.append(sb2.toString());
        mo3683c(rect);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("; boundsInScreen: ");
        sb3.append(rect);
        sb.append(sb3.toString());
        sb.append("; packageName: ");
        sb.append(mo3713o());
        sb.append("; className: ");
        sb.append(mo3714p());
        sb.append("; text: ");
        sb.append(mo3715q());
        sb.append("; contentDescription: ");
        sb.append(mo3716r());
        sb.append("; viewId: ");
        sb.append(mo3718t());
        sb.append("; checkable: ");
        sb.append(mo3693e());
        sb.append("; checked: ");
        sb.append(mo3697f());
        sb.append("; focusable: ");
        sb.append(mo3699g());
        sb.append("; focused: ");
        sb.append(mo3701h());
        sb.append("; selected: ");
        sb.append(mo3704i());
        sb.append("; clickable: ");
        sb.append(mo3706j());
        sb.append("; longClickable: ");
        sb.append(mo3708k());
        sb.append("; enabled: ");
        sb.append(mo3710l());
        sb.append("; password: ");
        sb.append(mo3711m());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("; scrollable: ");
        sb4.append(mo3712n());
        sb.append(sb4.toString());
        sb.append("; [");
        int d = mo3687d();
        while (d != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(d);
            d &= ~numberOfTrailingZeros;
            sb.append(m3418b(numberOfTrailingZeros));
            if (d != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a */
    private void m3416a(int i, boolean z) {
        Bundle u = mo3720u();
        if (u != null) {
            int i2 = u.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z) {
                i = 0;
            }
            u.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }
}
