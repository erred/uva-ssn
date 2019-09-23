package com.google.android.material.card;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.C2167R;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

class MaterialCardViewHelper {
    private static final float CARD_VIEW_SHADOW_MULTIPLIER = 1.5f;
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    private static final int DEFAULT_STROKE_VALUE = -1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private final MaterialShapeDrawable bgDrawable;
    private LayerDrawable clickableForegroundDrawable;
    private MaterialShapeDrawable compatRippleDrawable;
    /* access modifiers changed from: private */
    public final MaterialShapeDrawable drawableInsetByStroke;
    private Drawable fgDrawable;
    private boolean isBackgroundOverwritten = false;
    private final MaterialCardView materialCardView;
    private int rippleColor;
    private Drawable rippleDrawable;
    private final ShapeAppearanceModel shapeAppearanceModel;
    private final ShapeAppearanceModel shapeAppearanceModelInsetByStroke;
    private int strokeColor;
    private final MaterialShapeDrawable strokeDrawable;
    private int strokeWidth;
    /* access modifiers changed from: private */
    public final Rect temporaryBounds = new Rect();
    private final Rect userContentPadding = new Rect();

    public MaterialCardViewHelper(MaterialCardView materialCardView2, AttributeSet attributeSet, int i, int i2) {
        this.materialCardView = materialCardView2;
        this.bgDrawable = new MaterialShapeDrawable(materialCardView2.getContext(), attributeSet, i, i2);
        this.shapeAppearanceModel = this.bgDrawable.getShapeAppearanceModel();
        this.bgDrawable.setShadowColor(-12303292);
        this.strokeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.strokeDrawable.setFillColor(ColorStateList.valueOf(0));
        this.fgDrawable = this.materialCardView.isClickable() ? getClickableForeground() : this.strokeDrawable;
        TypedArray obtainStyledAttributes = materialCardView2.getContext().obtainStyledAttributes(attributeSet, C2167R.styleable.CardView, i, C2167R.style.CardView);
        if (obtainStyledAttributes.hasValue(C2167R.styleable.CardView_cardCornerRadius)) {
            this.shapeAppearanceModel.setCornerRadius(obtainStyledAttributes.getDimension(C2167R.styleable.CardView_cardCornerRadius, BitmapDescriptorFactory.HUE_RED));
        }
        this.shapeAppearanceModelInsetByStroke = new ShapeAppearanceModel(this.shapeAppearanceModel);
        this.drawableInsetByStroke = new MaterialShapeDrawable(this.shapeAppearanceModelInsetByStroke);
    }

    public void loadFromAttributes(TypedArray typedArray) {
        this.strokeColor = typedArray.getColor(C2167R.styleable.MaterialCardView_strokeColor, -1);
        this.strokeWidth = typedArray.getDimensionPixelSize(C2167R.styleable.MaterialCardView_strokeWidth, 0);
        adjustShapeAppearanceModelInsetByStroke();
        this.rippleColor = getRippleColor();
        updateRippleColor();
        updateElevation();
        updateStroke();
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
        adjustContentPadding(this.strokeWidth);
    }

    /* access modifiers changed from: 0000 */
    public boolean isBackgroundOverwritten() {
        return this.isBackgroundOverwritten;
    }

    /* access modifiers changed from: 0000 */
    public void setBackgroundOverwritten(boolean z) {
        this.isBackgroundOverwritten = z;
    }

    /* access modifiers changed from: 0000 */
    public void setStrokeColor(int i) {
        if (this.strokeColor != i) {
            this.strokeColor = i;
            updateStroke();
        }
    }

    /* access modifiers changed from: 0000 */
    public int getStrokeColor() {
        return this.strokeColor;
    }

    /* access modifiers changed from: 0000 */
    public void setStrokeWidth(int i) {
        if (i != this.strokeWidth) {
            int i2 = i - this.strokeWidth;
            this.strokeWidth = i;
            adjustShapeAppearanceModelInsetByStroke();
            updateStroke();
            adjustContentPadding(i2);
        }
    }

    /* access modifiers changed from: 0000 */
    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    /* access modifiers changed from: 0000 */
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.bgDrawable.setFillColor(colorStateList);
    }

    /* access modifiers changed from: 0000 */
    public ColorStateList getCardBackgroundColor() {
        return this.bgDrawable.getFillColor();
    }

    /* access modifiers changed from: 0000 */
    public void setUserContentPadding(int i, int i2, int i3, int i4) {
        this.userContentPadding.set(i, i2, i3, i4);
        updateContentPadding();
    }

    /* access modifiers changed from: 0000 */
    public Rect getUserContentPadding() {
        return this.userContentPadding;
    }

    /* access modifiers changed from: 0000 */
    public void updateClickable() {
        Drawable drawable = this.fgDrawable;
        this.fgDrawable = this.materialCardView.isClickable() ? getClickableForeground() : this.strokeDrawable;
        if (drawable != this.fgDrawable) {
            updateInsetForeground(this.fgDrawable);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setCornerRadius(float f) {
        this.shapeAppearanceModel.setCornerRadius(f);
        this.shapeAppearanceModelInsetByStroke.setCornerRadius(f - ((float) this.strokeWidth));
        this.bgDrawable.invalidateSelf();
        this.fgDrawable.invalidateSelf();
        if (shouldAddCornerPaddingOutsideCardBackground() || shouldAddCornerPaddingInsideCardBackground()) {
            updateContentPadding();
        }
        if (shouldAddCornerPaddingOutsideCardBackground()) {
            updateInsets();
        }
    }

    /* access modifiers changed from: 0000 */
    public float getCornerRadius() {
        return this.shapeAppearanceModel.getTopLeftCorner().getCornerSize();
    }

    /* access modifiers changed from: 0000 */
    public void updateElevation() {
        if (VERSION.SDK_INT < 21) {
            this.bgDrawable.setShadowElevation((int) this.materialCardView.getCardElevation());
            this.bgDrawable.setShadowRadius((int) Math.ceil((double) (this.materialCardView.getCardElevation() * SHADOW_RADIUS_MULTIPLIER)));
            this.bgDrawable.setShadowVerticalOffset((int) Math.ceil((double) (this.materialCardView.getCardElevation() * SHADOW_OFFSET_MULTIPLIER)));
        }
    }

    /* access modifiers changed from: 0000 */
    public void updateInsets() {
        if (!isBackgroundOverwritten()) {
            this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        }
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    /* access modifiers changed from: 0000 */
    public void updateStroke() {
        if (this.strokeColor != -1) {
            this.strokeDrawable.setStroke((float) this.strokeWidth, this.strokeColor);
        }
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(21)
    public void createOutlineProvider(View view) {
        if (view != null) {
            this.materialCardView.setClipToOutline(false);
            if (canClipToOutline()) {
                view.setClipToOutline(true);
                view.setOutlineProvider(new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        MaterialCardViewHelper.this.temporaryBounds.set(0, 0, view.getWidth(), view.getHeight());
                        MaterialCardViewHelper.this.drawableInsetByStroke.setBounds(MaterialCardViewHelper.this.temporaryBounds);
                        MaterialCardViewHelper.this.drawableInsetByStroke.getOutline(outline);
                    }
                });
            } else {
                view.setClipToOutline(false);
                view.setOutlineProvider(null);
            }
        }
    }

    private void adjustShapeAppearanceModelInsetByStroke() {
        this.shapeAppearanceModelInsetByStroke.getTopLeftCorner().setCornerSize(this.shapeAppearanceModel.getTopLeftCorner().getCornerSize() - ((float) this.strokeWidth));
        this.shapeAppearanceModelInsetByStroke.getTopRightCorner().setCornerSize(this.shapeAppearanceModel.getTopRightCorner().getCornerSize() - ((float) this.strokeWidth));
        this.shapeAppearanceModelInsetByStroke.getBottomRightCorner().setCornerSize(this.shapeAppearanceModel.getBottomRightCorner().getCornerSize() - ((float) this.strokeWidth));
        this.shapeAppearanceModelInsetByStroke.getBottomLeftCorner().setCornerSize(this.shapeAppearanceModel.getBottomLeftCorner().getCornerSize() - ((float) this.strokeWidth));
    }

    private void updateInsetForeground(Drawable drawable) {
        if (VERSION.SDK_INT < 23 || !(this.materialCardView.getForeground() instanceof InsetDrawable)) {
            this.materialCardView.setForeground(insetDrawable(drawable));
        } else {
            ((InsetDrawable) this.materialCardView.getForeground()).setDrawable(drawable);
        }
    }

    private Drawable insetDrawable(Drawable drawable) {
        int i;
        int i2;
        if ((VERSION.SDK_INT < 21) || this.materialCardView.getUseCompatPadding()) {
            i2 = (int) Math.ceil((double) calculateHorizontalBackgroundPadding());
            i = (int) Math.ceil((double) calculateVerticalBackgroundPadding());
        } else {
            i2 = 0;
            i = 0;
        }
        C21992 r2 = new InsetDrawable(drawable, i2, i, i2, i) {
            public boolean getPadding(Rect rect) {
                return false;
            }
        };
        return r2;
    }

    private float calculateVerticalBackgroundPadding() {
        return (this.materialCardView.getMaxCardElevation() * CARD_VIEW_SHADOW_MULTIPLIER) + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : BitmapDescriptorFactory.HUE_RED);
    }

    private float calculateHorizontalBackgroundPadding() {
        return this.materialCardView.getMaxCardElevation() + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : BitmapDescriptorFactory.HUE_RED);
    }

    private boolean canClipToOutline() {
        return VERSION.SDK_INT >= 21 && this.shapeAppearanceModel.isRoundRect();
    }

    private float getParentCardViewCalculatedCornerPadding() {
        return (!this.materialCardView.getPreventCornerOverlap() || (VERSION.SDK_INT >= 21 && !this.materialCardView.getUseCompatPadding())) ? BitmapDescriptorFactory.HUE_RED : (float) ((1.0d - COS_45) * ((double) this.materialCardView.getCardViewRadius()));
    }

    private boolean shouldAddCornerPaddingInsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && !canClipToOutline();
    }

    private boolean shouldAddCornerPaddingOutsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && canClipToOutline() && this.materialCardView.getUseCompatPadding();
    }

    private float calculateActualCornerPadding() {
        return Math.max(Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopLeftCorner()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopRightCorner())), Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomRightCorner()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomLeftCorner())));
    }

    private float calculateCornerPaddingForCornerTreatment(CornerTreatment cornerTreatment) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - COS_45) * ((double) cornerTreatment.getCornerSize()));
        }
        return cornerTreatment instanceof CutCornerTreatment ? cornerTreatment.getCornerSize() / 2.0f : BitmapDescriptorFactory.HUE_RED;
    }

    private Drawable getClickableForeground() {
        if (this.rippleDrawable == null) {
            this.rippleDrawable = createForegroundRippleDrawable();
        }
        if (this.clickableForegroundDrawable == null) {
            this.clickableForegroundDrawable = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.strokeDrawable});
        }
        return this.clickableForegroundDrawable;
    }

    private void adjustContentPadding(int i) {
        this.materialCardView.setContentPadding(this.materialCardView.getContentPaddingLeft() + i, this.materialCardView.getContentPaddingTop() + i, this.materialCardView.getContentPaddingRight() + i, this.materialCardView.getContentPaddingBottom() + i);
    }

    /* access modifiers changed from: 0000 */
    public void updateContentPadding() {
        int calculateActualCornerPadding = (int) ((shouldAddCornerPaddingInsideCardBackground() || shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : BitmapDescriptorFactory.HUE_RED) - getParentCardViewCalculatedCornerPadding());
        this.materialCardView.setContentPaddingInternal(this.userContentPadding.left + calculateActualCornerPadding, this.userContentPadding.top + calculateActualCornerPadding, this.userContentPadding.right + calculateActualCornerPadding, this.userContentPadding.bottom + calculateActualCornerPadding);
    }

    private int getRippleColor() {
        Context context = this.materialCardView.getContext();
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C2167R.attr.colorControlHighlight, typedValue, true);
        return typedValue.data;
    }

    private Drawable createForegroundRippleDrawable() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
            return new RippleDrawable(ColorStateList.valueOf(this.rippleColor), null, createForegroundShapeDrawable());
        }
        return createCompatRippleDrawable();
    }

    private Drawable createCompatRippleDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.compatRippleDrawable = createForegroundShapeDrawable();
        this.compatRippleDrawable.setFillColor(ColorStateList.valueOf(this.rippleColor));
        stateListDrawable.addState(new int[]{16842919}, this.compatRippleDrawable);
        return stateListDrawable;
    }

    private void updateRippleColor() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE && this.rippleDrawable != null) {
            ((RippleDrawable) this.rippleDrawable).setColor(ColorStateList.valueOf(this.rippleColor));
        } else if (this.compatRippleDrawable != null) {
            this.compatRippleDrawable.setFillColor(ColorStateList.valueOf(this.rippleColor));
        }
    }

    private MaterialShapeDrawable createForegroundShapeDrawable() {
        return new MaterialShapeDrawable(this.shapeAppearanceModel);
    }
}
