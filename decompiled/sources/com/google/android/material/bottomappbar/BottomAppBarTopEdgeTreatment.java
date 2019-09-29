package com.google.android.material.bottomappbar;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private float cradleVerticalOffset;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f, float f2, float f3) {
        this.fabMargin = f;
        this.roundedCornerRadius = f2;
        this.cradleVerticalOffset = f3;
        if (f3 >= BitmapDescriptorFactory.HUE_RED) {
            this.horizontalOffset = BitmapDescriptorFactory.HUE_RED;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        float f4 = f;
        ShapePath shapePath2 = shapePath;
        if (this.fabDiameter == BitmapDescriptorFactory.HUE_RED) {
            shapePath2.lineTo(f4, BitmapDescriptorFactory.HUE_RED);
            return;
        }
        float f5 = ((this.fabMargin * 2.0f) + this.fabDiameter) / 2.0f;
        float f6 = f3 * this.roundedCornerRadius;
        float f7 = f2 + this.horizontalOffset;
        float f8 = (this.cradleVerticalOffset * f3) + ((1.0f - f3) * f5);
        if (f8 / f5 >= 1.0f) {
            shapePath2.lineTo(f4, BitmapDescriptorFactory.HUE_RED);
            return;
        }
        float f9 = f5 + f6;
        float f10 = f8 + f6;
        float sqrt = (float) Math.sqrt((double) ((f9 * f9) - (f10 * f10)));
        float f11 = f7 - sqrt;
        float f12 = f7 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f10)));
        float f13 = 90.0f - degrees;
        shapePath2.lineTo(f11, BitmapDescriptorFactory.HUE_RED);
        float f14 = f6 * 2.0f;
        float f15 = degrees;
        shapePath.addArc(f11 - f6, BitmapDescriptorFactory.HUE_RED, f11 + f6, f14, 270.0f, degrees);
        shapePath.addArc(f7 - f5, (-f5) - f8, f7 + f5, f5 - f8, 180.0f - f13, (f13 * 2.0f) - 180.0f);
        shapePath.addArc(f12 - f6, BitmapDescriptorFactory.HUE_RED, f12 + f6, f14, 270.0f - f15, f15);
        shapePath2.lineTo(f4, BitmapDescriptorFactory.HUE_RED);
    }

    public float getFabDiameter() {
        return this.fabDiameter;
    }

    public void setFabDiameter(float f) {
        this.fabDiameter = f;
    }

    /* access modifiers changed from: 0000 */
    public void setHorizontalOffset(float f) {
        this.horizontalOffset = f;
    }

    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    /* access modifiers changed from: 0000 */
    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    /* access modifiers changed from: 0000 */
    public void setCradleVerticalOffset(float f) {
        this.cradleVerticalOffset = f;
    }

    /* access modifiers changed from: 0000 */
    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    /* access modifiers changed from: 0000 */
    public void setFabCradleMargin(float f) {
        this.fabMargin = f;
    }

    /* access modifiers changed from: 0000 */
    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    /* access modifiers changed from: 0000 */
    public void setFabCradleRoundedCornerRadius(float f) {
        this.roundedCornerRadius = f;
    }
}
