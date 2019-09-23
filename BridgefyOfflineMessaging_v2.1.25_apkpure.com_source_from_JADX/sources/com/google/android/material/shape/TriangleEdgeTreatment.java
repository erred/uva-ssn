package com.google.android.material.shape;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.internal.Experimental;

@Experimental("The shapes API is currently experimental and subject to change")
public class TriangleEdgeTreatment extends EdgeTreatment implements Cloneable {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f, boolean z) {
        this.size = f;
        this.inside = z;
    }

    public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        shapePath.lineTo(f2 - (this.size * f3), BitmapDescriptorFactory.HUE_RED);
        shapePath.lineTo(f2, (this.inside ? this.size : -this.size) * f3);
        shapePath.lineTo(f2 + (this.size * f3), BitmapDescriptorFactory.HUE_RED);
        shapePath.lineTo(f, BitmapDescriptorFactory.HUE_RED);
    }
}
