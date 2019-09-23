package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.C1407m;
import androidx.transition.C1424t;
import java.util.Map;

public class TextScale extends C1407m {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    public void captureStartValues(C1424t tVar) {
        captureValues(tVar);
    }

    public void captureEndValues(C1424t tVar) {
        captureValues(tVar);
    }

    private void captureValues(C1424t tVar) {
        if (tVar.f4234b instanceof TextView) {
            tVar.f4233a.put(PROPNAME_SCALE, Float.valueOf(((TextView) tVar.f4234b).getScaleX()));
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, C1424t tVar, C1424t tVar2) {
        if (tVar == null || tVar2 == null || !(tVar.f4234b instanceof TextView) || !(tVar2.f4234b instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) tVar2.f4234b;
        Map<String, Object> map = tVar.f4233a;
        Map<String, Object> map2 = tVar2.f4233a;
        float f = 1.0f;
        float floatValue = map.get(PROPNAME_SCALE) != null ? ((Float) map.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        if (map2.get(PROPNAME_SCALE) != null) {
            f = ((Float) map2.get(PROPNAME_SCALE)).floatValue();
        }
        if (floatValue == f) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{floatValue, f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }
}
