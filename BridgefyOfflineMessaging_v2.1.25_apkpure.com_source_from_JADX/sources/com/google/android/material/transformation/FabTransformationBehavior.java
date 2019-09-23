package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.C0825e;
import androidx.core.p070g.C0962r;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.C2167R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealScrimColorProperty;
import com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import java.util.ArrayList;
import java.util.List;
import p140me.bridgefy.ormlite.entities.FriendDTO;

public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    private float dependencyOriginalTranslationX;
    private float dependencyOriginalTranslationY;
    private final int[] tmpArray = new int[2];
    private final Rect tmpRect = new Rect();
    private final RectF tmpRectF1 = new RectF();
    private final RectF tmpRectF2 = new RectF();

    protected static class FabTransformationSpec {
        public Positioning positioning;
        public MotionSpec timings;

        protected FabTransformationSpec() {
        }
    }

    /* access modifiers changed from: protected */
    public abstract FabTransformationSpec onCreateMotionSpec(Context context, boolean z);

    public FabTransformationBehavior() {
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() != 8) {
            boolean z = false;
            if (!(view2 instanceof FloatingActionButton)) {
                return false;
            }
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                z = true;
            }
            return z;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    public void onAttachedToLayoutParams(C0825e eVar) {
        if (eVar.f2696h == 0) {
            eVar.f2696h = 80;
        }
    }

    /* access modifiers changed from: protected */
    public AnimatorSet onCreateExpandedStateChangeAnimation(View view, View view2, boolean z, boolean z2) {
        final boolean z3 = z;
        FabTransformationSpec onCreateMotionSpec = onCreateMotionSpec(view2.getContext(), z3);
        if (z3) {
            this.dependencyOriginalTranslationX = view.getTranslationX();
            this.dependencyOriginalTranslationY = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (VERSION.SDK_INT >= 21) {
            createElevationAnimation(view, view2, z, z2, onCreateMotionSpec, arrayList, arrayList2);
        }
        RectF rectF = this.tmpRectF1;
        View view3 = view;
        View view4 = view2;
        boolean z4 = z;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        createTranslationAnimation(view3, view4, z4, z2, onCreateMotionSpec, arrayList3, arrayList4, rectF);
        float width = rectF.width();
        float height = rectF.height();
        createDependencyTranslationAnimation(view3, view4, z4, onCreateMotionSpec, arrayList);
        boolean z5 = z2;
        FabTransformationSpec fabTransformationSpec = onCreateMotionSpec;
        createIconFadeAnimation(view3, view4, z4, z5, fabTransformationSpec, arrayList3, arrayList4);
        createExpansionAnimation(view3, view4, z4, z5, fabTransformationSpec, width, height, arrayList, arrayList2);
        ArrayList arrayList5 = arrayList;
        ArrayList arrayList6 = arrayList2;
        createColorAnimation(view3, view4, z4, z5, fabTransformationSpec, arrayList5, arrayList6);
        createChildrenFadeAnimation(view3, view4, z4, z5, fabTransformationSpec, arrayList5, arrayList6);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        final View view5 = view;
        final View view6 = view2;
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                if (z3) {
                    view6.setVisibility(0);
                    view5.setAlpha(BitmapDescriptorFactory.HUE_RED);
                    view5.setVisibility(4);
                }
            }

            public void onAnimationEnd(Animator animator) {
                if (!z3) {
                    view6.setVisibility(4);
                    view5.setAlpha(1.0f);
                    view5.setVisibility(0);
                }
            }
        });
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener((AnimatorListener) arrayList2.get(i));
        }
        return animatorSet;
    }

    @TargetApi(21)
    private void createElevationAnimation(View view, View view2, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        float o = C0962r.m3592o(view2) - C0962r.m3592o(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-o);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{0.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{-o});
        }
        fabTransformationSpec.timings.getTiming("elevation").apply(objectAnimator);
        list.add(objectAnimator);
    }

    private void createDependencyTranslationAnimation(View view, View view2, boolean z, FabTransformationSpec fabTransformationSpec, List<Animator> list) {
        float calculateTranslationX = calculateTranslationX(view, view2, fabTransformationSpec.positioning);
        float calculateTranslationY = calculateTranslationY(view, view2, fabTransformationSpec.positioning);
        Pair calculateMotionTiming = calculateMotionTiming(calculateTranslationX, calculateTranslationY, z, fabTransformationSpec);
        MotionTiming motionTiming = (MotionTiming) calculateMotionTiming.first;
        MotionTiming motionTiming2 = (MotionTiming) calculateMotionTiming.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            calculateTranslationX = this.dependencyOriginalTranslationX;
        }
        fArr[0] = calculateTranslationX;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            calculateTranslationY = this.dependencyOriginalTranslationY;
        }
        fArr2[0] = calculateTranslationY;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        motionTiming.apply(ofFloat);
        motionTiming2.apply(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private void createTranslationAnimation(View view, View view2, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<AnimatorListener> list2, RectF rectF) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        View view3 = view;
        View view4 = view2;
        boolean z3 = z;
        FabTransformationSpec fabTransformationSpec2 = fabTransformationSpec;
        List<Animator> list3 = list;
        float calculateTranslationX = calculateTranslationX(view3, view4, fabTransformationSpec2.positioning);
        float calculateTranslationY = calculateTranslationY(view3, view4, fabTransformationSpec2.positioning);
        Pair calculateMotionTiming = calculateMotionTiming(calculateTranslationX, calculateTranslationY, z3, fabTransformationSpec2);
        MotionTiming motionTiming = (MotionTiming) calculateMotionTiming.first;
        MotionTiming motionTiming2 = (MotionTiming) calculateMotionTiming.second;
        if (z3) {
            if (!z2) {
                view4.setTranslationX(-calculateTranslationX);
                view4.setTranslationY(-calculateTranslationY);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{0.0f});
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{0.0f});
            calculateChildVisibleBoundsAtEndOfExpansion(view2, fabTransformationSpec, motionTiming, motionTiming2, -calculateTranslationX, -calculateTranslationY, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, rectF);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{-calculateTranslationX});
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{-calculateTranslationY});
        }
        motionTiming.apply(objectAnimator2);
        motionTiming2.apply(objectAnimator);
        list3.add(objectAnimator2);
        list3.add(objectAnimator);
    }

    private void createIconFadeAnimation(View view, final View view2, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if ((view2 instanceof CircularRevealWidget) && (view instanceof ImageView)) {
            final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            final Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{0});
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{255});
                }
                objectAnimator.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        view2.invalidate();
                    }
                });
                fabTransformationSpec.timings.getTiming("iconFade").apply(objectAnimator);
                list.add(objectAnimator);
                list2.add(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        circularRevealWidget.setCircularRevealOverlayDrawable(drawable);
                    }

                    public void onAnimationEnd(Animator animator) {
                        circularRevealWidget.setCircularRevealOverlayDrawable(null);
                    }
                });
            }
        }
    }

    private void createExpansionAnimation(View view, View view2, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, float f, float f2, List<Animator> list, List<AnimatorListener> list2) {
        MotionTiming motionTiming;
        Animator animator;
        View view3 = view;
        View view4 = view2;
        FabTransformationSpec fabTransformationSpec2 = fabTransformationSpec;
        if (view4 instanceof CircularRevealWidget) {
            final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view4;
            float calculateRevealCenterX = calculateRevealCenterX(view3, view4, fabTransformationSpec2.positioning);
            float calculateRevealCenterY = calculateRevealCenterY(view3, view4, fabTransformationSpec2.positioning);
            ((FloatingActionButton) view3).getContentRect(this.tmpRect);
            float width = ((float) this.tmpRect.width()) / 2.0f;
            MotionTiming timing = fabTransformationSpec2.timings.getTiming("expansion");
            if (z) {
                if (!z2) {
                    circularRevealWidget.setRevealInfo(new RevealInfo(calculateRevealCenterX, calculateRevealCenterY, width));
                }
                float f3 = z2 ? circularRevealWidget.getRevealInfo().radius : width;
                animator = CircularRevealCompat.createCircularReveal(circularRevealWidget, calculateRevealCenterX, calculateRevealCenterY, MathUtils.distanceToFurthestCorner(calculateRevealCenterX, calculateRevealCenterY, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f, f2));
                animator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
                        revealInfo.radius = Float.MAX_VALUE;
                        circularRevealWidget.setRevealInfo(revealInfo);
                    }
                });
                createPreFillRadialExpansion(view2, timing.getDelay(), (int) calculateRevealCenterX, (int) calculateRevealCenterY, f3, list);
                motionTiming = timing;
            } else {
                float f4 = circularRevealWidget.getRevealInfo().radius;
                Animator createCircularReveal = CircularRevealCompat.createCircularReveal(circularRevealWidget, calculateRevealCenterX, calculateRevealCenterY, width);
                int i = (int) calculateRevealCenterX;
                int i2 = (int) calculateRevealCenterY;
                View view5 = view2;
                int i3 = i2;
                createPreFillRadialExpansion(view5, timing.getDelay(), i, i2, f4, list);
                motionTiming = timing;
                createPostFillRadialExpansion(view5, timing.getDelay(), timing.getDuration(), fabTransformationSpec2.timings.getTotalDuration(), i, i3, width, list);
                animator = createCircularReveal;
            }
            motionTiming.apply(animator);
            list.add(animator);
            list2.add(CircularRevealCompat.createCircularRevealListener(circularRevealWidget));
        }
    }

    private void createColorAnimation(View view, View view2, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof CircularRevealWidget) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            int backgroundTint = getBackgroundTint(view);
            int i = 16777215 & backgroundTint;
            if (z) {
                if (!z2) {
                    circularRevealWidget.setCircularRevealScrimColor(backgroundTint);
                }
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{i});
            } else {
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{backgroundTint});
            }
            objectAnimator.setEvaluator(ArgbEvaluatorCompat.getInstance());
            fabTransformationSpec.timings.getTiming(FriendDTO.COLOR).apply(objectAnimator);
            list.add(objectAnimator);
        }
    }

    private void createChildrenFadeAnimation(View view, View view2, boolean z, boolean z2, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof ViewGroup) {
            if (!(view2 instanceof CircularRevealWidget) || CircularRevealHelper.STRATEGY != 0) {
                ViewGroup calculateChildContentContainer = calculateChildContentContainer(view2);
                if (calculateChildContentContainer != null) {
                    if (z) {
                        if (!z2) {
                            ChildrenAlphaProperty.CHILDREN_ALPHA.set(calculateChildContentContainer, Float.valueOf(BitmapDescriptorFactory.HUE_RED));
                        }
                        objectAnimator = ObjectAnimator.ofFloat(calculateChildContentContainer, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{1.0f});
                    } else {
                        objectAnimator = ObjectAnimator.ofFloat(calculateChildContentContainer, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{0.0f});
                    }
                    fabTransformationSpec.timings.getTiming("contentFade").apply(objectAnimator);
                    list.add(objectAnimator);
                }
            }
        }
    }

    private Pair<MotionTiming, MotionTiming> calculateMotionTiming(float f, float f2, boolean z, FabTransformationSpec fabTransformationSpec) {
        MotionTiming motionTiming;
        MotionTiming motionTiming2;
        if (f != BitmapDescriptorFactory.HUE_RED) {
            int i = (f2 > BitmapDescriptorFactory.HUE_RED ? 1 : (f2 == BitmapDescriptorFactory.HUE_RED ? 0 : -1));
            if (i != 0) {
                if ((!z || f2 >= BitmapDescriptorFactory.HUE_RED) && (z || i <= 0)) {
                    motionTiming2 = fabTransformationSpec.timings.getTiming("translationXCurveDownwards");
                    motionTiming = fabTransformationSpec.timings.getTiming("translationYCurveDownwards");
                } else {
                    motionTiming2 = fabTransformationSpec.timings.getTiming("translationXCurveUpwards");
                    motionTiming = fabTransformationSpec.timings.getTiming("translationYCurveUpwards");
                }
                return new Pair<>(motionTiming2, motionTiming);
            }
        }
        motionTiming2 = fabTransformationSpec.timings.getTiming("translationXLinear");
        motionTiming = fabTransformationSpec.timings.getTiming("translationYLinear");
        return new Pair<>(motionTiming2, motionTiming);
    }

    private float calculateTranslationX(View view, View view2, Positioning positioning) {
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateDependencyWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        int i = positioning.gravity & 7;
        float f = i != 1 ? i != 3 ? i != 5 ? BitmapDescriptorFactory.HUE_RED : rectF2.right - rectF.right : rectF2.left - rectF.left : rectF2.centerX() - rectF.centerX();
        return f + positioning.xAdjustment;
    }

    private float calculateTranslationY(View view, View view2, Positioning positioning) {
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateDependencyWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        int i = positioning.gravity & 112;
        float f = i != 16 ? i != 48 ? i != 80 ? BitmapDescriptorFactory.HUE_RED : rectF2.bottom - rectF.bottom : rectF2.top - rectF.top : rectF2.centerY() - rectF.centerY();
        return f + positioning.yAdjustment;
    }

    private void calculateWindowBounds(View view, RectF rectF) {
        rectF.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.tmpArray;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    private void calculateDependencyWindowBounds(View view, RectF rectF) {
        calculateWindowBounds(view, rectF);
        rectF.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
    }

    private float calculateRevealCenterX(View view, View view2, Positioning positioning) {
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateDependencyWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        rectF2.offset(-calculateTranslationX(view, view2, positioning), BitmapDescriptorFactory.HUE_RED);
        return rectF.centerX() - rectF2.left;
    }

    private float calculateRevealCenterY(View view, View view2, Positioning positioning) {
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateDependencyWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        rectF2.offset(BitmapDescriptorFactory.HUE_RED, -calculateTranslationY(view, view2, positioning));
        return rectF.centerY() - rectF2.top;
    }

    private void calculateChildVisibleBoundsAtEndOfExpansion(View view, FabTransformationSpec fabTransformationSpec, MotionTiming motionTiming, MotionTiming motionTiming2, float f, float f2, float f3, float f4, RectF rectF) {
        float calculateValueOfAnimationAtEndOfExpansion = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming, f, f3);
        float calculateValueOfAnimationAtEndOfExpansion2 = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming2, f2, f4);
        Rect rect = this.tmpRect;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.tmpRectF1;
        rectF2.set(rect);
        RectF rectF3 = this.tmpRectF2;
        calculateWindowBounds(view, rectF3);
        rectF3.offset(calculateValueOfAnimationAtEndOfExpansion, calculateValueOfAnimationAtEndOfExpansion2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private float calculateValueOfAnimationAtEndOfExpansion(FabTransformationSpec fabTransformationSpec, MotionTiming motionTiming, float f, float f2) {
        long delay = motionTiming.getDelay();
        long duration = motionTiming.getDuration();
        MotionTiming timing = fabTransformationSpec.timings.getTiming("expansion");
        return AnimationUtils.lerp(f, f2, motionTiming.getInterpolator().getInterpolation(((float) (((timing.getDelay() + timing.getDuration()) + 17) - delay)) / ((float) duration)));
    }

    private ViewGroup calculateChildContentContainer(View view) {
        View findViewById = view.findViewById(C2167R.C2170id.mtrl_child_content_container);
        if (findViewById != null) {
            return toViewGroupOrNull(findViewById);
        }
        if ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) {
            return toViewGroupOrNull(((ViewGroup) view).getChildAt(0));
        }
        return toViewGroupOrNull(view);
    }

    private ViewGroup toViewGroupOrNull(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    private int getBackgroundTint(View view) {
        ColorStateList v = C0962r.m3599v(view);
        if (v != null) {
            return v.getColorForState(view.getDrawableState(), v.getDefaultColor());
        }
        return 0;
    }

    private void createPreFillRadialExpansion(View view, long j, int i, int i2, float f, List<Animator> list) {
        if (VERSION.SDK_INT >= 21 && j > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
            createCircularReveal.setStartDelay(0);
            createCircularReveal.setDuration(j);
            list.add(createCircularReveal);
        }
    }

    private void createPostFillRadialExpansion(View view, long j, long j2, long j3, int i, int i2, float f, List<Animator> list) {
        if (VERSION.SDK_INT >= 21) {
            long j4 = j + j2;
            if (j4 < j3) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
                createCircularReveal.setStartDelay(j4);
                createCircularReveal.setDuration(j3 - j4);
                list.add(createCircularReveal);
            }
        }
    }
}
