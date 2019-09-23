package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.core.graphics.drawable.C0983a;
import androidx.core.p070g.C0962r;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.C2167R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;
import java.util.Iterator;

class FloatingActionButtonImpl {
    static final int ANIM_STATE_HIDING = 1;
    static final int ANIM_STATE_NONE = 0;
    static final int ANIM_STATE_SHOWING = 2;
    static final long ELEVATION_ANIM_DELAY = 100;
    static final long ELEVATION_ANIM_DURATION = 100;
    static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    private static final float ELEVATION_MULTIPLIER = 0.75f;
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] ENABLED_STATE_SET = {16842910};
    static final int[] FOCUSED_ENABLED_STATE_SET = {16842908, 16842910};
    private static final float HIDE_ICON_SCALE = 0.0f;
    private static final float HIDE_OPACITY = 0.0f;
    private static final float HIDE_SCALE = 0.0f;
    static final int[] HOVERED_ENABLED_STATE_SET = {16843623, 16842910};
    static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = {16843623, 16842908, 16842910};
    private static final float OFFSET_MULTIPLIER = 0.25f;
    static final int[] PRESSED_ENABLED_STATE_SET = {16842919, 16842910};
    static final float SHADOW_MULTIPLIER = 1.5f;
    private static final float SHOW_ICON_SCALE = 1.0f;
    private static final float SHOW_OPACITY = 1.0f;
    private static final float SHOW_SCALE = 1.0f;
    int animState = 0;
    BorderDrawable borderDrawable;
    Drawable contentBackground;
    Animator currentAnimator;
    private MotionSpec defaultHideMotionSpec;
    private MotionSpec defaultShowMotionSpec;
    float elevation;
    private ArrayList<AnimatorListener> hideListeners;
    MotionSpec hideMotionSpec;
    float hoveredFocusedTranslationZ;
    float imageMatrixScale = 1.0f;
    private InsetDrawable insetDrawable;
    int maxImageSize;
    int minTouchTargetSize;
    private OnPreDrawListener preDrawListener;
    float pressedTranslationZ;
    Drawable rippleDrawable;
    private float rotation;
    final ShadowViewDelegate shadowViewDelegate;
    ShapeAppearanceModel shapeAppearance;
    MaterialShapeDrawable shapeDrawable;
    private ArrayList<AnimatorListener> showListeners;
    MotionSpec showMotionSpec;
    private final StateListAnimator stateListAnimator;
    private final Matrix tmpMatrix = new Matrix();
    private final Rect tmpRect = new Rect();
    private final RectF tmpRectF1 = new RectF();
    private final RectF tmpRectF2 = new RectF();
    private ArrayList<InternalTransformationListener> transformationListeners;
    boolean usingDefaultCorner;
    final FloatingActionButton view;

    private class DisabledElevationAnimation extends ShadowAnimatorImpl {
        /* access modifiers changed from: protected */
        public float getTargetShadowSize() {
            return BitmapDescriptorFactory.HUE_RED;
        }

        DisabledElevationAnimation() {
            super();
        }
    }

    private class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToHoveredFocusedTranslationZAnimation() {
            super();
        }

        /* access modifiers changed from: protected */
        public float getTargetShadowSize() {
            return FloatingActionButtonImpl.this.elevation + FloatingActionButtonImpl.this.hoveredFocusedTranslationZ;
        }
    }

    private class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToPressedTranslationZAnimation() {
            super();
        }

        /* access modifiers changed from: protected */
        public float getTargetShadowSize() {
            return FloatingActionButtonImpl.this.elevation + FloatingActionButtonImpl.this.pressedTranslationZ;
        }
    }

    interface InternalTransformationListener {
        void onScaleChanged();

        void onTranslationChanged();
    }

    interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    private class ResetElevationAnimation extends ShadowAnimatorImpl {
        ResetElevationAnimation() {
            super();
        }

        /* access modifiers changed from: protected */
        public float getTargetShadowSize() {
            return FloatingActionButtonImpl.this.elevation;
        }
    }

    private abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements AnimatorUpdateListener {
        private float shadowSizeEnd;
        private float shadowSizeStart;
        private boolean validValues;

        /* access modifiers changed from: protected */
        public abstract float getTargetShadowSize();

        private ShadowAnimatorImpl() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.validValues) {
                this.shadowSizeStart = (float) FloatingActionButtonImpl.this.shapeDrawable.getShadowElevation();
                this.shadowSizeEnd = getTargetShadowSize();
                this.validValues = true;
            }
            FloatingActionButtonImpl.this.updateShadow((float) ((int) (this.shadowSizeStart + ((this.shadowSizeEnd - this.shadowSizeStart) * valueAnimator.getAnimatedFraction()))));
        }

        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl.this.updateShadow((float) ((int) this.shadowSizeEnd));
            this.validValues = false;
        }
    }

    /* access modifiers changed from: 0000 */
    public void onCompatShadowChanged() {
    }

    /* access modifiers changed from: 0000 */
    public boolean requirePreDrawListener() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldAddPadding() {
        return true;
    }

    FloatingActionButtonImpl(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate2) {
        this.view = floatingActionButton;
        this.shadowViewDelegate = shadowViewDelegate2;
        this.stateListAnimator = new StateListAnimator();
        this.stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToPressedTranslationZAnimation()));
        this.stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        this.stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        this.stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        this.stateListAnimator.addState(ENABLED_STATE_SET, createElevationAnimator(new ResetElevationAnimation()));
        this.stateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(new DisabledElevationAnimation()));
        this.rotation = this.view.getRotation();
    }

    /* access modifiers changed from: 0000 */
    public void setBackgroundDrawable(ColorStateList colorStateList, Mode mode, ColorStateList colorStateList2, int i) {
        this.shapeDrawable = createShapeDrawable();
        this.shapeDrawable.setTintList(colorStateList);
        if (mode != null) {
            this.shapeDrawable.setTintMode(mode);
        }
        this.shapeDrawable.setShadowColor(-12303292);
        MaterialShapeDrawable createShapeDrawable = createShapeDrawable();
        createShapeDrawable.setTintList(RippleUtils.convertToRippleDrawableColor(colorStateList2));
        this.rippleDrawable = createShapeDrawable;
        this.contentBackground = new LayerDrawable(new Drawable[]{this.shapeDrawable, this.rippleDrawable});
        this.shadowViewDelegate.setBackgroundDrawable(this.contentBackground);
    }

    /* access modifiers changed from: 0000 */
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.shapeDrawable != null) {
            this.shapeDrawable.setTintList(colorStateList);
        }
        if (this.borderDrawable != null) {
            this.borderDrawable.setBorderTint(colorStateList);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setBackgroundTintMode(Mode mode) {
        if (this.shapeDrawable != null) {
            C0983a.m3701a((Drawable) this.shapeDrawable, mode);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setMinTouchTargetSize(int i) {
        this.minTouchTargetSize = i;
    }

    /* access modifiers changed from: 0000 */
    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleDrawable != null) {
            C0983a.m3698a(this.rippleDrawable, RippleUtils.convertToRippleDrawableColor(colorStateList));
        }
    }

    /* access modifiers changed from: 0000 */
    public final void setElevation(float f) {
        if (this.elevation != f) {
            this.elevation = f;
            onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        }
    }

    /* access modifiers changed from: 0000 */
    public float getElevation() {
        return this.elevation;
    }

    /* access modifiers changed from: 0000 */
    public float getHoveredFocusedTranslationZ() {
        return this.hoveredFocusedTranslationZ;
    }

    /* access modifiers changed from: 0000 */
    public float getPressedTranslationZ() {
        return this.pressedTranslationZ;
    }

    /* access modifiers changed from: 0000 */
    public final void setHoveredFocusedTranslationZ(float f) {
        if (this.hoveredFocusedTranslationZ != f) {
            this.hoveredFocusedTranslationZ = f;
            onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void setPressedTranslationZ(float f) {
        if (this.pressedTranslationZ != f) {
            this.pressedTranslationZ = f;
            onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void setMaxImageSize(int i) {
        if (this.maxImageSize != i) {
            this.maxImageSize = i;
            updateImageMatrixScale();
        }
    }

    /* access modifiers changed from: 0000 */
    public final void updateImageMatrixScale() {
        setImageMatrixScale(this.imageMatrixScale);
    }

    /* access modifiers changed from: 0000 */
    public final void setImageMatrixScale(float f) {
        this.imageMatrixScale = f;
        Matrix matrix = this.tmpMatrix;
        calculateImageMatrixFromScale(f, matrix);
        this.view.setImageMatrix(matrix);
    }

    private void calculateImageMatrixFromScale(float f, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.view.getDrawable();
        if (drawable != null && this.maxImageSize != 0) {
            RectF rectF = this.tmpRectF1;
            RectF rectF2 = this.tmpRectF2;
            rectF.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            rectF2.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) this.maxImageSize, (float) this.maxImageSize);
            matrix.setRectToRect(rectF, rectF2, ScaleToFit.CENTER);
            matrix.postScale(f, f, ((float) this.maxImageSize) / 2.0f, ((float) this.maxImageSize) / 2.0f);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void setShapeAppearance(ShapeAppearanceModel shapeAppearanceModel, boolean z) {
        if (z) {
            shapeAppearanceModel.setCornerRadius((float) (this.view.getSizeDimension() / 2));
        }
        this.shapeAppearance = shapeAppearanceModel;
        this.usingDefaultCorner = z;
        if (this.shapeDrawable != null) {
            this.shapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (this.rippleDrawable instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) this.rippleDrawable).setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (this.borderDrawable != null) {
            this.borderDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    /* access modifiers changed from: 0000 */
    public final MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    /* access modifiers changed from: 0000 */
    public final void setShowMotionSpec(MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    /* access modifiers changed from: 0000 */
    public final MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    /* access modifiers changed from: 0000 */
    public final void setHideMotionSpec(MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    /* access modifiers changed from: 0000 */
    public final boolean isAccessible() {
        return this.view.getSizeDimension() >= this.minTouchTargetSize;
    }

    /* access modifiers changed from: 0000 */
    public void onElevationsChanged(float f, float f2, float f3) {
        updatePadding();
        updateShadow(f);
    }

    /* access modifiers changed from: private */
    public void updateShadow(float f) {
        this.shapeDrawable.setShadowElevation((int) Math.ceil((double) (ELEVATION_MULTIPLIER * f)));
        this.shapeDrawable.setShadowVerticalOffset((int) Math.ceil((double) (f * OFFSET_MULTIPLIER)));
    }

    /* access modifiers changed from: 0000 */
    public void onDrawableStateChanged(int[] iArr) {
        this.stateListAnimator.setState(iArr);
    }

    /* access modifiers changed from: 0000 */
    public void jumpDrawableToCurrentState() {
        this.stateListAnimator.jumpToCurrentState();
    }

    /* access modifiers changed from: 0000 */
    public void addOnShowAnimationListener(AnimatorListener animatorListener) {
        if (this.showListeners == null) {
            this.showListeners = new ArrayList<>();
        }
        this.showListeners.add(animatorListener);
    }

    /* access modifiers changed from: 0000 */
    public void removeOnShowAnimationListener(AnimatorListener animatorListener) {
        if (this.showListeners != null) {
            this.showListeners.remove(animatorListener);
        }
    }

    public void addOnHideAnimationListener(AnimatorListener animatorListener) {
        if (this.hideListeners == null) {
            this.hideListeners = new ArrayList<>();
        }
        this.hideListeners.add(animatorListener);
    }

    public void removeOnHideAnimationListener(AnimatorListener animatorListener) {
        if (this.hideListeners != null) {
            this.hideListeners.remove(animatorListener);
        }
    }

    /* access modifiers changed from: 0000 */
    public void hide(final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z) {
        MotionSpec motionSpec;
        if (!isOrWillBeHidden()) {
            if (this.currentAnimator != null) {
                this.currentAnimator.cancel();
            }
            if (shouldAnimateVisibilityChange()) {
                if (this.hideMotionSpec != null) {
                    motionSpec = this.hideMotionSpec;
                } else {
                    motionSpec = getDefaultHideMotionSpec();
                }
                AnimatorSet createAnimator = createAnimator(motionSpec, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
                createAnimator.addListener(new AnimatorListenerAdapter() {
                    private boolean cancelled;

                    public void onAnimationStart(Animator animator) {
                        FloatingActionButtonImpl.this.view.internalSetVisibility(0, z);
                        FloatingActionButtonImpl.this.animState = 1;
                        FloatingActionButtonImpl.this.currentAnimator = animator;
                        this.cancelled = false;
                    }

                    public void onAnimationCancel(Animator animator) {
                        this.cancelled = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        FloatingActionButtonImpl.this.animState = 0;
                        FloatingActionButtonImpl.this.currentAnimator = null;
                        if (!this.cancelled) {
                            FloatingActionButtonImpl.this.view.internalSetVisibility(z ? 8 : 4, z);
                            if (internalVisibilityChangedListener != null) {
                                internalVisibilityChangedListener.onHidden();
                            }
                        }
                    }
                });
                if (this.hideListeners != null) {
                    Iterator it = this.hideListeners.iterator();
                    while (it.hasNext()) {
                        createAnimator.addListener((AnimatorListener) it.next());
                    }
                }
                createAnimator.start();
            } else {
                this.view.internalSetVisibility(z ? 8 : 4, z);
                if (internalVisibilityChangedListener != null) {
                    internalVisibilityChangedListener.onHidden();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void show(final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z) {
        MotionSpec motionSpec;
        if (!isOrWillBeShown()) {
            if (this.currentAnimator != null) {
                this.currentAnimator.cancel();
            }
            if (shouldAnimateVisibilityChange()) {
                if (this.view.getVisibility() != 0) {
                    this.view.setAlpha(BitmapDescriptorFactory.HUE_RED);
                    this.view.setScaleY(BitmapDescriptorFactory.HUE_RED);
                    this.view.setScaleX(BitmapDescriptorFactory.HUE_RED);
                    setImageMatrixScale(BitmapDescriptorFactory.HUE_RED);
                }
                if (this.showMotionSpec != null) {
                    motionSpec = this.showMotionSpec;
                } else {
                    motionSpec = getDefaultShowMotionSpec();
                }
                AnimatorSet createAnimator = createAnimator(motionSpec, 1.0f, 1.0f, 1.0f);
                createAnimator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        FloatingActionButtonImpl.this.view.internalSetVisibility(0, z);
                        FloatingActionButtonImpl.this.animState = 2;
                        FloatingActionButtonImpl.this.currentAnimator = animator;
                    }

                    public void onAnimationEnd(Animator animator) {
                        FloatingActionButtonImpl.this.animState = 0;
                        FloatingActionButtonImpl.this.currentAnimator = null;
                        if (internalVisibilityChangedListener != null) {
                            internalVisibilityChangedListener.onShown();
                        }
                    }
                });
                if (this.showListeners != null) {
                    Iterator it = this.showListeners.iterator();
                    while (it.hasNext()) {
                        createAnimator.addListener((AnimatorListener) it.next());
                    }
                }
                createAnimator.start();
            } else {
                this.view.internalSetVisibility(0, z);
                this.view.setAlpha(1.0f);
                this.view.setScaleY(1.0f);
                this.view.setScaleX(1.0f);
                setImageMatrixScale(1.0f);
                if (internalVisibilityChangedListener != null) {
                    internalVisibilityChangedListener.onShown();
                }
            }
        }
    }

    private MotionSpec getDefaultShowMotionSpec() {
        if (this.defaultShowMotionSpec == null) {
            this.defaultShowMotionSpec = MotionSpec.createFromResource(this.view.getContext(), C2167R.animator.design_fab_show_motion_spec);
        }
        return this.defaultShowMotionSpec;
    }

    private MotionSpec getDefaultHideMotionSpec() {
        if (this.defaultHideMotionSpec == null) {
            this.defaultHideMotionSpec = MotionSpec.createFromResource(this.view.getContext(), C2167R.animator.design_fab_hide_motion_spec);
        }
        return this.defaultHideMotionSpec;
    }

    private AnimatorSet createAnimator(MotionSpec motionSpec, float f, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.view, View.ALPHA, new float[]{f});
        motionSpec.getTiming("opacity").apply(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[]{f2});
        motionSpec.getTiming("scale").apply(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{f2});
        motionSpec.getTiming("scale").apply(ofFloat3);
        arrayList.add(ofFloat3);
        calculateImageMatrixFromScale(f3, this.tmpMatrix);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.view, new ImageMatrixProperty(), new MatrixEvaluator() {
            public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
                FloatingActionButtonImpl.this.imageMatrixScale = f;
                return super.evaluate(f, matrix, matrix2);
            }
        }, new Matrix[]{new Matrix(this.tmpMatrix)});
        motionSpec.getTiming("iconScale").apply(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    /* access modifiers changed from: 0000 */
    public void addTransformationListener(InternalTransformationListener internalTransformationListener) {
        if (this.transformationListeners == null) {
            this.transformationListeners = new ArrayList<>();
        }
        this.transformationListeners.add(internalTransformationListener);
    }

    /* access modifiers changed from: 0000 */
    public void removeTransformationListener(InternalTransformationListener internalTransformationListener) {
        if (this.transformationListeners != null) {
            this.transformationListeners.remove(internalTransformationListener);
        }
    }

    /* access modifiers changed from: 0000 */
    public void onTranslationChanged() {
        if (this.transformationListeners != null) {
            Iterator it = this.transformationListeners.iterator();
            while (it.hasNext()) {
                ((InternalTransformationListener) it.next()).onTranslationChanged();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void onScaleChanged() {
        if (this.transformationListeners != null) {
            Iterator it = this.transformationListeners.iterator();
            while (it.hasNext()) {
                ((InternalTransformationListener) it.next()).onScaleChanged();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final Drawable getContentBackground() {
        return this.contentBackground;
    }

    /* access modifiers changed from: 0000 */
    public void updateSize() {
        if (this.usingDefaultCorner) {
            this.shapeDrawable.getShapeAppearanceModel().setCornerRadius((float) (this.view.getSizeDimension() / 2));
        }
    }

    /* access modifiers changed from: 0000 */
    public final void updatePadding() {
        Rect rect = this.tmpRect;
        getPadding(rect);
        onPaddingUpdated(rect);
        this.shadowViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: 0000 */
    public void getPadding(Rect rect) {
        int sizeDimension = (this.minTouchTargetSize - this.view.getSizeDimension()) / 2;
        float elevation2 = getElevation() + this.pressedTranslationZ;
        int max = Math.max(sizeDimension, (int) Math.ceil((double) elevation2));
        int max2 = Math.max(sizeDimension, (int) Math.ceil((double) (elevation2 * SHADOW_MULTIPLIER)));
        rect.set(max, max2, max, max2);
    }

    /* access modifiers changed from: 0000 */
    public void onPaddingUpdated(Rect rect) {
        if (shouldAddPadding()) {
            InsetDrawable insetDrawable2 = new InsetDrawable(this.contentBackground, rect.left, rect.top, rect.right, rect.bottom);
            this.insetDrawable = insetDrawable2;
            this.shadowViewDelegate.setBackgroundDrawable(this.insetDrawable);
            return;
        }
        this.shadowViewDelegate.setBackgroundDrawable(this.contentBackground);
    }

    /* access modifiers changed from: 0000 */
    public void onAttachedToWindow() {
        if (requirePreDrawListener()) {
            ensurePreDrawListener();
            this.view.getViewTreeObserver().addOnPreDrawListener(this.preDrawListener);
        }
    }

    /* access modifiers changed from: 0000 */
    public void onDetachedFromWindow() {
        if (this.preDrawListener != null) {
            this.view.getViewTreeObserver().removeOnPreDrawListener(this.preDrawListener);
            this.preDrawListener = null;
        }
    }

    /* access modifiers changed from: 0000 */
    public void onPreDraw() {
        float rotation2 = this.view.getRotation();
        if (this.rotation != rotation2) {
            this.rotation = rotation2;
            updateFromViewRotation();
        }
    }

    private void ensurePreDrawListener() {
        if (this.preDrawListener == null) {
            this.preDrawListener = new OnPreDrawListener() {
                public boolean onPreDraw() {
                    FloatingActionButtonImpl.this.onPreDraw();
                    return true;
                }
            };
        }
    }

    /* access modifiers changed from: 0000 */
    public MaterialShapeDrawable createShapeDrawable() {
        if (this.usingDefaultCorner) {
            this.shapeAppearance.setCornerRadius((float) (this.view.getSizeDimension() / 2));
        }
        return new MaterialShapeDrawable(this.shapeAppearance);
    }

    /* access modifiers changed from: 0000 */
    public boolean isOrWillBeShown() {
        boolean z = false;
        if (this.view.getVisibility() != 0) {
            if (this.animState == 2) {
                z = true;
            }
            return z;
        }
        if (this.animState != 1) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public boolean isOrWillBeHidden() {
        boolean z = false;
        if (this.view.getVisibility() == 0) {
            if (this.animState == 1) {
                z = true;
            }
            return z;
        }
        if (this.animState != 2) {
            z = true;
        }
        return z;
    }

    private ValueAnimator createElevationAnimator(ShadowAnimatorImpl shadowAnimatorImpl) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(shadowAnimatorImpl);
        valueAnimator.addUpdateListener(shadowAnimatorImpl);
        valueAnimator.setFloatValues(new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
        return valueAnimator;
    }

    private boolean shouldAnimateVisibilityChange() {
        return C0962r.m3603z(this.view) && !this.view.isInEditMode();
    }

    /* access modifiers changed from: 0000 */
    public void updateFromViewRotation() {
        if (VERSION.SDK_INT == 19) {
            if (this.rotation % 90.0f != BitmapDescriptorFactory.HUE_RED) {
                if (this.view.getLayerType() != 1) {
                    this.view.setLayerType(1, null);
                }
            } else if (this.view.getLayerType() != 0) {
                this.view.setLayerType(0, null);
            }
        }
        if (this.shapeDrawable != null) {
            this.shapeDrawable.setShadowCompatRotation((int) this.rotation);
        }
    }
}
