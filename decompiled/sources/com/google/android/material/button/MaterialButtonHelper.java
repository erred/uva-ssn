package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import androidx.core.graphics.drawable.C0983a;
import androidx.core.p070g.C0962r;
import com.google.android.material.C2167R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

class MaterialButtonHelper {
    private static final float CORNER_RADIUS_ADJUSTMENT = 1.0E-5f;
    private static final boolean IS_LOLLIPOP = (VERSION.SDK_INT >= 21);
    private boolean backgroundOverwritten = false;
    private ColorStateList backgroundTint;
    private Mode backgroundTintMode;
    private int cornerRadius;
    private boolean cornerRadiusSet = false;
    private int insetBottom;
    private int insetLeft;
    private int insetRight;
    private int insetTop;
    private MaterialShapeDrawable maskDrawable;
    private final MaterialButton materialButton;
    private ColorStateList rippleColor;
    private LayerDrawable rippleDrawable;
    private final ShapeAppearanceModel shapeAppearanceModel;
    private ColorStateList strokeColor;
    private int strokeWidth;

    MaterialButtonHelper(MaterialButton materialButton2, ShapeAppearanceModel shapeAppearanceModel2) {
        this.materialButton = materialButton2;
        this.shapeAppearanceModel = shapeAppearanceModel2;
    }

    /* access modifiers changed from: 0000 */
    public void loadFromAttributes(TypedArray typedArray) {
        this.insetLeft = typedArray.getDimensionPixelOffset(C2167R.styleable.MaterialButton_android_insetLeft, 0);
        this.insetRight = typedArray.getDimensionPixelOffset(C2167R.styleable.MaterialButton_android_insetRight, 0);
        this.insetTop = typedArray.getDimensionPixelOffset(C2167R.styleable.MaterialButton_android_insetTop, 0);
        this.insetBottom = typedArray.getDimensionPixelOffset(C2167R.styleable.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(C2167R.styleable.MaterialButton_cornerRadius)) {
            this.cornerRadius = typedArray.getDimensionPixelSize(C2167R.styleable.MaterialButton_cornerRadius, -1);
            this.shapeAppearanceModel.setCornerRadius((float) this.cornerRadius);
            this.cornerRadiusSet = true;
        }
        adjustShapeAppearanceModelCornerRadius(this.shapeAppearanceModel, CORNER_RADIUS_ADJUSTMENT);
        this.strokeWidth = typedArray.getDimensionPixelSize(C2167R.styleable.MaterialButton_strokeWidth, 0);
        this.backgroundTintMode = ViewUtils.parseTintMode(typedArray.getInt(C2167R.styleable.MaterialButton_backgroundTintMode, -1), Mode.SRC_IN);
        this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, C2167R.styleable.MaterialButton_backgroundTint);
        this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, C2167R.styleable.MaterialButton_strokeColor);
        this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, C2167R.styleable.MaterialButton_rippleColor);
        int h = C0962r.m3583h(this.materialButton);
        int paddingTop = this.materialButton.getPaddingTop();
        int i = C0962r.m3585i(this.materialButton);
        int paddingBottom = this.materialButton.getPaddingBottom();
        this.materialButton.setInternalBackground(createBackground());
        C0962r.m3553a(this.materialButton, h + this.insetLeft, paddingTop + this.insetTop, i + this.insetRight, paddingBottom + this.insetBottom);
    }

    /* access modifiers changed from: 0000 */
    public void setBackgroundOverwritten() {
        this.backgroundOverwritten = true;
        this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
        this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
    }

    /* access modifiers changed from: 0000 */
    public boolean isBackgroundOverwritten() {
        return this.backgroundOverwritten;
    }

    private InsetDrawable wrapDrawableWithInset(Drawable drawable) {
        InsetDrawable insetDrawable = new InsetDrawable(drawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
        return insetDrawable;
    }

    /* access modifiers changed from: 0000 */
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            if (getMaterialShapeDrawable() != null) {
                C0983a.m3698a((Drawable) getMaterialShapeDrawable(), this.backgroundTint);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public ColorStateList getSupportBackgroundTintList() {
        return this.backgroundTint;
    }

    /* access modifiers changed from: 0000 */
    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            if (getMaterialShapeDrawable() != null && this.backgroundTintMode != null) {
                C0983a.m3701a((Drawable) getMaterialShapeDrawable(), this.backgroundTintMode);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public Mode getSupportBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    private Drawable createBackground() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        C0983a.m3698a((Drawable) materialShapeDrawable, this.backgroundTint);
        if (this.backgroundTintMode != null) {
            C0983a.m3701a((Drawable) materialShapeDrawable, this.backgroundTintMode);
        }
        materialShapeDrawable.setStroke((float) this.strokeWidth, this.strokeColor);
        this.maskDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        if (IS_LOLLIPOP) {
            if (this.strokeWidth > 0) {
                ShapeAppearanceModel shapeAppearanceModel2 = new ShapeAppearanceModel(this.shapeAppearanceModel);
                adjustShapeAppearanceModelCornerRadius(shapeAppearanceModel2, ((float) this.strokeWidth) / 2.0f);
                materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel2);
                this.maskDrawable.setShapeAppearanceModel(shapeAppearanceModel2);
            }
            C0983a.m3696a((Drawable) this.maskDrawable, -1);
            this.rippleDrawable = new RippleDrawable(RippleUtils.convertToRippleDrawableColor(this.rippleColor), wrapDrawableWithInset(materialShapeDrawable), this.maskDrawable);
            return this.rippleDrawable;
        }
        C0983a.m3698a((Drawable) this.maskDrawable, RippleUtils.convertToRippleDrawableColor(this.rippleColor));
        this.rippleDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable, this.maskDrawable});
        return wrapDrawableWithInset(this.rippleDrawable);
    }

    /* access modifiers changed from: 0000 */
    public void updateMaskBounds(int i, int i2) {
        if (this.maskDrawable != null) {
            this.maskDrawable.setBounds(this.insetLeft, this.insetTop, i2 - this.insetRight, i - this.insetBottom);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setBackgroundColor(int i) {
        if (getMaterialShapeDrawable() != null) {
            getMaterialShapeDrawable().setTint(i);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            if (IS_LOLLIPOP && (this.materialButton.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.materialButton.getBackground()).setColor(RippleUtils.convertToRippleDrawableColor(colorStateList));
            } else if (!IS_LOLLIPOP && getMaskDrawable() != null) {
                C0983a.m3698a((Drawable) getMaskDrawable(), RippleUtils.convertToRippleDrawableColor(colorStateList));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    /* access modifiers changed from: 0000 */
    public void setStrokeColor(ColorStateList colorStateList) {
        if (this.strokeColor != colorStateList) {
            this.strokeColor = colorStateList;
            updateStroke();
        }
    }

    /* access modifiers changed from: 0000 */
    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    /* access modifiers changed from: 0000 */
    public void setStrokeWidth(int i) {
        if (this.strokeWidth != i) {
            this.strokeWidth = i;
            updateStroke();
        }
    }

    /* access modifiers changed from: 0000 */
    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    private void updateStroke() {
        this.materialButton.setInternalBackground(createBackground());
    }

    /* access modifiers changed from: 0000 */
    public void setCornerRadius(int i) {
        if (!this.cornerRadiusSet || this.cornerRadius != i) {
            this.cornerRadius = i;
            this.cornerRadiusSet = true;
            this.shapeAppearanceModel.setCornerRadius(((float) i) + CORNER_RADIUS_ADJUSTMENT + (((float) this.strokeWidth) / 2.0f));
            if (getMaterialShapeDrawable() != null) {
                getMaterialShapeDrawable().setShapeAppearanceModel(this.shapeAppearanceModel);
            }
            if (getMaskDrawable() != null) {
                getMaskDrawable().setShapeAppearanceModel(this.shapeAppearanceModel);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public int getCornerRadius() {
        return this.cornerRadius;
    }

    private void adjustShapeAppearanceModelCornerRadius(ShapeAppearanceModel shapeAppearanceModel2, float f) {
        shapeAppearanceModel2.getTopLeftCorner().setCornerSize(shapeAppearanceModel2.getTopLeftCorner().getCornerSize() + f);
        shapeAppearanceModel2.getTopRightCorner().setCornerSize(shapeAppearanceModel2.getTopRightCorner().getCornerSize() + f);
        shapeAppearanceModel2.getBottomRightCorner().setCornerSize(shapeAppearanceModel2.getBottomRightCorner().getCornerSize() + f);
        shapeAppearanceModel2.getBottomLeftCorner().setCornerSize(shapeAppearanceModel2.getBottomLeftCorner().getCornerSize() + f);
    }

    private MaterialShapeDrawable getMaterialShapeDrawable() {
        Drawable drawable = (this.rippleDrawable == null || this.rippleDrawable.getNumberOfLayers() <= 0) ? null : this.rippleDrawable.getDrawable(0);
        if (drawable instanceof MaterialShapeDrawable) {
            return (MaterialShapeDrawable) drawable;
        }
        if (drawable instanceof InsetDrawable) {
            InsetDrawable insetDrawable = (InsetDrawable) drawable;
            if (IS_LOLLIPOP) {
                return (MaterialShapeDrawable) insetDrawable.getDrawable();
            }
        }
        return null;
    }

    public MaterialShapeDrawable getMaskDrawable() {
        if (this.rippleDrawable == null || this.rippleDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return (MaterialShapeDrawable) this.rippleDrawable.getDrawable(1);
    }
}
