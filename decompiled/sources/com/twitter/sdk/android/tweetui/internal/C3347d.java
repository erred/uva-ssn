package com.twitter.sdk.android.tweetui.internal;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.twitter.sdk.android.tweetui.internal.C3353f.C3356b;

/* renamed from: com.twitter.sdk.android.tweetui.internal.d */
/* compiled from: MultiTouchImageView */
public class C3347d extends ImageView implements C3356b {

    /* renamed from: a */
    final ScaleGestureDetector f8744a;

    /* renamed from: b */
    final GestureDetector f8745b;

    /* renamed from: c */
    final Matrix f8746c;

    /* renamed from: d */
    final Matrix f8747d;

    /* renamed from: e */
    final Matrix f8748e;

    /* renamed from: f */
    final RectF f8749f;

    /* renamed from: g */
    final RectF f8750g;

    /* renamed from: h */
    final float[] f8751h;

    /* renamed from: i */
    boolean f8752i;

    public C3347d(Context context) {
        this(context, null);
    }

    public C3347d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C3347d(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8746c = new Matrix();
        this.f8747d = new Matrix();
        this.f8748e = new Matrix();
        this.f8749f = new RectF();
        this.f8750g = new RectF();
        this.f8751h = new float[9];
        this.f8744a = new ScaleGestureDetector(context, new SimpleOnScaleGestureListener() {
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                C3347d.this.mo28112a(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                C3347d.this.mo28120e();
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                if (C3347d.this.getScale() < 1.0f) {
                    C3347d.this.mo28118c();
                    C3347d.this.mo28120e();
                }
            }
        });
        this.f8745b = new GestureDetector(context, new SimpleOnGestureListener() {
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                C3347d.this.mo28111a(-f, -f2);
                C3347d.this.mo28120e();
                if (C3347d.this.f8752i && !C3347d.this.f8744a.isInProgress()) {
                    C3347d.this.mo28115a(false);
                }
                return true;
            }

            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (C3347d.this.getScale() > 1.0f) {
                    C3347d.this.mo28113a(C3347d.this.getScale(), 1.0f, motionEvent.getX(), motionEvent.getY());
                } else {
                    C3347d.this.mo28113a(C3347d.this.getScale(), 2.0f, motionEvent.getX(), motionEvent.getY());
                }
                return true;
            }
        });
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo28116a() {
        Drawable drawable = getDrawable();
        return drawable != null && drawable.getIntrinsicWidth() > 0;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (mo28116a()) {
            mo28117b();
            mo28114a(getDrawable());
            mo28120e();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo28117b() {
        this.f8749f.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28114a(Drawable drawable) {
        RectF rectF = new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        this.f8747d.reset();
        this.f8747d.setRectToRect(rectF, this.f8749f, ScaleToFit.CENTER);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!mo28116a()) {
            return false;
        }
        boolean z = true;
        mo28115a(true);
        if (!(this.f8745b.onTouchEvent(motionEvent) || this.f8744a.onTouchEvent(motionEvent)) && !super.onTouchEvent(motionEvent)) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28115a(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28112a(float f, float f2, float f3) {
        this.f8748e.postScale(f, f, f2, f3);
    }

    /* access modifiers changed from: 0000 */
    public float getScale() {
        this.f8748e.getValues(this.f8751h);
        return this.f8751h[0];
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28111a(float f, float f2) {
        this.f8748e.postTranslate(f, f2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo28118c() {
        this.f8748e.reset();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo28119d() {
        RectF a = mo28110a(getDrawMatrix());
        float height = a.height();
        float height2 = this.f8749f.height();
        float f = BitmapDescriptorFactory.HUE_RED;
        float f2 = height <= height2 ? ((this.f8749f.height() - a.height()) / 2.0f) - a.top : a.top > BitmapDescriptorFactory.HUE_RED ? -a.top : a.bottom < this.f8749f.height() ? this.f8749f.height() - a.bottom : BitmapDescriptorFactory.HUE_RED;
        if (a.width() <= this.f8749f.width()) {
            this.f8752i = true;
            f = ((this.f8749f.width() - a.width()) / 2.0f) - a.left;
        } else if (a.left > BitmapDescriptorFactory.HUE_RED) {
            this.f8752i = true;
            f = -a.left;
        } else if (a.right < this.f8749f.width()) {
            this.f8752i = true;
            f = this.f8749f.width() - a.right;
        } else {
            this.f8752i = false;
        }
        mo28111a(f, f2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public RectF mo28110a(Matrix matrix) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            this.f8750g.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            matrix.mapRect(this.f8750g);
        }
        return this.f8750g;
    }

    /* access modifiers changed from: 0000 */
    public Matrix getDrawMatrix() {
        this.f8746c.set(this.f8747d);
        this.f8746c.postConcat(this.f8748e);
        return this.f8746c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo28120e() {
        mo28119d();
        setScaleType(ScaleType.MATRIX);
        setImageMatrix(getDrawMatrix());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28113a(float f, float f2, final float f3, final float f4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                C3347d.this.mo28112a(((Float) valueAnimator.getAnimatedValue()).floatValue() / C3347d.this.getScale(), f3, f4);
                C3347d.this.mo28120e();
            }
        });
        ofFloat.start();
    }

    /* renamed from: f */
    public boolean mo28121f() {
        return getScale() == 1.0f;
    }
}
