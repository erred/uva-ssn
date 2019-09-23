package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.p070g.C0962r;
import androidx.core.p070g.C0966s;
import com.google.android.gms.common.api.Api.BaseClientBuilder;

/* renamed from: androidx.appcompat.widget.ay */
/* compiled from: TooltipCompatHandler */
class C0650ay implements OnAttachStateChangeListener, OnHoverListener, OnLongClickListener {

    /* renamed from: j */
    private static C0650ay f1885j;

    /* renamed from: k */
    private static C0650ay f1886k;

    /* renamed from: a */
    private final View f1887a;

    /* renamed from: b */
    private final CharSequence f1888b;

    /* renamed from: c */
    private final int f1889c;

    /* renamed from: d */
    private final Runnable f1890d = new Runnable() {
        public void run() {
            C0650ay.this.mo2474a(false);
        }
    };

    /* renamed from: e */
    private final Runnable f1891e = new Runnable() {
        public void run() {
            C0650ay.this.mo2473a();
        }
    };

    /* renamed from: f */
    private int f1892f;

    /* renamed from: g */
    private int f1893g;

    /* renamed from: h */
    private C0653az f1894h;

    /* renamed from: i */
    private boolean f1895i;

    public void onViewAttachedToWindow(View view) {
    }

    /* renamed from: a */
    public static void m2297a(View view, CharSequence charSequence) {
        if (f1885j != null && f1885j.f1887a == view) {
            m2298a((C0650ay) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            if (f1886k != null && f1886k.f1887a == view) {
                f1886k.mo2473a();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new C0650ay(view, charSequence);
    }

    private C0650ay(View view, CharSequence charSequence) {
        this.f1887a = view;
        this.f1888b = charSequence;
        this.f1889c = C0966s.m3615b(ViewConfiguration.get(this.f1887a.getContext()));
        m2302d();
        this.f1887a.setOnLongClickListener(this);
        this.f1887a.setOnHoverListener(this);
    }

    public boolean onLongClick(View view) {
        this.f1892f = view.getWidth() / 2;
        this.f1893g = view.getHeight() / 2;
        mo2474a(true);
        return true;
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1894h != null && this.f1895i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1887a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                m2302d();
                mo2473a();
            }
        } else if (this.f1887a.isEnabled() && this.f1894h == null && m2299a(motionEvent)) {
            m2298a(this);
        }
        return false;
    }

    public void onViewDetachedFromWindow(View view) {
        mo2473a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2474a(boolean z) {
        long j;
        if (C0962r.m3543C(this.f1887a)) {
            m2298a((C0650ay) null);
            if (f1886k != null) {
                f1886k.mo2473a();
            }
            f1886k = this;
            this.f1895i = z;
            this.f1894h = new C0653az(this.f1887a.getContext());
            this.f1894h.mo2482a(this.f1887a, this.f1892f, this.f1893g, this.f1895i, this.f1888b);
            this.f1887a.addOnAttachStateChangeListener(this);
            if (this.f1895i) {
                j = 2500;
            } else if ((C0962r.m3594q(this.f1887a) & 1) == 1) {
                j = 3000 - ((long) ViewConfiguration.getLongPressTimeout());
            } else {
                j = 15000 - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.f1887a.removeCallbacks(this.f1891e);
            this.f1887a.postDelayed(this.f1891e, j);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2473a() {
        if (f1886k == this) {
            f1886k = null;
            if (this.f1894h != null) {
                this.f1894h.mo2481a();
                this.f1894h = null;
                m2302d();
                this.f1887a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1885j == this) {
            m2298a((C0650ay) null);
        }
        this.f1887a.removeCallbacks(this.f1891e);
    }

    /* renamed from: a */
    private static void m2298a(C0650ay ayVar) {
        if (f1885j != null) {
            f1885j.m2301c();
        }
        f1885j = ayVar;
        if (f1885j != null) {
            f1885j.m2300b();
        }
    }

    /* renamed from: b */
    private void m2300b() {
        this.f1887a.postDelayed(this.f1890d, (long) ViewConfiguration.getLongPressTimeout());
    }

    /* renamed from: c */
    private void m2301c() {
        this.f1887a.removeCallbacks(this.f1890d);
    }

    /* renamed from: a */
    private boolean m2299a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f1892f) <= this.f1889c && Math.abs(y - this.f1893g) <= this.f1889c) {
            return false;
        }
        this.f1892f = x;
        this.f1893g = y;
        return true;
    }

    /* renamed from: d */
    private void m2302d() {
        this.f1892f = BaseClientBuilder.API_PRIORITY_OTHER;
        this.f1893g = BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
