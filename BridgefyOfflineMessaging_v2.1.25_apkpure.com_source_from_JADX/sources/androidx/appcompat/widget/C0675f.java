package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.p070g.C0962r;

/* renamed from: androidx.appcompat.widget.f */
/* compiled from: AppCompatBackgroundHelper */
class C0675f {

    /* renamed from: a */
    private final View f1966a;

    /* renamed from: b */
    private final C0680k f1967b;

    /* renamed from: c */
    private int f1968c = -1;

    /* renamed from: d */
    private C0643at f1969d;

    /* renamed from: e */
    private C0643at f1970e;

    /* renamed from: f */
    private C0643at f1971f;

    C0675f(View view) {
        this.f1966a = view;
        this.f1967b = C0680k.m2397a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2547a(AttributeSet attributeSet, int i) {
        C0645av a = C0645av.m2230a(this.f1966a.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i, 0);
        try {
            if (a.mo2464g(R.styleable.ViewBackgroundHelper_android_background)) {
                this.f1968c = a.mo2463g(R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList b = this.f1967b.mo2594b(this.f1966a.getContext(), this.f1968c);
                if (b != null) {
                    mo2549b(b);
                }
            }
            if (a.mo2464g(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                C0962r.m3554a(this.f1966a, a.mo2460e(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (a.mo2464g(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                C0962r.m3555a(this.f1966a, C0607ad.m2102a(a.mo2447a(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            a.mo2450a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2543a(int i) {
        this.f1968c = i;
        mo2549b(this.f1967b != null ? this.f1967b.mo2594b(this.f1966a.getContext(), i) : null);
        mo2550c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2546a(Drawable drawable) {
        this.f1968c = -1;
        mo2549b((ColorStateList) null);
        mo2550c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2544a(ColorStateList colorStateList) {
        if (this.f1970e == null) {
            this.f1970e = new C0643at();
        }
        this.f1970e.f1855a = colorStateList;
        this.f1970e.f1858d = true;
        mo2550c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ColorStateList mo2542a() {
        if (this.f1970e != null) {
            return this.f1970e.f1855a;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2545a(Mode mode) {
        if (this.f1970e == null) {
            this.f1970e = new C0643at();
        }
        this.f1970e.f1856b = mode;
        this.f1970e.f1857c = true;
        mo2550c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Mode mo2548b() {
        if (this.f1970e != null) {
            return this.f1970e.f1856b;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo2550c() {
        Drawable background = this.f1966a.getBackground();
        if (background != null && (!m2373d() || !m2372b(background))) {
            if (this.f1970e != null) {
                C0680k.m2400a(background, this.f1970e, this.f1966a.getDrawableState());
            } else if (this.f1969d != null) {
                C0680k.m2400a(background, this.f1969d, this.f1966a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo2549b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1969d == null) {
                this.f1969d = new C0643at();
            }
            this.f1969d.f1855a = colorStateList;
            this.f1969d.f1858d = true;
        } else {
            this.f1969d = null;
        }
        mo2550c();
    }

    /* renamed from: d */
    private boolean m2373d() {
        int i = VERSION.SDK_INT;
        boolean z = false;
        if (i <= 21) {
            return i == 21;
        }
        if (this.f1969d != null) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private boolean m2372b(Drawable drawable) {
        if (this.f1971f == null) {
            this.f1971f = new C0643at();
        }
        C0643at atVar = this.f1971f;
        atVar.mo2445a();
        ColorStateList v = C0962r.m3599v(this.f1966a);
        if (v != null) {
            atVar.f1858d = true;
            atVar.f1855a = v;
        }
        Mode w = C0962r.m3600w(this.f1966a);
        if (w != null) {
            atVar.f1857c = true;
            atVar.f1856b = w;
        }
        if (!atVar.f1858d && !atVar.f1857c) {
            return false;
        }
        C0680k.m2400a(drawable, atVar, this.f1966a.getDrawableState());
        return true;
    }
}
