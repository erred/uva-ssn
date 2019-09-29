package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.C0983a;
import androidx.core.p070g.C0962r;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.appcompat.widget.w */
/* compiled from: AppCompatSeekBarHelper */
class C0697w extends C0693s {

    /* renamed from: a */
    private final SeekBar f2011a;

    /* renamed from: b */
    private Drawable f2012b;

    /* renamed from: c */
    private ColorStateList f2013c = null;

    /* renamed from: d */
    private Mode f2014d = null;

    /* renamed from: e */
    private boolean f2015e = false;

    /* renamed from: f */
    private boolean f2016f = false;

    C0697w(SeekBar seekBar) {
        super(seekBar);
        this.f2011a = seekBar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2643a(AttributeSet attributeSet, int i) {
        super.mo2643a(attributeSet, i);
        C0645av a = C0645av.m2230a(this.f2011a.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i, 0);
        Drawable b = a.mo2454b(R.styleable.AppCompatSeekBar_android_thumb);
        if (b != null) {
            this.f2011a.setThumb(b);
        }
        mo2653a(a.mo2449a(R.styleable.AppCompatSeekBar_tickMark));
        if (a.mo2464g(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.f2014d = C0607ad.m2102a(a.mo2447a(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f2014d);
            this.f2016f = true;
        }
        if (a.mo2464g(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f2013c = a.mo2460e(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.f2015e = true;
        }
        a.mo2450a();
        m2446d();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2653a(Drawable drawable) {
        if (this.f2012b != null) {
            this.f2012b.setCallback(null);
        }
        this.f2012b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f2011a);
            C0983a.m3704b(drawable, C0962r.m3579f(this.f2011a));
            if (drawable.isStateful()) {
                drawable.setState(this.f2011a.getDrawableState());
            }
            m2446d();
        }
        this.f2011a.invalidate();
    }

    /* renamed from: d */
    private void m2446d() {
        if (this.f2012b == null) {
            return;
        }
        if (this.f2015e || this.f2016f) {
            this.f2012b = C0983a.m3709g(this.f2012b.mutate());
            if (this.f2015e) {
                C0983a.m3698a(this.f2012b, this.f2013c);
            }
            if (this.f2016f) {
                C0983a.m3701a(this.f2012b, this.f2014d);
            }
            if (this.f2012b.isStateful()) {
                this.f2012b.setState(this.f2011a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo2654b() {
        if (this.f2012b != null) {
            this.f2012b.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo2655c() {
        Drawable drawable = this.f2012b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f2011a.getDrawableState())) {
            this.f2011a.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2652a(Canvas canvas) {
        if (this.f2012b != null) {
            int max = this.f2011a.getMax();
            int i = 1;
            if (max > 1) {
                int intrinsicWidth = this.f2012b.getIntrinsicWidth();
                int intrinsicHeight = this.f2012b.getIntrinsicHeight();
                int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.f2012b.setBounds(-i2, -i, i2, i);
                float width = ((float) ((this.f2011a.getWidth() - this.f2011a.getPaddingLeft()) - this.f2011a.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f2011a.getPaddingLeft(), (float) (this.f2011a.getHeight() / 2));
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f2012b.draw(canvas);
                    canvas.translate(width, BitmapDescriptorFactory.HUE_RED);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
