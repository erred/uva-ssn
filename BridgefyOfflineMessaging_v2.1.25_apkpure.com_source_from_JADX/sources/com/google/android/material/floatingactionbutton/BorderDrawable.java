package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.C0977a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

class BorderDrawable extends Drawable {
    private static final float DRAW_STROKE_WIDTH_MULTIPLE = 1.3333f;
    private ColorStateList borderTint;
    float borderWidth;
    private int bottomInnerStrokeColor;
    private int bottomOuterStrokeColor;
    private int currentBorderTintColor;
    private boolean invalidateShader = true;
    private final Paint paint;
    private final ShapeAppearancePathProvider pathProvider = new ShapeAppearancePathProvider();
    private final Rect rect = new Rect();
    private final RectF rectF = new RectF();
    private ShapeAppearanceModel shapeAppearanceModel;
    private final Path shapePath = new Path();
    private int topInnerStrokeColor;
    private int topOuterStrokeColor;

    BorderDrawable(ShapeAppearanceModel shapeAppearanceModel2) {
        this.shapeAppearanceModel = shapeAppearanceModel2;
        this.paint = new Paint(1);
        this.paint.setStyle(Style.STROKE);
    }

    public void setBorderWidth(float f) {
        if (this.borderWidth != f) {
            this.borderWidth = f;
            this.paint.setStrokeWidth(f * DRAW_STROKE_WIDTH_MULTIPLE);
            this.invalidateShader = true;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: 0000 */
    public void setBorderTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.currentBorderTintColor = colorStateList.getColorForState(getState(), this.currentBorderTintColor);
        }
        this.borderTint = colorStateList;
        this.invalidateShader = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    /* access modifiers changed from: 0000 */
    public void setGradientColors(int i, int i2, int i3, int i4) {
        this.topOuterStrokeColor = i;
        this.topInnerStrokeColor = i2;
        this.bottomOuterStrokeColor = i3;
        this.bottomInnerStrokeColor = i4;
    }

    public void draw(Canvas canvas) {
        if (this.invalidateShader) {
            this.paint.setShader(createGradientShader());
            this.invalidateShader = false;
        }
        float strokeWidth = this.paint.getStrokeWidth() / 2.0f;
        copyBounds(this.rect);
        this.rectF.set(this.rect);
        if (this.shapeAppearanceModel.isRoundRect()) {
            this.rectF.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.rectF, this.rectF.width() / 2.0f, this.rectF.height() / 2.0f, this.paint);
            return;
        }
        this.pathProvider.calculatePath(this.shapeAppearanceModel, 1.0f, this.rectF, this.shapePath);
        canvas.drawPath(this.shapePath, this.paint);
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.shapeAppearanceModel.isRoundRect()) {
            outline.setRoundRect(getBounds(), this.shapeAppearanceModel.getTopLeftCorner().getCornerSize());
            return;
        }
        copyBounds(this.rect);
        this.rectF.set(this.rect);
        this.pathProvider.calculatePath(this.shapeAppearanceModel, 1.0f, this.rectF, this.shapePath);
        if (this.shapePath.isConvex()) {
            outline.setConvexPath(this.shapePath);
        }
    }

    public boolean getPadding(Rect rect2) {
        if (this.shapeAppearanceModel.isRoundRect()) {
            int round = Math.round(this.borderWidth);
            rect2.set(round, round, round, round);
        }
        return true;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel2) {
        this.shapeAppearanceModel = shapeAppearanceModel2;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        this.paint.setAlpha(i);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.borderWidth > BitmapDescriptorFactory.HUE_RED ? -3 : -2;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect2) {
        this.invalidateShader = true;
    }

    public boolean isStateful() {
        return (this.borderTint != null && this.borderTint.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.borderTint != null) {
            int colorForState = this.borderTint.getColorForState(iArr, this.currentBorderTintColor);
            if (colorForState != this.currentBorderTintColor) {
                this.invalidateShader = true;
                this.currentBorderTintColor = colorForState;
            }
        }
        if (this.invalidateShader) {
            invalidateSelf();
        }
        return this.invalidateShader;
    }

    private Shader createGradientShader() {
        Rect rect2 = this.rect;
        copyBounds(rect2);
        float height = this.borderWidth / ((float) rect2.height());
        LinearGradient linearGradient = new LinearGradient(BitmapDescriptorFactory.HUE_RED, (float) rect2.top, BitmapDescriptorFactory.HUE_RED, (float) rect2.bottom, new int[]{C0977a.m3658a(this.topOuterStrokeColor, this.currentBorderTintColor), C0977a.m3658a(this.topInnerStrokeColor, this.currentBorderTintColor), C0977a.m3658a(C0977a.m3660b(this.topInnerStrokeColor, 0), this.currentBorderTintColor), C0977a.m3658a(C0977a.m3660b(this.bottomInnerStrokeColor, 0), this.currentBorderTintColor), C0977a.m3658a(this.bottomInnerStrokeColor, this.currentBorderTintColor), C0977a.m3658a(this.bottomOuterStrokeColor, this.currentBorderTintColor)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP);
        return linearGradient;
    }
}
