package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.p076e.p077a.p078a.C1045a;
import androidx.p076e.p077a.p078a.C1046b;
import androidx.p076e.p077a.p078a.C1047c;

public class AnimationUtils {
    public static final TimeInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new C1045a();
    public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new C1046b();
    public static final TimeInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new C1047c();

    public static float lerp(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int lerp(int i, int i2, float f) {
        return i + Math.round(f * ((float) (i2 - i)));
    }
}
