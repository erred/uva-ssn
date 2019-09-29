package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R;
import androidx.appcompat.p047a.p048a.C0424a;
import androidx.core.graphics.drawable.C0983a;
import androidx.core.widget.C1007c;

/* renamed from: androidx.appcompat.widget.j */
/* compiled from: AppCompatCompoundButtonHelper */
class C0679j {

    /* renamed from: a */
    private final CompoundButton f1974a;

    /* renamed from: b */
    private ColorStateList f1975b = null;

    /* renamed from: c */
    private Mode f1976c = null;

    /* renamed from: d */
    private boolean f1977d = false;

    /* renamed from: e */
    private boolean f1978e = false;

    /* renamed from: f */
    private boolean f1979f;

    C0679j(CompoundButton compoundButton) {
        this.f1974a = compoundButton;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2586a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f1974a.getContext().obtainStyledAttributes(attributeSet, R.styleable.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.f1974a.setButtonDrawable(C0424a.m1270b(this.f1974a.getContext(), resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTint)) {
                C1007c.m3844a(this.f1974a, obtainStyledAttributes.getColorStateList(R.styleable.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
                C1007c.m3845a(this.f1974a, C0607ad.m2102a(obtainStyledAttributes.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2584a(ColorStateList colorStateList) {
        this.f1975b = colorStateList;
        this.f1977d = true;
        mo2589d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public ColorStateList mo2583a() {
        return this.f1975b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2585a(Mode mode) {
        this.f1976c = mode;
        this.f1978e = true;
        mo2589d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Mode mo2587b() {
        return this.f1976c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo2588c() {
        if (this.f1979f) {
            this.f1979f = false;
            return;
        }
        this.f1979f = true;
        mo2589d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo2589d() {
        Drawable b = C1007c.m3846b(this.f1974a);
        if (b == null) {
            return;
        }
        if (this.f1977d || this.f1978e) {
            Drawable mutate = C0983a.m3709g(b).mutate();
            if (this.f1977d) {
                C0983a.m3698a(mutate, this.f1975b);
            }
            if (this.f1978e) {
                C0983a.m3701a(mutate, this.f1976c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f1974a.getDrawableState());
            }
            this.f1974a.setButtonDrawable(mutate);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo2582a(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable b = C1007c.m3846b(this.f1974a);
        return b != null ? i + b.getIntrinsicWidth() : i;
    }
}
