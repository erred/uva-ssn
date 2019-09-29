package com.twitter.sdk.android.tweetui.internal;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: com.twitter.sdk.android.tweetui.internal.f */
/* compiled from: SwipeToDismissTouchListener */
public class C3353f implements OnTouchListener {

    /* renamed from: a */
    private int f8760a;

    /* renamed from: b */
    private float f8761b;

    /* renamed from: c */
    private final float f8762c;

    /* renamed from: d */
    private final float f8763d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C3355a f8764e;

    /* renamed from: f */
    private float f8765f;

    /* renamed from: g */
    private float f8766g;

    /* renamed from: h */
    private int f8767h;

    /* renamed from: i */
    private boolean f8768i;

    /* renamed from: com.twitter.sdk.android.tweetui.internal.f$a */
    /* compiled from: SwipeToDismissTouchListener */
    public interface C3355a {
        /* renamed from: a */
        void mo27978a();

        /* renamed from: a */
        void mo27979a(float f);
    }

    /* renamed from: com.twitter.sdk.android.tweetui.internal.f$b */
    /* compiled from: SwipeToDismissTouchListener */
    public interface C3356b {
        /* renamed from: f */
        boolean mo28121f();
    }

    /* renamed from: a */
    public static C3353f m9788a(View view, C3355a aVar) {
        return new C3353f(aVar, ViewConfiguration.get(view.getContext()).getScaledTouchSlop(), ((float) view.getContext().getResources().getDisplayMetrics().heightPixels) * 0.5f);
    }

    C3353f(C3355a aVar, int i, float f) {
        this(aVar, i, f, 0.2f * f);
    }

    C3353f(C3355a aVar, int i, float f, float f2) {
        mo28142a(aVar);
        this.f8760a = i;
        this.f8762c = f;
        this.f8763d = f2;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        if (!(view instanceof C3356b) || ((C3356b) view).mo28121f() || mo28143a()) {
            z = mo28148a(view, motionEvent);
        } else {
            z = false;
        }
        if (z || view.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo28148a(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 5) {
            switch (actionMasked) {
                case 0:
                    this.f8765f = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    this.f8766g = rawY;
                    this.f8761b = rawY;
                    this.f8768i = false;
                    this.f8767h = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
                    break;
                case 1:
                case 3:
                    boolean a = (!mo28146a(motionEvent) || !this.f8768i) ? false : mo28147a(view);
                    this.f8768i = false;
                    return a;
                case 2:
                    float rawX = motionEvent.getRawX();
                    float rawY2 = motionEvent.getRawY();
                    float f = rawY2 - this.f8761b;
                    float f2 = rawX - this.f8765f;
                    float f3 = rawY2 - this.f8766g;
                    this.f8765f = rawX;
                    this.f8766g = rawY2;
                    if (mo28146a(motionEvent) && (this.f8768i || (mo28144a(f) && mo28145a(f2, f3)))) {
                        this.f8768i = true;
                        mo28141a(view, f3);
                        break;
                    }
            }
        } else {
            mo28150b(view);
            this.f8768i = false;
            this.f8767h = -1;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo28144a(float f) {
        return Math.abs(f) > ((float) this.f8760a);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo28145a(float f, float f2) {
        return Math.abs(f2) > Math.abs(f);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo28143a() {
        return this.f8768i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo28146a(MotionEvent motionEvent) {
        return this.f8767h >= 0 && motionEvent.getPointerCount() == 1;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo28147a(View view) {
        float translationY = view.getTranslationY();
        if (translationY > this.f8763d || translationY < (-this.f8763d)) {
            if (this.f8764e != null) {
                this.f8764e.mo27978a();
            }
            return true;
        }
        mo28150b(view);
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo28150b(View view) {
        if (view.getTranslationY() != BitmapDescriptorFactory.HUE_RED) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{0.0f}).setDuration(100);
            duration.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (C3353f.this.f8764e != null) {
                        C3353f.this.f8764e.mo27979a(floatValue);
                    }
                }
            });
            duration.start();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28141a(View view, float f) {
        float translationY = view.getTranslationY();
        float c = mo28151c(translationY + ((float) (((double) f) * mo28149b(translationY))));
        view.setTranslationY(c);
        if (this.f8764e != null) {
            this.f8764e.mo27979a(c);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public double mo28149b(float f) {
        return 1.0d - (Math.pow((double) Math.abs(f), 2.0d) / Math.pow((double) (this.f8763d * 2.0f), 2.0d));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public float mo28151c(float f) {
        if (f < (-this.f8762c)) {
            return -this.f8762c;
        }
        return f > this.f8762c ? this.f8762c : f;
    }

    /* renamed from: a */
    public void mo28142a(C3355a aVar) {
        this.f8764e = aVar;
    }
}
