package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.transition.i */
/* compiled from: PropertyValuesHolderUtils */
class C1403i {
    /* renamed from: a */
    static PropertyValuesHolder m5662a(Property<?, PointF> property, Path path) {
        if (VERSION.SDK_INT >= 21) {
            return PropertyValuesHolder.ofObject(property, null, path);
        }
        return PropertyValuesHolder.ofFloat(new C1402h(property, path), new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
    }
}
