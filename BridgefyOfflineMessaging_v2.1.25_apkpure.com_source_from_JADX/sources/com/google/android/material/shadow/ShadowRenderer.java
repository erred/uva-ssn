package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Shader.TileMode;
import androidx.core.graphics.C0977a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class ShadowRenderer {
    private static final int COLOR_ALPHA_END = 0;
    private static final int COLOR_ALPHA_MIDDLE = 20;
    private static final int COLOR_ALPHA_START = 68;
    private static final int[] cornerColors = new int[4];
    private static final float[] cornerPositions = {BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0.5f, 1.0f};
    private static final int[] edgeColors = new int[3];
    private static final float[] edgePositions = {BitmapDescriptorFactory.HUE_RED, 0.5f, 1.0f};
    private final Paint cornerShadowPaint;
    private final Paint edgeShadowPaint;
    private final Path scratch;
    private int shadowEndColor;
    private int shadowMiddleColor;
    private final Paint shadowPaint;
    private int shadowStartColor;

    public ShadowRenderer() {
        this(-16777216);
    }

    public ShadowRenderer(int i) {
        this.scratch = new Path();
        setShadowColor(i);
        this.cornerShadowPaint = new Paint(4);
        this.cornerShadowPaint.setStyle(Style.FILL);
        this.shadowPaint = new Paint();
        this.shadowPaint.setColor(this.shadowStartColor);
        this.edgeShadowPaint = new Paint(this.cornerShadowPaint);
    }

    public void setShadowColor(int i) {
        this.shadowStartColor = C0977a.m3660b(i, 68);
        this.shadowMiddleColor = C0977a.m3660b(i, 20);
        this.shadowEndColor = C0977a.m3660b(i, 0);
    }

    public void drawEdgeShadow(Canvas canvas, Matrix matrix, RectF rectF, int i) {
        rectF.bottom += (float) i;
        rectF.offset(BitmapDescriptorFactory.HUE_RED, (float) (-i));
        edgeColors[0] = this.shadowEndColor;
        edgeColors[1] = this.shadowMiddleColor;
        edgeColors[2] = this.shadowStartColor;
        Paint paint = this.edgeShadowPaint;
        LinearGradient linearGradient = new LinearGradient(rectF.left, rectF.top, rectF.left, rectF.bottom, edgeColors, edgePositions, TileMode.CLAMP);
        paint.setShader(linearGradient);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.edgeShadowPaint);
        canvas.restore();
    }

    public void drawCornerShadow(Canvas canvas, Matrix matrix, RectF rectF, int i, float f, float f2) {
        RectF rectF2 = rectF;
        int i2 = i;
        float f3 = f2;
        boolean z = f3 < BitmapDescriptorFactory.HUE_RED;
        Path path = this.scratch;
        if (z) {
            cornerColors[0] = 0;
            cornerColors[1] = this.shadowEndColor;
            cornerColors[2] = this.shadowMiddleColor;
            cornerColors[3] = this.shadowStartColor;
            float f4 = f;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF2, f, f3);
            path.close();
            float f5 = (float) (-i2);
            rectF2.inset(f5, f5);
            cornerColors[0] = 0;
            cornerColors[1] = this.shadowStartColor;
            cornerColors[2] = this.shadowMiddleColor;
            cornerColors[3] = this.shadowEndColor;
        }
        float width = 1.0f - (((float) i2) / (rectF.width() / 2.0f));
        float f6 = ((1.0f - width) / 2.0f) + width;
        cornerPositions[1] = width;
        cornerPositions[2] = f6;
        Paint paint = this.cornerShadowPaint;
        RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, cornerColors, cornerPositions, TileMode.CLAMP);
        paint.setShader(radialGradient);
        canvas.save();
        canvas.concat(matrix);
        if (!z) {
            canvas.clipPath(path, Op.DIFFERENCE);
        } else {
            Canvas canvas2 = canvas;
        }
        canvas.drawArc(rectF, f, f2, true, this.cornerShadowPaint);
        canvas.restore();
    }

    public Paint getShadowPaint() {
        return this.shadowPaint;
    }
}
