package com.twitter.sdk.android.tweetui.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: com.twitter.sdk.android.tweetui.internal.a */
/* compiled from: AnimationUtils */
class C3343a {
    /* renamed from: a */
    public static ViewPropertyAnimator m9766a(final View view, int i) {
        if (view.getVisibility() != 0) {
            return null;
        }
        view.clearAnimation();
        ViewPropertyAnimator animate = view.animate();
        animate.alpha(BitmapDescriptorFactory.HUE_RED).setDuration((long) i).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(4);
                view.setAlpha(1.0f);
            }
        });
        return animate;
    }

    /* renamed from: b */
    public static ViewPropertyAnimator m9767b(View view, int i) {
        if (view.getVisibility() != 0) {
            view.setAlpha(BitmapDescriptorFactory.HUE_RED);
            view.setVisibility(0);
        }
        view.clearAnimation();
        ViewPropertyAnimator animate = view.animate();
        animate.alpha(1.0f).setDuration((long) i).setListener(null);
        return animate;
    }
}
