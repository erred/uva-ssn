package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.core.widget.C1009e;

/* renamed from: androidx.appcompat.widget.o */
/* compiled from: AppCompatImageHelper */
public class C0689o {

    /* renamed from: a */
    private final ImageView f1995a;

    /* renamed from: b */
    private C0643at f1996b;

    /* renamed from: c */
    private C0643at f1997c;

    /* renamed from: d */
    private C0643at f1998d;

    public C0689o(ImageView imageView) {
        this.f1995a = imageView;
    }

    /* renamed from: a */
    public void mo2620a(AttributeSet attributeSet, int i) {
        C0645av a = C0645av.m2230a(this.f1995a.getContext(), attributeSet, R.styleable.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f1995a.getDrawable();
            if (drawable == null) {
                int g = a.mo2463g(R.styleable.AppCompatImageView_srcCompat, -1);
                if (g != -1) {
                    drawable = C0424a.m1270b(this.f1995a.getContext(), g);
                    if (drawable != null) {
                        this.f1995a.setImageDrawable(drawable);
                    }
                }
            }
            if (drawable != null) {
                C0607ad.m2104b(drawable);
            }
            if (a.mo2464g(R.styleable.AppCompatImageView_tint)) {
                C1009e.m3849a(this.f1995a, a.mo2460e(R.styleable.AppCompatImageView_tint));
            }
            if (a.mo2464g(R.styleable.AppCompatImageView_tintMode)) {
                C1009e.m3850a(this.f1995a, C0607ad.m2102a(a.mo2447a(R.styleable.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            a.mo2450a();
        }
    }

    /* renamed from: a */
    public void mo2617a(int i) {
        if (i != 0) {
            Drawable b = C0424a.m1270b(this.f1995a.getContext(), i);
            if (b != null) {
                C0607ad.m2104b(b);
            }
            this.f1995a.setImageDrawable(b);
        } else {
            this.f1995a.setImageDrawable(null);
        }
        mo2624d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo2621a() {
        return VERSION.SDK_INT < 21 || !(this.f1995a.getBackground() instanceof RippleDrawable);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2618a(ColorStateList colorStateList) {
        if (this.f1997c == null) {
            this.f1997c = new C0643at();
        }
        this.f1997c.f1855a = colorStateList;
        this.f1997c.f1858d = true;
        mo2624d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public ColorStateList mo2622b() {
        if (this.f1997c != null) {
            return this.f1997c.f1855a;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2619a(Mode mode) {
        if (this.f1997c == null) {
            this.f1997c = new C0643at();
        }
        this.f1997c.f1856b = mode;
        this.f1997c.f1857c = true;
        mo2624d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Mode mo2623c() {
        if (this.f1997c != null) {
            return this.f1997c.f1856b;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo2624d() {
        Drawable drawable = this.f1995a.getDrawable();
        if (drawable != null) {
            C0607ad.m2104b(drawable);
        }
        if (drawable != null && (!m2430e() || !m2429a(drawable))) {
            if (this.f1997c != null) {
                C0680k.m2400a(drawable, this.f1997c, this.f1995a.getDrawableState());
            } else if (this.f1996b != null) {
                C0680k.m2400a(drawable, this.f1996b, this.f1995a.getDrawableState());
            }
        }
    }

    /* renamed from: e */
    private boolean m2430e() {
        int i = VERSION.SDK_INT;
        boolean z = false;
        if (i <= 21) {
            return i == 21;
        }
        if (this.f1996b != null) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private boolean m2429a(Drawable drawable) {
        if (this.f1998d == null) {
            this.f1998d = new C0643at();
        }
        C0643at atVar = this.f1998d;
        atVar.mo2445a();
        ColorStateList a = C1009e.m3848a(this.f1995a);
        if (a != null) {
            atVar.f1858d = true;
            atVar.f1855a = a;
        }
        Mode b = C1009e.m3851b(this.f1995a);
        if (b != null) {
            atVar.f1857c = true;
            atVar.f1856b = b;
        }
        if (!atVar.f1858d && !atVar.f1857c) {
            return false;
        }
        C0680k.m2400a(drawable, atVar, this.f1995a.getDrawableState());
        return true;
    }
}
