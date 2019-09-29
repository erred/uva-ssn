package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.content.p066a.C0886f.C0887a;
import androidx.core.widget.C1006b;
import androidx.core.widget.C1013i;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.widget.y */
/* compiled from: AppCompatTextHelper */
class C0705y {

    /* renamed from: a */
    private final TextView f2039a;

    /* renamed from: b */
    private C0643at f2040b;

    /* renamed from: c */
    private C0643at f2041c;

    /* renamed from: d */
    private C0643at f2042d;

    /* renamed from: e */
    private C0643at f2043e;

    /* renamed from: f */
    private C0643at f2044f;

    /* renamed from: g */
    private C0643at f2045g;

    /* renamed from: h */
    private final C0604aa f2046h;

    /* renamed from: i */
    private int f2047i = 0;

    /* renamed from: j */
    private Typeface f2048j;

    /* renamed from: k */
    private boolean f2049k;

    C0705y(TextView textView) {
        this.f2039a = textView;
        this.f2046h = new C0604aa(this.f2039a);
    }

    /* access modifiers changed from: 0000 */
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo2703a(AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        boolean z;
        boolean z2;
        AttributeSet attributeSet2 = attributeSet;
        int i2 = i;
        Context context = this.f2039a.getContext();
        C0680k a = C0680k.m2397a();
        C0645av a2 = C0645av.m2230a(context, attributeSet2, R.styleable.AppCompatTextHelper, i2, 0);
        int g = a2.mo2463g(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (a2.mo2464g(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.f2040b = m2462a(context, a, a2.mo2463g(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a2.mo2464g(R.styleable.AppCompatTextHelper_android_drawableTop)) {
            this.f2041c = m2462a(context, a, a2.mo2463g(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a2.mo2464g(R.styleable.AppCompatTextHelper_android_drawableRight)) {
            this.f2042d = m2462a(context, a, a2.mo2463g(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a2.mo2464g(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.f2043e = m2462a(context, a, a2.mo2463g(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (VERSION.SDK_INT >= 17) {
            if (a2.mo2464g(R.styleable.AppCompatTextHelper_android_drawableStart)) {
                this.f2044f = m2462a(context, a, a2.mo2463g(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (a2.mo2464g(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
                this.f2045g = m2462a(context, a, a2.mo2463g(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        a2.mo2450a();
        boolean z3 = this.f2039a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z4 = true;
        ColorStateList colorStateList3 = null;
        if (g != -1) {
            C0645av a3 = C0645av.m2228a(context, g, R.styleable.TextAppearance);
            if (z3 || !a3.mo2464g(R.styleable.TextAppearance_textAllCaps)) {
                z2 = false;
                z = false;
            } else {
                z = a3.mo2451a(R.styleable.TextAppearance_textAllCaps, false);
                z2 = true;
            }
            m2463a(context, a3);
            if (VERSION.SDK_INT < 23) {
                ColorStateList e = a3.mo2464g(R.styleable.TextAppearance_android_textColor) ? a3.mo2460e(R.styleable.TextAppearance_android_textColor) : null;
                colorStateList = a3.mo2464g(R.styleable.TextAppearance_android_textColorHint) ? a3.mo2460e(R.styleable.TextAppearance_android_textColorHint) : null;
                if (a3.mo2464g(R.styleable.TextAppearance_android_textColorLink)) {
                    colorStateList3 = a3.mo2460e(R.styleable.TextAppearance_android_textColorLink);
                }
                ColorStateList colorStateList4 = e;
                colorStateList2 = colorStateList3;
                colorStateList3 = colorStateList4;
            } else {
                colorStateList2 = null;
                colorStateList = null;
            }
            a3.mo2450a();
        } else {
            colorStateList2 = null;
            colorStateList = null;
            z2 = false;
            z = false;
        }
        C0645av a4 = C0645av.m2230a(context, attributeSet2, R.styleable.TextAppearance, i2, 0);
        if (z3 || !a4.mo2464g(R.styleable.TextAppearance_textAllCaps)) {
            z4 = z2;
        } else {
            z = a4.mo2451a(R.styleable.TextAppearance_textAllCaps, false);
        }
        if (VERSION.SDK_INT < 23) {
            if (a4.mo2464g(R.styleable.TextAppearance_android_textColor)) {
                colorStateList3 = a4.mo2460e(R.styleable.TextAppearance_android_textColor);
            }
            if (a4.mo2464g(R.styleable.TextAppearance_android_textColorHint)) {
                colorStateList = a4.mo2460e(R.styleable.TextAppearance_android_textColorHint);
            }
            if (a4.mo2464g(R.styleable.TextAppearance_android_textColorLink)) {
                colorStateList2 = a4.mo2460e(R.styleable.TextAppearance_android_textColorLink);
            }
        }
        if (VERSION.SDK_INT >= 28 && a4.mo2464g(R.styleable.TextAppearance_android_textSize) && a4.mo2459e(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f2039a.setTextSize(0, BitmapDescriptorFactory.HUE_RED);
        }
        m2463a(context, a4);
        a4.mo2450a();
        if (colorStateList3 != null) {
            this.f2039a.setTextColor(colorStateList3);
        }
        if (colorStateList != null) {
            this.f2039a.setHintTextColor(colorStateList);
        }
        if (colorStateList2 != null) {
            this.f2039a.setLinkTextColor(colorStateList2);
        }
        if (!z3 && z4) {
            mo2705a(z);
        }
        if (this.f2048j != null) {
            this.f2039a.setTypeface(this.f2048j, this.f2047i);
        }
        this.f2046h.mo2149a(attributeSet2, i2);
        if (C1006b.f3146d && this.f2046h.mo2145a() != 0) {
            int[] e2 = this.f2046h.mo2154e();
            if (e2.length > 0) {
                if (((float) this.f2039a.getAutoSizeStepGranularity()) != -1.0f) {
                    this.f2039a.setAutoSizeTextTypeUniformWithConfiguration(this.f2046h.mo2152c(), this.f2046h.mo2153d(), this.f2046h.mo2151b(), 0);
                } else {
                    this.f2039a.setAutoSizeTextTypeUniformWithPresetSizes(e2, 0);
                }
            }
        }
        C0645av a5 = C0645av.m2229a(context, attributeSet2, R.styleable.AppCompatTextView);
        int e3 = a5.mo2459e(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        int e4 = a5.mo2459e(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int e5 = a5.mo2459e(R.styleable.AppCompatTextView_lineHeight, -1);
        a5.mo2450a();
        if (e3 != -1) {
            C1013i.m3869b(this.f2039a, e3);
        }
        if (e4 != -1) {
            C1013i.m3872c(this.f2039a, e4);
        }
        if (e5 != -1) {
            C1013i.m3874d(this.f2039a, e5);
        }
    }

    /* renamed from: a */
    private void m2463a(Context context, C0645av avVar) {
        this.f2047i = avVar.mo2447a(R.styleable.TextAppearance_android_textStyle, this.f2047i);
        boolean z = true;
        if (avVar.mo2464g(R.styleable.TextAppearance_android_fontFamily) || avVar.mo2464g(R.styleable.TextAppearance_fontFamily)) {
            this.f2048j = null;
            int i = avVar.mo2464g(R.styleable.TextAppearance_fontFamily) ? R.styleable.TextAppearance_fontFamily : R.styleable.TextAppearance_android_fontFamily;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.f2039a);
                try {
                    this.f2048j = avVar.mo2448a(i, this.f2047i, (C0887a) new C0887a() {
                        public void onFontRetrievalFailed(int i) {
                        }

                        public void onFontRetrieved(Typeface typeface) {
                            C0705y.this.mo2704a(weakReference, typeface);
                        }
                    });
                    if (this.f2048j != null) {
                        z = false;
                    }
                    this.f2049k = z;
                } catch (NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f2048j == null) {
                String d = avVar.mo2458d(i);
                if (d != null) {
                    this.f2048j = Typeface.create(d, this.f2047i);
                }
            }
            return;
        }
        if (avVar.mo2464g(R.styleable.TextAppearance_android_typeface)) {
            this.f2049k = false;
            switch (avVar.mo2447a(R.styleable.TextAppearance_android_typeface, 1)) {
                case 1:
                    this.f2048j = Typeface.SANS_SERIF;
                    break;
                case 2:
                    this.f2048j = Typeface.SERIF;
                    break;
                case 3:
                    this.f2048j = Typeface.MONOSPACE;
                    break;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2704a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f2049k) {
            this.f2048j = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f2047i);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2702a(Context context, int i) {
        C0645av a = C0645av.m2228a(context, i, R.styleable.TextAppearance);
        if (a.mo2464g(R.styleable.TextAppearance_textAllCaps)) {
            mo2705a(a.mo2451a(R.styleable.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && a.mo2464g(R.styleable.TextAppearance_android_textColor)) {
            ColorStateList e = a.mo2460e(R.styleable.TextAppearance_android_textColor);
            if (e != null) {
                this.f2039a.setTextColor(e);
            }
        }
        if (a.mo2464g(R.styleable.TextAppearance_android_textSize) && a.mo2459e(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f2039a.setTextSize(0, BitmapDescriptorFactory.HUE_RED);
        }
        m2463a(context, a);
        a.mo2450a();
        if (this.f2048j != null) {
            this.f2039a.setTypeface(this.f2048j, this.f2047i);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2705a(boolean z) {
        this.f2039a.setAllCaps(z);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2698a() {
        if (!(this.f2040b == null && this.f2041c == null && this.f2042d == null && this.f2043e == null)) {
            Drawable[] compoundDrawables = this.f2039a.getCompoundDrawables();
            m2464a(compoundDrawables[0], this.f2040b);
            m2464a(compoundDrawables[1], this.f2041c);
            m2464a(compoundDrawables[2], this.f2042d);
            m2464a(compoundDrawables[3], this.f2043e);
        }
        if (VERSION.SDK_INT < 17) {
            return;
        }
        if (this.f2044f != null || this.f2045g != null) {
            Drawable[] compoundDrawablesRelative = this.f2039a.getCompoundDrawablesRelative();
            m2464a(compoundDrawablesRelative[0], this.f2044f);
            m2464a(compoundDrawablesRelative[2], this.f2045g);
        }
    }

    /* renamed from: a */
    private void m2464a(Drawable drawable, C0643at atVar) {
        if (drawable != null && atVar != null) {
            C0680k.m2400a(drawable, atVar, this.f2039a.getDrawableState());
        }
    }

    /* renamed from: a */
    private static C0643at m2462a(Context context, C0680k kVar, int i) {
        ColorStateList b = kVar.mo2594b(context, i);
        if (b == null) {
            return null;
        }
        C0643at atVar = new C0643at();
        atVar.f1858d = true;
        atVar.f1855a = b;
        return atVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2706a(boolean z, int i, int i2, int i3, int i4) {
        if (!C1006b.f3146d) {
            mo2708b();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2700a(int i, float f) {
        if (!C1006b.f3146d && !mo2709c()) {
            m2465b(i, f);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo2708b() {
        this.f2046h.mo2155f();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo2709c() {
        return this.f2046h.mo2156g();
    }

    /* renamed from: b */
    private void m2465b(int i, float f) {
        this.f2046h.mo2147a(i, f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2699a(int i) {
        this.f2046h.mo2146a(i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2701a(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        this.f2046h.mo2148a(i, i2, i3, i4);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2707a(int[] iArr, int i) throws IllegalArgumentException {
        this.f2046h.mo2150a(iArr, i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo2710d() {
        return this.f2046h.mo2145a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public int mo2711e() {
        return this.f2046h.mo2151b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public int mo2712f() {
        return this.f2046h.mo2152c();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public int mo2713g() {
        return this.f2046h.mo2153d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public int[] mo2714h() {
        return this.f2046h.mo2154e();
    }
}
