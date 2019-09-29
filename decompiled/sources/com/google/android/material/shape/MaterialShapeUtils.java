package com.google.android.material.shape;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class MaterialShapeUtils {
    static CornerTreatment createCornerTreatment(int i, int i2) {
        switch (i) {
            case 0:
                return new RoundedCornerTreatment((float) i2);
            case 1:
                return new CutCornerTreatment((float) i2);
            default:
                return createDefaultCornerTreatment();
        }
    }

    static CornerTreatment createDefaultCornerTreatment() {
        return new RoundedCornerTreatment(BitmapDescriptorFactory.HUE_RED);
    }

    static EdgeTreatment createDefaultEdgeTreatment() {
        return new EdgeTreatment();
    }
}
