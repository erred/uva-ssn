package com.google.android.material.shape;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.internal.Experimental;

@Experimental("The shapes API is currently experimental and subject to change")
public class RoundedCornerTreatment extends CornerTreatment implements Cloneable {
    public RoundedCornerTreatment(float f) {
        super(f);
    }

    public void getCornerPath(float f, float f2, ShapePath shapePath) {
        float f3 = this.cornerSize;
        shapePath.reset(BitmapDescriptorFactory.HUE_RED, f3 * f2, 180.0f, 180.0f - f);
        float f4 = f3 * 2.0f * f2;
        shapePath.addArc(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f4, f4, 180.0f, f);
    }
}
