package com.google.android.material.shape;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.internal.Experimental;

@Experimental("The shapes API is currently experimental and subject to change")
public class CutCornerTreatment extends CornerTreatment implements Cloneable {
    public CutCornerTreatment(float f) {
        super(f);
    }

    public void getCornerPath(float f, float f2, ShapePath shapePath) {
        shapePath.reset(BitmapDescriptorFactory.HUE_RED, this.cornerSize * f2, 180.0f, 180.0f - f);
        double d = (double) f2;
        shapePath.lineTo((float) (Math.sin(Math.toRadians((double) f)) * ((double) this.cornerSize) * d), (float) (Math.sin(Math.toRadians((double) (90.0f - f))) * ((double) this.cornerSize) * d));
    }
}
